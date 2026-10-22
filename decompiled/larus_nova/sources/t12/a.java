package t12;

import android.content.Context;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.g;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.t0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends l {
    public a(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r100, SelectedStatus r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "selectedStatus");
        String r103 = null;
        if (r100 == null) goto L5;
        Object r104 = r100.f126620h;
    L6:
        boolean r105 = false;
        if ((r104 instanceof h1) == false) goto L32;
        if (r100 == null) goto L10;
        Object r106 = r100.f126620h;
    L11:
        if (r106 == null) goto L31;
        h1 r107 = (h1) r106;
        if (r107.getBizType() != 2) goto L32;
        t0 r108 = r107.getGoodsBizItem();
        if (r108 == null) goto L19;
        g r109 = r108.b();
        if (r109 == null) goto L19;
        r103 = r109.a();
    L19:
        Context r110 = getContext();
        if (r110 != null) goto L22;
    L29:
        return true;
    L22:
        if (StringUtils.isEmpty(r103) == true) goto L29;
        if (r101 != SelectedStatus.LOCATE) goto L26;
        r105 = true;
    L26:
        if (r103 == null) goto L29;
        if (r105 == true) goto L29;
        ((zz0.g) f.a(zz0.g.class)).S2(r110, r103);
        goto L29
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L10:
        r106 = null;
    L32:
        return false;
    L5:
        r104 = null;
        goto L6
    }
}
