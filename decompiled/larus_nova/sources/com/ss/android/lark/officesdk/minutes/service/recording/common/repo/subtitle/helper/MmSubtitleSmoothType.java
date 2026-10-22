package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/helper/MmSubtitleSmoothType;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE", "TARGET", "UNKNOWN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSubtitleSmoothType extends Enum<MmSubtitleSmoothType> {
    public static final MmSubtitleSmoothType SOURCE = null;
    public static final MmSubtitleSmoothType TARGET = null;
    public static final MmSubtitleSmoothType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSubtitleSmoothType[] f435237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435238b = null;

    public static EnumEntries<MmSubtitleSmoothType> getEntries() {
        return f435238b;
    }

    static {
        MmSubtitleSmoothType r100 = new MmSubtitleSmoothType("SOURCE", 0);
        SOURCE = r100;
        MmSubtitleSmoothType r101 = new MmSubtitleSmoothType("TARGET", 1);
        TARGET = r101;
        MmSubtitleSmoothType r102 = new MmSubtitleSmoothType("UNKNOWN", 2);
        UNKNOWN = r102;
        MmSubtitleSmoothType[] r103 = {r100, r101, r102};
        f435237a = r103;
        f435238b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmSubtitleSmoothType[] values() {
        return (MmSubtitleSmoothType[]) f435237a.clone();
    }

    public static MmSubtitleSmoothType valueOf(String r100) {
        return (MmSubtitleSmoothType) a.a(MmSubtitleSmoothType.class, r100);
    }

    public MmSubtitleSmoothType(String r100, int r101) {
        super(r100, r101);
    }
}
