package com.bytedance.live.livelink.kmp.impl.core.video.pipeline;

import com.bytedance.live.livelink.kmp.api.base.video.NodeType;
import com.bytedance.live.livelink.kmp.api.base.video.Status;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import ej6.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qi6.f;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<yi6.a> f255487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<yi6.b> f255488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f255489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Status f255490d;

    public final void j() {
        this.f255490d = Status.UNDEFINED;
        Iterator<T> r100 = this.f255489c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((f) r100.next()).release();
        goto L4
    L6:
        this.f255487a.clear();
        this.f255488b.clear();
        this.f255489c.clear();
    }

    public c() {
        this.f255487a = new LinkedHashSet();
        this.f255488b = new LinkedHashSet();
        this.f255489c = new CopyOnWriteArraySet();
        this.f255490d = Status.UNDEFINED;
    }

    public final f b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Iterator<T> r101 = this.f255489c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((f) r102).getName(), r100) == false) goto L4;
    L10:
        return (f) r102;
    L8:
        r102 = null;
        goto L10
    }

    public final void c(f r100) {
        NodeType r101 = r100.getType();
        int r102 = b.f255485c[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f255487a.add((yi6.a) r100);
        this.f255489c.add(r100);
        return;
    L5:
        if (r102 == 2) goto L7;
        this.f255489c.add(r100);
        return;
    L7:
        this.f255488b.add((yi6.b) r100);
        this.f255489c.add(r100);
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pipeLineName");
        LinkedHashSet r101 = new LinkedHashSet();
        StringBuilder r102 = new StringBuilder(this.f255489c.size() + " Relations: ");
        Iterator<f> r103 = this.f255489c.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        f r104 = r103.next();
        if (r101.contains(r104) == true) goto L4;
        r102.append(f(r104, r101, ""));
        goto L4
    L8:
        int r105 = ej6.a.f472874a;
        ej6.a.c(r100, String.valueOf(r102));
        int r106 = e.f472877a;
        e.a(TraceEvent.VIDEO_MANAGER, r100, 0, r102.toString(), null, 20);
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pipeLineName");
        LinkedHashSet r101 = new LinkedHashSet();
        StringBuilder r102 = new StringBuilder(this.f255489c.size() + " RelationsReverse: ");
        Iterator r103 = CollectionsKt.reversed(this.f255489c).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        f r104 = (f) r103.next();
        if (r101.contains(r104) == true) goto L4;
        r102.append(g(r104, r101, ""));
        goto L4
    L8:
        int r105 = ej6.a.f472874a;
        ej6.a.c(r100, String.valueOf(r102.toString()));
        int r106 = e.f472877a;
        e.a(TraceEvent.VIDEO_MANAGER, r100, 0, r102.toString(), null, 20);
    }

    public static void a(f r100, f r101) {
        r100.k().remove(r101);
        r101.j().remove(r100);
    }

    public static void e(f r100, f r101) {
        r100.k().add(r101);
        r101.j().add(r100);
    }

    public static String f(f r100, Set r101, String r102) {
        boolean r103 = true;
        if (r101.contains(r100) == false) goto L14;
        Iterator<T> r104 = r100.j().iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        f r106 = (f) r105;
        if ((!r101.contains(r100)) == false) goto L6;
    L11:
        if (r105 == null) goto L14;
        return "";
    L10:
        r105 = null;
    L14:
        r101.add(r100);
        if (r102.length() == 0) goto L18;
        r103 = false;
    L18:
        if (r103 == false) goto L20;
        String r107 = r100.getName();
    L22:
        if (r100.k().isEmpty() == true) goto L24;
        StringBuilder r108 = new StringBuilder();
        Iterator<f> r109 = r100.k().iterator();
    L27:
        if (r109.hasNext() == false) goto L30;
        r108.append(f(r109.next(), r101, r107));
        goto L27
    L30:
        return r108.toString();
    L24:
        return "< " + r107 + " > ";
    L20:
        r107 = r102 + " -> " + r100.getName();
        goto L22
    }

    public static String g(f r100, Set r101, String r102) {
        boolean r103 = true;
        if (r101.contains(r100) == false) goto L14;
        Iterator<T> r104 = r100.k().iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        f r106 = (f) r105;
        if ((!r101.contains(r100)) == false) goto L6;
    L11:
        if (r105 == null) goto L14;
        return "";
    L10:
        r105 = null;
    L14:
        r101.add(r100);
        if (r102.length() == 0) goto L18;
        r103 = false;
    L18:
        if (r103 == false) goto L20;
        String r107 = r100.getName();
    L22:
        if (r100.j().isEmpty() == true) goto L24;
        StringBuilder r108 = new StringBuilder();
        Iterator<f> r109 = r100.j().iterator();
    L27:
        if (r109.hasNext() == false) goto L30;
        r108.append(g(r109.next(), r101, r107));
        goto L27
    L30:
        return r108.toString();
    L24:
        return "< " + r107 + " > ";
    L20:
        r107 = r100.getName() + " -> " + r102;
        goto L22
    }

    public final void d(f r100, List<f> r101, List<f> r102) {
        Intrinsics.checkNotNullParameter(r100, "insertNode");
        Intrinsics.checkNotNullParameter(r101, "preNodes");
        Intrinsics.checkNotNullParameter(r102, "nextNodes");
        c(r100);
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        f r104 = (f) r103.next();
        Iterator<T> r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        a(r104, (f) r105.next());
        goto L7
    L9:
        Iterator<T> r106 = r101.iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        f r107 = (f) r106.next();
        if (this.f255489c.contains(r107) == false) goto L11;
        e(r107, r100);
        goto L11
    L15:
        Iterator<T> r108 = r102.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        f r109 = (f) r108.next();
        if (this.f255489c.contains(r109) == false) goto L17;
        e(r100, r109);
        goto L17
    }
}
