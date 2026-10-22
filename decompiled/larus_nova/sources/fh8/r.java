package fh8;

import android.content.Context;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<View, lw8.f, Unit> f477141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function4<Context, View, lw8.f, View, Unit> f477142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Context, gw8.b, Unit> f477143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Context, gw8.b, Unit> f477144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<gw8.b, View, Unit> f477145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<lw8.g, Unit> f477146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<lw8.g, Unit> f477147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<lw8.f, by7.e, Unit> f477148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function3<Integer, lw8.k, View, Unit> f477149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f477150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f477151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function2<View, View, Unit> f477152l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f477141a, r101.f477141a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477142b, r101.f477142b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f477143c, r101.f477143c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f477144d, r101.f477144d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f477145e, r101.f477145e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f477146f, r101.f477146f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f477147g, r101.f477147g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f477148h, r101.f477148h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f477149i, r101.f477149i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f477150j, r101.f477150j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f477151k, r101.f477151k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f477152l, r101.f477152l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((this.f477141a.hashCode() * 31) + this.f477142b.hashCode()) * 31) + this.f477143c.hashCode()) * 31) + this.f477144d.hashCode()) * 31) + this.f477145e.hashCode()) * 31) + this.f477146f.hashCode()) * 31) + this.f477147g.hashCode()) * 31) + this.f477148h.hashCode()) * 31) + this.f477149i.hashCode()) * 31) + this.f477150j.hashCode()) * 31) + this.f477151k.hashCode()) * 31) + this.f477152l.hashCode();
    }

    public final String toString() {
        return "MarkdownTextWidgetEventDelegator(onClickShareButton=" + this.f477141a + ", onClickCopyButton=" + this.f477142b + ", jumpToCodePage=" + this.f477143c + ", jumpToTablePage=" + this.f477144d + ", onFullScreenPreviewClick=" + this.f477145e + ", onClickCitation=" + this.f477146f + ", onInlineCitationSpanShow=" + this.f477147g + ", onCopyShow=" + this.f477148h + ", onSoftLinkShow=" + this.f477149i + ", onFootnoteLinkShow=" + this.f477150j + ", onFootnoteLinkClick=" + this.f477151k + ", onClickSoftLink=" + this.f477152l + ')';
    }

    public r(fm8.n r100, fm8.o r101, fm8.p r102, fm8.b r103, fm8.c r104, fm8.d r105, fm8.e r106, fm8.f r107, fm8.g r110, fm8.h r111, fm8.i r112, fm8.j r113) {
        Intrinsics.checkNotNullParameter(r100, "onClickShareButton");
        Intrinsics.checkNotNullParameter(r101, "onClickCopyButton");
        Intrinsics.checkNotNullParameter(r102, "jumpToCodePage");
        Intrinsics.checkNotNullParameter(r103, "jumpToTablePage");
        Intrinsics.checkNotNullParameter(r104, "onFullScreenPreviewClick");
        Intrinsics.checkNotNullParameter(r105, "onClickCitation");
        Intrinsics.checkNotNullParameter(r106, "onInlineCitationSpanShow");
        Intrinsics.checkNotNullParameter(r107, "onCopyShow");
        Intrinsics.checkNotNullParameter(r110, "onSoftLinkShow");
        Intrinsics.checkNotNullParameter(r111, "onFootnoteLinkShow");
        Intrinsics.checkNotNullParameter(r112, "onFootnoteLinkClick");
        Intrinsics.checkNotNullParameter(r113, "onClickSoftLink");
        this.f477141a = r100;
        this.f477142b = r101;
        this.f477143c = r102;
        this.f477144d = r103;
        this.f477145e = r104;
        this.f477146f = r105;
        this.f477147g = r106;
        this.f477148h = r107;
        this.f477149i = r110;
        this.f477150j = r111;
        this.f477151k = r112;
        this.f477152l = r113;
    }
}
