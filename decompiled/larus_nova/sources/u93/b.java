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
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u93.d;

/* JADX INFO: loaded from: classes13.dex */
public class b<MW extends d> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<? extends d> f549213a;

    public b() {
    }

    @Override // u93.c
    public void a() {
    }

    @Override // u93.c
    public void b(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // u93.c
    public void c(List r100, int r101) {
        Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
        Intrinsics.checkNotNullParameter(r100, "apiKeyList");
    }

    @Override // u93.c
    public final void d(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
    }

    @Override // u93.c
    public void e(String r100, ECHybridNetworkVO r101, String r102, boolean r103, HomePageDTO r104) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r102, "result");
    }

    @Override // u93.c
    public void f(HomePageDTO r100) {
    }

    @Override // u93.c
    public void g(boolean r100) {
    }

    @Override // u93.c
    public void i(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // u93.c
    public void j(HomePageDTO r100) {
    }

    @Override // u93.c
    public void k(HomePageDTO r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "homePage");
    }

    @Override // u93.c
    public void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    @Override // u93.c
    public void m(Configuration r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    @Override // u93.c
    public final void n(LayoutInflater r100, ViewGroup r101, Bundle r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
    }

    @Override // u93.c
    public void onCreate(Bundle r100) {
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
        a<? extends d> r100 = this.f549213a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("group");
    L6:
        return r100.f549211b;
    }

    public final MW p() {
        a<? extends d> r100 = this.f549213a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("group");
    L5:
        MW r101 = r100.f549212c;
        if (r101 == null) goto L9;
        return r101;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type MW");
    }
}
