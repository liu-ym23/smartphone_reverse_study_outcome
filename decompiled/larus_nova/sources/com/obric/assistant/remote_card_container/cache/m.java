package com.obric.assistant.remote_card_container.cache;

import androidx.collection.LruCache;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f391249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f391250b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f391251c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, j> f391252d = null;

    public m() {
    }

    static {
        f391249a = new m();
        f391250b = Keva.getRepo("obric_remote_cards");
        f391251c = new Gson();
        f391252d = new LruCache(50);
    }

    public final synchronized j a(String r100) {
        monitor-enter(this);
        boolean r101 = false;
        if (r100 != null) goto L48;
    L11:
        boolean r102 = true;
    L12:
        Object r103 = null;
        if (r102 == false) goto L16;
        monitor-exit(this);
        return null;
    L16:
        j r104 = f391252d.get(r100);     // Catch: Throwable -> L9
        if (r104 == null) goto L46;
        monitor-exit(this);
        return r104;
    L46:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L30
        String r106 = f391250b.getString(r100, null);     // Catch: Throwable -> L30
        if (r106 != null) goto L23;
    L24:
        r101 = true;
    L25:
        if (r101 == false) goto L27;
        j r107 = null;
    L28:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L30
    L33:
        if (Result.m9456isSuccessimpl(r108) == false) goto L38;
        j r109 = (j) r108;     // Catch: Throwable -> L9
        if (r109 == null) goto L38;
        f391252d.put(r100, r109);     // Catch: Throwable -> L9
    L38:
        if (Result.m9455isFailureimpl(r108) == true) goto L41;
        r103 = r108;
    L41:
        j r110 = (j) r103;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r110;
    L27:
        r107 = (j) f391251c.fromJson(r106, j.class);     // Catch: Throwable -> L30
        goto L28
    L23:
        if (r106.length() != 0) goto L25;
    L30:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L9
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L48:
        if (r100.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final synchronized j b(String r100, Function1<? super j, j> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "updateAction");     // Catch: Throwable -> L30
        boolean r102 = true;
        if (r100 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L15;
        monitor-exit(this);
        return null;
    L15:
        j r104 = a(r100);     // Catch: Throwable -> L30
        final j r105 = r101.invoke(r104);     // Catch: Throwable -> L30
        p9a.e r106 = p9a.b.f528329a;     // Catch: Throwable -> L30
        p9a.b.a("CardInfoCache", "updateCardInfo: cardUri = " + r100 + ", updateCardInfo = " + r105);     // Catch: Throwable -> L30
        if (r105 != null) goto L18;
    L28:
        monitor-exit(this);
        return r105;
    L18:
        if (Intrinsics.areEqual(r104, r105) == true) goto L28;
        String r107 = r105.c();     // Catch: Throwable -> L30
        if (r107 != null) goto L22;
    L25:
        if (r102 == false) goto L27;
        FLogger.f375446a.i("CardInfoCache", "card uri is empty");     // Catch: Throwable -> L30
        goto L28
    L27:
        f391252d.put(r105.c(), r105);     // Catch: Throwable -> L30
        CardCacheManager r108 = CardCacheManager.f391235a;     // Catch: Throwable -> L30
        CardCacheManager.b(new k(r105));     // Catch: Throwable -> L30
        goto L28
    L22:
        if (r107.length() == 0) goto L25;
        r102 = false;
        goto L25
    L7:
        if (r100.length() == 0) goto L10;
        r103 = false;
    L30:
        th = move-exception;
        throw th;
    }
}
