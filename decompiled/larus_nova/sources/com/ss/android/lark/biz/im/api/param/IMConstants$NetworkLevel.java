package com.ss.android.lark.biz.im.api.param;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum IMConstants$NetworkLevel extends Enum<IMConstants$NetworkLevel> {
    public static final IMConstants$NetworkLevel EVALUATING = null;
    public static final IMConstants$NetworkLevel EXCELLENT = null;
    public static final IMConstants$NetworkLevel NET_UNAVAILABLE = null;
    public static final IMConstants$NetworkLevel SERVICE_UNAVAILABLE = null;
    public static final IMConstants$NetworkLevel WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMConstants$NetworkLevel[] f410435a = null;
    private final int status;

    static {
        IMConstants$NetworkLevel r100 = new IMConstants$NetworkLevel("EXCELLENT", 0, 1);
        EXCELLENT = r100;
        IMConstants$NetworkLevel r101 = new IMConstants$NetworkLevel("EVALUATING", 1, 2);
        EVALUATING = r101;
        IMConstants$NetworkLevel r102 = new IMConstants$NetworkLevel("WEAK", 2, 3);
        WEAK = r102;
        IMConstants$NetworkLevel r103 = new IMConstants$NetworkLevel("NET_UNAVAILABLE", 3, 4);
        NET_UNAVAILABLE = r103;
        IMConstants$NetworkLevel r104 = new IMConstants$NetworkLevel("SERVICE_UNAVAILABLE", 4, 5);
        SERVICE_UNAVAILABLE = r104;
        f410435a = new IMConstants$NetworkLevel[]{r100, r101, r102, r103, r104};
    }

    public static IMConstants$NetworkLevel[] values() {
        return (IMConstants$NetworkLevel[]) f410435a.clone();
    }

    public int getValue() {
        return this.status;
    }

    public static IMConstants$NetworkLevel forNumber(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return EXCELLENT;
    L15:
        return SERVICE_UNAVAILABLE;
    L17:
        return NET_UNAVAILABLE;
    L19:
        return WEAK;
    L21:
        return EVALUATING;
    L23:
        return EXCELLENT;
    }

    public static IMConstants$NetworkLevel valueOf(String r100) {
        return (IMConstants$NetworkLevel) a.a(IMConstants$NetworkLevel.class, r100);
    }

    public IMConstants$NetworkLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
