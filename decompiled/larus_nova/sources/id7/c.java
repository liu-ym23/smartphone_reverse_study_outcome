package id7;

import com.bytedance.sdk.xbridge.cn.utils.j;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f489341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f489342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f489343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f489344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f489345e;

    public c() {
    }

    static {
        f489341a = new c();
        f489344d = new d();
        f489345e = true;
    }

    @JvmStatic
    public static final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f489343c == false) goto L5;
        return;
    L5:
        String r101 = "##BDXBridge: " + r100;
        j r102 = f489344d.f489347b;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter("x.copy", "methodName");
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter("BridgeProcessing", "bridgeStatus");
        if (f489343c == false) goto L28;
        return;
    L28:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
        boolean r103 = false;
        if ("BridgeProcessing".length() <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        String r105 = "[bullet-bridge][x.copy][BridgeProcessing] " + r100;     // Catch: Throwable -> L25
    L12:
        if (r101 != null) goto L14;
    L15:
        r103 = true;
    L16:
        if (r103 == false) goto L18;
        String r106 = "[bulletSession-unknown]" + r105;     // Catch: Throwable -> L25
    L19:
        j r107 = f489344d.f489347b;     // Catch: Throwable -> L25
        if (r107 == null) goto L22;
        r107.a(r106);     // Catch: Throwable -> L25
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L25
        return;
    L22:
        r108 = null;
        goto L23
    L18:
        r106 = "[bulletSession-" + r101 + ']' + r105;     // Catch: Throwable -> L25
        goto L19
    L14:
        if (r101.length() != 0) goto L16;
    L11:
        r105 = "[bullet-bridge][x.copy] " + r100;     // Catch: Throwable -> L25
        goto L12
    L8:
        r104 = false;
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
