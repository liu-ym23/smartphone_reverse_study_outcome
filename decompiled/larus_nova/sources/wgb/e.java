package wgb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.flow.chat.databinding.LayoutFlowMessageTipBinding;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f559628b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutFlowMessageTipBinding f559629a;

    public static final class a {
    }

    public final void a() {
        setVisibility(0);
        LayoutFlowMessageTipBinding r100 = this.f559629a;
        LayoutFlowMessageTipBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        r100.f422175c.setVisibility(8);
        LayoutFlowMessageTipBinding r102 = this.f559629a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r101.f422178f.setVisibility(0);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    static {
        f559628b = UIHelper.dp2px(268.0f) - UIHelper.dp2px(92.0f);
    }

    public e(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        View r111 = LayoutInflater.from(getContext()).inflate(R.layout.layout_flow_message_tip, this, false);
        addView(r111);
        int r100 = R.id.arrow_state;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r111, R.id.arrow_state);
        if (r101 == null) goto L21;
        r100 = R.id.back_to_bottom_drawable;
        if (((ImageView) ViewBindings.findChildViewById(r111, R.id.back_to_bottom_drawable)) == null) goto L21;
        r100 = R.id.back_to_bottom_root;
        UDShadowLayout r102 = (UDShadowLayout) ViewBindings.findChildViewById(r111, R.id.back_to_bottom_root);
        if (r102 == null) goto L21;
        r100 = R.id.fl_state_icon;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.fl_state_icon);
        if (r103 == null) goto L21;
        r100 = R.id.loading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(r111, R.id.loading);
        if (r104 == null) goto L21;
        r100 = R.id.new_messages_bg;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r111, R.id.new_messages_bg)) == null) goto L21;
        r100 = R.id.new_messages_root;
        UDShadowLayout r105 = (UDShadowLayout) ViewBindings.findChildViewById(r111, R.id.new_messages_root);
        if (r105 == null) goto L21;
        r100 = R.id.tv_message_tip;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r111, R.id.tv_message_tip);
        if (r106 == null) goto L21;
        this.f559629a = new LayoutFlowMessageTipBinding((LinearLayout) r111, r101, r102, r103, r104, r105, r106);
        r106.setMaxWidth(f559628b);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    public final void setArrowDirection(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = R.drawable.flow_ud_ic_arrow_up;
    L5:
        LayoutFlowMessageTipBinding r102 = this.f559629a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L8:
        r102.f422174b.setImageDrawable(UIUtils.getDrawable(getContext(), r101));
        return;
    L4:
        r101 = R.drawable.flow_ud_ic_arrow_down;
        goto L5
    }

    public final void setLoadingState(boolean r100) {
        LayoutFlowMessageTipBinding r101 = null;
        if (r100 == false) goto L12;
        LayoutFlowMessageTipBinding r102 = this.f559629a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L7:
        r102.f422174b.setVisibility(8);
        LayoutFlowMessageTipBinding r103 = this.f559629a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r101.f422177e.setVisibility(0);
        return;
    L10:
        r101 = r103;
        goto L11
    L12:
        LayoutFlowMessageTipBinding r104 = this.f559629a;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L15:
        r104.f422174b.setVisibility(0);
        LayoutFlowMessageTipBinding r105 = this.f559629a;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r101.f422177e.setVisibility(8);
        return;
    L18:
        r101 = r105;
        goto L19
    }
}
