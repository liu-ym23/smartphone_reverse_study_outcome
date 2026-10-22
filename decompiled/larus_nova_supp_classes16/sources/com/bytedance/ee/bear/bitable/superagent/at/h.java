package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.bitable.superagent.r;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements kn4.g {
    public final FragmentActivity a;
    public final String b;
    public final BitableSuperAgentAtView c;
    public final BitableSuperAgentAtViewModel d;
    public kn4.g.b e;
    public kn4.g.a f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public final void a(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void c(boolean r1) {
    }

    public final void d(View r1) {
    }

    public final void e(int r1) {
    }

    public final void g(bo4.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mentionInfo");
    }

    public final void h(View r1) {
    }

    public final void i(int r1) {
    }

    public void update() {
    }

    public final void j() {
        if (this.g == true) goto L5;
        return;
    L5:
        this.g = false;
        tt5.a.h("BitableSuperAgentAtWindow", "closeFindView: baseId=" + this.b);
        this.c.c(null, this.a);
        this.c.setVisibility(8);
        BitableSuperAgentAtViewModel r1 = this.d;
        if (r1.r == false) goto L9;
        r1.r = false;
        MutableLiveData r2 = ((AtFinderViewModel) r1.f.getValue()).getSearchResultList(r1.d);
        r2.removeObserver(r1.t);
        r2.setValue(null);
        r1.g.setValue(CollectionsKt.emptyList());
        r1.i.setValue(CollectionsKt.emptyList());
        MutableLiveData<Boolean> r3 = r1.k;
        Boolean r4 = Boolean.FALSE;
        r3.setValue(r4);
        r1.m.setValue(r4);
        r1.o.setValue(BitableSuperAgentAtViewModel.ViewMode.DEFAULT);
    L9:
        kn4.g.b r5 = this.e;
        if (r5 == null) goto L13;
        r5.b(false);
        return;
    }

    public final void show() {
        if (this.g == true) goto L14;
        this.g = true;
        tt5.a.h("BitableSuperAgentAtWindow", "showFindView: baseId=" + this.b);
        this.c.c(this.d, this.a);
        this.c.setVisibility(0);
        BitableSuperAgentAtViewModel r1 = this.d;
        if (r1.r == true) goto L9;
        r1.r = true;
        MutableLiveData r2 = ((AtFinderViewModel) r1.f.getValue()).getSearchResultList(r1.d);
        r2.removeObserver(r1.t);
        r2.observe(r1.a, r1.t);
        r1.g.setValue(CollectionsKt.emptyList());
        r1.i.setValue(CollectionsKt.emptyList());
        MutableLiveData<Boolean> r3 = r1.k;
        Boolean r4 = Boolean.FALSE;
        r3.setValue(r4);
        r1.m.setValue(r4);
        r1.o.setValue(BitableSuperAgentAtViewModel.ViewMode.DEFAULT);
    L9:
        this.d.a("");
        kn4.g.b r5 = this.e;
        if (r5 == null) goto L13;
        r5.b(true);
        return;
    L13:
        return;
    }

    public final void close() {
        j();
    }

    public final boolean isShowing() {
        return this.g;
    }

    public final void b(kn4.g.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e = r2;
    }

    public final void f(kn4.g.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.f = r2;
    }

    public final void x0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        this.d.a(r2);
    }

    public h(FragmentActivity r2, String r3, BitableSuperAgentAtView r4, r r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "baseId");
        Intrinsics.checkNotNullParameter(r4, "atView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        BitableSuperAgentAtViewModel r0 = new BitableSuperAgentAtViewModel(r2, r3, r5);
        this.d = r0;
        r4.setVisibility(8);
        r0.s = new BitableSuperAgentAtWindow$1(this);
    }
}
