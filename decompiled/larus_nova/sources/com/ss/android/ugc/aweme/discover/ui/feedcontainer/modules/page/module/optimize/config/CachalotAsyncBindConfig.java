package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.EcomAsyncPrefetchStrategy;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.IAsyncPrefetchStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/CachalotAsyncBindConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CachalotAsyncBindConfig<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<String, Integer, T, CardPreloadConfig> f450668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Boolean, Boolean> f450669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IAsyncPrefetchStrategy f450670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f450671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f450672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f450673f;

    public CachalotAsyncBindConfig() {
        this(null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CachalotAsyncBindConfig) == false) goto L18;
        CachalotAsyncBindConfig r101 = (CachalotAsyncBindConfig) r100;
        if (Intrinsics.areEqual(this.f450668a, r101.f450668a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450669b, r101.f450669b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f450670c, r101.f450670c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f450671d, r101.f450671d) == true) goto L14;
        return false;
    L14:
        if (this.f450672e == r101.f450672e) goto L16;
        return false;
    L16:
        if (this.f450673f == r101.f450673f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        Function3<String, Integer, T, CardPreloadConfig> r100 = this.f450668a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function4<Integer, Integer, Integer, Boolean, Boolean> r104 = this.f450669b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAsyncPrefetchStrategy r107 = this.f450670c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.f450671d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.f450672e;
        ?? r113 = 1;
        ?? r114 = r112;
        if (r112 == false) goto L20;
        r114 = 1;
    L20:
        int r115 = (r111 + r114) * 31;
        boolean r116 = this.f450673f;
        if (r116 == true) goto L25;
        r113 = r116;
    L25:
        return r115 + r113;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CachalotAsyncBindConfig(cardPreloadConfigs=" + this.f450668a + ", skipAsyncBind=" + this.f450669b + ", preloadStrategy=" + this.f450670c + ", resultListener=" + this.f450671d + ", enableMainPrefetch=" + this.f450672e + ", fixChunkAsyncBindReuse=" + this.f450673f + ")";
    }

    public CachalotAsyncBindConfig(Function3 r100, EcomAsyncPrefetchStrategy r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = AnonymousClass1.INSTANCE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        Intrinsics.checkNotNullParameter(r100, "cardPreloadConfigs");
        Intrinsics.checkNotNullParameter(r103, "skipAsyncBind");
        this.f450668a = r100;
        this.f450669b = r103;
        this.f450670c = r101;
        this.f450671d = null;
        this.f450672e = false;
        this.f450673f = false;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
