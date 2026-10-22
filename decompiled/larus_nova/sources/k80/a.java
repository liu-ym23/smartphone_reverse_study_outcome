package k80;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements CompletableSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f502075a;

    /* JADX INFO: renamed from: k80.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC6519a extends qtc.a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f502076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final io.reactivex.b f502077c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        @Override // qtc.a
        public final void b() {
            this.f502076b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            if (isDisposed() == true) goto L6;
            this.f502077c.onComplete();
            return;
        }

        public ViewOnAttachStateChangeListenerC6519a(View r100, io.reactivex.b r101) {
            this.f502076b = r100;
            this.f502077c = r101;
        }
    }

    public a(View r100) {
        this.f502075a = r100;
    }

    @Override // io.reactivex.CompletableSource
    public final void subscribe(io.reactivex.b r100) {
        ViewOnAttachStateChangeListenerC6519a r101 = new ViewOnAttachStateChangeListenerC6519a(this.f502075a, r100);
        r100.onSubscribe(r101);
        if (l80.b.f507908a.getAsBoolean() == true) goto L8;
        r100.onError(new IllegalStateException("Views can only be bound to on the main thread!"));
        return;
    L8:
        if (this.f502075a.isAttachedToWindow() == false) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == true) goto L17;
        r100.onError(new OutsideScopeException("View is not attached!"));
        return;
    L17:
        this.f502075a.addOnAttachStateChangeListener(r101);
        if (r101.isDisposed() == false) goto L26;
        this.f502075a.removeOnAttachStateChangeListener(r101);
        return;
    L26:
        return;
    L10:
        if (this.f502075a.getWindowToken() != null) goto L13;
        r102 = false;
    L21:
        e = move-exception;
        throw Exceptions.propagate(e);
    }
}
