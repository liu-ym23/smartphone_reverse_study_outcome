package com.larus.account.saas.security.internal;

import com.larus.account.saas.runtime.internal.util.GsonHolder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class AccountSecurityObservationStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f286492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f286493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, e48.e> f286494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f286495d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e48.e f286496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f286497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f286498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f286499d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f286496a, r101.f286496a) == true) goto L12;
            return false;
        L12:
            if (this.f286497b == r101.f286497b) goto L15;
            return false;
        L15:
            if (this.f286498c == r101.f286498c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f286499d, r101.f286499d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            e48.e r100 = this.f286496a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            long r103 = this.f286497b;
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f286498c;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            Long r107 = this.f286499d;
            if (r107 == null) goto L11;
            r101 = r107.hashCode();
        L11:
            return r106 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "BrowsedChatMessageCountResult(state=" + this.f286496a + ", threshold=" + this.f286497b + ", totalCount=" + this.f286498c + ", reportCount=" + this.f286499d + ')';
        }

        public a(e48.e r100, long r101, long r102, Long r103) {
            this.f286496a = r100;
            this.f286497b = r101;
            this.f286498c = r102;
            this.f286499d = r103;
        }
    }

    public AccountSecurityObservationStore() {
        this.f286492a = LazyKt.lazy(AccountSecurityObservationStore$sp$2.INSTANCE);
        this.f286493b = new CopyOnWriteArraySet();
        this.f286494c = new ConcurrentHashMap();
        this.f286495d = new ConcurrentHashMap();
    }

    public final e48.e a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Object r101 = null;
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        e48.e r102 = this.f286494c.get(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        if (this.f286493b.contains(r100) == false) goto L11;
        return null;
    L11:
        String r103 = ((d48.f.b) this.f286492a.getValue()).getString("account_security_observation_" + r100);
        if (StringsKt.isBlank(r103) == false) goto L28;
    L23:
        if (r101 == null) goto L25;
        this.f286494c.put(r100, (e48.e) r101);
    L27:
        return this.f286494c.get(r100);
    L25:
        this.f286493b.add(r100);
        goto L27
    L28:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        Lazy r105 = GsonHolder.f286473a;     // Catch: Throwable -> L16
        Object r106 = Result.m9449constructorimpl((e48.e) GsonHolder.a(r103, e48.e.class));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r106) == true) goto L22;
        r101 = r106;
    L22:
        r101 = (e48.e) r101;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final boolean b(e48.d r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r102 = r100.f471001a.getValue() + '_' + r100.f471002b;
        long r103 = System.currentTimeMillis();
        Long r104 = this.f286495d.get(r102);
        if (r104 != null) goto L6;
        r104 = 0L;
    L6:
        if (r104.longValue() <= r103) goto L9;
        return true;
    L9:
        this.f286495d.put(r102, Long.valueOf(r103 + r101));
        return false;
    }
}
