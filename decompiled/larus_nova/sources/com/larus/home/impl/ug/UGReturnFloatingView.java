package com.larus.home.impl.ug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.home.impl.databinding.LarusLayoutUgEntranceFloatingViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/home/impl/ug/UGReturnFloatingView;", "Landroid/widget/FrameLayout;", "Lcom/larus/home/impl/ug/IUGReturnFloatingView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/home/impl/databinding/LarusLayoutUgEntranceFloatingViewBinding;", "asView", "Landroid/view/View;", "updateConfig", "", "config", "Lcom/larus/home/impl/ug/UGReturnFloatingViewConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UGReturnFloatingView extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutUgEntranceFloatingViewBinding f346280a;

    public UGReturnFloatingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UGReturnFloatingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.home.impl.ug.b
    public final UGReturnFloatingView asView() {
        return this;
    }

    @Override // com.larus.home.impl.ug.b
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        AppCompatTextView r101 = this.f346280a.f344344e;
        r101.setText(r100.f346310b);
        r101.setTextColor(ResourcesCompat.getColor(r100.f346309a.getResources(), R.color.larus_neutral_100, null));
        c29.a r102 = this.f346280a.f344341b.getDelegate();
        r102.a(ResourcesCompat.getColor(r100.f346309a.getResources(), R.color.larus_base_1, null));
        r102.g(ResourcesCompat.getColor(r100.f346309a.getResources(), R.color.larus_neutral_transparent_2, null));
        this.f346280a.f344342c.setImageDrawable(ResourcesCompat.getDrawable(r100.f346309a.getResources(), R.drawable.larus_ic_ug_return_button, null));
    }

    public UGReturnFloatingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_ug_entrance_floating_view, this, false);
        addView(r103);
        int r104 = R.id.container;
        RoundLinearLayout r105 = (RoundLinearLayout) ViewBindings.findChildViewById(r103, R.id.container);
        if (r105 == null) goto L11;
        r104 = R.id.icon;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.icon);
        if (r106 == null) goto L11;
        FrameLayout r107 = (FrameLayout) r103;
        r104 = R.id.text;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.text);
        if (r108 == null) goto L11;
        this.f346280a = new LarusLayoutUgEntranceFloatingViewBinding(r107, r105, r106, r107, r108);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ UGReturnFloatingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
