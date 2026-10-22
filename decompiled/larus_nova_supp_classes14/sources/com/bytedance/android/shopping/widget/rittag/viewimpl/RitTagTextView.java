package com.bytedance.android.shopping.widget.rittag.viewimpl;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.RitTagPart;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/widget/rittag/viewimpl/RitTagTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/shopping/widget/rittag/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RitTagTextView extends AppCompatTextView implements com.bytedance.android.shopping.widget.rittag.b {
    public static final /* synthetic */ int b = 0;
    public int a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final View i() {
        return this;
    }

    public RitTagTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        int r3 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.a = com.bytedance.android.ec.hybrid.list.util.c.d(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final void l(RitTagUI.RitTagUIItem r12, RitTagPart r13) {
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "part");
        int r0 = s.a;
        RitTagUI.RitTagUIItem.TextItem r1 = r12.getText();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getTextColor();
    L6:
        setTextColor(s.a(r3, -50350));
        float[] r4 = r12.getRadius();
        RitTagUI.RitTagUIItem.TextItem r5 = r12.getText();
        if (r5 == null) goto L9;
        String r6 = r5.getTextBorderColor();
    L10:
        RitTagUI.RitTagUIItem.TextItem r7 = r12.getText();
        if (r7 == null) goto L13;
        String r8 = r7.getTextBgColor();
    L14:
        Drawable r9 = com.bytedance.android.shopping.widget.rittag.a.c(r4, Float.MAX_VALUE, r6, r8);
        int r10 = com.bytedance.android.shopping.widget.rittag.a.a();
        int r14 = c.b[r13.ordinal()];
        if (r14 == 1) goto L23;
        if (r14 != 2) goto L18;
        setPadding(0, 0, 0, 0);
    L25:
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r9);
        RitTagUI.RitTagUIItem.TextItem r15 = r12.getText();
        if (r15 == null) goto L30;
        Float r16 = r15.leftPadding();
        if (r16 == null) goto L30;
        int r11 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r17 = com.bytedance.android.ec.hybrid.list.util.c.d(r16);
    L31:
        RitTagUI.RitTagUIItem.TextItem r18 = r12.getText();
        if (r18 == null) goto L36;
        Float r19 = r18.rightPadding();
        if (r19 == null) goto L36;
        int r20 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r21 = com.bytedance.android.ec.hybrid.list.util.c.d(r19);
    L37:
        setPadding(getPaddingLeft() + r17, getPaddingTop(), getPaddingRight() + r21, getPaddingBottom());
        RitTagUI.RitTagUIItem.TextItem r110 = r12.getText();
        if (r110 == null) goto L40;
        RitTagUI.RitTagUIItem.FontWeight r111 = r110.getWeight();
    L41:
        if (r111 == null) goto L46;
        int r112 = c.a[r111.ordinal()];
        if (r112 == 1) goto L49;
        if (r112 == 2) goto L46;
        throw new NoWhenBranchMatchedException();
    L49:
        Typeface r113 = Typeface.DEFAULT_BOLD;
    L50:
        setTypeface(r113);
        RitTagUI.RitTagUIItem.TextItem r114 = r12.getText();
        if (r114 == null) goto L53;
        r2 = r114.getText();
    L53:
        if (r2 != null) goto L55;
        r2 = "";
    L55:
        setText(r2);
        return;
    L46:
        r113 = Typeface.DEFAULT;
        goto L50
    L40:
        r111 = null;
    L36:
        r21 = this.a;
    L30:
        r17 = this.a;
        goto L31
    L18:
        if (r14 != 3) goto L21;
        setPadding(r10, 0, 0, 0);
        InsetDrawable r115 = new InsetDrawable(r9, -r10, 0, 0, 0);
    L24:
        r9 = r115;
        goto L25
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        setPadding(0, 0, r10, 0);
        r115 = new InsetDrawable(r9, 0, 0, -r10, 0);
        goto L24
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
