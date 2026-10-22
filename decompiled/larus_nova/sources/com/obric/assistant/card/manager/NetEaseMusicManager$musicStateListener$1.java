package com.obric.assistant.card.manager;

import android.os.Bundle;
import android.os.Handler;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/card/manager/NetEaseMusicManager$musicStateListener$1", "Lcom/obric/aiagent/assistant/idl/IMusicStateListenerIDL$Stub;", "onMusicStateChanged", "", "state", "Landroid/os/Bundle;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetEaseMusicManager$musicStateListener$1 extends IMusicStateListenerIDL.Stub {
    public static /* synthetic */ void a(Bundle r100) {
        onMusicStateChanged$lambda$0(r100);
    }

    public NetEaseMusicManager$musicStateListener$1() {
    }

    private static final void onMusicStateChanged$lambda$0(Bundle r100) {
        NetEaseMusicManager.f386509f = r100;
        if (r100.getBoolean("isPlaying", false) == true) goto L6;
        NetEaseMusicManager.f386504a.getClass();
        NetEaseMusicManager.f386510g = true;
        NetEaseMusicManager.f386506c.removeCallbacks(NetEaseMusicManager.f386511h);
    L8:
        NetEaseMusicManager.f386504a.getClass();
        NetEaseMusicManager.e(null, r100);
        return;
    L6:
        if (NetEaseMusicManager.f386510g == false) goto L8;
        NetEaseMusicManager.f386504a.getClass();
        NetEaseMusicManager.f386510g = false;
        Handler r101 = NetEaseMusicManager.f386506c;
        NetEaseMusicManager.b r102 = NetEaseMusicManager.f386511h;
        r101.removeCallbacks(r102);
        r101.postDelayed(r102, 1000);
        goto L8
    }

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL
    public void onMusicStateChanged(final Bundle r100) {
        if (r100 != null) goto L4;
        r100 = new Bundle();
    L4:
        NetEaseMusicManager.f386506c.post(new i(r100));
    }
}
