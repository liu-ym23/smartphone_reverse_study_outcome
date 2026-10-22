package com.larus.asr.config.builder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/asr/config/builder/ChatSpeakerElementKey;", "", "<init>", "(Ljava/lang/String;I)V", "Tips", "Visualizer", "Shadow", "CancelArea", "ActionArea", "FullShadow", "Blur", "VisualizerBackground", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSpeakerElementKey extends Enum<ChatSpeakerElementKey> {
    public static final ChatSpeakerElementKey ActionArea = null;
    public static final ChatSpeakerElementKey Blur = null;
    public static final ChatSpeakerElementKey CancelArea = null;
    public static final ChatSpeakerElementKey FullShadow = null;
    public static final ChatSpeakerElementKey Shadow = null;
    public static final ChatSpeakerElementKey Tips = null;
    public static final ChatSpeakerElementKey Visualizer = null;
    public static final ChatSpeakerElementKey VisualizerBackground = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSpeakerElementKey[] f287225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287226b = null;

    public static EnumEntries<ChatSpeakerElementKey> getEntries() {
        return f287226b;
    }

    static {
        ChatSpeakerElementKey r100 = new ChatSpeakerElementKey("Tips", 0);
        Tips = r100;
        ChatSpeakerElementKey r101 = new ChatSpeakerElementKey("Visualizer", 1);
        Visualizer = r101;
        ChatSpeakerElementKey r102 = new ChatSpeakerElementKey("Shadow", 2);
        Shadow = r102;
        ChatSpeakerElementKey r103 = new ChatSpeakerElementKey("CancelArea", 3);
        CancelArea = r103;
        ChatSpeakerElementKey r104 = new ChatSpeakerElementKey("ActionArea", 4);
        ActionArea = r104;
        ChatSpeakerElementKey r105 = new ChatSpeakerElementKey("FullShadow", 5);
        FullShadow = r105;
        ChatSpeakerElementKey r110 = new ChatSpeakerElementKey("Blur", 6);
        Blur = r110;
        ChatSpeakerElementKey r111 = new ChatSpeakerElementKey("VisualizerBackground", 7);
        VisualizerBackground = r111;
        ChatSpeakerElementKey[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f287225a = r112;
        f287226b = EnumEntriesKt.enumEntries(r112);
    }

    public static ChatSpeakerElementKey[] values() {
        return (ChatSpeakerElementKey[]) f287225a.clone();
    }

    public static ChatSpeakerElementKey valueOf(String r100) {
        return (ChatSpeakerElementKey) a.a(ChatSpeakerElementKey.class, r100);
    }

    public ChatSpeakerElementKey(String r100, int r101) {
        super(r100, r101);
    }
}
