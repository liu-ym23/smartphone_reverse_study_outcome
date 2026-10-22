package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.platform.model.SlashMentionConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/MentionPanelContent;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", "ADD", "ATTACHMENT", "CONTACT", "DRIVE", "CONVERSATION", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MentionPanelContent extends Enum<MentionPanelContent> {
    public static final MentionPanelContent ADD = null;
    public static final MentionPanelContent ATTACHMENT = null;
    public static final MentionPanelContent CONTACT = null;
    public static final MentionPanelContent CONVERSATION = null;
    public static final a Companion = null;
    public static final MentionPanelContent DRIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionPanelContent[] f298627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298628b = null;
    private final String configValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MentionPanelContent> getEntries() {
        return f298628b;
    }

    static {
        MentionPanelContent r100 = new MentionPanelContent("ADD", 0, "add");
        ADD = r100;
        MentionPanelContent r101 = new MentionPanelContent("ATTACHMENT", 1, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        ATTACHMENT = r101;
        MentionPanelContent r102 = new MentionPanelContent("CONTACT", 2, "contact");
        CONTACT = r102;
        MentionPanelContent r103 = new MentionPanelContent("DRIVE", 3, "drive");
        DRIVE = r103;
        MentionPanelContent r104 = new MentionPanelContent("CONVERSATION", 4, "conversation");
        CONVERSATION = r104;
        MentionPanelContent[] r105 = {r100, r101, r102, r103, r104};
        f298627a = r105;
        f298628b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MentionPanelContent[] values() {
        return (MentionPanelContent[]) f298627a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static MentionPanelContent valueOf(String r100) {
        return (MentionPanelContent) r27.a.a(MentionPanelContent.class, r100);
    }

    public MentionPanelContent(String r100, int r101, String r102) {
        super(r100, r101);
        this.configValue = r102;
    }
}
