package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public l1(HalfScreenCardComment r1) {
        this.a = r1;
    }

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
    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        this.a.b.o0().invoke();
        HalfScreenCardComment r15 = this.a;
        d r4 = null;
        List<String> r5 = null;
        if (r15.p0 == false) goto L41;
        String r16 = r15.a.O;
        if (r16 != null) goto L7;
    L10:
        boolean r17 = true;
    L11:
        if (r17 == true) goto L41;
        d r18 = this.a.E;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r18 = null;
    L15:
        CommentBean r19 = r18.e(Integer.valueOf(this.a.n.getCurrentItem()));
        if (r19 == null) goto L20;
        List<CommentBean.CommentDetail> r110 = r19.getComment_list();
        if (r110 == null) goto L20;
        CommentBean.CommentDetail r7 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r110);
    L21:
        CommentPagerAdapter r111 = this.a.D;
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r111 = null;
    L24:
        RecyclerView r112 = r111.P0(Integer.valueOf(this.a.n.getCurrentItem()));
        if (r112 == null) goto L27;
        RecyclerView.Adapter r113 = r112.getAdapter();
    L29:
        if ((r113 instanceof ICardAdapter) == false) goto L31;
        ICardAdapter r8 = (ICardAdapter) r113;
    L32:
        if (r7 == null) goto L51;
        if (r8 == null) goto L52;
        HalfScreenCardComment r114 = this.a;
        com.bytedance.ee.bear.middleground.comment.control.y r6 = r114.d;
        View r9 = r114.m;
        d r115 = r114.E;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r115 = null;
    L37:
        CommentBean r116 = r115.e(Integer.valueOf(this.a.n.getCurrentItem()));
        if (r116 == null) goto L40;
        r5 = r116.getParticipantList();
    L40:
        r6.y(r9, r7, r8, 0, r5, true);
        return;
    L52:
        return;
    L51:
        return;
    L31:
        r8 = null;
        goto L32
    L27:
        r113 = null;
    L20:
        r7 = null;
        goto L21
    L7:
        if (r16.length() == 0) goto L10;
        r17 = false;
    L41:
        HalfScreenCardComment r117 = this.a;
        com.bytedance.ee.bear.middleground.comment.control.y r10 = r117.d;
        d r118 = r117.E;
        if (r118 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L45:
        String r11 = r4.f(Integer.valueOf(this.a.n.getCurrentItem()));
        if (this.a.a.o != 0) goto L48;
        boolean r12 = true;
    L49:
        com.bytedance.ee.bear.middleground.comment.control.x.a(r10, r11, 0, r12, false, false, null, 48);
        return;
    L48:
        r12 = false;
        goto L49
    L44:
        r4 = r118;
        goto L45
    }
}
