package com.larus.avlink.env.diary.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.avlink.impl.databinding.LarusViewDiaryFeedbackEntryBinding;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import k98.a;
import k98.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/ui/DiaryFeedbackEntryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusViewDiaryFeedbackEntryBinding;", "value", "selectedActionType", "getSelectedActionType", "()I", "onLikeClick", "Lkotlin/Function0;", "", "getOnLikeClick", "()Lkotlin/jvm/functions/Function0;", "setOnLikeClick", "(Lkotlin/jvm/functions/Function0;)V", "onDislikeClick", "getOnDislikeClick", "setOnDislikeClick", "bind", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackEntryUiModel;", "updateSelectedActionType", ReportConstant.COMMON_ACTION_TYPE, "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiaryFeedbackEntryView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusViewDiaryFeedbackEntryBinding f292062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f292063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f292064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f292065d;

    public DiaryFeedbackEntryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DiaryFeedbackEntryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnDislikeClick() {
        return this.f292065d;
    }

    public final Function0<Unit> getOnLikeClick() {
        return this.f292064c;
    }

    public final int getSelectedActionType() {
        return this.f292063b;
    }

    public final void setOnDislikeClick(Function0<Unit> r100) {
        this.f292065d = r100;
    }

    public final void setOnLikeClick(Function0<Unit> r100) {
        this.f292064c = r100;
    }

    public DiaryFeedbackEntryView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r113 = LayoutInflater.from(r110).inflate(R.layout.larus_view_diary_feedback_entry, this, false);
        addView(r113);
        int r114 = R.id.dora_feedback_entry_actions_layout;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_actions_layout)) == null) goto L23;
        r114 = R.id.dora_feedback_entry_dislike_image;
        ImageView r100 = (ImageView) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_dislike_image);
        if (r100 == null) goto L23;
        r114 = R.id.dora_feedback_entry_dislike_layout;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_dislike_layout);
        if (r115 == null) goto L23;
        r114 = R.id.dora_feedback_entry_dislike_text;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_dislike_text);
        if (r101 == null) goto L23;
        r114 = R.id.dora_feedback_entry_divider_view;
        View r102 = ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_divider_view);
        if (r102 == null) goto L23;
        r114 = R.id.dora_feedback_entry_like_image;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_like_image);
        if (r103 == null) goto L23;
        r114 = R.id.dora_feedback_entry_like_layout;
        LinearLayout r116 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_like_layout);
        if (r116 == null) goto L23;
        r114 = R.id.dora_feedback_entry_like_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_like_text);
        if (r104 == null) goto L23;
        r114 = R.id.dora_feedback_entry_title_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.dora_feedback_entry_title_text);
        if (r105 == null) goto L23;
        this.f292062a = new LarusViewDiaryFeedbackEntryBinding((ConstraintLayout) r113, r100, r115, r101, r102, r103, r116, r104, r105);
        r116.setOnClickListener(new a(this));
        r115.setOnClickListener(new b(this));
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public /* synthetic */ DiaryFeedbackEntryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
