package ve5;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements Action {
    public final /* synthetic */ long a;
    public final /* synthetic */ e b;

    public k(long r1, e r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void run() {
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling complete by max attempts, botId=" + this.a + ", maxAttempts=10");
        this.b.d();
    }
}
