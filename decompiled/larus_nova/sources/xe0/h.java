package xe0;

import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f563338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f563339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f563340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f563341d;

    public interface a {
        void B0(long r100);
    }

    public h() {
        this.f563341d = new CopyOnWriteArrayList();
    }

    public final void a(boolean r100, Long r101) {
        long r102 = this.f563339b;
        if (r102 >= 1000) goto L9;
        if (r100 == false) goto L6;
        int r103 = fj0.d.f477462a;
        fj0.d.b(r102, this.f563338a);
    L7:
        String r104 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.k(LinkmicOnlineFloatWindowManager.c.a(), null, Boolean.TRUE, 1);
        return;
    L6:
        int r105 = fj0.d.f477462a;
        fj0.d.a(r102, this.f563338a, r101);
        goto L7
    }
}
