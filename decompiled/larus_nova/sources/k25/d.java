package k25;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    public static List<m0> b(SupportSQLiteDatabase r210) {
        Cursor r100 = r210.query("SELECT * FROM ResourceData");
        int r101 = r100.getColumnIndexOrThrow("id");     // Catch: Throwable -> L22
        int r102 = r100.getColumnIndexOrThrow(ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L22
        int r103 = r100.getColumnIndexOrThrow(ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L22
        int r104 = r100.getColumnIndexOrThrow(ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L22
        int r105 = r100.getColumnIndexOrThrow("update_time");     // Catch: Throwable -> L22
        int r106 = r100.getColumnIndexOrThrow(ResourceData.ACCESS_TIME);     // Catch: Throwable -> L22
        int r107 = r100.getColumnIndexOrThrow("isNeedSync");     // Catch: Throwable -> L22
        int r108 = r100.getColumnIndexOrThrow("config");     // Catch: Throwable -> L22
        int r109 = r100.getColumnIndexOrThrow("type");     // Catch: Throwable -> L22
        int r110 = r100.getColumnIndexOrThrow("token");     // Catch: Throwable -> L22
        int r111 = r100.getColumnIndexOrThrow("obj_token");     // Catch: Throwable -> L22
        int r112 = r100.getColumnIndexOrThrow("userToken");     // Catch: Throwable -> L22
        int r113 = r100.getColumnIndexOrThrow("tenantID");     // Catch: Throwable -> L22
        int r211 = r100.getColumnIndexOrThrow("url");     // Catch: Throwable -> L22
        ArrayList r114 = new ArrayList(r100.getCount());     // Catch: Throwable -> L22
    L4:
        if (r100.moveToNext() == false) goto L20;
        m0 r115 = new m0();     // Catch: Throwable -> L22
        ArrayList r116 = r114;
        r115.f501540a = r100.getInt(r101);     // Catch: Throwable -> L22
        r115.f501541b = r100.getString(r102);     // Catch: Throwable -> L22
        r115.f501542c = r100.getString(r103);     // Catch: Throwable -> L22
        r115.f501543d = r100.getString(r104);     // Catch: Throwable -> L22
        Long r117 = null;
        if (r100.isNull(r105) == false) goto L9;
        Long r118 = null;
    L10:
        r115.f501544e = r118;     // Catch: Throwable -> L22
        if (r100.isNull(r106) == true) goto L14;
        r117 = Long.valueOf(r100.getLong(r106));     // Catch: Throwable -> L22
    L14:
        r115.f501545f = r117;     // Catch: Throwable -> L22
        if (r100.getInt(r107) == 0) goto L17;
        boolean r119 = true;
    L18:
        r115.f501546g = r119;     // Catch: Throwable -> L22
        r115.f501547h = r100.getString(r108);     // Catch: Throwable -> L22
        r115.f501548i = r100.getString(r109);     // Catch: Throwable -> L22
        r115.f501549j = r100.getString(r110);     // Catch: Throwable -> L22
        r115.f501550k = r100.getString(r111);     // Catch: Throwable -> L22
        r115.f501551l = r100.getString(r112);     // Catch: Throwable -> L22
        r115.f501552m = r100.getString(r113);     // Catch: Throwable -> L22
        int r120 = r211;
        int r212 = r101;
        r115.f501553n = r100.getString(r120);     // Catch: Throwable -> L22
        r116.add(r115);     // Catch: Throwable -> L22
        r101 = r212;
        r211 = r120;
        r114 = r116;
        goto L4
    L17:
        r119 = false;
        goto L18
    L9:
        r118 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L22
        goto L10
    L20:
        ArrayList r121 = r114;
        r100.close();
        return r121;
    L22:
        th = move-exception;
        r100.close();
        throw th;
    }

    public static void a(SupportSQLiteDatabase r100, List<m0> r101) {
        ArrayList r102 = (ArrayList) r101;
        if (r102.size() == 0) goto L12;
        r100.beginTransaction();
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r100.delete(ResourceData.TABLE_NAME, "id=?", new String[]{String.valueOf(((m0) r103.next()).f501540a)});
        goto L7
    L9:
        r100.setTransactionSuccessful();
        r100.endTransaction();
        tt5.a.h("OfflineDataDBUtil", "OfflineDataDBUtil  deleteResourceDataList delete: " + r102.size());
        return;
    }

    public static void c(SupportSQLiteDatabase r100, List<m0> r101) {
        ArrayList r102 = (ArrayList) r101;
        if (r102.size() == 0) goto L12;
        r100.beginTransaction();
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        m0 r104 = (m0) r103.next();
        ContentValues r105 = new ContentValues();
        r105.put(ResourceData.KEY_RESOURCE_VALUE, r104.f501542c);
        r100.update(ResourceData.TABLE_NAME, 5, r105, "id=?", new String[]{String.valueOf(r104.f501540a)});
        goto L7
    L9:
        r100.setTransactionSuccessful();
        r100.endTransaction();
        tt5.a.h("OfflineDataDBUtil", "OfflineDataDBUtil  updateResourceDataList update: " + r102.size());
        return;
    }
}
