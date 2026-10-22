package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f436609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f436610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmSummaryViewType f436611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSummaryStatus f436612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmSummaryStatus f436613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f436614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f436615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f436616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f436617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f436618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f436619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b f436620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f436621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f436622n;

    public e() {
        this(false, false, null, null, false, false, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f436609a == r101.f436609a) goto L12;
        return false;
    L12:
        if (this.f436610b == r101.f436610b) goto L15;
        return false;
    L15:
        if (this.f436611c == r101.f436611c) goto L18;
        return false;
    L18:
        if (this.f436612d == r101.f436612d) goto L21;
        return false;
    L21:
        if (this.f436613e == r101.f436613e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f436614f, r101.f436614f) == true) goto L27;
        return false;
    L27:
        if (this.f436615g == r101.f436615g) goto L30;
        return false;
    L30:
        if (this.f436616h == r101.f436616h) goto L33;
        return false;
    L33:
        if (this.f436617i == r101.f436617i) goto L36;
        return false;
    L36:
        if (this.f436618j == r101.f436618j) goto L39;
        return false;
    L39:
        if (this.f436619k == r101.f436619k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f436620l, r101.f436620l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f436621m, r101.f436621m) == true) goto L48;
        return false;
    L48:
        if (this.f436622n == r101.f436622n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f436609a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f436610b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((((((r102 + r103) * 31) + this.f436611c.hashCode()) * 31) + this.f436612d.hashCode()) * 31) + this.f436613e.hashCode()) * 31) + this.f436614f.hashCode()) * 31;
        if (this.f436615g == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f436616h == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f436617i == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (((((r108 + r109) * 31) + this.f436618j) * 31) + this.f436619k) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r111 = this.f436620l;
        if (r111 != null) goto L25;
        int r112 = 0;
    L26:
        int r113 = (((r110 + r112) * 31) + this.f436621m.hashCode()) * 31;
        if (this.f436622n == true) goto L31;
        r100 = 1237;
    L31:
        return r113 + r100;
    L25:
        r112 = r111.hashCode();
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmSummaryVMState(isViewTypeSwitchEnable=" + this.f436609a + ", isFishBoneEnable=" + this.f436610b + ", viewType=" + this.f436611c + ", textSummaryStatus=" + this.f436612d + ", fishBoneSummaryStatus=" + this.f436613e + ", url=" + this.f436614f + ", isWebReady=" + this.f436615g + ", isWebLoading=" + this.f436616h + ", isWebLoadFailed=" + this.f436617i + ", webRetryCount=" + this.f436618j + ", maxWebRetryCount=" + this.f436619k + ", aiSummaryContent=" + this.f436620l + ", quotaCtaState=" + this.f436621m + ", isSubtitleDegraded=" + this.f436622n + ')';
    }

    public /* synthetic */ e(boolean r110, boolean r210, MmSummaryViewType r211, String r212, boolean r213, boolean r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r215 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r215 & 4) == 0) goto L13;
        MmSummaryViewType r102 = MmSummaryViewType.Markdown;
    L15:
        if ((r215 & 8) == 0) goto L17;
        MmSummaryStatus r103 = MmSummaryStatus.None;
    L19:
        if ((r215 & 16) == 0) goto L21;
        MmSummaryStatus r104 = MmSummaryStatus.None;
    L23:
        if ((r215 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r215 & 128) == 0) goto L29;
        boolean r111 = false;
    L31:
        if ((r215 & 256) == 0) goto L33;
        boolean r112 = false;
    L35:
        if ((r215 & 1024) == 0) goto L37;
        int r113 = 3;
    L39:
        if ((r215 & 4096) == 0) goto L41;
        h.a r114 = h.a.f434921a;
    L42:
        this(r100, r101, r102, r103, r104, r105, false, r111, r112, 0, r113, null, r114, false);
        return;
    L41:
        r114 = null;
        goto L42
    L37:
        r113 = 0;
        goto L39
    L33:
        r112 = r214;
        goto L35
    L29:
        r111 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public e(boolean r100, boolean r101, MmSummaryViewType r102, MmSummaryStatus r103, MmSummaryStatus r104, String r105, boolean r106, boolean r107, boolean r110, int r111, int r112, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r113, h r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r102, "viewType");
        Intrinsics.checkNotNullParameter(r103, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r104, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r105, "url");
        Intrinsics.checkNotNullParameter(r114, "quotaCtaState");
        this.f436609a = r100;
        this.f436610b = r101;
        this.f436611c = r102;
        this.f436612d = r103;
        this.f436613e = r104;
        this.f436614f = r105;
        this.f436615g = r106;
        this.f436616h = r107;
        this.f436617i = r110;
        this.f436618j = r111;
        this.f436619k = r112;
        this.f436620l = r113;
        this.f436621m = r114;
        this.f436622n = r115;
    }

    public static e a(e r110, boolean r111, boolean r112, MmSummaryViewType r113, MmSummaryStatus r114, MmSummaryStatus r210, String r211, boolean r212, boolean r213, boolean r214, int r215, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r216, h r217, boolean r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        boolean r100 = r110.f436609a;
    L7:
        if ((r219 & 2) == 0) goto L9;
        boolean r101 = r110.f436610b;
    L11:
        if ((r219 & 4) == 0) goto L13;
        MmSummaryViewType r102 = r110.f436611c;
    L15:
        if ((r219 & 8) == 0) goto L17;
        MmSummaryStatus r103 = r110.f436612d;
    L19:
        if ((r219 & 16) == 0) goto L21;
        MmSummaryStatus r104 = r110.f436613e;
    L23:
        if ((r219 & 32) == 0) goto L25;
        String r105 = r110.f436614f;
    L27:
        if ((r219 & 64) == 0) goto L29;
        boolean r106 = r110.f436615g;
    L31:
        if ((r219 & 128) == 0) goto L33;
        boolean r107 = r110.f436616h;
    L35:
        if ((r219 & 256) == 0) goto L37;
        boolean r115 = r110.f436617i;
    L39:
        if ((r219 & 512) == 0) goto L41;
        int r116 = r110.f436618j;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        int r117 = r110.f436619k;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r118 = r110.f436620l;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        h r119 = r110.f436621m;
    L55:
        if ((r219 & 8192) == 0) goto L57;
        boolean r108 = r110.f436622n;
    L58:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r102, "viewType");
        Intrinsics.checkNotNullParameter(r103, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r104, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r105, "url");
        Intrinsics.checkNotNullParameter(r119, "quotaCtaState");
        return new e(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r218;
        goto L58
    L53:
        r119 = r217;
        goto L55
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = 0;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
