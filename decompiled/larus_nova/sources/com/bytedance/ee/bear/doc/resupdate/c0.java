package com.bytedance.ee.bear.doc.resupdate;

import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class c0 implements Consumer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f218004a;

    public c0(List r100) {
        this.f218004a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Boolean r100) throws Exception {
        Iterator r101 = this.f218004a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        VFSFile r102 = (VFSFile) r101.next();
        tt5.a.h("ResUtil", "deleteExtraResource(): del = " + r102);
        FileUtils.p(r102.getVfsPath());
        goto L4
    }
}
