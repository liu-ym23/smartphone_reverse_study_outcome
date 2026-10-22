package ec9;

import android.content.Context;
import android.os.Process;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d0 implements p48.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f472134a;

    public d0(Context r100) {
        this.f472134a = r100;
    }

    @Override // p48.b
    public final void a(String r100) {
        com.larus.home.impl.privacy.a r101 = com.larus.home.impl.privacy.a.f346013a;
        com.larus.home.impl.privacy.a.b(this.f472134a);
        Intrinsics.checkNotNullParameter("Uncaught exception e: " + r100, "reason");
        if (com.larus.home.impl.privacy.a.f346014b != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentProcessName");
    L5:
        Process.killProcess(Process.myPid());
    }
}
