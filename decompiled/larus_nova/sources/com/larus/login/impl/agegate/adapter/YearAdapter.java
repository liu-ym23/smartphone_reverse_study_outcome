package com.larus.login.impl.agegate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.login.impl.agegate.h0;
import com.larus.login.impl.databinding.LarusItemYearBinding;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wj9.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/login/impl/agegate/adapter/YearAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/login/impl/agegate/adapter/YearAdapter$YearViewHolder;", "years", "", "", "listener", "Lcom/larus/login/impl/agegate/IClickChooseAgeListener;", "<init>", "(Ljava/util/List;Lcom/larus/login/impl/agegate/IClickChooseAgeListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "YearViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YearAdapter extends RecyclerView.Adapter<YearViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f357323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f357324b;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/login/impl/agegate/adapter/YearAdapter$YearViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/login/impl/databinding/LarusItemYearBinding;", "<init>", "(Lcom/larus/login/impl/databinding/LarusItemYearBinding;)V", "bind", "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class YearViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusItemYearBinding f357325a;

        public YearViewHolder(LarusItemYearBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f357580a);
            this.f357325a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f357323a.size();
    }

    public YearAdapter(List<String> r100, h0 r101) {
        Intrinsics.checkNotNullParameter(r100, "years");
        this.f357323a = r100;
        this.f357324b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        YearViewHolder r102 = (YearViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final String r103 = (String) ListProtector.get(this.f357323a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
        r102.f357325a.f357581b.setText(r103);
        r102.itemView.setOnClickListener(new c(this, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_year, r100, false);
        if (r102 == null) goto L7;
        TextView r103 = (TextView) r102;
        return new YearViewHolder(new LarusItemYearBinding(r103, r103));
    L7:
        throw new NullPointerException("rootView");
    }
}
