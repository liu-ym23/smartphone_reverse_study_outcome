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

/* JADX INFO: loaded from: classes16.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f561591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super String, Object, ? super m, Unit> f561592b;

    /* JADX INFO: renamed from: wv4.a$a, reason: collision with other inner class name */
    public static final class C8167a {
    }

    public static final class b<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f561593a;

        public b(m r100) {
            this.f561593a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            m r102 = this.f561593a;
            if (r102 == null) goto L6;
            r102.onCallBack(r101);
            return;
        }
    }

    public static final class c<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f561594a;

        public c(m r100) {
            this.f561594a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            m r102 = this.f561594a;
            if (r102 == null) goto L6;
            r102.onCallBack(r101);
            return;
        }
    }

    static {
    }

    @Override // tb5.n
    public final void b() {
        Intrinsics.checkNotNullParameter("biz.util.onKeyboardChanged", "handlerName");
        this.f561591a.unbindJSHandler("biz.util.onKeyboardChanged");
    }

    public a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        this.f561591a = r100;
    }

    @Override // tb5.n
    public final void c(String r100, i<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f561591a.h(r100, r101);
    }

    @Override // tb5.n
    public final void a(String r100, Object r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        String r103 = "javascript:" + r100;
        boolean r104 = r101 instanceof JSONObject;
        JSONObject r105 = null;
        if (r104 == true) goto L18;
        if (r101 == null) goto L18;
        if ((r101 instanceof org.json.JSONObject) == false) goto L9;
        this.f561591a.l(r103, (org.json.JSONObject) r101, new c(r102));
        return;
    L9:
        boolean r106 = r101 instanceof NonProguard;
        if (r106 == false) goto L13;
        if (r102 != null) goto L13;
        this.f561591a.k(r103, (NonProguard) r101, null);
        return;
    L13:
        if (r106 == false) goto L27;
        if (r102 == null) goto L28;
        Function3<? super String, Object, ? super m, Unit> r107 = this.f561592b;
        if (r107 == null) goto L29;
        r107.invoke(r103, r101, r102);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L18:
        k r108 = this.f561591a;
        if (r104 == false) goto L21;
        r105 = (JSONObject) r101;
    L21:
        if (r105 != null) goto L23;
        r105 = new JSONObject();
    L23:
        r108.a(r103, r105, new b(r102));
    }
}
