package com.bytedance.ee.bear.share.newshare;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f237188a;

    public static final class a extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f237189b = null;

        static {
            f237189b = new a();
        }

        public a() {
            super("bitableProSetting");
        }
    }

    public static final class b extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f237190b = null;

        static {
            f237190b = new b();
        }

        public b() {
            super("collAvatar");
        }
    }

    public static final class c extends b0 {
        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super(r100);
        }
    }

    public static final class d extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f237191b = null;

        static {
            f237191b = new d();
        }

        public d() {
            super("permissionSetting");
        }
    }

    public static final class e extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f237192b = null;

        static {
            f237192b = new e();
        }

        public e() {
            super("docLinkShare");
        }
    }

    public static final class f extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f237193b = 0;

        static {
        }
    }

    public static final class g extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f237194b = null;

        static {
            f237194b = new g();
        }

        public g() {
            super("shareNotify");
        }
    }

    public static final class h extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f237195b = null;

        static {
            f237195b = new h();
        }

        public h() {
            super("thirdPartyExternal");
        }
    }

    public b0(String r100) {
        this.f237188a = r100;
    }
}
