package com.ss.android.ainote.data;

import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.t;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406711a = 0;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(d.a((xra.a) r100)), Long.valueOf(d.a((xra.a) r101)));
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f406712a;

        public b(a r100) {
            this.f406712a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f406712a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(RangesKt.coerceAtLeast(((xra.a) r100).f564907l, 0)), Long.valueOf(RangesKt.coerceAtLeast(((xra.a) r101).f564907l, 0)));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f406713a;

        public c(b r100) {
            this.f406713a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f406713a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(RangesKt.coerceAtLeast(((xra.a) r100).f564906k, 0)), Long.valueOf(RangesKt.coerceAtLeast(((xra.a) r101).f564906k, 0)));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.ainote.data.d$d, reason: collision with other inner class name */
    public static final class C4705d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f406714a;

        public C4705d(c r100) {
            this.f406714a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f406714a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((xra.a) r100).c()), Long.valueOf(((xra.a) r101).c()));
        }
    }

    static {
    }

    public d() {
    }

    public static final long a(xra.a r100) {
        Long r101 = Long.valueOf(r100.f564907l);
        if (r101.longValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L12;
        return r101.longValue();
    L12:
        return RangesKt.coerceAtLeast(r100.f564906k, 0);
    L5:
        r102 = false;
        goto L6
    }

    public static List d(List r100) {
        Intrinsics.checkNotNullParameter(r100, "notes");
        return CollectionsKt.sortedWith(r100, new C4705d(new c(new b(new a()))));
    }

    public static List b(List r410, List r411) {
        Intrinsics.checkNotNullParameter(r410, "current");
        Intrinsics.checkNotNullParameter(r411, "remote");
        if (r410.isEmpty() == true) goto L5;
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator r101 = r410.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        xra.a r102 = (xra.a) r101.next();
        r100.put(Long.valueOf(r102.c()), r102);
        goto L8
    L10:
        Iterator r103 = r411.iterator();
    L12:
        if (r103.hasNext() == false) goto L38;
        xra.a r104 = (xra.a) r103.next();
        xra.a r105 = (xra.a) r100.get(Long.valueOf(r104.c()));
        Long r106 = Long.valueOf(r104.c());
        if (r105 == null) goto L36;
        long r107 = r104.f564905j;
        long r108 = r105.f564905j;
        if (r107 <= r108) goto L19;
        int r109 = t.f407207a;
        t.d("AINoteSyncReducer", "merge newer remote note, noteId=" + r104.c() + ", remoteVersion=" + r104.f564905j + ", currentVersion=" + r105.f564905j);
        r104 = c(r105, r104);
        goto L36
    L19:
        if (r107 >= r108) goto L22;
        int r110 = t.f407207a;
        t.d("AINoteSyncReducer", "discard older remote note, noteId=" + r105.c() + ", remoteVersion=" + r104.f564905j + ", currentVersion=" + r105.f564905j);
    L26:
        r104 = r105;
        goto L36
    L22:
        if (r105.f564910o == true) goto L24;
    L27:
        xra.a r111 = c(r105, r104);
        RichText r112 = r104.f564901f;
        if (r112 != null) goto L30;
    L35:
        r104 = r111;
        goto L36
    L30:
        if (Intrinsics.areEqual(r112, r105.f564901f) == true) goto L35;
        int r113 = t.f407207a;
        t.d("AINoteSyncReducer", "merge aiRichText update, noteId=" + r105.c() + ", remoteVersion=" + r104.f564905j + ", state=" + r104.f564908m);
        RichText r114 = r104.f564901f;
        String r115 = r104.f564902g;
        if (r115 != null) goto L34;
        r115 = r111.f564902g;
    L34:
        r104 = xra.a.b(r111, null, null, null, r114, r115, null, null, 0, 0, 0, null, false, false, 0, 0, null, 0, false, null, false, 2097055);
        goto L36
    L24:
        if (r104.f564910o == true) goto L27;
        int r116 = t.f407207a;
        t.d("AINoteSyncReducer", "keep current deleted note on equal version, noteId=" + r105.c() + ", remoteDeleted=" + r104.f564910o + ", currentDeleted=" + r105.f564910o);
    L36:
        r100.put(r106, r104);
        goto L12
    L38:
        return d(CollectionsKt.toList(r100.values()));
    L5:
        return d(r411);
    }

    public static xra.a c(xra.a r310, xra.a r311) {
        List<xra.b> r100 = r311.f564903h;
        RichText r101 = r311.f564899d;
        if (r101 != null) goto L5;
        r101 = r310.f564899d;
    L5:
        RichText r102 = r101;
        String r103 = r311.f564900e;
        if (r103 != null) goto L8;
        r103 = r310.f564900e;
    L8:
        String r104 = r103;
        RichText r105 = r311.f564901f;
        if (r105 != null) goto L11;
        r105 = r310.f564901f;
    L11:
        RichText r106 = r105;
        String r107 = r311.f564902g;
        if (r107 != null) goto L14;
        r107 = r310.f564902g;
    L14:
        String r108 = r107;
        AINoteType r109 = r311.f564904i;
        long r110 = Math.max(r310.f564905j, r311.f564905j);
        Long r111 = Long.valueOf(r311.f564906k);
        if (r111.longValue() <= 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L21;
        r111 = null;
    L21:
        if (r111 == null) goto L23;
        long r113 = r111.longValue();
    L24:
        long r114 = r113;
        Long r115 = Long.valueOf(r311.f564907l);
        if (r115.longValue() <= 0) goto L27;
        boolean r116 = true;
    L28:
        if (r116 == true) goto L31;
        r115 = null;
    L31:
        if (r115 == null) goto L33;
        long r117 = r115.longValue();
    L34:
        long r118 = r117;
        AINoteContentState r119 = r311.f564908m;
        boolean r120 = r311.f564909n;
        boolean r121 = r311.f564910o;
        Long r122 = Long.valueOf(r311.f564911p);
        if (r122.longValue() <= 0) goto L37;
        boolean r123 = true;
    L38:
        if (r123 == true) goto L41;
        r122 = null;
    L41:
        if (r122 == null) goto L43;
        long r124 = r122.longValue();
    L44:
        long r210 = r124;
        Long r125 = Long.valueOf(r311.f564912q);
        if (r125.longValue() <= 0) goto L47;
        boolean r126 = true;
    L48:
        if (r126 == true) goto L51;
        r125 = null;
    L51:
        if (r125 == null) goto L53;
        long r127 = r125.longValue();
    L54:
        long r211 = r127;
        String r128 = r311.f564913r;
        if (r128 != null) goto L57;
        r128 = r310.f564913r;
    L57:
        String r312 = r128;
        Long r129 = Long.valueOf(r311.f564914s);
        if (r129.longValue() <= 0) goto L60;
        boolean r130 = true;
    L61:
        if (r130 == true) goto L64;
        r129 = null;
    L64:
        if (r129 == null) goto L66;
        long r131 = r129.longValue();
    L67:
        long r313 = r131;
        if (r311.f564915t == false) goto L70;
    L73:
        boolean r314 = true;
    L74:
        boolean r212 = r314;
        xra.a r132 = xra.a.b(r311, null, r102, r104, r106, r108, r100, r109, r110, r114, r118, r119, r120, r121, r210, r211, r312, r313, r212, null, r310.f564917v, 1048583);
        if (r311.f564918w == false) goto L77;
    L80:
        boolean r133 = true;
    L81:
        r132.f564918w = r133;
        return r132;
    L77:
        if (r310.f564918w == true) goto L80;
        r133 = false;
        goto L81
    L70:
        if (r310.f564915t == true) goto L73;
        r314 = false;
        goto L74
    L66:
        r131 = r310.f564914s;
        goto L67
    L60:
        r130 = false;
        goto L61
    L53:
        r127 = r310.f564912q;
        goto L54
    L47:
        r126 = false;
        goto L48
    L43:
        r124 = r310.f564911p;
        goto L44
    L37:
        r123 = false;
        goto L38
    L33:
        r117 = r310.f564907l;
        goto L34
    L27:
        r116 = false;
        goto L28
    L23:
        r113 = r310.f564906k;
        goto L24
    L17:
        r112 = false;
        goto L18
    }
}
