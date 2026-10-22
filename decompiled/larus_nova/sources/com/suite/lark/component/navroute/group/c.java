package com.suite.lark.component.navroute.group;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f460382a;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((com.suite.lark.component.navroute.a) r100).f460218f.getPriority(), ((com.suite.lark.component.navroute.a) r101).f460218f.getPriority());
        }
    }

    static {
    }

    public c() {
        this.f460382a = new e();
    }

    public final com.suite.lark.component.navroute.a a(String r100, com.suite.lark.component.navroute.a r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r101, "excludeController");
        List r102 = CollectionsKt.sortedWith(this.f460382a.a(), new b());
        ListIterator r103 = r102.listIterator(r102.size());
    L4:
        if (r103.hasPrevious() == false) goto L13;
        Object r104 = r103.previous();
        com.suite.lark.component.navroute.a r105 = (com.suite.lark.component.navroute.a) r104;
        if (Intrinsics.areEqual(r105, r101) == false) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L4;
    L15:
        return (com.suite.lark.component.navroute.a) r104;
    L8:
        if (r105.b().a(r100) == null) goto L10;
        r106 = true;
        goto L11
    L13:
        r104 = null;
        goto L15
    }
}
