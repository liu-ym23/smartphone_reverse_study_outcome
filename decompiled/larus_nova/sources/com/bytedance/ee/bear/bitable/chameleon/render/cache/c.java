package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f209696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f209697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f209698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f209699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableCacheBlockType f209700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f209701f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f209696a, r101.f209696a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f209697b, r101.f209697b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f209698c, r101.f209698c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f209699d, r101.f209699d) == true) goto L21;
        return false;
    L21:
        if (this.f209700e == r101.f209700e) goto L24;
        return false;
    L24:
        if (this.f209701f == r101.f209701f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f209696a.hashCode() * 31) + this.f209697b.hashCode()) * 31) + this.f209698c.hashCode()) * 31) + this.f209699d.hashCode()) * 31) + this.f209700e.hashCode()) * 31;
        if (this.f209701f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BitableCacheFirstBlock(baseToken=" + this.f209696a + ", blockId=" + this.f209697b + ", viewId=" + this.f209698c + ", recordId=" + this.f209699d + ", blockType=" + this.f209700e + ", isFromUrl=" + this.f209701f + ')';
    }

    public c(String r100, String r101, String r102, String r103, BitableCacheBlockType r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "baseToken");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r102, "viewId");
        Intrinsics.checkNotNullParameter(r103, "recordId");
        Intrinsics.checkNotNullParameter(r104, "blockType");
        this.f209696a = r100;
        this.f209697b = r101;
        this.f209698c = r102;
        this.f209699d = r103;
        this.f209700e = r104;
        this.f209701f = r105;
    }
}
