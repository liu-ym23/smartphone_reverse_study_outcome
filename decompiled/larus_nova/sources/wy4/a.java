package wy4;

import android.content.Context;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.DebugResourceInterceptor;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.b;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.e;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.f;
import com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a[] f561871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f561872b;

    /* JADX INFO: renamed from: wy4.a$a, reason: collision with other inner class name */
    public static final class C8173a {
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r101 = new b(r100);
        this.f561872b = r101;
        this.f561871a = new com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a[]{new DebugResourceInterceptor(r100), new h(r100), new e(r100), new f(r100), r101};
    }
}
