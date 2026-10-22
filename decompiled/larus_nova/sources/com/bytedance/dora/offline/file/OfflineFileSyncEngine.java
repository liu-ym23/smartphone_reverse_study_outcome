package com.bytedance.dora.offline.file;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.voice.ProtocolAbility;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineFileSyncEngine {
    public p.a A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ak4.a f204503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f204504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f204505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f204506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f204507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f204508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f204509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f204510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f204511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f204512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f204513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, OfflineFileBusiness> f204514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, com.bytedance.dora.offline.file.b.g> f204515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.dora.offline.file.d f204516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.dora.offline.file.c f204517o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p f204518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g f204519q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.dora.offline.file.a f204520r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f204521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f204522t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile int f204523u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f204524v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile long f204525w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile j f204526x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ScheduledFuture<?> f204527y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p.b f204528z;

    /* JADX INFO: loaded from: classes15.dex */
    public static final enum FileOutcome extends Enum<FileOutcome> {
        public static final FileOutcome COMPLETED = null;
        public static final FileOutcome DEFERRED = null;
        public static final FileOutcome FAILED = null;
        public static final FileOutcome INTERRUPTED = null;
        public static final FileOutcome SKIPPED_NEXT_ROUND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileOutcome[] f204529a = null;

        static {
            FileOutcome r100 = new FileOutcome("COMPLETED", 0);
            COMPLETED = r100;
            FileOutcome r101 = new FileOutcome("FAILED", 1);
            FAILED = r101;
            FileOutcome r102 = new FileOutcome("DEFERRED", 2);
            DEFERRED = r102;
            FileOutcome r103 = new FileOutcome("SKIPPED_NEXT_ROUND", 3);
            SKIPPED_NEXT_ROUND = r103;
            FileOutcome r104 = new FileOutcome("INTERRUPTED", 4);
            INTERRUPTED = r104;
            f204529a = new FileOutcome[]{r100, r101, r102, r103, r104};
        }

        public static FileOutcome[] values() {
            return (FileOutcome[]) f204529a.clone();
        }

        public static FileOutcome valueOf(String r100) {
            return (FileOutcome) r27.a.a(FileOutcome.class, r100);
        }

        public FileOutcome(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final enum StopReason extends Enum<StopReason> {
        public static final StopReason ABILITY_UNSUPPORTED = null;
        public static final StopReason ACCOUNT_CHANGED = null;
        public static final StopReason BUSINESS_BLOCKED = null;
        public static final StopReason CANCELLED = null;
        public static final StopReason DISCONNECTED = null;
        public static final StopReason NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StopReason[] f204530a = null;

        static {
            StopReason r100 = new StopReason(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            StopReason r101 = new StopReason("ACCOUNT_CHANGED", 1);
            ACCOUNT_CHANGED = r101;
            StopReason r102 = new StopReason(State.DISCONNECTED, 2);
            DISCONNECTED = r102;
            StopReason r103 = new StopReason("ABILITY_UNSUPPORTED", 3);
            ABILITY_UNSUPPORTED = r103;
            StopReason r104 = new StopReason("BUSINESS_BLOCKED", 4);
            BUSINESS_BLOCKED = r104;
            StopReason r105 = new StopReason("CANCELLED", 5);
            CANCELLED = r105;
            f204530a = new StopReason[]{r100, r101, r102, r103, r104, r105};
        }

        public static StopReason[] values() {
            return (StopReason[]) f204530a.clone();
        }

        public static StopReason valueOf(String r100) {
            return (StopReason) r27.a.a(StopReason.class, r100);
        }

        public StopReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class TransferFailure extends Exception {
        final int terminalReason;

        public TransferFailure(int r100, String r101) {
            super(r101);
            this.terminalReason = r100;
        }

        public TransferFailure(int r100, String r101, Throwable r102) {
            super(r101, r102);
            this.terminalReason = r100;
        }
    }

    public class a implements IDoraLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfflineFileSyncEngine f204531a;

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
            IDoraLinkCallback.CC.$default$onBtConnectStateChanged(this, r100, r101, r102);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onBtStateChanged(int r100, int r101) {
            IDoraLinkCallback.CC.$default$onBtStateChanged(this, r100, r101);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onDeviceFound(DoraDevice r100) {
            IDoraLinkCallback.CC.$default$onDeviceFound(this, r100);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onScanFailed(int r100) {
            IDoraLinkCallback.CC.$default$onScanFailed(this, r100);
        }

        public a(OfflineFileSyncEngine r100) {
            this.f204531a = r100;
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            DoraDevice r103 = this.f204531a.f204503a.current();
            if (r100 == null) goto L10;
            if (r103 == null) goto L10;
            if (TextUtils.equals(r100.f204389mac, r103.f204389mac) == true) goto L10;
            pk4.j.d("OfflineFileSyncEngine", "Ignore link state from non-current device, state=" + r102);
            return;
        L10:
            if (r102 != 2) goto L22;
            final OfflineFileSyncEngine r104 = this.f204531a;
            r104.f204509g.set(true);
            r104.f204524v = false;
            r104.f204525w = r104.f204512j.get();
            r104.d("protocol_connected");
            Object r105 = r104.f204513k;
            monitor-enter(r105);
            ScheduledFuture<?> r106 = r104.f204527y;     // Catch: Throwable -> L19
            if (r106 == null) goto L16;
            r106.cancel(false);     // Catch: Throwable -> L19
        L16:
            r104.f204527y = r104.f204504b.schedule(new l(r104), 5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L19
            monitor-exit(r105);     // Catch: Throwable -> L19
            pk4.j.d("OfflineFileSyncEngine", "Protocol connected, delay offline file discovery, delayMs=5000");
            return;
        L19:
            th = move-exception;
            throw th;
        L22:
            if (r102 != 0) goto L24;
        L25:
            OfflineFileSyncEngine r107 = this.f204531a;
            r107.f204509g.set(false);
            r107.f204524v = false;
            com.bytedance.dora.offline.file.a r108 = r107.f204520r;
            if (((ConcurrentHashMap) r108.f204566a).isEmpty() == true) goto L29;
            ((ConcurrentHashMap) r108.f204566a).clear();
            pk4.j.d("OfflineFileBusinessBlocker", "Clear active business states, reason=protocol_disconnected");
        L29:
            r107.b("protocol_disconnected");
            r107.d("protocol_disconnected");
            pk4.j.d("OfflineFileSyncEngine", "Protocol disconnected, stop current offline file round");
            return;
        L24:
            if (r102 == (-1)) goto L25;
        }
    }

    public class b implements sk4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfflineFileSyncEngine f204532a;

        public b(OfflineFileSyncEngine r100) {
            this.f204532a = r100;
        }

        @Override // sk4.c
        public final void a(sk4.e r100) {
            OfflineFileSyncEngine r101 = this.f204532a;
            if (r100 == null) goto L7;
            r101.getClass();
            if (r100.b(ProtocolAbility.FEATURE_OFFLINE_MINUTES) == false) goto L7;
            boolean r102 = true;
        L8:
            r101.f204524v = r102;
            pk4.j.d("OfflineFileSyncEngine", "Offline file ability changed, supported=" + r102);
            if (r102 == false) goto L11;
            r101.A();
            return;
        L11:
            r101.b("ability_unsupported");
            r101.d("ability_unsupported");
            pk4.j.d("OfflineFileSyncEngine", "Skip offline file capability, reason=ability_unsupported");
            return;
        L7:
            r102 = false;
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204533a = null;

        static {
            int[] r100 = new int[StopReason.values().length];
            f204533a = r100;
            r100[StopReason.DISCONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f204533a[StopReason.BUSINESS_BLOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f204533a[StopReason.ACCOUNT_CHANGED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f204533a[StopReason.CANCELLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f204534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f204535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f204536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f204537d;

        public d(long r100, long r101, int r102) {
            this.f204534a = r100;
            this.f204535b = r101;
            this.f204536c = SystemClock.elapsedRealtime() + KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
            this.f204537d = r100 / 960;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfflineFileSyncEngine f204538a = null;

        static {
            f204538a = new OfflineFileSyncEngine();
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.dora.offline.file.b.d f204539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OfflineFileBusiness f204540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p.a f204541c;

        public f(com.bytedance.dora.offline.file.b.d r100, OfflineFileBusiness r101, p.a r102) {
            this.f204539a = r100;
            this.f204540b = r101;
            this.f204541c = r102;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f204542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f204543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f204544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f204545d;

        public g() {
            this.f204542a = new HashSet();
        }

        public final void a(PolarisFileWrapper r100) {
            if (r100 != null) goto L4;
            String r101 = null;
        L5:
            this.f204545d = r101;
            return;
        L4:
            r101 = r100.getAbsolutePath();
            goto L5
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204547b;

        public h(int r100, int r101) {
            this.f204546a = r100;
            this.f204547b = r101;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f204548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f204549b;

        public i() {
        }

        public final h a(p.b r100) {
            if (this.f204548a == false) goto L5;
        L8:
            int r101 = 8999;
            if (r100 != null) goto L11;
            int r102 = 8999;
        L12:
            if (r102 == 0) goto L16;
            r101 = r102;
        L16:
            return new h(1, r101);
        L11:
            r102 = r100.f204658l;
            goto L12
        L5:
            if (this.f204549b == true) goto L8;
            return new h(0, 0);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f204550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f204551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayBlockingQueue<com.bytedance.dora.offline.file.b.c> f204552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayBlockingQueue<com.bytedance.dora.offline.file.b.e> f204553d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayBlockingQueue<com.bytedance.dora.offline.file.b.a> f204554e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile int f204555f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile int f204556g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile String f204557h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile int f204558i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile String f204559j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile boolean f204560k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public volatile boolean f204561l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f204562m;

        public final synchronized long b() {
            monitor-enter(this);
            long r100 = this.f204562m;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void c() {
            monitor-enter(this);
            this.f204560k = true;     // Catch: Throwable -> L7
            this.f204562m++;     // Catch: Throwable -> L7
            this.f204555f = -1;     // Catch: Throwable -> L7
            this.f204556g = -1;     // Catch: Throwable -> L7
            this.f204557h = null;     // Catch: Throwable -> L7
            this.f204558i = -1;     // Catch: Throwable -> L7
            this.f204559j = null;     // Catch: Throwable -> L7
            this.f204552c.clear();     // Catch: Throwable -> L7
            this.f204553d.clear();     // Catch: Throwable -> L7
            this.f204554e.clear();     // Catch: Throwable -> L7
            this.f204552c.offer(new com.bytedance.dora.offline.file.b.c(-1, 0, false, Collections.emptyList()));     // Catch: Throwable -> L7
            this.f204553d.offer(new com.bytedance.dora.offline.file.b.e(-1, null));     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final boolean a() {
            if (this.f204560k == false) goto L5;
        L7:
            return false;
        L5:
            if (ek4.a.a(this.f204550a) == false) goto L7;
            return true;
        }

        public final synchronized boolean d(long r100) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.f204560k == false) goto L6;
        L10:
            boolean r101 = false;
        L11:
            monitor-exit(this);
            return r101;
        L6:
            if (this.f204562m != r100) goto L10;
            if (ek4.a.a(this.f204550a) == false) goto L10;
            r101 = true;
            goto L11
        }

        public j(String r100, long r101) {
            this.f204552c = new ArrayBlockingQueue(1);
            this.f204553d = new ArrayBlockingQueue(1);
            this.f204554e = new ArrayBlockingQueue(64);
            this.f204555f = -1;
            this.f204556g = -1;
            this.f204558i = -1;
            this.f204550a = r100;
            this.f204551b = r101;
        }

        public final synchronized <T> boolean e(long r100, ArrayBlockingQueue<T> r101, T r102) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (d(r100) == true) goto L8;
            monitor-exit(this);
            return false;
        L8:
            r101.clear();     // Catch: Throwable -> L11
            boolean r103 = r101.offer(r102);     // Catch: Throwable -> L11
            monitor-exit(this);
            return r103;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class k implements AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.dora.offline.file.d.a f204563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f204564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f204565c;

        @Override // java.lang.AutoCloseable
        public final void close() throws IOException {
            this.f204563a.close();
        }

        public k(com.bytedance.dora.offline.file.d r100, PolarisFileWrapper r101, long r102) throws IOException {
            r100.getClass();
            File r103 = r101.getParentFile();
            if (r103 != null) goto L5;
        L9:
            this.f204563a = new com.bytedance.dora.offline.file.d.a(r101);
            this.f204564b = r102;
            return;
        L5:
            if (r103.exists() == true) goto L9;
            if (r103.mkdirs() == true) goto L9;
            pk4.j.f("OfflineFileStore", "Create parent dir failed, directory=" + r103.getName());
            goto L9
        }
    }

    public final void A() {
        if (this.f204524v == true) goto L6;
        pk4.j.d("OfflineFileSyncEngine", "Skip sync scheduling because ability is unsupported");
        return;
    L6:
        this.f204508f.set(true);
        if (this.f204507e.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        this.f204504b.execute(new com.bytedance.dora.offline.file.e(this));
    }

    public final void a() {
        if (this.f204515m.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = new ArrayList(this.f204515m.values()).iterator();
    L7:
        if (r100.hasNext() == false) goto L31;
        com.bytedance.dora.offline.file.b.g r101 = (com.bytedance.dora.offline.file.b.g) r100.next();
        if (r101 == null) goto L29;
        long r102 = 0;
        com.bytedance.dora.offline.file.b.v("business_type", r102);     // Catch: Throwable -> L24
        com.bytedance.dora.offline.file.b.u("max_single_duration_sec", 0);     // Catch: Throwable -> L24
        com.bytedance.dora.offline.file.b.u("max_single_file_size_bytes", 0);     // Catch: Throwable -> L24
        com.bytedance.dora.offline.file.b.u("max_total_duration_sec", 0);     // Catch: Throwable -> L24
        com.bytedance.dora.offline.file.b.u("max_total_dir_size_bytes", 0);     // Catch: Throwable -> L24
        com.bytedance.dora.offline.file.b.t("max_file_count", r102);     // Catch: Throwable -> L24
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L24
        r103.put("business_type", 0);     // Catch: Throwable -> L24
        r103.put("max_single_duration_sec", 0);     // Catch: Throwable -> L24
        r103.put("max_single_file_size_bytes", 0);     // Catch: Throwable -> L24
        r103.put("max_total_duration_sec", 0);     // Catch: Throwable -> L24
        r103.put("max_total_dir_size_bytes", 0);     // Catch: Throwable -> L24
        r103.put("max_file_count", 0);     // Catch: Throwable -> L24
        byte[] r104 = r103.toString().getBytes(StandardCharsets.UTF_8);     // Catch: Throwable -> L24
        pk4.j.d("OfflineFileProtocol", "Build storage config request, businessType=0, payloadLength=" + r104.length + ", maxFileCount=0");     // Catch: Throwable -> L24
        if (r104.length > 255) goto L27;
        int r105 = B(com.bytedance.dora.offline.file.b.w(59, r104));     // Catch: Throwable -> L20
        if (r105 != 0) goto L17;
        boolean r106 = true;
    L18:
        pk4.j.d("OfflineFileSyncEngine", "Send storage config finished, success=" + r106 + ", ret=" + r105 + ", businessType=0");     // Catch: Throwable -> L20
    L22:
        if (r106 == false) goto L7;
        this.f204515m.remove(0, r101);     // Catch: Throwable -> L24
        goto L7
    L17:
        r106 = false;
    L20:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Send storage config failed, businessType=0", th);     // Catch: Throwable -> L24
        r106 = false;
        goto L22
    L27:
        throw new IllegalArgumentException("storage_cfg_req payload exceeds TLV limit: " + r104.length);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ConcurrentHashMap<Integer, com.bytedance.dora.offline.file.b.g> r107 = this.f204515m;
        r101.getClass();
        r107.remove(0, r101);
        pk4.j.c("OfflineFileSyncEngine", "Drop invalid pending storage config, businessType=0", th);
        goto L7
    L29:
        throw new IllegalArgumentException("storage config is null");     // Catch: Throwable -> L24
    }

    public final boolean n() {
        DoraDevice r100 = this.f204503a.current();
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f204503a.getDoraLinkState(r100) != 2) goto L8;
        r101 = true;
    L8:
        if (r101 == false) goto L10;
        this.f204509g.set(true);
    L10:
        return r101;
    }

    public final void s() {
        p.a r100 = this.A;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f204645l <= 0) goto L10;
        r100.f204646m += Math.max(0, SystemClock.elapsedRealtime() - r100.f204645l);
        r100.f204645l = 0;
        return;
    }

    public final void z() {
        char[] r100 = ek4.a.f472939a;
        String r101 = pk4.c.a.f529617a.a();
        if (r101 != null) goto L5;
    L9:
        String r102 = "";
    L11:
        if (r102.isEmpty() == false) goto L15;
        pk4.j.d("OfflineFileSyncEngine", "Skip sync round because user is unavailable");
        return;
    L15:
        if (this.f204514l.isEmpty() == false) goto L18;
        pk4.j.d("OfflineFileSyncEngine", "Skip sync round because no business is registered");
        return;
    L18:
        long r103 = this.f204512j.get();
        if (this.f204525w == r103) goto L22;
        pk4.j.d("OfflineFileSyncEngine", "Skip sync round until account reconnects, generation=" + r103 + ", connectedGeneration=" + this.f204525w);
        return;
    L22:
        j r104 = new j(r102, r103);
        this.f204526x = r104;
        if (this.f204514l.size() != 1) goto L25;
        int r105 = this.f204514l.keySet().iterator().next().intValue();
    L26:
        this.f204518p.getClass();
        if (r105 == 1) goto L29;
        p.b r106 = null;
    L30:
        this.f204528z = r106;
        g r107 = this.f204519q;
        r107.f204543b = 0;
        r107.f204544c = 0;
        r107.f204545d = null;
        ((HashSet) r107.f204542a).clear();
        int r108 = this.f204523u;
        StopReason r110 = D(r104, false);     // Catch: Throwable -> L38
        if (r110 == StopReason.NONE) goto L34;
        h r109 = l(r110);     // Catch: Throwable -> L38
    L36:
        if (this.f204526x == r104) goto L46;
    L47:
        r104.c();
        this.A = null;
        this.f204528z = null;
        p r111 = this.f204518p;
        int r112 = r109.f204546a;
        int r113 = r109.f204547b;
        r111.getClass();
        if (r106 != null) goto L50;
    L57:
        pk4.j.d("OfflineFileSyncEngine", "Finish offline file sync round, status=" + r109.f204546a + ", terminalReason=" + r109.f204547b);
        return;
    L50:
        if (r106.f204659m == true) goto L57;
        r106.f204659m = true;
        long r114 = Math.max(0, SystemClock.elapsedRealtime() - r106.f204649c);
        HashMap r115 = new HashMap();
        r115.put("session_id", r106.f204647a);
        r115.put("business_type", Integer.valueOf(r106.f204648b));
        r115.put("session_status", Integer.valueOf(r112));
        r115.put("terminal_reason", Integer.valueOf(r113));
        r115.put("duration_ms", Long.valueOf(r114));
        r115.put("remote_file_count", Long.valueOf(r106.f204653g));
        r115.put("pending_file_count", Integer.valueOf(r106.f204652f.size()));
        r115.put("success_file_count", Integer.valueOf(r106.a(0)));
        r115.put("failed_file_count", Integer.valueOf(r106.a(1)));
        r115.put("interrupted_file_count", Integer.valueOf(r106.a(2)));
        r115.put("total_received_size", Long.valueOf(r106.f204654h));
        r115.put("compensation_count", Integer.valueOf(r106.f204655i));
        r115.put("compensation_status", Integer.valueOf(r106.f204656j));
        pk4.l.c("dora_offline_recording_session_result", r115);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        pk4.j.c("OfflineFileSyncTracker", "Report offline file trace failed, event=".concat("dora_offline_recording_session_result"), th);
    L46:
        this.f204526x = null;
        goto L47
    L34:
        pk4.j.d("OfflineFileSyncEngine", "Start offline file sync round, queryBusinessType=" + r105 + ", registeredBusinessTypes=" + this.f204514l.keySet() + ", fileListLimit=" + r108);     // Catch: Throwable -> L38
        r109 = F(r104, r105, r108);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        StopReason r116 = D(r104, false);     // Catch: Throwable -> L59
        if (r116 == StopReason.NONE) goto L42;
        h r117 = l(r116);     // Catch: Throwable -> L59
        pk4.j.d("OfflineFileSyncEngine", "Stop sync round after interruption, reason=" + r116 + ", error=" + th.getMessage());     // Catch: Throwable -> L59
        r109 = r117;
    L45:
        if (this.f204526x != r104) goto L47;
    L42:
        pk4.j.c("OfflineFileSyncEngine", "Offline file sync round failed", th);     // Catch: Throwable -> L59
        t(8999);     // Catch: Throwable -> L59
        r109 = new h(1, 8999);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        if (this.f204526x != r104) goto L63;
        this.f204526x = null;
    L63:
        r104.c();
        this.A = null;
        this.f204528z = null;
        throw th;
    L29:
        r106 = new p.b(UUID.randomUUID().toString(), r105, SystemClock.elapsedRealtime());
        goto L30
    L25:
        r105 = 0;
        goto L26
    L5:
        if (r101.isEmpty() == true) goto L9;
        r102 = r101.trim();
        if (r102.isEmpty() == false) goto L11;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.dora.offline.file.i] */
    public OfflineFileSyncEngine() {
        this.f204503a = ak4.a.d();
        this.f204504b = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new n());
        final String r100 = "Dora-OfflineFileResponse";
        this.f204505c = PThreadExecutorsUtils.newSingleThreadExecutor(new m(r100));
        final String r101 = "Dora-OfflineFileReady";
        this.f204506d = PThreadExecutorsUtils.newSingleThreadExecutor(new m(r101));
        this.f204507e = new AtomicBoolean(false);
        this.f204508f = new AtomicBoolean(false);
        this.f204509g = new AtomicBoolean(false);
        this.f204510h = new AtomicBoolean(false);
        this.f204511i = new AtomicBoolean(false);
        this.f204512j = new AtomicLong();
        this.f204513k = new Object();
        this.f204514l = new ConcurrentHashMap();
        this.f204515m = new ConcurrentHashMap();
        this.f204516n = new com.bytedance.dora.offline.file.d();
        this.f204517o = new com.bytedance.dora.offline.file.c();
        this.f204518p = new p();
        this.f204519q = new g();
        this.f204523u = 10;
        this.f204521s = new a(this);
        this.f204522t = new b(this);
        this.f204520r = new com.bytedance.dora.offline.file.a(new com.bytedance.dora.offline.file.i(this));
    }

    public static int G(StopReason r100) {
        int r101 = c.f204533a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 8002;
    L5:
        if (r101 != 2) goto L7;
        return 8003;
    L7:
        if (r101 != 3) goto L9;
        return 8001;
    L9:
        if (r101 == 4) goto L18;
        return 8999;
    L18:
        return 8001;
    }

    public static String h(com.bytedance.dora.offline.file.b.d r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return "businessType=" + r100.f204581a + ", vuiId=" + r100.f204582b + ", contextType=" + r100.f204583c + ", fileType=" + r100.f204585e + ", fileFormat=" + r100.f204590j + ", fileSize=" + r100.f204589i;
    }

    public static h l(StopReason r100) {
        return new h(2, G(r100));
    }

    public static boolean o(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.isFile() == false) goto L9;
        if (r100.canRead() == false) goto L9;
        return true;
    }

    public final int B(byte[] r100) {
        return this.f204503a.j(2, 5, r100, KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
    }

    public final void b(String r100) {
        Object r101 = this.f204513k;
        monitor-enter(r101);
        ScheduledFuture<?> r102 = this.f204527y;     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        r102.cancel(false);     // Catch: Throwable -> L11
        this.f204527y = null;     // Catch: Throwable -> L11
        pk4.j.d("OfflineFileSyncEngine", "Cancel delayed offline file discovery, reason=".concat(r100));     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void d(String r100) {
        j r101 = this.f204526x;
        if (r101 == null) goto L6;
        r101.c();
        pk4.j.d("OfflineFileSyncEngine", "Close active offline file session, reason=".concat(r100));
        return;
    }

    public final void t(int r100) {
        p.b r101 = this.f204528z;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f204657k != 0) goto L10;
        if (r100 == 0) goto L11;
        r101.f204657k = r100;
        r101.b();
        return;
    L11:
        return;
    }

    public static void q(com.bytedance.dora.offline.file.b.d r100, String r101) {
        pk4.j.b("OfflineFileSyncEngine", "Offline file sync error, message=" + r101 + ", file=" + h(r100));
    }

    public final StopReason D(j r100, boolean r101) {
        if (r100.f204551b == this.f204512j.get()) goto L5;
    L33:
        b("account_changed");
        r100.c();
        return StopReason.ACCOUNT_CHANGED;
    L5:
        if (ek4.a.a(r100.f204550a) == false) goto L33;
        if (this.f204509g.get() == true) goto L14;
        if (n() == true) goto L14;
        return StopReason.DISCONNECTED;
    L14:
        if (this.f204524v == true) goto L18;
        return StopReason.ABILITY_UNSUPPORTED;
    L18:
        if (r100.f204560k == false) goto L22;
        return StopReason.DISCONNECTED;
    L22:
        if (r100.f204561l == false) goto L26;
        return StopReason.CANCELLED;
    L26:
        if ((!((ConcurrentHashMap) this.f204520r.f204566a).isEmpty()) == false) goto L32;
        if (r101 == false) goto L30;
        this.f204508f.set(true);
    L30:
        return StopReason.BUSINESS_BLOCKED;
    L32:
        return StopReason.NONE;
    }

    public final FileOutcome E(j r210, f r211) throws Exception {
        StopReason r100 = D(r210, true);
        StopReason r101 = StopReason.NONE;
        if (r100 != r101) goto L5;
        com.bytedance.dora.offline.file.b.d r102 = r211.f204539a;
        OfflineFileBusiness r103 = r211.f204540b;
        p.a r104 = r211.f204541c;
        r211.f204541c = null;
        if (r104 != null) goto L13;
        p.b r110 = this.f204528z;
        if (r110 != null) goto L11;
        r104 = null;
        goto L13
    L11:
        this.f204518p.getClass();
        r104 = new p.a(r110, UUID.randomUUID().toString(), r102.f204581a, r102.f204582b, r102.f204589i, SystemClock.elapsedRealtime());
    L13:
        this.A = r104;
        this.f204519q.a(null);
        int r105 = 4001;
        PolarisFileWrapper r106 = x(r210, r102, r103);     // Catch: Throwable -> L43 TransferFailure -> L86
        if (r106 != null) goto L21;
        j(1, 4001);     // Catch: Throwable -> L43 TransferFailure -> L86
        FileOutcome r107 = FileOutcome.FAILED;     // Catch: Throwable -> L43 TransferFailure -> L86
        if (this.A != r104) goto L20;
        this.A = null;
    L20:
        return r107;
    L21:
        FileOutcome r111 = y(r210, r102, r106);     // Catch: Throwable -> L43 TransferFailure -> L86
        int r112 = 0;
        if (r111 != null) goto L24;
        byte[] r113 = p(r102, r106);     // Catch: Throwable -> L43 TransferFailure -> L86
        if (r113 != null) goto L45;
        FileOutcome r114 = i(r210, r102, r106);     // Catch: Throwable -> L43 TransferFailure -> L86
        if (r114 == FileOutcome.COMPLETED) goto L50;
        if (this.A != r104) goto L42;
        this.A = null;
    L42:
        return r114;
    L50:
        if (J(r102, r106, r113) == true) goto L56;
        j(1, 5001);     // Catch: Throwable -> L78 TransferFailure -> L86
        c(r210, r102, "integrity_check_failed");     // Catch: Throwable -> L78 TransferFailure -> L86
        FileOutcome r108 = FileOutcome.SKIPPED_NEXT_ROUND;     // Catch: Throwable -> L78 TransferFailure -> L86
        if (this.A != r104) goto L55;
        this.A = null;
    L55:
        return r108;
    L56:
        j(0, 0);     // Catch: Throwable -> L78 TransferFailure -> L86
        if (o(r106) == true) goto L67;
        q(r102, "local_file_not_ready");     // Catch: Throwable -> L78 TransferFailure -> L86
        r(r102, 4001);     // Catch: Throwable -> L43 TransferFailure -> L86
        FileOutcome r109 = FileOutcome.FAILED;     // Catch: Throwable -> L43 TransferFailure -> L86
        if (this.A != r104) goto L64;
        this.A = null;
    L64:
        return r109;
    L67:
        if (D(r210, true) == r101) goto L73;
        FileOutcome r115 = FileOutcome.INTERRUPTED;     // Catch: Throwable -> L43 TransferFailure -> L86
        if (this.A != r104) goto L72;
        this.A = null;
    L72:
        return r115;
    L73:
        FileOutcome r116 = g(r210, r102, r106, r103);     // Catch: Throwable -> L43 TransferFailure -> L86
        if (this.A != r104) goto L77;
        this.A = null;
    L77:
        return r116;
    L45:
        long r117 = r106.length();     // Catch: Throwable -> L43 TransferFailure -> L86
        p.a r118 = this.A;     // Catch: Throwable -> L43 TransferFailure -> L86
        if (r118 == null) goto L50;
        r118.f204641h = Math.max(0, r117);     // Catch: Throwable -> L78 TransferFailure -> L86
    L78:
        th = th;
        r105 = 4001;
    L81:
        if ((th instanceof IOException) == false) goto L83;
        int r119 = 1;
    L84:
        j(r119, r105);     // Catch: Throwable -> L95
        throw th;     // Catch: Throwable -> L95
    L83:
        r119 = 1;
        r105 = 8999;
        goto L84
    L24:
        if (r111 != FileOutcome.COMPLETED) goto L27;
        int r120 = 0;
    L30:
        j(r120, r112);     // Catch: Throwable -> L43 TransferFailure -> L86
        if (this.A != r104) goto L34;
        this.A = null;
    L34:
        return r111;
    L27:
        if (r111 != FileOutcome.INTERRUPTED) goto L29;
        r112 = G(D(r210, false));     // Catch: Throwable -> L43 TransferFailure -> L86
        r120 = 2;
        goto L30
    L29:
        r120 = 1;
        r112 = 8999;
    L43:
        th = th;
    L86:
        e = move-exception;
        j(1, e.terminalReason);     // Catch: Throwable -> L95
        pk4.j.c("OfflineFileSyncEngine", "Transfer offline file failed, " + h(r102), e);     // Catch: Throwable -> L95
        if (D(r210, true) != StopReason.NONE) goto L90;
        FileOutcome r121 = FileOutcome.DEFERRED;     // Catch: Throwable -> L95
    L92:
        if (this.A != r104) goto L94;
        this.A = null;
    L94:
        return r121;
    L90:
        r121 = FileOutcome.INTERRUPTED;     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        if (this.A != r104) goto L99;
        this.A = null;
    L99:
        throw th;
    L5:
        return FileOutcome.INTERRUPTED;
    }

    public final void j(int r100, int r101) {
        k(this.A, r100, r101);
    }

    public final boolean m(j r100, long r101) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (this.f204526x != r100) goto L8;
        if (r100.d(r101) == false) goto L8;
        return true;
    }

    public final byte[] p(com.bytedance.dora.offline.file.b.d r100, PolarisFileWrapper r101) throws Exception {
        if (o(r101) == true) goto L5;
        return null;
    L5:
        this.f204516n.getClass();
        byte[] r102 = com.bytedance.dora.offline.file.d.e(r101);
        if (r101.length() < r100.f204589i) goto L8;
    L16:
        this.f204519q.a(r101);
        return r102;
    L8:
        if (com.bytedance.dora.offline.file.b.e(r100.f204600t) == false) goto L16;
        this.f204516n.getClass();
        String r103 = com.bytedance.dora.offline.file.d.g(r102);
        String r104 = r100.f204600t;
        if (r104 != null) goto L12;
        String r105 = "";
    L14:
        if (TextUtils.equals(r105, r103) == true) goto L16;
        return null;
    L12:
        r105 = r104.toLowerCase(Locale.US);
        goto L14
    }

    public final void r(com.bytedance.dora.offline.file.b.d r100, int r101) {
        p.b r102 = this.f204528z;
        if (r102 == null) goto L6;
        String r103 = r100.a();
        r102.f204651e.put(r103, Integer.valueOf(r101));
        r102.b();
        return;
    }

    public final void v(j r110, com.bytedance.dora.offline.file.b.d r111) {
        OfflineFileBusiness r100 = this.f204514l.get(Integer.valueOf(r111.f204581a));
        if (r100 != null) goto L5;
        return;
    L5:
        if (r110.a() == false) goto L19;
        String r112 = r110.f204550a;     // Catch: Throwable -> L13
        g r101 = this.f204519q;     // Catch: Throwable -> L13
        int r102 = Math.max(0, Math.min(r101.f204544c, r101.f204543b));     // Catch: Throwable -> L13
        int r103 = r101.f204543b;     // Catch: Throwable -> L13
        if (r103 != 0) goto L10;
        int r104 = 0;
    L11:
        r100.e(r112, new OfflineFileBusiness.a(r111.f204581a, r111.f204582b, r101.f204543b, r102, r104, r101.f204545d, System.currentTimeMillis()));     // Catch: Throwable -> L13
        return;
    L10:
        r104 = (int) Math.min(100, (((long) r102) * 100) / ((long) r103));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Notify offline file progress failed, " + h(r111), th);
        return;
    }

    public final void C(com.bytedance.dora.offline.file.b.d r100, long r101, int r102) throws TransferFailure {
        int r103 = B(com.bytedance.dora.offline.file.b.w(56, com.bytedance.dora.offline.file.b.b(new byte[][]{com.bytedance.dora.offline.file.b.d(r100.f204581a, r100.f204582b), com.bytedance.dora.offline.file.b.x(r101), com.bytedance.dora.offline.file.b.x(960), com.bytedance.dora.offline.file.b.x(r102)})));     // Catch: Throwable -> L8
        if (r103 != 0) goto L7;
        return;
    L7:
        throw new TransferFailure(3001, "Send file data request failed, ret=" + r103 + ", offset=" + r101);
    L8:
        th = move-exception;
        throw new TransferFailure(3001, "Send file data request failed, offset=" + r101, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.bytedance.dora.offline.file.OfflineFileSyncEngine] */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Iterable, java.util.List] */
    public final h F(j r210, int r211, int r212) throws Exception {
        i r100 = new i();
        HashSet r101 = new HashSet();
        int r102 = 0;
        int r103 = 0;
        boolean r104 = false;
    L3:
        StopReason r105 = D(r210, true);
        if (r105 != StopReason.NONE) goto L6;
        monitor-enter(r210);
        r210.f204552c.clear();     // Catch: Throwable -> L167
        r210.f204555f = r211;     // Catch: Throwable -> L167
        r210.f204562m++;     // Catch: Throwable -> L167
        monitor-exit(r210);
        int r106 = 1;
    L11:
        Integer r110 = null;
        if (r106 > 3) goto L36;
        if (D(r210, true) != StopReason.NONE) goto L36;
        com.bytedance.dora.offline.file.b.c r111 = r210.f204552c.poll();
        if (r111 != null) goto L19;
    L22:
        byte[] r112 = new byte[2];
        long r113 = r211;
        com.bytedance.dora.offline.file.b.v("business_type", r113);
        r112[r102] = (byte) r113;
        long r114 = r212;
        com.bytedance.dora.offline.file.b.v("file_list_limit", r114);
        r112[1] = (byte) r114;
        int r115 = B(com.bytedance.dora.offline.file.b.w(54, r112));
        if (r115 == 0) goto L25;
        pk4.j.f("OfflineFileSyncEngine", "Send file list request failed, ret=" + r115 + ", attempt=" + r106);
    L35:
        r106 = r106 + 1;
        goto L11
    L25:
        r111 = r210.f204552c.poll(KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL, TimeUnit.MILLISECONDS);
        if (r111 != null) goto L28;
    L30:
        StringBuilder r116 = new StringBuilder("Wait file list response failed, attempt=");
        r116.append(r106);
        r116.append(", retCode=");
        if (r111 == null) goto L34;
        r110 = Integer.valueOf(r111.f204577a);
    L34:
        r116.append(r110);
        pk4.j.f("OfflineFileSyncEngine", r116.toString());
        goto L35
    L28:
        if (r111.f204577a != 0) goto L30;
    L38:
        if (r111 == null) goto L39;
        int r117 = r111.f204580d.size();
        p.b r118 = this.f204528z;
        if (r118 == null) goto L48;
        r118.f204653g += (long) Math.max(r102, r117);
    L48:
        List<com.bytedance.dora.offline.file.b.C2961b> r107 = r111.f204580d;
        if (r107 != null) goto L51;
    L60:
        ?? r108 = Collections.emptyList();
    L62:
        if (r108.isEmpty() == true) goto L63;
        ArrayList r109 = new ArrayList();
        Iterator r119 = r108.iterator();
    L70:
        if (r119.hasNext() == false) goto L72;
        com.bytedance.dora.offline.file.b.C2961b r120 = (com.bytedance.dora.offline.file.b.C2961b) r119.next();
        r109.add(r120.f204575a + "_" + com.bytedance.dora.offline.file.b.g(r120.f204576b));
        goto L70
    L72:
        Collections.sort(r109);
        if (r101.add(TextUtils.join(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, r109)) == false) goto L74;
        p.b r121 = this.f204528z;
        if (r121 == null) goto L82;
        Iterator r122 = r108.iterator();
    L80:
        if (r122.hasNext() == false) goto L82;
        com.bytedance.dora.offline.file.b.C2961b r123 = (com.bytedance.dora.offline.file.b.C2961b) r122.next();
        r121.f204652f.add(r123.f204575a + "_" + com.bytedance.dora.offline.file.b.g(r123.f204576b));
    L82:
        List<f> r124 = w(r210, r108, r100);
        StopReason r125 = D(r210, true);
        if (r125 != StopReason.NONE) goto L85;
        ArrayList r126 = (ArrayList) r124;
        if (r126.isEmpty() == true) goto L89;
        int r127 = r126.size();
        if (r104 == false) goto L97;
        int r128 = 0;
        boolean r129 = false;
    L104:
        if (r129 == false) goto L106;
        v(r210, ((f) ListProtector.get(r124, r128)).f204539a);
    L106:
        int r130 = this.f204519q.f204544c;
        ArrayList r131 = new ArrayList();
        Iterator r132 = r126.iterator();
    L108:
        if (r132.hasNext() == false) goto L124;
        f r133 = (f) r132.next();
        FileOutcome r134 = E(r210, r133);
        FileOutcome r135 = FileOutcome.DEFERRED;
        if (r134 != r135) goto L113;
        r131.add(r133);
        boolean r136 = true;
    L121:
        if (r134 != FileOutcome.INTERRUPTED) goto L108;
        h r137 = l(D(r210, r136));
    L151:
        if (r137 != null) goto L152;
        if (r100.f204549b == true) goto L155;
        boolean r138 = r111.f204579c;
        if (r138 == true) goto L160;
    L163:
        if (r138 == false) goto L165;
        r103 = r103 + 1;
        r102 = 0;
        goto L3
    L165:
        return r100.a(this.f204528z);
    L160:
        if (this.f204519q.f204544c > r130) goto L163;
        pk4.j.f("OfflineFileSyncEngine", "Stop paging because current page made no progress, pageIndex=" + r103 + ", completedCount=" + this.f204519q.f204544c);
        t(1001);
        return new h(1, 1001);
    L155:
        pk4.j.d("OfflineFileSyncEngine", "Stop paging because deferred files remain on device, pageIndex=" + r103);
        return r100.a(this.f204528z);
    L152:
        return r137;
    L113:
        if (r134 != FileOutcome.FAILED) goto L115;
        r136 = true;
        r100.f204548a = true;
        goto L121
    L115:
        r136 = true;
        if (r134 != r135) goto L118;
    L119:
        r100.f204549b = true;
        goto L121
    L118:
        if (r134 != FileOutcome.SKIPPED_NEXT_ROUND) goto L121;
    L124:
        Iterator r139 = r131.iterator();
    L126:
        if (r139.hasNext() == false) goto L150;
        f r140 = (f) r139.next();
        int r141 = 1;
    L128:
        if (r141 > 3) goto L146;
        if (D(r210, true) != StopReason.NONE) goto L131;
        pk4.j.d("OfflineFileSyncEngine", "Retry deferred offline file, businessType=" + r140.f204539a.f204581a + ", vuiId=" + r140.f204539a.f204582b + ", attempt=" + r141);
        FileOutcome r142 = E(r210, r140);
        if (r142 == FileOutcome.INTERRUPTED) goto L134;
        FileOutcome r143 = FileOutcome.DEFERRED;
        if (r142 != r143) goto L138;
        r141 = r141 + 1;
        goto L128
    L138:
        if (r142 != FileOutcome.FAILED) goto L140;
        r100.f204548a = true;
    L144:
        boolean r144 = true;
    L147:
        if (r144 == true) goto L126;
        c(r210, r140.f204539a, "transfer_failed");
        r100.f204549b = true;
        goto L126
    L140:
        if (r142 != r143) goto L142;
    L143:
        r100.f204549b = true;
        goto L144
    L142:
        if (r142 != FileOutcome.SKIPPED_NEXT_ROUND) goto L144;
    L134:
        r137 = l(D(r210, true));
        goto L151
    L131:
        r137 = l(D(r210, true));
        goto L151
    L146:
        r144 = false;
        goto L147
    L150:
        r137 = null;
        goto L151
    L97:
        if (r111.f204579c == false) goto L103;
        long r145 = r111.f204578b;
        if (r145 <= SieveCacheKt.NodeLinkMask) goto L102;
        r127 = Integer.MAX_VALUE;
        goto L103
    L102:
        r127 = Math.max(r127, (int) Math.max(0, r145));
    L103:
        g r146 = this.f204519q;
        r128 = 0;
        r146.f204543b = 0;
        r146.f204544c = 0;
        r146.f204545d = null;
        ((HashSet) r146.f204542a).clear();
        r146.f204543b = Math.max(0, r127);
        r104 = true;
        r129 = true;
        goto L104
    L89:
        if (r100.f204548a == false) goto L92;
        return r100.a(this.f204528z);
    L92:
        return new h(3, 1003);
    L85:
        return l(r125);
    L74:
        pk4.j.f("OfflineFileSyncEngine", "Stop sync because device returned a repeated page, pageIndex=" + r103 + ", fileCount=" + r108.size());
        t(1001);
        return new h(1, 1001);
    L63:
        if (r104 == true) goto L67;
        t(1003);
        return new h(3, 1003);
    L67:
        return r100.a(this.f204528z);
    L51:
        if (r107.isEmpty() == true) goto L60;
        r108 = new ArrayList();
        Iterator<com.bytedance.dora.offline.file.b.C2961b> r147 = r107.iterator();
    L55:
        if (r147.hasNext() == false) goto L62;
        com.bytedance.dora.offline.file.b.C2961b r148 = r147.next();
        if (this.f204514l.containsKey(Integer.valueOf(r148.f204575a)) == true) goto L58;
        pk4.j.d("OfflineFileSyncEngine", "Skip file without registered business, businessType=" + r148.f204575a + ", vuiId=" + r148.f204576b);
        goto L55
    L58:
        r108.add(r148);
        goto L55
    L39:
        StopReason r149 = D(r210, true);
        if (r149 != StopReason.NONE) goto L42;
        q(null, "query_file_list_failed");
        t(1001);
        return new h(1, 1001);
    L42:
        return l(r149);
    L19:
        if (r111.f204577a == 0) goto L38;
        pk4.j.f("OfflineFileSyncEngine", "Ignore failed cached file list response, attempt=" + r106 + ", retCode=" + r111.f204577a);
    L36:
        r111 = null;
    L167:
        th = move-exception;
        throw th;
    L6:
        return l(r105);
    }

    public final void I(com.bytedance.dora.offline.file.b.d r100, k r101, d r102) throws TransferFailure {
        if (r101.f204564b == r102.f204534a) goto L6;
        r101.f204565c = 0;
        return;
    L6:
        int r103 = r101.f204565c + 1;
        r101.f204565c = r103;
        if (r103 >= 3) goto L13;
        p.a r104 = this.A;
        if (r104 == null) goto L14;
        r104.f204642i++;
        return;
    L14:
        return;
    L13:
        throw new TransferFailure(3002, "File transfer timeout, vuiId=" + r100.f204582b + ", offset=" + r101.f204564b);
    }

    public final boolean J(com.bytedance.dora.offline.file.b.d r100, PolarisFileWrapper r101, byte[] r102) throws Exception {
        if (o(r101) == true) goto L5;
        return false;
    L5:
        if (r102 != null) goto L7;
        this.f204516n.getClass();
        r102 = com.bytedance.dora.offline.file.d.e(r101);
    L7:
        this.f204516n.getClass();
        String r103 = com.bytedance.dora.offline.file.d.g(r102);
        String r104 = r100.f204600t;
        if (r104 != null) goto L10;
        String r105 = "";
    L12:
        if (TextUtils.equals(r105, r103) == false) goto L18;
        p.a r106 = this.A;
        if (r106 == null) goto L16;
        r106.f204643j = true;
    L16:
        return true;
    L18:
        if (r101.length() != r100.f204589i) goto L21;
        pk4.j.d("OfflineFileSyncEngine", "Accept file by size because checksum is unavailable or mismatched, checksumPresent=" + com.bytedance.dora.offline.file.b.e(r100.f204600t) + ", " + h(r100));
        return true;
    L21:
        return false;
    L10:
        r105 = r104.toLowerCase(Locale.US);
        goto L12
    }

    public final void c(j r100, com.bytedance.dora.offline.file.b.d r101, String r102) {
        com.bytedance.dora.offline.file.c r103 = this.f204517o;
        String r104 = r100.f204550a;
        r103.getClass();
        pk4.i r105 = pk4.i.a.f529628a;
        r105.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r104, "progress_", r101.a()), 0);
        com.bytedance.dora.offline.file.d r106 = this.f204516n;
        String r107 = r100.f204550a;
        String r108 = r101.a();
        r106.getClass();
        pk4.j.d("OfflineFileSyncEngine", "Clean offline file for next round, deleted=" + com.bytedance.dora.offline.file.d.b(r107, r108) + ", reason=" + r102 + ", " + h(r101));
    }

    public final boolean e(j r110, com.bytedance.dora.offline.file.b.d r111, boolean r112) {
        if (D(r110, false) == StopReason.NONE) goto L5;
        return false;
    L5:
        if (r112 == false) goto L10;
        com.bytedance.dora.offline.file.d r100 = this.f204516n;
        String r101 = r110.f204550a;
        String r102 = r111.a();
        r100.getClass();
        if (com.bytedance.dora.offline.file.d.b(r101, r102) == true) goto L10;
        q(r111, "local_file_delete_failed");
        r(r111, 4001);
        return false;
    L10:
        int r103 = 1;
    L12:
        if (r103 > 3) goto L31;
        StopReason r104 = D(r110, false);
        StopReason r105 = StopReason.NONE;
        if (r104 != r105) goto L31;
        int r106 = B(com.bytedance.dora.offline.file.b.w(57, com.bytedance.dora.offline.file.b.d(r111.f204581a, r111.f204582b)));     // Catch: Throwable -> L23
        if (D(r110, false) != r105) goto L31;
        if (r106 == 0) goto L20;
        pk4.j.f("OfflineFileSyncEngine", "Send sync confirmation failed, ret=" + r106 + ", attempt=" + r103 + ", " + h(r111));     // Catch: Throwable -> L23
    L25:
        if (r103 >= 3) goto L30;
        Thread.sleep(300);     // Catch: InterruptedException -> L29
    L29:
        ThreadMethodProxy.currentThread().interrupt();
    L30:
        r103 = r103 + 1;
        goto L12
    L20:
        boolean r107 = true;
    L32:
        if (r107 == true) goto L36;
        q(r111, "device_delete_confirm_failed");
        r(r111, 8999);
        return false;
    L36:
        if (r112 == false) goto L38;
        com.bytedance.dora.offline.file.c r113 = this.f204517o;
        String r114 = r110.f204550a;
        r113.getClass();
        String r115 = r111.a();
        pk4.i r108 = pk4.i.a.f529628a;
        r108.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r114, "progress_", r115), 0);
        com.bytedance.dora.offline.file.c.b(com.bytedance.dora.offline.file.c.c(r114, "local_retained_", r111.a()), false);
        com.bytedance.dora.offline.file.c.b(com.bytedance.dora.offline.file.c.a(r114, r111), false);
    L39:
        return true;
    L38:
        com.bytedance.dora.offline.file.c r116 = this.f204517o;
        String r117 = r110.f204550a;
        r116.getClass();
        String r118 = r111.a();
        pk4.i r109 = pk4.i.a.f529628a;
        r109.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r117, "progress_", r118), 0);
        com.bytedance.dora.offline.file.c.b(com.bytedance.dora.offline.file.c.a(r117, r111), false);
    L23:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Send sync confirmation failed with exception, attempt=" + r103 + ", " + h(r111), th);
    L31:
        r107 = false;
        goto L32
    }

    public final FileOutcome i(j r110, com.bytedance.dora.offline.file.b.d r111, PolarisFileWrapper r112) throws Exception {
        com.bytedance.dora.offline.file.d r100 = this.f204516n;
        String r101 = r110.f204550a;
        long r102 = r111.f204589i;
        r100.getClass();
        PolarisFileWrapper r103 = com.bytedance.dora.offline.file.d.a(r101);
        if (r102 > 0) goto L6;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L16;
        q(r111, "disk_full");
        j(1, 4002);
        return FileOutcome.FAILED;
    L16:
        com.bytedance.dora.offline.file.c r105 = this.f204517o;
        String r106 = r110.f204550a;
        r105.getClass();
        pk4.i r107 = pk4.i.a.f529628a;
        Long r108 = 0L;
        long r109 = r107.f529627a.getLong(com.bytedance.dora.offline.file.c.c(r106, "progress_", r111.a()), r108.longValue());
        if (r112.exists() == false) goto L19;
        long r113 = r112.length();
    L20:
        long r114 = Math.min(r109, r113);
        p.a r115 = this.A;
        if (r115 == null) goto L23;
        r115.f204641h = Math.max(0, r114);
    L23:
        pk4.j.d("OfflineFileSyncEngine", "Start offline file download, " + h(r111) + ", startOffset=" + r114);
        StopReason r116 = H(r110, r111, r112, r114);     // Catch: IOException -> L31
        if (r116 == StopReason.NONE) goto L30;
        j(2, G(r116));
        return FileOutcome.INTERRUPTED;
    L30:
        return FileOutcome.COMPLETED;
    L31:
        e = move-exception;
        throw new TransferFailure(4001, "Write offline file failed, vuiId=" + r111.f204582b, e);
    L19:
        r113 = 0;
        goto L20
    L6:
        if (r102 <= 4611686018427387903L) goto L8;
        long r117 = Long.MAX_VALUE;
    L10:
        if (r103.getUsableSpace() <= r117) goto L12;
        r104 = true;
        goto L13
    L8:
        r117 = r102 * 2;
        goto L10
    }

    public final void k(p.a r110, int r111, int r112) {
        if (r110 == null) goto L35;
        this.f204518p.getClass();
        if (r110.f204644k == true) goto L36;
        r110.f204644k = true;
        p.b r100 = r110.f204634a;
        r100.getClass();
        String r101 = r110.f204636c + "_" + r110.f204637d;
        r100.f204650d.put(r101, Integer.valueOf(r111));
        r100.f204652f.remove(r101);
        r100.f204654h += r110.f204640g;
        r100.f204651e.put(r101, Integer.valueOf(r112));
        r100.b();
        long r102 = 0;
        long r103 = Math.max(0, SystemClock.elapsedRealtime() - r110.f204638e);
        if (r110.f204645l > 0) goto L10;
        long r104 = r110.f204646m;
    L11:
        long r105 = r110.f204640g;
        if (r105 > 0) goto L14;
    L16:
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L17:
        HashMap r113 = new HashMap();
        r113.put("session_id", r110.f204634a.f204647a);
        r113.put("attempt_id", r110.f204635b);
        String r114 = r110.f204637d;
        if (r114 != null) goto L20;
    L25:
        r113.put("record_id", Long.valueOf(r102));
        r113.put("business_type", Integer.valueOf(r110.f204636c));
        r113.put("pull_status", Integer.valueOf(r111));
        r113.put("terminal_reason", Integer.valueOf(r112));
        r113.put("file_size", Long.valueOf(r110.f204639f));
        r113.put("received_size", Long.valueOf(r110.f204640g));
        r113.put("resume_offset", Long.valueOf(r110.f204641h));
        r113.put("duration_ms", Long.valueOf(r103));
        r113.put("receive_duration_ms", Long.valueOf(r104));
        r113.put("received_speed", Double.valueOf(r106));
        r113.put("data_retry_count", Integer.valueOf(r110.f204642i));
        r113.put("checksum_valid", Integer.valueOf(r110.f204643j ? 1 : 0));
        pk4.l.c("dora_offline_recording_file_result", r113);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        pk4.j.c("OfflineFileSyncTracker", "Report offline file trace failed, event=".concat("dora_offline_recording_file_result"), th);
        return;
    L20:
        if (r114.length() == 0) goto L25;
        r102 = Math.max(0, CastLongProtector.parseLong(r114));     // Catch: NumberFormatException -> L24
    L24:
        pk4.j.f("OfflineFileSyncTracker", "Parse record id failed, valueLength=" + r114.length());
        goto L25
    L14:
        if (r104 <= 0) goto L16;
        r106 = (r105 / 1024.0d) / (r104 / 1000.0d);
        goto L17
    L10:
        r104 = r110.f204646m + Math.max(0, SystemClock.elapsedRealtime() - r110.f204645l);
        goto L11
    L36:
        return;
    }

    public final List<f> w(j r110, List<com.bytedance.dora.offline.file.b.C2961b> r210, i r211) throws InterruptedException {
        ArrayList r100 = new ArrayList();
        Iterator<com.bytedance.dora.offline.file.b.C2961b> r101 = r210.iterator();
    L4:
        if (r101.hasNext() == false) goto L89;
        com.bytedance.dora.offline.file.b.C2961b r102 = r101.next();
        if (D(r110, true) != StopReason.NONE) goto L7;
        p.b r111 = this.f204528z;
        if (r111 != null) goto L11;
        p.a r103 = null;
    L12:
        int r104 = r102.f204575a;
        String r112 = r102.f204576b;
        monitor-enter(r110);
        r110.f204553d.clear();     // Catch: Throwable -> L86
        r110.f204556g = r104;     // Catch: Throwable -> L86
        r110.f204557h = r112;     // Catch: Throwable -> L86
        r110.f204562m++;     // Catch: Throwable -> L86
        monitor-exit(r110);
        int r105 = 1;
    L18:
        if (r105 > 3) goto L42;
        if (D(r110, true) != StopReason.NONE) goto L42;
        com.bytedance.dora.offline.file.b.e r113 = r110.f204553d.poll();
        if (r113 != null) goto L25;
    L28:
        int r114 = B(com.bytedance.dora.offline.file.b.w(55, com.bytedance.dora.offline.file.b.d(r102.f204575a, r102.f204576b)));
        if (r114 == 0) goto L31;
        pk4.j.f("OfflineFileSyncEngine", "Send metadata request failed, ret=" + r114 + ", vuiId=" + r102.f204576b + ", attempt=" + r105);
    L41:
        r105 = r105 + 1;
        goto L18
    L31:
        com.bytedance.dora.offline.file.b.e r115 = r110.f204553d.poll(KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL, TimeUnit.MILLISECONDS);
        if (r115 != null) goto L34;
    L36:
        StringBuilder r116 = new StringBuilder("Wait metadata response failed, vuiId=");
        r116.append(r102.f204576b);
        r116.append(", attempt=");
        r116.append(r105);
        r116.append(", retCode=");
        if (r115 != null) goto L39;
        Integer r117 = null;
    L40:
        r116.append(r117);
        pk4.j.f("OfflineFileSyncEngine", r116.toString());
        goto L41
    L39:
        r117 = Integer.valueOf(r115.f204601a);
        goto L40
    L34:
        if (r115.f204601a != 0) goto L36;
        com.bytedance.dora.offline.file.b.d r106 = r115.f204602b;
    L43:
        if (r106 == null) goto L44;
        if (r103 == null) goto L57;
        r103.f204639f = Math.max(0, r106.f204589i);
    L57:
        OfflineFileBusiness r107 = this.f204514l.get(Integer.valueOf(r106.f204581a));
        if (r107 != null) goto L91;
        String r108 = "unsupported_business_type_" + r106.f204581a;
    L79:
        if (r108 != null) goto L80;
        r100.add(new f(r106, r107, r103));
        goto L4
    L80:
        r211.f204548a = true;
        if ("invalid_file_size".equals(r108) == false) goto L83;
        int r109 = 2004;
    L84:
        k(r103, 1, r109);
        q(r106, r108);
        goto L4
    L83:
        r109 = 2002;
        goto L84
    L91:
        com.bytedance.dora.offline.file.b.r(r106.f204582b, "uint32");     // Catch: IllegalArgumentException -> L63
        boolean r118 = true;
    L64:
        if (r118 == true) goto L67;
        r108 = "invalid_vui_id";
        goto L79
    L67:
        if (r106.f204591k == 1) goto L70;
        r108 = "file_not_ready";
        goto L79
    L70:
        if (r106.f204592l == true) goto L72;
        r108 = "pull_not_allowed";
        goto L79
    L72:
        long r119 = r106.f204589i;
        if (r119 > 0) goto L75;
    L78:
        r108 = "invalid_file_size";
        goto L79
    L75:
        if (r119 > BodyPartID.bodyIdMax) goto L78;
        r108 = r107.a(r106);
    L63:
        r118 = false;
        goto L64
    L44:
        StopReason r120 = D(r110, true);
        StopReason r121 = StopReason.NONE;
        if (r120 != r121) goto L47;
        int r122 = 1;
    L48:
        if (r120 != r121) goto L50;
        int r123 = 2001;
    L51:
        k(r103, r122, r123);
        if (r120 != r121) goto L4;
        r211.f204548a = true;
        q(null, "query_file_metadata_failed, vuiId=" + r102.f204576b);
        goto L4
    L50:
        r123 = G(r120);
        goto L51
    L47:
        r122 = 2;
        goto L48
    L25:
        if (r113.f204601a == 0) goto L26;
        pk4.j.f("OfflineFileSyncEngine", "Ignore failed cached metadata response, vuiId=" + r102.f204576b + ", attempt=" + r105 + ", retCode=" + r113.f204601a);
        goto L28
    L26:
        r106 = r113.f204602b;
    L42:
        r106 = null;
    L86:
        th = move-exception;
        throw th;
    L11:
        this.f204518p.getClass();
        r103 = new p.a(r111, UUID.randomUUID().toString(), r102.f204575a, r102.f204576b, 0, SystemClock.elapsedRealtime());
        goto L12
    L7:
        return r100;
    L89:
        pk4.j.d("OfflineFileSyncEngine", "Prepare offline files finished, inputCount=" + r210.size() + ", preparedCount=" + r100.size() + ", failed=" + r211.f204548a);
        return r100;
    }

    public final PolarisFileWrapper x(j r100, com.bytedance.dora.offline.file.b.d r101, OfflineFileBusiness r102) {
        com.bytedance.dora.offline.file.d r103 = this.f204516n;     // Catch: Throwable -> L6
        String r104 = r100.f204550a;     // Catch: Throwable -> L6
        r102.f();     // Catch: Throwable -> L6
        r103.getClass();     // Catch: Throwable -> L6
        PolarisFileWrapper r105 = com.bytedance.dora.offline.file.d.d(r104, r101, ".opus");     // Catch: Throwable -> L6
        this.f204519q.a(r105);     // Catch: Throwable -> L6
        return r105;
    L6:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Prepare local file failed, " + h(r101), th);
        q(r101, "prepare_local_path_failed");
        return null;
    }

    public final FileOutcome y(j r110, com.bytedance.dora.offline.file.b.d r111, PolarisFileWrapper r112) {
        com.bytedance.dora.offline.file.c r100 = this.f204517o;
        String r101 = r110.f204550a;
        r100.getClass();
        String r102 = com.bytedance.dora.offline.file.c.a(r101, r111);
        pk4.i r103 = pk4.i.a.f529628a;
        int r104 = 1;
        if (r103.f529627a.getInt(r102, 0) != 1) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L27;
        u(r110, r111, r112, "already_consumed");
        boolean r113 = e(r110, r111, true);
        if (r113 == false) goto L11;
    L14:
        p.b r114 = this.f204528z;
        if (r114 == null) goto L23;
        r114.f204655i++;
        if (r114.f204656j == 2) goto L23;
        if (r113 == true) goto L22;
        r104 = 2;
    L22:
        r114.f204656j = r104;
    L23:
        if (r113 == false) goto L26;
        return FileOutcome.COMPLETED;
    L26:
        return FileOutcome.FAILED;
    L11:
        if (D(r110, true) == StopReason.NONE) goto L14;
        return FileOutcome.INTERRUPTED;
    L27:
        com.bytedance.dora.offline.file.c r106 = this.f204517o;
        String r107 = r110.f204550a;
        r106.getClass();
        if (r103.f529627a.getInt(com.bytedance.dora.offline.file.c.c(r107, "local_retained_", r111.a()), 0) != 1) goto L30;
        boolean r108 = true;
    L32:
        if (r108 == true) goto L60;
        return null;
    L60:
        boolean r109 = J(r111, r112, null);     // Catch: Throwable -> L36
    L38:
        if (r109 == true) goto L41;
        pk4.j.f("OfflineFileSyncEngine", "Retained local file is invalid, redownload, " + h(r111));
        this.f204516n.getClass();
        com.bytedance.dora.offline.file.d.c(r112);
        com.bytedance.dora.offline.file.c r115 = this.f204517o;
        String r116 = r110.f204550a;
        r115.getClass();
        com.bytedance.dora.offline.file.c.b(com.bytedance.dora.offline.file.c.c(r116, "local_retained_", r111.a()), false);
        String r117 = r111.a();
        pk4.i r118 = pk4.i.a.f529628a;
        r118.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r116, "progress_", r117), 0);
        return null;
    L41:
        u(r110, r111, r112, "already_retained");
        boolean r119 = e(r110, r111, false);
        if (r119 == false) goto L44;
    L47:
        p.b r120 = this.f204528z;
        if (r120 == null) goto L56;
        r120.f204655i++;
        if (r120.f204656j == 2) goto L56;
        if (r119 == true) goto L55;
        r104 = 2;
    L55:
        r120.f204656j = r104;
    L56:
        if (r119 == false) goto L59;
        return FileOutcome.COMPLETED;
    L59:
        return FileOutcome.FAILED;
    L44:
        if (D(r110, true) == StopReason.NONE) goto L47;
        return FileOutcome.INTERRUPTED;
    L36:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Validate retained file failed, " + h(r111), th);
        r109 = false;
        goto L38
    L30:
        r108 = false;
        goto L32
    L5:
        r105 = false;
        goto L7
    }

    public final StopReason H(j r110, com.bytedance.dora.offline.file.b.d r111, PolarisFileWrapper r210, long r211) throws Exception {
        int r100 = r111.f204581a;
        String r101 = r111.f204582b;
        monitor-enter(r110);
        r110.f204554e.clear();     // Catch: Throwable -> L50
        r110.f204558i = r100;     // Catch: Throwable -> L50
        r110.f204559j = r101;     // Catch: Throwable -> L50
        long r102 = 1;
        r110.f204562m++;     // Catch: Throwable -> L50
        monitor-exit(r110);
        this.f204519q.a(r210);
        v(r110, r111);
        p.a r103 = this.A;
        if (r103 != null) goto L9;
    L59:
        k r104 = new k(this.f204516n, r210, r211);     // Catch: Throwable -> L47
    L60:
    L39:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L43
    L64:
        throw th;     // Catch: Throwable -> L47
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L13:
        if (r104.f204564b >= r111.f204589i) goto L35;
        StopReason r105 = D(r110, true);     // Catch: Throwable -> L39
        StopReason r106 = StopReason.NONE;     // Catch: Throwable -> L39
        if (r105 != r106) goto L16;
        long r112 = r104.f204564b;     // Catch: Throwable -> L39
        long r113 = r111.f204589i - r112;     // Catch: Throwable -> L39
        if (r113 > 0) goto L23;
        int r107 = 0;
    L24:
        d r114 = new d(r112, Math.min(r111.f204589i, Math.min(((long) r107) * 960, r111.f204589i - r112) + r112), r107);     // Catch: Throwable -> L39
        C(r111, r104.f204564b, r107);     // Catch: Throwable -> L39
        StopReason r108 = f(r110, r111, r104, r114);     // Catch: Throwable -> L32
        com.bytedance.dora.offline.file.c r109 = this.f204517o;     // Catch: Throwable -> L39
        String r115 = r110.f204550a;     // Catch: Throwable -> L39
        long r116 = r104.f204564b;     // Catch: Throwable -> L39
        r109.getClass();     // Catch: Throwable -> L39
        pk4.i r117 = pk4.i.a.f529628a;     // Catch: Throwable -> L39
        r117.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r115, "progress_", r111.a()), r116);     // Catch: Throwable -> L39
        if (r108 != r106) goto L28;
        I(r111, r104, r114);     // Catch: Throwable -> L39
        r102 = 1;
        goto L60
    L28:
        r104.close();     // Catch: Throwable -> L47
        s();
        return r108;
    L32:
        th = move-exception;
        com.bytedance.dora.offline.file.c r118 = this.f204517o;     // Catch: Throwable -> L39
        String r119 = r110.f204550a;     // Catch: Throwable -> L39
        long r120 = r104.f204564b;     // Catch: Throwable -> L39
        r118.getClass();     // Catch: Throwable -> L39
        pk4.i r121 = pk4.i.a.f529628a;     // Catch: Throwable -> L39
        r121.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r119, "progress_", r111.a()), r120);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L23:
        r107 = (int) Math.min(((r113 + 960) - r102) / 960, 64);     // Catch: Throwable -> L39
        goto L24
    L16:
        com.bytedance.dora.offline.file.c r122 = this.f204517o;     // Catch: Throwable -> L39
        String r123 = r110.f204550a;     // Catch: Throwable -> L39
        long r124 = r104.f204564b;     // Catch: Throwable -> L39
        r122.getClass();     // Catch: Throwable -> L39
        pk4.i r125 = pk4.i.a.f529628a;     // Catch: Throwable -> L39
        r125.f529627a.storeLong(com.bytedance.dora.offline.file.c.c(r123, "progress_", r111.a()), r124);     // Catch: Throwable -> L39
        r104.close();     // Catch: Throwable -> L47
        s();
        return r105;
    L35:
        StopReason r126 = StopReason.NONE;     // Catch: Throwable -> L39
        r104.close();     // Catch: Throwable -> L47
        s();
        return r126;
    L47:
        th = move-exception;
        s();
        throw th;
    L9:
        if (r103.f204645l > 0) goto L59;
        r103.f204645l = SystemClock.elapsedRealtime();
    L50:
        th = move-exception;
        throw th;
    }

    public final StopReason f(j r110, com.bytedance.dora.offline.file.b.d r111, k r112, d r113) throws Exception {
    L3:
        if (r112.f204564b >= r113.f204535b) goto L59;
        if (SystemClock.elapsedRealtime() >= r113.f204536c) goto L59;
        StopReason r100 = D(r110, true);
        StopReason r101 = StopReason.NONE;
        if (r100 != r101) goto L8;
        com.bytedance.dora.offline.file.b.a r102 = r110.f204554e.poll(200, TimeUnit.MILLISECONDS);
        if (r102 == null) goto L3;
        if (TextUtils.equals(r111.f204582b, r102.f204571c) == false) goto L57;
        if (r111.f204581a != r102.f204570b) goto L57;
        long r103 = r112.f204564b;
        if (r102.f204569a != 0) goto L56;
        long r104 = r102.f204572d;
        long r105 = r113.f204537d;
        if (r104 >= r105) goto L23;
        boolean r106 = false;
    L31:
        if (r106 == false) goto L3;
        StopReason r107 = D(r110, true);
        if (r107 != r101) goto L35;
        com.bytedance.dora.offline.file.d.a r108 = r112.f204563a;
        long r109 = r112.f204564b;
        byte[] r114 = r102.f204574f;
        if (r109 == 0) goto L39;
    L41:
        r108.f204612b.seek(r109);
        r108.f204612b.write(r114);
        long r115 = r112.f204564b;
        long r116 = r102.f204573e;
        r112.f204564b = r115 + r116;
        p.a r117 = this.A;
        if (r117 != null) goto L44;
    L46:
        r113.f204537d++;
        goto L3
    L44:
        if (r116 <= 0) goto L46;
        r117.f204640g += r116;
        goto L46
    L39:
        if (r108.f204612b.length() <= 0) goto L41;
        long r118 = r108.f204612b.length();
        r108.f204612b.setLength(0);
        pk4.j.d("OfflineFileStore", "Truncate stale offline file before fresh download, fileName=" + r108.f204611a.getName() + ", previousLength=" + r118);
        goto L41
    L35:
        return r107;
    L23:
        if (r104 != r105) goto L54;
        long r119 = r104 * 960;
        if (r119 != r103) goto L52;
        int r120 = r102.f204573e;
        if (r120 == 0) goto L50;
        if ((r103 + ((long) r120)) > r111.f204589i) goto L48;
        r106 = true;
        goto L31
    L48:
        throw new TransferFailure(3003, "File data exceeds expected size");
    L50:
        throw new TransferFailure(3004, "Empty file data payload");
    L52:
        throw new TransferFailure(3005, "Unexpected file data offset, expected=" + r103 + ", actual=" + r119);
    L54:
        throw new TransferFailure(3003, "Out-of-order file data, expected=" + r113.f204537d + ", actual=" + r102.f204572d);
    L56:
        throw new TransferFailure(3001, "Device returned file data error, retCode=" + r102.f204569a);
    L57:
        pk4.j.f("OfflineFileSyncEngine", "Ignore unmatched file data, expectedBusinessType=" + r111.f204581a + ", actualBusinessType=" + r102.f204570b + ", expectedVuiId=" + r111.f204582b + ", actualVuiId=" + r102.f204571c);
        goto L3
    L8:
        return r100;
    L59:
        return StopReason.NONE;
    }

    public final FileOutcome g(j r100, com.bytedance.dora.offline.file.b.d r101, PolarisFileWrapper r102, OfflineFileBusiness r110) {
        if (r100.a() == true) goto L49;
        return FileOutcome.INTERRUPTED;
    L49:
        OfflineFileBusiness.DeliveryResult r103 = r110.b(r100.f204550a, r101, r102);     // Catch: Throwable -> L46
        if (r103 != OfflineFileBusiness.DeliveryResult.CONSUMED) goto L12;
        com.bytedance.dora.offline.file.c r104 = this.f204517o;
        String r105 = r100.f204550a;
        r104.getClass();
        com.bytedance.dora.offline.file.c.b(com.bytedance.dora.offline.file.c.a(r105, r101), true);
    L15:
        if (r100.a() == false) goto L17;
        r110.c(r100.f204550a, r101, r102);     // Catch: Throwable -> L20
    L23:
        if (r100.a() == false) goto L25;
        u(r100, r101, r102, r103.name().toLowerCase(Locale.US));
        if (r103 != OfflineFileBusiness.DeliveryResult.CONSUMED) goto L29;
        boolean r106 = true;
    L30:
        boolean r107 = e(r100, r101, r106);
        if (r107 == false) goto L33;
    L36:
        if (r107 == false) goto L39;
        return FileOutcome.COMPLETED;
    L39:
        return FileOutcome.FAILED;
    L33:
        if (D(r100, true) == StopReason.NONE) goto L36;
        return FileOutcome.INTERRUPTED;
    L29:
        r106 = false;
        goto L30
    L25:
        return FileOutcome.INTERRUPTED;
    L20:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Business delivery commit callback failed, " + h(r101), th);
        goto L23
    L17:
        return FileOutcome.INTERRUPTED;
    L12:
        if (r103 != OfflineFileBusiness.DeliveryResult.RETAINED) goto L41;
        com.bytedance.dora.offline.file.c r108 = this.f204517o;
        String r109 = r100.f204550a;
        r108.getClass();
        com.bytedance.dora.offline.file.c.b(com.bytedance.dora.offline.file.c.c(r109, "local_retained_", r101.a()), true);
        goto L15
    L41:
        if (r103 != OfflineFileBusiness.DeliveryResult.CANCELLED) goto L44;
        r100.f204561l = true;
        q(r101, "user_cancel");
        return FileOutcome.INTERRUPTED;
    L44:
        q(r101, "business_failed");
        r(r101, 8999);
        return FileOutcome.FAILED;
    L46:
        th = move-exception;
        pk4.j.c("OfflineFileSyncEngine", "Business delivery failed with exception, " + h(r101), th);
        q(r101, "business_exception");
        r(r101, 8999);
        return FileOutcome.FAILED;
    }

    public final void u(j r100, com.bytedance.dora.offline.file.b.d r101, PolarisFileWrapper r102, String r103) {
        if (r100.a() == true) goto L5;
        return;
    L5:
        this.f204519q.a(r102);
        g r104 = this.f204519q;
        if (((HashSet) r104.f204542a).add(r101.a()) == false) goto L9;
        r104.f204544c = Math.min(r104.f204543b, r104.f204544c + 1);
    L9:
        pk4.j.d("OfflineFileSyncEngine", "Offline file completed, source=" + r103 + ", completedCount=" + this.f204519q.f204544c + ", totalCount=" + this.f204519q.f204543b + ", " + h(r101));
        v(r100, r101);
    }
}
