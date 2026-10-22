package ak2;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements vlc.l {
    public final /* synthetic */ l a;
    public final /* synthetic */ td.a b;

    public k(l r1, com.bytedance.android.livesdk.livecommerce.messagev2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onMessage(tlc.d r7) {
        this.a.getClass();
        StringBuilder r0 = new StringBuilder("message received: Class: ");
        if (r7 == null) goto L5;
        String r2 = r7.getClass().getSimpleName();
    L6:
        r0.append(r2);
        r0.append(", msgId: ");
        if (r7 == null) goto L9;
        Long r3 = Long.valueOf(r7.getMessageId());
    L10:
        r0.append(r3);
        r0.append(", method: ");
        if (r7 == null) goto L13;
        String r4 = r7.getMessageMethod();
    L14:
        r0.append(r4);
        r0.append(", contentType=");
        boolean r5 = r7 instanceof fe.a;
        if (r5 == true) goto L17;
        tlc.d r6 = null;
    L18:
        fe.a r8 = (fe.a) r6;
        if (r8 == null) goto L21;
        String r9 = r8.getContentType();
    L22:
        r0.append(r9);
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", r0.toString())});
        xh.b r10 = new xh.b();
        r10.c(null);
        r10.b("VirtualMsgChannel");
        r10.a(r1);
        xh.c.a("Live").f(3, r10);
        if (r5 == true) goto L25;
        return;
    L25:
        if ((r7 instanceof ee.a) == false) goto L29;
        this.b.f((ee.a) r7, true);
        return;
    L29:
        return;
    L21:
        r9 = null;
        goto L22
    L17:
        r6 = r7;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
