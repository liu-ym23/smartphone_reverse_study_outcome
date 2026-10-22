package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;", "", "<init>", "(Ljava/lang/String;I)V", "FLOAT_WINDOW", "RECORDING_START_AUTO_OPEN", "CLICK_RECORDING_CARD", "OUTER_PUSH", "DOUBAO_APPS_FLOAT_WINDOW", "DOUBAO_APPS_IN_TASK", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingPageOpenSource extends Enum<MmRecordingPageOpenSource> {
    public static final MmRecordingPageOpenSource CLICK_RECORDING_CARD = null;
    public static final a Companion = null;
    public static final MmRecordingPageOpenSource DOUBAO_APPS_FLOAT_WINDOW = null;
    public static final MmRecordingPageOpenSource DOUBAO_APPS_IN_TASK = null;
    public static final MmRecordingPageOpenSource FLOAT_WINDOW = null;
    public static final MmRecordingPageOpenSource OUTER_PUSH = null;
    public static final MmRecordingPageOpenSource RECORDING_START_AUTO_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingPageOpenSource[] f433575a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433576b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MmRecordingPageOpenSource> getEntries() {
        return f433576b;
    }

    static {
        MmRecordingPageOpenSource r100 = new MmRecordingPageOpenSource("FLOAT_WINDOW", 0);
        FLOAT_WINDOW = r100;
        MmRecordingPageOpenSource r101 = new MmRecordingPageOpenSource("RECORDING_START_AUTO_OPEN", 1);
        RECORDING_START_AUTO_OPEN = r101;
        MmRecordingPageOpenSource r102 = new MmRecordingPageOpenSource("CLICK_RECORDING_CARD", 2);
        CLICK_RECORDING_CARD = r102;
        MmRecordingPageOpenSource r103 = new MmRecordingPageOpenSource("OUTER_PUSH", 3);
        OUTER_PUSH = r103;
        MmRecordingPageOpenSource r104 = new MmRecordingPageOpenSource("DOUBAO_APPS_FLOAT_WINDOW", 4);
        DOUBAO_APPS_FLOAT_WINDOW = r104;
        MmRecordingPageOpenSource r105 = new MmRecordingPageOpenSource("DOUBAO_APPS_IN_TASK", 5);
        DOUBAO_APPS_IN_TASK = r105;
        MmRecordingPageOpenSource[] r110 = {r100, r101, r102, r103, r104, r105};
        f433575a = r110;
        f433576b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static MmRecordingPageOpenSource[] values() {
        return (MmRecordingPageOpenSource[]) f433575a.clone();
    }

    public static MmRecordingPageOpenSource valueOf(String r100) {
        return (MmRecordingPageOpenSource) r27.a.a(MmRecordingPageOpenSource.class, r100);
    }

    public MmRecordingPageOpenSource(String r100, int r101) {
        super(r100, r101);
    }
}
