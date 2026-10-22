package com.bytedance.ee.bear.list.create;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f227721a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f227722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f227723b;

        public a(String r100, m r101) {
            this.f227722a = r100;
            this.f227723b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            HashMap r103 = new HashMap();
            r103.put("action", this.f227722a);
            r103.put(MapController.ITEM_LAYER_TAG, "create");
            r103.put("sub_item", "create_new_objs");
            r103.put("source", this.f227723b.f227762a.f496181c);
            if (TextUtils.isEmpty(this.f227723b.f227762a.f496180b) == true) goto L5;
            r103.put(EventConstant.Key.MODULE, this.f227723b.f227762a.f496180b);
        L5:
            r102.v("client_commerce", r103);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f227724a = null;

        static {
            f227724a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.l("CreateErrorDialogUtils", "reportCreateExceedQuotaEvent ", (Throwable) r100);
        }
    }

    static {
    }

    public e() {
    }

    public static final void a(Context r100, NetService r101) {
        tt5.a.h("CreateErrorDialogUtils", "executeRemindAdmin()");
        NetService.d r102 = r101.Vc(new ax4.f());
        NetService.f r103 = new NetService.f("/api/explorer/lark/notifysuitebot/");
        r103.f216906c = 2;
        r102.a(r103).subscribe(new c(r100), new d(r100));
    }

    @JvmStatic
    public static final void b(m r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "createInfo");
        Intrinsics.checkNotNullParameter(r101, "action");
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new a(r101, r100), b.f227724a);
    }
}
