package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeTitleTopBar;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "getTitle", "()Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", com.alipay.sdk.m.x.d.f25925o, "(Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;)V", "title", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeTitleTopBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtTextView f259930a;

    public LiveLocalLifeTitleTopBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLocalLifeTitleTopBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final DmtTextView getTitle() {
        DmtTextView r100 = this.f259930a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    public final void setTitle(DmtTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f259930a = r100;
    }

    public LiveLocalLifeTitleTopBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setTitle((DmtTextView) LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_live_local_life_title_top_bar, this, true).findViewById(R.id.live_shelf_title));
    }

    public /* synthetic */ LiveLocalLifeTitleTopBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
