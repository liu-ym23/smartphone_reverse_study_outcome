package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public final Context a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a$a, reason: collision with other inner class name */
    public static final class C0045a {
    }

    static {
    }

    public abstract e0 b();

    public abstract boolean d();

    public final e0 a() {
        VFSPath r0 = new com.bytedance.ee.bear.doc.resupdate.b().a(this.a);
        if (r0 != null) goto L5;
        r0 = new com.bytedance.ee.bear.doc.resupdate.b().a(this.a);
    L5:
        String r1 = d0.f(r0);
        return new e0(r0.toFile(), r1, "");
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final e0 c(VFSFile r6, String r7, String r8) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "version");
        Intrinsics.checkNotNullParameter(r8, "channel");
        VFSPath r9 = r6.getVfsPath().subPath(r7);
        VFSPath r0 = r9.subPath("eesz");
        tt5.a.b("AbsResourceInterceptor", "getResourceInternal, res = " + r0.getRealPath());
        boolean r1 = new com.bytedance.ee.bear.doc.resupdate.a(r7, r8).a(r0);
        tt5.a.h("AbsResourceInterceptor", "getResourceInternal, check completion = " + r1 + ", withoutMd5Check = true");
        if (r1 == true) goto L5;
        vy4.a.c(this.a, r8);
        FileUtils.m(r9);
    L5:
        if (r1 == false) goto L8;
        return new e0(r0.toFile(), r7, r8);
    L8:
        return a();
    }
}
