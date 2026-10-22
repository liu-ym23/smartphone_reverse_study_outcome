package ms.bd.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes6.dex */
public final class n1 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MSManager f515239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f515240b;

    public final void a() {
        if (this.f515239a != null) goto L5;
        this.f515239a = MSManagerUtils.get(this.f515240b.f515282c);
    L5:
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0c1bd7", new byte[]{5, 110, 87, 47, 82, 46, 31, 75, 118, 55});
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ee22b2", new byte[]{80, 104, 1, 117, 121, 14, 38, 86, 102, 114, 123, 117, 85, 79, 83, 34, 40, 10, 45});
        this.f515239a.report((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "90910e", new byte[]{36, 59, 92, 64, 48, 102, 63, 2}));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        super.handleMessage(r100);
        int r101 = r100.what;
        if (r101 != 0) goto L5;
        this.f515240b.f515285f.post(new l1(this));
        this.f515240b.f515280a.c();
        long r102 = this.f515240b.f515281b.f515400d;
        Message r103 = new Message();
        r103.what = 1;
        sendMessageDelayed(r103, r102);
        return;
    L5:
        if (r101 == 1) goto L15;
        if (r101 != 2) goto L8;
        this.f515240b.f515280a.c();
        long r104 = this.f515240b.f515281b.f515398b;
        Message r105 = new Message();
        r105.what = 2;
        sendMessageDelayed(r105, r104);
        return;
    L8:
        if (r101 != 3) goto L10;
        a();
        long r106 = this.f515240b.f515281b.f515399c;
        Message r107 = new Message();
        r107.what = 3;
        sendMessageDelayed(r107, r106);
        return;
    L10:
        if (r101 != 4) goto L28;
        a();
        this.f515240b.f515280a.a(true);
        this.f515240b.f515284e.removeCallbacks(null);
        this.f515240b.f515287h.countDown();
        return;
    L28:
        return;
    L15:
        this.f515240b.f515285f.post(new m1(this));
        v1 r108 = this.f515240b.f515281b;
        if (r108.f515402f == false) goto L20;
        int r109 = r108.f515398b;
        if (r109 != r108.f515397a) goto L20;
        Message r110 = new Message();
        r110.what = 2;
        sendMessageDelayed(r110, r109);
        return;
    L20:
        long r111 = r108.f515398b;
        Message r112 = new Message();
        r112.what = 0;
        sendMessageDelayed(r112, r111);
    }

    public n1(p1 r100, Looper r101) {
        this.f515240b = r100;
        super(r101);
    }
}
