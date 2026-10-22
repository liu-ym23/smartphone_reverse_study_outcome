package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/rtc/VCMediaStreamType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RTC_MEDIA_STREAM_TYPE_AUDIO", "RTC_MEDIA_STREAM_TYPE_VIDEO", "RTC_MEDIA_STREAM_TYPE_BOTH", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VCMediaStreamType extends Enum<VCMediaStreamType> {
    public static final a Companion = null;
    public static final VCMediaStreamType RTC_MEDIA_STREAM_TYPE_AUDIO = null;
    public static final VCMediaStreamType RTC_MEDIA_STREAM_TYPE_BOTH = null;
    public static final VCMediaStreamType RTC_MEDIA_STREAM_TYPE_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VCMediaStreamType[] f433553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433554b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<VCMediaStreamType> getEntries() {
        return f433554b;
    }

    static {
        VCMediaStreamType r100 = new VCMediaStreamType("RTC_MEDIA_STREAM_TYPE_AUDIO", 0, 1);
        RTC_MEDIA_STREAM_TYPE_AUDIO = r100;
        VCMediaStreamType r101 = new VCMediaStreamType("RTC_MEDIA_STREAM_TYPE_VIDEO", 1, 2);
        RTC_MEDIA_STREAM_TYPE_VIDEO = r101;
        VCMediaStreamType r102 = new VCMediaStreamType("RTC_MEDIA_STREAM_TYPE_BOTH", 2, 3);
        RTC_MEDIA_STREAM_TYPE_BOTH = r102;
        VCMediaStreamType[] r103 = {r100, r101, r102};
        f433553a = r103;
        f433554b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static VCMediaStreamType[] values() {
        return (VCMediaStreamType[]) f433553a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final VCMediaStreamType valueOf(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return null;
    L14:
        return RTC_MEDIA_STREAM_TYPE_BOTH;
    L15:
        return RTC_MEDIA_STREAM_TYPE_VIDEO;
    L12:
        return RTC_MEDIA_STREAM_TYPE_AUDIO;
    }

    public static VCMediaStreamType valueOf(String r100) {
        return (VCMediaStreamType) r27.a.a(VCMediaStreamType.class, r100);
    }

    public VCMediaStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
