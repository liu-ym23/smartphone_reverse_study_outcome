package com.larus.bmhome.view.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/actionbar/ActionbarDataType;", "", "typeVal", "", "<init>", "(Ljava/lang/String;II)V", "getTypeVal", "()I", "ORDER", "BOT", "VIEW_TYPE_EXPERT_SWITCH", "VIEW_TYPE_GPT_4_SWITCH", "VIEW_TYPE_ACTION_BAR_HEADER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionbarDataType extends Enum<ActionbarDataType> {
    public static final ActionbarDataType BOT = null;
    public static final ActionbarDataType ORDER = null;
    public static final ActionbarDataType VIEW_TYPE_ACTION_BAR_HEADER = null;
    public static final ActionbarDataType VIEW_TYPE_EXPERT_SWITCH = null;
    public static final ActionbarDataType VIEW_TYPE_GPT_4_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionbarDataType[] f315617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315618b = null;
    private final int typeVal;

    public static EnumEntries<ActionbarDataType> getEntries() {
        return f315618b;
    }

    static {
        ActionbarDataType r100 = new ActionbarDataType("ORDER", 0, 0);
        ORDER = r100;
        ActionbarDataType r101 = new ActionbarDataType("BOT", 1, 1);
        BOT = r101;
        ActionbarDataType r102 = new ActionbarDataType("VIEW_TYPE_EXPERT_SWITCH", 2, -3);
        VIEW_TYPE_EXPERT_SWITCH = r102;
        ActionbarDataType r103 = new ActionbarDataType("VIEW_TYPE_GPT_4_SWITCH", 3, -2);
        VIEW_TYPE_GPT_4_SWITCH = r103;
        ActionbarDataType r104 = new ActionbarDataType("VIEW_TYPE_ACTION_BAR_HEADER", 4, -1);
        VIEW_TYPE_ACTION_BAR_HEADER = r104;
        ActionbarDataType[] r105 = {r100, r101, r102, r103, r104};
        f315617a = r105;
        f315618b = EnumEntriesKt.enumEntries(r105);
    }

    public static ActionbarDataType[] values() {
        return (ActionbarDataType[]) f315617a.clone();
    }

    public final int getTypeVal() {
        return this.typeVal;
    }

    public static ActionbarDataType valueOf(String r100) {
        return (ActionbarDataType) a.a(ActionbarDataType.class, r100);
    }

    public ActionbarDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeVal = r102;
    }
}
