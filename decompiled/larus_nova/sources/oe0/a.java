package oe0;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f522915a;

    public a(b r100) {
        this.f522915a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        b r101 = this.f522915a;
        r101.c((EnlargeGuestInfo) r100);
    }
}
