package q21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkTabTitleViewHolder;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends me.drakeet.multitype.b<a, AnchorLinkTabTitleViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<CharSequence> f531362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MutableLiveData<Integer> f531363b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f531362a, r101.f531362a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f531363b, r101.f531363b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<CharSequence> r100 = this.f531362a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            MutableLiveData<Integer> r104 = this.f531363b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AnchorLinkTabTitleViewBinderData(titles=" + this.f531362a + ", tabSelectedIndex=" + this.f531363b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends CharSequence> r100, MutableLiveData<Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "titles");
            Intrinsics.checkNotNullParameter(r101, "tabSelectedIndex");
            this.f531362a = r100;
            this.f531363b = r101;
        }
    }

    public e() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r110) {
        AnchorLinkTabTitleViewHolder r101 = (AnchorLinkTabTitleViewHolder) r100;
        a r111 = r110;
        Intrinsics.checkNotNullParameter(r101, "holder");
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        MultiTypeAdapter r102 = r101.f93738b;
        List<CharSequence> r103 = r111.f531362a;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
        int r106 = 0;
    L4:
        if (r105.hasNext() == false) goto L9;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r104.add(new l.a(r106, (CharSequence) r107, r111.f531363b));
        r106 = r108;
        goto L4
    L9:
        r102.f513437a = r104;
        r101.f93738b.notifyDataSetChanged();
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = r100.inflate(R.layout.ttlive_item_anchor_link_tab_title, r101, false);
        r102.setTag("RecyclerOptBar");
        Unit r103 = Unit.INSTANCE;
        return new AnchorLinkTabTitleViewHolder(r102);
    }
}
