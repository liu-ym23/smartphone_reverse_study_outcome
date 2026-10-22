package com.obric.oui.sheet.v2;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class SheetAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f402960a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "", "", "maxRatio", FaceService.girlLabel, "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum HeightLevel extends Enum<HeightLevel> {
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HeightLevel[] f402961a = null;
        private final float maxRatio;

        public static HeightLevel valueOf(String r100) {
            return (HeightLevel) r27.a.a(HeightLevel.class, r100);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) f402961a.clone();
        }

        static {
            HeightLevel r100 = new HeightLevel("SMALL", 0, 0.4f);
            SMALL = r100;
            HeightLevel r101 = new HeightLevel("MEDIUM", 1, 0.8f);
            MEDIUM = r101;
            HeightLevel r102 = new HeightLevel("LARGE", 2, 1.0f);
            LARGE = r102;
            f402961a = new HeightLevel[]{r100, r101, r102};
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }

        public HeightLevel(String r100, int r101, float r102) {
            super(r100, r101);
            this.maxRatio = r102;
        }
    }

    static {
    }

    public SheetAnimStyle() {
    }

    public static void c(RadiusLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        int r101 = pla.d.n(r100, 10);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103.topMargin >= r101) goto L7;
        r103.topMargin = r101;
    L7:
        r100.setLayoutParams(r102);
    }

    public static Pair d(float r100, boolean r110) {
        float r101 = 1.0f - Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH.getBounce();
        if (r110 == false) goto L6;
        float r111 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_1.getDuration() / 1000.0f;
        float r102 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3.getDuration() / 1000.0f;
        int r103 = vma.b.f556350a;
        return new Pair(Float.valueOf(r101), Float.valueOf((float) Math.pow(6.283185307179586d / ((double) (r111 + ((r102 - r111) * vma.b.a(RangesKt.coerceIn(r100, 0.3f, 0.6f), 0.3f, 0.6f)))), 2.0d)));
    L6:
        float r112 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration() / 1000.0f;
        float r104 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2.getDuration() / 1000.0f;
        int r105 = vma.b.f556350a;
        return new Pair(Float.valueOf(r101), Float.valueOf((float) Math.pow(6.283185307179586d / ((double) (r112 + ((r104 - r112) * vma.b.a(RangesKt.coerceIn(r100, 0.3f, 0.6f), 0.3f, 0.6f)))), 2.0d)));
    }

    public static com.obric.common.oea.foundation.animation.builder.b.a e(RadiusLayout r100, int r101) {
        int r102 = vma.c.f556351a;
        Object r103 = r100.getTag(r101);
        if (r103 != null) goto L6;
    L8:
        r103 = null;
    L9:
        com.obric.common.oea.foundation.animation.builder.b.a r104 = (com.obric.common.oea.foundation.animation.builder.b.a) r103;
        if (r104 != null) goto L13;
        com.obric.common.oea.foundation.animation.builder.b.a r105 = new com.obric.common.oea.foundation.animation.builder.b.a(r100);
        r100.setTag(r101, r105);
        return r105;
    L13:
        return r104;
    L6:
        if ((r103 instanceof com.obric.common.oea.foundation.animation.builder.b.a) == false) goto L8;
        goto L8
    }

    public static final void a(View r100, float r101, float r102, float r103) {
        float r104 = r103 - r102;     // Catch: Exception -> L5
        r100.setAlpha(r102 + (r104 * RangesKt.coerceIn(r101, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Intrinsics.stringPlus("updateDimViewWithAnim: ", e.getMessage());
    }

    public static final void b(Window r100, float r101, float r102, float r103) {
        float r104 = r103 - r102;     // Catch: Exception -> L5
        r100.setDimAmount(r102 + (r104 * RangesKt.coerceIn(r101, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Intrinsics.stringPlus("updateWindowDimWithAnim: ", e.getMessage());
    }
}
