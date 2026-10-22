package com.bytedance.ee.bear.middleground.permission.custompassword.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/TriggerAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLEAR", "LOSE_FOCUS", "DEFAULT", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TriggerAction extends Enum<TriggerAction> {
    public static final TriggerAction CLEAR = null;
    public static final TriggerAction DEFAULT = null;
    public static final TriggerAction LOSE_FOCUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerAction[] f233824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233825b = null;

    public static EnumEntries<TriggerAction> getEntries() {
        return f233825b;
    }

    static {
        TriggerAction r100 = new TriggerAction("CLEAR", 0);
        CLEAR = r100;
        TriggerAction r101 = new TriggerAction("LOSE_FOCUS", 1);
        LOSE_FOCUS = r101;
        TriggerAction r102 = new TriggerAction("DEFAULT", 2);
        DEFAULT = r102;
        TriggerAction[] r103 = {r100, r101, r102};
        f233824a = r103;
        f233825b = EnumEntriesKt.enumEntries(r103);
    }

    public static TriggerAction[] values() {
        return (TriggerAction[]) f233824a.clone();
    }

    public static TriggerAction valueOf(String r100) {
        return (TriggerAction) a.a(TriggerAction.class, r100);
    }

    public TriggerAction(String r100, int r101) {
        super(r100, r101);
    }
}
