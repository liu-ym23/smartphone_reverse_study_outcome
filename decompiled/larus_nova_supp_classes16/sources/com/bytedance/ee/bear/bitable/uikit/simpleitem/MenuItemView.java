package com.bytedance.ee.bear.bitable.uikit.simpleitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/MenuItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getMenuIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMenuIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "menuTextFromXml", "Landroid/widget/TextView;", "getMenuTextFromXml", "()Landroid/widget/TextView;", "setMenuTextFromXml", "(Landroid/widget/TextView;)V", "originImageTintList", "Landroid/content/res/ColorStateList;", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuItemView extends FrameLayout {
    public AppCompatImageView a;
    public TextView b;

    public MenuItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MenuItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final AppCompatImageView getMenuIconFromXml() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379912);
        this.a = r0;
    L6:
        return r0;
    }

    public final TextView getMenuTextFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379929);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final void setMenuIconFromXml(AppCompatImageView r1) {
        this.a = r1;
    }

    public final void setMenuTextFromXml(TextView r1) {
        this.b = r1;
    }

    public MenuItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131559149, this, true);
        setBackgroundResource(2131232371);
        AppCompatImageView r5 = getMenuIconFromXml();
        if (r5 == null) goto L6;
        r5.getImageTintList();
        return;
    }

    public /* synthetic */ MenuItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
