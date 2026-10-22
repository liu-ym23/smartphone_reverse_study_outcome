package mnb;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.jsruntime.EngineType;
import rnb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514569a = 0;

    /* JADX INFO: renamed from: mnb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6836a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f514570a = null;

        static {
            int[] r100 = new int[EngineType.values().length];
            r100[EngineType.VMSDK_QUICKJS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EngineType.VMSDK_V8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EngineType.AHA_V8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f514570a = r100;
        }
    }

    static {
    }

    public static boolean a() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.enable_runtime_debug");
        c.c("ccm_JSRuntimeFactory", "enableRuntimeDebug: " + r100);
        return r100;
    }
}
