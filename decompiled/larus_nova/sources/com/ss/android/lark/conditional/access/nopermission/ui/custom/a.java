package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends j0, m0, d0, e, c, e0, f0, g0, k0, b, i0, l0 {

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.nopermission.ui.custom.a$a, reason: collision with other inner class name */
    public static final class C4919a {
        public static boolean a(a r100, CustomDisplayHandler r101, InternalSecurityAction r102, Context r103) {
            Intrinsics.checkNotNullParameter(r101, "handler");
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r104 = r101.type;
            if (r104 != null) goto L5;
        L63:
            int r105 = ScsLogger.f440428a;
            ScsLogger.e("SecurityPolicy_ButtonTypeFunction", "click: unknown button type： " + r101.type);
            return false;
        L5:
            switch(r104.hashCode()) {
                case -2063279368: goto L59;
                case -2055224702: goto L53;
                case -1977847723: goto L49;
                case -1820782903: goto L44;
                case -1520881346: goto L40;
                case -119419380: goto L36;
                case 76232: goto L32;
                case 97165976: goto L28;
                case 411527979: goto L24;
                case 1022185706: goto L20;
                case 1474416494: goto L16;
                case 1584359545: goto L12;
                case 2011110042: goto L8;
                default: goto L63;
            };
        L8:
            if (r104.equals("Cancel") == false) goto L63;
            r100.KT(r101, r102, r103);
            return true;
        L12:
            if (r104.equals("GeoAuth") == false) goto L63;
            r100.QY(r101, r102, r103);
            return true;
        L16:
            if (r104.equals("VerifyLocation") == false) goto L63;
            r100.QY(r101, r102, r103);
            return true;
        L20:
            if (r104.equals("CustomAppLink") == false) goto L63;
            r100.eG(r101, r102, r103);
            return true;
        L24:
            if (r104.equals("CustomLink") == false) goto L63;
            r100.nb(r101, r103);
            return true;
        L28:
            if (r104.equals("DeviceApply") == false) goto L63;
            r100.Fw(r101, r102, r103);
            return true;
        L32:
            if (r104.equals("MFA") == false) goto L63;
            r100.To(r101, r102, r103);
            return true;
        L36:
            if (r104.equals("RetryAccess") == false) goto L63;
            r100.VB(r101, r102, r103);
            return true;
        L40:
            if (r104.equals("DeviceAuth") == false) goto L63;
            r100.Vy(r101, r102, r103);
            return true;
        L44:
            if (r104.equals("DeviceTokenClaimsChallenge") == false) goto L63;
            r100.sI(r101, r102, r103);
            return false;
        L49:
            if (r104.equals("UserConfirm") == false) goto L63;
            r100.uR(r101, r102, r103);
            return true;
        L53:
            if (r104.equals("DeviceCertAuth") == false) goto L63;
            r100.Dx(r101, r102, r103);
            return true;
        L59:
            if (r104.equals(CancelRetainContactInfoFunctions.SkipVerify) == false) goto L63;
            r100.qF(r101, r102, r103);
            return false;
        }
    }

    boolean dL(CustomDisplayHandler r100, InternalSecurityAction r101, Context r102);
}
