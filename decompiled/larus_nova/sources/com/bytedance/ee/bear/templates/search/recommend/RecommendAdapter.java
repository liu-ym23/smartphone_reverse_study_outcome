package com.bytedance.ee.bear.templates.search.recommend;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter$ViewHodler;", "<init>", "()V", "datas", "", "", "getDatas", "()Ljava/util/List;", "setDatas", "(Ljava/util/List;)V", "onClickItem", "Lkotlin/Function1;", "", "getOnClickItem", "()Lkotlin/jvm/functions/Function1;", "setOnClickItem", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "Companion", "ViewHodler", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendAdapter extends RecyclerView.Adapter<ViewHodler> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f239390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f239391b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter$ViewHodler;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "num", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNum", "()Landroid/widget/TextView;", "searchKey", "getSearchKey", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHodler extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f239392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f239393b;

        public ViewHodler(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f239392a = (TextView) r100.findViewById(R.id.recommend_num);
            this.f239393b = (TextView) r100.findViewById(R.id.search_key);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f239390a.size();
    }

    public RecommendAdapter() {
        this.f239390a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHodler r102 = (ViewHodler) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TextView r103 = r102.f239392a;
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L8;
        if (r101 == 2) goto L7;
        int r104 = R.drawable.template_search_num_more;
    L10:
        r103.setBackgroundResource(r104);
        Drawable r105 = r102.f239392a.getBackground();
        if (r105 == null) goto L20;
        if (r101 == 0) goto L18;
        if (r101 == 1) goto L17;
        if (r101 == 2) goto L16;
        int r106 = 255;
    L19:
        r105.setAlpha(r106);
        goto L20
    L16:
        r106 = 128;
        goto L19
    L17:
        r106 = 77;
        goto L19
    L18:
        r106 = 37;
    L20:
        TextView r107 = r102.f239392a;
        Resources r108 = r102.itemView.getContext().getResources();
        if (r101 == 0) goto L27;
        if (r101 == 1) goto L26;
        if (r101 == 2) goto L25;
        int r109 = R.color.text_caption;
    L28:
        r107.setTextColor(r108.getColor(r109));
        r102.f239392a.setText(String.valueOf(r101 + 1));
        r102.f239393b.setText((CharSequence) ListProtector.get(this.f239390a, r101));
        r102.itemView.setOnClickListener(new com.bytedance.ee.bear.templates.search.recommend.a(this, r101));
        return;
    L25:
        r109 = R.color.ud_Y500;
        goto L28
    L26:
        r109 = R.color.ud_O500;
        goto L28
    L27:
        r109 = R.color.colorful_red;
        goto L28
    L7:
        r104 = R.drawable.template_search_num_three;
        goto L10
    L8:
        r104 = R.drawable.template_search_num_two;
        goto L10
    L9:
        r104 = R.drawable.template_search_num_one;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.template_search_recommend_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHodler(r102);
    }
}
