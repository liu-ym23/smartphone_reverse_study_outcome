package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f420140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eab.e f420141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MovableRenderConfig f420142c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Float.compare(this.f420140a, r101.f420140a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f420141b, r101.f420141b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f420142c, r101.f420142c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f420140a) * 31) + this.f420141b.hashCode()) * 31) + this.f420142c.hashCode();
    }

    public final String toString() {
        return "MarkdownDocumentPreloadKey(widthDp=" + this.f420140a + ", markdownNode=" + this.f420141b + ", renderConfig=" + this.f420142c + ')';
    }

    public a(float r100, eab.e r101, MovableRenderConfig r102) {
        Intrinsics.checkNotNullParameter(r101, "markdownNode");
        Intrinsics.checkNotNullParameter(r102, "renderConfig");
        this.f420140a = r100;
        this.f420141b = r101;
        this.f420142c = r102;
    }
}
