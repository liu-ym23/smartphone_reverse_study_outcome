package com.obric.aiagent.assistant_card.provider_core.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/assistant_card/provider_core/bean/ActionType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ACTION_ON_CLICK", "ACTION_ON_LONG_CLICK", "assistant-card-provider-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType ACTION_ON_CLICK = null;
    public static final ActionType ACTION_ON_LONG_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f384638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384639b = null;
    private final String type;

    public static EnumEntries<ActionType> getEntries() {
        return f384639b;
    }

    static {
        ActionType r100 = new ActionType("ACTION_ON_CLICK", 0, "on_click");
        ACTION_ON_CLICK = r100;
        ActionType r101 = new ActionType("ACTION_ON_LONG_CLICK", 1, "on_long_click");
        ACTION_ON_LONG_CLICK = r101;
        ActionType[] r102 = {r100, r101};
        f384638a = r102;
        f384639b = EnumEntriesKt.enumEntries(r102);
    }

    public static ActionType[] values() {
        return (ActionType[]) f384638a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) a.a(ActionType.class, r100);
    }

    public ActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
