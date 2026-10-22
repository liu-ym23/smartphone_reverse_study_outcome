package com.ss.android.lark.widget.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public class NavigationTabItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoundFrameLayout f448876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SquircleImageView f448877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f448878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f448879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f448880f;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationTabItemView f448881a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        public a(NavigationTabItemView r100) {
            this.f448881a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            c r101 = this.f448881a.f448880f;
            if (r101 == null) goto L8;
            LKUIBadgeView r102 = r101.f448892a;
            if (r102 == null) goto L9;
            r102.requestLayout();
            return;
        L9:
            return;
        }
    }

    public interface b {
    }

    public void setNavigationRedDotListener(b r100) {
    }

    public void setTabColor(int r100) {
    }

    public Drawable getDefaultDrawable() {
        return this.f448877c.getDrawable();
    }

    public String getTextContent() {
        return this.f448879e.getText().toString();
    }

    public CharSequence getTitle() {
        TextView r100 = this.f448879e;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getText();
    }

    public ImageView getIcon() {
        return this.f448877c;
    }

    public FrameLayout getNavigationContainer() {
        return this.f448876b;
    }

    public <T extends c> T getRedDotView() {
        return (T) this.f448880f;
    }

    public NavigationTabItemView(Context r100) {
        this(r100, null);
    }

    public final void setExternalIconLock(boolean r100) {
        this.f448878d = r100;
    }

    public final void setIconBgColor(int r100) {
        this.f448876b.setBackgroundColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setRedDotView(c r100) {
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 8388661;
        c r102 = this.f448880f;
        if (r102 == null) goto L5;
        removeView(r102.f448892a);
    L5:
        this.f448880f = r100;
        if (r100 == null) goto L8;
        r100.f448892a.setVisibility(8);
    L8:
        this.f448876b.addView(this.f448880f.f448892a, r101);
    }

    public void setRemoteDrawable(d r100) {
        if (r100 == null) goto L10;
        e.a r101 = (e.a) r100;
        this.f448877c.setImageDrawable(r101.a());
        if ((r100 instanceof e) == false) goto L7;
        d r102 = r100;
    L8:
        Log.i("NavigationTabItemView", "setRemoteDrawable() called with: remoteDrawable = [" + r100 + "]");
        Glide.with(this).load(r101.b()).placeholder(r101.a()).error(r101.a()).dontAnimate().into(new com.ss.android.lark.widget.tab.b(this, r102));
        return;
    L7:
        r102 = new e.a(r100);
        goto L8
    }

    public void setTabIcon(Drawable r100) {
        SquircleImageView r101 = this.f448877c;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setImageDrawable(r100);
        return;
    L8:
        return;
    }

    public void setTabTitle(String r100) {
        this.f448879e.setText(r100);
    }

    public void setTitleHorizontalPadding(int r100) {
        TextView r101 = this.f448879e;
        r101.setPadding(r100, r101.getPaddingTop(), r100, this.f448879e.getPaddingBottom());
    }

    public NavigationTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NavigationTabItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448875a = UIUtils.dp2px(r100, 6.0f);
        UIUtils.dp2px(r100, 12.0f);
        int r103 = DesktopUtil.f420394a;
        RoundFrameLayout r104 = new RoundFrameLayout(getContext());
        this.f448876b = r104;
        r104.setId(R.id.layout_container);
        this.f448876b.setRadius(UIUtils.dp2px(r100, 12.0f));
        this.f448876b.setBackgroundColor(ContextCompat.getColor(r100, R.color.bg_navigation_item));
        SquircleImageView r105 = new SquircleImageView(getContext());
        this.f448877c = r105;
        r105.setId(R.id.icon);
        this.f448877c.setRadius(UIUtils.dp2px(r100, 5.0f));
        int r106 = UIUtils.dp2px(r100, 48.0f);
        int r107 = UIUtils.dp2px(r100, 32.0f);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r107, r107, 17);
        r108.gravity = 17;
        this.f448876b.addView(this.f448877c, r108);
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(r106, r106);
        r109.rightToRight = 0;
        r109.leftToLeft = 0;
        r109.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = UIUtils.dp2px(getContext(), 8.0f);
        addView(this.f448876b, r109);
        TextView r110 = new TextView(getContext());
        this.f448879e = r110;
        r110.setId(R.id.textItem);
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(-2, -2);
        r111.rightToRight = 0;
        r111.leftToLeft = 0;
        r111.topToBottom = R.id.layout_container;
        r111.bottomToBottom = 0;
        r111.verticalBias = 0.0f;
        ((ViewGroup.MarginLayoutParams) r111).topMargin = UIUtils.dp2px(getContext(), 4.0f);
        this.f448879e.setGravity(49);
        TextView r112 = this.f448879e;
        int r113 = this.f448875a;
        r112.setPadding(r113, 0, r113, 0);
        this.f448879e.setMaxLines(2);
        this.f448879e.setTextSize(12.0f);
        TextView r114 = this.f448879e;
        r114.setTextColor(ContextCompat.getColor(r114.getContext(), R.color.text_caption));
        this.f448879e.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.f448879e, r111);
        addOnAttachStateChangeListener(new a(this));
    }
}
