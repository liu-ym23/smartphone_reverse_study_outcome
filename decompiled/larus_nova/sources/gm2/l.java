package gm2;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements vlc.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h80.d<Long> f481655a;

    public l(h80.d<Long> r100) {
        this.f481655a = r100;
    }

    @Override // vlc.k
    public final void b(long r100, int r101, int r102, long r103) {
        long r104 = this.f481655a.get().longValue();
        int r105 = n.f481657a;
        HashMap r106 = new HashMap();
        r106.put("room_id", Long.valueOf(r104));
        r106.put("msg_id", Long.valueOf(r100));
        r106.put("first_src", Integer.valueOf(r101));
        r106.put("last_src", Integer.valueOf(r102));
        r106.put("delay", Long.valueOf(r103));
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_room_msg_duplicate_all", 0, r103, r106);
    }
}
