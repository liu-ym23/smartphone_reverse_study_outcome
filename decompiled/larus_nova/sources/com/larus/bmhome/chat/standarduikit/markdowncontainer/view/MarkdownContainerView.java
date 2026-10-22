package com.larus.bmhome.chat.standarduikit.markdowncontainer.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import fh8.f;
import fh8.g;
import fh8.h;
import fh8.l;
import fh8.t;
import fm8.b;
import fm8.c;
import fm8.d;
import fm8.e;
import fm8.i;
import fm8.j;
import fm8.k;
import fm8.n;
import fm8.o;
import fm8.p;
import fm8.q;
import fm8.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vg8.m;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0012H\u0003J\b\u0010\u001d\u001a\u00020\u0012H\u0003J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\b\u0010\u001f\u001a\u00020\u0012H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/markdowncontainer/view/MarkdownContainerView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/markdowncontainer/view/MarkdownTextContainerInput;", "Lcom/larus/bmhome/chat/standarduikit/markdowncontainer/view/MarkdownTextContainerOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "markdownRenderHelper", "Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "lastMarginRectF", "Landroid/graphics/RectF;", "commonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "tryCreateMarkdownRenderHelper", "resetMarkdownWidgetsIfMarginRectFChanged", "marginRectF", "sameValueAs", "", "other", "onViewRecycled", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownContainerView extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f309513d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f309514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f309515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f309516c;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        m r100 = this.f309514a;
        if (r100 == null) goto L8;
        v0 r101 = r100.f554754g;
        if (r101 == null) goto L9;
        r101.b();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m r100 = this.f309514a;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public MarkdownContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public MarkdownContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f309516c = new g().a();
        setOrientation(1);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [fm8.f] */
    /* JADX WARN: Type inference failed for: r12v1, types: [fm8.g] */
    /* JADX WARN: Type inference failed for: r14v1, types: [fm8.h] */
    /* JADX WARN: Type inference failed for: r15v1, types: [fm8.n] */
    /* JADX WARN: Type inference failed for: r2v9, types: [fm8.o] */
    /* JADX WARN: Type inference failed for: r3v11, types: [fm8.j] */
    /* JADX WARN: Type inference failed for: r4v6, types: [fm8.i] */
    /* JADX WARN: Type inference failed for: r5v2, types: [fm8.p] */
    /* JADX WARN: Type inference failed for: r6v1, types: [fm8.b] */
    /* JADX WARN: Type inference failed for: r7v1, types: [fm8.c] */
    /* JADX WARN: Type inference failed for: r8v1, types: [fm8.d] */
    /* JADX WARN: Type inference failed for: r9v1, types: [fm8.e] */
    public final void a(final q r310, final r r311) {
        Intrinsics.checkNotNullParameter(r310, "input");
        Intrinsics.checkNotNullParameter(r311, BdpAppEventConstant.PARAMS_OUTPUT);
        FLogger.f375446a.d("MarkdownContainerView", "bindData, input: " + r310);
        if (this.f309514a != null) goto L6;
        this.f309514a = new m("text_block" + r310.f477867m);
    L6:
        t.a r100 = new t.a();
        r100.f477166a = r310.f477855a;
        r100.f477167b = r310.f477856b;
        r100.f477168c = r310.f477857c;
        r100.f477169d = r310.f477858d;
        r100.f477170e = r310.f477859e;
        r100.f477171f = r310.f477860f;
        r100.f477173h = r310.f477861g;
        r100.f477174i = r310.f477876v;
        t r101 = r100.a();
        String r102 = r310.f477866l;
        if (r102 != null) goto L9;
        r102 = r310.f477865k;
    L9:
        g r103 = h.a(r310.f477875u);
        r103.f477106j = r102;
        r103.f477105i = new fm8.a(this, r310, r311);
        this.f309516c = r103.a();
        l r104 = new l(r310.f477863i, r310.f477864j, r310.f477865k, r310.f477867m, r102, r310.f477868n, false, r310.f477869o, r310.f477870p, r310.f477871q, r310.f477874t, 192);
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L44;
        z2 r105 = z2.f365865a;
        RectF r106 = r310.f477876v;
        RectF r107 = this.f309515b;
        if (r107 == null) goto L40;
        boolean r108 = false;
        if (r106 != null) goto L16;
    L36:
        if (r108 == true) goto L40;
        m r109 = this.f309514a;
        if (r109 == null) goto L40;
        r109.d(this);
        goto L40
    L16:
        if (r107.left != r106.left) goto L18;
        boolean r110 = true;
    L19:
        if (r110 == false) goto L36;
        if (r107.top != r106.top) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == false) goto L36;
        if (r107.right != r106.right) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L36;
        if (r107.bottom != r106.bottom) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L36;
        r108 = true;
        goto L36
    L33:
        r113 = false;
        goto L34
    L28:
        r112 = false;
        goto L29
    L23:
        r111 = false;
        goto L24
    L18:
        r110 = false;
    L40:
        if (r106 == null) goto L42;
        RectF r114 = new RectF(r106);
    L43:
        this.f309515b = r114;
        goto L44
    L42:
        r114 = null;
    L44:
        fh8.r r115 = new fh8.r(new n(r311), new o(r311), new p(r311), new b(r311), new c(r311), new d(r311), new e(r311), new fm8.f(r311), new fm8.g(r311), new fm8.h(r311), new i(r311), new j(r311));
        m r116 = this.f309514a;
        if (r116 == null) goto L48;
        fh8.e.a(r116, this, r310.f477872r, r101, r104, new k(r311, this), new fm8.l(r311, this), new fm8.m(r311, this), null, this.f309516c, r310.f477873s, r115, 128);
        return;
    }
}
