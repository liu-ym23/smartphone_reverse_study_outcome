package ve5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ n a;

    public g(n r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.e("BotMentionHintCoordinator", "[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded failed, botId=" + this.a.a, (Throwable) r4, false);
    }
}
