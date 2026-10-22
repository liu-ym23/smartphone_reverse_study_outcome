package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.search.activity.ShopSearchResultActivity;
import com.bytedance.android.shopping.store.search.fragment.ECShopSearchFragment;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "SearchMode", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopSearchBasePresenter extends QPresenter implements LifecycleObserver {
    public final Lazy e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter$SearchMode;", "", "", "type", "I", "getType", "()I", "KEYBOARD", "BUTTON", "HISTORY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SearchMode extends Enum<SearchMode> {
        public static final SearchMode BUTTON = null;
        public static final SearchMode HISTORY = null;
        public static final SearchMode KEYBOARD = null;
        public static final /* synthetic */ SearchMode[] a = null;
        private final int type;

        static {
            SearchMode r1 = new SearchMode("KEYBOARD", 0, 0);
            KEYBOARD = r1;
            SearchMode r2 = new SearchMode("BUTTON", 1, 1);
            BUTTON = r2;
            SearchMode r3 = new SearchMode("HISTORY", 2, 2);
            HISTORY = r3;
            a = new SearchMode[]{r1, r2, r3};
        }

        public static SearchMode valueOf(String r1) {
            return (SearchMode) r27.a.a(SearchMode.class, r1);
        }

        public static SearchMode[] values() {
            return (SearchMode[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public SearchMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public final ShopSearchViewModel E() {
        return (ShopSearchViewModel) this.e.getValue();
    }

    public ShopSearchBasePresenter() {
        this.e = LazyKt.lazy(new ShopSearchBasePresenter$viewModel$2(this));
    }

    public final ECShopSearchFragment D() {
        Fragment r0 = u().d().i();
        if ((r0 instanceof ECShopSearchFragment) == true) goto L6;
        r0 = null;
    L6:
        return (ECShopSearchFragment) r0;
    }

    public final void F(SearchMode r10) {
        Intrinsics.checkNotNullParameter(r10, "searchMode");
        String r0 = (String) E().getSearchContent().a();
        Context r1 = null;
        if (r0 == null) goto L5;
        String r2 = StringsKt.trim(r0).toString();
    L7:
        if (g4.a[r10.ordinal()] == 1) goto L9;
        String r11 = "normal_search";
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L19;
        String r12 = String.valueOf(E().getSearchHint().a());
        if (TextUtils.isEmpty(r12) == true) goto L17;
        int r3 = com.bytedance.android.ec.core.utils.g1.a;
        if ((!Intrinsics.areEqual(com.bytedance.android.ec.core.utils.g1.a.c(u().c(), 2131895925, new Object[0]), r12)) == false) goto L17;
        r2 = r12;
    L17:
        r11 = "hint_word_search";
    L19:
        if (TextUtils.isEmpty(r2) == true) goto L32;
        Lazy r4 = ECStoreFoldPhoneHelper.a;
        ECStoreFoldPhoneHelper.f(D());
        E().getSearchContent().g(r2);
        ECShopSearchParam r5 = E().getSearchParam();
        if (r2 != null) goto L23;
        String r6 = "";
    L24:
        r5.setSearchKeyword(r6);
        E().getSearchParam().setSearchSource(r11);
        E().getSearchParam().setFromSug(false);
        int r13 = ShopSearchResultActivity.m;
        QContext r14 = u();
        Context r7 = com.bytedance.android.ec.core.utils.l0.c(r14.c());
        if ((r7 instanceof FragmentActivity) == false) goto L28;
        r1 = r7;
    L28:
        if (r1 != null) goto L30;
        r1 = r14.a();
    L30:
        ShopSearchResultActivity.a.a(r1, E().getSearchParam(), 1, BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8121.c478706.d826529", PageFinder.via(y()), null, 4, null), 16);
        E().getPostKeyword().setValue(r2);
        return;
    L23:
        r6 = r2;
        goto L24
    L32:
        return;
    L9:
        r11 = "search_history";
        goto L11
    L5:
        r2 = null;
        goto L7
    }
}
