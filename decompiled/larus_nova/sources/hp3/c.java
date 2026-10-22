package hp3;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f486386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f486387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486388d;

    @Override // hp3.b
    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, Long.valueOf(this.f486386b)), TuplesKt.to("sort", Long.valueOf(this.f486387c)), TuplesKt.to("name", this.f486388d)});
    }

    public c(long r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "name");
        super("sortBarClicked");
        this.f486386b = r100;
        this.f486387c = r101;
        this.f486388d = r102;
    }
}
