package org.bouncycastle.pqc.crypto.sphincs;

/* JADX INFO: loaded from: classes42.dex */
class Tree {

    public static class leafaddr {
        int level;
        long subleaf;
        long subtree;

        public leafaddr() {
        }

        public leafaddr(leafaddr r100) {
            this.level = r100.level;
            this.subtree = r100.subtree;
            this.subleaf = r100.subleaf;
        }
    }

    public Tree() {
    }

    public static void gen_leaf_wots(HashFunctions r110, byte[] r111, int r112, byte[] r113, int r114, byte[] r115, leafaddr r116) {
        byte[] r100 = new byte[32];
        byte[] r101 = new byte[2144];
        Wots r102 = new Wots();
        Seed.get_seed(r110, r100, 0, r115, r116);
        r102.wots_pkgen(r110, r101, 0, r100, 0, r113, r114);
        l_tree(r110, r111, r112, r101, 0, r113, r114);
    }

    public static void l_tree(HashFunctions r110, byte[] r111, int r112, byte[] r113, int r114, byte[] r115, int r210) {
        int r116 = 67;
        int r117 = 0;
    L4:
        if (r117 >= 7) goto L13;
        int r118 = 0;
    L6:
        int r100 = r116 >>> 1;
        if (r118 >= r100) goto L10;
        r110.hash_2n_n_mask(r113, r114 + (r118 * 32), r113, r114 + ((r118 * 2) * 32), r115, r210 + ((r117 * 2) * 32));
        r118 = r118 + 1;
        goto L6
    L10:
        if ((r116 & 1) == 0) goto L12;
        System.arraycopy(r113, r114 + ((r116 - 1) * 32), r113, (r100 * 32) + r114, 32);
        r100 = r100 + 1;
    L12:
        r116 = r100;
        r117 = r117 + 1;
        goto L4
    L13:
        System.arraycopy(r113, r114, r111, r112, 32);
    }

    public static void treehash(HashFunctions r110, byte[] r111, int r112, int r210, byte[] r211, leafaddr r212, byte[] r213, int r214) {
        leafaddr r100 = new leafaddr(r212);
        int r101 = r210 + 1;
        byte[] r113 = new byte[r101 * 32];
        int[] r114 = new int[r101];
        int r115 = 1;
        int r116 = (int) (r100.subleaf + ((long) (1 << r210)));
        int r102 = 0;
    L4:
        if (r100.subleaf >= r116) goto L11;
        gen_leaf_wots(r110, r113, r102 * 32, r213, r214, r211, r100);
        r114[r102] = 0;
        int r103 = r102 + r115;
    L6:
        if (r103 <= r115) goto L10;
        int r104 = r114[r103 - 1];
        int r105 = r103 - 2;
        if (r104 != r114[r105]) goto L10;
        int r106 = r105 * 32;
        int[] r107 = r114;
        r110.hash_2n_n_mask(r113, r106, r113, r106, r213, r214 + (((r104 + 7) * 2) * 32));
        r107[r105] = r107[r105] + 1;
        r103 = r103 - 1;
        r116 = r116;
        r114 = r107;
        r115 = 1;
    L10:
        r100.subleaf++;
        r102 = r103;
        r116 = r116;
        r114 = r114;
        r115 = 1;
        goto L4
    L11:
        int r108 = 0;
    L12:
        if (r108 >= 32) goto L14;
        r111[r112 + r108] = r113[r108];
        r108 = r108 + 1;
        goto L12
    }
}
