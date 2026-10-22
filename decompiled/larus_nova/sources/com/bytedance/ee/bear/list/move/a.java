package com.bytedance.ee.bear.list.move;

import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f228839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GetMoveReviewerInfoPuller$Result f228840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f228841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f228842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f228843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f228844f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f228839a, r101.f228839a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f228840b, r101.f228840b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f228841c, r101.f228841c) == true) goto L18;
        return false;
    L18:
        if (this.f228842d == r101.f228842d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f228843e, r101.f228843e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f228844f, r101.f228844f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f228839a.hashCode() * 31) + this.f228840b.hashCode()) * 31) + this.f228841c.hashCode()) * 31) + this.f228842d) * 31) + this.f228843e.hashCode()) * 31) + this.f228844f.hashCode();
    }

    public final String toString() {
        return "ApplyMoveSpaceToWikiShowParam(fragmentManager=" + this.f228839a + ", reviewerResult=" + this.f228840b + ", objToken=" + this.f228841c + ", objType=" + this.f228842d + ", parentWikiToken=" + this.f228843e + ", spaceId=" + this.f228844f + ')';
    }

    public a(FragmentManager r100, GetMoveReviewerInfoPuller$Result r101, String r102, int r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "reviewerResult");
        Intrinsics.checkNotNullParameter(r102, "objToken");
        Intrinsics.checkNotNullParameter(r104, "parentWikiToken");
        Intrinsics.checkNotNullParameter(r105, "spaceId");
        this.f228839a = r100;
        this.f228840b = r101;
        this.f228841c = r102;
        this.f228842d = r103;
        this.f228843e = r104;
        this.f228844f = r105;
    }
}
