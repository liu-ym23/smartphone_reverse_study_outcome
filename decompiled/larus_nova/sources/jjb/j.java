package jjb;

import com.bytedance.lark.pb.basic.v1.LogoutReason;
import com.bytedance.lark.pb.tool.v1.MakeUserOfflineV2Request;
import com.ss.android.lark.passport.signinsdk_api.feature.context.OfficeSDKLogoutContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f499464a = null;

        static {
            int[] r100 = new int[OfficeSDKLogoutContext.Action.values().length];
            r100[OfficeSDKLogoutContext.Action.SWITCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[OfficeSDKLogoutContext.Action.DOUBAO_CHANGE_BINDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[OfficeSDKLogoutContext.Action.LOGOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f499464a = r100;
        }
    }

    public static final void a(MakeUserOfflineV2Request.Builder r100, j0c.e r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        lzb.a r102 = r101.f496854c;
        if ((r102 instanceof OfficeSDKLogoutContext) == false) goto L5;
        OfficeSDKLogoutContext r103 = (OfficeSDKLogoutContext) r102;
    L6:
        if (r103 == null) goto L23;
        OfficeSDKLogoutContext.Action r104 = r103.f438082a;
        if (r104 == null) goto L24;
        int r105 = a.f499464a[r104.ordinal()];
        if (r105 != 1) goto L13;
        LogoutReason r106 = LogoutReason.ChangeTenant;
    L21:
        r100.logout_reason(r106);
        return;
    L13:
        if (r105 != 2) goto L15;
        r106 = LogoutReason.BoundDoubaoAccountChanged;
        goto L21
    L15:
        if (r105 != 3) goto L18;
        r106 = LogoutReason.UserLogout;
        goto L21
    L18:
        throw new NoWhenBranchMatchedException();
    L24:
        return;
    L23:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
