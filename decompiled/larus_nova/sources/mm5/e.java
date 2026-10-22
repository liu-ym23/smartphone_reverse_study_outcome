package mm5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.view.CornerRadiusItemDecoration;
import com.bytedance.ee.bear.share.view.DividerItemDecoration;
import com.bytedance.ee.bear.share.view.ShareAdapter;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f514471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f514472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f514473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f514474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f514475f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final d0 c() {
        return this.f514471b;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.share_vertical_group_layout, r100, false);
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final void a(View r110, List<? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        RecyclerView r100 = (RecyclerView) r110.findViewById(R.id.verticalRecycler);
        TextView r101 = (TextView) r110.findViewById(R.id.title);
        LinearLayout r102 = (LinearLayout) r110.findViewById(R.id.root);
        String r103 = this.f514472c;
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        r101.setText(r103);
        String r104 = this.f514472c;
        boolean r105 = true;
        if (r104 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        int r107 = 8;
    L16:
        r101.setVisibility(r107);
        if (this.f514474e == true) goto L20;
        r102.setPaddingRelative(0, 0, 0, 0);
    L20:
        if (this.f514475f == false) goto L22;
        r102.setPaddingRelative(UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f), 0);
    L22:
        RecyclerView.Adapter r108 = r100.getAdapter();
        String r109 = null;
        if ((r108 instanceof ShareAdapter) == false) goto L25;
        ShareAdapter r112 = (ShareAdapter) r108;
    L26:
        if (r112 != null) goto L28;
        boolean r113 = true;
    L29:
        StringBuilder r114 = new StringBuilder("UILinearGroupItem.bind. linearAdapter?=");
        if (r112 != null) goto L32;
        boolean r115 = true;
    L33:
        r114.append(r115);
        r114.append(", this=");
        r114.append(hashCode());
        r114.append(", itemView=");
        r114.append(r110.hashCode());
        r114.append(", payloads=");
        if (r111 == null) goto L38;
        Object[] r116 = r111.toArray(new Object[0]);
        if (r116 == null) goto L38;
        r109 = Arrays.toString(r116);
    L38:
        r114.append(r109);
        tt5.a.h("UIShareLinearGroupItem", r114.toString());
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        int r117 = r100.getItemDecorationCount() - 1;
    L39:
        if ((-1) >= r117) goto L41;
        r100.removeItemDecorationAt(r117);
        r117 = r117 - 1;
        goto L39
    L41:
        ShareAdapter r118 = new ShareAdapter();
        r100.setAdapter(r118);
        r100.setLayoutManager(new LinearLayoutManagerWrapper(r110.getContext()));
        r100.setNestedScrollingEnabled(false);
        r100.addItemDecoration(new DividerItemDecoration(n.c(0.5f), n.c(16.0f), r100.getResources().getColor(R.color.line_divider_default)));
        if (this.f514473d == false) goto L44;
        r100.addItemDecoration(new CornerRadiusItemDecoration());
    L44:
        if (r113 == true) goto L59;
        List<? extends Object> r119 = r111;
        if (r119 != null) goto L48;
    L51:
        if (r105 == true) goto L59;
        Iterator<T> r120 = r111.iterator();
    L55:
        if (r120.hasNext() == false) goto L67;
        Object r121 = r120.next();
        if ((r121 instanceof e0) == false) goto L55;
        r118.z2((e0) r121);
        goto L55
    L67:
        return;
    L48:
        if (r119.isEmpty() == true) goto L51;
        r105 = false;
    L59:
        r118.y2(this.f514471b);
        return;
    L32:
        r115 = false;
        goto L33
    L28:
        r113 = false;
        goto L29
    L25:
        r112 = null;
        goto L26
    L15:
        r107 = 0;
        goto L16
    L9:
        if (r104.length() == 0) goto L12;
        r106 = false;
        goto L13
    }

    public e(String r100, d0 r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "items");
        super(r100);
        this.f514471b = r101;
        this.f514472c = null;
        this.f514473d = r102;
        this.f514474e = r103;
        this.f514475f = r104;
    }
}
