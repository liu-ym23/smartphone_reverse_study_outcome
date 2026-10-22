package com.larksuite.component.ui.text;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import j08.b;

/* JADX INFO: loaded from: classes24.dex */
public class LKUITextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f284474a = null;

    static {
        f284474a = new float[][]{new float[]{26.0f, 10.0f}, new float[]{20.0f, 8.0f}, new float[]{17.0f, 7.0f}, new float[]{16.0f, 8.0f}, new float[]{14.0f, 8.0f}, new float[]{12.0f, 4.0f}, new float[]{11.0f, 3.0f}};
    }

    public final void x() {
        float r100 = 0.0f;
        if (getLineSpacingExtra() == 0.0f) goto L5;
        return;
    L5:
        if (getLineSpacingMultiplier() != 1.0f) goto L30;
        int r101 = getLineHeight();
        float r102 = getTextSize();
        float r103 = r101 - r102;
        Resources r104 = getContext().getResources();
        float r105 = (int) ((r102 / WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density) + 0.5f);
        float[][] r106 = f284474a;
        float[] r107 = r106[0];
        if (r105 < r107[0]) goto L10;
        r100 = r107[1];
    L20:
        setLineSpacing(b.a(getContext(), r100) - r103, 1.0f);
        return;
    L10:
        float[] r108 = r106[6];
        if (r105 > r108[0]) goto L13;
        r100 = r108[1];
        goto L20
    L13:
        int r109 = 0;
    L14:
        if (r109 >= 6) goto L20;
        float[] r110 = r106[r109];
        r109 = r109 + 1;
        float[] r111 = r106[r109];
        float r112 = r110[0];
        if (r112 < r105) goto L14;
        float r113 = r111[0];
        if (r113 > r105) goto L14;
        float r114 = r110[1];
        float r115 = r111[1];
        r100 = (((r114 - r115) / (r112 - r113)) * (r105 - r113)) + r115;
        goto L14
    }

    public LKUITextView(Context r100) {
        super(r100);
        x();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r100) {
        super.setTextSize(r100);
        x();
    }

    public LKUITextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        x();
    }

    public LKUITextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        x();
    }
}
