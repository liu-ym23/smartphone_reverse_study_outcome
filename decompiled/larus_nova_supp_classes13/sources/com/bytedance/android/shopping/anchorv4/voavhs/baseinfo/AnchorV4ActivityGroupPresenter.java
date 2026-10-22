package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4ActivityGroupPresenter extends QPresenter implements com.bytedance.android.shopping.anchorv4.vm.h {
    public final com.bytedance.android.ec.core.arch.viewmodel.c e;
    public ActivityVO f;

    public final void A(QModel r1) {
    }

    public final void S2(float r1) {
    }

    public final void a2(boolean r1) {
    }

    public AnchorV4ActivityGroupPresenter(final FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AnchorV4ActivityGroupPresenter$viewModel$2 r0 = AnchorV4ActivityGroupPresenter$viewModel$2.INSTANCE;
        final Function0<FragmentActivity> r1 = new AnchorV4ActivityGroupPresenter$$special$$inlined$viewModels$1(r5);
        this.e = com.bytedance.android.ec.core.arch.viewmodel.a.a(r5, Reflection.getOrCreateKotlinClass(AnchorV4ActivityGroupViewModel.class), new AnchorV4ActivityGroupPresenter$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void b2(boolean r2) {
        ((AnchorV4ActivityGroupViewModel) this.e.getValue()).isFullScreenState().g(Boolean.valueOf(r2));
    }
}
