package p72;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import u22.m;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f527992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f527993b;

    public d(c r100, String r101) {
        this.f527992a = r100;
        this.f527993b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        if (r101 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.emoji.b r102 = (com.bytedance.android.livesdk.interactivity.api.emoji.b) r101.data;
        if (r102 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.api.emoji.c r103 = r102.a();
        if (r103 == null) goto L15;
        this.f527992a.f527987c = r103;
        xs2.b r104 = xs2.b.a();
        m r105 = new m();
        String r106 = this.f527993b;
        if (r106 == null) goto L11;
        r105.f548435f = r106;
    L11:
        Unit r107 = Unit.INSTANCE;
        r104.post(r105);
        return;
    L15:
        return;
    L14:
        return;
    }
}
