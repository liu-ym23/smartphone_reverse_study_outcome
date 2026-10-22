package mi4;

import android.database.Cursor;
import io.reactivex.Observable;
import java.util.List;
import ki4.b0;
import ki4.g;
import ki4.h;
import ki4.h0;
import ki4.p;
import ki4.r;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import li4.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements p<r, b0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f514068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<r> f514069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f514070c;

    /* JADX WARN: Type inference failed for: r2v1, types: [mi4.a] */
    @Override // ki4.p
    public final Observable<Pair<b0, List<r>>> a(final int r100, b0 r101) {
        final b0 r102 = r101;
        Intrinsics.checkNotNullParameter(r102, "currentCursor");
        if (r102.f503616b == false) goto L7;
        final m r103 = this.f514069b.a(this.f514070c);
        Observable<Cursor> r104 = this.f514068a.a(this.f514070c);
        final ?? r105 = new a(r102, r103, r100);
        return r104.map(new b(r105)).defaultIfEmpty(TuplesKt.to(new b0(r102.f503615a, false), CollectionsKt.emptyList()));
    L7:
        return Observable.just(TuplesKt.to(r102, CollectionsKt.emptyList()));
    }

    public c(h r100, g<r> r101, h0 r102) {
        Intrinsics.checkNotNullParameter(r100, "cursorProvider");
        Intrinsics.checkNotNullParameter(r101, "cursorParserProvider");
        Intrinsics.checkNotNullParameter(r102, "queryParam");
        this.f514068a = r100;
        this.f514069b = r101;
        this.f514070c = r102;
    }
}
