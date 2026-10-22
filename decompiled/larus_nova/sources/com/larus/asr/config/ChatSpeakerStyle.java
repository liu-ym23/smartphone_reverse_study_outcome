package com.larus.asr.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/config/ChatSpeakerStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Speech", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSpeakerStyle extends Enum<ChatSpeakerStyle> {
    public static final ChatSpeakerStyle Normal = null;
    public static final ChatSpeakerStyle Speech = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSpeakerStyle[] f287223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287224b = null;

    public static EnumEntries<ChatSpeakerStyle> getEntries() {
        return f287224b;
    }

    static {
        ChatSpeakerStyle r100 = new ChatSpeakerStyle("Normal", 0);
        Normal = r100;
        ChatSpeakerStyle r101 = new ChatSpeakerStyle("Speech", 1);
        Speech = r101;
        ChatSpeakerStyle[] r102 = {r100, r101};
        f287223a = r102;
        f287224b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatSpeakerStyle[] values() {
        return (ChatSpeakerStyle[]) f287223a.clone();
    }

    public static ChatSpeakerStyle valueOf(String r100) {
        return (ChatSpeakerStyle) a.a(ChatSpeakerStyle.class, r100);
    }

    public ChatSpeakerStyle(String r100, int r101) {
        super(r100, r101);
    }
}
