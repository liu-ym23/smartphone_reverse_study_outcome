package com.ss.android.lark.voiceinput.api.data.config.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/config/record/PcmEncoding;", "", "<init>", "(Ljava/lang/String;I)V", "Pcm8Bit", "Pcm16Bit", "PcmFloat", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcmEncoding extends Enum<PcmEncoding> {
    public static final PcmEncoding Pcm16Bit = null;
    public static final PcmEncoding Pcm8Bit = null;
    public static final PcmEncoding PcmFloat = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PcmEncoding[] f445028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445029b = null;

    public static EnumEntries<PcmEncoding> getEntries() {
        return f445029b;
    }

    static {
        PcmEncoding r100 = new PcmEncoding("Pcm8Bit", 0);
        Pcm8Bit = r100;
        PcmEncoding r101 = new PcmEncoding("Pcm16Bit", 1);
        Pcm16Bit = r101;
        PcmEncoding r102 = new PcmEncoding("PcmFloat", 2);
        PcmFloat = r102;
        PcmEncoding[] r103 = {r100, r101, r102};
        f445028a = r103;
        f445029b = EnumEntriesKt.enumEntries(r103);
    }

    public static PcmEncoding[] values() {
        return (PcmEncoding[]) f445028a.clone();
    }

    public static PcmEncoding valueOf(String r100) {
        return (PcmEncoding) a.a(PcmEncoding.class, r100);
    }

    public PcmEncoding(String r100, int r101) {
        super(r100, r101);
    }
}
