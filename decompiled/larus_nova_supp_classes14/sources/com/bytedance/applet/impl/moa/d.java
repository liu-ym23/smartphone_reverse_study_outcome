package com.bytedance.applet.impl.moa;

import android.os.Looper;
import com.bytedance.ai.applet.moa.MoaGrantingResult;
import com.bytedance.ai.applet.moa.i;
import com.bytedance.ai.applet.moa.k;
import com.bytedance.ai.applet.moa.l;
import com.bytedance.ai.applet.moa.m;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.quickreply.MoaGrantingDecision;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final d a = null;
    public static final CoroutineScope b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MoaGrantingResult.values().length];
            r0[MoaGrantingResult.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MoaGrantingResult.REFUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MoaGrantingResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public d() {
    }

    static {
        a = new d();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public static void a(mi8.g r8) {
        int r0 = f.a;
        e r1 = f.a(r8.a);
        if (r1 != null) goto L9;
        FLogger.a.e("MoaGrantingApplet", "operate failed: invalid MOA payload, msgId=" + r8.c.a);
        Function0 r9 = r8.e;
        if (r9 == null) goto L27;
        r9.invoke();
        return;
    L27:
        return;
    L9:
        if (r8.b != MoaGrantingDecision.UNSUPPORTED) goto L14;
        FLogger.a.e("MoaGrantingApplet", "operate failed: unsupported MOA decision, authorizationID=" + r1.b);
        Function0 r10 = r8.e;
        if (r10 == null) goto L28;
        r10.invoke();
        return;
    L28:
        return;
    L14:
        m r2 = b(r1, r8.e);
        if (r2 != null) goto L17;
        return;
    L17:
        k r3 = k.a;
        String r4 = r2.a;
        String r5 = r2.b;
        if (r8.b != MoaGrantingDecision.ALLOW) goto L20;
        boolean r6 = true;
    L21:
        WeakReference r7 = r8.d;
        Function0 r11 = r8.e;
        r3.getClass();
        if (k.i(r4, r5, r6, r7, r11) == true) goto L29;
        FLogger.a.e("MoaGrantingApplet", "operate rejected by SDK, authorizationID=" + r2.b);
        Function0 r12 = r8.e;
        if (r12 == null) goto L30;
        r12.invoke();
        return;
    L30:
        return;
    L29:
        return;
    L20:
        r6 = false;
        goto L21
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ai.applet.moa.f, com.bytedance.applet.impl.moa.a, java.lang.Object] */
    public static m b(final e r9, final Function0 r10) {
        ?? r6 = new com.bytedance.applet.impl.moa.a(r9, r10);
        String r0 = r9.c;
        String r1 = r9.a;
        if (r1 != null) goto L5;
    L11:
        m r2 = null;
    L12:
        if (r0 == null) goto L85;
        if (r2 == null) goto L85;
        k.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "authExt");
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "prepareMoaGrantingData must be called on the main thread");
        r6.a(r2, MoaGrantingResult.FAILED);
        return null;
    L18:
        String r11 = StringsKt.trim(r2.a).toString();
        String r3 = StringsKt.trim(r2.b).toString();
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r3, "authorizationID");
        m r4 = new m(r11, r3);
        String r12 = r4.a;
        String r5 = r4.b;
        if (StringsKt.isBlank(r12) == false) goto L21;
    L83:
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "prepareMoaGrantingData: appletId or authorizationID is blank");
        r6.a(r4, MoaGrantingResult.FAILED);
        return null;
    L21:
        if (StringsKt.isBlank(r5) == true) goto L83;
        i r8 = new i(r12, r5);
        if (k.e.contains(r8) == false) goto L26;
        com.bytedance.ai.utils.g.a.i("MoaGrantingManager", "Prepare retry for completed authorizationID=" + r5 + ", appletId=" + r12);
    L26:
        com.bytedance.ai.applet.moa.g r7 = (com.bytedance.ai.applet.moa.g) k.c.get(r8);
        if (r7 == null) goto L33;
        if (k.f(r7, r8) == true) goto L31;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "MOA session identity does not match its composite key");
        k.h(r4, MoaGrantingResult.FAILED, r6);
        return null;
    L31:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r7.f = r6;
        return r7.b;
    L33:
        if (StringsKt.isBlank(r0) == false) goto L88;
        k.b r13 = null;
    L46:
        if (r13 == null) goto L48;
        u2.e r14 = r13.a;
    L49:
        if (r14 == null) goto L53;
        String r15 = r14.d();
        if (r15 == null) goto L53;
        String r16 = StringsKt.trim(r15).toString();
    L54:
        if (r16 != null) goto L56;
        r16 = "";
    L56:
        if (r14 == null) goto L65;
        List r17 = r14.h();
        if (r17 == null) goto L65;
        if (r17.isEmpty() == false) goto L63;
        r17 = null;
    L63:
        if (r17 == null) goto L65;
        List r18 = CollectionsKt.sortedWith(r17, new l());
    L66:
        if (r13 == null) goto L82;
        if (r14 == null) goto L82;
        if (r18 == null) goto L82;
        if (StringsKt.isBlank(r16) == false) goto L74;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "prepareMoaGrantingData: appletId is blank");
        k.h(r4, MoaGrantingResult.FAILED, r6);
        return null;
    L74:
        if (Intrinsics.areEqual(r12, r16) == true) goto L76;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "prepareMoaGrantingData: request appletId does not match granting data");
        k.h(r4, MoaGrantingResult.FAILED, r6);
        return null;
    L76:
        com.bytedance.ai.applet.moa.g r19 = new com.bytedance.ai.applet.moa.g(r8, r4, r14, r18, r13.b, r6);
        ConcurrentHashMap r110 = k.c;
        r110.put(r8, r19);
        k.b(r19);
        if (r19.a() != null) goto L79;
        k.c(r19, MoaGrantingResult.GRANTED);
        return null;
    L79:
        com.bytedance.ai.applet.moa.g r20 = (com.bytedance.ai.applet.moa.g) r110.get(r8);
        if (r20 != null) goto L97;
        return null;
    L97:
        return r20.b;
    L82:
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "prepareMoaGrantingData: auth Ext is invalid");
        k.h(r4, MoaGrantingResult.FAILED, r6);
        return null;
    L65:
        r18 = null;
    L53:
        r16 = null;
        goto L54
    L48:
        r14 = null;
        goto L49
    L88:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L37
        Lazy r22 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L37
        Object r23 = Result.constructor-impl(k.j((JsonObject) com.bytedance.ai.applet.base.gson.e.a(r0, JsonObject.class)));     // Catch: Throwable -> L37
    L39:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L43;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "Failed to parse auth Ext", r24);
    L43:
        if (Result.isFailure-impl(r23) == false) goto L45;
        r23 = null;
    L45:
        r13 = (k.b) r23;
    L37:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L85:
        if (r10 == null) goto L87;
        r10.invoke();
    L87:
        return null;
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L11;
        r2 = new m(r1, r9.b);
        goto L12
    }
}
