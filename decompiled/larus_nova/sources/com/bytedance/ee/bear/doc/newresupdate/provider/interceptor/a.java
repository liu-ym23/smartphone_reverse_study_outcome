package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f217982a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a$a, reason: collision with other inner class name */
    public static final class C3101a {
    }

    static {
    }

    public abstract e0 b();

    public abstract boolean d();

    public final e0 a() {
        VFSPath r100 = new com.bytedance.ee.bear.doc.resupdate.b().a(this.f217982a);
        if (r100 != null) goto L5;
        r100 = new com.bytedance.ee.bear.doc.resupdate.b().a(this.f217982a);
    L5:
        String r101 = d0.f(r100);
        return new e0(r100.toFile(), r101, "");
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f217982a = r100;
    }

    public final e0 c(VFSFile r100, String r101, String r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "channel");
        VFSPath r103 = r100.getVfsPath().subPath(r101);
        VFSPath r104 = r103.subPath("eesz");
        tt5.a.b("AbsResourceInterceptor", "getResourceInternal, res = " + r104.getRealPath());
        boolean r105 = new com.bytedance.ee.bear.doc.resupdate.a(r101, r102).a(r104);
        tt5.a.h("AbsResourceInterceptor", "getResourceInternal, check completion = " + r105 + ", withoutMd5Check = true");
        if (r105 == true) goto L5;
        vy4.a.c(this.f217982a, r102);
        FileUtils.m(r103);
    L5:
        if (r105 == false) goto L8;
        return new e0(r104.toFile(), r101, r102);
    L8:
        return a();
    }
}
