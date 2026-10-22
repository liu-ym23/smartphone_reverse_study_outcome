package com.larus.im.internal.stream;

import androidx.camera.video.AudioStats;
import com.flow.kmp.common.util.g;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.p0;
import com.larus.im.internal.tracking.TypeWriterRecorder;
import com.larus.im.internal.utils.w;
import com.larus.im.service.ServerStreamConfig;
import com.larus.im.service.StreamSettings;
import com.larus.im.service.g0;
import com.larus.im.service.h0;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class Typewriter {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f350104t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final vt7.a<String, Typewriter> f350105u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final vt7.a<String, Double> f350106v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final vt7.a<String, Double> f350107w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final vt7.a<String, Double> f350108x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final CoroutineScope f350109y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReentrantReadWriteLock f350110z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Message f350111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f350112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f350113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f350114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f350115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f350116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f350117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f350118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f350119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f350120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f350121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.im.bean.message.c f350122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f350123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f350124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f350125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TypeWriterRecorder.b f350126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ServerStreamConfig f350127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f350128r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f350129s;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/stream/Typewriter$PerfScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TYPEWRITE", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PerfScene extends Enum<PerfScene> {
        public static final PerfScene TYPEWRITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PerfScene[] f350130a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f350131b = null;
        private final String value;

        public PerfScene() {
            super("TYPEWRITE", 0);
            this.value = "TYPEWRITE";
        }

        public static EnumEntries<PerfScene> getEntries() {
            return f350131b;
        }

        static {
            PerfScene r100 = new PerfScene();
            TYPEWRITE = r100;
            PerfScene[] r101 = {r100};
            f350130a = r101;
            f350131b = EnumEntriesKt.enumEntries(r101);
        }

        public static PerfScene[] values() {
            return (PerfScene[]) f350130a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static PerfScene valueOf(String r100) {
            return (PerfScene) r27.a.a(PerfScene.class, r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/stream/Typewriter$TypewriterMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RUNNING", "PAUSE", "STOP", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TypewriterMode extends Enum<TypewriterMode> {
        public static final TypewriterMode PAUSE = null;
        public static final TypewriterMode RUNNING = null;
        public static final TypewriterMode STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TypewriterMode[] f350132a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f350133b = null;
        private final String value;

        public static EnumEntries<TypewriterMode> getEntries() {
            return f350133b;
        }

        static {
            TypewriterMode r100 = new TypewriterMode("RUNNING", 0, "RUNNING");
            RUNNING = r100;
            TypewriterMode r101 = new TypewriterMode("PAUSE", 1, "PAUSE");
            PAUSE = r101;
            TypewriterMode r102 = new TypewriterMode("STOP", 2, "STOP");
            STOP = r102;
            TypewriterMode[] r103 = {r100, r101, r102};
            f350132a = r103;
            f350133b = EnumEntriesKt.enumEntries(r103);
        }

        public static TypewriterMode[] values() {
            return (TypewriterMode[]) f350132a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static TypewriterMode valueOf(String r100) {
            return (TypewriterMode) r27.a.a(TypewriterMode.class, r100);
        }

        public TypewriterMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }

        public static Typewriter a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            ReentrantReadWriteLock.ReadLock r101 = Typewriter.f350110z.readLock();
            r101.lock();
            Typewriter r102 = Typewriter.f350105u.get(r100);     // Catch: Throwable -> L6
            r101.unlock();
            return r102;
        L6:
            th = move-exception;
            r101.unlock();
            throw th;
        }

        public final void update(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            ReentrantReadWriteLock.WriteLock r101 = Typewriter.f350110z.writeLock();
            r101.lock();
            Typewriter r102 = Typewriter.f350105u.get(r100.getMessageId());     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
            r102.f350111a = r100;     // Catch: Throwable -> L9
        L6:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r101.unlock();
            return;
        L9:
            th = move-exception;
            r101.unlock();
            throw th;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f350134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f350135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f350136c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Double.compare(this.f350134a, r101.f350134a) == 0) goto L12;
            return false;
        L12:
            if (Double.compare(this.f350135b, r101.f350135b) == 0) goto L15;
            return false;
        L15:
            if (this.f350136c == r101.f350136c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f350134a);
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = Double.doubleToLongBits(this.f350135b);
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            if (this.f350136c == false) goto L5;
            int r104 = 1231;
        L7:
            return r103 + r104;
        L5:
            r104 = 1237;
            goto L7
        }

        public final String toString() {
            return "DelayResult(delay=" + this.f350134a + ", delayBeforeCorrection=" + this.f350135b + ", isLowWaterDecelerating=" + this.f350136c + ')';
        }

        public b(double r100, double r101, boolean r102) {
            this.f350134a = r100;
            this.f350135b = r101;
            this.f350136c = r102;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r101, "<this>");
            String r102 = ExceptionsKt.stackTraceToString(r101);
            com.larus.im.internal.delegate.a.f348188b.e("Typewriter", "exception=" + r102);
            d1 r103 = d1.f348206b;
            LinkedHashMap r104 = new LinkedHashMap();
            TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r102);
            Unit r105 = Unit.INSTANCE;
            r103.a("type_writer_exception", new d0(r104));
            if (com.larus.im.internal.delegate.c.f348197a.isTestChannel() == true) goto L5;
            return;
        L5:
            throw r101;
        }
    }

    static {
        f350104t = new a();
        f350105u = new vt7.a();
        f350106v = new vt7.a();
        f350107w = new vt7.a();
        f350108x = new vt7.a();
        c r100 = new c(CoroutineExceptionHandler.Key);
        f350109y = CoroutineScopeKt.CoroutineScope(com.flow.kmp.common.thread.c.a("flow-im#typewriter").plus(r100));
        f350110z = new ReentrantReadWriteLock();
    }

    public final void c() {
        if (this.f350115e == false) goto L5;
        return;
    L5:
        if (this.f350117g == false) goto L7;
        return;
    L7:
        if (this.f350116f == true) goto L20;
        Message r100 = this.f350111a;
        ReentrantReadWriteLock.WriteLock r101 = f350110z.writeLock();
        r101.lock();
        vt7.a<String, Typewriter> r102 = f350105u;     // Catch: Throwable -> L13
        String r103 = r100.getMessageId();     // Catch: Throwable -> L13
        Typewriter r104 = (Typewriter) TypeIntrinsics.asMutableMap(r102).remove(r103);     // Catch: Throwable -> L13
        r101.unlock();
        vt7.a<String, Double> r105 = f350106v;
        String r106 = r100.getMessageId();
        TypeIntrinsics.asMutableMap(r105).remove(r106);
        p0.f348255a.a(PerfScene.TYPEWRITE.getValue(), TypewriterMode.STOP.getValue());
        StreamDispatcher.f350097a.A(this.f350111a);
        return;
    L13:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final boolean d() {
        if (this.f350122l != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f350113c >= this.f350114d) goto L7;
        return true;
    }

    public final int e() {
        if (this.f350122l == null) goto L9;
        int r100 = this.f350114d;
        if (r100 >= 0) goto L8;
        return 0;
    L8:
        return Math.max(r100 + 1, 0);
    L9:
        return 0;
    }

    public final int f() {
        if (this.f350119i.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return 0;
    L9:
        return RangesKt.coerceAtMost(Math.max(this.f350112b + 1, 0), this.f350119i.length());
    L5:
        r100 = false;
        goto L6
    }

    public Typewriter(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f350111a = r100;
        this.f350115e = true;
        this.f350119i = "";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x019b -> B:74:0x01a8). Please report as a decompilation issue!!! */
    public static final Object a(Typewriter r410, Continuation r411) {
        Typewriter r100 = r410;
        r410.getClass();
        if ((r411 instanceof Typewriter$loop$1) == false) goto L7;
        Typewriter$loop$1 r101 = (Typewriter$loop$1) r411;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r110 = r101.J$0;
        int r106 = r101.I$0;
        double r111 = r101.D$1;
        double r107 = r101.D$0;
        boolean r112 = r101.Z$0;
        vt7.a<String, Double> r108 = (vt7.a) r101.L$3;
        Object r113 = r104;
        ServerStreamConfig r109 = (ServerStreamConfig) r101.L$2;
        String r114 = (String) r101.L$1;
        String r115 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Typewriter r116 = r100;
        int r117 = 1;
        int r118 = r106;
        ServerStreamConfig r119 = r109;
        String r120 = r114;
        String r121 = "";
        boolean r210 = r112;
        Object r122 = "1";
        double r123 = r111;
        Object r124 = "message_playback_mode";
        long r125 = r110;
        vt7.a<String, Double> r126 = r108;
        double r127 = r107;
    L74:
        long r211 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        Typewriter$loop$1 r412 = r101;
        int r128 = r116.f350120j + r117;
        r116.f350120j = r128;
        double r129 = r123;
        r116.f350121k += r125;
        if (r128 != 10) goto L83;
        if (w.f350562a.nextInt(1000) != 0) goto L79;
        boolean r130 = true;
    L80:
        if (r130 == false) goto L83;
        d1 r131 = d1.f348206b;
        LinkedHashMap r132 = new LinkedHashMap();
        TuplesKt.to("duration", Long.valueOf(r116.f350121k / ((long) r116.f350120j)));
        Unit r133 = Unit.INSTANCE;
        r131.a("flow_message_type_writer", new d0(r132));
        r116.f350120j = 0;
        r116.f350121k = 0;
        goto L83
    L79:
        r130 = false;
    L83:
        Map<String, String> r134 = r116.f350111a.getBusinessExt();
        if (r134 == null) goto L86;
        String r135 = r134.get(r124);
    L87:
        boolean r136 = Intrinsics.areEqual(r135, r122);
        if (Intrinsics.areEqual(r116.f350129s, Boxing.boxBoolean(true)) == false) goto L92;
        if (r210 == false) goto L92;
        if (r136 == true) goto L92;
        int r137 = 1;
    L93:
        if (r137 != 0) goto L95;
    L97:
        boolean r138 = false;
    L98:
        if (r138 == false) goto L100;
        double r139 = Math.max(r129, StreamSettings.c(r127, r119));
    L101:
        int r212 = r118;
        f350106v.put(r115, Boxing.boxDouble(r139));
        r126.put(r120, Boxing.boxDouble(r139));
        if (r116.f350116f == true) goto L114;
        Message r140 = r116.f350111a;
        Intrinsics.checkNotNullParameter(r140, "<this>");
        Map<String, String> r141 = r140.getBusinessExt();
        if (r141 == null) goto L107;
        String r142 = r141.get("flush_enable");
    L109:
        if (Intrinsics.areEqual(r142, r122) == true) goto L114;
        if (r136 == true) goto L113;
    L115:
        if (r137 != 0) goto L117;
    L119:
        int r143 = r116.f350113c;
        int r144 = r116.f350112b;
        if (r137 != 0) goto L122;
    L124:
        boolean r145 = false;
    L126:
        if (r116.d() == false) goto L153;
        com.larus.im.bean.message.c r146 = r116.f350122l;
        if (r146 == null) goto L130;
        String r147 = r146.f347104a;
    L131:
        if (r147 != null) goto L133;
        r147 = r121;
    L133:
        if (r137 != 0) goto L146;
        int r148 = r116.f350113c + 1;
        vt7.a<String, Double> r213 = r126;
        int r214 = 0;
    L136:
        if (r148 >= r116.f350114d) goto L145;
        int r149 = r214 + g.a(String.valueOf(r147.charAt(r148))).length;
        if (r136 == false) goto L140;
        int r215 = StreamSettings.f350621c;
    L141:
        String r216 = r115;
        if (r149 >= r215) goto L152;
        r148 = r148 + 1;
        r214 = r149;
        r115 = r216;
    L152:
        r116.f350113c = r148;
    L174:
        if (r143 == r116.f350113c) goto L176;
    L177:
        if (r137 == 0) goto L186;
        TypeWriterRecorder r150 = TypeWriterRecorder.f350227a;
        Message r151 = r116.f350111a;
        int r152 = r116.f();
        if (r116.f350122l != null) goto L181;
    L184:
        int r153 = 0;
    L185:
        int r154 = r152 + r153;
        TypeWriterRecorder.b r155 = r116.f350126p;
        r150.getClass();
        TypeWriterRecorder.d(r151, r119, r154, r155);
    L194:
        StreamDispatcher.f350097a.B(r116.f350111a);
        if (r210 == false) goto L375;
        if (r137 == 0) goto L298;
        Message r156 = r116.f350111a;
        double r157 = StreamSettings.e(r119);
        if (r116.d() == false) goto L206;
        com.larus.im.bean.message.c r158 = r116.f350122l;
        if (r158 == null) goto L202;
        String r159 = r158.f347104a;
    L203:
        if (r159 != null) goto L212;
    L210:
        r159 = r121;
    L212:
        if (r116.d() == false) goto L214;
        int r160 = r116.f350113c;
    L215:
        int r161 = r160 + 1;
        if (r159.length() >= r161) goto L219;
        Integer r162 = null;
    L232:
        if (r162 != null) goto L235;
        b r163 = new b(r157, r157, false);
        r122 = r122;
    L293:
        double r164 = r163.f350134a;
        boolean r165 = r163.f350136c;
        r116.f350124n = r165;
        if (r165 == false) goto L296;
        TypeWriterRecorder.b r166 = new TypeWriterRecorder.b(r163.f350135b, r164);
    L297:
        r116.f350126p = r166;
    L374:
        r129 = r164;
    L376:
        r101 = r412;
        r100 = r116;
        Object r167 = r113;
        String r168 = r121;
        boolean r169 = r210;
        long r170 = r211;
        r118 = r212;
        r126 = r213;
        String r171 = r216;
        r127 = r127;
        r120 = r120;
        Object r172 = r124;
        Object r173 = r122;
    L70:
        Object r413 = r172;
        Object r217 = r173;
        long r174 = (long) ((com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r170) + r129);
        Typewriter r175 = r100;
        r121 = r168;
        Object r218 = r167;
        com.larus.im.internal.delegate.a.f348188b.d("Typewriter", "msgId:" + r171 + ",delay:" + r129 + ",realDelay:" + r174);
        r101.L$0 = r171;
        r101.L$1 = r120;
        r101.L$2 = r119;
        r101.L$3 = r126;
        r101.Z$0 = r169;
        r101.D$0 = r127;
        r101.D$1 = r129;
        r101.I$0 = r118;
        r101.J$0 = r174;
        r117 = 1;
        r101.label = 1;
        if (DelayKt.delay(r174, r101) == r218) goto L395;
        r115 = r171;
        r210 = r169;
        r116 = r175;
        r113 = r218;
        r123 = r129;
        r125 = r174;
        r122 = r217;
        r124 = r413;
        goto L74
    L395:
        return r218;
    L296:
        r166 = null;
        goto L297
    L235:
        if (r156.getMessageStatusLocal() != 21) goto L237;
        boolean r176 = true;
    L238:
        h0.a r177 = StreamSettings.b();
        if (r177 == null) goto L241;
        int r178 = r177.f350858d;
    L247:
        double r179 = r178;
        h0.a r180 = StreamSettings.b();
        if (r180 == null) goto L250;
        int r181 = r180.f350857c;
    L256:
        double r182 = r181;
        if (r176 == false) goto L259;
        double r183 = r157;
    L260:
        h0.a r184 = StreamSettings.b();
        if (r184 == null) goto L263;
        double r185 = r184.f350861g;
    L270:
        if (r162.intValue() <= 0) goto L273;
        r116.f350123m = true;
    L273:
        if (r162.intValue() < 0) goto L275;
    L277:
        double r186 = r129 / ((((r185 * ((double) r162.intValue())) * r129) * r129) + ((double) 1));
    L279:
        if (r186 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L281;
        double r187 = r179;
    L282:
        if (r136 == false) goto L284;
    L288:
        boolean r188 = false;
    L289:
        if (r188 == false) goto L291;
        double r189 = RangesKt.coerceAtMost(Math.max(r187, StreamSettings.c(r157, r119)), r183);
    L292:
        r163 = new b(r189, r187, r188);
        goto L293
    L291:
        r189 = r187;
        goto L292
    L284:
        if (r116.f350123m == false) goto L288;
        if (r162.intValue() >= 0) goto L288;
        r188 = true;
        goto L289
    L281:
        r187 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r186, r182), r183);
        goto L282
    L275:
        if (r116.f350123m == true) goto L277;
        r186 = r129;
        goto L279
    L263:
        boolean r190 = g0.f350840a;
        if (r119 == null) goto L268;
        Double r191 = r119.getSmoothK();
        if (r191 == null) goto L268;
        r185 = r191.doubleValue();
    L268:
        r185 = g0.f350846g;
        goto L270
    L259:
        r183 = r179;
        goto L260
    L250:
        boolean r192 = g0.f350840a;
        if (r119 == null) goto L255;
        Integer r193 = r119.getMinInterval();
        if (r193 == null) goto L255;
        r181 = r193.intValue();
    L255:
        r181 = g0.f350842c;
        goto L256
    L241:
        boolean r194 = g0.f350840a;
        if (r119 == null) goto L246;
        Integer r195 = r119.getMaxInterval();
        if (r195 == null) goto L246;
        r178 = r195.intValue();
    L246:
        r178 = g0.f350843d;
        goto L247
    L237:
        r176 = false;
        goto L238
    L219:
        if (r116.d() == true) goto L222;
        com.larus.im.bean.message.a.n0(r156);
    L222:
        int r196 = g.a(r159.substring(r161)).length / RangesKt.coerceAtLeast(StreamSettings.a(), 1);
        h0.a r197 = StreamSettings.b();
        if (r197 == null) goto L225;
        int r198 = r197.f350860f;
    L231:
        r162 = Integer.valueOf(r196 - r198);
        goto L232
    L225:
        boolean r199 = g0.f350840a;
        if (r119 == null) goto L230;
        Integer r200 = r119.getBalanceDistance();
        if (r200 == null) goto L230;
        r198 = r200.intValue();
    L230:
        r198 = g0.f350845f;
        goto L231
    L214:
        r160 = r116.f350112b;
        goto L215
    L202:
        r159 = null;
        goto L203
    L206:
        if (com.larus.im.bean.message.a.b0(r156) == false) goto L208;
        r159 = com.larus.im.bean.message.a.e(r156);
        goto L212
    L208:
        r159 = com.larus.im.bean.message.a.O(r156);
        if (r159 != null) goto L212;
    L298:
        r120 = r120;
        r127 = r127;
        r124 = r124;
        r122 = r122;
        r116.f350124n = false;
        r116.f350126p = null;
        Message r201 = r116.f350111a;
        r164 = StreamSettings.e(r119);
        if (r116.d() == false) goto L307;
        com.larus.im.bean.message.c r202 = r116.f350122l;
        if (r202 == null) goto L303;
        String r203 = r202.f347104a;
    L304:
        if (r203 != null) goto L313;
    L311:
        r203 = r121;
    L313:
        if (r116.d() == false) goto L315;
        int r204 = r116.f350113c;
    L316:
        int r205 = r204 + 1;
        if (r203.length() < r205) goto L374;
        if (r201.getMessageStatusLocal() != 21) goto L322;
        boolean r1100 = true;
    L323:
        h0.a r206 = StreamSettings.b();
        if (r206 == null) goto L326;
        int r207 = r206.f350858d;
    L332:
        r164 = r207;
        h0.a r208 = StreamSettings.b();
        if (r208 == null) goto L335;
        int r209 = r208.f350857c;
    L341:
        double r219 = r209;
        h0.a r220 = StreamSettings.b();
        if (r220 == null) goto L344;
        double r221 = r220.f350861g;
    L350:
        int r222 = g.a(r203.substring(r205)).length;
        com.larus.im.bean.message.a.n0(r201);
        int r223 = r222 / StreamSettings.a();
        h0.a r224 = StreamSettings.b();
        if (r224 == null) goto L353;
        int r225 = r224.f350860f;
    L359:
        int r226 = r223 - r225;
        if (r226 <= 0) goto L362;
        r116.f350123m = true;
    L362:
        if (r226 < 0) goto L364;
    L366:
        double r227 = r129 / ((((r221 * ((double) r226)) * r129) * r129) + ((double) 1));
    L368:
        if (r227 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L374;
        double r228 = RangesKt.coerceAtLeast(r227, r219);
        if (r1100 == false) goto L373;
        r164 = StreamSettings.e(r119);
    L373:
        r164 = RangesKt.coerceAtMost(r228, r164);
        goto L374
    L364:
        if (r116.f350123m == true) goto L366;
        r227 = r129;
        goto L368
    L353:
        boolean r229 = g0.f350840a;
        if (r119 == null) goto L358;
        Integer r230 = r119.getBalanceDistance();
        if (r230 == null) goto L358;
        r225 = r230.intValue();
    L358:
        r225 = g0.f350845f;
        goto L359
    L344:
        boolean r231 = g0.f350840a;
        if (r119 == null) goto L349;
        Double r232 = r119.getSmoothK();
        if (r232 == null) goto L349;
        r221 = r232.doubleValue();
    L349:
        r221 = g0.f350846g;
        goto L350
    L335:
        boolean r233 = g0.f350840a;
        if (r119 == null) goto L340;
        Integer r234 = r119.getMinInterval();
        if (r234 == null) goto L340;
        r209 = r234.intValue();
    L340:
        r209 = g0.f350842c;
        goto L341
    L326:
        boolean r235 = g0.f350840a;
        if (r119 == null) goto L331;
        Integer r236 = r119.getMaxInterval();
        if (r236 == null) goto L331;
        r207 = r236.intValue();
    L331:
        r207 = g0.f350843d;
        goto L332
    L322:
        r1100 = false;
        goto L323
    L315:
        r204 = r116.f350112b;
        goto L316
    L303:
        r203 = null;
        goto L304
    L307:
        if (com.larus.im.bean.message.a.b0(r201) == false) goto L309;
        r203 = com.larus.im.bean.message.a.e(r201);
        goto L313
    L309:
        r203 = com.larus.im.bean.message.a.O(r201);
        if (r203 != null) goto L313;
    L375:
        r120 = r120;
        r127 = r127;
        r124 = r124;
        r122 = r122;
        r116.f350126p = null;
        goto L376
    L181:
        if (r116.f350114d < 0) goto L184;
        r153 = RangesKt.coerceAtMost(Math.max(r116.f350113c + 1, 0), r116.e());
        goto L185
    L186:
        TypeWriterRecorder r237 = TypeWriterRecorder.f350227a;
        Message r238 = r116.f350111a;
        int r239 = r116.f();
        if (r116.f350122l != null) goto L189;
    L192:
        int r1101 = 0;
    L193:
        r237.getClass();
        Intrinsics.checkNotNullParameter(r238, "message");
        TypeWriterRecorder.d(r238, r119, r239 + r1101, null);
        goto L194
    L189:
        if (r116.f350114d < 0) goto L192;
        r1101 = RangesKt.coerceAtMost(Math.max(r116.f350113c + 1, 0), r116.e());
        goto L193
    L176:
        if (r144 == r116.f350112b) goto L194;
    L140:
        r215 = StreamSettings.a();
        goto L141
    L145:
        r216 = r115;
        goto L152
    L146:
        r213 = r126;
        r216 = r115;
        int r240 = StreamSettings.a();
        if (r136 == false) goto L149;
        r240 = StreamSettings.f350621c;
    L151:
        int r241 = d.f350139a;
        r148 = d.i(r147, r116.f350113c, r240);
        goto L152
    L149:
        if (r145 == false) goto L151;
        r240 = StreamSettings.d(r240, r116.f350127q);
        goto L151
    L130:
        r147 = null;
        goto L131
    L153:
        r213 = r126;
        r216 = r115;
        int r242 = r116.f350112b;
        if (r242 >= r116.f350118h) goto L377;
        if (r137 != 0) goto L166;
        int r243 = r242 + 1;
        int r1102 = 0;
    L158:
        if (r243 >= r116.f350118h) goto L172;
        r1102 = r1102 + g.a(String.valueOf(r116.f350119i.charAt(r243))).length;
        if (r136 == false) goto L162;
        int r244 = StreamSettings.f350620b;
    L163:
        if (r1102 >= r244) goto L172;
        r243 = r243 + 1;
        goto L158
    L162:
        int r245 = StreamSettings.f350619a;
        com.larus.im.bean.message.a.n0(r116.f350111a);
        r244 = StreamSettings.a();
    L172:
        r116.f350112b = r243;
        goto L174
    L166:
        int r246 = StreamSettings.f350619a;
        com.larus.im.bean.message.a.n0(r116.f350111a);
        int r247 = StreamSettings.a();
        if (r136 == false) goto L169;
        r247 = StreamSettings.f350620b;
    L171:
        int r248 = d.f350139a;
        r243 = d.i(r116.f350119i, r116.f350112b, r247);
        goto L172
    L169:
        if (r145 == false) goto L171;
        r247 = StreamSettings.d(r247, r116.f350127q);
        goto L171
    L377:
        TypeWriterRecorder.b r249 = null;
        int r250 = r137;
    L378:
        if (r250 != 0) goto L380;
        r116.f350126p = r249;
        boolean r251 = false;
        r116.f350124n = false;
    L381:
        r116.f350117g = r251;
        Map<String, String> r252 = r116.f350111a.getBusinessExt();
        if (r252 == null) goto L384;
        String r253 = r252.get(r124);
    L386:
        if (Intrinsics.areEqual(r253, r122) == false) goto L388;
        r116.f350115e = r251;
        r116.c();
    L388:
        r116.c();
        return Unit.INSTANCE;
    L384:
        r253 = r249;
        goto L386
    L380:
        r251 = false;
        goto L381
    L122:
        if (r116.f350124n == false) goto L124;
        r145 = true;
        goto L126
    L117:
        if (r116.f350125o == true) goto L119;
        TypeWriterRecorder.f350227a.getClass();
        r116.f350125o = TypeWriterRecorder.h(r115);
        goto L119
    L113:
        if (r116.f350115e == true) goto L115;
    L107:
        r142 = null;
    L114:
        r250 = r212;
        r249 = null;
        goto L378
    L100:
        r139 = r129;
        goto L101
    L95:
        if (r116.f350124n == false) goto L97;
        r138 = true;
    L92:
        r137 = 0;
        goto L93
    L86:
        r135 = null;
        goto L87
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r100.f350117g == true) goto L390;
        if (r100.f350115e == false) goto L390;
        r100.f350117g = true;
        r171 = r100.f350111a.getMessageId();
        if (r171 != null) goto L22;
        r171 = "";
    L22:
        String r254 = r100.f350111a.getConversationId();
        String r255 = r100.f350111a.getThreadId();
        if (r254 != null) goto L25;
    L28:
        boolean r1103 = true;
    L29:
        if (r1103 == false) goto L35;
        if (r255 != null) goto L33;
        r254 = "";
        goto L35
    L33:
        r254 = r255;
    L35:
        if (r100.f350128r == false) goto L37;
        ServerStreamConfig r256 = r100.f350127q;
    L43:
        boolean r257 = StreamSettings.f(r256);
        double r258 = StreamSettings.e(r256);
        Map<String, String> r1104 = r100.f350111a.getBusinessExt();
        if (r1104 == null) goto L46;
        String r1105 = r1104.get("message_playback_mode");
    L47:
        boolean r1106 = Intrinsics.areEqual(r1105, "1");
        if (Intrinsics.areEqual(r100.f350129s, Boxing.boxBoolean(true)) == false) goto L52;
        if (r257 == false) goto L52;
        if (r1106 == true) goto L52;
        boolean r1107 = true;
    L53:
        if (r1107 == false) goto L55;
        r126 = f350107w;
    L56:
        if (r257 == true) goto L58;
    L68:
        double r1108 = r258;
    L69:
        ServerStreamConfig r310 = r256;
        r120 = r254;
        r167 = r104;
        r170 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        r169 = r257;
        r129 = r1108;
        r119 = r310;
        r168 = "";
        r173 = "1";
        r172 = "message_playback_mode";
        r127 = r258;
        r118 = 0;
        goto L70
    L58:
        if (StreamSettings.f350622d == false) goto L62;
        Double r1109 = f350106v.get(r171);
        if (r1109 == null) goto L68;
        r1108 = r1109.doubleValue();
        goto L69
    L62:
        Double r1110 = f350106v.get(r171);
        if (r1110 != null) goto L67;
        r1110 = r126.get(r254);
        if (r1110 == null) goto L68;
    L67:
        r1108 = r1110.doubleValue();
        goto L69
    L55:
        r126 = f350108x;
    L52:
        r1107 = false;
        goto L53
    L46:
        r1105 = null;
        goto L47
    L37:
        r256 = r100.f350127q;
        if (r256 != null) goto L43;
        r256 = com.larus.im.bean.message.a.I(r100.f350111a);
        if (r256 == null) goto L42;
        r100.f350127q = r256;
        goto L43
    L42:
        r256 = null;
        goto L43
    L25:
        if (StringsKt.isBlank(r254) == true) goto L28;
        r1103 = false;
    L390:
        return Unit.INSTANCE;
    L7:
        r101 = new Typewriter$loop$1(r100, r411);
        goto L8
    }

    public static final int b(Typewriter r100, String r101, int r102, int r103) {
        r100.getClass();
        if (r102 != 0) goto L13;
        if (r103 > 0) goto L6;
        return r102;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        return r102;
    L12:
        return RangesKt.coerceAtMost(d.i(r101, -1, 1), r103);
    L8:
        r104 = false;
        goto L9
    L13:
        return r102;
    }
}
