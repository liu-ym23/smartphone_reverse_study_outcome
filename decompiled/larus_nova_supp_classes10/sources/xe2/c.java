package xe2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final Map<String, BehaviorSubject<Long>> a;
    public final CompositeDisposable b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.b.clear();
        Iterator<T> r0 = this.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BehaviorSubject) r0.next()).onNext(0L);
        goto L4
    }

    public c() {
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to("start_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("music_download_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("music_set_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("seek_sync_info_time", BehaviorSubject.createDefault(0L))});
        this.b = new CompositeDisposable();
    }

    public final long b(String r3) {
        BehaviorSubject<Long> r4 = this.a.get(r3);
        if (r4 == null) goto L7;
        Long r5 = (Long) r4.getValue();
        if (r5 == null) goto L7;
        return r5.longValue();
    L7:
        return 0;
    }

    public final void c(String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "step");
        if (Intrinsics.areEqual(r6, "seek_sync_info_time") == true) goto L5;
    L7:
        BehaviorSubject<Long> r0 = this.a.get(r6);
        if (r0 == null) goto L10;
        Long r1 = (Long) r0.getValue();
    L11:
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.longValue() == 0) goto L16;
        return;
    L16:
        BehaviorSubject<Long> r8 = this.a.get(r6);
        if (r8 == null) goto L21;
        r8.onNext(Long.valueOf(r7));
        return;
    L21:
        return;
    L10:
        r1 = null;
        goto L11
    L5:
        if (b("music_set_time") > 0) goto L7;
    }
}
