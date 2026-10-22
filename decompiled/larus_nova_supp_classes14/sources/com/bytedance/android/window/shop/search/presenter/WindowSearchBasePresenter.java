package com.bytedance.android.window.shop.search.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.window.shop.search.activity.WindowSearchResultActivity;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "SearchMode", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowSearchBasePresenter extends QPresenter implements LifecycleObserver {
    public WindowSearchViewModel e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter$SearchMode;", "", "", "type", "I", "getType", "()I", "KEYBOARD", "BUTTON", "HISTORY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public WindowSearchBasePresenter() {
    }

    public void A(QModel r2) {
        this.e = ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
    }

    public final void D(SearchMode r14) {
        Intrinsics.checkNotNullParameter(r14, "searchMode");
        WindowSearchViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r1 = (String) r0.getSearchContent().a();
        ComponentActivity r2 = null;
        if (r1 == null) goto L8;
        String r3 = StringsKt.trim(r1).toString();
    L10:
        if (a.a[r14.ordinal()] == 1) goto L12;
        String r4 = "normal_search";
    L14:
        if (TextUtils.isEmpty(r3) == false) goto L30;
        if (r14 != SearchMode.BUTTON) goto L19;
        r4 = "search_button";
    L21:
        WindowSearchViewModel r15 = this.e;
        if (r15 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        String r16 = String.valueOf(r15.getSearchHint().a());
        if (TextUtils.isEmpty(r16) == true) goto L30;
        int r5 = g1.a;
        if ((!Intrinsics.areEqual(g1.a.c(u().c(), 2131895922, new Object[0]), r16)) == false) goto L30;
        r3 = r16;
        goto L30
    L19:
        if (r14 != SearchMode.KEYBOARD) goto L21;
        r4 = "default_search_keyword";
    L30:
        if (TextUtils.isEmpty(r3) == true) goto L61;
        WindowSearchViewModel r17 = this.e;
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r17.getSearchContent().g(r3);
        WindowSearchViewModel r18 = this.e;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        ECWindowSearchParam r19 = r18.getSearchParam();
        if (r3 != null) goto L40;
        String r6 = "";
    L41:
        r19.setSearchKeyword(r6);
        WindowSearchViewModel r110 = this.e;
        if (r110 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        r110.getSearchParam().setSearchSource(r4);
        WindowSearchViewModel r111 = this.e;
        if (r111 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        r111.getSearchParam().setFromSug(false);
        int r112 = WindowSearchResultActivity.l;
        QContext r113 = u();
        ComponentActivity r7 = l0.c(r113.c());
        if ((r7 instanceof FragmentActivity) == false) goto L51;
        r2 = r7;
    L51:
        if (r2 != null) goto L53;
        r2 = r113.a();
    L53:
        WindowSearchViewModel r114 = this.e;
        if (r114 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L56:
        ECWindowSearchParam r115 = r114.getSearchParam();
        String r8 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8121.c478706.d826529", PageFinder.via(y()), null, 4, null);
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r115, "searchParam");
        Intent r9 = new Intent(r2, WindowSearchResultActivity.class);
        r9.putExtra("search_param", r115);
        r9.putExtra("source_btm_token", r8);
        r9.putExtra("is_from_search_activity", true);
        r2.startActivityForResult(r9, 1);
        r2.overridePendingTransition(0, 0);
        WindowSearchViewModel r116 = this.e;
        if (r116 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        r116.getPostKeyword().setValue(r3);
        return;
    L40:
        r6 = r3;
        goto L41
    L61:
        return;
    L12:
        r4 = "search_history";
        goto L14
    L8:
        r3 = null;
        goto L10
    }
}
