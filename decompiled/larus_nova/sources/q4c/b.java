package q4c;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import com.ss.android.lark.security.compliance.api.model.filepolicy.p;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements p4c.b {
    @Override // p4c.b
    public final void a(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
    }

    @Override // p4c.b
    public final boolean d(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        return true;
    }

    @Override // p4c.b
    public final void e(SecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "securityAction");
    }

    @Override // p4c.b
    public final void f(PolicyModel[] r100, AuthEntity r101, ValidateConfig r102, m r103) {
        Intrinsics.checkNotNullParameter(r100, "policyModels");
        Intrinsics.checkNotNullParameter(r103, "callback");
    }

    @Override // p4c.b
    public final void g(l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // p4c.b
    public final long h() {
        return 0;
    }

    @Override // p4c.b
    public final void i(o4c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "securityActionContext");
    }

    @Override // p4c.b
    public final void k(List<ValidateLogInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "resultLogs");
    }

    public b() {
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L6;
        return;
    L6:
        throw new RuntimeException("Crash because u are using ConditionalAccessApiMock in debug mode, ConditionalAccessApiMock should not be used in release\nif u are developing officesdk, please use LarkContext.getApplication().spiByDwarf(IConditionalAccessApi::class.java) instead, it works both in lark and officesdk");
    }

    @Override // p4c.b
    public final ValidateResult b(PolicyModel r100, AuthEntity r101, ValidateConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        return p.f440415a;
    }
}
