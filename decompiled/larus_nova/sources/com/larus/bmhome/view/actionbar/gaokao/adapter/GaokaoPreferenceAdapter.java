package com.larus.bmhome.view.actionbar.gaokao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import ct8.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter$GaokaoPreferenceViewHolder;", "dataList", "", "", "maxSelectedNum", "", "selectCallback", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "currentSelectedViewHolder", "selectedPosition", "Ljava/util/TreeSet;", "getMaxSelectedNum", "getSelectedList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setSelectedStatus", "isSelected", "", "getItemCount", "GaokaoPreferenceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoPreferenceAdapter extends RecyclerView.Adapter<GaokaoPreferenceViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f316755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f316756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<List<String>, Unit> f316757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GaokaoPreferenceViewHolder f316758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TreeSet<Integer> f316759e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter$GaokaoPreferenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "rootView", "getRootView", "()Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GaokaoPreferenceViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f316760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f316761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f316762c;

        public final Context getContext() {
            return this.f316760a;
        }

        public GaokaoPreferenceViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f316760a = r100.getContext();
            this.f316761b = r100.findViewById(R.id.item_root);
            this.f316762c = (TextView) r100.findViewById(R.id.item_text);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f316755a.size();
    }

    public final List<String> y2() {
        ArrayList r100 = new ArrayList();
        Iterator<Integer> r101 = this.f316759e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        int r102 = r101.next().intValue();
        r100.add(ListProtector.get(this.f316755a, r102));
        goto L4
    L6:
        return r100;
    }

    public static void z2(GaokaoPreferenceViewHolder r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == false) goto L11;
        TextView r102 = r100.f316762c;
        if (r102 == null) goto L8;
        r102.setTextColor(ContextCompat.getColor(r100.getContext(), c.b(R.attr.larus_primary_50, r100.getContext(), R.color.larus_primary_50)));
    L8:
        View r103 = r100.f316761b;
        if (r103 == null) goto L18;
        r103.setBackgroundResource(c.b(R.attr.larus_bg_gaokao_8_radius_selected, r103.getContext(), R.drawable.larus_bg_gaokao_8_radius_selected));
        return;
    L18:
        return;
    L11:
        TextView r104 = r100.f316762c;
        if (r104 == null) goto L14;
        r104.setTextColor(ContextCompat.getColor(r100.getContext(), c.b(R.attr.larus_neutral_100, r100.getContext(), R.color.larus_neutral_100)));
    L14:
        View r105 = r100.f316761b;
        if (r105 == null) goto L20;
        r105.setBackgroundResource(c.b(R.attr.larus_bg_gaokao_8_radius, r105.getContext(), R.drawable.larus_bg_gaokao_8_radius));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        final GaokaoPreferenceViewHolder r102 = (GaokaoPreferenceViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ListProtector.get(this.f316755a, r101);
        TextView r104 = r102.f316762c;
        if (r104 == null) goto L5;
        r104.setText(r103);
    L5:
        z2(r102, this.f316759e.contains(Integer.valueOf(r101)));
        View r105 = r102.f316761b;
        if (r105 == null) goto L9;
        e1.d(r105, new a(r102, this, r101));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_gaokao_preference, r100, false);
        Intrinsics.checkNotNull(r102);
        return new GaokaoPreferenceViewHolder(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GaokaoPreferenceAdapter(List<String> r100, int r101, Function1<? super List<String>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        this.f316755a = r100;
        this.f316756b = r101;
        this.f316757c = r102;
        this.f316759e = new TreeSet();
    }
}
