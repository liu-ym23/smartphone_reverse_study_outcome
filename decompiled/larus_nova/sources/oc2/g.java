package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends a<f32.d, FlowLikeFeatureLevel> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DegradeFeature f522687f;

    @Override // oc2.a
    public final Enum e() {
        FlowLikeFeatureLevel r100 = FlowLikeFeatureLevel.LEVEL_DEFAULT;
        DegradeSceneLevel r101 = this.f522680e.b(DegradeScene.PERFORMANCE_FRAME);
        if (this.f522680e.b(DegradeScene.ECOM) != DegradeSceneLevel.Ecom.HAPPEN) goto L8;
        if (g32.a.f479792a.b() != 3) goto L8;
        return FlowLikeFeatureLevel.LEVEL_FIVE;
    L8:
        if (this.f522680e.a() == false) goto L13;
        if (this.f522680e.b(DegradeScene.LOW_PERFORMANCE_PHONE) != DegradeSceneLevel.LowPerformancePhone.HAPPEN) goto L13;
        return FlowLikeFeatureLevel.LEVEL_FOUR;
    L13:
        if (this.f522680e.b(DegradeScene.LOW_PERFORMANCE_PHONE) == DegradeSceneLevel.LowPerformancePhone.HAPPEN) goto L27;
        if (r101 == DegradeSceneLevel.PerformanceFrame.ANCHOR_OVERHEAT) goto L27;
        if (r101 == DegradeSceneLevel.PerformanceFrame.LEVEL_TWO) goto L32;
        if (r101 == DegradeSceneLevel.PerformanceFrame.LOW_BATTERY) goto L32;
        if (r101 == DegradeSceneLevel.PerformanceFrame.LEVEL_ONE) goto L31;
        return r100;
    L31:
        return FlowLikeFeatureLevel.LEVEL_ONE;
    L32:
        return FlowLikeFeatureLevel.LEVEL_TWO;
    L27:
        return FlowLikeFeatureLevel.LEVEL_THREE;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f522687f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r110) {
        FlowLikeFeatureLevel r100 = (FlowLikeFeatureLevel) r110;
        Intrinsics.checkNotNullParameter(r100, "level");
        int r101 = f.f522686a[r100.ordinal()];
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L21;
        if (r101 == 5) goto L20;
        return new f32.d(false, false, 0, false, 15);
    L20:
        return new f32.d(true, false, 0, false, 14);
    L21:
        return new f32.d(false, true, 0, true, 5);
    L22:
        return new f32.d(false, false, 0, true, 7);
    L23:
        return new f32.d(false, true, 1000, false, 9);
    L18:
        return new f32.d(false, true, 500, false, 9);
    }

    public g(FlowLikeFeatureLevel r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        super(r100, r101);
        this.f522687f = DegradeFeature.FLOW_LIKE;
    }
}
