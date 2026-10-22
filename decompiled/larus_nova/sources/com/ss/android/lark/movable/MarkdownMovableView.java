package com.ss.android.lark.movable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.island.MovableIslandsOpsApplier;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010!\u001a\u00020\"2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\"0$¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0014J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\u001cH\u0007J$\u0010*\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-J\b\u0010.\u001a\u00020\"H\u0016J\u0017\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\"H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RT\u0010\u0014\u001aF\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/movable/MarkdownMovableView;", "Lcom/ss/android/lark/movable/MovableView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ownedParsedDocumentReleaseHandle", "Lcom/ss/android/lark/movable/MovableDocumentReleaseHandle;", "markdownRenderScope", "Lkotlinx/coroutines/CoroutineScope;", "currentMarkdown", "", "renderConfig", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "getRenderConfig$movable_release", "()Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "setRenderConfig$movable_release", "(Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;)V", "markParser", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "markdown", "", "widthDp", "Lkotlin/coroutines/Continuation;", "Lcom/ss/android/lark/movable/ParsedMovableDocument;", "", "Lkotlin/jvm/functions/Function3;", "manualHandleReleasing", "", "setupMarkdown", "", "block", "Lkotlin/Function1;", "Lcom/ss/android/lark/movable/MarkdownMovableView$Config;", "Lkotlin/ExtensionFunctionType;", "applyConfig", "config", "Lcom/ss/android/lark/movable/MovableView$Config;", "renderMarkdown", "parsedDocument", "urlPreviewInlines", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInlines;", "onRecycled", "releaseOwnedParsedDocumentIfNeed", "documentId", "Lkotlin/UInt;", "releaseOwnedParsedDocumentIfNeed-WZ4Q5Ns", "(I)V", "releaseOwnedParsedDocument", "Config", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownMovableView extends MovableView {
    public d B;
    public final CoroutineScope C;
    public String D;
    public MovableRenderConfig E;
    public Function3<? super String, ? super Float, ? super Continuation<? super h>, ? extends Object> F;
    public boolean G;

    public static final class a extends MovableView.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f432540g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public MovableRenderConfig f432541h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Function3<? super String, ? super Float, ? super Continuation<? super h>, ? extends Object> f432542i;

        public a() {
        }
    }

    @Override // com.ss.android.lark.movable.MovableView
    public final void d() {
        if (this.G == true) goto L9;
        d r100 = this.B;
        if (r100 == null) goto L8;
        r100.a();
    L8:
        this.B = null;
    L9:
        this.D = null;
        this.E = null;
        this.F = null;
        JobKt.cancelChildren$default(this.C.getCoroutineContext(), null, 1, null);
        super.d();
    }

    public final MovableRenderConfig getRenderConfig$movable_release() {
        return this.E;
    }

    public MarkdownMovableView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.ss.android.lark.movable.MovableView
    public final void b(MovableView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        final Function2<? super Integer, ? super Integer, Unit> r101 = r100.f432591e;
        r100.f432591e = new MarkdownMovableView$applyConfig$1(this, r101);
        super.b(r100);
        if ((r100 instanceof a) == false) goto L6;
        a r102 = (a) r100;
        this.G = r102.f432540g;
        this.E = r102.f432541h;
        this.F = r102.f432542i;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View, android.widget.FrameLayout, com.ss.android.lark.movable.MarkdownMovableView, com.ss.android.lark.movable.MovableView] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void j(h r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.G == true) goto L11;
        d r100 = this.B;
        if (r100 == null) goto L10;
        r100.a();
    L10:
        this.B = null;
    L11:
        this.B = r110.f432667b;
        int r101 = r110.f432666a.m8423getDocumentIdpVg5ArA();
        d r102 = this.B;
        if (r102 != null) goto L15;
    L22:
        MovableDocumentInfo r111 = r110.f432666a;
        Intrinsics.checkNotNullParameter(r111, "originDocumentInfo");
        Context r103 = getContext();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        MovableDocumentInfo r104 = MovableDocumentInfo.m8419copySOCY_n4$default(r111, 0, 0, com.ss.android.lark.movable.utils.b.d(r111.getWidth(), r103), com.ss.android.lark.movable.utils.b.d(r111.getHeight(), r103), 3, null);
        int r105 = r104.m8423getDocumentIdpVg5ArA();
        MovableDocumentInfo r106 = getMovableDocumentInfo();
        if (r106 == null) goto L25;
        UInt r107 = UInt.m9538boximpl(r106.m8423getDocumentIdpVg5ArA());
    L26:
        boolean r108 = UInt.m9550equalsimpl(r105, r107);
        boolean r109 = false;
        if (r108 == false) goto L39;
        int r112 = r104.m8424getDocumentVersionpVg5ArA();
        MovableDocumentInfo r113 = getMovableDocumentInfo();
        if (r113 == null) goto L31;
        int r114 = r113.m8424getDocumentVersionpVg5ArA();
    L33:
        if (Integer.compare(r112 ^ Integer.MIN_VALUE, r114 ^ Integer.MIN_VALUE) > 0) goto L39;
        StringBuilder r115 = new StringBuilder("receive lower document version, ignore，curVersion:");
        MovableDocumentInfo r116 = getMovableDocumentInfo();
        if (r116 == null) goto L37;
        int r117 = r116.m8424getDocumentVersionpVg5ArA();
    L38:
        r115.append(UInt.m9590toStringimpl(r117));
        r115.append(", newVersion:");
        r115.append(UInt.m9590toStringimpl(r104.m8424getDocumentVersionpVg5ArA()));
        Log.i("MovableView", r115.toString());
        MovableView.c r118 = null;
    L52:
        if (r118 == null) goto L100;
        this.f432568h++;
    L85:
        e = move-exception;
        Log.e("MovableView", "render failed: " + e.getMessage(), e);
        return;
    L56:
        if (this.f432569i == false) goto L58;
        byte[] r119 = Lark_markdown_renderKt.m8401ffiRequestRenderStreamfeOb9K0(r118.f432595c, r118.f432596d);     // Catch: Exception -> L85
    L59:
        byte[] r120 = Lark_markdown_renderKt.m8393ffiMovableRequestAttachmentsDiffzly0blg(r118.f432596d, 0, r118.f432595c);     // Catch: Exception -> L85
        byte[] r121 = Lark_markdown_renderKt.m8395ffiMovableRequestIslandsDiffzly0blg(r118.f432596d, 0, r118.f432595c);     // Catch: Exception -> L85
        Log.i("MovableView", "render main fetched: doc=" + r118.f432594b.toString() + ", sizes(common=" + r119.length + ", attach=" + r120.length + ", islands=" + r121.length + ')');     // Catch: Exception -> L85
        i(r119, r118.f432593a);     // Catch: Exception -> L85
        g(r120);     // Catch: Exception -> L85
        h(r118.f432597e);     // Catch: Exception -> L85
        if (Arrays.equals(this.f432566f, r121) == false) goto L62;
        List r122 = null;
    L64:
        if (r122 == null) goto L69;
        ?? r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));     // Catch: Exception -> L85
        Iterator r124 = r122.iterator();     // Catch: Exception -> L85
    L67:
        if (r124.hasNext() == false) goto L70;
        r123.add(Integer.valueOf(((jsb.a) ((Pair) r124.next()).getSecond()).f500270a));     // Catch: Exception -> L85
    L70:
        Iterable r125 = (Iterable) r123;     // Catch: Exception -> L85
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));     // Catch: Exception -> L85
        Iterator r127 = r125.iterator();     // Catch: Exception -> L85
    L72:
        if (r127.hasNext() == false) goto L83;
        int r128 = ((Number) r127.next()).intValue();     // Catch: Exception -> L85
        if (this.f432569i == false) goto L77;
        byte[] r129 = Lark_markdown_renderKt.m8399ffiRequestIslandRenderStreamzly0blg(r118.f432595c, r118.f432596d, UInt.m9544constructorimpl(r128));     // Catch: Exception -> L80
    L78:
        Pair r130 = TuplesKt.to(Integer.valueOf(r128), r129);     // Catch: Exception -> L80
    L82:
        r126.add(r130);     // Catch: Exception -> L85
        goto L72
    L77:
        r129 = Lark_markdown_renderKt.m8400ffiRequestIslandRenderStreamInTextApizly0blg(r118.f432595c, r118.f432596d, UInt.m9544constructorimpl(r128));     // Catch: Exception -> L80
        goto L78
    L80:
        e = move-exception;
        Log.e("MovableView", "Failed to request island " + r128 + ": " + e.getMessage());     // Catch: Exception -> L85
        r130 = TuplesKt.to(Integer.valueOf(r128), null);     // Catch: Exception -> L85
        goto L82
    L83:
        c(r118, r126, r109, r122);     // Catch: Exception -> L85
        return;
    L69:
        r123 = CollectionsKt.emptyList();     // Catch: Exception -> L85
        goto L70
    L62:
        this.f432566f = r121;     // Catch: Exception -> L85
        int r131 = MovableIslandsOpsApplier.f432668c;     // Catch: Exception -> L85
        r122 = MovableIslandsOpsApplier.a.a(r121, getContext());     // Catch: Exception -> L85
        r109 = true;
        goto L64
    L58:
        r119 = Lark_markdown_renderKt.m8402ffiRequestRenderStreamInTextApifeOb9K0(r118.f432595c, r118.f432596d);     // Catch: Exception -> L85
        goto L59
    L100:
        return;
    L37:
        r117 = 0;
        goto L38
    L31:
        r114 = 0;
    L39:
        this.f432580t = r111;
        StringBuilder r132 = new StringBuilder("updateMovableDocumentInfo called: documentId =");
        MovableDocumentInfo r133 = this.f432580t;
        if (r133 == null) goto L42;
        UInt r134 = UInt.m9538boximpl(r133.m8423getDocumentIdpVg5ArA());
    L43:
        r132.append(r134);
        r132.append(", documentVersion = ");
        MovableDocumentInfo r135 = this.f432580t;
        if (r135 == null) goto L46;
        UInt r136 = UInt.m9538boximpl(r135.m8424getDocumentVersionpVg5ArA());
    L47:
        r132.append(r136);
        Log.d("MovableView", r132.toString());
        Log.i("MovableView", "hashCode: " + hashCode() + ", start render MovableView: " + r111.toString() + ", inStreaming: false");
        float r137 = r104.getWidth();
        float r138 = r104.getHeight();
        int r139 = getLayoutParams().height;
        int r140 = (int) r138;
        ViewGroup.LayoutParams r141 = getLayoutParams();
        if (r141 == null) goto L91;
        r141.width = (int) r137;
        setLayoutParams(r141);
        ViewGroup.LayoutParams r142 = getLayoutParams();
        if (r142 == null) goto L89;
        r142.height = r140;
        setLayoutParams(r142);
        r118 = new MovableView.c(r111, r104, r104.m8424getDocumentVersionpVg5ArA(), r104.m8423getDocumentIdpVg5ArA());
        goto L52
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L46:
        r136 = null;
        goto L47
    L42:
        r134 = null;
        goto L43
    L25:
        r107 = null;
        goto L26
    L15:
        if (r102.f432659a == r101) goto L22;
        if (this.G == true) goto L22;
        if (r102 == null) goto L21;
        r102.a();
    L21:
        this.B = null;
        goto L22
    }

    public final void setRenderConfig$movable_release(MovableRenderConfig r100) {
        this.E = r100;
    }

    public final void setupMarkdown(Function1<? super a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        a r101 = new a();
        r100.invoke(r101);
        setupWithConfig(r101);
    }

    public MarkdownMovableView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.C = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void k(MarkdownMovableView r110, String r111, float r112) {
        if (r111 != null) goto L5;
        r110.getClass();
        return;
    L5:
        r110.D = r111;
        BuildersKt.launch$default(r110.C, null, null, new MarkdownMovableView$renderMarkdown$1(r110, r111, r112, null, null), 3, null);
    }
}
