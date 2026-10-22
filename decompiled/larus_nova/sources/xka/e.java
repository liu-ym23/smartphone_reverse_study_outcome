package xka;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements vka.b<Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f564290c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f564291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564292b;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.delete(new ala.b(Long.valueOf(this.f564291a), this.f564292b), null, null) <= 0) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    public e(long r100, String r101) {
        this.f564291a = r100;
        this.f564292b = r101;
    }
}
