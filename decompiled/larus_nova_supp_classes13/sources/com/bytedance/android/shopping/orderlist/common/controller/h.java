package com.bytedance.android.shopping.orderlist.common.controller;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final Map<String, Object> a;
    public final b b;
    public final List<WeakReference<MessageQueue.IdleHandler>> c;

    public static final class a {
    }

    public interface b {
        void a(List r1);

        void b(String r1);
    }

    static {
    }

    public final void b() {
        Map<String, Object> r0 = this.a;
        if (r0 == null) goto L5;
        Object r1 = r0.get("preload_tasks");
    L7:
        if ((r1 instanceof List) == true) goto L9;
        r1 = null;
    L9:
        List r2 = (List) r1;
        Map<String, Object> r3 = this.a;
        if (r3 == null) goto L12;
        Object r4 = r3.get("preload_biz_scene_priority");
    L14:
        if ((r4 instanceof List) == true) goto L16;
        r4 = null;
    L16:
        final List r5 = (List) r4;
        Map<String, Object> r6 = this.a;
        if (r6 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L74;
        List r8 = r2;
        if (r8 != null) goto L27;
    L30:
        boolean r9 = true;
    L31:
        if (r9 == true) goto L74;
        List r10 = r5;
        if (r10 != null) goto L35;
    L38:
        boolean r11 = true;
    L39:
        if (r11 == true) goto L74;
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r2.iterator();
    L43:
        if (r14.hasNext() == false) goto L63;
        Object r15 = r14.next();
        if ((r15 instanceof Map) == true) goto L47;
        r15 = null;
    L47:
        Map r16 = (Map) r15;
        if (r16 == null) goto L43;
        v r17 = new v(r16);
        Object r18 = r17.c.get("strategy");
        if (r18 == null) goto L53;
        Integer r19 = com.bytedance.kmp.ec.yata.common.utils.d.d(r18);
    L54:
        if (r19 != null) goto L57;
    L59:
        boolean r20 = false;
    L60:
        if (r20 == true) goto L61;
        r13.add(r17);
        goto L43
    L61:
        r12.add(r17);
        goto L43
    L57:
        if (r19.intValue() != 0) goto L59;
        r20 = true;
        goto L60
    L53:
        r19 = null;
        goto L54
    L63:
        Function1<v, Integer> r21 = new OrderCommonPreloadManager$splitAndSortTasksToQueues$selector$1(r5);
        if (r12.size() <= 1) goto L67;
        CollectionsKt.sortWith(r12, new j(r21));
    L67:
        if (r13.size() <= 1) goto L69;
        CollectionsKt.sortWith(r13, new k(r21));
    L69:
        Pair r22 = TuplesKt.to(r12, r13);
        List<v> r23 = (List) r22.getFirst();
        List r24 = (List) r22.getSecond();
        a(r23);
        if (r24.isEmpty() == true) goto L84;
        i r25 = new i(this, r24);
        this.c.add(new WeakReference(r25));
        Looper.myQueue().addIdleHandler(r25);
        return;
    L84:
        return;
    L35:
        if (r10.isEmpty() == true) goto L38;
        r11 = false;
        goto L39
    L27:
        if (r8.isEmpty() == true) goto L30;
        r9 = false;
    L74:
        this.b.a(r2);
        return;
    L19:
        if (r6.isEmpty() == true) goto L22;
        r7 = false;
        goto L23
    L12:
        r4 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final void a(List<v> r6) {
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L22;
        v r0 = (v) r7.next();
        r0.getClass();
        int r1 = com.bytedance.android.shopping.yata.init.a.a;
        Object r2 = ECSettingKeys.f0().get("fix_self_add_preload_task_crash");
        if ((r2 instanceof Boolean) == true) goto L8;
        r2 = null;
    L8:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L11;
        boolean r4 = r3.booleanValue();
    L12:
        if (r4 == false) goto L18;
        Context r5 = ECAppInfoService.e.getApplicationContext();
        if (r5 == null) goto L21;
        com.bytedance.android.anniex.assemble.a.a.c(r5);
    L21:
        this.b.b(r0.b);
    L18:
        if (ECSettingKeys.J() == false) goto L20;
        Observable.create(new r(r0)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s.a, t.a, u.a);
        goto L21
    L20:
        r0.a();
        goto L21
    L11:
        r4 = true;
        goto L12
    }

    public h(Map r2, g r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "monitor");
        Intrinsics.checkNotNullParameter(r4, "idleHandlerList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
