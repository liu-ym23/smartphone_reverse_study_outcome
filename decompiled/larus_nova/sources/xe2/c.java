package xe2;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, BehaviorSubject<Long>> f563351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f563352b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f563352b.clear();
        Iterator<T> r100 = this.f563351a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((BehaviorSubject) r100.next()).onNext(0L);
        goto L4
    }

    public c() {
        this.f563351a = MapsKt.mapOf(new Pair[]{TuplesKt.to(ILoadStallMonitor.START_TIME, BehaviorSubject.createDefault(0L)), TuplesKt.to("music_download_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("music_set_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("seek_sync_info_time", BehaviorSubject.createDefault(0L))});
        this.f563352b = new CompositeDisposable();
    }

    public final long b(String r100) {
        BehaviorSubject<Long> r101 = this.f563351a.get(r100);
        if (r101 == null) goto L7;
        Long r102 = r101.getValue();
        if (r102 == null) goto L7;
        return r102.longValue();
    L7:
        return 0;
    }

    public final void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        if (Intrinsics.areEqual(r100, "seek_sync_info_time") == true) goto L5;
    L7:
        BehaviorSubject<Long> r102 = this.f563351a.get(r100);
        if (r102 == null) goto L10;
        Long r103 = r102.getValue();
    L11:
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.longValue() == 0) goto L16;
        return;
    L16:
        BehaviorSubject<Long> r104 = this.f563351a.get(r100);
        if (r104 == null) goto L21;
        r104.onNext(Long.valueOf(r101));
        return;
    L21:
        return;
    L10:
        r103 = null;
        goto L11
    L5:
        if (b("music_set_time") > 0) goto L7;
    }
}
