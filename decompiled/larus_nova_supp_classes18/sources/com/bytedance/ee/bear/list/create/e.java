package com.bytedance.ee.bear.list.create;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ m b;

        public a(String r1, m r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            HashMap r0 = new HashMap();
            r0.put("action", this.a);
            r0.put("item", "create");
            r0.put("sub_item", "create_new_objs");
            r0.put("source", this.b.a.c);
            if (TextUtils.isEmpty(this.b.a.b) == true) goto L5;
            r0.put("module", this.b.a.b);
        L5:
            r6.v("client_commerce", r0);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            tt5.a.l("CreateErrorDialogUtils", "reportCreateExceedQuotaEvent ", (Throwable) r3);
        }
    }

    static {
    }

    public e() {
    }

    public static final void a(Context r2, NetService r3) {
        tt5.a.h("CreateErrorDialogUtils", "executeRemindAdmin()");
        NetService.d r4 = r3.Vc(new ax4.f());
        NetService.f r0 = new NetService.f("/api/explorer/lark/notifysuitebot/");
        ((NetService.e) r0).c = 2;
        r4.a(r0).subscribe(new c(r2), new d(r2));
    }

    @JvmStatic
    public static final void b(m r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "createInfo");
        Intrinsics.checkNotNullParameter(r3, "action");
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new a(r3, r2), b.a);
    }
}
