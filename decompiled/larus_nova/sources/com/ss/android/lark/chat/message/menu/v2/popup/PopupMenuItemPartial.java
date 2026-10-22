package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuItemPartial;", "Landroid/widget/LinearLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuItemView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "Lkotlin/Lazy;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "setIcon", "", "resId", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "text", "", "setIconTint", "color", "setTextColor", "setBgColor", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuItemPartial extends LinearLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f415821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f415822b;

    public PopupMenuItemPartial(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopupMenuItemPartial(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final ImageView getIconView() {
        return (ImageView) this.f415821a.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.f415822b.getValue();
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setBgColor(int r100) {
        setBackgroundResource(r100);
    }

    public void setIcon(Drawable r100) {
        if (r100 == null) goto L4;
        getIconView().setImageDrawable(r100);
        getIconView().setVisibility(0);
        return;
    L4:
        getIconView().setVisibility(8);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setIconTint(int r100) {
        getIconView().setImageTintList(ColorStateList.valueOf(r100));
    }

    public void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        getTextView().setText(r100);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setTextColor(int r100) {
        getTextView().setTextColor(r100);
    }

    public void setIcon(int r100) {
        getIconView().setImageResource(r100);
        getIconView().setVisibility(0);
    }

    public PopupMenuItemPartial(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415821a = LazyKt.lazy(new PopupMenuItemPartial$iconView$2(r100));
        this.f415822b = LazyKt.lazy(new PopupMenuItemPartial$textView$2(r100));
        setOrientation(1);
        setGravity(1);
        addView(getIconView());
        addView(getTextView());
        setMinimumWidth(UIUtils.dp2px(r100, 60.0f));
        setPadding(0, UIUtils.dp2px(r100, 2.0f), 0, UIUtils.dp2px(r100, 6.0f));
    }

    public /* synthetic */ PopupMenuItemPartial(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
