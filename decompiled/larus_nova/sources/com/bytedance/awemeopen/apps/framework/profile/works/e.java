package com.bytedance.awemeopen.apps.framework.profile.works;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements RecentlySeeHelper.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecentlySeeHelper f197583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f197584b;

    @Override // com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper.a
    public final void a() {
        ToastUtils.b(this.f197584b.getContext(), R.string.aos_aweme_not_found);
        RecentlySeeHelper r100 = this.f197583a;
        r100.f197536o = false;
        r100.f();
        RecentlySeeHelper r101 = this.f197583a;
        r101.f197532k = false;
        ViewGroup r102 = r101.f197524c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r102 = null;
    L5:
        x54.b.b(r102);
    }

    @Override // com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper.a
    public final void onFail() {
        RecentlySeeHelper r100 = this.f197583a;
        r100.f197536o = false;
        r100.f();
    }

    public e(RecentlySeeHelper r100, View r101) {
        this.f197583a = r100;
        this.f197584b = r101;
    }

    @Override // com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper.a
    public final void onSuccess(List<jz3.a> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        RecentlySeeHelper r102 = this.f197583a;
        r102.f197531j = RecentlySeeHelper.b(r100, r102.f197530i);
        RecentlySeeHelper r103 = this.f197583a;
        ViewGroup r104 = null;
        ViewGroup r105 = null;
        TextView r106 = null;
        if (r103.f197531j < 0) goto L14;
        TextView r107 = r103.f197525d;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r107 = null;
    L7:
        r107.setText(R.string.aos_recently_see);
        ViewGroup r108 = this.f197583a.f197524c;
        if (r108 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
    L12:
        if (x54.b.c(r105) == false) goto L26;
        RecentlySeeHelper r109 = this.f197583a;
        r109.f197536o = true;
        r109.c(r109.f197531j);
    L26:
        this.f197583a.f();
        return;
    L10:
        r105 = r108;
        goto L12
    L14:
        r103.f197536o = false;
        if (r101 == false) goto L21;
        TextView r110 = r103.f197525d;
        if (r110 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L20:
        r106.setText(R.string.aos_recently_see_go_on);
        ToastUtils.b(this.f197584b.getContext(), R.string.aos_aweme_out_of_date_not_found);
        goto L26
    L19:
        r106 = r110;
        goto L20
    L21:
        ToastUtils.b(this.f197584b.getContext(), R.string.aos_aweme_not_found);
        RecentlySeeHelper r111 = this.f197583a;
        r111.f197532k = false;
        ViewGroup r112 = r111.f197524c;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
    L25:
        x54.b.b(r104);
        goto L26
    L24:
        r104 = r112;
        goto L25
    }
}
