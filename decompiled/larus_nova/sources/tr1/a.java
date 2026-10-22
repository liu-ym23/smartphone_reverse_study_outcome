package tr1;

import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.chatroom.vs_impl.widget.BusinessScreenBarWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BusinessScreenBarWidget f547288a;

    public a(BusinessScreenBarWidget r100) {
        this.f547288a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ObjectAnimator r102 = this.f547288a.f118363h;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        ObjectAnimator r103 = this.f547288a.f118364i;
        if (r103 == null) goto L9;
        r103.start();
        return;
    }
}
