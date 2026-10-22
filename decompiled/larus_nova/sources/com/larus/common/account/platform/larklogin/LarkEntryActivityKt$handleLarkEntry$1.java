package com.larus.common.account.platform.larklogin;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class LarkEntryActivityKt$handleLarkEntry$1 extends FunctionReferenceImpl implements Function1<Uri, Boolean> {
    public LarkEntryActivityKt$handleLarkEntry$1(Object r100) {
        super(1, r100, LarkLogin.a.class, "isAuthorizationRedirect", "isAuthorizationRedirect(Landroid/net/Uri;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Uri r100) {
        ((LarkLogin.a) this.receiver).getClass();
        return Boolean.valueOf(LarkLogin.f326156h.f(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Uri r100) {
        return invoke2(r100);
    }
}
