package cu2;

import com.bytedance.android.livehostapi.platform.IHostAction;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f465419a = 0;

    /* JADX INFO: renamed from: cu2.a$a, reason: collision with other inner class name */
    public static final class C5589a {
        @JvmStatic
        public static void a() {
            Intrinsics.checkNotNullParameter("live_inner_scroll", "scene");
            IHostAction r100 = (IHostAction) k.f(IHostAction.class);
            if (r100 == null) goto L6;
            r100.beginDoFrameBoost("live_inner_scroll");
            return;
        }

        @JvmStatic
        public static void b() {
            Intrinsics.checkNotNullParameter("live_inner_scroll", "scene");
            IHostAction r100 = (IHostAction) k.f(IHostAction.class);
            if (r100 == null) goto L6;
            r100.endDoFrameBoost("live_inner_scroll");
            return;
        }
    }

    static {
    }
}
