package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/CachalotAsyncConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CachalotAsyncConfig<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CachalotAsyncBindConfig<T> f450674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f450675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Mode f450676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f450677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f450678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f450679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f450680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f450681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f450682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f450683j;

    public CachalotAsyncConfig() {
        this(null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CachalotAsyncConfig) == false) goto L28;
        CachalotAsyncConfig r101 = (CachalotAsyncConfig) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450674a, r101.f450674a) == true) goto L10;
        return false;
    L10:
        if (this.f450675b == r101.f450675b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f450676c, r101.f450676c) == true) goto L14;
        return false;
    L14:
        if (this.f450677d == r101.f450677d) goto L16;
        return false;
    L16:
        if (Float.compare(this.f450678e, r101.f450678e) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f450679f, r101.f450679f) == 0) goto L20;
        return false;
    L20:
        if (this.f450680g == r101.f450680g) goto L22;
        return false;
    L22:
        if (this.f450681h == r101.f450681h) goto L24;
        return false;
    L24:
        if (this.f450682i == r101.f450682i) goto L26;
        return false;
    L26:
        if (this.f450683j == r101.f450683j) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        CachalotAsyncBindConfig<T> r100 = this.f450674a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = (r102 + 0) * 31;
        boolean r104 = this.f450675b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Mode r108 = this.f450676c;
        if (r108 == null) goto L12;
        r101 = r108.hashCode();
    L12:
        int r109 = (r107 + r101) * 31;
        boolean r110 = this.f450677d;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (((((r109 + r111) * 31) + Float.floatToIntBits(this.f450678e)) * 31) + Float.floatToIntBits(this.f450679f)) * 31;
        boolean r113 = this.f450680g;
        ?? r114 = r113;
        if (r113 == false) goto L18;
        r114 = 1;
    L18:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f450681h;
        ?? r117 = r116;
        if (r116 == false) goto L21;
        r117 = 1;
    L21:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f450682i;
        ?? r120 = r119;
        if (r119 == false) goto L24;
        r120 = 1;
    L24:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f450683j;
        if (r122 == true) goto L29;
        r105 = r122;
    L29:
        return r121 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CachalotAsyncConfig(createConfig=null, bindConfig=" + this.f450674a + ", compatPrefetchInMainThread=" + this.f450675b + ", viewHolderCreateMode=" + this.f450676c + ", disableLynxRVPrefetch=" + this.f450677d + ", preLayoutOptFactor=" + this.f450678e + ", delayRecycleOnScrollOptFactor=" + this.f450679f + ", disablePreLayoutIfLowMem=" + this.f450680g + ", disableDelayRecycleOnScrollIfLowMem=" + this.f450681h + ", enableCachePreBindOnScroll=" + this.f450682i + ", enableCachePreBindOnIdle=" + this.f450683j + ")";
    }

    public CachalotAsyncConfig(CachalotAsyncBindConfig r100, int r101) {
        Mode r102 = null;
        if ((r101 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 8) == 0) goto L8;
        r102 = Mode.ON_MAIN_THREAD;
    L8:
        Intrinsics.checkNotNullParameter(r102, "viewHolderCreateMode");
        this.f450674a = r100;
        this.f450675b = false;
        this.f450676c = r102;
        this.f450677d = false;
        this.f450678e = 0.0f;
        this.f450679f = 0.0f;
        this.f450680g = false;
        this.f450681h = false;
        this.f450682i = false;
        this.f450683j = false;
    }
}
