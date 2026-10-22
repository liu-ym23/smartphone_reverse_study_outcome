package ylc;

import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> f568355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Set<c>> f568356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f568357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LimitedSizeHashMap<String, Long> f568358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LimitedSizeHashMap<String, Long> f568359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f568360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f568361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vlc.g f568362h;

    public /* synthetic */ e() {
        throw null;
    }

    public final void h() {
        ((LinkedHashMap) this.f568355a).clear();
        Iterator<Map.Entry<String, Set<c>>> r100 = this.f568356b.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Iterator<T> r101 = r100.next().getValue().iterator();
    L7:
        if (r101.hasNext() == false) goto L4;
        ((c) r101.next()).onClear();
        goto L7
    L9:
        this.f568356b.clear();
        this.f568357c.clear();
    }

    @Override // ylc.b
    public final long getRoomId() {
        return this.f568360f;
    }

    @Override // ylc.b
    public final com.ss.ugc.live.sdk.message.wrsc.data.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return e(r100);
    }

    public final void c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f568357c.contains(r100) == true) goto L6;
        this.f568357c.add(r100);
        return;
    }

    public final com.ss.ugc.live.sdk.message.wrsc.data.a e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (com.ss.ugc.live.sdk.message.wrsc.data.a) ((LinkedHashMap) this.f568355a).get(r100);
    }

    @Override // ylc.b
    public final void f(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        i(r100);
    }

    public final void g(com.ss.ugc.live.sdk.message.wrsc.data.a r100) {
        if (this.f568361g.f568354b.contains(r100.f458186g) == false) goto L6;
        this.f568358d.put(r100.f458186g, Long.valueOf(r100.f458180a));
    L8:
        Set<c> r101 = this.f568356b.get(r100.f458186g);
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((c) r102.next()).a(r100);
    L14:
        Iterator<T> r103 = this.f568357c.iterator();
    L16:
        if (r103.hasNext() == false) goto L18;
        ((c) r103.next()).a(r100);
        goto L16
    L18:
        return;
    L6:
        if (this.f568361g.f568353a <= 0) goto L8;
        this.f568359e.put(r100.f458186g, Long.valueOf(r100.f458180a));
        goto L8
    }

    public final void i(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Iterator<Map.Entry<String, Set<c>>> r101 = this.f568356b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().remove(r100);
        goto L4
    }

    @Override // ylc.b
    public final void a(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "listener");
        d(r100, r101);
    }

    public final void d(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "dataSyncKey");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<c> r102 = this.f568356b.get(r100);
        if (r102 != null) goto L5;
        r102 = new CopyOnWriteArraySet();
        this.f568356b.put(r100, r102);
    L5:
        r102.add(r101);
    }

    public e(long r100, d r101, bc2.e r102) {
        Intrinsics.checkNotNullParameter(r101, "wrdsConfig");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        this.f568360f = r100;
        this.f568361g = r101;
        this.f568362h = r102;
        this.f568355a = new LinkedHashMap();
        this.f568356b = new HashMap();
        this.f568357c = new CopyOnWriteArrayList();
        this.f568358d = new LimitedSizeHashMap(Math.max(1, r101.f568354b.size()));
        this.f568359e = new LimitedSizeHashMap(Math.max(1, r101.f568353a - r101.f568354b.size()));
    }
}
