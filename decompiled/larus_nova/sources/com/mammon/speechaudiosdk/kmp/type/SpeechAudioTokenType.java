package com.mammon.speechaudiosdk.kmp.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TOKEN_TO_B", "TOKEN_TO_C_D", "TOKEN_TO_B_MIXED", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechAudioTokenType extends Enum<SpeechAudioTokenType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpeechAudioTokenType[] $VALUES = null;
    public static final SpeechAudioTokenType TOKEN_TO_B = null;
    public static final SpeechAudioTokenType TOKEN_TO_B_MIXED = null;
    public static final SpeechAudioTokenType TOKEN_TO_C_D = null;
    private final int value;

    private static final /* synthetic */ SpeechAudioTokenType[] $values() {
        return new SpeechAudioTokenType[]{TOKEN_TO_B, TOKEN_TO_C_D, TOKEN_TO_B_MIXED};
    }

    public static EnumEntries<SpeechAudioTokenType> getEntries() {
        return $ENTRIES;
    }

    static {
        TOKEN_TO_B = new SpeechAudioTokenType("TOKEN_TO_B", 0, 0);
        TOKEN_TO_C_D = new SpeechAudioTokenType("TOKEN_TO_C_D", 1, 1);
        TOKEN_TO_B_MIXED = new SpeechAudioTokenType("TOKEN_TO_B_MIXED", 2, 2);
        SpeechAudioTokenType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SpeechAudioTokenType[] values() {
        return (SpeechAudioTokenType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeechAudioTokenType valueOf(String r100) {
        return (SpeechAudioTokenType) a.a(SpeechAudioTokenType.class, r100);
    }

    private SpeechAudioTokenType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
