package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.o {
    public final /* synthetic */ SlidesAndIndicatorV4Component a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final boolean b() {
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final void a() {
        ViewPager r0 = this.a.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (c() == false) goto L24;
        c r1 = e();
        if (r1 != null) goto L9;
    L10:
        c r2 = e();
        Context r3 = null;
        if (r2 == null) goto L15;
        h83.a r4 = r2.B;
        if (r4 == null) goto L15;
        String r5 = r4.b;
    L16:
        Context r6 = r0.getContext();
        if ((r6 instanceof Activity) == false) goto L20;
        r3 = r6;
    L20:
        Activity r7 = (Activity) r3;
        if (r5 == null) goto L27;
        if (r7 == null) goto L28;
        com.bytedance.android.ec.sdk.helper.p.a.d(r5, r7);
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r5 = null;
        goto L16
    L9:
        if (r1.D != true) goto L10;
    L24:
        this.a.l(Integer.valueOf(r0.getCurrentItem()), 0, true);
    }

    public final c e() {
        AnchorV4HeadViewPager r0 = this.a.e;
        if (r0 == null) goto L10;
        int r2 = r0.getCurrentItem();
        HeadViewHolderBuilder r1 = r0.g;
        if (r1 == null) goto L11;
        List<c> r3 = r1.b;
        if (r3 != null) goto L9;
        return null;
    L9:
        return (c) CollectionsKt.getOrNull(r3, r2);
    L11:
        return null;
    L10:
        return null;
    }

    public final PlayerBlock f() {
        AnchorV4HeadViewPager r0 = this.a.e;
        if (r0 == null) goto L11;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r1 = r0.i(r0.getCurrentItem());
        if (r1 != null) goto L7;
        return null;
    L7:
        if (((com.bytedance.android.shopping.anchorv3.detail.widget.l) r1).a != null) goto L10;
        ((com.bytedance.android.shopping.anchorv3.detail.widget.l) r1).a = r1.c(LayoutInflater.from(((com.bytedance.android.shopping.anchorv3.detail.widget.l) r1).b));
    L10:
        return r1.g().a;
    L11:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final boolean c() {
        c r0 = e();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r0.a, HeadViewType.GOOD_COMMENT.getType()) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final Map<String, Object> d() {
        if (c() == false) goto L5;
        String r0 = "test_tab_window";
    L6:
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("video_type", r0);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r2 = getVideoModel();
        if (r2 == null) goto L9;
        String r3 = r2.j();
    L10:
        r1[1] = TuplesKt.to("video_id", r3);
        return MapsKt.mutableMapOf(r1);
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = "main_video_window";
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final x73.c getSharePlayer() {
        PlayerBlock r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSharePlayer();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b getVideoModel() {
        c r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final boolean isPlaying() {
        PlayerBlock r0 = f();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() != true) goto L7;
        return true;
    }

    public s(SlidesAndIndicatorV4Component r1) {
        this.a = r1;
    }
}
