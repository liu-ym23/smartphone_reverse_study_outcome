package i8b;

import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes35.dex */
public interface q extends com.ss.android.lark.conditional.access.auth.v2.handler.c {
    com.ss.android.lark.conditional.access.auth.v2.c a(PolicyModel r100);

    boolean b(PolicyModel r100);

    com.ss.android.lark.conditional.access.auth.v2.c d(PolicyModel r100);

    Object e(List<PolicyModel> r100, FileAuthMonitor.UpdateTrigger r101, Continuation<? super Map<String, b0>> r102);

    boolean f(PolicyModel r100);

    void g(List<PolicyModel> r100, FileAuthMonitor.UpdateTrigger r101);

    boolean h(PolicyModel r100);

    Map<String, com.ss.android.lark.conditional.access.auth.v2.service.i> i();

    com.ss.android.lark.conditional.access.auth.v2.e j(PolicyModel r100, boolean r101);
}
