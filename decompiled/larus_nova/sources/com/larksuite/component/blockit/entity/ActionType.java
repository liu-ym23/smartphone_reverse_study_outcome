package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: classes24.dex */
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType HashTag = null;
    public static final ActionType Todo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f282977a = null;
    private int value;

    static {
        ActionType r100 = new ActionType("HashTag", 0, 1);
        HashTag = r100;
        ActionType r101 = new ActionType("Todo", 1, 2);
        Todo = r101;
        f282977a = new ActionType[]{r100, r101};
    }

    public static ActionType[] values() {
        return (ActionType[]) f282977a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ActionType forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return Todo;
    L11:
        return HashTag;
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) r27.a.a(ActionType.class, r100);
    }

    public static ActionType valueOf(int r100) {
        return forNumber(r100);
    }

    public ActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
