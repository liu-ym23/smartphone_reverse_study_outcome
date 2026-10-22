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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.UIHelper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends e0 {
    public final d0 b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final d0 c() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final View b(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        return LayoutInflater.from(r4.getContext()).inflate(2131564519, r4, false);
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final void a(View r10, List<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        RecyclerView r0 = r10.findViewById(2131392216);
        TextView r1 = (TextView) r10.findViewById(2131388772);
        LinearLayout r2 = (LinearLayout) r10.findViewById(2131384813);
        String r3 = this.c;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r1.setText(r3);
        String r4 = this.c;
        boolean r5 = true;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        int r7 = 8;
    L16:
        r1.setVisibility(r7);
        if (this.e == true) goto L20;
        r2.setPaddingRelative(0, 0, 0, 0);
    L20:
        if (this.f == false) goto L22;
        r2.setPaddingRelative(UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f), 0);
    L22:
        RecyclerView.Adapter r8 = r0.getAdapter();
        String r9 = null;
        if ((r8 instanceof ShareAdapter) == false) goto L25;
        ShareAdapter r12 = (ShareAdapter) r8;
    L26:
        if (r12 != null) goto L28;
        boolean r13 = true;
    L29:
        StringBuilder r14 = new StringBuilder("UILinearGroupItem.bind. linearAdapter?=");
        if (r12 != null) goto L32;
        boolean r15 = true;
    L33:
        r14.append(r15);
        r14.append(", this=");
        r14.append(hashCode());
        r14.append(", itemView=");
        r14.append(r10.hashCode());
        r14.append(", payloads=");
        if (r11 == null) goto L38;
        Object[] r16 = r11.toArray(new Object[0]);
        if (r16 == null) goto L38;
        r9 = Arrays.toString(r16);
    L38:
        r14.append(r9);
        tt5.a.h("UIShareLinearGroupItem", r14.toString());
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "recyclerView");
        int r17 = r0.getItemDecorationCount() - 1;
    L39:
        if ((-1) >= r17) goto L41;
        r0.removeItemDecorationAt(r17);
        r17 = r17 - 1;
        goto L39
    L41:
        ShareAdapter r18 = new ShareAdapter();
        r0.setAdapter(r18);
        r0.setLayoutManager(new LinearLayoutManagerWrapper(r10.getContext()));
        r0.setNestedScrollingEnabled(false);
        r0.addItemDecoration(new DividerItemDecoration(n.c(0.5f), n.c(16.0f), r0.getResources().getColor(2131103353)));
        if (this.d == false) goto L44;
        r0.addItemDecoration(new CornerRadiusItemDecoration());
    L44:
        if (r13 == true) goto L59;
        List<? extends Object> r19 = r11;
        if (r19 != null) goto L48;
    L51:
        if (r5 == true) goto L59;
        Iterator<T> r110 = r11.iterator();
    L55:
        if (r110.hasNext() == false) goto L67;
        Object r111 = r110.next();
        if ((r111 instanceof e0) == false) goto L55;
        r18.z2((e0) r111);
        goto L55
    L67:
        return;
    L48:
        if (r19.isEmpty() == true) goto L51;
        r5 = false;
    L59:
        r18.y2(this.b);
        return;
    L32:
        r15 = false;
        goto L33
    L28:
        r13 = false;
        goto L29
    L25:
        r12 = null;
        goto L26
    L15:
        r7 = 0;
        goto L16
    L9:
        if (r4.length() == 0) goto L12;
        r6 = false;
        goto L13
    }

    public e(String r2, d0 r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "items");
        super(r2);
        this.b = r3;
        this.c = null;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
