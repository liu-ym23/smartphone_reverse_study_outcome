package com.larus.image.loader;

import android.net.Uri;
import android.util.Base64;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageUrlStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageUrlStorage f350955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f350956b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f350957c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f350958d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, a> f350959e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f350960f;

    public ImageUrlStorage() {
    }

    static {
        f350955a = new ImageUrlStorage();
        f350956b = LazyKt.lazy(new p());
        f350957c = LazyKt.lazy(new q());
        f350958d = LazyKt.lazy(new s());
        f350959e = new HashMap();
    }

    public static dvc.e d() {
        return (dvc.e) f350956b.getValue();
    }

    public static String e(Uri r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(r100.buildUpon().clearQuery().toString());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 == null) goto L12;
        return r103;
    L12:
        return r100.toString();
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void g(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        BuildersKt.launch$default((CoroutineScope) f350958d.getValue(), null, null, new ImageUrlStorage$remove$1(r100, null), 3, null);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static final String a(ImageUrlStorage r100, String r101) {
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        String r103 = e(y0.i(r101));     // Catch: Throwable -> L5
        ByteString.Companion.getClass();     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(ByteString.a.b(r103).md5().hex());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        String r105 = (String) r104;
        if (r105 != null) goto L14;
        return r101;
    L14:
        return r105;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static Object c(String r100, ContinuationImpl r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        return BuildersKt.withContext((ExecutorCoroutineDispatcher) f350957c.getValue(), new ImageUrlStorage$get$2(r100, null), r101);
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L9
    }

    public static void f(String r100, Throwable r101) {
        FLogger.f375446a.e("ImageUrlStorage", r100 + " error:" + r101.getMessage());
    }

    public static final void b(ImageUrlStorage r100, String r101, String r102) {
        r100.getClass();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L36
        if (r102 == null) goto L14;
        Intrinsics.checkNotNullParameter(r102, "<this>");     // Catch: Throwable -> L36
        Object r104 = Result.m9449constructorimpl(Base64.encodeToString(r102.getBytes(Charsets.UTF_8), 0));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        String r105 = (String) r104;     // Catch: Throwable -> L36
    L15:
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        d().m(r101);     // Catch: Throwable -> L36
    L29:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L50;
        f350955a.getClass();
        f("internalAdd", r108);
        return;
    L50:
        return;
    L23:
        dvc.e.b r109 = d().d(r101, -1);     // Catch: Throwable -> L36
        if (r109 == null) goto L29;
        BufferedSink r110 = Okio.buffer(r109.d(0));     // Catch: Throwable -> L36
        r110.writeUtf8(r105);     // Catch: Throwable -> L31
        r110.flush();     // Catch: Throwable -> L31
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r110, null);     // Catch: Throwable -> L36
        r109.b();     // Catch: Throwable -> L36
        goto L29
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L17:
        if (r105.length() == 0) goto L20;
        r106 = false;
    L8:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
        goto L11
    L14:
        r105 = null;
    L36:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    }
}
