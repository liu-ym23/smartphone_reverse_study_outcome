package p4c;

import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes38.dex */
public interface b {
    @Deprecated(message = "not recommended function")
    void a(PolicyModel r100);

    ValidateResult b(PolicyModel r100, AuthEntity r101, ValidateConfig r102);

    boolean d(PolicyModel r100);

    void e(SecurityAction r100);

    void f(PolicyModel[] r100, AuthEntity r101, ValidateConfig r102, m r103);

    void g(l r100);

    long h();

    void i(o4c.b r100);

    boolean j();

    void k(List<ValidateLogInfo> r100);
}
