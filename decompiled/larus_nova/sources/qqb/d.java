package qqb;

import com.suite.component.logger.api.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f534510a = null;

    static {
        f534510a = new d();
    }

    public d() {
    }

    @Override // com.suite.component.logger.api.f
    public final boolean a(com.suite.component.logger.b r100, com.suite.component.logger.c r101) {
        Intrinsics.checkNotNullParameter(r100, "logContext");
        Intrinsics.checkNotNullParameter(r101, "logEntity");
        String r102 = a.d();
        if (Intrinsics.areEqual(r102, "") == true) goto L7;
        r101.b("contextID:" + r102 + ' ' + r101.f460117c);
        return true;
    L7:
        return true;
    }
}
