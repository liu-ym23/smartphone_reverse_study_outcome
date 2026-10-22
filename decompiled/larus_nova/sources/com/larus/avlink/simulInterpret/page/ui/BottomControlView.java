package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBindings;
import com.dtf.face.config.IConstValues;
import com.larus.avlink.impl.databinding.LayoutBottomControlViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/BottomControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutBottomControlViewBinding;", "isRotated", "", "onStartTranslationClick", "Lkotlin/Function0;", "", "getOnStartTranslationClick", "()Lkotlin/jvm/functions/Function0;", "setOnStartTranslationClick", "(Lkotlin/jvm/functions/Function0;)V", "onEndTranslationClick", "getOnEndTranslationClick", "setOnEndTranslationClick", "onMuteClick", "getOnMuteClick", "setOnMuteClick", "onFlipScreenClick", "Lkotlin/Function1;", "getOnFlipScreenClick", "()Lkotlin/jvm/functions/Function1;", "setOnFlipScreenClick", "(Lkotlin/jvm/functions/Function1;)V", "setMuteState", "isMuted", "updateForOnBoarding", "updateForListening", "updateForTranslating", "initView", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "setStartSubTextStart", "text", "", "setSubTextEndVisible", "isVisible", "setSubTextEnd", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomControlView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutBottomControlViewBinding f294500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f294501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f294502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f294503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f294504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f294505f;

    public BottomControlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomControlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnEndTranslationClick() {
        return this.f294503d;
    }

    public final Function1<Boolean, Unit> getOnFlipScreenClick() {
        return this.f294505f;
    }

    public final Function0<Unit> getOnMuteClick() {
        return this.f294504e;
    }

    public final Function0<Unit> getOnStartTranslationClick() {
        return this.f294502c;
    }

    public final void setMuteState(boolean r100) {
        ImageView r101 = this.f294500a.f293279c;
        if (r100 == false) goto L5;
        int r102 = R.drawable.icon_speaker_mute_si;
    L6:
        r101.setImageResource(r102);
        return;
    L5:
        r102 = R.drawable.icon_speaker_si;
        goto L6
    }

    public final void setOnEndTranslationClick(Function0<Unit> r100) {
        this.f294503d = r100;
    }

    public final void setOnFlipScreenClick(Function1<? super Boolean, Unit> r100) {
        this.f294505f = r100;
    }

    public final void setOnMuteClick(Function0<Unit> r100) {
        this.f294504e = r100;
    }

    public final void setOnStartTranslationClick(Function0<Unit> r100) {
        this.f294502c = r100;
    }

    public final void setStartSubTextStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f294500a.f293282f.setVisibility(8);
        return;
    L8:
        this.f294500a.f293282f.setVisibility(0);
        this.f294500a.f293282f.setText(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setSubTextEnd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f294500a.f293281e.setVisibility(8);
        return;
    L8:
        this.f294500a.f293281e.setVisibility(0);
        this.f294500a.f293281e.setText(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setSubTextEndVisible(boolean r100) {
        TextView r101 = this.f294500a.f293281e;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public BottomControlView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r100 = LayoutInflater.from(r110).inflate(R.layout.layout_bottom_control_view, this, false);
        addView(r100);
        int r101 = R.id.group_translating;
        Group r102 = (Group) ViewBindings.findChildViewById(r100, R.id.group_translating);
        if (r102 == null) goto L25;
        r101 = R.id.ic_flip;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r100, R.id.ic_flip);
        if (r103 == null) goto L25;
        r101 = R.id.ic_mute;
        ImageView r113 = (ImageView) ViewBindings.findChildViewById(r100, R.id.ic_mute);
        if (r113 == null) goto L25;
        r101 = R.id.layout_end_sl;
        ConstraintLayout r114 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.layout_end_sl);
        if (r114 == null) goto L25;
        r101 = R.id.layout_start_sl;
        ConstraintLayout r115 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.layout_start_sl);
        if (r115 == null) goto L25;
        r101 = R.id.main_text_end_sl;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.main_text_end_sl)) == null) goto L25;
        r101 = R.id.main_text_start_sl;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.main_text_start_sl)) == null) goto L25;
        r101 = R.id.sub_text_end_cl;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.sub_text_end_cl);
        if (r116 == null) goto L25;
        r101 = R.id.sub_text_start_cl;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.sub_text_start_cl);
        if (r117 == null) goto L25;
        r101 = R.id.text_flip;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r100, R.id.text_flip);
        if (r118 == null) goto L25;
        this.f294500a = new LayoutBottomControlViewBinding((ConstraintLayout) r100, r102, r103, r113, r114, r115, r116, r117, r118);
        r115.setOnClickListener(new a(this));
        r114.setOnClickListener(new b(this));
        r118.setOnClickListener(new c(this));
        r103.setOnClickListener(new d(this));
        r113.setOnClickListener(new e(this));
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public /* synthetic */ BottomControlView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
