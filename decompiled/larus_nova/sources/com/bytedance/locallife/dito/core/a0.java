package com.bytedance.locallife.dito.core;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<String, Object> f257874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair<String, Object> f257875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, Object>> f257876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Pair<String, Object>> f257877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Pair<String, Object>> f257878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f257879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f257880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f257881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f257882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f257883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f257884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f257885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f257886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f257887n;

    public a0() {
        this(null, null, null, false, false, false, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f257874a, r101.f257874a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257875b, r101.f257875b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f257876c, r101.f257876c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f257877d, r101.f257877d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f257878e, r101.f257878e) == true) goto L24;
        return false;
    L24:
        if (this.f257879f == r101.f257879f) goto L27;
        return false;
    L27:
        if (this.f257880g == r101.f257880g) goto L30;
        return false;
    L30:
        if (this.f257881h == r101.f257881h) goto L33;
        return false;
    L33:
        if (this.f257882i == r101.f257882i) goto L36;
        return false;
    L36:
        if (this.f257883j == r101.f257883j) goto L39;
        return false;
    L39:
        if (this.f257884k == r101.f257884k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f257885l, r101.f257885l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f257886m, r101.f257886m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f257887n, r101.f257887n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Pair<String, Object> r100 = this.f257874a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Pair<String, Object> r104 = this.f257875b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.f257876c.hashCode()) * 31) + this.f257877d.hashCode()) * 31) + this.f257878e.hashCode()) * 31;
        int r107 = 1231;
        if (this.f257879f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f257880g == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f257881h == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f257882i == false) goto L25;
        int r114 = 1231;
    L26:
        long r115 = this.f257883j;
        int r116 = (((r113 + r114) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        if (this.f257884k == true) goto L30;
        r107 = 1237;
    L30:
        int r117 = (r116 + r107) * 31;
        Integer r118 = this.f257885l;
        if (r118 != null) goto L33;
        int r119 = 0;
    L34:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f257886m;
        if (r121 != null) goto L37;
        int r122 = 0;
    L38:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.f257887n;
        if (r124 == null) goto L43;
        r101 = r124.hashCode();
    L43:
        return r123 + r101;
    L37:
        r122 = r121.hashCode();
        goto L38
    L33:
        r119 = r118.hashCode();
        goto L34
    L25:
        r114 = 1237;
        goto L26
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoUIConfig(pageStatusView=" + this.f257874a + ", toolbarView=" + this.f257875b + ", floatViewList=" + this.f257876c + ", bodyViewList=" + this.f257877d + ", backgroundViewList=" + this.f257878e + ", footerAddDecorView=" + this.f257879f + ", headerAddDecorView=" + this.f257880g + ", footerFloat=" + this.f257881h + ", headerFloat=" + this.f257882i + ", fmpTimeout=" + this.f257883j + ", wakeupStubsAfterRequestComplete=" + this.f257884k + ", itemViewCacheSize=" + this.f257885l + ", gapWorkerPrefetchCount=" + this.f257886m + ", triggerGapWorkerAfterFmp=" + this.f257887n + ')';
    }

    public a0(Pair r100, List r101, List r102, boolean r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 4) == 0) goto L8;
        ArrayList r103 = new ArrayList();
    L10:
        if ((r113 & 8) == 0) goto L13;
        r101 = new ArrayList();
    L13:
        if ((r113 & 16) == 0) goto L16;
        r102 = new ArrayList();
    L16:
        if ((r113 & 32) == 0) goto L19;
        r110 = false;
    L19:
        if ((r113 & 128) == 0) goto L22;
        r111 = false;
    L22:
        if ((r113 & 256) == 0) goto L25;
        r112 = false;
    L25:
        if ((r113 & 512) == 0) goto L27;
        long r104 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
    L28:
        Intrinsics.checkNotNullParameter(r103, "floatViewList");
        Intrinsics.checkNotNullParameter(r101, "bodyViewList");
        Intrinsics.checkNotNullParameter(r102, "backgroundViewList");
        this.f257874a = r100;
        this.f257875b = null;
        this.f257876c = r103;
        this.f257877d = r101;
        this.f257878e = r102;
        this.f257879f = r110;
        this.f257880g = false;
        this.f257881h = r111;
        this.f257882i = r112;
        this.f257883j = r104;
        this.f257884k = false;
        this.f257885l = null;
        this.f257886m = null;
        this.f257887n = null;
        return;
    L27:
        r104 = 0;
        goto L28
    L8:
        r103 = null;
        goto L10
    }
}
