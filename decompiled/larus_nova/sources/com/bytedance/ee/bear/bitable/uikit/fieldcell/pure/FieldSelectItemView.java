package com.bytedance.ee.bear.bitable.uikit.fieldcell.pure;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldSelectModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/pure/FieldSelectItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldSelectModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBorderRadii", "", "getMBorderRadii", "()[F", "setMBorderRadii", "([F)V", "mBackgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getMBackgroundDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setMBackgroundDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "initBorderRadii", "", "radius", "", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldSelectItemView extends AppCompatTextView implements b<FieldSelectModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f216199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GradientDrawable f216200b;

    public FieldSelectItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FieldSelectItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final GradientDrawable getMBackgroundDrawable() {
        return this.f216200b;
    }

    public final float[] getMBorderRadii() {
        return this.f216199a;
    }

    public final void setMBackgroundDrawable(GradientDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f216200b = r100;
    }

    public final void setMBorderRadii(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f216199a = r100;
    }

    public FieldSelectItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f216199a = new float[8];
        setIncludeFontPadding(false);
        float r103 = d.a(100);
        float[] r104 = this.f216199a;
        r104[0] = r103;
        r104[1] = r103;
        r104[2] = r103;
        r104[3] = r103;
        r104[4] = r103;
        r104[5] = r103;
        r104[6] = r103;
        r104[7] = r103;
        GradientDrawable r105 = new GradientDrawable();
        r105.setCornerRadii(this.f216199a);
        this.f216200b = r105;
        setBackground(r105);
        setGravity(8388627);
        setPadding(d.a(8), d.a(4), d.a(8), d.a(4));
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setFocusableInTouchMode(true);
        setKeyListener(null);
        setCursorVisible(false);
    }

    public /* synthetic */ FieldSelectItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
