package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable r1);

    void setMinWidthHeightInternal(int r1, int r2);

    void setShadowPadding(int r1, int r2, int r3, int r4);
}
