package wv4;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import tb5.n;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements n {
    public final k a;
    public Function3<? super String, Object, ? super m, Unit> b;

    /* JADX INFO: renamed from: wv4.a$a, reason: collision with other inner class name */
    public static final class C0320a {
    }

    public static final class b<T> implements ValueCallback {
        public final /* synthetic */ m a;

        public b(m r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r2) {
            String r3 = (String) r2;
            m r0 = this.a;
            if (r0 == null) goto L6;
            r0.onCallBack(r3);
            return;
        }
    }

    public static final class c<T> implements ValueCallback {
        public final /* synthetic */ m a;

        public c(m r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r2) {
            String r3 = (String) r2;
            m r0 = this.a;
            if (r0 == null) goto L6;
            r0.onCallBack(r3);
            return;
        }
    }

    static {
    }

    @Override // tb5.n
    public final void b() {
        Intrinsics.checkNotNullParameter("biz.util.onKeyboardChanged", "handlerName");
        this.a.unbindJSHandler("biz.util.onKeyboardChanged");
    }

    public a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "web");
        this.a = r2;
    }

    @Override // tb5.n
    public final void c(String r2, i<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "handlerName");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a.h(r2, r3);
    }

    @Override // tb5.n
    public final void a(String r4, Object r5, m r6) {
        Intrinsics.checkNotNullParameter(r4, "handlerName");
        String r7 = "javascript:" + r4;
        boolean r0 = r5 instanceof JSONObject;
        JSONObject r1 = null;
        if (r0 == true) goto L18;
        if (r5 == null) goto L18;
        if ((r5 instanceof org.json.JSONObject) == false) goto L9;
        this.a.l(r7, (org.json.JSONObject) r5, new c(r6));
        return;
    L9:
        boolean r2 = r5 instanceof NonProguard;
        if (r2 == false) goto L13;
        if (r6 != null) goto L13;
        this.a.k(r7, (NonProguard) r5, null);
        return;
    L13:
        if (r2 == false) goto L27;
        if (r6 == null) goto L28;
        Function3<? super String, Object, ? super m, Unit> r3 = this.b;
        if (r3 == null) goto L29;
        r3.invoke(r7, r5, r6);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L18:
        k r8 = this.a;
        if (r0 == false) goto L21;
        r1 = (JSONObject) r5;
    L21:
        if (r1 != null) goto L23;
        r1 = new JSONObject();
    L23:
        r8.a(r7, r1, new b(r6));
    }
}
