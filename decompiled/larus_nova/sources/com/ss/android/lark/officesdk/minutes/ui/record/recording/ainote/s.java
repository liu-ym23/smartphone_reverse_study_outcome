package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class s implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f436116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f436117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f436118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmAINoteSheetState f436119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmAINoteHint f436120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f436121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f436122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f436123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f436124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f436125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmRecordingUILaunchMode f436126k;

    public s() {
        boolean r100 = false;
        this(r100, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f436116a == r101.f436116a) goto L12;
        return false;
    L12:
        if (this.f436117b == r101.f436117b) goto L15;
        return false;
    L15:
        if (this.f436118c == r101.f436118c) goto L18;
        return false;
    L18:
        if (this.f436119d == r101.f436119d) goto L21;
        return false;
    L21:
        if (this.f436120e == r101.f436120e) goto L24;
        return false;
    L24:
        if (this.f436121f == r101.f436121f) goto L27;
        return false;
    L27:
        if (this.f436122g == r101.f436122g) goto L30;
        return false;
    L30:
        if (this.f436123h == r101.f436123h) goto L33;
        return false;
    L33:
        if (this.f436124i == r101.f436124i) goto L36;
        return false;
    L36:
        if (this.f436125j == r101.f436125j) goto L39;
        return false;
    L39:
        if (this.f436126k == r101.f436126k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f436116a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f436117b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        int r104 = 1231;
        if (this.f436118c == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (((r103 + r105) * 31) + this.f436119d.hashCode()) * 31;
        MmAINoteHint r107 = this.f436120e;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        if (this.f436121f == false) goto L13;
        int r110 = 1231;
    L14:
        int r111 = (r109 + r110) * 31;
        if (this.f436122g == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r111 + r112) * 31;
        if (this.f436123h == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        if (this.f436124i == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f436125j == true) goto L31;
        r104 = 1237;
    L31:
        return ((r117 + r104) * 31) + this.f436126k.hashCode();
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = 1237;
        goto L18
    L13:
        r110 = 1237;
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmAINoteVMState(duration=" + this.f436116a + ", meetingStartTime=" + this.f436117b + ", isWavePlaying=" + this.f436118c + ", sheetState=" + this.f436119d + ", hint=" + this.f436120e + ", isTrialTagVisible=" + this.f436121f + ", saveSwitchVisible=" + this.f436122g + ", saveSwitchChecked=" + this.f436123h + ", saveSwitchEnabled=" + this.f436124i + ", showCloseAction=" + this.f436125j + ", uiLaunchMode=" + this.f436126k + ')';
    }

    public /* synthetic */ s(boolean r110, MmRecordingUILaunchMode r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r112 & 8) == 0) goto L9;
        MmAINoteSheetState r101 = MmAINoteSheetState.CLOSED;
    L11:
        if ((r112 & 32) == 0) goto L13;
        boolean r113 = false;
    L15:
        if ((r112 & 128) == 0) goto L17;
        boolean r114 = true;
    L19:
        if ((r112 & 512) == 0) goto L21;
        boolean r115 = true;
    L23:
        if ((r112 & 1024) == 0) goto L25;
        MmRecordingUILaunchMode r116 = MmRecordingUILaunchMode.UNKNOWN;
    L26:
        this(0, 0, r100, r101, null, r113, false, r114, false, r115, r116);
        return;
    L25:
        r116 = r111;
        goto L26
    L21:
        r115 = false;
        goto L23
    L17:
        r114 = false;
        goto L19
    L13:
        r113 = r110;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public s(long r100, long r101, boolean r102, MmAINoteSheetState r103, MmAINoteHint r104, boolean r105, boolean r110, boolean r111, boolean r112, boolean r113, MmRecordingUILaunchMode r114) {
        Intrinsics.checkNotNullParameter(r103, "sheetState");
        Intrinsics.checkNotNullParameter(r114, "uiLaunchMode");
        this.f436116a = r100;
        this.f436117b = r101;
        this.f436118c = r102;
        this.f436119d = r103;
        this.f436120e = r104;
        this.f436121f = r105;
        this.f436122g = r110;
        this.f436123h = r111;
        this.f436124i = r112;
        this.f436125j = r113;
        this.f436126k = r114;
    }

    public static s a(s r110, long r111, long r210, boolean r211, MmAINoteSheetState r212, MmAINoteHint r213, boolean r214, boolean r215, boolean r216, boolean r217, int r310) {
        if ((r310 & 1) == 0) goto L5;
        long r100 = r110.f436116a;
    L7:
        if ((r310 & 2) == 0) goto L9;
        long r101 = r110.f436117b;
    L11:
        if ((r310 & 4) == 0) goto L13;
        boolean r102 = r110.f436118c;
    L15:
        if ((r310 & 8) == 0) goto L17;
        MmAINoteSheetState r112 = r110.f436119d;
    L19:
        if ((r310 & 16) == 0) goto L21;
        MmAINoteHint r113 = r110.f436120e;
    L23:
        if ((r310 & 32) == 0) goto L25;
        boolean r114 = r110.f436121f;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r115 = r110.f436122g;
    L31:
        if ((r310 & 128) == 0) goto L33;
        boolean r116 = r110.f436123h;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r117 = r110.f436124i;
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r118 = r110.f436125j;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        MmRecordingUILaunchMode r103 = r110.f436126k;
    L46:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r112, "sheetState");
        Intrinsics.checkNotNullParameter(r103, "uiLaunchMode");
        return new s(r100, r101, r102, r112, r113, r114, r115, r116, r117, r118, r103);
    L45:
        r103 = null;
        goto L46
    L41:
        r118 = r217;
        goto L43
    L37:
        r117 = r216;
        goto L39
    L33:
        r116 = r215;
        goto L35
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = false;
        goto L27
    L21:
        r113 = r213;
        goto L23
    L17:
        r112 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
