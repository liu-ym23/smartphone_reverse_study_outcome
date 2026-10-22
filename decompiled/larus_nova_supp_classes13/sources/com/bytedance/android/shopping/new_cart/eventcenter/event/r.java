package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r implements ti.j {
    public final /* synthetic */ SelfSubscribeBridgeEvent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e c;
    public final /* synthetic */ String d;

    public static final class a implements Runnable {
        public final /* synthetic */ AndroidYaTaInstance a;
        public final /* synthetic */ r b;
        public final /* synthetic */ JSONObject c;

        public a(AndroidYaTaInstance r1, r r2, JSONObject r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            YataEventCenter r0 = this.a.k();
            com.bytedance.kmp.ec.yata.event.common.e.a r1 = com.bytedance.kmp.ec.yata.event.common.e.a;
            AndroidYaTaInstance r2 = this.a;
            String r4 = this.b.c.k();
            String r5 = this.b.d;
            Map r6 = z1.k(this.c);
            String r7 = this.b.d;
            if (r7 != null) goto L5;
            r7 = "yata_event_name";
        L5:
            r0.d(r1.a(r2, null, r4, r5, r6, r7));
        }

        @Override // java.lang.Runnable
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
    }

    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        AndroidYaTaInstance r0 = (AndroidYaTaInstance) this.a.b.e.d.invoke();
        bg3.a r1 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c((CartViewModel) this.a.a.getValue(), String.valueOf(this.b), new a(r0, this, r5), null);
    }

    public r(SelfSubscribeBridgeEvent r1, String r2, com.bytedance.kmp.ec.yata.event.core.a r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
