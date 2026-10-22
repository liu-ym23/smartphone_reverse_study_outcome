package com.obric.oui.dialog.anim;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pla.d;
import vma.c;

/* JADX INFO: loaded from: classes34.dex */
public final class DialogAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f400636a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "", "", "maxRatio", FaceService.girlLabel, "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum HeightLevel extends Enum<HeightLevel> {
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HeightLevel[] f400637a = null;
        private final float maxRatio;

        public static HeightLevel valueOf(String r100) {
            return (HeightLevel) r27.a.a(HeightLevel.class, r100);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) f400637a.clone();
        }

        static {
            HeightLevel r100 = new HeightLevel("SMALL", 0, 0.4f);
            SMALL = r100;
            HeightLevel r101 = new HeightLevel("MEDIUM", 1, 0.8f);
            MEDIUM = r101;
            HeightLevel r102 = new HeightLevel("LARGE", 2, 1.0f);
            LARGE = r102;
            f400637a = new HeightLevel[]{r100, r101, r102};
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }

        public HeightLevel(String r100, int r101, float r102) {
            super(r100, r101);
            this.maxRatio = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400638a = null;

        static {
            int[] r100 = new int[HeightLevel.values().length];
            r100[HeightLevel.SMALL.ordinal()] = 1;
            r100[HeightLevel.MEDIUM.ordinal()] = 2;
            r100[HeightLevel.LARGE.ordinal()] = 3;
            f400638a = r100;
        }
    }

    static {
    }

    public DialogAnimStyle() {
    }

    public static void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        int r101 = d.n(r100, 10);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103.topMargin >= r101) goto L7;
        r103.topMargin = r101;
    L7:
        r100.setLayoutParams(r102);
    }

    public static HeightLevel b(View r100, int r101) {
        if (r101 <= 0) goto L4;
        float r102 = r100.getHeight() / r101;
        HeightLevel r103 = HeightLevel.SMALL;
        if (r102 < r103.getMaxRatio()) goto L13;
        HeightLevel r104 = HeightLevel.MEDIUM;
        if (r102 >= r104.getMaxRatio()) goto L12;
        return r104;
    L12:
        return HeightLevel.LARGE;
    L13:
        return r103;
    L4:
        return HeightLevel.MEDIUM;
    }

    public static Pair c(boolean r100, HeightLevel r101, boolean r102) {
        Float r103 = Float.valueOf(1.0f);
        if (r100 == true) goto L7;
        return new Pair(r103, Float.valueOf(480.0f));
    L7:
        if (r102 == false) goto L18;
        int r104 = a.f400638a[r101.ordinal()];
        if (r104 == 1) goto L31;
        if (r104 == 2) goto L30;
        if (r104 != 3) goto L15;
        return new Pair(r103, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r105 = a.f400638a[r101.ordinal()];
        if (r105 == 1) goto L28;
        if (r105 == 2) goto L33;
        if (r105 != 3) goto L25;
        return new Pair(r103, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    public static com.obric.oui.animation.easy.b d(View r110, final Window r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Size r100 = zma.a.c(r110.getContext());
        int r101 = r110.getHeight();
        ViewGroup.LayoutParams r102 = r110.getLayoutParams();
        Object r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
        if (r104 == null) goto L8;
        int r105 = r104.bottomMargin;
    L9:
        int r106 = r101 + r105;
        int r107 = d.n(r110, 24) + r106;
        Pair r114 = c(r113, b(r110, r100.getHeight()), false);
        final float r108 = ((Number) r114.component1()).floatValue();
        final float r115 = ((Number) r114.component2()).floatValue();
        int r109 = c.f556351a;
        Object r116 = r110.getTag(R.id.o_dialog_anim_out);
        if (r116 != null) goto L13;
    L15:
        com.obric.oui.animation.easy.b r117 = (com.obric.oui.animation.easy.b) r103;
        if (r117 != null) goto L18;
        r117 = new com.obric.oui.animation.easy.b(r110);
        r110.setTag(R.id.o_dialog_anim_out, r117);
    L18:
        Function1<com.obric.oui.animation.easy.a, Unit> r118 = new DialogAnimStyle$dialogBottomHide$spring$1(r108, r115);
        Intrinsics.checkNotNullParameter(r118, "config");
        r117.a(jla.b.f499571m, r107, r118);
        if (r111 == null) goto L26;
        if (r112 == false) goto L26;
        r111.addFlags(2);     // Catch: Exception -> L24
        final float r119 = r106;
        final float r120 = r111.getAttributes().dimAmount;     // Catch: Exception -> L24
        final Ref.BooleanRef r121 = new Ref.BooleanRef();     // Catch: Exception -> L24
        final com.obric.oui.animation.easy.b r122 = r117;
        jla.b.j r123 = new com.obric.oui.dialog.anim.a(r111, r119, r120, r121, r122);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r123, "listener");     // Catch: Exception -> L24
        r117.f398744g = r123;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage());
    L26:
        com.obric.oui.animation.style.a.b(r110);
        return r117;
    L13:
        if ((r116 instanceof com.obric.oui.animation.easy.b) == false) goto L15;
        r103 = r116;
        goto L15
    L8:
        r105 = 0;
        goto L9
    }

    public static com.obric.oui.animation.easy.b e(View r100, final Window r101, boolean r102, final float r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Size r104 = zma.a.c(r100.getContext());
        int r105 = r100.getHeight();
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        Object r107 = null;
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r106 = null;
    L5:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r106;
        if (r108 == null) goto L8;
        int r109 = r108.bottomMargin;
    L9:
        final int r111 = (r105 + r109) + d.n(r100, 24);
        r100.setAlpha(1.0f);
        Pair r112 = c(r110, b(r100, r104.getHeight()), true);
        final float r113 = ((Number) r112.component1()).floatValue();
        final float r114 = ((Number) r112.component2()).floatValue();
        int r115 = c.f556351a;
        Object r116 = r100.getTag(R.id.o_dialog_anim_in);
        if (r116 != null) goto L13;
    L15:
        com.obric.oui.animation.easy.b r117 = (com.obric.oui.animation.easy.b) r107;
        if (r117 != null) goto L18;
        r117 = new com.obric.oui.animation.easy.b(r100);
        r100.setTag(R.id.o_dialog_anim_in, r117);
    L18:
        Function1<com.obric.oui.animation.easy.a, Unit> r118 = new DialogAnimStyle$dialogBottomShow$1(r113, r114, r111);
        Intrinsics.checkNotNullParameter(r118, "config");
        r117.a(jla.b.f499571m, 0.0f, r118);
        if (r101 == null) goto L26;
        if (r102 == false) goto L26;
        r101.addFlags(2);     // Catch: Exception -> L24
        final float r119 = r111;
        jla.b.j r120 = new b(r101, r119, r103);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r120, "listener");     // Catch: Exception -> L24
        r117.f398744g = r120;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage());
    L26:
        return r117;
    L13:
        if ((r116 instanceof com.obric.oui.animation.easy.b) == false) goto L15;
        r107 = r116;
        goto L15
    L8:
        r109 = 0;
        goto L9
    }
}
