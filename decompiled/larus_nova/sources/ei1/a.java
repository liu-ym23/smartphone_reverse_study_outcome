package ei1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.l1;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ik1.c;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f472760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f472761b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        b r101 = this.f472761b;
        c r102 = this.f472760a;
        int r103 = ((Integer) ((KVData) r100).getData()).intValue();
        r101.getClass();
        ALogger.i("FoldDevice", "Current state" + r103);
        if (l1.f65347a.getValue().booleanValue() != true) goto L10;
        RoomSession r104 = r102.f490211d;
        if (r104 == null) goto L11;
        ILivePlayerClient r105 = LivePlatformPlayerManager.a(Long.valueOf(r104.getRoomId()).longValue(), false);
        if (r105 == null) goto L12;
        r105.extraRenderController().onFoldDeviceStateChanged();
        return;
    L12:
        return;
    L11:
        return;
    }

    public a(b r100, c r101) {
        this.f472761b = r100;
        this.f472760a = r101;
    }
}
