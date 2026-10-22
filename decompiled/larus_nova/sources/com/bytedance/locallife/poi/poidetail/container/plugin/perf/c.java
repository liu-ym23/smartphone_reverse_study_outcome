package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/c;", "", "", "url", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "cardCreateTime", "J", "c", "()J", "setCardCreateTime", "(J)V", "bindCardTime", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setBindCardTime", "(Ljava/lang/Long;)V", "bindFinishTime", "b", "h", "lastSizeChangeTime", "d", "setLastSizeChangeTime", "durationCreateToStable", "durationBindToStable", "durationStableToFmp", "getDurationStableToFmp", ce.f26395j, "durationLastChangeBeforeFmp", "getDurationLastChangeBeforeFmp", RXScreenCaptureService.KEY_INDEX, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Integer f264145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Integer f264146b;

    @SerializedName("bind_card_time")
    private Long bindCardTime;

    @SerializedName("bind_finish_time")
    private Long bindFinishTime;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient List<r> f264147c;

    @SerializedName("card_create_time")
    private long cardCreateTime;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient List<Long> f264148d;

    @SerializedName("duration_bind_to_stable")
    private Long durationBindToStable;

    @SerializedName("duration_create_to_stable")
    private Long durationCreateToStable;

    @SerializedName("duration_last_change_before_fmp")
    private Long durationLastChangeBeforeFmp;

    @SerializedName("duration_stable_to_fmp")
    private Long durationStableToFmp;

    @SerializedName("last_size_change_time")
    private Long lastSizeChangeTime;

    @SerializedName("url")
    private String url;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f264145a, r101.f264145a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f264146b, r101.f264146b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f264147c, r101.f264147c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f264148d, r101.f264148d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L24;
        return false;
    L24:
        if (this.cardCreateTime == r101.cardCreateTime) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bindCardTime, r101.bindCardTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bindFinishTime, r101.bindFinishTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.lastSizeChangeTime, r101.lastSizeChangeTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.durationCreateToStable, r101.durationCreateToStable) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.durationBindToStable, r101.durationBindToStable) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.durationStableToFmp, r101.durationStableToFmp) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.durationLastChangeBeforeFmp, r101.durationLastChangeBeforeFmp) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f264145a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f264146b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<r> r107 = this.f264147c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f264148d.hashCode()) * 31;
        String r110 = this.url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.cardCreateTime;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        Long r115 = this.bindCardTime;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        Long r118 = this.bindFinishTime;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        Long r121 = this.lastSizeChangeTime;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        Long r124 = this.durationCreateToStable;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        Long r127 = this.durationBindToStable;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        Long r130 = this.durationStableToFmp;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.durationLastChangeBeforeFmp;
        if (r133 == null) goto L47;
        r101 = r133.hashCode();
    L47:
        return r132 + r101;
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiCardSizeChangeInfo(measuredWidth=" + this.f264145a + ", measuredHeight=" + this.f264146b + ", leafViewGroups=" + this.f264147c + ", changeTimeList=" + this.f264148d + ", url=" + this.url + ", cardCreateTime=" + this.cardCreateTime + ", bindCardTime=" + this.bindCardTime + ", bindFinishTime=" + this.bindFinishTime + ", lastSizeChangeTime=" + this.lastSizeChangeTime + ", durationCreateToStable=" + this.durationCreateToStable + ", durationBindToStable=" + this.durationBindToStable + ", durationStableToFmp=" + this.durationStableToFmp + ", durationLastChangeBeforeFmp=" + this.durationLastChangeBeforeFmp + ')';
    }

    public final Long a() {
        return this.bindCardTime;
    }

    public final Long b() {
        return this.bindFinishTime;
    }

    public final long c() {
        return this.cardCreateTime;
    }

    public final Long d() {
        return this.lastSizeChangeTime;
    }

    public final String e() {
        return this.url;
    }

    public c(Object r100) {
        ArrayList r101 = new ArrayList();
        long r102 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r101, "changeTimeList");
        this.f264145a = null;
        this.f264146b = null;
        this.f264147c = null;
        this.f264148d = r101;
        this.url = null;
        this.cardCreateTime = r102;
        this.bindCardTime = null;
        this.bindFinishTime = null;
        this.lastSizeChangeTime = null;
        this.durationCreateToStable = null;
        this.durationBindToStable = null;
        this.durationStableToFmp = null;
        this.durationLastChangeBeforeFmp = null;
    }

    public final void f(String r100) {
        if (this.bindCardTime != null) goto L6;
        this.bindCardTime = Long.valueOf(System.currentTimeMillis());
        this.url = r100;
        return;
    }

    public final boolean g(Long r100) {
        long r101 = System.currentTimeMillis();
        Long r102 = this.lastSizeChangeTime;
        if (r102 == null) goto L9;
        if (r100 == null) goto L9;
        if ((r101 - r102.longValue()) < 1000) goto L9;
        return false;
    L9:
        return true;
    }

    public final void h(Long r100) {
        this.bindFinishTime = r100;
    }

    public final void i(Long r100) {
        this.durationLastChangeBeforeFmp = r100;
    }

    public final void j(Long r100) {
        this.durationStableToFmp = r100;
    }

    public final void k(String r100, int r101, int r102, List<r> r103) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        Integer r104 = this.f264145a;
        if (r104 != null) goto L6;
    L14:
        this.f264145a = Integer.valueOf(r101);
        this.f264146b = Integer.valueOf(r102);
        this.f264147c = r103;
        long r105 = System.currentTimeMillis();
        this.lastSizeChangeTime = Long.valueOf(r105);
        this.f264148d.add(Long.valueOf(r105));
        Long r106 = this.bindCardTime;
        if (r106 == null) goto L17;
        this.durationBindToStable = Long.valueOf(r105 - r106.longValue());
    L17:
        this.durationCreateToStable = Long.valueOf(r105 - this.cardCreateTime);
        return;
    L6:
        if (r104.intValue() != r101) goto L14;
        Integer r107 = this.f264146b;
        if (r107 == null) goto L14;
        if (r107.intValue() != r102) goto L14;
        if (r103 != null) goto L14;
    }
}
