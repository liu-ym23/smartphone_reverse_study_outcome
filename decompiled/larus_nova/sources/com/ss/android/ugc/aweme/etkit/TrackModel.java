package com.ss.android.ugc.aweme.etkit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/etkit/TrackModel;", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class TrackModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Params f450808b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TrackModel) == true) goto L8;
        return false;
    L8:
        TrackModel r101 = (TrackModel) r100;
        if (Intrinsics.areEqual(this.f450807a, r101.f450807a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f450808b, r101.f450808b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f450807a.hashCode() * 31) + this.f450808b.hashCode();
    }

    public final String toString() {
        return "TrackModel(eventName=" + this.f450807a + ", params=" + this.f450808b + ')';
    }

    public TrackModel(String r100, Params r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f450807a = r100;
        this.f450808b = r101;
    }
}
