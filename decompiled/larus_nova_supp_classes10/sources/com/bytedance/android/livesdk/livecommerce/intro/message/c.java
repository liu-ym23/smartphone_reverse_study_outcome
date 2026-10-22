package com.bytedance.android.livesdk.livecommerce.intro.message;

import bk2.d;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.intro.manager.r;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.model.e;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final g a;
    public Disposable b;
    public final e c;
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.c d;
    public final r e;
    public final RoomContextController f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ Function1 d;

        public a(c r1, String r2, Map r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r3) {
            LiveIntroResponse r4 = (LiveIntroResponse) r3;
            int r0 = k.a;
            k.c("[refresh] " + this.b + " success, statusCode=" + ((com.bytedance.android.ec.model.g) r4).statusCode);
            this.a.d.d(r4);
            Function1 r1 = this.d;
            if (r1 == null) goto L6;
            Unit r5 = (Unit) r1.invoke(r4);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Function1 c;

        public b(String r1, Map r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = k.a;
            k.b("[refresh] " + this.a + " failed, msg: " + r4.getMessage());
            ECExceptionMonitor.e(r4);
        }
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "promotionId");
        List<uh2.a> r0 = this.d.b();
        if (r0 == null) goto L6;
        this.d.f(r0);
        v r1 = new v("livesdk_hot_atmosphere_message_received", com.bytedance.android.ec.common.api.jump.model.b.a);
        r1.c("promotion_id", r4);
        r1.c("use_new_message", "1");
        r1.c("scene", "promotion_card");
        r1.c("handled", "1");
        r1.i(null);
        return;
    }

    public c(e r2, com.bytedance.android.livesdk.livecommerce.intro.manager.c r3, r r4, RoomContextController r5) {
        Intrinsics.checkNotNullParameter(r2, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r3, "introCardManager");
        Intrinsics.checkNotNullParameter(r4, "repository");
        Intrinsics.checkNotNullParameter(r5, "roomContextController");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new g();
    }

    public final void b(String r11, Map<String, String> r12, List<String> r13, Function1<? super LiveIntroResponse, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "path");
        Intrinsics.checkNotNullParameter(r12, "extraParams");
        Intrinsics.checkNotNullParameter(r13, "promotionIds");
        ECContext r15 = this.f.r();
        if (r15 == null) goto L9;
        Disposable r0 = this.b;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        this.b = bk2.c.a(bg4.b.b(this.e.a(this.c, IntroCardScene.REFRESH_MESSAGE, false, false, null, null, r11, r12)).subscribe(new a(this, r11, r12, r14), new b(r11, r12, r14)), (d) r15.getDisposableContext().getValue());
        return;
    }
}
