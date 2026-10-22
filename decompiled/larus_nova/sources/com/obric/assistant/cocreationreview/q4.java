package com.obric.assistant.cocreationreview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<e4> f387671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f387672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f387673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, String> f387674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<String> f387675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f387676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f387677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CocreationTaskFilter f387678h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f387679a = null;

        static {
            int[] r100 = new int[CocreationTaskFilter.values().length];
            r100[CocreationTaskFilter.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CocreationTaskFilter.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CocreationTaskFilter.RUN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f387679a = r100;
        }
    }

    public q4() {
        this.f387671a = CollectionsKt.emptyList();
        this.f387674d = new LinkedHashMap();
        this.f387675e = new LinkedHashSet();
        this.f387678h = CocreationTaskFilter.ALL;
    }

    public final void a(List<e4> r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "recommendations");
        Intrinsics.checkNotNullParameter(r101, "persistedRunIds");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        e4 r105 = (e4) r104;
        boolean r106 = true;
        if ((!StringsKt.isBlank(r105.f387269a)) == true) goto L8;
    L10:
        r106 = false;
    L11:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r105.f387270b)) == false) goto L10;
    L13:
        HashSet r107 = new HashSet();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r102.iterator();
    L15:
        if (r109.hasNext() == false) goto L19;
        Object r110 = r109.next();
        if (r107.add(((e4) r110).f387269a) == false) goto L15;
        r108.add(r110);
        goto L15
    L19:
        this.f387671a = r108;
        HashSet r111 = new HashSet();
        Iterator r112 = r108.iterator();
    L21:
        if (r112.hasNext() == false) goto L23;
        r111.add(((e4) r112.next()).f387269a);
        goto L21
    L23:
        this.f387674d.keySet().retainAll(r111);
        this.f387675e.clear();
        this.f387675e.addAll(CollectionsKt.intersect(r101, r111));
        if (CollectionsKt.contains(r111, this.f387676f) == true) goto L38;
        this.f387676f = null;
        return;
    }
}
