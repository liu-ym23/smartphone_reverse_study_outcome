package f2;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f475103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f475104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f475105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f475106d;

    static {
        f475103a = new AtomicBoolean(false);
        f475105c = new HashMap();
    }

    public static Context a() {
        Context r100 = f475106d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    public static Activity b() {
        Activity r100 = z4.a.f569879a.a();
        if (r100 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.currentActivity();
    L9:
        return r100;
    }
}
