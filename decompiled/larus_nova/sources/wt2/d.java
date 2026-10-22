package wt2;

import android.os.Build;
import com.bytedance.android.livesdk.config.wh0;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561186a = 0;

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        return false;
    L9:
        return wh0.f121525a.getValue().mDisableShared;
    L5:
        r100 = false;
        goto L6
    }

    static {
    }
}
