package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.e
    public final String b() {
        return "eesz";
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.e
    public final VFSPath a(Context r110) {
        String r100 = EChannel.DOCS_CHANNEL.toString();
        h0 r101 = h0.a.f218018a;     // Catch: IOException -> L25
        g0 r102 = r101.c(r110);     // Catch: IOException -> L25
        String r111 = r102.f218011b;     // Catch: IOException -> L25
        VFSFile r112 = d0.j(r100);     // Catch: IOException -> L25
        if (r102.f218012c == false) goto L6;
        String r113 = "_sim";
    L7:
        VFSFile r114 = ay4.d.a().D(r112, r111 + r113);     // Catch: IOException -> L25
        if (r114.exists() == true) goto L19;
        VFSFile r103 = ay4.d.a().D(r112, r111 + "_" + System.currentTimeMillis() + "__temp");     // Catch: IOException -> L25
        r103.mkdir();     // Catch: IOException -> L23
        if (r101.a(r110, r103, r100) == true) goto L15;
        FileUtils.m(r103.getVfsPath());     // Catch: IOException -> L23
        return null;
    L15:
        if (r114.exists() == false) goto L17;
        tt5.a.h("DocsDefaultResourceImp", "getResource(): destParentFile exists() after unzip delete temp file , destParentFile= " + r114);     // Catch: IOException -> L23
        FileUtils.m(r103.getVfsPath());     // Catch: IOException -> L23
    L21:
        VFSPath r104 = ay4.d.a().H(r114, "eesz");     // Catch: IOException -> L23
        tt5.a.h("DocsDefaultResourceImp", "getResource(): path " + r104.getRealPath() + ",isSlim = " + r102.f218012c);     // Catch: IOException -> L23
        return r104;
    L17:
        tt5.a.h("DocsDefaultResourceImp", "getResource(): rename result = " + r103.renameTo(r114));     // Catch: IOException -> L23
    L23:
        e = e;
    L27:
        tt5.a.e("DocsDefaultResourceImp", "docs getResource(): failed ", e, false);
        if (r103 != null) goto L37;
        return null;
    L37:
        FileUtils.m(r103.getVfsPath());     // Catch: IOException -> L32
        return null;
    L32:
        e = move-exception;
        tt5.a.e("DocsDefaultResourceImp", "safeDeleteFile failed ", e, false);
        return null;
    L19:
        tt5.a.h("DocsDefaultResourceImp", "getResource(): destParentFile exists()");     // Catch: IOException -> L25
        goto L21
    L6:
        r113 = "";
    L25:
        e = e;
        r103 = null;
        goto L27
    }
}
