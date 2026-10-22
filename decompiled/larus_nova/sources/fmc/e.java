package fmc;

import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements com.ss.ugc.live.sdk.msg.network.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f477897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f477898b;

    @Override // com.ss.ugc.live.sdk.msg.network.h
    public final void a(com.ss.ugc.live.sdk.msg.network.g r110) {
        Intrinsics.checkNotNullParameter(r110, "httpResponse");
        if (r110.a() == false) goto L37;
        SdkResponse r100 = SdkResponse.ADAPTER.decode(r110.f458314d);
        long r101 = System.currentTimeMillis();
        ArrayList r102 = new ArrayList();
        List<SdkMessage> r103 = r100.messages;
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L29;
        long r105 = System.currentTimeMillis();
        Iterator<T> r106 = r100.messages.iterator();
    L14:
        if (r106.hasNext() == false) goto L25;
        SdkMessage r107 = (SdkMessage) r106.next();
        Long r108 = r100.now;
        if (r108 == null) goto L18;
        long r109 = r108.longValue();
    L19:
        Long r111 = com.ss.ugc.live.sdk.msg.utils.c.e(r110.f458313c);
        if (r111 == null) goto L22;
        r109 = r111.longValue();
    L22:
        r107.timestamp = r109;
        r107.fromHttp = true;
        tlc.d r112 = this.f477897a.f477902d.a(r107);
        if (r112 == null) goto L14;
        r112.setMessageMethod(r107.method);
        r112.setHttpSendTime(this.f477898b);
        r112.setReceiveTime(r101);
        r102.add(r112);
        goto L14
    L18:
        r109 = System.currentTimeMillis();
        goto L19
    L25:
        long r113 = System.currentTimeMillis();
        Iterator r114 = r102.iterator();
    L27:
        if (r114.hasNext() == false) goto L29;
        tlc.d r115 = (tlc.d) r114.next();
        r115.setDecodeStartTime(r105);
        r115.setDecodeEndTime(r113);
    L29:
        r110.f458315e = new com.ss.ugc.live.sdk.msg.data.b(r100, r102, this.f477897a.f477903e);
        return;
    L7:
        if (r103.isEmpty() == true) goto L10;
        r104 = false;
        goto L11
    }

    public e(g r100, long r101) {
        this.f477897a = r100;
        this.f477898b = r101;
    }
}
