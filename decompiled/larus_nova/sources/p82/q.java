package p82;

import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f528155a;

    public q(p r100) {
        this.f528155a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LiveSwitchButton r102 = this.f528155a.f528130e;
        if (r102 == null) goto L6;
        r102.setEnabled(true);
        return;
    }
}
