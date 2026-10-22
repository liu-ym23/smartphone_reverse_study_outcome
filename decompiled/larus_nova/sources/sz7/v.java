package sz7;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "replaceWith: LarkAvatarView")
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f544033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f544034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Class<? extends g>, sz7.b<? extends g>> f544035c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f544036d = null;

    public static final class a {
        @Deprecated(message = "temp export, not use")
        @JvmStatic
        public static boolean a() {
            if (v.f544034b != null) goto L7;
            return false;
        L7:
            return FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
        }
    }

    public static final class b implements j {
        public b() {
        }

        @Override // sz7.j
        public final void a(Context r100, String r101, String r102, int r103, int r104, ImageView r105) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r105, "imageView");
        }

        @Override // sz7.j
        public final void b(Context r100, String r101, String r102, String r103, int r104, int r105, r r106) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "key");
            r106.onError(new Throwable("icon load not implement"));
        }
    }

    static {
        f544035c = new HashMap();
        f544036d = new b();
    }
}
