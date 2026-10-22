package com.larus.push.impl.reminder;

import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f367114c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f367112a, r101.f367112a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367113b, r101.f367113b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f367114c, r101.f367114c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f367112a.hashCode() * 31;
        String r101 = this.f367113b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f367114c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BubbleUIData(avatar=" + this.f367112a + ", name=" + this.f367113b + ", brief=" + this.f367114c + ')';
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        Intrinsics.checkNotNullParameter(r102, SelectInfo.BRIEF);
        this.f367112a = r100;
        this.f367113b = r101;
        this.f367114c = r102;
    }
}
