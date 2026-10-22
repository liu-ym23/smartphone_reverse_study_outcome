package com.larus.im.internal.tracking.network;

import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import ouc.g0;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final LongRange f350375m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final LongRange f350376n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n f350377o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f350378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f350379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f350380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f350381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f350382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f350383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f350384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompletableJob f350385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f350386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Channel<b> f350387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0 f350388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Job f350389l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f350390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f350391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f350392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f350393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.larus.im.internal.tracking.network.d f350394e;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f350390a, r101.f350390a) == true) goto L12;
            return false;
        L12:
            if (this.f350391b == r101.f350391b) goto L15;
            return false;
        L15:
            if (this.f350392c == r101.f350392c) goto L18;
            return false;
        L18:
            if (this.f350393d == r101.f350393d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f350394e, r101.f350394e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f350390a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            if (this.f350391b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (((r103 + r104) * 31) + this.f350392c) * 31;
            long r106 = this.f350393d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            com.larus.im.internal.tracking.network.d r108 = this.f350394e;
            if (r108 == null) goto L15;
            r101 = r108.hashCode();
        L15:
            return r107 + r101;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ColdStartState(anchorAtMs=" + this.f350390a + ", inProgress=" + this.f350391b + ", completedStepsMask=" + this.f350392c + ", watchdogGeneration=" + this.f350393d + ", watchdog=" + this.f350394e + ')';
        }

        public a(int r100) {
            this.f350390a = null;
            this.f350391b = false;
            this.f350392c = 0;
            this.f350393d = 0;
            this.f350394e = null;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public interface b {

        public static final class a implements b {
            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                ((a) r100).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                throw null;
            }

            public final String toString() {
                return "Barrier(completion=null)";
            }
        }

        /* JADX INFO: renamed from: com.larus.im.internal.tracking.network.k$b$b, reason: collision with other inner class name */
        public static final class C4377b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f350395a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f350396b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final NetworkTrackTransport f350397c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final long f350398d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final long f350399e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4377b) == true) goto L8;
                return false;
            L8:
                C4377b r101 = (C4377b) r100;
                if (Intrinsics.areEqual(this.f350395a, r101.f350395a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f350396b, r101.f350396b) == true) goto L15;
                return false;
            L15:
                if (this.f350397c == r101.f350397c) goto L18;
                return false;
            L18:
                if (this.f350398d == r101.f350398d) goto L21;
                return false;
            L21:
                if (this.f350399e == r101.f350399e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                int r100 = ((((this.f350395a.hashCode() * 31) + this.f350396b.hashCode()) * 31) + this.f350397c.hashCode()) * 31;
                long r101 = this.f350398d;
                int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
                long r103 = this.f350399e;
                return r102 + ((int) (r103 ^ (r103 >>> 32)));
            }

            public final String toString() {
                return "Begin(requestId=" + this.f350395a + ", path=" + this.f350396b + ", transport=" + this.f350397c + ", netConnected=" + this.f350398d + ", startedAtMs=" + this.f350399e + ')';
            }

            public C4377b(String r100, String r101, NetworkTrackTransport r102, long r103, long r104) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                Intrinsics.checkNotNullParameter(r101, "path");
                Intrinsics.checkNotNullParameter(r102, NotificationCompat.CATEGORY_TRANSPORT);
                this.f350395a = r100;
                this.f350396b = r101;
                this.f350397c = r102;
                this.f350398d = r103;
                this.f350399e = r104;
            }
        }

        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f350400a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.f350400a == ((c) r100).f350400a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f350400a;
                return (int) (r100 ^ (r100 >>> 32));
            }

            public final String toString() {
                return "ColdAnchor(anchorAtMs=" + this.f350400a + ')';
            }

            public c(long r100) {
                this.f350400a = r100;
            }
        }

        public static final class d implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final NetworkTrackColdStartStep f350401a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (this.f350401a == ((d) r100).f350401a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f350401a.hashCode();
            }

            public final String toString() {
                return "ColdStepDone(step=" + this.f350401a + ')';
            }

            public d(NetworkTrackColdStartStep r100) {
                Intrinsics.checkNotNullParameter(r100, "step");
                this.f350401a = r100;
            }
        }

        public static final class e implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f350402a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L9;
                return false;
            L9:
                if (this.f350402a == ((e) r100).f350402a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f350402a;
                return (int) (r100 ^ (r100 >>> 32));
            }

            public final String toString() {
                return "ColdWatchdog(generation=" + this.f350402a + ')';
            }

            public e(long r100) {
                this.f350402a = r100;
            }
        }

        public static final class f implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f350403a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final a0 f350404b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f350405c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L8;
                return false;
            L8:
                f r101 = (f) r100;
                if (Intrinsics.areEqual(this.f350403a, r101.f350403a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f350404b, r101.f350404b) == true) goto L15;
                return false;
            L15:
                if (this.f350405c == r101.f350405c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f350403a.hashCode() * 31) + this.f350404b.hashCode()) * 31;
                long r101 = this.f350405c;
                return r100 + ((int) (r101 ^ (r101 >>> 32)));
            }

            public final String toString() {
                return "Finish(requestId=" + this.f350403a + ", result=" + this.f350404b + ", finishedAtMs=" + this.f350405c + ')';
            }

            public f(String r100, a0 r101, long r102) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                Intrinsics.checkNotNullParameter(r101, "result");
                this.f350403a = r100;
                this.f350404b = r101;
                this.f350405c = r102;
            }
        }

        public static final class g implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f350406a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f350407b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof g) == true) goto L8;
                return false;
            L8:
                g r101 = (g) r100;
                if (Intrinsics.areEqual(this.f350406a, r101.f350406a) == true) goto L12;
                return false;
            L12:
                if (this.f350407b == r101.f350407b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f350406a.hashCode() * 31;
                long r101 = this.f350407b;
                return r100 + ((int) (r101 ^ (r101 >>> 32)));
            }

            public final String toString() {
                return "KeepAlive(requestId=" + this.f350406a + ", observedAtMs=" + this.f350407b + ')';
            }

            public g(String r100, long r101) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                this.f350406a = r100;
                this.f350407b = r101;
            }
        }

        public static final class h implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f350408a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final x f350409b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f350410c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof h) == true) goto L8;
                return false;
            L8:
                h r101 = (h) r100;
                if (Intrinsics.areEqual(this.f350408a, r101.f350408a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f350409b, r101.f350409b) == true) goto L15;
                return false;
            L15:
                if (this.f350410c == r101.f350410c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f350408a.hashCode() * 31) + this.f350409b.hashCode()) * 31;
                long r101 = this.f350410c;
                return r100 + ((int) (r101 ^ (r101 >>> 32)));
            }

            public final String toString() {
                return "Response(requestId=" + this.f350408a + ", response=" + this.f350409b + ", observedAtMs=" + this.f350410c + ')';
            }

            public h(String r100, x r101, long r102) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                Intrinsics.checkNotNullParameter(r101, "response");
                this.f350408a = r100;
                this.f350409b = r101;
                this.f350410c = r102;
            }
        }

        public static final class i implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f350411a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f350412b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f350413c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof i) == true) goto L8;
                return false;
            L8:
                i r101 = (i) r100;
                if (Intrinsics.areEqual(this.f350411a, r101.f350411a) == true) goto L12;
                return false;
            L12:
                if (this.f350412b == r101.f350412b) goto L15;
                return false;
            L15:
                if (this.f350413c == r101.f350413c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f350411a.hashCode() * 31;
                long r101 = this.f350412b;
                int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
                long r103 = this.f350413c;
                return r102 + ((int) (r103 ^ (r103 >>> 32)));
            }

            public final String toString() {
                return "Timeout(requestId=" + this.f350411a + ", generation=" + this.f350412b + ", finishedAtMs=" + this.f350413c + ')';
            }

            public i(String r100, long r101, long r102) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                this.f350411a = r100;
                this.f350412b = r101;
                this.f350413c = r102;
            }
        }
    }

    public static final class c {
        public static double a(ouc.i r100) {
            if ((r100 instanceof g0) == false) goto L5;
            g0 r101 = (g0) r100;
        L7:
            if (r101 != null) goto L10;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L10:
            if (r101.c() == false) goto L12;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L12:
            Double r102 = ouc.k.i(r101);
            if (r102 == null) goto L24;
            double r103 = r102.doubleValue();
            if (Double.isInfinite(r103) == false) goto L17;
        L19:
            boolean r104 = false;
        L20:
            if (r104 == true) goto L23;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L23:
            return RangesKt.coerceIn(r103, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
        L17:
            if (Double.isNaN(r103) == true) goto L19;
            r104 = true;
            goto L20
        L24:
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L5:
            r101 = null;
            goto L7
        }
    }

    public static final class d implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineScope f350414a;

        public d(CoroutineScope r100) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            this.f350414a = r100;
        }

        @Override // com.larus.im.internal.tracking.network.b0
        public final m a(long r100, Function0 r110) {
            Intrinsics.checkNotNullParameter(r110, "block");
            return new m(BuildersKt.launch$default(this.f350414a, null, null, new NetworkTrackCenter$CoroutineTimeoutScheduler$schedule$job$1(r100, r110, null), 3, null));
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f350415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NetworkTrackTransport f350416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f350417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f350418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f350419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Long f350420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f350421g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public x f350422h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f350423i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public com.larus.im.internal.tracking.network.d f350424j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f350415a, r101.f350415a) == true) goto L12;
            return false;
        L12:
            if (this.f350416b == r101.f350416b) goto L15;
            return false;
        L15:
            if (this.f350417c == r101.f350417c) goto L18;
            return false;
        L18:
            if (this.f350418d == r101.f350418d) goto L21;
            return false;
        L21:
            if (this.f350419e == r101.f350419e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f350420f, r101.f350420f) == true) goto L27;
            return false;
        L27:
            if (this.f350421g == r101.f350421g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f350422h, r101.f350422h) == true) goto L33;
            return false;
        L33:
            if (this.f350423i == r101.f350423i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f350424j, r101.f350424j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f350415a.hashCode() * 31) + this.f350416b.hashCode()) * 31;
            long r101 = this.f350417c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f350418d;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f350419e;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            Long r107 = this.f350420f;
            int r108 = 0;
            if (r107 != null) goto L5;
            int r109 = 0;
        L6:
            int r110 = (r106 + r109) * 31;
            if (this.f350421g == false) goto L9;
            int r111 = 1231;
        L10:
            int r112 = (((r110 + r111) * 31) + this.f350422h.hashCode()) * 31;
            long r113 = this.f350423i;
            int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
            com.larus.im.internal.tracking.network.d r115 = this.f350424j;
            if (r115 == null) goto L15;
            r108 = r115.hashCode();
        L15:
            return r114 + r108;
        L9:
            r111 = 1237;
            goto L10
        L5:
            r109 = r107.hashCode();
            goto L6
        }

        public final String toString() {
            return "RequestState(path=" + this.f350415a + ", transport=" + this.f350416b + ", netConnected=" + this.f350417c + ", startedAtMs=" + this.f350418d + ", lastActivityAtMs=" + this.f350419e + ", coldStartOffsetMs=" + this.f350420f + ", isColdStartRequest=" + this.f350421g + ", response=" + this.f350422h + ", timeoutGeneration=" + this.f350423i + ", timeout=" + this.f350424j + ')';
        }

        public e(String r100, NetworkTrackTransport r101, long r102, long r103, long r104, Long r110, boolean r111) {
            x r105 = new x(0);
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_TRANSPORT);
            Intrinsics.checkNotNullParameter(r105, "response");
            this.f350415a = r100;
            this.f350416b = r101;
            this.f350417c = r102;
            this.f350418d = r103;
            this.f350419e = r104;
            this.f350420f = r110;
            this.f350421g = r111;
            this.f350422h = r105;
            this.f350423i = 0;
            this.f350424j = null;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f350425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f350426b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f350425a, r101.f350425a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f350426b, r101.f350426b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f350425a.hashCode() * 31) + this.f350426b.hashCode();
        }

        public final String toString() {
            return "RuntimeConfig(snapshot=" + this.f350425a + ", sampling=" + this.f350426b + ')';
        }

        public f(n r100, y r101) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r101, "sampling");
            this.f350425a = r100;
            this.f350426b = r101;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350427a = null;

        static {
            int[] r100 = new int[NetworkTrackTransport.values().length];
            r100[NetworkTrackTransport.HTTP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[NetworkTrackTransport.SSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f350427a = r100;
        }
    }

    public k() {
        throw null;
    }

    static {
        f350375m = new LongRange(100, 599);
        f350376n = new LongRange(200, 299);
        f350377o = new n(false, new z(), 0);
    }

    public final boolean f() {
        n r100 = ((f) this.f350384g.getValue()).f350425a;
        if (r100.f350429a == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f350431c <= 0) goto L7;
        return true;
    }

    public final void c(e r100) {
        com.larus.im.internal.tracking.network.d r101 = r100.f350424j;
        Unit r102 = null;
        r100.f350424j = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.cancel();     // Catch: Throwable -> L8
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r104 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        g(r105);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void d(a r100) {
        r100.f350391b = false;
        com.larus.im.internal.tracking.network.d r101 = r100.f350394e;
        Unit r102 = null;
        r100.f350394e = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.cancel();     // Catch: Throwable -> L8
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r104 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        g(r105);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void g(Throwable r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        this.f350381d.a(r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:13:0x003c). Please report as a decompilation issue!!! */
    public static final Object a(final k r210, Continuation r211) {
        r210.getClass();
        if ((r211 instanceof NetworkTrackCenter$consumeCommands$1) == false) goto L7;
        NetworkTrackCenter$consumeCommands$1 r100 = (NetworkTrackCenter$consumeCommands$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        ChannelIterator<b> r106 = (ChannelIterator) r100.L$2;
        a r107 = (a) r100.L$1;
        Map<String, e> r108 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L160
    L13:
        a r110 = r107;
        Map<String, e> r111 = r108;
    L158:
        th = th;
    L162:
        Throwable r109 = th;
        r1.f350387j.cancel(null);
        Iterator<T> r112 = r111.values().iterator();
    L164:
        if (r112.hasNext() == false) goto L166;
        r210.c((e) r112.next());
        goto L164
    L166:
        r111.clear();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L173
        com.larus.im.internal.tracking.network.d r114 = r110.f350394e;     // Catch: Throwable -> L173
        if (r114 == null) goto L170;
        r114.cancel();     // Catch: Throwable -> L173
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L173
    L171:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L173
    L175:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L178;
        r1.g(r117);
    L178:
        r110.f350394e = null;
        throw r109;
    L170:
        r115 = null;
    L173:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L175
    L22:
        if (((Boolean) r102).booleanValue() == false) goto L140;
        b r119 = r106.next();     // Catch: Throwable -> L158
        if ((r119 instanceof b.C4377b) == true) goto L26;
        r100 = r100;
        r103 = r103;
        if ((r119 instanceof b.h) == false) goto L71;
        e r120 = r111.get(((b.h) r119).f350408a);     // Catch: Throwable -> L158
        if (r120 == null) goto L133;
        x r121 = r120.f350422h;     // Catch: Throwable -> L158
        x r122 = ((b.h) r119).f350409b;     // Catch: Throwable -> L158
        Long r123 = r122.f350442a;     // Catch: Throwable -> L158
        if (r123 != null) goto L56;
        r123 = r121.f350442a;     // Catch: Throwable -> L158
    L56:
        Long r124 = r123;
        Long r125 = r122.f350443b;     // Catch: Throwable -> L158
        if (r125 != null) goto L59;
        r125 = r121.f350443b;     // Catch: Throwable -> L158
    L59:
        Long r126 = r125;
        String r127 = r122.f350444c;     // Catch: Throwable -> L158
        if (r127 != null) goto L62;
        r127 = r121.f350444c;     // Catch: Throwable -> L158
    L62:
        String r128 = r127;
        Long r129 = r122.f350445d;     // Catch: Throwable -> L158
        if (r129 != null) goto L65;
        r129 = r121.f350445d;     // Catch: Throwable -> L158
    L65:
        Long r130 = r129;
        Long r131 = r122.f350446e;     // Catch: Throwable -> L158
        if (r131 != null) goto L68;
        Long r132 = r121.f350446e;     // Catch: Throwable -> L158
    L69:
        x r133 = new x(r124, r126, r128, r130, r132);     // Catch: Throwable -> L158
        Intrinsics.checkNotNullParameter(r133, "<set-?>");     // Catch: Throwable -> L158
        r120.f350422h = r133;     // Catch: Throwable -> L158
        r210.h(((b.h) r119).f350408a, r120, ((b.h) r119).f350410c);     // Catch: Throwable -> L158
        goto L133
    L68:
        r132 = r131;
    L133:
        r100 = r100;
        r107 = r110;
        r108 = r111;
        r103 = r103;
        r105 = 1;
    L18:
        r100.L$0 = r108;     // Catch: Throwable -> L160
        r100.L$1 = r107;     // Catch: Throwable -> L160
        r100.L$2 = r106;     // Catch: Throwable -> L160
        r100.label = r105;     // Catch: Throwable -> L160
        r102 = r106.hasNext(r100);     // Catch: Throwable -> L160
        if (r102 != r103) goto L13;
        return r103;
    L71:
        if ((r119 instanceof b.g) == false) goto L77;
        e r134 = r111.get(((b.g) r119).f350406a);     // Catch: Throwable -> L158
        if (r134 == null) goto L133;
        r210.h(((b.g) r119).f350406a, r134, ((b.g) r119).f350407b);     // Catch: Throwable -> L158
        goto L133
    L77:
        if ((r119 instanceof b.f) == false) goto L80;
        r210.e(r111, ((b.f) r119).f350403a, ((b.f) r119).f350404b, ((b.f) r119).f350405c);     // Catch: Throwable -> L158
        goto L133
    L80:
        if ((r119 instanceof b.i) == false) goto L88;
        e r135 = r111.get(((b.i) r119).f350411a);     // Catch: Throwable -> L158
        if (r135 == null) goto L133;
        if (r135.f350423i != ((b.i) r119).f350412b) goto L133;
        r210.e(r111, ((b.i) r119).f350411a, new a0(NetworkTrackOutcome.TIMEOUT, null, 126), ((b.i) r119).f350413c);     // Catch: Throwable -> L158
        goto L133
    L88:
        if ((r119 instanceof b.c) == false) goto L106;
        if (r110.f350390a != null) goto L133;
        r110.f350390a = Boxing.boxLong(((b.c) r119).f350400a);     // Catch: Throwable -> L158
        r110.f350391b = true;     // Catch: Throwable -> L158
        final long r136 = r110.f350393d + 1;     // Catch: Throwable -> L158
        r110.f350393d = r136;     // Catch: Throwable -> L158
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L94
        Object r138 = Result.m9449constructorimpl(r210.f350388k.a(10000, new com.larus.im.internal.tracking.network.e(r210, r136)));     // Catch: Throwable -> L94
    L96:
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);     // Catch: Throwable -> L158
        if (r139 == null) goto L100;
        r210.g(r139);     // Catch: Throwable -> L158
    L100:
        if (Result.m9455isFailureimpl(r138) == false) goto L102;
        r138 = null;
    L102:
        com.larus.im.internal.tracking.network.d r140 = (com.larus.im.internal.tracking.network.d) r138;     // Catch: Throwable -> L158
        r110.f350394e = r140;     // Catch: Throwable -> L158
        if (r140 != null) goto L133;
        r210.d(r110);     // Catch: Throwable -> L158
        goto L133
    L94:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L158
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
        goto L96
    L106:
        if ((r119 instanceof b.d) == false) goto L127;
        if (r110.f350391b == false) goto L133;
        if (r110.f350390a == null) goto L133;
        int r142 = r110.f350392c;     // Catch: Throwable -> L158
        NetworkTrackColdStartStep r143 = ((b.d) r119).f350401a;     // Catch: Throwable -> L158
        int r144 = o.f350432a[r143.ordinal()];     // Catch: Throwable -> L158
        if (r144 != 1) goto L115;
        int r145 = 1;
    L123:
        int r146 = r145 | r142;     // Catch: Throwable -> L158
        r110.f350392c = r146;     // Catch: Throwable -> L158
        if (r146 != 7) goto L133;
        r210.d(r110);     // Catch: Throwable -> L158
        goto L133
    L115:
        if (r144 != 2) goto L117;
        r145 = 2;
        goto L123
    L117:
        if (r144 != 3) goto L120;
        r145 = 4;
        goto L123
    L120:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L158
    L127:
        if ((r119 instanceof b.e) == false) goto L135;
        if (r110.f350391b == false) goto L133;
        if (r110.f350393d != ((b.e) r119).f350402a) goto L133;
        r210.d(r110);     // Catch: Throwable -> L158
        goto L133
    L135:
        if ((r119 instanceof b.a) == false) goto L139;
        ((b.a) r119).getClass();     // Catch: Throwable -> L158
        Unit r147 = Unit.INSTANCE;     // Catch: Throwable -> L158
        throw null;     // Catch: Throwable -> L158
    L139:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L158
    L26:
        if (r111.containsKey(((b.C4377b) r119).f350395a) == false) goto L28;
    L46:
        r100 = r100;
        r103 = r103;
        goto L133
    L28:
        if (r111.size() >= ((f) r210.f350384g.getValue()).f350425a.f350431c) goto L46;
        String r148 = ((b.C4377b) r119).f350396b;     // Catch: Throwable -> L158
        NetworkTrackTransport r149 = ((b.C4377b) r119).f350397c;     // Catch: Throwable -> L158
        long r150 = ((b.C4377b) r119).f350398d;     // Catch: Throwable -> L158
        long r151 = ((b.C4377b) r119).f350399e;     // Catch: Throwable -> L158
        long r152 = ((b.C4377b) r119).f350399e;     // Catch: Throwable -> L158
        Long r153 = r110.f350390a;     // Catch: Throwable -> L158
        if (r153 == null) goto L40;
        long r154 = r153.longValue();     // Catch: Throwable -> L158
        Long r155 = Boxing.boxLong(((b.C4377b) r119).f350399e - r154);     // Catch: Throwable -> L158
        if (r155.longValue() < 0) goto L35;
        boolean r156 = true;
    L36:
        if (r156 == true) goto L39;
        r155 = null;
    L39:
        Long r212 = r155;
    L42:
        if (r110.f350391b == false) goto L44;
        boolean r213 = true;
    L45:
        e r157 = new e(r148, r149, r150, r151, r152, r212, r213);     // Catch: Throwable -> L158
        r111.put(((b.C4377b) r119).f350395a, r157);     // Catch: Throwable -> L158
        r210.h(((b.C4377b) r119).f350395a, r157, ((b.C4377b) r119).f350399e);     // Catch: Throwable -> L158
        goto L133
    L44:
        r213 = false;
        goto L45
    L35:
        r156 = false;
        goto L36
    L40:
        r212 = null;
        goto L42
    L140:
        r210.f350387j.cancel(null);
        Iterator<T> r158 = r111.values().iterator();
    L142:
        if (r158.hasNext() == false) goto L144;
        r210.c((e) r158.next());
        goto L142
    L144:
        r111.clear();
        Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L151
        com.larus.im.internal.tracking.network.d r160 = r110.f350394e;     // Catch: Throwable -> L151
        if (r160 == null) goto L148;
        r160.cancel();     // Catch: Throwable -> L151
        Unit r161 = Unit.INSTANCE;     // Catch: Throwable -> L151
    L149:
        Object r162 = Result.m9449constructorimpl(r161);     // Catch: Throwable -> L151
    L153:
        Throwable r163 = Result.m9452exceptionOrNullimpl(r162);
        if (r163 == null) goto L156;
        r210.g(r163);
    L156:
        r110.f350394e = null;
        return Unit.INSTANCE;
    L148:
        r161 = null;
    L151:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L153
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        r108 = new LinkedHashMap();
        r107 = new a(0);
        r106 = r210.f350387j.iterator();     // Catch: Throwable -> L160
    L160:
        th = th;
        r110 = r107;
        r111 = r108;
    L7:
        r100 = new NetworkTrackCenter$consumeCommands$1(r210, r211);
        goto L8
    }

    public final String b(w r110, c0 r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "netConnectedProvider");
        if (f() == true) goto L5;
        return null;
    L5:
        String r100 = r110.f350439a;
        y r101 = ((f) this.f350384g.getValue()).f350426b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "path");
        Double r102 = r101.f350449b.f350451b.get(r100);
        if (r102 == null) goto L8;
        double r103 = r102.doubleValue();
    L10:
        if (r103 < 1.0d) goto L12;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        return null;
    L20:
        ((com.larus.im.internal.tracking.network.g) this.f350379b).getClass();
        String r105 = com.flow.kmp.common.util.i.a();
        Channel<b> r112 = this.f350387j;
        NetworkTrackTransport r106 = r110.f350440b;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L23
        Object r114 = Result.m9449constructorimpl(r111.invoke());     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r114) == false) goto L28;
        r114 = null;
    L28:
        Long r115 = (Long) r114;
        if (r115 != null) goto L32;
    L33:
        if (r115 != null) goto L36;
    L38:
        long r116 = -1;
    L40:
        Object r117 = r112.mo10962trySendJP2dKIU(new b.C4377b(r105, r100, r106, r116, this.f350378a.elapsedRealtime()));
        kotlinx.coroutines.channels.g.c r118 = kotlinx.coroutines.channels.g.f504696b;
        if ((!(r117 instanceof kotlinx.coroutines.channels.g.c)) == true) goto L43;
        return null;
    L43:
        return r105;
    L36:
        if (r115.longValue() != 1) goto L38;
    L39:
        r116 = r115.longValue();
        goto L40
    L32:
        if (r115.longValue() == 0) goto L39;
    L23:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L12:
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        ((com.larus.im.internal.tracking.network.f) r101.f350448a).getClass();
        if (Random.Default.nextDouble() < r103) goto L17;
    L16:
        r104 = false;
        goto L18
    L8:
        r103 = r101.f350449b.f350450a;
        goto L10
    }

    public k(CoroutineScope r100, final n r110, final l r111) {
        j r101 = new j(com.larus.im.internal.delegate.c.f348197a);
        final u r102 = new com.larus.im.internal.tracking.network.f();
        r r103 = new com.larus.im.internal.tracking.network.g();
        com.larus.im.internal.tracking.network.b r104 = com.larus.im.internal.tracking.network.b.f350340a;
        com.larus.im.internal.tracking.network.a r105 = com.larus.im.internal.tracking.network.a.f350332a;
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r101, "clock");
        Intrinsics.checkNotNullParameter(r102, "random");
        Intrinsics.checkNotNullParameter(r103, "idGenerator");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        Intrinsics.checkNotNullParameter(r105, "errorLogger");
        this.f350378a = r101;
        this.f350379b = r103;
        this.f350380c = r104;
        this.f350381d = r105;
        this.f350382e = 60000;
        this.f350383f = 90000;
        this.f350384g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new i(this, r102, r111, r110));
        CompletableJob r112 = SupervisorKt.SupervisorJob((Job) r100.getCoroutineContext().get(Job.Key));
        this.f350385h = r112;
        CoroutineScope r106 = CoroutineScopeKt.CoroutineScope(r100.getCoroutineContext().plus(r112));
        this.f350386i = r106;
        this.f350387j = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f350388k = new d(r106);
        this.f350389l = BuildersKt.launch$default(r106, null, null, new NetworkTrackCenter$consumerJob$1(this, null), 3, null);
    }

    public final void h(final String r100, e r101, long r110) {
        long r102 = r101.f350419e;
        if (r110 >= r102) goto L5;
        return;
    L5:
        if (r110 == r102) goto L7;
    L9:
        r101.f350419e = r110;
        c(r101);
        final long r103 = r101.f350423i + 1;
        r101.f350423i = r103;
        NetworkTrackTransport r104 = r101.f350416b;
        int r105 = g.f350427a[r104.ordinal()];
        if (r105 != 1) goto L12;
        long r106 = this.f350382e;
    L17:
        long r107 = RangesKt.coerceAtLeast(this.f350378a.elapsedRealtime() - r110, 0);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L20
        Object r109 = Result.m9449constructorimpl(this.f350388k.a(RangesKt.coerceAtLeast(r106 - r107, 0), new h(this, r100, r103)));     // Catch: Throwable -> L20
    L22:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L26;
        g(r111);
    L26:
        if (Result.m9455isFailureimpl(r109) == false) goto L28;
        r109 = null;
    L28:
        r101.f350424j = (com.larus.im.internal.tracking.network.d) r109;
        return;
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L12:
        if (r105 != 2) goto L15;
        r106 = this.f350383f;
        goto L17
    L15:
        throw new NoWhenBranchMatchedException();
    L7:
        if (r101.f350424j == null) goto L9;
    }

    public final void e(Map<String, e> r410, String r510, a0 r511, long r512) {
        e r100 = r410.remove(r510);
        if (r100 != null) goto L5;
        return;
    L5:
        c(r100);
        x r101 = r100.f350422h;
        Long r102 = r511.f350334b;
        Long r103 = r511.f350335c;
        String r104 = r511.f350336d;
        Long r105 = r511.f350338f;
        Long r106 = r511.f350339g;
        if (r102 != null) goto L8;
        r102 = r101.f350442a;
    L8:
        if (r103 != null) goto L10;
        r103 = r101.f350443b;
    L10:
        if (r104 != null) goto L12;
        r104 = r101.f350444c;
    L12:
        if (r105 != null) goto L14;
        r105 = r101.f350445d;
    L14:
        if (r106 != null) goto L16;
        r106 = r101.f350446e;
    L16:
        s r107 = r511.f350337e;
        if (r107 == null) goto L19;
        s r110 = new s(t.a(r107.f350433a), t.a(r107.f350434b), t.a(r107.f350435c), t.a(r107.f350436d), t.a(r107.f350437e), t.a(r107.f350438f));
    L20:
        boolean r108 = true;
        if (r102 == null) goto L33;
        long r111 = r102.longValue();
        LongRange r112 = f350375m;
        long r113 = r112.getFirst();
        if (r111 <= r112.getLast()) goto L25;
    L27:
        boolean r114 = false;
    L28:
        if (r114 == false) goto L30;
        Long r115 = r102;
    L31:
        if (r115 == null) goto L33;
        long r210 = r115.longValue();
    L34:
        NetworkTrackTransport r116 = r100.f350416b;
        if (r116 != NetworkTrackTransport.HTTP) goto L37;
        boolean r117 = true;
    L38:
        if (r117 == false) goto L40;
        s r118 = r110;
    L41:
        String r119 = r100.f350415a;
        String r120 = r116.getValue();
        long r109 = r100.f350417c;
        if (r104 != null) goto L44;
        r104 = "";
    L44:
        String r211 = r104;
        if (r103 != null) goto L47;
    L56:
        if (r102 == null) goto L75;
        long r121 = r102.longValue();
        LongRange r122 = f350375m;
        long r123 = r122.getFirst();
        if (r121 <= r122.getLast()) goto L60;
    L62:
        boolean r124 = false;
    L63:
        if (r124 == true) goto L66;
        r102 = null;
    L66:
        if (r102 == null) goto L75;
        long r125 = r102.longValue();
        LongRange r126 = f350376n;
        long r127 = r126.getFirst();
        if (r125 <= r126.getLast()) goto L70;
    L72:
        boolean r128 = false;
    L73:
        if (r128 == true) goto L74;
    L55:
        long r212 = r125;
    L76:
        Long r129 = Long.valueOf(r512 - r100.f350418d);
        if (r129.longValue() < 0) goto L79;
        boolean r130 = true;
    L80:
        if (r130 == true) goto L83;
        r129 = null;
    L83:
        if (r129 == null) goto L85;
        long r213 = r129.longValue();
    L86:
        if (r118 == null) goto L90;
        Long r131 = r118.f350433a;
        if (r131 == null) goto L90;
        long r214 = r131.longValue();
    L91:
        if (r118 == null) goto L95;
        Long r132 = r118.f350434b;
        if (r132 == null) goto L95;
        long r310 = r132.longValue();
    L96:
        if (r118 == null) goto L100;
        Long r133 = r118.f350435c;
        if (r133 == null) goto L100;
        long r311 = r133.longValue();
    L101:
        if (r118 == null) goto L105;
        Long r134 = r118.f350436d;
        if (r134 == null) goto L105;
        long r312 = r134.longValue();
    L106:
        if (r118 == null) goto L110;
        Long r135 = r118.f350437e;
        if (r135 == null) goto L110;
        long r313 = r135.longValue();
    L111:
        if (r118 == null) goto L115;
        Long r136 = r118.f350438f;
        if (r136 == null) goto L115;
        long r314 = r136.longValue();
    L116:
        if (r105 != null) goto L118;
    L126:
        long r411 = -1;
    L127:
        if (r106 != null) goto L129;
    L137:
        long r412 = -1;
    L138:
        Long r137 = r100.f350420f;
        if (r137 == null) goto L141;
        long r413 = r137.longValue();
    L142:
        com.larus.im.internal.tracking.network.c r138 = new com.larus.im.internal.tracking.network.c(r119, r120, r109, r211, r210, r212, r213, r214, r310, r311, r312, r313, r314, r411, r412, r413, r100.f350421g);
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L145
        this.f350380c.a(r138);     // Catch: Throwable -> L145
        Object r140 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L145
    L147:
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L153;
        g(r141);
        return;
    L153:
        return;
    L145:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L147
    L141:
        r413 = -1;
        goto L142
    L129:
        if (r106.longValue() >= 0) goto L132;
        r108 = false;
    L132:
        if (r108 == true) goto L135;
        r106 = null;
    L135:
        if (r106 == null) goto L137;
        r412 = r106.longValue();
        goto L138
    L118:
        if (r105.longValue() < 0) goto L120;
        boolean r143 = true;
    L121:
        if (r143 == true) goto L124;
        r105 = null;
    L124:
        if (r105 == null) goto L126;
        r411 = r105.longValue();
        goto L127
    L120:
        r143 = false;
    L115:
        r314 = -1;
    L110:
        r313 = -1;
    L105:
        r312 = -1;
    L100:
        r311 = -1;
    L95:
        r310 = -1;
    L90:
        r214 = -1;
        goto L91
    L85:
        r213 = -1;
        goto L86
    L79:
        r130 = false;
        goto L80
    L74:
        r212 = 0;
        goto L76
    L70:
        if (r127 > r125) goto L72;
        r128 = true;
        goto L73
    L60:
        if (r123 > r121) goto L62;
        r124 = true;
    L75:
        r212 = -1;
        goto L76
    L47:
        if (r103.longValue() == 0) goto L49;
        boolean r144 = true;
    L50:
        if (r144 == true) goto L53;
        r103 = null;
    L53:
        if (r103 == null) goto L56;
        r125 = r103.longValue();
        goto L55
    L49:
        r144 = false;
        goto L50
    L40:
        r118 = null;
        goto L41
    L37:
        r117 = false;
        goto L38
    L30:
        r115 = null;
        goto L31
    L25:
        if (r113 > r111) goto L27;
        r114 = true;
    L33:
        r210 = -1;
        goto L34
    L19:
        r110 = null;
        goto L20
    }
}
