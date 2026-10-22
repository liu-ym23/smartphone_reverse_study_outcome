package wy4;

import android.content.Context;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.DebugResourceInterceptor;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.b;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.e;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.f;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a[] a;
    public final b b;

    /* JADX INFO: renamed from: wy4.a$a, reason: collision with other inner class name */
    public static final class C0321a {
    }

    static {
    }

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        b r0 = new b(r5);
        this.b = r0;
        this.a = new com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a[]{new DebugResourceInterceptor(r5), new h(r5), new e(r5), new f(r5), r0};
    }
}
