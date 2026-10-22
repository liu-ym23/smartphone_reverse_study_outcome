package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmAnsMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ANS_MODE_DISABLE", "ANS_MODE_LOW", "ANS_MODE_MEDIUM", "ANS_MODE_HIGH", "ANS_MODE_AUTOMATIC", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAnsMode extends Enum<MmAnsMode> {
    public static final MmAnsMode ANS_MODE_AUTOMATIC = null;
    public static final MmAnsMode ANS_MODE_DISABLE = null;
    public static final MmAnsMode ANS_MODE_HIGH = null;
    public static final MmAnsMode ANS_MODE_LOW = null;
    public static final MmAnsMode ANS_MODE_MEDIUM = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAnsMode[] f434368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434369b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MmAnsMode> getEntries() {
        return f434369b;
    }

    static {
        MmAnsMode r100 = new MmAnsMode("ANS_MODE_DISABLE", 0, 0);
        ANS_MODE_DISABLE = r100;
        MmAnsMode r101 = new MmAnsMode("ANS_MODE_LOW", 1, 1);
        ANS_MODE_LOW = r101;
        MmAnsMode r102 = new MmAnsMode("ANS_MODE_MEDIUM", 2, 2);
        ANS_MODE_MEDIUM = r102;
        MmAnsMode r103 = new MmAnsMode("ANS_MODE_HIGH", 3, 3);
        ANS_MODE_HIGH = r103;
        MmAnsMode r104 = new MmAnsMode("ANS_MODE_AUTOMATIC", 4, 4);
        ANS_MODE_AUTOMATIC = r104;
        MmAnsMode[] r105 = {r100, r101, r102, r103, r104};
        f434368a = r105;
        f434369b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MmAnsMode[] values() {
        return (MmAnsMode[]) f434368a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmAnsMode valueOf(String r100) {
        return (MmAnsMode) r27.a.a(MmAnsMode.class, r100);
    }

    public MmAnsMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
