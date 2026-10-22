package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelSection;", "", "<init>", "(Ljava/lang/String;I)V", "ATTACHMENT", "CONTACT", "GROUP", "DRIVE", "CONVERSATION", "SKILL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MentionPanelSection extends Enum<MentionPanelSection> {
    public static final MentionPanelSection ATTACHMENT = null;
    public static final MentionPanelSection CONTACT = null;
    public static final MentionPanelSection CONVERSATION = null;
    public static final MentionPanelSection DRIVE = null;
    public static final MentionPanelSection GROUP = null;
    public static final MentionPanelSection SKILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionPanelSection[] f298866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298867b = null;

    public static EnumEntries<MentionPanelSection> getEntries() {
        return f298867b;
    }

    static {
        MentionPanelSection r100 = new MentionPanelSection("ATTACHMENT", 0);
        ATTACHMENT = r100;
        MentionPanelSection r101 = new MentionPanelSection("CONTACT", 1);
        CONTACT = r101;
        MentionPanelSection r102 = new MentionPanelSection("GROUP", 2);
        GROUP = r102;
        MentionPanelSection r103 = new MentionPanelSection("DRIVE", 3);
        DRIVE = r103;
        MentionPanelSection r104 = new MentionPanelSection("CONVERSATION", 4);
        CONVERSATION = r104;
        MentionPanelSection r105 = new MentionPanelSection("SKILL", 5);
        SKILL = r105;
        MentionPanelSection[] r110 = {r100, r101, r102, r103, r104, r105};
        f298866a = r110;
        f298867b = EnumEntriesKt.enumEntries(r110);
    }

    public static MentionPanelSection[] values() {
        return (MentionPanelSection[]) f298866a.clone();
    }

    public static MentionPanelSection valueOf(String r100) {
        return (MentionPanelSection) r27.a.a(MentionPanelSection.class, r100);
    }

    public MentionPanelSection(String r100, int r101) {
        super(r100, r101);
    }
}
