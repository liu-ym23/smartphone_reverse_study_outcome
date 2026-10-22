package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.CartGULView;
import com.bytedance.android.shopping.new_cart.widgets.LoadMoreFooterView;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartLoadMoreComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public static final /* synthetic */ int j = 0;
    public boolean b;
    public final CartViewModel c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final Lazy g;
    public boolean h;
    public final CartObjectContainer i;

    public static final class a {
        public static Boolean a(AndroidYaTaInstance r2, Boolean r3) {
            Object r0 = null;
            if (r2 == null) goto L5;
            Object r4 = r2.i("pagination");
        L7:
            if ((r4 instanceof Map) == true) goto L9;
            r4 = null;
        L9:
            Map r5 = (Map) r4;
            if (r5 == null) goto L12;
            Object r6 = r5.get("has_more");
        L14:
            if ((r6 instanceof Boolean) == false) goto L17;
            r0 = r6;
        L17:
            Boolean r1 = (Boolean) r0;
            if (r1 != null) goto L21;
            return r3;
        L21:
            return r1;
        L12:
            r6 = null;
            goto L14
        L5:
            r4 = null;
            goto L7
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CartLoadMoreComponent a;

        public b(CartLoadMoreComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            com.bytedance.android.shopping.new_cart.viewmodel.d r4 = (com.bytedance.android.shopping.new_cart.viewmodel.d) r3;
            CartLoadMoreComponent r0 = this.a;
            r0.b = r4.b;
            String r5 = r4.a;
            Intrinsics.checkNotNullParameter(r5, "queryScene");
            if ((!Intrinsics.areEqual(r5, GYLFetchType.LOAD_MORE)) == true) goto L7;
            r0.d = true;
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CartLoadMoreComponent a;

        public c(CartLoadMoreComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            com.bytedance.android.shopping.new_cart.viewmodel.c r11 = (com.bytedance.android.shopping.new_cart.viewmodel.c) r10;
            CartLoadMoreComponent r0 = this.a;
            Context r2 = r0.e();
            String r1 = r11.a;
            com.bytedance.kmp.ec.yata.common.protocol.data.e r3 = r11.b;
            if (r3 == null) goto L5;
            boolean r4 = com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r3);
        L6:
            com.bytedance.kmp.ec.yata.common.protocol.data.e r12 = r11.b;
            String r5 = null;
            if (r12 == null) goto L9;
            String r13 = r12.b();
        L10:
            Intrinsics.checkNotNullParameter(r1, "queryScene");
            if ((!Intrinsics.areEqual(r1, GYLFetchType.LOAD_MORE)) == true) goto L29;
            r0.r(false);
            r0.e = r4;
            if (r4 == true) goto L27;
            if (r13 == null) goto L20;
            String r14 = a2.d(r13);
            if (r14 == null) goto L20;
        L19:
            String r6 = r14;
            if (r6 == null) goto L27;
            if (r2 == null) goto L27;
            ECToast.showToast$default(ECToast.INSTANCE, r2, r6, 0, null, 8, null);
        L20:
            com.bytedance.android.ec.core.cart.d r15 = ECSettingKeys.p().l();
            if (r15 == null) goto L23;
            r5 = r15.a();
        L23:
            r14 = a2.d(r5);
        L27:
            r0.d = false;
            return;
        L29:
            return;
        L9:
            r13 = null;
            goto L10
        L5:
            r4 = false;
            goto L6
        }
    }

    static {
    }

    public final CartBodyComponent n() {
        return (CartBodyComponent) this.g.getValue();
    }

    public final void p() {
        this.h = true;
        CartBodyComponent r0 = n();
        if (r0 == null) goto L9;
        NestedScrollView r1 = r0.o();
        if (r1 == null) goto L9;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L9;
        r2.height = com.bytedance.android.shopping.extensions.b.b(70);
    L9:
        CartBodyComponent r3 = n();
        if (r3 == null) goto L17;
        CartLinkedScrollViewV2 r4 = r3.b;
        if (r4 == null) goto L14;
        CartGULView r5 = r4.getGul();
    L15:
        if (r5 == null) goto L17;
        r5.j();
        goto L17
    L14:
        r5 = null;
    L17:
        CartBodyComponent r6 = n();
        if (r6 == null) goto L21;
        r6.p().requestLayout();
        return;
    }

    public final void q() {
        this.h = false;
        CartBodyComponent r1 = n();
        if (r1 == null) goto L9;
        NestedScrollView r2 = r1.o();
        if (r2 == null) goto L9;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L9;
        r3.height = 0;
    L9:
        CartGULView r4 = null;
        if (Intrinsics.areEqual(((AndroidYaTaInstance) this.i.e.d.invoke()).i("no_feed"), Boolean.TRUE) == false) goto L23;
        CartBodyComponent r0 = n();
        if (r0 == null) goto L18;
        CartLinkedScrollViewV2 r5 = r0.b;
        if (r5 == null) goto L16;
        r4 = r5.getGul();
    L16:
        if (r4 == null) goto L18;
        r4.i();
    L18:
        CartBodyComponent r6 = n();
        if (r6 == null) goto L30;
        LoadMoreFooterView r7 = r6.o();
        if (r7 == null) goto L30;
        r7.requestLayout();
    L30:
        CartBodyComponent r8 = n();
        if (r8 == null) goto L34;
        r8.p().requestLayout();
        return;
    L34:
        return;
    L23:
        CartBodyComponent r9 = n();
        if (r9 == null) goto L30;
        CartLinkedScrollViewV2 r10 = r9.b;
        if (r10 == null) goto L28;
        r4 = r10.getGul();
    L28:
        if (r4 == null) goto L30;
        r4.i();
        com.bytedance.android.shopping.new_cart.utils.a.e(5, new com.bytedance.android.shopping.new_cart.widgets.b(r4));
        goto L30
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        this.c.getOnQueryStartLiveData().observe(f(), new b(this));
        this.c.getOnQueryEndLiveData().observe(f(), new c(this));
    }

    public CartLoadMoreComponent(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.i = r2;
        this.b = true;
        this.c = this.a.d;
        this.e = true;
        this.g = LazyKt.lazy(new CartLoadMoreComponent$bodyComponent$2(this));
        this.h = true;
        new Rect();
    }

    public final void r(boolean r8) {
        if (r8 == true) goto L4;
    L6:
        this.f = r8;
        return;
    L4:
        if (this.f == true) goto L6;
        CartViewModel.doEventAction$default(this.c, "cart_load_more_event", MapsKt.mapOf(TuplesKt.to("event_type", "show_load_more_footer")), null, 4, null);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(CartLinkedScrollViewV2 r13, boolean r14, LoadMoreFooterView r15) {
        Intrinsics.checkNotNullParameter(r13, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r15, "footerView");
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        Intrinsics.checkNotNullParameter(r15, "v");
        if (r15.getGlobalVisibleRect(new Rect()) == false) goto L6;
        r(true);
    L6:
        if (this.d == false) goto L9;
        return;
    L9:
        if ((!Intrinsics.areEqual(a.a((AndroidYaTaInstance) this.i.e.d.invoke(), Boolean.FALSE), Boolean.TRUE)) == false) goto L11;
        return;
    L11:
        RecyclerView r16 = r13.getCartRev();
        int r1 = 0;
        if (r16 == null) goto L16;
        RecyclerView.Adapter r17 = r16.getAdapter();
        if (r17 == null) goto L16;
        int r18 = r17.getItemCount();
    L17:
        RecyclerView r2 = r13.getCartRev();
        RecyclerView.LayoutManager r3 = null;
        if (r2 == null) goto L20;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();
    L22:
        if ((r4 instanceof LinearLayoutManager) == false) goto L25;
        r3 = r4;
    L25:
        LinearLayoutManager r5 = (LinearLayoutManager) r3;
        if (r5 == null) goto L28;
        r1 = r5.findLastCompletelyVisibleItemPosition();
    L28:
        com.bytedance.android.ec.core.cart.d r6 = ECSettingKeys.p().l();
        if (r6 == null) goto L31;
        int r7 = r6.c();
    L33:
        if (this.e == true) goto L35;
    L36:
        if (r14 == true) goto L38;
        return;
    L38:
        if (r13.canScrollVertically(1) == true) goto L46;
    L39:
        CartViewModel.doEventAction$default(this.c, "pull_load_more", MapsKt.mapOf(TuplesKt.to("is_auto", Integer.valueOf(r13.canScrollVertically(1) ? 1 : 0))), null, 4, null);
        RecyclerView r19 = r13.getCartRev();
        if (r19 != null) goto L42;
        return;
    L42:
        if (r19.getContext() == null) goto L48;
        CartViewModel.doEventAction$default(this.c, "cart_load_more_event", MapsKt.mapOf(TuplesKt.to("event_type", "do_load_more")), null, 4, null);
        CartViewModel.doQuery$default(this.c, false, GYLFetchType.LOAD_MORE, null, 4, null);
        return;
    L48:
        return;
    L46:
        return;
    L35:
        if ((r1 + r7) >= r18) goto L39;
    L31:
        r7 = 4;
        goto L33
    L20:
        r4 = null;
    L16:
        r18 = 0;
        goto L17
    }
}
