package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class RedirectRuleStorage$save$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ d5 $data;

    public RedirectRuleStorage$save$1(d5 r100) {
        this.$data = r100;
        super(1);
    }

    public final Object invoke(boolean r100) {
        com.bytedance.anniex.bd.foundation.impl.r r101 = new com.bytedance.anniex.bd.foundation.impl.r("annie_redirect");
        d5 r102 = this.$data;
        Intrinsics.checkNotNullParameter(r102, "settingsData");
        int r103 = or3.a.f524932a;
        JSONObject r104 = new JSONObject();
        JSONObject r105 = r102.f268024a;
        if (r105 == null) goto L5;
        Intrinsics.checkNotNull(r105);
        com.bytedance.anniex.bd.foundation.impl.o.r(r104, "redirectRules", r105);
    L5:
        JSONObject r106 = r102.f268025b;
        if (r106 == null) goto L8;
        Intrinsics.checkNotNull(r106);
        com.bytedance.anniex.bd.foundation.impl.o.r(r104, "commonConfig", r106);
    L8:
        String r107 = r102.f268026c;
        if (r107 == null) goto L11;
        Intrinsics.checkNotNull(r107);
        com.bytedance.anniex.bd.foundation.impl.o.r(r104, "geckoCDNVersion", r107);
    L11:
        com.bytedance.anniex.bd.foundation.impl.o.r(r104, "settingsDataInitTime", Long.valueOf(r102.f268027d));
        r101.a("redirect_rules", com.bytedance.anniex.bd.foundation.impl.o.a(r104));
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }
}
