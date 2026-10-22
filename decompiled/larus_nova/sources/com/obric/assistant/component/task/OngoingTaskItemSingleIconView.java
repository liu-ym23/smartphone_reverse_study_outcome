package com.obric.assistant.component.task;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.impl.databinding.ObricMtmItemSingleIconTemplateBinding;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJZ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2H\u0010\u0010\u001aD\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012#\u0012!\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/component/task/OngoingTaskItemSingleIconView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/impl/databinding/ObricMtmItemSingleIconTemplateBinding;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "clickFrom", "", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskItemSingleIconView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f388802b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricMtmItemSingleIconTemplateBinding f388803a;

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
        View r103 = LayoutInflater.from(r100).inflate(R.layout.obric_mtm_item_single_icon_template, this, false);
        addView(r103);
        int r104 = R.id.mtm_task_action_holder;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.mtm_task_action_holder);
        if (r105 == null) goto L16;
        r104 = R.id.mtm_task_desc;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.mtm_task_desc);
        if (r106 == null) goto L16;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        r104 = R.id.mtm_task_single_icon;
        SimpleDraweeView r108 = (SimpleDraweeView) ViewBindings.findChildViewById(r103, R.id.mtm_task_single_icon);
        if (r108 == null) goto L16;
        r104 = R.id.mtm_task_title;
        TextView r109 = (TextView) ViewBindings.findChildViewById(r103, R.id.mtm_task_title);
        if (r109 == null) goto L16;
        this.f388803a = new ObricMtmItemSingleIconTemplateBinding(r107, r105, r106, r108, r109);
        int r110 = g0.f388873a;
        Intrinsics.checkNotNullParameter(r108, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r108, PickerReporterConstants.KEY.TARGET);
        Object r111 = r108.getParent();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.View");
        View r112 = (View) r111;
        Rect r113 = new Rect();
        r113.left = c7.b(8);
        r113.top = c7.b(8);
        r113.right = c7.b(8);
        r113.bottom = c7.b(8);
        TouchDelegate r114 = r112.getTouchDelegate();
        if ((r114 instanceof g0.b) == false) goto L13;
        g0.b r115 = (g0.b) r114;
        g0.a r116 = new g0.a(r108, r113);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "touchDelegate");
        ((LinkedList) r115.f388881a).add(r116);
        return;
    L13:
        g0.b r117 = new g0.b(r108);
        r112.setTouchDelegate(r117);
        g0.a r118 = new g0.a(r108, r113);
        Intrinsics.checkNotNullParameter(r118, "touchDelegate");
        ((LinkedList) r117.f388881a).add(r118);
        return;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ OngoingTaskItemSingleIconView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
