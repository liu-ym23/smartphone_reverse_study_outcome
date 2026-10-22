package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.store.window.ECShopHybridRoundedLinearLayout;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageLynxCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends HybridPageSlicePagePresenter {

    public static final class a implements wj3.a {
        public final /* synthetic */ f a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.store.router.hybridpage.presenter.page.f$a$a, reason: collision with other inner class name */
        public static final class C0013a extends m0 {
            public final /* synthetic */ a a;
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

            public C0013a(a r1, Map r2, Map r3) {
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

        public a(f r1) {
            this.a = r1;
        }

        @Override // wj3.a
        public final m0 b(Map<String, Object> r2, Map<String, Object> r3) {
            return new C0013a(this, r2, r3);
        }
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageSlicePagePresenter
    public final wj3.a e0() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageSlicePagePresenter
    public final String h0() {
        return ShopSliceUniqueId.SEARCH_RESULT_PAGE.getId();
    }

    public f(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }
}
