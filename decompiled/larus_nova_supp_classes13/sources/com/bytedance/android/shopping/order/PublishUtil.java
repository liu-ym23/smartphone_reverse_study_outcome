package com.bytedance.android.shopping.order;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.o;
import com.bytedance.android.shopping.anchorv3.comment.helper.ShowOrderSource;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.order.api.OrderApi;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PublishUtil {
    public static final Handler a = null;

    public static final class a extends TimerTask {
        public final /* synthetic */ JSONObject a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.order.PublishUtil$a$a, reason: collision with other inner class name */
        public static final class RunnableC0138a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0138a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
                r0.put("eventName", "ecPostCommentVideo");     // Catch: Throwable -> L4
                r0.put("data", this.a.a);     // Catch: Throwable -> L4
                Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L4
                ECLiveHybridUtil.f("notification", r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a() {
            vi.a r0 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo();
            JSONObject r1 = new JSONObject();
            r1.put("eventName", "ecPostCommentVideo");
            r1.put("data", this.a);
            Unit r2 = Unit.INSTANCE;
            r0.d(r1);
            Handler r3 = PublishUtil.a;
            PublishUtil.a.post(new RunnableC0138a(this));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(JSONObject r1) {
            this.a = r1;
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r3, Object r4) {
            cg3.h r5 = (cg3.h) r3;
            cg3.d r6 = (cg3.d) r4;
            Intrinsics.checkNotNullParameter(r5, "shareInfoResponseDTO");
            Intrinsics.checkNotNullParameter(r6, "commentPublishResponseDTO");
            cg3.e r7 = r5.a();
            if (r7 != null) goto L6;
            r7 = new cg3.e(0);
        L6:
            return new cg3.c(r7, r6);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ cg3.e a;

        public c(cg3.e r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            cg3.d r4 = (cg3.d) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            return new cg3.c(this.a, r4);
        }
    }

    public static final class d extends TimerTask {
        public final /* synthetic */ JSONObject a;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
                r0.put("eventName", "ecPostCommentVideoTask");     // Catch: Throwable -> L4
                r0.put("data", this.a.a);     // Catch: Throwable -> L4
                Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L4
                ECLiveHybridUtil.f("notification", r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a() {
            vi.a r0 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo();
            JSONObject r1 = new JSONObject();
            r1.put("eventName", "ecPostCommentVideoTask");
            r1.put("data", this.a);
            Unit r2 = Unit.INSTANCE;
            r0.d(r1);
            Handler r3 = PublishUtil.a;
            PublishUtil.a.post(new a(this));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(JSONObject r1) {
            this.a = r1;
        }
    }

    public PublishUtil() {
    }

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static String b(cg3.f r2) {
        StringBuilder r0 = new StringBuilder("{\"order_id\":\"");
        if (r2 == null) goto L5;
        Long r3 = r2.d();
    L6:
        r0.append(r3);
        r0.append("\",\"show_order_source\":\"");
        r0.append(ShowOrderSource.COMMENT_PUBLISH_SHOW_ORDER.getSource());
        r0.append("\"}");
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public static Observable c(cg3.g r17, cg3.f r18) {
        OrderApi.a.getClass();
        OrderApi r2 = OrderApi.a.a;
        if (r17 == null) goto L5;
        Long r3 = r17.a;
    L6:
        if (r17 == null) goto L8;
        Long r4 = r17.b;
    L9:
        if (r17 == null) goto L11;
        Long r5 = r17.c;
    L12:
        if (r18 == null) goto L14;
        Long r6 = r18.q();
    L15:
        if (r18 == null) goto L17;
        String r7 = r18.a();
    L18:
        if (r18 == null) goto L20;
        Long r8 = r18.b();
    L21:
        if (r18 == null) goto L23;
        Long r9 = r18.d();
    L24:
        if (r18 == null) goto L26;
        Long r10 = r18.g();
    L27:
        if (r18 == null) goto L29;
        Long r11 = r18.j();
    L30:
        if (r18 == null) goto L32;
        Long r12 = r18.k();
    L33:
        if (r18 == null) goto L35;
        Long r13 = r18.l();
    L36:
        if (r18 == null) goto L38;
        String r14 = r18.e();
    L39:
        if (r18 == null) goto L41;
        String r15 = r18.p();
    L42:
        if (r18 == null) goto L44;
        Boolean r16 = r18.c();
    L46:
        return r2.publishComment(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16).subscribeOn(Schedulers.io());
    L44:
        r16 = null;
        goto L46
    L41:
        r15 = null;
        goto L42
    L38:
        r14 = null;
        goto L39
    L35:
        r13 = null;
        goto L36
    L32:
        r12 = null;
        goto L33
    L29:
        r11 = null;
        goto L30
    L26:
        r10 = null;
        goto L27
    L23:
        r9 = null;
        goto L24
    L20:
        r8 = null;
        goto L21
    L17:
        r7 = null;
        goto L18
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public static void f(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "awemeId");
        JSONObject r0 = new JSONObject();
        r0.put(SimilarProductParam.AWEME_ID, r3);
        r0.put("motivate_ret", r4);
        JSONObject r5 = new JSONObject();
        r5.put("data", r0);
        int r1 = 0;
        if (r3.length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        r1 = -1;
    L8:
        r5.put("code", r1);
        new PthreadTimer("r/PublishUtil").schedule(new d(r5), 1000);
        return;
    L5:
        r6 = false;
        goto L6
    }

    public static void a(final String r8, String r9, String r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        boolean r0 = true;
        if (r10 != null) goto L7;
    L11:
        int r11 = ECSdk.a;
        s83.g r1 = (s83.g) ECSdk.a(s83.g.class);
        if (r1 == null) goto L14;
        r1.L(r8, "", "", null, null);
    L14:
        JSONObject r12 = new JSONObject();
        r12.put(SimilarProductParam.AWEME_ID, r8);
        JSONObject r13 = new JSONObject();
        int r2 = 0;
        if (r8.length() == 0) goto L18;
        r0 = false;
    L18:
        if (r0 == false) goto L20;
        r2 = -1;
    L20:
        r13.put("code", r2);
        r13.put("data", r12);
        new PthreadTimer("r/PublishUtil").schedule(new a(r13), 1000);
        return;
    L7:
        if (k.c(r10) != true) goto L11;
        int r3 = ECSdk.a;
        s83.g r4 = (s83.g) ECSdk.a(s83.g.class);
        if (r4 == null) goto L14;
        r4.L(r8, r9, r10, new PublishUtil$broadcast$1(r8), new PublishUtil$broadcast$2(r8));
        goto L14
    }

    public static void e(Context r10, cg3.k r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "param");
        cg3.e r0 = r11.a;
        cg3.f r1 = r11.b;
        String r2 = r11.c;
        String r3 = r11.d;
        Object r4 = r11.e;
        Function2<Boolean, String, Unit> r13 = r11.f;
        JSONObject r5 = new JSONObject();
        String r6 = "";
        if (r0 == null) goto L6;
        String r7 = r0.c();
        if (r7 == null) goto L6;
    L7:
        r5.put("anchor_title", r7);
        if (r0 == null) goto L13;
        String r8 = r0.b();
        if (r8 == null) goto L13;
        r6 = r8;
    L13:
        r5.put("anchor_description", r6);
        String r9 = null;
        if (r1 == null) goto L18;
        Long r14 = r1.g();
        if (r14 == null) goto L18;
        String r15 = String.valueOf(r14.longValue());
    L19:
        r5.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r15);
        String r16 = r5.toString();
        o r17 = o.a;
        Bundle r18 = new Bundle();
        r18.putString("local_video_path", r2);
        r18.putString("music_id", r3);
        if (r1 == null) goto L24;
        Long r19 = r1.g();
        if (r19 == null) goto L24;
        String r20 = String.valueOf(r19.longValue());
    L25:
        r18.putString("anchor_id", r20);
        r18.putString("content", r16);
        if (r12 == false) goto L31;
        if (r1 == null) goto L29;
        String r110 = r1.a();
    L30:
        r18.putString("text", r110);
        goto L31
    L29:
        r110 = null;
    L31:
        if (r0 == null) goto L35;
        Integer r111 = r0.a();
        if (r111 == null) goto L35;
        r9 = String.valueOf(r111.intValue());
    L35:
        r18.putString("rank_type", r9);
        r18.putInt("story_source_type", 10);
        r18.putString("shaidan_source_page", "comment_edit_page");
        r18.putString("activity_extra_json", b(r1));
        Unit r112 = Unit.INSTANCE;
        r17.d(r10, r18, r4, r13);
        return;
    L24:
        r20 = null;
    L18:
        r15 = null;
    L6:
        r7 = "";
        goto L7
    }

    public static Observable d(cg3.g r10, tl.a r11, cg3.e r12, Function1 r13) {
        if (r13 == null) goto L4;
        Unit r14 = (Unit) r13.invoke(Boolean.TRUE);
    L4:
        String r15 = null;
        if (r10 == null) goto L9;
        List<cg3.f> r0 = r10.d;
        if (r0 == null) goto L9;
        cg3.f r1 = (cg3.f) CollectionsKt.firstOrNull(r0);
    L10:
        if (r12 != null) goto L38;
        OrderApi.a.getClass();
        OrderApi r2 = OrderApi.a.a;
        if (r11 == null) goto L14;
        Long r3 = r11.a;
    L15:
        if (r11 == null) goto L17;
        Long r4 = r11.b;
    L18:
        if (r11 == null) goto L20;
        String r5 = r11.c;
    L21:
        if (r11 == null) goto L23;
        Long r6 = r11.d;
    L24:
        if (r11 == null) goto L26;
        Long r7 = r11.e;
    L27:
        if (r11 == null) goto L29;
        Long r8 = r11.f;
    L30:
        if (r11 == null) goto L32;
        String r9 = r11.g;
    L33:
        if (r11 == null) goto L36;
        r15 = r11.h;
    L36:
        return Observable.zip(r2.getShareInfo(r3, r4, r5, r6, r7, r8, r9, r15).subscribeOn(Schedulers.io()), c(r10, r1), b.a);
    L32:
        r9 = null;
        goto L33
    L29:
        r8 = null;
        goto L30
    L26:
        r7 = null;
        goto L27
    L23:
        r6 = null;
        goto L24
    L20:
        r5 = null;
        goto L21
    L17:
        r4 = null;
        goto L18
    L14:
        r3 = null;
        goto L15
    L38:
        return c(r10, r1).map(new c(r12));
    L9:
        r1 = null;
        goto L10
    }
}
