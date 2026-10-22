package a15;

import android.text.TextUtils;
import b15.b;
import b15.c;
import com.bytedance.ee.bear.contract.d;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public final d a;
    public final Map<String, Object> b;

    /* JADX INFO: renamed from: a15.a$a, reason: collision with other inner class name */
    public static final class C0001a {
    }

    static {
    }

    public abstract void c();

    public abstract void e();

    public abstract void f(String r1);

    public abstract void g();

    public abstract void h(String r1, String r2, String r3, String r4, String r5);

    public abstract void j();

    public abstract void k(String r1);

    public abstract void l(String r1);

    public abstract void m();

    public abstract void n(String r1, String r2, String r3);

    public abstract void p();

    public a(d r4) {
        this.a = r4;
        this.b = new HashMap();
        if (r4 == null) goto L5;
        HashMap<String, Object> r5 = r4.m("docCommonParams");
    L6:
        if (r5 == null) goto L11;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<String, Object> r0 = r6.next();
        this.b.put(r0.getKey(), r0.getValue());
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        HashMap r0 = new HashMap(2);
        r0.put("click", "back");
        r0.put("target", "none");
        q(r4, r0);
    }

    @JvmStatic
    public static final a a(d r1, int r2) {
        if (r2 != 22) goto L6;
        return new b(r1);
    L6:
        if (r2 != 3) goto L9;
        return new c(r1);
    L9:
        return new b15.a(r1);
    }

    @JvmStatic
    public static final a b(d r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        int r4 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).Z(r3).a();
        if (r4 != 22) goto L6;
        return new b(r2);
    L6:
        if (r4 != 3) goto L9;
        return new c(r2);
    L9:
        return new b15.a(r2);
    }

    public final void q(String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "params");
        ((HashMap) r4).putAll(this.b);
        tt5.a.b("EditionAnalytic", "reportEventV2: event = " + r3 + ", params = " + r4);
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.n(r3, r4);
        return;
    }

    public final void o(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "event");
        HashMap r0 = new HashMap();
        r0.put("click", r4);
        r0.put("target", r6);
        r0.put("target_version_id", r5);
        q(r3, r0);
    }

    public final void i(String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "event");
        HashMap r0 = new HashMap(2);
        r0.put("click", r4);
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.put("target", r5);
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r0.put("show_type", r6);
    L9:
        if (TextUtils.isEmpty(r7) == true) goto L12;
        r0.put("download_type", r7);
    L12:
        if (TextUtils.isEmpty(r8) == true) goto L14;
        r0.put("lang", r8);
    L14:
        q(r3, r0);
    }
}
