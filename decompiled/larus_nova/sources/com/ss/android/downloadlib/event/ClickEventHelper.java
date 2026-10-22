package com.ss.android.downloadlib.event;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ClickEventHelper {
    private static final long LAST_TIME = 1209600000;
    private static volatile ClickEventHelper sInstance;
    private SQLiteDatabase mDb;

    public static ClickEventHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ClickEventHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ClickEventHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClickEventHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ClickEventHelper() {
        this.mDb = new ClickEventDBHelper(GlobalInfo.getContext()).getWritableDatabase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        TTDownloaderMonitor.inst().monitorException(th, "ClickEventHelper");
    }

    public boolean sendClicEventkWithIdAndReqId() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.KEY_CLICK_EVENT_SWITCH, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean sendClickEventWithClickButton() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.KEY_CLICK_EVENT_SWITCH, 0) != 2) goto L6;
        return true;
    L6:
        return false;
    }

    private void deleteClickRecord(long r100, String r101) {
        SQLiteDatabase r102 = this.mDb;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isOpen() == true) goto L8;
        return;
    L8:
        if (r100 > 0) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L25;
        String r103 = new JSONObject(r101).optString("req_id");     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r103) == false) goto L15;
        return;
    L15:
        this.mDb.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - LAST_TIME), String.valueOf(r100), r103});     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public boolean hasClickRecord(long r110, String r111) {
        SQLiteDatabase r100 = this.mDb;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L31:
        return false;
    L5:
        if (r100.isOpen() == false) goto L31;
        if (r110 <= 0) goto L31;
        if (TextUtils.isEmpty(r111) == true) goto L31;
        Cursor r102 = null;
        String r112 = new JSONObject(r111).optString("req_id");     // Catch: Throwable -> L21 Exception -> L23
        if (TextUtils.isEmpty(r112) == false) goto L16;
        return false;
    L16:
        r102 = this.mDb.query("click_event", ClickEventDBHelper.EVENT_COLS, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - LAST_TIME), String.valueOf(r110), r112}, null, null, null, null);     // Catch: Throwable -> L21 Exception -> L23
        if (r102.getCount() <= 0) goto L19;
        r101 = true;
    L19:
        r102.close();
        return r101;
    L21:
        th = move-exception;
        if (r102 == null) goto L30;
        r102.close();
    L30:
        throw th;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r102 == null) goto L27;
        r102.close();
    L27:
        return false;
    }

    public void recordClick(long r100, String r101) {
        SQLiteDatabase r102 = this.mDb;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isOpen() == true) goto L8;
        return;
    L8:
        if (r100 > 0) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        String r103 = new JSONObject(r101).optString("req_id");     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r103) == false) goto L15;
        return;
    L15:
        ContentValues r104 = new ContentValues();     // Catch: Exception -> L17
        r104.put("ad_id", Long.valueOf(r100));     // Catch: Exception -> L17
        r104.put("req_id", r103);     // Catch: Exception -> L17
        r104.put("time", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L17
        this.mDb.insert("click_event", null, r104);     // Catch: Exception -> L17
    L19:
        deleteClickRecord(r100, r101);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
