package com.samsung.sdk.sperf;

/* JADX INFO: loaded from: classes34.dex */
class BoostResource {
    protected static final int NO_RESOURCE = 64532198;
    protected static final int TIMEOUT_INF = 99999999;
    private int defaultLevel;
    private int[] levelTable;
    private int maxTimeout;

    public BoostResource(int[] r100, int r101) {
        this.levelTable = null;
        this.maxTimeout = NO_RESOURCE;
        this.defaultLevel = NO_RESOURCE;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        SPerfUtil.log("Table[" + r102 + "] : " + r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        SPerfUtil.log("Timeout : " + r101);
        this.levelTable = r100;
        this.maxTimeout = r101;
    }

    public int adjustLevel(int r100) {
        int[] r101 = this.levelTable;
        if (r101.length >= 1) goto L5;
        return NO_RESOURCE;
    L5:
        if (r100 >= 0) goto L9;
        SPerfUtil.log("");
        return NO_RESOURCE;
    L9:
        if (r100 < r101.length) goto L11;
        return NO_RESOURCE;
    L11:
        return r100;
    }

    public int adjustTimeout(int r100) {
        if (r100 >= 0) goto L5;
        return NO_RESOURCE;
    L5:
        int r101 = this.maxTimeout;
        if (r100 <= r101) goto L8;
        return r101;
    L8:
        return r100;
    }

    public boolean check(int r100, int r101) {
        if (r101 > 0) goto L5;
    L18:
        return false;
    L5:
        if (r101 > this.maxTimeout) goto L18;
        int r102 = 0;
    L8:
        int[] r103 = this.levelTable;
        if (r102 >= r103.length) goto L14;
        if (r103[r102] == r100) goto L12;
        r102 = r102 + 1;
        goto L8
    L12:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L17;
        return false;
    L17:
        return true;
    L14:
        r104 = false;
        goto L15
    }

    public int getDefaultLevel() {
        return this.defaultLevel;
    }

    public int getRealBoostLevel(int r100) {
        int[] r101 = this.levelTable;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (r100 >= 0) goto L7;
    L11:
        return -1;
    L7:
        if (r100 >= r101.length) goto L11;
        return r101[r100];
    }

    public void setDefaultLevel(int r100) {
        this.defaultLevel = r100;
    }
}
