package ms.bd.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes6.dex */
public final class q1 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f515299a;

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        super.onTouchEvent(r100);
        long r101 = r100.getEventTime();
        u1 r102 = this.f515299a.f515337g;
        long r103 = r102.f515374d;
        long r104 = 0;
        if (r103 == 0) goto L6;
        r104 = r101 - r103;
    L6:
        r102.f515373c = r104;
        r102.f515374d = r101;
        r102.f515375e.f515366a = r100.getX();
        this.f515299a.f515337g.f515375e.f515367b = r100.getY();
        this.f515299a.f515337g.f515372b++;
        String r105 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "212cd9", new byte[]{7, 60, 84, 46, 82, 32, 29, 25, 117, 54});
        String r106 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "131d56", new byte[]{101, 53, 24, 80, 39, 46, 38, 27, 111, 58, 5, 39, 71, 30, 30, 123, 114, 87, 115});
        return true;
    }

    public q1(r1 r100, Context r101) {
        this.f515299a = r100;
        super(r101);
    }
}
