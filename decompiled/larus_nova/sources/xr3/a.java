package xr3;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import f06.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f564848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f564850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Integer> f564851d;

    /* JADX INFO: renamed from: xr3.a$a, reason: collision with other inner class name */
    public interface InterfaceC8265a<T> {
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f564852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Integer> f564853b;

        public final int a(String r100) {
            Integer r101 = this.f564853b.get(r100);
            if (r101 != null) goto L9;
            r101 = Integer.valueOf(this.f564852a.getColumnIndex(r100));     // Catch: Throwable -> L6
        L7:
            this.f564853b.put(r100, r101);
        L6:
            r101 = -1;
        L9:
            return r101.intValue();
        }

        public final long b(String r100) {
            return this.f564852a.getLong(a(r100));
        L4:
            return -1;
        }

        public final String c(String r100) {
            return this.f564852a.getString(a(r100));
        L4:
            return "";
        }

        public b(Cursor r100, HashMap r101) {
            this.f564852a = r100;
            this.f564853b = r101;
        }
    }

    public abstract void e();

    public abstract void f();

    public final Uri g() {
        if (this.f564850c != null) goto L6;
        f();
        this.f564850c = UriProtector.parse("content://" + this.f564849b + "/apm_monitor_t1.db/t_battery");
    L6:
        return this.f564850c;
    }

    public a() {
        this.f564851d = new HashMap();
        Context r100 = d.getContext();
        this.f564848a = r100;
        this.f564849b = r100.getPackageName() + ".apm";
    }

    public synchronized <I extends T> long insert(ContentValues r100) {
        monitor-enter(this);
        if (r100 != null) goto L22;
        monitor-exit(this);
        return -1;
    L22:
        Uri r101 = b(d.getContext().getContentResolver(), g(), r100);     // Catch: Throwable -> L17 Exception -> L20
        if (r101 != null) goto L25;
        monitor-exit(this);
        return -1;
    L25:
        long r102 = CastLongProtector.parseLong(r101.getLastPathSegment());     // Catch: Exception -> L14 Throwable -> L17
        monitor-exit(this);
        return r102;
    L15:
        return 1;
    L17:
        th = move-exception;
        throw th;
    L21:
        return -1;
    }

    public int delete(String r100, String[] r101) {
        return a(this.f564848a.getContentResolver(), g(), r100, r101);
    L4:
        return -1;
    }

    public static Uri b(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public int update(ContentValues r100, String r101, String[] r102) {
        if (r100 != null) goto L8;
        return -1;
    L8:
        return d(d.getContext().getContentResolver(), g(), r100, r101, r102);
    L7:
        return -1;
    }

    public static int a(ContentResolver r110, Uri r111, String r210, String[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public List<T> query(String r100, String[] r101, String r110, InterfaceC8265a<T> r111) {
        ContentResolver r102 = this.f564848a.getContentResolver();     // Catch: Throwable -> L34
        Uri r103 = g();     // Catch: Throwable -> L34
        e();     // Catch: Throwable -> L34
        Cursor r104 = c(r102, r103, yr3.a.f568907f, r100, r101, r110);     // Catch: Throwable -> L34
        if (r104 != null) goto L53;
    L28:
        List<T> r105 = Collections.emptyList();     // Catch: Throwable -> L43
        if (r104 != null) goto L45;
    L33:
        return r105;
    L45:
        if (r104.isClosed() == true) goto L33;
        r104.close();     // Catch: Exception -> L42
        goto L33
    L53:
        if (r104.getCount() <= 0) goto L28;
        if (TextUtils.isEmpty(r110) == true) goto L17;
        int r106 = r110.indexOf("LIMIT");     // Catch: Throwable -> L43
        if (r106 <= 0) goto L17;
        int r107 = r110.indexOf("OFF");     // Catch: Throwable -> L43
        if (r107 <= 0) goto L16;
        int r108 = Integer.valueOf(r110.substring(r106 + 5, r107).trim()).intValue();     // Catch: Throwable -> L43
    L18:
        LinkedList r112 = new LinkedList();     // Catch: Throwable -> L43
        int r109 = 0;
    L20:
        if (r104.moveToNext() == false) goto L47;
        if (r109 >= r108) goto L47;
        b r113 = new b(r104, this.f564851d);     // Catch: Throwable -> L43
        r112.add(((yr3.a) r111).h(r113));     // Catch: Throwable -> L43
        r109 = r109 + 1;
    L47:
        if (r104.isClosed() == true) goto L27;
        r104.close();     // Catch: Exception -> L41
    L27:
        return r112;
    L16:
        r108 = Integer.valueOf(r110.substring(r106 + 5).trim()).intValue();     // Catch: Throwable -> L43
    L17:
        r108 = Integer.MAX_VALUE;
    L35:
        if (r104 == null) goto L40;
        if (r104.isClosed() == true) goto L40;
        r104.close();     // Catch: Exception -> L44
    L40:
        return Collections.emptyList();
    L34:
        r104 = null;
        goto L35
    }

    public static int d(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211, r212};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240018, "android/content/ContentResolver", "update", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.update(r111, r210, r211, r212);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
