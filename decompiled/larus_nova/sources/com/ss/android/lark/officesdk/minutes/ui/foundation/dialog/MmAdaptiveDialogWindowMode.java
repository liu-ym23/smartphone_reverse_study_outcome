package com.ss.android.lark.officesdk.minutes.ui.foundation.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/dialog/MmAdaptiveDialogWindowMode;", "", "<init>", "(Ljava/lang/String;I)V", "MobilePortrait", "MobileLandscape", "PadPortrait", "PadLandscape", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAdaptiveDialogWindowMode extends Enum<MmAdaptiveDialogWindowMode> {
    public static final MmAdaptiveDialogWindowMode MobileLandscape = null;
    public static final MmAdaptiveDialogWindowMode MobilePortrait = null;
    public static final MmAdaptiveDialogWindowMode PadLandscape = null;
    public static final MmAdaptiveDialogWindowMode PadPortrait = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAdaptiveDialogWindowMode[] f435618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435619b = null;

    public static EnumEntries<MmAdaptiveDialogWindowMode> getEntries() {
        return f435619b;
    }

    static {
        MmAdaptiveDialogWindowMode r100 = new MmAdaptiveDialogWindowMode("MobilePortrait", 0);
        MobilePortrait = r100;
        MmAdaptiveDialogWindowMode r101 = new MmAdaptiveDialogWindowMode("MobileLandscape", 1);
        MobileLandscape = r101;
        MmAdaptiveDialogWindowMode r102 = new MmAdaptiveDialogWindowMode("PadPortrait", 2);
        PadPortrait = r102;
        MmAdaptiveDialogWindowMode r103 = new MmAdaptiveDialogWindowMode("PadLandscape", 3);
        PadLandscape = r103;
        MmAdaptiveDialogWindowMode[] r104 = {r100, r101, r102, r103};
        f435618a = r104;
        f435619b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmAdaptiveDialogWindowMode[] values() {
        return (MmAdaptiveDialogWindowMode[]) f435618a.clone();
    }

    public static MmAdaptiveDialogWindowMode valueOf(String r100) {
        return (MmAdaptiveDialogWindowMode) a.a(MmAdaptiveDialogWindowMode.class, r100);
    }

    public MmAdaptiveDialogWindowMode(String r100, int r101) {
        super(r100, r101);
    }
}
