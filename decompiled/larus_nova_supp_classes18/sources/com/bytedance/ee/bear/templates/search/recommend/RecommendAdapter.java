package com.bytedance.ee.bear.templates.search.recommend;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter$ViewHodler;", "<init>", "()V", "datas", "", "", "getDatas", "()Ljava/util/List;", "setDatas", "(Ljava/util/List;)V", "onClickItem", "Lkotlin/Function1;", "", "getOnClickItem", "()Lkotlin/jvm/functions/Function1;", "setOnClickItem", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "Companion", "ViewHodler", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendAdapter extends RecyclerView.Adapter<ViewHodler> {
    public List<String> a;
    public Function1<? super String, Unit> b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter$ViewHodler;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "num", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNum", "()Landroid/widget/TextView;", "searchKey", "getSearchKey", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHodler extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;

        public ViewHodler(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131383953);
            this.b = (TextView) r2.findViewById(2131385520);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public RecommendAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ViewHodler r7 = (ViewHodler) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        TextView r0 = r7.a;
        if (r6 == 0) goto L9;
        if (r6 == 1) goto L8;
        if (r6 == 2) goto L7;
        int r3 = 2131248374;
    L10:
        r0.setBackgroundResource(r3);
        Drawable r1 = r7.a.getBackground();
        if (r1 == null) goto L20;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        int r4 = 255;
    L19:
        r1.setAlpha(r4);
        goto L20
    L16:
        r4 = 128;
        goto L19
    L17:
        r4 = 77;
        goto L19
    L18:
        r4 = 37;
    L20:
        TextView r2 = r7.a;
        Resources r8 = ((RecyclerView.ViewHolder) r7).itemView.getContext().getResources();
        if (r6 == 0) goto L27;
        if (r6 == 1) goto L26;
        if (r6 == 2) goto L25;
        int r9 = 2131106607;
    L28:
        r2.setTextColor(r8.getColor(r9));
        r7.a.setText(String.valueOf(r6 + 1));
        r7.b.setText((CharSequence) ListProtector.get(this.a, r6));
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new com.bytedance.ee.bear.templates.search.recommend.a(this, r6));
        return;
    L25:
        r9 = 2131108870;
        goto L28
    L26:
        r9 = 2131108756;
        goto L28
    L27:
        r9 = 2131101119;
        goto L28
    L7:
        r3 = 2131248376;
        goto L10
    L8:
        r3 = 2131248377;
        goto L10
    L9:
        r3 = 2131248375;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564967, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ViewHodler(r5);
    }
}
