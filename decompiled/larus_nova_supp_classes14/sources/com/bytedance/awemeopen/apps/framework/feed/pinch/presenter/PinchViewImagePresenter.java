package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.ImageCanvasView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PinchViewImagePresenter extends b {
    public View h;
    public final Lazy i;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        sz3.c r0 = this.b;
        Float r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.e;
    L7:
        if (Intrinsics.areEqual(r2, "graphic_detail") == true) goto L9;
        return;
    L9:
        sz3.c r3 = this.b;
        if (r3 == null) goto L14;
        Function0<? extends View> r4 = r3.j;
        if (r4 == null) goto L14;
        View r5 = (View) r4.invoke();
    L15:
        this.h = r5;
        if ((r5 instanceof ImageView) == false) goto L145;
        ImageCanvasView r6 = (ImageCanvasView) this.a.findViewById(2131375091);
        View r7 = this.h;
        if ((r7 instanceof ImageView) == false) goto L20;
        ImageView r8 = (ImageView) r7;
    L21:
        r6.setImageView(r8);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r9 = this.c;
        if (r9 == null) goto L77;
        View r10 = this.a;
        Intrinsics.checkNotNullParameter(r10, "rootView");
        FrameLayout r11 = (FrameLayout) r10.findViewById(2131382321);
        int[] r12 = new int[2];
        View r13 = r9.o();
        if (r13 == null) goto L26;
        ViewParent r14 = r13.getParent();
    L28:
        if ((r14 instanceof ViewGroup) == false) goto L30;
        ViewGroup r15 = (ViewGroup) r14;
    L31:
        if (r15 == null) goto L33;
        r15.getLocationOnScreen(r12);
    L33:
        r11.setX(r12[0]);
        r11.setY(r12[1]);
        ViewGroup.LayoutParams r16 = r11.getLayoutParams();
        View r17 = r9.o();
        if (r17 == null) goto L36;
        ViewParent r18 = r17.getParent();
    L38:
        if ((r18 instanceof ViewGroup) == false) goto L40;
        ViewGroup r19 = (ViewGroup) r18;
    L41:
        if (r19 == null) goto L43;
        int r20 = r19.getWidth();
    L44:
        r16.width = r20;
        View r21 = r9.o();
        if (r21 == null) goto L47;
        ViewParent r22 = r21.getParent();
    L49:
        if ((r22 instanceof ViewGroup) == false) goto L51;
        ViewGroup r23 = (ViewGroup) r22;
    L52:
        if (r23 == null) goto L54;
        int r24 = r23.getHeight();
    L55:
        r16.height = r24;
        r11.setLayoutParams(r16);
        ViewGroup.LayoutParams r25 = r6.getLayoutParams();
        if ((r25 instanceof FrameLayout.LayoutParams) == false) goto L58;
        FrameLayout.LayoutParams r26 = (FrameLayout.LayoutParams) r25;
    L59:
        if (r26 == null) goto L66;
        View r27 = r9.o();
        if (r27 == null) goto L64;
        int r28 = r27.getWidth();
    L65:
        r26.width = r28;
        goto L66
    L64:
        r28 = 0;
    L66:
        if (r26 == null) goto L73;
        View r29 = r9.o();
        if (r29 == null) goto L71;
        int r30 = r29.getHeight();
    L72:
        r26.height = r30;
        goto L73
    L71:
        r30 = 0;
    L73:
        if (r26 == null) goto L76;
        r26.gravity = 17;
    L76:
        r6.setLayoutParams(r26);
        goto L77
    L58:
        r26 = null;
        goto L59
    L54:
        r24 = 0;
        goto L55
    L51:
        r23 = null;
        goto L52
    L47:
        r22 = null;
        goto L49
    L43:
        r20 = 0;
        goto L44
    L40:
        r19 = null;
        goto L41
    L36:
        r18 = null;
        goto L38
    L30:
        r15 = null;
        goto L31
    L26:
        r14 = null;
    L77:
        ViewGroup r31 = this.d;
        if (r31 == null) goto L80;
        r31.setBackgroundColor(-16777216);
    L80:
        r6.setVisibility(0);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r32 = this.c;
        if (r32 == null) goto L143;
        r32.c = r6;
        if ((r32.o() instanceof ImageView) == false) goto L142;
        View r33 = r32.o();
        if (r33 == null) goto L87;
        ViewParent r34 = r33.getParent();
    L89:
        if ((r34 instanceof ViewGroup) == false) goto L91;
        ViewGroup r35 = (ViewGroup) r34;
    L92:
        if (r35 == null) goto L94;
        int r36 = r35.getWidth();
    L95:
        View r37 = r32.o();
        if (r37 == null) goto L98;
        ViewParent r38 = r37.getParent();
    L100:
        if ((r38 instanceof ViewGroup) == false) goto L102;
        ViewGroup r39 = (ViewGroup) r38;
    L103:
        if (r39 == null) goto L105;
        int r40 = r39.getHeight();
    L106:
        View r41 = r32.o();
        if (r41 == null) goto L109;
        int r42 = r41.getWidth();
    L110:
        View r110 = r32.o();
        if (r110 == null) goto L113;
        int r111 = r110.getHeight();
    L114:
        if (r36 <= 0) goto L117;
        r42 = Math.min(r42, r36);
    L117:
        if (r32.m == true) goto L121;
        if (r40 <= 0) goto L121;
        int r43 = Math.min(r111, r40);
    L122:
        sz3.c r44 = r32.d;
        if (r44 == null) goto L141;
        Activity r45 = r44.getActivity();
        if (r45 == null) goto L141;
        if (TextUtils.equals(null, "graphic_detail") == false) goto L141;
        r14.c r46 = r32.e;
        View r47 = r32.o();
        boolean r112 = r32.m;
        Intrinsics.checkNotNullParameter(r45, "context");
        if (r47 != null) goto L131;
        float r48 = 0.0f;
    L136:
        r1 = Float.valueOf(r48);
        if (r32.m == true) goto L140;
        int r49 = com.bytedance.awemeopen.apps.framework.utils.g0.a;
        r111 = Math.min((int) com.bytedance.awemeopen.apps.framework.utils.g0.a(r45, r32.e), r43);
    L140:
        r43 = r111;
        goto L141
    L131:
        int[] r113 = new int[2];
        r47.getLocationOnScreen(r113);
        if (r112 == false) goto L134;
        float r50 = 0;
    L135:
        r48 = r113[1] - r50;
        goto L136
    L134:
        r50 = ((com.bytedance.awemeopen.apps.framework.utils.g0.a(r45, r46) - r47.getHeight()) / 2) + 0;
    L141:
        r32.j.e(r6, Integer.valueOf(r42), Integer.valueOf(r43), r1);
    L121:
        r43 = r111;
        goto L122
    L113:
        r111 = 0;
        goto L114
    L109:
        r42 = 0;
        goto L110
    L105:
        r40 = 0;
        goto L106
    L102:
        r39 = null;
        goto L103
    L98:
        r38 = null;
        goto L100
    L94:
        r36 = 0;
        goto L95
    L91:
        r35 = null;
        goto L92
    L87:
        r34 = null;
        goto L89
    L142:
        r32.j.e(r6, null, null, null);
    L143:
        g(true);
        return;
    L20:
        r8 = null;
        goto L21
    L145:
        return;
    L14:
        r5 = null;
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.e;
    L7:
        if (Intrinsics.areEqual(r1, "graphic_detail") == true) goto L9;
        return;
    L9:
        g(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public PinchViewImagePresenter(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.i = LazyKt.lazy(PinchViewImagePresenter$mPinchingObserver$2.INSTANCE);
    }

    public final void g(boolean r3) {
        if (r3 == false) goto L8;
        sz3.c r4 = this.b;
        if (r4 == null) goto L14;
        qz3.b r5 = r4.i;
        if (r5 == null) goto L15;
        r5.i(null, (Observer) this.i.getValue());
        return;
    L15:
        return;
    L14:
        return;
    L8:
        sz3.c r6 = this.b;
        if (r6 == null) goto L17;
        qz3.b r7 = r6.i;
        if (r7 == null) goto L18;
        r7.h((Observer) this.i.getValue());
        return;
    L18:
        return;
    }
}
