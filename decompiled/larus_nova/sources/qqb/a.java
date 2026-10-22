package qqb;

import com.ss.android.lark.log.Log;
import java.security.SecureRandom;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<String> f534506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SecureRandom> f534507b = null;

    static {
        f534506a = new ThreadLocal();
        f534507b = new ThreadLocal();
    }

    @JvmStatic
    public static final void a() {
        f534506a.set("");
    }

    @JvmStatic
    public static final String d() {
        String r100 = f534506a.get();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @JvmStatic
    public static final UUID e() {
        ThreadLocal<SecureRandom> r100 = f534507b;
        SecureRandom r101 = r100.get();
        if (r101 != null) goto L5;
        r101 = new SecureRandom();
        r100.set(r101);
    L5:
        byte[] r102 = new byte[16];
        r101.nextBytes(r102);
        byte r103 = (byte) (r102[6] & 15);
        r102[6] = r103;
        r102[6] = (byte) (r103 | 64);
        byte r104 = (byte) (r102[8] & 63);
        r102[8] = r104;
        r102[8] = (byte) (r104 | ByteCompanionObject.MIN_VALUE);
        int r105 = 0;
        long r106 = 0;
    L7:
        if (r105 >= 8) goto L9;
        r106 = (r106 << 8) | (255 & (((long) r102[r105]) + 0));
        r105 = r105 + 1;
        goto L7
    L9:
        long r110 = 0;
        int r107 = 8;
    L10:
        if (r107 >= 16) goto L13;
        r110 = (r110 << 8) | ((((long) r102[r107]) + 0) & 255);
        r107 = r107 + 1;
        goto L10
    L13:
        return new UUID(r106, r110);
    }

    @JvmStatic
    public static final String c() {
        String r100 = d();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return i(e());
    L9:
        return r100 + '_' + i(e());
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        String r101 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r100, new String[]{"_"}, false, 0, 6, null));
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @JvmStatic
    public static final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        g(r100);
    }

    @JvmStatic
    public static final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        f534506a.set(r100);
    }

    @JvmStatic
    public static final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mark");
        if (Intrinsics.areEqual(d(), "") == true) goto L5;
        Log.e("TraceIdUtils", "Please check if the traceId is set repeatedly or forget to clear");
    L5:
        g(i(e()));
        Log.i("TraceIdUtils", StringsKt.trimIndent("\n            Start traceable log\n            " + r100 + "\n            "));
    }

    @JvmStatic
    public static final String i(UUID r100) {
        return StringsKt.replace$default(String.valueOf(r100), "-", "", false, 4, null).substring(0, 10);
    }
}
