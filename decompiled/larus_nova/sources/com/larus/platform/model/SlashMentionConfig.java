package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/SlashMentionConfig;", "", "enableSlash", "", "enableMention", "enableMessageRender", "slashContents", "", "", "mentionContents", "<init>", "(ZZZLjava/util/List;Ljava/util/List;)V", "getEnableSlash", "()Z", "getEnableMention", "getEnableMessageRender", "getSlashContents", "()Ljava/util/List;", "getMentionContents", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlashMentionConfig {
    public static final a Companion = null;
    public static final List<String> DEFAULT_MENTION_CONTENTS = null;
    public static final List<String> DEFAULT_SLASH_CONTENTS = null;
    public static final String MENTION_CONTENT_ADD = "add";
    public static final String MENTION_CONTENT_ATTACHMENT = "attachment";
    public static final String MENTION_CONTENT_CONTACT = "contact";
    public static final String MENTION_CONTENT_CONVERSATION = "conversation";
    public static final String MENTION_CONTENT_DRIVE = "drive";
    public static final String SLASH_CONTENT_PROJECT = "project";
    public static final String SLASH_CONTENT_QUOTA = "quota";
    public static final String SLASH_CONTENT_SKILL = "skill";

    @SerializedName("enable_mention")
    private final boolean enableMention;

    @SerializedName("enable_message_render")
    private final boolean enableMessageRender;

    @SerializedName("enable_slash")
    private final boolean enableSlash;

    @SerializedName("mention_contents")
    private final List<String> mentionContents;

    @SerializedName("slash_contents")
    private final List<String> slashContents;

    public static final class a {
        public a() {
        }
    }

    public SlashMentionConfig() {
        this(false, false, false, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlashMentionConfig copy$default(SlashMentionConfig r100, boolean r101, boolean r102, boolean r103, List r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableSlash;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enableMention;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.enableMessageRender;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.slashContents;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.mentionContents;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableSlash;
    }

    public final boolean component2() {
        return this.enableMention;
    }

    public final boolean component3() {
        return this.enableMessageRender;
    }

    public final List<String> component4() {
        return this.slashContents;
    }

    public final List<String> component5() {
        return this.mentionContents;
    }

    public final SlashMentionConfig copy(boolean r100, boolean r101, boolean r110, List<String> r111, List<String> r112) {
        return new SlashMentionConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SlashMentionConfig) == true) goto L8;
        return false;
    L8:
        SlashMentionConfig r101 = (SlashMentionConfig) r100;
        if (this.enableSlash == r101.enableSlash) goto L12;
        return false;
    L12:
        if (this.enableMention == r101.enableMention) goto L15;
        return false;
    L15:
        if (this.enableMessageRender == r101.enableMessageRender) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slashContents, r101.slashContents) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mentionContents, r101.mentionContents) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableSlash == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMention == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableMessageRender == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        List<String> r106 = this.slashContents;
        int r107 = 0;
        if (r106 != null) goto L17;
        int r108 = 0;
    L18:
        int r109 = (r105 + r108) * 31;
        List<String> r110 = this.mentionContents;
        if (r110 == null) goto L23;
        r107 = r110.hashCode();
    L23:
        return r109 + r107;
    L17:
        r108 = r106.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SlashMentionConfig(enableSlash=" + this.enableSlash + ", enableMention=" + this.enableMention + ", enableMessageRender=" + this.enableMessageRender + ", slashContents=" + this.slashContents + ", mentionContents=" + this.mentionContents + ')';
    }

    static {
        Companion = new a();
        DEFAULT_SLASH_CONTENTS = CollectionsKt.listOf(new String[]{SLASH_CONTENT_QUOTA, SLASH_CONTENT_PROJECT, SLASH_CONTENT_SKILL});
        DEFAULT_MENTION_CONTENTS = CollectionsKt.listOf(new String[]{"add", MENTION_CONTENT_ATTACHMENT, "contact", "drive", "conversation"});
    }

    public final boolean getEnableMention() {
        return this.enableMention;
    }

    public final boolean getEnableMessageRender() {
        return this.enableMessageRender;
    }

    public final boolean getEnableSlash() {
        return this.enableSlash;
    }

    public final List<String> getMentionContents() {
        return this.mentionContents;
    }

    public final List<String> getSlashContents() {
        return this.slashContents;
    }

    public SlashMentionConfig(boolean r100, boolean r101, boolean r102, List<String> r103, List<String> r104) {
        this.enableSlash = r100;
        this.enableMention = r101;
        this.enableMessageRender = r102;
        this.slashContents = r103;
        this.mentionContents = r104;
    }

    public /* synthetic */ SlashMentionConfig(boolean r100, boolean r101, boolean r102, List r103, List r104, int r105, DefaultConstructorMarker r110) {
        boolean r106 = true;
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = true;
    L7:
        if ((r105 & 2) == 0) goto L9;
        boolean r107 = true;
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        r103 = DEFAULT_SLASH_CONTENTS;
    L17:
        List r108 = r103;
        if ((r105 & 16) == 0) goto L20;
        r104 = DEFAULT_MENTION_CONTENTS;
    L20:
        boolean r109 = r111;
        boolean r112 = r107;
        boolean r113 = r106;
        this(r109, r112, r113, r108, r104);
        return;
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
