package com.bytedance.ee.bear.document.plugin.loading;

import com.bytedance.ee.bear.document.j5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f220844a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.loading.a$a, reason: collision with other inner class name */
    public static final class C3148a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f220845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f220846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f220847c;

        public C3148a() {
            this.f220846b = "";
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f220846b = r100;
        }
    }

    static {
    }

    public static boolean a(int r100) {
        if (r100 != (-2)) goto L5;
        return true;
    L5:
        if (r100 != (-600)) goto L7;
        return true;
    L7:
        if (r100 != (-50)) goto L9;
        return true;
    L9:
        if (j5.a() == false) goto L48;
        int r101 = a05.c.b.f1307a;
        if (r100 != 999) goto L14;
    L49:
        boolean r102 = true;
    L50:
        if (r102 == true) goto L57;
        return false;
    L57:
        return true;
    L14:
        if (r100 == 100) goto L49;
        if (r100 == 101) goto L49;
        if (r100 == 400) goto L49;
        if (r100 == 501) goto L49;
        if (r100 == 502) goto L49;
        if (r100 == 503) goto L49;
        if (r100 == 504) goto L49;
        if (r100 == 505) goto L49;
        if (r100 == 506) goto L49;
        if (r100 == 507) goto L49;
        if (r100 == 601) goto L49;
        if (r100 == 602) goto L49;
        if (r100 == 603) goto L49;
        if (r100 == 604) goto L49;
        if (r100 == 605) goto L49;
        if (r100 == 606) goto L49;
        if (r100 == 607) goto L49;
    L48:
        r102 = false;
        goto L50
    }
}
