package com.bytedance.android.shopping.verify;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.verify.api.AuthApi;
import com.bytedance.android.shopping.verify.api.LawHintRequestListener;
import com.google.gson.Gson;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AuthUtils {
    public static final /* synthetic */ int a = 0;

    public AuthUtils() {
    }

    static {
    }

    public static void b(long r3, CompositeDisposable r5, int r6) {
        Disposable r0 = null;
        if ((r6 & 2) == 0) goto L20;
        r5 = null;
    L20:
        HashMap r7 = g.c();     // Catch: Exception -> L7
        r7.put(g.b(r3), Boolean.FALSE);     // Catch: Exception -> L7
        int r1 = pi3.a.a;     // Catch: Exception -> L7
        String r8 = new Gson().toJson(r7);     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r8, "newValue");     // Catch: Exception -> L7
        q.a.putString("law_hint_map", r8);     // Catch: Exception -> L7
    L9:
        SourceType.Companion.getClass();
        if (SourceType.a.c(r3) == false) goto L12;
    L13:
        int r4 = bl3.e.a;
        com.bytedance.android.ec.sdk.helper.d r9 = com.bytedance.android.ec.sdk.helper.d.b;
        String r10 = r9.getIECHostUserService().getCurrentUserId();
        String r11 = r9.getIECHostAppInfo().getAppId();
        AuthApi.a.getClass();
        AuthApi r2 = AuthApi.a.a;
        if (r2 == null) goto L16;
        r0 = bg4.b.b(r2.authorizeSmallShop(r10, r11, 1L)).subscribe(new bl3.a(null), new bl3.b(null));
    L16:
        if (r0 == null) goto L23;
        if (r5 == null) goto L24;
        r5.add(r0);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        if (SourceType.a.b(r3) == true) goto L13;
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.f(e, "LawPermissionPreHelper");
        goto L9
    }

    public static void a(final Context r11, final long r12, Boolean r14, final Function2 r15) {
        Intrinsics.checkNotNullParameter(r15, "callback");
        if (r14 == null) goto L6;
        r15.invoke(r14, Boolean.FALSE);
        return;
    L6:
        if (r11 != null) goto L9;
        r15.invoke(Boolean.TRUE, Boolean.FALSE);
        return;
    L9:
        final CompositeDisposable r16 = new CompositeDisposable();
        if (ih3.e.a() == false) goto L39;
        final Function1<Boolean, Unit> r7 = new AuthUtils$checkLawHint$1(r12, r11, r16, r15);
        Intrinsics.checkNotNullParameter(r16, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r7, "callBack");
        String r0 = g.b(r12);
        boolean r3 = false;
        if (Intrinsics.areEqual(r0, "unknown_type") == false) goto L14;
        boolean r1 = false;
    L18:
        final boolean r4 = !r1;
        SourceType.Companion.getClass();
        if (SourceType.a.c(r12) == false) goto L21;
    L24:
        String r2 = g.b(r12);
        if (Intrinsics.areEqual(r2, "unknown_type") == true) goto L31;
        Boolean r5 = (Boolean) g.a().get(r2);
        if (r5 != null) goto L30;
        r5 = Boolean.FALSE;
    L30:
        r3 = r5.booleanValue();
    L31:
        if (r3 == false) goto L33;
        r7.invoke(Boolean.FALSE);
    L41:
        if ((r11 instanceof FragmentActivity) == true) goto L43;
        r11 = null;
    L43:
        FragmentActivity r13 = (FragmentActivity) r11;
        if (r13 == null) goto L49;
        Lifecycle r17 = r13.getLifecycle();
        if (r17 == null) goto L50;
        r17.addObserver(new LawHintRequestListener(r16));
        return;
    L50:
        return;
    L49:
        return;
    L33:
        int r6 = bl3.e.a;
        com.bytedance.android.ec.sdk.helper.d r8 = com.bytedance.android.ec.sdk.helper.d.b;
        String r9 = r8.getIECHostUserService().getCurrentUserId();
        String r10 = r8.getIECHostAppInfo().getAppId();
        Function1<Boolean, Unit> r18 = new AuthUtils$needToShowLawHint$1(r7, r12, r4, r16);
        Intrinsics.checkNotNullParameter(r18, "callBack");
        AuthApi.a.getClass();
        AuthApi r19 = AuthApi.a.a;
        if (r19 == null) goto L36;
        Disposable r110 = bg4.b.b(r19.getAuthStatus(r9, r10)).subscribe(new bl3.c(r18), new bl3.d(r18));
    L37:
        if (r110 == null) goto L41;
        r16.add(r110);
        goto L41
    L36:
        r18.invoke(Boolean.FALSE);
        r110 = null;
        goto L37
    L21:
        if (SourceType.a.b(r12) == true) goto L24;
        r7.invoke(Boolean.valueOf(!r4));
        goto L41
    L14:
        Boolean r20 = (Boolean) g.c().get(r0);
        if (r20 != null) goto L17;
        r20 = Boolean.TRUE;
    L17:
        r1 = r20.booleanValue();
        goto L18
    L39:
        r15.invoke(Boolean.TRUE, Boolean.FALSE);
        goto L41
    }
}
