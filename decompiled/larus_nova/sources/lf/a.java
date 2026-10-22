package lf;

import cf.l;
import com.bytedance.android.ec.base.service.ECServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509031a = 0;

    static {
    }

    public static void b(boolean r100) {
        boolean r101 = ECServiceManager.f42805a;
        l r102 = (l) ECServiceManager.c(l.class);
        if (r102 == null) goto L6;
        r102.Oa(r100);
        return;
    }

    public static void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "upon");
        boolean r102 = ECServiceManager.f42805a;
        l r103 = (l) ECServiceManager.c(l.class);
        if (r103 == null) goto L6;
        r103.Aa(r100, r101);
        return;
    }
}
