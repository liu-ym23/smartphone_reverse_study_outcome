package com.larksuite.component.card.datachannel;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UniversalCardEntity f283710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f283711b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f283710a, r101.f283710a) == true) goto L12;
        return false;
    L12:
        if (this.f283711b == r101.f283711b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f283710a.hashCode() * 31;
        if (this.f283711b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "GetCardEntityResponse(universalCardEntity=" + this.f283710a + ", isFromCache=" + this.f283711b + ')';
    }

    public a(UniversalCardEntity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "universalCardEntity");
        this.f283710a = r100;
        this.f283711b = r101;
    }
}
