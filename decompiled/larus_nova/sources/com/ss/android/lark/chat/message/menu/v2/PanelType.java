package com.ss.android.lark.chat.message.menu.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "", "<init>", "(Ljava/lang/String;I)V", "EMOJI", "ACTION", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType ACTION = null;
    public static final PanelType EMOJI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelType[] f415665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415666b = null;

    public static EnumEntries<PanelType> getEntries() {
        return f415666b;
    }

    static {
        PanelType r100 = new PanelType("EMOJI", 0);
        EMOJI = r100;
        PanelType r101 = new PanelType("ACTION", 1);
        ACTION = r101;
        PanelType[] r102 = {r100, r101};
        f415665a = r102;
        f415666b = EnumEntriesKt.enumEntries(r102);
    }

    public static PanelType[] values() {
        return (PanelType[]) f415665a.clone();
    }

    public static PanelType valueOf(String r100) {
        return (PanelType) r27.a.a(PanelType.class, r100);
    }

    public PanelType(String r100, int r101) {
        super(r100, r101);
    }
}
