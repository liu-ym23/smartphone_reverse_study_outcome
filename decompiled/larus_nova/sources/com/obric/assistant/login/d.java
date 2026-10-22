package com.obric.assistant.login;

import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements com.obric.matrix.platform.sdk.ones.dataanalysis.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f390251a;

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "installId");
    }

    public d(LoginReportImpl$report$1.a r100) {
        this.f390251a = r100;
    }

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        this.f390251a.invoke(r100);
        MatrixTeaManager r101 = MatrixTeaManager.f396960o;
        MatrixTeaManager.a.a().i(this);
    }
}
