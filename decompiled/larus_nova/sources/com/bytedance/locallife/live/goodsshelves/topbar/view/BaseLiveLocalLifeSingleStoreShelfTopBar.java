package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.goodsshelves.bean.h0;
import com.bytedance.locallife.live.util.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/topbar/view/BaseLiveLocalLifeSingleStoreShelfTopBar;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/locallife/live/goodsshelves/bean/h0;", "b", "Lcom/bytedance/locallife/live/goodsshelves/bean/h0;", "getLiveLifeTopbarShowInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/h0;", "setLiveLifeTopbarShowInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/h0;)V", "liveLifeTopbarShowInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseLiveLocalLifeSingleStoreShelfTopBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveGoodsShelvesResponse f259911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f259912b;

    public BaseLiveLocalLifeSingleStoreShelfTopBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseLiveLocalLifeSingleStoreShelfTopBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        int r100 = qv6.e.f534905a;
        LinkedHashMap r101 = new LinkedHashMap();
        LiveGoodsShelvesResponse r102 = this.f259911a;
        if (r102 == null) goto L5;
        r101.put("position_info_type", p.p(r102));
        r101.put("is_top_list_show", "0");
    L5:
        Unit r103 = Unit.INSTANCE;
        qv6.e.a("live_life_bar_hotspot_click", r101, true, null);
    }

    public final h0 getLiveLifeTopbarShowInfo() {
        return this.f259912b;
    }

    public final void setLiveLifeTopbarShowInfo(h0 r100) {
        this.f259912b = r100;
    }

    public BaseLiveLocalLifeSingleStoreShelfTopBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public void a(LiveGoodsShelvesResponse r100, String r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, "liveGoodsShelvesResponse");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        this.f259911a = r100;
    }

    public /* synthetic */ BaseLiveLocalLifeSingleStoreShelfTopBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
