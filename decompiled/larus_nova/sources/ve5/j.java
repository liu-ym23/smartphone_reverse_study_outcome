package ve5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f554387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f554388b;

    public j(long r100, e r101) {
        this.f554387a = r100;
        this.f554388b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling failed, botId=" + this.f554387a, (Throwable) r100, false);
        this.f554388b.d();
    }
}
