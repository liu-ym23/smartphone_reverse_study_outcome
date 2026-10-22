package ak2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements com.bytedance.android.livesdk.livecommerce.room.api.h {
    public final MutableLiveData<Boolean> a;
    public final Object b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.h
    public final MutableLiveData<Boolean> getPlaying() {
        return this.a;
    }

    public p(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        this.b = r2;
        if ((r2 instanceof td.e) == false) goto L6;
        MutableLiveData<Boolean> r0 = ((td.e) r2).getPlaying();
    L9:
        this.a = r0;
        if ((r2 instanceof td.e) == false) goto L13;
        ((td.e) r2).getVideoSizeChanged();
    L17:
        if ((r2 instanceof td.e) == false) goto L20;
        ((td.e) r2).getFirstFrame();
    L24:
        if ((r2 instanceof td.e) == false) goto L27;
        ((td.e) r2).getPlayerMute();
    L31:
        if ((r2 instanceof td.e) == false) goto L34;
        ((td.e) r2).getPlayPrepared();
    L38:
        if ((r2 instanceof td.e) == false) goto L41;
        ((td.e) r2).getPlayerMediaError();
        return;
    L41:
        if ((r2 instanceof IRoomEventHub) == false) goto L43;
        ((IRoomEventHub) r2).getPlayerMediaError();
        return;
    L43:
        new MutableLiveData();
        return;
    L34:
        if ((r2 instanceof IRoomEventHub) == false) goto L36;
        ((IRoomEventHub) r2).getPlayPrepared();
        goto L38
    L36:
        new MutableLiveData();
        goto L38
    L27:
        if ((r2 instanceof IRoomEventHub) == false) goto L29;
        ((IRoomEventHub) r2).getPlayerMute();
        goto L31
    L29:
        new MutableLiveData();
        goto L31
    L20:
        if ((r2 instanceof IRoomEventHub) == false) goto L22;
        ((IRoomEventHub) r2).getFirstFrame();
        goto L24
    L22:
        new MutableLiveData();
        goto L24
    L13:
        if ((r2 instanceof IRoomEventHub) == false) goto L15;
        ((IRoomEventHub) r2).getVideoSizeChanged();
        goto L17
    L15:
        new MutableLiveData();
        goto L17
    L6:
        if ((r2 instanceof IRoomEventHub) == false) goto L8;
        r0 = ((IRoomEventHub) r2).getPlaying();
        goto L9
    L8:
        r0 = new MutableLiveData();
        goto L9
    }
}
