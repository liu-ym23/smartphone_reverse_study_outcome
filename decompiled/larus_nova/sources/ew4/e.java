package ew4;

import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f474538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<List<f>, Unit> f474540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<CommentImageSelectorDismissReason, Unit> f474541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f474542e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f474538a == r101.f474538a) goto L12;
        return false;
    L12:
        if (this.f474539b == r101.f474539b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474540c, r101.f474540c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474541d, r101.f474541d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474542e, r101.f474542e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f474538a * 31) + this.f474539b) * 31) + this.f474540c.hashCode()) * 31;
        Function1<CommentImageSelectorDismissReason, Unit> r101 = this.f474541d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f474542e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommentImageSelectorRequest(height=" + this.f474538a + ", maxSelectImageCount=" + this.f474539b + ", onSelectImages=" + this.f474540c + ", onDismiss=" + this.f474541d + ", dialogLifecycle=" + this.f474542e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(int r100, int r101, Function1<? super List<f>, Unit> r102, Function1<? super CommentImageSelectorDismissReason, Unit> r103, d r104) {
        Intrinsics.checkNotNullParameter(r102, "onSelectImages");
        Intrinsics.checkNotNullParameter(r104, "dialogLifecycle");
        this.f474538a = r100;
        this.f474539b = r101;
        this.f474540c = r102;
        this.f474541d = r103;
        this.f474542e = r104;
    }
}
