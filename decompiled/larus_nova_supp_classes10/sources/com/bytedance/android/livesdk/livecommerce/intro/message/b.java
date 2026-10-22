package com.bytedance.android.livesdk.livecommerce.intro.message;

import bk2.d;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.intro.manager.r;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.n;
import com.bytedance.android.livesdk.livecommerce.room.model.e;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final g a;
    public Disposable b;
    public final e c;
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.c d;
    public final r e;
    public final RoomContextController f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public a(b r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            LiveIntroResponse r4 = (LiveIntroResponse) r3;
            int r0 = k.a;
            k.c("[refresh] " + this.b + " success, statusCode=" + ((com.bytedance.android.ec.model.g) r4).statusCode);
            this.a.d.d(r4);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.message.b$b, reason: collision with other inner class name */
    public static final class C0067b<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;

        public C0067b(String r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = k.a;
            k.b("[refresh] " + this.a + " failed, msg: " + r4.getMessage());
            ECExceptionMonitor.e(r4);
        }
    }

    public final void a(String r11, Map<String, String> r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r11, "path");
        Intrinsics.checkNotNullParameter(r12, "extraParams");
        Intrinsics.checkNotNullParameter(r13, "promotionIds");
        n r14 = this.f.A().q;
        dm.a.b r0 = dm.a.a;
        dm.a.a("isCanChangeExplainCard = " + r14.m);
        JSONObject r1 = new JSONObject();
        r1.put("is_change", 1);
        Unit r2 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.explainCard.change", r1);
        if (r14.m == false) goto L11;
        ECContext r15 = this.f.r();
        if (r15 == null) goto L12;
        Disposable r3 = this.b;
        if (r3 == null) goto L9;
        r3.dispose();
    L9:
        this.b = bk2.c.a(bg4.b.b(this.e.a(this.c, IntroCardScene.REFRESH_MESSAGE, false, false, null, null, r11, r12)).subscribe(new a(this, r11, r12), new C0067b(r11, r12)), (d) r15.getDisposableContext().getValue());
        return;
    L12:
        return;
    }

    public b(e r2, com.bytedance.android.livesdk.livecommerce.intro.manager.c r3, r r4, RoomContextController r5) {
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
}
