package org.koin.core.scope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.DefinitionParameterException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class Scope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f526145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final org.koin.core.a f526146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Scope> f526147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nwc.a f526148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f526149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<b> f526150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f526151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public lwc.a f526152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jwc.a f526153j;

    public final void a() {
        this.f526151h = true;
        this.f526149f = null;
        if (this.f526146c.f526124c.c(Level.DEBUG) == false) goto L5;
        jwc.a r100 = this.f526146c.f526124c;
        String r101 = "closing scope:'" + this.f526144a + '\'';
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        r100.b(Level.INFO, r101);
    L5:
        Iterator<b> r102 = this.f526150g.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().a();
        goto L7
    L9:
        this.f526150g.clear();
        nwc.a r103 = this.f526148e;
        Iterator<T> r104 = r103.f521026c.values().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        ((iwc.c) r104.next()).b();
        goto L11
    L13:
        r103.f521026c.clear();
    }

    public final void b() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L6
        this.f526146c.f526122a.c(this);     // Catch: Throwable -> L6
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Scope) == true) goto L8;
        return false;
    L8:
        Scope r101 = (Scope) r100;
        if (Intrinsics.areEqual(this.f526144a, r101.f526144a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f526145b, r101.f526145b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f526146c, r101.f526146c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f526144a.hashCode() * 31) + this.f526145b.hashCode()) * 31) + this.f526146c.hashCode();
    }

    public final String toString() {
        return "['" + this.f526144a + "']";
    }

    public Scope(String r100, c r101, org.koin.core.a r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "_scopeDefinition");
        Intrinsics.checkNotNullParameter(r102, "_koin");
        this.f526144a = r100;
        this.f526145b = r101;
        this.f526146c = r102;
        this.f526147d = new ArrayList();
        this.f526148e = new nwc.a(r102, this);
        this.f526150g = new ArrayList();
        this.f526153j = r102.f526124c;
    }

    public final <T> T c(final KClass<T> r100, final mwc.a r101, final Function0<? extends lwc.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f526146c.f526124c.c(Level.DEBUG) == false) goto L13;
        if (r101 == null) goto L9;
        String r103 = " with qualifier '" + r101 + '\'';
        if (r103 == null) goto L9;
    L10:
        this.f526146c.f526124c.a("+- '" + pwc.a.a(r100) + '\'' + r103);
        Function0<T> r104 = new Scope$get$1(this, r101, r100, r102);
        Intrinsics.checkNotNullParameter(r104, "code");
        long r105 = System.currentTimeMillis();
        r104.invoke();
        Pair r106 = new Pair(r104.invoke(), Double.valueOf(System.currentTimeMillis() - r105));
        T r107 = (T) r106.component1();
        double r108 = ((Number) r106.component2()).doubleValue();
        this.f526146c.f526124c.a("|- '" + pwc.a.a(r100) + "' in " + r108 + " ms");
        return r107;
    L9:
        r103 = "";
        goto L10
    L13:
        return (T) e(r101, r100, r102);
    }

    public final <T> T d(KClass<T> r100, mwc.a r101, Function0<? extends lwc.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    L11:
        return (T) c(r100, r101, r102);
    L6:
        this.f526146c.f526124c.a("Koin.getOrNull - scope closed - no instance found for " + pwc.a.a(r100) + " on scope " + this);
    L7:
        return null;
    L5:
        this.f526146c.f526124c.a("Koin.getOrNull - no instance found for " + pwc.a.a(r100) + " on scope " + this);
        goto L7
    }

    public final <T> T e(mwc.a r100, KClass<T> r110, Function0<? extends lwc.a> r111) {
        if (this.f526151h == true) goto L49;
        String r101 = org.koin.core.definition.a.a(r110, r100);
        nwc.a r102 = this.f526148e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "indexKey");
        iwc.c<?> r103 = r102.f521026c.get(r101);
        Object r104 = null;
        if (r103 != null) goto L7;
        Object r105 = null;
    L9:
        if (r105 != null) goto L32;
        this.f526146c.f526124c.a("'" + pwc.a.a(r110) + "' - q:'" + r100 + "' not found in current scope");
        if (r110.isInstance(this.f526149f) == false) goto L13;
        r105 = (T) this.f526149f;
    L14:
        if (r105 != null) goto L32;
        this.f526146c.f526124c.a("'" + pwc.a.a(r110) + "' - q:'" + r100 + "' not found in current scope's source");
        lwc.a r106 = this.f526152i;
        if (r106 == null) goto L31;
        Intrinsics.checkNotNullParameter(r110, "clazz");
        List r107 = CollectionsKt.filterNotNull(r106.f511103a);
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        T r112 = r109.next();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r112.getClass()), r110) == false) goto L20;
        r108.add(r112);
        goto L20
    L24:
        int r113 = r108.size();
        if (r113 == 0) goto L31;
        if (r113 != 1) goto L30;
        r105 = (T) CollectionsKt.first(r108);
        goto L32
    L30:
        throw new DefinitionParameterException("Ambiguous parameter injection: more than one value of type '" + pwc.a.a(r110) + "' to get from " + r106 + ". Check your injection parameters");
    L31:
        r105 = (T) null;
        goto L32
    L13:
        r105 = null;
    L32:
        if (r105 != null) goto L47;
        this.f526146c.f526124c.a("'" + pwc.a.a(r110) + "' - q:'" + r100 + "' not found in injected parameters");
        Iterator<Scope> r114 = this.f526147d.iterator();
    L35:
        if (r114.hasNext() == false) goto L38;
        r104 = r114.next().d(r110, r100, r111);
        if (r104 == null) goto L35;
    L38:
        r105 = (T) r104;
        if (r105 != null) goto L47;
        this.f526146c.f526124c.a("'" + pwc.a.a(r110) + "' - q:'" + r100 + "' not found in linked scopes");
        if (r100 == null) goto L44;
        String r115 = " & qualifier:'" + r100 + '\'';
        if (r115 == null) goto L44;
    L46:
        throw new NoBeanDefFoundException("No definition found for class:'" + pwc.a.a(r110) + '\'' + r115 + ". Check your definitions!");
    L44:
        r115 = "";
    L47:
        return (T) r105;
    L7:
        r105 = r103.c(new iwc.b(r102.f521024a, r102.f521025b, r111));
        goto L9
    L49:
        throw new ClosedScopeException("Scope '" + this.f526144a + "' is closed");
    }
}
