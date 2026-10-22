package com.larus.asr.config.builder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/config/builder/ChatSpeakerScene;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "O", "FeiShu", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSpeakerScene extends Enum<ChatSpeakerScene> {
    public static final ChatSpeakerScene Default = null;
    public static final ChatSpeakerScene FeiShu = null;
    public static final ChatSpeakerScene O = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSpeakerScene[] f287229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287230b = null;

    public static EnumEntries<ChatSpeakerScene> getEntries() {
        return f287230b;
    }

    static {
        ChatSpeakerScene r100 = new ChatSpeakerScene("Default", 0);
        Default = r100;
        ChatSpeakerScene r101 = new ChatSpeakerScene("O", 1);
        O = r101;
        ChatSpeakerScene r102 = new ChatSpeakerScene("FeiShu", 2);
        FeiShu = r102;
        ChatSpeakerScene[] r103 = {r100, r101, r102};
        f287229a = r103;
        f287230b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChatSpeakerScene[] values() {
        return (ChatSpeakerScene[]) f287229a.clone();
    }

    public static ChatSpeakerScene valueOf(String r100) {
        return (ChatSpeakerScene) a.a(ChatSpeakerScene.class, r100);
    }

    public ChatSpeakerScene(String r100, int r101) {
        super(r100, r101);
    }
}
