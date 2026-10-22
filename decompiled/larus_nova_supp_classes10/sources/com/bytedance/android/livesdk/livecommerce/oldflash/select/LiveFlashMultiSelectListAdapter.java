package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.checkbox.ECCheckBox;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashMultiSelectListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<k> a;
    public final Function1<String, Unit> b;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ECCheckBox b;

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390394);
            this.b = r2.findViewById(2131370510);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveFlashMultiSelectListAdapter a;
        public final /* synthetic */ k b;

        public c(LiveFlashMultiSelectListAdapter r1, k r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b.invoke(this.b.a);
        }
    }

    static {
    }

    public final int getItemViewType(int r1) {
        return 1;
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveFlashMultiSelectListAdapter(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clickCallback");
        this.b = r2;
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        k r0 = (k) ListProtector.get(this.a, r6);
        if ((r5 instanceof b) == false) goto L11;
        b r7 = (b) r5;
        TextView r1 = r7.a;
        r1.setText(r0.a);
        Context r2 = r1.getContext();
        if (r0.b == false) goto L7;
        int r3 = 2131101581;
    L8:
        r1.setTextColor(th.a.a(r2, r3));
        r7.b.setChecked(r0.b);
        r5.itemView.setOnClickListener(new c(this, r0));
        return;
    L7:
        r3 = 2131101610;
        goto L8
    L11:
        throw new IllegalStateException("Invalid type ".concat(((k) ListProtector.get(this.a, r6)).getClass().getName()).toString());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 1) goto L11;
        Context r1 = r4.getContext();
        if (r1 == null) goto L7;
        Context r0 = th.a.e(r1, true);
    L9:
        return new b(LayoutInflater.from(r0).inflate(2131560761, r4, false));
    L7:
        r0 = null;
        goto L9
    L11:
        throw new IllegalStateException(("Invalid type " + r5).toString());
    }
}
