package com.bytedance.ee.bear.bitable.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/CatalogView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tableName", "Landroid/widget/TextView;", "viewName", "iconView", "Landroid/widget/ImageView;", "divider", "Landroid/view/View;", "catalogDivider", "catalogWrapper", "badgeView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "contentWidth", "", "setCatalog", "", "model", "Lcom/bytedance/ee/bear/bitable/titlebar/BitableCatalogModel;", "setCatalogClickListener", "listener", "Landroid/view/View$OnClickListener;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setWeightAtViewName", "setWeightAtTableName", "setTableNameViewVisible", "visible", "", "setWeight", "weight", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogView extends FrameLayout {
    public static final int i = 0;
    public static final int j = 0;
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final View d;
    public final View e;
    public final View f;
    public final UDBadgeView g;
    public float h;

    public static final class a {
    }

    public CatalogView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CatalogView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        i = d.a(50);
        j = d.a(99);
    }

    private final void setTableNameViewVisible(boolean r5) {
        TextView r0 = this.a;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        View r2 = this.d;
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setCatalog(BitableCatalogModel r8) {
        Intrinsics.checkNotNullParameter(r8, "model");
        if (r8.isValid() == true) goto L5;
        return;
    L5:
        int r1 = 8;
        if (TextUtils.isEmpty(r8.getTableName()) == false) goto L8;
    L17:
        this.g.setVisibility(8);
        setTableNameViewVisible(false);
        if (TextUtils.isEmpty(r8.getTableName()) == false) goto L20;
        String r0 = r8.getViewName();
    L21:
        this.b.setText(r0);
        a(this.b, 1);
        this.a.setMaxWidth(i);
        a(this.a, 0);
    L23:
        if (TextUtils.isEmpty(r8.getIconUrl()) == true) goto L25;
        RequestBuilder r2 = Glide.with(getContext()).load(r8.getIconUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(n.d(2))));
        EPanelItemIcon r4 = EPanelItemIcon.UNKNOWN;
        r2.placeholder(r4.inactiveImageRes).error(r4.inactiveImageRes).into(this.c);
        int r3 = d.a(1);
        this.c.setPadding(r3, r3, r3, r3);
        this.c.setImageTintList(null);
    L26:
        View r5 = this.e;
        if (r8.showDivider() == false) goto L29;
        r1 = 0;
    L29:
        r5.setVisibility(r1);
        return;
    L25:
        this.c.setImageResource(r8.getIcon(getContext()));
        this.c.setPadding(0, 0, 0, 0);
        this.c.setImageTintList(getResources().getColorStateList(2131102418));
        goto L26
    L20:
        r0 = r8.getTableName();
        goto L21
    L8:
        if (TextUtils.isEmpty(r8.getViewName()) == true) goto L17;
        setTableNameViewVisible(true);
        this.a.setText(r8.getTableName());
        this.b.setText(r8.getViewName());
        UDBadgeView r6 = this.g;
        if (r8.getNeedShowBadge() == false) goto L12;
        int r7 = 0;
    L13:
        r6.setVisibility(r7);
        float r9 = this.b.getPaint().measureText(r8.getViewName());
        float r10 = this.h;
        int r11 = i;
        if (((r10 - r11) - j) > r9) goto L16;
        a(this.b, 1);
        this.a.setMaxWidth(r11);
        a(this.a, 0);
        goto L23
    L16:
        a(this.a, 1);
        this.a.setMaxWidth(SmallLoadingPlugin.DURATION_MAX);
        a(this.b, 0);
        goto L23
    L12:
        r7 = 8;
        goto L13
    }

    public final void setCatalogClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.setOnClickListener(r2);
    }

    public static void a(TextView r2, int r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
        r1.weight = r3;
        r2.setLayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.h = getMeasuredWidth() * 0.8f;
    }

    public CatalogView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        int r6 = com.larksuite.framework.utils.autoscale.a.a;
        Resources r7 = Resources.getSystem();
        this.h = (float) (((double) WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).widthPixels) * 0.8d);
        View r8 = LayoutInflater.from(r3).inflate(2131558897, this);
        this.a = (TextView) r8.findViewById(2131388080);
        this.b = (TextView) r8.findViewById(2131392559);
        this.c = (ImageView) r8.findViewById(2131392520);
        this.d = r8.findViewById(2131369197);
        this.g = r8.findViewById(2131363831);
        this.f = r8.findViewById(2131365283);
        this.e = r8.findViewById(2131365278);
    }

    public /* synthetic */ CatalogView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
