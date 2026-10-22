package com.obric.oui.popover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.popover.PopoverLinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/popover/view/GuidePopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "", "charSequence", "", "setStatusText", "setGuideText", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTvStatus", "()Landroid/widget/TextView;", "tvStatus", "b", "getTvGuide", "tvGuide", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class GuidePopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f402453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f402454b;

    public final TextView getTvGuide() {
        return this.f402454b;
    }

    public final TextView getTvStatus() {
        return this.f402453a;
    }

    public GuidePopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setGuideText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f402454b.setText(r100);
    }

    public final void setStatusText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f402453a.setText(r100);
    }

    public GuidePopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout.inflate(r100, R.layout.o_popover_guide_view, this);
        setOrientation(0);
        int r102 = d.n(this, 12);
        setPadding(r102, r102, r102, r102);
        setBackground(ContextCompat.getDrawable(r100, R.drawable.o_popover_view_bg));
        this.f402453a = (TextView) findViewById(R.id.tv_status_text);
        this.f402454b = (TextView) findViewById(R.id.tv_guide_text);
    }
}
