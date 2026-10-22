package com.obric.oui.texteffects.runtime;

import android.util.LruCache;
import android.view.animation.PathInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.texteffects.core.EffectProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import qma.g;
import qma.i;
import qma.j;
import qma.k;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<qma.a.b, PathInterpolator> f403340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<qma.a.C7361a, com.obric.oui.texteffects.runtime.a> f403341b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f403342a = null;

        static {
            int[] r100 = new int[EffectProperty.values().length];
            r100[EffectProperty.Alpha.ordinal()] = 1;
            r100[EffectProperty.Tracking.ordinal()] = 2;
            r100[EffectProperty.GradientAlphaScan.ordinal()] = 3;
            r100[EffectProperty.Visibility.ordinal()] = 4;
            r100[EffectProperty.BlurRadius.ordinal()] = 5;
            r100[EffectProperty.TranslationX.ordinal()] = 6;
            r100[EffectProperty.TranslationY.ordinal()] = 7;
            f403342a = r100;
        }
    }

    static {
        f403340a = new LruCache(16);
        f403341b = new LruCache(16);
    }

    public static boolean c(qma.d r100) {
        if ((r100 instanceof qma.d.b) == false) goto L5;
    L16:
        return true;
    L5:
        if ((r100 instanceof qma.d.a) == true) goto L16;
        if ((r100 instanceof qma.d.e) == true) goto L16;
        if ((r100 instanceof qma.d.C7363d) == true) goto L16;
        if ((r100 instanceof qma.d.f) == true) goto L16;
        if ((r100 instanceof qma.d.c) == true) goto L16;
        return false;
    }

    public static float a(qma.a r100, float r101) {
        if (Intrinsics.areEqual(r100, qma.a.c.f533932a) == false) goto L6;
        return r101;
    L6:
        if ((r100 instanceof qma.a.b) == false) goto L12;
        qma.a.b r102 = (qma.a.b) r100;
        LruCache<qma.a.b, PathInterpolator> r103 = f403340a;
        PathInterpolator r104 = r103.get(r102);
        if (r104 != null) goto L20;
        r104 = new PathInterpolator(r102.f533928a, r102.f533929b, r102.f533930c, r102.f533931d);
        r103.put(r102, r104);
    L20:
        return r104.getInterpolation(r101);
    L12:
        if ((r100 instanceof qma.a.C7361a) == false) goto L19;
        qma.a.C7361a r105 = (qma.a.C7361a) r100;
        LruCache<qma.a.C7361a, com.obric.oui.texteffects.runtime.a> r106 = f403341b;
        com.obric.oui.texteffects.runtime.a r107 = r106.get(r105);
        if (r107 != null) goto L17;
        r107 = new com.obric.oui.texteffects.runtime.a(r105.f533925a, r105.f533926b, r105.f533927c);
        r106.put(r105, r107);
    L17:
        return r107.getInterpolation(r101);
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static float b(qma.d r100, float r101) {
        if ((r100 instanceof qma.d.b) == false) goto L6;
        return ((qma.d.b) r100).f533947a;
    L6:
        if ((r100 instanceof qma.d.a) == true) goto L8;
        return r101;
    L8:
        return ((qma.d.a) r100).f533946a;
    }

    public static int d(List r100, long r101) {
        int r102 = CollectionsKt.getLastIndex(r100);
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L10;
        int r104 = (r103 + r102) >>> 1;
        if (((qma.f) ListProtector.get(r100, r104)).f533957a >= r101) goto L7;
        r103 = r104 + 1;
        goto L4
    L7:
        r102 = r104;
        goto L4
    L10:
        return RangesKt.coerceAtLeast(r103, 1);
    }

    public static e e(k r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, "spec");
        long r100 = RangesKt.coerceAtLeast(r210.f533973c, 1);
        g r101 = r210.f533974d;
        long r102 = 0;
        int r110 = 0;
        if (Intrinsics.areEqual(r101, g.b.f533959a) == false) goto L8;
        long r103 = r211 % r100;
        if (r103 >= 0) goto L18;
    L6:
        r103 = r103 + r100;
    L18:
        long r104 = r103;
    L19:
        Iterator<T> r105 = r210.f533975e.iterator();
        if (r105.hasNext() == true) goto L22;
        Integer r106 = null;
    L28:
        if (r106 == null) goto L31;
        r110 = r106.intValue();
    L31:
        ArrayList r107 = new ArrayList(r110);
        Iterator<T> r108 = r210.f533975e.iterator();
    L33:
        if (r108.hasNext() == false) goto L68;
        qma.c r109 = (qma.c) r108.next();
        long r111 = r104 - r109.f533943b;
        if (r111 < r102) goto L67;
        if (r111 > r109.f533944c) goto L67;
        Iterator<T> r112 = r109.f533945d.iterator();
    L41:
        if (r112.hasNext() == false) goto L33;
        qma.b r113 = (qma.b) r112.next();
        String r114 = r109.f533942a;
        Iterator<T> r115 = r113.b().iterator();
        float r116 = Float.NaN;
        float r212 = Float.NaN;
        float r213 = Float.NaN;
        j.b r214 = null;
        float r215 = Float.NaN;
        qma.d r216 = null;
        qma.d r217 = null;
        qma.d r218 = null;
    L44:
        if (r115.hasNext() == false) goto L59;
        i r117 = (i) r115.next();
        EffectProperty r118 = r117.f533962a;
        switch(a.f403342a[r118.ordinal()]) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L48;
            default: goto L44;
        };
    L52:
        r212 = g(r117, r111);
        j r119 = r117.f533965d;
        if ((r119 instanceof j.b) == false) goto L55;
        r214 = (j.b) r119;
        goto L44
    L55:
        r214 = null;
        goto L44
    L48:
        r218 = f(r117, r111);
        goto L44
    L49:
        r217 = f(r117, r111);
        goto L44
    L50:
        r216 = f(r117, r111);
        goto L44
    L51:
        r215 = g(r117, r111);
        goto L44
    L56:
        r213 = g(r117, r111);
        goto L44
    L57:
        r116 = g(r117, r111);
        goto L44
    L59:
        String r120 = r113.a();
        if ((r113 instanceof qma.b.a) == false) goto L62;
        qma.b.a r121 = (qma.b.a) r113;
    L63:
        if (r121 != null) goto L65;
        String r122 = null;
    L66:
        r107.add(new d(r114, r120, r122, r111, r116, r212, r213, r214, r215, r216, r217, r218));
        r102 = 0;
        goto L41
    L65:
        r122 = r121.f533934b;
        goto L66
    L62:
        r121 = null;
    L67:
        r102 = 0;
        goto L33
    L68:
        int r123 = com.obric.oui.texteffects.f.f403310a;
        return new e(r211, r104, r107);
    L22:
        r106 = Integer.valueOf(((qma.c) r105.next()).f533945d.size());
    L24:
        if (r105.hasNext() == false) goto L28;
        Integer r124 = Integer.valueOf(((qma.c) r105.next()).f533945d.size());
        if (r106.compareTo(r124) >= 0) goto L24;
        r106 = r124;
        goto L24
    L8:
        if ((r101 instanceof g.a) == false) goto L16;
        ((g.a) r210.f533974d).getClass();
        if (r211 < (((long) RangesKt.coerceAtLeast(0, 1)) * r100)) goto L12;
        r104 = r100;
        goto L19
    L12:
        r103 = RangesKt.coerceAtLeast(r211, 0) % r100;
        if (r103 >= 0) goto L18;
    L16:
        if (Intrinsics.areEqual(r101, g.c.f533960a) == false) goto L71;
        r103 = RangesKt.coerceIn(r211, 0, r100);
        goto L18
    L71:
        throw new NoWhenBranchMatchedException();
    }

    public static qma.d f(i r100, long r101) {
        List<qma.f> r102 = r100.f533963b;
        if (r102.isEmpty() == false) goto L7;
        return new qma.d.b(0.0f);
    L7:
        if (r101 > ((qma.f) CollectionsKt.first(r102)).f533957a) goto L11;
        return ((qma.f) CollectionsKt.first(r102)).f533958b;
    L11:
        if (r101 >= ((qma.f) CollectionsKt.last(r102)).f533957a) goto L13;
        int r103 = d(r102, r101);
        qma.f r104 = (qma.f) ListProtector.get(r102, r103 - 1);
        qma.f r105 = (qma.f) ListProtector.get(r102, r103);
        float r106 = a(r100.f533964c, RangesKt.coerceIn((r101 - r104.f533957a) / RangesKt.coerceAtLeast(r105.f533957a - r104.f533957a, 1), 0.0f, 1.0f));
        qma.d r107 = r104.f533958b;
        qma.d r108 = r105.f533958b;
        if ((r107 instanceof qma.d.b) == false) goto L21;
        if ((r108 instanceof qma.d.b) == false) goto L21;
        float r109 = ((qma.d.b) r107).f533947a;
        qma.d r110 = new qma.d.b(r109 + ((((qma.d.b) r108).f533947a - r109) * r106));
    L35:
        return r110;
    L21:
        if ((r107 instanceof qma.d.a) == false) goto L26;
        if ((r108 instanceof qma.d.a) == false) goto L26;
        float r111 = ((qma.d.a) r107).f533946a;
        r110 = new qma.d.a(r111 + ((((qma.d.a) r108).f533946a - r111) * r106));
    L26:
        if (c(r107) == false) goto L31;
        if (c(r108) == false) goto L31;
        r110 = new qma.d.c(r107, r108, r106);
    L31:
        if (r106 >= 1.0f) goto L34;
        return r107;
    L34:
        return r108;
    L13:
        return ((qma.f) CollectionsKt.last(r102)).f533958b;
    }

    public static float g(i r100, long r101) {
        List<qma.f> r102 = r100.f533963b;
        if (r102.isEmpty() == false) goto L6;
        return 0.0f;
    L6:
        if (r101 > ((qma.f) CollectionsKt.first(r102)).f533957a) goto L10;
        return b(((qma.f) CollectionsKt.first(r102)).f533958b, 0.0f);
    L10:
        if (r101 >= ((qma.f) CollectionsKt.last(r102)).f533957a) goto L12;
        int r103 = d(r102, r101);
        qma.f r104 = (qma.f) ListProtector.get(r102, r103 - 1);
        qma.f r105 = (qma.f) ListProtector.get(r102, r103);
        float r106 = a(r100.f533964c, RangesKt.coerceIn((r101 - r104.f533957a) / RangesKt.coerceAtLeast(r105.f533957a - r104.f533957a, 1), 0.0f, 1.0f));
        float r107 = b(r104.f533958b, 0.0f);
        return r107 + ((b(r105.f533958b, b(r104.f533958b, 0.0f)) - r107) * r106);
    L12:
        return b(((qma.f) CollectionsKt.last(r102)).f533958b, 0.0f);
    }
}
