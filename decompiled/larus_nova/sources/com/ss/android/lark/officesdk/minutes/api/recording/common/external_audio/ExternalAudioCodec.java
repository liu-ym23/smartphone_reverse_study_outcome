package com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalAudioCodec;", "", "<init>", "(Ljava/lang/String;I)V", "OPUS", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalAudioCodec extends Enum<ExternalAudioCodec> {
    public static final ExternalAudioCodec OPUS = null;
    public static final ExternalAudioCodec UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalAudioCodec[] f433561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433562b = null;

    public static EnumEntries<ExternalAudioCodec> getEntries() {
        return f433562b;
    }

    static {
        ExternalAudioCodec r100 = new ExternalAudioCodec("OPUS", 0);
        OPUS = r100;
        ExternalAudioCodec r101 = new ExternalAudioCodec("UNKNOWN", 1);
        UNKNOWN = r101;
        ExternalAudioCodec[] r102 = {r100, r101};
        f433561a = r102;
        f433562b = EnumEntriesKt.enumEntries(r102);
    }

    public static ExternalAudioCodec[] values() {
        return (ExternalAudioCodec[]) f433561a.clone();
    }

    public static ExternalAudioCodec valueOf(String r100) {
        return (ExternalAudioCodec) a.a(ExternalAudioCodec.class, r100);
    }

    public ExternalAudioCodec(String r100, int r101) {
        super(r100, r101);
    }
}
