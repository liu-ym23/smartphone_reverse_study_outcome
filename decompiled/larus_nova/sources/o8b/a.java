package o8b;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import kotlin.jvm.internal.Intrinsics;
import w4c.c;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    static {
    }

    public static boolean a(InternalSecurityAction r100) {
        if (r100 == null) goto L6;
        DecisionData.Action r101 = r100.getCurrentAction();
        if (r101 == null) goto L6;
        String r102 = r101.getName();
    L8:
        if (Intrinsics.areEqual(r102, "ACCESS_CONTROL_ACTION_COMMON") == true) goto L10;
        return false;
    L10:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L14;
        return false;
    L14:
        if (c.a().i() == true) goto L16;
        return true;
    L16:
        if (r100 != null) goto L18;
        return false;
    L18:
        if (r100.getSource() != 1) goto L22;
        return true;
    L22:
        return false;
    L6:
        r102 = null;
        goto L8
    }
}
