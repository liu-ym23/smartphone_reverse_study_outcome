package com.ss.android.lark.im.sdk.message.send;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f425992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, a> f425993b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f425994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f425995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f425996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TreeMap<Long, Function0<Unit>> f425997d;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f425994a == r101.f425994a) goto L12;
            return false;
        L12:
            if (this.f425995b == r101.f425995b) goto L15;
            return false;
        L15:
            if (this.f425996c == r101.f425996c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f425997d, r101.f425997d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f425994a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f425995b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            if (this.f425996c == false) goto L5;
            int r104 = 1231;
        L7:
            return ((r103 + r104) * 31) + this.f425997d.hashCode();
        L5:
            r104 = 1237;
            goto L7
        }

        public final String toString() {
            return "QueueState(nextAssignSeq=" + this.f425994a + ", nextRunSeq=" + this.f425995b + ", draining=" + this.f425996c + ", pending=" + this.f425997d + ')';
        }

        public a(Object r100) {
            TreeMap<Long, Function0<Unit>> r101 = new TreeMap();
            Intrinsics.checkNotNullParameter(r101, AiBotPollingAuthResult.STATUS_PENDING);
            this.f425994a = 0;
            this.f425995b = 0;
            this.f425996c = false;
            this.f425997d = r101;
        }
    }

    static {
        f425992a = new Object();
        f425993b = new LinkedHashMap();
    }

    public static void b(long r100) {
    L2:
        Object r101 = f425992a;
        monitor-enter(r101);
        a r102 = (a) ((LinkedHashMap) f425993b).get(Long.valueOf(r100));     // Catch: Throwable -> L16
        if (r102 == null) goto L6;
        Function0<Unit> r103 = r102.f425997d.remove(Long.valueOf(r102.f425995b));     // Catch: Throwable -> L16
        if (r103 == null) goto L10;
        r102.f425995b++;     // Catch: Throwable -> L16
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);
        r103.invoke();
        goto L2
    L10:
        r102.f425996c = false;     // Catch: Throwable -> L16
        a(r100, r102);     // Catch: Throwable -> L16
        monitor-exit(r101);
        return;
    L6:
        monitor-exit(r101);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void a(long r100, a r101) {
        if (r101.f425996c == false) goto L5;
        return;
    L5:
        if (r101.f425997d.isEmpty() == true) goto L7;
        return;
    L7:
        if (r101.f425995b != r101.f425994a) goto L12;
        f425993b.remove(Long.valueOf(r100));
        return;
    }
}
