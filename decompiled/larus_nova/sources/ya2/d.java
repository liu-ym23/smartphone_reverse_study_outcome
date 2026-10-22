package ya2;

import com.bytedance.android.livesdk.config.fd0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f567017a;

    @JvmStatic
    public static final int a() {
        if (f567017a != 0) goto L9;
        fd0 r100 = fd0.f120193a;
        int r101 = 50;
        if (r100.getValue().intValue() <= 50) goto L7;
        r101 = r100.getValue().intValue();
    L7:
        f567017a = r101;
    L9:
        return f567017a;
    }

    static {
    }
}
