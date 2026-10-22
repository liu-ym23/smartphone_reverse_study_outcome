package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f420152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eab.e f420153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f420154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MovableRenderConfig f420155d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Float.compare(this.f420152a, r101.f420152a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f420153b, r101.f420153b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f420154c, r101.f420154c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f420155d, r101.f420155d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((Float.floatToIntBits(this.f420152a) * 31) + this.f420153b.hashCode()) * 31) + this.f420154c.hashCode()) * 31;
        MovableRenderConfig r101 = this.f420155d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownRenderKey(widthDp=" + this.f420152a + ", markdownNode=" + this.f420153b + ", urlPreviewInlineDigest=" + this.f420154c + ", renderConfig=" + this.f420155d + ')';
    }

    public h(float r100, eab.e r101, String r102, MovableRenderConfig r103) {
        Intrinsics.checkNotNullParameter(r101, "markdownNode");
        Intrinsics.checkNotNullParameter(r102, "urlPreviewInlineDigest");
        this.f420152a = r100;
        this.f420153b = r101;
        this.f420154c = r102;
        this.f420155d = r103;
    }
}
