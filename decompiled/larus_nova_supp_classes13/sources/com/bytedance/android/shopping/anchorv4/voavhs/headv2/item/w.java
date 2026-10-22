package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.Config;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaPreviewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.HeadLynxAbilityManager;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.ItemMediaLayer;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends RoundedFrameLayout implements o<HeaderContentModel>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {
    public ItemMediaLayer b;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i c;
    public HeadMultiPreview d;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c e;
    public int f;
    public boolean g;
    public boolean h;
    public HeaderContentModel i;
    public u j;
    public v k;
    public final BgDecorLayer l;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s m;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b n;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(boolean r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r1, Boolean r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r1) {
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s getHeadAbility() {
        return this.m;
    }

    public final View B(Integer r5) {
        if (r5 == null) goto L36;
        HeaderContentModel r1 = this.i;
        if (r1 == null) goto L13;
        HeaderMediaModel r2 = r1.getMedia();
        if (r2 == null) goto L13;
        List<HeaderMediaPreviewModel> r3 = r2.getPreviewList();
        if (r3 == null) goto L13;
        HeaderMediaPreviewModel r4 = (HeaderMediaPreviewModel) CollectionsKt.getOrNull(r3, r5.intValue());
        if (r4 == null) goto L13;
        String r6 = r4.getSliceKey();
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r7 = this.c;
        if (r7 == null) goto L36;
        if (r6 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == true) goto L33;
        SlcTemplateViewHelper r9 = r7.b;
        if (r9 == null) goto L28;
        View r10 = r9.d(r6);
        if (r10 == null) goto L28;
    L34:
        if (r10 == null) goto L36;
        return r10;
    L28:
        View r11 = r7.a;
        if (r11 == null) goto L33;
        if (r7.c.yd().b == null) goto L33;
        r10 = SlcRenderContext.f(r11, r6);
    L33:
        r10 = null;
        goto L34
    L18:
        if (r6.length() == 0) goto L21;
        r8 = false;
    L13:
        r6 = null;
    L36:
        if (r5 != null) goto L38;
    L45:
        ItemMediaLayer r12 = this.b;
        if (r12 != null) goto L48;
        return null;
    L48:
        return r12.r();
    L38:
        if (r5.intValue() < 0) goto L45;
        HeadMultiPreview r13 = this.d;
        if (r13 == null) goto L45;
        ItemMediaLayer r14 = (ItemMediaLayer) CollectionsKt.getOrNull(r13.e, r5.intValue());
        if (r14 != null) goto L44;
        return null;
    L44:
        return r14.r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r3) {
        if (this.f != this.m.getCurrentPosition()) goto L16;
        if (r3 == false) goto L10;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r4 = this.c;
        if (r4 == null) goto L17;
        View r5 = r4.a;
        if (r5 == null) goto L18;
        ViewExtensionsKt.c(r5, false, 3);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r6 = this.c;
        if (r6 == null) goto L20;
        View r7 = r6.a;
        if (r7 == null) goto L21;
        ViewExtensionsKt.i(r7);
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r5) {
        boolean r0 = true;
        if (r5 == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r5 == true) goto L12;
    L14:
        r0 = r1;
    L15:
        if (r0 == false) goto L18;
        int r6 = k83.b.a;
        k83.b.c(this.m.getRecyclerView());
        return;
    L18:
        return;
    L12:
        if (this.m.h00() == true) goto L14;
        this.m.m90();
        goto L15
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.b(this.m, null, 3) == false) goto L7;
    L8:
        this.m.tB(Boolean.TRUE);
        this.n.c = null;
        r1 = true;
        goto L10
    L7:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.a(this.m, null, 3) == false) goto L9;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r5) {
        int r0 = this.m.XU();
        HeaderContentModel r1 = this.i;
        if (r1 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.i r2 = r1.getStyle();
        if (r2 == null) goto L9;
        Float r3 = r2.a();
        if (r3 == null) goto L9;
        float r4 = r3.floatValue();
    L11:
        if (r0 == 1) goto L13;
        return;
    L13:
        if (this.m.wq() == false) goto L15;
        return;
    L15:
        if (r4 >= 1.0f) goto L25;
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r6 = null;
    L19:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        if (r7 == null) goto L26;
        r7.topMargin = (int) (com.bytedance.android.shopping.extensions.b.b(12) + ((com.bytedance.android.shopping.extensions.b.b(44) - com.bytedance.android.shopping.extensions.b.b(12)) * r5));
        setLayoutParams(r7);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        r4 = 1.0f;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.FrameLayout*/.onDraw(r2);
        BgDecorLayer r0 = this.l;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(int r7) {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.b(this.m, null, 3) == false) goto L6;
        setTranslationY(r7 * (1 - 0.4f));
        return;
    L6:
        if (this.g == false) goto L43;
        ItemMediaLayer r0 = this.b;
        if (r0 == null) goto L27;
        float r3 = r7 * (1 - 0.4f);
        r0.c.setTranslationY(r3);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        k r4 = r0.f;
        if (r4 == null) goto L21;
        r4.b = r3;
        BasePdpVideoView r5 = k.g(r4.a);
        if (r5 == null) goto L21;
        r5.setTranslationY(r4.b);
    L21:
        BlurImageView r6 = r0.g;
        if (r6 == null) goto L24;
        r6.setTranslationY(r3);
    L24:
        ECDraweeView r1 = r0.h;
        if (r1 == null) goto L27;
        r1.setTranslationY(r3);
        goto L27
    L16:
        j r8 = r0.e;
        if (r8 == null) goto L21;
        r8.f = r3;
        PlayerBlock r9 = r8.e;
        if (r9 == null) goto L21;
        r9.setTranslationY(r3);
    L27:
        BgDecorLayer r2 = this.l;
        if (r2 != null) goto L30;
    L34:
        HeadMultiPreview r10 = this.d;
        if (r10 == null) goto L37;
        float r11 = r7 * (1 - 0.4f);
        r10.a.setTranslationY(r11);
        r10.b.setTranslationY(r11);
    L37:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r12 = this.e;
        if (r12 == null) goto L43;
        b r13 = r12.a;
        if (r13 == null) goto L43;
        r13.setTranslationY(r7 * (1 - 0.4f));
        goto L43
    L30:
        if (r2.e() == false) goto L32;
        float r14 = 0.0f;
    L33:
        r2.e = r14;
        r2.h.invalidate();
        goto L34
    L32:
        r14 = r7 * (1 - 0.4f);
    L43:
        if (this.h == false) goto L51;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r15 = this.c;
        if (r15 == null) goto L52;
        View r16 = r15.a;
        if (r16 == null) goto L53;
        r16.setTranslationY(r7 * (1 - 0.4f));
        return;
    L53:
        return;
    L52:
        return;
    }

    public final void C(JSONObject r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        this.m.Pg().e(r9.optString("pdp_container_id", "ai_combination"), r10);
        RecyclerView r11 = this.m.getRecyclerView();
        if (r11 == null) goto L7;
        RecyclerView.Adapter r12 = r11.getAdapter();
        if (r12 == null) goto L7;
        r12.notifyItemChanged(this.f);
    L7:
        if (r10 == false) goto L18;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r13 = this.e;
        if (r13 == null) goto L18;
        String r0 = this.m.rR().getSessionId();
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        b r14 = r13.a;
        if (r14 == null) goto L18;
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        ti.l r15 = r14.a;
        if (r15 == null) goto L18;
        JSONObject r1 = new JSONObject();
        r1.put("update_combination_tryon_setting", true);
        Unit r2 = Unit.INSTANCE;
        r15.sendJsEvent("ec.tryon.combain.setting.open", r1);
    L18:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r16 = this.n;
        r16.c = Integer.valueOf((int) com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.k(r16, this.f, null, null, null, 14));
        RecyclerView r17 = this.m.getRecyclerView();
        if (r17 == null) goto L21;
        r17.requestLayout();
    L21:
        this.m.eh().h(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super/*android.widget.FrameLayout*/.onMeasure(r1, r2);
        if (this.m.aN(this.f) == false) goto L6;
        setMeasuredDimension(0, getMeasuredHeight());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(Context r7, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r8, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "headAbility");
        Intrinsics.checkNotNullParameter(r9, "sizeHelper");
        super(r7);
        this.m = r8;
        this.n = r9;
        this.f = -1;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == false) goto L5;
        BgDecorLayer r10 = new BgDecorLayer(r8, this, false, false, 12);
    L6:
        this.l = r10;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(-1);
        addOnAttachStateChangeListener(new p(this));
        if (r10 == null) goto L10;
        setWillNotDraw(false);
        return;
    L10:
        return;
    L5:
        r10 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final void l(HeaderContentModel r12, int r13, Integer r14) {
        HeaderContentModel r15 = r12;
        Intrinsics.checkNotNullParameter(r15, "data");
        setContentDescription("图片" + (r13 + 1));
        this.f = r13;
        removeAllViews();
        this.i = r15;
        if (this.m.aN(r13) == true) goto L170;
        BgDecorLayer r0 = this.l;
        b r1 = null;
        if (r0 == null) goto L18;
        Intrinsics.checkNotNullParameter(r15, "data");
        Integer r16 = r0.b;
        if (r16 != null) goto L11;
    L12:
        r0.c = null;
        r0.d = null;
        CloseableReference<Bitmap> r17 = r0.f;
        if (r17 == null) goto L15;
        r17.close();
    L15:
        r0.f = null;
        r0.h.invalidate();
    L16:
        r0.b = Integer.valueOf(r13);
        r0.a = r15;
        goto L18
    L11:
        if (r16.intValue() == r13) goto L16;
    L18:
        if (r15.getMultiPreview() == null) goto L75;
        HeadMultiPreview r18 = this.d;
        if (r18 != null) goto L22;
        r18 = new HeadMultiPreview(getContext(), this.m, this.n);
    L22:
        this.d = r18;
        HeadMultiPreview r19 = this.d;
        if (r19 == null) goto L73;
        Intrinsics.checkNotNullParameter(r15, "contentVo");
        r19.f = r13;
        int r3 = 0;
        if (r19.d != null) goto L27;
        r19.a.removeAllViews();
        r19.b.removeAllViews();
        List<HeaderContentModel> r2 = r19.c;
        if (r2 != null) goto L50;
        r19.c = new ArrayList();
    L51:
        r19.d = r15;
        ((ArrayList) r19.e).clear();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r4 = r15.getMultiPreview();
        if (r4 == null) goto L72;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r5 = r4.a();
        if (r5 == null) goto L72;
        Iterator<T> r6 = r5.iterator();
        int r7 = 0;
    L57:
        if (r6.hasNext() == false) goto L72;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r10 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) r8;
        HeaderContentModel r11 = r19.l(r10);
        ItemMediaLayer r20 = new ItemMediaLayer(r19.h, false);
        if (r11 == null) goto L64;
        r19.b(r20, r11, r10, r7);
    L64:
        ViewGroup r21 = r20.b;
        if (r7 != 0) goto L67;
        r19.a.addView(r21, -1, -1);
    L71:
        ((ArrayList) r19.e).add(r20);
        r7 = r9;
        goto L57
    L67:
        LinearLayout r22 = r19.b;
        ViewGroup.MarginLayoutParams r110 = new ViewGroup.MarginLayoutParams(-1, -1);
        if (r7 <= 1) goto L70;
        int r23 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r110.topMargin = com.bytedance.android.ec.hybrid.list.util.c.d(6);
    L70:
        Unit r24 = Unit.INSTANCE;
        r22.addView(r21, r110);
    L72:
        r19.r();
        goto L73
    L50:
        ((ArrayList) r2).clear();
        goto L51
    L27:
        if (PdpPerfOpt.b().h() == false) goto L44;
        r19.d = r15;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r25 = r15.getMultiPreview();
        if (r25 == null) goto L44;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r26 = r25.a();
        if (r26 == null) goto L44;
        Iterator<T> r27 = r26.iterator();
    L34:
        if (r27.hasNext() == false) goto L44;
        Object r28 = r27.next();
        int r29 = r3 + 1;
        if (r3 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r30 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) r28;
        HeaderContentModel r31 = r19.l(r30);
        ItemMediaLayer r32 = (ItemMediaLayer) CollectionsKt.getOrNull(r19.e, r3);
        if (r32 == null) goto L42;
        if (r31 == null) goto L42;
        r19.b(r32, r31, r30, r3);
    L42:
        r3 = r29;
    L44:
        if (r19.h.wq() == false) goto L46;
        LinearLayout r33 = r19.a;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        r34.width = -1;
        r34.height = -1;
        Unit r35 = Unit.INSTANCE;
        r33.setLayoutParams(r34);
        r19.i.c = null;
        r19.o(null);
    L46:
        r19.r();
    L73:
        addView(this.d);
    L75:
        if (r15.getMedia() == null) goto L85;
        ItemMediaLayer r111 = this.b;
        if (r111 != null) goto L79;
        r111 = new ItemMediaLayer(this.m, true);
    L79:
        this.b = r111;
        r111.i = new s(this, r13);
        o.a.a(r111, r15.getMedia(), r13);
        ItemMediaLayer r112 = this.b;
        if (r112 == null) goto L85;
        ViewGroup r113 = r112.b;
        if (r113 == null) goto L85;
        wg.a.a(r113);
        addView(r113);
    L85:
        if (r15.getSlice() == null) goto L95;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r114 = this.c;
        if (r114 != null) goto L89;
        r114 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i(this.m);
    L89:
        this.c = r114;
        o.a.a(r114, r15.getSlice(), r13);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r115 = this.c;
        if (r115 == null) goto L95;
        View r116 = r115.a;
        if (r116 == null) goto L95;
        wg.a.a(r116);
        addView(r116);
    L95:
        if (r15.getLynx() != null) goto L97;
        u r117 = this.j;
        if (r117 == null) goto L142;
        this.m.Pg().f("ec.tryon.combain.setting.close", r117);
    L142:
        v r118 = this.k;
        if (r118 == null) goto L145;
        this.m.Pg().f("ec.tryon.combain.setting.open", r118);
    L145:
        setOnClickListener(new t(this, r13));
        Config r119 = r15.getConfig();
        if (r119 == null) goto L149;
        this.g = r119.getEnableMediaAsyncScroll();
        this.h = r119.getEnableSliceAsyncScroll();
    L149:
        if (PdpAB.c != 1) goto L166;
        y(this.m.rR().R());
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r120 = this.c;
        if (r120 != null) goto L153;
        return;
    L153:
        if (r120.a != null) goto L155;
        return;
    L155:
        if (this.b != null) goto L157;
        setBackgroundColor(ColorProtector.parseColor("#FFF6F6F9"));
        return;
    L157:
        setBackgroundColor(ColorProtector.parseColor("#FFFFFFFF"));
        return;
    L166:
        return;
    L97:
        if (Intrinsics.areEqual(r15.getLynx().a(), "ai_combination") == false) goto L111;
        if (this.j != null) goto L102;
        this.j = new u(this);
    L102:
        if (this.k != null) goto L105;
        this.k = new v(this);
    L105:
        if (this.j == null) goto L108;
        this.m.Pg().c("ec.tryon.combain.setting.close", this.j);
    L108:
        if (this.k == null) goto L111;
        this.m.Pg().c("ec.tryon.combain.setting.open", this.k);
    L111:
        if (this.m.Pg().b(r15.getLynx()) == false) goto L145;
        if (r15.getLynx().c() == false) goto L128;
        HeadLynxAbilityManager r121 = this.m.Pg();
        String r36 = r15.getLynx().a();
        String r37 = "";
        if (r36 != null) goto L117;
        r36 = "";
    L117:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r122 = r121.a(r36);
        if (r122 == null) goto L120;
        this.e = r122;
    L132:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r123 = this.e;
        if (r123 == null) goto L135;
        o.a.a(r123, r15.getLynx(), r13);
    L135:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r124 = this.e;
        if (r124 == null) goto L138;
        r1 = r124.a;
    L138:
        addView(r1);
        goto L145
    L120:
        this.e = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c(getContext(), this.m);
        HeadLynxAbilityManager r125 = this.m.Pg();
        String r38 = r15.getLynx().a();
        if (r38 != null) goto L123;
        r38 = "";
    L123:
        r125.d(r38, this.e);
        HeadLynxAbilityManager r126 = this.m.Pg();
        String r39 = r15.getLynx().a();
        if (r39 == null) goto L127;
        r37 = r39;
    L127:
        r126.e(r37, r15.getLynx().f());
        goto L132
    L128:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r127 = this.e;
        if (r127 != null) goto L131;
        r127 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c(getContext(), this.m);
    L131:
        this.e = r127;
        goto L132
    }
}
