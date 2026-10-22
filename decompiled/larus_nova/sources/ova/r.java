package ova;

import android.app.Application;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class r extends c0c.a implements pva.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f526975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f526976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UserSession f526977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy<pva.c> f526978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy<Set<pva.b>> f526979g;

    @Override // pva.a
    public final Map<String, d> b() {
        Set<pva.b> r100 = this.f526979g.get();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        CollectionsKt.addAll(r101, MapsKt.toList(((pva.b) r102.next()).a(this.f526975c)));
        goto L4
    L6:
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Pair r105 = (Pair) r104.next();
        r103.put(r105.getFirst(), r105.getSecond());
        goto L8
    L10:
        return r103;
    }

    @Override // c0c.c
    public final void d(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f526978f.get().b(this.f526977e);
    }

    @Override // c0c.c
    public final void l(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r101 = Intrinsics.areEqual(this.f526977e, this.f526976d.b());
        this.f526978f.get().a(this.f526977e, r101, this);
    }

    @Inject
    public r(Application r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.api.m r102, UserSession r103, Lazy<pva.c> r104, Lazy<Set<pva.b>> r105) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "globalPassport");
        Intrinsics.checkNotNullParameter(r102, "userPassport");
        Intrinsics.checkNotNullParameter(r103, "userSession");
        Intrinsics.checkNotNullParameter(r104, "registry");
        Intrinsics.checkNotNullParameter(r105, "extensions");
        super(r102);
        this.f526975c = r100;
        this.f526976d = r101;
        this.f526977e = r103;
        this.f526978f = r104;
        this.f526979g = r105;
    }
}
