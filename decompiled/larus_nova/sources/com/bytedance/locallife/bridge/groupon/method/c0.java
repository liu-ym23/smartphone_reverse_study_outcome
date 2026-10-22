package com.bytedance.locallife.bridge.groupon.method;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f257107a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f257108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f257109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f257110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f257111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f257112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f257113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f257114g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f257115h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Object f257116i;

        public a(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105, boolean r106, long r107, Object r110) {
            this.f257108a = r100;
            this.f257109b = r101;
            this.f257110c = r102;
            this.f257111d = r103;
            this.f257112e = r104;
            this.f257113f = r105;
            this.f257114g = r106;
            this.f257115h = r107;
            this.f257116i = r110;
        }

        public final void a() {
            mq6.c r100 = new mq6.c();
            String r101 = this.f257108a;
            String r102 = this.f257109b;
            String r103 = this.f257110c;
            boolean r104 = this.f257111d;
            boolean r105 = this.f257112e;
            boolean r106 = this.f257113f;
            boolean r107 = this.f257114g;
            long r108 = this.f257115h;
            Object r110 = this.f257116i;
            r100.d("info", r101);
            r100.d("ui_component_type", r102);
            r100.d("ui_component_id", r103);
            r100.d("groupon_visible", com.bytedance.locallife.groupon.utils.c.a(Boolean.valueOf(r104)));
            r100.d("pass_avoid", com.bytedance.locallife.groupon.utils.c.a(Boolean.valueOf(r105)));
            r100.d("need_try", com.bytedance.locallife.groupon.utils.c.a(Boolean.valueOf(r106)));
            r100.d("has_tried", com.bytedance.locallife.groupon.utils.c.a(Boolean.valueOf(r107)));
            r100.b("duration", r108);
            if ((r110 instanceof Map) == false) goto L5;
            Map r111 = (Map) r110;
        L6:
            if (r111 == null) goto L11;
            Iterator r109 = r111.entrySet().iterator();
        L9:
            if (r109.hasNext() == false) goto L11;
            Map.Entry r112 = (Map.Entry) r109.next();
            Object r113 = r112.getKey();
            Object r114 = r112.getValue();
            r100.c(String.valueOf(r113), r114);
        L11:
            Map<String, String> r115 = r100.f514893a;
            int r116 = com.bytedance.locallife.biz.mob.a.f256703c;
            com.bytedance.locallife.biz.mob.a.C3646a.c("life_groupon_ui_component_state_jsb_monitor_tech", r115);
            return;
        L5:
            r111 = null;
            goto L6
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

    static {
    }

    public static void a(String r110, String r111, String r112, boolean r113, boolean r114, boolean r115, boolean r116, long r210, Object r211) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r111, "uiComponentType");
        Intrinsics.checkNotNullParameter(r112, "uiComponentId");
        long r100 = System.currentTimeMillis() - r210;
        Schedulers.io().scheduleDirect(new a(r110, r111, r112, r113, r114, r115, r116, r100, r211));
    }
}
