package com.ss.android.lark.message.lynxcard.message;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.widget.EllipsizeFrameLayout;

/* JADX INFO: loaded from: classes36.dex */
public class LynxCardViewHolder extends RecyclerView.ViewHolder implements LifecycleObserver {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f432166n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f432167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f432168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GradientDrawable f432169c;

    @BindView(9763)
    public LynxCardMessageContentLayout contentLayout;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f432170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f432171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f432172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f432173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f432174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f432175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f432176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v5b.c<LynxCardContentVO> f432177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p f432178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final bz7.a f432179m;

    @BindView(9764)
    public EllipsizeFrameLayout mEllipsizeLayout;

    @BindView(9765)
    public FrameLayout mFoldContainer;

    @BindView(10086)
    public LynxCardRoundLinearLayout mRootLayout;

    @BindView(9767)
    public TextView mShowMoreText;

    @BindView(9766)
    public View mShowMoreView;

    @BindView(9774)
    public ViewStub mTranslateStub;

    public final void U3() {
        this.f432170d = false;
        EllipsizeFrameLayout r100 = this.mEllipsizeLayout;
        if (r100 == null) goto L5;
        r100.setEllipsizeListener(null);
        this.mEllipsizeLayout.setShouldEllipsizeListener(null);
        this.mEllipsizeLayout.setEnableEllipsize(false);
    L5:
        LynxCardRoundLinearLayout r101 = this.mRootLayout;
        if (r101 == null) goto L8;
        r101.setOnCardTapListener(null);
        this.mRootLayout.setOnCardTapObserver(null);
    L8:
        this.f432171e = 0;
        this.f432172f = null;
        View r102 = this.mShowMoreView;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        TextView r103 = this.mShowMoreText;
        if (r103 == null) goto L15;
        r103.setVisibility(8);
        this.mShowMoreText.setOnClickListener(null);
        this.mShowMoreText.setOnLongClickListener(null);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LynxCardMessageContentLayout r100 = this.contentLayout;
        if (r100 == null) goto L5;
        r100.setOnSizeChangeListener(null);
    L5:
        U3();
    }

    public static LynxCardViewHolder V3(View r100) {
        Object r101 = r100.getTag(R.id.lynx_card_cell);
        if ((r101 instanceof LynxCardViewHolder) == true) goto L5;
        return null;
    L5:
        return (LynxCardViewHolder) r101;
    }

    public LynxCardViewHolder(View r100, CardImpl r101) {
        super(r100);
        ButterKnife.bind(this, r100);
        Context r102 = r100.getContext();
        int r103 = r102.getResources().getIdentifier("chat_post_bg_show_more", "drawable", r102.getPackageName());
        if (r103 == 0) goto L5;
        this.mShowMoreText.setBackgroundResource(r103);
    L6:
        this.mShowMoreText.setPadding(UIUtils.dp2px(r102, 15.0f), UIUtils.dp2px(r102, 2.0f), UIUtils.dp2px(r102, 15.0f), UIUtils.dp2px(r102, 6.0f));
        zz7.a.c(this.mShowMoreText, 14);
        this.f432179m = r101;
        return;
    L5:
        TextView r104 = this.mShowMoreText;
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(0);
        r105.setColor(UIUtils.getColor(r102, R.color.bg_body));
        r105.setCornerRadius(UIUtils.dp2px(r102, 50.0f));
        r104.setBackground(r105);
        goto L6
    }

    public final void T3(Context r100, boolean r101) {
        if (r101 == true) goto L4;
        View r102 = this.f432173g;
        if (r102 == null) goto L14;
        r102.setVisibility(8);
        UIUtils.hide(this.f432174h);
        UIUtils.hide(this.f432175i);
        return;
    L14:
        return;
    L4:
        if (this.f432173g != null) goto L8;
        View r103 = dwa.j.d(r100).f(this.mTranslateStub);
        this.f432173g = r103;
        this.f432174h = (TextView) r103.findViewById(R.id.lynx_card_translate_feedback_tv);
        this.f432175i = (AppCompatImageView) this.f432173g.findViewById(R.id.lynx_card_translate_more_action);
        TextView r104 = this.f432174h;
        if (r104 == null) goto L8;
        zz7.a.c(r104, 12);
    L8:
        this.f432173g.setVisibility(0);
        UIUtils.show(this.f432174h);
        UIUtils.show(this.f432175i);
    }
}
