package zx1;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.gamesticker.LiveGameStickerWidgetV2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.KVData;
import vlc.d;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGameStickerWidgetV2 f573873a;

    public a(LiveGameStickerWidgetV2 r100) {
        this.f573873a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveGameStickerWidgetV2 r101 = this.f573873a;
        r101.f125525c = (d) ((KVData) r100).getData();
        d r102 = this.f573873a.f125525c;
        if (r102 == null) goto L6;
        r102.addMessageListener(MessageType.GAME_ROOM_STICKER_OPR_MESSAGE.getIntType(), this.f573873a.f125536n);
        return;
    }
}
