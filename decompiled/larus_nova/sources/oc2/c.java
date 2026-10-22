package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterAnimFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends a<f32.b, EnterAnimFeatureLevel> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DegradeFeature f522682f;

    @Override // oc2.a
    public final Enum e() {
        EnterAnimFeatureLevel r100 = EnterAnimFeatureLevel.LEVEL_DEFAULT;
        if (this.f522680e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L5;
        return r100;
    L5:
        if (g32.a.f479792a.e() == 3) goto L7;
        return r100;
    L7:
        return EnterAnimFeatureLevel.LEVEL_ONE;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f522682f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r110) {
        EnterAnimFeatureLevel r100 = (EnterAnimFeatureLevel) r110;
        Intrinsics.checkNotNullParameter(r100, "level");
        if (b.f522681a[r100.ordinal()] == 1) goto L6;
        return new f32.b(false, false, false, false, false, 31);
    L6:
        return new f32.b(true, false, false, false, false, 30);
    }

    public c(EnterAnimFeatureLevel r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        super(r100, r101);
        this.f522682f = DegradeFeature.ENTER_ANIM;
    }
}
