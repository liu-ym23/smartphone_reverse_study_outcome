package com.bytedance.android.shopping.anchorv4.voavhs.lynx.air;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/lynx/air/AnchorV4LynxAirNodeVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/lynx/air/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LynxAirNodeVH extends AbsFullSpanVH<com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a> implements d {
    public static final /* synthetic */ int p = 0;
    public final ViewGroup m;
    public final VisibleLogManager n;
    public final AnchorV4VM o;

    public static final class a {
    }

    static {
    }

    public final void onScan() {
    }

    public final void onVisible() {
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof b) == true) goto L5;
        r0 = null;
    L5:
        b r1 = (b) r0;
        if (r1 == null) goto L11;
        ECLynxCard r2 = r1.b;
        if (r2 == null) goto L12;
        r2.release();
        r1.b = null;
        return;
    L12:
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r9) {
        com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a r10 = (com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a) r9;
        Intrinsics.checkNotNullParameter(r10, "item");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L23;
        b r1 = (b) r0;
        Intrinsics.checkNotNullParameter(r10, "data");
        String r2 = r10.b;
        String r3 = b.d;
        String r4 = null;
        if (r2 != null) goto L8;
        dm.a.a(r3).b("bindUI: lynxAddress is null", null);
    L20:
        Unit r5 = Unit.INSTANCE;
        this.n.b(this, r10, 0);
        this.o.registerRefreshDetailInfoListener(new AnchorV4LynxAirNodeVH$listenDataChange$1(this));
        return;
    L8:
        if (StringsKt.isBlank(r2) == false) goto L11;
        dm.a.a(r3).b("bindUI: lynxAddress is empty", null);
        goto L20
    L11:
        if (r1.b != null) goto L13;
        r1.b = new ECLynxCard();
    L13:
        ECLynxLoadParam.a r6 = new ECLynxLoadParam.a(r1.getContext(), r2, r1);
        r6.j(2000);
        r6.j = r10.c;
        r6.f(r1.c);
        JSONObject r7 = r10.d;
        JSONObject r8 = new JSONObject();
        r8.put("track_context", r7);
        r8.put("identifier", AnchorV4DataManager.d);
        Map<String, Object> r11 = com.bytedance.android.shopping.hybrid.a.b(r8);
        Intrinsics.checkNotNullParameter(r11, "ecGlobalProps");
        r6.p = r11;
        ECLynxLoadParam r12 = new ECLynxLoadParam(r6);
        ECLynxCard r13 = r1.b;
        if (r13 == null) goto L16;
        r13.j(r12);
    L16:
        dm.a.b r14 = dm.a.a(r3);
        StringBuilder r15 = new StringBuilder("createLynxCardAndLoad schema: ");
        r15.append(r2);
        r15.append(", meta: ");
        r15.append(r10.c);
        r15.append(", logParams:");
        JSONObject r16 = r10.d;
        if (r16 == null) goto L19;
        r4 = r16.toString();
    L19:
        r15.append(r4);
        r14.a(r15.toString());
        goto L20
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.AnchorV4LynxAirNodeView");
    }

    public AnchorV4LynxAirNodeVH(ViewGroup r2, VisibleLogManager r3, FragmentActivity r4, AnchorV4VM r5) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        Intrinsics.checkNotNullParameter(r3, "logManager");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        super(new b(r2.getContext()), true);
        this.m = r2;
        this.n = r3;
        this.o = r5;
    }
}
