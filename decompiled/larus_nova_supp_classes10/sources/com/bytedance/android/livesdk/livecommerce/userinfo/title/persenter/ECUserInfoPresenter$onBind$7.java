package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$a;", BaseCoreViewModel.CORE_TAG_STATE, "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoPresenter$onBind$7 extends Lambda implements Function1<ECUserInfoState.a, Unit> {
    final /* synthetic */ e this$0;

    public ECUserInfoPresenter$onBind$7(e r1) {
        super(1);
    }

    public final void invoke(ECUserInfoState.a r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        if (r2.a != ECUserInfoState.AnimStateEnum.NONE) goto L6;
        return;
    L6:
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ECUserInfoState.a) r1);
        return Unit.INSTANCE;
    }
}
