package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DebugResourceInterceptor extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f217978e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f217979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f217980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f217981d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("AbsResourceInterceptor", "getResource, use debug resource");
        String r100 = ((VFSFile) this.f217980c.getValue()).listFiles()[0].getName();
    L8:
        e = move-exception;
        tt5.a.e("AbsResourceInterceptor", "getResource error", e, false);
        return a();
    L4:
        if (f217978e == true) goto L6;
        j.c(new c(r100));     // Catch: Exception -> L8
        f217978e = true;     // Catch: Exception -> L8
    L6:
        return c((VFSFile) this.f217980c.getValue(), r100, EChannel.DOCS_CHANNEL.toString());
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(this.f217979b) == true) goto L5;
        return false;
    L5:
        if (this.f217981d == false) goto L14;
        String[] r100 = ((VFSFile) this.f217980c.getValue()).list();
        if (r100 == null) goto L9;
        int r101 = r100.length;
    L10:
        if (r101 <= 0) goto L15;
        return true;
    L15:
        return false;
    L9:
        r101 = 0;
        goto L10
    L14:
        return false;
    }

    public DebugResourceInterceptor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f217979b = r100;
        this.f217980c = LazyKt.lazy(new DebugResourceInterceptor$debugDir$2(this));
        this.f217981d = ((Boolean) new ml5.b("debug_config").a("enable_debug_res", Boolean.FALSE)).booleanValue();
    }
}
