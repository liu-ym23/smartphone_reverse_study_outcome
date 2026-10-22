package t30;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.live.schema.api.b;
import com.bytedance.android.live.schema.api.c;
import com.bytedance.android.livesdk.config.kg1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements c {
    public a() {
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(b r100, WebcastRedirectReportInfo r101, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r102, Function3<? super Integer, ? super String, ? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "reportInfo");
        Intrinsics.checkNotNullParameter(r102, "success");
        Intrinsics.checkNotNullParameter(r103, "fail");
        r101.a("schema_source", "setting");
        Map<String, ? extends String> r104 = kg1.f120601a.getValue();
        String r105 = r104.get(r100.f100495c);
        if (r105 == null) goto L6;
        r101.a("get_type", "local");
        r102.invoke(new com.bytedance.android.live.schema.api.a(r105));
        return;
    L6:
        r103.invoke(1001, "webcast settings has " + r104.size() + " rules", Boolean.FALSE);
    }
}
