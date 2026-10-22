package pn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutConfigModel f529919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerResStep f529920b;

    public e(LayoutConfigModel r100, ProducerResStep r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        Intrinsics.checkNotNullParameter(r101, "step");
        this.f529919a = r100;
        this.f529920b = r101;
    }
}
