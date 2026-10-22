package uf;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.common.api.domainselect.IDomainSelect;
import com.bytedance.android.ec.core.opt.ab.p;
import jj4.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IDomainSelect {

    /* JADX INFO: renamed from: uf.a$a, reason: collision with other inner class name */
    public static final class C7874a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.android.ec.common.api.domainselect.IDomainSelect
    public final String selectedHost() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        b r103 = b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("iesec_use_domain_ecombdapi", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r104).booleanValue() == false) goto L16;
        return "https://ecom.ecombdapi.com";
    L16:
        return CJPayConstant.TT_CJ_PAY_FOLLOW_HOST;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }
}
