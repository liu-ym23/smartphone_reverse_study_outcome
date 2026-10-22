package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$b;", BaseCoreViewModel.CORE_TAG_STATE, "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoAvatarPresenter$onBind$2 extends Lambda implements Function1<ECUserInfoState.b, Unit> {
    final /* synthetic */ b this$0;

    public ECUserInfoAvatarPresenter$onBind$2(b r1) {
        super(1);
    }

    public final void invoke(ECUserInfoState.b r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        if (r2.a != null) goto L5;
        return;
    L5:
        int r3 = b.e;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ECUserInfoState.b) r1);
        return Unit.INSTANCE;
    }
}
