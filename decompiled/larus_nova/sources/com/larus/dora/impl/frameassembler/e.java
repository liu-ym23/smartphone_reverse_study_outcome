package com.larus.dora.impl.frameassembler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f335807m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f335808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f335809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f335810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f335811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f335812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f335813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f335814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PolarisFileWrapper f335815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DoraDuplicateFramePolicy f335816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DoraIncompleteSessionPolicy f335817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f335818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f335819l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f335820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f335821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f335822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f335823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f335824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f335825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f335826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final PolarisFileWrapper f335827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final DoraDuplicateFramePolicy f335828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final DoraIncompleteSessionPolicy f335829j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f335830k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f335831l;

        public a() {
            this.f335820a = TimeUnit.MINUTES.toMillis(1);
            this.f335821b = TimeUnit.SECONDS.toMillis(10);
            this.f335822c = 1000;
            this.f335823d = 67108864;
            this.f335824e = 8388608;
            this.f335825f = 128;
            this.f335826g = 4194304;
            this.f335827h = new PolarisFileWrapper(System.getProperty("java.io.tmpdir"), "frame-assembler-spool");
            this.f335828i = DoraDuplicateFramePolicy.OVERWRITE;
            this.f335829j = DoraIncompleteSessionPolicy.NOTIFY_PARTIAL;
            this.f335830k = true;
            Level r100 = Level.INFO;
        }
    }

    public static final class b {
    }

    static {
    }

    public e(a r100) {
        this.f335808a = r100.f335820a;
        this.f335809b = r100.f335821b;
        this.f335810c = r100.f335822c;
        this.f335811d = r100.f335823d;
        this.f335812e = r100.f335824e;
        this.f335813f = r100.f335825f;
        this.f335814g = r100.f335826g;
        this.f335815h = r100.f335827h;
        this.f335816i = r100.f335828i;
        this.f335817j = r100.f335829j;
        this.f335818k = r100.f335830k;
        this.f335819l = r100.f335831l;
    }
}
