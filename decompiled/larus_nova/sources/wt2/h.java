package wt2;

import android.os.Build;
import com.bytedance.android.livesdk.config.tt0;
import com.bytedance.android.livesdk.config.wv;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f561189a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f561190a = null;

        static {
            int[] r100 = new int[LiveMode.values().length];
            f561190a = r100;
            r100[LiveMode.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f561190a[LiveMode.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f() {
        int r100 = wv.f121555a.getValue().intValue();
        if (a() == false) goto L10;
        if (r100 <= 0) goto L10;
        if (f561189a >= r100) goto L10;
        if (d() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean c() {
        if (d() == false) goto L5;
    L8:
        return true;
    L5:
        if (e() == true) goto L8;
        return false;
    }

    public static boolean d() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (tt0.f121325a.getValue().mSurfaceRenderClick == false) goto L7;
        return true;
    }

    public static boolean e() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (tt0.f121325a.getValue().mSurfaceRenderDraw == false) goto L7;
        return true;
    }

    public static boolean b(boolean r100, LiveMode r101) {
        if (a() == true) goto L6;
        return false;
    L6:
        if (r100 == true) goto L8;
        int r102 = a.f561190a[r101.ordinal()];
        if (r102 == 1) goto L18;
        if (r102 == 2) goto L16;
        return tt0.f121325a.getValue().mSurfaceRenderDrawOther;
    L16:
        return tt0.f121325a.getValue().mSurfaceRenderDrawAudio;
    L18:
        return tt0.f121325a.getValue().mSurfaceRenderDrawVideo;
    L8:
        return tt0.f121325a.getValue().mSurfaceRenderDrawVs;
    }
}
