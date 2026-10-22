package com.obric.aiagent.ipc.utils;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class IPCAnomalyTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IPCAnomalyTrace f384709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f384710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<Boolean> f384711c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyTrace$Direction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CALL", "INVOKE", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Direction extends Enum<Direction> {
        public static final Direction CALL = null;
        public static final Direction INVOKE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f384712a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f384713b = null;
        private final String value;

        public static EnumEntries<Direction> getEntries() {
            return f384713b;
        }

        static {
            Direction r100 = new Direction("CALL", 0, NotificationCompat.CATEGORY_CALL);
            CALL = r100;
            Direction r101 = new Direction("INVOKE", 1, AbsMethodDelegate.TAG_INVOKE);
            INVOKE = r101;
            Direction[] r102 = {r100, r101};
            f384712a = r102;
            f384713b = EnumEntriesKt.enumEntries(r102);
        }

        public static Direction[] values() {
            return (Direction[]) f384712a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public Direction(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f384714c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f384715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f384716b;

        /* JADX INFO: renamed from: com.obric.aiagent.ipc.utils.IPCAnomalyTrace$a$a, reason: collision with other inner class name */
        public static final class C4586a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f384715a == r101.f384715a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f384716b, r101.f384716b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f384715a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f384716b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "RuntimeConfig(enabled=" + this.f384715a + ", detector=" + this.f384716b + ')';
        }

        public a(boolean r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "detector");
            this.f384715a = r100;
            this.f384716b = r101;
        }
    }

    public IPCAnomalyTrace() {
    }

    static {
        f384709a = new IPCAnomalyTrace();
        int r100 = a.f384714c;
        com.obric.aiagent.ipc.utils.a r101 = new com.obric.aiagent.ipc.utils.a(14);
        Intrinsics.checkNotNullParameter(r101, "config");
        Long r102 = Long.valueOf(r101.f384720b);
        boolean r103 = true;
        if (r102.longValue() < 0) goto L5;
        boolean r104 = true;
    L6:
        Integer r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        long r106 = r102.longValue();
    L13:
        Integer r107 = Integer.valueOf(r101.f384721c);
        if (r107.intValue() <= 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == true) goto L20;
        r107 = null;
    L20:
        if (r107 == null) goto L22;
        int r109 = r107.intValue();
    L23:
        Integer r110 = Integer.valueOf(r101.f384722d);
        if (r110.intValue() > 0) goto L27;
        r103 = false;
    L27:
        if (r103 == false) goto L29;
        r105 = r110;
    L29:
        if (r105 == null) goto L31;
        int r111 = r105.intValue();
    L32:
        f384710b = new a(r101.f384719a, new c(RangesKt.coerceAtMost(r106, 9223372036854775L) * 1000, r109, r111));
        f384711c = new ThreadLocal();
        return;
    L31:
        r111 = 60;
        goto L32
    L22:
        r109 = 3000;
        goto L23
    L16:
        r108 = false;
        goto L17
    L12:
        r106 = 200;
        goto L13
    L5:
        r104 = false;
        goto L6
    }

    public final void c(String r110, String r111, long r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, com.alipay.sdk.m.p.e.f25671s);
        a(Direction.CALL, r110, r111, r112, r113, null);
    }

    public final void e(String r110, String r111, long r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, com.alipay.sdk.m.p.e.f25671s);
        a(Direction.INVOKE, r110, r111, r112, r113, null);
    }

    public static void b(String r100, String r110, IPCException r111, long r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r110, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "e");
        a(Direction.CALL, r100, r110, r112, r113, r111);
    }

    public static void d(String r100, String r110, IPCException r111, long r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r110, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "e");
        a(Direction.INVOKE, r100, r110, r112, r113, r111);
    }

    public static void a(Direction r110, String r111, String r112, long r113, long r114, IPCException r210) {
        a r100 = f384710b;
        if (r100.f384715a == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(f384711c.get(), Boolean.TRUE) == true) goto L41;
        c r101 = r100.f384716b;     // Catch: Throwable -> L13
        String r102 = r110.getValue();     // Catch: Throwable -> L13
        if (r210 == null) goto L10;
        boolean r115 = true;
    L11:
        b r103 = r101.a(r102, r111, r112, r113, r115, r114 / 1000000);     // Catch: Throwable -> L13
    L16:
        if (r103 != null) goto L18;
        return;
    L18:
        f384711c.set(Boolean.TRUE);
        Iterator<T> r104 = r103.f384723a.iterator();     // Catch: Throwable -> L24
    L21:
        if (r104.hasNext() == false) goto L26;
        f(r110, r111, r112, r113, r210, (IPCAnomalyType) r104.next(), r103.f384724b);     // Catch: Throwable -> L24
    L26:
        f384711c.remove();
        return;
    L24:
        th = move-exception;
        ILogDepend.f384986a.w("IPC-BASE", "IPC anomaly trace failed", th);     // Catch: Throwable -> L28
        goto L26
    L10:
        r115 = false;
    L13:
        th = move-exception;
        ILogDepend.f384986a.w("IPC-BASE", "IPC anomaly trace failed", th);     // Catch: Throwable -> L29
    L15:
        r103 = null;
        goto L16
    }

    public static void f(Direction r100, String r101, String r102, long r103, IPCException r104, IPCAnomalyType r110, int r111) {
        boolean r105 = false;
        Bundle r106 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("ipc_direction", r100.getValue()), TuplesKt.to("ipc_tag", r101), TuplesKt.to("ipc_method", r102), TuplesKt.to("ipc_anomaly_type", r110.getEventValue()), TuplesKt.to("ipc_cost", Long.valueOf(r103 / 1000))});
        if (r110 != IPCAnomalyType.FREQUENT) goto L6;
        r106.putInt("ipc_window_count", r111);
    L6:
        if (r110 != IPCAnomalyType.FAILURE) goto L24;
        if (r104 == null) goto L24;
        String r107 = r104.getMessage();
        if (r107 == null) goto L15;
        Sequence r108 = StringsKt.lineSequence(r107);
        if (r108 == null) goto L15;
        String r109 = (String) SequencesKt.firstOrNull(r108);
        if (r109 == null) goto L15;
        String r112 = StringsKt.trim(r109).toString();
    L16:
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        if (r112.length() != 0) goto L21;
        r105 = true;
    L21:
        if (r105 == false) goto L23;
        r112 = "com.obric.aiagent.ipc.utils.IPCException";
    L23:
        r106.putString("ipc_exception", StringsKt.take(r112, 512));
    L15:
        r112 = null;
    L24:
        ITraceDepend.f385002a.a(r106);
    }
}
