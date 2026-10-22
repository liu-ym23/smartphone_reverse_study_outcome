package gpb;

import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: gpb.a$a, reason: collision with other inner class name */
    public static final class C6054a {
        @Deprecated(message = "use isFeishuBrand and envType")
        public static int a(a r100) {
            int r101 = r100.envType();
            boolean r102 = !r100.isFeishuBrand();
            if (r101 != 2) goto L5;
            if (r102 == false) goto L18;
            return 5;
        L18:
            return 2;
        L5:
            if (r101 == 3) goto L9;
            if (r102 == false) goto L16;
            return 4;
        L16:
            return 1;
        L9:
            if (r102 == true) goto L17;
            return 3;
        L17:
            return 4;
        }
    }

    int envType();

    String getGeo();

    String getPolicyUrl(PolicyAgreement r100);

    String getTenantBrand();

    String getUserUnit();

    boolean isBoe();

    boolean isChinaMainlandGeo();

    boolean isFeishuBrand();

    @Deprecated(message = "use isFeishuBrand and envType")
    int oldSdkEnv();

    void registerEnvChangeListener(ipb.a r100);
}
