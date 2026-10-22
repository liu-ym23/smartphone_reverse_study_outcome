package rwb;

import com.ss.android.lark.integrator.security.compliance.ConditionalAccessModuleDependency;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends IOfficeSDKProtocol {

    /* JADX INFO: renamed from: rwb.a$a, reason: collision with other inner class name */
    public interface InterfaceC7547a {
        void onError(int r100, String r101);

        void onSuccess();
    }

    void T0(ConditionalAccessModuleDependency.c.a r100);
}
