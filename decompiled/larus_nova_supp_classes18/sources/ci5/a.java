package ci5;

import android.content.Context;
import ax4.f;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.secret.c0;
import com.bytedance.ee.bear.middleground.permission.secret.n;
import com.bytedance.ee.bear.middleground.permission.secret.o;
import com.bytedance.ee.bear.middleground.permission.secret.p;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.bytedance.ee.bear.middleground.permission.secret.d {

    /* JADX INFO: renamed from: ci5.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    public static final class b<T extends Result> implements NetService.c {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Result<Boolean> parse(String r2) {
            Result<Boolean> r3 = new Result();
            r3.setData(Boolean.TRUE);
            return r3;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Result r3 = (Result) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (Boolean) r3.data;
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((SimpleRequestResult) r2, "it");
            return Boolean.TRUE;
        }
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.secret.d
    public final Flowable<Boolean> b(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        NetService.f r0 = new NetService.f("/space/api/sec_label/update/");
        ((NetService.e) r0).c = 1;
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r5.a);     // Catch: Exception -> L5
        r1.put(ResourceData.KEY_TYPE, String.valueOf(r5.getType()));     // Catch: Exception -> L5
        r1.put("sec_label_id", r5.c);     // Catch: Exception -> L5
        r1.put("change_reason", r5.d);     // Catch: Exception -> L5
        r0.d(r1);     // Catch: Exception -> L5
    L8:
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r0).map(d.a);
    L5:
        e = move-exception;
        tt5.a.d("SecretBannerImpl", e.toString());
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.permission.secret.d
    public final o a(n r6, Context r7) {
        Intrinsics.checkNotNullParameter(r6, "bean");
        Intrinsics.checkNotNullParameter(r7, "context");
        o r0 = new o(0);
        if (r6.h == true) goto L10;
        if (r6.c == false) goto L7;
    L8:
        return r0;
    L7:
        if (r6.b == true) goto L8;
    L10:
        if (r6.b == false) goto L14;
        f(r0, r7, 2131889837, r6.g, false);
        return r0;
    L14:
        if (r6.d == false) goto L27;
        if (r6.a == false) goto L24;
        if (r6.e == false) goto L21;
        e(r0, r7, r6.c, r6.g, true);
    L33:
        return r0;
    L21:
        if (r6.c == false) goto L33;
        r0.d = true;
        r0.b = true;
        r0.a(xo5.a.c(r7, 2131889840, "securityLevel", r6.g));
        goto L33
    L24:
        if (r6.c == false) goto L33;
        f(r0, r7, 2131889838, r6.g, true);
        goto L33
    L27:
        if (r6.f == false) goto L30;
        e(r0, r7, r6.c, r6.g, false);
        goto L33
    L30:
        if (r6.c == false) goto L32;
        f(r0, r7, 2131889838, r6.g, true);
        goto L33
    L32:
        r0.a(r7.getString(2131889950));
        r0.d = r6.i;
        goto L33
    }

    @Override // com.bytedance.ee.bear.middleground.permission.secret.d
    public final Flowable<VisibleSecretResult> c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        return p.a(r2, r3);
    }

    public static void e(o r1, Context r2, boolean r3, String r4, boolean r5) {
        r1.d = true;
        if (r3 == false) goto L5;
        r1.b = true;
        r1.a(xo5.a.c(r2, 2131889840, "securityLevel", r4));
        return;
    L5:
        if (r5 == false) goto L7;
        r1.a(xo5.a.c(r2, 2131889916, "secure_label", r4));
        return;
    L7:
        r1.a(r2.getString(2131889917));
    }

    public static void f(o r1, Context r2, int r3, String r4, boolean r5) {
        r1.a(xo5.a.c(r2, r3, "securityLevel", r4));
        r1.d = true;
        r1.c = true;
        r1.b = r5;
        r1.e = true ^ r5;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.secret.d
    public final Flowable<Boolean> d(String r5, int r6, String r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "objId");
        Intrinsics.checkNotNullParameter(r7, "secLabelId");
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/sec_label/banner/");
        ((NetService.e) r1).c = 1;
        JSONObject r2 = new JSONObject();
        r2.put("obj_id", r5);     // Catch: Exception -> L5
        r2.put("obj_type", r6);     // Catch: Exception -> L5
        r2.put("sec_label_id", r7);     // Catch: Exception -> L5
        r2.put("banner_type", r8);     // Catch: Exception -> L5
        r2.put("banner_status", r9);     // Catch: Exception -> L5
        ((NetService.e) r1).j = r2.toString();     // Catch: Exception -> L5
    L8:
        return r0.Vc(b.a).a(r1).map(c.a);
    L5:
        e = move-exception;
        tt5.a.d("SecretBannerImpl", e.toString());
        goto L8
    }
}
