package com.bytedance.awemeopen.apps.framework.profile.works;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.utils.AwemeCheckUtilsKt;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/works/UserProfileWorkViewHolder;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerItemViewHolder;", "Ljz3/a;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileWorkViewHolder extends AosRecyclerItemViewHolder<jz3.a> {
    public final a c;
    public final Lazy d;
    public final View e;
    public final View f;
    public final AoImageView g;
    public final ImageView h;
    public final DmtTextView i;
    public int j;
    public final g k;

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder
    public final void V3() {
    }

    public UserProfileWorkViewHolder(a r2) {
        Intrinsics.checkNotNullParameter(r2, "groupParameters");
        super(r2.a);
        this.c = r2;
        this.d = LazyKt.lazy(UserProfileWorkViewHolder$showRecentlySee$2.INSTANCE);
        this.e = T3(2131383869);
        this.f = T3(2131375718);
        this.g = T3(2131383212);
        this.h = (ImageView) T3(2131382245);
        this.i = (DmtTextView) T3(2131393316);
        this.j = -1;
        this.k = new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder
    public final void U3(jz3.a r8, int r9) {
        jz3.a r10 = r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        this.j = r9;
        int r11 = n.a;
        n.b(r10.a, this.g);
        n.a(r10.a, this.h);
        AppCompatTextView r12 = this.i;
        r14.j r0 = r10.a.L();
        if (r0 == null) goto L5;
        long r1 = r0.d();
    L6:
        x04.a.a(r12, r1);
        this.f.setOnClickListener(new i(this, r10));
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L9;
    L11:
        x54.b.a(this.e);
    L12:
        r14.c r13 = r10.a;
        LinkedHashMap r2 = new LinkedHashMap();
        User r14 = r13.f();
        String r3 = "";
        if (r14 == null) goto L16;
        String r15 = r14.u();
        if (r15 == null) goto L16;
    L17:
        r2.put("author_openid", r15);
        String r16 = r13.t();
        if (r16 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == false) goto L26;
        String r18 = r13.c();
    L27:
        r2.put("group_id", r18);
        a0 r19 = r13.d;
        if (r19 == null) goto L33;
        String r20 = r19.a();
        if (r20 == null) goto L33;
        r3 = r20;
    L33:
        r2.put("impr_id", r3);
        r2.put("enter_from", "others_homepage");
        AosEventReporter.s(AosEventReporter.a, "feed_client_show", r2, null, null, new com.bytedance.awemeopen.apps.framework.utils.e(r13), 12);
        return;
    L26:
        r18 = r13.t();
        goto L27
    L20:
        if (r16.length() == 0) goto L23;
        r17 = false;
    L16:
        r15 = "";
        goto L17
    L9:
        if (Intrinsics.areEqual(this.c.d.getEnterAid(), r10.a.c()) == false) goto L11;
        x54.b.d(this.e);
        goto L12
    L5:
        Long r4 = 0L;
        AwemeCheckUtilsKt.a(r4, null, 3);
        r1 = r4.longValue();
        goto L6
    }
}
