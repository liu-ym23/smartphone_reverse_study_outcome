package sw2;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostShare;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f543706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, b> f543707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f543708c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f543709d;

    static {
        f543706a = new d();
        f543707b = new WeakHashMap();
        f543708c = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    }
}
