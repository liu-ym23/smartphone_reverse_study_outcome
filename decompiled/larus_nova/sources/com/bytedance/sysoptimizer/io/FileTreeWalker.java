package com.bytedance.sysoptimizer.io;

import android.content.Context;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class FileTreeWalker {

    public static class Stat {
        private final long blockSize;
        private final long blocks;
        private final long size;

        public long getBlockSize() {
            return this.blockSize;
        }

        public long getBlocks() {
            return this.blocks;
        }

        public long getSize() {
            return this.size;
        }

        public static /* synthetic */ long access$000(Stat r100) {
            return r100.size;
        }

        public static /* synthetic */ long access$100(Stat r100) {
            return r100.blockSize;
        }

        public Stat(long r100, long r101, long r102) {
            this.size = r100;
            this.blocks = r101;
            this.blockSize = r102;
        }
    }

    public FileTreeWalker() {
    }

    private static native Stat nativeWalk(String r100);

    public static long getTotalBlockSize(Context r100, String r101) {
        Stat r102 = walk(r100, r101);
        if (r102 != null) goto L7;
        return -1;
    L7:
        return Stat.access$100(r102);
    }

    public static long getTotalSize(Context r100, String r101) {
        Stat r102 = walk(r100, r101);
        if (r102 != null) goto L7;
        return -1;
    L7:
        return Stat.access$000(r102);
    }

    private static Stat walk(Context r100, String r101) {
        if (r101 != null) goto L5;
    L11:
        return null;
    L5:
        if (r101.isEmpty() == true) goto L11;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L11;
        return nativeWalk(r101);
    }
}
