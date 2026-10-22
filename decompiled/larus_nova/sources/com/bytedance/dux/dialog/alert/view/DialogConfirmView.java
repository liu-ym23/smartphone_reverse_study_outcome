package com.bytedance.dux.dialog.alert.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.widget.DuxCheckBox;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Deprecated(message = "only for dux demo")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/dux/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/dux/widget/DuxCheckBox;", "getCheckBox", "Landroid/widget/TextView;", "getNormalTextView", "getLinkTextView", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DialogConfirmView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxCheckBox f204951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f204952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f204953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f204954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f204955e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogConfirmView f204956a;

        public a(DialogConfirmView r100) {
            this.f204956a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f204956a.f204953c.performClick();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogConfirmView f204957a;

        public b(DialogConfirmView r100) {
            this.f204957a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f204957a.getCheckBox().performClick();
        }
    }

    public DialogConfirmView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DialogConfirmView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r100 = getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r101 = (ViewGroup) r100;
        this.f204954d.setPadding(0, r101.getPaddingTop(), 0, r101.getPaddingBottom());
        this.f204954d.setOnClickListener(new a(this));
        r101.setPadding(r101.getPaddingLeft(), 0, r101.getPaddingRight(), 0);
        this.f204955e.setOnClickListener(new b(this));
        return;
    }

    public final DuxCheckBox getCheckBox() {
        return this.f204951a;
    }

    public final TextView getLinkTextView() {
        return this.f204953c;
    }

    public final TextView getNormalTextView() {
        return this.f204952b;
    }

    public DialogConfirmView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_layout_dialog_options, this);
        Resources r103 = Resources.getSystem();
        int r104 = MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        setPadding(r104, r104, r104, 0);
        this.f204951a = (DuxCheckBox) findViewById(R.id.radio);
        this.f204952b = (TextView) findViewById(R.id.tv_normal);
        this.f204953c = (TextView) findViewById(R.id.tv_link);
        this.f204954d = (RelativeLayout) findViewById(R.id.link_text_container);
        this.f204955e = (ViewGroup) findViewById(R.id.click_container);
    }
}
