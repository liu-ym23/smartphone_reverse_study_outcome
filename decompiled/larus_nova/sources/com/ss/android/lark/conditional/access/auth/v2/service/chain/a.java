package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.l;
import i8b.n;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f417883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f417884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<PolicyModel> f417885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ValidateConfig f417886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f417887e;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.auth.v2.service.chain.a$a, reason: collision with other inner class name */
    public static final class C4916a {
    }

    static {
    }

    @Override // i8b.l
    public final String getTraceId() {
        return this.f417887e;
    }

    @Override // i8b.l
    public final Object a(List<PolicyModel> r100, Continuation<? super Map<String, com.ss.android.lark.conditional.access.auth.v2.c>> r101) {
        if (this.f417884b < this.f417883a.size()) goto L6;
        ScsLogger.c("SecurityPolicy_AsyncCheckChain", "index >= interceptors.size!");
        return com.ss.android.lark.conditional.access.utils.e.b(r100);
    L6:
        a r102 = new a(this.f417883a, this.f417884b + 1, r100, this.f417886d, this.f417887e);
        return ((n) ListProtector.get(this.f417883a, this.f417884b)).b(r102, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends n> r100, int r101, List<PolicyModel> r102, ValidateConfig r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r102, "mPolicyModels");
        Intrinsics.checkNotNullParameter(r104, "traceId");
        this.f417883a = r100;
        this.f417884b = r101;
        this.f417885c = r102;
        this.f417886d = r103;
        this.f417887e = r104;
    }
}
