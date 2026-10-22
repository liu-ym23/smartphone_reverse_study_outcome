package com.bytedance.android.shopping.store.recommend.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/recommend/widget/PriceTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "price", "", "setPrice", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceTagView extends AppCompatTextView {
    public static final AbsoluteSizeSpan a = null;

    public static final class a {
    }

    static {
        a = new AbsoluteSizeSpan(13, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPrice(long r9) {
        long r0 = 100;
        if ((r9 % r0) != 0) goto L6;
        String r10 = String.valueOf(r9 / r0);
    L9:
        setText(r10);
        return;
    L6:
        if ((r9 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r10 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r9 / 100.0f)}, 1));
        goto L9
    L8:
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        r10 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r9 / 100.0f)}, 1));
        goto L9
    }

    public PriceTagView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        setTextSize(1, 11.0f);
    }

    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r1 = View.MeasureSpec.getSize(r6);
        float r2 = r1 * 1.5f;
        if (r0 >= r1) goto L5;
        r5 = View.MeasureSpec.makeMeasureSpec((int) r2, View.MeasureSpec.getMode(r5));
    L5:
        super.onMeasure(r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r9, TextView.BufferType r10) {
        if (r9 != null) goto L5;
        super/*android.widget.TextView*/.setText(r9, r10);
        return;
    L5:
        String r11 = "¥" + r9;
        int r0 = StringsKt.indexOf$default(r11, ".", 0, false, 6, null);
        if (r0 >= 0) goto L8;
        r0 = r11.length();
    L8:
        SpannableString r1 = new SpannableString(r11);
        r1.setSpan(a, 1, r0, 33);
        super/*android.widget.TextView*/.setText(r1, r10);
    }
}
