package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBackGroundViewOutLineContext;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GSBackGroundViewOutLineContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f450183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f450184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f450185c;

    public GSBackGroundViewOutLineContext() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GSBackGroundViewOutLineContext) == false) goto L12;
        GSBackGroundViewOutLineContext r101 = (GSBackGroundViewOutLineContext) r100;
        if (this.f450183a == r101.f450183a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f450184b, r101.f450184b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f450185c, r101.f450185c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f450183a * 31) + Float.floatToIntBits(this.f450184b)) * 31) + Float.floatToIntBits(this.f450185c);
    }

    public final String toString() {
        return "GSBackGroundViewOutLineContext(color=" + this.f450183a + ", strokeWidth=" + this.f450184b + ", radius=" + this.f450185c + ")";
    }

    public /* synthetic */ GSBackGroundViewOutLineContext(int r100) {
        this(0, 0.0f, 0.0f);
    }

    public GSBackGroundViewOutLineContext(int r100, float r101, float r102) {
        this.f450183a = r100;
        this.f450184b = r101;
        this.f450185c = r102;
    }
}
