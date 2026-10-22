package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.dtf.face.config.IConstValues;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.avlink.impl.databinding.LayoutOnboardingPanelViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/OnboardingPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutOnboardingPanelViewBinding;", "onSetShortcutClick", "Lkotlin/Function0;", "", "getOnSetShortcutClick", "()Lkotlin/jvm/functions/Function0;", "setOnSetShortcutClick", "(Lkotlin/jvm/functions/Function0;)V", "setShortcutText", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "setShortcutViewVisibility", RemoteMessageConst.Notification.VISIBILITY, "updateOnboardingContent", "isConference", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnboardingPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutOnboardingPanelViewBinding f294533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f294534b;

    public OnboardingPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OnboardingPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnSetShortcutClick() {
        return this.f294534b;
    }

    public final void R5(boolean r100) {
        if (r100 == false) goto L4;
        this.f294533a.f293323c.setImageResource(R.drawable.larus_dora_avlink_conference_mode);
        this.f294533a.f293324d.setText(getContext().getString(R.string.larus_dorag_livetranslation_mode1_cn));
        this.f294533a.f293322b.setText(getContext().getString(R.string.larus_dorag_livetranslation_tips2_cn));
        return;
    L4:
        this.f294533a.f293323c.setImageResource(R.drawable.larus_dora_avlink_facetoface_mode);
        this.f294533a.f293324d.setText(getContext().getString(R.string.larus_dorag_livetranslation_mode2_cn));
        this.f294533a.f293322b.setText(getContext().getString(R.string.larus_dorag_livetranslation_tips_cn));
    }

    public final void setOnSetShortcutClick(Function0<Unit> r100) {
        this.f294534b = r100;
    }

    public final void setShortcutText(DoraDeviceType r100) {
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        this.f294533a.f293322b.setText(r100.getOnboardingDescription());
    }

    public final void setShortcutViewVisibility(int r100) {
        this.f294533a.f293325e.setVisibility(r100);
    }

    public OnboardingPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.layout_onboarding_panel_view, this, false);
        addView(r103);
        int r104 = R.id.onboarding_description;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.onboarding_description);
        if (r105 == null) goto L13;
        r104 = R.id.onboarding_icon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r103, R.id.onboarding_icon);
        if (r106 == null) goto L13;
        r104 = R.id.onboarding_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.onboarding_title);
        if (r107 == null) goto L13;
        r104 = R.id.set_shortcut_text;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r103, R.id.set_shortcut_text);
        if (r108 == null) goto L13;
        this.f294533a = new LayoutOnboardingPanelViewBinding((ConstraintLayout) r103, r105, r106, r107, r108);
        r108.setOnClickListener(new q(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ OnboardingPanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
