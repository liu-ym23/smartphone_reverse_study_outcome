package oc2;

import com.bytedance.android.livesdk.config.o20;
import com.bytedance.android.livesdk.config.p4;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterRoomDurationFeatureLevel;
import kotlin.jvm.internal.Intrinsics;
import r52.l0;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends a<f32.c, EnterRoomDurationFeatureLevel> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f522684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DegradeFeature f522685g;

    @Override // oc2.a
    public final Enum e() {
        EnterRoomDurationFeatureLevel r100 = EnterRoomDurationFeatureLevel.OutEnterRoomDuration;
        com.bytedance.android.livesdk.interactivity.b r101 = this.f522680e;
        DegradeScene r102 = DegradeScene.ENTER_ROOM_DURATION;
        DegradeSceneLevel r103 = r101.b(r102);
        DegradeSceneLevel.EnterRoomDuration r104 = DegradeSceneLevel.EnterRoomDuration.InEnterRoomDuration;
        if (r103 != r104) goto L6;
        r100 = EnterRoomDurationFeatureLevel.InEnterRoomDuration;
    L6:
        if (this.f522680e.b(DegradeScene.GAME) == DegradeSceneLevel.Game.HAPPEN) goto L8;
        return r100;
    L8:
        if (this.f522680e.b(r102) == r104) goto L10;
        return r100;
    L10:
        return EnterRoomDurationFeatureLevel.LEVEL_SMART;
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f522685g;
    }

    @Override // oc2.a
    public final f32.f c(Enum r100) {
        EnterRoomDurationFeatureLevel r101 = (EnterRoomDurationFeatureLevel) r100;
        Intrinsics.checkNotNullParameter(r101, "level");
        int r102 = d.f522683a[r101.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L15;
        p4 r103 = o20.f120877a.getValue();
        if (r103.b() == false) goto L17;
        if (r103.c() <= 0) goto L17;
        return new f32.c(r103.c());
    L17:
        return new f32.c(0);
    L15:
        return new f32.c(0);
    L14:
        return new f32.c(this.f522684f);
    }

    public e(EnterRoomDurationFeatureLevel r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        super(r100, r101);
        int r102 = com.bytedance.android.livesdk.interactivity.api.settings.config.h.f133762a;
        this.f522684f = l0.f536212a.getValue().c();
        this.f522685g = DegradeFeature.ENTER_ROOM_DURATION;
    }
}
