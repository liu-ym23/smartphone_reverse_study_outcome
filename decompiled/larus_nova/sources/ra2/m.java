package ra2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.s51;
import com.bytedance.android.livesdk.config.t2;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import ec2.u0;
import ec2.v1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface m {

    public static final class a {
        public static boolean a(m r100) {
            Integer r101 = null;
            if (v1.f472065a.getValue().d() == false) goto L11;
            IInteractivityInjectService r102 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r102 == null) goto L7;
            Boolean r103 = Boolean.valueOf(r102.isShowWebAnim());
        L8:
            ALogger.i("IAnimComboView", "isShowWebAnim: " + r103);
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L11;
            return true;
        L7:
            r103 = null;
        L11:
            s51 r104 = u0.f472061a.getValue();
            if (r104 == null) goto L43;
            t2 r105 = r104.b();
            if (r105 == null) goto L43;
            float r106 = z0.b(false);
            if (r106 <= 0.0f) goto L22;
            if (r106 > r105.b()) goto L22;
            return r100.a();
        L22:
            if (r105.a() == false) goto L43;
            if (r100.a() == false) goto L41;
            IPerformanceStrategyManager r107 = (IPerformanceStrategyManager) jc1.k.f(IPerformanceStrategyManager.class);
            if (r107 == null) goto L28;
            r101 = Integer.valueOf(r107.getCurrentPerformanceLevel());
        L28:
            if (r101 != null) goto L31;
        L32:
            if (r101 != null) goto L35;
        L37:
            boolean r108 = false;
        L39:
            if (r108 == false) goto L41;
            return true;
        L35:
            if (r101.intValue() != 2) goto L37;
        L38:
            r108 = true;
            goto L39
        L31:
            if (r101.intValue() == 1) goto L38;
        L41:
            return false;
        L43:
            return false;
        }
    }

    boolean a();
}
