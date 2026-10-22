package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.IconTextUIKit;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.SimpleTextModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<SimpleTextModel> {
    public final Boolean e;
    public IconTextUIKit f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SimpleTextModel a;

        public a(SimpleTextModel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = this.a.getTextUrl();
            if (r4 == null) goto L6;
            ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(com.bytedance.ee.bear.bitable.utils.h.a(r4));
            return;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.SIMPLETEXT.getValue();
    }

    public /* synthetic */ u(iv4.b r2) {
        this(r2, Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<SimpleTextModel> r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        IconTextUIKit r2 = this.f;
        if (r2 == null) goto L15;
        h(r2, (SimpleTextModel) ListProtector.get(r3, 0));
        return;
    L15:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public u(iv4.b r1, Boolean r2) {
        super(r1);
        this.e = r2;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = c(r2, r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.IconTextUIKit");
        this.f = (IconTextUIKit) r4;
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r3 = ht4.b.a;
        getType();
        return new IconTextUIKit(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (SimpleTextModel) r2);
    }

    public final void h(View r7, SimpleTextModel r8) {
        Intrinsics.checkNotNullParameter(r7, "kitView");
        Intrinsics.checkNotNullParameter(r8, "model");
        if ((r7 instanceof IconTextUIKit) == false) goto L26;
        IconTextUIKit r0 = (IconTextUIKit) r7;
        a(r0.getContentTv(), false);
        r0.setContent(r8.getText());
        String r1 = r8.getTextColor();
        if (r1 == null) goto L7;
        r0.setContentColor(ColorUtils.h(r1));
    L7:
        Icon r2 = r8.getLeftIcon();
        if (r2 == null) goto L10;
        r0.setLeftIconVisible(true);
        r0.setLeftIcon(r2);
    L11:
        Icon r3 = r8.getRightIcon();
        if (r3 == null) goto L14;
        r0.setRightIconVisible(true);
        r0.setRightIcon(r3);
    L15:
        String r4 = r8.getBackgroundColor();
        if (r4 == null) goto L18;
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(com.bytedance.ee.util.ui.n.d(6));
        r5.setColor(ColorProtector.parseColor(r4));
        r7.setBackground(r5);
        r7.setPadding(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(4));
    L20:
        if (Intrinsics.areEqual(this.e, Boolean.TRUE) == true) goto L22;
    L24:
        r7.setOnClickListener(null);
        r7.setClickable(false);
        return;
    L22:
        if (TextUtils.isEmpty(r8.getTextUrl()) == true) goto L24;
        r7.setOnClickListener(new a(r8));
        return;
    L18:
        r7.setBackground(null);
        r7.setPadding(0, 0, 0, 0);
        goto L20
    L14:
        r0.setRightIconVisible(false);
        goto L15
    L10:
        r0.setLeftIconVisible(false);
        goto L11
    }
}
