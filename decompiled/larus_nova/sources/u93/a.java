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
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u93.d;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a<MW extends d> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f549210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f549211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MW f549212c;

    @Override // u93.c
    public final void a() {
        Iterator<T> r100 = this.f549210a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).a();
        goto L4
    }

    @Override // u93.c
    public final void onDestroy() {
        Iterator<T> r100 = this.f549210a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).onDestroy();
        goto L4
    }

    @Override // u93.c
    public final void onDestroyView() {
        Iterator<T> r100 = this.f549210a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).onDestroyView();
        goto L4
    }

    @Override // u93.c
    public final void onFirstScreen() {
        Iterator<T> r100 = this.f549210a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).onFirstScreen();
        goto L4
    }

    @Override // u93.c
    public final void onStop() {
        Iterator<T> r100 = this.f549210a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).onStop();
        goto L4
    }

    @Override // u93.c
    public final void f(HomePageDTO r100) {
        Iterator r101 = ((ArrayList) this.f549210a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).f(r100);
        goto L4
    }

    @Override // u93.c
    public final void g(boolean r100) {
        Iterator r101 = ((ArrayList) this.f549210a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).g(r100);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(com.bytedance.android.shopping.mall.homepage.component.b r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(this, "group");
        r100.f549213a = this;
        ((ArrayList) this.f549210a).add(r100);
    }

    @Override // u93.c
    public final void j(HomePageDTO r100) {
        Iterator r101 = ((ArrayList) this.f549210a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).j(r100);
        goto L4
    }

    @Override // u93.c
    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Iterator<T> r101 = this.f549210a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).l(r100);
        goto L4
    }

    @Override // u93.c
    public final void onCreate(Bundle r100) {
        Iterator<T> r101 = this.f549210a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).onCreate(r100);
        goto L4
    }

    public a(Fragment r100, MW r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "middleware");
        this.f549211b = r100;
        this.f549212c = r101;
        this.f549210a = new ArrayList();
    }

    @Override // u93.c
    public final void b(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator<T> r102 = this.f549210a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).b(r100, r101);
        goto L4
    }

    @Override // u93.c
    public final void c(List r100, int r101) {
        Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
        Intrinsics.checkNotNullParameter(r100, "apiKeyList");
        Iterator r102 = ((ArrayList) this.f549210a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).c(r100, r101);
        goto L4
    }

    @Override // u93.c
    public final void i(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator<T> r102 = this.f549210a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).i(r100, r101);
        goto L4
    }

    @Override // u93.c
    public final void k(HomePageDTO r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "homePage");
        Iterator r102 = ((ArrayList) this.f549210a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).k(r100, r101);
        goto L4
    }

    @Override // u93.c
    public final void d(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Iterator<T> r103 = this.f549210a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).d(r100, r101, r102);
        goto L4
    }

    @Override // u93.c
    public final void m(Configuration r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        Iterator<T> r103 = this.f549210a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).m(r100, r101, r102);
        goto L4
    }

    @Override // u93.c
    public final void n(LayoutInflater r100, ViewGroup r101, Bundle r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Iterator<T> r104 = this.f549210a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((c) r104.next()).n(r100, r101, r102, r103);
        goto L4
    }

    @Override // u93.c
    public final void e(String r100, ECHybridNetworkVO r110, String r111, boolean r112, HomePageDTO r113) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r111, "result");
        Iterator r101 = ((ArrayList) this.f549210a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).e(r100, r110, r111, r112, r113);
        goto L4
    }
}
