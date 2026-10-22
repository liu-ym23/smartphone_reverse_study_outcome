package u93;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u93.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class b<MW extends d> implements c {
    public a<? extends d> a;

    public b() {
    }

    @Override // u93.c
    public void a() {
    }

    @Override // u93.c
    public void b(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    @Override // u93.c
    public void c(List r2, int r3) {
        Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
        Intrinsics.checkNotNullParameter(r2, "apiKeyList");
    }

    @Override // u93.c
    public final void d(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
    }

    @Override // u93.c
    public void e(String r1, ECHybridNetworkVO r2, String r3, boolean r4, HomePageDTO r5) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // u93.c
    public void f(HomePageDTO r1) {
    }

    @Override // u93.c
    public void g(boolean r1) {
    }

    @Override // u93.c
    public void i(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    @Override // u93.c
    public void j(HomePageDTO r1) {
    }

    @Override // u93.c
    public void k(HomePageDTO r1, k r2) {
        Intrinsics.checkNotNullParameter(r1, "homePage");
    }

    @Override // u93.c
    public void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
    }

    @Override // u93.c
    public void m(Configuration r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "newConfig");
    }

    @Override // u93.c
    public final void n(LayoutInflater r1, ViewGroup r2, Bundle r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
    }

    @Override // u93.c
    public void onCreate(Bundle r1) {
    }

    @Override // u93.c
    public void onDestroy() {
    }

    @Override // u93.c
    public final void onDestroyView() {
    }

    @Override // u93.c
    public void onFirstScreen() {
    }

    @Override // u93.c
    public void onStop() {
    }

    public final Fragment o() {
        a<? extends d> r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("group");
    L6:
        return r0.b;
    }

    public final MW p() {
        a<? extends d> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("group");
    L5:
        MW r1 = r0.c;
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type MW");
    }
}
