package com.larus.asr.config.builder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/config/builder/ChatSpeakerGesturePhase;", "", "<init>", "(Ljava/lang/String;I)V", "Move", "Release", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSpeakerGesturePhase extends Enum<ChatSpeakerGesturePhase> {
    public static final ChatSpeakerGesturePhase Move = null;
    public static final ChatSpeakerGesturePhase Release = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSpeakerGesturePhase[] f287227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287228b = null;

    public static EnumEntries<ChatSpeakerGesturePhase> getEntries() {
        return f287228b;
    }

    static {
        ChatSpeakerGesturePhase r100 = new ChatSpeakerGesturePhase("Move", 0);
        Move = r100;
        ChatSpeakerGesturePhase r101 = new ChatSpeakerGesturePhase("Release", 1);
        Release = r101;
        ChatSpeakerGesturePhase[] r102 = {r100, r101};
        f287227a = r102;
        f287228b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatSpeakerGesturePhase[] values() {
        return (ChatSpeakerGesturePhase[]) f287227a.clone();
    }

    public static ChatSpeakerGesturePhase valueOf(String r100) {
        return (ChatSpeakerGesturePhase) a.a(ChatSpeakerGesturePhase.class, r100);
    }

    public ChatSpeakerGesturePhase(String r100, int r101) {
        super(r100, r101);
    }
}
