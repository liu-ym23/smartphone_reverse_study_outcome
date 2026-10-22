package com.bytedance.ee.bear;

/* JADX INFO: loaded from: classes15.dex */
public final enum NodeType extends Enum<NodeType> {
    public static final NodeType ENTITY = null;
    public static final NodeType SHORT_CUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeType[] f206180a = null;
    int value;

    static {
        NodeType r100 = new NodeType("SHORT_CUT", 0, 1);
        SHORT_CUT = r100;
        NodeType r101 = new NodeType("ENTITY", 1, 0);
        ENTITY = r101;
        f206180a = new NodeType[]{r100, r101};
    }

    public static NodeType[] values() {
        return (NodeType[]) f206180a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static boolean isShortcut(int r100) {
        if (r100 != SHORT_CUT.value) goto L5;
        return true;
    L5:
        return false;
    }

    public static NodeType valueOf(String r100) {
        return (NodeType) r27.a.a(NodeType.class, r100);
    }

    public NodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
