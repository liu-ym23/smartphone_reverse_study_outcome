package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import my4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 $2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0016\u0010\u001d\u001a\u00020\u00152\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\rJ\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter$CoverSeriesViewHolder;", "<init>", "()V", "mLanguage", "", "mCoverSeriesList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverSeries;", "mCoverImageAdapter", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverImageAdapter;", "mCoverClickListener", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OnOfficialCoverClickListener;", "mContainerWidth", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "setLanguage", "language", "updateContainerWidth", "containerWidth", "getContainerWidth", "setData", "coverSeriesList", "", "setOnCoverClickListener", "listener", "getItemViewType", "getItemCount", "Companion", "CoverSeriesViewHolder", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverSeriesAdapter extends RecyclerView.Adapter<CoverSeriesViewHolder> {
    public String a;
    public final List<OfficialCoverData.CoverSeries> b;
    public CoverImageAdapter c;
    public g d;
    public int e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter$CoverSeriesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter;Landroid/view/View;)V", "titleTV", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "setTitleTV", "(Landroid/widget/TextView;)V", "imageRV", "Landroidx/recyclerview/widget/RecyclerView;", "getImageRV", "()Landroidx/recyclerview/widget/RecyclerView;", "setImageRV", "(Landroidx/recyclerview/widget/RecyclerView;)V", "bottomPlaceHolder", "getBottomPlaceHolder", "()Landroid/view/View;", "setBottomPlaceHolder", "(Landroid/view/View;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CoverSeriesViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final RecyclerView b;
        public final View c;

        public CoverSeriesViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131388772);
            this.b = r2.findViewById(2131375051);
            this.c = r2.findViewById(2131364497);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemViewType(int r1) {
        return r1;
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public CoverSeriesAdapter() {
        this.a = "";
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        CoverSeriesViewHolder r7 = (CoverSeriesViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        OfficialCoverData.CoverSeries r0 = (OfficialCoverData.CoverSeries) ListProtector.get(this.b, r6);
        TextView r1 = r7.a;
        String r2 = this.a;
        if (Intrinsics.areEqual(r2, Locale.CHINESE.getLanguage()) == false) goto L5;
    L20:
        OfficialCoverData.Series r3 = r0.getSeries();
        if (r3 == null) goto L23;
        String r4 = r3.getZh();
    L24:
        r1.setText(r4);
        CoverImageAdapter r8 = new CoverImageAdapter(this.e);
        List<OfficialCoverData.CoverItem> r9 = r0.getCandidateCovers();
        if (r9 == null) goto L27;
        ((ArrayList) r8.b).clear();
        ((ArrayList) r8.b).addAll(r9);
        r8.notifyDataSetChanged();
    L27:
        this.c = r8;
        RecyclerView r10 = r7.b;
        r10.setAdapter(r8);
        r10.setLayoutManager(new GridLayoutManager(((RecyclerView.ViewHolder) r7).itemView.getContext(), 4));
        r10.addItemDecoration(new CoverImageDecoration());
        View r11 = r7.c;
        if (r6 != (getItemCount() - 1)) goto L30;
        int r12 = 0;
    L31:
        r11.setVisibility(r12);
        g r13 = this.d;
        if (r13 == null) goto L37;
        CoverImageAdapter r14 = this.c;
        if (r14 == null) goto L38;
        Intrinsics.checkNotNullParameter(r13, "listener");
        r14.c = r13;
        return;
    L38:
        return;
    L37:
        return;
    L30:
        r12 = 8;
    L23:
        r4 = null;
        goto L24
    L5:
        if (Intrinsics.areEqual(r2, Locale.CHINA.getLanguage()) == true) goto L20;
        if (Intrinsics.areEqual(r2, Locale.JAPANESE.getLanguage()) == false) goto L13;
        OfficialCoverData.Series r16 = r0.getSeries();
        if (r16 == null) goto L23;
        r4 = r16.getJp();
        goto L24
    L13:
        if (Intrinsics.areEqual(r2, Locale.ENGLISH.getLanguage()) == false) goto L17;
        OfficialCoverData.Series r17 = r0.getSeries();
        if (r17 == null) goto L23;
        r4 = r17.getEn();
        goto L24
    L17:
        OfficialCoverData.Series r18 = r0.getSeries();
        if (r18 == null) goto L23;
        r4 = r18.getEn();
        goto L24
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r4 = LayoutInflater.from(r2.getContext()).inflate(2131560077, null);
        Intrinsics.checkNotNull(r4);
        return new CoverSeriesViewHolder(r4);
    }
}
