package com.larus.bmhome.view.actionbar.gaokao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.actionbar.gaokao.a;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoProvince;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import ct8.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter$GaokaoProvinceViewHolder;", "dataList", "", "Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoProvince;", "currentProvinceKey", "", "noDefaultProvinceProvided", "", "selectCallback", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "defaultCityKey", "currentSelectedViewHolder", "currentProvince", "getCurrentProvince", "getCurrentSelectedPosition", "", "isLatestOneSelected", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "GaokaoProvinceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoProvinceAdapter extends RecyclerView.Adapter<GaokaoProvinceViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GaokaoProvince> f316765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f316766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f316767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<GaokaoProvince, Unit> f316768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f316769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GaokaoProvinceViewHolder f316770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GaokaoProvince f316771g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter$GaokaoProvinceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootView", "getRootView", "()Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textViewPostfix", "getTextViewPostfix", "selectedView", "getSelectedView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GaokaoProvinceViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f316772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f316773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f316774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f316775d;

        public GaokaoProvinceViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f316772a = r100.findViewById(R.id.item_root);
            this.f316773b = (TextView) r100.findViewById(R.id.item_text);
            this.f316774c = (TextView) r100.findViewById(R.id.item_text_postfix);
            this.f316775d = r100.findViewById(R.id.item_selected);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f316765a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final GaokaoProvinceViewHolder r102 = (GaokaoProvinceViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final GaokaoProvince r103 = (GaokaoProvince) ListProtector.get(this.f316765a, r101);
        View r104 = r102.f316775d;
        int r105 = 4;
        if (r104 != null) goto L5;
    L9:
        TextView r106 = r102.f316774c;
        if (r106 != null) goto L12;
    L20:
        TextView r107 = r102.f316773b;
        if (r107 == null) goto L23;
        r107.setText(r103.getProvince());
    L23:
        View r108 = r102.f316772a;
        if (r108 == null) goto L27;
        r108.setOnClickListener(new b(r103, this, r102));
        return;
    L27:
        return;
    L12:
        if (Intrinsics.areEqual(r103.getKey(), this.f316769e) == true) goto L14;
    L19:
        r106.setVisibility(r105);
        goto L20
    L14:
        if (this.f316767c == true) goto L19;
        String r109 = "（" + AppHost.f326268a.getApplication().getString(R.string.larus_Province_pad_ip_hint) + 65289;
        TextView r110 = r102.f316774c;
        if (r110 == null) goto L18;
        r110.setText(r109);
    L18:
        r105 = 0;
        goto L19
    L5:
        if (Intrinsics.areEqual(r103.getKey(), this.f316766b) == false) goto L7;
        this.f316770f = r102;
        int r111 = 0;
    L8:
        r104.setVisibility(r111);
        goto L9
    L7:
        r111 = 4;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_gaokao_province, r100, false);
        Intrinsics.checkNotNull(r102);
        return new GaokaoProvinceViewHolder(r102);
    }

    public GaokaoProvinceAdapter(List r100, String r101, boolean r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        this.f316765a = r100;
        this.f316766b = r101;
        this.f316767c = r102;
        this.f316768d = r103;
        this.f316769e = r101;
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((GaokaoProvince) r105).getKey(), this.f316766b) == false) goto L4;
    L9:
        this.f316771g = (GaokaoProvince) r105;
        return;
    L8:
        r105 = null;
        goto L9
    }
}
