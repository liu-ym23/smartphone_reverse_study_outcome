package com.larus.office.plugins.input.cache;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.im.j;
import com.larus.platform.service.AccountService;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes30.dex */
public final class OfficeDocumentConversationCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeDocumentConversationCache f362464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f362465b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f362466c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f362467d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f362468e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Regex f362469f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/office/plugins/input/cache/OfficeDocumentConversationCache$ReadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "HIT", "MISS", "EXPIRED", "INVALID_INPUT", "ACCOUNT_CHANGED", "STORE_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReadStatus extends Enum<ReadStatus> {
        public static final ReadStatus ACCOUNT_CHANGED = null;
        public static final ReadStatus EXPIRED = null;
        public static final ReadStatus HIT = null;
        public static final ReadStatus INVALID_INPUT = null;
        public static final ReadStatus MISS = null;
        public static final ReadStatus STORE_ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReadStatus[] f362470a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f362471b = null;

        public static EnumEntries<ReadStatus> getEntries() {
            return f362471b;
        }

        static {
            ReadStatus r100 = new ReadStatus("HIT", 0);
            HIT = r100;
            ReadStatus r101 = new ReadStatus("MISS", 1);
            MISS = r101;
            ReadStatus r102 = new ReadStatus("EXPIRED", 2);
            EXPIRED = r102;
            ReadStatus r103 = new ReadStatus("INVALID_INPUT", 3);
            INVALID_INPUT = r103;
            ReadStatus r104 = new ReadStatus("ACCOUNT_CHANGED", 4);
            ACCOUNT_CHANGED = r104;
            ReadStatus r105 = new ReadStatus("STORE_ERROR", 5);
            STORE_ERROR = r105;
            ReadStatus[] r110 = {r100, r101, r102, r103, r104, r105};
            f362470a = r110;
            f362471b = EnumEntriesKt.enumEntries(r110);
        }

        public static ReadStatus[] values() {
            return (ReadStatus[]) f362470a.clone();
        }

        public static ReadStatus valueOf(String r100) {
            return (ReadStatus) r27.a.a(ReadStatus.class, r100);
        }

        public ReadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f362472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f362473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f362474c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f362472a, r101.f362472a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362473b, r101.f362473b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f362474c, r101.f362474c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f362472a.hashCode() * 31) + this.f362473b.hashCode()) * 31) + this.f362474c.hashCode();
        }

        public final String toString() {
            return "AccountContext(userId=" + this.f362472a + ", secUserId=" + this.f362473b + ", ownerHash=" + this.f362474c + ')';
        }

        public a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "secUserId");
            Intrinsics.checkNotNullParameter(r102, "ownerHash");
            this.f362472a = r100;
            this.f362473b = r101;
            this.f362474c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f362475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f362476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f362477c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f362475a, r101.f362475a) == true) goto L12;
            return false;
        L12:
            if (this.f362476b == r101.f362476b) goto L15;
            return false;
        L15:
            if (this.f362477c == r101.f362477c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f362475a.hashCode() * 31;
            long r101 = this.f362476b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f362477c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "Entry(conversationId=" + this.f362475a + ", lastAccessAtMs=" + this.f362476b + ", accessSequence=" + this.f362477c + ')';
        }

        public b(String r100, long r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f362475a = r100;
            this.f362476b = r101;
            this.f362477c = r102;
        }

        public static b a(b r100, long r101, long r102, int r103) {
            if ((r103 & 1) == 0) goto L5;
            String r104 = r100.f362475a;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r101 = r100.f362476b;
        L9:
            long r105 = r101;
            if ((r103 & 4) == 0) goto L12;
            r102 = r100.f362477c;
        L12:
            Intrinsics.checkNotNullParameter(r104, "conversationId");
            String r106 = r104;
            return new b(r106, r105, r102);
        L5:
            r104 = null;
            goto L7
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReadStatus f362478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f362479b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f362478a == r101.f362478a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362479b, r101.f362479b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f362478a.hashCode() * 31;
            String r101 = this.f362479b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReadResult(status=" + this.f362478a + ", conversationId=" + this.f362479b + ')';
        }

        public c(ReadStatus r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "status");
            this.f362478a = r100;
            this.f362479b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f362480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, b> f362481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f362482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f362483d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f362480a == r101.f362480a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362481b, r101.f362481b) == true) goto L15;
            return false;
        L15:
            if (this.f362482c == r101.f362482c) goto L18;
            return false;
        L18:
            if (this.f362483d == r101.f362483d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f362480a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f362481b.hashCode()) * 31;
            int r102 = 1231;
            if (this.f362482c == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (r101 + r103) * 31;
            if (this.f362483d == true) goto L11;
            r102 = 1237;
        L11:
            return r104 + r102;
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "SanitizedSnapshot(nextAccessSequence=" + this.f362480a + ", entries=" + this.f362481b + ", changed=" + this.f362482c + ", requestedEntryExpired=" + this.f362483d + ')';
        }

        public d(long r100, Map<String, b> r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "entries");
            this.f362480a = r100;
            this.f362481b = r101;
            this.f362482c = r102;
            this.f362483d = r103;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f362484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, b> f362485b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f362484a == r101.f362484a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362485b, r101.f362485b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f362484a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f362485b.hashCode();
        }

        public final String toString() {
            return "Snapshot(nextAccessSequence=" + this.f362484a + ", entries=" + this.f362485b + ')';
        }

        public e(long r100, Map<String, b> r101) {
            Intrinsics.checkNotNullParameter(r101, "entries");
            this.f362484a = r100;
            this.f362485b = r101;
        }
    }

    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((b) ((Map.Entry) r100).getValue()).f362477c), Long.valueOf(((b) ((Map.Entry) r101).getValue()).f362477c));
        }
    }

    public static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f362486a;

        public g(f r100) {
            this.f362486a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f362486a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues((Comparable) ((Map.Entry) r100).getKey(), (Comparable) ((Map.Entry) r101).getKey());
        }
    }

    public OfficeDocumentConversationCache() {
    }

    static {
        f362464a = new OfficeDocumentConversationCache();
        f362465b = kotlinx.coroutines.sync.b.a();
        f362466c = new Gson();
        f362467d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f362468e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.office.plugins.input.cache.a());
        f362469f = new Regex("[0-9a-f]{64}");
    }

    public static String e(String r100) {
        byte[] r101 = MessageDigest.getInstance("SHA-256").digest(r100.getBytes(StandardCharsets.UTF_8));
        StringBuilder r102 = new StringBuilder(r101.length * 2);
        Intrinsics.checkNotNull(r101);
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        byte r105 = r101[r104];
        r102.append("0123456789abcdef".charAt((r105 >>> 4) & 15));
        r102.append("0123456789abcdef".charAt(r105 & 15));
        r104 = r104 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    public static boolean f(a r100) {
        AccountService r101 = AccountService.f365697a;
        if (Intrinsics.areEqual(r101.getUserId(), r100.f362472a) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101.getSecUserId(), r100.f362473b) == false) goto L7;
        return true;
    }

    public static boolean g(e r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f362484a > 0) goto L8;
        return false;
    L8:
        if (r100.f362485b.size() > 100) goto L37;
        Map<String, b> r101 = r100.f362485b;
        if (r101.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, b>> r102 = r101.entrySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L27;
        Map.Entry<String, b> r103 = r102.next();
        String r104 = r103.getKey();
        b r105 = r103.getValue();
        if (f362469f.matches(r104) == true) goto L18;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == true) goto L14;
        boolean r107 = false;
    L28:
        if (r107 == false) goto L38;
        return true;
    L38:
        return false;
    L18:
        if ((!StringsKt.isBlank(r105.f362475a)) == false) goto L24;
        if (r105.f362476b < 0) goto L24;
        if (r105.f362477c <= 0) goto L24;
        r106 = true;
    L27:
        r107 = true;
        goto L28
    L37:
        return false;
    }

    public static Map m(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap(r100);
    L4:
        if (r101.size() <= 100) goto L9;
        Map.Entry r102 = (Map.Entry) CollectionsKt.minWithOrNull(r101.entrySet(), new g(new f()));
        if (r102 == null) goto L9;
        r101.remove(r102.getKey());
    L9:
        return r101;
    }

    public static final e a(OfficeDocumentConversationCache r100, a r101) {
        r100.getClass();
        String r102 = "snapshot_" + r101.f362474c;
        Object r103 = null;
        String r104 = ((Keva) f362468e.getValue()).getString(r102, null);
        if (r104 == null) goto L32;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl((e) f362466c.fromJson(r104, e.class));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r106) == true) goto L13;
        r103 = r106;
    L13:
        e r107 = (e) r103;
        Object r108 = Result.m9449constructorimpl(Boolean.valueOf(g(r107)));     // Catch: Throwable -> L16
    L18:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r108) == false) goto L22;
        r108 = r109;
    L22:
        if (((Boolean) r108).booleanValue() == true) goto L24;
        ((Keva) f362468e.getValue()).erase(r102);
        return new e(1, MapsKt.emptyMap());
    L24:
        if (r107 != null) goto L27;
        return new e(1, MapsKt.emptyMap());
    L27:
        return r107;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L32:
        return new e(1, MapsKt.emptyMap());
    }

    public static final a b(OfficeDocumentConversationCache r100, String r101) {
        r100.getClass();
        AccountService r102 = AccountService.f365697a;
        String r103 = r102.getUserId();
        String r104 = r102.getSecUserId();
        if (StringsKt.isBlank(r101) == false) goto L5;
    L10:
        return null;
    L5:
        if (Intrinsics.areEqual(r103, r101) == false) goto L10;
        if (StringsKt.isBlank(r104) == true) goto L10;
        return new a(r103, r104, e(r104));
    }

    public static final boolean d(OfficeDocumentConversationCache r100, e r101, a r102) {
        r100.getClass();
        if (f(r102) == true) goto L5;
        return false;
    L5:
        ((Keva) f362468e.getValue()).storeString("snapshot_" + r102.f362474c, GsonProtectorUtils.toJson(f362466c, r101));
        return true;
    }

    public final <T> Object k(T r100, Function1<? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
        if ((r102 instanceof OfficeDocumentConversationCache$runSafely$1) == false) goto L7;
        OfficeDocumentConversationCache$runSafely$1 r103 = (OfficeDocumentConversationCache$runSafely$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        r100 = (T) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L20 CancellationException -> L22
    L24:
        return r105;
        goto L27
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;     // Catch: Exception -> L20 CancellationException -> L22
        r103.label = 1;     // Catch: Exception -> L20 CancellationException -> L22
        r105 = r101.invoke(r103);     // Catch: Exception -> L20 CancellationException -> L22
        if (r105 != r106) goto L24;
        return r106;
    L22:
        e = move-exception;
        throw e;
    L27:
        return r100;
    L7:
        r103 = new OfficeDocumentConversationCache$runSafely$1(this, r102);
        goto L8
    }

    public final Object h(String r100, String r101, String r102, Continuation<? super Boolean> r103) {
        if (StringsKt.isBlank(r100) == true) goto L14;
        if (StringsKt.isBlank(r101) == true) goto L14;
        if (StringsKt.isBlank(r102) == true) goto L14;
        if (j.f(r102) == true) goto L14;
        return k(Boxing.boxBoolean(false), new OfficeDocumentConversationCache$promoteLruIfMatches$2(r100, r101, r102, null), r103);
    L14:
        return Boxing.boxBoolean(false);
    }

    public final Object i(String r100, String r101, int r102, ContinuationImpl r103) {
        if (StringsKt.isBlank(r100) == true) goto L10;
        if (StringsKt.isBlank(r101) == true) goto L10;
        return k(new c(ReadStatus.STORE_ERROR, null), new OfficeDocumentConversationCache$read$2(r100, r101, r102, null), r103);
    L10:
        return new c(ReadStatus.INVALID_INPUT, null);
    }

    public final Object j(String r100, String r101, String r102, Continuation<? super Boolean> r103) {
        if (StringsKt.isBlank(r100) == true) goto L12;
        if (StringsKt.isBlank(r101) == true) goto L12;
        if (StringsKt.isBlank(r102) == true) goto L12;
        return k(Boxing.boxBoolean(false), new OfficeDocumentConversationCache$removeIfMatches$2(r100, r101, r102, null), r103);
    L12:
        return Boxing.boxBoolean(false);
    }

    public final Object l(String r100, String r101, String r102, Continuation<? super Boolean> r103) {
        if (StringsKt.isBlank(r100) == true) goto L14;
        if (StringsKt.isBlank(r101) == true) goto L14;
        if (StringsKt.isBlank(r102) == true) goto L14;
        if (j.f(r102) == true) goto L14;
        return k(Boxing.boxBoolean(false), new OfficeDocumentConversationCache$touchIfMatches$2(r100, r101, r102, null), r103);
    L14:
        return Boxing.boxBoolean(false);
    }

    public static final d c(OfficeDocumentConversationCache r110, e r111, String r112, long r113, long r114) {
        r110.getClass();
        LinkedHashMap r100 = new LinkedHashMap(r111.f362485b.size());
        Iterator<Map.Entry<String, b>> r101 = r111.f362485b.entrySet().iterator();
        boolean r102 = false;
        boolean r103 = false;
        boolean r104 = false;
    L4:
        if (r101.hasNext() == false) goto L25;
        Map.Entry<String, b> r105 = r101.next();
        String r106 = r105.getKey();
        b r107 = r105.getValue();
        Lazy r108 = j.f350569a;
        boolean r109 = j.f(r107.f362475a);
        long r115 = r107.f362476b;
        if (r113 >= r115) goto L8;
        boolean r116 = true;
    L9:
        if (r116 == false) goto L11;
    L13:
        boolean r117 = false;
    L14:
        if (r109 == true) goto L20;
        if (r116 == true) goto L20;
        if (r117 == true) goto L20;
        r100.put(r106, r107);
    L20:
        if (Intrinsics.areEqual(r106, r112) == false) goto L24;
        if (r116 == true) goto L23;
        if (r117 == false) goto L24;
    L23:
        r103 = true;
        r104 = true;
    L24:
        r103 = true;
        goto L4
    L11:
        if ((r113 - r115) < r114) goto L13;
        r117 = true;
        goto L14
    L8:
        r116 = false;
        goto L9
    L25:
        Map r118 = m(r100);
        long r119 = r111.f362484a;
        if (r103 == false) goto L28;
    L29:
        r102 = true;
    L31:
        return new d(r119, r118, r102, r104);
    L28:
        if (r118.size() == r100.size()) goto L31;
        goto L29
    }
}
