package com.bytedance.android.window.shop.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import zq3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/home/ECWindowDialogFragment;", "Lcom/bytedance/android/window/shop/home/ECBaseDialogFragment;", "Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel;", "", "<init>", "()V", "Companion", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowDialogFragment extends ECBaseDialogFragment<ECWindowViewModel> {
    public static final /* synthetic */ int k = 0;

    public static final class Companion {
        public static ECWindowDialogFragment a(ECWindowParam r3, Uri r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r3, "shopParam");
            ECWindowDialogFragment r0 = new ECWindowDialogFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("shop_param", r3);
            r1.putSerializable("entrance_info", String.valueOf(r5));
            Unit r6 = Unit.INSTANCE;
            r0.setArguments(r1);
            r0.g = r4;
            if (r3.isCroppedStyle() == false) goto L5;
            r0.getLifecycle().addObserver(new ECWindowDialogFragment$Companion$newInstance$1$2());
        L5:
            return r0;
        }
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(ECWindowDialogFragment.class, "a1.b7635");
    }

    public ECWindowDialogFragment() {
        super(Reflection.getOrCreateKotlinClass(ECWindowViewModel.class));
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment
    public final void dismissAllowingStateLoss() {
        if (T90().isSplitStyle() == true) goto L6;
        U90(this);
        return;
    L6:
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L10;
        getActivity();
        new AnonymousClass1(this);
        r0.n();
        return;
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.c.c(T90().getShopParam().getLifecycleMonitorId());
    }

    public static void U90(ECBaseDialogFragment r1) {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Lazy r6 = BtmSDKWrapper.a;
        Uri r7 = this.g;
        String r0 = null;
        if (r7 == null) goto L5;
        String r8 = UriProtector.getQueryParameter(r7, "source_btm_token");
    L6:
        BtmSDKWrapper.b(this, "a1.b7635", r8);
        Bundle r9 = getArguments();
        if (r9 == null) goto L9;
        Serializable r10 = r9.getSerializable("shop_param");
    L11:
        if ((r10 instanceof ECWindowParam) == true) goto L13;
        r10 = null;
    L13:
        ECWindowParam r11 = (ECWindowParam) r10;
        if (r11 != null) goto L16;
        return;
    L16:
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r1 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r2 = com.bytedance.android.window.shop.lifecycle.c.a(r11.getLifecycleMonitorId());
        if (r2 == null) goto L19;
        r2.o(getContext(), r11);
    L19:
        ECWindowViewModel r3 = T90();
        Uri r4 = this.g;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L22;
        r0 = xn.c.d(r12);
    L22:
        r3.init(r11, r4, r0);
        T90().appendEventParams(new Pair[]{TuplesKt.to("icon_page", CommentServiceId.HOT_SPOT)});
        T90().getShopParam().setBtmPageId(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        T90().loadHeaderInfo();
        return;
    L9:
        r10 = null;
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.home.ECBaseDialogFragment
    public final QUIModule S90(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r6 = r4.inflate(2131560376, null, false);
        ViewGroup r7 = (ViewGroup) r6.findViewById(2131370968);
        if (l.b() == false) goto L5;
        th.a.c(th.a.e(r7.getContext(), true), 2131561046, r7, true);
    L7:
        return new com.bytedance.android.window.shop.home.module.h(r6, T90().isCroppedStyle(), T90().isVideoTrailerOrSplitOpt(), new ECWindowDialogFragment$createRootModule$1(this));
    L5:
        th.a.c(th.a.e(r7.getContext(), true), 2131561045, r7, true);
        goto L7
    }
}
