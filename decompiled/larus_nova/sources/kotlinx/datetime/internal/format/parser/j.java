package kotlinx.datetime.internal.format.parser;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class j<Output> implements r<Output> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e<Output>> f505329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f505331c;

    public final String b() {
        List<e<Output>> r100 = this.f505329a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        e r103 = (e) r102.next();
        StringBuilder r104 = new StringBuilder();
        Integer r105 = r103.f505315a;
        if (r105 != null) goto L8;
        String r106 = "at least one digit";
    L9:
        r104.append(r106);
        r104.append(" for ");
        r104.append(r103.f505316b);
        r101.add(r104.toString());
        goto L4
    L8:
        r106 = r105 + " digits";
        goto L9
    L11:
        if (this.f505331c == false) goto L14;
        return "a number with at least " + this.f505330b + " digits: " + r101;
    L14:
        return "a number with exactly " + this.f505330b + " digits: " + r101;
    }

    public final String toString() {
        return b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends e<? super Output>> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumers");
        this.f505329a = r100;
        Iterator r101 = r100.iterator();
        int r102 = 0;
    L3:
        int r103 = 1;
        if (r101.hasNext() == false) goto L9;
        Integer r104 = ((e) r101.next()).f505315a;
        if (r104 == null) goto L8;
        r103 = r104.intValue();
    L8:
        r102 = r102 + r103;
        goto L3
    L9:
        this.f505330b = r102;
        List<e<Output>> r105 = this.f505329a;
        if ((r105 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r106 = r105.iterator();
    L16:
        if (r106.hasNext() == false) goto L13;
        if (((e) r106.next()).f505315a != null) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L16;
        boolean r108 = true;
    L23:
        this.f505331c = r108;
        List<e<Output>> r109 = this.f505329a;
        if ((r109 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r110 = r109.iterator();
    L30:
        if (r110.hasNext() == false) goto L27;
        Integer r111 = ((e) r110.next()).f505315a;
        if (r111 == null) goto L34;
        int r112 = r111.intValue();
    L35:
        if (r112 <= 0) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == true) goto L30;
        boolean r114 = false;
    L40:
        if (r114 == false) goto L78;
        List<e<Output>> r115 = this.f505329a;
        if ((r115 instanceof Collection) == true) goto L44;
    L46:
        Iterator<T> r116 = r115.iterator();
        int r117 = 0;
    L48:
        if (r116.hasNext() == false) goto L57;
        if (((e) r116.next()).f505315a != null) goto L52;
        boolean r118 = true;
    L53:
        if (r118 == false) goto L48;
        r117 = r117 + 1;
        if (r117 >= 0) goto L48;
        CollectionsKt.throwCountOverflow();
        goto L48
    L52:
        r118 = false;
    L57:
        if (r117 > 1) goto L59;
        boolean r119 = true;
    L60:
        if (r119 == true) goto L76;
        List<e<Output>> r120 = this.f505329a;
        ArrayList r121 = new ArrayList();
        Iterator<T> r122 = r120.iterator();
    L63:
        if (r122.hasNext() == false) goto L70;
        Object r123 = r122.next();
        if (((e) r123).f505315a != null) goto L67;
        boolean r124 = true;
    L68:
        if (r124 == false) goto L63;
        r121.add(r123);
        goto L63
    L67:
        r124 = false;
        goto L68
    L70:
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r126 = r121.iterator();
    L72:
        if (r126.hasNext() == false) goto L75;
        r125.add(((e) r126.next()).f505316b);
        goto L72
    L75:
        throw new IllegalArgumentException(("At most one variable-length numeric field in a row is allowed, but got several: " + r125 + ". Parsing is undefined: for example, with variable-length month number and variable-length day of month, '111' can be parsed as Jan 11th or Nov 1st.").toString());
    L76:
        return;
    L59:
        r119 = false;
        goto L60
    L44:
        if (r115.isEmpty() == false) goto L46;
        r117 = 0;
        goto L57
    L78:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L37:
        r113 = false;
        goto L38
    L34:
        r112 = Integer.MAX_VALUE;
    L27:
        r114 = true;
        goto L40
    L26:
        if (r109.isEmpty() == false) goto L28;
    L20:
        r107 = false;
    L13:
        r108 = false;
        goto L23
    L12:
        if (r105.isEmpty() == false) goto L14;
        goto L13
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public final Object a(c r100, CharSequence r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        if ((this.f505330b + r102) <= r101.length()) goto L6;
        int r103 = l.f505334a;
        return l.a.a(r102, new g(this));
    L6:
        final Ref.IntRef r104 = new Ref.IntRef();
    L8:
        if ((r104.element + r102) >= r101.length()) goto L13;
        if (guc.d.a(r101.charAt(r104.element + r102)) == false) goto L13;
        r104.element++;
    L13:
        if (r104.element >= this.f505330b) goto L16;
        int r105 = l.f505334a;
        return l.a.a(r102, new h(r104, this));
    L16:
        int r106 = this.f505329a.size();
        final int r107 = 0;
    L17:
        if (r107 >= r106) goto L27;
        Integer r108 = ((e) ListProtector.get(this.f505329a, r107)).f505315a;
        if (r108 == null) goto L21;
        int r109 = r108.intValue();
    L22:
        int r110 = r109 + r102;
        final f r111 = ((e) ListProtector.get(this.f505329a, r107)).a(r100, r101, r102, r110);
        if (r111 != null) goto L24;
        r107 = r107 + 1;
        r102 = r110;
        goto L17
    L24:
        final String r112 = r101.subSequence(r102, r110).toString();
        int r113 = l.f505334a;
        return l.a.a(r102, new i(r112, this, r107, r111));
    L21:
        r109 = (r104.element - this.f505330b) + 1;
        goto L22
    L27:
        int r114 = l.f505334a;
        return Integer.valueOf(r102);
    }
}
