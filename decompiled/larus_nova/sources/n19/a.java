package n19;

import com.larus.common_ui.presentation.UiPresentationChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f516677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<UiPresentationChannel, Set<String>> f516678b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<UiPresentationChannel, Map<String, Function0<Unit>>> f516679c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<UiPresentationChannel, Set<b>> f516680d = null;

    public a() {
    }

    static {
        f516677a = new a();
        f516678b = new LinkedHashMap();
        f516679c = new LinkedHashMap();
        f516680d = new LinkedHashMap();
    }

    public final synchronized boolean d(UiPresentationChannel r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "channel");     // Catch: Throwable -> L10
        Set r101 = (Set) ((LinkedHashMap) f516678b).get(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L6;
        r101 = SetsKt.emptySet();     // Catch: Throwable -> L10
    L6:
        boolean r102 = !r101.isEmpty();
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(UiPresentationChannel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        update(r100, r101, true, null);
    }

    public final synchronized void c(UiPresentationChannel r100, b r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "channel");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "listener");     // Catch: Throwable -> L9
        LinkedHashMap r102 = (LinkedHashMap) f516680d;     // Catch: Throwable -> L9
        Object r103 = r102.get(r100);     // Catch: Throwable -> L9
        if (r103 != null) goto L6;
        r103 = new LinkedHashSet();     // Catch: Throwable -> L9
        r102.put(r100, r103);     // Catch: Throwable -> L9
    L6:
        ((Set) r103).add(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void e(UiPresentationChannel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        update(r100, r101, false, null);
    }

    public final void b(UiPresentationChannel r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        Intrinsics.checkNotNullParameter(r102, "onPreemptRequested");
        update(r100, r101, true, r102);
    }

    private final void update(UiPresentationChannel r100, String r101, boolean r102, Function0<Unit> r103) {
        if (StringsKt.isBlank(r101) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        LinkedHashMap r104 = (LinkedHashMap) f516678b;     // Catch: Throwable -> L37
        Object r105 = r104.get(r100);     // Catch: Throwable -> L37
        if (r105 != null) goto L9;
        r105 = new LinkedHashSet();     // Catch: Throwable -> L37
        r104.put(r100, r105);     // Catch: Throwable -> L37
    L9:
        Set r106 = (Set) r105;     // Catch: Throwable -> L37
        boolean r107 = !r106.isEmpty();     // Catch: Throwable -> L37
        if (r102 == false) goto L17;
        if (r103 == null) goto L16;
        LinkedHashMap r108 = (LinkedHashMap) f516679c;     // Catch: Throwable -> L37
        Object r109 = r108.get(r100);     // Catch: Throwable -> L37
        if (r109 != null) goto L15;
        r109 = new LinkedHashMap();     // Catch: Throwable -> L37
        r108.put(r100, r109);     // Catch: Throwable -> L37
    L15:
        ((Map) r109).put(r101, r103);     // Catch: Throwable -> L37
    L16:
        boolean r110 = r106.add(r101);     // Catch: Throwable -> L37
    L21:
        boolean r111 = !r106.isEmpty();     // Catch: Throwable -> L37
        if (r110 == false) goto L35;
        if (r107 == r111) goto L35;
        Boolean r112 = Boolean.valueOf(r111);     // Catch: Throwable -> L37
        Set r113 = (Set) ((LinkedHashMap) f516680d).get(r100);     // Catch: Throwable -> L37
        if (r113 != null) goto L28;
        r113 = SetsKt.emptySet();     // Catch: Throwable -> L37
    L28:
        Pair r114 = TuplesKt.to(r112, CollectionsKt.toList(r113));     // Catch: Throwable -> L37
        monitor-exit(this);
        Iterator r115 = ((Iterable) r114.getSecond()).iterator();
    L32:
        if (r115.hasNext() == false) goto L34;
        ((b) r115.next()).f(r100, ((Boolean) r114.getFirst()).booleanValue());
        goto L32
    L34:
        return;
    L35:
        monitor-exit(this);
        return;
    L17:
        Map r116 = (Map) ((LinkedHashMap) f516679c).get(r100);     // Catch: Throwable -> L37
        if (r116 == null) goto L20;
        Function0 r117 = (Function0) r116.remove(r101);     // Catch: Throwable -> L37
    L20:
        r110 = r106.remove(r101);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }
}
