package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaPreviewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPreviewMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.ItemViewHolder;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFromType;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements s {
    public float A;
    public boolean B;
    public k0 C;
    public final Context D;
    public final View E;
    public u a;
    public int b;
    public int c;
    public Integer d;
    public AnchorV4HeadV2VO e;
    public final b f;
    public final y g;
    public final d0 h;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a i;
    public final HeadLynxAbilityManager j;
    public boolean k;
    public View l;
    public RecyclerView m;
    public Integer n;
    public boolean o;
    public boolean p;
    public final Map<Integer, Boolean> q;
    public boolean r;
    public Integer s;
    public boolean t;
    public Boolean u;
    public final Lazy v;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.t w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public final class b implements o {
        public final o a;
        public final /* synthetic */ e b;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void c(boolean r2) {
            this.a.c(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void e() {
            this.a.e();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void h(boolean r2) {
            this.a.h(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void j(int r2, ImageInfo r3, boolean r4, int r5) {
            this.a.j(r2, r3, r4, r5);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void k() {
            this.a.k();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void m() {
            this.a.m();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void p(String r2) {
            this.a.p(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void s() {
            this.a.s();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void t() {
            this.a.t();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void u() {
            this.a.u();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void w(int r2) {
            this.a.w(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.o
        public final void x(p r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.a.x(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.o
        public final boolean z(p r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            return this.a.z(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onDestroy() {
            Iterator r0 = ((Map) this.b.j.c.getValue()).entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L13;
            Map.Entry r1 = (Map.Entry) r0.next();
            List r2 = (List) r1.getValue();
            if (r2 == null) goto L4;
            Iterator r3 = r2.iterator();
        L9:
            if (r3.hasNext() == false) goto L4;
            ti.j r4 = (ti.j) r3.next();
            if (r4 == null) goto L9;
            ECLiveHybridUtil.p((String) r1.getKey(), r4);
            goto L9
        L13:
            this.a.onDestroy();
            y r5 = this.b.g;
            r5.getClass();
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
            a0.a(r5.b, PlayerAbility$onDestroy$1.INSTANCE);
        L17:
            z73.a r6 = PlayAbilityUtil.a;
            PlayAbilityUtil.a.a.clear();
            return;
        L16:
            a0.a(r5.a, PlayerAbility$onDestroy$2.INSTANCE);
            goto L17
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onPause() {
            this.a.onPause();
            y r0 = this.b.g;
            r0.getClass();
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
            a0.a(r0.b, PlayerAbility$onPause$1.INSTANCE);
            return;
        L5:
            a0.a(r0.a, PlayerAbility$onPause$2.INSTANCE);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onResume() {
            this.a.onResume();
            y r0 = this.b.g;
            r0.getClass();
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
            a0.a(r0.b, PlayerAbility$onResume$1.INSTANCE);
            return;
        L5:
            a0.a(r0.a, PlayerAbility$onResume$2.INSTANCE);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void v() {
            this.a.v();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void A(boolean r3) {
            e r0 = this.b;
            r0.z = false;
            if (r3 == false) goto L5;
            float r1 = 1.0f;
        L6:
            r0.A = r1;
            this.a.A(r3);
            return;
        L5:
            r1 = 0.0f;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void a(boolean r2) {
            this.b.getClass();
            this.a.a(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void f(boolean r2) {
            this.b.o = r2;
            this.a.f(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void i(float r3) {
            e r0 = this.b;
            r0.A = r3;
            if (r0.z == true) goto L8;
            if (r3 >= 1.0f) goto L8;
            r0.z = true;
            this.a.s();
        L8:
            if (this.b.z == false) goto L11;
            this.a.i(r3);
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void onPageSelected(int r15) {
            e r0 = this.b;
            if (r0.b == r15) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r4 = r0.i;
            r4.getClass();
            q.a.a(r4, "slide_product_main_picture", MapsKt.mapOf(TuplesKt.to("item_order", Integer.valueOf(r15 + 1))), true, null, r4.b.getRecyclerView(), "a1.b8094.c0645.d057069", null, null, 408);
        L8:
            e r2 = this.b;
            r2.n = null;
            r2.y = true;
            r2.c = r2.b;
            r2.b = r15;
            u r3 = r2.rR();
            if (r3 == null) goto L11;
            r3.Z(new i(r2, r15), false);
        L11:
            this.a.onPageSelected(r15);
            if (r1 == false) goto L20;
            e r5 = this.b;
            AnchorV4HeadV2VO r6 = r5.e;
            if (r6 == null) goto L20;
            Map<String, IAction> r7 = r6.getActionMap();
            if (r7 == null) goto L20;
            IAction r8 = r7.get("header_state_change_action");
            if (r8 == null) goto L20;
            d0 r9 = r5.h;
            r9.d(r8, r5.E, r9.a());
        L20:
            e.l(this.b, r15);
            e r10 = this.b;
            u r11 = r10.rR();
            if (r11 == null) goto L23;
            r11.Z(new h(r10, r15), false);
        L23:
            this.b.y = false;
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void q(AnchorV4HeadV2VO r2) {
            Intrinsics.checkNotNullParameter(r2, "headVo");
            this.a.q(r2);
        }

        public b(e r2, EventDispatcher r3) {
            Intrinsics.checkNotNullParameter(r3, "dispatcher");
            this.b = r2;
            this.a = r3;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void d(boolean r4, int r5) {
            this.b.q.put(Integer.valueOf(r5), Boolean.valueOf(r4));
            this.a.d(r4, r5);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
        public final void n(int r2, Boolean r3) {
            if (this.b.y == true) goto L6;
            this.a.n(r2, null);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void Gw() {
        this.r = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void Nw() {
        this.x = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final com.bytedance.android.shopping.anchorv4.voavhs.blur.f eL() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.blur.f) this.v.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void u1() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final int XU() {
        Integer r0 = this.s;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final int bz() {
        Integer r0 = this.d;
        if (r0 != null) goto L5;
        u r1 = rR();
        Integer r2 = null;
        if (r1 == null) goto L13;
        AnchorV4Param r3 = r1.c();
        if (r3 == null) goto L13;
        V4NativeParams r4 = r3.getNativeParams();
        if (r4 == null) goto L13;
        String r5 = r4.getCovImageUri();
    L14:
        boolean r6 = true;
        int r7 = 0;
        if (com.bytedance.android.shopping.extensions.k.c(r5) == false) goto L43;
        AnchorV4HeadV2VO r8 = this.e;
        if (r8 == null) goto L38;
        List<HeaderContentModel> r9 = r8.getCells();
        if (r9 == null) goto L38;
        Iterator<HeaderContentModel> r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L35;
        HeaderMediaModel r11 = r10.next().getMedia();
        if (r11 == null) goto L30;
        ImageModel r12 = r11.getImage();
        if (r12 == null) goto L30;
        ECUrlModel r13 = r12.getRemote();
        if (r13 == null) goto L30;
        String r14 = r13.getUri();
    L32:
        if (Intrinsics.areEqual(r14, r5) == true) goto L36;
        r7 = r7 + 1;
    L36:
        this.d = Integer.valueOf(r7);
        return r7;
    L30:
        r14 = null;
        goto L32
    L35:
        r7 = -1;
    L38:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r15 = this.i;
        Pair[] r16 = new Pair[1];
        CommonMeta r17 = r15.b.rR().r0();
        if (r17 == null) goto L41;
        String r18 = r17.getProductId();
    L42:
        r16[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r18);
        q.a.a(r15, "product_preview_dismatch", MapsKt.hashMapOf(r16), false, null, null, null, null, null, 508);
        goto L43
    L41:
        r18 = null;
    L43:
        AnchorV4HeadV2VO r19 = this.e;
        if (r19 == null) goto L58;
        HeaderPreviewMeta r20 = r19.getPreviewMeta();
        if (r20 == null) goto L58;
        Integer r21 = r20.getDefaultPosition();
        if (r21 == null) goto L58;
        if (r21.intValue() > 0) goto L53;
        r6 = false;
    L53:
        if (r6 == false) goto L55;
        r2 = r21;
    L55:
        if (r2 == null) goto L58;
        return r2.intValue();
    L58:
        this.d = Integer.valueOf(this.b);
        return this.b;
    L13:
        r5 = null;
        goto L14
    L5:
        return r0.intValue();
    }

    @Override // d83.b
    public final List<ECUrlModel> c() {
        ArrayList r0 = new ArrayList();
        AnchorV4HeadV2VO r1 = this.e;
        if (r1 == null) goto L20;
        List<HeaderContentModel> r2 = r1.getCells();
        if (r2 == null) goto L20;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L20;
        HeaderMediaModel r4 = ((HeaderContentModel) r3.next()).getMedia();
        if (r4 == null) goto L19;
        if (r4.getSupportNavBlur() == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L19;
        ECUrlModel r5 = HeaderMediaModel.getImageUrl$default(r4, false, 1, null);
        if (r5 == null) goto L19;
        r0.add(r5);
    L19:
        r0.add(null);
    L20:
        return r0;
    }

    @Override // d83.b
    public final void d() {
        this.f.onPause();
    }

    @Override // d83.b
    public final String f() {
        AnchorV4HeadV2VO r0 = this.e;
        if (r0 == null) goto L15;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L15;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.getOrNull(r1, getCurrentPosition());
        if (r2 == null) goto L15;
        HeaderMediaModel r3 = r2.getMedia();
        if (r3 == null) goto L15;
        ImageModel r4 = r3.getImage();
        if (r4 == null) goto L15;
        ECUrlModel r5 = r4.getRemote();
        if (r5 == null) goto L15;
        return r5.getUri();
    L15:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final int getCurrentPosition() {
        Integer r0 = this.n;
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        return this.b;
    }

    @Override // d83.b
    public final boolean i() {
        AnchorV4HeadV2VO r0 = this.e;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getSizeType() != 1) goto L9;
        if (n0() == false) goto L9;
        return true;
    }

    @Override // d83.b
    public final List<ECUrlModel> k() {
        AnchorV4HeadV2VO r0 = this.e;
        if (r0 == null) goto L86;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L86;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L86;
        ArrayList r3 = new ArrayList();
        AnchorV4HeadV2VO r4 = this.e;
        if (r4 == null) goto L85;
        List<HeaderContentModel> r5 = r4.getCells();
        if (r5 == null) goto L85;
        Iterator<T> r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L85;
        HeaderContentModel r7 = (HeaderContentModel) r6.next();
        if (r7.getMultiPreview() != null) goto L18;
        if (XU() != 1) goto L74;
        if (wq() == true) goto L74;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.i r8 = r7.getStyle();
        if (r8 == null) goto L51;
        Float r9 = r8.a();
        if (r9 == null) goto L51;
        float r10 = r9.floatValue();
    L53:
        if (r10 < 1.0f) goto L54;
        HeaderMediaModel r11 = r7.getMedia();
        if (r11 == null) goto L15;
        if (r11.getSupportNavBlur() == true) goto L70;
        r11 = null;
    L70:
        if (r11 == null) goto L15;
        ECUrlModel r12 = HeaderMediaModel.getImageUrl$default(r11, false, 1, null);
        if (r12 == null) goto L15;
        r3.add(r12);
        goto L15
    L54:
        ECUrlModel r13 = new ECUrlModel();
        HeaderMediaModel r14 = r2.getMedia();
        if (r14 == null) goto L62;
        ECUrlModel r15 = HeaderMediaModel.getImageUrl$default(r14, false, 1, null);
        if (r15 == null) goto L62;
        List r16 = r15.getUrlList();
        if (r16 == null) goto L62;
        String r17 = (String) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L62;
    L63:
        r13.setUrlList(CollectionsKt.listOf(r17));
        r13.setUri("empty_place_holder");
        Unit r18 = Unit.INSTANCE;
        r3.add(r13);
    L62:
        r17 = "";
    L51:
        r10 = 1.0f;
    L74:
        HeaderMediaModel r19 = r7.getMedia();
        if (r19 == null) goto L84;
        if (r19.getSupportNavBlur() == true) goto L80;
        r19 = null;
    L80:
        if (r19 == null) goto L84;
        ECUrlModel r20 = HeaderMediaModel.getImageUrl$default(r19, false, 1, null);
        if (r20 == null) goto L84;
        r3.add(r20);
    L84:
        r3.add(null);
        goto L15
    L18:
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r21 = r7.getMultiPreview().a();
        if (r21 == null) goto L15;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r22 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r21, 0);
        if (r22 == null) goto L15;
        if (r22.a() != null) goto L24;
        if (r22.c() == null) goto L15;
        AnchorV4HeadV2VO r23 = this.e;
        if (r23 == null) goto L40;
        List<HeaderContentModel> r24 = r23.getCells();
        if (r24 == null) goto L40;
        HeaderContentModel r25 = (HeaderContentModel) CollectionsKt.getOrNull(r24, r22.c().intValue());
        if (r25 == null) goto L40;
        HeaderMediaModel r26 = r25.getMedia();
        if (r26 == null) goto L40;
        ECUrlModel r27 = HeaderMediaModel.getImageUrl$default(r26, false, 1, null);
    L41:
        r3.add(r27);
    L40:
        r27 = null;
        goto L41
    L24:
        HeaderMediaModel r28 = r22.a().getMedia();
        if (r28 == null) goto L27;
        ECUrlModel r29 = HeaderMediaModel.getImageUrl$default(r28, false, 1, null);
    L28:
        r3.add(r29);
        goto L15
    L27:
        r29 = null;
    L85:
        return r3;
    L86:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void m90() {
        boolean r0 = this.t;
        this.t = true;
        if (r0 == true) goto L6;
        this.f.e();
        return;
    }

    @Override // d83.b
    public final void onResume() {
        this.f.onResume();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final u rR() {
        u r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("headerDependency");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean wq() {
        Boolean r0 = this.u;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final int FB() {
        if (n0() == false) goto L5;
        float r0 = 1.0f;
    L7:
        if (r0 > 0.5f) goto L11;
        return 0;
    L11:
        return (int) (((r0 - 0.5f) / (1 - 0.5f)) * com.bytedance.android.shopping.utils.d0.a());
    L5:
        r0 = this.A;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean Gv() {
        u r0 = rR();
        if (r0 == null) goto L13;
        AnchorV4Param r1 = r0.c();
        if (r1 == null) goto L13;
        V4NativeParams r2 = r1.getNativeParams();
        if (r2 == null) goto L13;
        WireFrameSchemaInfo r3 = r2.getWireFrameSchemaInfo();
        if (r3 == null) goto L13;
        if (r3.getHalPdpHeadSpace() != 1) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean Mm() {
        u r0 = rR();
        if (r0 == null) goto L15;
        AnchorV4Param r1 = r0.c();
        if (r1 == null) goto L15;
        V4NativeParams r2 = r1.getNativeParams();
        if (r2 == null) goto L15;
        WireFrameSchemaInfo r3 = r2.getWireFrameSchemaInfo();
        if (r3 == null) goto L15;
        if (r3.getHalPdpOptimizeStyle() != 1) goto L15;
        if (s00() == 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final AnchorV4HeadV2VO P70() {
        u r0 = rR();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final int W4() {
        u r0 = rR();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.W4());
    L7:
        return r1.intValue();
    L5:
        r1 = null;
        goto L7
    }

    @Override // d83.b
    public final boolean g() {
        u r0 = rR();
        if (r0 == null) goto L7;
        CommonMeta r1 = r0.r0();
        if (r1 == null) goto L7;
        Boolean r2 = Boolean.valueOf(r1.getEnablePDPOptimize());
    L9:
        return com.bytedance.android.shopping.extensions.k.i(r2);
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean isExpanded() {
        u r0 = rR();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isExpanded());
    L7:
        return com.bytedance.android.shopping.extensions.k.i(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean k80() {
        u r0 = rR();
        if (r0 != null) goto L5;
    L42:
        return false;
    L5:
        if (r0.b() != true) goto L42;
        FragmentManager r3 = null;
        if ((getContext() instanceof p83.g) == false) goto L18;
        Context r1 = getContext();
        if ((r1 instanceof FragmentActivity) == true) goto L12;
        r1 = null;
    L12:
        FragmentActivity r2 = (FragmentActivity) r1;
        if (r2 == null) goto L15;
        r3 = r2.getSupportFragmentManager();
    L15:
        boolean r4 = o(r3);
    L17:
        return !r4;
    L18:
        Context r5 = getContext();
        if ((r5 instanceof FragmentActivity) == true) goto L21;
        r5 = null;
    L21:
        FragmentActivity r6 = (FragmentActivity) r5;
        if (r6 == null) goto L24;
        FragmentManager r7 = r6.getSupportFragmentManager();
    L26:
        if (o(r7) == false) goto L28;
        return false;
    L28:
        if (r7 == null) goto L41;
        List r8 = r7.getFragments();
        if (r8 == null) goto L41;
        Iterator r9 = r8.iterator();
    L33:
        if (r9.hasNext() == false) goto L37;
        Object r10 = r9.next();
        if ((((Fragment) r10) instanceof p83.g) == false) goto L33;
    L38:
        Fragment r11 = (Fragment) r10;
        if (r11 == null) goto L41;
        r3 = r11.getChildFragmentManager();
        goto L41
    L37:
        r10 = null;
    L41:
        r4 = o(r3);
        goto L17
    L24:
        r7 = null;
        goto L26
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean n0() {
        u r0 = rR();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.n0());
    L7:
        return com.bytedance.android.shopping.extensions.k.i(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean oa() {
        u r0 = rR();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.oa());
    L7:
        return com.bytedance.android.shopping.extensions.k.i(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean r9() {
        u r0 = rR();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.r9());
    L7:
        return com.bytedance.android.shopping.extensions.k.i(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // d83.b
    public final boolean s() {
        if (W4() > 0) goto L5;
    L7:
        return false;
    L5:
        if (n0() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final float s00() {
        u r0 = rR();
        if (r0 == null) goto L11;
        AnchorV4Param r1 = r0.c();
        if (r1 == null) goto L11;
        V4NativeParams r2 = r1.getNativeParams();
        if (r2 == null) goto L11;
        WireFrameSchemaInfo r3 = r2.getWireFrameSchemaInfo();
        if (r3 == null) goto L11;
        return r3.getHalfPdpHeadScaleParam();
    L11:
        return 0.0f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean wZ() {
        u r0 = rR();
        if (r0 == null) goto L13;
        AnchorV4Param r1 = r0.c();
        if (r1 == null) goto L13;
        V4NativeParams r2 = r1.getNativeParams();
        if (r2 == null) goto L13;
        WireFrameSchemaInfo r3 = r2.getWireFrameSchemaInfo();
        if (r3 == null) goto L13;
        if (r3.getHalPdpOptimizeStyle() != 1) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean BY() {
        return this.x;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final Boolean Cb() {
        return this.u;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final int G7() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final float HG() {
        return this.A;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final AnchorV4HeadV2VO K10() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final Integer Lz() {
        return this.s;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final HeadLynxAbilityManager Pg() {
        return this.j;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final Map<Integer, Boolean> Rm() {
        return this.q;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final y Sf() {
        return this.g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean Y10() {
        return this.p;
    }

    @Override // d83.b
    public final boolean a() {
        return this.k;
    }

    @Override // d83.b
    public final View e() {
        return this.E;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean eI() {
        return this.z;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final b eh() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public Context getContext() {
        return this.D;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final RecyclerView getRecyclerView() {
        return this.m;
    }

    @Override // d83.b
    public final View h() {
        return this.l;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean h00() {
        return this.t;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.t hq() {
        return this.w;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean p3() {
        return this.o;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean vn() {
        return this.r;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a w7() {
        return this.i;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final d0 yd() {
        return this.h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean z20() {
        return this.B;
    }

    public static boolean o(FragmentManager r2) {
        if (r2 == null) goto L14;
        Iterator r3 = r2.getFragments().iterator();
    L5:
        if (r3.hasNext() == false) goto L24;
        Fragment r0 = (Fragment) r3.next();
        if ((r0 instanceof DialogFragment) == false) goto L5;
        if ((r0 instanceof p83.g) == true) goto L5;
        if (r0.isVisible() == false) goto L5;
        return true;
    L24:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void D6(RecyclerView r1) {
        this.m = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void Em(Integer r1) {
        this.s = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean aN(int r2) {
        if (this.t == true) goto L13;
        AnchorV4HeadV2VO r0 = this.e;
        if (r0 == null) goto L13;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L13;
        HeaderContentModel r3 = (HeaderContentModel) CollectionsKt.getOrNull(r1, r2);
        if (r3 == null) goto L13;
        if (r3.getDefaultHide() != true) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // d83.b
    public final void b(boolean r1) {
        this.B = r1;
        if (r1 == false) goto L5;
        this.f.t();
        return;
    L5:
        this.f.m();
    }

    @Override // d83.b
    public final void j(View r1) {
        this.l = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void k0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceId");
        k0 r0 = this.C;
        if (r0 == null) goto L6;
        r0.k0(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void l9(GalleryVO r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryVO");
        k0 r0 = this.C;
        if (r0 == null) goto L6;
        r0.l9(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void pK(Integer r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void tB(Boolean r1) {
        this.u = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void w5(Map<Integer, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        k0 r0 = this.C;
        if (r0 == null) goto L6;
        r0.w5(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void y5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "specId");
        k0 r0 = this.C;
        if (r0 == null) goto L6;
        r0.y5(r2);
        return;
    }

    public static final void l(e r1, int r2) {
        b r0 = r1.f;
        AnchorV4HeadV2VO r3 = r1.e;
        if (r3 == null) goto L9;
        List<HeaderContentModel> r4 = r3.getCells();
        if (r4 == null) goto L9;
        HeaderContentModel r5 = (HeaderContentModel) CollectionsKt.getOrNull(r4, r2);
        if (r5 == null) goto L9;
        String r6 = r5.getSkuSpecId();
    L10:
        r0.p(r6);
        return;
    L9:
        r6 = null;
        goto L10
    }

    public static Integer p(String r1, Map r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.get(r1);
    L7:
        if ((r3 instanceof Number) == true) goto L9;
        r3 = null;
    L9:
        Number r4 = (Number) r3;
        if (r4 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(r4.intValue());
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void Kb(int r2, Bitmap r3) {
        u r0 = rR();
        if (r0 == null) goto L6;
        r0.q0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void TB(int r9, boolean r10) {
        AnchorV4HeadV2VO r0 = this.e;
        if (r0 == null) goto L11;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L11;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.getOrNull(r1, r9);
        if (r2 == null) goto L11;
        IAction r3 = r2.getClickAction();
        if (r3 == null) goto L11;
        this.h.d(r3, this.E, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("disable_gallery_anim", Boolean.valueOf(r10))}));
        return;
    L11:
        AnchorV4HeadV2VO r4 = this.e;
        if (r4 == null) goto L20;
        HeaderContentModel r5 = AnchorV4HeadV2VO.getMultiPreviewCell$default(r4, r9, 0, 2, null);
        if (r5 == null) goto L21;
        IAction r6 = r5.getClickAction();
        if (r6 == null) goto L22;
        this.h.d(r6, this.E, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("disable_gallery_anim", Boolean.valueOf(r10)), TuplesKt.to("index", Integer.valueOf(r9)), TuplesKt.to("multi_position", Integer.valueOf(r9))}));
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final void W8(int r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        u r0 = rR();
        if (r0 == null) goto L6;
        r0.f0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean iW(Integer r3, Boolean r4) {
        if (r4 == null) goto L4;
        boolean r5 = r4.booleanValue();
    L6:
        if (r3 != null) goto L20;
        if (r5 == true) goto L32;
        Integer r6 = this.s;
        if (r6 != null) goto L12;
    L13:
        Integer r7 = this.s;
        if (r7 != null) goto L17;
        return false;
    L17:
        if (r7.intValue() != 3) goto L33;
    L18:
        return true;
    L33:
        return false;
    L12:
        if (r6.intValue() == 2) goto L18;
    L32:
        return false;
    L20:
        if (r5 == true) goto L35;
        AnchorV4HeadV2VO r8 = this.e;
        if (r8 == null) goto L28;
        List<HeaderContentModel> r9 = r8.getCells();
        if (r9 == null) goto L28;
        HeaderContentModel r10 = (HeaderContentModel) CollectionsKt.getOrNull(r9, r3.intValue());
        if (r10 == null) goto L28;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r11 = r10.getMultiPreview();
    L29:
        if (r11 == null) goto L36;
        return true;
    L36:
        return false;
    L28:
        r11 = null;
        goto L29
    L35:
        return false;
    L4:
        r5 = wq();
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void l0(int r2, String r3) {
        k0 r0 = this.C;
        if (r0 == null) goto L6;
        r0.l0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s
    public final boolean qV(Integer r4, Boolean r5) {
        if (XU() != 1) goto L22;
        if (r5 == null) goto L6;
        boolean r6 = r5.booleanValue();
    L7:
        if (r4 == null) goto L9;
        AnchorV4HeadV2VO r0 = this.e;
        if (r0 == null) goto L17;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.i r7 = r0.getCellStyle(r4.intValue());
        if (r7 == null) goto L17;
        Float r8 = r7.a();
        if (r8 == null) goto L17;
        float r9 = r8.floatValue();
    L18:
        if (r6 == true) goto L22;
        if (r9 >= 1.0f) goto L22;
        return true;
    L17:
        r9 = 1.0f;
        goto L18
    L9:
        return !r6;
    L6:
        r6 = wq();
    L22:
        return false;
    }

    public e(EventDispatcher r2, Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        this.D = r3;
        this.E = r4;
        this.c = -1;
        this.f = new b(this, r2);
        this.g = new y(this);
        this.h = new d0(this);
        this.i = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a(this);
        this.j = new HeadLynxAbilityManager(this);
        this.q = new LinkedHashMap();
        this.s = 0;
        this.v = LazyKt.lazy(new HeadAbilityManager$blurManager$2(this));
        this.w = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.t(this);
        this.B = true;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.HeadAbilityManager$openGallery$3] */
    public final void n(View r27, String r28, Map<String, ? extends Object> r29, Map<String, ? extends Object> r30) {
        if (r28 == null) goto L357;
        int r11 = 0;
        switch(r28.hashCode()) {
            case -1051415986: goto L295;
            case -100528790: goto L244;
            case 1399912872: goto L44;
            case 1774976811: goto L9;
            default: goto L358;
        };
    L358:
        return;
    L9:
        if (r28.equals("HeadTrack") == false) goto L347;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r12 = this.i;
        if (r29 == null) goto L13;
        Object r0 = r29.get("event_name");
    L15:
        if ((r0 instanceof String) == true) goto L17;
        r0 = null;
    L17:
        String r13 = (String) r0;
        if (r29 == null) goto L20;
        Object r1 = r29.get("event_params");
    L22:
        if ((r1 instanceof Map) == true) goto L24;
        r1 = null;
    L24:
        Map r14 = (Map) r1;
        View r2 = this.E;
        if (r29 == null) goto L27;
        Object r3 = r29.get("btm_id");
    L29:
        if ((r3 instanceof String) == true) goto L31;
        r3 = null;
    L31:
        String r18 = (String) r3;
        if (r29 == null) goto L36;
        Object r4 = r29.get("bst_report_type");
        if (r4 == null) goto L36;
        Integer r19 = Integer.valueOf(mq.b.b(r4, 0));
    L37:
        if (r29 == null) goto L41;
        Object r5 = r29.get("standard");
        if (r5 == null) goto L41;
        Integer r20 = Integer.valueOf(mq.b.b(r5, 0));
    L42:
        q.a.a(r12, r13, r14, false, null, r2, r18, r19, r20, 28);
        return;
    L41:
        r20 = null;
    L36:
        r19 = null;
        goto L37
    L27:
        r3 = null;
        goto L29
    L20:
        r1 = null;
        goto L22
    L13:
        r0 = null;
        goto L15
    L347:
        return;
    L44:
        if (r28.equals("HeadPreview") == false) goto L349;
        Integer r6 = p("index", r29);
        String r15 = "";
        if (r6 == null) goto L230;
        int r16 = r6.intValue();
        Integer r17 = p("sub_index", r29);
        if (r30 == null) goto L50;
        Object r7 = r30.get("disable_gallery_anim");
    L52:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == true) goto L90;
        if (r30 == null) goto L56;
        Object r8 = r30.get("index");
    L58:
        if ((r8 instanceof Integer) == true) goto L60;
        r8 = null;
    L60:
        Integer r9 = (Integer) r8;
        if (r9 == null) goto L63;
        int r10 = r9.intValue();
    L64:
        if (r30 == null) goto L66;
        Object r21 = r30.get("multi_position");
    L68:
        if ((r21 instanceof Integer) == true) goto L70;
        r21 = null;
    L70:
        Integer r22 = (Integer) r21;
        if (r22 != null) goto L73;
        r22 = r17;
    L73:
        RecyclerView r23 = this.m;
        if (r23 == null) goto L76;
        RecyclerView.ViewHolder r24 = r23.findViewHolderForAdapterPosition(r10);
    L78:
        if ((r24 instanceof ItemViewHolder) == true) goto L80;
        r24 = null;
    L80:
        ItemViewHolder r25 = (ItemViewHolder) r24;
        if (r25 == null) goto L83;
        Object r26 = ((RecyclerView.ViewHolder) r25).itemView;
    L85:
        if ((r26 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w) == true) goto L87;
        r26 = null;
    L87:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w r31 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w) r26;
        if (r31 == null) goto L90;
        View r110 = r31.B(r22);
    L91:
        ArrayList r32 = new ArrayList();
        ArrayList r33 = new ArrayList();
        this.f.w(r16);
        AnchorV4HeadV2VO r34 = this.e;
        int r111 = -1;
        if (r34 == null) goto L156;
        List<HeaderContentModel> r35 = r34.getCells();
        if (r35 == null) goto L156;
        Iterator<T> r112 = r35.iterator();
        int r36 = -1;
        int r113 = 0;
    L97:
        if (r112.hasNext() == false) goto L156;
        Object r37 = r112.next();
        int r114 = r113 + 1;
        if (r113 >= 0) goto L101;
        CollectionsKt.throwIndexOverflow();
    L101:
        HeaderContentModel r38 = (HeaderContentModel) r37;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r39 = r38.getMultiPreview();
        if (r39 == null) goto L114;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r40 = r39.a();
        if (r40 == null) goto L114;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r41 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r40, r11);
        if (r41 == null) goto L114;
        HeaderContentModel r42 = r41.a();
        if (r42 == null) goto L114;
        HeaderMediaModel r43 = r42.getMedia();
        if (r43 == null) goto L114;
        if (r43.getSupportPreview() != true) goto L114;
        HeaderContentModel r210 = r42;
    L115:
        HeaderMediaModel r44 = r210.getMedia();
        if (r44 != null) goto L118;
    L154:
        ArrayList r115 = r33;
        ArrayList r116 = r32;
    L155:
        r33 = r115;
        r32 = r116;
        r113 = r114;
        r11 = 0;
        goto L97
    L118:
        if (r44.getSupportPreview() != true) goto L154;
        if (com.bytedance.android.shopping.extensions.k.c(r210.getSkuSpecId()) == false) goto L122;
        r36 = r36 + 1;
    L122:
        int r211 = r36;
        HeaderMediaModel r45 = r210.getMedia();
        if (r45 == null) goto L125;
        List<HeaderMediaPreviewModel> r46 = r45.getPreviewList();
    L126:
        if (r46 != null) goto L129;
        r46 = CollectionsKt.emptyList();
    L129:
        if ((!r46.isEmpty()) == false) goto L138;
        Iterator<T> r212 = r46.iterator();
        int r47 = 0;
    L132:
        if (r212.hasNext() == false) goto L137;
        Object r48 = r212.next();
        int r213 = r47 + 1;
        if (r47 >= 0) goto L136;
        CollectionsKt.throwIndexOverflow();
    L136:
        HeaderMediaPreviewModel r49 = (HeaderMediaPreviewModel) r48;
        ArrayList r117 = r32;
        r117.add(m(r16, r210, r49.getUrlModel(), r113, r211, r49.getPreviewIndex(), Integer.valueOf(r47)));
        r33 = r33;
        r32 = r117;
        r47 = r213;
        goto L132
    L137:
        r115 = r33;
        r116 = r32;
    L153:
        r36 = r211;
        goto L155
    L138:
        r115 = r33;
        r116 = r32;
        if (r45 == null) goto L143;
        ImageModel r50 = r45.getImage();
        if (r50 == null) goto L143;
        ECUrlModel r51 = r50.getRemote();
    L144:
        if (r45 == null) goto L146;
        int r52 = r45.getPreviewIndex();
    L147:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r53 = m(r16, r210, r51, r113, r211, r52, null);
        GalleryFragment.N.getClass();
        Intrinsics.checkNotNullParameter(r53, "it");
        if (GalleryFragment.b.a(r53) == null) goto L150;
        boolean r54 = true;
    L151:
        if (r54 == false) goto L153;
        r116.add(r53);
        goto L153
    L150:
        r54 = false;
        goto L151
    L146:
        r52 = 0;
    L143:
        r51 = null;
        goto L144
    L125:
        r46 = null;
    L114:
        r210 = r38;
    L156:
        ArrayList r118 = r33;
        ArrayList r119 = r32;
        AnchorV4HeadV2VO r55 = this.e;
        if (r55 != null) goto L159;
    L163:
        Iterator r56 = r119.iterator();
        int r57 = 0;
    L165:
        if (r56.hasNext() == false) goto L173;
        if (((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q) r56.next()).h != r16) goto L169;
        boolean r58 = true;
    L170:
        if (r58 == true) goto L171;
        r57 = r57 + 1;
        goto L165
    L171:
        r111 = r57;
        goto L173
    L169:
        r58 = false;
    L173:
        if (r111 < 0) goto L230;
        if (r17 != null) goto L177;
    L183:
        int r59 = r111;
    L184:
        AnchorV4HeadV2VO r60 = this.e;
        if (r60 == null) goto L188;
        final List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.m> r61 = r60.getHeaderTabs();
        if (r61 == null) goto L188;
    L189:
        final Ref.IntRef r62 = new Ref.IntRef();
        r62.element = 0;
        ?? r63 = new HeadAbilityManager$openGallery$3(r62, r61);
        Iterator r64 = r119.iterator();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.m r65 = null;
        int r120 = 0;
    L191:
        if (r64.hasNext() == false) goto L217;
        Object r66 = r64.next();
        int r67 = r120 + 1;
        if (r120 >= 0) goto L195;
        CollectionsKt.throwIndexOverflow();
    L195:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r68 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q) r66;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.m r69 = r63.invoke(r68.h);
        if (r69 == null) goto L216;
        if ((!Intrinsics.areEqual(r65, r69)) == true) goto L200;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0 r70 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0) CollectionsKt.lastOrNull(r118);
        if (r70 == null) goto L216;
        r70.b++;
        List<String> r71 = r70.e;
        if (TypeIntrinsics.isMutableList(r71) == true) goto L213;
        r71 = null;
    L213:
        if (r71 == null) goto L215;
        r71.add(r69.b(r68.h));
    L215:
        r68.m = r70;
        goto L216
    L200:
        if (r69.c() == null) goto L202;
        List r214 = CollectionsKt.mutableListOf(new String[]{r69.b(r68.h)});
    L203:
        String r72 = r69.d();
        if (r72 != null) goto L206;
        String r121 = "";
    L207:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0 r73 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0(r120, 1, r121, r69.f(), r214);
        r68.m = r73;
        Unit r74 = Unit.INSTANCE;
        r118.add(r73);
        goto L216
    L206:
        r121 = r72;
        goto L207
    L202:
        r214 = null;
    L216:
        r120 = r67;
        r65 = r69;
        goto L191
    L217:
        y r75 = this.g;
        r75.getClass();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.c() == false) goto L222;
        PlayerBlockWrapper r76 = r75.a.get(r16);
        if (r76 == null) goto L229;
        r76.a("pause", r76.e.h(), false);
    L229:
        Fragment r77 = com.bytedance.android.shopping.anchorv4.containers.a.a;
        u r78 = rR();
        Intrinsics.checkNotNull(r78);
        f r79 = new f(this, r78.P(), GalleryFromType.Head);
        GalleryFragment.N.getClass();
        GalleryFragment r80 = new GalleryFragment(r79, GalleryFragment.b.b(r110));
        this.C = r80;
        this.k = true;
        r80.ma0(r119, r118);
        int r81 = FullScreenGalleryDialogActivity.l;
        Context r82 = getContext();
        GalleryViewerParams r84 = new GalleryViewerParams(r59);
        BtmSDK r85 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.model.d r86 = new com.bytedance.android.btm.api.model.d();
        r86.a = "a1.b8094.c0645.d0";
        r86.b = PageFinder.via(this.m);
        Unit r87 = Unit.INSTANCE;
        FullScreenGalleryDialogActivity.a.a(r82, r84, r85.createJumpSourceBtmToken(r86));
        com.bytedance.android.shopping.anchorv4.containers.a.a = r80;
        goto L230
    L222:
        PlayerBlockWrapper r88 = r75.a.get(r16);
        if (r88 == null) goto L229;
        PlayerBlock r89 = r88.d;
        if (r89 == null) goto L229;
        PlayerBlock.z(r89, false, false, "big_picture", 3);
        c63.c r90 = r89.N;
        if (r90 == null) goto L229;
        r90.y("big_picture");
    L188:
        r61 = CollectionsKt.emptyList();
        goto L189
    L177:
        if (r17.intValue() <= 0) goto L183;
        r59 = r17.intValue() + r111;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r91 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q) CollectionsKt.getOrNull(r119, r59);
        if (r91 == null) goto L183;
        if (r91.h != r16) goto L183;
    L159:
        if (r55.getNeedSortPreview() != true) goto L163;
        if (r119.size() <= 1) goto L163;
        CollectionsKt.sortWith(r119, new g());
        goto L163
    L83:
        r26 = null;
        goto L85
    L76:
        r24 = null;
        goto L78
    L66:
        r21 = null;
        goto L68
    L63:
        r10 = r16;
        goto L64
    L56:
        r8 = null;
    L90:
        r110 = null;
        goto L91
    L50:
        r7 = null;
    L230:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r92 = this.i;
        r92.getClass();
        q.a.a(r92, "click_product_main_picture", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail")}), false, null, null, null, null, null, 508);
        CommonMeta r94 = r92.b.rR().r0();
        if (r94 != null) goto L233;
    L242:
        r92.b.rR().f();
        return;
    L233:
        if (com.bytedance.android.shopping.extensions.k.c(h73.a.b(r94)) == false) goto L235;
        CommonMeta r122 = r94;
    L236:
        if (r122 == null) goto L242;
        s83.g r95 = AdLogUtils.a;
        String r96 = h73.a.b(r122);
        if (r96 == null) goto L241;
        r15 = r96;
    L241:
        AdLogUtils.i(r15, h73.a.a(r122), h73.a.c(r122));
        goto L242
    L235:
        r122 = null;
        goto L236
    L349:
        return;
    L244:
        if (r28.equals("HeadScrollToIndex") == false) goto L351;
        Integer r97 = p("index", r29);
        if (r97 == null) goto L352;
        int r98 = r97.intValue();
        if (r29 == null) goto L250;
        Object r99 = r29.get("is_preview_index");
    L252:
        if ((r99 instanceof Boolean) == false) goto L255;
        Boolean r100 = (Boolean) r99;
    L266:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L286;
        AnchorV4HeadV2VO r101 = this.e;
        if (r101 == null) goto L285;
        List<HeaderContentModel> r102 = r101.getCells();
        if (r102 == null) goto L285;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
        int r123 = 0;
    L273:
        if (r104.hasNext() == false) goto L284;
        Object r105 = r104.next();
        int r106 = r123 + 1;
        if (r123 >= 0) goto L277;
        CollectionsKt.throwIndexOverflow();
    L277:
        Integer r107 = Integer.valueOf(r123);
        r107.intValue();
        if ((!((HeaderContentModel) r105).getDefaultHide()) == true) goto L281;
        r107 = null;
    L281:
        if (r107 == null) goto L283;
        r103.add(r107);
    L283:
        r123 = r106;
        goto L273
    L284:
        Integer r108 = (Integer) CollectionsKt.getOrNull(r103, r98);
    L287:
        if (r108 != null) goto L289;
        return;
    L289:
        if ((!aN(r108.intValue())) == true) goto L292;
        r108 = null;
    L292:
        if (r108 == null) goto L354;
        this.f.n(r108.intValue(), null);
        return;
    L354:
        return;
    L285:
        r108 = null;
        goto L287
    L286:
        r108 = Integer.valueOf(r98);
        goto L287
    L255:
        if ((r99 instanceof Number) == false) goto L262;
        if (((Number) r99).intValue() == 0) goto L259;
        boolean r109 = true;
    L260:
        r100 = Boolean.valueOf(r109);
        goto L266
    L259:
        r109 = false;
        goto L260
    L262:
        if ((r99 instanceof String) == false) goto L264;
        r100 = Boolean.valueOf(StringsKt.equals((String) r99, "true", true));
        goto L266
    L264:
        r100 = null;
        goto L266
    L250:
        r99 = null;
        goto L252
    L352:
        return;
    L351:
        return;
    L295:
        if (r28.equals("HeadJump") == false) goto L356;
        if (r29 == null) goto L298;
        Object r124 = r29.get("btm_fields");
    L300:
        if ((r124 instanceof Map) == true) goto L302;
        r124 = null;
    L302:
        Map r125 = (Map) r124;
        if (r125 == null) goto L305;
        com.bytedance.android.ec.core.btm.a r126 = com.bytedance.android.ec.core.btm.c.h(r125);
    L306:
        com.bytedance.android.ec.sdk.helper.p r127 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r128 = getContext();
        if (r29 == null) goto L309;
        Object r129 = r29.get("url");
    L311:
        if ((r129 instanceof String) == true) goto L313;
        r129 = null;
    L313:
        String r130 = (String) r129;
        if (r130 == null) goto L327;
        if (r126 == null) goto L317;
        String r131 = r126.b();
    L318:
        BcmParams r132 = new BcmParams();
        if (r126 == null) goto L326;
        Map r133 = r126.a();
        if (r133 == null) goto L326;
        Iterator r134 = r133.entrySet().iterator();
    L324:
        if (r134.hasNext() == false) goto L326;
        Map.Entry r135 = (Map.Entry) r134.next();
        r132.put((String) r135.getKey(), r135.getValue());
    L326:
        Unit r136 = Unit.INSTANCE;
        String r137 = com.bytedance.android.ec.core.btm.c.b(r130, r27, r131, r132);
    L328:
        r127.openSchema(r128, r137);
        return;
    L317:
        r131 = null;
        goto L318
    L327:
        r137 = null;
        goto L328
    L309:
        r129 = null;
        goto L311
    L305:
        r126 = null;
        goto L306
    L298:
        r124 = null;
        goto L300
    L356:
        return;
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q m(int r23, HeaderContentModel r24, ECUrlModel r25, int r26, int r27, int r28, Integer r29) {
        AnchorV4HeadV2VO r2 = this.e;
        Map<String, Object> r3 = null;
        if (r2 == null) goto L9;
        HeaderPreviewMeta r4 = r2.getPreviewMeta();
        if (r4 == null) goto L9;
        List<String> r5 = r4.getSkuTabs();
        if (r5 == null) goto L9;
        String r6 = (String) CollectionsKt.getOrNull(r5, r27);
    L10:
        String r7 = r24.getSkuSpecId();
        HeaderMediaModel r8 = r24.getMedia();
        if (r8 == null) goto L13;
        String r9 = r8.getFindSameUrl();
    L14:
        HeaderMediaModel r10 = r24.getMedia();
        if (r10 == null) goto L17;
        String r11 = r10.getFindSameUrlForScreenShot();
    L18:
        AnchorV4HeadV2VO r12 = this.e;
        if (r12 == null) goto L28;
        List<HeaderContentModel> r13 = r12.getCells();
        if (r13 == null) goto L28;
        HeaderContentModel r14 = (HeaderContentModel) CollectionsKt.getOrNull(r13, r26);
        if (r14 == null) goto L28;
        HeaderMediaModel r15 = r14.getMedia();
        if (r15 == null) goto L28;
        VideoModel r16 = r15.getPreviewVideo();
        if (r16 == null) goto L28;
    L46:
        if (r16 == null) goto L58;
        z73.a r17 = PlayAbilityUtil.a;
        AnchorV4HeadV2VO r18 = this.e;
        if (r18 == null) goto L56;
        List<HeaderContentModel> r19 = r18.getCells();
        if (r19 == null) goto L56;
        HeaderContentModel r110 = (HeaderContentModel) CollectionsKt.getOrNull(r19, r26);
        if (r110 == null) goto L56;
        HeaderMediaModel r111 = r110.getMedia();
        if (r111 == null) goto L56;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.n r112 = r111.getVideoInteractor();
    L57:
        d r113 = new d(PlayAbilityUtil.a(r16, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.h.a(r112), PlayerViewScene.SCENE_PRODUCT_VIDEO), this.g.d(r26), null, false, false);
    L65:
        HeaderMediaModel r20 = r24.getMedia();
        if (r20 != null) goto L68;
    L87:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.p r114 = null;
    L88:
        HeaderMediaModel r1 = r24.getMedia();
        if (r1 != null) goto L91;
    L93:
        boolean r115 = false;
    L95:
        return new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q(r25, r6, r7, r113, r9, r11, "", r26, r114, r28, r29, r115, 4096);
    L91:
        if (r1.getSupportThumbList() != true) goto L93;
        r115 = true;
        goto L95
    L68:
        if (r20.getPreviewType() != 1) goto L87;
        u r116 = rR();
        if (r116 == null) goto L74;
        CommonMeta r117 = r116.r0();
        if (r117 == null) goto L74;
        String r118 = r117.getProductId();
    L75:
        PlayerBlock r119 = this.g.d(r23);
        if (r119 == null) goto L78;
        Float r120 = Float.valueOf(r119.getPlayProgress());
    L79:
        u r121 = rR();
        if (r121 == null) goto L82;
        r3 = r121.getEventParams();
    L82:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r21 = this.g.f(r23);
        if (r21 == null) goto L85;
        String r22 = com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.d(r21);
    L86:
        r114 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.p(r118, r120, r3, r22);
        goto L88
    L85:
        r22 = null;
        goto L86
    L78:
        r120 = null;
    L74:
        r118 = null;
    L56:
        r112 = null;
        goto L57
    L58:
        AnchorV4HeadV2VO r30 = this.e;
        if (r30 != null) goto L61;
    L63:
        d r31 = null;
    L64:
        r113 = r31;
        goto L65
    L61:
        if (AnchorV4HeadV2VO.getVideoData$default(r30, r26, null, 2, null) == null) goto L63;
        r31 = new d(this.g.f(r26), this.g.d(r26), this.g.c(r26), true, com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a());
    L28:
        AnchorV4HeadV2VO r32 = this.e;
        if (r32 == null) goto L45;
        List<HeaderContentModel> r33 = r32.getCells();
        if (r33 == null) goto L45;
        HeaderContentModel r34 = (HeaderContentModel) CollectionsKt.getOrNull(r33, r26);
        if (r34 == null) goto L45;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r35 = r34.getMultiPreview();
        if (r35 == null) goto L45;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r36 = r35.a();
        if (r36 == null) goto L45;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r37 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) CollectionsKt.getOrNull(r36, 0);
        if (r37 == null) goto L45;
        HeaderContentModel r38 = r37.a();
        if (r38 == null) goto L45;
        HeaderMediaModel r39 = r38.getMedia();
        if (r39 == null) goto L45;
        r16 = r39.getPreviewVideo();
    L45:
        r16 = null;
        goto L46
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
    L9:
        r6 = null;
        goto L10
    }
}
