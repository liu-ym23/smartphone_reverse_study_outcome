package com.larus.business.markdown.api.extplugin.image;

import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f320467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f320468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f320469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Pair<Integer, View>> f320470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f320471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f320472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f320473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f320474h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f320467a, r101.f320467a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f320468b, r101.f320468b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f320469c, r101.f320469c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f320470d, r101.f320470d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f320471e, r101.f320471e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f320472f, r101.f320472f) == true) goto L27;
        return false;
    L27:
        if (this.f320473g == r101.f320473g) goto L30;
        return false;
    L30:
        if (this.f320474h == r101.f320474h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f320467a.hashCode() * 31) + this.f320468b.hashCode()) * 31) + this.f320469c.hashCode()) * 31) + this.f320470d.hashCode()) * 31) + this.f320471e.hashCode()) * 31) + this.f320472f.hashCode()) * 31) + this.f320473g) * 31) + this.f320474h;
    }

    public final String toString() {
        return "ImageLoaderInfo(imageView=" + this.f320467a + ", textView=" + this.f320468b + ", span=" + this.f320469c + ", imageViewList=" + this.f320470d + ", imageInfoList=" + this.f320471e + ", imageIndex=" + this.f320472f + ", targetWidth=" + this.f320473g + ", targetHeight=" + this.f320474h + ')';
    }

    public g(SimpleDraweeView r100, TextView r101, c r102, List r103, List r104, AtomicInteger r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "span");
        Intrinsics.checkNotNullParameter(r103, "imageViewList");
        Intrinsics.checkNotNullParameter(r104, "imageInfoList");
        Intrinsics.checkNotNullParameter(r105, "imageIndex");
        this.f320467a = r100;
        this.f320468b = r101;
        this.f320469c = r102;
        this.f320470d = r103;
        this.f320471e = r104;
        this.f320472f = r105;
        this.f320473g = r106;
        this.f320474h = r107;
    }
}
