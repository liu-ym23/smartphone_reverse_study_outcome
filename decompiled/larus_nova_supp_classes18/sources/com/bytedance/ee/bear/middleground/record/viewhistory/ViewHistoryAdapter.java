package com.bytedance.ee.bear.middleground.record.viewhistory;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import org.koin.java.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ViewHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<RecordListResult.a> a;
    public final String b;

    public final int getItemCount() {
        return this.a.size();
    }

    public ViewHistoryAdapter(List r1) {
        this.a = r1;
        this.b = ((i0) a.a(i0.class)).a();
    }

    public final int getItemViewType(int r2) {
        return ((RecordListResult.a) ListProtector.get(this.a, r2)).i;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        int r0 = getItemViewType(r10);
        if (r0 != 0) goto L5;
        ((ViewHistoryFooterViewHolder) r9).getClass();
        return;
    L5:
        if (r0 != 1) goto L7;
        ViewHistoryBaseViewHolder r11 = (ViewHistoryBaseViewHolder) r9;
        r11.U3((RecordListResult.a) ListProtector.get(this.a, r10));
        if (r10 != 0) goto L38;
        r11.e.setVisibility(4);
        return;
    L38:
        return;
    L7:
        if (r0 != 2) goto L9;
        ViewHistoryBaseViewHolder r12 = (ViewHistoryBaseViewHolder) r9;
        r12.T3((RecordListResult.a) ListProtector.get(this.a, r10), false, false);
        r12.c.setVisibility(0);
        r12.c.setText(n.x(r12.f, 2131887408));
        if (r10 != 0) goto L36;
        r12.e.setVisibility(4);
        return;
    L36:
        return;
    L9:
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L14;
        ViewHistoryBaseViewHolder r13 = (ViewHistoryBaseViewHolder) r9;
        r13.U3((RecordListResult.a) ListProtector.get(this.a, r10));
        if (r10 != 0) goto L30;
        r13.e.setVisibility(4);
        return;
    L30:
        return;
    L14:
        ViewHistoryBaseViewHolder r14 = (ViewHistoryBaseViewHolder) r9;
        r14.T3((RecordListResult.a) ListProtector.get(this.a, r10), true, false);
        r14.c.setVisibility(8);
        if (r10 != 0) goto L32;
        r14.e.setVisibility(4);
        return;
    L32:
        return;
    L17:
        ViewHistoryBaseViewHolder r15 = (ViewHistoryBaseViewHolder) r9;
        RecordListResult.a r1 = (RecordListResult.a) ListProtector.get(this.a, r10);
        r15.T3(r1, false, false);
        r15.c.setVisibility(0);
        r15.c.setText(xo5.a.c(r15.f, 2131887422, "location", r1.g));
        if (TextUtils.isEmpty(r1.g) == false) goto L20;
        r15.c.setVisibility(8);
    L20:
        if (r10 != 0) goto L34;
        r15.e.setVisibility(4);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 0) goto L7;
        return new ViewHistoryFooterViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131568173, r3, false));
    L7:
        return new ViewHistoryBaseViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131568174, r3, false), this.b);
    }
}
