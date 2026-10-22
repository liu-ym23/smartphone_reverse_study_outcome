package com.ss.android.ugc.aweme.search.dynamic.core.data;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.ui.e;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ra.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/data/RenderLoaderData;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class RenderLoaderData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXLynxView f452708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f452709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f452710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RenderEngineOption f452711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f452712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DynamicCardEngine f452713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f452714g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RenderLoaderData) == true) goto L8;
        return false;
    L8:
        RenderLoaderData r101 = (RenderLoaderData) r100;
        if (Intrinsics.areEqual(this.f452708a, r101.f452708a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f452709b, r101.f452709b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f452710c, r101.f452710c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f452711d, r101.f452711d) == true) goto L21;
        return false;
    L21:
        if (this.f452712e == r101.f452712e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f452713f, r101.f452713f) == true) goto L27;
        return false;
    L27:
        if (this.f452714g == r101.f452714g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f452708a.hashCode() * 31) + this.f452709b.hashCode()) * 31;
        e r101 = this.f452710c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f452711d.hashCode()) * 31;
        if (this.f452712e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        DynamicCardEngine r107 = this.f452713f;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return ((r106 + r102) * 31) + this.f452714g;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RenderLoaderData(annieXLynxView=" + this.f452708a + ", annieXLynxModel=" + this.f452709b + ", lifecycleObserver=" + this.f452710c + ", config=" + this.f452711d + ", isFromPreload=" + this.f452712e + ", engine=" + this.f452713f + ", expectedReuseVersion=" + this.f452714g + ')';
    }

    public RenderLoaderData(AnnieXLynxView r100, a r101, e r102, RenderEngineOption r103, boolean r104, DynamicCardEngine r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "annieXLynxView");
        Intrinsics.checkNotNullParameter(r101, "annieXLynxModel");
        Intrinsics.checkNotNullParameter(r103, "config");
        this.f452708a = r100;
        this.f452709b = r101;
        this.f452710c = r102;
        this.f452711d = r103;
        this.f452712e = r104;
        this.f452713f = r105;
        this.f452714g = r106;
    }
}
