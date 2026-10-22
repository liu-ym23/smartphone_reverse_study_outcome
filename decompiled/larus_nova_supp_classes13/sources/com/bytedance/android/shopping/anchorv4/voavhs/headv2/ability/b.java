package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements c63.c {
    public final Map<String, String> a;
    public final /* synthetic */ a b;

    public final void K(boolean r1) {
    }

    public final void c(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1, String r2) {
    }

    public final void u(String r12) {
        Intrinsics.checkNotNullParameter(r12, "fromEntrance");
        a r1 = this.b;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(this.a);
        r3.putAll(this.b.b());
        r3.put("from_entrance", r12);
        Unit r13 = Unit.INSTANCE;
        q.a.a(r1, "pd_video_pause", r3, false, null, null, null, null, null, 508);
    }

    public final void y(String r2) {
        this.b.j(r2);
    }

    public b(a r1, int r2) {
        this.b = r1;
        AnchorV4HeadV2VO r3 = r1.b.K10();
        if (r3 == null) goto L10;
        List<HeaderContentModel> r4 = r3.getCells();
        if (r4 == null) goto L10;
        HeaderContentModel r5 = (HeaderContentModel) CollectionsKt.getOrNull(r4, r2);
        if (r5 == null) goto L10;
        Map<String, String> r6 = r5.getTrack();
        if (r6 == null) goto L10;
    L11:
        this.a = r6;
        return;
    L10:
        r6 = MapsKt.emptyMap();
        goto L11
    }

    public final void E(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "fromEntrance");
        Intrinsics.checkNotNullParameter(r3, "fromEntrance");
    }

    public final void B(String r11, String r12, Integer r13) {
        a r0 = this.b;
        Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", r11), TuplesKt.to("pd_headvideo_size", r12), TuplesKt.to("video_source_type", String.valueOf(r13))});
        r2.putAll(this.a);
        r2.putAll(this.b.b());
        Unit r14 = Unit.INSTANCE;
        q.a.a(r0, "pd_main_video_click", r2, false, null, null, null, null, null, 508);
    }

    public final void e(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "fromEntrance");
        Intrinsics.checkNotNullParameter(r12, "videoType");
        a r0 = this.b;
        Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", PageScrollStatus.slide)});
        r2.putAll(this.a);
        r2.putAll(this.b.b());
        TuplesKt.to("from_entrance", r11);
        Unit r14 = Unit.INSTANCE;
        q.a.a(r0, "pd_video_progress_bar", r2, false, null, null, null, null, null, 508);
    }

    public final void x(String r19, String r20, String r21, Integer r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r19, "fromEntrance");
        Intrinsics.checkNotNullParameter(r20, "entranceMethod");
        String r4 = r19 + '_' + r24;
        int r5 = !this.b.a.contains(r4) ? 1 : 0;
        if (r24 == null) goto L5;
        this.b.a.add(r4);
    L5:
        a r8 = this.b;
        Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_method", r20), TuplesKt.to("pd_headvideo_size", r21), TuplesKt.to("video_source_type", String.valueOf(r22)), TuplesKt.to("video_id", r24), TuplesKt.to("is_first", Integer.valueOf(r5))});
        r10.putAll(this.a);
        r10.putAll(this.b.b());
        r10.put("from_entrance", r19);
        Unit r1 = Unit.INSTANCE;
        q.a.a(r8, "pd_video_play", r10, false, null, this.b.b.getRecyclerView(), "a1.b8094.c0645.d057069", null, null, 412);
    }

    public final void w(String r12, String r13, long r14, String r16, Integer r17, String r18, String r19, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r12, "playMethod");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r16, "stopType");
        a r5 = this.b;
        Pair[] r7 = new Pair[7];
        r7[0] = TuplesKt.to("entrance_method", r12);
        r7[1] = TuplesKt.to("type", r13);
        r7[2] = TuplesKt.to("duration", Long.valueOf(r14));
        r7[3] = TuplesKt.to("stop_type", r16);
        r7[4] = TuplesKt.to("video_source_type", String.valueOf(r17));
        r7[5] = TuplesKt.to("video_id", null);
        if (r20 == false) goto L5;
        String r1 = "1";
    L6:
        r7[6] = TuplesKt.to("is_play_over", r1);
        Map r2 = MapsKt.mutableMapOf(r7);
        r2.putAll(this.a);
        r2.putAll(this.b.b());
        r2.put("from_entrance", r21);
        Unit r3 = Unit.INSTANCE;
        q.a.a(r5, "pd_video_play_time", r2, false, null, null, null, null, null, 508);
        return;
    L5:
        r1 = "0";
        goto L6
    }
}
