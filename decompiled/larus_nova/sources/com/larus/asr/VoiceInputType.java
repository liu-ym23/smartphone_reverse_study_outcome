package com.larus.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/asr/VoiceInputType;", "", "<init>", "(Ljava/lang/String;I)V", "TouchSpeaker", "ClickSpeaker", "ThirdPartySpeaker", "DoraVoiceSpeaker", "DoraRadioSpeaker", "ObricContinuousTalk", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceInputType extends Enum<VoiceInputType> {
    public static final VoiceInputType ClickSpeaker = null;
    public static final a Companion = null;
    public static final VoiceInputType DoraRadioSpeaker = null;
    public static final VoiceInputType DoraVoiceSpeaker = null;
    public static final VoiceInputType ObricContinuousTalk = null;
    public static final VoiceInputType ThirdPartySpeaker = null;
    public static final VoiceInputType TouchSpeaker = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceInputType[] f287162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287163b = null;

    public static final class a {
        public a() {
        }

        public static boolean a(VoiceInputType r100) {
            Intrinsics.checkNotNullParameter(r100, "voiceInputType");
            if (r100 != VoiceInputType.ClickSpeaker) goto L5;
        L10:
            return true;
        L5:
            if (r100 == VoiceInputType.ThirdPartySpeaker) goto L10;
            if (r100 == VoiceInputType.DoraVoiceSpeaker) goto L10;
            return false;
        }

        public static boolean b(VoiceInputType r100) {
            if (r100 != VoiceInputType.TouchSpeaker) goto L5;
        L8:
            return true;
        L5:
            if (r100 == VoiceInputType.DoraRadioSpeaker) goto L8;
            return false;
        }
    }

    public static EnumEntries<VoiceInputType> getEntries() {
        return f287163b;
    }

    static {
        VoiceInputType r100 = new VoiceInputType("TouchSpeaker", 0);
        TouchSpeaker = r100;
        VoiceInputType r101 = new VoiceInputType("ClickSpeaker", 1);
        ClickSpeaker = r101;
        VoiceInputType r102 = new VoiceInputType("ThirdPartySpeaker", 2);
        ThirdPartySpeaker = r102;
        VoiceInputType r103 = new VoiceInputType("DoraVoiceSpeaker", 3);
        DoraVoiceSpeaker = r103;
        VoiceInputType r104 = new VoiceInputType("DoraRadioSpeaker", 4);
        DoraRadioSpeaker = r104;
        VoiceInputType r105 = new VoiceInputType("ObricContinuousTalk", 5);
        ObricContinuousTalk = r105;
        VoiceInputType[] r110 = {r100, r101, r102, r103, r104, r105};
        f287162a = r110;
        f287163b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static VoiceInputType[] values() {
        return (VoiceInputType[]) f287162a.clone();
    }

    public static VoiceInputType valueOf(String r100) {
        return (VoiceInputType) r27.a.a(VoiceInputType.class, r100);
    }

    public VoiceInputType(String r100, int r101) {
        super(r100, r101);
    }
}
