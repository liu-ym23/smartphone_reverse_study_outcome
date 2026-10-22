package com.bytedance.android.shopping.deepfeed.weights.video;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoProgressTextLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressTextLayout extends LinearLayout {
    public final TextView a;
    public final TextView b;

    public VideoProgressTextLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoProgressTextLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static String a(int r5) {
        int r0 = r5 / 60;
        int r6 = r5 % 60;
        StringBuilder r1 = new StringBuilder();
        if (r0 >= 10) goto L5;
        String r2 = "0" + r0;
    L6:
        r1.append(r2);
        r1.append(':');
        if (r6 >= 10) goto L9;
        String r7 = "0" + r6;
    L10:
        r1.append(r7);
        return r1.toString();
    L9:
        r7 = String.valueOf(r6);
        goto L10
    L5:
        r2 = String.valueOf(r0);
        goto L6
    }

    public final TextView b(int r3) {
        TextView r0 = new TextView(getContext());
        ViewExtensionsKt.h(r0, 24);
        r0.setTypeface(Typeface.DEFAULT_BOLD);
        r0.setTextColor(r3);
        r0.setLineSpacing(q.a(8), 1.0f);
        return r0;
    }

    public VideoProgressTextLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        TextView r6 = b(-1);
        this.a = r6;
        int r7 = (int) 2164260863L;
        TextView r8 = b(r7);
        this.b = r8;
        addView(r6);
        TextView r9 = b(r7);
        ViewExtensionsKt.h(r9, 12);
        r9.setText("/");
        Unit r10 = Unit.INSTANCE;
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        r11.leftMargin = b.a(12);
        r11.rightMargin = b.a(12);
        addView(r9, r11);
        addView(r8);
        setGravity(17);
        setOrientation(0);
    }

    public /* synthetic */ VideoProgressTextLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
