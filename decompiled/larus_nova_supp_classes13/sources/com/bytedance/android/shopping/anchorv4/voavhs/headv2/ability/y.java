package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.api.video.AVScene;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y {
    public final SparseArray<PlayerBlockWrapper> a;
    public final SparseArray<l> b;
    public final SparseBooleanArray c;
    public boolean d;
    public Boolean e;
    public final s f;

    public static final class a {
        public final HeaderContentModel a;
        public final HeaderMediaModel b;
        public final VideoModel c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            HeaderContentModel r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            HeaderMediaModel r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            VideoModel r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "HeadMediaAndVideo(headCell=" + this.a + ", mediaContent=" + this.b + ", videoData=" + this.c + ")";
        }

        public a(HeaderContentModel r2, HeaderMediaModel r3, VideoModel r4) {
            Intrinsics.checkNotNullParameter(r2, "headCell");
            Intrinsics.checkNotNullParameter(r3, "mediaContent");
            Intrinsics.checkNotNullParameter(r4, "videoData");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.f {
        public final /* synthetic */ y a;

        public final void b() {
            this.a.d = true;
        }

        public final boolean isExpanded() {
            return this.a.f.isExpanded();
        }

        public final boolean isFullScreen() {
            return this.a.f.n0();
        }

        public b(y r1) {
            this.a = r1;
        }

        public final Boolean a(Boolean r2, boolean r3, Boolean r4) {
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L8;
            if (r4 == null) goto L7;
            this.a.e = r4;
        L7:
            return Boolean.valueOf(this.a.g(r2, r3));
        L8:
            Boolean r5 = this.a.a();
            if (r5 != null) goto L11;
            return null;
        L11:
            return Boolean.valueOf(r5.booleanValue());
        }
    }

    public static final class c implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.f {
        public final /* synthetic */ y a;

        public final void b() {
            this.a.d = true;
        }

        public final boolean isExpanded() {
            return this.a.f.isExpanded();
        }

        public final boolean isFullScreen() {
            return this.a.f.n0();
        }

        public c(y r1) {
            this.a = r1;
        }

        public final Boolean a(Boolean r2, boolean r3, Boolean r4) {
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L8;
            if (r4 == null) goto L7;
            this.a.e = r4;
        L7:
            return Boolean.valueOf(this.a.g(r2, r3));
        L8:
            Boolean r5 = this.a.a();
            if (r5 != null) goto L11;
            return null;
        L11:
            return Boolean.valueOf(r5.booleanValue());
        }
    }

    public final Boolean a() {
        if (this.f.n0() == true) goto L5;
        return null;
    L5:
        if (this.d == true) goto L14;
        AnchorV4PlayerStateManager.t.getClass();
        if (AnchorV4PlayerStateManager.b.c() == true) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(this.f.rR().i0(), Boolean.FALSE) == true) goto L11;
        return null;
    L11:
        return Boolean.TRUE;
    L14:
        return null;
    }

    public y(s r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        this.f = r2;
        this.a = new SparseArray();
        this.b = new SparseArray();
        this.c = new SparseBooleanArray();
    }

    public static AVScene i(HeaderMediaModel r3) {
        ECPDPBaseVideo r1 = null;
        if (r3.getPreviewType() != 1) goto L11;
        VideoModel r0 = r3.getVideo();
        if (r0 == null) goto L7;
        ECPDPBaseVideo r2 = r0.getPlayMeta();
    L8:
        if (r2 == null) goto L11;
        return AVScene.PDP_HEADER_KOL_OPT;
    L7:
        r2 = null;
    L11:
        if (r3.getPreviewType() != 1) goto L18;
        VideoModel r4 = r3.getVideo();
        if (r4 == null) goto L15;
        r1 = r4.getPlayMeta();
    L15:
        if (r1 != null) goto L18;
        return AVScene.PDP_HEADER_KOL;
    L18:
        return AVScene.CONTENT_PRODUCT_DETAIL_HEADER;
    }

    public final a b(int r4) {
        AnchorV4HeadV2VO r0 = this.f.K10();
        if (r0 == null) goto L32;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L33;
        HeaderContentModel r5 = (HeaderContentModel) CollectionsKt.getOrNull(r1, r4);
        if (r5 == null) goto L34;
        HeaderMediaModel r2 = r5.getMedia();
        if (r2 != null) goto L21;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r3 = r5.getMultiPreview();
        if (r3 == null) goto L20;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r6 = r3.a();
        if (r6 == null) goto L20;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r7 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L20;
        HeaderContentModel r8 = r7.a();
        if (r8 == null) goto L20;
        r2 = r8.getMedia();
    L20:
        r2 = null;
    L21:
        if (r2 != null) goto L23;
        return null;
    L23:
        HeaderMediaModel r9 = r5.getMedia();
        if (r9 == null) goto L27;
        VideoModel r10 = r9.getVideo();
        if (r10 == null) goto L27;
    L28:
        if (r10 != null) goto L31;
        return null;
    L31:
        return new a(r5, r2, r10);
    L27:
        r10 = r2.getVideo();
        goto L28
    L34:
        return null;
    L33:
        return null;
    L32:
        return null;
    }

    public final l c(int r13) {
        a r0 = b(r13);
        if (r0 != null) goto L5;
        return null;
    L5:
        HeaderMediaModel r2 = r0.b;
        VideoModel r1 = r0.c;
        l r3 = this.b.get(r13);
        if (r3 != null) goto L22;
        z73.a r4 = PlayAbilityUtil.a;
        AnchorV4HeadV2VO r5 = this.f.K10();
        if (r5 == null) goto L12;
        HeaderMediaModel r6 = AnchorV4HeadV2VO.getVideoMedia$default(r5, r13, null, 2, null);
        if (r6 == null) goto L12;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.n r7 = r6.getVideoInteractor();
    L13:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r8 = PlayAbilityUtil.a(r1, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.h.a(r7), PlayerViewScene.SCENE_PRODUCT_VIDEO);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        BasePdpVideoView r9 = new BasePdpVideoView(this.f.getContext(), null, 6, 0);
        r9.k(i(r2), false, new a83.b(), PlayAbilityCacheScene.SCENE_HEADER);
    L17:
        r9.i(r8, new com.bytedance.android.shopping.api.video.d(false, false, 0, 0, false, 511), r9.getSharePlayer());
        l r10 = new l(r9, r8, r1);
        com.bytedance.android.shopping.anchorv4.video.f r11 = this.f.rR().e();
        b r12 = new b(this);
        Intrinsics.checkNotNullParameter("head_video", "scene");
        Intrinsics.checkNotNullParameter(r11, "playerStateManager");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r10.d != null) goto L20;
        k r14 = new k(r10, r12, r11, r11);
        r11.c(r14);
        Unit r15 = Unit.INSTANCE;
        r10.d = r14;
    L20:
        this.b.put(r13, r10);
        return r10;
    L16:
        r9 = new BasePdVideoView(this.f.getContext(), null);
        r9.h(i(r2), false);
    L12:
        r7 = null;
        goto L13
    L22:
        return r3;
    }

    public final PlayerBlock d(int r15) {
        a r0 = b(r15);
        ECUrlModel r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        HeaderContentModel r2 = r0.a;
        HeaderMediaModel r3 = r0.b;
        VideoModel r4 = r0.c;
        PlayerBlockWrapper r5 = this.a.get(r15);
        if (r5 == null) goto L8;
        PlayerBlock r6 = r5.d;
    L9:
        if (r6 != null) goto L44;
        z73.a r7 = PlayAbilityUtil.a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r8 = PlayAbilityUtil.a(r4, null, PlayerViewScene.SCENE_PRODUCT_VIDEO);
        Context r9 = this.f.getContext();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r10 = this.f.w7();
        r10.getClass();
        PlayerBlock r13 = new PlayerBlock(r9, null, 0, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b(r10, r15), true, true, 182);
        AnchorV4HeadV2VO r11 = this.f.K10();
        if (r11 == null) goto L13;
        Boolean r12 = r11.getEnableLego26();
    L14:
        boolean r14 = Intrinsics.areEqual(r12, Boolean.TRUE);
        if (r14 == false) goto L17;
        Integer r16 = 68;
    L18:
        if (r16 == null) goto L20;
        int r17 = r16.intValue();
    L21:
        float r18 = com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r17));
        int r19 = this.f.XU();
        float r20 = k83.a.a(r19, 0);
        if (r19 != 1) goto L27;
        if (this.f.wq() == true) goto L27;
    L31:
        r18 = r18 * r20;
    L32:
        Integer r21 = Integer.valueOf((int) r18);
        if (r14 == false) goto L35;
        Integer r22 = 2131234768;
    L36:
        r13.q(true, r21, r22);
        r13.setCollisionNegotiator(this.f.rR().e0());
        r13.u(this.f.rR().e(), new c(this));
        PlayerViewScene r23 = r8.e;
        if (r23 == null) goto L39;
        r13.z = r23;
    L39:
        ImageModel r24 = r4.getPosterImage();
        if (r24 == null) goto L42;
        r1 = r24.getRemote();
    L42:
        PlayerBlock.m(r13, r8, r1, false, i(r3), null, null, 48);
        r13.setTag(2131370743, Integer.valueOf(r15));
        this.a.put(r15, new PlayerBlockWrapper(r13, r8, r2));
        return r13;
    L35:
        r22 = null;
    L27:
        if (r19 < 2) goto L32;
        if (r15 != 0) goto L32;
        if (this.f.wq() == true) goto L32;
    L20:
        r17 = 79;
        goto L21
    L17:
        r16 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    L44:
        return r6;
    L8:
        r6 = null;
        goto L9
    }

    public final Integer e(PlayerBlock r3) {
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.getTag(2131370743);
    L7:
        if ((r4 instanceof Integer) == false) goto L11;
        r0 = r4;
    L11:
        return (Integer) r0;
    L5:
        r4 = null;
        goto L7
    }

    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b f(int r5) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.n r2 = null;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L18;
        l r0 = this.b.get(r5);
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1 = r0.f;
        if (r1 == null) goto L8;
    L33:
        return r1;
    L8:
        AnchorV4HeadV2VO r3 = this.f.K10();
        if (r3 == null) goto L30;
        VideoModel r4 = AnchorV4HeadV2VO.getVideoData$default(r3, r5, null, 2, null);
        if (r4 == null) goto L31;
        z73.a r6 = PlayAbilityUtil.a;
        AnchorV4HeadV2VO r7 = this.f.K10();
        if (r7 == null) goto L32;
        HeaderMediaModel r8 = AnchorV4HeadV2VO.getVideoMedia$default(r7, r5, null, 2, null);
        if (r8 == null) goto L32;
        r2 = r8.getVideoInteractor();
    L32:
        return PlayAbilityUtil.a(r4, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.h.a(r2), PlayerViewScene.SCENE_PRODUCT_VIDEO);
    L31:
        return null;
    L30:
        return null;
    L18:
        PlayerBlockWrapper r9 = this.a.get(r5);
        if (r9 == null) goto L24;
        r1 = r9.e;
        if (r1 != null) goto L33;
    L24:
        AnchorV4HeadV2VO r10 = this.f.K10();
        if (r10 == null) goto L34;
        VideoModel r11 = AnchorV4HeadV2VO.getVideoData$default(r10, r5, null, 2, null);
        if (r11 == null) goto L35;
        z73.a r12 = PlayAbilityUtil.a;
        return PlayAbilityUtil.a(r11, null, PlayerViewScene.SCENE_PRODUCT_VIDEO);
    L35:
        return null;
    L34:
        return null;
    }

    public final boolean h(int r4) {
        boolean r0 = this.c.get(r4, true);
        this.c.put(r4, false);
        return r0;
    }

    public final void j(int r2) {
        PlayerBlockWrapper r3 = this.a.get(r2);
        if (r3 == null) goto L6;
        r3.b = "click_tab";
        return;
    }

    public final boolean g(Boolean r3, boolean r4) {
        Boolean r0 = a();
        if (r0 != null) goto L5;
        Boolean r1 = this.e;
        if (r1 == null) goto L12;
        boolean r2 = r1.booleanValue();
        if (this.d == true) goto L12;
        return r2;
    L12:
        if (this.f.n0() == false) goto L16;
        if (r3 != null) goto L22;
        return r4;
    L22:
        return r3.booleanValue();
    L16:
        if (this.d == false) goto L19;
        if (r3 != null) goto L24;
        return r4;
    L24:
        return r3.booleanValue();
    L19:
        return true;
    L5:
        return r0.booleanValue();
    }
}
