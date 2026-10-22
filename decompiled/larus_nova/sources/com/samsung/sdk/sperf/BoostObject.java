package com.samsung.sdk.sperf;

/* JADX INFO: loaded from: classes34.dex */
class BoostObject {
    public static final int NO_ID = -1;
    private static final int PRIO_HIGHER_IDX_IS_BETTER = 0;
    private static final int PRIO_LAST_OVERWRITE = 2;
    private static final int PRIO_LOWER_IDX_IS_BETTER = 1;
    private static int[] priority;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f405790id;
    private int[] levels;
    private int[] timeouts;

    static {
        priority = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2};
    }

    public BoostObject() {
        this.f405790id = -1;
        this.levels = new int[11];
        this.timeouts = new int[11];
        int r100 = 0;
    L3:
        if (r100 >= 11) goto L5;
        this.levels[r100] = 64532198;
        this.timeouts[r100] = 64532198;
        r100 = r100 + 1;
        goto L3
    }

    private BoostObject(int[] r100, int[] r101) {
        this.f405790id = -1;
        this.levels = new int[r100.length];
        this.timeouts = new int[r101.length];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L7;
        this.levels[r103] = r100[r103];
        r103 = r103 + 1;
    L7:
        if (r102 >= r101.length) goto L9;
        this.timeouts[r102] = r101[r102];
        r102 = r102 + 1;
        goto L7
    }

    public boolean combineBoostObject(BoostObject r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        int r100 = 0;
    L7:
        if (r100 >= this.levels.length) goto L31;
        int r101 = r110.getLevel(r100);     // Catch: ArrayIndexOutOfBoundsException -> L28
        if (r101 == 64532198) goto L27;
        int[] r102 = this.levels;     // Catch: ArrayIndexOutOfBoundsException -> L28
        int r103 = r102[r100];     // Catch: ArrayIndexOutOfBoundsException -> L28
        if (r103 == 64532198) goto L26;
        int[] r104 = this.timeouts;     // Catch: ArrayIndexOutOfBoundsException -> L28
        if (r104[r100] == 64532198) goto L26;
        int r105 = priority[r100];     // Catch: ArrayIndexOutOfBoundsException -> L28
        if (r105 != 0) goto L20;
        if (r103 >= r101) goto L20;
        r102[r100] = r101;     // Catch: ArrayIndexOutOfBoundsException -> L28
        r104[r100] = r110.getTimeout(r100);     // Catch: ArrayIndexOutOfBoundsException -> L28
    L20:
        if (r105 != 1) goto L24;
        if (r103 <= r101) goto L24;
        r102[r100] = r101;     // Catch: ArrayIndexOutOfBoundsException -> L28
        r104[r100] = r110.getTimeout(r100);     // Catch: ArrayIndexOutOfBoundsException -> L28
    L24:
        if (r105 != 2) goto L27;
        r102[r100] = r101;     // Catch: ArrayIndexOutOfBoundsException -> L28
        r104[r100] = r110.getTimeout(r100);     // Catch: ArrayIndexOutOfBoundsException -> L28
    L26:
        r102[r100] = r101;     // Catch: ArrayIndexOutOfBoundsException -> L28
        this.timeouts[r100] = r110.getTimeout(r100);     // Catch: ArrayIndexOutOfBoundsException -> L28
    L27:
        r100 = r100 + 1;
    L28:
        e = move-exception;
        e.printStackTrace();
        SPerfUtil.log("Combine Boost Object has array out of bounds on type : " + r100);
        return false;
    L31:
        return true;
    }

    public BoostObject copyBoostObject() {
        return new BoostObject(this.levels, this.timeouts);
    }

    public int getID() {
        return this.f405790id;
    }

    public int getLevel(int r100) {
        if (r100 >= 0) goto L4;
        return 64532198;
    L4:
        if (r100 < 11) goto L7;
        return 64532198;
    L7:
        return this.levels[r100];
    }

    public int getTimeout(int r100) {
        if (r100 >= 0) goto L4;
        return 64532198;
    L4:
        if (r100 < 11) goto L7;
        return 64532198;
    L7:
        return this.timeouts[r100];
    }

    public void setID(int r100) {
        this.f405790id = r100;
    }

    public int update(int r100, int r101, int r102) {
        if (r100 > 11) goto L8;
        if (r100 < 0) goto L10;
        this.levels[r100] = r101;
        this.timeouts[r100] = r102;
        SPerfUtil.log("Update Boost - type : " + r100 + "   level : " + this.levels[r100] + "   timeouts : " + this.timeouts[r100]);
        return 0;
    L10:
        return -1;
    L8:
        return -1;
    }
}
