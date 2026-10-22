package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/AdapterScreenSimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdapterScreenSimpleDraweeView extends SimpleDraweeView {
    public final Paint a;
    public final Path b;
    public final RectF c;
    public final boolean d;
    public final Integer e;

    public AdapterScreenSimpleDraweeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AdapterScreenSimpleDraweeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        int r0 = r7.save();
        Integer r1 = this.e;
        if (r1 == null) goto L8;
        if (r1.intValue() <= 0) goto L8;
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.reset();
        this.b.addRoundRect(this.c, this.e.intValue(), this.e.intValue(), Path.Direction.CW);
        r7.clipPath(this.b);
    L10:
        super/*android.widget.ImageView*/.onDraw(r7);
        r7.restoreToCount(r0);
        return;
    L8:
        if (this.d == false) goto L10;
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        r7.drawRect(this.c, this.a);
        goto L10
    }

    public AdapterScreenSimpleDraweeView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        r8.setStyle(Paint.Style.FILL);
        Unit r1 = Unit.INSTANCE;
        this.a = r8;
        this.b = new Path();
        this.c = new RectF();
        a r2 = a.e;
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130969699, 2130969706, 2130969707, 2130969708, 2130969709, 2130969712}, 0, 0);
        String r10 = r9.getString(0);
        if (r10 != null) goto L5;
    L10:
        int r11 = r9.getInt(5, 0);
        if (r2 == null) goto L13;
        DeepFeedFoldHelper.d();
        int r12 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r13 = com.bytedance.android.ec.hybrid.list.util.c.c(Integer.valueOf(r11), r2.d, true);
    L14:
        this.e = Integer.valueOf(r13);
        r9.recycle();
        return;
    L13:
        int r14 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r13 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r11));
        goto L14
    L5:
        if (r10.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r8.setColor(ColorProtector.parseColor(r10));
        this.d = true;
        goto L10
    L7:
        r3 = false;
        goto L8
    }

    public /* synthetic */ AdapterScreenSimpleDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
