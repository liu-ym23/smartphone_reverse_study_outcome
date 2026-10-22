package com.ss.android.socialbase.appdownloader.util.parser.manifest;

/* JADX INFO: loaded from: classes38.dex */
public final class NamespaceStack {
    private int[] m_data;
    private int m_dataLength;
    private int m_depth;

    public void increaseDepth() {
        ensureDataCapacity(2);
        int r100 = this.m_dataLength;
        int[] r101 = this.m_data;
        r101[r100] = 0;
        r101[r100 + 1] = 0;
        this.m_dataLength = r100 + 2;
        this.m_depth++;
    }

    public void reset() {
        this.m_dataLength = 0;
        this.m_depth = 0;
    }

    public void decreaseDepth() {
        int r100 = this.m_dataLength;
        if (r100 != 0) goto L5;
        return;
    L5:
        int r101 = r100 - 1;
        int r102 = this.m_data[r101] * 2;
        if (((r101 - 1) - r102) != 0) goto L8;
        return;
    L8:
        this.m_dataLength = r100 - (r102 + 2);
        this.m_depth--;
    }

    public int getCurrentCount() {
        int r100 = this.m_dataLength;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.m_data[r100 - 1];
    }

    public boolean pop() {
        int r100 = this.m_dataLength;
        if (r100 != 0) goto L5;
        return false;
    L5:
        int r101 = r100 - 1;
        int[] r102 = this.m_data;
        int r103 = r102[r101];
        if (r103 != 0) goto L8;
        return false;
    L8:
        int r104 = r103 - 1;
        int r105 = r101 - 2;
        r102[r105] = r104;
        r102[r105 - ((r104 * 2) + 1)] = r104;
        this.m_dataLength = r100 - 2;
        return true;
    }

    public NamespaceStack() {
        this.m_data = new int[32];
    }

    public int getDepth() {
        return this.m_depth;
    }

    private void ensureDataCapacity(int r100) {
        int[] r101 = this.m_data;
        int r102 = r101.length;
        int r103 = this.m_dataLength;
        int r104 = r102 - r103;
        if (r104 <= r100) goto L5;
        return;
    L5:
        int[] r105 = new int[(r101.length + r104) * 2];
        System.arraycopy(r101, 0, r105, 0, r103);
        this.m_data = r105;
    }

    public int findPrefix(int r100) {
        return find(r100, false);
    }

    public int getAccumulatedCount(int r100) {
        int r101 = 0;
        if (this.m_dataLength == 0) goto L12;
        if (r100 < 0) goto L12;
        int r102 = this.m_depth;
        if (r100 <= r102) goto L9;
        r100 = r102;
    L9:
        int r103 = 0;
    L10:
        if (r100 == 0) goto L12;
        int r104 = this.m_data[r103];
        r101 = r101 + r104;
        r103 = r103 + ((r104 * 2) + 2);
        r100 = r100 - 1;
    L12:
        return r101;
    }

    public int getPrefix(int r100) {
        return get(r100, true);
    }

    public int getUri(int r100) {
        return get(r100, false);
    }

    private int find(int r100, boolean r101) {
        int r102 = this.m_dataLength;
        if (r102 != 0) goto L5;
        return -1;
    L5:
        int r103 = r102 - 1;
        int r104 = this.m_depth;
    L6:
        if (r104 == 0) goto L20;
        int r105 = this.m_data[r103];
        r103 = r103 - 2;
    L8:
        if (r105 == 0) goto L19;
        if (r101 == false) goto L14;
        int[] r106 = this.m_data;
        if (r106[r103] != r100) goto L18;
        return r106[r103 + 1];
    L18:
        r103 = r103 - 2;
        r105 = r105 - 1;
        goto L8
    L14:
        int[] r107 = this.m_data;
        if (r107[r103 + 1] != r100) goto L18;
        return r107[r103];
    L19:
        r104 = r104 - 1;
        goto L6
    L20:
        return -1;
    }

    private int get(int r100, boolean r101) {
        if (this.m_dataLength == 0) goto L16;
        if (r100 < 0) goto L16;
        int r102 = this.m_depth;
        int r103 = 0;
    L7:
        if (r102 == 0) goto L16;
        int[] r104 = this.m_data;
        int r105 = r104[r103];
        if (r100 < r105) goto L11;
        r100 = r100 - r105;
        r103 = r103 + ((r105 * 2) + 2);
        r102 = r102 - 1;
        goto L7
    L11:
        int r106 = r103 + ((r100 * 2) + 1);
        if (r101 == true) goto L15;
        r106 = r106 + 1;
    L15:
        return r104[r106];
    L16:
        return -1;
    }

    public void push(int r100, int r101) {
        if (this.m_depth != 0) goto L5;
        increaseDepth();
    L5:
        ensureDataCapacity(2);
        int r102 = this.m_dataLength;
        int r103 = r102 - 1;
        int[] r104 = this.m_data;
        int r105 = r104[r103];
        int r106 = (r103 - 1) - (r105 * 2);
        int r107 = r105 + 1;
        r104[r106] = r107;
        r104[r103] = r100;
        r104[r103 + 1] = r101;
        r104[r103 + 2] = r107;
        this.m_dataLength = r102 + 2;
    }
}
