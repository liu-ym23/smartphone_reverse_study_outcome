package ve5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotCheckConfigStatusResult;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ e b;

    public f(n r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r12) {
        AiBotCheckConfigStatusResult r13 = (AiBotCheckConfigStatusResult) r12;
        if (((Result) r13).code == 0) goto L5;
    L41:
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded skip, botId=" + this.a.a + ", code=" + ((Result) r13).code);
        return;
    L5:
        if (((Result) r13).data == null) goto L41;
        e r0 = this.b;
        Intrinsics.checkNotNull(r13);
        r0.a(r13);
        AiBotCheckConfigStatusResult.ResultsData r14 = (AiBotCheckConfigStatusResult.ResultsData) ((Result) r13).data;
        boolean r1 = false;
        AiBotCheckConfigStatusResult.Data r3 = null;
        if (r14 == null) goto L21;
        ArrayList<AiBotCheckConfigStatusResult.Data> r15 = r14.results;
        if (r15 == null) goto L21;
        n r4 = this.a;
        Iterator<T> r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L20;
        T r5 = r16.next();
        if (((AiBotCheckConfigStatusResult.Data) r5).botId != r4.a) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L13;
        r3 = r5;
        goto L20
    L17:
        r6 = false;
    L20:
        r3 = r3;
    L21:
        if (r3 != null) goto L23;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded no result, botId=" + this.a.a);
        this.b.d();
        return;
    L23:
        StringBuilder r17 = new StringBuilder("[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded refreshed, botId=");
        r17.append(this.a.a);
        r17.append(", finished=");
        r17.append(r3.finishedConfig);
        r17.append(", deviceCodeEmpty=");
        String r7 = r3.deviceCode;
        if (r7 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        r17.append(r8);
        r17.append(", expired=");
        e r9 = this.b;
        Long r10 = r3.deviceCodeExpireTime;
        r9.getClass();
        r17.append(e.e(r10));
        r17.append(", expireTime=");
        r17.append(r3.deviceCodeExpireTime);
        tt5.a.h("BotMentionHintCoordinator", r17.toString());
        if (r3.finishedConfig == false) goto L33;
        this.b.b(new d.b(this.a.a));
        this.b.d();
        return;
    L33:
        long r11 = this.a.a;
        String r18 = r3.authUrl;
        String r2 = r3.deviceCode;
        n r19 = new n(r11, r18, r2, r3.deviceCodeExpireTime);
        this.b.f = r19;
        if (r2 != null) goto L36;
    L37:
        r1 = true;
    L38:
        if (r1 == false) goto L40;
        this.b.d();
        return;
    L40:
        this.b.g(r19);
        return;
    L36:
        if (StringsKt.isBlank(r2) == false) goto L38;
    L26:
        if (StringsKt.isBlank(r7) == true) goto L29;
        r8 = false;
        goto L30
    }
}
