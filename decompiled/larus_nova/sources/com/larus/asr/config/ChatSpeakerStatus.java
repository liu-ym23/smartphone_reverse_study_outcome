package com.larus.asr.config;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/asr/config/ChatSpeakerStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Recording", "HandsfreeLocked", "Cancel", "Speech", "ImAsr", "toLegacyStatus", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSpeakerStatus extends Enum<ChatSpeakerStatus> {
    public static final ChatSpeakerStatus Cancel = null;
    public static final ChatSpeakerStatus HandsfreeLocked = null;

    @Deprecated(message = "Use Normal or Recording for new Element state.")
    public static final ChatSpeakerStatus ImAsr = null;
    public static final ChatSpeakerStatus Normal = null;
    public static final ChatSpeakerStatus Recording = null;
    public static final ChatSpeakerStatus Speech = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSpeakerStatus[] f287220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287221b = null;

    /* JADX INFO: loaded from: classes24.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f287222a = null;

        static {
            int[] r100 = new int[ChatSpeakerStatus.values().length];
            r100[ChatSpeakerStatus.Cancel.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ChatSpeakerStatus.Speech.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f287222a = r100;
        }
    }

    public static EnumEntries<ChatSpeakerStatus> getEntries() {
        return f287221b;
    }

    static {
        ChatSpeakerStatus r100 = new ChatSpeakerStatus("Normal", 0);
        Normal = r100;
        ChatSpeakerStatus r101 = new ChatSpeakerStatus("Recording", 1);
        Recording = r101;
        ChatSpeakerStatus r102 = new ChatSpeakerStatus("HandsfreeLocked", 2);
        HandsfreeLocked = r102;
        ChatSpeakerStatus r103 = new ChatSpeakerStatus("Cancel", 3);
        Cancel = r103;
        ChatSpeakerStatus r104 = new ChatSpeakerStatus("Speech", 4);
        Speech = r104;
        ChatSpeakerStatus r105 = new ChatSpeakerStatus("ImAsr", 5);
        ImAsr = r105;
        ChatSpeakerStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f287220a = r110;
        f287221b = EnumEntriesKt.enumEntries(r110);
    }

    public static ChatSpeakerStatus[] values() {
        return (ChatSpeakerStatus[]) f287220a.clone();
    }

    public final ChatSpeakerStatus toLegacyStatus() {
        int r100 = a.f287222a[ordinal()];
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return ImAsr;
    L11:
        return Speech;
    L9:
        return Cancel;
    }

    public static ChatSpeakerStatus valueOf(String r100) {
        return (ChatSpeakerStatus) r27.a.a(ChatSpeakerStatus.class, r100);
    }

    public ChatSpeakerStatus(String r100, int r101) {
        super(r100, r101);
    }
}
