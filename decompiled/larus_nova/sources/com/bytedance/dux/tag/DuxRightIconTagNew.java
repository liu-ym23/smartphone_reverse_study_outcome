package com.bytedance.dux.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/bytedance/dux/tag/DuxRightIconTagNew;", "Lcom/bytedance/dux/tag/DuxTagNew;", "Landroid/graphics/drawable/Drawable;", "icon", "", "setRightIcon", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxRightIconTagNew extends DuxTagNew {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f205754c;

    public DuxRightIconTagNew(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxRightIconTagNew(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final void a() {
        if (this.f205754c != null) goto L5;
        return;
    L5:
        if (getLayout() == null) goto L20;
        TextPaint r100 = getPaint();
        String r101 = getText().toString();
        if (getTransformationMethod() == null) goto L10;
        r101 = getTransformationMethod().getTransformation(r101, this).toString();
    L10:
        int r102 = RangesKt.coerceAtMost((int) r100.measureText(r101), getLayout().getWidth());
        if (getIconSize() != 0) goto L13;
        Drawable r103 = this.f205754c;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getIntrinsicWidth();
    L14:
        int r105 = -((((((getMeasuredWidth() - r102) - ViewCompat.getPaddingEnd(this)) - r104) - getIconPadding()) - ViewCompat.getPaddingStart(this)) / 2);
        if (this.f205753b == r105) goto L19;
        this.f205753b = r105;
        updateIcon();
        return;
    L19:
        return;
    L13:
        r104 = getIconSize();
        goto L14
    }

    public final void updateIcon() {
        Drawable r100 = this.f205754c;
        if (r100 == null) goto L16;
        Intrinsics.checkNotNull(r100);
        Drawable r101 = r100.mutate();
        this.f205754c = r101;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, getIconTint());
        if (getIconTintMode() == null) goto L8;
        Drawable r102 = this.f205754c;
        Intrinsics.checkNotNull(r102);
        DrawableCompat.setTintMode(r102, getIconTintMode());
    L8:
        if (getIconSize() == 0) goto L10;
        int r103 = getIconSize();
    L12:
        if (getIconSize() == 0) goto L14;
        int r104 = getIconSize();
    L15:
        Drawable r105 = this.f205754c;
        Intrinsics.checkNotNull(r105);
        int r106 = this.f205753b;
        r105.setBounds(r106, 0, r103 + r106, r104);
        goto L16
    L14:
        Drawable r107 = this.f205754c;
        Intrinsics.checkNotNull(r107);
        r104 = r107.getIntrinsicHeight();
        goto L15
    L10:
        Drawable r108 = this.f205754c;
        Intrinsics.checkNotNull(r108);
        r103 = r108.getIntrinsicWidth();
    L16:
        TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f205754c, null);
    }

    public final void setRightIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        if (Intrinsics.areEqual(this.f205754c, r100) == true) goto L6;
        this.f205754c = r100;
        a();
        return;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        a();
    }

    public DuxRightIconTagNew(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.duxRightIcon, R.attr.iconTint}, 0, 0);
        this.f205754c = r103.getDrawable(0);     // Catch: Throwable -> L9
        r103.recycle();
        setCompoundDrawablePadding(getIconPadding());
        updateIcon();
        return;
    L9:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        a();
    }
}
