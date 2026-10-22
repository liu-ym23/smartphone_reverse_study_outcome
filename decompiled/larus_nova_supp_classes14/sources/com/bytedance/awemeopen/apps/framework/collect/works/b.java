package com.bytedance.awemeopen.apps.framework.collect.works;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedActivity;
import com.bytedance.awemeopen.apps.framework.feed.collect.f;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends o {
    public final /* synthetic */ UserCollectWorkViewHolder d;
    public final /* synthetic */ jz3.a e;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        UserCollectWorkViewHolder r0 = this.d;
        jz3.a r1 = this.e;
        if (Intrinsics.areEqual(r0.c.d.getEnterAid(), r1.a.c()) == false) goto L25;
        d14.a r2 = b14.a.a;
        t24.a r3 = b14.a.a(t24.a.class);
        Function0<String> r4 = r0.c.f;
        if (r4 == null) goto L7;
        String r5 = (String) r4.invoke();
    L9:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        User r6 = r1.a.f();
        if (r6 == null) goto L15;
        String r7 = r6.u();
        if (r7 == null) goto L15;
    L16:
        String r8 = r1.a.c();
        String r9 = r1.a.r().c;
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        User r10 = r1.a.f();
        if (r10 == null) goto L23;
        String r11 = r10.u();
        if (r11 == null) goto L23;
    L24:
        t24.a.a.h(r3, r5, r7, r8, r9, r11);
    L23:
        r11 = "";
    L15:
        r7 = "";
        goto L16
    L7:
        r5 = null;
    L25:
        String r12 = f.a;
        String r13 = r0.c.d.getUserOpenId();
        f.a.C0071a r14 = f.a.C0071a.a;
        long r15 = r0.c.d.maxCursor();
        boolean r16 = r0.c.d.hasMore();
        Object r17 = r0.c.d.getDataList().getValue();
        Intrinsics.checkNotNull(r17);
        List r18 = (List) ((ListState) r17).a;
        int r19 = r1.d;
        Intrinsics.checkNotNullParameter(r13, "userOpenId");
        Intrinsics.checkNotNullParameter(r14, "profileTab");
        Intrinsics.checkNotNullParameter(r18, "datas");
        f.a = r13;
        f.b = r14;
        f.c = 20;
        f.d = r15;
        f.e = r16;
        ArrayList r20 = (ArrayList) f.f;
        r20.clear();
        r20.addAll(r18);
        if (r19 < 0) goto L28;
        f.g = r19;
    L28:
        DampScrollableLayout r21 = m04.a.a;
        UserCollectWorksFragmentViewModel r22 = r0.c.d;
        Intrinsics.checkNotNullParameter(r22, "vm");
        m04.a.b = r22;
        int r23 = AosUserCollectFeedActivity.a;
        FragmentActivity r24 = r0.c.getActivity();
        Bundle r25 = new Bundle();
        r25.putByte("hide_long_press_tab", r0.c.d.getHideLongPressTab() ? 1 : 0);
        r25.putString("host_enter_from", r0.c.d.getHostEnterFrom());
        Unit r26 = Unit.INSTANCE;
        Intent r27 = new Intent(r24, AosUserCollectFeedActivity.class);
        r27.addFlags(268435456);
        r27.putExtras(r25);
        j04.b.b("user_collect_play");
        if (r24 == null) goto L32;
        r24.startActivity(r27);
        return;
    }

    public b(UserCollectWorkViewHolder r1, jz3.a r2) {
        this.d = r1;
        this.e = r2;
    }
}
