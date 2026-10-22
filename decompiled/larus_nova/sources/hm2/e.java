package hm2;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.h7;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements cmc.d<LiveWsMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.dispatch.f f485757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h80.d f485758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f485759c;

    @Override // cmc.d
    public final List a(LiveWsMessage r110) {
        LiveWsMessage r100 = r110;
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        if (r100 != null) goto L5;
        tlc.f r111 = null;
    L12:
        byte[] r101 = d4.c(r111);
        int r102 = com.ss.ugc.live.sdk.msg.utils.e.f458474a;
        if (r101 != null) goto L80;
    L16:
        SdkResponse r103 = null;
    L17:
        ArrayList r104 = new ArrayList();
        if (r103 == null) goto L78;
        List<SdkMessage> r105 = r103.messages;
        boolean r106 = false;
        if (r105 != null) goto L23;
    L26:
        boolean r107 = true;
    L28:
        if (r107 == false) goto L30;
    L62:
        if (r111 == null) goto L64;
        List<com.ss.ugc.live.sdk.msg.network.d> r108 = r111.f546765f;
    L65:
        String r109 = com.ss.ugc.live.sdk.msg.utils.c.a(r108);
        if (r109 != null) goto L68;
        r109 = r103.internal_ext;
    L68:
        if (r109 == null) goto L78;
        h80.d r112 = this.f485758b;
        if (r112 == null) goto L72;
        LiveWsBridge r113 = (LiveWsBridge) r112.get();
    L73:
        if (r113 != null) goto L75;
    L77:
        this.f485759c.add(r109);
        goto L78
    L75:
        if (r113.isConnected() == false) goto L77;
        r113.sendMessage(LiveWsMessage.Builder.create(r113.getWsChannelId()).setLogId(r100.getLogId()).setSeqId(r100.getLogId()).setService(1).setMethod(1).setPayload(r109.getBytes(Charsets.UTF_8)).setPayloadType(PayloadItemType.PAYLOAD_TYPE_HOST_ACK.getType()).setPayloadEncoding("none").setFrom(2).build(), null);
        goto L78
    L72:
        r113 = null;
        goto L73
    L64:
        r108 = null;
        goto L65
    L30:
        if (h7.f120344a.getValue().booleanValue() == true) goto L32;
    L34:
        long r114 = System.currentTimeMillis();
        Iterator<T> r115 = r103.messages.iterator();
    L36:
        if (r115.hasNext() == false) goto L58;
        SdkMessage r116 = (SdkMessage) r115.next();
        Long r117 = r103.now;
        if (r117 == null) goto L40;
        long r118 = r117.longValue();
    L41:
        if (r111 == null) goto L43;
        List<com.ss.ugc.live.sdk.msg.network.d> r119 = r111.f546765f;
    L44:
        Long r120 = com.ss.ugc.live.sdk.msg.utils.c.e(r119);
        if (r120 == null) goto L47;
        r118 = r120.longValue();
    L47:
        r116.timestamp = r118;
        r116.fromHttp = r106;
        tlc.d r121 = this.f485757a.a(r116);
        if (r121 == null) goto L57;
        if ((r121 instanceof o0) == true) goto L52;
        tlc.d r122 = null;
    L53:
        o0 r123 = (o0) r122;
        if (r123 == null) goto L56;
        r123.setMessageFrom(2);
    L56:
        r121.setMessageMethod(r116.method);
        r121.setReceiveTime(r100.receiveTime);
        r104.add(r121);
        goto L57
    L52:
        r122 = r121;
    L57:
        r106 = false;
        goto L36
    L43:
        r119 = null;
        goto L44
    L40:
        r118 = System.currentTimeMillis();
        goto L41
    L58:
        long r124 = System.currentTimeMillis();
        Iterator r125 = r104.iterator();
    L60:
        if (r125.hasNext() == false) goto L62;
        tlc.d r126 = (tlc.d) r125.next();
        r126.setDecodeStartTime(r114);
        r126.setDecodeEndTime(r124);
        goto L60
    L32:
        if (v.a() == false) goto L34;
        AndroidSchedulers.mainThread().scheduleDirect(new d(r103));
        goto L34
    L23:
        if (r105.isEmpty() == true) goto L26;
        r107 = false;
    L78:
        return r104;
    L80:
        r103 = SdkResponse.ADAPTER.decode(r101);     // Catch: Exception -> L79
    L5:
        ArrayList r127 = new ArrayList();
        if (r100.getMsgHeaders() == null) goto L11;
        Iterator<LiveWsMessage.MsgHeader> r128 = r100.getMsgHeaders().iterator();
    L9:
        if (r128.hasNext() == false) goto L11;
        LiveWsMessage.MsgHeader r129 = r128.next();
        r127.add(new com.ss.ugc.live.sdk.msg.network.d(r129.getKey(), r129.getValue()));
    L11:
        r111 = new tlc.f(r100.getService(), r100.getMethod(), r100.getPayloadType(), r100.getPayloadEncoding(), r100.getPayload(), r127, r100.getLogId(), r100.getSeqId());
        bc2.c.f(r111);
        goto L12
    }

    public e(im2.d r100, h80.d r101, List r102) {
        this.f485757a = r100;
        this.f485758b = r101;
        this.f485759c = r102;
    }
}
