package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\f\u0010\u0012\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/MenuIcon;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "setIcon", "", "iconRes", "", "setIconColor", "colorRes", "dp", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuIcon extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f427190a;

    public static final class a {
    }

    static {
    }

    public MenuIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MenuIcon(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final void setIcon(String r100) {
        Context r101 = getContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = n.n(r101, r100);
        this.f427190a.setImageResource(r102);
    }

    public final void setIconColor(String r100) {
        Context r101 = getContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = n.i(r101, r100);
        int r103 = ContextCompat.getColor(getContext(), r102);
        this.f427190a.setColorFilter(r103, PorterDuff.Mode.SRC_IN);
    }

    public MenuIcon(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AppCompatImageView r103 = new AppCompatImageView(r100);
        r103.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r103.setAdjustViewBounds(true);
        r103.setPadding(a(2), a(2), a(2), a(2));
        this.f427190a = r103;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(a(20) + (a(2) * 2), a(20) + (a(2) * 2));
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public /* synthetic */ MenuIcon(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
