package ig0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f489708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f489709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f489710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f489711d;

    public c(b r100, boolean r101, boolean r102, List r103, Integer r104) {
        this.f489708a = r100;
        this.f489709b = r101;
        this.f489710c = r102;
        this.f489711d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f489708a.t().getWidth();     // Catch: Throwable -> L4
        SeatAnimationView r101 = this.f489708a.t();     // Catch: Throwable -> L4
        b r102 = this.f489708a;     // Catch: Throwable -> L4
        int r103 = r102.f489703i;     // Catch: Throwable -> L4
        MicSeatScene r104 = r102.f498952b;     // Catch: Throwable -> L4
        boolean r105 = this.f489709b;     // Catch: Throwable -> L4
        r101.c(r103, r104, this.f489710c, r105, r100, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
