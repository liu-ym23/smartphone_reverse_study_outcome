package xq0;

import android.text.format.DateUtils;
import com.bytedance.android.livesdk.sharedpref.b;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564792a = 0;

    public static boolean a() {
        Long r100 = b.H3.getValue();
        if ((System.currentTimeMillis() - r100.longValue()) < (((long) 7) * TimeUnit.DAYS.toMillis(1))) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b() {
        Integer r100 = b.G3.getValue();
        Long r101 = b.F3.getValue();
        if (r100.intValue() < 3) goto L5;
    L7:
        return false;
    L5:
        if (DateUtils.isToday(r101.longValue()) == true) goto L7;
        return true;
    }

    static {
    }
}
