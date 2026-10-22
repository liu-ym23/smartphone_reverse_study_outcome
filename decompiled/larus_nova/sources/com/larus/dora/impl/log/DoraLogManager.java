package com.larus.dora.impl.log;

import android.content.Context;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.spp.DoraSppLink;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.s0;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import t39.u;
import t39.w;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraLogManager extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraLogManager f336045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f336046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean[] f336047c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f336048d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f336049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static u f336050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static w f336051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f336052h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Context f336053i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static byte[] f336054j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static PolarisFileWrapper f336055k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f336056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f336057m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static u f336058n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ScheduledExecutorService f336059o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static ScheduledFuture<?> f336060p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicBoolean f336061q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ScheduledExecutorService f336062r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static ScheduledFuture<?> f336063s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f336064t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f336065u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f336066v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f336067w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f336068x;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/log/DoraLogManager$DoraHeadPhoneLogType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "KEY", "POINT", "ASSERT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DoraHeadPhoneLogType extends Enum<DoraHeadPhoneLogType> {
        public static final DoraHeadPhoneLogType ASSERT = null;
        public static final DoraHeadPhoneLogType KEY = null;
        public static final DoraHeadPhoneLogType POINT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DoraHeadPhoneLogType[] f336069a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f336070b = null;
        private final String typeName;

        public static EnumEntries<DoraHeadPhoneLogType> getEntries() {
            return f336070b;
        }

        static {
            DoraHeadPhoneLogType r100 = new DoraHeadPhoneLogType("KEY", 0, "doralite-key");
            KEY = r100;
            DoraHeadPhoneLogType r101 = new DoraHeadPhoneLogType("POINT", 1, "doralite-point");
            POINT = r101;
            DoraHeadPhoneLogType r102 = new DoraHeadPhoneLogType("ASSERT", 2, "doralite-assert");
            ASSERT = r102;
            DoraHeadPhoneLogType[] r103 = {r100, r101, r102};
            f336069a = r103;
            f336070b = EnumEntriesKt.enumEntries(r103);
        }

        public static DoraHeadPhoneLogType[] values() {
            return (DoraHeadPhoneLogType[]) f336069a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public static DoraHeadPhoneLogType valueOf(String r100) {
            return (DoraHeadPhoneLogType) r27.a.a(DoraHeadPhoneLogType.class, r100);
        }

        public DoraHeadPhoneLogType(String r100, int r101, String r102) {
            super(r100, r101);
            this.typeName = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f336071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f336072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f336073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f336074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte f336075e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f336076f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f336071a == r101.f336071a) goto L12;
            return false;
        L12:
            if (this.f336072b == r101.f336072b) goto L15;
            return false;
        L15:
            if (this.f336073c == r101.f336073c) goto L18;
            return false;
        L18:
            if (this.f336074d == r101.f336074d) goto L21;
            return false;
        L21:
            if (this.f336075e == r101.f336075e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f336076f, r101.f336076f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f336071a * 31) + this.f336072b) * 31) + this.f336073c) * 31;
            long r101 = this.f336074d;
            return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f336075e) * 31) + Arrays.hashCode(this.f336076f);
        }

        public final String toString() {
            return "LogInfo(magicId=" + this.f336071a + ", recordId=" + this.f336072b + ", tick=" + this.f336073c + ", utc=" + this.f336074d + ", len=" + this.f336075e + ", pBuf=" + Arrays.toString(this.f336076f) + ')';
        }

        public a(byte r100, int r101, int r102, long r103, byte r104, byte[] r105) {
            Intrinsics.checkNotNullParameter(r105, "pBuf");
            this.f336071a = r100;
            this.f336072b = r101;
            this.f336073c = r102;
            this.f336074d = r103;
            this.f336075e = r104;
            this.f336076f = r105;
        }
    }

    static {
        f336045a = new DoraLogManager();
        f336047c = new AtomicBoolean[]{new AtomicBoolean(false), new AtomicBoolean(false)};
        f336048d = new AtomicBoolean(false);
        f336049e = "";
        f336052h = LazyKt.lazy(new com.larus.dora.impl.log.a());
        f336053i = AppHost.f326268a.getApplication().getApplicationContext();
        f336054j = new byte[0];
        f336059o = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("oraLogManager"));
        f336061q = new AtomicBoolean(false);
        f336062r = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("oraLogManager"));
    }

    public static boolean l() {
        int r100 = f336066v;
        if (r100 != 1) goto L5;
    L16:
        return false;
    L5:
        if (r100 == 2) goto L16;
        if (f336057m == true) goto L14;
        if (f336056l == true) goto L14;
        if (f336061q.get() == false) goto L16;
    L14:
        if (f336064t == false) goto L16;
        return true;
    }

    public final String p() {
        return f336053i.getFilesDir() + "/DoraSDK/DLog/";
    }

    public final boolean r() {
        return f336048d.get();
    }

    public static String n() {
        DoraDevice r100 = DoraAdapterExtKt.h(kj4.a.g());
        if (r100 == null) goto L8;
        String r101 = r100.f204389mac;
        if (r101 == null) goto L8;
        String r102 = StringsKt.replace$default(r101, ":", "", false, 4, null);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public static void x() {
        if (DoraAdapterExtKt.h(kj4.a.g()) != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraLogManager$openEarbudsOnlineBuryPointSwitch$1(null), 3, null);
    }

    public DoraLogManager() {
    }

    public static String q(int r100) {
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return DoraHeadPhoneLogType.KEY.getTypeName();
    L14:
        return DoraHeadPhoneLogType.KEY.getTypeName();
    L15:
        return DoraHeadPhoneLogType.POINT.getTypeName();
    L12:
        return DoraHeadPhoneLogType.ASSERT.getTypeName();
    }

    public static void w(d49.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (Intrinsics.areEqual(r100, d49.c.a.f466863a) == false) goto L5;
    L21:
        boolean r101 = false;
    L22:
        f336057m = r101;
        return;
    L5:
        if (Intrinsics.areEqual(r100, d49.c.d.f466868a) == true) goto L21;
        if ((r100 instanceof d49.c.C5633c) == true) goto L21;
        if ((r100 instanceof d49.c.f) == false) goto L13;
        r101 = true;
        goto L22
    L13:
        if ((r100 instanceof d49.c.b) == true) goto L21;
        if ((r100 instanceof d49.c.e) == true) goto L21;
        if ((r100 instanceof d49.c.g) == true) goto L21;
        throw new NoWhenBranchMatchedException();
    }

    public static a y(byte[] r100) {
        DoraDevice r101 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: BufferUnderflowException -> L13
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (o59.a.x(r101) != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;     // Catch: BufferUnderflowException -> L13
    L11:
        ByteBuffer r104 = ByteBuffer.wrap(r100).order(r103);     // Catch: BufferUnderflowException -> L13
        byte r105 = r104.get();     // Catch: BufferUnderflowException -> L13
        int r106 = r104.getInt();     // Catch: BufferUnderflowException -> L13
        int r107 = r104.getInt();     // Catch: BufferUnderflowException -> L13
        long r108 = r104.getLong();     // Catch: BufferUnderflowException -> L13
        byte r109 = r104.get();     // Catch: BufferUnderflowException -> L13
        byte[] r110 = new byte[r109 & UByte.MAX_VALUE];     // Catch: BufferUnderflowException -> L13
        r104.get(r110);     // Catch: BufferUnderflowException -> L13
        return new a(r105, r106, r107, r108, r109, r110);
    L10:
        r103 = ByteOrder.LITTLE_ENDIAN;     // Catch: BufferUnderflowException -> L13
    L7:
        r102 = false;
    L13:
        return null;
    }

    public static void z(Function0 r100) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraLogManager$runOnIO$1(r100, null), 3, null);
    }

    public final void B(boolean r100) {
        f336048d.set(r100);
    }

    public final void v(int r110) {
        AtomicBoolean[] r100 = f336047c;
        boolean r101 = true;
        r100[r110].set(true);
        boolean r102 = false;
        p.d(0, 0);
        kj4.a.g().m(r110);
        StringBuilder r103 = new StringBuilder("type ");
        r103.append(f336066v);
        r103.append(" log has saved to ");
        r103.append(f336049e);
        r103.append(", size ");
        PolarisFileWrapper r104 = f336055k;
        if (r104 == null) goto L5;
        Long r105 = Long.valueOf(r104.length());
    L6:
        r103.append(r105);
        g49.d.d("DoraLogManager", r103.toString());
        if (f336066v != 3) goto L9;
        ((Keva) f336052h.getValue()).storeLong(n().concat("_GetLogTime"), System.currentTimeMillis());
    L9:
        int r106 = 1 - r110;
        DoraDevice r107 = DoraAdapterExtKt.h(kj4.a.g());
        if (r107 == null) goto L16;
        int[] r108 = r107.state;
        if (r108 == null) goto L16;
        if (r108[r110] != 2) goto L16;
        boolean r109 = true;
    L17:
        boolean r111 = !r100[r106].get();
        if (r111 == true) goto L20;
    L25:
        boolean r112 = false;
    L26:
        DoraDevice r113 = DoraAdapterExtKt.h(kj4.a.g());
        if (r113 != null) goto L29;
    L31:
        boolean r114 = false;
    L32:
        if (r114 == false) goto L36;
        if (r111 == false) goto L36;
        if (r109 == false) goto L36;
        boolean r115 = true;
    L37:
        if (r112 == true) goto L41;
        if (r115 == true) goto L41;
        boolean r116 = false;
    L42:
        g49.d.d("DoraLogManager", "anotherConnected " + r109);
        g49.d.d("DoraLogManager", "needSwitchToAnother " + r116);
        String r117 = "earbudsSide " + r110 + ", type " + f336066v + " done!";
        if (r116 == false) goto L68;
        s(true, r117, f336049e, true, f336066v);
        DoraDevice r118 = DoraAdapterExtKt.h(kj4.a.g());
        if (r118 != null) goto L47;
    L49:
        boolean r119 = false;
    L50:
        if (r119 == false) goto L55;
        g49.d.d("DoraLogManager", "get third-party log info, earbudsSide " + r106);
        kj4.a r120 = kj4.a.g();
        boolean r121 = f336064t ^ true;
        mj4.f r122 = r120.f503708c;
        if (r121 == false) goto L54;
        r122.f514229d.g(4, 7, new byte[]{1, 2, 1, (byte) r106});
    L66:
        if (r101 == true) goto L70;
        B(false);
        return;
    L70:
        return;
    L54:
        r122.f514229d.g(4, 7, new byte[]{1, 2, 0, (byte) r106});
        goto L66
    L55:
        if (r110 != 1) goto L57;
        int r123 = 3;
    L58:
        p.f336150i = true;
        if (p.f336145d != 0) goto L61;
        String r124 = "R_to_L";
    L62:
        p.f336144c = r124;
        byte[] r125 = {5, 1, (byte) r123};
        DoraSppLink r126 = kj4.a.g().f503708c.f514229d.f4000a;
        r126.getClass();
        int r127 = r126.E(1, 6, pk4.n.c(1, 6, r125), 10, r125);
        if (r127 == 0) goto L65;
        String r128 = "switchBudsRole to " + r123 + " error " + r127;
        g49.d.b("DoraLogManager", r128);
        p.e(1);
        t(this, false, r128, null, 0, 28);
        r101 = false;
        goto L66
    L65:
        g49.d.d("DoraLogManager", "switchBudsRole to " + r123 + " success");
        BuildersKt.runBlocking$default(null, new DoraLogManager$getAnotherEarbudLog$1(null), 1, null);
        g49.d.d("DoraLogManager", "getLogInfo 2");
        z(new f(r102));
        goto L66
    L61:
        r124 = "L_to_R";
        goto L62
    L57:
        r123 = 2;
        goto L58
    L47:
        if (o59.a.x(r118) != true) goto L49;
        r119 = true;
        goto L50
    L68:
        B(false);
        t(this, true, r117, f336049e, f336066v, 8);
        g49.d.d("DoraLogManager", "!!!all ears log done!!! type " + f336066v);
        return;
    L41:
        r116 = true;
    L36:
        r115 = false;
        goto L37
    L29:
        if (o59.a.x(r113) != true) goto L31;
        r114 = true;
        goto L32
    L20:
        if (f336066v != 3) goto L25;
        if (f336064t == true) goto L25;
        if (r109 == false) goto L25;
        r112 = true;
    L16:
        r109 = false;
        goto L17
    L5:
        r105 = null;
        goto L6
    }

    public final void u(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        g49.d.d("DoraLogManager", "notifyUploadLogResult success " + r100 + " msg " + r101);
        w r102 = f336051g;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public static void k(int r110, long r111, boolean r112) {
        g49.d.d("DoraLogManager", "autoGetLog " + r110 + " after " + (r111 / ((long) 1000)) + 's');
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraLogManager$autoGetLog$1(r111, r110, r112, null), 2, null);
    }

    public static String m(a r100, int r101, int r102) {
        String r103 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(r100.f336074d));
        byte[] r104 = r100.f336076f;
        if (r101 != 3) goto L6;
        r104 = ArraysKt.sliceArray(r104, RangesKt.until(0, r104.length - 1));
    L6:
        if (r101 == 2) goto L8;
        String r105 = new String(r104, Charsets.UTF_8);
    L12:
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L16;
        String r106 = "Unknown";
    L19:
        if (r102 != 0) goto L21;
        String r107 = "R";
    L23:
        return r103 + " [" + r106 + "] [" + r107 + "] recordId: " + r100.f336072b + ", tick: " + r100.f336073c + ", info: " + r105;
    L21:
        r107 = "L";
        goto L23
    L16:
        r106 = "Key";
        goto L19
    L17:
        r106 = "Point";
        goto L19
    L18:
        r106 = "Assert";
        goto L19
    L8:
        if (r104.length == 2) goto L10;
        r105 = new String(r104, Charsets.UTF_8);
        goto L12
    L10:
        r105 = o.a(((r104[1] & UByte.MAX_VALUE) << 8) | (r104[0] & UByte.MAX_VALUE));
        goto L12
    }

    public final void A(int r100, int r101, long r102) {
        ((Keva) f336052h.getValue()).storeLong(n() + '_' + r100 + '_' + r101, r102);
    }

    @Override // com.larus.dora.impl.util.s0, mj4.i
    public final void i(int r110, byte r111, int[] r112) {
        g49.d.d("DoraLogManager", "onGetLogInfo");
        g49.d.d("DoraLogManager", "nid: " + r110);
        StringBuilder r113 = new StringBuilder("earbuds_side: ");
        r113.append(r111);
        r113.append(" lens0: ");
        Integer r100 = null;
        if (r112 == null) goto L5;
        Integer r101 = Integer.valueOf(r112[0]);
    L6:
        r113.append(r101);
        r113.append(" lens1: ");
        if (r112 == null) goto L9;
        Integer r102 = Integer.valueOf(r112[1]);
    L10:
        r113.append(r102);
        r113.append(" lens2: ");
        if (r112 == null) goto L13;
        r100 = Integer.valueOf(r112[2]);
    L13:
        r113.append(r100);
        g49.d.d("DoraLogManager", r113.toString());
        p.c(0);
        f336065u = 0;
        ScheduledFuture<?> r114 = f336060p;
        if (r114 == null) goto L17;
        r114.cancel(true);
    L17:
        if (f336047c[r111].get() == true) goto L19;
    L22:
        p.e(0);
        boolean r115 = f336064t;
        if (r112 == null) goto L25;
        int r103 = ArraysKt.sum(r112);
    L26:
        long r104 = f336046b;
        p.f336142a = System.currentTimeMillis();
        if (r115 == false) goto L29;
        String r116 = "auto";
    L30:
        p.f336143b = r116;
        p.f336145d = r111;
        p.f336146e = r103;
        p.f336149h = r104;
        int r117 = f336066v;
        int r105 = r117 - 1;
        if (r105 < 0) goto L40;
        if (r112 == null) goto L34;
        int r106 = r112.length;
    L35:
        if (r105 >= r106) goto L40;
        if (r112 == null) goto L38;
        int r118 = r112[r105];
    L39:
        f336068x = r118;
        goto L40
    L38:
        r118 = 0;
        goto L39
    L34:
        r106 = 0;
    L40:
        f336046b = ((Keva) f336052h.getValue()).getLong(n() + '_' + r111 + '_' + r117, 0);
        int r119 = f336066v;
        String r120 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        if (r111 != 1) goto L43;
        String r107 = "L";
    L45:
        if (r119 != 3) goto L47;
        String r108 = ".dlog";
    L48:
        StringBuilder r109 = new StringBuilder();
        r109.append(p());
        r109.append("DoraLog_");
        r109.append(r120);
        r109.append('_');
        r109.append(n());
        r109.append('_');
        DoraDevice r121 = DoraAdapterExtKt.h(kj4.a.g());
        if (r121 == null) goto L52;
        String r122 = r121.softVersion;
        if (r122 == null) goto L52;
    L53:
        r109.append(r122);
        r109.append('_');
        r109.append(r107);
        r109.append('_');
        if (r119 == 1) goto L60;
        if (r119 == 2) goto L59;
        if (r119 == 3) goto L58;
        String r123 = "Unknown";
    L61:
        r109.append(r123);
        r109.append(r108);
        f336049e = r109.toString();
        PolarisFileWrapper r124 = new PolarisFileWrapper(f336049e);
        f336055k = r124;
        if (r124.exists() == false) goto L64;
    L66:
        o(r111, f336066v, f336046b, 512);
        if (f336066v == 1) goto L69;
        return;
    L69:
        if (f336068x <= 0) goto L73;
        DoraBuryPointManager r125 = DoraBuryPointManager.f331862a;
        r125.getClass();
        DoraBuryPointManager.J(r125, "device_assert_found", MapsKt.emptyMap(), false, 12);
        return;
    L73:
        return;
    L64:
        if (r124.createNewFile() == true) goto L66;
        g49.d.b("DoraLogManager", "create file " + f336049e + " failed");
        goto L66
    L58:
        r123 = "Key";
        goto L61
    L59:
        r123 = "Point";
        goto L61
    L60:
        r123 = "Assert";
    L52:
        r122 = "";
        goto L53
    L47:
        r108 = Global.SUFFIX_TXT_FILE;
        goto L48
    L43:
        r107 = "R";
        goto L45
    L29:
        r116 = "manual";
        goto L30
    L25:
        r103 = 0;
        goto L26
    L19:
        if (f336064t == true) goto L22;
        g49.d.d("DoraLogManager", "earbuds_side " + r111 + " log has collected, skip");
        B(false);
        p.e(2);
        t(this, false, "", null, 0, 28);
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public static void o(final int r100, final int r101, final long r102, final int r110) {
        z(new d(r100, r101, r102, r110));
    }

    @Override // com.larus.dora.impl.util.s0, mj4.i
    public final void c(final byte r100, final byte r101, final long r110, final byte[] r111) {
        z(new e(r100, r101, r110, r111));
    }

    public static void s(boolean r100, String r101, String r110, boolean r111, int r112) {
        g49.d.d("DoraLogManager", "notifyGetLogResult success: " + r100 + ", msg: " + r101);
        if (f336064t == false) goto L7;
        u r102 = f336058n;
        if (r102 == null) goto L11;
        r102.a(r100, r101, r110, r111, r112);
        return;
    L11:
        return;
    L7:
        u r103 = f336050f;
        if (r103 == null) goto L13;
        r103.a(r100, r101, r110, r111, r112);
        return;
    }

    public static /* synthetic */ void t(DoraLogManager r100, boolean r101, String r102, String r103, int r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = "";
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = 3;
    L8:
        r100.getClass();
        s(r101, r102, r103, false, r104);
    }

    public static void C(final int r110, final u r111, boolean r112, boolean r113, final boolean r114, boolean r115, boolean r116, int r117) {
        DoraLogManager r100 = f336045a;
        if ((r117 & 4) == 0) goto L5;
        final boolean r101 = false;
    L7:
        if ((r117 & 8) == 0) goto L9;
        final boolean r102 = false;
    L11:
        if ((r117 & 32) == 0) goto L13;
        final boolean r103 = false;
    L15:
        if ((r117 & 64) == 0) goto L17;
        final boolean r118 = false;
    L18:
        g49.d.d("DoraLogManager", "startGetEarbudsLog: type " + r110 + ", isAuto " + r101 + ", isDownloading " + r100.r() + ", pendingUpload：" + r114 + " fromFeedback " + r103 + " curLogType " + f336066v);
        z(new c(r101, r103, r110, r111, r114, r102, r118));
        return;
    L17:
        r118 = r116;
        goto L18
    L13:
        r103 = r115;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
