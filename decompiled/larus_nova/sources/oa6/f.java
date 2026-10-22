package oa6;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements ia6.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f522557k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ia6.b> f522558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final na6.a<Object, Object> f522559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f522560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f522561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f522562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f522563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f522564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f522565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f522566i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C7029f f522567j;

    public static final class a {
        @JvmStatic
        public static String a(long r100, int r101) {
            if (r101 > 0) goto L6;
            return String.valueOf(r100);
        L6:
            if (r100 >= 0) goto L8;
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            long r103 = -r100;
        L12:
            String r104 = String.valueOf(r103);
            int r105 = r101 - r104.length();
            if (r105 <= 0) goto L21;
            String r106 = StringsKt.repeat("0", r105);
            if (r102 == false) goto L18;
            StringBuilder r107 = new StringBuilder("-");
        L19:
            r107.append(r106);
            r107.append(r104);
            return r107.toString();
        L18:
            r107 = new StringBuilder();
            goto L19
        L21:
            return String.valueOf(r100);
        L11:
            r103 = r100;
            goto L12
        L8:
            r102 = false;
            goto L9
        }
    }

    public static final class b implements ia6.b {
        public b() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r100, List<? extends Object> r101) {
            long r102 = oa6.a.e();
            if (r100 == null) goto L5;
            Object r103 = r100.getService();
        L7:
            return Double.valueOf((r102 - (oa6.a.c(r103, 0) * ((long) 1000))) / 1000.0d);
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class c implements ia6.b {
        public c() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = f.f522557k;
            return a.a(0, 0);
        L13:
            long r102 = oa6.a.d(ListProtector.get(r111, 0));
            boolean r103 = oa6.a.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = oa6.a.b(CollectionsKt.getOrNull(r111, 2), 0);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = oa6.a.e();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (oa6.a.c(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = f.f522557k;
            return a.a(0, r113);
        L21:
            double r108 = (r107 * 1.0d) / 86400000;
            if (r103 == false) goto L24;
            int r116 = na6.d.f518470a;
            long r109 = (long) Math.ceil(r108);
        L25:
            int r117 = f.f522557k;
            return a.a(r109, r113);
        L24:
            r109 = (long) r108;
            goto L25
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class d implements ia6.b {
        public d() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = f.f522557k;
            return a.a(0, 2);
        L13:
            long r102 = oa6.a.d(ListProtector.get(r111, 0));
            boolean r103 = oa6.a.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = oa6.a.b(CollectionsKt.getOrNull(r111, 2), 2);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = oa6.a.e();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (oa6.a.c(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = f.f522557k;
            return a.a(0, r113);
        L21:
            double r108 = ((r107 * 1.0d) % 86400000) / 3600000;
            if (r103 == false) goto L24;
            int r116 = na6.d.f518470a;
            r108 = Math.ceil(r108);
        L24:
            int r117 = f.f522557k;
            return a.a((long) r108, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class e implements ia6.b {
        public e() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = f.f522557k;
            return a.a(0, 2);
        L13:
            long r102 = oa6.a.d(ListProtector.get(r111, 0));
            boolean r103 = oa6.a.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = oa6.a.b(CollectionsKt.getOrNull(r111, 2), 2);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = oa6.a.e();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (oa6.a.c(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = f.f522557k;
            return a.a(0, r113);
        L21:
            double r108 = (r107 * 1.0d) / 3600000;
            if (r103 == false) goto L24;
            int r116 = na6.d.f518470a;
            r108 = Math.ceil(r108);
        L24:
            int r117 = f.f522557k;
            return a.a((long) r108, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    /* JADX INFO: renamed from: oa6.f$f, reason: collision with other inner class name */
    public static final class C7029f implements ia6.b {
        public C7029f() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r100, List<? extends Object> r101) {
            throw new Exception("not support lerpColor function");
        }
    }

    public static final class g implements ia6.b {
        public g() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = f.f522557k;
            return a.a(0, 1);
        L13:
            long r102 = oa6.a.d(ListProtector.get(r111, 0));
            int r113 = oa6.a.b(CollectionsKt.getOrNull(r111, 1), 0);
            if (r113 <= 0) goto L16;
            if (r113 > 3) goto L16;
        L17:
            long r103 = 1000;
            long r104 = r102 * r103;
            long r105 = oa6.a.e();
            if (r110 == null) goto L20;
            Object r114 = r110.getService();
        L21:
            long r106 = r104 - (r105 - (oa6.a.c(r114, 0) * r103));
            if (r106 > 0) goto L25;
            int r115 = f.f522557k;
            return a.a(0, r113);
        L25:
            if (r113 == 1) goto L36;
            if (r113 == 2) goto L33;
            if (r113 != 3) goto L32;
            int r116 = f.f522557k;
            return a.a(r106 % r103, r113);
        L32:
            throw new IllegalArgumentException("millisecondsUntil:Invalid digits value: " + r113);
        L33:
            int r117 = f.f522557k;
            return a.a((r106 % r103) / ((long) 10), r113);
        L36:
            return String.valueOf((r106 % r103) / ((long) 100));
        L20:
            r114 = null;
        L16:
            r113 = 1;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class h implements ia6.b {
        public h() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = f.f522557k;
            return a.a(0, 2);
        L13:
            long r102 = oa6.a.d(ListProtector.get(r111, 0));
            boolean r103 = oa6.a.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = oa6.a.b(CollectionsKt.getOrNull(r111, 2), 2);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = oa6.a.e();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (oa6.a.c(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = f.f522557k;
            return a.a(0, r113);
        L21:
            double r108 = ((r107 * 1.0d) % 3600000) / 60000;
            if (r103 == false) goto L24;
            int r116 = na6.d.f518470a;
            r108 = Math.ceil(r108);
        L24:
            int r117 = f.f522557k;
            return a.a((long) r108, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class i implements ia6.b {
        public i() {
        }

        @Override // ia6.b
        public final Object a(ia6.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = f.f522557k;
            return a.a(0, 2);
        L13:
            long r102 = oa6.a.d(ListProtector.get(r111, 0));
            int r113 = oa6.a.b(CollectionsKt.getOrNull(r111, 2), 2);
            long r103 = 1000;
            long r104 = r102 * r103;
            long r105 = oa6.a.e();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r106 = r104 - (r105 - (oa6.a.c(r114, 0) * r103));
            if (r106 > 0) goto L21;
            int r115 = f.f522557k;
            return a.a(0, r113);
        L21:
            int r116 = f.f522557k;
            return a.a((r106 % 60000) / 1000, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    static {
    }

    @Override // ia6.a
    public final Object getService() {
        Intrinsics.checkNotNullParameter("slc_server_time", "serviceKey");
        na6.a<Object, Object> r100 = this.f522559b;
        ReentrantReadWriteLock.ReadLock r101 = r100.f518467b.f518471a.readLock();
        r101.lock();
        Object r102 = r100.f518466a.get("slc_server_time");     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // ia6.a
    public final ia6.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        switch(r100.hashCode()) {
            case -1733354757: goto L48;
            case -851270209: goto L42;
            case -633409492: goto L36;
            case -302968724: goto L30;
            case 183106591: goto L24;
            case 285097287: goto L18;
            case 1126050093: goto L12;
            case 1494276495: goto L6;
            default: goto L54;
        };
    L6:
        if (r100.equals("hoursUntil") == false) goto L54;
        d r101 = this.f522562e;
        if (r101 != null) goto L55;
        d r102 = new d();
        this.f522562e = r102;
        return r102;
    L55:
        return r101;
    L12:
        if (r100.equals("curTime") == false) goto L54;
        b r103 = this.f522560c;
        if (r103 != null) goto L57;
        b r104 = new b();
        this.f522560c = r104;
        return r104;
    L57:
        return r103;
    L18:
        if (r100.equals("daysUntil") == false) goto L54;
        c r105 = this.f522561d;
        if (r105 != null) goto L59;
        c r106 = new c();
        this.f522561d = r106;
        return r106;
    L59:
        return r105;
    L24:
        if (r100.equals("secondsUntil") == false) goto L54;
        i r107 = this.f522565h;
        if (r107 != null) goto L61;
        i r108 = new i();
        this.f522565h = r108;
        return r108;
    L61:
        return r107;
    L30:
        if (r100.equals("millisecondsUntil") == false) goto L54;
        g r109 = this.f522566i;
        if (r109 != null) goto L63;
        g r110 = new g();
        this.f522566i = r110;
        return r110;
    L63:
        return r109;
    L36:
        if (r100.equals("lerpColor") == false) goto L54;
        C7029f r111 = this.f522567j;
        if (r111 != null) goto L65;
        C7029f r112 = new C7029f();
        this.f522567j = r112;
        return r112;
    L65:
        return r111;
    L42:
        if (r100.equals("minutesUntil") == false) goto L54;
        h r113 = this.f522564g;
        if (r113 != null) goto L67;
        h r114 = new h();
        this.f522564g = r114;
        return r114;
    L67:
        return r113;
    L48:
        if (r100.equals("hoursWithoutDayUntil") == false) goto L54;
        e r115 = this.f522563f;
        if (r115 != null) goto L69;
        e r116 = new e();
        this.f522563f = r116;
        return r116;
    L69:
        return r115;
    L54:
        return this.f522558a.get(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Map<String, ? extends ia6.b> r100, na6.a<Object, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "functions");
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.SERVICES);
        this.f522558a = r100;
        this.f522559b = r101;
    }
}
