package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SHOWING", "SHOWN", "DISMISSING", "DISMISSED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingFloatLifecycleState extends Enum<MmRecordingFloatLifecycleState> {
    public static final MmRecordingFloatLifecycleState DISMISSED = null;
    public static final MmRecordingFloatLifecycleState DISMISSING = null;
    public static final MmRecordingFloatLifecycleState IDLE = null;
    public static final MmRecordingFloatLifecycleState SHOWING = null;
    public static final MmRecordingFloatLifecycleState SHOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingFloatLifecycleState[] f436878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436879b = null;

    public static EnumEntries<MmRecordingFloatLifecycleState> getEntries() {
        return f436879b;
    }

    static {
        MmRecordingFloatLifecycleState r100 = new MmRecordingFloatLifecycleState("IDLE", 0);
        IDLE = r100;
        MmRecordingFloatLifecycleState r101 = new MmRecordingFloatLifecycleState("SHOWING", 1);
        SHOWING = r101;
        MmRecordingFloatLifecycleState r102 = new MmRecordingFloatLifecycleState("SHOWN", 2);
        SHOWN = r102;
        MmRecordingFloatLifecycleState r103 = new MmRecordingFloatLifecycleState("DISMISSING", 3);
        DISMISSING = r103;
        MmRecordingFloatLifecycleState r104 = new MmRecordingFloatLifecycleState("DISMISSED", 4);
        DISMISSED = r104;
        MmRecordingFloatLifecycleState[] r105 = {r100, r101, r102, r103, r104};
        f436878a = r105;
        f436879b = EnumEntriesKt.enumEntries(r105);
    }

    public static MmRecordingFloatLifecycleState[] values() {
        return (MmRecordingFloatLifecycleState[]) f436878a.clone();
    }

    public static MmRecordingFloatLifecycleState valueOf(String r100) {
        return (MmRecordingFloatLifecycleState) a.a(MmRecordingFloatLifecycleState.class, r100);
    }

    public MmRecordingFloatLifecycleState(String r100, int r101) {
        super(r100, r101);
    }
}
