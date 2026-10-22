package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CLOSE", "PAGE_RESUME", "RECORDING_END", "RECORDING_INTERRUPTED", "SESSION_INACTIVE", "HOST_DISMISS", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingFloatDismissReason extends Enum<MmRecordingFloatDismissReason> {
    public static final MmRecordingFloatDismissReason HOST_DISMISS = null;
    public static final MmRecordingFloatDismissReason PAGE_RESUME = null;
    public static final MmRecordingFloatDismissReason RECORDING_END = null;
    public static final MmRecordingFloatDismissReason RECORDING_INTERRUPTED = null;
    public static final MmRecordingFloatDismissReason SESSION_INACTIVE = null;
    public static final MmRecordingFloatDismissReason USER_CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingFloatDismissReason[] f436872a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436873b = null;

    public static EnumEntries<MmRecordingFloatDismissReason> getEntries() {
        return f436873b;
    }

    static {
        MmRecordingFloatDismissReason r100 = new MmRecordingFloatDismissReason("USER_CLOSE", 0);
        USER_CLOSE = r100;
        MmRecordingFloatDismissReason r101 = new MmRecordingFloatDismissReason("PAGE_RESUME", 1);
        PAGE_RESUME = r101;
        MmRecordingFloatDismissReason r102 = new MmRecordingFloatDismissReason("RECORDING_END", 2);
        RECORDING_END = r102;
        MmRecordingFloatDismissReason r103 = new MmRecordingFloatDismissReason("RECORDING_INTERRUPTED", 3);
        RECORDING_INTERRUPTED = r103;
        MmRecordingFloatDismissReason r104 = new MmRecordingFloatDismissReason("SESSION_INACTIVE", 4);
        SESSION_INACTIVE = r104;
        MmRecordingFloatDismissReason r105 = new MmRecordingFloatDismissReason("HOST_DISMISS", 5);
        HOST_DISMISS = r105;
        MmRecordingFloatDismissReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f436872a = r110;
        f436873b = EnumEntriesKt.enumEntries(r110);
    }

    public static MmRecordingFloatDismissReason[] values() {
        return (MmRecordingFloatDismissReason[]) f436872a.clone();
    }

    public static MmRecordingFloatDismissReason valueOf(String r100) {
        return (MmRecordingFloatDismissReason) a.a(MmRecordingFloatDismissReason.class, r100);
    }

    public MmRecordingFloatDismissReason(String r100, int r101) {
        super(r100, r101);
    }
}
