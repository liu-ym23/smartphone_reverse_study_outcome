package com.bytedance.awemeopen.apps.framework.feed.profile;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f195880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f195881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f195882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f195883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f195884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f195885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<jz3.a> f195886g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f195887h;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.profile.f$a$a, reason: collision with other inner class name */
        public static final class C2811a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2811a f195888a = null;

            static {
                f195888a = new C2811a();
            }

            public C2811a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f195889a = null;

            static {
                f195889a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    static {
        f195880a = "";
        f195881b = "";
        f195883d = 20;
        f195886g = new ArrayList();
    }

    public static void a(String r100, a r101, long r102, boolean r103, List r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "userOpenId");
        Intrinsics.checkNotNullParameter(r101, "profileTab");
        Intrinsics.checkNotNullParameter(r104, "datas");
        Intrinsics.checkNotNullParameter(r106, "fromGroupId");
        f195880a = r100;
        f195882c = r101;
        f195883d = 20;
        f195884e = r102;
        f195885f = r103;
        ArrayList r107 = (ArrayList) f195886g;
        r107.clear();
        r107.addAll(r104);
        if (r105 < 0) goto L5;
        f195887h = r105;
    L5:
        f195881b = r106;
    }
}
