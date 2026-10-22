package com.larus.community.api.tracker;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class CreationFeedBehaviorTracker<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, String> f328749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Long> f328750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f328751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, T> f328752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, a<T>> f328753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f328754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f328755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<ExposurePauseReason> f328756h;

    /* JADX INFO: renamed from: com.larus.community.api.tracker.CreationFeedBehaviorTracker$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/community/api/tracker/CreationFeedBehaviorTracker$ExposurePauseReason;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE_HIDDEN", "DATA_REFRESH", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExposurePauseReason extends Enum<ExposurePauseReason> {
        public static final ExposurePauseReason DATA_REFRESH = null;
        public static final ExposurePauseReason PAGE_HIDDEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExposurePauseReason[] f328757a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f328758b = null;

        public static EnumEntries<ExposurePauseReason> getEntries() {
            return f328758b;
        }

        static {
            ExposurePauseReason r100 = new ExposurePauseReason("PAGE_HIDDEN", 0);
            PAGE_HIDDEN = r100;
            ExposurePauseReason r101 = new ExposurePauseReason("DATA_REFRESH", 1);
            DATA_REFRESH = r101;
            ExposurePauseReason[] r102 = {r100, r101};
            f328757a = r102;
            f328758b = EnumEntriesKt.enumEntries(r102);
        }

        public static ExposurePauseReason[] values() {
            return (ExposurePauseReason[]) f328757a.clone();
        }

        public static ExposurePauseReason valueOf(String r100) {
            return (ExposurePauseReason) r27.a.a(ExposurePauseReason.class, r100);
        }

        public ExposurePauseReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f328759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f328760b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f328759a, r101.f328759a) == true) goto L12;
            return false;
        L12:
            if (this.f328760b == r101.f328760b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f328759a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f328760b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActiveExposure(item=" + this.f328759a + ", startTimeMs=" + this.f328760b + ')';
        }

        public a(T r100, long r101) {
            this.f328759a = r100;
            this.f328760b = r101;
        }
    }

    public static final class b {
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f328761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f328762b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f328761a, r101.f328761a) == true) goto L12;
            return false;
        L12:
            if (this.f328762b == r101.f328762b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f328761a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f328762b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StayTimeResult(item=" + this.f328761a + ", durationMs=" + this.f328762b + ')';
        }

        public c(T r100, long r101) {
            this.f328761a = r100;
            this.f328762b = r101;
        }
    }

    public static final class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f328763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c<T>> f328764b;

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f328763a, r101.f328763a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f328764b, r101.f328764b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f328763a.hashCode() * 31) + this.f328764b.hashCode();
        }

        public final String toString() {
            return "UpdateResult(firstScreenSlideItems=" + this.f328763a + ", stayTimeResults=" + this.f328764b + ')';
        }

        public /* synthetic */ d(int r100) {
            this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends T> r100, List<c<T>> r101) {
            Intrinsics.checkNotNullParameter(r100, "firstScreenSlideItems");
            Intrinsics.checkNotNullParameter(r101, "stayTimeResults");
            this.f328763a = r100;
            this.f328764b = r101;
        }
    }

    static {
    }

    public CreationFeedBehaviorTracker(Function1 r100) {
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "clock");
        this.f328749a = r100;
        this.f328750b = r101;
        this.f328751c = 500;
        this.f328752d = new LinkedHashMap();
        this.f328753e = new LinkedHashMap();
        this.f328755g = true;
        this.f328756h = new LinkedHashSet();
    }

    public final void a(ExposurePauseReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f328756h.add(r100);
        this.f328753e.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.ArrayList] */
    public final d<T> b(List<? extends T> r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "visibleItems");
        boolean r100 = true;
        int r101 = 0;
        if ((!this.f328756h.isEmpty()) == true) goto L5;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r113 = r110.iterator();
    L8:
        if (r113.hasNext() == false) goto L20;
        T r103 = r113.next();
        String r104 = this.f328749a.invoke(r103);
        if (r104 == null) goto L8;
        if ((!StringsKt.isBlank(r104)) == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L8;
        if (r102.get(r104) != null) goto L8;
        r102.put(r104, r103);
        goto L8
    L20:
        if (r102.isEmpty() == true) goto L22;
    L25:
        long r105 = this.f328750b.invoke().longValue();
        if (this.f328754f == true) goto L28;
        this.f328754f = true;
        this.f328752d.putAll(r102);
    L28:
        if (r112 == false) goto L38;
        Set r114 = r102.keySet();
        ?? r115 = new ArrayList();
        Iterator<Map.Entry<String, a<T>>> r106 = this.f328753e.entrySet().iterator();
    L31:
        if (r106.hasNext() == false) goto L39;
        Map.Entry<String, a<T>> r107 = r106.next();
        String r108 = r107.getKey();
        a<T> r109 = r107.getValue();
        if (r114.contains(r108) == true) goto L31;
        r106.remove();
        long r116 = RangesKt.coerceAtLeast(r105 - r109.f328760b, 0);
        if (r116 <= this.f328751c) goto L31;
        r115.add(new c(r109.f328759a, r116));
    L39:
        Iterator r117 = r102.entrySet().iterator();
    L41:
        if (r117.hasNext() == false) goto L45;
        Map.Entry r118 = (Map.Entry) r117.next();
        String r119 = (String) r118.getKey();
        Object r120 = r118.getValue();
        LinkedHashMap<String, a<T>> r121 = this.f328753e;
        if (r121.get(r119) != null) goto L41;
        r121.put(r119, new a(r120, r105));
        goto L41
    L45:
        if (r111 == true) goto L47;
    L62:
        List r122 = CollectionsKt.emptyList();
    L64:
        return new d(r122, r115);
    L47:
        if (this.f328755g == false) goto L62;
        Set r123 = r102.keySet();
        if ((r123 instanceof Collection) == true) goto L51;
    L53:
        Iterator<T> r124 = r123.iterator();
    L55:
        if (r124.hasNext() == false) goto L59;
        if ((!this.f328752d.containsKey((String) r124.next())) == false) goto L55;
    L60:
        if (r100 == false) goto L62;
        this.f328755g = false;
        r122 = CollectionsKt.toList(this.f328752d.values());
    L59:
        r100 = false;
        goto L60
    L51:
        if (r123.isEmpty() == false) goto L53;
    L38:
        r115 = CollectionsKt.emptyList();
        goto L39
    L22:
        if (this.f328754f == true) goto L25;
        return new d(r101);
    L5:
        return new d(r101);
    }
}
