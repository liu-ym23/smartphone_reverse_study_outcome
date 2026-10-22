package com.ss.android.lark.chat.message.menu.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/PanelActionType;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_ACTION", "PARTIAL_ACTION", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PanelActionType extends Enum<PanelActionType> {
    public static final PanelActionType ALL_ACTION = null;
    public static final PanelActionType PARTIAL_ACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelActionType[] f415663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415664b = null;

    public static EnumEntries<PanelActionType> getEntries() {
        return f415664b;
    }

    static {
        PanelActionType r100 = new PanelActionType("ALL_ACTION", 0);
        ALL_ACTION = r100;
        PanelActionType r101 = new PanelActionType("PARTIAL_ACTION", 1);
        PARTIAL_ACTION = r101;
        PanelActionType[] r102 = {r100, r101};
        f415663a = r102;
        f415664b = EnumEntriesKt.enumEntries(r102);
    }

    public static PanelActionType[] values() {
        return (PanelActionType[]) f415663a.clone();
    }

    public static PanelActionType valueOf(String r100) {
        return (PanelActionType) r27.a.a(PanelActionType.class, r100);
    }

    public PanelActionType(String r100, int r101) {
        super(r100, r101);
    }
}
