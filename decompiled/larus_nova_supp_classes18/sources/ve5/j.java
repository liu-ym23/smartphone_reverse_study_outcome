package ve5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ e b;

    public j(long r1, e r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r4) {
        tt5.a.e("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling failed, botId=" + this.a, (Throwable) r4, false);
        this.b.d();
    }
}
