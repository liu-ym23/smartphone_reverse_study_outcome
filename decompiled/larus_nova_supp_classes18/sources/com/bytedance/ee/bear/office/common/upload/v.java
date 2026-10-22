package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends FrameLayout {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeUploadStatus.values().length];
            r0[OfficeUploadStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OfficeUploadStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public v(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11);
        ImageView r0 = new ImageView(r11);
        this.a = r0;
        TextView r1 = new TextView(r11);
        r1.setTextColor(ContextCompat.getColor(r11, 2131103959));
        r1.setTextSize(17.0f);
        r1.setTypeface(Typeface.DEFAULT_BOLD);
        r1.setIncludeFontPadding(false);
        r1.setMaxLines(1);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        this.b = r1;
        TextView r3 = new TextView(r11);
        r3.setTextSize(14.0f);
        r3.setIncludeFontPadding(false);
        this.c = r3;
        ImageView r2 = new ImageView(r11);
        r2.setImageResource(2131244688);
        r2.setContentDescription(null);
        this.d = r2;
        ImageView r5 = new ImageView(r11);
        r5.setImageResource(2131244691);
        r5.setContentDescription(null);
        this.e = r5;
        setLayoutParams(new RecyclerView.LayoutParams(-1, e.a(r11, 80)));
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(e.a(r11, 48), e.a(r11, 48));
        r4.gravity = 8388627;
        r4.leftMargin = e.a(r11, 20);
        Unit r9 = Unit.INSTANCE;
        addView(r0, r4);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -2);
        r6.gravity = 48;
        r6.leftMargin = e.a(r11, 84);
        r6.rightMargin = e.a(r11, 12);
        r6.topMargin = e.a(r11, 16);
        addView(r1, r6);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 8388659;
        r7.leftMargin = e.a(r11, 84);
        r7.topMargin = e.a(r11, 43);
        addView(r3, r7);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(e.a(r11, 20), e.a(r11, 20));
        r8.gravity = 8388629;
        r8.rightMargin = e.a(r11, 18);
        addView(r2, r8);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(e.a(r11, 20), e.a(r11, 20));
        r10.gravity = 8388629;
        r10.rightMargin = e.a(r11, 58);
        addView(r5, r10);
    }
}
