package xka;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements vka.b<Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f564287c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f564288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564289b;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.delete(new ala.a(Long.valueOf(this.f564288a), this.f564289b), null, null) <= 0) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    public d(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "accountName");
        this.f564288a = r100;
        this.f564289b = r101;
    }
}
