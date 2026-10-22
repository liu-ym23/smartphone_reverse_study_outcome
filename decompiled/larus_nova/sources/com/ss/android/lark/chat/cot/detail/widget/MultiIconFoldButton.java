package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\f\u0010\u0016\u001a\u00020\u0007*\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/widget/MultiIconFoldButton;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconContainer", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "setText", "", "text", "", "setIcons", "icons", "", "Lcom/ss/android/lark/chat/cot/detail/widget/FoldIconConfig;", "dp", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiIconFoldButton extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f415039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f415040b;

    public static final class a {
    }

    static {
    }

    public MultiIconFoldButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MultiIconFoldButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setIcons(List<c> r110) {
        Intrinsics.checkNotNullParameter(r110, "icons");
        this.f415039a.removeAllViews();
        if (r110.isEmpty() == false) goto L6;
        this.f415039a.setVisibility(8);
        return;
    L6:
        this.f415039a.setVisibility(0);
        Iterator r100 = CollectionsKt.take(r110, 3).iterator();
        int r101 = 0;
    L7:
        boolean r102 = true;
        if (r100.hasNext() == false) goto L37;
        Object r103 = r100.next();
        int r104 = r101 + 1;
        if (r101 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        c r105 = (c) r103;
        FrameLayout r106 = this.f415039a;
        Integer r111 = null;
        FoldCircleImageView r112 = new FoldCircleImageView(getContext(), null);
        if (r110.size() == 1) goto L15;
        boolean r113 = true;
    L16:
        r112.f415038h = r113;
        int r114 = r105.f415053b;
        r112.setPadding(r114, r114, r114, r114);
        Integer r115 = r105.f415055d;
        if (r115 == null) goto L19;
        int r116 = r115.intValue();
    L20:
        r112.f415036f = r116;
        r112.f415037g = UIUtils.getColor(r112.getContext(), r112.f415036f);
        Drawable r117 = UIUtils.getDrawable(r112.getContext(), r105.f415052a);
        if (r117 == null) goto L23;
        Drawable r118 = r117.mutate();
    L24:
        Integer r107 = r105.f415054c;
        if (r107 == null) goto L36;
        if (r107.intValue() > 0) goto L30;
        r102 = false;
    L30:
        if (r102 == false) goto L32;
        r111 = r107;
    L32:
        if (r111 == null) goto L36;
        int r108 = r111.intValue();
        if (r118 == null) goto L36;
        r118.setColorFilter(UIUtils.getColor(r112.getContext(), r108), PorterDuff.Mode.SRC_IN);
    L36:
        r112.setImageDrawable(r118);
        r112.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(UIUtils.dp2px(getContext(), 14.0f), UIUtils.dp2px(getContext(), 14.0f));
        r109.leftMargin = r101 * UIUtils.dp2px(getContext(), 12.0f);
        r109.gravity = 16;
        Unit r119 = Unit.INSTANCE;
        r106.addView(r112, r109);
        r101 = r104;
        goto L7
    L23:
        r118 = null;
        goto L24
    L19:
        r116 = R.color.bg_body_overlay;
        goto L20
    L15:
        r113 = false;
        goto L16
    L37:
        FrameLayout r120 = this.f415039a;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        r121.width = UIUtils.dp2px(getContext(), 14.0f) + ((Math.min(r110.size(), 3) - 1) * UIUtils.dp2px(getContext(), 12.0f));
        r120.setLayoutParams(r121);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f415040b.setText(r100);
    }

    public MultiIconFoldButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout r103 = new FrameLayout(r100);
        this.f415039a = r103;
        TextView r104 = new TextView(r100);
        this.f415040b = r104;
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(UIUtils.dp2px(r100, 26.0f));
        setPadding(UIUtils.dp2px(r100, 8.0f), 0, UIUtils.dp2px(r100, 8.0f), 0);
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(0);
        r105.setCornerRadius(UIUtils.dp2px(r100, 100.0f));
        r105.setColor(UIUtils.getColor(r100, R.color.bg_body_overlay));
        setBackground(r105);
        r103.setVisibility(8);
        addView(r103, new LinearLayout.LayoutParams(-2, UIUtils.dp2px(r100, 14.0f)));
        r104.setGravity(16);
        r104.setMinHeight(UIUtils.dp2px(r100, 20.0f));
        r104.setTextSize(12.0f);
        r104.setMaxLines(1);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.setTextColor(UIUtils.getColor(r100, R.color.text_caption));
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.setMarginStart(UIUtils.dp2px(r100, 4.0f));
        Unit r107 = Unit.INSTANCE;
        addView(r104, r106);
    }

    public /* synthetic */ MultiIconFoldButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
