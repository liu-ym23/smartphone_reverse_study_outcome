package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.TabTitleItemViewHolder;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.n;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends me.drakeet.multitype.b<a, TabTitleItemViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f531391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f531392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MutableLiveData<Integer> f531393c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f531391a == r101.f531391a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f531392b, r101.f531392b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f531393c, r101.f531393c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f531391a * 31;
            CharSequence r101 = this.f531392b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            MutableLiveData<Integer> r105 = this.f531393c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "TabTitleItemViewBinderData(tabIndex=" + this.f531391a + ", title=" + this.f531392b + ", tabSelectedIndex=" + this.f531393c + ")";
        }

        public a(int r100, CharSequence r101, MutableLiveData<Integer> r102) {
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "tabSelectedIndex");
            this.f531391a = r100;
            this.f531392b = r101;
            this.f531393c = r102;
        }
    }

    public l() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        TabTitleItemViewHolder r102 = (TabTitleItemViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f93817c = Integer.valueOf(r103.f531391a);
        r102.f93815a.setText(r103.f531392b);
        r102.f93815a.setOnClickListener(new n(r102));
        MutableLiveData<Integer> r104 = r103.f531393c;
        r102.f93818d = r104;
        Intrinsics.checkNotNull(r104);
        x.e(r104, r102.f93816b);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new TabTitleItemViewHolder(r100.inflate(R.layout.ttlive_anchor_link_tab_title_item, r101, false));
    }
}
