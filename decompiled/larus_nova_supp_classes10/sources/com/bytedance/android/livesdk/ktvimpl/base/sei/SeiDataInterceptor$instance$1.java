package com.bytedance.android.livesdk.ktvimpl.base.sei;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class SeiDataInterceptor$instance$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public SeiDataInterceptor$instance$1(s r8) {
        super(1, r8, s.class, "defaultSeiFilter", "defaultSeiFilter(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String r10) {
        Intrinsics.checkNotNullParameter(r10, "p1");
        s r0 = (s) ((CallableReference) this).receiver;
        s r1 = s.a;
        r0.getClass();
        if (r10.length() != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L10;
        pd2.d.J(pd2.d.n, "data_empty", null, null, null, 30);
        return null;
    L10:
        if (StringsKt.startsWith$default(r10, "JSON", false, 2, null) == false) goto L13;
        r10 = r10.substring(4);
    L13:
        if (StringsKt.contains$default(r10, "ktv_", false, 2, null) == true) goto L15;
        return null;
    L15:
        return r10;
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
