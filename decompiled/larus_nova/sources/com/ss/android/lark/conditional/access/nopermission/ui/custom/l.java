package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes35.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f418385a;

    public l() {
        this.f418385a = "fixed:advanced_login:geo_restricted";
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = ScsLogger.f440428a;
        ScsLogger.e("SecurityPolicy_CustomNoPermissionFragment", "loadDynamicPageTemplate failed, key=" + this.f418385a + ", error=" + ((Throwable) r100).getMessage());
    }
}
