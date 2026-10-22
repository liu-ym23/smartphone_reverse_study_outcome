package com.larus.setting.impl.blocklist;

import com.larus.home.api.block.BlockUserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockUserInfo f368110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f368111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f368112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f368113d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f368110a, r101.f368110a) == true) goto L12;
        return false;
    L12:
        if (this.f368111b == r101.f368111b) goto L15;
        return false;
    L15:
        if (this.f368112c == r101.f368112c) goto L18;
        return false;
    L18:
        if (this.f368113d == r101.f368113d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        BlockUserInfo r100 = this.f368110a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f368111b == false) goto L9;
        int r103 = 1231;
    L11:
        return ((((r102 + r103) * 31) + this.f368112c) * 31) + this.f368113d;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BlockUserItem(blockUserInfo=" + this.f368110a + ", block=" + this.f368111b + ", type=" + this.f368112c + ", loadMoreStatus=" + this.f368113d + ')';
    }

    public final int getType() {
        return this.f368112c;
    }

    public m(BlockUserInfo r100, boolean r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r101 = true;
    L5:
        int r104 = 0;
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = 2;
    L11:
        this.f368110a = r100;
        this.f368111b = r101;
        this.f368112c = r102;
        this.f368113d = r104;
    }
}
