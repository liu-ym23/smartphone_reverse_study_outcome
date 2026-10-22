package mk7;

import android.app.Activity;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import uo7.c;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f514342a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f514343a = null;

        static {
            f514343a = new b();
        }
    }

    public b() {
        if (to7.c.c() == false) goto L5;
        lm7.a.b();
    L5:
        to7.c.d(this);
    }

    @Override // uo7.c, uo7.b
    public final void onEnterForeground(Activity r100) {
        super.onEnterForeground(r100);
        d.d("LuckyDogDeviceManager", "onEnterForeground() on call;");
        lm7.a.b();
    }
}
