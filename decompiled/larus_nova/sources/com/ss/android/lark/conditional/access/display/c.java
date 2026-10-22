package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.security.compliance.infra.base.UserScopeProxy;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends UserScopeProxy<g> implements g {
    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        return rf().U(r100);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single v5(String r100) {
        Intrinsics.checkNotNullParameter("fixed:advanced_login:geo_restricted", "displayKey");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        return rf().v5(r100);
    }

    public c(com.ss.android.lark.passportc.api.j r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        super(r100, r101, g.class);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<? extends CustomDisplayConfig> Ld(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        return rf().Ld(r100, r101);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final void S5(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        g.a.a(rf(), r100);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<CustomDisplayModel> ye(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        return rf().ye(r100, r101);
    }
}
