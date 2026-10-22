package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.utils.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends FrameLayout implements g {
    public l a;
    public SlcTemplateViewHelper b;
    public SlcContext c;
    public boolean d;
    public com.bytedance.android.ecom.arch.slice.g e;
    public final Map<String, a> f;
    public boolean g;

    public static final class a {
        public final View a;

        public a(View r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public final c asView() {
        return this;
    }

    public final void c() {
        if (this.d == false) goto L5;
        return;
    L5:
        SlcTemplateViewHelper r0 = this.b;
        if (r0 != null) goto L8;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L18;
        this.d = true;
        l r2 = this.a;
        if (r2 == null) goto L19;
        r2.b1();
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r0.d != true) goto L12;
        if (getChildCount() == 0) goto L12;
        r1 = true;
        goto L13
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public final View a(String r4) {
        View r0 = null;
        if (r4 == null) goto L22;
        SlcTemplateViewHelper r1 = this.b;
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.d != true) goto L11;
        if (getChildCount() == 0) goto L11;
    L12:
        if (r2 == false) goto L22;
        a r3 = (a) ((LinkedHashMap) this.f).get(r4);
        if (r3 != null) goto L21;
        SlcTemplateViewHelper r5 = this.b;
        if (r5 == null) goto L19;
        r0 = r5.d(r4);
    L19:
        r3 = new a(r0);
        this.f.put(r4, r3);
    L21:
        return r3.a;
    L11:
        r2 = false;
    L22:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (this.g == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public void setDisableTouchEvent(boolean r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public void setOnViewReadyCallback(l r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public final boolean b(com.bytedance.android.ecom.arch.slice.g r4, Map<String, ? extends Object> r5, String r6) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (this.b == null) goto L11;
        com.bytedance.android.ecom.arch.slice.g r0 = this.e;
        if (r0 == null) goto L11;
        int r2 = y.a;
        if (y.h(r0, r4) != true) goto L11;
    L18:
        this.e = r4;
        SlcTemplateViewHelper r1 = this.b;
        if (r1 == null) goto L22;
        r1.b(r4, r5, r6);
    L22:
        if (getChildCount() != 0) goto L29;
        SlcTemplateViewHelper r7 = this.b;
        if (r7 == null) goto L28;
        View r8 = SlcTemplateViewHelper.e(r7);
        if (r8 == null) goto L28;
        addView(r8, new FrameLayout.LayoutParams(-1, -2));
    L28:
        c();
    L29:
        return true;
    L11:
        SlcTemplateViewHelper r3 = new SlcTemplateViewHelper(new d(this));
        SlcContext r9 = this.c;
        if (r9 == null) goto L15;
        r3.f(r9);
    L15:
        if (this.b == null) goto L17;
        removeAllViews();
        ((LinkedHashMap) this.f).clear();
    L17:
        this.b = r3;
        goto L18
    }
}
