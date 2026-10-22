package com.ss.android.ugc.aweme.search.optimize;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/PreloadData;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PreloadData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IOptimizeCore<?> f453354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IEventDispatcher f453355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<IOptimize> f453356d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreloadData) == true) goto L8;
        return false;
    L8:
        PreloadData r101 = (PreloadData) r100;
        if (Intrinsics.areEqual(this.f453353a, r101.f453353a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f453354b, r101.f453354b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f453355c, r101.f453355c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f453356d, r101.f453356d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f453353a.hashCode() * 31) + this.f453354b.hashCode()) * 31) + this.f453355c.hashCode()) * 31) + this.f453356d.hashCode();
    }

    public final String toString() {
        return "PreloadData(pageName=" + this.f453353a + ", preloadPage=" + this.f453354b + ", trigger=" + this.f453355c + ", abilityList=" + this.f453356d + ')';
    }

    public PreloadData(String r100, IOptimizeCore r101, SearchOptimizeManager.EventDispatcher r102, ArrayList r103) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "preloadPage");
        Intrinsics.checkNotNullParameter(r102, "trigger");
        Intrinsics.checkNotNullParameter(r103, "abilityList");
        this.f453353a = r100;
        this.f453354b = r101;
        this.f453355c = r102;
        this.f453356d = r103;
    }
}
