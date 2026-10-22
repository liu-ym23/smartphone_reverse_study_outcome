package com.bytedance.android.shopping.deepfeed.slice.view.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.deepfeed.slice.view.e;
import com.bytedance.android.shopping.deepfeed.ui.vh.l;
import com.bytedance.android.shopping.deepfeed.utlis.k;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.b<b> {
    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Type inference failed for: r11v6, types: [android.view.View, com.bytedance.android.shopping.deepfeed.slice.view.live.b] */
    public final void H0(Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "props");
        Object r1 = r11.get("roomId");
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r2 = (String) r1;
        if (r2 != null) goto L8;
        String r3 = "";
    L9:
        Object r4 = r11.get("streamData");
        if ((r4 instanceof String) == true) goto L12;
        r4 = null;
    L12:
        String r5 = (String) r4;
        if (r5 != null) goto L15;
        String r6 = "";
    L16:
        Object r7 = r11.get("coverUrl");
        if ((r7 instanceof String) == true) goto L19;
        r7 = null;
    L19:
        String r8 = (String) r7;
        if (r8 != null) goto L22;
        String r9 = "";
    L23:
        Boolean r10 = Boolean.TRUE;
        Object r12 = r11.get("mute");
        if ((r12 instanceof Boolean) == true) goto L26;
        r12 = null;
    L26:
        Boolean r13 = (Boolean) r12;
        if (r13 != null) goto L29;
        r13 = r10;
    L29:
        boolean r14 = r13.booleanValue();
        Boolean r15 = Boolean.FALSE;
        Object r16 = r11.get("visible");
        if ((r16 instanceof Boolean) == true) goto L32;
        r16 = null;
    L32:
        Boolean r17 = (Boolean) r16;
        if (r17 == null) goto L36;
        r15 = r17;
    L36:
        boolean r18 = r15.booleanValue();
        Object r19 = r11.get("isPlaying");
        if ((r19 instanceof Boolean) == true) goto L39;
        r19 = null;
    L39:
        Boolean r110 = (Boolean) r19;
        if (r110 == null) goto L43;
        r10 = r110;
    L43:
        e r0 = new e(r3, r6, r9, r14, r18, r10.booleanValue());
        ?? r111 = (b) k1();
        if (r111 == 0) goto L119;
        Intrinsics.checkNotNullParameter(r0, "data");
        com.bytedance.android.shopping.deepfeed.slice.service.b r20 = r111.b();
        if (r20 == null) goto L48;
        r20.K(r111.j);
    L48:
        e r21 = r111.g;
        Intrinsics.checkNotNullParameter(r21, "newState");
        if ((!Intrinsics.areEqual(r0.a, r21.a)) == false) goto L51;
    L62:
        boolean r22 = true;
    L63:
        if (r22 == true) goto L66;
        r111.d();
        return;
    L66:
        if (r0.a.length() != 0) goto L68;
        boolean r23 = true;
    L69:
        if (r23 == false) goto L77;
        if (r0.b.length() != 0) goto L73;
        boolean r24 = true;
    L74:
        if (r24 == false) goto L77;
        r111.g();
        r111.e();
        r111.g = r0;
        return;
    L73:
        r24 = false;
    L77:
        if (r0.a.length() <= 0) goto L79;
        boolean r25 = true;
    L80:
        if (r25 == true) goto L82;
    L84:
        boolean r26 = false;
    L85:
        if (r26 == false) goto L88;
        r111.g();
        r111.e();
        r111.f();
    L88:
        if (r0.c.length() <= 0) goto L90;
        boolean r27 = true;
    L91:
        if (r27 == false) goto L99;
        if ((!Intrinsics.areEqual(r0.c, r111.g.c)) == false) goto L99;
        String r28 = r0.c;
        r111.c.setVisibility(0);
        ECUrlModel r29 = new ECUrlModel();
        List r30 = CollectionsKt.listOf(r28);
        if ((r30 instanceof List) == true) goto L97;
        r30 = null;
    L97:
        r29.setUrlList(r30);
        LruCache<String, Bitmap> r31 = l.a;
        SimpleDraweeView r32 = r111.c;
        int r33 = k.a;
        Intrinsics.checkNotNullParameter("live_image", "sceneTag");
        l.c(null, r29, r32, new r("ec_na_deepfeed", "live_image"));
    L99:
        if (r111.e == null) goto L101;
    L105:
        r111.d();
        if (r0.d == true) goto L112;
        le.b r34 = r111.e;
        if (r34 == null) goto L117;
        IECLivePlayerClient r35 = r34.a();
        if (r35 == null) goto L117;
        r35.unmute();
    L117:
        r111.h(r0);
        r111.g = r0;
        return;
    L112:
        le.b r36 = r111.e;
        if (r36 == null) goto L117;
        IECLivePlayerClient r37 = r36.a();
        if (r37 == null) goto L117;
        r37.mute();
        goto L117
    L101:
        if (r0.e == false) goto L105;
        if (ViewCompat.isAttachedToWindow(r111) == false) goto L105;
        r111.c(r0);
        goto L105
    L90:
        r27 = false;
        goto L91
    L82:
        if ((!Intrinsics.areEqual(r0.a, r111.g.a)) == false) goto L84;
        r26 = true;
        goto L85
    L79:
        r25 = false;
        goto L80
    L68:
        r23 = false;
        goto L69
    L51:
        if ((!Intrinsics.areEqual(r0.b, r21.b)) == true) goto L62;
        if ((!Intrinsics.areEqual(r0.c, r21.c)) == true) goto L62;
        if (r0.d != r21.d) goto L62;
        if (r0.e != r21.e) goto L62;
        if (r0.f != r21.f) goto L62;
        r22 = false;
        goto L63
    L119:
        return;
    L22:
        r9 = r8;
        goto L23
    L15:
        r6 = r5;
        goto L16
    L8:
        r3 = r2;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.deepfeed.slice.view.live.b] */
    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ?? r0 = new b(r3);
        SlcTemplateContext r4 = ((BaseSlcViewManager) this).a;
        Intrinsics.checkNotNullParameter(r4, "templateCtx");
        r0.f = r4;
        return r0;
    }
}
