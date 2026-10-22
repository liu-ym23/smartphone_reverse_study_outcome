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
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f235024a = null;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseMoreItem f235025a;

        public a(IBaseMoreItem r100) {
            this.f235025a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((IGridMoreItem) this.f235025a).onClick();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseMoreItem f235026a;

        public static final class a implements ISwitchMoreItem.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBaseMoreItem f235027a;

            @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem.a
            public final void notifyItemChanged() {
                this.f235027a.notifyItemChanged();
            }

            public a(IBaseMoreItem r100) {
                this.f235027a = r100;
            }
        }

        public b(IBaseMoreItem r100) {
            this.f235026a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            IBaseMoreItem r101 = this.f235026a;
            ((ISwitchMoreItem) r101).onCheckStateChange(new a(r101));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseMoreItem f235028a;

        public static final class a implements ISwitchMoreItem.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBaseMoreItem f235029a;

            @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem.a
            public final void notifyItemChanged() {
                this.f235029a.notifyItemChanged();
            }

            public a(IBaseMoreItem r100) {
                this.f235029a = r100;
            }
        }

        public c(IBaseMoreItem r100) {
            this.f235028a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            IBaseMoreItem r101 = this.f235028a;
            ((ILoadingSwitchMoreItem) r101).onCheckStateChange(new a(r101));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.view3.d$d, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3370d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseMoreItem f235030a;

        public ViewOnClickListenerC3370d(IBaseMoreItem r100) {
            this.f235030a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((ITextMoreItem) this.f235030a).onClick();
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseMoreItem f235031a;

        public e(IBaseMoreItem r100) {
            this.f235031a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((ITextMoreItem) this.f235031a).onDisableClick();
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseMoreItem f235032a;

        public f(IBaseMoreItem r100) {
            this.f235032a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((ITextMoreItem) this.f235032a).onClick();
        }
    }

    static {
        f235024a = new d();
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final g buildHeader() {
        return new zj5.a();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final k a(IBaseMoreItem r310, com.bytedance.ee.bear.more.protocol3.a r311, m r312) {
        Intrinsics.checkNotNullParameter(r310, "moreItem");
        Intrinsics.checkNotNullParameter(r311, "extendEnableChecker");
        Intrinsics.checkNotNullParameter(r312, "extendVisibleChecker");
        sj5.a r100 = null;
        if (r310.isVisible() == true) goto L5;
    L99:
        return null;
    L5:
        if (r312.isVisible() == false) goto L99;
        boolean r101 = r311.isEnable();
        String r102 = r311.b();
        if ((r310 instanceof IGridMoreItem) == false) goto L32;
        String r103 = r310.getId();
        IGridMoreItem r104 = (IGridMoreItem) r310;
        String r110 = r104.getTitle();
        int r111 = r104.getIcon();
        int r112 = r104.getIconTint();
        boolean r113 = r104.needShowBadge();
        if (r104.isEnable() == true) goto L12;
    L14:
        boolean r114 = false;
    L15:
        String r105 = r310.getItemDisableReasonByJSMsg();
        if (r105 != null) goto L18;
        r105 = r104.getUnableTips();
    L18:
        String r115 = r105;
        a r106 = new a(r310);
        boolean r107 = r310 instanceof sj5.a;
        if (r107 == false) goto L21;
        final sj5.a r108 = (sj5.a) r310;
    L22:
        if (r108 == null) goto L24;
        Function2<Context, Integer, Drawable> r210 = new UIMoreItemFactoryImpl$customIconDrawableProvider$1$1(r108);
    L25:
        if (r107 == false) goto L27;
        r100 = (sj5.a) r310;
    L27:
        if (r100 == null) goto L29;
        boolean r211 = r100.getShouldIgnoreIconTint();
    L96:
        return new UINormalItem(r103, r110, r111, r112, r113, false, false, r114, r115, r106, null, null, r210, r211);
    L29:
        r211 = false;
        goto L96
    L24:
        r210 = null;
        goto L25
    L21:
        r108 = null;
        goto L22
    L12:
        if (r311.isEnable() == false) goto L14;
        r114 = true;
        goto L15
    L32:
        if ((r310 instanceof ISwitchMoreItem) == false) goto L44;
        boolean r109 = y.a();
        if (r109 == true) goto L36;
        y.c("UIMoreItemFactoryImpl", r310.getId());
    L36:
        if (r109 == false) goto L38;
        boolean r116 = r101;
    L39:
        if (r109 == false) goto L41;
        String r117 = r102;
    L42:
        ISwitchMoreItem r118 = (ISwitchMoreItem) r310;
        return new j(r310.getId(), r118.getTitle(), r118.getIcon(), r118.getIconTint(), false, "", r118.isCheck(), r116, r117, new b(r310));
    L41:
        r117 = "";
        goto L42
    L38:
        r116 = true;
        goto L39
    L44:
        if ((r310 instanceof ILoadingSwitchMoreItem) == false) goto L56;
        boolean r119 = y.a();
        if (r119 == true) goto L48;
        y.c("UIMoreItemFactoryImpl", r310.getId());
    L48:
        if (r119 == false) goto L50;
        boolean r120 = r101;
    L51:
        if (r119 == false) goto L53;
        String r121 = r102;
    L54:
        ILoadingSwitchMoreItem r122 = (ILoadingSwitchMoreItem) r310;
        return new com.bytedance.ee.bear.more.view3.ui.g(r310.getId(), r122.getTitle(), r122.getIcon(), r122.getIconTint(), r122.isCheck(), r122.isLoading(), r120, r121, new c(r310));
    L53:
        r121 = "";
        goto L54
    L50:
        r120 = true;
        goto L51
    L56:
        if ((r310 instanceof ITextMoreItem) == false) goto L98;
        ITextMoreItem r123 = (ITextMoreItem) r310;
        if (r123.getStateTips().length() != 0) goto L60;
        boolean r124 = true;
    L61:
        if (r124 == false) goto L85;
        String r125 = r310.getId();
        String r126 = r123.getTitle();
        int r127 = r123.getIcon();
        int r128 = r123.getIconTint();
        boolean r129 = r123.needShowBadge();
        if (r123.isEnable() == true) goto L65;
    L67:
        boolean r130 = false;
    L68:
        String r131 = r310.getItemDisableReasonByJSMsg();
        if (r131 != null) goto L71;
        r131 = r123.getUnableTips();
    L71:
        String r132 = r131;
        ViewOnClickListenerC3370d r133 = new ViewOnClickListenerC3370d(r310);
        e r134 = new e(r310);
        MoreUiAction r212 = r123.getMoreAction();
        boolean r135 = r310 instanceof sj5.a;
        if (r135 == false) goto L74;
        final sj5.a r136 = (sj5.a) r310;
    L75:
        if (r136 == null) goto L77;
        Function2<Context, Integer, Drawable> r213 = new UIMoreItemFactoryImpl$customIconDrawableProvider$1$1(r136);
    L78:
        if (r135 == false) goto L80;
        r100 = (sj5.a) r310;
    L80:
        if (r100 == null) goto L82;
        boolean r214 = r100.getShouldIgnoreIconTint();
    L83:
        k r137 = new UINormalItem(r125, r126, r127, r128, r129, false, false, r130, r132, r133, r134, r212, r213, r214);
    L102:
        return r137;
    L82:
        r214 = false;
        goto L83
    L77:
        r213 = null;
        goto L78
    L74:
        r136 = null;
        goto L75
    L65:
        if (r311.isEnable() == false) goto L67;
        r130 = true;
        goto L68
    L85:
        String r215 = r310.getId();
        String r216 = r123.getTitle();
        int r217 = r123.getIcon();
        int r218 = r123.getIconTint();
        boolean r219 = r123.needShowBadge();
        String r313 = r123.getStateTips();
        if (r123.isEnable() == true) goto L88;
    L90:
        boolean r314 = false;
    L91:
        String r138 = r310.getItemDisableReasonByJSMsg();
        if (r138 != null) goto L94;
        String r315 = r123.getUnableTips();
    L95:
        r137 = new com.bytedance.ee.bear.more.view3.ui.e(r215, r216, r217, r218, r219, false, r313, r314, r315, new f(r310));
        goto L102
    L94:
        r315 = r138;
        goto L95
    L88:
        if (r311.isEnable() == false) goto L90;
        r314 = true;
        goto L91
    L60:
        r124 = false;
        goto L61
    L98:
        throw new IllegalStateException("Illegal MoreItem: ".concat(r310.getClass().getSimpleName()));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final k b(com.bytedance.ee.bear.more.protocol3.f r210, com.bytedance.ee.bear.more.protocol3.e r211, List<? extends m> r212, List<? extends com.bytedance.ee.bear.more.protocol3.a> r213, View.OnClickListener r214) {
        Intrinsics.checkNotNullParameter(r210, "type");
        Intrinsics.checkNotNullParameter(r211, "style");
        View.OnClickListener r100 = null;
        if (r212 == null) goto L11;
        Iterator<? extends m> r101 = r212.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        if (r101.next().isVisible() == true) goto L6;
        return null;
    L11:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.a) == false) goto L15;
        return new com.bytedance.ee.bear.more.view3.ui.c(r210.f234853a, ((com.bytedance.ee.bear.more.protocol3.e.a) r211).f234795a);
    L15:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.d) == false) goto L18;
        com.bytedance.ee.bear.more.protocol3.e.d r102 = (com.bytedance.ee.bear.more.protocol3.e.d) r211;
        return new com.bytedance.ee.bear.more.view3.ui.f(r210.f234853a, r102.f234804a, r102.f234805b);
    L18:
        String r103 = r210.f234853a;
        com.bytedance.ee.bear.more.protocol3.d r104 = r210.f234854b;
        String r105 = r104.f234794d;
        if (r105 != null) goto L21;
        String r106 = eu5.b.f474075a.getString(r104.f234791a);
    L22:
        com.bytedance.ee.bear.more.protocol3.d r107 = r210.f234854b;
        int r108 = r107.f234792b;
        int r109 = r107.f234793c;
        if (r213 == null) goto L30;
        Iterator<? extends com.bytedance.ee.bear.more.protocol3.a> r110 = r213.iterator();
    L26:
        if (r110.hasNext() == false) goto L30;
        com.bytedance.ee.bear.more.protocol3.a r111 = r110.next();
        if (r111.isEnable() == true) goto L26;
        String r112 = r111.b();
        r100 = r111.a();
        String r113 = r112;
        boolean r114 = false;
    L32:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.h) == false) goto L35;
        com.bytedance.ee.bear.more.protocol3.e.h r115 = (com.bytedance.ee.bear.more.protocol3.e.h) r211;
        return new j(r103, r106, r108, r109, r115.f234813b, r115.f234814c, r115.f234812a, r114, r113, r214);
    L35:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.c) == false) goto L38;
        com.bytedance.ee.bear.more.protocol3.e.c r116 = (com.bytedance.ee.bear.more.protocol3.e.c) r211;
        return new com.bytedance.ee.bear.more.view3.ui.e(r103, r106, r108, r109, r116.f234801a, r116.f234802b, r116.f234803c, r114, r113, r214);
    L38:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.f) == false) goto L41;
        com.bytedance.ee.bear.more.protocol3.e.f r117 = (com.bytedance.ee.bear.more.protocol3.e.f) r211;
        return new UINormalItem(r103, r106, r108, r109, r117.f234807a, r117.f234808b, r117.f234809c, r114, r113, r214, r100, null, null, false);
    L41:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.b) == false) goto L44;
        com.bytedance.ee.bear.more.protocol3.e.b r118 = (com.bytedance.ee.bear.more.protocol3.e.b) r211;
        boolean r119 = r114;
        String r120 = r113;
        return new com.bytedance.ee.bear.more.view3.ui.d(r103, r106, r108, r109, r118.f234797b, r118.f234798c, r119, r120, r214, r118.f234799d, r118.f234800e, r118.f234796a);
    L44:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.g) == false) goto L48;
        boolean r121 = r114;
        String r122 = r113;
        k r123 = new i(r103, r106, r108, r109, r121, r122, ((com.bytedance.ee.bear.more.protocol3.e.g) r211).f234811b, r214, r100);
    L62:
        return r123;
    L48:
        if ((r211 instanceof com.bytedance.ee.bear.more.protocol3.e.C3365e) == false) goto L52;
        r123 = new h(r103, r106, r108, r109, ((com.bytedance.ee.bear.more.protocol3.e.C3365e) r211).f234806a, r114, r113, r214, r100);
        goto L62
    L52:
        throw new IllegalStateException("Illegal MoreItemStyle: ".concat(r211.getClass().getSimpleName()));
    L30:
        r114 = true;
        r113 = "";
        goto L32
    L21:
        r106 = r105;
        goto L22
    }
}
