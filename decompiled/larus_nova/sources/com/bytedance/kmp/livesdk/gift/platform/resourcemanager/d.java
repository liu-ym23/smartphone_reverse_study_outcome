package com.bytedance.kmp.livesdk.gift.platform.resourcemanager;

import c12.t;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a f252397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fd6.a<String> f252398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f252399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f252400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f252401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f252402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f252403g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f252404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f252405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f252406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f252407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f252408e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final fd6.a<String> f252409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a f252410g;

        public a(t r100, AssetsFileCacheFactory r101) {
            Intrinsics.checkNotNullParameter(r100, "producerFactory");
            Intrinsics.checkNotNullParameter(r101, "fileCacheFactory");
            this.f252409f = r100;
            this.f252410g = r101;
            this.f252404a = 2;
            this.f252405b = 5;
            this.f252406c = 3;
        }
    }

    public static final class b {
    }

    static {
    }

    public d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f252397a = r100.f252410g;
        this.f252398b = r100.f252409f;
        this.f252399c = r100.f252404a;
        this.f252400d = r100.f252405b;
        this.f252401e = r100.f252406c;
        this.f252402f = r100.f252407d;
        this.f252403g = r100.f252408e;
    }
}
