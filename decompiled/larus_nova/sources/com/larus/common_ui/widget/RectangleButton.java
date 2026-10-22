package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusRectangleButtonBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/larus/common_ui/widget/RectangleButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusRectangleButtonBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusRectangleButtonBinding;", "updateButtonState", "", "enable", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RectangleButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusRectangleButtonBinding f328483a;

    public final LarusRectangleButtonBinding getBinding() {
        return this.f328483a;
    }

    public RectangleButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(boolean r100) {
        setEnabled(r100);
        if (r100 == false) goto L9;
        LarusRectangleButtonBinding r101 = this.f328483a;
        if (r101 == null) goto L15;
        LinearLayout r102 = r101.f326771b;
        if (r102 == null) goto L16;
        r102.setBackground(getContext().getDrawable(c.b(R.attr.larus_bg_age_gate_next_button, getContext(), R.drawable.larus_bg_age_gate_next_button)));
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusRectangleButtonBinding r103 = this.f328483a;
        if (r103 == null) goto L18;
        LinearLayout r104 = r103.f326771b;
        if (r104 == null) goto L19;
        r104.setBackground(getContext().getDrawable(c.b(R.attr.larus_bg_age_gate_next_button_disable, getContext(), R.drawable.larus_bg_age_gate_next_button_disable)));
        return;
    L19:
        return;
    }

    public RectangleButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_rectangle_button, this, false);
        addView(r102);
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.button_text)) == null) goto L7;
        LinearLayout r103 = (LinearLayout) r102;
        this.f328483a = new LarusRectangleButtonBinding(r103, r103);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.button_text)));
    }
}
