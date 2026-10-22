package hh6;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f485216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f485217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f485218c;

    public d(String r100, String r101, long r102) {
        this.f485216a = r100;
        this.f485217b = r101;
        this.f485218c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f485216a;
        String r102 = this.f485217b;
        i97.a r103 = i97.a.f488802a;
        long r104 = System.currentTimeMillis() - this.f485218c;
        InteractLinkFullLinkMonitor.g(r101, r102, r104, (Throwable) r100);
    }
}
