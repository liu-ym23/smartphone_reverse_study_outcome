package com.bytedance.android.shopping.store.home.presenter;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AbsECShopPresenter extends QPresenter {
    public static final /* synthetic */ int i = 0;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Fragment h;

    public static final class a {
    }

    static {
    }

    public final ECStoreViewModel T() {
        return (ECStoreViewModel) this.e.getValue();
    }

    public final Pair<Integer, Integer> O() {
        int r0 = com.bytedance.android.shopping.store.home.t.a;
        return com.bytedance.android.shopping.store.home.t.a(T().getStoreParam(), (ECStoreTabAreaVO) T().getTabArea().getValue());
    }

    public final void Q() {
        Fragment r0 = this.h;
        if ((r0 instanceof TabKitFragment) == false) goto L8;
        if (r0 == null) goto L7;
        ((TabKitFragment) r0).finish();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.TabKitFragment");
    }

    public final DialogFragment S() {
        Fragment r0 = this.h;
        Fragment r2 = null;
        if ((r0 instanceof com.bytedance.android.shopping.store.tabkit.f) == false) goto L13;
        if (r0 == null) goto L6;
        Fragment r1 = r0.getParentFragment();
    L8:
        if ((r1 instanceof DialogFragment) == false) goto L17;
        r2 = r1;
    L17:
        return (DialogFragment) r2;
    L6:
        r1 = null;
        goto L8
    L13:
        if ((r0 instanceof DialogFragment) == true) goto L16;
        r0 = null;
    L16:
        return (DialogFragment) r0;
    }

    public final LifecycleOwner W() {
        Fragment r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public final boolean D() {
        if (F() == true) goto L5;
    L7:
        return false;
    L5:
        if (U() == true) goto L7;
        return true;
    }

    public final boolean E() {
        if (G() == true) goto L5;
    L9:
        return false;
    L5:
        if (U() == true) goto L9;
        if (T().canShowTopLiveAndVideo() == false) goto L9;
        return true;
    }

    public final boolean F() {
        if (G() == true) goto L7;
        if (T().couldVideoV2() == true) goto L7;
    L11:
        return false;
    L7:
        if (U() == true) goto L11;
        if (T().canShowTopLiveAndVideo() == false) goto L11;
        return true;
    }

    public final boolean G() {
        return T().couldLive();
    }

    @Deprecated(message = "不建议使用，videoInfo赋值晚，可能会出现取不到值")
    public final boolean I() {
        if (T().couldVideo() == true) goto L5;
    L7:
        return false;
    L5:
        if (T().isWhiteBrand() == true) goto L7;
        return true;
    }

    public final boolean K() {
        ECStoreTabAreaVO r0 = (ECStoreTabAreaVO) T().getTabArea().getValue();
        if (r0 == null) goto L22;
        List<uj3.j> r1 = r0.b;
        if (r1 == null) goto L22;
        int r3 = ((Number) N().getFirst()).intValue();
        int r4 = r1.size();
        if (r3 < 0) goto L21;
        if (r4 <= r3) goto L21;
        uj3.j r2 = (uj3.j) ListProtector.get(r1, r3);
        List<uj3.j> r5 = r2.b;
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        List<uj3.j> r7 = CollectionsKt.listOf(r2);
    L24:
        if (r7.size() <= 1) goto L27;
        return true;
    L27:
        return false;
    L20:
        r7 = r2.b;
        Intrinsics.checkNotNull(r7);
        goto L24
    L14:
        if (r5.isEmpty() == true) goto L17;
        r6 = false;
    L21:
        r7 = CollectionsKt.emptyList();
    L22:
        r7 = CollectionsKt.emptyList();
        goto L24
    }

    public final Pair<Integer, Integer> N() {
        Pair<Integer, Integer> r0 = (Pair) T().getSelectedTabLocation().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return O();
    }

    public final boolean U() {
        return T().isCroppedStyle();
    }

    public final boolean V() {
        return T().isFullScreen();
    }

    public AbsECShopPresenter(Fragment r1) {
        this.h = r1;
        this.e = LazyKt.lazy(new AbsECShopPresenter$viewModel$2(this));
        this.f = LazyKt.lazy(AbsECShopPresenter$currentLoginSecUserId$2.INSTANCE);
        this.g = LazyKt.lazy(new AbsECShopPresenter$sharedPrefHelper$2(this));
    }
}
