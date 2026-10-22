package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ gi2.a c;
    public final /* synthetic */ Map d;

    public e(int r1, String r2, gi2.a r3, Map r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        int r0 = this.a;
        if (r0 != 1) goto L5;
        String r4 = "a1.b0715.c9204.d6819";
    L22:
        if (r0 == 14) goto L36;
        String r1 = "livesdk_show_" + this.b;
        com.bytedance.android.ec.common.api.jump.model.b r5 = this.c;
        if (r5 != null) goto L26;
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L26:
        v r2 = new v(r1, r5);
        int r3 = this.a;
        if (r3 == 1) goto L34;
        if (r3 != 9) goto L30;
        r2.c("consultation_type", "anchor");
    L35:
        r2.d(this.d);
        r2.i(r4);
        return;
    L30:
        if (r3 != 12) goto L35;
        r2.c("click_area", "top");
        goto L35
    L34:
        r2.c("consultation_type", "shop");
        goto L35
    L36:
        gi2.a r6 = this.c;
        Boolean r7 = null;
        if (r6 == null) goto L39;
        LiveRoomParams r8 = (LiveRoomParams) r6.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
    L40:
        com.bytedance.android.ec.common.api.jump.model.b r9 = this.c;
        if (r9 != null) goto L43;
        r9 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L43:
        v r10 = new v("show_search", r9);
        r10.c("enter_from", "search_live_product");
        if (r8 == null) goto L46;
        String r11 = r8.getEnterMethod();
    L47:
        String r12 = "";
        if (r11 != null) goto L50;
        r11 = "";
    L50:
        r10.c("enter_from_method", r11);
        if (r8 == null) goto L53;
        String r13 = r8.getEnterFromMerge();
    L54:
        if (r13 != null) goto L56;
        r13 = "";
    L56:
        r10.c("enter_from_second", r13);
        if (r8 == null) goto L59;
        String r14 = r8.getAuthorId();
    L60:
        if (r14 == null) goto L63;
        r12 = r14;
    L63:
        r10.c("author_id", r12);
        r10.c("group_id", l0.i("room_id"));
        gi2.a r15 = this.c;
        if (r15 == null) goto L74;
        Function0<Boolean> r16 = r15.h;
        if (r16 == null) goto L74;
        Boolean r17 = (Boolean) r16.invoke();
        if (r17 == null) goto L74;
        if (r17.booleanValue() == false) goto L72;
        r7 = r17;
    L72:
        if (r7 == null) goto L74;
        r7.booleanValue();
        r10.c("page_name", "live_instant_store");
    L74:
        r10.i(r4);
        return;
    L59:
        r14 = null;
        goto L60
    L53:
        r13 = null;
        goto L54
    L46:
        r11 = null;
        goto L47
    L39:
        r8 = null;
        goto L40
    L5:
        if (r0 != 2) goto L7;
        r4 = "a1.b0715.c9204.d8081";
        goto L22
    L7:
        if (r0 != 3) goto L9;
        r4 = "a1.b0715.c9204.d5770";
        goto L22
    L9:
        if (r0 == 4) goto L18;
        if (r0 != 9) goto L12;
        r4 = "a1.b0715.c9204.d22364";
        goto L22
    L12:
        if (r0 == 11) goto L16;
        if (r0 == 14) goto L15;
        r4 = "a1.b0715.c9204.d838700";
        goto L22
    L15:
        r4 = "a1.b0715.c9204.d70073";
        goto L22
    L16:
        r4 = "a1.b0715.c9204.d67191";
        goto L22
    L18:
        r4 = "a1.b0715.c9204.d052621";
        goto L22
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
