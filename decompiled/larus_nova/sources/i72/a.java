package i72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488458a = 0;

    static {
    }

    public static boolean a(e r110) {
        Intrinsics.checkNotNullParameter(r110, "uiContext");
        int r100 = r110.pT();
        int r101 = r110.WN();
        if (r101 >= ((((double) r100) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        if (r110.g1() == false) goto L13;
        if (r101 <= 0) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L5:
        r102 = false;
        goto L6
    }
}
