package ni4;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements a0<ki4.r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ki4.t<ki4.r> f519282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f519283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ki4.u f519284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ki4.r[] f519285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f519286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject<Unit> f519287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Subject<Unit> f519288g;

    @Override // ni4.a0
    public final boolean hasNext() {
        return this.f519282a.hasNext();
    }

    @Override // ni4.a0
    public final Single<List<ki4.r>> a(ki4.d0 r100) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        if (this.f519283b == false) goto L6;
        return b(r100);
    L6:
        return this.f519282a.next(r100.f503622b);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [ni4.d] */
    /* JADX WARN: Type inference failed for: r1v7, types: [ni4.h] */
    /* JADX WARN: Type inference failed for: r1v8, types: [ni4.f] */
    public final Single<List<ki4.r>> b(final ki4.d0 r100) {
        if (ki4.c0.a(r100) == true) goto L7;
        if (this.f519285d.length < (r100.f503621a + r100.f503622b)) goto L7;
    L9:
        return Single.create(new b(this, r100));
    L7:
        if (this.f519282a.hasNext() == false) goto L9;
        if (ki4.c0.a(r100) == false) goto L19;
        if (this.f519282a.hasNext() == true) goto L19;
        if (this.f519286e.get() == true) goto L19;
        return Single.create(new c(this, r100));
    L19:
        if (this.f519286e.get() == false) goto L21;
        Single<Unit> r101 = this.f519288g.take(1).singleOrError();
        final ?? r102 = new d(this, r100);
        Single r103 = r101.flatMap(new e(r102));
        Intrinsics.checkNotNull(r103);
        return r103;
    L21:
        this.f519286e.set(true);
        int r104 = (r100.f503621a + r100.f503622b) - this.f519285d.length;
        int r105 = RangesKt.coerceAtMost(this.f519284c.nextIndex(), r104);
        Single<List<ki4.r>> r106 = this.f519282a.next(r105);
        final ?? r107 = new h(this);
        Single<R> r108 = r106.map(new i(r107));
        final ?? r109 = new f(this, r100);
        Single<List<ki4.r>> r110 = r108.flatMap(new g(r109));
        Intrinsics.checkNotNull(r110);
        return r110;
    }

    public j(ki4.t<ki4.r> r100, boolean r101, ki4.u r102) {
        Intrinsics.checkNotNullParameter(r100, "materialIterator");
        Intrinsics.checkNotNullParameter(r102, "indexer");
        this.f519282a = r100;
        this.f519283b = r101;
        this.f519284c = r102;
        this.f519285d = new ki4.r[0];
        this.f519286e = new AtomicBoolean(false);
        PublishSubject<Unit> r103 = PublishSubject.create();
        this.f519287f = r103;
        this.f519288g = r103.toSerialized();
    }
}
