package xka;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements vka.b<Boolean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f564293d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f564295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f564296c;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = true;
        if (this.f564295b == null) goto L10;
        if (r100.delete(new ala.d(this.f564295b, this.f564294a), null, null) > 0) goto L19;
        r101 = false;
    L19:
        return Boolean.valueOf(r101);
    L10:
        if (this.f564296c == null) goto L18;
        vka.k r102 = new vka.k();
        r102.a("event_id", this.f564296c);
        Pair<String, String[]> r103 = r102.b();
        String r104 = r103.component1();
        String[] r105 = r103.component2();
        if (r100.delete(new ala.d(this.f564295b, this.f564294a), r104, r105) > 0) goto L16;
        r101 = false;
    L16:
        return Boolean.valueOf(r101);
    L18:
        throw new IllegalArgumentException("id or eventId must be provided");
    }

    public f(String r100, Long r101, Long r102) {
        this.f564294a = r100;
        this.f564295b = r101;
        this.f564296c = r102;
    }
}
