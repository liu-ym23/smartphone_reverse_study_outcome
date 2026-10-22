package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.store.window.ECShopHybridRoundedLinearLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.event.SliceEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageLynxCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends HybridPageSlicePagePresenter {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.router.hybridpage.presenter.page.a$a, reason: collision with other inner class name */
    public static final class C0011a implements wj3.a {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.store.router.hybridpage.presenter.page.a$a$a, reason: collision with other inner class name */
        public static final class C0012a extends m0 {
            public final /* synthetic */ C0011a a;
            public final /* synthetic */ Map b;
            public final /* synthetic */ Map c;

            public final ECLynxCardHolder a(Context r5) {
                Intrinsics.checkNotNullParameter(r5, "context");
                ECShopHybridRoundedLinearLayout r0 = new ECShopHybridRoundedLinearLayout(r5, null, 6, 0);
                r0.setOrientation(1);
                r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                HybridPageLynxCardHolder r6 = new HybridPageLynxCardHolder(r0, this.a.a.i0().getSceneId(), this.a.a.i0());
                ((ECLynxCardHolder) r6).q = this.b;
                LinkedHashMap r1 = new LinkedHashMap();
                Map r2 = this.c;
                if (r2 == null) goto L10;
                Iterator r3 = r2.entrySet().iterator();
            L6:
                if (r3.hasNext() == false) goto L10;
                Map.Entry r4 = (Map.Entry) r3.next();
                Object r7 = r4.getValue();
                if (r7 == null) goto L6;
                r1.put(r4.getKey(), r7);
            L10:
                ((ECLynxCardHolder) r6).q = this.b;
                ((ECLynxCardHolder) r6).r = r1;
                return r6;
            }

            public C0012a(C0011a r1, Map r2, Map r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        @Override // wj3.a
        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "loadType");
        }

        @Override // wj3.a
        public final void a() {
            ReentrantReadWriteLock r0 = PageCardEventManager.a;
            PageCardEventManager.f(this.a.i0().getSceneId());
        }

        @Override // wj3.a
        public final HybridPageViewModel c() {
            return this.a.i0();
        }

        @Override // wj3.a
        public Context getContext() {
            return this.a.Y().c();
        }

        @Override // wj3.a
        public final Fragment getFragment() {
            return ((QFragmentPresenter) this.a).e;
        }

        public C0011a(a r1) {
            this.a = r1;
        }

        @Override // wj3.a
        public final m0 b(Map<String, Object> r2, Map<String, Object> r3) {
            return new C0012a(this, r2, r3);
        }
    }

    public static final class b extends com.bytedance.android.shopping.store.router.hybridpage.slice.a {
        public final /* synthetic */ a e;

        @Override // com.bytedance.android.shopping.store.router.hybridpage.slice.a
        public final void e(IAction r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "action");
            Intrinsics.checkNotNullParameter(r3, "targetView");
            if (Intrinsics.areEqual(r2.getType(), SliceActionType.CLOSE.getType()) == false) goto L11;
            Context r4 = this.e.Y().c();
            if ((r4 instanceof FragmentActivity) == true) goto L7;
            r4 = null;
        L7:
            FragmentActivity r5 = (FragmentActivity) r4;
            if (r5 == null) goto L12;
            r5.finish();
            return;
        L12:
            return;
        }

        public b(a r1, HybridPageViewModel r2, QContext r3) {
            this.e = r1;
            super(r2, r3);
        }
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageSlicePagePresenter
    public final wj3.a e0() {
        return new C0011a(this);
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageSlicePagePresenter
    public final String h0() {
        return ShopSliceUniqueId.CLASSIFICATION_SECOND_PAGE.getId();
    }

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageSlicePagePresenter
    public final void b0(QModel r8) {
        super.b0(r8);
        r r9 = this.f;
        if (r9 == null) goto L5;
        r9.b(new b(this, i0(), Y()));
    L5:
        Map<String, Object> r10 = i0().getRouterQuery();
        Object r1 = null;
        if (r10 == null) goto L8;
        Object r11 = r10.get("material_title");
    L10:
        if ((r11 instanceof String) == false) goto L13;
        r1 = r11;
    L13:
        String r2 = (String) r1;
        ReentrantReadWriteLock r12 = SliceEventManager.a;
        String r13 = i0().getSceneId();
        Pair[] r3 = new Pair[2];
        LinkedHashMap r4 = new LinkedHashMap();
        if (r2 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
        r4.put("material_title", r2);
    L22:
        Unit r0 = Unit.INSTANCE;
        r3[0] = TuplesKt.to("data_source", r4);
        r3[1] = TuplesKt.to("item_states", MapsKt.mapOf(TuplesKt.to("is_api_loading", 1)));
        SliceEventManager.b(r13, MapsKt.mapOf(r3));
        return;
    L16:
        if (r2.length() == 0) goto L19;
        r6 = false;
        goto L20
    L8:
        r11 = null;
        goto L10
    }
}
