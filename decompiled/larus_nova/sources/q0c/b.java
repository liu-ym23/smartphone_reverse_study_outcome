package q0c;

import android.content.Context;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: classes37.dex */
public interface b {

    public interface a {
    }

    void checkImageDownloadAuthorizationAndShowWarningOnFailed(String r100, String r101, String r102, Context r103, Integer r104, AuthorizationServiceV2.b r105);

    a getGuideDependency();

    String getWatermarkResource(String r100, String r101);

    void goImageForwardSelectPage(Context r100, String r101, int r102);

    boolean isAuthorizationPassed(ValidateResult r100);

    boolean isCipherStatusOn();

    boolean isFeatureGatingEnable(String r100);
}
