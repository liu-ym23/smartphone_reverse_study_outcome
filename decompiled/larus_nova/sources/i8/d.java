package i8;

import com.bytedance.android.annie.monitor.common.timing.jsb.GetPerfTimingMethod;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends y6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f488535b;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y6.c f488536a;

        public a(y6.c r100) {
            this.f488536a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new GetPerfTimingMethod(this.f488536a);
        }
    }

    public d() {
        this.f488535b = "AnnieMonitorCommonEnv";
    }

    @Override // y6.a
    public final String a() {
        return this.f488535b;
    }

    @Override // y6.a
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> l(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(TuplesKt.to("getPerfTiming", new a(r100)));
    }
}
