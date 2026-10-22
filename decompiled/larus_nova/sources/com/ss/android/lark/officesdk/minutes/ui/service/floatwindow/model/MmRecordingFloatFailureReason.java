package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "NO_PERMISSION", "CONTEXT_UNAVAILABLE", "SESSION_INACTIVE", "HOST_CREATE_FAILED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingFloatFailureReason extends Enum<MmRecordingFloatFailureReason> {
    public static final MmRecordingFloatFailureReason CONTEXT_UNAVAILABLE = null;
    public static final MmRecordingFloatFailureReason HOST_CREATE_FAILED = null;
    public static final MmRecordingFloatFailureReason NO_PERMISSION = null;
    public static final MmRecordingFloatFailureReason SESSION_INACTIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingFloatFailureReason[] f436874a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436875b = null;

    public static EnumEntries<MmRecordingFloatFailureReason> getEntries() {
        return f436875b;
    }

    static {
        MmRecordingFloatFailureReason r100 = new MmRecordingFloatFailureReason("NO_PERMISSION", 0);
        NO_PERMISSION = r100;
        MmRecordingFloatFailureReason r101 = new MmRecordingFloatFailureReason("CONTEXT_UNAVAILABLE", 1);
        CONTEXT_UNAVAILABLE = r101;
        MmRecordingFloatFailureReason r102 = new MmRecordingFloatFailureReason("SESSION_INACTIVE", 2);
        SESSION_INACTIVE = r102;
        MmRecordingFloatFailureReason r103 = new MmRecordingFloatFailureReason("HOST_CREATE_FAILED", 3);
        HOST_CREATE_FAILED = r103;
        MmRecordingFloatFailureReason[] r104 = {r100, r101, r102, r103};
        f436874a = r104;
        f436875b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmRecordingFloatFailureReason[] values() {
        return (MmRecordingFloatFailureReason[]) f436874a.clone();
    }

    public static MmRecordingFloatFailureReason valueOf(String r100) {
        return (MmRecordingFloatFailureReason) a.a(MmRecordingFloatFailureReason.class, r100);
    }

    public MmRecordingFloatFailureReason(String r100, int r101) {
        super(r100, r101);
    }
}
