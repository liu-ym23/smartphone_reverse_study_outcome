package cyb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.opmonitor.trace.OPTraceGSONParser;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f465988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f465989b;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/ss/android/lark/opmonitor/config/MinaConfigKt$getTracingConfig$types$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/ss/android/lark/opmonitor/config/TraceConfig;", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<d> {
        public a() {
        }
    }

    public static final d a() {
        if (f465988a != null) goto L10;
        int r100 = iyb.a.f496623a;
        int r101 = iyb.a.f496623a;
        Intrinsics.checkNotNullParameter("optrace_batch_config", "configKey");
        if (TextUtils.isEmpty("") == true) goto L8;
        Type r102 = new a().getType();
        Gson r103 = OPTraceGSONParser.f437603a;
        f465988a = (d) GsonProtectorUtils.fromJson(OPTraceGSONParser.f437603a, "", r102);
    L8:
        if (f465988a != null) goto L10;
        f465988a = new d();
    L10:
        d r104 = f465988a;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.opmonitor.config.TraceConfig");
        return r104;
    }
}
