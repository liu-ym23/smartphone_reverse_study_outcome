package com.ss.android.lark.feed.molten.cache;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<UIFeedCard> f421036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f421037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f421038c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f421036a, r101.f421036a) == true) goto L12;
        return false;
    L12:
        if (this.f421037b == r101.f421037b) goto L15;
        return false;
    L15:
        if (this.f421038c == r101.f421038c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f421036a.hashCode() * 31;
        if (this.f421037b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f421038c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "HumanSidebarFeedCacheSnapshot(items=" + this.f421036a + ", hasMore=" + this.f421037b + ", sourceVersion=" + this.f421038c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends UIFeedCard> r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f421036a = r100;
        this.f421037b = r101;
        this.f421038c = r102;
    }
}
