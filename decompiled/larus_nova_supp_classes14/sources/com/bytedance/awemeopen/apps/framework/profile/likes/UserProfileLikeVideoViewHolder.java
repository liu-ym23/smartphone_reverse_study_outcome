package com.bytedance.awemeopen.apps.framework.profile.likes;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder;
import com.bytedance.awemeopen.apps.framework.profile.works.n;
import com.bytedance.awemeopen.bizmodels.utils.AwemeCheckUtilsKt;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import jz3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p04.b;
import r14.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/likes/UserProfileLikeVideoViewHolder;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerItemViewHolder;", "Ljz3/a;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileLikeVideoViewHolder extends AosRecyclerItemViewHolder<a> {
    public static final /* synthetic */ int h = 0;
    public final p04.a c;
    public final View d;
    public final AoImageView e;
    public final ImageView f;
    public final DmtTextView g;

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder
    public final void V3() {
    }

    public UserProfileLikeVideoViewHolder(p04.a r2) {
        Intrinsics.checkNotNullParameter(r2, "groupParameters");
        super(r2.a);
        this.c = r2;
        this.d = T3(2131375718);
        this.e = T3(2131383212);
        this.f = (ImageView) T3(2131382245);
        this.g = (DmtTextView) T3(2131393316);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder
    public final void U3(a r4, int r5) {
        a r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        int r7 = n.a;
        n.b(r6.a, this.e);
        n.a(r6.a, this.f);
        AppCompatTextView r8 = this.g;
        j r0 = r6.a.L();
        if (r0 == null) goto L5;
        long r1 = r0.d();
    L6:
        x04.a.a(r8, r1);
        this.d.setOnClickListener(new b(this, r6));
        return;
    L5:
        Long r2 = 0L;
        AwemeCheckUtilsKt.a(r2, null, 3);
        r1 = r2.longValue();
        goto L6
    }
}
