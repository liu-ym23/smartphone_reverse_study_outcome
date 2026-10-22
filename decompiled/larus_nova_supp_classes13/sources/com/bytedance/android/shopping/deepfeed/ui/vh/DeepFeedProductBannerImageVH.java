package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductBannerImageVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbstractDeepFeedBannerVH;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductBannerImageVH extends AbstractDeepFeedBannerVH {
    public static final /* synthetic */ int k = 0;
    public final SimpleDraweeView a;
    public final SimpleDraweeView b;
    public final SimpleDraweeView c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Integer i;
    public final com.bytedance.android.ec.core.imagex.r j;

    public static final class a {
    }

    static {
    }

    public final Bitmap V3() {
        Drawable r0 = this.a.getDrawable();
        if (r0 != null) goto L8;
        GenericDraweeHierarchy r1 = this.a.getHierarchy();
        if (r1 == null) goto L7;
        r0 = r1.getTopLevelDrawable();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L11;
        return null;
    L11:
        return X3(r0, this.a.getWidth(), this.a.getHeight());
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void T3(int r5) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L17;
        int r2 = r1.topMargin + (r5 / 3);
        int r6 = -com.bytedance.android.shopping.extensions.b.b(8);
        int r3 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.d));
        if (r6 > r2) goto L12;
        if (r3 < r2) goto L12;
        Y3(r2);
        return;
    L12:
        EventBus r7 = EventBus.getDefault();
        boolean r4 = false;
        if (r2 > com.bytedance.android.shopping.extensions.b.b(0)) goto L15;
        r4 = true;
    L15:
        r7.post(new ge3.a(r4));
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void U3(int r1) {
        if (r1 != 0) goto L4;
        Y3(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L4:
        Y3(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.d)));
    }

    public final void W3(boolean r1) {
        if (r1 == false) goto L4;
        Y3(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L4:
        Y3(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.d)));
    }

    public final void Y3(int r3) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 != null) goto L8;
    L10:
        if (r1 == null) goto L13;
        r1.topMargin = r3;
        this.a.setLayoutParams(r1);
        return;
    L13:
        return;
    L8:
        if (r1.topMargin != r3) goto L10;
    }

    public DeepFeedProductBannerImageVH(View r2, com.bytedance.android.ec.core.imagex.r r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.j = r3;
        this.a = r2.findViewById(2131367831);
        this.b = r2.findViewById(2131364314);
        this.c = r2.findViewById(2131364315);
        this.d = 150;
    }

    public static Bitmap X3(Drawable r4, int r5, int r6) {
        if ((r4 instanceof BitmapDrawable) == false) goto L11;
        Bitmap r0 = ((BitmapDrawable) r4).getBitmap();
        if (r0 == null) goto L11;
        Bitmap.Config r7 = r0.getConfig();
        if (r7 != null) goto L10;
        r7 = Bitmap.Config.ARGB_8888;
    L10:
        return r0.copy(r7, false);
    L11:
        Integer r8 = Integer.valueOf(r5);
        boolean r2 = true;
        if (r8.intValue() <= 0) goto L14;
        boolean r1 = true;
    L15:
        Object r3 = null;
        if (r1 == true) goto L19;
        r8 = null;
    L19:
        if (r8 != null) goto L27;
        r8 = Integer.valueOf(r4.getIntrinsicWidth());
        if (r8.intValue() <= 0) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == true) goto L27;
        r8 = null;
        goto L27
    L23:
        r9 = false;
    L27:
        if (r8 == null) goto L57;
        int r10 = r8.intValue();
        Integer r11 = Integer.valueOf(r6);
        if (r11.intValue() <= 0) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L35;
        r11 = null;
    L35:
        if (r11 != null) goto L43;
        r11 = Integer.valueOf(r4.getIntrinsicHeight());
        if (r11.intValue() > 0) goto L40;
        r2 = false;
    L40:
        if (r2 == true) goto L43;
        r11 = null;
    L43:
        if (r11 == null) goto L58;
        int r13 = r11.intValue();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L47
        Bitmap r15 = Bitmap.createBitmap(r10, r13, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L47
        Canvas r16 = new Canvas(r15);     // Catch: Throwable -> L47
        r4.setBounds(0, 0, r16.getWidth(), r16.getHeight());     // Catch: Throwable -> L47
        r4.draw(r16);     // Catch: Throwable -> L47
        Object r17 = Result.constructor-impl(r15);     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r17) == true) goto L54;
        r3 = r17;
    L54:
        return (Bitmap) r3;
    L47:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L58:
        return null;
    L31:
        r12 = false;
        goto L32
    L57:
        return null;
    L14:
        r1 = false;
        goto L15
    }
}
