package oc2;

import com.bytedance.android.livesdk.config.e30;
import com.bytedance.android.livesdk.config.yh1;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.TapLikeFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends a<f32.i, TapLikeFeatureLevel> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DegradeFeature f522697f;

    @Override // oc2.a
    public final Enum e() {
        TapLikeFeatureLevel r100 = TapLikeFeatureLevel.LEVEL_DEFAULT;
        boolean r101 = true;
        if (this.f522680e.a() == false) goto L13;
        if (this.f522680e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L13;
        return TapLikeFeatureLevel.LEVEL_THREE;
    L7:
        if (g32.a.f479792a.d() != 2) goto L9;
        r102 = true;
    L13:
        if (this.f522680e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L15;
    L17:
        r101 = false;
    L18:
        if (r101 == false) goto L21;
        return TapLikeFeatureLevel.LEVEL_TWO;
    L21:
        if (this.f522680e.a() == false) goto L24;
        return TapLikeFeatureLevel.LEVEL_ONE;
    L24:
        if (this.f522680e.b(DegradeScene.GAME) == DegradeSceneLevel.Game.HAPPEN) goto L26;
        return r100;
    L26:
        return TapLikeFeatureLevel.LEVEL_SMART;
    L15:
        if (g32.a.f479792a.d() != 2) goto L17;
        goto L17
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f522697f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r110) {
        TapLikeFeatureLevel r100 = (TapLikeFeatureLevel) r110;
        Intrinsics.checkNotNullParameter(r100, "level");
        int r101 = l.f522696a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L16;
        yh1 r102 = e30.f120082a.getValue();
        long r103 = r102.f();
        boolean r104 = r102.c();
        boolean r105 = r102.b();
        boolean r106 = r102.d();
        return new f32.i(r103, r102.a(), r102.e(), r106, r104, r105);
    L16:
        return new f32.i(0, false, false, false, false, 63);
    L18:
        return new f32.i(500, true, true, true, true, 8);
    L19:
        return new f32.i(500, true, false, true, true, 12);
    L15:
        return new f32.i(0, false, true, false, false, 59);
    }

    public m(TapLikeFeatureLevel r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        super(r100, r101);
        this.f522697f = DegradeFeature.TAP_LIKE;
    }
}
