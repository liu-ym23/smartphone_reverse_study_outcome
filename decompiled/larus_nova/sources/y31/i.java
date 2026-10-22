package y31;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKExpandCollapseViewHolder;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i extends me.drakeet.multitype.b<a, PKExpandCollapseViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PKExpandCollapseViewHolder.a f565766b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f565767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f565768b;

        public a() {
            this.f565767a = "";
        }
    }

    public i(PKExpandCollapseViewHolder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f565766b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        PKExpandCollapseViewHolder r102 = (PKExpandCollapseViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        boolean r104 = r103.f565768b;
        String r105 = r103.f565767a;
        if (r104 == false) goto L9;
        TextView r106 = r102.f96159a;
        if (TextUtils.isEmpty(r105) == false) goto L8;
        r105 = s1.B(R.string.ttlive_live_user_list_collapse_title);
    L8:
        r106.setText(r105);
        r102.f96160b.setRotationX(180.0f);
    L14:
        r102.f96159a.setTextColor(ColorProtector.parseColor("#99161823"));
        return;
    L9:
        TextView r107 = r102.f96159a;
        if (TextUtils.isEmpty(r105) == false) goto L13;
        r105 = s1.B(R.string.ttlive_live_user_list_expend_title);
    L13:
        r107.setText(r105);
        r102.f96160b.setRotationX(0.0f);
        goto L14
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PKExpandCollapseViewHolder(r100.inflate(R.layout.ttlive_item_interact_pk_expand_collapse_button, r101, false), this.f565766b);
    }
}
