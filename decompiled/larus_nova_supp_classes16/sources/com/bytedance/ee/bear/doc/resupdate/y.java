package com.bytedance.ee.bear.doc.resupdate;

import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements Consumer<Boolean> {
    public final /* synthetic */ VFSFile a;
    public final /* synthetic */ w b;

    public final void accept(Object r3) throws Exception {
        Boolean r4 = (Boolean) r3;
        FileUtils.p(this.a.getVfsPath());
        Iterator r5 = ((ArrayList) this.b.c).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r0 = (String) r5.next();
        this.b.o(r0);
        goto L4
    L6:
        tt5.a.h("LocalResUpdateServiceImpl", "accept(): clean space_res dir success");
    }

    public y(w r1, VFSFile r2) {
        this.b = r1;
        this.a = r2;
    }
}
