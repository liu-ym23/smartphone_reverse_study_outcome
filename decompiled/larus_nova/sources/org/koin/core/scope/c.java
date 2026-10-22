package org.koin.core.scope;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final mwc.c f526154d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mwc.a f526155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<BeanDefinition<?>> f526157c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f526155a, r101.f526155a) == true) goto L12;
        return false;
    L12:
        if (this.f526156b == r101.f526156b) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int r100 = this.f526155a.hashCode() * 31;
        boolean r101 = this.f526156b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "ScopeDefinition(qualifier=" + this.f526155a + ", isRoot=" + this.f526156b + ')';
    }

    static {
        Intrinsics.checkNotNullParameter("-Root-", "name");
        f526154d = new mwc.c("-Root-");
    }

    public c(mwc.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "qualifier");
        this.f526155a = r100;
        this.f526156b = r101;
        this.f526157c = new HashSet();
    }
}
