package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.store.view.ECShopLivePlayerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopLivePlayerView> {
    public String H3;
    public String I3;
    public List<String> J3;
    public Boolean K3;
    public String L3;

    public static final class a {
    }

    static {
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.J3 = CollectionsKt.emptyList();
    }

    public final void H0(Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r14, "props");
        if (k1() != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r15 = r14.entrySet().iterator();
    L6:
        boolean r1 = true;
        String r2 = "play";
        String r3 = null;
        if (r15.hasNext() == false) goto L46;
        Map.Entry<String, ? extends Object> r0 = r15.next();
        String r4 = r0.getKey();
        switch(r4.hashCode()) {
            case -1550742480: goto L39;
            case 104264043: goto L33;
            case 1379892991: goto L27;
            case 1626999049: goto L21;
            case 2085263161: goto L12;
            default: goto L6;
        };
    L12:
        if (r4.equals("playback_control") == false) goto L6;
        Object r5 = r0.getValue();
        if (r5 == null) goto L19;
        String r6 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5);
        if (r6 == null) goto L19;
        r2 = r6;
    L19:
        this.L3 = r2;
        goto L6
    L21:
        if (r4.equals("stream_data") == false) goto L6;
        Object r7 = r0.getValue();
        if (r7 == null) goto L25;
        r3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r7);
    L25:
        this.I3 = r3;
        goto L6
    L27:
        if (r4.equals("room_id") == false) goto L6;
        Object r8 = r0.getValue();
        if (r8 == null) goto L31;
        r3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r8);
    L31:
        this.H3 = r3;
        goto L6
    L33:
        if (r4.equals("muted") == false) goto L6;
        Object r9 = r0.getValue();
        if (r9 == null) goto L37;
        r1 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r9);
    L37:
        this.K3 = Boolean.valueOf(r1);
        goto L6
    L39:
        if (r4.equals("placeholder_urls") == false) goto L6;
        Object r10 = r0.getValue();
        if (r10 == null) goto L44;
        List<String> r11 = com.bytedance.android.ecom.arch.slice.render.util.b.s(r10);
        if (r11 == null) goto L44;
    L45:
        this.J3 = r11;
    L44:
        r11 = CollectionsKt.emptyList();
        goto L45
    L46:
        ECShopLivePlayerView r16 = k1();
        if (r16 == null) goto L138;
        String r12 = this.H3;
        String r13 = this.I3;
        String r17 = (String) CollectionsKt.firstOrNull(this.J3);
        Boolean r18 = this.K3;
        String r19 = this.L3;
        boolean r20 = false;
        if (r12 != null) goto L51;
    L54:
        boolean r21 = true;
    L55:
        if (r21 == false) goto L63;
        if (r13 != null) goto L58;
    L59:
        r20 = true;
    L60:
        if (r20 == false) goto L63;
        r16.c = null;
        r16.d = null;
        r16.f();
        r16.removeAllViews();
        return;
    L58:
        if (r13.length() != 0) goto L60;
    L63:
        if ((!Intrinsics.areEqual(r17, r16.e)) == false) goto L69;
        r16.e = r17;
        if (r17 == null) goto L69;
        h0.e(r16.a, r17, new r("ec_shop", "ec_store_live_cover_image"), null, null, 120);
    L69:
        if ((!Intrinsics.areEqual(r12, r16.c)) == false) goto L76;
        if ((!Intrinsics.areEqual(r13, r16.d)) == false) goto L76;
        r16.c = r12;
        r16.d = r13;
        if (ViewCompat.isAttachedToWindow(r16) == false) goto L76;
        r16.a();
    L76:
        if ((!Intrinsics.areEqual(r18, r16.g)) == false) goto L90;
        r16.g = r18;
        if (Intrinsics.areEqual(r18, Boolean.FALSE) == false) goto L84;
        le.b r22 = r16.b;
        if (r22 == null) goto L90;
        IECLivePlayerClient r23 = r22.a();
        if (r23 == null) goto L90;
        r23.unmute();
        goto L90
    L84:
        le.b r24 = r16.b;
        if (r24 == null) goto L90;
        IECLivePlayerClient r25 = r24.a();
        if (r25 == null) goto L90;
        r25.mute();
    L90:
        if ((!Intrinsics.areEqual(r19, r16.f)) == false) goto L140;
        r16.f = r19;
        if (r19 == null) goto L148;
        int r26 = r19.hashCode();
        if (r26 == 3443508) goto L112;
        if (r26 == 3540994) goto L109;
        if (r26 == 106440182) goto L102;
        return;
    L102:
        if (r19.equals("pause") == false) goto L141;
        le.b r110 = r16.b;
        if (r110 == null) goto L142;
        IECLivePlayerClient r111 = r110.a();
        if (r111 == null) goto L143;
        r111.pause();
        return;
    L143:
        return;
    L142:
        return;
    L141:
        return;
    L109:
        if (r19.equals("stop") == false) goto L145;
        r16.f();
        return;
    L145:
        return;
    L112:
        if (r19.equals("play") == false) goto L147;
        r16.e();
        return;
    L147:
        return;
    L148:
        return;
    L140:
        return;
    L51:
        if (r12.length() == 0) goto L54;
        r21 = false;
        goto L55
    }

    public final View n1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlcTemplateContext r0 = ((BaseSlcViewManager) this).a;
        String r1 = r0.g;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Object r2 = r0.o(r1);
        Context r3 = null;
        if ((r2 instanceof gk3.a) == true) goto L8;
        r2 = null;
    L8:
        gk3.a r5 = (gk3.a) r2;
        if (r5 == null) goto L13;
        LifecycleOwner r6 = r5.getLifecycleOwner();
        if (r6 == null) goto L13;
    L18:
        return new ECShopLivePlayerView(r4, r6);
    L13:
        if ((r4 instanceof LifecycleOwner) == false) goto L16;
        r3 = r4;
    L16:
        r6 = (LifecycleOwner) r3;
        goto L18
    }
}
