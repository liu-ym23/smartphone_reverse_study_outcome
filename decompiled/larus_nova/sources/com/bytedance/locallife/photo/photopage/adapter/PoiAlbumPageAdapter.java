package com.bytedance.locallife.photo.photopage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;
import com.bytedance.locallife.photo.photopage.fragment.PoiAlbumFragment;
import com.bytedance.locallife.photo.photopage.view.PoiAlbumBaseViewHolder;
import com.bytedance.locallife.photo.photopage.view.PoiAlbumHighLightPicVH;
import com.bytedance.locallife.photo.photopage.view.PoiAlbumPhotoViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/adapter/PoiAlbumPageAdapter;", "Lcom/bytedance/locallife/photo/photopage/adapter/BaseAdapter;", "Lcom/bytedance/locallife/model/album/PhotoData;", "Lcom/bytedance/locallife/photo/album/model/PhotoData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumPageAdapter extends BaseAdapter<PhotoData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f262155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AlbumViewModel f262156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f262157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f262158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, WeakReference<PoiAlbumBaseViewHolder>> f262159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f262160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f262161j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemViewType(int r100) {
        List<T> r101 = this.f262151c;
        if (r101 == 0) goto L22;
        if (r100 >= 0) goto L6;
        return 10086;
    L6:
        if (r100 >= r101.size()) goto L26;
        PhotoData r102 = (PhotoData) ListProtector.get(r101, r100);
        boolean r103 = false;
        if (r102.getMediaType() != 0) goto L11;
    L14:
        boolean r104 = true;
    L16:
        if (r102.getHighlight() == null) goto L18;
        r103 = true;
    L18:
        if (r103 == false) goto L24;
        if (r104 == false) goto L25;
        return 12121;
    L25:
        return 10086;
    L24:
        return 10086;
    L11:
        if (Intrinsics.areEqual(this.f262158g, "highlight") == true) goto L14;
        r104 = false;
        goto L16
    L26:
        return 10086;
    L22:
        return 10086;
    }

    @Override // com.bytedance.locallife.photo.photopage.adapter.LoadMoreRecyclerViewAdapter, com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof PoiAlbumBaseViewHolder) == false) goto L6;
        ((PoiAlbumBaseViewHolder) r100).T3(r101);
        Integer r102 = Integer.valueOf(r101);
        this.f262159h.put(r102, new WeakReference(r100));
        return;
    }

    @Override // com.bytedance.locallife.photo.photopage.adapter.LoadMoreRecyclerViewAdapter, com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        Context r102 = null;
        if (r101 != 12121) goto L7;
        if (r100 == null) goto L11;
        r102 = r100.getContext();
    L11:
        return new PoiAlbumHighLightPicVH(LayoutInflater.from(r102).inflate(R.layout.poi_album_spot_pic_item_layout, r100, false), this.f262156e, this.f262157f, this.f262158g);
    L7:
        if (r100 == null) goto L10;
        r102 = r100.getContext();
    L10:
        return new PoiAlbumPhotoViewHolder(LayoutInflater.from(r102).inflate(R.layout.poi_album_photo_item_layout, r100, false), this.f262156e, this.f262157f, this.f262158g);
    }

    public PoiAlbumPageAdapter(RecyclerView r100, AlbumViewModel r101, int r102, String r103, PoiAlbumFragment r104) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r103, "tabId");
        this.f262155d = r100;
        this.f262156e = r101;
        this.f262157f = r102;
        this.f262158g = r103;
        this.f262159h = new LinkedHashMap();
        if (this.f262153a == true) goto L5;
        this.f262153a = true;
        y2(true);
    L5:
        this.f262160i = -1;
        this.f262161j = -1;
    }
}
