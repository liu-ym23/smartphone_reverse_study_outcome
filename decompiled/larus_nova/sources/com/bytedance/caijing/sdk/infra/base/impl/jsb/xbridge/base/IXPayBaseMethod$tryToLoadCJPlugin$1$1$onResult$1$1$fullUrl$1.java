package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base;

import com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class IXPayBaseMethod$tryToLoadCJPlugin$1$1$onResult$1$1$fullUrl$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $schema;

    public IXPayBaseMethod$tryToLoadCJPlugin$1$1$onResult$1$1$fullUrl$1(String r100) {
        this.$schema = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        String r100 = CJSchemaExtensionKt.getQueryParameter(this.$schema, "surl");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
