package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.platform.model.SlashMentionConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/SlashPanelContent;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", "QUOTA", "PROJECT", "SKILL", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SlashPanelContent extends Enum<SlashPanelContent> {
    public static final a Companion = null;
    public static final SlashPanelContent PROJECT = null;
    public static final SlashPanelContent QUOTA = null;
    public static final SlashPanelContent SKILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlashPanelContent[] f298689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298690b = null;
    private final String configValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SlashPanelContent> getEntries() {
        return f298690b;
    }

    static {
        SlashPanelContent r100 = new SlashPanelContent("QUOTA", 0, SlashMentionConfig.SLASH_CONTENT_QUOTA);
        QUOTA = r100;
        SlashPanelContent r101 = new SlashPanelContent("PROJECT", 1, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        PROJECT = r101;
        SlashPanelContent r102 = new SlashPanelContent("SKILL", 2, SlashMentionConfig.SLASH_CONTENT_SKILL);
        SKILL = r102;
        SlashPanelContent[] r103 = {r100, r101, r102};
        f298689a = r103;
        f298690b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static SlashPanelContent[] values() {
        return (SlashPanelContent[]) f298689a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static SlashPanelContent valueOf(String r100) {
        return (SlashPanelContent) r27.a.a(SlashPanelContent.class, r100);
    }

    public SlashPanelContent(String r100, int r101, String r102) {
        super(r100, r101);
        this.configValue = r102;
    }
}
