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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final ConcurrentHashMap<String, C0225a> a;
    public StringBuilder b;
    public NetService c;

    /* JADX INFO: renamed from: f35.a$a, reason: collision with other inner class name */
    public static class C0225a {
        public int a;
        public long b;

        public C0225a() {
        }
    }

    public static class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }

    public void bindService(NetService r2) {
        if (this.c != null) goto L7;
        if (r2 == null) goto L8;
        this.c = r2;
        tt5.a.h("PermissionCenter", "bindService... net = false");
        return;
    L8:
        return;
    }

    public final C0225a a(String r17, int r18, long r19, boolean r21) {
        tt5.a.h("PermissionCenter", "getPermissionDataSync... for token : " + du5.b.g(r17));
        C0225a r5 = null;
        if (TextUtils.isEmpty(r17) == true) goto L40;
        if (r18 < 0) goto L40;
        StringBuilder r0 = new StringBuilder();
        this.b = r0;
        r0.append(r17);
        r0.append("-");
        r0.append(r18);
        String r1 = this.b.toString();
        if (this.a.containsKey(r1) == false) goto L16;
        C0225a r2 = this.a.get(r1);
        r2.getClass();
        long r10 = System.currentTimeMillis();
        long r12 = 1000 * r19;
        if (r19 > 0) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == true) goto L16;
        r5 = r2;
        goto L16
    L11:
        if (Math.abs(r10 - r2.b) <= r12) goto L13;
        r7 = true;
    L16:
        if (r5 == null) goto L19;
        tt5.a.b("PermissionCenter", "getPermissionDataSync... got valid data for token : " + r17 + "retCode = " + r5.a + "fetchTime:" + r5.b);
        return r5;
    L19:
        if (lbb.a.a(r17) == false) goto L22;
        tt5.a.h("PermissionCenter", "getPermissionDataSync... this token is created in offline env, got to hav permission");
        long r4 = System.currentTimeMillis();
        C0225a r3 = new C0225a();
        r3.b = r4;
        r3.a = 0;
        StringBuilder r6 = new StringBuilder();
        this.b = r6;
        r6.append(r17);
        r6.append("-");
        r6.append(r18);
        this.a.put(this.b.toString(), r3);
    L45:
        return r3;
    L22:
        if (r21 == false) goto L39;
        tt5.a.b("PermissionCenter", "getPermissionDataSync... need to req permission : " + r17);
        if (Looper.getMainLooper() == Looper.myLooper()) goto L38;
        tt5.a.h("PermissionCenter", "doCheckPermission... for :" + du5.b.g(r17));
        String r8 = "https://" + p.u + String.format(Locale.US, "/space/api/suite/permission/user.v3/?token=%s&type=%d", new Object[]{r17, Integer.valueOf(r18)});
        Request.Builder r9 = new Request.Builder().url(r8).get();
        tt5.a.b("PermissionCenter", "doCheckPermission... begin req : " + r8);
        Response r11 = this.c.g6(r9.build());
        if (r11 != null) goto L28;
    L34:
        tt5.a.d("PermissionCenter", "doCheckPermission... check failed");
    L35:
        int r13 = -1;
    L36:
        long r14 = System.currentTimeMillis();
        r3 = new C0225a();
        r3.b = r14;
        r3.a = r13;
        StringBuilder r16 = new StringBuilder();
        this.b = r16;
        r16.append(r17);
        r16.append("-");
        r16.append(r18);
        this.a.put(this.b.toString(), r3);
        goto L45
    L28:
        if (r11.isSuccessful() == false) goto L34;
        r13 = new JSONObject(r11.body().string()).optInt("code");     // Catch: Exception -> L32
        tt5.a.h("PermissionCenter", "doCheckPermission... checking result code: " + r13 + "for obj-token : " + du5.b.g(r17));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        tt5.a.e("PermissionCenter", "doCheckPermission... err happens when try to parse result : ", e, false);
        goto L35
    L38:
        throw new RuntimeException("you can not choose reqWhenNoResult sync while you are int main thread !");
    L39:
        tt5.a.b("PermissionCenter", "getPermissionDataSync... no cache result, and no need to req for token : " + r17);
        long r20 = System.currentTimeMillis();
        C0225a r22 = new C0225a();
        r22.b = r20;
        r22.a = 0;
        return r22;
    L40:
        tt5.a.d("PermissionCenter", "getPermissionDataSync... error token or type");
        return null;
    }
}
