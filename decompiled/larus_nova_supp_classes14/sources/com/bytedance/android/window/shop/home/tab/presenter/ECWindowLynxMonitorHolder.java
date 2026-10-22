package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.window.shop.widget.ECWindowHybridRoundedLinearLayout;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/presenter/ECWindowLynxMonitorHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLynxCardHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowLynxMonitorHolder extends ECLynxCardHolder {
    public boolean W;
    public Function3<? super Long, ? super Long, ? super Map<String, String>, Unit> X;
    public final ECWindowViewModel Y;

    public ECWindowLynxMonitorHolder() {
        throw null;
    }

    public final void onPreCreateView(boolean r1) {
        this.W = r1;
    }

    public final void onTimingSetupPref(com.bytedance.android.ec.hybrid.card.util.k r7) {
        int r0 = com.bytedance.android.window.shop.lifecycle.a.a;
        ECWindowViewModel r1 = this.Y;
        Object r2 = null;
        if (r7 == null) goto L5;
        Object r3 = null;
        r7.getClass();
    L6:
        com.bytedance.android.window.shop.lifecycle.a.a(r1, r7, String.valueOf(r3), this.W);
        Function3<? super Long, ? super Long, ? super Map<String, String>, Unit> r4 = this.X;
        if (r4 == null) goto L28;
        long r5 = 0;
        if (r7 == null) goto L13;
        Long r6 = r7.b;
        if (r6 == null) goto L13;
        long r8 = r6.longValue();
    L14:
        Long r9 = Long.valueOf(r8);
        if (r7 == null) goto L19;
        Long r10 = r7.c;
        if (r10 == null) goto L19;
        r5 = r10.longValue();
    L19:
        Long r11 = Long.valueOf(r5);
        Pair[] r12 = new Pair[3];
        if (r7 == null) goto L22;
        r2 = null;
        r7.getClass();
    L22:
        r12[0] = TuplesKt.to("resource_perf", com.bytedance.android.ec.hybrid.list.util.k.d(r2));
        if (this.W == false) goto L25;
        String r13 = CommentScene.COMMENTSCENE_NO_AWEME;
    L26:
        r12[1] = TuplesKt.to("is_preload", r13);
        r12[2] = TuplesKt.to("is_end_with_update", "0");
        Unit r14 = (Unit) r4.invoke(r9, r11, MapsKt.mapOf(r12));
        return;
    L25:
        r13 = "0";
    L13:
        r8 = 0;
        goto L14
    L28:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onTimingUpdatePref(com.bytedance.android.ec.hybrid.card.util.k r7) {
        int r0 = com.bytedance.android.window.shop.lifecycle.a.a;
        ECWindowViewModel r1 = this.Y;
        Object r2 = null;
        if (r7 == null) goto L5;
        String r3 = null;
        r7.getClass();
    L6:
        if (r7 == null) goto L8;
        Object r4 = null;
        r7.getClass();
    L9:
        com.bytedance.android.window.shop.lifecycle.a.b(r1, r7, r3, String.valueOf(r4), this.W);
        Function3<? super Long, ? super Long, ? super Map<String, String>, Unit> r5 = this.X;
        if (r5 == null) goto L31;
        long r6 = 0;
        if (r7 == null) goto L16;
        Long r8 = r7.b;
        if (r8 == null) goto L16;
        long r9 = r8.longValue();
    L17:
        Long r10 = Long.valueOf(r9);
        if (r7 == null) goto L22;
        Long r11 = r7.c;
        if (r11 == null) goto L22;
        r6 = r11.longValue();
    L22:
        Long r12 = Long.valueOf(r6);
        Pair[] r13 = new Pair[3];
        if (r7 == null) goto L25;
        r2 = null;
        r7.getClass();
    L25:
        r13[0] = TuplesKt.to("resource_perf", com.bytedance.android.ec.hybrid.list.util.k.d(r2));
        if (this.W == false) goto L28;
        String r14 = CommentScene.COMMENTSCENE_NO_AWEME;
    L29:
        r13[1] = TuplesKt.to("is_preload", r14);
        r13[2] = TuplesKt.to("is_end_with_update", CommentScene.COMMENTSCENE_NO_AWEME);
        Unit r15 = (Unit) r5.invoke(r10, r12, MapsKt.mapOf(r13));
        return;
    L28:
        r14 = "0";
    L16:
        r9 = 0;
        goto L17
    L31:
        return;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public ECWindowLynxMonitorHolder(ECWindowViewModel r14, ECWindowHybridRoundedLinearLayout r15, String r16, Lifecycle r17) {
        com.bytedance.android.ec.hybrid.list.entity.l.a r4 = com.bytedance.android.ec.hybrid.list.entity.l.a.a;
        Map r7 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r14, "windowViewModel");
        Intrinsics.checkNotNullParameter(r15, "viewGroup");
        Intrinsics.checkNotNullParameter(r16, "sceneID");
        Intrinsics.checkNotNullParameter(r4, "pageType");
        Intrinsics.checkNotNullParameter(r7, "lynxConsumerMonitor");
        super(r15, r16, r4, null, r17, r7, null, null, true, false, 1024);
        this.Y = r14;
    }
}
