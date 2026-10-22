package com.bytedance.ee.util.io;

import com.ss.android.lark.vfs.VFSFile;
import java.util.Comparator;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Comparator<VFSFile> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(VFSFile r100, VFSFile r101) {
        if (FileUtils.v(r100.getVfsPath()) >= FileUtils.v(r101.getVfsPath())) goto L5;
        return -1;
    L5:
        return 1;
    }
}
