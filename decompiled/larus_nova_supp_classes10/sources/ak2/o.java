package ak2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements com.bytedance.android.livesdk.livecommerce.room.api.f {
    public final MutableLiveData<Boolean> a;
    public final Object b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.f
    public final MutableLiveData<Boolean> getPlaying() {
        return this.a;
    }

    public o(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        this.b = r2;
        if ((r2 instanceof td.e) == false) goto L6;
        MutableLiveData<Boolean> r0 = ((td.e) r2).getPlaying();
    L9:
        this.a = r0;
        if ((r2 instanceof td.e) == false) goto L13;
        ((td.e) r2).getStopped();
    L17:
        if ((r2 instanceof td.e) == false) goto L20;
        ((td.e) r2).getReleased();
    L24:
        if ((r2 instanceof td.e) == false) goto L27;
        ((td.e) r2).getVideoSizeChanged();
    L31:
        if ((r2 instanceof td.e) == false) goto L34;
        ((td.e) r2).getFirstFrame();
    L38:
        if ((r2 instanceof td.e) == false) goto L41;
        ((td.e) r2).getSeiUpdate();
    L45:
        if ((r2 instanceof td.e) == false) goto L48;
        ((td.e) r2).getPlayComplete();
    L52:
        if ((r2 instanceof td.e) == false) goto L55;
        ((td.e) r2).getPlayResume();
    L59:
        if ((r2 instanceof td.e) == false) goto L62;
        ((td.e) r2).getPlayerMute();
    L66:
        if ((r2 instanceof td.e) == false) goto L69;
        ((td.e) r2).getPlayPrepared();
    L73:
        if ((r2 instanceof td.e) == false) goto L76;
        ((td.e) r2).getPlayerMediaError();
    L80:
        if ((r2 instanceof td.e) == false) goto L83;
        ((td.e) r2).isSeiCropping();
    L87:
        if ((r2 instanceof td.e) == false) goto L90;
        ((td.e) r2).getLiveEnd();
    L94:
        if ((r2 instanceof td.e) == false) goto L97;
        ((td.e) r2).getReset();
    L101:
        if ((r2 instanceof td.e) == false) goto L104;
        ((td.e) r2).getPlayerBlur();
        return;
    L104:
        if ((r2 instanceof IRoomEventHub) == false) goto L106;
        ((IRoomEventHub) r2).getPlayerBlur();
        return;
    L106:
        new MutableLiveData();
        return;
    L97:
        if ((r2 instanceof IRoomEventHub) == false) goto L99;
        ((IRoomEventHub) r2).getReset();
        goto L101
    L99:
        new MutableLiveData();
        goto L101
    L90:
        if ((r2 instanceof IRoomEventHub) == false) goto L92;
        ((IRoomEventHub) r2).getLiveEnd();
        goto L94
    L92:
        new MutableLiveData();
        goto L94
    L83:
        if ((r2 instanceof IRoomEventHub) == false) goto L85;
        ((IRoomEventHub) r2).isSeiCropping();
        goto L87
    L85:
        new MutableLiveData();
        goto L87
    L76:
        if ((r2 instanceof IRoomEventHub) == false) goto L78;
        ((IRoomEventHub) r2).getPlayerMediaError();
        goto L80
    L78:
        new MutableLiveData();
        goto L80
    L69:
        if ((r2 instanceof IRoomEventHub) == false) goto L71;
        ((IRoomEventHub) r2).getPlayPrepared();
        goto L73
    L71:
        new MutableLiveData();
        goto L73
    L62:
        if ((r2 instanceof IRoomEventHub) == false) goto L64;
        ((IRoomEventHub) r2).getPlayerMute();
        goto L66
    L64:
        new MutableLiveData();
        goto L66
    L55:
        if ((r2 instanceof IRoomEventHub) == false) goto L57;
        ((IRoomEventHub) r2).getPlayResume();
        goto L59
    L57:
        new MutableLiveData();
        goto L59
    L48:
        if ((r2 instanceof IRoomEventHub) == false) goto L50;
        ((IRoomEventHub) r2).getPlayComplete();
        goto L52
    L50:
        new MutableLiveData();
        goto L52
    L41:
        if ((r2 instanceof IRoomEventHub) == false) goto L43;
        ((IRoomEventHub) r2).getSeiUpdate();
        goto L45
    L43:
        new MutableLiveData();
        goto L45
    L34:
        if ((r2 instanceof IRoomEventHub) == false) goto L36;
        ((IRoomEventHub) r2).getFirstFrame();
        goto L38
    L36:
        new MutableLiveData();
        goto L38
    L27:
        if ((r2 instanceof IRoomEventHub) == false) goto L29;
        ((IRoomEventHub) r2).getVideoSizeChanged();
        goto L31
    L29:
        new MutableLiveData();
        goto L31
    L20:
        if ((r2 instanceof IRoomEventHub) == false) goto L22;
        ((IRoomEventHub) r2).getReleased();
        goto L24
    L22:
        new MutableLiveData();
        goto L24
    L13:
        if ((r2 instanceof IRoomEventHub) == false) goto L15;
        ((IRoomEventHub) r2).getStopped();
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
