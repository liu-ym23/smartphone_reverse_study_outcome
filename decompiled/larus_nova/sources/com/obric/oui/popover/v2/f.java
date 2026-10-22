package com.obric.oui.popover.v2;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f402406a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f402407a;

        public a(float r100) {
            this.f402407a = r100;
        }
    }

    public static final class b extends jla.c<View> {
        public b() {
        }

        @Override // jla.c
        public final float a(View r100) {
            View r101 = r100;
            if (r101 == null) goto L17;
            b r102 = f.f402406a;
            Object r103 = r101.getTag(R.id.o_popover_anim_p);
            if (r103 == null) goto L17;
            int r104 = vma.c.f556351a;
            Float r105 = null;
            if ((r103 instanceof a) == true) goto L12;
            r103 = null;
        L12:
            a r106 = (a) r103;
            if (r106 == null) goto L16;
            r105 = Float.valueOf(r106.f402407a);
        L16:
            if (r105 == null) goto L17;
            return r105.floatValue();
        L17:
            return 0.0f;
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            View r102 = r100;
            if (r102 == null) goto L17;
            b r103 = f.f402406a;
            Object r104 = r102.getTag(R.id.o_popover_anim_p);
            if (r104 == null) goto L18;
            int r105 = vma.c.f556351a;
            if ((r104 instanceof a) == true) goto L12;
            r104 = null;
        L12:
            a r106 = (a) r104;
            if (r106 == null) goto L19;
            r106.f402407a = r101;
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    static {
        f402406a = new b();
    }

    public static void a(OPopoverBase r110, boolean r111, final float r112, final float r113) {
        Intrinsics.checkNotNullParameter(r110, "popover");
        final ViewGroup r100 = r110.getPopoverWindowFrame();
        final View r101 = r110.getPopoverBubbleLayout().getChildAt(0);
        if (r111 == false) goto L5;
        float r114 = 0.8f;
    L7:
        if (r111 == false) goto L9;
        final float r102 = 0.0f;
    L10:
        if (r111 == false) goto L12;
        final float r103 = 10000.0f;
    L13:
        final float r104 = r100.getScaleX();
        final float r105 = r101.getAlpha();
        com.obric.oui.animation.easy.b r115 = com.obric.oui.animation.easy.f.a(r100);
        r115.f398741d = r114;
        r115.f398742e = 439.0f;
        com.obric.oui.animation.easy.b.b(r115, r103);
        jla.b.j r116 = new d(r100, r102, r103, r104, r113, r101, r105, r112);
        Intrinsics.checkNotNullParameter(r116, "listener");
        r115.f398744g = r116;
        r115.e();
        return;
    L12:
        r103 = 0.0f;
        goto L13
    L9:
        r102 = 10000.0f;
        goto L10
    L5:
        r114 = 1.0f;
        goto L7
    }
}
