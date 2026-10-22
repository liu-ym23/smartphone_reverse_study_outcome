package ve5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ e b;

    public i(long r1, e r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r12) {
        AiBotPollingAuthResult r13 = (AiBotPollingAuthResult) r12;
        if (((Result) r13).code != 0) goto L65;
        AiBotPollingAuthResult.Data r0 = (AiBotPollingAuthResult.Data) ((Result) r13).data;
        String r3 = null;
        if (r0 == null) goto L7;
        String r1 = r0.status;
    L9:
        if (Intrinsics.areEqual(r1, "error") == true) goto L65;
        AiBotPollingAuthResult.Data r2 = (AiBotPollingAuthResult.Data) ((Result) r13).data;
        if (r2 == null) goto L14;
        String r4 = r2.status;
    L16:
        if (Intrinsics.areEqual(r4, AiBotPollingAuthResult.STATUS_EXPIRED) == false) goto L21;
        StringBuilder r5 = new StringBuilder("[BOT_POLL_TRACE] polling stop by expired status, botId=");
        r5.append(this.a);
        r5.append(", message=");
        AiBotPollingAuthResult.Data r14 = (AiBotPollingAuthResult.Data) ((Result) r13).data;
        if (r14 == null) goto L20;
        r3 = r14.message;
    L20:
        r5.append(r3);
        tt5.a.h("BotMentionHintCoordinator", r5.toString());
        this.b.d();
        return;
    L21:
        e r6 = this.b;
        long r7 = this.a;
        Intrinsics.checkNotNull(r13);
        r6.getClass();
        AiBotPollingAuthResult.Data r8 = (AiBotPollingAuthResult.Data) ((Result) r13).data;
        if (((Result) r13).code != 0) goto L51;
        if (r8 == null) goto L51;
        String r9 = r8.status;
        if (r9 != null) goto L28;
    L50:
        d r10 = d.a.a;
    L52:
        AiBotPollingAuthResult.Data r11 = (AiBotPollingAuthResult.Data) ((Result) r13).data;
        if (r11 == null) goto L55;
        String r15 = r11.status;
    L57:
        if (Intrinsics.areEqual(r15, "success") == false) goto L59;
        this.b.g.remove(Long.valueOf(this.a));
    L59:
        StringBuilder r16 = new StringBuilder("[BOT_POLL_TRACE] polling result, botId=");
        r16.append(this.a);
        r16.append(", code=");
        r16.append(((Result) r13).code);
        r16.append(", status=");
        r16.append(r15);
        r16.append(", message=");
        AiBotPollingAuthResult.Data r17 = (AiBotPollingAuthResult.Data) ((Result) r13).data;
        if (r17 == null) goto L62;
        r3 = r17.message;
    L62:
        r16.append(r3);
        r16.append(", decision=");
        r16.append(r10.getClass().getSimpleName());
        tt5.a.h("BotMentionHintCoordinator", r16.toString());
        this.b.b(r10);
        if ((r10 instanceof d.b) == false) goto L68;
        this.b.d();
        return;
    L68:
        return;
    L55:
        r15 = null;
        goto L57
    L28:
        switch(r9.hashCode()) {
            case -1867169789: goto L47;
            case -1309235419: goto L43;
            case -682587753: goto L39;
            case 96784904: goto L35;
            case 772475936: goto L31;
            default: goto L50;
        };
    L31:
        if (r9.equals(AiBotPollingAuthResult.STATUS_SLOW_DOWN) == false) goto L50;
        r10 = d.a.a;
        goto L52
    L35:
        if (r9.equals("error") == false) goto L50;
        r10 = d.a.a;
        goto L52
    L39:
        if (r9.equals(AiBotPollingAuthResult.STATUS_PENDING) == false) goto L50;
        r10 = d.a.a;
        goto L52
    L43:
        if (r9.equals(AiBotPollingAuthResult.STATUS_EXPIRED) == false) goto L50;
        r10 = d.a.a;
        goto L52
    L47:
        if (r9.equals("success") == false) goto L50;
        r10 = new d.b(r7);
    L51:
        r10 = d.a.a;
        goto L52
    L14:
        r4 = null;
        goto L16
    L7:
        r1 = null;
    L65:
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling stop by error code, botId=" + this.a + ", code=" + ((Result) r13).code);
        this.b.d();
    }
}
