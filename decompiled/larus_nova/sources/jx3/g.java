package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a {
    public boolean A;
    public String B;
    public String C;
    public boolean D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f500801y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f500802z;

    @Override // jx3.a
    public final String h() {
        return EventVerify.TYPE_LAUNCH;
    }

    @Override // jx3.a
    public final String j() {
        return EventVerify.TYPE_LAUNCH;
    }

    @Override // jx3.a
    public final String g() {
        if (this.A == false) goto L5;
        return "bg";
    L5:
        return AppConstants.APP_FG;
    }

    @Override // jx3.a
    public final JSONObject r() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("local_time_ms", this.f500758b);
        r100.put("tea_event_index", this.f500759c);
        r100.put("session_id", this.f500760d);
        c(r100);
        if (TextUtils.isEmpty(this.f500763g) == true) goto L6;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f500763g);
    L6:
        if (this.A == false) goto L8;
        r100.put(LocationMonitorConst.IS_BACKGROUND, true);
    L8:
        r100.put(SheetInputData.InputData.DateType.DATETIME, this.f500770n);
        if (TextUtils.isEmpty(this.f500764h) == true) goto L12;
        r100.put("ab_sdk_version", this.f500764h);
    L12:
        if (TextUtils.isEmpty(this.B) == true) goto L14;
        r100.put("uuid_changed", true);
        r100.put("original_session_id", this.B);
    L14:
        long r101 = this.f500773q;
        if (r101 <= 0) goto L17;
        r100.put("event_id", r101);
    L17:
        long r102 = this.f500774r;
        if (r102 <= 0) goto L20;
        r100.put("monitor_id", String.valueOf(r102));
    L20:
        int r103 = this.f500775s;
        if (r103 <= 0) goto L24;
        r100.put("event_stained", r103);
    L24:
        if (TextUtils.isEmpty(this.C) == false) goto L37;
    L36:
        return r100;
    L37:
        JSONObject r104 = new JSONObject(this.C);     // Catch: Throwable -> L34
        Iterator<String> r105 = r104.keys();     // Catch: Throwable -> L34
    L27:
        if (r105.hasNext() == false) goto L36;
        String r106 = r105.next();     // Catch: Throwable -> L34
        if (r100.has(r106) == false) goto L31;
        i().f(4, this.f500776t, "Add params to launch conflict: {} - {}", new Object[]{r106, r104.opt(r106)});     // Catch: Throwable -> L34
        goto L27
    L31:
        r100.put(r106, r104.opt(r106));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i().r(4, this.f500776t, "Add flat params: {} to launch error", th, new Object[]{this.C});
        goto L36
    }

    public g() {
        this.D = true;
    }

    @Override // jx3.a
    public final List<String> e() {
        List<String> r100 = super.e();
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        r101.addAll(Arrays.asList(new String[]{"ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", LocationMonitorConst.IS_BACKGROUND, "integer", "flat_params", "varchar", "sendable", "integer"}));
        return r101;
    }

    @Override // jx3.a
    public final void k(Cursor r100) {
        super.k(r100);
        this.f500802z = r100.getString(18);
        this.f500801y = r100.getLong(19);
        this.B = r100.getString(20);
        boolean r101 = false;
        if (r100.getInt(21) != 1) goto L5;
        boolean r102 = true;
    L6:
        this.A = r102;
        this.C = r100.getString(22);
        if (r100.getInt(23) != 1) goto L9;
        r101 = true;
    L9:
        this.D = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // jx3.a
    public final a l(JSONObject r100) {
        i().p(4, this.f500776t, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // jx3.a
    public final void p(ContentValues r100) {
        super.p(r100);
        r100.put("ver_name", this.f500802z);
        r100.put("ver_code", Long.valueOf(this.f500801y));
        r100.put("last_session", this.B);
        r100.put(LocationMonitorConst.IS_BACKGROUND, Integer.valueOf(this.A ? 1 : 0));
        r100.put("flat_params", this.C);
        r100.put("sendable", Integer.valueOf(this.D ? 1 : 0));
    }

    @Override // jx3.a
    public final void q(JSONObject r100) {
        i().p(4, this.f500776t, "write ipc not implemented", new Object[0]);
    }
}
