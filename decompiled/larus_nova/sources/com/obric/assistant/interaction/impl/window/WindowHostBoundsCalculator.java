package com.obric.assistant.interaction.impl.window;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostBoundsCalculator;", "", "<init>", "()V", "resolveBounds", "Landroid/graphics/Rect;", "displayWidth", "", "displayHeight", "attrsWidth", "attrsHeight", GXTemplateKey.GAIAX_LAYER_GRAVITY, "x", "y", "decorWidth", "decorHeight", "layoutDirection", "resolveWindowDimension", "attrsSize", "decorSize", "displaySize", "resolveGravity", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostBoundsCalculator {
    public static final WindowHostBoundsCalculator INSTANCE = null;

    static {
        INSTANCE = new WindowHostBoundsCalculator();
    }

    private WindowHostBoundsCalculator() {
    }

    private final int resolveGravity(int r100) {
        boolean r101 = false;
        if ((r100 & 7) == 0) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if ((r100 & 112) == 0) goto L12;
        r101 = true;
    L12:
        if (r102 == true) goto L14;
        r100 = r100 | GravityCompat.START;
    L14:
        if (r101 == false) goto L16;
        return r100;
    L16:
        return r100 | 48;
    L5:
        if ((8388615 & r100) != 0) goto L8;
        r102 = false;
        goto L10
    }

    private final int resolveWindowDimension(int r100, int r101, int r102) {
        if (r100 == (-1)) goto L11;
        if (r100 > 0) goto L13;
        if (r101 > 0) goto L12;
        return 0;
    L12:
        return r101;
    L13:
        return r100;
    L11:
        return r102;
    }

    public final Rect resolveBounds(int r110, int r111, int r112, int r113, int r114, int r210, int r211, int r212, int r213, int r214) {
        if (r110 <= 0) goto L18;
        if (r111 <= 0) goto L21;
        int r100 = resolveWindowDimension(r112, r212, r110);
        int r101 = resolveWindowDimension(r113, r213, r111);
        if (r100 <= 0) goto L19;
        if (r101 <= 0) goto L22;
        boolean r115 = false;
        Rect r116 = new Rect(0, 0, r110, r111);
        Rect r102 = new Rect();
        Gravity.apply(resolveGravity(r114), r100, r101, r116, r210, r211, r102, r214);
        if (r102.intersect(r116) == true) goto L13;
    L15:
        if (r115 == true) goto L17;
        return null;
    L17:
        return r102;
    L13:
        if (r102.isEmpty() == true) goto L15;
        r115 = true;
        goto L15
    L22:
        return null;
    L19:
        return null;
    L21:
        return null;
    L18:
        return null;
    }

    public static /* synthetic */ Rect resolveBounds$default(WindowHostBoundsCalculator r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210, int r211, int r212, int r213, Object r214) {
        if ((r213 & 512) == 0) goto L5;
        int r118 = 0;
    L7:
        return r110.resolveBounds(r111, r112, r113, r114, r115, r116, r117, r210, r211, r118);
    L5:
        r118 = r212;
        goto L7
    }
}
