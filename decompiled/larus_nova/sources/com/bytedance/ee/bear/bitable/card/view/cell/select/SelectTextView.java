package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.util.ui.ColorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 J\b\u0010\"\u001a\u00020\u0016H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBorderRadii", "", "getMBorderRadii", "()[F", "setMBorderRadii", "([F)V", "mBackgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getMBackgroundDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setMBackgroundDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "initAttr", "", "initBorderRadii", "radius", "", "updateBorderRadii", "setData", "selectEntity", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "setColor", "backgroundColor", "", "textColor", "onDetachedFromWindow", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectTextView extends BitableAtEditText {

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public float[] f208102h2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public GradientDrawable f208103p2;

    public static final class a {
    }

    static {
    }

    public void O() {
        setIncludeFontPadding(false);
        P(com.bytedance.ee.util.ui.n.d(100));
        GradientDrawable r100 = new GradientDrawable();
        this.f208103p2 = r100;
        Intrinsics.checkNotNull(r100);
        r100.setCornerRadii(this.f208102h2);
        setBackground(this.f208103p2);
        setGravity(17);
        setPadding(com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(2));
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setFocusableInTouchMode(true);
        setTextIsSelectable(true);
        setKeyListener(null);
        setCursorVisible(false);
    }

    public final GradientDrawable getMBackgroundDrawable() {
        return this.f208103p2;
    }

    public final float[] getMBorderRadii() {
        return this.f208102h2;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public SelectTextView(Context r100) {
        super(r100);
        this.f208102h2 = new float[8];
        O();
    }

    public final void P(float r100) {
        float[] r101 = this.f208102h2;
        r101[0] = r100;
        r101[1] = r100;
        r101[2] = r100;
        r101[3] = r100;
        r101[4] = r100;
        r101[5] = r100;
        r101[6] = r100;
        r101[7] = r100;
    }

    public final void R(float r100) {
        P(r100);
        GradientDrawable r101 = this.f208103p2;
        if (r101 == null) goto L5;
        r101.setCornerRadii(this.f208102h2);
    L5:
        setBackground(this.f208103p2);
    }

    public final void setData(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r100) {
        if (r100 == null) goto L5;
        String r101 = r100.f207142b;
        if (r101 == null) goto L5;
    L6:
        setTextSimple(r101);
        if (r100 == null) goto L10;
        Q(r100.f207144d, r100.f207145e);
        return;
    L10:
        return;
    L5:
        r101 = "";
        goto L6
    }

    public final void setMBackgroundDrawable(GradientDrawable r100) {
        this.f208103p2 = r100;
    }

    public final void setMBorderRadii(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f208102h2 = r100;
    }

    public SelectTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f208102h2 = new float[8];
        O();
    }

    public final void Q(String r100, String r101) {
        if (r100 != null) goto L14;
    L9:
        if (r101 == null) goto L16;
        setTextColor(ColorUtils.h(r101));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e("SelectTextView", "parse color failed!", e, false);
        return;
    L16:
        return;
    L14:
        GradientDrawable r102 = this.f208103p2;     // Catch: Exception -> L7
        if (r102 == null) goto L6;
        r102.setColor(ColorUtils.h(r100));     // Catch: Exception -> L7
    L6:
        setBackground(this.f208103p2);     // Catch: Exception -> L7
        goto L9
    }
}
