package com.ss.android.lark.coremd.utils;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v7b.r;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class BISURelocator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f419950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<s>[] f419951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f419952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<s> f419953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<s> f419954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f419955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<s, Integer> f419956g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f419957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f419958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f419959c;

        public b(int r100, int r101, int r102) {
            this.f419957a = r100;
            this.f419958b = r101;
            this.f419959c = r102;
        }
    }

    static {
    }

    public BISURelocator() {
        this.f419950a = new int[]{1, 2, 4, 8};
        this.f419951b = new Function0[]{BISURelocator$styleNodeFactory$1.INSTANCE, BISURelocator$styleNodeFactory$2.INSTANCE, BISURelocator$styleNodeFactory$3.INSTANCE, BISURelocator$styleNodeFactory$4.INSTANCE};
        this.f419952c = new ArrayList();
        this.f419953d = new ArrayList();
        this.f419954e = new ArrayList();
        this.f419955f = new ArrayList();
        this.f419956g = new LinkedHashMap();
    }

    public static int c(s r100) {
        NodeBISUUtils.f419961c.getClass();
        Intrinsics.checkNotNullParameter(r100, "node");
        return ((Number) NodeBISUUtils.f419963e.getValue(r100, NodeBISUUtils.f419962d[0])).intValue();
    }

    public final void d(v7b.e r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Log.d("BISURelocator", "parseBISU: node is " + r.a(r100, false));
        b(r100, c(r100));
        ((ArrayList) this.f419952c).clear();
        ((ArrayList) this.f419953d).clear();
        ((ArrayList) this.f419955f).clear();
        ((ArrayList) this.f419954e).clear();
    }

    public final void b(s r110, int r111) {
        s r100 = r110.f553569e;
        if (r100 != null) goto L10;
        if (r110.f553570f != null) goto L10;
        if ((r110 instanceof v7b.a) == true) goto L10;
        this.f419956g.put(r110, Integer.valueOf(r111));
        return;
    L10:
        if (r100 == null) goto L12;
        b(r100, c(r100) | r111);
        r100 = r100.f553572h;
        goto L10
    L12:
        ((ArrayList) this.f419952c).clear();
        ((ArrayList) this.f419953d).clear();
        ((ArrayList) this.f419954e).clear();
        ((ArrayList) this.f419955f).clear();
        s r112 = r110.f553569e;
    L13:
        int r101 = 0;
        if (r112 == null) goto L19;
        Integer r102 = (Integer) ((LinkedHashMap) this.f419956g).get(r112);
        if (r102 == null) goto L18;
        r101 = r102.intValue();
    L18:
        ((ArrayList) this.f419952c).add(Integer.valueOf(r101));
        ((ArrayList) this.f419953d).add(r112);
        s r103 = r112.f553572h;
        r112.p();
        r112 = r103;
        goto L13
    L19:
        int r104 = 1;
        if ((!((ArrayList) this.f419952c).isEmpty()) == false) goto L38;
        Iterator r113 = ((ArrayList) this.f419952c).iterator();
        int r105 = 1;
        int r106 = 2;
        int r107 = 4;
        int r108 = 8;
    L23:
        if (r113.hasNext() == false) goto L26;
        int r109 = ((Number) r113.next()).intValue();
        r105 = r105 & r109;
        r106 = r106 & r109;
        r107 = r107 & r109;
        r108 = r108 & r109;
        goto L23
    L26:
        if ((r110 instanceof v7b.a) == true) goto L36;
        if (r105 == 1) goto L30;
        r104 = 0;
    L30:
        if (r106 != 2) goto L32;
        r104 = r104 | 2;
    L32:
        if (r107 != 4) goto L34;
        r104 = r104 | 4;
    L34:
        if (r108 != 8) goto L37;
        r104 = r104 | 8;
    L37:
        this.f419956g.put(r110, Integer.valueOf(r104));
    L39:
        List<Integer> r114 = this.f419952c;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = ((ArrayList) r114).iterator();
    L41:
        if (r116.hasNext() == false) goto L43;
        r115.add(Integer.valueOf((((Number) r116.next()).intValue() & 15) & (~(r104 & 15))));
        goto L41
    L43:
        int r117 = r115.size();
        int r118 = -1;
        int r119 = -1;
        int r120 = 0;
    L44:
        if (r120 >= r117) goto L51;
        int r121 = ((Number) ListProtector.get(r115, r120)).intValue();
        if (r121 == r119) goto L50;
        if (r118 < 0) goto L49;
        ((ArrayList) this.f419955f).add(new b(r118, r120, r119));
    L49:
        r118 = r120;
        r119 = r121;
    L50:
        r120 = r120 + 1;
        goto L44
    L51:
        if (r118 < 0) goto L53;
        ((ArrayList) this.f419955f).add(new b(r118, r115.size(), r119));
    L53:
        Iterator r122 = ((ArrayList) this.f419955f).iterator();
    L55:
        if (r122.hasNext() == false) goto L63;
        b r123 = (b) r122.next();
        s r124 = a(r123.f419959c, this.f419953d, r123.f419957a, r123.f419958b);
        if (r124 != null) goto L58;
        int r125 = r123.f419957a;
        int r126 = r123.f419958b;
    L60:
        if (r125 >= r126) goto L55;
        ((ArrayList) this.f419954e).add(ListProtector.get(this.f419953d, r125));
        r125 = r125 + 1;
        goto L60
    L58:
        ((ArrayList) this.f419954e).add(r124);
        goto L55
    L63:
        if ((r110 instanceof v7b.a) == false) goto L68;
        List<s> r127 = this.f419954e;
        s r128 = a(r104, r127, 0, ((ArrayList) r127).size());
        if (r128 == null) goto L67;
        ((ArrayList) this.f419954e).clear();
        ((ArrayList) this.f419954e).add(r128);
    L67:
        this.f419956g.remove(r110);
    L68:
        Iterator r129 = ((ArrayList) this.f419954e).iterator();
    L70:
        if (r129.hasNext() == false) goto L72;
        r110.e((s) r129.next());
        goto L70
    L72:
        return;
    L36:
        r104 = 0;
        goto L37
    L38:
        r104 = 0;
        goto L39
    }

    public final s a(int r100, List<? extends s> r101, int r102, int r110) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        int r103 = 0;
        s r104 = null;
        s r105 = null;
    L7:
        if (r103 >= 4) goto L17;
        int r106 = this.f419950a[r103];
        if ((r100 & r106) != r106) goto L16;
        s r107 = this.f419951b[r103].invoke();
        if (r105 == null) goto L13;
        r107.e(r105);
    L13:
        if (r104 != null) goto L15;
        r104 = r107;
    L15:
        r105 = r107;
    L16:
        r103 = r103 + 1;
        goto L7
    L17:
        if (r104 == null) goto L21;
    L18:
        if (r102 >= r110) goto L20;
        r104.e((s) ListProtector.get(r101, r102));
        r102 = r102 + 1;
        goto L18
    L20:
        return r105;
    L21:
        return null;
    }
}
