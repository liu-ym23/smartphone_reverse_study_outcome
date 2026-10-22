package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskTitleBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskTitleView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskTitleBinding;", "onItemClick", "Lkotlin/Function1;", "", "", "bind", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Title;", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskTitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricOmniBlockTaskTitleBinding f390597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f390598b;

    public static final class a {
    }

    static {
    }

    public TaskTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public TaskTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.obric_omni_block_task_title, this, false);
        addView(r103);
        int r104 = R.id.ivIcon;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r103, R.id.ivIcon);
        if (r105 == null) goto L9;
        r104 = R.id.tvTitle;
        ShimmerTextView r106 = (ShimmerTextView) ViewBindings.findChildViewById(r103, R.id.tvTitle);
        if (r106 == null) goto L9;
        this.f390597a = new ObricOmniBlockTaskTitleBinding((ConstraintLayout) r103, r105, r106);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setOnClickListener(new s0(this));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ TaskTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
