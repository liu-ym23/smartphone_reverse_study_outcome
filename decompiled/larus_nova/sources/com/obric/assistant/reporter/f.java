package com.obric.assistant.reporter;

import com.obric.assistant.login.LoginReportImpl$report$1;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements com.obric.matrix.platform.sdk.ones.dataanalysis.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f391356a;

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "installId");
    }

    public f(LoginReportImpl$report$1.a r100) {
        this.f391356a = r100;
    }

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        this.f391356a.invoke(r100);
        MatrixTeaManager r101 = MatrixTeaManager.f396960o;
        MatrixTeaManager.a.a().i(this);
    }
}
