package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.common_res.common_ui.databinding.LarusLayoutGradientMaskBinding;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0007H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/view/GradientMaskView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutGradientMaskBinding;", "updateMaskContainerParams", "", "updateLeftMaskVisibility", "", RemoteMessageConst.Notification.VISIBILITY, "updateRightMaskVisibility", "onVisibilityChanged", "changedView", "Landroid/view/View;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientMaskView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutGradientMaskBinding f328243a;

    public GradientMaskView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientMaskView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        FLogger.f375446a.i("GradientMaskView", "onVisibilityChanged: " + r101);
    }

    public GradientMaskView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_gradient_mask, this, false);
        addView(r103);
        int r104 = R.id.left_mask;
        View r105 = ViewBindings.findChildViewById(r103, R.id.left_mask);
        if (r105 == null) goto L10;
        FrameLayout r106 = (FrameLayout) r103;
        View r107 = ViewBindings.findChildViewById(r103, R.id.right_mask);
        if (r107 == null) goto L8;
        this.f328243a = new LarusLayoutGradientMaskBinding(r106, r105, r106, r107);
        boolean r108 = e2.f365734a.isPad();
        ViewExtKt.k(r105, Boolean.valueOf(r108));
        ViewExtKt.k(r107, Boolean.valueOf(r108));
        post(new t(this));
        return;
    L8:
        r104 = R.id.right_mask;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ GradientMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
