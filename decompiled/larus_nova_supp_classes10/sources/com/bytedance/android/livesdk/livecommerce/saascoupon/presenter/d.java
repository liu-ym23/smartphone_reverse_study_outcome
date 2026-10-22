package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.SaasCouponViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends QFragmentPresenter {
    public SaasCouponViewModel f;

    public d(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public static final /* synthetic */ SaasCouponViewModel d0(d r1) {
        SaasCouponViewModel r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public final void b0(QModel r7) {
        SaasCouponViewModel r8 = Y().g(SaasCouponViewModel.class);
        this.f = r8;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r9 = r8.getStartAuthType();
        int r1 = r9.hashCode();
        if (r1 == (-1748180802)) goto L28;
        if (r1 == (-819456368)) goto L19;
        if (r1 == 2122142280) goto L13;
    L30:
        SaasCouponViewModel r10 = this.f;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        com.bytedance.android.ec.core.arch.state.c.a(r10, Y().e(), SaasCouponPresenter$setCommonText$1.INSTANCE, new SaasCouponPresenter$setCommonText$2(this));
        SaasCouponViewModel r11 = this.f;
        if (r11 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        com.bytedance.android.ec.core.arch.state.c.a(r11, Y().e(), SaasCouponPresenter$setCommonText$3.INSTANCE, new SaasCouponPresenter$setCommonText$4(this));
        ((ImageView) Z().b(2131385055).f()).setOnClickListener(new a(this));
        ((TextView) Z().b(2131385063).f()).setOnClickListener(new b(this));
        ((TextView) Z().b(2131385056).f()).setOnClickListener(new c(this));
        return;
    L13:
        if (r9.equals("nologin") == false) goto L30;
        Z().b(2131385065).c();
        Z().b(2131385066).c();
        Z().b(2131385056).c();
        SaasCouponViewModel r12 = this.f;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        com.bytedance.android.ec.core.arch.event.c.d(r12, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.f.a);
        goto L30
    L19:
        if (r9.equals("login_no_auth") == false) goto L30;
        SaasCouponViewModel r13 = this.f;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r13.getCurrentAccountPhoneNumber(new SaasCouponPresenter$setAllText$1(this));
        SaasCouponViewModel r14 = this.f;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        com.bytedance.android.ec.core.arch.event.c.d(r14, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.f.a);
        goto L30
    L28:
        if (r9.equals("login_auth") == false) goto L30;
        Z().b(2131385065).c();
        Z().b(2131385066).c();
        Z().b(2131385056).c();
        goto L30
    }
}
