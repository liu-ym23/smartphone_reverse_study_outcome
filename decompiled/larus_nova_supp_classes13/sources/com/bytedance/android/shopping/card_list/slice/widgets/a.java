package com.bytedance.android.shopping.card_list.slice.widgets;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ BottomButtonContainerView d;
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.context.b e;
    public final /* synthetic */ List f;

    public a(LinearLayout r1, String r2, String r3, BottomButtonContainerView r4, com.bytedance.android.ecom.arch.slice.render.context.b r5, List r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
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
    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        View r0 = new View(this.a.getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(0, -1));
        r0.setBackground(r10.getBackground());
        if (Intrinsics.areEqual(this.c, "delete") == false) goto L6;
        this.d.addView(r0);
        BottomButtonContainerView.b(this.d, r0, this.c, this.e, 1);
        return;
    L6:
        if (Intrinsics.areEqual(this.c, "collect") == false) goto L23;
        SlcRoundLinearlayout r1 = this.d;
        int r4 = r1.getChildCount();
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L22;
        View r6 = r1.getChildAt(r5);
        if ((!Intrinsics.areEqual(r6, r10)) == false) goto L21;
        int r7 = s.a;
        Integer r8 = s.b(this.b);
        if (r8 == null) goto L14;
        int r9 = r8.intValue();
    L15:
        r6.setBackgroundColor(r9);
        TextView r11 = (TextView) r6.findViewById(2131388772);
        if (r11 == null) goto L18;
        r11.setVisibility(8);
    L18:
        ECDraweeView r12 = r6.findViewById(2131374718);
        if (r12 == null) goto L21;
        r12.setVisibility(8);
        goto L21
    L14:
        r9 = 0;
    L21:
        r5 = r5 + 1;
        goto L8
    L22:
        this.d.addView(r0);
        BottomButtonContainerView.b(this.d, r0, this.c, this.e, this.f.size());
        return;
    L23:
        BaseSlcViewManager r13 = SlcViewExtensionsKt.g(this.d);
        if (r13 == null) goto L33;
        r13.a.d(new SlcCommonAction(this.c + "Click", MapsKt.emptyMap()), this.d, r13.l(), null, null);
        return;
    }
}
