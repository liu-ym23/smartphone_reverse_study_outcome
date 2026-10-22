package com.ss.android.lark.ug.business.badge;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.pb.ug_reach.BadgeMaterial;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f444424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, k> f444425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f444426c;

    public final synchronized void c() {
        monitor-enter(this);
        this.f444424a.f444428b = b(this.f444424a);     // Catch: Throwable -> L8
        l r100 = this.f444426c;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.onUpdate();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void a() {
        LinkedList r100 = new LinkedList();
        r100.offer(this.f444424a);
    L4:
        if ((!r100.isEmpty()) == false) goto L11;
        k r101 = (k) r100.poll();
        if (r101 == null) goto L4;
        this.f444425b.put(r101.f444427a, r101);
        Iterator<T> r102 = r101.f444429c.iterator();
    L9:
        if (r102.hasNext() == false) goto L4;
        r100.offer((k) r102.next());
        goto L9
    }

    public j() {
        this.f444424a = new k(NodeType.SETTING.getKey());
        this.f444425b = new LinkedHashMap();
    }

    public static a b(k r100) {
        if ((!((CopyOnWriteArrayList) r100.f444429c).isEmpty()) == false) goto L5;
        a r101 = null;
    L6:
        Iterator r102 = ((CopyOnWriteArrayList) r100.f444429c).iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        k r103 = (k) r102.next();
        a r104 = b(r103);
        r103.f444428b = r104;
        if (r101 != null) goto L13;
        if (r104 != null) goto L13;
    L17:
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        r101 = r101.a(r104);
        goto L8
    L15:
        if (r104 == null) goto L17;
        r101 = r104.a(r101);
        goto L8
    L18:
        return r101;
    L5:
        r101 = r100.f444428b;
        goto L6
    }

    @Override // com.ss.android.lark.ug.business.badge.m
    public synchronized void update(Map<String, ? extends List<BadgeMaterial>> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "dataMap");     // Catch: Throwable -> L17
        Iterator<Map.Entry<String, ? extends List<BadgeMaterial>>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L17
    L5:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, ? extends List<BadgeMaterial>> r102 = r101.next();     // Catch: Throwable -> L17
        k r103 = (k) ((LinkedHashMap) this.f444425b).get(r102.getKey());     // Catch: Throwable -> L17
        List<BadgeMaterial> r104 = r102.getValue();     // Catch: Throwable -> L17
        if (r103 == null) goto L5;
        if ((!r104.isEmpty()) == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L5;
        r103.f444428b = new a(1, (BadgeMaterial) ListProtector.get(r104, 0));     // Catch: Throwable -> L17
        goto L5
    L14:
        c();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
