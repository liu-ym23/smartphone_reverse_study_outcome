package com.bytedance.live.layout;

import android.graphics.RectF;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LayoutContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdjustBase f255174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutScale f255175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutAlign f255176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f255177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f255178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f255179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f255180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LayoutStrategy f255181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f255182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f255183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f255184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f255185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f255186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f255187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f255188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f255189p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f255190q;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f255191a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f255192b = null;

        static {
            int[] r100 = new int[LayoutAlign.values().length];
            r100[LayoutAlign.LEFT_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L58:
            r100[LayoutAlign.CENTER_BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L68:
            r100[LayoutAlign.RIGHT_BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L42:
            r100[LayoutAlign.LEFT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L44:
            r100[LayoutAlign.CENTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L56:
            r100[LayoutAlign.RIGHT_CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L66:
            r100[LayoutAlign.LEFT_TOP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L50:
            r100[LayoutAlign.CENTER_TOP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L60:
            r100[LayoutAlign.RIGHT_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L62:
            r100[LayoutAlign.NONE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L17:
            f255191a = r100;
            int[] r101 = new int[LayoutScale.values().length];
            r101[LayoutScale.FIT_WIDTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L54:
            r101[LayoutScale.FIT_HEIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L64:
            r101[LayoutScale.ASPECT_FILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L40:
            r101[LayoutScale.ASPECT_FIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L46:
            r101[LayoutScale.FILL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L23:
            f255192b = r101;
        }
    }

    public LayoutContext(c r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        this.f255174a = r100.f255198a;
        this.f255175b = r100.f255199b;
        this.f255176c = r100.f255200c;
        this.f255177d = r100.f255201d;
        this.f255178e = r100.f255202e;
        this.f255179f = r100.f255203f;
        this.f255180g = r100.f255204g;
        this.f255181h = r100.f255205h;
        this.f255182i = r100.f255206i;
        this.f255183j = r100.f255209l;
        this.f255184k = LazyKt.lazy(new LayoutContext$containerRatioWH$2(this));
        this.f255185l = r100.f255207j;
        this.f255186m = r100.f255208k;
        this.f255187n = LazyKt.lazy(new LayoutContext$target$2(this));
        this.f255188o = LazyKt.lazy(new LayoutContext$targetRatioWH$2(this));
        this.f255189p = LazyKt.lazy(new LayoutContext$contentWHRatio$2(this));
        this.f255190q = LazyKt.lazy(new LayoutContext$baseWHRatio$2(this));
    }
}
