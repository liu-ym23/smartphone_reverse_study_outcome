package hm2;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.host.LiveHostWsMessageBridge;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends cmc.b<LiveWsMessage> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f485761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h80.d<LiveWsBridge> f485762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f485763f;

    @Override // cmc.b, com.ss.ugc.live.sdk.msg.b
    public final void onInit() {
    }

    public final Pair<String, String> c() {
        if (this.f485763f.isEmpty() == false) goto L6;
        return null;
    L6:
        Pair<String, String> r100 = TuplesKt.to(PayloadItemType.PAYLOAD_TYPE_HOST_ACK.getType(), TextUtils.join(",", this.f485763f));
        this.f485763f.clear();
        return r100;
    }

    @Override // cmc.b, com.ss.ugc.live.sdk.msg.b
    public final void onRelease() {
        LiveHostWsMessageBridge.getInstance().unregisterMsgListener(this.f485761d);
        bc2.c.b("unregister host ws listener");
    }

    @Override // cmc.b, com.ss.ugc.live.sdk.msg.b
    public final void onResume() {
        LiveHostWsMessageBridge.getInstance().registerMsgListener(this.f485761d);
        bc2.c.b("register host ws listener");
    }

    @Override // cmc.b, com.ss.ugc.live.sdk.msg.b
    public final void onStart() {
        LiveHostWsMessageBridge.getInstance().registerMsgListener(this.f485761d);
        bc2.c.b("register host ws listener");
    }

    @Override // cmc.b, com.ss.ugc.live.sdk.msg.b
    public final void a(boolean r100) {
        LiveHostWsMessageBridge.getInstance().unregisterMsgListener(this.f485761d);
        bc2.c.b("unregister host ws listener");
    }

    public g(im2.d r100, im2.k.d r101) {
        CopyOnWriteArrayList r102 = new CopyOnWriteArrayList();
        Intrinsics.checkNotNullParameter(r100, "messageDecoder");
        Intrinsics.checkNotNullParameter(r102, "hostWsMessageAckList");
        super(new e(r100, r101, r102));
        this.f485762e = r101;
        this.f485763f = r102;
        this.f485761d = new f(this);
    }
}
