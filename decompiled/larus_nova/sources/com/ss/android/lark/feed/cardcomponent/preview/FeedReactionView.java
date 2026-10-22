package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedReactionView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "reactionIconSizeDp", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "reactionIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "reactionCountText", "Landroid/widget/TextView;", "reactionIconSize", "reactionXPadding", "reactionNoBackgroundXPadding", "reactionYPadding", "value", "", "isShowBackground", "()Z", "setShowBackground", "(Z)V", "initView", "", "updateBackground", "getReactionIcon", "setReactionCount", "count", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedReactionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f420886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f420887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f420888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f420889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f420890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f420891f;

    public FeedReactionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 0, 14);
    }

    public FeedReactionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 0, 12);
    }

    public FeedReactionView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 0, 8);
    }

    public final void a() {
        if (this.f420891f == false) goto L5;
        int r100 = this.f420888c;
    L6:
        int r101 = this.f420890e;
        setPadding(r100, r101, r100, r101);
        if (this.f420891f == false) goto L9;
        setBackgroundResource(R.drawable.feed_list_reaction_bg_selector);
        return;
    L9:
        setBackground(null);
        return;
    L5:
        r100 = this.f420889d;
        goto L6
    }

    public final AppCompatImageView getReactionIcon() {
        AppCompatImageView r100 = this.f420886a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("reactionIcon");
        return null;
    L6:
        return r100;
    }

    public final void setReactionCount(int r100) {
        TextView r101 = null;
        if (r100 <= 1) goto L12;
        TextView r102 = this.f420887b;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCountText");
        r102 = null;
    L7:
        r102.setVisibility(0);
        TextView r103 = this.f420887b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCountText");
    L11:
        r101.setText(String.valueOf(r100));
        return;
    L10:
        r101 = r103;
        goto L11
    L12:
        TextView r104 = this.f420887b;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCountText");
    L16:
        r101.setVisibility(8);
        return;
    L15:
        r101 = r104;
        goto L16
    }

    public final void setShowBackground(boolean r100) {
        if (this.f420891f != r100) goto L5;
        return;
    L5:
        this.f420891f = r100;
        a();
    }

    public FeedReactionView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = 14;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r105 = zz7.b.g(r100, r103);
        this.f420888c = UIHelper.dp2px(6.0f);
        this.f420889d = UIHelper.dp2px(3.0f);
        this.f420890e = UIHelper.dp2px(2.0f);
        this.f420891f = true;
        AppCompatImageView r106 = new AppCompatImageView(r100);
        r106.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r106.setAdjustViewBounds(true);
        this.f420886a = r106;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, r105);
        r107.gravity = 16;
        Unit r108 = Unit.INSTANCE;
        addView(r106, r107);
        TextView r109 = new TextView(r100);
        r109.setGravity(17);
        zz7.a.c(r109, 10);
        r109.setTextColor(UDColorUtils.getColor(r100, R.color.text_caption));
        this.f420887b = r109;
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, r105);
        r110.gravity = 16;
        r110.leftMargin = UIHelper.dp2px(2.0f);
        addView(r109, r110);
        a();
    }
}
