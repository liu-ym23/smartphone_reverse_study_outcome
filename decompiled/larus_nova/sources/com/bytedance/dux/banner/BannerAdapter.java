package com.bytedance.dux.banner;

import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dux/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/dux/banner/BannerViewHolder;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ol4.a f204843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d> f204844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f204845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ol4.b f204846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHashMap<BannerViewHolder, Unit> f204847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends b> f204848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f204849g;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f204849g == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.f204848f.size();
    }

    public BannerAdapter(DuxBanner r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerOperator");
        this.f204843a = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        this.f204844b = r101;
        ArrayList r102 = new ArrayList();
        this.f204845c = r102;
        this.f204847e = new WeakHashMap();
        this.f204848f = CollectionsKt.emptyList();
        this.f204849g = true;
        StubViewHolder.a r103 = StubViewHolder.f204878g;
        Intrinsics.checkNotNullParameter(r103, "factory");
        r101.put("_stub", r103);
        r102.add(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (((ArrayList) this.f204845c).isEmpty() == true) goto L11;
        if (this.f204848f.isEmpty() == false) goto L7;
        StubViewHolder.a r101 = StubViewHolder.f204878g;
    L8:
        d r102 = (d) ((LinkedHashMap) this.f204844b).get("_stub");
        return CollectionsKt.indexOf(this.f204845c, r102);
    L7:
        List<? extends b> r103 = this.f204848f;
        ((b) ListProtector.get(r103, r100 % r103.size())).a();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        BannerViewHolder r101 = (BannerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        ol4.a r102 = r101.f204853b;
        if (r102 == null) goto L7;
        LiveData<Integer> r103 = r102.getSelectedPosition();
        if (r103 == null) goto L7;
        r103.observeForever(r101.f204856e);
    L7:
        this.f204847e.put(r101, Unit.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        BannerViewHolder r101 = (BannerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        ol4.a r102 = r101.f204853b;
        if (r102 == null) goto L7;
        LiveData<Integer> r103 = r102.getSelectedPosition();
        if (r103 == null) goto L7;
        r103.removeObserver(r101.f204856e);
    L7:
        CoroutineScope r104 = r101.f204855d;
        if (r104 == null) goto L10;
        CoroutineScopeKt.cancel$default(r104, null, 1, null);
    L10:
        r101.f204852a = false;
        this.f204847e.remove(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        BannerViewHolder r101 = (BannerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BannerViewHolder r102 = (BannerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        int r103 = pl4.a.f529758a;
        boolean r104 = this.f204849g;
        int r105 = this.f204848f.size();
        if (r104 == false) goto L10;
        if (r105 > 0) goto L8;
        r105 = 1;
    L8:
        r101 = r101 % r105;
    L10:
        if (this.f204848f.isEmpty() == false) goto L12;
        f r106 = new f();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r106, "data");
        r102.f204854c = r101;
        r102.U3(r106);
        r102.T3(true);
        return;
    L12:
        b r107 = (b) ListProtector.get(this.f204848f, r101);
        if ((r107 instanceof c) == false) goto L15;
        ((c) r107).b();
    L15:
        this.f204843a.b(r102);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r107, "data");
        r102.f204854c = r101;
        r102.U3(r107);
        r102.T3(true);
        r102.itemView.setTag(R.id.banner_pos_key, Integer.valueOf(r101));
        if (r102.itemView.hasOnClickListeners() == true) goto L20;
        r102.itemView.setOnClickListener(new a(this));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (((ArrayList) this.f204845c).isEmpty() == true) goto L7;
        StubViewHolder r102 = ((d) ListProtector.get(this.f204845c, r101)).a(r100);
        r102.f204853b = this.f204843a;
        return r102;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }
}
