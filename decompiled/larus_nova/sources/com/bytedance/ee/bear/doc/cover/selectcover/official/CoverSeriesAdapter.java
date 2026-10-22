package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import my4.g;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 $2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0016\u0010\u001d\u001a\u00020\u00152\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\rJ\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter$CoverSeriesViewHolder;", "<init>", "()V", "mLanguage", "", "mCoverSeriesList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverSeries;", "mCoverImageAdapter", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter;", "mCoverClickListener", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OnOfficialCoverClickListener;", "mContainerWidth", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "setLanguage", "language", "updateContainerWidth", "containerWidth", "getContainerWidth", "setData", "coverSeriesList", "", "setOnCoverClickListener", "listener", "getItemViewType", "getItemCount", "Companion", "CoverSeriesViewHolder", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverSeriesAdapter extends RecyclerView.Adapter<CoverSeriesViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f217828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<OfficialCoverData.CoverSeries> f217829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CoverImageAdapter f217830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f217831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f217832e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter$CoverSeriesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter;Landroid/view/View;)V", "titleTV", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "setTitleTV", "(Landroid/widget/TextView;)V", "imageRV", "Landroidx/recyclerview/widget/RecyclerView;", "getImageRV", "()Landroidx/recyclerview/widget/RecyclerView;", "setImageRV", "(Landroidx/recyclerview/widget/RecyclerView;)V", "bottomPlaceHolder", "getBottomPlaceHolder", "()Landroid/view/View;", "setBottomPlaceHolder", "(Landroid/view/View;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CoverSeriesViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f217833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView f217834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f217835c;

        public CoverSeriesViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217833a = (TextView) r100.findViewById(R.id.title);
            this.f217834b = (RecyclerView) r100.findViewById(R.id.image_recyclerview);
            this.f217835c = r100.findViewById(R.id.bottom_place_holder);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f217829b).size();
    }

    public CoverSeriesAdapter() {
        this.f217828a = "";
        this.f217829b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        CoverSeriesViewHolder r102 = (CoverSeriesViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        OfficialCoverData.CoverSeries r103 = (OfficialCoverData.CoverSeries) ListProtector.get(this.f217829b, r101);
        TextView r104 = r102.f217833a;
        String r105 = this.f217828a;
        if (Intrinsics.areEqual(r105, Locale.CHINESE.getLanguage()) == false) goto L5;
    L20:
        OfficialCoverData.Series r106 = r103.getSeries();
        if (r106 == null) goto L23;
        String r107 = r106.getZh();
    L24:
        r104.setText(r107);
        CoverImageAdapter r108 = new CoverImageAdapter(this.f217832e);
        List<OfficialCoverData.CoverItem> r109 = r103.getCandidateCovers();
        if (r109 == null) goto L27;
        ((ArrayList) r108.f217823b).clear();
        ((ArrayList) r108.f217823b).addAll(r109);
        r108.notifyDataSetChanged();
    L27:
        this.f217830c = r108;
        RecyclerView r110 = r102.f217834b;
        r110.setAdapter(r108);
        r110.setLayoutManager(new GridLayoutManager(r102.itemView.getContext(), 4));
        r110.addItemDecoration(new CoverImageDecoration());
        View r111 = r102.f217835c;
        if (r101 != (getItemCount() - 1)) goto L30;
        int r112 = 0;
    L31:
        r111.setVisibility(r112);
        g r113 = this.f217831d;
        if (r113 == null) goto L37;
        CoverImageAdapter r114 = this.f217830c;
        if (r114 == null) goto L38;
        Intrinsics.checkNotNullParameter(r113, "listener");
        r114.f217824c = r113;
        return;
    L38:
        return;
    L37:
        return;
    L30:
        r112 = 8;
    L23:
        r107 = null;
        goto L24
    L5:
        if (Intrinsics.areEqual(r105, Locale.CHINA.getLanguage()) == true) goto L20;
        if (Intrinsics.areEqual(r105, Locale.JAPANESE.getLanguage()) == false) goto L13;
        OfficialCoverData.Series r115 = r103.getSeries();
        if (r115 == null) goto L23;
        r107 = r115.getJp();
        goto L24
    L13:
        if (Intrinsics.areEqual(r105, Locale.ENGLISH.getLanguage()) == false) goto L17;
        OfficialCoverData.Series r116 = r103.getSeries();
        if (r116 == null) goto L23;
        r107 = r116.getEn();
        goto L24
    L17:
        OfficialCoverData.Series r117 = r103.getSeries();
        if (r117 == null) goto L23;
        r107 = r117.getEn();
        goto L24
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_cover_series_item, null);
        Intrinsics.checkNotNull(r102);
        return new CoverSeriesViewHolder(r102);
    }
}
