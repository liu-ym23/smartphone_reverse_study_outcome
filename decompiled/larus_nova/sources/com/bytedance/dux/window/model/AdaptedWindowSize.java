package com.bytedance.dux.window.model;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.dux.window.inner_split.SplitHelper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import hm4.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class AdaptedWindowSize implements jm4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AdaptedWindowSize f205949b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f205950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f205951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static hm4.a f205952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<Integer> f205953f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<jm4.b> f205954g = null;

    public AdaptedWindowSize() {
    }

    static {
        f205949b = new AdaptedWindowSize();
        jm4.a.f499636a.getClass();
        f205950c = jm4.a.C6460a.f499638b;
        f205951d = 1;
        f205952e = new hm4.a(0.0f, 0.0f);
        f205953f = new LinkedHashSet();
        f205954g = new CopyOnWriteArrayList();
    }

    public final boolean a(Set<Integer> r100, int r101, Pair<Integer, Integer> r102) {
        if (r100.contains(Integer.valueOf(r101)) == true) goto L24;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(Integer.valueOf((((Number) r104.next()).intValue() - r102.getSecond().intValue()) - r102.getFirst().intValue()));
        goto L6
    L9:
        if (r103.contains(Integer.valueOf(r101)) == true) goto L24;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r106 = r100.iterator();
    L12:
        if (r106.hasNext() == false) goto L15;
        r105.add(Integer.valueOf(((Number) r106.next()).intValue() - r102.getSecond().intValue()));
        goto L12
    L15:
        if (r105.contains(Integer.valueOf(r101)) == true) goto L24;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r108 = r100.iterator();
    L18:
        if (r108.hasNext() == false) goto L21;
        r107.add(Integer.valueOf(((Number) r108.next()).intValue() - r102.getFirst().intValue()));
        goto L18
    L21:
        if (r107.contains(Integer.valueOf(r101)) == true) goto L24;
        return false;
    L24:
        return true;
    }

    public final b b(final Activity r100, int r101, int r102) {
        if (r100 == null) goto L63;
        Resources r103 = Resources.getSystem();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        final float r105 = r101 / r104;
        final float r106 = r102 / r104;
        Lazy r107 = SplitHelper.f205938a;
        SplitHelper.a(r100, new AdaptedWindowSize$setCurrentWindowSize$1$1(r105, r106));
        hm4.a r108 = new hm4.a(r105, r106);
        Intrinsics.checkNotNullParameter(r108, "pageSize");
        ((ConcurrentHashMap) SplitHelper.f205940c.getValue()).put(Integer.valueOf(SplitHelper.d(r100)), r108);
        final b r109 = b.f485918c;
        float r110 = r109.f485928a;
        if (r105 >= r110) goto L7;
        jm4.a.f499636a.getClass();
        r109 = jm4.a.C6460a.f499638b;
    L52:
        Intrinsics.checkNotNullParameter(r109, "windowSizeClass");
        ((ConcurrentHashMap) SplitHelper.f205938a.getValue()).put(Integer.valueOf(SplitHelper.d(r100)), r109);
        if (Intrinsics.areEqual(f205950c, r109) == true) goto L57;
        jm4.a.f499636a.getClass();
        if (Intrinsics.areEqual(r109, jm4.a.C6460a.f499638b) == true) goto L57;
    L58:
        SplitHelper.a(r100, new AdaptedWindowSize$setCurrentWindowSize$1$2(r109, r100));
        Objects.toString(f205950c);
        if (Build.VERSION.SDK_INT < 24) goto L63;
        r100.isInMultiWindowMode();
    L57:
        if (f205951d == r100.getResources().getConfiguration().orientation) goto L63;
    L7:
        if (r105 >= r110) goto L9;
    L11:
        r109 = b.f485919d;
        if (r105 >= r109.f485928a) goto L14;
    L16:
        r109 = b.f485920e;
        if (r105 >= r109.f485928a) goto L19;
    L21:
        r109 = b.f485921f;
        if (r105 >= r109.f485928a) goto L24;
    L26:
        r109 = b.f485922g;
        if (r105 >= r109.f485928a) goto L29;
    L31:
        r109 = b.f485923h;
        if (r105 >= r109.f485928a) goto L34;
    L36:
        r109 = b.f485924i;
        if (r105 >= r109.f485928a) goto L39;
    L41:
        r109 = b.f485925j;
        if (r105 >= r109.f485928a) goto L44;
    L46:
        r109 = b.f485926k;
        if (r105 >= r109.f485928a) goto L49;
    L51:
        r109 = b.f485927l;
        goto L52
    L49:
        if (r105 >= b.f485927l.f485928a) goto L51;
    L44:
        if (r105 >= b.f485926k.f485928a) goto L46;
    L39:
        if (r105 >= b.f485925j.f485928a) goto L41;
    L34:
        if (r105 >= b.f485924i.f485928a) goto L36;
    L29:
        if (r105 >= b.f485923h.f485928a) goto L31;
    L24:
        if (r105 >= b.f485922g.f485928a) goto L26;
    L19:
        if (r105 >= b.f485921f.f485928a) goto L21;
    L14:
        if (r105 >= b.f485920e.f485928a) goto L16;
    L9:
        if (r105 >= b.f485919d.f485928a) goto L11;
    L63:
        return f205950c;
    }
}
