package com.bytedance.ee.bear.debug.net;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qx4.l;
import qx4.m;
import qx4.n;
import qx4.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/debug/net/RequestListFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "adapter", "Lcom/bytedance/ee/bear/debug/net/RequestAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initTitleBar", "root", "initSearchBar", "search", "query", "", "initRecycler", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestListFragment extends BaseFragment {
    public final RequestAdapter e;

    public static final class a {
    }

    static {
    }

    public RequestListFragment() {
        this.e = new RequestAdapter();
    }

    public static final void U90(RequestListFragment r7, String r8) {
        r7.getClass();
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        r7.e.setNewData(o0.a);
        return;
    L19:
        ArrayList<DebugRequest> r1 = o0.a;     // Catch: Exception -> L16
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L16
        Iterator<DebugRequest> r3 = r1.iterator();     // Catch: Exception -> L16
    L10:
        if (r3.hasNext() == false) goto L14;
        DebugRequest r4 = r3.next();     // Catch: Exception -> L16
        if (StringsKt.contains$default(r4.b, r8, false, 2, null) == false) goto L10;
        r2.add(r4);     // Catch: Exception -> L16
        goto L10
    L14:
        r7.e.setNewData(r2);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        tt5.a.d("RequestListFragment", "search " + e.getMessage());
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        r4.findViewById(2131388775).setTitle("网络请求");
        r4.findViewById(2131388775).a(new n(this), true);
        r4.findViewById(2131388775).a(new o(this), true);
        ((ImageView) r4.findViewById(2131366930)).setOnClickListener(new l(r4, this));
        ((ImageView) r4.findViewById(2131366930)).setVisibility(8);
        r4.findViewById(2131375327).addTextChangedListener(new m(this, r4));
        r4.findViewById(2131384070).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        r4.findViewById(2131384070).setAdapter(this.e);
        this.e.setNewData(o0.a);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561241, r3, false);
    }
}
