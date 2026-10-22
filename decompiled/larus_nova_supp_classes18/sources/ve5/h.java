package ve5;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ long a;
    public final /* synthetic */ e b;
    public final /* synthetic */ String c;

    public h(long r1, e r3, String r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final Object apply(Object r6) {
        Long r7 = (Long) r6;
        Intrinsics.checkNotNullParameter(r7, "tick");
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling tick=" + r7.longValue() + ", botId=" + this.a);
        a r8 = this.b.d;
        long r0 = this.a;
        String r2 = this.c;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "deviceCode");
        NetService.f r3 = new NetService.f("/space/api/platform/ai_bot/auth_result");
        ((NetService.e) r3).c = 2;
        r3.b("bot_id", String.valueOf(r0));
        r3.b("device_code", r2);
        return r8.a.Vc(new a.c()).a(r3);
    }
}
