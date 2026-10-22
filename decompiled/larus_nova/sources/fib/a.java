package fib;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477428a = 0;

    static {
    }

    public static boolean a() {
        return FeatureGatingModule.getFeatureGatingService().isEnable("lark.split.window");
    }
}
