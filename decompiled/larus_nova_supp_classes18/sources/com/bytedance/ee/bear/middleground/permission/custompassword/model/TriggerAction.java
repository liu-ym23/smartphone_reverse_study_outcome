package com.bytedance.ee.bear.middleground.permission.custompassword.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/TriggerAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLEAR", "LOSE_FOCUS", "DEFAULT", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TriggerAction extends Enum<TriggerAction> {
    public static final TriggerAction CLEAR = null;
    public static final TriggerAction DEFAULT = null;
    public static final TriggerAction LOSE_FOCUS = null;
    public static final /* synthetic */ TriggerAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TriggerAction> getEntries() {
        return b;
    }

    static {
        TriggerAction r0 = new TriggerAction("CLEAR", 0);
        CLEAR = r0;
        TriggerAction r1 = new TriggerAction("LOSE_FOCUS", 1);
        LOSE_FOCUS = r1;
        TriggerAction r3 = new TriggerAction("DEFAULT", 2);
        DEFAULT = r3;
        TriggerAction[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TriggerAction[] values() {
        return (TriggerAction[]) a.clone();
    }

    public static TriggerAction valueOf(String r1) {
        return (TriggerAction) a.a(TriggerAction.class, r1);
    }

    public TriggerAction(String r1, int r2) {
        super(r1, r2);
    }
}
