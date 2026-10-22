package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.loading.ECSloganLoadingAnimationView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Deprecated(message = "不要用这个了，用ec-core中的")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/window/shop/widget/StatusView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "loadingView", "", "setLoading", "", "status", "setECStatus", "setupLoadingAnim", "", "a", "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "statusViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StatusView extends FrameLayout {
    public final Map<Integer, View> a;
    public int b;
    public View c;

    public static final class a {
    }

    static {
    }

    public StatusView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StatusView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a() {
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = getContext();
        r0.getClass();
        View r2 = ShoppingAsyncInflater.a.a(r1).aU(2131561038, this, false);
        Lazy r3 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L6;
    L8:
        this.c = r2;
        return r2;
    L6:
        if (we.a.a == false) goto L8;
        ((LinearLayout) r2.findViewById(2131389439)).setVisibility(0);
        goto L8
    }

    public final void b() {
        if (this.b != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        Map<Integer, View> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        View r2 = (View) r1.get(Integer.valueOf(this.b));
        if (r2 == null) goto L8;
        r2.setVisibility(4);
    L8:
        this.b = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.a;
    }

    public final void setECStatus(int r3) {
        int r0 = this.b;
        if (r0 < 0) goto L7;
        Map<Integer, View> r1 = this.a;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        View r4 = (View) r2.get(Integer.valueOf(r0));
        if (r4 == null) goto L7;
        r4.setVisibility(4);
    L7:
        Map<Integer, View> r5 = this.a;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        View r7 = (View) r6.get(Integer.valueOf(r3));
        if (r7 == null) goto L15;
        r7.setVisibility(0);
        this.b = r3;
        if (r3 != 0) goto L16;
        Lazy r8 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L17;
        setupLoadingAnim(r7);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void setLoading(View r3) {
        Intrinsics.checkNotNullParameter(r3, "loadingView");
        this.a.put(0, r3);
        removeAllViews();
        Iterator r4 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        int r0 = ((Number) r4.next()).intValue();
        Map<Integer, View> r1 = this.a;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        View r5 = (View) r2.get(Integer.valueOf(r0));
        if (r5 == null) goto L4;
        r5.setVisibility(4);
        addView(r5);
        goto L4
    }

    public void setupLoadingAnim(View r2) {
        Intrinsics.checkNotNullParameter(r2, "loadingView");
        ECSloganLoadingAnimationView r3 = (ECSloganLoadingAnimationView) r2.findViewById(2131386336);
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }

    public StatusView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = -1;
        c(null, null, false);
    }

    public final void c(View r5, View r6, boolean r7) {
        ((LinkedHashMap) this.a).clear();
        Map<Integer, View> r0 = this.a;
        if (r5 != null) goto L15;
        if (r7 == false) goto L14;
        r5 = this.c;
        if (r5 == null) goto L13;
        ViewParent r8 = r5.getParent();
        if ((r8 instanceof ViewGroup) == true) goto L10;
        r8 = null;
    L10:
        ViewGroup r9 = (ViewGroup) r8;
        if (r9 == null) goto L15;
        r9.removeView(r5);
        goto L15
    L13:
        r5 = a();
        this.c = r5;
        Intrinsics.checkNotNull(r5);
        goto L15
    L14:
        r5 = a();
    L15:
        r0.put(0, r5);
        this.a.put(1, null);
        this.a.put(2, r6);
        removeAllViews();
        Iterator r10 = ((LinkedHashMap) this.a).keySet().iterator();
    L17:
        if (r10.hasNext() == false) goto L22;
        int r11 = ((Number) r10.next()).intValue();
        View r12 = (View) ((LinkedHashMap) this.a).get(Integer.valueOf(r11));
        if (r12 == null) goto L17;
        r12.setVisibility(4);
        addView(r12);
        goto L17
    }

    public /* synthetic */ StatusView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
