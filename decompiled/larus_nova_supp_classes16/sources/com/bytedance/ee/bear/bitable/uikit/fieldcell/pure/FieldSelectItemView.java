package com.bytedance.ee.bear.bitable.uikit.fieldcell.pure;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldSelectModel;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/pure/FieldSelectItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldSelectModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBorderRadii", "", "getMBorderRadii", "()[F", "setMBorderRadii", "([F)V", "mBackgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getMBackgroundDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setMBackgroundDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "initBorderRadii", "", "radius", "", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldSelectItemView extends AppCompatTextView implements b<FieldSelectModel> {
    public float[] a;
    public GradientDrawable b;

    public FieldSelectItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FieldSelectItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final GradientDrawable getMBackgroundDrawable() {
        return this.b;
    }

    public final float[] getMBorderRadii() {
        return this.a;
    }

    public final void setMBackgroundDrawable(GradientDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMBorderRadii(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FieldSelectItemView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new float[8];
        setIncludeFontPadding(false);
        float r8 = d.a(100);
        float[] r0 = this.a;
        r0[0] = r8;
        r0[1] = r8;
        r0[2] = r8;
        r0[3] = r8;
        r0[4] = r8;
        r0[5] = r8;
        r0[6] = r8;
        r0[7] = r8;
        GradientDrawable r9 = new GradientDrawable();
        r9.setCornerRadii(this.a);
        this.b = r9;
        setBackground(r9);
        setGravity(8388627);
        setPadding(d.a(8), d.a(4), d.a(8), d.a(4));
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setFocusableInTouchMode(true);
        setKeyListener(null);
        setCursorVisible(false);
    }

    public /* synthetic */ FieldSelectItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
