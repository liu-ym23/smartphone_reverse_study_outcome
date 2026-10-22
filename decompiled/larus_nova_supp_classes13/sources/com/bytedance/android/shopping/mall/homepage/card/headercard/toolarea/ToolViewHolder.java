package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int j = 0;
    public final Context a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final BadgeView d;
    public ToolVO e;
    public final ToolItemView f;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a g;
    public final h h;
    public final Function0<Boolean> i;

    public static final class a {
    }

    static {
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
    public final void T3() {
        int r0 = com.bytedance.android.shopping.api.mall.common.tools.e.a;
        SkinConfigStyle r1 = this.g.b();
        String r2 = null;
        if (r1 == null) goto L9;
        SkinConfigStyle.SearchStyle r3 = r1.getSearchStyle();
        if (r3 == null) goto L9;
        SkinConfigStyle.BadgeStyle r4 = r3.getBadgeStyle();
        if (r4 == null) goto L9;
        String r5 = r4.getTextColor();
    L10:
        String r6 = com.bytedance.android.shopping.api.mall.common.tools.e.a(r5);
        boolean r7 = true;
        if (r6 != null) goto L47;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
        int r9 = ContextCompat.getColor(this.a, 2131106130);     // Catch: Exception -> L16
    L24:
        this.d.setTextColor(r9);
        int r10 = com.bytedance.android.shopping.api.mall.common.tools.e.a;
        SkinConfigStyle r11 = this.g.b();
        if (r11 == null) goto L31;
        SkinConfigStyle.SearchStyle r12 = r11.getSearchStyle();
        if (r12 == null) goto L31;
        SkinConfigStyle.BadgeStyle r13 = r12.getBadgeStyle();
        if (r13 == null) goto L31;
        r2 = r13.getBgColor();
    L31:
        String r14 = com.bytedance.android.shopping.api.mall.common.tools.e.a(r2);
        if (r14 != null) goto L46;
    L39:
        if (r7 == false) goto L41;
        int r15 = ContextCompat.getColor(this.a, 2131106126);     // Catch: Exception -> L37
    L44:
        this.d.setBadgeColor(r15);
        return;
    L41:
        r15 = Color.parseColor(r14);     // Catch: Exception -> L37
        goto L44
    L46:
    L37:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r15 = ContextCompat.getColor(this.a, 2131106126);
        goto L44
    L34:
        if (r14.length() == 0) goto L39;
        r7 = false;
        goto L39
    L21:
        r9 = Color.parseColor(r6);     // Catch: Exception -> L16
        goto L24
    L47:
    L16:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r9 = ContextCompat.getColor(this.a, 2131106130);
        goto L24
    L13:
        if (r6.length() == 0) goto L18;
        r8 = false;
    L9:
        r5 = null;
        goto L10
    }

    public ToolViewHolder(ToolItemView r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3, h r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "toolItemView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        Intrinsics.checkNotNullParameter(r4, "toolReporter");
        super(r2);
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = r2.getContext();
        this.b = r2.getIconSdView();
        this.c = r2.getTitleTextView();
        this.d = r2.getBadeView();
        r2.setOnClickListener(new AnonymousClass1(this));
    }
}
