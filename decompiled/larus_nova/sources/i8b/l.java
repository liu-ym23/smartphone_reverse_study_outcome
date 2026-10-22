package i8b;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes35.dex */
public interface l {
    Object a(List<PolicyModel> r100, Continuation<? super Map<String, com.ss.android.lark.conditional.access.auth.v2.c>> r101);

    String getTraceId();
}
