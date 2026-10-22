package com.bytedance.creativex.mediaimport.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/creativex/mediaimport/widget/InternalLoadingView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "progress", "Landroid/view/View;", "setVisibility", "", RemoteMessageConst.Notification.VISIBILITY, "", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InternalLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f204186a;

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.f204186a;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public InternalLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f204186a = LayoutInflater.from(r100).inflate(R.layout.larus_tools_layout_internal_loading, this, true).findViewById(R.id.double_loading_view);
    }
}
