package com.larksuite.component.blockit.hashtag.list;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<oy7.e> f283056a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f283056a, ((l) r100).f283056a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<oy7.e> r100 = this.f283056a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "InitData(hashTagList=" + this.f283056a + ')';
    }

    public l(List<oy7.e> r100) {
        this.f283056a = r100;
    }
}
