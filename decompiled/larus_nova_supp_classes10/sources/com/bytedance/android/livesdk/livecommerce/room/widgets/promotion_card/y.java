package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y {
    public static final boolean j = false;
    public static final boolean k = false;
    public static final boolean l = false;
    public static final boolean m = false;
    public static final HashMap<String, y> n = null;
    public static final a o = null;
    public boolean a;
    public Long b;
    public Long c;
    public ECUIPromotion d;
    public volatile boolean e;
    public Disposable f;
    public volatile Function1<? super ECUIPromotion, Unit> g;
    public boolean h;
    public WeakReference<Context> i;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y$a$a, reason: collision with other inner class name */
        public static final class C0118a extends BaseRequestListener {
            public C0118a() {
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
                OptCardUtil.b("image", "botton prefetch success");
            }

            public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
                super.onRequestStart(r1, r2, r3, r4);
                OptCardUtil.b("image", "botton prefetch start");
            }
        }

        public static final class c extends BaseRequestListener {
            public c() {
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

        public static final class d extends BaseRequestListener {
            public d() {
            }

            public final void onRequestSuccess(ImageRequest r1, String r2, boolean r3) {
                super.onRequestSuccess(r1, r2, r3);
                OptCardUtil.b("image", "activity prefetch success");
            }

            public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
                super.onRequestStart(r1, r2, r3, r4);
                OptCardUtil.b("image", "activity prefetch start");
            }
        }

        public a() {
        }

        public static y a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "roomId");
            HashMap<String, y> r0 = y.n;
            y r1 = r0.get(r3);
            if (r1 != null) goto L6;
            y r2 = new y();
            y.o.getClass();
            r0.put(r3, r2);
            return r2;
        L6:
            return r1;
        }

        public static void b(ECUIPromotion r14) {
            Intrinsics.checkNotNullParameter(r14, "promotion");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
            String r1 = r14.imageUrl;     // Catch: Throwable -> L14
            int r2 = com.bytedance.android.ec.core.imagex.r.h;     // Catch: Throwable -> L14
            com.bytedance.android.ec.core.imagex.r r3 = com.bytedance.android.ec.core.imagex.r.a.b("goods_card_view");     // Catch: Throwable -> L14
            Priority r4 = Priority.IMMEDIATE;     // Catch: Throwable -> L14
            ImageExtensionsKt.B(r1, r3, null, null, r4, new C0118a(), null, false, 192);     // Catch: Throwable -> L14
            y.o.getClass();     // Catch: Throwable -> L14
            if (y.m == true) goto L6;
            return;
        L6:
            ImageExtensionsKt.B(r14.normalBottonIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_botton_normal_view"), null, null, r4, new b(), null, false, 192);     // Catch: Throwable -> L14
            ImageExtensionsKt.B(r14.qIvIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_up_view"), null, null, r4, new c(), null, false, 192);     // Catch: Throwable -> L14
            ECUISmallPopCard r15 = r14.smallPopCard;     // Catch: Throwable -> L14
            if (r15 == null) goto L11;
            String r5 = r15.backgroundImgNew;     // Catch: Throwable -> L14
            if (r5 == null) goto L11;
            ImageExtensionsKt.B(r5, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_activity_view"), null, null, r4, new d(), null, false, 192);     // Catch: Throwable -> L14
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L14
        L12:
            Result.constructor-impl(r16);     // Catch: Throwable -> L14
            return;
        L11:
            r16 = null;
        L14:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public y() {
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
