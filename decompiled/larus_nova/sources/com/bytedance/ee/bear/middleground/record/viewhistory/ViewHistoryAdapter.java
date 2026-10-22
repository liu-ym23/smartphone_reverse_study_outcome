package com.bytedance.ee.bear.middleground.record.viewhistory;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import org.koin.java.a;

/* JADX INFO: loaded from: classes18.dex */
public class ViewHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<RecordListResult.a> f234350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f234351b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f234350a.size();
    }

    public ViewHistoryAdapter(List r100) {
        this.f234350a = r100;
        this.f234351b = ((i0) a.a(i0.class)).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((RecordListResult.a) ListProtector.get(this.f234350a, r100)).f234345i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        int r101 = getItemViewType(r110);
        if (r101 != 0) goto L5;
        ((ViewHistoryFooterViewHolder) r100).getClass();
        return;
    L5:
        if (r101 != 1) goto L7;
        ViewHistoryBaseViewHolder r102 = (ViewHistoryBaseViewHolder) r100;
        r102.U3((RecordListResult.a) ListProtector.get(this.f234350a, r110));
        if (r110 != 0) goto L38;
        r102.f234356e.setVisibility(4);
        return;
    L38:
        return;
    L7:
        if (r101 != 2) goto L9;
        ViewHistoryBaseViewHolder r103 = (ViewHistoryBaseViewHolder) r100;
        r103.T3((RecordListResult.a) ListProtector.get(this.f234350a, r110), false, false);
        r103.f234354c.setVisibility(0);
        r103.f234354c.setText(n.x(r103.f234357f, R.string.CreationMobile_Stats_Visits_AnonVisitDesc));
        if (r110 != 0) goto L36;
        r103.f234356e.setVisibility(4);
        return;
    L36:
        return;
    L9:
        if (r101 == 3) goto L17;
        if (r101 == 4) goto L14;
        ViewHistoryBaseViewHolder r104 = (ViewHistoryBaseViewHolder) r100;
        r104.U3((RecordListResult.a) ListProtector.get(this.f234350a, r110));
        if (r110 != 0) goto L30;
        r104.f234356e.setVisibility(4);
        return;
    L30:
        return;
    L14:
        ViewHistoryBaseViewHolder r105 = (ViewHistoryBaseViewHolder) r100;
        r105.T3((RecordListResult.a) ListProtector.get(this.f234350a, r110), true, false);
        r105.f234354c.setVisibility(8);
        if (r110 != 0) goto L32;
        r105.f234356e.setVisibility(4);
        return;
    L32:
        return;
    L17:
        ViewHistoryBaseViewHolder r106 = (ViewHistoryBaseViewHolder) r100;
        RecordListResult.a r107 = (RecordListResult.a) ListProtector.get(this.f234350a, r110);
        r106.T3(r107, false, false);
        r106.f234354c.setVisibility(0);
        r106.f234354c.setText(xo5.a.c(r106.f234357f, R.string.CreationMobile_Stats_Visits_VisitFrom, "location", r107.f234343g));
        if (TextUtils.isEmpty(r107.f234343g) == false) goto L20;
        r106.f234354c.setVisibility(8);
    L20:
        if (r110 != 0) goto L34;
        r106.f234356e.setVisibility(4);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 0) goto L7;
        return new ViewHistoryFooterViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.view_history_item_bottom, r100, false));
    L7:
        return new ViewHistoryBaseViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.view_history_item_user, r100, false), this.f234351b);
    }
}
