package com.ss.android.ugc.aweme.search.common.mob;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ECSearchResultSceneKey;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchResultSceneKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f451726a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchResultSceneKey) == true) goto L6;
        return false;
    L6:
        if (this.f451726a == ((ECSearchResultSceneKey) r100).f451726a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f451726a;
    }

    public final String toString() {
        return "ECSearchResultSceneKey(id=" + this.f451726a + ")";
    }

    public ECSearchResultSceneKey(int r100) {
        this.f451726a = r100;
    }
}
