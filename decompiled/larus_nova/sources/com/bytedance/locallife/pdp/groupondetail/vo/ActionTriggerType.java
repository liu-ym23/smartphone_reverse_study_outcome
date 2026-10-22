package com.bytedance.locallife.pdp.groupondetail.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/vo/ActionTriggerType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CLICK", "EXPOSE", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum ActionTriggerType extends Enum<ActionTriggerType> {
    public static final ActionTriggerType CLICK = null;
    public static final ActionTriggerType EXPOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionTriggerType[] f261457a = null;
    private final String type;

    public static ActionTriggerType valueOf(String r100) {
        return (ActionTriggerType) a.a(ActionTriggerType.class, r100);
    }

    public static ActionTriggerType[] values() {
        return (ActionTriggerType[]) f261457a.clone();
    }

    static {
        ActionTriggerType r100 = new ActionTriggerType("CLICK", 0, "click");
        CLICK = r100;
        ActionTriggerType r101 = new ActionTriggerType("EXPOSE", 1, "expose");
        EXPOSE = r101;
        f261457a = new ActionTriggerType[]{r100, r101};
    }

    public final String getType() {
        return this.type;
    }

    public ActionTriggerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
