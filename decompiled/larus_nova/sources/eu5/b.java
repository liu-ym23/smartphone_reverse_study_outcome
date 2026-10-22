package eu5;

import android.app.Application;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f474075a;

    public static Application a() {
        Application r100 = f474075a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return LarkContext.getApplication();
    }

    static {
        f474075a = LarkContext.getApplication();
    }
}
