package ufb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.lark.floating.enums.SidePattern;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements wfb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f549970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f549971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f549972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f549973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f549974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f549975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f549976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f549977h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f549978a = null;

        static {
            int[] r100 = new int[SidePattern.values().length];
            r100[SidePattern.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r100[SidePattern.RESULT_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r100[SidePattern.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r100[SidePattern.RESULT_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r100[SidePattern.TOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r100[SidePattern.RESULT_TOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[SidePattern.BOTTOM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[SidePattern.RESULT_BOTTOM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r100[SidePattern.DEFAULT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r100[SidePattern.AUTO_HORIZONTAL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[SidePattern.RESULT_HORIZONTAL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[SidePattern.AUTO_VERTICAL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r100[SidePattern.RESULT_VERTICAL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            f549978a = r100;
        }
    }

    public d() {
        this.f549976g = new Rect();
        this.f549977h = new Rect();
    }

    public final float b(View r100) {
        return (this.f549971b + r100.getWidth()) + r100.getTranslationX();
    }

    @Override // wfb.d
    public final Animator a(View r100, ViewGroup r101, SidePattern r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "parentView");
        Intrinsics.checkNotNullParameter(r102, "sidePattern");
        r100.getGlobalVisibleRect(this.f549976g);
        r101.getGlobalVisibleRect(this.f549977h);
        Rect r103 = this.f549976g;
        int r104 = r103.left;
        this.f549970a = r104;
        Rect r105 = this.f549977h;
        int r106 = r105.right - r103.right;
        this.f549971b = r106;
        this.f549972c = r103.top - r105.top;
        this.f549973d = r105.bottom - r103.bottom;
        this.f549974e = Math.min(r104, r106);
        this.f549975f = Math.min(this.f549972c, this.f549973d);
        int r107 = a.f549978a[r102.ordinal()];
        String r108 = LiveDegradeFpsAnimator.TRANSLATION_Y;
        switch(r107) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L9;
            case 13: goto L9;
            default: goto L5;
        };
    L9:
        int r109 = this.f549972c;
        int r110 = this.f549973d;
        if (r109 >= r110) goto L13;
        float r111 = -(r109 + r100.getHeight());
        float r112 = r100.getTranslationY();
    L12:
        float r113 = r111 + r112;
    L31:
        if (Intrinsics.areEqual(r108, LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L33;
        float r114 = r100.getTranslationX();
    L34:
        Triple r115 = new Triple(r108, Float.valueOf(r113), Float.valueOf(r114));
        return ObjectAnimator.ofFloat(r100, (String) r115.component1(), new float[]{((Number) r115.component2()).floatValue(), ((Number) r115.component3()).floatValue()}).setDuration(500);
    L33:
        r114 = r100.getTranslationY();
        goto L34
    L13:
        r111 = r110 + r100.getHeight();
        r112 = r100.getTranslationY();
        goto L12
    L14:
        int r116 = this.f549970a;
        if (r116 >= this.f549971b) goto L18;
        float r117 = -(r116 + r100.getWidth());
        float r118 = r100.getTranslationX();
    L17:
        r113 = r117 + r118;
    L25:
        r108 = LiveDegradeFpsAnimator.TRANSLATION_X;
        goto L31
    L18:
        r113 = b(r100);
        goto L25
    L19:
        r113 = b(r100);
        goto L31
    L20:
        r111 = -(this.f549972c + r100.getHeight());
        r112 = r100.getTranslationY();
        goto L12
    L21:
        r113 = b(r100);
        goto L25
    L22:
        r117 = -(this.f549970a + r100.getWidth());
        r118 = r100.getTranslationX();
        goto L17
    L5:
        if (this.f549974e > this.f549975f) goto L26;
        int r119 = this.f549970a;
        if (r119 < this.f549971b) goto L23;
        r113 = b(r100);
        goto L25
    L23:
        r117 = -(r119 + r100.getWidth());
        r118 = r100.getTranslationX();
        goto L17
    L26:
        int r120 = this.f549972c;
        int r121 = this.f549973d;
        if (r120 >= r121) goto L29;
        r111 = -(r120 + r100.getHeight());
        r112 = r100.getTranslationY();
        goto L12
    L29:
        r111 = r121 + r100.getHeight();
        r112 = r100.getTranslationY();
        goto L12
    }
}
