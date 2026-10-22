package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextViewV2;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBorderRadii", "", "getMBorderRadii", "()[F", "setMBorderRadii", "([F)V", "mBackgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getMBackgroundDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setMBackgroundDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "initAttr", "", "initBorderRadii", "radius", "", "updateBorderRadii", "setData", "selectEntity", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "setColor", "backgroundColor", "", "textColor", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectTextViewV2 extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f208104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GradientDrawable f208105b;

    public static final class a {
    }

    static {
    }

    public final void x() {
        setIncludeFontPadding(false);
        float r100 = com.bytedance.ee.util.ui.n.d(100);
        float[] r101 = this.f208104a;
        r101[0] = r100;
        r101[1] = r100;
        r101[2] = r100;
        r101[3] = r100;
        r101[4] = r100;
        r101[5] = r100;
        r101[6] = r100;
        r101[7] = r100;
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadii(this.f208104a);
        this.f208105b = r102;
        setBackground(r102);
        setGravity(3);
        setPadding(com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(2));
        setKeyListener(null);
        setCursorVisible(false);
    }

    public final GradientDrawable getMBackgroundDrawable() {
        return this.f208105b;
    }

    public final float[] getMBorderRadii() {
        return this.f208104a;
    }

    public SelectTextViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f208104a = new float[8];
        x();
    }

    public final void setData(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r100) {
        if (r100 == null) goto L5;
        String r101 = r100.f207142b;
        if (r101 == null) goto L5;
    L6:
        setText(r101);
        if (r100 == null) goto L23;
        String r102 = r100.f207144d;
        String r103 = r100.f207145e;
        if (r102 != null) goto L21;
    L16:
        if (r103 == null) goto L24;
        setTextColor(ColorUtils.h(r103));     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        tt5.a.e("SelectTextView", "parse color failed!", e, false);
        return;
    L24:
        return;
    L21:
        GradientDrawable r104 = this.f208105b;     // Catch: Exception -> L14
        if (r104 == null) goto L13;
        r104.setColor(ColorUtils.h(r102));     // Catch: Exception -> L14
    L13:
        setBackground(this.f208105b);     // Catch: Exception -> L14
        goto L16
    L23:
        return;
    L5:
        r101 = "";
        goto L6
    }

    public final void setMBackgroundDrawable(GradientDrawable r100) {
        this.f208105b = r100;
    }

    public final void setMBorderRadii(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f208104a = r100;
    }

    public final void y(float r100) {
        float[] r101 = this.f208104a;
        r101[0] = r100;
        r101[1] = r100;
        r101[2] = r100;
        r101[3] = r100;
        r101[4] = r100;
        r101[5] = r100;
        r101[6] = r100;
        r101[7] = r100;
        GradientDrawable r102 = this.f208105b;
        if (r102 == null) goto L5;
        r102.setCornerRadii(r101);
    L5:
        setBackground(this.f208105b);
    }

    public SelectTextViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f208104a = new float[8];
        x();
    }
}
