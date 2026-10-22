package com.obric.assistant.ability.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/ability/audio/ExitClickSpeakerType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ASR_END", "TIMEOUT", "MANUAL", "RESTART", "INTERRUPT", "MOTIVE_END", "SEND_MESSAGE", "DESTROY", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExitClickSpeakerType extends Enum<ExitClickSpeakerType> {
    public static final ExitClickSpeakerType ASR_END = null;
    public static final ExitClickSpeakerType DESTROY = null;
    public static final ExitClickSpeakerType INTERRUPT = null;
    public static final ExitClickSpeakerType MANUAL = null;
    public static final ExitClickSpeakerType MOTIVE_END = null;
    public static final ExitClickSpeakerType RESTART = null;
    public static final ExitClickSpeakerType SEND_MESSAGE = null;
    public static final ExitClickSpeakerType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExitClickSpeakerType[] f385217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385218b = null;

    public static EnumEntries<ExitClickSpeakerType> getEntries() {
        return f385218b;
    }

    static {
        ExitClickSpeakerType r100 = new ExitClickSpeakerType("ASR_END", 0);
        ASR_END = r100;
        ExitClickSpeakerType r101 = new ExitClickSpeakerType("TIMEOUT", 1);
        TIMEOUT = r101;
        ExitClickSpeakerType r102 = new ExitClickSpeakerType("MANUAL", 2);
        MANUAL = r102;
        ExitClickSpeakerType r103 = new ExitClickSpeakerType("RESTART", 3);
        RESTART = r103;
        ExitClickSpeakerType r104 = new ExitClickSpeakerType("INTERRUPT", 4);
        INTERRUPT = r104;
        ExitClickSpeakerType r105 = new ExitClickSpeakerType("MOTIVE_END", 5);
        MOTIVE_END = r105;
        ExitClickSpeakerType r110 = new ExitClickSpeakerType("SEND_MESSAGE", 6);
        SEND_MESSAGE = r110;
        ExitClickSpeakerType r111 = new ExitClickSpeakerType("DESTROY", 7);
        DESTROY = r111;
        ExitClickSpeakerType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f385217a = r112;
        f385218b = EnumEntriesKt.enumEntries(r112);
    }

    public static ExitClickSpeakerType[] values() {
        return (ExitClickSpeakerType[]) f385217a.clone();
    }

    public static ExitClickSpeakerType valueOf(String r100) {
        return (ExitClickSpeakerType) a.a(ExitClickSpeakerType.class, r100);
    }

    public ExitClickSpeakerType(String r100, int r101) {
        super(r100, r101);
    }
}
