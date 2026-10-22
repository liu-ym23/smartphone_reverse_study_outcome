package lb1;

import android.graphics.RectF;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends e<nb1.f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fb0.g f508323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f508325d;

    public i(nb1.f r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
        this.f508323b = new fb0.g();
        this.f508324c = "#56000000";
        this.f508325d = new RectF();
    }

    @Override // lb1.g
    public final void a(com.bytedance.android.live.soloktv.template.timeline.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        fb0.g r101 = this.f508323b;
        ColorProtector.parseColor(this.f508324c);
        r101.getClass();
        this.f508325d.set(0.0f, 0.0f, r100.f101464c, r100.f101465d);
    }
}
