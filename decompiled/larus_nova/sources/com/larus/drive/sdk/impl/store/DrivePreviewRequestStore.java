package com.larus.drive.sdk.impl.store;

import android.os.SystemClock;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.larus.drive.sdk.impl.preview.b;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class DrivePreviewRequestStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrivePreviewRequestStore f341970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<String, a> f341971b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/impl/store/DrivePreviewRequestStore$EntryState;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "ACTIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EntryState extends Enum<EntryState> {
        public static final EntryState ACTIVE = null;
        public static final EntryState PENDING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntryState[] f341972a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f341973b = null;

        public static EnumEntries<EntryState> getEntries() {
            return f341973b;
        }

        static {
            EntryState r100 = new EntryState("PENDING", 0);
            PENDING = r100;
            EntryState r101 = new EntryState("ACTIVE", 1);
            ACTIVE = r101;
            EntryState[] r102 = {r100, r101};
            f341972a = r102;
            f341973b = EnumEntriesKt.enumEntries(r102);
        }

        public static EntryState[] values() {
            return (EntryState[]) f341972a.clone();
        }

        public static EntryState valueOf(String r100) {
            return (EntryState) r27.a.a(EntryState.class, r100);
        }

        public EntryState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DrivePreviewOpenRequest f341974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EntryState f341975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f341976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.larus.drive.sdk.impl.store.a f341977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function0<Unit> f341978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function0<Boolean> f341979f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f341974a, r101.f341974a) == true) goto L12;
            return false;
        L12:
            if (this.f341975b == r101.f341975b) goto L15;
            return false;
        L15:
            if (this.f341976c == r101.f341976c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f341977d, r101.f341977d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f341978e, r101.f341978e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f341979f, r101.f341979f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f341974a.hashCode() * 31) + this.f341975b.hashCode()) * 31;
            long r101 = this.f341976c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            com.larus.drive.sdk.impl.store.a r103 = this.f341977d;
            int r104 = 0;
            if (r103 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = (r102 + r105) * 31;
            Function0<Unit> r107 = this.f341978e;
            if (r107 != null) goto L9;
            int r108 = 0;
        L10:
            int r109 = (r106 + r108) * 31;
            Function0<Boolean> r110 = this.f341979f;
            if (r110 == null) goto L15;
            r104 = r110.hashCode();
        L15:
            return r109 + r104;
        L9:
            r108 = r107.hashCode();
            goto L10
        L5:
            r105 = r103.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(request=" + this.f341974a + ", state=" + this.f341975b + ", createdAtMs=" + this.f341976c + ", aiSession=" + this.f341977d + ", launchFailureFallback=" + this.f341978e + ", isLaunchActive=" + this.f341979f + ')';
        }

        public a(DrivePreviewOpenRequest r100, EntryState r101, long r102, com.larus.drive.sdk.impl.store.a r103, com.larus.drive.sdk.impl.preview.a r104, b r105) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "state");
            this.f341974a = r100;
            this.f341975b = r101;
            this.f341976c = r102;
            this.f341977d = r103;
            this.f341978e = r104;
            this.f341979f = r105;
        }
    }

    public DrivePreviewRequestStore() {
    }

    static {
        f341970a = new DrivePreviewRequestStore();
        f341971b = new LinkedHashMap(20, 0.75f, true);
    }

    public static int b() {
        Collection<a> r100 = f341971b.values();
        if (r100.isEmpty() == true) goto L25;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L17;
        if (((a) r101.next()).f341975b != EntryState.ACTIVE) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L7;
        r102 = r102 + 1;
        if (r102 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        r103 = false;
        goto L12
    L17:
        return r102;
    L25:
        return 0;
    }

    public static int e() {
        Collection<a> r100 = f341971b.values();
        if (r100.isEmpty() == true) goto L25;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L17;
        if (((a) r101.next()).f341975b != EntryState.PENDING) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L7;
        r102 = r102 + 1;
        if (r102 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        r103 = false;
        goto L12
    L17:
        return r102;
    L25:
        return 0;
    }

    public static List i() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L4:
        if (e() <= 20) goto L25;
        Iterator<T> r102 = f341971b.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if (((a) ((Map.Entry) r103).getValue()).f341975b != EntryState.PENDING) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L7;
    L15:
        Map.Entry r105 = (Map.Entry) r103;
        if (r105 == null) goto L25;
        String r106 = (String) r105.getKey();
        if (r106 == null) goto L25;
        a r107 = f341971b.remove(r106);
        if (r107 == null) goto L24;
        Function0<Unit> r108 = r107.f341978e;
        if (r108 == null) goto L24;
        r100.add(r108);
    L24:
        r101 = r101 + 1;
        goto L4
    L11:
        r104 = false;
        goto L12
    L14:
        r103 = null;
    L25:
        if (r101 <= 0) goto L27;
        FLogger.f375446a.w("DrivePreviewRequestStore", "evict pending requests by capacity, removedCount=" + r101);
    L27:
        return r100;
    }

    public static void h(long r100) {
        Iterator<Map.Entry<String, a>> r101 = f341971b.entrySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        a r103 = r101.next().getValue();
        if (r103.f341975b != EntryState.PENDING) goto L4;
        if (r103.f341978e != null) goto L4;
        if ((r100 - r103.f341976c) < 300000) goto L4;
        r101.remove();
        r102 = r102 + 1;
        goto L4
    L12:
        if (r102 <= 0) goto L24;
        FLogger.f375446a.i("DrivePreviewRequestStore", "remove expired pending requests, removedCount=" + r102);
        return;
    }

    public final synchronized boolean c(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "requestId");     // Catch: Throwable -> L18
        h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L18
        LinkedHashMap<String, a> r101 = f341971b;     // Catch: Throwable -> L18
        a r102 = r101.get(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L10;
        monitor-exit(this);
        return false;
    L10:
        if (r102.f341978e != null) goto L14;
        monitor-exit(this);
        return false;
    L14:
        r102.f341978e = null;     // Catch: Throwable -> L18
        r102.f341979f = null;     // Catch: Throwable -> L18
        r101.remove(r100);     // Catch: Throwable -> L18
        FLogger.f375446a.i("DrivePreviewRequestStore", "cancel launch, pendingCount=" + e() + ", activeCount=" + b());     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        monitor-enter(this);
        h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L25
        LinkedHashMap<String, a> r101 = f341971b;     // Catch: Throwable -> L25
        a r102 = r101.get(r100);     // Catch: Throwable -> L25
        Function0<Unit> r103 = null;
        if (r102 == null) goto L12;
        Function0<Unit> r104 = r102.f341978e;     // Catch: Throwable -> L25
        if (r104 == null) goto L12;
        r102.f341978e = null;     // Catch: Throwable -> L25
        r102.f341979f = null;     // Catch: Throwable -> L25
        r101.remove(r100);     // Catch: Throwable -> L25
        r103 = r104;
    L12:
        monitor-exit(this);
        if (r103 != null) goto L30;
        return false;
    L30:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        Object r106 = Result.m9449constructorimpl(r103.invoke());     // Catch: Throwable -> L18
    L20:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L32;
        FLogger.f375446a.e("DrivePreviewRequestStore", "launch fallback failed, errorType=".concat(r107.getClass().getSimpleName()));
        return true;
    L32:
        return true;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "requestId");     // Catch: Throwable -> L11
        h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        if (f341971b.remove(r100) == null) goto L7;
        boolean r101 = true;
    L8:
        FLogger.f375446a.i("DrivePreviewRequestStore", "release request, removed=" + r101 + ", pendingCount=" + e() + ", activeCount=" + b());     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r101 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static a a(String r100, boolean r110) {
        h(SystemClock.elapsedRealtime());
        LinkedHashMap<String, a> r101 = f341971b;
        a r102 = r101.get(r100);
        if (r102 != null) goto L6;
        FLogger.f375446a.w("DrivePreviewRequestStore", "acquire request missed, pendingCount=" + e() + ", activeCount=" + b());
        return null;
    L6:
        com.larus.drive.sdk.impl.store.a r103 = r102.f341977d;
        boolean r104 = false;
        if (r103 == null) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == r110) goto L13;
        FLogger.f375446a.w("DrivePreviewRequestStore", "acquire request type mismatched");
        return null;
    L13:
        if (r103 == null) goto L22;
        Function0<Boolean> r111 = r102.f341979f;
        if (r111 != null) goto L17;
    L19:
        if (r104 == false) goto L22;
        r101.remove(r100);
        FLogger.f375446a.i("DrivePreviewRequestStore", "cancel inactive launch on acquire, pendingCount=" + e() + ", activeCount=" + b());
        return null;
    L17:
        if (r111.invoke().booleanValue() == true) goto L19;
        r104 = true;
    L22:
        EntryState r106 = EntryState.ACTIVE;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r102.f341975b = r106;
        int r107 = b();
        FLogger r112 = FLogger.f375446a;
        r112.i("DrivePreviewRequestStore", "acquire request succeeded, pendingCount=" + e() + ", activeCount=" + r107);
        if (r107 <= 20) goto L25;
        r112.w("DrivePreviewRequestStore", "active request count exceeds warning threshold, activeCount=" + r107);
    L25:
        return r102;
    L9:
        r105 = false;
        goto L10
    }

    public final String f(DrivePreviewOpenRequest r110, com.larus.drive.sdk.impl.store.a r111, com.larus.drive.sdk.impl.preview.a r112, b r113) {
        monitor-enter(this);
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        h(r100);     // Catch: Throwable -> L18
        String r101 = UUID.randomUUID().toString();     // Catch: Throwable -> L18
        f341971b.put(r101, new a(r110, EntryState.PENDING, r100, r111, r112, r113));     // Catch: Throwable -> L18
        List r102 = i();     // Catch: Throwable -> L18
        FLogger.f375446a.i("DrivePreviewRequestStore", "put request, pendingCount=" + e() + ", activeCount=" + b());     // Catch: Throwable -> L18
        Pair r103 = TuplesKt.to(r101, r102);     // Catch: Throwable -> L18
        monitor-exit(this);
        String r104 = (String) r103.component1();
        Iterator r105 = ((List) r103.component2()).iterator();
    L8:
        if (r105.hasNext() == false) goto L17;
        Function0 r106 = (Function0) r105.next();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L12
        Object r108 = Result.m9449constructorimpl(r106.invoke());     // Catch: Throwable -> L12
    L14:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L8;
        FLogger.f375446a.e("DrivePreviewRequestStore", "capacity fallback failed, errorType=".concat(r109.getClass().getSimpleName()));
    L12:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L17:
        return r104;
    L18:
        th = move-exception;
        throw th;
    }
}
