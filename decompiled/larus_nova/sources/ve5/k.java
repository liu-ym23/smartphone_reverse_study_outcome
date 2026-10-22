package ve5;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f554389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f554390b;

    public k(long r100, e r101) {
        this.f554389a = r100;
        this.f554390b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling complete by max attempts, botId=" + this.f554389a + ", maxAttempts=10");
        this.f554390b.d();
    }
}
