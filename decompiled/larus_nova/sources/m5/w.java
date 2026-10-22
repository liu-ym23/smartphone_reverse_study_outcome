package m5;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class w implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f512037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f512038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f512039c;

    public /* synthetic */ w(String r100, long r101, Map r102) {
        this.f512037a = r100;
        this.f512038b = r101;
        this.f512039c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.f512037a;
        long r101 = this.f512038b;
        Map<? extends String, ? extends Object> r102 = this.f512039c;
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        r103.d("AppletEventMonitorManager", "onLoadTemplateEnd: " + r100);
        i1 r104 = y0.f512051a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        r103.d(r104.f511964h, "onLoadTemplateEnd: " + r100 + ", " + r101);
        h1 r105 = d1.d(r104.f511917c, r100);
        r105.d("applet_load_widget_template_end", Long.valueOf(r101));
        d1.a(r104.f511919e, r100).f512061d.putAll(r102);
        d1.b(r104.f511918d, r100).d("load_template_duration", Long.valueOf(r101 - r105.c("applet_load_widget_template_start")));
        return Unit.INSTANCE;
    }
}
