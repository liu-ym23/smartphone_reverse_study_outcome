package ve5;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotCheckConfigStatusResult;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f554379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f554380b;

    public f(n r100, e r101) {
        this.f554379a = r100;
        this.f554380b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        AiBotCheckConfigStatusResult r111 = (AiBotCheckConfigStatusResult) r110;
        if (r111.code == 0) goto L5;
    L41:
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded skip, botId=" + this.f554379a.f554398a + ", code=" + r111.code);
        return;
    L5:
        if (r111.data == 0) goto L41;
        e r100 = this.f554380b;
        Intrinsics.checkNotNull(r111);
        r100.a(r111);
        AiBotCheckConfigStatusResult.ResultsData r112 = (AiBotCheckConfigStatusResult.ResultsData) r111.data;
        boolean r101 = false;
        AiBotCheckConfigStatusResult.Data r102 = null;
        if (r112 == null) goto L21;
        ArrayList<AiBotCheckConfigStatusResult.Data> r113 = r112.results;
        if (r113 == null) goto L21;
        n r103 = this.f554379a;
        Iterator<T> r114 = r113.iterator();
    L13:
        if (r114.hasNext() == false) goto L20;
        T r104 = r114.next();
        if (((AiBotCheckConfigStatusResult.Data) r104).botId != r103.f554398a) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L13;
        r102 = r104;
        goto L20
    L17:
        r105 = false;
    L20:
        r102 = r102;
    L21:
        if (r102 != null) goto L23;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded no result, botId=" + this.f554379a.f554398a);
        this.f554380b.d();
        return;
    L23:
        StringBuilder r115 = new StringBuilder("[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded refreshed, botId=");
        r115.append(this.f554379a.f554398a);
        r115.append(", finished=");
        r115.append(r102.finishedConfig);
        r115.append(", deviceCodeEmpty=");
        String r106 = r102.deviceCode;
        if (r106 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        r115.append(r107);
        r115.append(", expired=");
        e r108 = this.f554380b;
        Long r109 = r102.deviceCodeExpireTime;
        r108.getClass();
        r115.append(e.e(r109));
        r115.append(", expireTime=");
        r115.append(r102.deviceCodeExpireTime);
        tt5.a.h("BotMentionHintCoordinator", r115.toString());
        if (r102.finishedConfig == false) goto L33;
        this.f554380b.b(new d.b(this.f554379a.f554398a));
        this.f554380b.d();
        return;
    L33:
        long r116 = this.f554379a.f554398a;
        String r117 = r102.authUrl;
        String r118 = r102.deviceCode;
        n r119 = new n(r116, r117, r118, r102.deviceCodeExpireTime);
        this.f554380b.f554370f = r119;
        if (r118 != null) goto L36;
    L37:
        r101 = true;
    L38:
        if (r101 == false) goto L40;
        this.f554380b.d();
        return;
    L40:
        this.f554380b.g(r119);
        return;
    L36:
        if (StringsKt.isBlank(r118) == false) goto L38;
    L26:
        if (StringsKt.isBlank(r106) == true) goto L29;
        r107 = false;
        goto L30
    }
}
