package com.obric.aiagent.assistant_card.provider_core;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant_card.provider_core.service.CardProviderService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import p9a.e;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.obric.aiagent.assistant_card.provider_core.a> f384640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f384641b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile IHostApi f384642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Context f384643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f384644e = null;

    public static final class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied(IBinder r100) {
            Intrinsics.checkNotNullParameter(r100, "who");
            super.binderDied(r100);
            e r101 = p9a.b.f528329a;
            p9a.b.a("CardProviderManager", "binderDied: " + r100);
            ConcurrentHashMap<String, com.obric.aiagent.assistant_card.provider_core.a> r102 = c.f384640a;
            c.f384642c = null;
        }
    }

    public c() {
    }

    static {
        f384640a = new ConcurrentHashMap();
        f384641b = LazyKt.lazy(new b());
        f384644e = new a();
    }

    public static final void a(Uri r100, JSONObject r101) {
        e r102 = p9a.b.f528329a;
        p9a.b.a("CardProviderManager", "notifyWithCP: cardUri = " + r100 + ", cardParams = " + r101);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Context r104 = f384643d;     // Catch: Throwable -> L13
        Bundle r105 = null;
        String r106 = null;
        r105 = null;
        if (r104 == null) goto L11;
        ContentResolver r107 = r104.getContentResolver();     // Catch: Throwable -> L13
        if (r107 == null) goto L11;
        Uri r108 = p9a.a.f528328a;     // Catch: Throwable -> L13
        Bundle r109 = new Bundle();     // Catch: Throwable -> L13
        r109.putString("card_uri", r100.toString());     // Catch: Throwable -> L13
        if (r101 == null) goto L10;
        r106 = r101.toString();     // Catch: Throwable -> L13
    L10:
        r109.putString("card_extra_params", r106);     // Catch: Throwable -> L13
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r105 = r107.call(r108, "notify_card_change", "", r109);     // Catch: Throwable -> L13
    L11:
        Object r111 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L15:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L19;
        e r113 = p9a.b.f528329a;
        p9a.b.c("CardProviderManager", "notifyWithCP failed: " + r112.getMessage(), r112);
    L19:
        if (Result.m9456isSuccessimpl(r111) == false) goto L24;
        Bundle r114 = (Bundle) r111;
        p9a.b.a("CardProviderManager", "notifyWithCP succeed");
        return;
    L24:
        return;
    L13:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void c(CardProviderService r100, IHostApi r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        e r102 = p9a.b.f528329a;
        p9a.b.a("CardProviderManager", "setHostApi: " + r101);
        BuildersKt.launch$default((CoroutineScope) f384641b.getValue(), null, null, new CardProviderManager$setHostApi$1(r101, null), 3, null);
    }

    public static void b(CardProviderService r100, Uri r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardUri");
        Intrinsics.checkNotNullParameter(r102, "cardAction");
        e r103 = p9a.b.f528329a;
        p9a.b.a("CardProviderManager", "handleCardAction: " + r101 + ", " + r102);
        BuildersKt.launch$default((CoroutineScope) f384641b.getValue(), null, null, new CardProviderManager$handleCardAction$1(r102, r101, r100, null), 3, null);
    }
}
