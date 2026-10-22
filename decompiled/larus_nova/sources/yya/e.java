package yya;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface e extends l {

    public static final class a {
        public static void b(MessageActionType r100, yya.a r101) {
            Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(r101, "actionContext");
        }

        public static void c(MessageActionType r100, yya.a r101) {
            Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(r101, "actionContext");
        }

        public static String a(e r100) {
            return r100.getType().name() + "_interceptor";
        }
    }

    boolean b(MessageActionType r100, yya.a r101);

    boolean c(MessageActionType r100, yya.a r101, boolean r102);

    FeatureScopeInterceptorType getType();
}
