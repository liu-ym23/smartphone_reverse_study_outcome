package kc0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes45.dex */
public interface j extends k, dy0.c {
    r createRevMultiControlWidget(r.a r100, ViewGroup r101, Boolean r102, boolean r103);

    Class<? extends Widget> getAnchorTicketWidgetClass();

    qc0.f getInteractFeedView(Context r100, pc0.a r101, int r102, d r103);

    Class<? extends Widget> getProfitInteractionWidgetClass();

    void notifyAudienceEngineEvent();
}
