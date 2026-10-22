package vx9;

import androidx.collection.SieveCacheKt;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements io.opentelemetry.sdk.trace.d {

    /* JADX INFO: renamed from: vx9.a$a, reason: collision with other inner class name */
    public static final class C8049a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicLong f557495a = null;

        static {
            f557495a = new AtomicLong(Random.Default.nextInt(0, Integer.MAX_VALUE));
        }

        public static long a() {
            AtomicLong r100 = f557495a;
            long r101 = r100.addAndGet(1);
            if (r101 < SieveCacheKt.NodeLinkMask) goto L6;
            r100.set(Random.Default.nextInt(0, Integer.MAX_VALUE));
            return a();
        L6:
            return r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
    }

    @Override // io.opentelemetry.sdk.trace.d
    public final String generateSpanId() {
    L2:
        long r100 = URandomKt.nextULong(Random.Default);
        if (r100 == 0) goto L2;
        return StringsKt.padStart(UStringsKt.m10779toStringJSWoG40(r100, 16), 16, '0');
    }

    @Override // io.opentelemetry.sdk.trace.d
    public final String generateTraceId() {
        long r100 = ULong.m9623constructorimpl(ULong.m9623constructorimpl(Long.MAX_VALUE) | 1);
        String r101 = o.f365780a.getDeviceId();     // Catch: Exception -> L5
    L7:
        int r102 = 0;
        if (r101.length() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        r101 = String.valueOf(System.currentTimeMillis());
    L13:
        byte[] r104 = MessageDigest.getInstance("SHA-256").digest(r101.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r104);
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r102 >= r105) goto L16;
        r106 = ((r106 + r104[r102]) & 255) << 5;
        r102 = r102 + 1;
        goto L14
    L16:
        String r107 = StringsKt.padStart(UStringsKt.m10779toStringJSWoG40(ULong.m9623constructorimpl(ULong.m9623constructorimpl((((long) r106) << 32) + C8049a.a()) & r100), 16), 16, '0');
    L17:
        long r108 = URandomKt.nextULong(Random.Default);
        if (r108 == 0) goto L17;
        return r107 + StringsKt.padStart(UStringsKt.m10779toStringJSWoG40(ULong.m9623constructorimpl(r100 & r108), 16), 16, '0');
    L10:
        r103 = false;
    L5:
        e = move-exception;
        FLogger.f375446a.e("IdsGenerator", "getDeviceId failed:" + e);
        r101 = "";
        goto L7
    }
}
