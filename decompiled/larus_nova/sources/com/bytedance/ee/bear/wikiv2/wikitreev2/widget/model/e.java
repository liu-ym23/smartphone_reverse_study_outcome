package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f241806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<TreeNode> f241807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WikiRelation f241808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f241809g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f241803a, r101.f241803a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f241804b, r101.f241804b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f241805c, r101.f241805c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f241806d, r101.f241806d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f241807e, r101.f241807e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f241808f, r101.f241808f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f241809g, r101.f241809g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f241803a.hashCode() * 31) + this.f241804b.hashCode()) * 31;
        String r101 = this.f241805c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f241806d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f241807e.hashCode()) * 31;
        WikiRelation r108 = this.f241808f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f241809g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MovBatchNodeBean(srcParent=" + this.f241803a + ", destParent=" + this.f241804b + ", forceExpandToken=" + this.f241805c + ", expandToToken=" + this.f241806d + ", spareNodeList=" + this.f241807e + ", spareRelation=" + this.f241808f + ", destSpaceId=" + this.f241809g + ')';
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.c
    public final String getSpaceId() {
        return this.f241809g;
    }

    public e(String r100, String r101, String r102, String r103, List<TreeNode> r104, WikiRelation r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "srcParent");
        Intrinsics.checkNotNullParameter(r101, "destParent");
        Intrinsics.checkNotNullParameter(r104, "spareNodeList");
        this.f241803a = r100;
        this.f241804b = r101;
        this.f241805c = r102;
        this.f241806d = r103;
        this.f241807e = r104;
        this.f241808f = r105;
        this.f241809g = r106;
    }
}
