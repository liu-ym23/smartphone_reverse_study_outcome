package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class ConversationWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<wc9.e, Long> f345204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<wc9.e, Boolean> f345205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Message> f345206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<wc9.e> f345207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<wc9.e> f345208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Message> f345209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f345210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f345211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f345212i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/ConversationWindow$MutationKind;", "", "isStructural", "", "<init>", "(Ljava/lang/String;IZ)V", "()Z", "NOOP", "UPDATE", "INSERT", "MOVE", "REMOVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MutationKind extends Enum<MutationKind> {
        public static final MutationKind INSERT = null;
        public static final MutationKind MOVE = null;
        public static final MutationKind NOOP = null;
        public static final MutationKind REMOVE = null;
        public static final MutationKind UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MutationKind[] f345213a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f345214b = null;
        private final boolean isStructural;

        public static EnumEntries<MutationKind> getEntries() {
            return f345214b;
        }

        static {
            MutationKind r100 = new MutationKind("NOOP", 0, false);
            NOOP = r100;
            MutationKind r101 = new MutationKind("UPDATE", 1, false);
            UPDATE = r101;
            MutationKind r102 = new MutationKind("INSERT", 2, true);
            INSERT = r102;
            MutationKind r103 = new MutationKind("MOVE", 3, true);
            MOVE = r103;
            MutationKind r104 = new MutationKind("REMOVE", 4, true);
            REMOVE = r104;
            MutationKind[] r105 = {r100, r101, r102, r103, r104};
            f345213a = r105;
            f345214b = EnumEntriesKt.enumEntries(r105);
        }

        public static MutationKind[] values() {
            return (MutationKind[]) f345213a.clone();
        }

        public final boolean isStructural() {
            return this.isStructural;
        }

        public static MutationKind valueOf(String r100) {
            return (MutationKind) r27.a.a(MutationKind.class, r100);
        }

        public MutationKind(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.isStructural = r102;
        }
    }

    public interface a {

        /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.group.datasource.im.ConversationWindow$a$a, reason: collision with other inner class name */
        public static final class C4324a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f345215a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Set<String> f345216b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4324a) == true) goto L8;
                return false;
            L8:
                C4324a r101 = (C4324a) r100;
                if (this.f345215a == r101.f345215a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f345216b, r101.f345216b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f345215a * 31) + this.f345216b.hashCode();
            }

            public final String toString() {
                return "Applied(structuralChanges=" + this.f345215a + ", briefRefreshIds=" + this.f345216b + ')';
            }

            public C4324a(int r100, Set<String> r101) {
                Intrinsics.checkNotNullParameter(r101, "briefRefreshIds");
                this.f345215a = r100;
                this.f345216b = r101;
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f345217a = null;

            static {
                f345217a = new b();
            }

            public b() {
            }
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f345218a;

        public b(Function1 r100) {
            this.f345218a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Function1 r102 = this.f345218a;
            return ComparisonsKt.compareValues((Comparable) r102.invoke(r101), (Comparable) r102.invoke(r100));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f345219a;

        public c(b r100) {
            this.f345219a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f345219a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(((wc9.e) r101).f559198a, ((wc9.e) r100).f559198a);
        }
    }

    public final int c() {
        return ((ArrayList) this.f345207d).size();
    }

    public final void f() {
        c r100 = new c(new b(this.f345204a));
        CollectionsKt.sortWith(this.f345207d, r100);
        CollectionsKt.sortWith(this.f345208e, r100);
        wc9.e r101 = (wc9.e) CollectionsKt.lastOrNull(this.f345207d);
        if (r101 == null) goto L5;
        long r102 = this.f345204a.invoke(r101).longValue();
    L6:
        this.f345210g = r102;
        if (r101 == null) goto L9;
        String r103 = r101.f559198a;
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        this.f345211h = r103;
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = Long.MAX_VALUE;
        goto L6
    }

    public final Map<String, String> b(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationIds");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L25;
        String r103 = (String) r102.next();
        Iterator<T> r104 = this.f345207d.iterator();
    L6:
        Pair r105 = null;
        if (r104.hasNext() == false) goto L11;
        Object r106 = r104.next();
        if (Intrinsics.areEqual(((wc9.e) r106).f559198a, r103) == false) goto L6;
    L12:
        wc9.e r107 = (wc9.e) r106;
        if (r107 == null) goto L22;
        String r108 = r107.f559211n;
        if (r108 == null) goto L22;
        if ((!StringsKt.isBlank(r108)) == true) goto L20;
        r108 = null;
    L20:
        if (r108 == null) goto L22;
        r105 = TuplesKt.to(r108, r103);
    L22:
        if (r105 == null) goto L4;
        r101.add(r105);
        goto L4
    L11:
        r106 = null;
        goto L12
    L25:
        return MapsKt.toMap(r101);
    }

    public final Map<String, Message> e(Map<String, Message> r100) {
        Intrinsics.checkNotNullParameter(r100, "briefMessages");
        if (r100.isEmpty() == true) goto L5;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, Message>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L24;
        Map.Entry<String, Message> r103 = r102.next();
        String r104 = r103.getKey();
        Message r105 = r103.getValue();
        Iterator r106 = ((ArrayList) this.f345207d).iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((wc9.e) r107).f559198a, r104) == false) goto L11;
    L16:
        wc9.e r108 = (wc9.e) r107;
        if (r108 != null) goto L19;
    L21:
        boolean r109 = false;
    L22:
        if (r109 == false) goto L8;
        r101.put(r103.getKey(), r103.getValue());
        goto L8
    L19:
        if (Intrinsics.areEqual(r108.f559211n, r105.getLocalMessageId()) == false) goto L21;
        r109 = true;
        goto L22
    L15:
        r107 = null;
        goto L16
    L24:
        this.f345209f.putAll(r101);
        return r101;
    L5:
        return MapsKt.emptyMap();
    }

    public final int d(List<wc9.e> r110, wc9.e r111) {
        long r100 = this.f345204a.invoke(r111).longValue();
        Iterator<wc9.e> r101 = r110.iterator();
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L17;
        wc9.e r104 = r101.next();
        if (this.f345204a.invoke(r104).longValue() >= r100) goto L8;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L18;
        r103 = r103 + 1;
    L18:
        Integer r106 = Integer.valueOf(r103);
        if (r106.intValue() < 0) goto L21;
        r102 = true;
    L21:
        if (r102 == true) goto L24;
        r106 = null;
    L24:
        if (r106 == null) goto L26;
        int r107 = r106.intValue();
    L27:
        ListProtector.add(r110, r107, r111);
        return r107;
    L26:
        r107 = r110.size();
        goto L27
    L8:
        if (this.f345204a.invoke(r104).longValue() == r100) goto L10;
    L12:
        r105 = false;
        goto L14
    L10:
        if (r104.f559198a.compareTo(r111.f559198a) >= 0) goto L12;
    L17:
        r103 = -1;
        goto L18
    }

    public final wc9.e g(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (com.larus.bmhome.chat.bean.d.D0((Message) ((LinkedHashMap) this.f345209f).get(r100), r101) == true) goto L5;
        return null;
    L5:
        Iterator<T> r102 = this.f345207d.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((wc9.e) r103).f559198a, r100) == false) goto L7;
    L12:
        wc9.e r104 = (wc9.e) r103;
        if (r104 != null) goto L27;
        List<wc9.e> r105 = this.f345208e;
        boolean r106 = true;
        if ((r105 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r107 = r105.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((wc9.e) r107.next()).f559198a, r100) == false) goto L21;
        r106 = false;
    L25:
        if (r106 == false) goto L27;
        return null;
    L17:
        if (r105.isEmpty() == false) goto L19;
    L27:
        this.f345209f.put(r100, r101);
        return r104;
    L11:
        r103 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConversationWindow(Function1<? super wc9.e, Long> r100, Function1<? super wc9.e, Boolean> r101, Function1<? super String, Message> r102) {
        Intrinsics.checkNotNullParameter(r100, "sortKeyOf");
        Intrinsics.checkNotNullParameter(r101, "matchesQuery");
        Intrinsics.checkNotNullParameter(r102, "sharedBriefLookup");
        this.f345204a = r100;
        this.f345205b = r101;
        this.f345206c = r102;
        this.f345207d = new ArrayList();
        this.f345208e = new ArrayList();
        this.f345209f = new LinkedHashMap();
        this.f345210g = Long.MAX_VALUE;
        this.f345211h = "";
    }

    public final void a(l0 r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "page");
        long r100 = Long.MAX_VALUE;
        if (r112 == false) goto L5;
        long r101 = Long.MAX_VALUE;
    L6:
        String r102 = "";
        if (r112 == false) goto L9;
        String r103 = "";
    L10:
        if (r112 == false) goto L12;
        ((ArrayList) this.f345207d).clear();
        ((LinkedHashMap) this.f345209f).clear();
    L12:
        ((ArrayList) this.f345208e).clear();
        List<wc9.e> r113 = this.f345207d;
        LinkedHashSet r104 = new LinkedHashSet();
        Iterator r114 = ((ArrayList) r113).iterator();
    L14:
        if (r114.hasNext() == false) goto L16;
        r104.add(((wc9.e) r114.next()).f559198a);
        goto L14
    L16:
        List<wc9.e> r115 = r110.f345359a;
        ArrayList r105 = new ArrayList();
        Iterator<T> r116 = r115.iterator();
    L18:
        if (r116.hasNext() == false) goto L22;
        Object r106 = r116.next();
        if (r104.contains(((wc9.e) r106).f559198a) == true) goto L18;
        r105.add(r106);
        goto L18
    L22:
        CollectionsKt.addAll(this.f345207d, CollectionsKt.take(r105, r111));
        CollectionsKt.addAll(this.f345208e, CollectionsKt.drop(r105, r111));
        this.f345209f.putAll(r110.f345360b);
        wc9.e r117 = (wc9.e) CollectionsKt.lastOrNull(this.f345207d);
        if (r117 == null) goto L25;
        r100 = this.f345204a.invoke(r117).longValue();
    L25:
        this.f345210g = r100;
        if (r117 == null) goto L28;
        String r118 = r117.f559198a;
    L29:
        if (r118 == null) goto L32;
        r102 = r118;
    L32:
        this.f345211h = r102;
        boolean r107 = false;
        if (1 <= r100) goto L35;
    L37:
        boolean r119 = false;
    L38:
        if (r119 == false) goto L40;
    L45:
        boolean r120 = true;
    L47:
        if (r110.f345361c == false) goto L49;
    L50:
        if (r120 == false) goto L52;
        r107 = true;
    L52:
        this.f345212i = r107;
        return;
    L49:
        if ((!((ArrayList) this.f345208e).isEmpty()) == false) goto L52;
    L40:
        if (r100 == r101) goto L42;
    L44:
        r120 = false;
        goto L47
    L42:
        if (r102.compareTo(r103) >= 0) goto L44;
    L35:
        if (r100 >= r101) goto L37;
        r119 = true;
        goto L38
    L28:
        r118 = null;
        goto L29
    L9:
        r103 = this.f345211h;
        goto L10
    L5:
        r101 = this.f345210g;
        goto L6
    }
}
