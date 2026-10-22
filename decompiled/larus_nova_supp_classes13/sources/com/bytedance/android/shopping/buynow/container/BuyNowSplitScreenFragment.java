package com.bytedance.android.shopping.buynow.container;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.live.s;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowSplitScreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/android/shopping/buynow/container/o;", "Lcom/bytedance/android/ec/model/live/s;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowSplitScreenFragment extends Fragment implements o, s {
    public static final /* synthetic */ int f = 0;
    public BuyNowFragment d;
    public la3.e e;

    public static final class a {
        public static BuyNowSplitScreenFragment a(String r3, Uri r4, BuyNowOrderSchema r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "sessionId");
            BuyNowSplitScreenFragment r0 = new BuyNowSplitScreenFragment();
            Bundle r1 = new Bundle();
            r1.putString("PrefetchSessionId", r3);
            r1.putParcelable("Schema", r4);
            r1.putParcelable("OrderSchema", r5);
            r1.putString("source_btm_token", r6);
            r1.putString("SplitScreenType", "buy_now");
            Unit r7 = Unit.INSTANCE;
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final void close() {
        BuyNowFragment r0 = this.d;
        if (r0 == null) goto L9;
        BuyNowViewModel r1 = r0.W90();
        if (r1 == null) goto L9;
        ul.f r2 = r1.getSkuPageState();
        if (r2 == null) goto L9;
        r2.a = 1;
    L9:
        nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r3 == null) goto L13;
        ECHybridExtensionsKt.a(getContext());
        r3.m();
        return;
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final View G9() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        return S90(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final Window Ou() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindow();
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final Window TR() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindow();
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final View s7() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        return S90(r1);
    L7:
        return null;
    }

    public BuyNowSplitScreenFragment() {
    }

    public final LiveScreenMoveMode AC() {
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    public final LiveClearScreenMode cy() {
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }

    public final void onStart() {
        super.onStart();
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (r10 == null) goto L6;
        close();
        return;
    L6:
        int r11 = com.bytedance.android.shopping.buynow.starter.a.a;
        com.bytedance.android.shopping.buynow.starter.a.a(requireActivity());
        Bundle r12 = getArguments();
        if (r12 == null) goto L9;
        Uri r13 = (Uri) r12.getParcelable("Schema");
    L10:
        Bundle r1 = getArguments();
        if (r1 == null) goto L13;
        BuyNowOrderSchema r7 = (BuyNowOrderSchema) r1.getParcelable("OrderSchema");
    L14:
        Bundle r2 = getArguments();
        if (r2 == null) goto L17;
        Serializable r3 = r2.getSerializable("ultimate_buy_params");
    L19:
        if ((r3 instanceof UltimateBuyParams) == true) goto L21;
        r3 = null;
    L21:
        UltimateBuyParams r4 = (UltimateBuyParams) r3;
        Bundle r5 = getArguments();
        if (r5 == null) goto L24;
        float r6 = r5.getFloat("HeightPercent");
    L25:
        Bundle r8 = getArguments();
        if (r8 == null) goto L28;
        Integer r9 = Integer.valueOf(r8.getInt("ultimate_buy_ab"));
    L29:
        int r14 = com.bytedance.android.shopping.extensions.k.g(r9, 0);
        Bundle r15 = getArguments();
        if (r15 == null) goto L33;
        r15.getString("SplitScreenType");
    L33:
        if (r14 <= 0) goto L43;
        int r16 = BuyNowFragment.J;
        Bundle r17 = getArguments();
        if (r17 == null) goto L37;
        String r18 = r17.getString("PrefetchSessionId");
    L38:
        la3.e r19 = this.e;
        Bundle r20 = getArguments();
        if (r20 == null) goto L41;
        String r21 = r20.getString("source_btm_token");
    L42:
        this.d = BuyNowFragment.a.b(r18, r19, r4, r21, r6, r13, r7, true);
    L52:
        BuyNowFragment r110 = this.d;
        if (r110 == null) goto L60;
        FragmentTransaction r22 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r22, r110, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131365071) == true) goto L58;
        r22 = r22.replace(2131365071, r110);
    L58:
        r22.commit();
        return;
    L60:
        return;
    L41:
        r21 = null;
        goto L42
    L37:
        r18 = null;
        goto L38
    L43:
        int r23 = BuyNowFragment.J;
        Bundle r24 = getArguments();
        if (r24 == null) goto L46;
        String r25 = r24.getString("PrefetchSessionId");
    L47:
        Bundle r26 = getArguments();
        if (r26 == null) goto L50;
        String r27 = r26.getString("source_btm_token");
    L51:
        this.d = BuyNowFragment.a.a(r25, r13, r7, r27, 0.0f, true, 16);
        goto L52
    L50:
        r27 = null;
        goto L51
    L46:
        r25 = null;
        goto L47
    L28:
        r9 = null;
        goto L29
    L24:
        r6 = 0.73f;
        goto L25
    L17:
        r3 = null;
        goto L19
    L13:
        r7 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559216, r3, false);
    }
}
