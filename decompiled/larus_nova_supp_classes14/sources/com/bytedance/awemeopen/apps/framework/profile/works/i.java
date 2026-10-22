package com.bytedance.awemeopen.apps.framework.profile.works;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedActivity;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends o {
    public final /* synthetic */ UserProfileWorkViewHolder d;
    public final /* synthetic */ jz3.a e;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        UserProfileWorkViewHolder r0 = this.d;
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
        String r12 = com.bytedance.awemeopen.apps.framework.feed.profile.f.a;
        String r13 = r0.c.d.getUserOpenId();
        com.bytedance.awemeopen.apps.framework.feed.profile.f.a.b r14 = com.bytedance.awemeopen.apps.framework.feed.profile.f.a.b.a;
        long r15 = r0.c.d.maxCursor();
        boolean r16 = r0.c.d.hasMore();
        Object r17 = r0.c.d.getDataList().getValue();
        Intrinsics.checkNotNull(r17);
        com.bytedance.awemeopen.apps.framework.feed.profile.f.a(r13, r14, r15, r16, (List) ((ListState) r17).a, r1.d, r0.c.d.getEnterAid());
        DampScrollableLayout r18 = m04.a.a;
        UserProfileWorksFragmentViewModel r19 = r0.c.d;
        Intrinsics.checkNotNullParameter(r19, "vm");
        m04.a.b = r19;
        int r20 = AosUserProfileFeedActivity.a;
        FragmentActivity r21 = r0.c.getActivity();
        Bundle r22 = new Bundle();
        r22.putByte("hide_long_press_tab", r0.c.d.getHideLongPressTab() ? 1 : 0);
        r22.putString("host_extra_param_json_str", r0.c.d.getHostExtraParams().toString());
        r22.putString("host_enter_from", r0.c.d.getHostEnterFrom());
        Unit r23 = Unit.INSTANCE;
        AosUserProfileFeedActivity.a.a(r21, r22);
    }

    public i(UserProfileWorkViewHolder r1, jz3.a r2) {
        this.d = r1;
        this.e = r2;
    }
}
