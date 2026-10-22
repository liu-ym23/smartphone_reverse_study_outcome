package com.bytedance.android.livesdk.linkvideo.ui;

import android.view.View;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.linkvideo.LoadMoreScrollListener;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ LinkVideoDialog a;

    public b(LinkVideoDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        com.bytedance.android.livesdk.linkvideo.g r9 = (com.bytedance.android.livesdk.linkvideo.g) r8;
        LinkVideoDialog r0 = this.a;
        String r1 = LinkVideoDialog.R;
        r0.getClass();
        boolean r3 = true;
        if ((r9 instanceof com.bytedance.android.livesdk.linkvideo.g.b) == false) goto L66;
        View r2 = r0.l;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
    L7:
        r0.hideLoading();
        View r4 = r0.k;
        if (r4 == null) goto L10;
        r4.setVisibility(8);
    L10:
        gf2.b r10 = ((com.bytedance.android.livesdk.linkvideo.g.b) r9).a;
        if (r10 == null) goto L15;
        Boolean r5 = r10.a();
        if (r5 == null) goto L15;
        boolean r6 = r5.booleanValue();
    L16:
        r0.V90(false);
        MultiTypeAdapter r7 = r0.z;
        Unit r11 = null;
        if (r7 == null) goto L19;
        List r12 = r7.a;
    L21:
        if (TypeIntrinsics.isMutableList(r12) == true) goto L24;
        r12 = null;
    L24:
        if (r10 == null) goto L44;
        List<gf2.a> r13 = r10.c();
        if (r13 == null) goto L44;
        if ((!r13.isEmpty()) == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L44;
        if (r12 == null) goto L34;
        r12.addAll(r13);
    L34:
        if (r6 == true) goto L40;
        LoadMoreScrollListener r14 = r0.A;
        if (r14 == null) goto L38;
        r14.b = 2;
    L38:
        if (r12 == null) goto L40;
        r12.add(new com.bytedance.android.livesdk.linkvideo.view.f(2));
    L40:
        MultiTypeAdapter r15 = r0.z;
        if (r15 == null) goto L43;
        r15.notifyDataSetChanged();
        r11 = Unit.INSTANCE;
    L43:
        if (r11 == null) goto L44;
    L59:
        if (r12 != null) goto L61;
        return;
    L61:
        if (r12.isEmpty() == false) goto L63;
        return;
    L63:
        if (r0.L == true) goto L111;
        r0.Z90(!r12.isEmpty());
        r0.L = true;
        return;
    L111:
        return;
    L44:
        if (r6 == true) goto L58;
        if (r12 == null) goto L47;
        boolean r16 = r12.isEmpty();
    L48:
        if (r16 == false) goto L50;
        r0.W90();
        Unit r17 = Unit.INSTANCE;
        goto L59
    L50:
        LoadMoreScrollListener r18 = r0.A;
        if (r18 == null) goto L53;
        r18.b = 2;
    L53:
        if (r12 == null) goto L55;
        r12.add(new com.bytedance.android.livesdk.linkvideo.view.f(2));
    L55:
        MultiTypeAdapter r19 = r0.z;
        if (r19 == null) goto L59;
        r19.notifyDataSetChanged();
        Unit r20 = Unit.INSTANCE;
        goto L59
    L47:
        r16 = true;
        goto L48
    L58:
        r0.V90(true);
        Unit r21 = Unit.INSTANCE;
        goto L59
    L19:
        r12 = null;
    L15:
        r6 = true;
        goto L16
    L66:
        if ((r9 instanceof com.bytedance.android.livesdk.linkvideo.g.a) == false) goto L79;
        Throwable r22 = ((com.bytedance.android.livesdk.linkvideo.g.a) r9).a;
        r0.V90(true);
        MultiTypeAdapter r23 = r0.z;
        if (r23 == null) goto L72;
        List r24 = r23.a;
        if (r24 == null) goto L72;
        r3 = r24.isEmpty();
    L72:
        if (r3 == false) goto L76;
        r0.hideLoading();
        View r25 = r0.k;
        if (r25 == null) goto L77;
        r25.setVisibility(0);
    L77:
        r0.Z90(false);
        return;
    L76:
        ExceptionUtils.handleException(r0.getContext(), r22);
        goto L77
    L79:
        if ((r9 instanceof com.bytedance.android.livesdk.linkvideo.g.c) == false) goto L85;
        r0.hideLoading();
        View r26 = r0.k;
        if (r26 == null) goto L83;
        r26.setVisibility(8);
    L83:
        r0.W90();
        r0.Z90(false);
        return;
    L85:
        if ((r9 instanceof com.bytedance.android.livesdk.linkvideo.g.d) == false) goto L100;
        View r27 = r0.l;
        if (r27 == null) goto L89;
        r27.setVisibility(8);
    L89:
        View r28 = r0.k;
        if (r28 == null) goto L92;
        r28.setVisibility(8);
    L92:
        View r29 = r0.j;
        if (r29 == null) goto L95;
        r29.setVisibility(0);
    L95:
        LiveDoubleColorBallAnimationView r30 = r0.B;
        if (r30 == null) goto L98;
        r30.b();
    L98:
        r0.Z90(false);
        return;
    L100:
        if ((r9 instanceof com.bytedance.android.livesdk.linkvideo.g.e) == false) goto L116;
        r0.hideLoading();
        View r31 = r0.l;
        if (r31 == null) goto L104;
        r31.setVisibility(8);
    L104:
        View r32 = r0.k;
        if (r32 == null) goto L107;
        r32.setVisibility(0);
    L107:
        r0.Z90(false);
        return;
    }
}
