package ve5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f554381a;

    public g(n r100) {
        this.f554381a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("BotMentionHintCoordinator", "[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded failed, botId=" + this.f554381a.f554398a, (Throwable) r100, false);
    }
}
