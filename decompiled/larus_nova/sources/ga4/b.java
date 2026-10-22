package ga4;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements d {
    public b() {
    }

    @Override // ga4.d
    public final void a(Activity r100, String[] r101, c.a r102, String r103) {
        if (r100.isFinishing() == false) goto L5;
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new a(this, r101, r100, r102));
    }
}
