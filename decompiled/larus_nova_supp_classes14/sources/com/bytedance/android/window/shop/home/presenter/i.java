package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends j {
    public ECDraweeView m;
    public View n;
    public View o;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            uq3.a r11 = (uq3.a) r10;
            uq3.a r12 = (uq3.a) this.a.O().getHeaderResponse().getValue();
            Integer r0 = null;
            if (r12 == null) goto L7;
            uq3.o r13 = r12.c;
            if (r13 == null) goto L7;
            ECUrlModel r2 = r13.g;
        L8:
            uq3.a r14 = (uq3.a) this.a.O().getHeaderResponse().getValue();
            if (r14 == null) goto L13;
            uq3.o r15 = r14.c;
            if (r15 == null) goto L13;
            r0 = r15.h;
        L13:
            if (r2 == null) goto L29;
            if (r0 != null) goto L16;
            return;
        L16:
            if (this.a.F() == true) goto L31;
            ECDraweeView r1 = this.a.m;
            if (r1 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("baseBgPic");
        L21:
            com.bytedance.android.ec.core.imagex.h0.d(r1, r2, this.a.O().getImageCallerContext(), null, null, null, null, 120);
            View r16 = this.a.n;
            if (r16 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("bgSecondPart");
        L24:
            r16.setBackgroundColor(r0.intValue());
            GradientDrawable r17 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) 71.4d, Color.red(r0.intValue()), Color.green(r0.intValue()), Color.blue(r0.intValue())), r0.intValue()});
            View r3 = this.a.o;
            if (r3 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
        L27:
            r3.setBackgroundDrawable(r17);
            return;
        L31:
            return;
        L29:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ i a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        public c(i r1, float r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
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
        public final void onChanged(Object r4) {
            Pair r5 = (Pair) r4;
            GenericDraweeView r0 = this.a.m;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("baseBgPic");
        L5:
            r0.setY(this.b - Math.abs(((Number) r5.getFirst()).intValue()));
            View r1 = this.a.o;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
        L8:
            r1.setY(this.c - Math.abs(((Number) r5.getFirst()).intValue()));
        }
    }

    static {
    }

    public i() {
    }

    public final void A(QModel r6) {
        this.m = (ECDraweeView) w().b(2131371293).f();
        this.n = w().b(2131371295).f();
        this.o = w().b(2131371298).f();
        O().getHeaderResponse().a(U(), new b(this), false);
        GenericDraweeView r7 = this.m;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseBgPic");
    L5:
        float r8 = r7.getY();
        View r0 = this.o;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
    L8:
        float r1 = r0.getY();
        O().getOffsetState().a(U(), new c(this, r8, r1), false);
    }
}
