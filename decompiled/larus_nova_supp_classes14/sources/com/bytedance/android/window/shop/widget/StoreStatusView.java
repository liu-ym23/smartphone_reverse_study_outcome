package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/widget/StoreStatusView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/j;", "", "status", "", "setECStatus", "", "Landroid/view/View;", "a", "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "statusViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StoreStatusView extends FrameLayout implements com.bytedance.android.ec.core.widget.j {
    public final Map<Integer, View> a;
    public final Map<Integer, Function0<View>> b;
    public int c;

    public static final class a {
    }

    static {
    }

    public StoreStatusView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StoreStatusView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void showLoading() {
        setVisibility(0);
        setECStatus(0);
    }

    public final void reset() {
        if (this.c != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        Map<Integer, View> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        View r2 = (View) r1.get(Integer.valueOf(this.c));
        if (r2 == null) goto L8;
        r2.setVisibility(4);
    L8:
        this.c = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.a;
    }

    public void setECStatus(int r4) {
        if (this.a.containsKey(Integer.valueOf(r4)) == true) goto L10;
        Map<Integer, Function0<View>> r0 = this.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Function0 r2 = (Function0) r1.get(Integer.valueOf(r4));
        if (r2 == null) goto L7;
        View r3 = (View) r2.invoke();
    L8:
        if (r3 == null) goto L10;
        addView(r3);
        this.a.put(Integer.valueOf(r4), r3);
        goto L10
    L7:
        r3 = null;
    L10:
        int r5 = this.c;
        if (r5 < 0) goto L15;
        Map<Integer, View> r6 = this.a;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        View r8 = (View) r7.get(Integer.valueOf(r5));
        if (r8 == null) goto L15;
        r8.setVisibility(4);
    L15:
        Map<Integer, View> r9 = this.a;
        LinkedHashMap r10 = (LinkedHashMap) r9;
        View r11 = (View) r10.get(Integer.valueOf(r4));
        if (r11 == null) goto L19;
        r11.setVisibility(0);
        this.c = r4;
        return;
    }

    public StoreStatusView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = -1;
    }

    public /* synthetic */ StoreStatusView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
