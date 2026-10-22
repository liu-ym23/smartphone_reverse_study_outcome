package ve5;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f554385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f554386b;

    public i(long r100, e r101) {
        this.f554385a = r100;
        this.f554386b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        AiBotPollingAuthResult r111 = (AiBotPollingAuthResult) r110;
        if (r111.code != 0) goto L65;
        AiBotPollingAuthResult.Data r100 = (AiBotPollingAuthResult.Data) r111.data;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.status;
    L9:
        if (Intrinsics.areEqual(r102, "error") == true) goto L65;
        AiBotPollingAuthResult.Data r103 = (AiBotPollingAuthResult.Data) r111.data;
        if (r103 == null) goto L14;
        String r104 = r103.status;
    L16:
        if (Intrinsics.areEqual(r104, AiBotPollingAuthResult.STATUS_EXPIRED) == false) goto L21;
        StringBuilder r105 = new StringBuilder("[BOT_POLL_TRACE] polling stop by expired status, botId=");
        r105.append(this.f554385a);
        r105.append(", message=");
        AiBotPollingAuthResult.Data r112 = (AiBotPollingAuthResult.Data) r111.data;
        if (r112 == null) goto L20;
        r101 = r112.message;
    L20:
        r105.append(r101);
        tt5.a.h("BotMentionHintCoordinator", r105.toString());
        this.f554386b.d();
        return;
    L21:
        e r106 = this.f554386b;
        long r107 = this.f554385a;
        Intrinsics.checkNotNull(r111);
        r106.getClass();
        AiBotPollingAuthResult.Data r108 = (AiBotPollingAuthResult.Data) r111.data;
        if (r111.code != 0) goto L51;
        if (r108 == null) goto L51;
        String r109 = r108.status;
        if (r109 != null) goto L28;
    L50:
        d r113 = d.a.f554362a;
    L52:
        AiBotPollingAuthResult.Data r114 = (AiBotPollingAuthResult.Data) r111.data;
        if (r114 == null) goto L55;
        String r115 = r114.status;
    L57:
        if (Intrinsics.areEqual(r115, "success") == false) goto L59;
        this.f554386b.f554371g.remove(Long.valueOf(this.f554385a));
    L59:
        StringBuilder r116 = new StringBuilder("[BOT_POLL_TRACE] polling result, botId=");
        r116.append(this.f554385a);
        r116.append(", code=");
        r116.append(r111.code);
        r116.append(", status=");
        r116.append(r115);
        r116.append(", message=");
        AiBotPollingAuthResult.Data r117 = (AiBotPollingAuthResult.Data) r111.data;
        if (r117 == null) goto L62;
        r101 = r117.message;
    L62:
        r116.append(r101);
        r116.append(", decision=");
        r116.append(r113.getClass().getSimpleName());
        tt5.a.h("BotMentionHintCoordinator", r116.toString());
        this.f554386b.b(r113);
        if ((r113 instanceof d.b) == false) goto L68;
        this.f554386b.d();
        return;
    L68:
        return;
    L55:
        r115 = null;
        goto L57
    L28:
        switch(r109.hashCode()) {
            case -1867169789: goto L47;
            case -1309235419: goto L43;
            case -682587753: goto L39;
            case 96784904: goto L35;
            case 772475936: goto L31;
            default: goto L50;
        };
    L31:
        if (r109.equals(AiBotPollingAuthResult.STATUS_SLOW_DOWN) == false) goto L50;
        r113 = d.a.f554362a;
        goto L52
    L35:
        if (r109.equals("error") == false) goto L50;
        r113 = d.a.f554362a;
        goto L52
    L39:
        if (r109.equals(AiBotPollingAuthResult.STATUS_PENDING) == false) goto L50;
        r113 = d.a.f554362a;
        goto L52
    L43:
        if (r109.equals(AiBotPollingAuthResult.STATUS_EXPIRED) == false) goto L50;
        r113 = d.a.f554362a;
        goto L52
    L47:
        if (r109.equals("success") == false) goto L50;
        r113 = new d.b(r107);
    L51:
        r113 = d.a.f554362a;
        goto L52
    L14:
        r104 = null;
        goto L16
    L7:
        r102 = null;
    L65:
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] polling stop by error code, botId=" + this.f554385a + ", code=" + r111.code);
        this.f554386b.d();
    }
}
