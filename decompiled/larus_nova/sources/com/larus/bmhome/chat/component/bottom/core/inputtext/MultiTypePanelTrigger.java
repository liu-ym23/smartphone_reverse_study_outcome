package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/MultiTypePanelTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "MENTION", "SLASH", "EXTERNAL_SKILL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultiTypePanelTrigger extends Enum<MultiTypePanelTrigger> {
    public static final MultiTypePanelTrigger EXTERNAL_SKILL = null;
    public static final MultiTypePanelTrigger MENTION = null;
    public static final MultiTypePanelTrigger SLASH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiTypePanelTrigger[] f298665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298666b = null;

    public static EnumEntries<MultiTypePanelTrigger> getEntries() {
        return f298666b;
    }

    static {
        MultiTypePanelTrigger r100 = new MultiTypePanelTrigger("MENTION", 0);
        MENTION = r100;
        MultiTypePanelTrigger r101 = new MultiTypePanelTrigger("SLASH", 1);
        SLASH = r101;
        MultiTypePanelTrigger r102 = new MultiTypePanelTrigger("EXTERNAL_SKILL", 2);
        EXTERNAL_SKILL = r102;
        MultiTypePanelTrigger[] r103 = {r100, r101, r102};
        f298665a = r103;
        f298666b = EnumEntriesKt.enumEntries(r103);
    }

    public static MultiTypePanelTrigger[] values() {
        return (MultiTypePanelTrigger[]) f298665a.clone();
    }

    public static MultiTypePanelTrigger valueOf(String r100) {
        return (MultiTypePanelTrigger) r27.a.a(MultiTypePanelTrigger.class, r100);
    }

    public MultiTypePanelTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
