package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.data.media.VisitInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardResource.ResourceType f283914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f283915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VisitInfo f283916c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f283914a == r101.f283914a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283915b, r101.f283915b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f283916c, r101.f283916c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f283914a.hashCode() * 31) + this.f283915b.hashCode()) * 31;
        VisitInfo r101 = this.f283916c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CardResourceParams(type=" + this.f283914a + ", fileKey=" + this.f283915b + ", visitInfo=" + this.f283916c + ')';
    }

    public final CardResource.ResourceType getType() {
        return this.f283914a;
    }

    public b(CardResource.ResourceType r100, String r101, VisitInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "fileKey");
        this.f283914a = r100;
        this.f283915b = r101;
        this.f283916c = r102;
    }
}
