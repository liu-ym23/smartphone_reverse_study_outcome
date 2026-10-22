package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.video.float.w;
import com.bytedance.android.shopping.anchorv4.video.float.x;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVH;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeadScrollStateManager;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadScrollStateManager extends RecyclerView.OnScrollListener {
    public static final /* synthetic */ int n = 0;
    public RecyclerView a;
    public a73.g b;
    public a73.m c;
    public a73.e d;
    public boolean e;
    public int[] f;
    public o g;
    public com.bytedance.android.shopping.anchorv4.video.float.u h;
    public boolean i;
    public boolean j;
    public final Handler k;
    public final b l;
    public final AnchorV4VM m;

    public static final class a {
    }

    public static final class b implements fj.b {
        public b() {
        }
    }

    static {
    }

    public HeadScrollStateManager(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.m = r2;
        this.e = true;
        this.k = new Handler(Looper.getMainLooper());
        b r3 = new b();
        this.l = r3;
        int r0 = ECSdk.a;
        fj.c r1 = (fj.c) ECSdk.a(fj.c.class);
        if (r1 == null) goto L6;
        r1.b(r3);
        return;
    }

    public static void k(HeadScrollStateManager r24) {
        o r1 = r24.g;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L73;
        o r4 = r24.g;
        if (r4 == null) goto L33;
        int r5 = com.bytedance.android.shopping.anchorv4.video.float.e.a;
        if (r5 != 1) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
    L23:
        if (r5 != 1) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L33;
        if (r4.c() == true) goto L33;
    L32:
        r2 = true;
        goto L33
    L25:
        if (r5 == 2) goto L28;
        r7 = false;
        goto L29
    L22:
        if (r4.c() == true) goto L32;
    L16:
        if (r5 == 3) goto L19;
        r6 = false;
    L33:
        if (r2 == false) goto L74;
        o r8 = r24.g;
        x73.c r11 = null;
        if (r8 == null) goto L37;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r9 = r8.getVideoModel();
    L38:
        o r10 = r24.g;
        if (r10 == null) goto L41;
        x73.c r12 = r10.getSharePlayer();
    L42:
        if (r9 == null) goto L75;
        if (r12 == null) goto L76;
        com.bytedance.android.shopping.anchorv4.video.float.g r13 = r24.m.getFloatVideoManager();
        com.bytedance.android.shopping.anchorv4.video.float.g r14 = r24.m.getFloatVideoManager();
        h r15 = new h(r24);
        LinkedHashMap r16 = new LinkedHashMap();
        o r17 = r24.g;
        if (r17 == null) goto L49;
        Map<String, Object> r18 = r17.d();
        if (r18 == null) goto L49;
        r16.putAll(r18);
    L49:
        Unit r19 = Unit.INSTANCE;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r9, "videoModel");
        Intrinsics.checkNotNullParameter(r12, "sharePlayer");
        ViewGroup r20 = r14.c;
        if (r20 != null) goto L52;
        com.bytedance.android.shopping.anchorv4.video.float.i r21 = null;
    L63:
        com.bytedance.android.shopping.anchorv4.video.float.g.a r22 = r13.a(r21);
        r24.h = r22;
        if (r22 == null) goto L66;
        return;
    L66:
        if ((r12 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) == false) goto L69;
        r11 = r12;
    L69:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c r110 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) r11;
        if (r110 == null) goto L78;
        r110.k(true);
        return;
    L78:
        return;
    L52:
        AnchorV4VM r23 = r14.e;
        Context r111 = r20.getContext();
        AnchorV4PlayerStateManager r25 = r14.a;
        Boolean r26 = Boolean.FALSE;
        com.bytedance.android.shopping.api.video.i r27 = r12.d;
        if (r27 == null) goto L55;
        Boolean r28 = Boolean.valueOf(((ECVideoPlayerView) r27).f());
    L56:
        w r112 = new w(r25, r26, r28, AVScene.CONTENT_PRODUCT_DETAIL_HEADER, r9, true, r12, null);
        Pair r29 = r14.d.a;
        if (r29 == null) goto L61;
        Boolean r30 = (Boolean) r29.getSecond();
        if (r30 == null) goto L61;
        boolean r31 = r30.booleanValue();
    L62:
        r21 = new com.bytedance.android.shopping.anchorv4.video.float.i(r23, r111, r20, r112, new x(r31, null, null, 121), r15, r16);
    L61:
        r31 = true;
        goto L62
    L55:
        r28 = null;
        goto L56
    L76:
        return;
    L75:
        return;
    L41:
        r12 = null;
        goto L42
    L37:
        r9 = null;
        goto L38
    L74:
        return;
    L73:
        return;
    L5:
        if (r1.isPlaying() != true) goto L8;
        r3 = true;
        goto L9
    }

    public final void l(Boolean r6) {
        o r0 = this.g;
        boolean r1 = true;
        if (r0 == null) goto L8;
        if (r0.c() != true) goto L8;
        return;
    L8:
        if (this.h == null) goto L50;
        o r2 = this.g;
        if (r2 == null) goto L45;
        x73.c r3 = r2.getSharePlayer();
        if (r3 == null) goto L45;
        o r4 = this.g;
        if (r4 == null) goto L26;
        x73.c r5 = r4.getSharePlayer();
        if (r5 == null) goto L26;
        com.bytedance.android.shopping.anchorv4.video.float.u r7 = this.h;
        if (r7 == null) goto L24;
        com.bytedance.android.shopping.anchorv4.video.float.i r8 = r7.getParams();
        if (r8 == null) goto L24;
        w r9 = r8.d;
        if (r9 == null) goto L24;
        x73.c r10 = r9.g;
    L25:
        boolean r11 = Intrinsics.areEqual(r5, r10);
    L27:
        if (r11 == false) goto L40;
        if (r6 == null) goto L30;
        boolean r12 = r6.booleanValue();
    L36:
        if (r12 == false) goto L45;
        com.bytedance.android.shopping.anchorv4.video.float.u r13 = this.h;
        if (r13 == null) goto L44;
        r13.b(r3);
    L44:
        boolean r14 = false;
    L46:
        if (r14 == false) goto L50;
        com.bytedance.android.shopping.anchorv4.video.float.u r15 = this.h;
        if (r15 == null) goto L50;
        r15.close(true);
        goto L50
    L30:
        o r16 = this.g;
        if (r16 != null) goto L33;
    L35:
        r12 = false;
        goto L36
    L33:
        if (r16.isPlaying() != true) goto L35;
        r12 = true;
        goto L36
    L40:
        com.bytedance.android.shopping.anchorv4.video.float.u r17 = this.h;
        if (r17 == null) goto L43;
        r17.close(true);
    L43:
        k(this);
    L24:
        r10 = null;
    L26:
        r11 = false;
    L45:
        r14 = true;
    L50:
        o r18 = this.g;
        if (r18 == null) goto L59;
        x73.c r19 = r18.getSharePlayer();
        if (r19 == null) goto L59;
        com.bytedance.android.shopping.api.video.i r20 = r19.d;
        if (r20 == null) goto L59;
        if (((ECVideoPlayerView) r20).h() != true) goto L59;
        boolean r21 = true;
    L60:
        if (r21 == true) goto L75;
        com.bytedance.android.shopping.anchorv4.video.float.g.a r22 = this.m.getFloatVideoManager().b;
        if (r22 == null) goto L76;
        AVScene r23 = r22.a.d.d;
        if (r23 != AVScene.CONTENT_PD_LIVE_REPLAY_WINDOW) goto L66;
        boolean r24 = true;
    L67:
        if (r24 == false) goto L69;
    L73:
        r22.b.resume();
        return;
    L69:
        if (r23 == AVScene.CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW) goto L72;
        r1 = false;
    L72:
        if (r1 == true) goto L73;
        return;
    L66:
        r24 = false;
        goto L67
    L76:
        return;
    L75:
        return;
    L59:
        r21 = false;
        goto L60
    }

    public static final void j(HeadScrollStateManager r8, boolean r9) {
        r8.getClass();
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r8.m);
        if (r1 == null) goto L14;
        LinkedHashMap r2 = new LinkedHashMap();
        o r10 = r8.g;
        if (r10 == null) goto L9;
        Map<String, Object> r11 = r10.d();
        if (r11 == null) goto L9;
        r2.putAll(r11);
    L9:
        if (r9 == false) goto L11;
        String r12 = FreqActions.ACTION_CLOSE;
    L12:
        r2.put("click_type", r12);
        Unit r13 = Unit.INSTANCE;
        r1.c = r2;
        AnchorV4TrackerImpl.b(r1, "main_video_window_click", false, null, false, null, 30);
        return;
    L11:
        r12 = "blank";
        goto L12
    }

    public final void onScrolled(RecyclerView r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        RecyclerView.LayoutManager r12 = r9.getLayoutManager();
        x73.c r0 = null;
        if ((r12 instanceof StaggeredGridLayoutManager) == true) goto L5;
        r12 = null;
    L5:
        StaggeredGridLayoutManager r13 = (StaggeredGridLayoutManager) r12;
        if (r13 != null) goto L8;
    L20:
        boolean r14 = false;
    L22:
        if (this.e == r14) goto L63;
        this.e = r14;
        d83.c r15 = this.m.getHeadViewAbilityNew();
        if (r15 == null) goto L27;
        r15.b(r14);
    L27:
        if (this.e == false) goto L32;
        com.bytedance.android.shopping.anchorv4.video.float.u r16 = this.h;
        if (r16 == null) goto L64;
        r16.close(false);
        return;
    L64:
        return;
    L32:
        if (com.bytedance.android.shopping.anchorv4.video.float.e.a() == false) goto L50;
        boolean r17 = true;
        if (this.m.getFloatVideoManager().b == null) goto L36;
        boolean r18 = true;
    L37:
        a73.m r1 = this.c;
        if (r1 == null) goto L40;
        boolean r2 = r1.E();
    L41:
        AnchorV4PlayerStateManager.t.getClass();
        if (AnchorV4PlayerStateManager.b.c() == true) goto L47;
        if (r18 == true) goto L47;
        if (r2 == true) goto L47;
        r17 = false;
    L47:
        if (r17 == true) goto L50;
        k(this);
        goto L50
    L40:
        r2 = false;
        goto L41
    L36:
        r18 = false;
    L50:
        if (this.h != null) goto L66;
        o r19 = this.g;
        if (r19 == null) goto L54;
        x73.c r20 = r19.getSharePlayer();
    L56:
        if ((r20 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) == false) goto L59;
        r0 = r20;
    L59:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c r3 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) r0;
        if (r3 == null) goto L67;
        r3.k(false);
        return;
    L67:
        return;
    L54:
        r20 = null;
        goto L56
    L66:
        return;
    L63:
        return;
    L8:
        if (this.f != null) goto L10;
        this.f = new int[r13.getSpanCount()];
    L10:
        int[] r4 = this.f;
        if (r4 == null) goto L13;
        ArraysKt.fill$default(r4, -1, 0, 0, 6, null);
    L13:
        r13.findFirstVisibleItemPositions(this.f);
        int[] r110 = this.f;
        if (r110 == null) goto L20;
        Integer r111 = ArraysKt.firstOrNull(r110);
        if (r111 == null) goto L20;
        RecyclerView.ViewHolder r21 = r9.findViewHolderForAdapterPosition(r111.intValue());
        if (r21 == null) goto L20;
        r14 = (r21 instanceof AnchorV4HeadVH) | (r21 instanceof AnchorV4HeadV2VH);
        goto L22
    }
}
