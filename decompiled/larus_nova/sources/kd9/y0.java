package kd9;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.im.internal.network.link.impl.rtc.abs.FlowRTCLinkSession;
import com.larus.im.internal.rtcsdk.service.AudioEncodeType;
import com.larus.im.service.audio.autotest.DataType;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y0 implements com.larus.im.service.audio.n, com.larus.im.service.audio.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ff9.o f502950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.im.internal.audio.session.v2.p0 f502951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ue9.j f502952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f502953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f502954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.im.service.audio.t f502955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f502956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f502957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f502958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final he9.c f502959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PthreadThreadV2 f502960k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f502961l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedBlockingQueue<c> f502962m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f502963n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.im.service.audio.g f502964o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f502965p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f502966q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final z0 f502967r;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f502968a;

        public final void a() {
            fe9.c.f476624a.e(this.f502968a.f502956g, "HookDataReaderRunnable started");
        L4:
            if (Thread.interrupted() == true) goto L22;
            if (this.f502968a.f502961l == true) goto L22;
            if (this.f502968a.f502958i == false) goto L22;
            byte[] r100 = com.larus.im.internal.utils.x.f350563a.a(80, DataType.MIC);     // Catch: Exception -> L19 InterruptedException -> L21
        L11:
            if (r100.length != 0) goto L13;
            boolean r101 = true;
        L15:
            if ((!r101) == false) goto L17;
            LinkedBlockingQueue<c> r102 = this.f502968a.f502962m;     // Catch: Exception -> L19 InterruptedException -> L21
            ue9.g.f549873a.getClass();     // Catch: Exception -> L19 InterruptedException -> L21
            com.larus.im.service.audio.l r103 = new com.larus.im.service.audio.l(r100, null, ue9.g.b.f549878c, false);     // Catch: Exception -> L19 InterruptedException -> L21
            y0 r104 = this.f502968a;     // Catch: Exception -> L19 InterruptedException -> L21
            int r105 = r104.f502965p + 1;     // Catch: Exception -> L19 InterruptedException -> L21
            r104.f502965p = r105;     // Catch: Exception -> L19 InterruptedException -> L21
            r102.offer(new c(r103, ((long) r105) * 20000));     // Catch: Exception -> L19 InterruptedException -> L21
        L17:
            Thread.sleep(20);     // Catch: Exception -> L19 InterruptedException -> L21
            goto L4
        L13:
            r101 = false;
        L21:
            ThreadMethodProxy.currentThread().interrupt();
        L19:
            e = move-exception;
            fe9.c.f476624a.b(this.f502968a.f502956g, "Error in HookDataReaderRunnable: " + e.getMessage());
            Thread.sleep(20);
        L22:
            fe9.c.f476624a.e(this.f502968a.f502956g, "HookDataReaderRunnable stopped");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(y0 r100) {
            this.f502968a = r100;
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ue9.f f502969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0 f502970b;

        public final void a() {
            fe9.c.f476624a.e(this.f502970b.f502956g, "prepare to start sending cache data");
        L4:
            if (Thread.interrupted() == true) goto L33;
            if (this.f502970b.f502961l == true) goto L33;
            ue9.f r100 = this.f502969a;     // Catch: InterruptedException -> L31
            byte[] r101 = null;
            if (r100 == null) goto L13;
            if (this.f502970b.f502952c.f(r100) == (-1)) goto L11;
            this.f502969a = null;     // Catch: InterruptedException -> L31
            goto L13
        L11:
            Thread.sleep(20);     // Catch: InterruptedException -> L31
        L13:
            c r102 = this.f502970b.f502962m.take();     // Catch: InterruptedException -> L31
            com.larus.im.service.audio.l r103 = this.f502970b.f502955f.a(r102.f502971a);     // Catch: InterruptedException -> L31
            byte[] r104 = r103.f350772a;     // Catch: InterruptedException -> L31
            ue9.g r105 = r103.getType();     // Catch: InterruptedException -> L31
            he9.c r106 = this.f502970b.f502959j;     // Catch: InterruptedException -> L31
            if (r106 == null) goto L16;
            r101 = r106.b(r103.f350773b);     // Catch: InterruptedException -> L31
        L16:
            ue9.f r110 = new ue9.f(r104, r105, r101, Long.valueOf(r102.f502972b), false, null, 48);     // Catch: InterruptedException -> L31
            int r107 = this.f502970b.f502952c.f(r110);     // Catch: InterruptedException -> L31
            if (r107 == (-1)) goto L18;
            if (r107 != 0) goto L20;
            com.larus.im.service.audio.g r108 = this.f502970b.f502964o;     // Catch: InterruptedException -> L31
            if (r108 == null) goto L24;
            r108.a(r103.f350772a);     // Catch: InterruptedException -> L31
        L24:
            y0 r109 = this.f502970b;     // Catch: InterruptedException -> L31
            if ((r109.f502965p % 100) != 0) goto L4;
            fe9.a r111 = fe9.a.f476620a;     // Catch: InterruptedException -> L31
            String r112 = r109.f502956g;     // Catch: InterruptedException -> L31
            StringBuilder r113 = new StringBuilder();     // Catch: InterruptedException -> L31
            r113.append("send stream success, timestamp: ");     // Catch: InterruptedException -> L31
            r113.append(r110.f549870d);     // Catch: InterruptedException -> L31
            r113.append(", content: ");     // Catch: InterruptedException -> L31
            byte[] r114 = r103.f350772a;     // Catch: InterruptedException -> L31
            String r115 = "";
            int r116 = r114.length;     // Catch: InterruptedException -> L31
            int r117 = 0;
        L27:
            if (r117 >= r116) goto L29;
            r115 = r115 + String.format("%02X ", Arrays.copyOf(new Object[]{Byte.valueOf(r114[r117])}, 1)) + ' ';     // Catch: InterruptedException -> L31
            r117 = r117 + 1;     // Catch: InterruptedException -> L31
            goto L27
        L29:
            r113.append(r115);     // Catch: InterruptedException -> L31
            r111.e(r112, r113.toString());     // Catch: InterruptedException -> L31
            goto L4
        L20:
            fe9.a.f476620a.b(this.f502970b.f502956g, "send stream failed, result: " + r107);     // Catch: InterruptedException -> L31
            goto L4
        L18:
            this.f502969a = r110;     // Catch: InterruptedException -> L31
            Thread.sleep(20);     // Catch: InterruptedException -> L31
        L31:
            ThreadMethodProxy.currentThread().interrupt();
        L33:
            if (this.f502970b.f502961l == false) goto L35;
            fe9.a.f476620a.e(this.f502970b.f502956g, "sending cache data thread stopped by release");
            return;
        L35:
            fe9.a.f476620a.e(this.f502970b.f502956g, "sending cache data thread stopped unexpectedly");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(y0 r100) {
            this.f502970b = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.im.service.audio.l f502971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f502972b;

        public c(com.larus.im.service.audio.l r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            this.f502971a = r100;
            this.f502972b = r101;
        }
    }

    @Override // com.larus.im.service.audio.n
    public final void release() {
        fe9.c.f476624a.e(this.f502956g, "release");
        this.f502951b.b(this.f502967r);
        this.f502961l = true;
        this.f502960k.interrupt();
    }

    @Override // com.larus.im.service.audio.n
    public final void setup() {
        fe9.c.f476624a.e(this.f502956g, LynxTemplateRender.RENDER_PHASE_SETUP);
        this.f502951b.a();
        int r100 = com.larus.im.a.f346406a;
        gd9.o r101 = com.larus.im.internal.d.f347913a;
        com.larus.im.internal.audio.u.f347501c.getClass();
        com.larus.im.internal.utils.x r102 = com.larus.im.internal.utils.x.f350563a;
        this.f502951b.c(this.f502967r);
        this.f502950a.n(this.f502953d, this.f502954e, AudioEncodeType.OPUS);
    }

    @Override // com.larus.im.service.audio.n
    public final void startCapture() {
        fe9.c.f476624a.e(this.f502956g, "startCapture");
        this.f502958i = true;
        if (this.f502963n.compareAndSet(false, true) == false) goto L6;
        ThreadMethodProxy.start(this.f502960k);
        return;
    }

    @Override // com.larus.im.service.audio.n
    public final void stopCapture() {
        fe9.c.f476624a.e(this.f502956g, "stopCapture");
        this.f502958i = false;
    }

    @Override // com.larus.im.service.audio.f
    public final void a(com.larus.audio.call.record.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f502964o = r100;
    }

    @Override // com.larus.im.service.audio.n
    public final void setBluetoothForceToMedia(boolean r100) {
        fe9.c.f476624a.e(this.f502956g, "setBluetoothForceToMedia, enable: " + r100);
        this.f502950a.setBluetoothForceToMedia(r100);
    }

    public y0(FlowRTCLinkSession r100, com.larus.im.internal.audio.session.v2.z0 r101, ue9.i r102, ge9.d.b r103, int r104, int r105, com.larus.im.internal.audio.session.v2.i0 r106) {
        Intrinsics.checkNotNullParameter(r100, "linkSessionMedia");
        Intrinsics.checkNotNullParameter(r101, "speechDataSource");
        Intrinsics.checkNotNullParameter(r102, "streamSender");
        Intrinsics.checkNotNullParameter(r106, "preProcessor");
        this.f502950a = r100;
        this.f502951b = r101;
        this.f502952c = r102;
        this.f502953d = r104;
        this.f502954e = r105;
        this.f502955f = r106;
        this.f502956g = "LLMSpeechCaptureControl_" + hashCode();
        this.f502958i = true;
        if (r103 == null) goto L5;
        ge9.d.c r107 = r103.f481027a;
    L6:
        this.f502959j = r107;
        PthreadThreadV2 r108 = new PthreadThreadV2(new b(this), "cacheDataProcessor");
        ThreadMethodProxy.setPriority(r108, 10);
        this.f502960k = r108;
        this.f502962m = new LinkedBlockingQueue();
        this.f502963n = new AtomicBoolean(false);
        this.f502966q = LazyKt.lazy(new x0(this));
        this.f502967r = new z0(this);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
