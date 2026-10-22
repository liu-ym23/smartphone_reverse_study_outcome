package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EmptyStateSource f218435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f218436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f218437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f218438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f218439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f218440f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f218435a, r101.f218435a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f218436b, r101.f218436b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f218437c, r101.f218437c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f218438d, r101.f218438d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f218439e, r101.f218439e) == true) goto L24;
        return false;
    L24:
        if (this.f218440f == r101.f218440f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        EmptyStateSource r100 = this.f218435a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f218436b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f218437c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f218438d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f218439e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f218440f == false) goto L25;
        int r115 = 1231;
    L27:
        return r114 + r115;
    L25:
        r115 = 1237;
        goto L27
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
        return "VoteOptionAttachParams(emptyStateSource=" + this.f218435a + ", pageId=" + this.f218436b + ", blockId=" + this.f218437c + ", optionId=" + this.f218438d + ", firstOffset=" + this.f218439e + ", isVoteDesc=" + this.f218440f + ')';
    }

    public c(EmptyStateSource r100, String r101, String r102, String r103, String r104, boolean r105) {
        this.f218435a = r100;
        this.f218436b = r101;
        this.f218437c = r102;
        this.f218438d = r103;
        this.f218439e = r104;
        this.f218440f = r105;
    }
}
