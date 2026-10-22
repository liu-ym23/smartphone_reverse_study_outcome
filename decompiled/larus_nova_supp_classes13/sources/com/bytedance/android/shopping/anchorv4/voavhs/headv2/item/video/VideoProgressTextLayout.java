package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/item/video/VideoProgressTextLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressTextLayout extends LinearLayout {
    public final TextView a;
    public final TextView b;

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

    public VideoProgressTextLayout(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        TextView r6 = b(-1);
        this.a = r6;
        int r7 = (int) 2164260863L;
        TextView r0 = b(r7);
        this.b = r0;
        addView(r6);
        TextView r8 = b(r7);
        ViewExtensionsKt.h(r8, 12);
        r8.setText("/");
        Unit r9 = Unit.INSTANCE;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r10.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        addView(r8, r10);
        addView(r0);
        setGravity(17);
        setOrientation(0);
    }
}
