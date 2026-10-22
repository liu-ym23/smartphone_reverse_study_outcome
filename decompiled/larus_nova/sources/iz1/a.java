package iz1;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends l {
    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r100, SelectedStatus r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "selectedStatus");
        return false;
    }

    public a(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
