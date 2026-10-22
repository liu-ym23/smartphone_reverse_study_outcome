package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntro;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final boolean j = false;
    public static final boolean k = false;
    public static final boolean l = false;
    public static final boolean m = false;
    public static final HashMap<String, f> n = null;
    public static final a o = null;
    public boolean a;
    public Long b;
    public Long c;
    public LiveIntroResponse d;
    public volatile boolean e;
    public Disposable f;
    public volatile Function1<? super LiveIntroResponse, Unit> g;
    public boolean h;
    public WeakReference<Context> i;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.utils.f$a$a, reason: collision with other inner class name */
        public static final class C0068a extends BaseRequestListener {
            public C0068a() {
            }

            public final void onRequestSuccess(ImageRequest r1, String r2, boolean r3) {
                super.onRequestSuccess(r1, r2, r3);
                OptCardUtil.b("image", "prefetch success");
            }

            public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
                super.onRequestStart(r1, r2, r3, r4);
                OptCardUtil.b("image", "prefetch start");
            }
        }

        public static final class b extends BaseRequestListener {
            public b() {
            }

            public final void onRequestSuccess(ImageRequest r1, String r2, boolean r3) {
                super.onRequestSuccess(r1, r2, r3);
                OptCardUtil.b("image", "up prefetch success");
            }

            public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
                super.onRequestStart(r1, r2, r3, r4);
                OptCardUtil.b("image", "up prefetch start");
            }
        }

        public a() {
        }

        public static void a(LiveIntroResponse r11) {
            Intrinsics.checkNotNullParameter(r11, "liveIntroResp");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L38
            List<LiveIntro> r12 = r11.getIntros();     // Catch: Throwable -> L38
            if (r12 == null) goto L35;
            Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L38
        L7:
            if (r13.hasNext() == false) goto L34;
            LiveIntro r1 = (LiveIntro) r13.next();     // Catch: Throwable -> L38
            if (r1.c() != 1) goto L7;
            t0 r2 = r1.d();     // Catch: Throwable -> L38
            if (r2 == null) goto L18;
            u r3 = r2.i();     // Catch: Throwable -> L38
            if (r3 == null) goto L18;
            String r4 = r3.c();     // Catch: Throwable -> L38
            if (r4 == null) goto L18;
            int r5 = r.h;     // Catch: Throwable -> L38
            ImageExtensionsKt.B(r4, r.a.b("ec_live_intro_card_image"), null, null, Priority.IMMEDIATE, new C0068a(), null, false, 192);     // Catch: Throwable -> L38
        L18:
            t0 r6 = r1.d();     // Catch: Throwable -> L38
            if (r6 == null) goto L7;
            u r7 = r6.i();     // Catch: Throwable -> L38
            if (r7 == null) goto L7;
            List<t> r8 = r7.d();     // Catch: Throwable -> L38
            if (r8 == null) goto L7;
            Iterator<T> r9 = r8.iterator();     // Catch: Throwable -> L38
        L26:
            if (r9.hasNext() == false) goto L7;
            t1 r10 = ((t) r9.next()).c();     // Catch: Throwable -> L38
            if (r10 == null) goto L26;
            List r14 = r10.b();     // Catch: Throwable -> L38
            if (r14 == null) goto L26;
            String r15 = (String) CollectionsKt.firstOrNull(r14);     // Catch: Throwable -> L38
            if (r15 == null) goto L26;
            int r16 = r.h;     // Catch: Throwable -> L38
            ImageExtensionsKt.B(r15, r.a.b("ec_live_intro_card_upper_left_image"), null, null, Priority.IMMEDIATE, new b(), null, false, 192);     // Catch: Throwable -> L38
            goto L26
        L34:
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L38
        L36:
            Result.constructor-impl(r17);     // Catch: Throwable -> L38
            return;
        L35:
            r17 = null;
        L38:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public f() {
    }

    static {
        o = new a();
        boolean r1 = false;
        if (EComABUtils.cardLoadOptV3Api() != 1) goto L5;
        boolean r0 = true;
    L6:
        j = r0;
        if (EComABUtils.cardLoadOptV3Layout() != 1) goto L9;
        boolean r2 = true;
    L10:
        k = r2;
        if (EComABUtils.cardLoadOptV3Event() != 1) goto L13;
        boolean r3 = true;
    L14:
        l = r3;
        if (EComABUtils.cardLoadOptV3Image() != 1) goto L17;
        r1 = true;
    L17:
        m = r1;
        n = new HashMap();
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final WeakReference<Context> getContext() {
        return this.i;
    }
}
