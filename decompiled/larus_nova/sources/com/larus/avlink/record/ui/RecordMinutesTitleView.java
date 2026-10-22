package com.larus.avlink.record.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import ba8.f;
import ba8.g;
import com.larus.avlink.impl.databinding.LayoutRecordMinutesTitleBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordMinutesTitleBinding;", "onBackButtonClick", "Lkotlin/Function0;", "", "getOnBackButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "onSettingIconClick", "getOnSettingIconClick", "setOnSettingIconClick", "hideTitleText", "showTitleText", "settingView", "Landroid/view/View;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesTitleView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutRecordMinutesTitleBinding f294321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f294322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f294323c;

    public RecordMinutesTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordMinutesTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnBackButtonClick() {
        return this.f294322b;
    }

    public final Function0<Unit> getOnSettingIconClick() {
        return this.f294323c;
    }

    public final void setOnBackButtonClick(Function0<Unit> r100) {
        this.f294322b = r100;
    }

    public final void setOnSettingIconClick(Function0<Unit> r100) {
        this.f294323c = r100;
    }

    public RecordMinutesTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.layout_record_minutes_title, this, false);
        addView(r103);
        int r104 = R.id.back_button;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r103, R.id.back_button);
        if (r105 == null) goto L11;
        r104 = R.id.right_setting_icon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r103, R.id.right_setting_icon);
        if (r106 == null) goto L11;
        r104 = R.id.toolbar_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.toolbar_title);
        if (r107 == null) goto L11;
        this.f294321a = new LayoutRecordMinutesTitleBinding((ConstraintLayout) r103, r105, r106, r107);
        r105.setOnClickListener(new f(this));
        r106.setOnClickListener(new g(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ RecordMinutesTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
