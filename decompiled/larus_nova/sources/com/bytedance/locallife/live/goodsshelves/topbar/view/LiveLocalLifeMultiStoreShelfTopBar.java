package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.locallife.live.goodsshelves.bean.h0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeMultiStoreShelfTopBar;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "getTitle", "()Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", com.alipay.sdk.m.x.d.f25925o, "(Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;)V", "title", "", "b", "Ljava/lang/String;", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "anchorId", "Lcom/bytedance/locallife/live/goodsshelves/bean/h0;", "f", "Lcom/bytedance/locallife/live/goodsshelves/bean/h0;", "getLiveLifeTopbarShowInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/h0;", "setLiveLifeTopbarShowInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/h0;)V", "liveLifeTopbarShowInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeMultiStoreShelfTopBar extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f259913g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtTextView f259914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f259915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f259916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f259917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f259918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h0 f259919f;

    public LiveLocalLifeMultiStoreShelfTopBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLocalLifeMultiStoreShelfTopBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final String getAnchorId() {
        return this.f259915b;
    }

    public final h0 getLiveLifeTopbarShowInfo() {
        return this.f259919f;
    }

    public final DmtTextView getTitle() {
        return this.f259914a;
    }

    public final void setAnchorId(String r100) {
        this.f259915b = r100;
    }

    public final void setLiveLifeTopbarShowInfo(h0 r100) {
        this.f259919f = r100;
    }

    public final void setTitle(DmtTextView r100) {
        this.f259914a = r100;
    }

    public static void a(String r100, Map r101) {
        qv6.e.a(r100, r101, true, null);
    }

    public LiveLocalLifeMultiStoreShelfTopBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.saas_poi_live_local_life_multi_store_shelf_top_bar, this, true);
        this.f259914a = (DmtTextView) r103.findViewById(R.id.title);
        this.f259916c = (LinearLayout) r103.findViewById(R.id.consult_layout);
        this.f259917d = (LinearLayout) r103.findViewById(R.id.order_layout);
        this.f259918e = (LinearLayout) r103.findViewById(R.id.vip_layout);
        LinearLayout r104 = this.f259916c;
        if (r104 == null) goto L6;
        r104.setOnClickListener(new c(this));
        return;
    }

    public /* synthetic */ LiveLocalLifeMultiStoreShelfTopBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
