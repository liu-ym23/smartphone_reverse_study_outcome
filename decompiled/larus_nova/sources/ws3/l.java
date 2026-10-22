package ws3;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f561029a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f561030a = null;

        static {
            f561030a = new l();
        }
    }

    public final long a() {
        return this.f561029a.i();
    }

    public l() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.f561029a = new g();
    L6:
        this.f561029a.init();
        return;
    L5:
        this.f561029a = new h();
        goto L6
    }
}
