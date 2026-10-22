package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.blur.f;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpBgDecorProjectionViewManagerOptimized extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b {
    public final SlcTemplateContext W3;

    public static final class a {
    }

    static {
    }

    public PdpBgDecorProjectionViewManagerOptimized(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        super(r2);
        this.W3 = r2;
    }

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return J1(r1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void H0(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "props");
        Object r0 = getView();
        if ((r0 instanceof SlcBgDecorProjectionOptimizedView) == true) goto L5;
        r0 = null;
    L5:
        SlcBgDecorProjectionOptimizedView r1 = (SlcBgDecorProjectionOptimizedView) r0;
        if (r1 == null) goto L32;
        Object r8 = r7.get("mask_color");
        if ((r8 instanceof Number) == false) goto L11;
        Integer r9 = Integer.valueOf((int) ((Number) r8).longValue());
    L14:
        if (r9 == null) goto L16;
        int r10 = r9.intValue();
    L18:
        if (r1.H == r10) goto L37;
        r1.H = r10;
        int r2 = r1.e.getChildCount();
        int r3 = 0;
    L21:
        if (r3 >= r2) goto L38;
        View r4 = r1.e.getChildAt(r3);
        if ((r4 instanceof SlcBgDecorProjectionOptimizedView.a) == true) goto L25;
        r4 = null;
    L25:
        SlcBgDecorProjectionOptimizedView.a r5 = (SlcBgDecorProjectionOptimizedView.a) r4;
        if (r5 == null) goto L31;
        if (r5.b == r10) goto L31;
        r5.b = r10;
        r5.invalidate();
    L31:
        r3 = r3 + 1;
        goto L21
    L38:
        return;
    L37:
        return;
    L16:
        r10 = 1728053247;
        goto L18
    L11:
        if ((r8 instanceof String) == false) goto L13;
        int r6 = s.a;
        r9 = s.b((String) r8);
        goto L14
    L13:
        r9 = null;
        goto L14
    }

    public final SlcFlexElementView J1(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Object r0 = this.W3.w.g(AnchorV4VM.class);
        View r2 = null;
        if ((r0 instanceof AnchorV4VM) == true) goto L5;
        r0 = null;
    L5:
        final AnchorV4VM r1 = (AnchorV4VM) r0;
        Object r3 = this.W3.w.g(l.class);
        if ((r3 instanceof l) == true) goto L8;
        r3 = null;
    L8:
        final l r4 = (l) r3;
        if (r1 == null) goto L11;
        final v r5 = r1.getHeadViewAbilityV2New();
    L12:
        final SlcBgDecorProjectionOptimizedView r6 = new SlcBgDecorProjectionOptimizedView(r8, new f(r8));
        if (r5 == null) goto L15;
        View r9 = r5.e();
    L16:
        if (r9 != null) goto L22;
        if (r1 == null) goto L21;
        d83.c r10 = r1.getHeadViewAbilityNew();
        if (r10 == null) goto L21;
        r9 = r10.e();
    L21:
        r9 = null;
    L22:
        if (r9 != null) goto L27;
        if (r4 == null) goto L25;
        r9 = r4.k1();
        goto L27
    L25:
        r9 = null;
    L27:
        if ((r9 instanceof RecyclerView) == false) goto L30;
        r2 = r9;
    L30:
        RecyclerView r7 = (RecyclerView) r2;
        if (r7 == null) goto L47;
        Intrinsics.checkNotNullParameter(r7, "headRv");
        WeakReference<RecyclerView> r11 = r6.h;
        if (r11 == null) goto L37;
        RecyclerView r12 = r11.get();
        if (r12 == null) goto L37;
        r12.removeOnScrollListener(r6.N);
    L37:
        r6.h = new WeakReference(r7);
        if (r6.L == false) goto L40;
    L42:
        r7.post(new c(r6, r7));
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.a r13 = new com.bytedance.android.shopping.slice.elements.bgdecorprojection.a(r6, new PdpBgDecorProjectionViewManagerOptimized$onCreateView$$inlined$let$lambda$1(r6, r4, r5, r1), new PdpBgDecorProjectionViewManagerOptimized$onCreateView$$inlined$let$lambda$2(r6, r4, r5, r1), new PdpBgDecorProjectionViewManagerOptimized$onCreateView$$inlined$let$lambda$3(r6, r4, r5, r1));
        if (r4 == null) goto L45;
        r4.x(r13);
    L45:
        if (r5 == null) goto L47;
        r5.x(r13);
        goto L47
    L40:
        if (r6.M == true) goto L42;
        r7.addOnScrollListener(r6.N);
    L47:
        return r6;
    L15:
        r9 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    }
}
