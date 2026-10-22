package com.bytedance.android.livesdk.ktvimpl.ksong.base.view;

import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ksong/base/view/KSongAudienceScoreFinishFragment;", "Lcom/bytedance/android/livesdk/ktvimpl/ksong/base/view/AbsKSongScoreFinishFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongAudienceScoreFinishFragment extends AbsKSongScoreFinishFragment {
    public static final /* synthetic */ int h = 0;
    public float g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KSongAudienceScoreFinishFragment a;

        public b(KSongAudienceScoreFinishFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final Disposable S90() {
        return Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }

    public KSongAudienceScoreFinishFragment() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final float T90() {
        return this.g;
    }
}
