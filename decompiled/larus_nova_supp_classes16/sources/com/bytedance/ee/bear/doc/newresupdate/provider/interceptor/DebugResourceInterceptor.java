package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DebugResourceInterceptor extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {
    public static boolean e;
    public final Context b;
    public final Lazy c;
    public final boolean d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("AbsResourceInterceptor", "getResource, use debug resource");
        String r1 = ((VFSFile) this.c.getValue()).listFiles()[0].getName();
    L8:
        e = move-exception;
        tt5.a.e("AbsResourceInterceptor", "getResource error", e, false);
        return a();
    L4:
        if (e == true) goto L6;
        j.c(new c(r1));     // Catch: Exception -> L8
        e = true;     // Catch: Exception -> L8
    L6:
        return c((VFSFile) this.c.getValue(), r1, EChannel.DOCS_CHANNEL.toString());
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(this.b) == true) goto L5;
        return false;
    L5:
        if (this.d == false) goto L14;
        String[] r0 = ((VFSFile) this.c.getValue()).list();
        if (r0 == null) goto L9;
        int r1 = r0.length;
    L10:
        if (r1 <= 0) goto L15;
        return true;
    L15:
        return false;
    L9:
        r1 = 0;
        goto L10
    L14:
        return false;
    }

    public DebugResourceInterceptor(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = r3;
        this.c = LazyKt.lazy(new DebugResourceInterceptor$debugDir$2(this));
        this.d = ((Boolean) new ml5.b("debug_config").a("enable_debug_res", Boolean.FALSE)).booleanValue();
    }
}
