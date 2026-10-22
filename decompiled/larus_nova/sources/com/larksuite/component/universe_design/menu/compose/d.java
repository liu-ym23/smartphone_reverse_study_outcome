package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.menu.PositionAlign;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDMenuGravity f285120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PositionAlign f285121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f285122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f285123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f285124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f285125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f285126g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285127a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f285128b = null;

        static {
            int[] r100 = new int[UDMenuGravity.values().length];
            r100[UDMenuGravity.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[UDMenuGravity.Start.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[UDMenuGravity.End.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[UDMenuGravity.Bottom.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f285127a = r100;
            int[] r101 = new int[PositionAlign.values().length];
            r101[PositionAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[PositionAlign.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[PositionAlign.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f285128b = r101;
        }
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo340calculatePositionllwVHH4(IntRect r110, long r111, LayoutDirection r210, long r211) {
        Intrinsics.checkNotNullParameter(r110, "anchorBounds");
        Intrinsics.checkNotNullParameter(r210, "layoutDirection");
        int r100 = RangesKt.coerceAtLeast((((int) (r211 >> 32)) - this.f285123d) - this.f285125f, 0);
        int r101 = RangesKt.coerceAtLeast((((int) (r211 & BodyPartID.bodyIdMax)) - this.f285124e) - this.f285126g, 0);
        long r102 = IntSize.m7714constructorimpl((((long) r100) << 32) | (((long) r101) & BodyPartID.bodyIdMax));
        UDMenuGravity r103 = this.f285120a;
        int[] r104 = a.f285127a;
        int r105 = r104[r103.ordinal()];
        if (r105 == 1) goto L12;
        if (r105 == 2) goto L11;
        if (r105 == 3) goto L10;
        if (r105 != 4) goto L9;
        int r106 = r110.getLeft() + ((r110.getWidth() - ((int) (r102 >> 32))) / 2);
        long r112 = ((long) (r110.getBottom() + this.f285122c)) & BodyPartID.bodyIdMax;
        long r113 = IntOffset.m7670constructorimpl(r112 | (((long) r106) << 32));
    L13:
        int r107 = IntOffset.m7676getXimpl(r113);
        int r114 = IntOffset.m7677getYimpl(r113);
        int r108 = r104[this.f285120a.ordinal()];
        if (r108 != 1) goto L16;
    L38:
        PositionAlign r109 = this.f285121b;
        int r115 = a.f285128b[r109.ordinal()];
        if (r115 == 1) goto L46;
        if (r115 != 2) goto L42;
    L47:
        r107 = RangesKt.coerceIn(r107, 0, ((int) (r111 >> 32)) - ((int) (r102 >> 32)));
        if (r114 < 0) goto L52;
        if ((((int) (r102 & BodyPartID.bodyIdMax)) + r114) > ((int) (r111 & BodyPartID.bodyIdMax))) goto L52;
    L59:
        long r116 = IntOffset.m7670constructorimpl((((long) r107) << 32) | (((long) r114) & BodyPartID.bodyIdMax));
        int r117 = IntOffset.m7676getXimpl(r116) - this.f285123d;
        int r118 = IntOffset.m7677getYimpl(r116) - this.f285124e;
        long r119 = ((long) r118) & BodyPartID.bodyIdMax;
        return IntOffset.m7670constructorimpl(r119 | (((long) r117) << 32));
    L52:
        if (this.f285120a != UDMenuGravity.Bottom) goto L54;
        int r120 = (r110.getTop() - this.f285122c) - ((int) (r102 & BodyPartID.bodyIdMax));
    L55:
        if (r120 < 0) goto L59;
        if ((((int) (r102 & BodyPartID.bodyIdMax)) + r120) > ((int) (r111 & BodyPartID.bodyIdMax))) goto L59;
        r114 = r120;
        goto L59
    L54:
        r120 = r110.getBottom() + this.f285122c;
        goto L55
    L42:
        if (r115 != 3) goto L45;
        r107 = r110.getRight() - ((int) (r102 >> 32));
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();
    L46:
        r107 = r110.getLeft();
        goto L47
    L16:
        if (r108 == 4) goto L38;
        PositionAlign r121 = this.f285121b;
        int r122 = a.f285128b[r121.ordinal()];
        if (r122 == 1) goto L25;
        if (r122 != 2) goto L21;
    L26:
        r114 = RangesKt.coerceIn(r114, 0, ((int) (r111 & BodyPartID.bodyIdMax)) - ((int) (r102 & BodyPartID.bodyIdMax)));
        if (r107 < 0) goto L31;
        if ((((int) (r102 >> 32)) + r107) <= ((int) (r111 >> 32))) goto L59;
    L31:
        if (this.f285120a != UDMenuGravity.End) goto L33;
        int r123 = (r110.getLeft() - this.f285122c) - ((int) (r102 >> 32));
    L34:
        if (r123 < 0) goto L59;
        if ((((int) (r102 >> 32)) + r123) > ((int) (r111 >> 32))) goto L59;
        r107 = r123;
        goto L59
    L33:
        r123 = r110.getRight() + this.f285122c;
        goto L34
    L21:
        if (r122 != 3) goto L24;
        r114 = r110.getBottom() - ((int) (r102 & BodyPartID.bodyIdMax));
        goto L26
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r114 = r110.getTop();
        goto L26
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        int r124 = r110.getRight() + this.f285122c;
        int r125 = r110.getTop() + ((r110.getHeight() - ((int) (r102 & BodyPartID.bodyIdMax))) / 2);
        long r126 = ((long) r125) & BodyPartID.bodyIdMax;
        r113 = IntOffset.m7670constructorimpl(r126 | (((long) r124) << 32));
        goto L13
    L11:
        int r127 = (r110.getLeft() - this.f285122c) - ((int) (r102 >> 32));
        int r128 = r110.getTop() + ((r110.getHeight() - ((int) (r102 & BodyPartID.bodyIdMax))) / 2);
        long r129 = ((long) r128) & BodyPartID.bodyIdMax;
        r113 = IntOffset.m7670constructorimpl(r129 | (((long) r127) << 32));
        goto L13
    L12:
        int r130 = r110.getLeft() + ((r110.getWidth() - ((int) (r102 >> 32))) / 2);
        int r131 = (r110.getTop() - this.f285122c) - ((int) (r102 & BodyPartID.bodyIdMax));
        long r132 = ((long) r131) & BodyPartID.bodyIdMax;
        r113 = IntOffset.m7670constructorimpl(r132 | (((long) r130) << 32));
        goto L13
    }

    public d(UDMenuGravity r100, PositionAlign r101, int r102, int r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        Intrinsics.checkNotNullParameter(r101, "align");
        this.f285120a = r100;
        this.f285121b = r101;
        this.f285122c = r102;
        this.f285123d = r103;
        this.f285124e = r104;
        this.f285125f = r105;
        this.f285126g = r106;
    }
}
