package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusButtonBotCreateBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\f\u0010\u001b\u001a\u00020\r*\u00020\u0017H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/CreateBotButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusButtonBotCreateBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusButtonBotCreateBinding;", "setButtonText", "", "text", "", "setLeftImage", "resId", "", "setLeftImageSize", "size", "zoomOutAnimation", "view", "Landroid/view/View;", "scaleSize", "", "zoomInAnimation", "bounceWhenPressedItem", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateBotButton extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f315535b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusButtonBotCreateBinding f315536a;

    public final LarusButtonBotCreateBinding getBinding() {
        return this.f315536a;
    }

    public CreateBotButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f315536a.f326612b.setText(r100);
    }

    public final void setLeftImage(int r100) {
        this.f315536a.f326613c.setImageResource(r100);
    }

    public final void setLeftImageSize(int r100) {
        this.f315536a.f326613c.setLayoutParams(new LinearLayout.LayoutParams(r100, r100));
    }

    public CreateBotButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_button_bot_create, this, false);
        addView(r102);
        int r103 = R.id.button_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.button_text);
        if (r104 == null) goto L9;
        r103 = R.id.image;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.image);
        if (r105 == null) goto L9;
        LarusButtonBotCreateBinding r106 = new LarusButtonBotCreateBinding((LinearLayout) r102, r104, r105);
        setOnTouchListener(new x1(this, this));
        this.f315536a = r106;
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
