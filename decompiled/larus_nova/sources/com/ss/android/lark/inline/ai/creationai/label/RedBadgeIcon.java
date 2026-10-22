package com.ss.android.lark.inline.ai.creationai.label;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J&\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\f\u0010\u001e\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/RedBadgeIcon;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "view", "Landroid/view/View;", "rightIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "rightBadge", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "setRightBadge", "", "isShowBadge", "", "setRightIcon", "res", "", "setIconColor", "colorRes", "setViewPadding", "left", "top", "right", "bottom", "dp", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedBadgeIcon extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f427163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f427164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDBadgeView f427165c;

    public RedBadgeIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RedBadgeIcon(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setIconColor(String r100) {
        Context r101 = getContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = n.i(r101, r100);
        int r103 = ContextCompat.getColor(getContext(), r102);
        this.f427164b.setColorFilter(r103, PorterDuff.Mode.SRC_IN);
    }

    public final void setRightBadge(boolean r100) {
        if (r100 == false) goto L4;
        this.f427165c.setVisibility(0);
        return;
    L4:
        this.f427165c.setVisibility(8);
    }

    public final void setRightIcon(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        this.f427164b.setImageDrawable(null);
        return;
    L11:
        int r102 = n.o(getContext(), r100);
        if (r102 == 0) goto L15;
        this.f427164b.setImageResource(r102);
        return;
    L15:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public RedBadgeIcon(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.layout_red_badge_icon, this, true);
        this.f427163a = findViewById(R.id.item_view);
        this.f427164b = (AppCompatImageView) findViewById(R.id.right_icon_iv);
        this.f427165c = (UDBadgeView) findViewById(R.id.right_badge_view);
    }

    public /* synthetic */ RedBadgeIcon(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
