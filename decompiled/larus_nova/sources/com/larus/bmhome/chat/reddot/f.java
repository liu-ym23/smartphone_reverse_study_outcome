package com.larus.bmhome.chat.reddot;

import androidx.collection.SieveCacheKt;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.platform.api.m4;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import ic8.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f308497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f308498b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f308499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f308500d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f308501e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArraySet<j> f308502f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f308503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f308504h = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            f.a(f.f308497a);
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            f.a(f.f308497a);
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        @Override // com.larus.platform.api.m4
        public final void S1() {
            f.a(f.f308497a);
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
            f.a(f.f308497a);
        }
    }

    public static final class c implements wh8.b {
        public c() {
        }

        @Override // wh8.b
        public final void IJ(int r100) {
        }

        @Override // wh8.b
        public final void Yo(List<wh8.a> r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            f r101 = f.f308497a;
            ArrayList r102 = new ArrayList(r100);
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            r103.add(wh8.a.a((wh8.a) r104.next(), null, null, UnixStat.PERM_MASK));
            goto L4
        L6:
            ArrayList r105 = new ArrayList();
            Iterator r106 = r103.iterator();
        L8:
            if (r106.hasNext() == false) goto L12;
            Object r107 = r106.next();
            if (n.q(((wh8.a) r107).f559708a) == true) goto L8;
            r105.add(r107);
            goto L8
        L12:
            int r108 = f.b(null);
            f.f308499c = 0;
            f.f308501e.clear();
            Iterator r109 = r105.iterator();
        L14:
            if (r109.hasNext() == false) goto L33;
            wh8.a r110 = (wh8.a) r109.next();
            wc9.e r111 = r110.f559708a;
            if (r111 == null) goto L14;
            f r112 = f.f308497a;
            if (((Boolean) f.f308498b.getValue()).booleanValue() == false) goto L20;
        L22:
            Integer r113 = r111.f559209l;
            if (r113 == null) goto L25;
            int r114 = r113.intValue();
        L26:
            Integer r115 = r111.f559210m;
            if (r115 == null) goto L29;
            int r116 = r115.intValue();
        L30:
            int r117 = r114 - r116;
        L31:
            if (r117 <= 0) goto L14;
            f.f308501e.put(r111.f559198a, Integer.valueOf(r117));
            f.f308499c += r117;
            goto L14
        L29:
            r116 = 0;
            goto L30
        L25:
            r114 = 0;
            goto L26
        L20:
            if (r110.f559710c != null) goto L22;
            r117 = 0;
            goto L31
        L33:
            int r118 = f.b(null);
            FLogger r119 = FLogger.f375446a;
            r119.d("ConversationRedDotManager", "redDotCount=" + f.f308499c + ", mixedFeedRedDotCount=" + f.f308500d.b(f.f308499c) + ", totalRedDotCount=" + r118 + ", cvsRedDotCountMap=" + f.f308501e);
            if (r118 == r108) goto L50;
            r119.i("ConversationRedDotManager", "totalRedDotCount = " + r108 + " -> " + r118);
            f.c(f.f308502f);
            return;
        }

        @Override // wh8.b
        public final void R70(List r100, List r101) {
            wh8.b.a.a(r100, r101);
        }
    }

    public f() {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.reddot.c] */
    static {
        f308497a = new f();
        f308498b = LazyKt.lazy(new com.larus.bmhome.chat.reddot.b());
        f308500d = new i(new com.larus.bmhome.chat.reddot.c());
        f308501e = new ConcurrentHashMap();
        f308502f = new CopyOnWriteArraySet();
        f308504h = new c();
        AccountService r100 = AccountService.f365697a;
        r100.E(new a());
        r100.H(new b());
        LarkSocialExp r101 = LarkSocialExp.f365340a;
        Function2<Boolean, Boolean, Unit> r102 = new d();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        LarkSocialExp.f365343d.add(r102);
        FLogger.f375446a.i("ConversationRedDotManager", "init");
    }

    public static final void a(f r100) {
        r100.getClass();
        f308500d.a();
        f308503g = false;
        f308499c = 0;
        f308501e.clear();
        f308502f.clear();
    }

    public static int b(String r100) {
        if (r100 == null) goto L7;
        Integer r101 = f308501e.get(r100);
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        long r103 = RangesKt.coerceAtLeast(f308499c - r102, 0);
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == false) goto L12;
        r103 = f308500d.b(r103);
    L12:
        return (int) RangesKt.coerceIn(r103, 0, SieveCacheKt.NodeLinkMask);
    L7:
        r102 = 0;
        goto L8
    }

    public static void c(Set r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        j r102 = (j) r101.next();
        LarkSocialExp.f365340a.getClass();
        boolean r103 = true;
        if (LarkSocialExp.e() == false) goto L11;
        f308500d.getClass();
        if ((!i.d()) == true) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        String r104 = r102.b();
    L14:
        r102.a(RangesKt.coerceAtLeast(b(r104), 0));
        goto L4
    L13:
        r104 = null;
        goto L14
    }

    public static void d(com.larus.bmhome.chat.reddot.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (f308503g == true) goto L7;
        f308503g = true;
        ConversationListModel r101 = ConversationListModel.f307444a;
        c r102 = f308504h;
        r101.f(r102);
        r101.e(r102, false);
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == false) goto L7;
        f308500d.e();
    L7:
        f308502f.add(r100);
        c(SetsKt.setOf(r100));
    }

    public static void e(j r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f308502f.remove(r100);
    }
}
