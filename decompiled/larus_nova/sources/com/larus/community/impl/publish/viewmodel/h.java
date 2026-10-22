package com.larus.community.impl.publish.viewmodel;

import com.larus.platform.api.creation.PublisherCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublisherCreation f329701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f329702b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f329701a, r101.f329701a) == true) goto L12;
        return false;
    L12:
        if (this.f329702b == r101.f329702b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        PublisherCreation r100 = this.f329701a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f329702b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishCreationState(publisherCreation=" + this.f329701a + ", isReady=" + this.f329702b + ')';
    }

    public h(PublisherCreation r100, boolean r101) {
        this.f329701a = r100;
        this.f329702b = r101;
    }
}
