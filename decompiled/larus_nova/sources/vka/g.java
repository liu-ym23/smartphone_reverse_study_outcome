package vka;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555553a;

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f555553a;
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f555553a = r100;
    }
}
