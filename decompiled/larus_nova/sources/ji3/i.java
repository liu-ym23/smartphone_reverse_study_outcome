package ji3;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f499176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f499177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f499178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f499179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f499180e;

    public interface a {
        void onTick();
    }

    public i() {
        this(0);
    }

    public i(int r100) {
        this.f499180e = 1000;
        this.f499177b = new Handler(Looper.getMainLooper());
        this.f499178c = new j(this);
        this.f499179d = new ArrayList();
    }

    public final void a(long r100) {
        if (this.f499176a == true) goto L6;
        return;
    L6:
        if (this.f499179d.isEmpty() == false) goto L8;
        return;
    L8:
        this.f499177b.removeCallbacks(this.f499178c);
        this.f499177b.postDelayed(this.f499178c, r100);
    }
}
