package com.larus.share.impl;

import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.h;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareScene f368637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f368638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f368639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<by7.e> f368640d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f368637a == r101.f368637a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368638b, r101.f368638b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f368639c, r101.f368639c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f368640d, r101.f368640d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        ShareScene r100 = this.f368637a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f368638b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f368639c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        WeakReference<by7.e> r110 = this.f368640d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "SharePanelClickConfig(shareScene=" + this.f368637a + ", channelType=" + this.f368638b + ", eventParam=" + this.f368639c + ", node=" + this.f368640d + ')';
    }

    public e(ShareScene r100, String r101, h r102, WeakReference<by7.e> r103) {
        this.f368637a = r100;
        this.f368638b = r101;
        this.f368639c = r102;
        this.f368640d = r103;
    }
}
