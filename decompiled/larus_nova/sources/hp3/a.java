package hp3;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f486384c;

    @Override // hp3.b
    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("action_type", this.f486383b), TuplesKt.to("action_params", this.f486384c)});
    }

    public a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionParams");
        super("windowDynamicCardClicked");
        this.f486383b = r100;
        this.f486384c = r101;
    }
}
