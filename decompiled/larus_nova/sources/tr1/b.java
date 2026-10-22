package tr1;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.vs_impl.widget.BusinessScreenBarWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BusinessScreenBarWidget f547289a;

    public b(BusinessScreenBarWidget r100) {
        this.f547289a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        FrameLayout r102 = this.f547289a.f118357b;
        if (r102 == null) goto L6;
        r102.setVisibility(0);
        return;
    }
}
