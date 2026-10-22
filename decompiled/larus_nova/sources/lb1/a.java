package lb1;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytedance.ies.videoclip.api.timeline.ITimeLine;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends e<nb1.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITimeLine f508305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.soloktv.model.k f508306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.soloktv.template.timeline.a f508307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kb1.a f508308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f508309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f508310g;

    /* JADX INFO: renamed from: lb1.a$a, reason: collision with other inner class name */
    public static final class C6669a {
    }

    static {
    }

    public a(nb1.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100);
    }

    @Override // lb1.g
    public final void a(com.bytedance.android.live.soloktv.template.timeline.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f508307d = r100;
        this.f508305b = r100.f101462a;
        this.f508306c = r100.f101463b;
    }
}
