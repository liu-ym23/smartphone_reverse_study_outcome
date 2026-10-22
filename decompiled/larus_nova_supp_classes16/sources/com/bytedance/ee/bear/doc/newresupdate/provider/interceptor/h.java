package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {
    public static boolean e;
    public final Context b;
    public VFSFile c;
    public final boolean d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("AbsResourceInterceptor", "getResource, use specific");
        File[] r1 = e().listFiles();
        Intrinsics.checkNotNull(r1);
        String r2 = r1[0].getName();
    L11:
        e = move-exception;
        tt5.a.e("AbsResourceInterceptor", "getResource error", e, false);
        return a();
    L4:
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(this.b) == true) goto L7;
    L9:
        return c(e(), r2, EChannel.DOCS_CHANNEL.toString());
    L7:
        if (e == true) goto L9;
        j.c(new i(r2));     // Catch: Exception -> L11
        e = true;     // Catch: Exception -> L11
        goto L9
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        if (this.d == true) goto L11;
        String[] r0 = e().list();
        if (r0 == null) goto L7;
        int r1 = r0.length;
    L8:
        if (r1 <= 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = 0;
        goto L8
    L11:
        return false;
    }

    public final VFSFile e() {
        if (this.c != null) goto L5;
        this.c = d0.j("specific");
    L5:
        VFSFile r0 = this.c;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public h(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = r3;
        this.d = ((Boolean) new ml5.b("debug_config").a("offline_disable_specific_res", Boolean.FALSE)).booleanValue();
    }
}
