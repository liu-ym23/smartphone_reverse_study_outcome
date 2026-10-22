package com.ss.android.lark.vfs2;

import android.net.Uri;
import com.ss.android.lark.vfs2.c;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<P, F, T extends c<P, F, ?>> {
    public final void a() {
        d r100 = (d) VFS2.f444834a.getValue();
        Uri r101 = ((com.ss.android.lark.vfs2.file.d) this).f444838a;
        e r102 = e.f444836b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "options");
        f r103 = (f) ((LinkedHashMap) r100.f444835a).get(r101.getScheme());
        if (r103 == null) goto L6;
        r103.a();
    L6:
        throw new IllegalStateException("FileSystem not found which support uri:" + r101.getPath());
    }

    public a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
    }
}
