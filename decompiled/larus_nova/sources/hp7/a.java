package hp7;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f486453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.bytedance.upc.a f486454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f486455c = null;

    public a() {
    }

    static {
        f486455c = new a();
    }

    public final Context getContext() {
        Application r100 = f486453a;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r100.getApplicationContext();
    }
}
