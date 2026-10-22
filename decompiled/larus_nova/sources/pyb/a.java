package pyb;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.mfa.FlowMfaEngine;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class a implements azb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowMfaEngine f531053a;

    /* JADX INFO: renamed from: pyb.a$a, reason: collision with other inner class name */
    public static final class C7256a {
    }

    static {
    }

    @Inject
    public a(FlowMfaEngine r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        this.f531053a = r100;
    }

    @Override // azb.a
    public final boolean Wd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        PassportLog.d("OfficeSDKIdpApplink", "handleApplinkIfNeeded called");
        boolean r101 = false;
        if (StringsKt.isBlank(r100) == false) goto L37;
        PassportLog.b("OfficeSDKIdpApplink", "parse applink failed: url is blank");
        return false;
    L37:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L35;
        Uri r105 = (Uri) r103;
        boolean r106 = true;
        if (StringsKt.equals("doubaolarkauth", r105.getScheme(), true) == true) goto L15;
    L19:
        r106 = false;
    L20:
        PassportLog.d("OfficeSDKIdpApplink", "parse applink success: scheme=" + r105.getScheme() + ", host=" + r105.getHost() + ", path=" + r105.getPath() + ", isTargetApplink=" + r106);
        if (r106 == true) goto L39;
        return false;
    L39:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(this.f531053a.b(r100)));     // Catch: Throwable -> L25
    L27:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L33;
        r101 = ((Boolean) r107).booleanValue();
        if (r101 == false) goto L32;
        PassportLog.d("OfficeSDKIdpApplink", "handle external browser IdP applink success");
    L34:
        return r101;
    L32:
        PassportLog.b("OfficeSDKIdpApplink", "handle external browser IdP applink failed: not handled");
        goto L34
    L33:
        PassportLog.c("OfficeSDKIdpApplink", "handle external browser IdP applink failed", r108);
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L15:
        if (StringsKt.equals(BytedCertConstant.CertKey.FLOW, r105.getHost(), true) == false) goto L19;
        if (Intrinsics.areEqual("/officesdk/passport/sso", r105.getPath()) == false) goto L19;
    L35:
        PassportLog.c("OfficeSDKIdpApplink", "parse applink failed", r104);
        return false;
    L8:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
