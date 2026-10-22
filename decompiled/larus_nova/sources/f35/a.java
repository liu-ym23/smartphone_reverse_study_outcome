package f35;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, C5854a> f475384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f475385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NetService f475386c;

    /* JADX INFO: renamed from: f35.a$a, reason: collision with other inner class name */
    public static class C5854a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f475387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f475388b;

        public C5854a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f475389a = null;

        static {
            f475389a = new a();
        }
    }

    public a() {
        this.f475384a = new ConcurrentHashMap();
    }

    public void bindService(NetService r100) {
        if (this.f475386c != null) goto L7;
        if (r100 == null) goto L8;
        this.f475386c = r100;
        tt5.a.h("PermissionCenter", "bindService... net = false");
        return;
    L8:
        return;
    }

    public final C5854a a(String r110, int r111, long r112, boolean r210) {
        tt5.a.h("PermissionCenter", "getPermissionDataSync... for token : " + du5.b.g(r110));
        C5854a r100 = null;
        if (TextUtils.isEmpty(r110) == true) goto L40;
        if (r111 < 0) goto L40;
        StringBuilder r101 = new StringBuilder();
        this.f475385b = r101;
        r101.append(r110);
        r101.append("-");
        r101.append(r111);
        String r102 = this.f475385b.toString();
        if (this.f475384a.containsKey(r102) == false) goto L16;
        C5854a r103 = this.f475384a.get(r102);
        r103.getClass();
        long r113 = System.currentTimeMillis();
        long r114 = 1000 * r112;
        if (r112 > 0) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L16;
        r100 = r103;
        goto L16
    L11:
        if (Math.abs(r113 - r103.f475388b) <= r114) goto L13;
        r104 = true;
    L16:
        if (r100 == null) goto L19;
        tt5.a.b("PermissionCenter", "getPermissionDataSync... got valid data for token : " + r110 + "retCode = " + r100.f475387a + "fetchTime:" + r100.f475388b);
        return r100;
    L19:
        if (lbb.a.a(r110) == false) goto L22;
        tt5.a.h("PermissionCenter", "getPermissionDataSync... this token is created in offline env, got to hav permission");
        long r105 = System.currentTimeMillis();
        C5854a r106 = new C5854a();
        r106.f475388b = r105;
        r106.f475387a = 0;
        StringBuilder r107 = new StringBuilder();
        this.f475385b = r107;
        r107.append(r110);
        r107.append("-");
        r107.append(r111);
        this.f475384a.put(this.f475385b.toString(), r106);
    L45:
        return r106;
    L22:
        if (r210 == false) goto L39;
        tt5.a.b("PermissionCenter", "getPermissionDataSync... need to req permission : " + r110);
        if (Looper.getMainLooper() == Looper.myLooper()) goto L38;
        tt5.a.h("PermissionCenter", "doCheckPermission... for :" + du5.b.g(r110));
        String r108 = "https://" + p.f540584u + String.format(Locale.US, "/space/api/suite/permission/user.v3/?token=%s&type=%d", new Object[]{r110, Integer.valueOf(r111)});
        Request.Builder r109 = new Request.Builder().url(r108).get();
        tt5.a.b("PermissionCenter", "doCheckPermission... begin req : " + r108);
        Response r115 = this.f475386c.g6(r109.build());
        if (r115 != null) goto L28;
    L34:
        tt5.a.d("PermissionCenter", "doCheckPermission... check failed");
    L35:
        int r116 = -1;
    L36:
        long r117 = System.currentTimeMillis();
        r106 = new C5854a();
        r106.f475388b = r117;
        r106.f475387a = r116;
        StringBuilder r118 = new StringBuilder();
        this.f475385b = r118;
        r118.append(r110);
        r118.append("-");
        r118.append(r111);
        this.f475384a.put(this.f475385b.toString(), r106);
        goto L45
    L28:
        if (r115.isSuccessful() == false) goto L34;
        r116 = new JSONObject(r115.body().string()).optInt("code");     // Catch: Exception -> L32
        tt5.a.h("PermissionCenter", "doCheckPermission... checking result code: " + r116 + "for obj-token : " + du5.b.g(r110));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        tt5.a.e("PermissionCenter", "doCheckPermission... err happens when try to parse result : ", e, false);
        goto L35
    L38:
        throw new RuntimeException("you can not choose reqWhenNoResult sync while you are int main thread !");
    L39:
        tt5.a.b("PermissionCenter", "getPermissionDataSync... no cache result, and no need to req for token : " + r110);
        long r119 = System.currentTimeMillis();
        C5854a r120 = new C5854a();
        r120.f475388b = r119;
        r120.f475387a = 0;
        return r120;
    L40:
        tt5.a.d("PermissionCenter", "getPermissionDataSync... error token or type");
        return null;
    }
}
