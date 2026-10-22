package fmc;

import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.task.HistoryHttpException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends com.ss.ugc.live.sdk.msg.utils.task.a<com.ss.ugc.live.sdk.msg.network.f, com.ss.ugc.live.sdk.msg.data.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.i f477901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.dispatch.f f477902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vlc.i f477903e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(com.ss.ugc.live.sdk.msg.network.f r110) {
        com.ss.ugc.live.sdk.msg.network.f r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "params");
        long r100 = System.currentTimeMillis();
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> r112 = this.f477901c.a(r111);
    L14:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L66;
        int r101 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        com.ss.ugc.live.sdk.msg.utils.g r102 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L67:
    L51:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L65;
        int r103 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        com.ss.ugc.live.sdk.msg.utils.g r113 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L56:
        if ((r113 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L59;
        com.ss.ugc.live.sdk.msg.utils.g r104 = new com.ss.ugc.live.sdk.msg.utils.g.c(((com.ss.ugc.live.sdk.msg.utils.g.c) r113).f458479b);
    L61:
        b(r104);
        return;
    L59:
        if ((r113 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L64;
        Exception r114 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r113).f458478b;
        r104 = new com.ss.ugc.live.sdk.msg.utils.g.b(new HistoryHttpException(this.f477903e, r114));
        goto L61
    L64:
        throw new NoWhenBranchMatchedException();
    L65:
        throw th;
    L19:
        if ((r102 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L47;
        Pair r115 = (Pair) ((com.ss.ugc.live.sdk.msg.utils.g.c) r102).f458479b;     // Catch: Throwable -> L51
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L51
        com.ss.ugc.live.sdk.msg.network.g r106 = (com.ss.ugc.live.sdk.msg.network.g) r115.getFirst();     // Catch: Throwable -> L51
        SdkResponse r116 = (SdkResponse) r115.getSecond();     // Catch: Throwable -> L51
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L51
        List<SdkMessage> r108 = r116.messages;     // Catch: Throwable -> L51
        if (r108 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == true) goto L45;
        long r117 = System.currentTimeMillis();     // Catch: Throwable -> L51
        Iterator<T> r118 = r116.messages.iterator();     // Catch: Throwable -> L51
    L30:
        if (r118.hasNext() == false) goto L41;
        SdkMessage r119 = (SdkMessage) r118.next();     // Catch: Throwable -> L51
        Long r120 = r116.now;     // Catch: Throwable -> L51
        if (r120 == null) goto L34;
        long r121 = r120.longValue();     // Catch: Throwable -> L51
    L35:
        Long r122 = com.ss.ugc.live.sdk.msg.utils.c.e(r106.f458313c);     // Catch: Throwable -> L51
        if (r122 == null) goto L38;
        r121 = r122.longValue();     // Catch: Throwable -> L51
    L38:
        r119.timestamp = r121;     // Catch: Throwable -> L51
        r119.fromHttp = true;     // Catch: Throwable -> L51
        tlc.d r123 = this.f477902d.a(r119);     // Catch: Throwable -> L51
        if (r123 == null) goto L30;
        r123.setMessageMethod(r119.method);     // Catch: Throwable -> L51
        r123.setHttpSendTime(r100);     // Catch: Throwable -> L51
        r123.setReceiveTime(r105);     // Catch: Throwable -> L51
        r107.add(r123);     // Catch: Throwable -> L51
        goto L30
    L34:
        r121 = System.currentTimeMillis();     // Catch: Throwable -> L51
        goto L35
    L41:
        long r124 = System.currentTimeMillis();     // Catch: Throwable -> L51
        Iterator r125 = r107.iterator();     // Catch: Throwable -> L51
    L43:
        if (r125.hasNext() == false) goto L45;
        tlc.d r126 = (tlc.d) r125.next();     // Catch: Throwable -> L51
        r126.setDecodeStartTime(r117);     // Catch: Throwable -> L51
        r126.setDecodeEndTime(r124);     // Catch: Throwable -> L51
    L45:
        com.ss.ugc.live.sdk.msg.data.b r127 = new com.ss.ugc.live.sdk.msg.data.b(r116, r107, this.f477903e);     // Catch: Throwable -> L51
        r127.f458229a = r106;     // Catch: Throwable -> L51
        r113 = new com.ss.ugc.live.sdk.msg.utils.g.c(r127);     // Catch: Throwable -> L51
        goto L56
    L23:
        if (r108.isEmpty() == true) goto L26;
        r109 = false;
        goto L27
    L47:
        if ((r102 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L50;
        r113 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r102).f458478b);     // Catch: Throwable -> L51
        goto L56
    L50:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L51
    L66:
        throw th;
    L4:
        if ((r112 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L10;
        com.ss.ugc.live.sdk.msg.network.g r128 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r112).f458479b;     // Catch: Throwable -> L14
        if (r128.a() == false) goto L8;
        SdkResponse r129 = SdkResponse.ADAPTER.decode(r128.f458314d);     // Catch: Throwable -> L14
        int r130 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Throwable -> L14
        r102 = new com.ss.ugc.live.sdk.msg.utils.g.c(TuplesKt.to(r128, r129));     // Catch: Throwable -> L14
        goto L67
    L8:
        int r131 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Throwable -> L14
        r102 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r128.f458311a, com.ss.ugc.live.sdk.msg.utils.c.c(r128)));     // Catch: Throwable -> L14
        goto L67
    L10:
        if ((r112 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L13;
        r102 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r112).f458478b);     // Catch: Throwable -> L14
        goto L67
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    }

    public g(d r100, com.ss.ugc.live.sdk.msg.network.i r101, com.ss.ugc.live.sdk.msg.dispatch.f r102, vlc.i r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "httpClient");
        Intrinsics.checkNotNullParameter(r102, "messageDecoder");
        Intrinsics.checkNotNullParameter(r103, "listener");
        super(r100);
        this.f477901c = r101;
        this.f477902d = r102;
        this.f477903e = r103;
    }
}
