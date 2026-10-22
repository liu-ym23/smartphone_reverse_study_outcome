package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.biz.videopip.LifeVideoPipSessionManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/poi/newdetail/widget/trip/PoiHeadViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TripPoiHeadAdapter extends RecyclerView.Adapter<PoiHeadViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f263525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f263526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f263527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f263528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f263529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f263530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f263531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s f263532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends PoiPhoto> f263533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Integer> f263534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<Integer, WeakReference<PoiHeadViewHolder>> f263535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TripPoiHeadAdapter$showTypeChangeListener$1 f263536l;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends PoiPhoto> r100 = this.f263533i;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        List<? extends PoiPhoto> r101 = this.f263533i;
        if (r101 == null) goto L9;
        PoiPhoto r102 = (PoiPhoto) ListProtector.get(r101, r100);
        if (r102 == null) goto L9;
        if (r102.mediaType != 1) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return 1;
    L12:
        return 0;
    L9:
        r103 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PoiHeadViewHolder r102 = (PoiHeadViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Integer r103 = Integer.valueOf(r101);
        this.f263535k.put(r103, new WeakReference(r102));
        List<? extends PoiPhoto> r104 = this.f263533i;
        if (r104 == null) goto L9;
        if (r101 >= 0) goto L6;
        return;
    L6:
        if (r101 >= r104.size()) goto L11;
        r102.U3((PoiPhoto) ListProtector.get(r104, r101), this.f263526b, r101);
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        if (r111 != 1) goto L5;
        View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.saas_poi_item_trip_head_video, r110, false);
        com.bytedance.locallife.biz.videopip.b r113 = LifeVideoPipSessionManager.f256999a;
        PoiHeadViewHolder r114 = new TripPoiHeadVideoViewHolder(r112, this.f263525a, this.f263528d, this.f263529e, !LifeVideoPipSessionManager.c(this.f263530f), this.f263530f, this.f263532h);
    L6:
        r112.setOnClickListener(new e(r112, r114, this));
        return r114;
    L5:
        r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.saas_poi_item_trip_head_image, r110, false);
        r114 = new TripPoiHeadImageViewHolder(r112, this.f263536l, this.f263534j, this.f263526b, this.f263527c, this.f263528d, this.f263529e);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadAdapter$showTypeChangeListener$1] */
    public TripPoiHeadAdapter(boolean r100, int r101, boolean r102, int r103, int r104, String r105, f r106, TripPoiHeadWidget.d r107) {
        Intrinsics.checkNotNullParameter(r105, "poiEnterId");
        this.f263525a = r100;
        this.f263526b = r101;
        this.f263527c = r102;
        this.f263528d = r103;
        this.f263529e = r104;
        this.f263530f = r105;
        this.f263531g = r106;
        this.f263532h = r107;
        this.f263535k = new HashMap();
        this.f263536l = new TripPoiHeadAdapter$showTypeChangeListener$1(this);
    }
}
