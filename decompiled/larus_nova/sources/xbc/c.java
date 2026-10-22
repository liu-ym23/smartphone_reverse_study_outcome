package xbc;

import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EntityDomain f563188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FileBizDomain f563189b = null;

    static {
        f563188a = EntityDomain.EntityDomainIM;
        f563189b = FileBizDomain.FileBizDomainIM;
    }

    @JvmStatic
    public static final PolicyModel a() {
        return new PolicyModel("PointKey_IM_MSG_FILE_READ", new IMFileEntity("IM_MSG_FILE", f563188a, "IM_MSG_FILE_READ", 0, 0, f563189b, null, null, null, null, null, null, null, null, null, 32704, null), null, 4, null);
    }
}
