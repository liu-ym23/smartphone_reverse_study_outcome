package com.bytedance.android.shopping.mall.homepage.card.live;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yj.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/BaseLiveViewHolder;", "Lcom/bytedance/android/shopping/mall/homepage/card/AbstractNativeCard;", "Lcom/bytedance/android/shopping/mall/homepage/card/live/b;", "Lcom/bytedance/android/shopping/mall/homepage/card/live/c;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseLiveViewHolder extends AbstractNativeCard implements com.bytedance.android.shopping.mall.homepage.card.live.b, c {
    public long A;
    public final Handler B;
    public final a C;
    public int D;
    public final Fragment E;
    public final View F;
    public final int G;
    public final Integer H;
    public final n I;
    public final g93.a J;
    public final String K;
    public final String L;
    public LiveCardData u;
    public String v;
    public boolean w;
    public boolean x;
    public Long y;
    public long z;

    public static final class a implements y {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ long c;
        public final /* synthetic */ RelativeLayout.LayoutParams d;
        public final /* synthetic */ BaseLiveViewHolder e;
        public final /* synthetic */ boolean f;

        public b(View r1, HashMap r2, long r3, RelativeLayout.LayoutParams r5, BaseLiveViewHolder r6, boolean r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void a() {
            BaseLiveViewHolder r0 = this.e;
            Fragment r3 = r0.E;
            if (r3 == null) goto L29;
            com.bytedance.android.shopping.api.mall.common.tools.h r12 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
            boolean r2 = this.f;
            View r1 = this.a;
            if (r1 == null) goto L28;
            FrameLayout r4 = (FrameLayout) r1;
            long r6 = this.c;
            String r5 = r0.v;
            if (r5 != null) goto L9;
        L14:
            boolean r8 = true;
        L15:
            r12.showOrHideFloatLive(r2, r3, r4, null, r6, r8, this.b, this.d, true);
            if (this.f == false) goto L23;
            Object r7 = n93.a.a;
            a r9 = this.e.C;
            Object r10 = n93.a.a;
            if (r10 == null) goto L20;
            r12.removeLiveFloatManagerListener(r10);
            n93.a.a = null;
        L20:
            if (r9 == null) goto L22;
            n93.a.a = r12.addLiveFloatManagerListener(r9);
        L22:
            BaseLiveViewHolder r11 = this.e;
            r11.w = true;
            r11.x = false;
            return;
        L23:
            Object r13 = n93.a.a;
            if (r13 == null) goto L26;
            r12.removeLiveFloatManagerListener(r13);
            n93.a.a = null;
        L26:
            BaseLiveViewHolder r14 = this.e;
            r14.w = false;
            r14.x = true;
            return;
        L9:
            if (r0.J == null) goto L14;
            if (g93.a.a(r5) == true) goto L14;
            r8 = false;
            goto L15
        L28:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public String A4() {
        return "";
    }

    public final boolean C3() {
        return true;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public final String q4() {
        return "1";
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public final int s4() {
        return 1;
    }

    public boolean w4() {
        return this instanceof NativeLiveBigCard;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public ECRoundedConstraintLayout r4() {
        return new ECRoundedConstraintLayout(((RecyclerView.ViewHolder) this).itemView.getContext(), null, 6, 0);
    }

    public final String y4() {
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.n() == false) goto L5;
    L8:
        return "order_center";
    L5:
        if (Intrinsics.areEqual(ToolsKt.k(this).get(PdpOpenThirdParam.KEY_PAGE_NAME), "order_homepage") == true) goto L8;
        return MallPageName.X_TAB_MALL;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.c
    public final void Y1() {
        if (w4() == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.api.mall.common.tools.h.b.isShowingFloatLive() == false) goto L9;
        C4(false);
        return;
    }

    public void onRelease() {
        super.onRelease();
        n r0 = this.I;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.b.remove(this);
        n r1 = this.I;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r1.a.remove(this);
        if (w4() == false) goto L6;
        C4(false);
        return;
    }

    public final void B4(double r4) {
        if (w4() == true) goto L5;
        return;
    L5:
        if (r4 > 0.2d) goto L7;
        boolean r5 = true;
    L8:
        boolean r6 = com.bytedance.android.shopping.api.mall.common.tools.h.b.isShowingFloatLive();
        if (r5 == true) goto L13;
        if (r6 == true) goto L12;
        return;
    L12:
        if (this.x == false) goto L13;
        return;
    L13:
        if (r5 == false) goto L18;
        if (r6 == false) goto L16;
        return;
    L16:
        if (this.w == false) goto L18;
        return;
    L18:
        C4(r5);
        return;
    L7:
        r5 = false;
        goto L8
    }

    public final void C4(boolean r11) {
        LiveCardData r0 = this.u;
        if (r0 == null) goto L34;
        LiveCardData.Live r1 = r0.getLive();
        if (r1 == null) goto L35;
        String r2 = r1.getRoomId();
        if (r2 == null) goto L36;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L37;
        long r4 = r3.longValue();
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(b0.c(110), b0.c(196));
        r6.addRule(12);
        r6.addRule(11);
        r6.bottomMargin = b0.c(165) + b0.c(Integer.valueOf(this.G));
        View r5 = this.F;
        if (r5 != null) goto L13;
        return;
    L13:
        if ((r5 instanceof FrameLayout) == true) goto L16;
        r5 = null;
    L16:
        View r7 = r5;
        if (r7 == null) goto L39;
        HashMap r8 = new HashMap();
        LiveCardData r9 = this.u;
        if (r9 != null) goto L21;
    L32:
        this.B.post(new b(r7, r8, r4, r6, this, r11));
        return;
    L21:
        if (r9.getSchema() == null) goto L32;
        String r10 = A4();
        if (TextUtils.isEmpty(r10) == true) goto L32;
        Uri r12 = UriProtector.parse(r10);
        r8.put("enter_from_merge", y4());
        String r13 = UriProtector.getQueryParameter(r12, "enter_method");
        String r14 = "";
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        r8.put("enter_method", r13);
        r8.put("previous_page", ToolsKt.h(this, 82));
        String r15 = UriProtector.getQueryParameter(r12, "ecom_live_params");
        if (r15 == null) goto L31;
        r14 = r15;
    L31:
        r8.put("ecom_live_params", r14);
        goto L32
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.b
    public final void j(boolean r5) {
        if (w4() == false) goto L18;
        com.bytedance.android.shopping.api.mall.common.tools.h r0 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
        if (r0.isShowingFloatLive() == false) goto L19;
        String r1 = this.v;
        if (r1 != null) goto L9;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L20;
        r0.toggleLiveAudio(!r5);
        return;
    L20:
        return;
    L9:
        if (this.J == null) goto L14;
        if (g93.a.a(r1) == true) goto L14;
        r2 = false;
        goto L15
    L19:
        return;
    }

    public final void m1(int r3, double r4) {
        if (w4() == false) goto L11;
        this.D = r3;
        if (r3 == 2) goto L7;
    L9:
        B4(r4);
        return;
    L7:
        if (r4 >= 1) goto L9;
        B4(0.0d);
        return;
    }

    public void b4(Object r2, String r3, com.bytedance.android.ec.hybrid.list.entity.k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        super.b4(r2, r3, r4);
    }

    public final void g1(int r2, int r3, double r4) {
        if (w4() == true) goto L5;
        return;
    L5:
        if (this.D == 2) goto L7;
    L9:
        B4(r4);
        return;
    L7:
        if (r4 >= 0.5d) goto L9;
        B4(0.0d);
    }

    public BaseLiveViewHolder(View r2, Fragment r3, View r4, int r5, Integer r6, n r7, g93.a r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r7, "pageStateChangeObserver");
        super(r2);
        this.E = r3;
        this.F = r4;
        this.G = r5;
        this.H = r6;
        this.I = r7;
        this.J = r8;
        this.K = r9;
        this.L = r10;
        this.z = System.currentTimeMillis();
        this.A = System.currentTimeMillis();
        this.B = new Handler(Looper.getMainLooper());
        this.C = new a();
        r7.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r7.a.add(this);
        Intrinsics.checkNotNullParameter(this, "listener");
        r7.b.add(this);
    }
}
