package cu2;

import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.s0;
import com.bytedance.android.livesdk.t1;
import com.bytedance.android.livesdkapi.model.LiveGcControllerConfig;
import jc1.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f465420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f465421b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f465422c = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(int r100) {
            if (b.f465421b == false) goto L8;
            IMiddlewareHostAction r101 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
            if (r101 == null) goto L9;
            r101.requestBlockGc(r100);
            return;
        L9:
            return;
        }
    }

    static {
        f465422c = new a();
        f465420a = "live_scene_scroll";
        LiveGcControllerConfig r100 = t1.f158504a.getValue();
        if (s0.f157854a.getValue().booleanValue() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        f465421b = r101;
        return;
    L5:
        if (r100.getDisablePrevCall() == true) goto L7;
        r101 = true;
        goto L8
    }
}
