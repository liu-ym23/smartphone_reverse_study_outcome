package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public class NewMessageTipView extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f417088n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f417089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f417090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f417091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f417092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f417093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f417094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f417095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f417096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f417097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f417098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f417099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f417100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f417101m;

    static {
        f417088n = UIHelper.dp2px(268.0f) - UIHelper.dp2px(92.0f);
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams r100 = super.getLayoutParams();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public NewMessageTipView(Context r100) {
        this(r100, null);
    }

    public void setArrowDirection(boolean r100) {
        this.f417101m = r100;
        ImageView r101 = this.f417090b;
        Context r102 = getContext();
        if (this.f417101m == false) goto L5;
        int r103 = R.drawable.ud_icon_up_top_outlined;
    L6:
        r101.setImageDrawable(UDIconUtils.getIconDrawable(r102, r103, UDColorUtils.getColor(getContext(), R.color.primary_fill_default)));
        return;
    L5:
        r103 = R.drawable.ud_icon_down_bottom_outlined;
        goto L6
    }

    public void setLoadingState(boolean r100) {
        if (r100 == false) goto L5;
        this.f417090b.setVisibility(8);
        this.f417091c.setVisibility(0);
        return;
    L5:
        this.f417090b.setVisibility(0);
        this.f417091c.setVisibility(8);
    }

    public NewMessageTipView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NewMessageTipView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_new_message_tip, this, true);
        UDShadowLayout r103 = (UDShadowLayout) findViewById(R.id.new_messages_root);
        this.f417093e = findViewById(R.id.new_messages_bg);
        TextView r104 = (TextView) findViewById(R.id.text);
        this.f417089a = r104;
        r104.setMaxWidth(f417088n);
        this.f417090b = (ImageView) findViewById(R.id.state);
        this.f417091c = (ProgressBar) findViewById(R.id.loading);
        this.f417092d = (ImageView) findViewById(R.id.image);
        this.f417094f = (ViewGroup) findViewById(R.id.new_messages_content);
        this.f417095g = (FrameLayout) findViewById(R.id.state_container);
        this.f417096h = findViewById(R.id.back_to_bottom_root);
        this.f417097i = (ImageView) findViewById(R.id.back_to_bottom_drawable);
        this.f417098j = findViewById(R.id.my_ai_button_summarize);
        this.f417099k = (ImageView) findViewById(R.id.ic_myai_icon);
        this.f417100l = (TextView) findViewById(R.id.tv_myai_summarize);
        if ((this.f417097i.getDrawable() instanceof LayerDrawable) == false) goto L7;
        Drawable r105 = ((LayerDrawable) this.f417097i.getDrawable()).findDrawableByLayerId(R.id.double_angle);
        if (r105 == null) goto L7;
        r105.setTint(UDColorUtils.getColor(getContext(), R.color.icon_n1));
    L7:
        zz7.a.a(this.f417092d, 20);
        TextView r106 = this.f417089a;
        LarkFont r107 = LarkFont.HEADLINE;
        zz7.a.d(r106, r107);
        zz7.a.d(this.f417100l, r107);
        zz7.a.a(this.f417090b, 12);
        zz7.a.a(this.f417091c, 12);
        zz7.a.a(this.f417099k, 14);
    }
}
