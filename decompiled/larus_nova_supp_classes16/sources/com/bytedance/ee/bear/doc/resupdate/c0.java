package com.bytedance.ee.bear.doc.resupdate;

import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0 implements Consumer<Boolean> {
    public final /* synthetic */ List a;

    public c0(List r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        Boolean r5 = (Boolean) r4;
        Iterator r6 = this.a.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        VFSFile r0 = (VFSFile) r6.next();
        tt5.a.h("ResUtil", "deleteExtraResource(): del = " + r0);
        FileUtils.p(r0.getVfsPath());
        goto L4
    }
}
