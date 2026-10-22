package w4b;

import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: classes35.dex */
public interface a {
    void a(ValidateResult r100, AuthorizationServiceV2.AuthorizationType r101);

    void auditLinkEvent(String r100, String r101);

    boolean b();

    void c(String r100, String r101);

    ValidateResult d();

    void e(String r100, String r101, String r102, String r103);

    void f(String r100, String r101);

    AuthorizationServiceV2 g();

    String getUploadAuthorizationTip();

    boolean isAuthorizationPassed(ValidateResult r100);
}
