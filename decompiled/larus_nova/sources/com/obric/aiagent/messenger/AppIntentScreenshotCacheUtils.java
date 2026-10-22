package com.obric.aiagent.messenger;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.debug.api.IObricDebugService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes32.dex */
public final class AppIntentScreenshotCacheUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppIntentScreenshotCacheUtils f384749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f384750b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f384751c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SecureRandom f384752d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f384753e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f384754f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f384755g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AppIntentScreenshotCacheUtils$cache$1 f384756h = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/messenger/AppIntentScreenshotCacheUtils$ScreenshotSource;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "HEIF", "BITMAP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenshotSource extends Enum<ScreenshotSource> {
        public static final ScreenshotSource BITMAP = null;
        public static final ScreenshotSource HEIF = null;
        public static final ScreenshotSource NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenshotSource[] f384757a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f384758b = null;

        public static EnumEntries<ScreenshotSource> getEntries() {
            return f384758b;
        }

        static {
            ScreenshotSource r100 = new ScreenshotSource(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ScreenshotSource r101 = new ScreenshotSource("HEIF", 1);
            HEIF = r101;
            ScreenshotSource r102 = new ScreenshotSource("BITMAP", 2);
            BITMAP = r102;
            ScreenshotSource[] r103 = {r100, r101, r102};
            f384757a = r103;
            f384758b = EnumEntriesKt.enumEntries(r103);
        }

        public static ScreenshotSource[] values() {
            return (ScreenshotSource[]) f384757a.clone();
        }

        public static ScreenshotSource valueOf(String r100) {
            return (ScreenshotSource) r27.a.a(ScreenshotSource.class, r100);
        }

        public ScreenshotSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f384759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f384760b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f384759a, r101.f384759a) == true) goto L12;
            return false;
        L12:
            if (this.f384760b == r101.f384760b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f384759a.hashCode() * 31;
            if (this.f384760b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "EncryptResult(data=" + this.f384759a + ", isPrivacy=" + this.f384760b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f384759a = r100;
            this.f384760b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f384761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f384762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScreenshotSource f384763c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f384761a, r101.f384761a) == true) goto L12;
            return false;
        L12:
            if (this.f384762b == r101.f384762b) goto L15;
            return false;
        L15:
            if (this.f384763c == r101.f384763c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f384761a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f384762b == false) goto L9;
            int r103 = 1231;
        L11:
            return ((r102 + r103) * 31) + this.f384763c.hashCode();
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "EncryptResultWithSource(data=" + this.f384761a + ", isPrivacy=" + this.f384762b + ", source=" + this.f384763c + ')';
        }

        public b(String r100, boolean r101, ScreenshotSource r102) {
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f384761a = r100;
            this.f384762b = r101;
            this.f384763c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f384764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f384765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CompletableDeferred<a> f384766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f384767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f384768e;

        public c() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f384764a, r101.f384764a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f384765b, r101.f384765b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f384766c, r101.f384766c) == true) goto L18;
            return false;
        L18:
            if (this.f384767d == r101.f384767d) goto L21;
            return false;
        L21:
            if (this.f384768e == r101.f384768e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Bitmap r100 = this.f384764a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f384765b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            CompletableDeferred<a> r107 = this.f384766c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (r106 + r101) * 31;
            if (this.f384767d == false) goto L17;
            int r109 = 1231;
        L18:
            int r110 = (r108 + r109) * 31;
            long r111 = this.f384768e;
            return r110 + ((int) (r111 ^ (r111 >>> 32)));
        L17:
            r109 = 1237;
            goto L18
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(bitmap=" + this.f384764a + ", encryptedData=" + this.f384765b + ", pendingEncryptData=" + this.f384766c + ", isPrivacy=" + this.f384767d + ", lastAccessUptimeMs=" + this.f384768e + ')';
        }

        public final boolean a() {
            Bitmap r100 = this.f384764a;
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == false) goto L10;
            return true;
        L10:
            if (this.f384764a != null) goto L22;
            String r102 = this.f384765b;
            if (r102 != null) goto L14;
        L17:
            boolean r103 = true;
        L18:
            if (r103 == false) goto L22;
            if (this.f384766c != null) goto L22;
            return true;
        L14:
            if (r102.length() == 0) goto L17;
            r103 = false;
        L22:
            return false;
        L5:
            if (r100.isRecycled() != true) goto L7;
            r101 = true;
            goto L8
        }

        public c(Bitmap r100, String r101, CompletableDeferred r102, boolean r103, long r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r105 & 8) == 0) goto L14;
            r103 = false;
        L14:
            this.f384764a = r100;
            this.f384765b = r101;
            this.f384766c = r102;
            this.f384767d = r103;
            this.f384768e = r104;
        }
    }

    public AppIntentScreenshotCacheUtils() {
    }

    static {
        f384749a = new AppIntentScreenshotCacheUtils();
        f384750b = new Object();
        f384751c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f384752d = new SecureRandom();
        t1 r100 = t1.f393353a;
        int r101 = r100.getObricAppIntentScreenshotCacheConfig().getMaxSize();
        f384753e = r101;
        f384754f = r100.getObricAppIntentScreenshotCacheConfig().getTtlMs();
        f384755g = r100.getObricAppIntentScreenshotCacheConfig().getEnableAppendScreenshotNoise();
        f384756h = new AppIntentScreenshotCacheUtils$cache$1(r101);
    }

    public static int e() {
        IObricPccService r100 = (IObricPccService) ServiceManager.get().getService(IObricPccService.class);
        if (r100 != null) goto L7;
        return 1;
    L7:
        return r100.c();
    }

    public static void f() {
        long r100 = SystemClock.uptimeMillis();
        Iterator<Map.Entry<String, c>> r101 = f384756h.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        c r102 = r101.next().getValue();
        boolean r103 = false;
        if ((r100 - r102.f384768e) <= f384754f) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        if (r102.a() == false) goto L4;
    L12:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("purgeExpiredLocked, ");
        r106.append(r104);
        r106.append(", ");
        Bitmap r107 = r102.f384764a;
        if (r107 != null) goto L15;
    L17:
        r106.append(r103);
        r105.i("AppIntentScreenshotCacheUtils", r106.toString());
        r101.remove();
        goto L4
    L15:
        if (r107.isRecycled() != true) goto L17;
        r103 = true;
        goto L17
    L8:
        r104 = false;
        goto L9
    }

    public static c d(String r100) {
        Object r101 = f384750b;
        monitor-enter(r101);
        f384749a.getClass();     // Catch: Throwable -> L14
        f();     // Catch: Throwable -> L14
        AppIntentScreenshotCacheUtils$cache$1 r102 = f384756h;     // Catch: Throwable -> L14
        c r103 = (c) r102.get(r100);     // Catch: Throwable -> L14
        if (r103 != null) goto L8;
    L10:
        r103 = null;
    L12:
        monitor-exit(r101);
        return r103;
    L8:
        if (r103.a() == false) goto L11;
        r102.remove(r100);     // Catch: Throwable -> L14
        FLogger.f375446a.w("AppIntentScreenshotCacheUtils", "getEntry, entry is invalid, messageId=" + r100);     // Catch: Throwable -> L14
        goto L10
    L11:
        r103.f384768e = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static final byte[] a(AppIntentScreenshotCacheUtils r100, ParcelFileDescriptor r101) {
        r100.getClass();
        ParcelFileDescriptor.AutoCloseInputStream r102 = new ParcelFileDescriptor.AutoCloseInputStream(r101);
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default(r102, r103, 0, 2, null);     // Catch: Throwable -> L9
        byte[] r104 = r103.toByteArray();     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r102, null);
        return r104;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public static Pair c(String r100, String r101) {
        if (r100 == null) goto L9;
        f384749a.getClass();
        c r102 = d(r100);
        if (r102 == null) goto L7;
        Pair r103 = TuplesKt.to(r100, r102);
    L8:
        if (r103 == null) goto L9;
    L14:
        return r103;
    L7:
        r103 = null;
    L9:
        if (r101 == null) goto L15;
        f384749a.getClass();
        c r104 = d(r101);
        if (r104 == null) goto L16;
        r103 = TuplesKt.to(r101, r104);
        goto L14
    L16:
        return null;
    L15:
        return null;
    }

    public static void g(String r110, Bitmap r111) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        Object r100 = f384750b;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r111.isRecycled() == false) goto L9;
        FLogger.f375446a.w("AppIntentScreenshotCacheUtils", "put, bitmap is recycled, messageId=".concat(r110));     // Catch: Throwable -> L12
        monitor-exit(r100);
        return;
    L9:
        f384749a.getClass();     // Catch: Throwable -> L12
        f();     // Catch: Throwable -> L12
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "put, messageId=".concat(r110));     // Catch: Throwable -> L12
        f384756h.put(r110, new c(r111, null, null, false, SystemClock.uptimeMillis(), 14));     // Catch: Throwable -> L12
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
    }

    public static void h(String r110, ParcelFileDescriptor r111) {
        Intrinsics.checkNotNullParameter(r110, "fdKey");
        Intrinsics.checkNotNullParameter(r111, "fd");
        if (StringsKt.isBlank(r110) == false) goto L10;
        FLogger.f375446a.e("AppIntentScreenshotCacheUtils", "putFile, fdKey is blank");
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L7
        r111.close();     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L10:
        CompletableDeferred r100 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Object r114 = f384750b;
        monitor-enter(r114);
        f384749a.getClass();     // Catch: Throwable -> L16
        f();     // Catch: Throwable -> L16
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "put pending heif, fdKey=".concat(r110));     // Catch: Throwable -> L16
        f384756h.put(r110, new c(null, null, r100, false, SystemClock.uptimeMillis(), 11));     // Catch: Throwable -> L16
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r114);
        BuildersKt.launch$default(f384751c, null, null, new AppIntentScreenshotCacheUtils$putFile$3(r111, r110, r100, null), 3, null);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final Object b(String r100, byte[] r101, Continuation<? super Pair<String, Boolean>> r102) {
        if ((r102 instanceof AppIntentScreenshotCacheUtils$encryptByteArray$1) == false) goto L7;
        AppIntentScreenshotCacheUtils$encryptByteArray$1 r103 = (AppIntentScreenshotCacheUtils$encryptByteArray$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L31:
        String r108 = (String) r105;
        if (r108 == null) goto L36;
        Pair r109 = TuplesKt.to(r108, Boxing.boxBoolean(true));
        if (r109 == null) goto L36;
        return r109;
    L36:
        return TuplesKt.to(null, Boxing.boxBoolean(false));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (f384755g == false) goto L17;
        byte[] r110 = new byte[128];
        f384752d.nextBytes(r110);
        r101 = ArraysKt.plus(r101, r110);
    L17:
        IObricDebugService r111 = (IObricDebugService) ServiceManager.get().getServiceForReal(IObricDebugService.class);
        if (r111 != null) goto L20;
    L22:
        boolean r112 = false;
    L24:
        if (r112 == false) goto L26;
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "encryptByteArray, not enable pcc privacy");
        return TuplesKt.to(Base64.encodeToString(r101, 2), Boxing.boxBoolean(false));
    L26:
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "encryptByteArray, encrypt");
        IObricPccService r113 = (IObricPccService) ServiceManager.get().getService(IObricPccService.class);
        if (r113 == null) goto L36;
        r103.label = 1;
        r105 = r113.a(r100, r101, r103);
        if (r105 != r106) goto L31;
        return r106;
    L20:
        if (r111.c() == true) goto L22;
        r112 = true;
    L7:
        r103 = new AppIntentScreenshotCacheUtils$encryptByteArray$1(this, r102);
        goto L8
    }

    public final Object i(String r110, String r111, Continuation<? super b> r112) {
        if ((r112 instanceof AppIntentScreenshotCacheUtils$tryGetEncryptData$1) == false) goto L7;
        AppIntentScreenshotCacheUtils$tryGetEncryptData$1 r100 = (AppIntentScreenshotCacheUtils$tryGetEncryptData$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r113);
    L96:
        Pair r114 = (Pair) r113;
        return new b((String) r114.component1(), ((Boolean) r114.component2()).booleanValue(), ScreenshotSource.BITMAP);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L19
    L75:
        a r115 = (a) r113;     // Catch: Throwable -> L19
        return new b(r115.f384759a, r115.f384760b, ScreenshotSource.HEIF);
    L21:
        String r116 = (String) r100.L$1;
        String r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L51:
        Pair r118 = (Pair) r113;
        String r119 = r117;
        r111 = r116;
        r110 = r119;
    L52:
        if (r118 == null) goto L57;
        String r104 = (String) r118.getFirst();
        if (r104 == null) goto L57;
        r110 = r104;
    L62:
        if (r118 == null) goto L98;
        c r120 = (c) r118.getSecond();
        if (r120 == null) goto L98;
        FLogger r121 = FLogger.f375446a;
        r121.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, in 1 messageId=".concat(r110));
        String r105 = r120.f384765b;
        if (r105 != null) goto L69;
        CompletableDeferred<a> r106 = r120.f384766c;
        if (r106 == null) goto L79;
        r121.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, wait pending encrypted data, messageId=".concat(r110));     // Catch: Throwable -> L19
        r100.L$0 = r110;     // Catch: Throwable -> L19
        r100.L$1 = null;     // Catch: Throwable -> L19
        r100.label = 2;     // Catch: Throwable -> L19
        r113 = r106.await(r100);     // Catch: Throwable -> L19
        if (r113 != r102) goto L75;
        return r102;
    L79:
        Bitmap r122 = r120.f384764a;
        if (r122 == null) goto L82;
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: Throwable -> L88
        if (r122.compress(Bitmap.CompressFormat.JPEG, 90, r107) == true) goto L86;
        r121.w("AppIntentScreenshotCacheUtils", "bitmapToByteArray, compress failed");     // Catch: Throwable -> L88
        goto L89
    L86:
        byte[] r123 = r107.toByteArray();     // Catch: Throwable -> L88
    L90:
        if (r123 != null) goto L93;
        f.a(r110, "bitmapToByteArray failed");
        f.b(r110);
        return new b(null, false, ScreenshotSource.NONE);
    L93:
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, in 2 messageId=".concat(r110));
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        r113 = b(r110, r123, r100);
        if (r113 != r102) goto L96;
        return r102;
    L89:
        r123 = null;
        goto L90
    L82:
        return new b(null, false, ScreenshotSource.NONE);
    L69:
        return new b(r105, r120.f384767d, ScreenshotSource.HEIF);
    L98:
        f.a(r110, "get screenshot failed");
        f.b(r110);
        return new b(null, false, ScreenshotSource.NONE);
    L57:
        if (r110 != null) goto L62;
        if (r111 == null) goto L60;
        r110 = r111;
        goto L62
    L60:
        return new b(null, false, ScreenshotSource.NONE);
    L22:
        ResultKt.throwOnFailure(r113);
        if (r110 != null) goto L25;
    L32:
        r110 = null;
    L33:
        if (r111 != null) goto L35;
    L44:
        r111 = null;
    L45:
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, in 0 messageId=" + r110 + ", questionId=" + r111);
        r118 = c(r110, r111);
        if (r118 != null) goto L52;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = j(r110, r111, r100);
        if (r113 != r102) goto L50;
        return r102;
    L50:
        String r124 = r111;
        r117 = r110;
        r116 = r124;
        goto L51
    L35:
        if ((!StringsKt.isBlank(r111)) == true) goto L37;
    L41:
        boolean r125 = false;
    L42:
        if (r125 == false) goto L44;
    L37:
        if (Intrinsics.areEqual(r111, "-1") == true) goto L41;
        if (Intrinsics.areEqual(r111, r110) == true) goto L41;
        r125 = true;
        goto L42
    L25:
        if ((!StringsKt.isBlank(r110)) == true) goto L27;
    L29:
        boolean r108 = false;
    L30:
        if (r108 == false) goto L32;
    L27:
        if (Intrinsics.areEqual(r110, "-1") == true) goto L29;
        r108 = true;
    L19:
        th = move-exception;
        ConcurrentHashMap<String, String> r126 = f.f384792a;
        f.a(r110, "wait pending encrypted data failed: " + th.getMessage());
        f.b(r110);
        return new b(null, false, ScreenshotSource.NONE);
    L7:
        r100 = new AppIntentScreenshotCacheUtils$tryGetEncryptData$1(this, r112);
        goto L8
    }

    public final Object j(String r110, String r111, Continuation<? super Pair<String, c>> r112) {
        if ((r112 instanceof AppIntentScreenshotCacheUtils$waitForEntry$1) == false) goto L7;
        AppIntentScreenshotCacheUtils$waitForEntry$1 r100 = (AppIntentScreenshotCacheUtils$waitForEntry$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r114 = r100.J$0;
        String r104 = (String) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L20:
        if (SystemClock.uptimeMillis() >= r114) goto L28;
        Pair r115 = c(r105, r104);
        if (r115 != null) goto L23;
        r100.L$0 = r105;
        r100.L$1 = r104;
        r100.J$0 = r114;
        r100.label = 1;
        if (DelayKt.delay(20, r100) != r102) goto L20;
        return r102;
    L23:
        FLogger.f375446a.i("AppIntentScreenshotCacheUtils", "waitForEntry hit, messageId=" + r105 + ", questionId=" + r104);
        return r115;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 != null) goto L18;
        if (r111 != null) goto L18;
        return null;
    L18:
        r104 = r111;
        r105 = r110;
        r114 = SystemClock.uptimeMillis() + 3000;
    L7:
        r100 = new AppIntentScreenshotCacheUtils$waitForEntry$1(this, r112);
        goto L8
    }
}
