package com.bytedance.ee.bear.bitable.uikit.simpleitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/MenuItemView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getMenuIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMenuIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "menuTextFromXml", "Landroid/widget/TextView;", "getMenuTextFromXml", "()Landroid/widget/TextView;", "setMenuTextFromXml", "(Landroid/widget/TextView;)V", "originImageTintList", "Landroid/content/res/ColorStateList;", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f216223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f216224b;

    public MenuItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MenuItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final AppCompatImageView getMenuIconFromXml() {
        KeyEvent.Callback r100 = this.f216223a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.menu_icon);
        this.f216223a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getMenuTextFromXml() {
        KeyEvent.Callback r100 = this.f216224b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.menu_text);
        this.f216224b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final void setMenuIconFromXml(AppCompatImageView r100) {
        this.f216223a = r100;
    }

    public final void setMenuTextFromXml(TextView r100) {
        this.f216224b = r100;
    }

    public MenuItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.bitable_simple_menu_item_layout, this, true);
        setBackgroundResource(R.drawable.bitable_simple_menu_item_bg);
        AppCompatImageView r103 = getMenuIconFromXml();
        if (r103 == null) goto L6;
        r103.getImageTintList();
        return;
    }

    public /* synthetic */ MenuItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
