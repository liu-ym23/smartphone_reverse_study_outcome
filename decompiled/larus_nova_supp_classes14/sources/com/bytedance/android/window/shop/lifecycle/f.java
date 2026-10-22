package com.bytedance.android.window.shop.lifecycle;

import android.content.Context;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements e {
    public final List<e> a;

    public f() {
        this(0);
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).b();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void f() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).f();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void k() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).k();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void l() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).l();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void r() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).r();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void u() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).u();
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void v() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).v();
        goto L4
    }

    public f(List<e> r2) {
        Intrinsics.checkNotNullParameter(r2, "windowLifecycleMonitors");
        this.a = r2;
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void d(long r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).d(r3);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void g(ECWindowParam r3) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).g(r3);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void h(ECWindowParam r3) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).h(r3);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void j(WindowTabInfoProvider r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).j(r3);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void n(uq3.a r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).n(r3);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final /* bridge */ /* synthetic */ e s(boolean r1) {
        return w(r1);
    }

    public final f w(boolean r4) {
        List<e> r0 = this.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(((e) r2.next()).s(r4));
        goto L4
    L7:
        return new f(CollectionsKt.toMutableList(r1));
    }

    public /* synthetic */ f(int r1) {
        this(new ArrayList());
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void o(Context r3, ECWindowParam r4) {
        Intrinsics.checkNotNullParameter(r4, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).o(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void p(ECWindowParam r3, WindowHeaderResponseDTO r4) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Intrinsics.checkNotNullParameter(r4, "response");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).p(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void q(Context r3, ECWindowParam r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).q(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void e(ECWindowParam r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).e(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void i(ECWindowParam r3, WindowTabInfoProvider r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Intrinsics.checkNotNullParameter(r4, "response");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).i(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void t(int r3, Integer r4, WindowTypeSeparatedAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).t(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void c(ECWindowParam r9, long r10, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r9, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).c(r9, r10, r12, r13);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void m(ECWindowParam r9, long r10, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r9, "windowParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).m(r9, r10, r12, r13);
        goto L4
    }
}
