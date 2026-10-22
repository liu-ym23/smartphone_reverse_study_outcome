package com.ss.android.lark.chat.dlp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/dlp/BehaviorOnClickDisableAction;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SHOW_TOAST", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BehaviorOnClickDisableAction extends Enum<BehaviorOnClickDisableAction> {
    public static final BehaviorOnClickDisableAction SHOW_TOAST = null;
    public static final BehaviorOnClickDisableAction UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BehaviorOnClickDisableAction[] f415066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415067b = null;

    public static EnumEntries<BehaviorOnClickDisableAction> getEntries() {
        return f415067b;
    }

    static {
        BehaviorOnClickDisableAction r100 = new BehaviorOnClickDisableAction("UNKNOWN", 0);
        UNKNOWN = r100;
        BehaviorOnClickDisableAction r101 = new BehaviorOnClickDisableAction("SHOW_TOAST", 1);
        SHOW_TOAST = r101;
        BehaviorOnClickDisableAction[] r102 = {r100, r101};
        f415066a = r102;
        f415067b = EnumEntriesKt.enumEntries(r102);
    }

    public static BehaviorOnClickDisableAction[] values() {
        return (BehaviorOnClickDisableAction[]) f415066a.clone();
    }

    public static BehaviorOnClickDisableAction valueOf(String r100) {
        return (BehaviorOnClickDisableAction) r27.a.a(BehaviorOnClickDisableAction.class, r100);
    }

    public BehaviorOnClickDisableAction(String r100, int r101) {
        super(r100, r101);
    }
}
