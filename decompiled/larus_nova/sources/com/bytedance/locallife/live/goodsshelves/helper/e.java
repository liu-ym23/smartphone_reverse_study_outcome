package com.bytedance.locallife.live.goodsshelves.helper;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import com.bytedance.locallife.live.goodsshelves.bean.BackgroundConfig;
import com.bytedance.locallife.live.goodsshelves.bean.ClientStyleConfig;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.util.c0;
import com.bytedance.locallife.live.util.j0;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final void a(LiveGoodsShelvesResponse r210, View r211) {
        if (r211 != null) goto L5;
        return;
    L5:
        float r100 = j0.b(12);
        float[] r101 = {r100, r100, r100, r100, 0.0f, 0.0f, 0.0f, 0.0f};
        String r102 = null;
        if (r210 == null) goto L10;
        ClientStyleConfig r103 = r210.getClientStyleConfig();
        if (r103 == null) goto L10;
        BackgroundConfig r104 = r103.getBackgroundConfig();
    L11:
        if (r104 == null) goto L13;
        String r105 = r104.getStartColor();
    L15:
        if (r105 == null) goto L22;
        if (r104 != null) goto L68;
        String r106 = null;
    L20:
        int r107 = Color.parseColor(r106);     // Catch: Exception -> L18
    L23:
        if (r104 == null) goto L25;
        int r110 = r104.getStartHeight();
    L26:
        int r111 = j0.c(r110);
        if (r104 == null) goto L29;
        int r112 = r104.getGradientHeight();
    L30:
        int r113 = j0.c(r112);
        if (r104 == null) goto L33;
        String r114 = r104.getEndColor();
    L34:
        if (r114 == null) goto L40;
        if (r104 != null) goto L66;
    L37:
        int r108 = Color.parseColor(r102);     // Catch: Exception -> L39
    L41:
        GradientDrawable r109 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r107, r107});
        r109.setCornerRadii(r101);
        GradientDrawable r115 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r107, r108});
        GradientDrawable r116 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r108, r108});
        Object[] r117 = CollectionsKt.listOf(new GradientDrawable[]{r109, r115, r116}).toArray(new GradientDrawable[0]);
        if (r117 == null) goto L65;
        LayerDrawable r118 = new LayerDrawable((Drawable[]) r117);
        int r119 = c0.a();
        if (r111 >= 0) goto L46;
        int r120 = r119;
    L47:
        if (r113 >= 0) goto L49;
        r113 = r119 - r120;
    L49:
        int[] r121 = {r120, r113, (r119 - r111) - r113};
        Iterator<Integer> r122 = ArraysKt.getIndices(r121).iterator();
    L51:
        if (r122.hasNext() == false) goto L55;
        int r123 = ((IntIterator) r122).nextInt();
        if (Build.VERSION.SDK_INT < 23) goto L51;
        r118.setLayerSize(r123, -1, r121[r123]);
        goto L51
    L55:
        if (r120 <= 0) goto L57;
        r118.setLayerInset(1, 0, r120, 0, 0);
    L58:
        int r124 = r120 + r113;
        if (r124 <= 0) goto L61;
        r118.setLayerInset(2, 0, r124, 0, 0);
    L62:
        r211.setBackground(r118);
        return;
    L61:
        r116.setCornerRadii(r101);
        goto L62
    L57:
        r115.setCornerRadii(r101);
        goto L58
    L46:
        r120 = r111;
        goto L47
    L65:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L66:
        r102 = r104.getEndColor();     // Catch: Exception -> L39
    L40:
        r108 = -1;
        goto L41
    L33:
        r114 = null;
        goto L34
    L29:
        r112 = -1;
        goto L30
    L25:
        r110 = -1;
        goto L26
    L68:
        r106 = r104.getStartColor();     // Catch: Exception -> L18
    L22:
        r107 = -1;
        goto L23
    L13:
        r105 = null;
    L10:
        r104 = null;
        goto L11
    }
}
