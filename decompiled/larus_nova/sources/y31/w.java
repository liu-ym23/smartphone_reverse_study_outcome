package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.ReserveTabViewHolder;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class w extends me.drakeet.multitype.b<a, ReserveTabViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f565840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f565841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f565842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f565843d;

        public a() {
            this.f565840a = "";
        }
    }

    public w() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        ReserveTabViewHolder r102 = (ReserveTabViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r103, "p1");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, AppConstants.BUNDLE_TIP);
        r102.f96276a = r103;
        TextView r104 = r102.f96277b;
        if (r104 == null) goto L5;
        r104.setText(r103.f565840a);
    L5:
        a r105 = r102.f96276a;
        if (r105 != null) goto L8;
    L15:
        TextView r106 = r102.f96277b;
        if (r106 == null) goto L19;
        r106.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.u(r102, r103));
        return;
    L19:
        return;
    L8:
        if (r105.f565843d != true) goto L15;
        TextView r107 = r102.f96277b;
        if (r107 == null) goto L12;
        r107.setBackground(s1.m(R.drawable.ttlive_pk_record_select_drawable));
    L12:
        TextView r108 = r102.f96277b;
        if (r108 == null) goto L15;
        r108.setTextColor(s1.h(R.color.black));
        goto L15
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ReserveTabViewHolder(r100.inflate(R.layout.ttlive_item_record_tab, r101, false));
    }
}
