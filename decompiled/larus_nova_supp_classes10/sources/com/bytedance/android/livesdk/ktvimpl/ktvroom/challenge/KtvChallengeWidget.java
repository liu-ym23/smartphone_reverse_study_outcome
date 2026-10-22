package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.KtvSingChallengeViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/KtvChallengeWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvChallengeWidget extends HolderRoomWidget {
    public KtvSingChallengeViewModel d;
    public final CompositeDisposable e;

    public KtvChallengeWidget() {
        this.e = new CompositeDisposable();
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        this.d = (KtvSingChallengeViewModel) new ViewModelProvider(this, new KtvSingChallengeViewModelFactory(((Widget) this).dataCenter)).get(KtvSingChallengeViewModel.class);
        Pair r0 = com.bytedance.live.datacontext.d.a(KtvChallengeWidget$onCreate$dataContext$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r0.getFirst(), KtvChallengeDataContext.class);
        ((KtvChallengeDataContext) r0.getFirst()).getService().d(this.d);
        this.e.add((Disposable) r0.getSecond());
    }

    public final void onDestroy() {
        super.onDestroy();
        this.e.clear();
    }
}
