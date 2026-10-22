package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteSheetState;", "", "<init>", "(Ljava/lang/String;I)V", "FULL", "HALF", ErrorCode.CLOSED, "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAINoteSheetState extends Enum<MmAINoteSheetState> {
    public static final MmAINoteSheetState CLOSED = null;
    public static final MmAINoteSheetState FULL = null;
    public static final MmAINoteSheetState HALF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAINoteSheetState[] f436025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436026b = null;

    public static EnumEntries<MmAINoteSheetState> getEntries() {
        return f436026b;
    }

    static {
        MmAINoteSheetState r100 = new MmAINoteSheetState("FULL", 0);
        FULL = r100;
        MmAINoteSheetState r101 = new MmAINoteSheetState("HALF", 1);
        HALF = r101;
        MmAINoteSheetState r102 = new MmAINoteSheetState(ErrorCode.CLOSED, 2);
        CLOSED = r102;
        MmAINoteSheetState[] r103 = {r100, r101, r102};
        f436025a = r103;
        f436026b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmAINoteSheetState[] values() {
        return (MmAINoteSheetState[]) f436025a.clone();
    }

    public static MmAINoteSheetState valueOf(String r100) {
        return (MmAINoteSheetState) r27.a.a(MmAINoteSheetState.class, r100);
    }

    public MmAINoteSheetState(String r100, int r101) {
        super(r100, r101);
    }
}
