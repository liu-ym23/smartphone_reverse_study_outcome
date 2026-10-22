package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.multitask_management.impl.databinding.LarusMtmItemSingleIconTemplateBinding;
import com.larus.nova.R;
import com.larus.utils.v0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJX\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2H\u0010\u0010\u001aD\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012#\u0012!\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/OngoingTaskItemSingleIconView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemSingleIconTemplateBinding;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "clickFrom", "", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskItemSingleIconView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f321158b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusMtmItemSingleIconTemplateBinding f321159a;

    public OngoingTaskItemSingleIconView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OngoingTaskItemSingleIconView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public OngoingTaskItemSingleIconView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_mtm_item_single_icon_template, this, false);
        addView(r103);
        int r104 = R.id.mtm_task_action_holder;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.mtm_task_action_holder);
        if (r105 == null) goto L13;
        r104 = R.id.mtm_task_desc;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.mtm_task_desc);
        if (r106 == null) goto L13;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        r104 = R.id.mtm_task_single_icon;
        SimpleDraweeView r108 = (SimpleDraweeView) ViewBindings.findChildViewById(r103, R.id.mtm_task_single_icon);
        if (r108 == null) goto L13;
        r104 = R.id.mtm_task_title;
        TextView r109 = (TextView) ViewBindings.findChildViewById(r103, R.id.mtm_task_title);
        if (r109 == null) goto L13;
        this.f321159a = new LarusMtmItemSingleIconTemplateBinding(r107, r105, r106, r108, r109);
        int r110 = v0.f375471a;
        Intrinsics.checkNotNullParameter(r108, PickerReporterConstants.KEY.TARGET);
        v0.a(r108, 8, 8, 8, 8);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ OngoingTaskItemSingleIconView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
