package com.obric.assistant.remote_card_container.manager;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.widget.RemoteViews;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.remote_card_container.cache.i;
import com.obric.assistant.remote_card_container.cache.j;
import com.obric.assistant.remote_card_container.cache.m;
import com.obric.assistant.remote_card_container.cache.n;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteCardManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RemoteCardManager f391279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f391280b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f391281c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static sfa.a f391282d;

    public RemoteCardManager() {
    }

    static {
        f391279a = new RemoteCardManager();
        f391280b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f391281c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static boolean c(o9a.d r100, rfa.c r110, j r111, boolean r112) {
        long r101 = r110.f537649a;
        if (r101 >= 0) goto L5;
    L31:
        p9a.e r102 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "source app info is invalid: " + r110);
        return false;
    L5:
        if (r110.f537650b < 0) goto L31;
        if (r100.f522505f == r101) goto L12;
        p9a.e r113 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "app version code not match: cardVersion = " + r100.f522505f + ", sourceAppVersion = " + r110.f537649a);
        return false;
    L12:
        if (r111 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L25;
        p9a.e r104 = p9a.b.f528329a;
        StringBuilder r105 = new StringBuilder("app last update time not match: cardLastUpdateTime = ");
        if (r111 == null) goto L21;
        Long r114 = Long.valueOf(r111.h());
    L22:
        r105.append(r114);
        r105.append(", sourceLastUpdateTime = ");
        r105.append(r110.f537650b);
        p9a.b.a("RemoteCardManager", r105.toString());
        return false;
    L21:
        r114 = null;
        goto L22
    L25:
        if (r100.f522503d == true) goto L27;
    L30:
        return true;
    L27:
        if (r100.f522502c == r112) goto L30;
        p9a.e r115 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "night mode not match: cardNightMode = " + r100.f522502c + ", contextNightMode = " + r112);
        return false;
    L14:
        if (r111.h() != r110.f537650b) goto L16;
        r103 = true;
        goto L17
    }

    public final Object b(Context r110, String r111, boolean r112, Continuation<? super Pair<o9a.d, Boolean>> r210) {
        if ((r210 instanceof RemoteCardManager$getCard$1) == false) goto L7;
        RemoteCardManager$getCard$1 r100 = (RemoteCardManager$getCard$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L66:
        return TuplesKt.to(r102, Boxing.boxBoolean(false));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r111 == null) goto L17;
        if (r112 == false) goto L62;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if ((r110.getResources().getConfiguration().uiMode & 48) != 32) goto L22;
        boolean r113 = true;
    L23:
        rfa.c r114 = rfa.b.a(p9a.f.b(UriProtector.parse(r111)));
        j r115 = m.f391249a.a(r111);
        n r116 = n.f391253a;
        monitor-enter(r116);
        Intrinsics.checkNotNullParameter(r111, "cardUri");     // Catch: Throwable -> L59
        o9a.d r105 = n.f391254b.get(r111);     // Catch: Throwable -> L59
        monitor-exit(r116);
        if (r105 != null) goto L29;
    L33:
        i r106 = i.f391243a;
        Intrinsics.checkNotNullParameter(r111, "cardUri");
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L47
        if (i.f391246d.contains(p9a.f.b(UriProtector.parse(r111))) == false) goto L37;
        p9a.e r107 = p9a.b.f528329a;     // Catch: Throwable -> L47
        p9a.b.a("DiskCache", "getCache: not support file cache ".concat(r111));     // Catch: Throwable -> L47
    L52:
        o9a.d r108 = null;
    L53:
        if (r108 == null) goto L62;
        if (c(r108, r114, r115, r113) == false) goto L58;
        p9a.e r109 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "disk cache is ok for ".concat(r111));
        n.f391253a.a(r111, r108);
        return TuplesKt.to(r108, Boxing.boxBoolean(true));
    L58:
        p9a.b.a("RemoteCardManager", "disk cache is invalid");
        i r118 = i.f391243a;
        i.b(r111);
        goto L62
    L37:
        PolarisFileWrapper r119 = new PolarisFileWrapper((File) i.f391245c.getValue(), r106.a(r111));     // Catch: Throwable -> L47
        if (r119.exists() == true) goto L70;
    L45:
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L52;
        p9a.e r122 = p9a.b.f528329a;
        p9a.b.c("DiskCache", "get cache failed: " + r121.getMessage(), r121);
        goto L52
    L70:
        Parcel r123 = Parcel.obtain();     // Catch: Throwable -> L41
        byte[] r124 = FilesKt.readBytes(r119);     // Catch: Throwable -> L41
        r123.unmarshall(r124, 0, r124.length);     // Catch: Throwable -> L41
        r123.setDataPosition(0);     // Catch: Throwable -> L41
        int r125 = o9a.d.f522499i;     // Catch: Throwable -> L41
        r108 = o9a.d.a.a(r123.readBundle(Bundle.class.getClassLoader()));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L47
        Throwable r127 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));     // Catch: Throwable -> L47
        if (r127 == null) goto L45;
        p9a.e r128 = p9a.b.f528329a;     // Catch: Throwable -> L47
        p9a.b.c("DiskCache", "parse cache failed: " + r127.getMessage(), r127);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L29:
        if (c(r105, r114, r115, r113) == false) goto L32;
        p9a.e r130 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "memory cache is ok for ".concat(r111));
        return TuplesKt.to(r105, Boxing.boxBoolean(true));
    L32:
        p9a.b.a("RemoteCardManager", "memory cache is invalid");
        r116.b(r111);
    L59:
        th = move-exception;
        throw th;
    L22:
        r113 = false;
    L62:
        r100.label = 1;
        p9a.e r131 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "fetchRemoteCard: cardUri = ".concat(r111));
        r102 = BuildersKt.async$default(f391280b, null, null, new RemoteCardManager$fetchRemoteCard$2(r111, r110, null), 3, null).await(r100);
        if (r102 != r103) goto L66;
        return r103;
    L17:
        return TuplesKt.to(null, Boxing.boxBoolean(false));
    L7:
        r100 = new RemoteCardManager$getCard$1(this, r210);
        goto L8
    }

    public static Object a(Context r110, RemoteCardContainer r111, RemoteViews r112, String r113, Continuation r114) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r114), 1);
        r100.C();
        CoroutineScope r101 = f391281c;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        CoroutineStart r102 = CoroutineStart.UNDISPATCHED;
    L6:
        BuildersKt.launch$default(r101, null, r102, new RemoteCardManager$applyRemoteViews$2$1(r112, r110, r111, r113, r100, null), 1, null);
        Object r103 = r100.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r114);
    L9:
        return r103;
    L5:
        r102 = CoroutineStart.DEFAULT;
        goto L6
    }
}
