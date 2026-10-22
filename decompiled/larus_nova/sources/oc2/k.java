package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.HotCommentFeatureLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends a<f32.e, HotCommentFeatureLevel> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DegradeFeature f522695f;

    @Override // oc2.a
    public final Enum e() {
        HotCommentFeatureLevel r100 = HotCommentFeatureLevel.LEVEL_DEFAULT;
        if (this.f522680e.b(DegradeScene.ECOM) == DegradeSceneLevel.Ecom.HAPPEN) goto L5;
        return r100;
    L5:
        if (g32.a.f479792a.c() == 2) goto L7;
        return r100;
    L7:
        return HotCommentFeatureLevel.LEVEL_ONE;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f522695f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r100) {
        HotCommentFeatureLevel r101 = (HotCommentFeatureLevel) r100;
        Intrinsics.checkNotNullParameter(r101, "level");
        if (j.f522694a[r101.ordinal()] == 1) goto L6;
        return new f32.e(false, 3);
    L6:
        return new f32.e(true, 1);
    }

    public k(HotCommentFeatureLevel r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        super(r100, r101);
        this.f522695f = DegradeFeature.HOT_COMMENT_TRAY;
    }
}
