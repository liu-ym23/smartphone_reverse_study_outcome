package org.koin.core.definition;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.scope.Scope;

/* JADX INFO: loaded from: classes42.dex */
public final class BeanDefinition<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mwc.a f526128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<?> f526129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mwc.a f526130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Scope, lwc.a, T> f526131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Kind f526132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends KClass<?>> f526133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f526134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b<T> f526135h;

    public BeanDefinition() {
        throw null;
    }

    public final int hashCode() {
        mwc.a r100 = this.f526130c;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f526129b.hashCode()) * 31) + this.f526128a.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        String r100 = this.f526132e.toString();
        String r101 = "'" + pwc.a.a(this.f526129b) + '\'';
        mwc.a r102 = this.f526130c;
        String r103 = "";
        if (r102 != null) goto L5;
    L4:
        String r104 = "";
    L8:
        mwc.a r105 = this.f526128a;
        mwc.c r106 = org.koin.core.scope.c.f526154d;
        if (Intrinsics.areEqual(r105, org.koin.core.scope.c.f526154d) == false) goto L11;
        String r107 = "";
    L13:
        if ((!this.f526133f.isEmpty()) == false) goto L16;
        r103 = Intrinsics.stringPlus(",binds:", CollectionsKt.joinToString$default(this.f526133f, ",", null, null, 0, null, BeanDefinition$toString$defOtherTypes$typesAsString$1.INSTANCE, 30, null));
    L16:
        return "[" + r100 + ':' + r101 + r104 + r107 + r103 + ']';
    L11:
        r107 = Intrinsics.stringPlus(",scope:", this.f526128a);
        goto L13
    L5:
        r104 = Intrinsics.stringPlus(",qualifier:", r102);
        if (r104 != null) goto L8;
        goto L8
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 == null) goto L17;
        BeanDefinition r101 = (BeanDefinition) r100;
        if (Intrinsics.areEqual(this.f526129b, r101.f526129b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f526130c, r101.f526130c) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.f526128a, r101.f526128a) == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    public BeanDefinition(mwc.c r100, KClass r101, mwc.a r102, Function2 r103, Kind r104, List r105, d r110) {
        e r106 = new e(null);
        Intrinsics.checkNotNullParameter(r100, "scopeQualifier");
        Intrinsics.checkNotNullParameter(r101, "primaryType");
        Intrinsics.checkNotNullParameter(r103, "definition");
        Intrinsics.checkNotNullParameter(r104, "kind");
        Intrinsics.checkNotNullParameter(r105, "secondaryTypes");
        Intrinsics.checkNotNullParameter(r110, "options");
        Intrinsics.checkNotNullParameter(r106, "properties");
        this.f526128a = r100;
        this.f526129b = r101;
        this.f526130c = r102;
        this.f526131d = r103;
        this.f526132e = r104;
        this.f526133f = r105;
        this.f526134g = r110;
        this.f526135h = new b(null);
    }
}
