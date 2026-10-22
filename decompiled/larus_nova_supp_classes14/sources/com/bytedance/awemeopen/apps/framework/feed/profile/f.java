package com.bytedance.awemeopen.apps.framework.feed.profile;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static String a;
    public static String b;
    public static a c;
    public static int d;
    public static long e;
    public static boolean f;
    public static final List<jz3.a> g = null;
    public static int h;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.profile.f$a$a, reason: collision with other inner class name */
        public static final class C0084a extends a {
            public static final C0084a a = null;

            static {
                a = new C0084a();
            }

            public C0084a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    static {
        a = "";
        b = "";
        d = 20;
        g = new ArrayList();
    }

    public static void a(String r1, a r2, long r3, boolean r5, List r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r1, "userOpenId");
        Intrinsics.checkNotNullParameter(r2, "profileTab");
        Intrinsics.checkNotNullParameter(r6, "datas");
        Intrinsics.checkNotNullParameter(r8, "fromGroupId");
        a = r1;
        c = r2;
        d = 20;
        e = r3;
        f = r5;
        ArrayList r4 = (ArrayList) g;
        r4.clear();
        r4.addAll(r6);
        if (r7 < 0) goto L5;
        h = r7;
    L5:
        b = r8;
    }
}
