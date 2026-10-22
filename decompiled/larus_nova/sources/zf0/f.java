package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.GuestApplyPaidQueueViewHolder;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends me.drakeet.multitype.b<a, GuestApplyPaidQueueViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f571602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Integer, Unit> f571604d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f571605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ApplyTitlePanelType f571606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Pair<Integer, Integer> f571607c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f571605a == r101.f571605a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f571606b, r101.f571606b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f571607c, r101.f571607c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f571605a * 31;
            ApplyTitlePanelType r101 = this.f571606b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            Pair<Integer, Integer> r105 = this.f571607c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "GuestApplyPaidQueueData(tabIndex=" + this.f571605a + ", panelType=" + this.f571606b + ", pair=" + this.f571607c + ")";
        }

        public /* synthetic */ a(int r100, Pair r101) {
            this(r100, ApplyTitlePanelType.UNKNOWN, r101);
        }

        public a(int r100, ApplyTitlePanelType r101, Pair<Integer, Integer> r102) {
            Intrinsics.checkNotNullParameter(r101, "panelType");
            Intrinsics.checkNotNullParameter(r102, "pair");
            this.f571605a = r100;
            this.f571606b = r101;
            this.f571607c = r102;
        }
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        GuestApplyPaidQueueViewHolder r102 = (GuestApplyPaidQueueViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.T3(r103.f571605a, r103.f571606b, r103.f571607c);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new GuestApplyPaidQueueViewHolder(r100.inflate(R.layout.ttlive_paid_queue_view_item, r101, false), this.f571603c, this.f571602b, this.f571604d);
    }

    public f(Function1 r100, Function1 r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = null;
    L9:
        Intrinsics.checkNotNullParameter(r100, "tabClickListener");
        this.f571602b = r100;
        this.f571603c = r103;
        this.f571604d = r101;
        return;
    L5:
        r103 = false;
        goto L7
    }
}
