package com.bytedance.ee.bear.more.view3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.l;
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.more.view3.ui.UINormalItem;
import com.bytedance.ee.bear.more.view3.ui.h;
import com.bytedance.ee.bear.more.view3.ui.i;
import com.bytedance.ee.bear.more.view3.ui.j;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements l {
    public static final d a = null;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ IBaseMoreItem a;

        public a(IBaseMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ((IGridMoreItem) this.a).onClick();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ IBaseMoreItem a;

        public static final class a implements ISwitchMoreItem.a {
            public final /* synthetic */ IBaseMoreItem a;

            @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem.a
            public final void notifyItemChanged() {
                this.a.notifyItemChanged();
            }

            public a(IBaseMoreItem r1) {
                this.a = r1;
            }
        }

        public b(IBaseMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            IBaseMoreItem r4 = this.a;
            ((ISwitchMoreItem) r4).onCheckStateChange(new a(r4));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ IBaseMoreItem a;

        public static final class a implements ISwitchMoreItem.a {
            public final /* synthetic */ IBaseMoreItem a;

            @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem.a
            public final void notifyItemChanged() {
                this.a.notifyItemChanged();
            }

            public a(IBaseMoreItem r1) {
                this.a = r1;
            }
        }

        public c(IBaseMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            IBaseMoreItem r4 = this.a;
            ((ILoadingSwitchMoreItem) r4).onCheckStateChange(new a(r4));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.view3.d$d, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0123d implements View.OnClickListener {
        public final /* synthetic */ IBaseMoreItem a;

        public ViewOnClickListenerC0123d(IBaseMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ((ITextMoreItem) this.a).onClick();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ IBaseMoreItem a;

        public e(IBaseMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ((ITextMoreItem) this.a).onDisableClick();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ IBaseMoreItem a;

        public f(IBaseMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ((ITextMoreItem) this.a).onClick();
        }
    }

    static {
        a = new d();
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final g buildHeader() {
        return new zj5.a();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final k a(IBaseMoreItem r35, com.bytedance.ee.bear.more.protocol3.a r36, m r37) {
        Intrinsics.checkNotNullParameter(r35, "moreItem");
        Intrinsics.checkNotNullParameter(r36, "extendEnableChecker");
        Intrinsics.checkNotNullParameter(r37, "extendVisibleChecker");
        sj5.a r4 = null;
        if (r35.isVisible() == true) goto L5;
    L99:
        return null;
    L5:
        if (r37.isVisible() == false) goto L99;
        boolean r1 = r36.isEnable();
        String r3 = r36.b();
        if ((r35 instanceof IGridMoreItem) == false) goto L32;
        String r9 = r35.getId();
        IGridMoreItem r5 = (IGridMoreItem) r35;
        String r10 = r5.getTitle();
        int r11 = r5.getIcon();
        int r12 = r5.getIconTint();
        boolean r13 = r5.needShowBadge();
        if (r5.isEnable() == true) goto L12;
    L14:
        boolean r16 = false;
    L15:
        String r2 = r35.getItemDisableReasonByJSMsg();
        if (r2 != null) goto L18;
        r2 = r5.getUnableTips();
    L18:
        String r17 = r2;
        a r6 = new a(r35);
        boolean r7 = r35 instanceof sj5.a;
        if (r7 == false) goto L21;
        final sj5.a r8 = (sj5.a) r35;
    L22:
        if (r8 == null) goto L24;
        Function2<Context, Integer, Drawable> r21 = new UIMoreItemFactoryImpl$customIconDrawableProvider$1$1(r8);
    L25:
        if (r7 == false) goto L27;
        r4 = (sj5.a) r35;
    L27:
        if (r4 == null) goto L29;
        boolean r22 = r4.getShouldIgnoreIconTint();
    L96:
        return new UINormalItem(r9, r10, r11, r12, r13, false, false, r16, r17, r6, null, null, r21, r22);
    L29:
        r22 = false;
        goto L96
    L24:
        r21 = null;
        goto L25
    L21:
        r8 = null;
        goto L22
    L12:
        if (r36.isEnable() == false) goto L14;
        r16 = true;
        goto L15
    L32:
        if ((r35 instanceof ISwitchMoreItem) == false) goto L44;
        boolean r14 = y.a();
        if (r14 == true) goto L36;
        y.c("UIMoreItemFactoryImpl", r35.getId());
    L36:
        if (r14 == false) goto L38;
        boolean r18 = r1;
    L39:
        if (r14 == false) goto L41;
        String r19 = r3;
    L42:
        ISwitchMoreItem r15 = (ISwitchMoreItem) r35;
        return new j(r35.getId(), r15.getTitle(), r15.getIcon(), r15.getIconTint(), false, "", r15.isCheck(), r18, r19, new b(r35));
    L41:
        r19 = "";
        goto L42
    L38:
        r18 = true;
        goto L39
    L44:
        if ((r35 instanceof ILoadingSwitchMoreItem) == false) goto L56;
        boolean r20 = y.a();
        if (r20 == true) goto L48;
        y.c("UIMoreItemFactoryImpl", r35.getId());
    L48:
        if (r20 == false) goto L50;
        boolean r110 = r1;
    L51:
        if (r20 == false) goto L53;
        String r111 = r3;
    L54:
        ILoadingSwitchMoreItem r23 = (ILoadingSwitchMoreItem) r35;
        return new com.bytedance.ee.bear.more.view3.ui.g(r35.getId(), r23.getTitle(), r23.getIcon(), r23.getIconTint(), r23.isCheck(), r23.isLoading(), r110, r111, new c(r35));
    L53:
        r111 = "";
        goto L54
    L50:
        r110 = true;
        goto L51
    L56:
        if ((r35 instanceof ITextMoreItem) == false) goto L98;
        ITextMoreItem r24 = (ITextMoreItem) r35;
        if (r24.getStateTips().length() != 0) goto L60;
        boolean r25 = true;
    L61:
        if (r25 == false) goto L85;
        String r26 = r35.getId();
        String r112 = r24.getTitle();
        int r113 = r24.getIcon();
        int r114 = r24.getIconTint();
        boolean r115 = r24.needShowBadge();
        if (r24.isEnable() == true) goto L65;
    L67:
        boolean r116 = false;
    L68:
        String r27 = r35.getItemDisableReasonByJSMsg();
        if (r27 != null) goto L71;
        r27 = r24.getUnableTips();
    L71:
        String r117 = r27;
        ViewOnClickListenerC0123d r28 = new ViewOnClickListenerC0123d(r35);
        e r29 = new e(r35);
        MoreUiAction r210 = r24.getMoreAction();
        boolean r30 = r35 instanceof sj5.a;
        if (r30 == false) goto L74;
        final sj5.a r31 = (sj5.a) r35;
    L75:
        if (r31 == null) goto L77;
        Function2<Context, Integer, Drawable> r211 = new UIMoreItemFactoryImpl$customIconDrawableProvider$1$1(r31);
    L78:
        if (r30 == false) goto L80;
        r4 = (sj5.a) r35;
    L80:
        if (r4 == null) goto L82;
        boolean r212 = r4.getShouldIgnoreIconTint();
    L83:
        k r32 = new UINormalItem(r26, r112, r113, r114, r115, false, false, r116, r117, r28, r29, r210, r211, r212);
    L102:
        return r32;
    L82:
        r212 = false;
        goto L83
    L77:
        r211 = null;
        goto L78
    L74:
        r31 = null;
        goto L75
    L65:
        if (r36.isEnable() == false) goto L67;
        r116 = true;
        goto L68
    L85:
        String r213 = r35.getId();
        String r214 = r24.getTitle();
        int r215 = r24.getIcon();
        int r216 = r24.getIconTint();
        boolean r217 = r24.needShowBadge();
        String r33 = r24.getStateTips();
        if (r24.isEnable() == true) goto L88;
    L90:
        boolean r34 = false;
    L91:
        String r38 = r35.getItemDisableReasonByJSMsg();
        if (r38 != null) goto L94;
        String r39 = r24.getUnableTips();
    L95:
        r32 = new com.bytedance.ee.bear.more.view3.ui.e(r213, r214, r215, r216, r217, false, r33, r34, r39, new f(r35));
        goto L102
    L94:
        r39 = r38;
        goto L95
    L88:
        if (r36.isEnable() == false) goto L90;
        r34 = true;
        goto L91
    L60:
        r25 = false;
        goto L61
    L98:
        throw new IllegalStateException("Illegal MoreItem: ".concat(r35.getClass().getSimpleName()));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final k b(com.bytedance.ee.bear.more.protocol3.f r21, com.bytedance.ee.bear.more.protocol3.e r22, List<? extends m> r23, List<? extends com.bytedance.ee.bear.more.protocol3.a> r24, View.OnClickListener r25) {
        Intrinsics.checkNotNullParameter(r21, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r22, "style");
        View.OnClickListener r2 = null;
        if (r23 == null) goto L11;
        Iterator<? extends m> r3 = r23.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        if (r3.next().isVisible() == true) goto L6;
        return null;
    L11:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.a) == false) goto L15;
        return new com.bytedance.ee.bear.more.view3.ui.c(r21.a, ((com.bytedance.ee.bear.more.protocol3.e.a) r22).a);
    L15:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.d) == false) goto L18;
        com.bytedance.ee.bear.more.protocol3.e.d r1 = (com.bytedance.ee.bear.more.protocol3.e.d) r22;
        return new com.bytedance.ee.bear.more.view3.ui.f(r21.a, r1.a, r1.b);
    L18:
        String r5 = r21.a;
        com.bytedance.ee.bear.more.protocol3.d r4 = r21.b;
        String r6 = r4.d;
        if (r6 != null) goto L21;
        String r7 = eu5.b.a.getString(r4.a);
    L22:
        com.bytedance.ee.bear.more.protocol3.d r0 = r21.b;
        int r8 = r0.b;
        int r9 = r0.c;
        if (r24 == null) goto L30;
        Iterator<? extends com.bytedance.ee.bear.more.protocol3.a> r10 = r24.iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        com.bytedance.ee.bear.more.protocol3.a r11 = r10.next();
        if (r11.isEnable() == true) goto L26;
        String r12 = r11.b();
        r2 = r11.a();
        String r13 = r12;
        boolean r14 = false;
    L32:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.h) == false) goto L35;
        com.bytedance.ee.bear.more.protocol3.e.h r15 = (com.bytedance.ee.bear.more.protocol3.e.h) r22;
        return new j(r5, r7, r8, r9, r15.b, r15.c, r15.a, r14, r13, r25);
    L35:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.c) == false) goto L38;
        com.bytedance.ee.bear.more.protocol3.e.c r16 = (com.bytedance.ee.bear.more.protocol3.e.c) r22;
        return new com.bytedance.ee.bear.more.view3.ui.e(r5, r7, r8, r9, r16.a, r16.b, r16.c, r14, r13, r25);
    L38:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.f) == false) goto L41;
        com.bytedance.ee.bear.more.protocol3.e.f r17 = (com.bytedance.ee.bear.more.protocol3.e.f) r22;
        return new UINormalItem(r5, r7, r8, r9, r17.a, r17.b, r17.c, r14, r13, r25, r2, null, null, false);
    L41:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.b) == false) goto L44;
        com.bytedance.ee.bear.more.protocol3.e.b r18 = (com.bytedance.ee.bear.more.protocol3.e.b) r22;
        boolean r19 = r14;
        String r110 = r13;
        return new com.bytedance.ee.bear.more.view3.ui.d(r5, r7, r8, r9, r18.b, r18.c, r19, r110, r25, r18.d, r18.e, r18.a);
    L44:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.g) == false) goto L48;
        boolean r20 = r14;
        String r111 = r13;
        k r112 = new i(r5, r7, r8, r9, r20, r111, ((com.bytedance.ee.bear.more.protocol3.e.g) r22).b, r25, r2);
    L62:
        return r112;
    L48:
        if ((r22 instanceof com.bytedance.ee.bear.more.protocol3.e.C0118e) == false) goto L52;
        r112 = new h(r5, r7, r8, r9, ((com.bytedance.ee.bear.more.protocol3.e.C0118e) r22).a, r14, r13, r25, r2);
        goto L62
    L52:
        throw new IllegalStateException("Illegal MoreItemStyle: ".concat(r22.getClass().getSimpleName()));
    L30:
        r14 = true;
        r13 = "";
        goto L32
    L21:
        r7 = r6;
        goto L22
    }
}
