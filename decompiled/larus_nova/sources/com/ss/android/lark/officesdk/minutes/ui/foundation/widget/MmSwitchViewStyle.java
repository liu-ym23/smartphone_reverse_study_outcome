package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSwitchViewStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SWITCH_ONLY", "SWITCH_HINT", "ICON_ONLY", "ICON_HINT", "CONTENT_ONLY", "CONTENT_HINT", "CHECK_ONLY", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmSwitchViewStyle extends Enum<MmSwitchViewStyle> {
    public static final MmSwitchViewStyle CHECK_ONLY = null;
    public static final MmSwitchViewStyle CONTENT_HINT = null;
    public static final MmSwitchViewStyle CONTENT_ONLY = null;
    public static final MmSwitchViewStyle ICON_HINT = null;
    public static final MmSwitchViewStyle ICON_ONLY = null;
    public static final MmSwitchViewStyle SWITCH_HINT = null;
    public static final MmSwitchViewStyle SWITCH_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmSwitchViewStyle[] f435721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435722b = null;
    private final int value;

    public static EnumEntries<MmSwitchViewStyle> getEntries() {
        return f435722b;
    }

    static {
        MmSwitchViewStyle r100 = new MmSwitchViewStyle("SWITCH_ONLY", 0, 0);
        SWITCH_ONLY = r100;
        MmSwitchViewStyle r101 = new MmSwitchViewStyle("SWITCH_HINT", 1, 1);
        SWITCH_HINT = r101;
        MmSwitchViewStyle r102 = new MmSwitchViewStyle("ICON_ONLY", 2, 2);
        ICON_ONLY = r102;
        MmSwitchViewStyle r103 = new MmSwitchViewStyle("ICON_HINT", 3, 3);
        ICON_HINT = r103;
        MmSwitchViewStyle r104 = new MmSwitchViewStyle("CONTENT_ONLY", 4, 4);
        CONTENT_ONLY = r104;
        MmSwitchViewStyle r105 = new MmSwitchViewStyle("CONTENT_HINT", 5, 5);
        CONTENT_HINT = r105;
        MmSwitchViewStyle r110 = new MmSwitchViewStyle("CHECK_ONLY", 6, 6);
        CHECK_ONLY = r110;
        MmSwitchViewStyle[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f435721a = r111;
        f435722b = EnumEntriesKt.enumEntries(r111);
    }

    public static MmSwitchViewStyle[] values() {
        return (MmSwitchViewStyle[]) f435721a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSwitchViewStyle valueOf(String r100) {
        return (MmSwitchViewStyle) r27.a.a(MmSwitchViewStyle.class, r100);
    }

    public MmSwitchViewStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
