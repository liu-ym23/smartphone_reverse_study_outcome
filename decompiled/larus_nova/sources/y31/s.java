package y31;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKTitleViewHolder;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends me.drakeet.multitype.b<a, PKTitleViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f565820b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f565821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f565822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f565823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f565824d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f565825e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f565826f;

        public a() {
            this.f565826f = "";
        }
    }

    public s(boolean r100) {
        this.f565820b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        PKTitleViewHolder r102 = (PKTitleViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f96270d = r103;
        CharSequence r104 = r103.f565821a;
        if (r104 == null) goto L6;
        String r105 = r104.toString();
        if (r105 == null) goto L6;
    L7:
        r102.f96268b = r105;
        boolean r106 = r103.f565823c;
        r102.f96269c = r106;
        View r107 = r102.f96267a;
        if (r106 == false) goto L10;
        int r108 = 75;
    L11:
        a1.k(r107, UtilityKotlinExtentionsKt.i(r108));
        int r109 = 0;
        ((TextView) r102.f96267a.findViewById(R.id.title)).setVisibility(0);
        ((TextView) r102.f96267a.findViewById(R.id.title)).setText(r103.f565821a);
        ((TextView) r102.f96267a.findViewById(R.id.title)).setTextColor(ColorProtector.parseColor("#c0161823"));
        View r110 = r102.f96267a.findViewById(R.id.divider);
        if (r103.f565822b == true) goto L15;
        r109 = 8;
    L15:
        r110.setVisibility(r109);
        if (r102.f96271e == true) goto L18;
        return;
    L18:
        if (r103.f565823c == true) goto L22;
        a1.k(r102.f96267a, UtilityKotlinExtentionsKt.i(32));
        ((TextView) r102.f96267a.findViewById(R.id.title)).setPadding(((TextView) r102.f96267a.findViewById(R.id.title)).getPaddingLeft(), ((TextView) r102.f96267a.findViewById(R.id.title)).getPaddingTop(), ((TextView) r102.f96267a.findViewById(R.id.title)).getPaddingRight(), UtilityKotlinExtentionsKt.i(4));
        return;
    L22:
        return;
    L10:
        r108 = 34;
    L6:
        r105 = "";
        goto L7
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PKTitleViewHolder(r100.inflate(R.layout.ttlive_item_interact_pk_title, r101, false), this.f565820b);
    }
}
