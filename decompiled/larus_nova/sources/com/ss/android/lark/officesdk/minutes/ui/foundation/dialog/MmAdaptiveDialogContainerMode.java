package com.ss.android.lark.officesdk.minutes.ui.foundation.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/dialog/MmAdaptiveDialogContainerMode;", "", "<init>", "(Ljava/lang/String;I)V", "BottomSheet", "CenterModal", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAdaptiveDialogContainerMode extends Enum<MmAdaptiveDialogContainerMode> {
    public static final MmAdaptiveDialogContainerMode BottomSheet = null;
    public static final MmAdaptiveDialogContainerMode CenterModal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAdaptiveDialogContainerMode[] f435616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435617b = null;

    public static EnumEntries<MmAdaptiveDialogContainerMode> getEntries() {
        return f435617b;
    }

    static {
        MmAdaptiveDialogContainerMode r100 = new MmAdaptiveDialogContainerMode("BottomSheet", 0);
        BottomSheet = r100;
        MmAdaptiveDialogContainerMode r101 = new MmAdaptiveDialogContainerMode("CenterModal", 1);
        CenterModal = r101;
        MmAdaptiveDialogContainerMode[] r102 = {r100, r101};
        f435616a = r102;
        f435617b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmAdaptiveDialogContainerMode[] values() {
        return (MmAdaptiveDialogContainerMode[]) f435616a.clone();
    }

    public static MmAdaptiveDialogContainerMode valueOf(String r100) {
        return (MmAdaptiveDialogContainerMode) a.a(MmAdaptiveDialogContainerMode.class, r100);
    }

    public MmAdaptiveDialogContainerMode(String r100, int r101) {
        super(r100, r101);
    }
}
