package com.larus.uaigc.template;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.larus.uaigc.impl.databinding.LarusButtonSameTemplateBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/uaigc/template/SameTemplateButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusButtonSameTemplateBinding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusButtonSameTemplateBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SameTemplateButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusButtonSameTemplateBinding f374189a;

    public final LarusButtonSameTemplateBinding getBinding() {
        return this.f374189a;
    }

    public SameTemplateButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public SameTemplateButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_button_same_template, this, false);
        addView(r102);
        int r103 = R.id.discovery_text;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.discovery_text)) == null) goto L10;
        LinearLayout r104 = (LinearLayout) r102;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.image)) == null) goto L8;
        this.f374189a = new LarusButtonSameTemplateBinding(r104);
        return;
    L8:
        r103 = R.id.image;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
