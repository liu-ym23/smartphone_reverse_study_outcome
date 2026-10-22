package com.larus.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.SieveCacheKt;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes30.dex */
public final class AudioPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f358891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioTrack f358892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.media.d f358893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f358894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f358895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f358896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f358897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f358898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedBlockingQueue<c> f358899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f358900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Thread f358901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f358902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f358903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f358904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super w, Unit> f358905o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super byte[], Unit> f358906p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile Function2<? super Long, ? super Long, Unit> f358907q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public qk9.c f358908r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public qk9.b f358909s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f358910t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FirstFramePlayoutState f358911u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f358912v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile long f358913w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicLong f358914x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicLong f358915y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f358916z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/media/AudioPlayer$FirstFramePlayoutState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ARMED", "REPORTED", "FINISHED_PENDING", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FirstFramePlayoutState extends Enum<FirstFramePlayoutState> {
        public static final FirstFramePlayoutState ARMED = null;
        public static final FirstFramePlayoutState FINISHED_PENDING = null;
        public static final FirstFramePlayoutState IDLE = null;
        public static final FirstFramePlayoutState REPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FirstFramePlayoutState[] f358917a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f358918b = null;

        public static EnumEntries<FirstFramePlayoutState> getEntries() {
            return f358918b;
        }

        static {
            FirstFramePlayoutState r100 = new FirstFramePlayoutState("IDLE", 0);
            IDLE = r100;
            FirstFramePlayoutState r101 = new FirstFramePlayoutState("ARMED", 1);
            ARMED = r101;
            FirstFramePlayoutState r102 = new FirstFramePlayoutState("REPORTED", 2);
            REPORTED = r102;
            FirstFramePlayoutState r103 = new FirstFramePlayoutState("FINISHED_PENDING", 3);
            FINISHED_PENDING = r103;
            FirstFramePlayoutState[] r104 = {r100, r101, r102, r103};
            f358917a = r104;
            f358918b = EnumEntriesKt.enumEntries(r104);
        }

        public static FirstFramePlayoutState[] values() {
            return (FirstFramePlayoutState[]) f358917a.clone();
        }

        public static FirstFramePlayoutState valueOf(String r100) {
            return (FirstFramePlayoutState) r27.a.a(FirstFramePlayoutState.class, r100);
        }

        public FirstFramePlayoutState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f358919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f358920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f358921c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f358919a, r101.f358919a) == true) goto L12;
            return false;
        L12:
            if (this.f358920b == r101.f358920b) goto L15;
            return false;
        L15:
            if (this.f358921c == r101.f358921c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f358919a.hashCode() * 31) + this.f358920b) * 31;
            long r101 = this.f358921c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "FirstFrameMarkerRequest(data=" + this.f358919a + ", markerPosition=" + this.f358920b + ", generation=" + this.f358921c + ')';
        }

        public b(w r100, int r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f358919a = r100;
            this.f358920b = r101;
            this.f358921c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f358922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f358923b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f358922a, r101.f358922a) == true) goto L12;
            return false;
        L12:
            if (this.f358923b == r101.f358923b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f358922a.hashCode() * 31;
            long r101 = this.f358923b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "QueuedPCMData(data=" + this.f358922a + ", epoch=" + this.f358923b + ')';
        }

        public c(w r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f358922a = r100;
            this.f358923b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f358924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f358925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f358926c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f358924a, r101.f358924a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f358925b, r101.f358925b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f358926c, r101.f358926c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((Arrays.hashCode(this.f358924a) * 31) + Arrays.hashCode(this.f358925b)) * 31) + this.f358926c.hashCode();
        }

        public final String toString() {
            return "TrackChunk(sourceData=" + Arrays.toString(this.f358924a) + ", trackData=" + Arrays.toString(this.f358925b) + ", plan=" + this.f358926c + ')';
        }

        public d(byte[] r100, byte[] r101, g r102) {
            Intrinsics.checkNotNullParameter(r100, "sourceData");
            Intrinsics.checkNotNullParameter(r101, "trackData");
            Intrinsics.checkNotNullParameter(r102, "plan");
            this.f358924a = r100;
            this.f358925b = r101;
            this.f358926c = r102;
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f358927a = null;

        static {
            int[] r100 = new int[FirstFramePlayoutState.values().length];
            r100[FirstFramePlayoutState.ARMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FirstFramePlayoutState.REPORTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f358927a = r100;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f358928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f358929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f358930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f358931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f358932e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f358933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f358934g;

        public f() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f358928a == r101.f358928a) goto L12;
            return false;
        L12:
            if (this.f358929b == r101.f358929b) goto L15;
            return false;
        L15:
            if (this.f358930c == r101.f358930c) goto L18;
            return false;
        L18:
            if (this.f358931d == r101.f358931d) goto L21;
            return false;
        L21:
            if (this.f358932e == r101.f358932e) goto L24;
            return false;
        L24:
            if (this.f358933f == r101.f358933f) goto L27;
            return false;
        L27:
            if (this.f358934g == r101.f358934g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f358928a * 31;
            long r101 = this.f358929b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f358930c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f358931d;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.f358932e;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            long r109 = this.f358933f;
            int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
            long r111 = this.f358934g;
            return r110 + ((int) (r111 ^ (r111 >>> 32)));
        }

        public final String toString() {
            return "WorkerLoopTrace(writeCalls=" + this.f358928a + ", maxChunkWriteCostMs=" + this.f358929b + ", audioTrackDumpCostMs=" + this.f358930c + ", referenceCallbackCostMs=" + this.f358931d + ", monitorConsumedCostMs=" + this.f358932e + ", consumedMs=" + this.f358933f + ", writtenMs=" + this.f358934g + ')';
        }

        public f(int r100) {
            this.f358928a = 0;
            this.f358929b = 0;
            this.f358930c = 0;
            this.f358931d = 0;
            this.f358932e = 0;
            this.f358933f = 0;
            this.f358934g = 0;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f358935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f358936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f358937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f358938d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f358939e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f358940f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f358941g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f358942h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f358935a == r101.f358935a) goto L12;
            return false;
        L12:
            if (this.f358936b == r101.f358936b) goto L15;
            return false;
        L15:
            if (this.f358937c == r101.f358937c) goto L18;
            return false;
        L18:
            if (this.f358938d == r101.f358938d) goto L21;
            return false;
        L21:
            if (this.f358939e == r101.f358939e) goto L24;
            return false;
        L24:
            if (this.f358940f == r101.f358940f) goto L27;
            return false;
        L27:
            if (this.f358941g == r101.f358941g) goto L30;
            return false;
        L30:
            if (this.f358942h == r101.f358942h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((this.f358935a * 31) + this.f358936b) * 31) + this.f358937c) * 31) + this.f358938d) * 31) + this.f358939e) * 31) + this.f358940f) * 31;
            int r101 = 1231;
            if (this.f358941g == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f358942h == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "WritePlan(maxSourceBytesPerWrite=" + this.f358935a + ", maxTrackBytesPerWrite=" + this.f358936b + ", framesPerWrite=" + this.f358937c + ", sourceBytesPerFrame=" + this.f358938d + ", resampledBytesPerFrame=" + this.f358939e + ", trackBytesPerFrame=" + this.f358940f + ", resampleToTrackRate=" + this.f358941g + ", expandMonoToStereo=" + this.f358942h + ')';
        }

        public g(int r100, int r101, int r102, int r103, int r104, int r105, boolean r106, boolean r107) {
            this.f358935a = r100;
            this.f358936b = r101;
            this.f358937c = r102;
            this.f358938d = r103;
            this.f358939e = r104;
            this.f358940f = r105;
            this.f358941g = r106;
            this.f358942h = r107;
        }
    }

    public static final class h implements AudioTrack.OnPlaybackPositionUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioPlayer f358943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f358944b;

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public final void onPeriodicNotification(AudioTrack r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public final void onMarkerReached(AudioTrack r110) {
            Intrinsics.checkNotNullParameter(r110, "t");
            long r100 = System.currentTimeMillis();
            AudioPlayer r111 = this.f358943a;
            Object r101 = r111.f358903m;
            b r102 = this.f358944b;
            monitor-enter(r101);
            FirstFramePlayoutState r103 = r111.f358911u;     // Catch: Throwable -> L41
            boolean r104 = false;
            if (r103 != FirstFramePlayoutState.ARMED) goto L7;
        L10:
            boolean r105 = true;
        L11:
            long r106 = r111.f358915y.get();     // Catch: Throwable -> L41
            long r112 = r102.f358921c;     // Catch: Throwable -> L41
            Long r107 = null;
            if (r106 != r112) goto L21;
            if (r105 == false) goto L21;
            if (r111.f358911u != FirstFramePlayoutState.FINISHED_PENDING) goto L18;
            FirstFramePlayoutState r108 = FirstFramePlayoutState.IDLE;     // Catch: Throwable -> L41
        L19:
            r111.f358911u = r108;     // Catch: Throwable -> L41
            Function2<? super Long, ? super Long, Unit> r113 = r111.f358907q;     // Catch: Throwable -> L41
        L22:
            monitor-exit(r101);
            if (r113 != null) goto L25;
            return;
        L25:
            Long r109 = Long.valueOf(this.f358944b.f358919a.f359149d.f359154e);
            if (r109.longValue() <= 0) goto L28;
            r104 = true;
        L28:
            if (r104 == false) goto L30;
            r107 = r109;
        L30:
            if (r107 == null) goto L32;
            long r114 = r107.longValue();
        L44:
            Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L35
            r113.invoke(Long.valueOf(r100), Long.valueOf(r114));     // Catch: Throwable -> L35
            Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
        L37:
            AudioPlayer r117 = this.f358943a;
            Throwable r118 = Result.m9452exceptionOrNullimpl(r116);
            if (r118 == null) goto L48;
            com.larus.im.internal.delegate.c0.f348199b.e(r117.f358891a, "firstFramePlayoutCallback failed, " + r118);
            return;
        L48:
            return;
        L35:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L37
        L32:
            r114 = this.f358944b.f358919a.f359149d.f359153d;
            goto L44
        L18:
            r108 = FirstFramePlayoutState.REPORTED;     // Catch: Throwable -> L41
        L21:
            r113 = null;
            goto L22
        L7:
            if (r103 == FirstFramePlayoutState.FINISHED_PENDING) goto L10;
            r105 = false;
        L41:
            th = move-exception;
            throw th;
        }

        public h(AudioPlayer r100, b r101) {
            this.f358943a = r100;
            this.f358944b = r101;
        }
    }

    static {
    }

    public final void A() {
        com.larus.im.internal.delegate.c0 r100 = com.larus.im.internal.delegate.c0.f348199b;
        r100.i(this.f358891a, "pause");
        AudioTrack r101 = this.f358892b;
        if (r101 != null) goto L25;
        r100.e(this.f358891a, "pause: audioTrack is null");
        return;
    L25:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        if (r101.getPlayState() == 3) goto L9;
        r100.i(this.f358891a, "pause: audioTrack is not playing: " + r101.getPlayState());     // Catch: Throwable -> L19
    L17:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L27;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "pause: audioTrack operation failed, " + r104);
        p();
        return;
    L27:
        return;
    L9:
        if (fna.g.d() == true) goto L11;
        r101.pause();     // Catch: Throwable -> L19
    L12:
        qk9.b r105 = this.f358909s;     // Catch: Throwable -> L19
        if (r105 == null) goto L15;
        r105.b("pause");     // Catch: Throwable -> L19
    L15:
        r100.i(this.f358891a, "pause: audioTrack paused successfully");     // Catch: Throwable -> L19
        goto L17
    L11:
        r101.pause();     // Catch: Throwable -> L19
        gna.a.a(r101.hashCode());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public final void B() {
        long r110 = SystemClock.elapsedRealtime();
        qk9.c r100 = this.f358908r;
        long r111 = 0;
        if (r100 == null) goto L13;
        long r101 = SystemClock.elapsedRealtime();
        if (r100.f533611j.get() == true) goto L7;
        r100.G.set(0);
        long r102 = 0;
    L12:
        long r103 = r102;
    L14:
        int r112 = this.f358899i.size();
        AudioPlayer r104 = this;
    L16:
        if (r104.f358900j.get() == false) goto L91;
        if (I() == true) goto L91;
        long r105 = k();
        if (r104.f358897g.get() == r105) goto L91;
        if (Build.VERSION.SDK_INT >= 26) goto L311;
        boolean r106 = false;
    L39:
        if (r106 == false) goto L91;
    L41:
        long r113 = r111;
    L43:
        if (r104.f358900j.get() == false) goto L89;
        if (k() != r105) goto L89;
        Iterator<c> r107 = r104.f358899i.iterator();
        long r210 = r111;
    L48:
        if (r107.hasNext() == false) goto L56;
        c r108 = r107.next();
        long r211 = r103;
        if (r108.f358923b != r105) goto L55;
        w r109 = r108.f358922a;
        r210 = r210 + ((long) r109.f359146a.length);
        if (r109.f359148c == false) goto L55;
        boolean r114 = true;
    L57:
        if (r114 == true) goto L58;
        if (r210 <= r111) goto L63;
        long r115 = SystemClock.elapsedRealtime();
        if (r113 > r111) goto L67;
        r113 = r115;
    L67:
        g r116 = r104.f358894d;
        if (r116 != null) goto L70;
        r116 = j();
        r104.f358894d = r116;
    L70:
        int r117 = r104.f358893c.f359013c;
        if (r117 <= 0) goto L75;
        int r118 = r116.f358938d;
        if (r118 <= 0) goto L75;
        long r119 = (r210 * 1000) / (((long) r117) * ((long) r118));
    L77:
        if ((r115 - r113) < 40) goto L79;
        boolean r120 = true;
    L81:
        if (r119 >= 40) goto L85;
        if (r120 == true) goto L85;
        Thread.sleep(5);
        r111 = 0;
        r103 = r211;
    L85:
        r104.f358897g.set(r105);
        if (k() == r105) goto L93;
        long r121 = r211;
        long r122 = 0;
    L302:
        r103 = r121;
        r111 = r122;
        r110 = r110;
        r112 = r112;
    L93:
        if (I() == false) goto L124;
        c r123 = r104.f358899i.poll(5, TimeUnit.MILLISECONDS);
        if (r123 == null) goto L96;
    L126:
        if (r123.f358923b == k()) goto L127;
        r121 = r211;
        r122 = 0;
        r104 = this;
        goto L302
    L127:
        c r124 = r123;
    L128:
        if (r124 != null) goto L130;
        return;
    L130:
        w r125 = r124.f358922a;
        r125.f359149d.f359152c = System.currentTimeMillis();
        long r126 = SystemClock.elapsedRealtime();
        f r127 = new f(0);
        w r128 = r124.f358922a;
        AudioTrack r129 = r104.f358892b;
        if (r129 != null) goto L133;
        com.larus.im.internal.delegate.c0.f348199b.w(r104.f358891a, "writeToAudioTrack: audioTrack is null");
    L169:
        AudioPlayer r130 = r104;
        r110 = r110;
        r125 = r125;
        r112 = r112;
        long r310 = r211;
        int r131 = 0;
        f r132 = r127;
    L236:
        long r133 = SystemClock.elapsedRealtime();
        qk9.c r134 = r130.f358908r;
        if (r134 == null) goto L343;
        long r135 = r133 - r110;
        long r136 = r126 - r110;
        long r137 = r133 - r126;
        int r138 = r130.f358899i.size();
        int r139 = r125.f359146a.length;
        int r140 = r132.f358928a;
        long r141 = r132.f358929b;
        long r142 = r132.f358930c;
        long r143 = r132.f358931d;
        long r144 = r132.f358932e;
        long r145 = r132.f358933f;
        long r146 = r132.f358934g;
        if (r134.f533611j.get() == false) goto L344;
        qk9.b r147 = r134.I;
        if (r147 == null) goto L244;
        r147.f533600y.set(r138);
    L244:
        long r148 = (r142 + r143) + r144;
        qk9.b r149 = r134.I;
        if (r149 == null) goto L247;
        qk9.b.g(r149.X, r310);
        qk9.b.g(r149.Y, r135);
        qk9.b.g(r149.Z, r136);
        long r150 = r137;
        qk9.b.g(r149.f533570a0, r150);
        qk9.b.g(r149.f533572b0, r148);
        qk9.b.g(r149.f533574c0, r142);
        qk9.b.g(r149.f533576d0, r143);
    L248:
        qk9.c.h(r134.f533624w, r135);
        qk9.c.h(r134.f533625x, r136);
        qk9.c.h(r134.f533626y, r150);
        qk9.c.h(r134.f533627z, r148);
        qk9.c.h(r134.A, r142);
        qk9.c.h(r134.B, r143);
        if (r146 > 0) goto L251;
    L253:
        boolean r151 = false;
    L255:
        if (r148 < 35) goto L257;
        boolean r152 = true;
    L259:
        if (r136 < 35) goto L261;
        boolean r311 = true;
    L263:
        if (r310 < 35) goto L268;
        if (r146 > 0) goto L266;
    L267:
        boolean r153 = true;
    L269:
        long r154 = RangesKt.coerceAtLeast(((r135 - r136) - r150) - r148, 0);
        if (r154 < 35) goto L272;
        boolean r155 = true;
    L273:
        if (r153 == true) goto L278;
        if (r311 == true) goto L278;
        if (r151 == true) goto L278;
        if (r152 == true) goto L278;
        if (r155 == true) goto L278;
    L279:
        if (r131 != 0) goto L282;
        return;
    L282:
        if (qk9.c.f(r134.f533609h, SystemClock.elapsedRealtime(), 200) == false) goto L346;
        if (r151 == false) goto L286;
        String r156 = "track_write";
    L299:
        com.larus.im.internal.delegate.c0.f348199b.w(r134.f533602a, "monitor_loop_jank: reason=" + r156 + " round=" + r134.f533610i.get() + " loopGapMs=" + r310 + " loopCostMs=" + r135 + " takeWaitMs=" + r136 + " writeToTrackCostMs=" + r150 + " maxChunkWriteCostMs=" + r141 + " postWriteCostMs=" + r148 + " audioTrackDumpCostMs=" + r142 + " referenceCallbackCostMs=" + r143 + " monitorConsumedCostMs=" + r144 + " trackWriteMarginMs=10 workerLoopOverheadMs=" + r154 + " queueBeforeTake=" + r112 + " queueAfterWrite=" + r138 + " queueMs=" + r134.f533619r.get() + " dataBytes=" + r139 + " writeCalls=" + r140 + " consumedMs=" + r145 + " writtenMs=" + r146);
        return;
    L286:
        if (r152 == false) goto L288;
        r156 = "post_callback";
        goto L299
    L288:
        if (r311 == false) goto L291;
        if (r112 <= 0) goto L291;
        r156 = "take_blocked_with_queue";
    L291:
        if (r311 == false) goto L293;
        r156 = "take_wait_no_data";
        goto L299
    L293:
        if (r153 == false) goto L296;
        if (r112 <= 0) goto L296;
        r156 = "scheduler_before_loop";
    L296:
        if (r155 == false) goto L298;
        r156 = "worker_loop_total";
        goto L299
    L298:
        r156 = "unknown";
        goto L299
    L346:
        return;
    L278:
        r131 = 1;
        goto L279
    L272:
        r155 = false;
        goto L273
    L266:
        if (r310 > (r146 + 10)) goto L267;
    L268:
        r153 = false;
        goto L269
    L261:
        r311 = false;
        goto L263
    L257:
        r152 = false;
        goto L259
    L251:
        if (r150 <= (r146 + 10)) goto L253;
        r151 = true;
        goto L255
    L247:
        r150 = r137;
        goto L248
    L344:
        return;
    L343:
        return;
    L133:
        boolean r157 = true;
        if (r129.getState() == 1) goto L137;
        com.larus.im.internal.delegate.c0.f348199b.e(r104.f358891a, "writeToAudioTrack: audioTrack not initialized, state: " + r129.getState());
        p();
        r157 = false;
    L137:
        if (r157 == false) goto L169;
        if (r124.f358923b != r104.k()) goto L142;
        boolean r158 = true;
    L143:
        if (r158 == false) goto L169;
        if (r128.f359146a.length != 0) goto L148;
        boolean r159 = true;
    L149:
        if (r159 == true) goto L151;
    L156:
        g r160 = r104.f358894d;
        if (r160 != null) goto L159;
        r160 = j();
        r104.f358894d = r160;
        com.larus.im.internal.delegate.c0.f348199b.w(r104.f358891a, "write_plan_fallback: create write plan during playback, plan=" + r160);
    L159:
        g r161 = r160;
        int r162 = 0;
    L161:
        if (r162 >= r128.f359146a.length) goto L228;
        if (r104.f358900j.get() == false) goto L228;
        if (r124.f358923b != r104.k()) goto L167;
        boolean r163 = true;
    L168:
        if (r163 == false) goto L169;
        int r164 = r128.f359146a.length - r162;
        int r165 = RangesKt.coerceAtMost(r164, r161.f358935a);
        int r166 = r104.a(r165, r161.f358938d, "next_source_write_size");
        if (r166 != 0) goto L175;
        if (r164 <= 0) goto L175;
        com.larus.im.internal.delegate.c0.f348199b.w(r104.f358891a, "write_size_fallback: aligned source write size is zero, remaining=" + r164 + ", rawSourceWriteBytes=" + r165 + ", sourceBytesPerFrame=" + r161.f358938d + ", plan=" + r161);
    L175:
        if (r166 <= 0) goto L176;
        if (r129.getPlayState() != 3) goto L180;
        boolean r167 = true;
        long r168 = 5;
    L187:
        if (r167 == true) goto L309;
        g r312 = r161;
        r130 = r104;
        AudioTrack r313 = r129;
        r310 = r211;
        r132 = r127;
        w r169 = r128;
    L226:
        r104 = r130;
        r127 = r132;
        r128 = r169;
        r112 = r112;
        r125 = r125;
        r110 = r110;
        r161 = r312;
        r129 = r313;
        r211 = r310;
        goto L161
    L309:
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L209
        w r171 = r124.f358922a;     // Catch: Throwable -> L209
        d r172 = r104.i(r171.f359146a, r162, r166, r161);     // Catch: Throwable -> L209
        if (r124.f358923b == k()) goto L192;
        int r314 = r162;
        r312 = r161;
        r130 = r104;
        r313 = r129;
        r310 = r211;
        r131 = 0;
        r132 = r127;
        r169 = r128;
    L202:
        Integer r173 = null;
    L220:
        if (r173 == null) goto L227;
        r162 = r314 + r173.intValue();
        if (r162 < r169.f359146a.length) goto L226;
        if (r169.f359148c == false) goto L226;
        r130.n("final_frame");
        goto L226
    L227:
        int r174 = r314;
    L230:
        if (r174 < r169.f359146a.length) goto L236;
        if (r130.f358899i.isEmpty() == false) goto L236;
        if (r169.f359148c == true) goto L236;
        r130.f358897g.set(-1);
        goto L236
    L192:
        long r175 = r104.f358913w;     // Catch: Throwable -> L209
        int r176 = r104.P(r129, r172.f358925b, r127);     // Catch: Throwable -> L209
        if (r176 <= 0) goto L199;
        if (r171.f359149d.f359153d > 0) goto L199;
        r171.f359149d.f359153d = System.currentTimeMillis();     // Catch: Throwable -> L207
    L207:
        th = th;
        r314 = r162;
        r312 = r161;
        r130 = r104;
        r313 = r129;
        r132 = r127;
        r169 = r128;
        r310 = r211;
        r131 = 0;
    L211:
        Result.Companion r177 = Result.Companion;
        Object r178 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L212:
        Throwable r179 = Result.m9452exceptionOrNullimpl(r178);
        if (r179 == null) goto L219;
        com.larus.im.internal.delegate.c0.f348199b.e(r130.f358891a, "writeToAudioTrack: unexpected error, " + r179);
        if ((r179 instanceof IllegalStateException) == false) goto L218;
        p();
        r178 = null;
        goto L219
    L218:
        Thread.sleep(10);
        r178 = Integer.valueOf(r131);
    L219:
        r173 = (Integer) r178;
    L199:
        r131 = 0;
        r314 = r162;
        r312 = r161;
        r130 = r104;
        r313 = r129;
        r132 = r127;
        r169 = r128;
        r310 = r211;
        O(r129, r171, r176, r172.f358926c, r124.f358923b, r175);     // Catch: Throwable -> L205
        if (r124.f358923b != k()) goto L202;
        r178 = Result.m9449constructorimpl(q(r171, r172, r176, r124.f358923b, r132));     // Catch: Throwable -> L205
    L205:
        th = th;
    L209:
        th = th;
        r314 = r162;
        r312 = r161;
        r130 = r104;
        r313 = r129;
        r310 = r211;
        r131 = 0;
        r132 = r127;
        r169 = r128;
        goto L211
    L180:
        qk9.c r180 = r104.f358908r;
        if (r180 == null) goto L186;
        int r181 = r104.f358899i.size();
        qk9.b r182 = r180.I;
        if (r182 == null) goto L185;
        r182.f533600y.set(r181);
    L185:
        r180.F.incrementAndGet();
        r180.c(SystemClock.elapsedRealtime(), r181);
    L186:
        r168 = 5;
        Thread.sleep(5);
        r167 = false;
        goto L187
    L176:
        com.larus.im.internal.delegate.c0.f348199b.w(r104.f358891a, "write_size_fallback: invalid sourceWriteBytes=" + r166 + ", remaining=" + r164 + ", offset=" + r162 + ", dataBytes=" + r128.f359146a.length + ", plan=" + r161);
        r174 = r162;
        r130 = r104;
        r132 = r127;
        r169 = r128;
        r310 = r211;
        r131 = 0;
        goto L230
    L167:
        r163 = false;
    L228:
        r174 = r162;
        r130 = r104;
        r110 = r110;
        r125 = r125;
        r112 = r112;
        r310 = r211;
        r131 = 0;
        r132 = r127;
        r169 = r128;
        goto L230
    L151:
        if (r128.f359148c == false) goto L156;
        com.larus.im.internal.delegate.c0.f348199b.i(r104.f358891a, "writeToAudioTrack: final data, size: " + r128.f359146a.length);
        Function1<? super w, Unit> r183 = r104.f358905o;
        if (r183 == null) goto L155;
        r183.invoke(r128);
    L155:
        r104.n("final_empty_frame");
        goto L169
    L148:
        r159 = false;
        goto L149
    L142:
        r158 = false;
        goto L143
    L96:
        com.larus.media.d r184 = r104.f358893c;
        if (r184.f359021k == true) goto L99;
        w r185 = r104.e(r184.f359017g);
    L122:
        c r186 = new c(r185, k());
    L123:
        r124 = r186;
        goto L128
    L99:
        AudioTrack r187 = r104.f358892b;
        if (r187 != null) goto L103;
    L119:
        r185 = null;
    L120:
        if (r185 != null) goto L122;
        r186 = null;
        goto L123
    L103:
        if (r187.getPlayState() != 3) goto L119;
        int r188 = r104.f358893c.f359012b;
        if (r188 <= 0) goto L119;
        long r189 = (((long) r188) * 10) / 1000;
        Result.Companion r190 = Result.Companion;     // Catch: Throwable -> L110
        Object r191 = Result.m9449constructorimpl(Long.valueOf(((long) r187.getPlaybackHeadPosition()) & BodyPartID.bodyIdMax));     // Catch: Throwable -> L110
    L113:
        if (Result.m9455isFailureimpl(r191) == false) goto L115;
        r191 = 0L;
    L115:
        long r192 = RangesKt.coerceAtLeast(r104.f358912v - ((Number) r191).longValue(), 0);
        if (r192 >= r189) goto L119;
        r185 = r104.e(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((r189 - r192) * 1000) / ((long) r104.f358893c.f359012b), 1), 5));
    L110:
        th = move-exception;
        Result.Companion r193 = Result.Companion;
        r191 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L113
    L124:
        r123 = r104.f358899i.take();
        goto L126
    L79:
        r120 = false;
    L75:
        r119 = 0;
        goto L77
    L63:
        Thread.sleep(5);
        r103 = r211;
        goto L41
    L58:
        r104.f358897g.set(r105);
        if (k() == r105) goto L93;
    L90:
        r111 = 0;
        r103 = r211;
    L55:
        r103 = r211;
        goto L48
    L56:
        r211 = r103;
        r114 = false;
    L89:
        r211 = r103;
        goto L90
    L311:
        Result.Companion r194 = Result.Companion;     // Catch: Throwable -> L33
        AudioTrack r195 = r104.f358892b;     // Catch: Throwable -> L33
        if (r195 != null) goto L28;
    L30:
        boolean r196 = false;
    L31:
        Object r197 = Result.m9449constructorimpl(Boolean.valueOf(r196));     // Catch: Throwable -> L33
    L35:
        Boolean r198 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r197) == false) goto L38;
        r197 = r198;
    L38:
        r106 = ((Boolean) r197).booleanValue();
        goto L39
    L28:
        if (r195.getPerformanceMode() != 1) goto L30;
        r196 = true;
    L33:
        th = move-exception;
        Result.Companion r199 = Result.Companion;
        r197 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L91:
        r211 = r103;
        goto L93
    L7:
        long r200 = r100.G.getAndSet(r101);
        if (r200 <= 0) goto L10;
        r102 = r101 - r200;
    L11:
        qk9.c.h(r100.f533623v, r102);
        goto L12
    L10:
        r102 = 0;
        goto L11
    L13:
        r103 = 0;
        goto L14
    }

    public final void F() {
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "resume");
        K();
    }

    public final boolean I() {
        if (this.f358893c.f359020j == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f358898h.get() != k()) goto L7;
        return true;
    }

    public final void K() {
        com.larus.im.internal.delegate.c0 r100 = com.larus.im.internal.delegate.c0.f348199b;
        r100.i(this.f358891a, "start");
        AudioTrack r101 = this.f358892b;
        if (r101 != null) goto L7;
        r100.e(this.f358891a, "start: audioTrack is null");
        return;
    L7:
        if (r101.getState() == 1) goto L37;
        r100.e(this.f358891a, "start: audioTrack is not initialized");
        return;
    L37:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L29
        if (r101.getPlayState() != 3) goto L35;
        r100.i(this.f358891a, "start: audioTrack is already playing");     // Catch: Throwable -> L29
        qk9.c r103 = this.f358908r;     // Catch: Throwable -> L29
        if (r103 == null) goto L27;
        r103.d("already_playing", r101.getPlayState(), this.f358899i.size());     // Catch: Throwable -> L29
    L27:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L39;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "start: audioTrack operation failed, " + r105);
        p();
        return;
    L39:
        return;
    L35:
        r100.w(this.f358891a, "startMediaPlaybackFgs skipped: context is null");     // Catch: Exception -> L15 Throwable -> L29
    L18:
        if (fna.g.d() == true) goto L20;
        r101.play();     // Catch: Throwable -> L29
    L21:
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "start: audioTrack started successfully");     // Catch: Throwable -> L29
        qk9.c r106 = this.f358908r;     // Catch: Throwable -> L29
        if (r106 == null) goto L27;
        r106.d("start", r101.getPlayState(), this.f358899i.size());     // Catch: Throwable -> L29
        goto L27
    L20:
        r101.play();     // Catch: Throwable -> L29
        gna.a.c(r101.hashCode());     // Catch: Throwable -> L29
    L15:
        e = move-exception;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "startMediaPlaybackFgs error, " + e);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    public final void L() {
        if (this.f358900j.get() == false) goto L6;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "startWorkerThread: thread is already running");
        return;
    L6:
        this.f358900j.set(true);
        this.f358901k = ThreadsKt.thread$default(false, false, null, "AvPlayer-Worker", 10, new com.larus.media.c(this), 7, null);
    }

    public final void M() {
        if (this.f358900j.get() == true) goto L6;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "stopWorkerThread: thread is not running");
        return;
    L6:
        this.f358900j.set(false);
        Thread r100 = this.f358901k;
        if (r100 == null) goto L23;
        r100.interrupt();
    L23:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        Thread r102 = this.f358901k;     // Catch: Throwable -> L16
        if (r102 == null) goto L13;
        ThreadMethodProxy.join(r102, 1000);     // Catch: Throwable -> L16
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L16
    L18:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L21;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "Error while waiting for worker thread to stop, " + r105);
    L21:
        this.f358901k = null;
        return;
    L13:
        r103 = null;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final void N() {
        g r100 = this.f358894d;
        if (r100 != null) goto L5;
        return;
    L5:
        qk9.b r101 = this.f358909s;
        if (r101 == null) goto L13;
        int r102 = this.f358893c.f359013c;
        int r103 = r100.f358938d;
        if (r102 <= 0) goto L14;
        if (r103 <= 0) goto L15;
        r101.C.set(r102);
        r101.D.set(r103);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final g j() {
        com.larus.media.d r100 = this.f358893c;
        if (r100.f359016f.f359140a == true) goto L5;
    L9:
        boolean r110 = false;
    L10:
        if (r110 == false) goto L12;
        int r111 = uk9.a.a(r100.f359015e);
    L13:
        if (r110 == false) goto L15;
        int r112 = uk9.a.a(this.f358893c.f359015e) * 2;
    L16:
        com.larus.media.d r101 = this.f358893c;
        if (r101.f359015e == 2) goto L19;
    L26:
        boolean r113 = false;
    L27:
        int r102 = (r101.f359013c * r101.f359017g) / 1000;
        int r103 = RangesKt.coerceAtLeast(r102, 1);
        if (r103 == r102) goto L30;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_size_fallback: invalid framesPerWrite rawFrames=" + r102 + ", sourceSampleRate=" + this.f358893c.f359013c + ", frameDurationMs=" + this.f358893c.f359017g + ", frames=" + r103);
    L30:
        int r104 = r111 * r103;
        return new g(r104, (J(r104, r111, r111) / r111) * r112, r103, r111, r111, r112, r113, r110);
    L19:
        if (r101.f359018h == false) goto L26;
        int r105 = r101.f359013c;
        if (r105 <= 0) goto L26;
        int r106 = r101.f359012b;
        if (r106 <= 0) goto L26;
        if (r105 == r106) goto L26;
        r113 = true;
        goto L27
    L15:
        r112 = r111;
        goto L16
    L12:
        r111 = uk9.a.a(r100.f359015e) * uk9.a.c(r100.f359014d, 1);
        goto L13
    L5:
        if (r100.f359015e != 2) goto L9;
        if (r100.f359014d != 12) goto L9;
        r110 = true;
        goto L10
    }

    public final long k() {
        return this.f358914x.get();
    }

    public final void l() {
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "destroyEngine");
        qk9.b r100 = this.f358909s;
        if (r100 == null) goto L5;
        r100.b(MapMonitorConst.EVENT_DESTROY);
    L5:
        M();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        qk9.c r102 = this.f358908r;     // Catch: Throwable -> L15
        if (r102 == null) goto L9;
        r102.b(MapMonitorConst.EVENT_DESTROY, this.f358899i.size());     // Catch: Throwable -> L15
    L9:
        this.f358908r = null;     // Catch: Throwable -> L15
        this.f358899i.clear();     // Catch: Throwable -> L15
        AudioTrack r103 = this.f358892b;     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        D(r103);     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L15
    L17:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L23;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "destroyEngine error, " + r106);
        this.f358892b = null;
        return;
    L23:
        return;
    L12:
        r104 = null;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final int o() {
        com.larus.media.d r100 = this.f358893c;
        int r101 = AudioTrack.getMinBufferSize(r100.f359012b, r100.f359014d, r100.f359015e);
        if (r101 > 0) goto L6;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "getMinBufferSize returns invalid value: " + r101 + ", using default size");
        return 1280;
    L6:
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "getMinBufferSize: " + r101);
        return r101;
    }

    public final void p() {
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "handleAudioTrackError: attempting to recover");
        this.f358902l.post(new com.larus.media.b(this));
    }

    public final boolean t() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        AudioTrack r101 = this.f358892b;     // Catch: Throwable -> L9
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "isPlaying error, " + r104);
        r103 = Boolean.FALSE;
    L16:
        return ((Boolean) r103).booleanValue();
    L5:
        if (r101.getPlayState() != 3) goto L7;
        r102 = true;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public AudioPlayer() {
        this.f358891a = "FlowIMSDK_AudioPlayer" + hashCode();
        this.f358893c = new com.larus.media.d(null, 0, 0, 0, null, 0, false, false, false, false, false, null, 8191);
        this.f358897g = new AtomicLong(-1);
        this.f358898h = new AtomicLong(-1);
        this.f358899i = new LinkedBlockingQueue(Integer.MAX_VALUE);
        this.f358900j = new AtomicBoolean(false);
        this.f358902l = new Handler(Looper.getMainLooper());
        this.f358903m = new Object();
        this.f358904n = new Object();
        this.f358911u = FirstFramePlayoutState.IDLE;
        this.f358914x = new AtomicLong(0);
        this.f358915y = new AtomicLong(0);
    }

    public static String d(AudioTrack r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L19;
        int r101 = -1;
    L18:
        return " audioTrackUnderrunCount=" + r101;
    L19:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(r100.getUnderrunCount()));     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L15;
        r103 = -2;
    L15:
        r101 = ((Number) r103).intValue();
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void C(com.larus.media.d r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        com.larus.im.internal.delegate.c0 r100 = com.larus.im.internal.delegate.c0.f348199b;
        r100.i(this.f358891a, "reconfigureEngine from " + this.f358893c + " to " + r110);
        boolean r101 = this.f358900j.get();
        boolean r102 = t();
        if (r101 == false) goto L5;
        M();
    L5:
        com.larus.media.d r103 = y(r110);
        AudioTrack r104 = this.f358892b;
        this.f358898h.set(-1);
        if (r104 == null) goto L8;
        D(r104);
    L8:
        this.f358893c = r103;
        this.f358896f = null;
        w(r110.f359017g, r103.f359017g);
        v(r110, r103);
        this.f358894d = j();
        N();
        G(r103.f359022l);
        qk9.c r111 = this.f358908r;
        if (r111 == null) goto L42;
        Intrinsics.checkNotNullParameter(r103, "config");
        r111.f533603b = r103;
        qk9.b r112 = r111.I;
        if (r112 == null) goto L42;
        r112.h(r103);
    L42:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L32
        this.f358895e = o();     // Catch: Throwable -> L32
        r100.i(this.f358891a, "reconfigureEngine, minBufferSize=" + this.f358895e + ", keepQueueSize=" + this.f358899i.size());     // Catch: Throwable -> L32
        AudioTrack r114 = h(r103);     // Catch: Throwable -> L32
        this.f358892b = r114;     // Catch: Throwable -> L32
        if (r114 == null) goto L18;
        boolean r105 = true;
        if (r114.getState() != 1) goto L18;
    L19:
        if (r105 == true) goto L25;
        String r115 = this.f358891a;     // Catch: Throwable -> L32
        StringBuilder r106 = new StringBuilder("AudioTrack reconfiguration failed, state: ");     // Catch: Throwable -> L32
        AudioTrack r107 = this.f358892b;     // Catch: Throwable -> L32
        if (r107 == null) goto L23;
        Integer r108 = Integer.valueOf(r107.getState());     // Catch: Throwable -> L32
    L24:
        r106.append(r108);     // Catch: Throwable -> L32
        r100.e(r115, r106.toString());     // Catch: Throwable -> L32
        this.f358892b = null;     // Catch: Throwable -> L32
    L30:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L37;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "reconfigureEngine error, " + r117);
        this.f358892b = null;
    L37:
        if (r101 == false) goto L39;
        L();
    L39:
        if (r102 == false) goto L44;
        K();
        return;
    L44:
        return;
    L23:
        r108 = null;
        goto L24
    L25:
        int r118 = this.f358895e;     // Catch: Throwable -> L32
        int r109 = uk9.a.c(r103.f359014d, -1);     // Catch: Throwable -> L32
        if (r109 > 0) goto L28;
        long r119 = 0;
    L29:
        u(this.f358892b, r103, r119);     // Catch: Throwable -> L32
        goto L30
    L28:
        r119 = c(r118, uk9.a.a(r103.f359015e) * r109, r103.f359012b);     // Catch: Throwable -> L32
    L18:
        r105 = false;
    L32:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    public final void D(AudioTrack r100) {
        this.f358896f = null;
        s(false);
        Object r101 = this.f358903m;
        monitor-enter(r101);
        this.f358913w++;     // Catch: Throwable -> L29
        this.f358912v = 0;     // Catch: Throwable -> L29
        long r102 = E(true);     // Catch: Throwable -> L29
        monitor-exit(r101);
        g(r100, r102);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        if (r100.getPlayState() == 3) goto L10;
    L13:
        r100.flush();     // Catch: Throwable -> L15
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L32;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "Error during stop/flush in destroyEngine, " + r105);
    L32:
        r100.release();     // Catch: Throwable -> L22
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L27;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "Error during release in destroyEngine, " + r107);
    L27:
        this.f358892b = null;
        return;
    L22:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L10:
        if (fna.g.d() == true) goto L12;
        r100.stop();     // Catch: Throwable -> L15
        goto L13
    L12:
        r100.stop();     // Catch: Throwable -> L15
        gna.a.a(r100.hashCode());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L29:
        th = move-exception;
        throw th;
    }

    public final long E(boolean r100) {
        this.f358897g.set(-1);
        if (r100 == false) goto L6;
        this.f358911u = FirstFramePlayoutState.IDLE;
        return this.f358915y.incrementAndGet();
    L6:
        FirstFramePlayoutState r101 = this.f358911u;
        int r102 = e.f358927a[r101.ordinal()];
        if (r102 != 1) goto L9;
        FirstFramePlayoutState r103 = FirstFramePlayoutState.FINISHED_PENDING;
    L13:
        this.f358911u = r103;
        return this.f358915y.get();
    L9:
        if (r102 == 2) goto L11;
        r103 = this.f358911u;
        goto L13
    L11:
        r103 = FirstFramePlayoutState.IDLE;
        goto L13
    }

    public final void G(boolean r100) {
        qk9.c r101 = this.f358908r;
        if (r100 == false) goto L10;
        if (r101 != null) goto L13;
        qk9.c r102 = new qk9.c(this.f358891a, this.f358893c, new AudioPlayer$setTraceEnabled$1(this));
        qk9.b r103 = this.f358909s;
        r102.I = r103;
        if (r103 == null) goto L8;
        r103.h(r102.f533603b);
    L8:
        this.f358908r = r102;
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "setTraceEnabled: audio player monitor enabled");
        return;
    L13:
        return;
    L10:
        if (r101 == null) goto L14;
        r101.b("trace_disabled", this.f358899i.size());
        this.f358908r = null;
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "setTraceEnabled: audio player monitor disabled");
        return;
    }

    public final void H(float r100) {
        com.larus.im.internal.delegate.c0 r101 = com.larus.im.internal.delegate.c0.f348199b;
        r101.i(this.f358891a, "setVolume: " + r100);
        AudioTrack r102 = this.f358892b;
        if (r102 != null) goto L14;
        r101.e(this.f358891a, "setVolume: audioTrack is null");
        return;
    L14:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.setVolume(RangesKt.coerceIn(r100, 0.0f, 1.0f));     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "setVolume: audioTrack operation failed, " + r105);
        p();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void Q(w r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L27
        boolean r102 = false;
        if (r100.f359146a.length != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L18;
        String r104 = r100.f359147b;     // Catch: Throwable -> L27
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L18;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "writeData: empty data and extra info");     // Catch: Throwable -> L27
    L25:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L35;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "writeData: unexpected error, " + r107);
        return;
    L35:
        return;
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
    L18:
        if (r100.f359146a.length != 0) goto L20;
        r102 = true;
    L20:
        if (r102 == false) goto L23;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "writeData: empty data");     // Catch: Throwable -> L27
    L23:
        if (m(r100) == false) goto L25;
        z(r100);     // Catch: Throwable -> L27
        goto L25
    L6:
        r103 = false;
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    public final w e(long r100) {
        g r101 = this.f358894d;
        if (r101 != null) goto L5;
        r101 = j();
        this.f358894d = r101;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_plan_fallback: create write plan for silence frame, plan=" + r101);
    L5:
        int r102 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast((((long) this.f358893c.f359013c) * r100) / 1000, 1), SieveCacheKt.NodeLinkMask);
        int r103 = r101.f358938d;
        byte[] r104 = new byte[a(r102 * r103, r103, "silence_frame")];
        Intrinsics.checkNotNullParameter(r104, "data");
        return new w(r104, "__client_poll_silence__", false, new x(0, 0, 31));
    }

    public final void f(boolean r100) {
        com.larus.im.internal.delegate.c0.f348199b.d(this.f358891a, "clearBuffer: before clear " + this.f358899i.size());
        qk9.c r101 = this.f358908r;
        if (r101 == null) goto L5;
        r101.b("clear_buffer", this.f358899i.size());
    L5:
        qk9.b r102 = this.f358909s;
        if (r102 == null) goto L31;
        r102.b("clear_buffer");
    L31:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L22
        if (r100 == true) goto L18;
        s(true);     // Catch: Throwable -> L22
        this.f358896f = null;     // Catch: Throwable -> L22
        Object r104 = this.f358903m;     // Catch: Throwable -> L22
        monitor-enter(r104);     // Catch: Throwable -> L22
        long r105 = E(true);     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L22
        g(this.f358892b, r105);     // Catch: Throwable -> L22
        qk9.c r106 = this.f358908r;     // Catch: Throwable -> L22
        if (r106 == null) goto L18;
        r106.e();     // Catch: Throwable -> L22
        goto L18
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L18:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L27;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "clearBuffer: audioTrack operation failed, " + r108);
        p();
    L27:
        com.larus.im.internal.delegate.c0.f348199b.d(this.f358891a, "clearBuffer: after clear " + this.f358899i.size());
        return;
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public final AudioTrack h(com.larus.media.d r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 23) goto L22;
        AudioTrack.Builder r102 = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(r100.f359011a.toUsageType().getValue()).setContentType(1).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(r100.f359015e).setSampleRate(r100.f359012b).setChannelMask(r100.f359014d).build()).setBufferSizeInBytes(this.f358895e).setTransferMode(1);
        if (r100.f359019i == false) goto L20;
        if (r101 < 26) goto L20;
        r102.setPerformanceMode(1);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(r102.build());     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L18;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "low_latency_fallback: build with low latency failed, " + r105);
        r104 = r102.setPerformanceMode(0).build();
    L18:
        return (AudioTrack) r104;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        return r102.build();
    L22:
        return new AudioTrack(r100.f359011a.toStreamType().getValue(), r100.f359012b, r100.f359014d, r100.f359015e, this.f358895e, 1);
    }

    public final boolean m(w r100) {
        r100.f359149d.f359151b = System.currentTimeMillis();
        c r101 = new c(r100, k());
        if (this.f358899i.offer(r101) == false) goto L6;
        return true;
    L6:
        com.larus.im.internal.delegate.c0 r102 = com.larus.im.internal.delegate.c0.f348199b;
        r102.w(this.f358891a, "writeData: queue is full, dropping data. Queue size: " + this.f358899i.size());
        this.f358899i.poll();
        boolean r103 = this.f358899i.offer(r101);
        if (r103 == true) goto L9;
        r102.e(this.f358891a, "writeData: failed to enqueue after removing old data");
    L9:
        return r103;
    }

    public final void n(String r100) {
        qk9.c r101 = this.f358908r;
        if (r101 == null) goto L5;
        r101.b(r100, this.f358899i.size());
    L5:
        qk9.b r102 = this.f358909s;
        if (r102 == null) goto L8;
        r102.b(r100);
    L8:
        Object r103 = this.f358903m;
        monitor-enter(r103);
        E(false);     // Catch: Throwable -> L18
        monitor-exit(r103);
        qk9.c r104 = this.f358908r;
        if (r104 == null) goto L16;
        r104.e();
    L16:
        this.f358896f = null;
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "finishPlaybackRound: reason=" + r100 + ", keep AudioTrack playing, queueSize=" + this.f358899i.size());
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void r(com.larus.media.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        com.larus.im.internal.delegate.c0 r101 = com.larus.im.internal.delegate.c0.f348199b;
        r101.i(this.f358891a, "initEngine");
        com.larus.media.d r102 = y(r100);
        this.f358893c = r102;
        this.f358898h.set(-1);
        this.f358896f = null;
        w(r100.f359017g, r102.f359017g);
        v(r100, r102);
        this.f358894d = j();
        N();
        G(r102.f359022l);
        qk9.c r103 = this.f358908r;
        if (r103 == null) goto L33;
        Intrinsics.checkNotNullParameter(r102, "config");
        r103.f533603b = r102;
        qk9.b r104 = r103.I;
        if (r104 == null) goto L33;
        r104.h(r102);
    L33:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L26
        this.f358895e = o();     // Catch: Throwable -> L26
        r101.i(this.f358891a, "initEngine, minBufferSize=" + this.f358895e);     // Catch: Throwable -> L26
        AudioTrack r106 = h(r102);     // Catch: Throwable -> L26
        this.f358892b = r106;     // Catch: Throwable -> L26
        if (r106 == null) goto L12;
        boolean r107 = true;
        if (r106.getState() != 1) goto L12;
    L13:
        if (r107 == true) goto L19;
        String r108 = this.f358891a;     // Catch: Throwable -> L26
        StringBuilder r109 = new StringBuilder("AudioTrack initialization failed, state: ");     // Catch: Throwable -> L26
        AudioTrack r110 = this.f358892b;     // Catch: Throwable -> L26
        if (r110 == null) goto L17;
        Integer r111 = Integer.valueOf(r110.getState());     // Catch: Throwable -> L26
    L18:
        r109.append(r111);     // Catch: Throwable -> L26
        r101.e(r108, r109.toString());     // Catch: Throwable -> L26
        this.f358892b = null;     // Catch: Throwable -> L26
    L24:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L31;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "initEngine error, " + r113);
        this.f358892b = null;
    L31:
        L();
        return;
    L17:
        r111 = null;
        goto L18
    L19:
        int r114 = this.f358895e;     // Catch: Throwable -> L26
        int r115 = uk9.a.c(r102.f359014d, -1);     // Catch: Throwable -> L26
        if (r115 > 0) goto L22;
        long r116 = 0;
    L23:
        u(this.f358892b, r102, r116);     // Catch: Throwable -> L26
        goto L24
    L22:
        r116 = c(r114, uk9.a.a(r102.f359015e) * r115, r102.f359012b);     // Catch: Throwable -> L26
    L12:
        r107 = false;
    L26:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    public final void s(boolean r100) {
        if (r100 == true) goto L4;
    L7:
        this.f358914x.incrementAndGet();
        this.f358899i.clear();
        this.f358898h.set(-1);
        return;
    L4:
        if (I() == false) goto L7;
        this.f358914x.incrementAndGet();
        this.f358899i.clear();
        this.f358898h.set(k());
    }

    public final void x(boolean r100) {
        com.larus.im.internal.delegate.c0 r101 = com.larus.im.internal.delegate.c0.f348199b;
        r101.i(this.f358891a, "silent: " + r100);
        if (this.f358916z == r100) goto L6;
        r101.i(this.f358891a, "Setting player mute: " + r100);
        this.f358916z = r100;
        return;
    }

    public final com.larus.media.d y(com.larus.media.d r210) {
        Integer r100 = Integer.valueOf(r210.f359013c);
        boolean r101 = true;
        if (r100.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        Integer r103 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        int r104 = r100.intValue();
    L13:
        int r105 = r104;
        if (r210.f359018h == true) goto L40;
        Integer r106 = Integer.valueOf(r210.f359012b);
        if (r106.intValue() > 0) goto L19;
        r101 = false;
    L19:
        if (r101 == false) goto L21;
        r103 = r106;
    L21:
        if (r103 == null) goto L23;
        int r107 = r103.intValue();
    L25:
        int r108 = r107;
        int r110 = (RangesKt.coerceAtLeast(r210.f359017g, 10) / 10) * 10;
        PlayScenario r109 = r210.f359011a;
        int r111 = r210.f359014d;
        int r112 = r210.f359015e;
        p0 r113 = r210.f359016f;
        boolean r114 = r210.f359018h;
        boolean r115 = r210.f359019i;
        boolean r116 = r210.f359020j;
        boolean r117 = r210.f359021k;
        boolean r118 = r210.f359022l;
        Context r119 = r210.f359023m;
        Intrinsics.checkNotNullParameter(r109, "playScenario");
        Intrinsics.checkNotNullParameter(r113, "stereoPlayoutGainConfig");
        return new com.larus.media.d(r109, r108, r105, r111, r112, r113, r110, r114, r115, r116, r117, r118, r119);
    L23:
        r107 = r105;
        goto L25
    L40:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L28
        Object r121 = Result.m9449constructorimpl(Integer.valueOf(AudioTrack.getNativeOutputSampleRate(r210.f359011a.toStreamType().getValue())));     // Catch: Throwable -> L28
    L30:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L34;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "getNativeOutputSampleRate failed, " + r122);
        r121 = 0;
    L34:
        r107 = ((Number) r121).intValue();
        if (r107 > 0) goto L25;
        r107 = r210.f359012b;
    L28:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L12:
        r104 = r210.f359012b;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public final void z(w r110) {
        qk9.c r100 = this.f358908r;
        if (r100 == null) goto L45;
        int r101 = this.f358899i.size();
        Intrinsics.checkNotNullParameter(r110, "data");
        boolean r102 = true;
        if (r110.f359146a.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L46;
        long r104 = SystemClock.elapsedRealtime();
        long r105 = r100.g(r110.f359146a.length);
        if (r100.f533611j.compareAndSet(false, true) == false) goto L20;
        long r111 = r100.f533610i.incrementAndGet();
        r100.f533612k.set(r104);
        r100.f533613l.set(0);
        r100.f533614m.set(0);
        r100.f533615n.set(0);
        r100.f533616o.set(0);
        r100.f533617p.set(0);
        r100.f533618q.set(0);
        r100.f533619r.set(0);
        r100.f533620s.set(0);
        r100.f533621t.set(0);
        r100.f533622u.set(0);
        r100.f533623v.set(0);
        r100.f533624w.set(0);
        r100.f533625x.set(0);
        r100.f533626y.set(0);
        r100.f533627z.set(0);
        r100.A.set(0);
        r100.B.set(0);
        r100.G.set(0);
        r100.H.set(0);
        r100.C.set(0);
        r100.D.set(0);
        r100.E.set(0);
        r100.F.set(0);
        r100.f533606e.set(0);
        r100.f533607f.set(0);
        r100.f533608g.set(0);
        r100.f533609h.set(0);
        com.larus.im.internal.delegate.c0.f348199b.i(r100.f533602a, "monitor_round_start: round=" + r111);
        qk9.b r106 = r100.I;
        if (r106 == null) goto L20;
        int r107 = r106.S.get();
        String r112 = r106.T.get();
        r106.f533590o.set(true);
        r106.f533591p.set(r111);
        r106.f533592q.set(r104);
        r106.f533593r.set(0);
        r106.f533594s.set(0);
        r106.f533595t.set(0);
        r106.f533596u.set(0);
        r106.f533597v.set(0);
        r106.f533598w.set(0);
        r106.f533599x.set(0);
        r106.f533600y.set(0);
        r106.e();
        if (r107 <= 0) goto L18;
        r106.S.set(r107);
        r106.T.set(r112);
    L18:
        r106.R.incrementAndGet();
    L20:
        long r113 = r100.f533605d.getAndSet(r104);
        if (r113 <= 0) goto L23;
        long r114 = r104 - r113;
    L24:
        qk9.c.h(r100.f533620s, r114);
        r100.f533613l.addAndGet(r105);
        r100.f533616o.incrementAndGet();
        long r115 = r100.f533619r.addAndGet(r105);
        qk9.b r108 = r100.I;
        if (r108 != null) goto L27;
    L33:
        int r109 = r110.f359146a.length;
        boolean r116 = r110.f359148c;
        if (r100.f533616o.get() <= 1) goto L37;
        r102 = false;
    L37:
        if (r102 == true) goto L42;
        if (qk9.c.f(r100.f533606e, r104, 2000) == true) goto L42;
        long r117 = r104;
    L43:
        r100.c(r117, r101);
        return;
    L42:
        com.larus.im.internal.delegate.c0.f348199b.d(r100.f533602a, "monitor_detail: receive round=" + r100.f533610i.get() + " bytes=" + r109 + " audioMs=" + r105 + " gapMs=" + r114 + " queueMs=" + r115 + " queueItems=" + r101 + " final=" + r116);
        r117 = r104;
        goto L43
    L27:
        if (r108.f533590o.get() == false) goto L33;
        if (r105 <= 0) goto L32;
        r108.f533601z.set(r105);
    L32:
        qk9.b.g(r108.U, r114);
        r108.f533593r.addAndGet(r105);
        r108.f533596u.incrementAndGet();
        r108.f533599x.set(r115);
        r108.f533600y.set(r101);
        goto L33
    L23:
        r114 = 0;
        goto L24
    L46:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public final void b(AudioTrack r100, b r101) {
        Object r102 = this.f358904n;
        monitor-enter(r102);
    L28:
        th = move-exception;
        throw th;
    L6:
        if (this.f358915y.get() == r101.f358921c) goto L33;
        monitor-exit(r102);
        return;
    L33:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        r100.setPlaybackPositionUpdateListener(new h(this, r101));     // Catch: Throwable -> L11
        r100.setNotificationMarkerPosition(r101.f358920b);     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L28
        monitor-exit(r102);
        if (r105 == null) goto L27;
        Object r106 = this.f358903m;
        monitor-enter(r106);
    L24:
        th = move-exception;
        throw th;
    L19:
        if (this.f358915y.get() != r101.f358921c) goto L21;
        this.f358911u = FirstFramePlayoutState.IDLE;     // Catch: Throwable -> L24
    L21:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r106);
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "armFirstFramePlayoutMarker failed, " + r105);
        return;
    L27:
        return;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L28
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L28
        goto L13
    }

    public final void g(AudioTrack r100, long r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        Object r102 = this.f358904n;
        monitor-enter(r102);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.f358915y.get() == r101) goto L24;
        monitor-exit(r102);
        return;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        r100.setNotificationMarkerPosition(0);     // Catch: Throwable -> L14
        r100.setPlaybackPositionUpdateListener(null);     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L21
        if (r105 == null) goto L19;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "clearFirstFramePlayoutMarker failed, " + r105);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r102);
        return;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
        goto L16
    }

    public final void v(com.larus.media.d r100, com.larus.media.d r101) {
        com.larus.im.internal.delegate.c0 r102 = com.larus.im.internal.delegate.c0.f348199b;
        String r103 = this.f358891a;
        StringBuilder r104 = new StringBuilder("sample_rate_config: sourceSampleRate=");
        r104.append(r101.f359013c);
        r104.append(", requestedTrackSampleRate=");
        r104.append(r100.f359012b);
        r104.append(", trackSampleRate=");
        r104.append(r101.f359012b);
        r104.append(", resample=");
        if (r101.f359015e == 2) goto L5;
    L12:
        boolean r105 = false;
    L13:
        r104.append(r105);
        r104.append(", enableResample=");
        r104.append(r101.f359018h);
        r102.i(r103, r104.toString());
        return;
    L5:
        if (r101.f359018h == false) goto L12;
        int r106 = r101.f359013c;
        if (r106 <= 0) goto L12;
        int r107 = r101.f359012b;
        if (r107 <= 0) goto L12;
        if (r106 == r107) goto L12;
        r105 = true;
        goto L13
    }

    public final void w(int r100, int r101) {
        if (r101 == r100) goto L4;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_frame_duration_fallback: rawMs=" + r100 + ", normalizedMs=" + r101);
        return;
    L4:
        com.larus.im.internal.delegate.c0.f348199b.i(this.f358891a, "write_frame_duration: " + r101 + "ms");
    }

    public static void R(byte[] r100, int r101, int r102) {
        r100[r101] = (byte) (r102 & 255);
        r100[r101 + 1] = (byte) ((r102 >> 8) & 255);
    }

    public static long c(int r100, int r101, int r102) {
        if (r100 <= 0) goto L8;
        if (r102 <= 0) goto L10;
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return (((long) r100) * 1000) / (((long) r102) * ((long) r101));
    L10:
        return 0;
    L8:
        return 0;
    }

    public final int J(int r100, int r101, int r102) {
        com.larus.media.d r103 = this.f358893c;
        if (r103.f359015e == 2) goto L5;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L16;
        return r100;
    L16:
        return (int) (RangesKt.coerceAtLeast((((long) (r100 / r101)) * ((long) r103.f359012b)) / ((long) r103.f359013c), 1) * ((long) r102));
    L5:
        if (r103.f359018h == false) goto L12;
        int r105 = r103.f359013c;
        if (r105 <= 0) goto L12;
        int r106 = r103.f359012b;
        if (r106 <= 0) goto L12;
        if (r105 == r106) goto L12;
        r104 = true;
        goto L13
    }

    public final int P(AudioTrack r110, byte[] r111, f r112) {
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = false;
        int r102 = r110.write(r111, 0, r111.length);
        long r103 = SystemClock.elapsedRealtime() - r100;
        r112.f358928a++;
        r112.f358929b = Math.max(r112.f358929b, r103);
        if (r102 == r111.length) goto L6;
        if (r102 < 0) goto L6;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_size_fallback: partial write, requestTrackBytes=" + r111.length + ", writtenTrackBytes=" + r102 + ", costMs=" + r103 + ", queueItems=" + this.f358899i.size());
    L6:
        qk9.c r104 = this.f358908r;
        if (r104 == null) goto L35;
        int r105 = r111.length;
        int r106 = this.f358899i.size();
        qk9.b r107 = r104.I;
        if (r107 == null) goto L11;
        r107.f533600y.set(r106);
    L11:
        qk9.b r108 = r104.I;
        if (r108 == null) goto L14;
        qk9.b.g(r108.W, r103);
    L14:
        qk9.c.h(r104.f533622u, r103);
        if (1 > r102) goto L18;
        if (r102 >= r105) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L21;
        r104.C.incrementAndGet();
    L21:
        int r113 = uk9.a.a(r104.f533603b.f359015e) * uk9.a.c(r104.f533603b.f359014d, 1);
        int r114 = r104.f533603b.f359012b;
        if (r105 <= 0) goto L27;
        if (r114 <= 0) goto L27;
        if (r113 <= 0) goto L27;
        long r115 = (((long) r105) * 1000) / (((long) r114) * ((long) r113));
    L29:
        if (r103 > (r115 + 20)) goto L34;
        if (1 > r102) goto L33;
        if (r102 >= r105) goto L33;
        r101 = true;
    L33:
        if (r101 == false) goto L35;
    L34:
        r104.c(SystemClock.elapsedRealtime(), r106);
    L27:
        r115 = 0;
    L18:
        r109 = false;
    L35:
        return r102;
    }

    public final int a(int r100, int r101, String r110) {
        if (r100 > 0) goto L5;
    L11:
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_size_align_fallback: reason=" + r110 + ", inputSize=" + r100 + ", alignBytes=" + r101);
        return r100;
    L5:
        if (r101 <= 1) goto L11;
        int r102 = r100 - (r100 % r101);
        if (r102 == r100) goto L10;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_size_align: reason=" + r110 + ", inputSize=" + r100 + ", alignBytes=" + r101 + ", alignedSize=" + r102 + ", droppedBytes=" + (r100 - r102));
    L10:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void u(AudioTrack r110, com.larus.media.d r111, long r112) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r100 = -1;
        int r101 = uk9.a.c(r111.f359014d, -1);
        if (r111.f359011a == PlayScenario.VOICE_COMMUNICATION) goto L7;
        ?? r102 = 1;
    L8:
        com.larus.im.internal.delegate.c0 r103 = com.larus.im.internal.delegate.c0.f348199b;
        String r104 = this.f358891a;
        StringBuilder r105 = new StringBuilder("audio_track_init_report: message_type=Initialize device_type=Render rtc_error=0 system_api=InitPlayout media_mode=");
        String r106 = r111.f359011a.name();
        Locale r107 = Locale.ROOT;
        r105.append(r106.toLowerCase(r107));
        r105.append(" [forbid_voip=");
        r105.append(r102);
        r105.append("] api_result=InitPlayout(sampleRate=");
        r105.append(r111.f359012b);
        r105.append(", channels=");
        r105.append(r101);
        r105.append(", forbidVoip=");
        r105.append(r102);
        r105.append("):minBufferSizeInBytes: ");
        r105.append(this.f358895e);
        r105.append(", minBufferDurationMs=");
        r105.append(r112);
        r105.append(", session_id=");
        r105.append(r110.getAudioSessionId());
        r105.append(", stream_type=");
        r105.append(r111.f359011a.name().toLowerCase(r107));
        r105.append(", play_sr=");
        r105.append(r111.f359012b);
        r105.append(", play_channel=");
        r105.append(r101);
        r105.append(", source_sr=");
        r105.append(r111.f359013c);
        r105.append(", source_channel=1, channel_mask=");
        r105.append(r111.f359014d);
        r105.append(", audio_format=");
        int r113 = r111.f359015e;
        if (r113 != 2) goto L11;
        String r114 = "pcm_16bit";
    L18:
        r105.append(r114);
        r105.append(", write_frame_ms=");
        r105.append(r111.f359017g);
        r105.append(", resample_to_output_rate=");
        r105.append(r111.f359018h);
        r105.append(", enable_low_latency=");
        r105.append(r111.f359019i);
        r105.append(", performance_mode=");
        if (Build.VERSION.SDK_INT >= 26) goto L64;
        String r115 = "unsupported";
    L37:
        r105.append(r115);
        r105.append(", trace=");
        r105.append(r111.f359022l);
        if (Build.VERSION.SDK_INT >= 23) goto L66;
        int r116 = -1;
    L50:
        if (Build.VERSION.SDK_INT >= 24) goto L62;
    L60:
        r105.append(" audioTrackBufferSizeInFrames=" + r116 + " audioTrackBufferCapacityInFrames=" + r100);
        r105.append(d(r110));
        r105.append(", writeFrameDurationMs=");
        r105.append(r111.f359017g);
        r105.append(", fillSilentWhenIdle=");
        r105.append(r111.f359020j);
        r105.append(", lowWatermarkSilencePlayout=");
        r105.append(r111.f359021k);
        r103.i(r104, r105.toString());
        return;
    L62:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L53
        Object r118 = Result.m9449constructorimpl(Integer.valueOf(r110.getBufferCapacityInFrames()));     // Catch: Throwable -> L53
    L56:
        if (Result.m9452exceptionOrNullimpl(r118) == null) goto L59;
        r118 = -2;
    L59:
        r100 = ((Number) r118).intValue();
    L53:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L66:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L41
        Object r120 = Result.m9449constructorimpl(Integer.valueOf(r110.getBufferSizeInFrames()));     // Catch: Throwable -> L41
    L44:
        if (Result.m9452exceptionOrNullimpl(r120) == null) goto L47;
        r120 = -2;
    L47:
        r116 = ((Number) r120).intValue();
    L41:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L64:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L23
        Object r123 = Result.m9449constructorimpl(Integer.valueOf(r110.getPerformanceMode()));     // Catch: Throwable -> L23
    L26:
        if (Result.m9452exceptionOrNullimpl(r123) == null) goto L29;
        r123 = -2;
    L29:
        int r124 = ((Number) r123).intValue();
        if (r124 == 0) goto L36;
        if (r124 == 1) goto L35;
        if (r124 == 2) goto L34;
        r115 = "unknown(" + r124 + ')';
        goto L37
    L34:
        r115 = "power_saving";
        goto L37
    L35:
        r115 = "low_latency";
        goto L37
    L36:
        r115 = "none";
    L23:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L11:
        if (r113 != 3) goto L13;
        r114 = "pcm_8bit";
        goto L18
    L13:
        if (r113 == 4) goto L15;
        r114 = "unknown(" + r113 + ')';
        goto L18
    L15:
        r114 = "pcm_float";
        goto L18
    L7:
        r102 = 0;
        goto L8
    }

    public final d i(byte[] r110, int r210, int r211, g r212) {
        byte[] r100 = ArraysKt.copyOfRange(r110, r210, r210 + r211);
        int r101 = 1;
        if (r212.f358941g == false) goto L47;
        int r102 = r212.f358938d;
        com.larus.media.d r103 = this.f358893c;
        if (r103.f359015e == 2) goto L7;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L47;
        if (r100.length != 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L47;
        if (r102 == 2) goto L24;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "resample_fallback: unsupported bytesPerFrame=" + r102 + ", sourceBytes=" + r100.length + ", sourceSampleRate=" + this.f358893c.f359013c + ", trackSampleRate=" + this.f358893c.f359012b);
        goto L47
    L24:
        int r106 = r100.length / r102;
        if (r106 <= 0) goto L47;
        int r111 = r103.f359012b;
        int r107 = r103.f359013c;
        if (r111 > r107) goto L30;
    L44:
        int r108 = (int) RangesKt.coerceAtLeast((((long) r106) * ((long) r111)) / ((long) r107), 1);
        byte[] r109 = new byte[r108 * r102];
        int r112 = 0;
    L45:
        if (r112 >= r108) goto L49;
        com.larus.media.d r113 = this.f358893c;
        long r114 = ((long) r112) * ((long) r113.f359013c);
        int r115 = r106 - 1;
        int r116 = RangesKt.coerceAtMost((int) (r114 / ((long) r113.f359012b)), r115);
        int r117 = RangesKt.coerceAtMost(r116 + 1, r115);
        int r118 = this.f358893c.f359012b;
        int r119 = (int) (r114 % ((long) r118));
        int r120 = r116 * r102;
        int r121 = (r100[r120] & UByte.MAX_VALUE) | (r100[r120 + 1] << 8);
        int r122 = r117 * r102;
        R(r109, r112 * r102, r121 + ((int) ((((long) (((r100[r122] & UByte.MAX_VALUE) | (r100[r122 + 1] << 8)) - r121)) * ((long) r119)) / ((long) r118))));
        r112 = r112 + 1;
    L49:
        if (this.f358916z == false) goto L51;
        g r123 = r212;
        r109 = new byte[(J(r211, r123.f358938d, r123.f358939e) / r123.f358939e) * r123.f358940f];
    L69:
        return new d(r100, r109, r123);
    L51:
        r123 = r212;
        if (r123.f358942h == false) goto L69;
        com.larus.media.d r124 = this.f358893c;
        p0 r125 = r124.f359016f;
        if (r124.f359011a != PlayScenario.VOICE_COMMUNICATION) goto L56;
        boolean r126 = true;
    L57:
        float r127 = 1.0f;
        if (r126 == false) goto L60;
        float r128 = 1.0f;
    L61:
        if (r126 == true) goto L64;
        r127 = r125.f359142c / 100.0f;
    L64:
        int r129 = r109.length / 2;
        byte[] r130 = new byte[r129 * 4];
        int r131 = 0;
    L65:
        if (r131 >= r129) goto L67;
        int r132 = r131 * 2;
        int r133 = (r109[r132 + 1] << 8) | (r109[r132] & UByte.MAX_VALUE);
        int r134 = r131 * 4;
        float r135 = r133;
        R(r130, r134, RangesKt.coerceIn((int) (r135 * r128), -32768, 32767));
        R(r130, r134 + 2, RangesKt.coerceIn((int) (r135 * r127), -32768, 32767));
        r131 = r131 + 1;
        goto L65
    L67:
        r109 = r130;
        goto L69
    L60:
        r128 = r125.f359141b / 100.0f;
        goto L61
    L56:
        r126 = false;
        goto L57
    L30:
        if ((r111 % r107) != 0) goto L44;
        int r136 = r111 / r107;
        r109 = new byte[(r106 * r136) * r102];
        int r137 = 0;
        int r138 = 0;
    L32:
        if (r137 >= r106) goto L49;
        int r139 = r137 * r102;
        int r140 = (r100[r139 + r101] << 8) | (r100[r139] & UByte.MAX_VALUE);
        Integer r141 = this.f358896f;
        if (r141 != null) goto L38;
        int r142 = 0;
    L36:
        if (r142 >= r136) goto L43;
        R(r109, r138, r140);
        r138 = r138 + r102;
        r142 = r142 + 1;
    L43:
        this.f358896f = Integer.valueOf(r140);
        r137 = r137 + 1;
        r101 = 1;
        goto L32
    L38:
        if (r101 > r136) goto L43;
        int r143 = 1;
    L40:
        R(r109, r138, r141.intValue() + ((int) ((((long) (r140 - r141.intValue())) * ((long) r143)) / ((long) r136))));
        r138 = r138 + r102;
        if (r143 == r136) goto L43;
        r143 = r143 + 1;
        goto L40
    L19:
        r105 = false;
        goto L20
    L7:
        if (r103.f359018h == false) goto L14;
        int r144 = r103.f359013c;
        if (r144 <= 0) goto L14;
        int r145 = r103.f359012b;
        if (r145 <= 0) goto L14;
        if (r144 == r145) goto L14;
        r104 = true;
    L47:
        r109 = r100;
        goto L49
    }

    public final Integer q(w r210, d r211, int r212, long r213, f r310) {
        if (r212 >= 0) goto L28;
        com.larus.im.internal.delegate.c0 r100 = com.larus.im.internal.delegate.c0.f348199b;
        r100.w(this.f358891a, "write_size_fallback: write error written=" + r212 + ", sourceBytes=" + r211.f358924a.length + ", trackBytes=" + r211.f358925b.length + ", plan=" + r211.f358926c);
        qk9.c r101 = this.f358908r;
        if (r101 == null) goto L10;
        int r102 = this.f358899i.size();
        qk9.b r103 = r101.I;
        if (r103 == null) goto L9;
        r103.f533600y.set(r102);
    L9:
        r101.E.incrementAndGet();
        r101.c(SystemClock.elapsedRealtime(), r102);
    L10:
        this.f358910t++;
        if (r212 != (-6)) goto L13;
        r100.e(this.f358891a, "handleWriteError: DEAD_OBJECT");
        p();
    L24:
        if (this.f358910t < 5) goto L26;
        this.f358910t = 0;
        p();
    L26:
        Thread.sleep(10);
    L154:
        return 0;
    L13:
        if (r212 != (-3)) goto L15;
        r100.e(this.f358891a, "handleWriteError: INVALID_OPERATION");
        p();
        goto L24
    L15:
        if (r212 != (-2)) goto L17;
        r100.e(this.f358891a, "handleWriteError: BAD_VALUE");
        goto L24
    L17:
        if (r212 != (-1)) goto L24;
        r100.e(this.f358891a, "handleWriteError: GENERAL ERROR");
        goto L24
    L28:
        if (r212 != 0) goto L37;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_size_fallback: zero write, sourceBytes=" + r211.f358924a.length + ", trackBytes=" + r211.f358925b.length + ", plan=" + r211.f358926c);
        qk9.c r104 = this.f358908r;
        if (r104 == null) goto L35;
        int r105 = this.f358899i.size();
        qk9.b r106 = r104.I;
        if (r106 == null) goto L34;
        r106.f533600y.set(r105);
    L34:
        r104.D.incrementAndGet();
        r104.c(SystemClock.elapsedRealtime(), r105);
    L35:
        Thread.sleep(2);
        goto L154
    L37:
        g r110 = r211.f358926c;
        int r111 = r110.f358940f;
        if ((r212 % r111) == 0) goto L41;
        com.larus.im.internal.delegate.c0.f348199b.e(this.f358891a, "write_size_fallback: unaligned writtenTrackBytes=" + r212 + ", trackBytesPerFrame=" + r110.f358940f + ", sourceBytes=" + r211.f358924a.length + ", trackBytes=" + r211.f358925b.length + ", plan=" + r110);
        p();
        Integer r107 = null;
    L58:
        if (r107 == null) goto L150;
        int r108 = r107.intValue();
        if (r108 > 0) goto L63;
        com.larus.im.internal.delegate.c0.f348199b.w(this.f358891a, "write_size_fallback: writtenTrackBytes=" + r212 + " but consumedSourceBytes=" + r108 + ", sourceBytes=" + r211.f358924a.length + ", trackBytes=" + r211.f358925b.length + ", plan=" + r211.f358926c);
        Thread.sleep(2);
        goto L154
    L63:
        Intrinsics.checkNotNullParameter(r210, "<this>");
        if (Intrinsics.areEqual(r210.f359147b, "__client_poll_silence__") == true) goto L69;
        if (this.f358898h.get() == r213) goto L69;
        this.f358898h.set(r213);
    L69:
        if (this.f358916z == false) goto L71;
        byte[] r109 = new byte[r108];
    L75:
        long r112 = SystemClock.elapsedRealtime();
        byte[] r113 = r211.f358925b;
        Function1<? super byte[], Unit> r114 = this.f358906p;
        if (r114 == null) goto L85;
        if (r212 <= 0) goto L85;
        if (r212 == r113.length) goto L84;
        r113 = Arrays.copyOf(r113, r212);
    L84:
        r114.invoke(r113);
    L85:
        long r115 = SystemClock.elapsedRealtime();
        r310.f358930c += r115 - r112;
        Function1<? super w, Unit> r116 = this.f358905o;
        if (r116 == null) goto L88;
        String r117 = r210.f359147b;
        boolean r118 = r210.f359148c;
        x r119 = r210.f359149d;
        Intrinsics.checkNotNullParameter(r109, "audio");
        Intrinsics.checkNotNullParameter(r119, "trace");
        r116.invoke(new w(r109, r117, r118, r119));
    L88:
        long r120 = SystemClock.elapsedRealtime();
        r310.f358931d += r120 - r115;
        qk9.b r121 = this.f358909s;
        if (r121 == null) goto L101;
        if (r108 <= 0) goto L101;
        r121.f533590o.compareAndSet(false, true);
        long r122 = r121.C.get();
        long r123 = r121.D.get();
        long r124 = (((long) r108) * 1000) / (RangesKt.coerceAtLeast(r122, 1) * RangesKt.coerceAtLeast(r123, 1));
        Object r125 = r121.f533578e0;
        monitor-enter(r125);
        r121.f533582g0 += r124;     // Catch: Throwable -> L97
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L97
        monitor-exit(r125);
    L97:
        th = move-exception;
        throw th;
    L101:
        qk9.c r127 = this.f358908r;
        if (r127 == null) goto L142;
        boolean r128 = this.f358899i.isEmpty();
        int r129 = this.f358899i.size();
        long r130 = SystemClock.elapsedRealtime();
        long r131 = r127.H.getAndSet(r130);
        if (r131 <= 0) goto L106;
        long r132 = r130 - r131;
    L107:
        qk9.c.h(r127.f533621t, r132);
        long r133 = r127.g(r108);
        int r134 = uk9.a.a(r127.f533603b.f359015e) * uk9.a.c(r127.f533603b.f359014d, 1);
        int r135 = r127.f533603b.f359012b;
        if (r212 <= 0) goto L113;
        if (r135 <= 0) goto L113;
        if (r134 <= 0) goto L113;
        long r136 = (((long) r212) * 1000) / (((long) r135) * ((long) r134));
    L114:
        r127.f533614m.addAndGet(r133);
        r127.f533615n.addAndGet(r136);
        r127.f533617p.incrementAndGet();
        r127.f533618q.incrementAndGet();
        AtomicLong r137 = r127.f533619r;
        long r138 = -r133;
    L115:
        long r139 = r137.get();
        boolean r140 = r128;
        int r141 = r129;
        long r214 = r138;
        long r142 = RangesKt.coerceAtLeast(r139 + r138, 0);
        if (r137.compareAndSet(r139, r142) == true) goto L117;
        r128 = r140;
        r129 = r141;
        r138 = r214;
        goto L115
    L117:
        qk9.b r143 = r127.I;
        if (r143 != null) goto L120;
    L129:
        int r144 = r141;
    L131:
        if (r127.f533617p.get() > 1) goto L133;
        boolean r145 = true;
    L134:
        if (r145 == true) goto L138;
        long r146 = r130;
        if (qk9.c.f(r127.f533607f, r146, 2000) == true) goto L139;
        int r147 = r212;
        int r148 = r108;
    L140:
        r127.c(r146, r144);
        int r149 = r147;
        int r150 = r148;
    L144:
        if (r210.f359148c == false) goto L148;
        qk9.b r151 = this.f358909s;
        if (r151 == null) goto L148;
        r151.b("final_frame");
    L148:
        r310.f358932e += SystemClock.elapsedRealtime() - r120;
        r310.f358933f += c(r150, r211.f358926c.f358938d, this.f358893c.f359013c);
        r310.f358934g += c(r149, r211.f358926c.f358940f, this.f358893c.f359012b);
        return Integer.valueOf(r150);
    L139:
        com.larus.im.internal.delegate.c0 r152 = com.larus.im.internal.delegate.c0.f348199b;
        String r153 = r127.f533602a;
        StringBuilder r154 = new StringBuilder("monitor_detail: consume round=");
        r154.append(r127.f533610i.get());
        r154.append(" consumedBytes=");
        r148 = r108;
        r154.append(r148);
        r154.append(" consumedMs=");
        r154.append(r133);
        r154.append(" writtenBytes=");
        r147 = r212;
        r154.append(r147);
        r154.append(" writtenMs=");
        r154.append(r136);
        r154.append(" queueMs=");
        r154.append(r142);
        r154.append(" queueItems=");
        r154.append(r144);
        r154.append(" queueDrained=");
        r154.append(r140);
        r152.d(r153, r154.toString());
        goto L140
    L138:
        r146 = r130;
        goto L139
    L133:
        r145 = false;
        goto L134
    L120:
        if (r143.f533590o.get() == false) goto L129;
        if (r133 <= 0) goto L126;
        r143.A.set(r133);
    L126:
        if (r136 <= 0) goto L128;
        r143.B.set(r136);
    L128:
        qk9.b.g(r143.V, r132);
        r143.f533594s.addAndGet(r133);
        r143.f533595t.addAndGet(r136);
        r143.f533597v.incrementAndGet();
        r143.f533598w.incrementAndGet();
        r143.f533599x.set(r142);
        r144 = r141;
        r143.f533600y.set(r144);
    L113:
        r136 = 0;
        goto L114
    L106:
        r132 = 0;
        goto L107
    L142:
        r149 = r212;
        r150 = r108;
        goto L144
    L71:
        r109 = r211.f358924a;
        if (r108 == r109.length) goto L75;
        r109 = Arrays.copyOf(r109, r108);
        goto L75
    L150:
        return null;
    L41:
        if (r212 != r211.f358925b.length) goto L43;
        r107 = Integer.valueOf(r211.f358924a.length);
        goto L58
    L43:
        int r155 = r110.f358938d;
        int r156 = r212 / r111;
        com.larus.media.d r157 = this.f358893c;
        if (r157.f359015e == 2) goto L46;
    L53:
        boolean r158 = false;
    L54:
        if (r158 == false) goto L56;
        long r159 = ((long) r156) * ((long) r157.f359013c);
        long r160 = r157.f359012b;
        long r161 = ((r159 + r160) - 1) / r160;
    L57:
        r107 = Integer.valueOf(RangesKt.coerceAtMost((int) (r161 * ((long) r155)), r211.f358924a.length));
        goto L58
    L56:
        r161 = r156;
        goto L57
    L46:
        if (r157.f359018h == false) goto L53;
        int r162 = r157.f359013c;
        if (r162 <= 0) goto L53;
        int r163 = r157.f359012b;
        if (r163 <= 0) goto L53;
        if (r162 == r163) goto L53;
        r158 = true;
        goto L54
    }

    public final void O(AudioTrack r100, w r101, int r102, g r103, long r104, long r110) {
        int r105 = r103.f358940f;
        if (r105 <= 0) goto L30;
        if (r102 <= 0) goto L34;
        Object r106 = this.f358903m;
        monitor-enter(r106);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (r110 != this.f358913w) goto L22;
        this.f358912v += ((long) r102) / ((long) r105);     // Catch: Throwable -> L27
        if (r104 != k()) goto L22;
        if (this.f358907q == null) goto L22;
        if (this.f358911u != FirstFramePlayoutState.IDLE) goto L22;
        Intrinsics.checkNotNullParameter(r101, "<this>");     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(r101.f359147b, "__client_poll_silence__") == true) goto L22;
        this.f358911u = FirstFramePlayoutState.ARMED;     // Catch: Throwable -> L27
        b r107 = new b(r101, (int) RangesKt.coerceAtMost(this.f358912v, SieveCacheKt.NodeLinkMask), this.f358915y.incrementAndGet());     // Catch: Throwable -> L27
    L23:
        monitor-exit(r106);
        if (r107 == null) goto L33;
        b(r100, r107);
        return;
    L33:
        return;
    L22:
        r107 = null;
        goto L23
    L34:
        return;
    }
}
