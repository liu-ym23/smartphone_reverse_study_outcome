package com.ss.android.lark.translate.cell_ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/translate/cell_ui/TranslationAnimationView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animView", "Landroid/view/View;", "animInnerView", "iconView", "Landroid/widget/ImageView;", "isAnimating", "", "playAnimation", "", "cancelAnimation", "setAnimViewVisibility", RemoteMessageConst.Notification.VISIBILITY, "", "setIconViewVisibility", "showOriginIcon", "showPreviewIcon", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslationAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f444300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f444301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f444302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f444303d;

    public final void a() {
        if (this.f444303d == true) goto L5;
        return;
    L5:
        this.f444300a.clearAnimation();
        Unit r100 = Unit.INSTANCE;
        this.f444303d = false;
    }

    public TranslationAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAnimViewVisibility(int r100) {
        this.f444300a.setVisibility(r100);
        this.f444301b.setVisibility(r100);
    }

    public final void setIconViewVisibility(int r100) {
        this.f444302c.setVisibility(r100);
    }

    public final void setImageDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f444302c.setImageDrawable(r100);
        Unit r101 = Unit.INSTANCE;
        setIconViewVisibility(0);
        setAnimViewVisibility(8);
        a();
    }

    public TranslationAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = new View(getContext());
        this.f444300a = r102;
        View r103 = new View(getContext());
        this.f444301b = r103;
        ImageView r104 = new ImageView(getContext());
        this.f444302c = r104;
        r102.setBackground(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_translate_circle_outlined, ResourcesCompat.getColor(getContext().getResources(), R.color.ud_B600, null)));
        addView(r102);
        r103.setBackground(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_translate_inside_outlined, ResourcesCompat.getColor(getContext().getResources(), R.color.ud_B600, null)));
        addView(r103);
        addView(r104);
    }
}
