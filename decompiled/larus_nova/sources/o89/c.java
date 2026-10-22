package o89;

import android.app.Activity;
import com.larus.nova.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522394a = 0;

    static {
    }

    public static void a(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AtomicBoolean r101 = q.f522409a;
        if (q.f(r100) == false) goto L8;
        return;
    L8:
        if (b.c() == false) goto L11;
        r100.overridePendingTransition(0, R.anim.slide_out_bottom);
        return;
    }
}
