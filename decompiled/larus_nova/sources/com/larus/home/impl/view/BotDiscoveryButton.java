package com.larus.home.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.home.impl.databinding.LarusButtonBotDiscoveryBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/larus/home/impl/view/BotDiscoveryButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/home/impl/databinding/LarusButtonBotDiscoveryBinding;", "getBinding", "()Lcom/larus/home/impl/databinding/LarusButtonBotDiscoveryBinding;", "setButtonText", "", "text", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoveryButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusButtonBotDiscoveryBinding f346355a;

    public final LarusButtonBotDiscoveryBinding getBinding() {
        return this.f346355a;
    }

    public BotDiscoveryButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f346355a.f344237b.setText(r100);
    }

    public BotDiscoveryButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_button_bot_discovery, this, false);
        addView(r102);
        int r103 = R.id.button_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.button_text);
        if (r104 == null) goto L9;
        r103 = R.id.image;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.image)) == null) goto L9;
        this.f346355a = new LarusButtonBotDiscoveryBinding((LinearLayout) r102, r104);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
