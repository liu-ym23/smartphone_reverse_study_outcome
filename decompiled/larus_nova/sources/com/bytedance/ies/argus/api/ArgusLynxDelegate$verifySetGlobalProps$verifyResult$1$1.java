package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class ArgusLynxDelegate$verifySetGlobalProps$verifyResult$1$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ ArgusLynxDelegate this$0;

    public ArgusLynxDelegate$verifySetGlobalProps$verifyResult$1$1(ArgusLynxDelegate r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        JSONObject r100 = new JSONObject();
        ArgusLynxDelegate r101 = this.this$0;
        Object r102 = r101.f245628c.f245866k;
        if (r102 != null) goto L5;
        r102 = "-1";
    L5:
        JSONUtilsKt.e(r100, "fe_id", r102);
        JSONUtilsKt.e(r100, "verify_url", r101.f245628c.f245865j);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
