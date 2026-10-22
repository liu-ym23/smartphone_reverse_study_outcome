package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.common.model.field.OriginStageOptionItem;
import com.bytedance.ee.bear.bitable.common.model.field.RichOptionItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends a.C2987a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StageType f207154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<StageFieldConfigInfo> f207155j;

    public final StageType getType() {
        return this.f207154i;
    }

    public d(OriginStageOptionItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this(null, new a.C2987a(r100.getId(), r100.getName(), r100.getColor(), r100.getCapsuleColor(), ""));
        StageType.a r101 = StageType.Companion;
        String r102 = r100.getType();
        r101.getClass();
        this.f207154i = StageType.a.a(r102);
    }

    public d(RichOptionItem r100, a.C2987a r110) {
        Intrinsics.checkNotNullParameter(r110, "optionEntity");
        super(r110.f207141a, r110.f207142b, r110.f207143c, r110.f207144d, r110.f207145e, r110.f207146f);
        StageType.a r111 = StageType.Companion;
        ArrayList<StageFieldConfigInfo> r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getType();
    L6:
        r111.getClass();
        this.f207154i = StageType.a.a(r102);
        StageTransitionRule.a r112 = StageTransitionRule.Companion;
        if (r100 == null) goto L9;
        String r103 = r100.getTransitionRule();
    L10:
        r112.getClass();
        StageTransitionRule[] r113 = StageTransitionRule.values();
        int r104 = r113.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L16;
        if (Intrinsics.areEqual(r113[r105].getValue(), r103) == true) goto L16;
        r105 = r105 + 1;
    L16:
        if (r100 == null) goto L18;
        r101 = r100.getFieldsConfigInfo();
    L18:
        this.f207155j = r101;
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
