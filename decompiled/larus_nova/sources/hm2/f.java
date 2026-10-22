package hm2;

import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements OnLiveWsMessageReceiveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f485760a;

    @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
    public final void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r101) {
    }

    public f(g r100) {
        this.f485760a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
    public final void onReceiveMsg(LiveWsMessage r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.receiveTime = System.currentTimeMillis();
        g r101 = this.f485760a;
        com.ss.ugc.live.sdk.msg.c r102 = r101.f24286a;
        if (r102 == null) goto L8;
        fmc.c r103 = new fmc.c(r101.f24288c);
        r102.f458212i.b(r103, r100, r101.f24287b);
        return;
    }
}
