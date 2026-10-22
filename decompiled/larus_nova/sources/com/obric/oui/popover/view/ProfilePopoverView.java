package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/popover/view/ProfilePopoverView;", "Lcom/obric/oui/popover/view/LinkPopoverView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setAvatarClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setLeftIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProfilePopoverView extends LinkPopoverView {
    public ProfilePopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAvatarClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getIvIcon().setOnClickListener(r100);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(int r100) {
        setPadding(d.n(this, 12), d.n(this, 9), d.n(this, 12), d.n(this, 9));
        super.setLeftIcon(r100);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(Drawable r100) {
        setPadding(d.n(this, 12), d.n(this, 9), d.n(this, 12), d.n(this, 9));
        super.setLeftIcon(r100);
    }

    public ProfilePopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ImageView r102 = getIvIcon();
        ViewGroup.LayoutParams r103 = getIvIcon().getLayoutParams();
        if (r103 == null) goto L7;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r104.height = d.n(this, 24);
        r104.width = d.n(this, 24);
        r104.setMarginEnd(d.n(this, 4));
        r102.setLayoutParams(r104);
        getIvIcon().setImageTintList(null);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
