package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\tJ\u001f\u0010\u0018\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple;", "Landroid/graphics/drawable/RippleDrawable;", "bounded", "", "<init>", "(Z)V", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "rippleRadius", "", "Ljava/lang/Integer;", "setColor", "", "color", "alpha", "", "setColor-DxMtmZc", "(JF)V", "projected", "isProjected", "getDirtyBounds", "Landroid/graphics/Rect;", "trySetRadius", "radius", "calculateRippleColor", "calculateRippleColor-5vOe2sY", "(JF)J", "MRadiusHelper", "Companion", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnprojectedRipple extends RippleDrawable {
    public static final Companion Companion = null;
    private static boolean setMaxRadiusFetched;
    private static Method setMaxRadiusMethod;
    private final boolean bounded;
    private boolean projected;
    private Color rippleColor;
    private Integer rippleRadius;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple$Companion;", "", "<init>", "()V", "setMaxRadiusMethod", "Ljava/lang/reflect/Method;", "setMaxRadiusFetched", "", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple$MRadiusHelper;", "", "<init>", "()V", "setRadius", "", "ripple", "Landroid/graphics/drawable/RippleDrawable;", "radius", "", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MRadiusHelper {
        public static final MRadiusHelper INSTANCE = null;

        static {
            INSTANCE = new MRadiusHelper();
        }

        private MRadiusHelper() {
        }

        public final void setRadius(RippleDrawable r1, int r2) {
            r1.setRadius(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        if (this.bounded == true) goto L5;
        this.projected = true;
    L5:
        Rect r0 = super.getDirtyBounds();
        this.projected = false;
        return r0;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.projected;
    }

    public UnprojectedRipple(boolean r5) {
        ColorStateList r0 = ColorStateList.valueOf(-16777216);
        if (r5 == false) goto L5;
        ColorDrawable r2 = new ColorDrawable(-1);
    L6:
        super(r0, null, r2);
        this.bounded = r5;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void trySetRadius(int r7) {
        Integer r0 = this.rippleRadius;
        if (r0 != null) goto L6;
    L7:
        this.rippleRadius = Integer.valueOf(r7);
        if (Build.VERSION.SDK_INT < 23) goto L19;
        MRadiusHelper.INSTANCE.setRadius(this, r7);
        return;
    L19:
    L16:
        Unit r8 = Unit.INSTANCE;
        return;
    L10:
        if (setMaxRadiusFetched == true) goto L12;
        setMaxRadiusFetched = true;     // Catch: Exception -> L16
        setMaxRadiusMethod = RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE});     // Catch: Exception -> L16
    L12:
        Method r1 = setMaxRadiusMethod;     // Catch: Exception -> L16
        if (r1 == null) goto L22;
        r1.invoke(this, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L16
        return;
    L22:
        return;
    L6:
        if (r0.intValue() != r7) goto L7;
    }

    /* JADX INFO: renamed from: calculateRippleColor-5vOe2sY, reason: not valid java name */
    private final long m2278calculateRippleColor5vOe2sY(long r10, float r12) {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        r12 = r12 * 2;
    L6:
        return Color.copy-wmQWz5c$default(r10, RangesKt.coerceAtMost(r12, 1.0f), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    }

    /* JADX INFO: renamed from: setColor-DxMtmZc, reason: not valid java name */
    public final void m2279setColorDxMtmZc(long r3, float r5) {
        long r4 = m2278calculateRippleColor5vOe2sY(r3, r5);
        Color r6 = this.rippleColor;
        if (r6 != null) goto L5;
        boolean r7 = false;
    L6:
        if (r7 == true) goto L9;
        this.rippleColor = Color.box-impl(r4);
        setColor(ColorStateList.valueOf(ColorKt.toArgb-8_81llA(r4)));
        return;
    L9:
        return;
    L5:
        r7 = Color.equals-impl0(r6.unbox-impl(), r4);
        goto L6
    }
}
