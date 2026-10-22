package com.larus.avlink.record.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import ba8.d;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesOnboardingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordMinutesOnboardingBinding;", "onShortcutClick", "Lkotlin/Function0;", "", "getOnShortcutClick", "()Lkotlin/jvm/functions/Function0;", "setOnShortcutClick", "(Lkotlin/jvm/functions/Function0;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesOnboardingView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f294316a;

    public RecordMinutesOnboardingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordMinutesOnboardingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnShortcutClick() {
        return this.f294316a;
    }

    public final void setOnShortcutClick(Function0<Unit> r100) {
        this.f294316a = r100;
    }

    public RecordMinutesOnboardingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.layout_record_minutes_onboarding, this, false);
        addView(r103);
        int r104 = R.id.description;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.description)) == null) goto L13;
        r104 = R.id.icon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r103, R.id.icon);
        if (r105 == null) goto L13;
        r104 = R.id.shortcut;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.shortcut);
        if (r106 == null) goto L13;
        r104 = R.id.title;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.title)) == null) goto L13;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        r106.setOnClickListener(new d(this));
        r105.setImageResource(DoraGResourceServiceDelegate.f291642b.i());
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ RecordMinutesOnboardingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
