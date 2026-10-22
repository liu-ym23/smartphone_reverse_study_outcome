package sl7;

import android.app.Activity;
import kk7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jk7.a f542476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xl7.a f542477b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f542478a = null;

        static {
            f542478a = new b();
        }
    }

    public b() {
    }

    public void requestPermissions(Activity r100, String[] r101, c r102) {
        jk7.a r103 = this.f542476a;
        if (r103 == null) goto L6;
        r103.requestPermissions(r100, r101, r102);
        return;
    }
}
