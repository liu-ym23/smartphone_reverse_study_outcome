package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmMarkedSpeakerType;", "", "<init>", "(Ljava/lang/String;I)V", "CLUSTER_ID", "TEMPORARY", "LARK_USER", "isLarkUser", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmMarkedSpeakerType extends Enum<MmMarkedSpeakerType> {
    public static final MmMarkedSpeakerType CLUSTER_ID = null;
    public static final MmMarkedSpeakerType LARK_USER = null;
    public static final MmMarkedSpeakerType TEMPORARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmMarkedSpeakerType[] f433518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433519b = null;

    public static EnumEntries<MmMarkedSpeakerType> getEntries() {
        return f433519b;
    }

    static {
        MmMarkedSpeakerType r100 = new MmMarkedSpeakerType("CLUSTER_ID", 0);
        CLUSTER_ID = r100;
        MmMarkedSpeakerType r101 = new MmMarkedSpeakerType("TEMPORARY", 1);
        TEMPORARY = r101;
        MmMarkedSpeakerType r102 = new MmMarkedSpeakerType("LARK_USER", 2);
        LARK_USER = r102;
        MmMarkedSpeakerType[] r103 = {r100, r101, r102};
        f433518a = r103;
        f433519b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmMarkedSpeakerType[] values() {
        return (MmMarkedSpeakerType[]) f433518a.clone();
    }

    public final boolean isLarkUser() {
        if (this != LARK_USER) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmMarkedSpeakerType valueOf(String r100) {
        return (MmMarkedSpeakerType) a.a(MmMarkedSpeakerType.class, r100);
    }

    public MmMarkedSpeakerType(String r100, int r101) {
        super(r100, r101);
    }
}
