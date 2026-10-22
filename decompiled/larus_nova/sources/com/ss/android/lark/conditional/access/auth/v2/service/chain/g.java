package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f417892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f417893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolicyModel f417894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ValidateConfig f417895d;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.conditional.access.auth.v2.c a(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        if (this.f417893b < this.f417892a.size()) goto L6;
        ScsLogger.c("SecurityPolicy_SyncCheckChain", "index >= interceptors.size!");
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L6:
        g r101 = new g(this.f417892a, this.f417893b + 1, r100, this.f417895d);
        return ((n) ListProtector.get(this.f417892a, this.f417893b)).a(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends n> r100, int r101, PolicyModel r102, ValidateConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r102, "mPolicyModel");
        this.f417892a = r100;
        this.f417893b = r101;
        this.f417894c = r102;
        this.f417895d = r103;
    }
}
