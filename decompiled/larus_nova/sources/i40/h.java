package i40;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f488147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<Long> f488148b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f488149c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f488150d;

    static {
        f488147a = new ArrayList();
        f488148b = new ArrayList();
        f488149c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveKeyboard", r100);
    }

    @JvmStatic
    public static final void b(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("LiveKeyboard", r100, r101);
    }

    @JvmStatic
    public static final void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveKeyboard", r100);
        if (r101 == false) goto L6;
        f488147a.add(r100);
        f488148b.add(Long.valueOf(System.currentTimeMillis()));
        return;
    }
}
