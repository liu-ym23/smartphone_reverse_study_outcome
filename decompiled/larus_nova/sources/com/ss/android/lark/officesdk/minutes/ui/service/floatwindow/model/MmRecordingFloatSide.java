package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatSide;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingFloatSide extends Enum<MmRecordingFloatSide> {
    public static final MmRecordingFloatSide LEFT = null;
    public static final MmRecordingFloatSide RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingFloatSide[] f436882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436883b = null;

    public static EnumEntries<MmRecordingFloatSide> getEntries() {
        return f436883b;
    }

    static {
        MmRecordingFloatSide r100 = new MmRecordingFloatSide("LEFT", 0);
        LEFT = r100;
        MmRecordingFloatSide r101 = new MmRecordingFloatSide("RIGHT", 1);
        RIGHT = r101;
        MmRecordingFloatSide[] r102 = {r100, r101};
        f436882a = r102;
        f436883b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingFloatSide[] values() {
        return (MmRecordingFloatSide[]) f436882a.clone();
    }

    public static MmRecordingFloatSide valueOf(String r100) {
        return (MmRecordingFloatSide) a.a(MmRecordingFloatSide.class, r100);
    }

    public MmRecordingFloatSide(String r100, int r101) {
        super(r100, r101);
    }
}
