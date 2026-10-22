package i84;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.z0;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f488632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f488633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f488634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f488635d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f488636e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f488637f = null;

    public static class a extends r<String> {
        public a() {
        }

        @Override // i84.r
        public final String a(Object[] r100) {
            Context r101 = (Context) r100[0];
            o0 r102 = (o0) r100[1];
            if (r101 == null) goto L9;
            if (r102 != null) goto L11;
            if (i84.f.a(r101) == false) goto L9;
        L11:
            return z0.a(String.valueOf(r102.f199728a)).e(r101, r102);
        L9:
            return null;
        }
    }

    public static class b extends r<String[]> {
        public b() {
        }

        @Override // i84.r
        public final String[] a(Object[] r100) {
            Context r101 = (Context) r100[0];
            o0 r102 = (o0) r100[1];
            if (r101 == null) goto L15;
            if (p.f() == true) goto L15;
            if (r102 == null) goto L9;
        L11:
            String[] r103 = z0.a(String.valueOf(r102.f199728a)).c(r102);
            if (r103 == null) goto L15;
            return r103;
        L9:
            if (i84.f.a(r101) == true) goto L11;
        L15:
            return new String[0];
        }
    }

    public static class c extends r<JSONArray> {
        public c() {
        }

        @Override // i84.r
        public final JSONArray a(Object[] r110) {
            Context r100 = (Context) r110[0];
            o0 r111 = (o0) r110[1];
            JSONArray r101 = new JSONArray();
            if (r111 == null) goto L6;
        L53:
        L41:
            th = move-exception;
            if ((th instanceof SecurityException) == false) goto L45;
            com.bytedance.bdinstall.t.b("读取imei没有权限");
            return r101;
        L45:
            th.printStackTrace();
            return r101;
        L10:
            if (Build.VERSION.SDK_INT >= 26) goto L54;
            h0 r112 = z0.a(String.valueOf(r111.f199728a));     // Catch: Throwable -> L41
            r101.put(q.a(r112.b(r100, 0), 0, "unknown"));     // Catch: Throwable -> L41
            r101.put(q.a(r112.b(r100, 1), 1, "unknown"));     // Catch: Throwable -> L41
            return r101;
        L54:
            r101.put(q.a(z0.a(String.valueOf(r111.f199728a)).g(0, r111), 0, "meid"));     // Catch: Exception -> L13 Throwable -> L41
        L51:
            r101.put(q.a(z0.a(String.valueOf(r111.f199728a)).g(1, r111), 1, "meid"));     // Catch: Exception -> L20 Throwable -> L41
        L49:
            r101.put(q.a(z0.a(String.valueOf(r111.f199728a)).d(0, r111), 0, "imei"));     // Catch: Exception -> L27 Throwable -> L41
        L47:
            r101.put(q.a(z0.a(String.valueOf(r111.f199728a)).d(1, r111), 1, "imei"));     // Catch: Exception -> L34 Throwable -> L41
        L60:
            return r101;
        L34:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L38;
            com.bytedance.bdinstall.t.b("读取imei没有权限");     // Catch: Throwable -> L41
            return r101;
        L38:
            e.printStackTrace();     // Catch: Throwable -> L41
            return r101;
        L27:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L31;
            com.bytedance.bdinstall.t.b("读取imei没有权限");     // Catch: Throwable -> L41
            goto L47
        L31:
            e.printStackTrace();     // Catch: Throwable -> L41
            goto L47
        L20:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L24;
            com.bytedance.bdinstall.t.b("读取imei没有权限");     // Catch: Throwable -> L41
            goto L49
        L24:
            e.printStackTrace();     // Catch: Throwable -> L41
            goto L49
        L13:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L17;
            com.bytedance.bdinstall.t.b("读取imei没有权限");     // Catch: Throwable -> L41
            goto L51
        L17:
            e.printStackTrace();     // Catch: Throwable -> L41
            goto L51
        L6:
            if (i84.f.a(r100) == true) goto L53;
            return new JSONArray();
        }
    }

    public static class d extends r<String> {
        public d() {
        }

        @Override // i84.r
        public final String a(Object[] r100) {
            Context r101 = (Context) r100[0];
            o0 r102 = (o0) r100[1];
            if (r101 != null) goto L6;
        L13:
            return null;
        L6:
            if (Build.VERSION.SDK_INT < 26) goto L15;
            if (r101.getApplicationInfo().targetSdkVersion < 26) goto L15;
            if (r102 != null) goto L15;
            if (i84.f.a(r101) == false) goto L13;
        L15:
            return z0.a(String.valueOf(r102.f199728a)).a(r101, r102);
        }
    }

    public static class e extends r<String> {
        public e() {
        }

        @Override // i84.r
        public final String a(Object[] r100) {
            p.a r101 = p.f488631a;
            int r102 = Build.VERSION.SDK_INT;
            if (r102 < 29) goto L5;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == false) goto L19;
            if (((Context) r100[0]).getApplicationInfo().targetSdkVersion < 29) goto L15;
            boolean r104 = true;
        L16:
            if (r104 == false) goto L19;
            return "";
        L15:
            r104 = false;
        L19:
            return z0.a((String) r100[1]).f((Context) r100[0], (o0) r100[2]);
        L5:
            if (r102 == 28) goto L7;
        L9:
            r103 = false;
            goto L11
        L7:
            if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
            goto L9
        }
    }

    public static class f extends r<JSONArray> {
        public f() {
        }

        @Override // i84.r
        public final JSONArray a(Object[] r100) {
            h0 r101 = z0.a((String) r100[1]);
            Context r102 = (Context) r100[0];
            return r101.h();
        }
    }

    public static class g extends r<String> {
        public g() {
        }

        @Override // i84.r
        public final String a(Object[] r100) {
            o0 r101 = (o0) r100[0];
            if (r101 == null) goto L15;
            f84.c r102 = r101.M;
            if (TextUtils.isEmpty(i84.a.a(r102.f475869a.getContext(), r102.f475869a).getString("device_id", "")) == false) goto L7;
            com.bytedance.bdinstall.t.a("sdk not start. media id return null. ");
            return "";
        L7:
            f84.b r103 = new f84.b();
            Future r104 = com.bytedance.bdinstall.v.c(com.bytedance.bdinstall.v.a(com.bytedance.bdinstall.v.f199798b)).submit(r103);
            return (String) r104.get(100, TimeUnit.MILLISECONDS);
        L10:
            e = move-exception;
            com.bytedance.bdinstall.t.c("media id get error", e);
            return "";
        L15:
            return "";
        }
    }

    static {
        f488632a = new a();
        f488633b = new b();
        f488634c = new c();
        f488635d = new d();
        f488636e = new e();
        f488637f = new f();
        new g();
    }

    public static String b(Context r100, o0 r101) {
        return f488632a.b(new Object[]{r100, r101});
    }

    public static String c(Context r100, o0 r101) {
        if (r101.f199727J == true) goto L5;
        return null;
    L5:
        return f488635d.b(new Object[]{r100, r101});
    }

    public static String[] d(Context r100, o0 r101) {
        return f488633b.b(new Object[]{r100, r101});
    }

    public static JSONObject a(String r100, int r101, String r102) throws JSONException {
        JSONObject r103 = new JSONObject();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r103.put("id", r100);
        r103.put("slot_index", r101);
        r103.put("type", r102);
    L5:
        return r103;
    }
}
