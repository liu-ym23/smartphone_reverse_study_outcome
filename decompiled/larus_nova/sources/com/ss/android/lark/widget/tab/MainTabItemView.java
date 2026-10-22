package com.ss.android.lark.widget.tab;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.dynamicresources.DynamicResourcesManager;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class MainTabItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f448862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f448863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f448864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f448865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f448866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SquircleImageView f448867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f448868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f448869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f448870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f448871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f448872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f448873l;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.tab.MainTabItemView$2, reason: invalid class name */
    class AnonymousClass2 implements IGetDataCallback<Map<String, com.ss.android.lark.widget.tab.a>> {
        final /* synthetic */ MainTabItemView this$0;
        final /* synthetic */ boolean val$clearColor;
        final /* synthetic */ d val$finalDefaultRemoteDrawable;
        final /* synthetic */ d val$finalSelectedRemoteDrawable;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            this.this$0.f448862a = false;
            Log.w("MainTabItemView", this.this$0.getClass().getName() + " setRemoteDrawable() failed defaultRemoteDrawable = [" + this.val$finalDefaultRemoteDrawable + "], selectedRemoteDrawable = [" + this.val$finalSelectedRemoteDrawable + "]", r100.getException());
        }

        public void onSuccess(Map<String, com.ss.android.lark.widget.tab.a> r100) {
            if (this.this$0.f448863b == false) goto L6;
            Log.i("MainTabItemView", "setRemoteDrawable skipped, title=" + this.this$0.f448873l);
            return;
        L6:
            if (r100 != null) goto L8;
            return;
        L8:
            r100.get(((e.a) this.val$finalDefaultRemoteDrawable).b()).getClass();
            r100.get(((e.a) this.val$finalSelectedRemoteDrawable).b()).getClass();
            Log.w("MainTabItemView", this.this$0.getClass().getName().concat(" setRemoteDrawable() success, one or more drawable is null. defaultRemoteDrawable = [null], selectedRemoteDrawable = [null]"));
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((Map) r100);
        }

        public AnonymousClass2(MainTabItemView r100, d r101, d r102, boolean r103) {
            this.this$0 = r100;
            this.val$finalDefaultRemoteDrawable = r101;
            this.val$finalSelectedRemoteDrawable = r102;
            this.val$clearColor = r103;
        }
    }

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainTabItemView f448874a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        public a(MainTabItemView r100) {
            this.f448874a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            c r101 = this.f448874a.f448871j;
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
        Drawable getDrawable();
    }

    public boolean getStatus() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptHoverEvent(MotionEvent r100) {
        return true;
    }

    public final void setDisableLocalIconTintByStrategy(boolean r100) {
    }

    public static void R5() {
        if (DynamicResourcesManager.f283993a == null) goto L5;
    L14:
        DynamicResourcesManager.f283993a.getClass();
        return;
    L5:
        monitor-enter(DynamicResourcesManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (DynamicResourcesManager.f283993a != null) goto L9;
        DynamicResourcesManager.f283993a = new DynamicResourcesManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DynamicResourcesManager.class);     // Catch: Throwable -> L11
        goto L14
    }

    public int getIconTop() {
        return this.f448864c.getTop();
    }

    public Animation getTabAnimation() {
        ScaleAnimation r100 = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        r100.setDuration(125);
        r100.setInterpolator(new AccelerateInterpolator());
        r100.setRepeatCount(1);
        r100.setRepeatMode(2);
        return r100;
    }

    public Boolean T5() {
        return Boolean.FALSE;
    }

    public final int getCurrentIconSizeDp() {
        return this.f448865d;
    }

    public Drawable getDrawableDefault() {
        return this.f448869h;
    }

    public ImageView getIcon() {
        return this.f448867f;
    }

    public FrameLayout getIconContainer() {
        return this.f448864c;
    }

    public <T extends c> T getRedDotView() {
        return (T) this.f448871j;
    }

    public final boolean getRemoteDrawableTintEnabled() {
        return this.f448866e;
    }

    public MainTabItemView(Context r100) {
        this(r100, null);
    }

    private void setIconImageDrawable(Drawable r100) {
        if (r100 == null) goto L8;
        SquircleImageView r101 = this.f448867f;
        if (r101 == null) goto L9;
        r101.setImageDrawable(r100);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r100) {
        super.onHoverChanged(r100);
        DesktopUtil.a(getContext());
    }

    public final void setExternalIconLock(boolean r100) {
        this.f448863b = r100;
    }

    public void setIconSelectStatus(boolean r100) {
        super.setSelected(r100);
        if (r100 == true) goto L5;
        setIconImageDrawable(this.f448869h);
        TextView r101 = this.f448868g;
        if (r101 == null) goto L25;
        r101.setTextColor(getContext().getResources().getColor(R.color.text_caption));
        return;
    L25:
        return;
    L5:
        if (this.f448870i != null) goto L9;
        b r102 = this.f448872k;
        if (r102 == null) goto L9;
        this.f448870i = r102.getDrawable();
    L9:
        R5();
        R5();
        if (this.f448862a == false) goto L16;
        SquircleImageView r103 = this.f448867f;
        if (r103 == null) goto L16;
        if (this.f448866e == true) goto L16;
        r103.setImageTintList(getContext().getResources().getColorStateList(R.color.fill_img_mask));
        r103.setImageTintMode(PorterDuff.Mode.SRC_ATOP);
    L16:
        setIconImageDrawable(this.f448870i);
        if (this.f448868g == null) goto L23;
        R5();
        this.f448868g.setTextColor(getContext().getResources().getColor(R.color.primary_fill_default));
        return;
    }

    public void setRedDotView(c r100) {
        c r101 = this.f448871j;
        if (r101 == null) goto L5;
        removeView(r101.f448892a);
    L5:
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-2, -2);
        r102.topToTop = R.id.layout_container;
        r102.endToEnd = R.id.layout_container;
        this.f448871j = r100;
        if (r100 == null) goto L8;
        r100.f448892a.setVisibility(8);
    L8:
        addView(this.f448871j.f448892a, r102);
    }

    public final void setRemoteDrawableTintEnabled(boolean r100) {
        this.f448866e = r100;
    }

    public void setTabTitle(String r100) {
        this.f448873l = r100;
        TextView r101 = this.f448868g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public MainTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void S5(Drawable r100, b r101) {
        if (this.f448867f != null) goto L5;
        return;
    L5:
        this.f448869h = r100;
        this.f448872k = r101;
        setIconImageDrawable(r100);
        R5();
        if (this.f448862a == true) goto L8;
        return;
    L8:
        if (this.f448866e == false) goto L12;
        this.f448867f.setImageTintList(getContext().getResources().getColorStateList(R.color.mine_tab_icon_color));
        this.f448867f.setImageTintMode(PorterDuff.Mode.SRC_IN);
        return;
    }

    public MainTabItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448865d = 22;
        Context r103 = getContext();
        TextView r104 = new TextView(getContext());
        this.f448868g = r104;
        r104.setId(R.id.textItem);
        int r105 = UIUtils.dp2px(getContext(), 1.0f);
        this.f448868g.setPadding(r105, 0, r105, 0);
        this.f448868g.setGravity(17);
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(-2, -2);
        r106.rightToRight = 0;
        r106.leftToLeft = 0;
        r106.topToBottom = R.id.layout_container;
        if (T5().booleanValue() == false) goto L5;
        r106.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = UIUtils.dp2px(getContext(), 4.0f);
    L6:
        this.f448868g.setLayoutParams(r106);
        DesktopUtil.a(r103);
        this.f448868g.setTextSize(12.0f);
        this.f448868g.setTextColor(getContext().getResources().getColor(R.color.text_caption));
        this.f448868g.setSingleLine(true);
        this.f448868g.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.f448868g);
        Context r107 = getContext();
        FrameLayout r108 = new FrameLayout(r107);
        this.f448864c = r108;
        r108.setId(R.id.layout_container);
        int r109 = UIUtils.dp2px(getContext(), 38);
        int r110 = UIUtils.dp2px(getContext(), 30);
        if (T5().booleanValue() == false) goto L9;
        r110 = UIUtils.dp2px(getContext(), 22);
    L9:
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(r109, r110);
        r111.rightToRight = 0;
        r111.leftToLeft = 0;
        r111.topToTop = 0;
        if (T5().booleanValue() == false) goto L12;
        r111.bottomToTop = R.id.textItem;
        r111.verticalChainStyle = 2;
    L13:
        this.f448864c.setLayoutParams(r111);
        addView(this.f448864c);
        SquircleImageView r112 = new SquircleImageView(r107);
        this.f448867f = r112;
        r112.setId(R.id.icon);
        this.f448867f.setRadius(UIUtils.dp2px(r107, 5.0f));
        SquircleImageView r113 = this.f448867f;
        int r114 = UIUtils.dp2px(getContext(), 22);
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(r114, r114);
        r115.gravity = 81;
        r113.setLayoutParams(r115);
        this.f448864c.addView(this.f448867f);
        DesktopUtil.a(getContext());
        addOnAttachStateChangeListener(new a(this));
        return;
    L12:
        ((ViewGroup.MarginLayoutParams) r111).topMargin = (int) j08.b.a(getContext(), 9.0f);
        goto L13
    L5:
        ((ViewGroup.MarginLayoutParams) r106).topMargin = UIUtils.dp2px(getContext(), 5.0f);
        goto L6
    }
}
