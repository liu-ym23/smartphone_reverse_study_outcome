package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vg3.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements n73.a {
    public final Map<String, String> a;
    public final boolean b;
    public final View c;
    public final Function0<z> d;

    public final void a(Map<String, ? extends Object> r7) {
        BtmSDK r0 = BtmSDK.INSTANCE;
        if (this.b == false) goto L5;
        String r1 = "a1.b8094.c5958.d61744";
    L6:
        Map<? extends String, ? extends Object> r2 = r0.createReportParams(r1, PageFinder.via(this.c));
        z r3 = (z) this.d.invoke();
        if (r3 == null) goto L14;
        LinkedHashMap r4 = new LinkedHashMap();
        Map<String, String> r5 = this.a;
        if (r5 == null) goto L11;
        r4.putAll(r5);
    L11:
        if (r7 == null) goto L13;
        r4.putAll(r7);
    L13:
        r4.putAll(r2);
        r4.put("btm", "a1.b8094.c5958.d6302");
        Unit r8 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r9 = r3.d(r4);
    L15:
        if (r9 == null) goto L17;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r9, "pdp_module_show", false, null, null, 14);
    L17:
        if (r9 != null) goto L19;
        return;
    L19:
        if (this.b == false) goto L21;
        String r6 = "livesdk_live_show";
    L22:
        String r10 = r6;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r9, r10, false, null, null, 12);
        return;
    L21:
        r6 = "explain_replay_entrance_show";
        goto L22
    L14:
        r9 = null;
        goto L15
    L5:
        r1 = "a1.b8094.c5958.d6302";
        goto L6
    }

    public final void b(Map<String, ? extends Object> r12) {
        BtmSDK r0 = BtmSDK.INSTANCE;
        if (this.b == false) goto L5;
        String r2 = "a1.b8094.c5958.d61744";
    L6:
        String r1 = r0.createBtmId(new BtmItemBuilder(r2, Boolean.FALSE).withView(this.c).build());
        z r3 = (z) this.d.invoke();
        if (r3 == null) goto L19;
        LinkedHashMap r4 = new LinkedHashMap();
        Map<String, String> r5 = this.a;
        if (r5 == null) goto L11;
        r4.putAll(r5);
    L11:
        r4.put("btm_id", r1);
        r4.putAll(r12);
        Unit r6 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r7 = r3.d(r4);
        if (r7 == null) goto L19;
        if (this.b == false) goto L16;
        String r8 = "livesdk_live_pd_play";
    L17:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r7, r8, true, null, null, 12);
        goto L19
    L16:
        r8 = "explain_replay_entrance_click";
    L19:
        if (this.b == false) goto L29;
        z r9 = (z) this.d.invoke();
        if (r9 == null) goto L30;
        LinkedHashMap r10 = new LinkedHashMap();
        Map<String, String> r11 = this.a;
        if (r11 == null) goto L25;
        r10.putAll(r11);
    L25:
        r10.put("btm_id", r1);
        r10.putAll(r12);
        Unit r13 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r14 = r9.d(r10);
        if (r14 == null) goto L31;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r14, "livesdk_rec_live_play", true, null, null, 12);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L5:
        r2 = "a1.b8094.c5958.d6302";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(PlayBackEntryVO r2, AnchorV4PlaybackAreaV2 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r4, "pdpTrackerCreator");
        this.c = r3;
        this.d = r4;
        if (r2 == null) goto L5;
        Map<String, String> r5 = r2.getTrackExtra();
    L6:
        this.a = r5;
        if (r2 == null) goto L13;
        boolean r6 = true;
        if (r2.isShowLiveIcon() != true) goto L13;
        if (r2.getLivingLink() == null) goto L13;
    L14:
        this.b = r6;
        return;
    L13:
        r6 = false;
        goto L14
    L5:
        r5 = null;
        goto L6
    }
}
