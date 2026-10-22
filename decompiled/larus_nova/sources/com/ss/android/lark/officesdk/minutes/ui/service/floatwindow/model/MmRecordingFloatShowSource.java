package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatShowSource;", "", "<init>", "(Ljava/lang/String;I)V", "USER_LEAVE", "PAGE_INVISIBLE", "APP_BACKGROUND", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingFloatShowSource extends Enum<MmRecordingFloatShowSource> {
    public static final MmRecordingFloatShowSource APP_BACKGROUND = null;
    public static final MmRecordingFloatShowSource PAGE_INVISIBLE = null;
    public static final MmRecordingFloatShowSource USER_LEAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingFloatShowSource[] f436880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436881b = null;

    public static EnumEntries<MmRecordingFloatShowSource> getEntries() {
        return f436881b;
    }

    static {
        MmRecordingFloatShowSource r100 = new MmRecordingFloatShowSource("USER_LEAVE", 0);
        USER_LEAVE = r100;
        MmRecordingFloatShowSource r101 = new MmRecordingFloatShowSource("PAGE_INVISIBLE", 1);
        PAGE_INVISIBLE = r101;
        MmRecordingFloatShowSource r102 = new MmRecordingFloatShowSource("APP_BACKGROUND", 2);
        APP_BACKGROUND = r102;
        MmRecordingFloatShowSource[] r103 = {r100, r101, r102};
        f436880a = r103;
        f436881b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingFloatShowSource[] values() {
        return (MmRecordingFloatShowSource[]) f436880a.clone();
    }

    public static MmRecordingFloatShowSource valueOf(String r100) {
        return (MmRecordingFloatShowSource) a.a(MmRecordingFloatShowSource.class, r100);
    }

    public MmRecordingFloatShowSource(String r100, int r101) {
        super(r100, r101);
    }
}
