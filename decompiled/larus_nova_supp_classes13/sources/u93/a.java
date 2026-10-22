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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u93.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a<MW extends d> implements c {
    public final List<c> a;
    public final Fragment b;
    public final MW c;

    @Override // u93.c
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).a();
        goto L4
    }

    @Override // u93.c
    public final void onDestroy() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onDestroy();
        goto L4
    }

    @Override // u93.c
    public final void onDestroyView() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onDestroyView();
        goto L4
    }

    @Override // u93.c
    public final void onFirstScreen() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onFirstScreen();
        goto L4
    }

    @Override // u93.c
    public final void onStop() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onStop();
        goto L4
    }

    @Override // u93.c
    public final void f(HomePageDTO r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).f(r3);
        goto L4
    }

    @Override // u93.c
    public final void g(boolean r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).g(r3);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(com.bytedance.android.shopping.mall.homepage.component.b r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(this, "group");
        r2.a = this;
        ((ArrayList) this.a).add(r2);
    }

    @Override // u93.c
    public final void j(HomePageDTO r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).j(r3);
        goto L4
    }

    @Override // u93.c
    public final void l(String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).l(r3);
        goto L4
    }

    @Override // u93.c
    public final void onCreate(Bundle r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onCreate(r3);
        goto L4
    }

    public a(Fragment r2, MW r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "middleware");
        this.b = r2;
        this.c = r3;
        this.a = new ArrayList();
    }

    @Override // u93.c
    public final void b(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).b(r3, r4);
        goto L4
    }

    @Override // u93.c
    public final void c(List r3, int r4) {
        Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
        Intrinsics.checkNotNullParameter(r3, "apiKeyList");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).c(r3, r4);
        goto L4
    }

    @Override // u93.c
    public final void i(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).i(r3, r4);
        goto L4
    }

    @Override // u93.c
    public final void k(HomePageDTO r3, k r4) {
        Intrinsics.checkNotNullParameter(r3, "homePage");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).k(r3, r4);
        goto L4
    }

    @Override // u93.c
    public final void d(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).d(r3, r4, r5);
        goto L4
    }

    @Override // u93.c
    public final void m(Configuration r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).m(r3, r4, r5);
        goto L4
    }

    @Override // u93.c
    public final void n(LayoutInflater r3, ViewGroup r4, Bundle r5, View r6) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).n(r3, r4, r5, r6);
        goto L4
    }

    @Override // u93.c
    public final void e(String r9, ECHybridNetworkVO r10, String r11, boolean r12, HomePageDTO r13) {
        Intrinsics.checkNotNullParameter(r9, "apiKey");
        Intrinsics.checkNotNullParameter(r11, "result");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).e(r9, r10, r11, r12, r13);
        goto L4
    }
}
