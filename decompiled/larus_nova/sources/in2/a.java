package in2;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Observer<FollowPair> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f490576a;

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
    }

    public a(b r100) {
        this.f490576a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        b r101 = this.f490576a;
        if (r101.f490581f == true) goto L5;
        return;
    L5:
        r101.f490580e = false;
        ExceptionUtils.handleException(r101.getContext(), r100);
    }

    @Override // io.reactivex.Observer
    public final void onNext(FollowPair r100) {
        b r101 = this.f490576a;
        if (r101.f490581f == false) goto L27;
        r101.f490580e = false;
        r101.f490577b.setText(R.string.ttlive_has_followed);
        b r102 = this.f490576a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r104 == null) goto L19;
        d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r103.getLooper()) goto L10;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    }
}
