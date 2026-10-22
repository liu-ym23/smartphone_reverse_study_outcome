package com.bytedance.ee.bear.share;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            SimpleRequestResult r11 = (SimpleRequestResult) r10;
            Intrinsics.checkNotNullParameter(r11, "result");
            JSONObject r12 = ((Result) r11).data;
            String r1 = null;
            if ((r12 instanceof JSONObject) == false) goto L5;
            JSONObject r13 = r12;
        L6:
            if (r13 == null) goto L8;
            Object r14 = r13.get("summary");
        L10:
            if ((r14 instanceof String) == false) goto L12;
            String r15 = (String) r14;
        L13:
            if (r15 == null) goto L17;
            String r3 = r15.substring(0, RangesKt.coerceAtMost(30, r15.length()));
            if (r3 == null) goto L17;
            r1 = StringsKt.replace$default(r3, "\n", " ", false, 4, null);
        L17:
            this.a.invoke(r1);
            return;
        L12:
            r15 = null;
            goto L13
        L8:
            r14 = null;
            goto L10
        L5:
            r13 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f("ShareUtils", (Throwable) r3, false);
            this.a.invoke(null);
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(NetService r2, String r3, String r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "cb");
        NetService.f r0 = new NetService.f("/space/api/summary/");
        ((NetService.e) r0).c = 2;
        r0.b("obj_type", r3);
        r0.b(ResourceData.KEY_OBJ_TOKEN, r4);
        r2.Vc(new ax4.f()).a(r0).subscribe(new a(r5), new b(r5));
    }
}
