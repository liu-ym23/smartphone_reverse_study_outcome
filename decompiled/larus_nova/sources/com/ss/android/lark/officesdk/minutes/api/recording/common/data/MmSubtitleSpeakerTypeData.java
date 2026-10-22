package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmSubtitleSpeakerTypeData;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", EffectConstants.NORMAL, "SCD_SPEAKER", "VOICE_PRINT_SPEAKER", "toString", "", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSubtitleSpeakerTypeData extends Enum<MmSubtitleSpeakerTypeData> {
    public static final a Companion = null;
    public static final MmSubtitleSpeakerTypeData NORMAL = null;
    public static final MmSubtitleSpeakerTypeData SCD_SPEAKER = null;
    public static final MmSubtitleSpeakerTypeData UNKNOWN = null;
    public static final MmSubtitleSpeakerTypeData VOICE_PRINT_SPEAKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSubtitleSpeakerTypeData[] f433533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433534b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MmSubtitleSpeakerTypeData> getEntries() {
        return f433534b;
    }

    static {
        MmSubtitleSpeakerTypeData r100 = new MmSubtitleSpeakerTypeData("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MmSubtitleSpeakerTypeData r101 = new MmSubtitleSpeakerTypeData(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        MmSubtitleSpeakerTypeData r102 = new MmSubtitleSpeakerTypeData("SCD_SPEAKER", 2, 2);
        SCD_SPEAKER = r102;
        MmSubtitleSpeakerTypeData r103 = new MmSubtitleSpeakerTypeData("VOICE_PRINT_SPEAKER", 3, 3);
        VOICE_PRINT_SPEAKER = r103;
        MmSubtitleSpeakerTypeData[] r104 = {r100, r101, r102, r103};
        f433533a = r104;
        f433534b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MmSubtitleSpeakerTypeData[] values() {
        return (MmSubtitleSpeakerTypeData[]) f433533a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MmSubtitleSpeakerTypeData(name=" + name() + ", value=" + this.value + ')';
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSubtitleSpeakerTypeData valueOf(String r100) {
        return (MmSubtitleSpeakerTypeData) r27.a.a(MmSubtitleSpeakerTypeData.class, r100);
    }

    public MmSubtitleSpeakerTypeData(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
