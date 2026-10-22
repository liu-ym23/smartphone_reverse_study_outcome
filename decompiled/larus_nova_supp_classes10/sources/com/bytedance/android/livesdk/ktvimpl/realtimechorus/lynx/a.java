package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import android.app.Activity;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.config.m71;
import com.bytedance.android.livesdk.config.s91;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "chorusBusinessType");
        Activity r2 = null;
        s91 r0 = ((m71) vm2.h.r4.getValue(null, vm2.h.a[276(0x114, float:3.87E-43)])).b();
        String r1 = r0.a();
        String r3 = r0.b();
        u6 r5 = new u6(r1);
        r5.b("url", r3);
        r5.d("url").b("chorus_business_type", r4);
        IMiddlewareHostApp r6 = jc1.k.f(IMiddlewareHostApp.class);
        if (r6 == null) goto L5;
        r2 = r6.getTopActivity();
    L5:
        if (r2 == null) goto L10;
        IMiddlewareLiveService r7 = TTLiveServiceMiddleware.getLiveService();
        if (r7 == null) goto L11;
        r7.handleSchema(r2, r5.c());
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void a(String r6, String r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter("info_area", "requestPage");
        Intrinsics.checkNotNullParameter(r6, "segment");
        Intrinsics.checkNotNullParameter(r7, "chorusId");
        Intrinsics.checkNotNullParameter(r8, "curUserChorusScore");
        Activity r4 = null;
        s91 r2 = ((m71) vm2.h.r4.getValue(null, vm2.h.a[276(0x114, float:3.87E-43)])).a();
        String r3 = r2.a();
        String r5 = r2.b();
        u6 r10 = new u6(r3);
        r10.b("url", r5);
        u6 r11 = r10.d("url");
        r11.b("request_page", "info_area");
        r11.b("song_name", xe2.h.e());
        r11.b("ksong_id", xe2.h.d());
        r11.b("function_type", "chorus");
        r11.b("function_type2", "chorus");
        r11.b("live_type", com.bytedance.android.live.ktv.common.util.j.d());
        r11.b("user_type", com.bytedance.android.live.ktv.common.util.j.g());
        r11.b("segment", r6);
        r11.b("chorus_id", r7);
        r11.b("cur_user_chorus_score", r8);
        r11.b("cur_user_is_sing", String.valueOf(r9));
        IMiddlewareHostApp r12 = jc1.k.f(IMiddlewareHostApp.class);
        if (r12 == null) goto L5;
        r4 = r12.getTopActivity();
    L5:
        if (r4 == null) goto L10;
        IMiddlewareLiveService r13 = TTLiveServiceMiddleware.getLiveService();
        if (r13 == null) goto L11;
        r13.handleSchema(r4, r10.c());
        return;
    L11:
        return;
    }
}
