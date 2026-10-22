package io;

import com.bytedance.android.ec.sdk.helper.r;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f490659i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f490660j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f490661k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f490662l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f490663m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f490666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f490667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f490668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f490669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f490670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f490671h;

    public static final class a {
        public a() {
        }

        public static e b(Map r110) {
            Intrinsics.checkNotNullParameter(r110, "map");
            return new e(r.f48132a.getCurrentUserId(), (String) c(r110, "scene_id", ""), (String) c(r110, "business", ""), ((Number) c(r110, "count", 0)).intValue(), ((Number) c(r110, "timestamp", Long.valueOf(System.currentTimeMillis()))).longValue(), (String) c(r110, "data", ""), (String) c(r110, "reserved_string", ""), ((Number) c(r110, "reserved_long", 0L)).longValue());
        }

        public static boolean a(Map r100, Set r101) {
            Set r102 = r101;
            if ((r102 instanceof Collection) == true) goto L5;
        L7:
            Iterator r103 = r102.iterator();
        L9:
            if (r103.hasNext() == false) goto L13;
            if (r100.containsKey((String) r103.next()) == true) goto L9;
            return false;
        L13:
            return true;
        L5:
            if (r102.isEmpty() == false) goto L7;
            goto L7
        }

        public static Object c(Map r100, String r101, Object r102) {
            Object r103 = r100.get(r101);
            if ((r103 instanceof Object) == true) goto L5;
            r103 = null;
        L5:
            if (r103 != null) goto L8;
            return r102;
        L8:
            return r103;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L22;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f490664a, r101.f490664a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f490665b, r101.f490665b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f490666c, r101.f490666c) == true) goto L12;
        return false;
    L12:
        if (this.f490667d == r101.f490667d) goto L14;
        return false;
    L14:
        if (this.f490668e == r101.f490668e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f490669f, r101.f490669f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f490670g, r101.f490670g) == true) goto L20;
        return false;
    L20:
        if (this.f490671h == r101.f490671h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f490664a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f490665b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f490666c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f490667d) * 31;
        long r110 = this.f490668e;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f490669f;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f490670g;
        if (r115 == null) goto L21;
        r101 = r115.hashCode();
    L21:
        int r116 = (r114 + r101) * 31;
        long r117 = this.f490671h;
        return r116 + ((int) (r117 ^ (r117 >>> 32)));
    L17:
        r113 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowLynxEventCardCommonEntity(userId=" + this.f490664a + ", sceneId=" + this.f490665b + ", business=" + this.f490666c + ", count=" + this.f490667d + ", timestamp=" + this.f490668e + ", data=" + this.f490669f + ", reservedString=" + this.f490670g + ", reservedLong=" + this.f490671h + ")";
    }

    static {
        f490663m = new a();
        Set<String> r100 = SetsKt.setOf(new String[]{"scene_id", "business"});
        f490659i = r100;
        Set<String> r101 = SetsKt.setOf(new String[]{"scene_id", "business"});
        f490660j = r101;
        f490661k = r100;
        f490662l = r101;
    }

    public e(String r100, String r101, String r102, int r103, long r104, String r105, String r106, long r110) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "sceneId");
        Intrinsics.checkNotNullParameter(r102, "business");
        Intrinsics.checkNotNullParameter(r105, "data");
        Intrinsics.checkNotNullParameter(r106, "reservedString");
        this.f490664a = r100;
        this.f490665b = r101;
        this.f490666c = r102;
        this.f490667d = r103;
        this.f490668e = r104;
        this.f490669f = r105;
        this.f490670g = r106;
        this.f490671h = r110;
    }
}
