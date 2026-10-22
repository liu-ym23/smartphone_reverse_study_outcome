package com.bytedance.ee.bear.bitable.uikit.simpleitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.Style;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.ui.n;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "setImageView", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchConfigIcon extends FrameLayout implements b<Icon> {
    public AppCompatImageView a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Icon a;
        public final /* synthetic */ gv4.a b;

        public a(Icon r1, gv4.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ActionPayload r3 = this.a.getClickActionPayload();
            if (r3 == null) goto L8;
            gv4.a r0 = this.b;
            if (r0 == null) goto L9;
            r0.a(r3);
            return;
        L9:
            return;
        }
    }

    public final AppCompatImageView getImageView() {
        return this.a;
    }

    public SearchConfigIcon(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setImageView(AppCompatImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public SearchConfigIcon(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(n.d(24), n.d(24)));
        AppCompatImageView r5 = new AppCompatImageView(r3);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(n.d(16), n.d(16));
        r6.gravity = 17;
        r5.setLayoutParams(r6);
        r5.setImageResource(2131253565);
        this.a = r5;
        addView(r5);
    }

    public final void a(Icon r5, gv4.a r6) {
        boolean r0 = false;
        if (r5 == null) goto L14;
        Integer r1 = r5.getStyle();
        int r2 = Style.Select.getValue();
        if (r1 != null) goto L8;
    L10:
        if (r0 == false) goto L12;
        setBackgroundResource(2131232365);
        this.a.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), 2131105576)));
    L13:
        setOnClickListener(new a(r5, r6));
        m.z(this, true);
        return;
    L12:
        setBackground(null);
        this.a.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), 2131102418)));
        goto L13
    L8:
        if (r1.intValue() != r2) goto L10;
        r0 = true;
        goto L10
    L14:
        m.z(this, false);
    }
}
