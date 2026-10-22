package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.e
    public final String b() {
        return "eesz";
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.e
    public final VFSPath a(Context r17) {
        String r6 = EChannel.DOCS_CHANNEL.toString();
        h0 r8 = h0.a.a;     // Catch: IOException -> L25
        g0 r9 = r8.c(r17);     // Catch: IOException -> L25
        String r10 = r9.b;     // Catch: IOException -> L25
        VFSFile r11 = d0.j(r6);     // Catch: IOException -> L25
        if (r9.c == false) goto L6;
        String r12 = "_sim";
    L7:
        VFSFile r13 = ay4.d.a().D(r11, r10 + r12);     // Catch: IOException -> L25
        if (r13.exists() == true) goto L19;
        VFSFile r4 = ay4.d.a().D(r11, r10 + OfflineDoc.DASH_DELIMITER + System.currentTimeMillis() + "__temp");     // Catch: IOException -> L25
        r4.mkdir();     // Catch: IOException -> L23
        if (r8.a(r17, r4, r6) == true) goto L15;
        FileUtils.m(r4.getVfsPath());     // Catch: IOException -> L23
        return null;
    L15:
        if (r13.exists() == false) goto L17;
        tt5.a.h("DocsDefaultResourceImp", "getResource(): destParentFile exists() after unzip delete temp file , destParentFile= " + r13);     // Catch: IOException -> L23
        FileUtils.m(r4.getVfsPath());     // Catch: IOException -> L23
    L21:
        VFSPath r0 = ay4.d.a().H(r13, "eesz");     // Catch: IOException -> L23
        tt5.a.h("DocsDefaultResourceImp", "getResource(): path " + r0.getRealPath() + ",isSlim = " + r9.c);     // Catch: IOException -> L23
        return r0;
    L17:
        tt5.a.h("DocsDefaultResourceImp", "getResource(): rename result = " + r4.renameTo(r13));     // Catch: IOException -> L23
    L23:
        e = e;
    L27:
        tt5.a.e("DocsDefaultResourceImp", "docs getResource(): failed ", e, false);
        if (r4 != null) goto L37;
        return null;
    L37:
        FileUtils.m(r4.getVfsPath());     // Catch: IOException -> L32
        return null;
    L32:
        e = move-exception;
        tt5.a.e("DocsDefaultResourceImp", "safeDeleteFile failed ", e, false);
        return null;
    L19:
        tt5.a.h("DocsDefaultResourceImp", "getResource(): destParentFile exists()");     // Catch: IOException -> L25
        goto L21
    L6:
        r12 = "";
    L25:
        e = e;
        r4 = null;
        goto L27
    }
}
