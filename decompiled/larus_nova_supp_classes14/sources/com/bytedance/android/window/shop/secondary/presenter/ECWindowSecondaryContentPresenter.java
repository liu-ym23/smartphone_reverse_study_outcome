package com.bytedance.android.window.shop.secondary.presenter;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.window.shop.home.tab.WindowTabFragment;
import com.bytedance.android.window.shop.home.tab.WindowTabFragmentBase;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.secondary.ECWindowSecondaryPageActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/secondary/presenter/ECWindowSecondaryContentPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSecondaryContentPresenter extends QPresenter implements LifecycleObserver {
    public ECWindowViewModel e;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowSecondaryContentPresenter a;

        public a(ECWindowSecondaryContentPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            ECWindowSecondaryContentPresenter r0 = this.a;
            if (((Boolean) r4).booleanValue() == false) goto L16;
            QContext r5 = r0.u();
            FragmentActivity r1 = l0.c(r5.c());
            if ((r1 instanceof ECWindowSecondaryPageActivity) == true) goto L7;
            r1 = null;
        L7:
            FragmentActivity r2 = (ECWindowSecondaryPageActivity) r1;
            if (r2 != null) goto L10;
            r2 = r5.a();
        L10:
            ((ECWindowSecondaryPageActivity) r2).finish();
            ECWindowViewModel r6 = r0.e;
            if (r6 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L13:
            Uri r7 = r6.getSecondaryPageParams().b;
            if (r7 == null) goto L18;
            Uri r8 = com.bytedance.android.shopping.utils.l0.c(r7, "target_tab_type", String.valueOf(100));
            p.a.openSchema(r0.u().c(), r8.toString());
            return;
        L18:
            return;
        L16:
            r0.getClass();
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowSecondaryContentPresenter a;

        public b(ECWindowSecondaryContentPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            WindowTabDataListResponseDTODeprecated r13 = (WindowTabDataListResponseDTODeprecated) r12;
            ECWindowSecondaryContentPresenter r14 = this.a;
            ECWindowViewModel r0 = r14.e;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L5:
            com.bytedance.android.window.shop.c r1 = r0.getSecondaryPageParams().a;
            if (r1 == null) goto L42;
            ECWindowViewModel r2 = r14.e;
            if (r2 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L10:
            com.bytedance.android.window.shop.c r3 = r2.getSecondaryPageParams().a;
            if (r3 == null) goto L35;
            int r4 = r3.getType();
            com.bytedance.android.window.shop.c r5 = com.bytedance.android.window.shop.c.g;
            if (r4 != r5.getType()) goto L35;
            int r6 = WindowTabFragmentBase.g;
            ECWindowViewModel r7 = r14.e;
            if (r7 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L17:
            String r8 = r7.getShopParam().getTargetCategory();
            if (r8 != null) goto L20;
            String r9 = "";
        L21:
            ECWindowViewModel r10 = r14.e;
            if (r10 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L24:
            Uri r11 = r10.getSecondaryPageParams().b;
            if (r11 == null) goto L27;
            String r15 = UriProtector.getQueryParameter(r11, "category_name");
        L28:
            if (r15 != null) goto L30;
            String r16 = "";
        L31:
            ECWindowViewModel r17 = r14.e;
            if (r17 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L34:
            Fragment r18 = WindowTabFragmentBase.a.a(r9, r16, r17.getShopParam().getLifecycleMonitorId(), false, r5.getType());
        L36:
            FragmentTransaction r19 = r14.u().a().getSupportFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r19, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131371351) == true) goto L40;
            r19 = r19.replace(2131371351, r18);
        L40:
            r19.commit();
            return;
        L30:
            r16 = r15;
            goto L31
        L27:
            r15 = null;
            goto L28
        L20:
            r9 = r8;
        L35:
            int r20 = WindowTabFragment.f;
            Intrinsics.checkNotNullParameter(r1, "shopWindowItemType");
            WindowTabFragment r21 = new WindowTabFragment();
            Bundle r22 = new Bundle();
            r22.putInt("SHOP_WINDOW_ITEM_TYPE", r1.getType());
            Unit r23 = Unit.INSTANCE;
            r21.setArguments(r22);
            r18 = r21;
            goto L36
        }
    }

    public ECWindowSecondaryContentPresenter() {
    }

    public final void A(QModel r5) {
        View r6 = w().b(2131387282).f();
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        r0.height = eh.b.b(r6.getContext());
        this.e = u().f(ECWindowViewModel.class);
        View r7 = w().b(2131371347).f();
        ECWindowViewModel r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        Integer r2 = r1.getShopParam().getTargetTabType();
        if (r2 != null) goto L9;
    L11:
        if (r2 != null) goto L14;
    L16:
        if (r2 != null) goto L19;
    L21:
        ECWindowViewModel r8 = this.e;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        r8.getSecondaryPageParams().e.a(u().e(), new a(this), false);
        ECWindowViewModel r9 = this.e;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L27:
        r9.getHeaderSubTabsParam().c.a(u().e(), new b(this), false);
        return;
    L19:
        if (r2.intValue() != 500) goto L21;
        int r3 = com.bytedance.android.ec.window.base.utils.c.a;
        Intrinsics.checkNotNullParameter(r7, "$this$setBackgroundCompat");
        r7.setBackground(null);
        goto L21
    L14:
        if (r2.intValue() != 300) goto L16;
        r7.setBackgroundResource(2131234924);
        goto L21
    L9:
        if (r2.intValue() != 200) goto L11;
        r7.setBackgroundResource(2131234925);
        goto L21
    }
}
