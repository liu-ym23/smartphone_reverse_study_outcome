package com.bytedance.ee.bear.debug.net;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qx4.l;
import qx4.m;
import qx4.n;
import qx4.o;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/debug/net/RequestListFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "adapter", "Lcom/bytedance/ee/bear/debug/net/RequestAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initTitleBar", RootDescription.ROOT_ELEMENT, "initSearchBar", "search", "query", "", "initRecycler", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestListFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RequestAdapter f217405e;

    public static final class a {
    }

    static {
    }

    public RequestListFragment() {
        this.f217405e = new RequestAdapter();
    }

    public static final void U90(RequestListFragment r100, String r101) {
        r100.getClass();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L19;
        r100.f217405e.setNewData(o0.f217119a);
        return;
    L19:
        ArrayList<DebugRequest> r103 = o0.f217119a;     // Catch: Exception -> L16
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L16
        Iterator<DebugRequest> r105 = r103.iterator();     // Catch: Exception -> L16
    L10:
        if (r105.hasNext() == false) goto L14;
        DebugRequest r106 = r105.next();     // Catch: Exception -> L16
        if (StringsKt.contains$default(r106.f216897b, r101, false, 2, null) == false) goto L10;
        r104.add(r106);     // Catch: Exception -> L16
        goto L10
    L14:
        r100.f217405e.setNewData(r104);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        tt5.a.d("RequestListFragment", "search " + e.getMessage());
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((BaseTitleBar) r100.findViewById(R.id.titleBar)).setTitle("网络请求");
        ((BaseTitleBar) r100.findViewById(R.id.titleBar)).a(new n(this), true);
        ((BaseTitleBar) r100.findViewById(R.id.titleBar)).a(new o(this), true);
        ((ImageView) r100.findViewById(R.id.clearIcon)).setOnClickListener(new l(r100, this));
        ((ImageView) r100.findViewById(R.id.clearIcon)).setVisibility(8);
        ((SpaceEditText) r100.findViewById(R.id.inputEt)).addTextChangedListener(new m(this, r100));
        ((RecyclerView) r100.findViewById(R.id.recycler)).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        ((RecyclerView) r100.findViewById(R.id.recycler)).setAdapter(this.f217405e);
        this.f217405e.setNewData(o0.f217119a);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_request_list, r101, false);
    }
}
