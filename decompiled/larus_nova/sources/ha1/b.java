package ha1;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.live.schema.api.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements c {
    public b() {
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(com.bytedance.android.live.schema.api.b r100, WebcastRedirectReportInfo r101, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r102, Function3<? super Integer, ? super String, ? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "reportInfo");
        Intrinsics.checkNotNullParameter(r102, "success");
        Intrinsics.checkNotNullParameter(r103, "fail");
        r101.a("schema_source", "unknown");
        r103.invoke(1001, "", Boolean.TRUE);
    }
}
