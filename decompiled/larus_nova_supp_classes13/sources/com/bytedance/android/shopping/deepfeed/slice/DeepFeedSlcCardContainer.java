package com.bytedance.android.shopping.deepfeed.slice;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementView;
import com.bytedance.android.shopping.deepfeed.action.h;
import com.bytedance.android.shopping.deepfeed.data.repo.l;
import com.bytedance.android.shopping.deepfeed.data.repo.n;
import com.bytedance.android.shopping.deepfeed.data.repo.o;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.slice.action.v;
import com.bytedance.android.shopping.deepfeed.slice.action.w;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcElementVH;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH;
import com.bytedance.android.shopping.deepfeed.utlis.k;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import he3.e1;
import he3.n0;
import he3.z0;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcCardContainer implements w {
    public View a;
    public View b;
    public final Map<String, v> c;
    public final boolean d;
    public final DeepFeedProductSlcVH e;
    public final DeepFeedProductViewModel f;
    public final h g;

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final DeepFeedProductEventTracker A() {
        return this.f.getEventTracker();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.u
    public final void a() {
        this.g.a();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final com.bytedance.android.shopping.deepfeed.action.d c() {
        return this.f.getActionHelper();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean i() {
        DeepFeedProductSlcVH r0 = this.e;
        r0.getClass();
        r0.getAdapterPosition();
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.b q() {
        return new vc3.b(this.e.m);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean v() {
        this.g.v();
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void C(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        InFeedProductV2 r0 = this.e.m;
        if (r0 == null) goto L12;
        n0 r1 = r0.slcCard();
        if (r1 == null) goto L13;
        c r3 = r1.d;
        if (r3 != null) goto L10;
        return;
    L10:
        xc3.a.b(r3, r2);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void b(boolean r1) {
        this.e.getClass();
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.c j(vc3.d r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        boolean r1 = false;
        if (r13.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        String r2 = this.e.A4(r13.a);
    L8:
        String r8 = r2;
        String r3 = "";
        if (r13.d == true) goto L28;
        DeepFeedProductSlcVH r4 = this.e;
        if (Intrinsics.areEqual(r8, r4.q) == false) goto L18;
    L21:
        r1 = true;
    L22:
        if (r1 == true) goto L28;
        if (r8 == null) goto L27;
        r3 = r8;
    L27:
        View r14 = r13.e;
        Intrinsics.checkNotNullParameter(r3, "btm");
        Intrinsics.checkNotNullParameter(r14, FreqActions.ACTION_VIEW);
        String r15 = le3.b.d(r3, r14, null);
    L33:
        String r7 = r15;
        DeepFeedProductSlcVH r16 = this.e;
        Pair r17 = TuplesKt.to(r16.E, r16.F);
        InFeedProductV2 r5 = this.e.m;
        if (r5 == null) goto L38;
        he3.v r6 = r5.getDynamicData();
        if (r6 == null) goto L38;
        int r9 = r6.c;
    L40:
        return new vc3.c(r5, r9, this.f.getFeedParam(), r7, r8, (JSONArray) r17.getFirst(), (Long) r17.getSecond(), this.e.D);
    L38:
        r9 = -1;
        goto L40
    L18:
        if (Intrinsics.areEqual(r8, r4.s) == true) goto L21;
        if (Intrinsics.areEqual(r8, r4.t) == false) goto L22;
    L28:
        InFeedProductV2 r10 = this.e.m;
        if (r8 == null) goto L32;
        r3 = r8;
    L32:
        r15 = com.bytedance.android.shopping.deepfeed.utlis.a.c(r10, r3, r13.e);
        goto L33
    L10:
        if (r13.c == false) goto L12;
        r2 = r13.b + "_i" + (this.e.getAdapterPosition() + 1);
        goto L8
    L12:
        r2 = r13.b;
        goto L8
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final v r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return (v) ((LinkedHashMap) this.c).get(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final String s(String r6) {
        Intrinsics.checkNotNullParameter(r6, "link");
        boolean r1 = false;
        if (StringsKt.startsWith$default(r6, "$", false, 2, null) == false) goto L5;
        r6 = StringsKt.substringAfter$default(r6, "$", null, 2, null);
    L5:
        InFeedProductV2 r0 = this.e.m;
        if (r0 == null) goto L13;
        n0 r2 = r0.slcCard();
        if (r2 == null) goto L13;
        Map<String, String> r3 = r2.d();
        if (r3 == null) goto L13;
        String r4 = r3.get(r6);
        if (r4 == null) goto L13;
    L22:
        if (r4 != null) goto L24;
    L25:
        r1 = true;
    L26:
        if (r1 == false) goto L37;
        if (this.d == false) goto L37;
        InFeedProductV2 r7 = this.e.m;
        if (r7 == null) goto L38;
        n0 r8 = r7.slcCard();
        if (r8 == null) goto L39;
        Map<String, String> r9 = r8.d();
        if (r9 != null) goto L41;
        return null;
    L41:
        return r9.get("product_detail");
    L39:
        return null;
    L38:
        return null;
    L37:
        return r4;
    L24:
        if (r4.length() != 0) goto L26;
    L13:
        l r5 = this.f.getResp();
        if (r5 == null) goto L21;
        o r10 = r5.b();
        if (r10 == null) goto L18;
        Map<String, String> r11 = r10.b();
    L19:
        if (r11 == null) goto L21;
        r4 = r11.get(r6);
        goto L22
    L18:
        r11 = null;
    L21:
        r4 = null;
        goto L22
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void t(Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        RecyclerView r1 = this.e.C4();
        if (r1 == null) goto L57;
        Intrinsics.checkNotNullParameter(r10, "callback");
        RecyclerView.ViewHolder r3 = r1.findViewHolderForAdapterPosition(r1.j);
        Object r5 = null;
        if ((r3 instanceof DeepFeedSlcElementVH) == true) goto L7;
        r3 = null;
    L7:
        DeepFeedSlcElementVH r4 = (DeepFeedSlcElementVH) r3;
        if (r4 != null) goto L10;
        r10.invoke(null);
        return;
    L10:
        String r2 = String.valueOf(r1.getContext().getCacheDir().getAbsolutePath());
        SlcAsyncImageElementView r6 = DeepFeedSlcList.z(r4.a);
        if ((r6 instanceof ad3.b) == false) goto L48;
        SlcAsyncImageElementView r7 = (ad3.b) r6;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "filePathPrefix");
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (r7.getWidth() > 0) goto L15;
    L46:
        r10.invoke(null);
        return;
    L15:
        if (r7.getHeight() <= 0) goto L46;
        int r0 = k.a;
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if ((r7 instanceof TextureView) == false) goto L22;
        Bitmap r8 = ((TextureView) r7).getBitmap();
        if (r8 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r2, "filePathPrefix");
        if (r8 != null) goto L56;
    L45:
        r10.invoke(r5);
        return;
    L56:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L38
        PolarisFileWrapper r11 = new PolarisFileWrapper(r2.concat("/deep_feed_photo_search.jpeg"));     // Catch: Throwable -> L38
        File r12 = r11.getParentFile();     // Catch: Throwable -> L38
        if (r12 == null) goto L29;
        r12.mkdirs();     // Catch: Throwable -> L38
    L29:
        PolarisFileOutputStreamWrapper r13 = new PolarisFileOutputStreamWrapper(r11);     // Catch: Throwable -> L38
        r8.compress(Bitmap.CompressFormat.JPEG, 100, r13);     // Catch: Throwable -> L33
        r13.flush();     // Catch: Throwable -> L33
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L38
        Object r15 = Result.constructor-impl(r11.getAbsolutePath());     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r15) == true) goto L44;
        r5 = r15;
    L44:
        r5 = (String) r5;
        goto L45
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        r7.measure(View.MeasureSpec.makeMeasureSpec(r7.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r7.getHeight(), 1073741824));
        r7.layout(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom());
        r8 = Bitmap.createBitmap(r7.getMeasuredWidth(), r7.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        r7.draw(new Canvas(r8));
        goto L23
    L48:
        if ((r6 instanceof DeepFeedSliceVideoView) == false) goto L50;
        ((DeepFeedSliceVideoView) r6).c(r2, r10);
        return;
    L50:
        r10.invoke(null);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void w(int r3) {
        h r0 = this.g;
        if (r0 == null) goto L6;
        r0.u(new com.bytedance.android.shopping.deepfeed.viewmodel.a(r3));
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void x(final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "afterAction");
        this.f.actionAfterCouponRequest(this.e.m, new DeepFeedSlcCardContainer$requestMixCoupon$1(r4));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void y(boolean r2) {
        this.e.n4(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxUrl");
        Intrinsics.checkNotNullParameter(r3, "popupType");
        h r4 = this.g;
        new DeepFeedSlcCardContainer$openPopup$1(this);
        r4.h();
        this.g.g(r3);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void h(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter(r4, "viewName");
        int r0 = r4.hashCode();
        if (r0 == (-1476195426)) goto L22;
        if (r0 == (-1030424504)) goto L13;
        if (r0 == 213085284) goto L10;
        return;
    L10:
        if (r4.equals("cart_view") == false) goto L25;
        this.a = r3;
        return;
    L25:
        return;
    L13:
        if (r4.equals("recommend_view") == false) goto L27;
        InFeedProductV2 r5 = this.e.m;
        if (r5 == null) goto L28;
        he3.v r6 = r5.getDynamicData();
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.e != true) goto L30;
        Pair r7 = k.b(r3);
        h r1 = this.g;
        ((Number) r7.getFirst()).intValue();
        r3.getWidth();
        ((Number) r7.getSecond()).intValue();
        com.bytedance.android.shopping.extensions.b.b(4);
        r1.o();
        return;
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L22:
        if (r4.equals("display_image") == false) goto L32;
        this.b = r3;
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void m(Boolean r9, View r10) {
        Intrinsics.checkNotNullParameter(r10, "targetView");
        DeepFeedProductViewModel r1 = this.f;
        DeepFeedProductSlcVH r0 = this.e;
        r1.clickCollect(r0.m, r0.A4("collect"), r10, this.e.n, r9, new DeepFeedSlcCardContainer$clickCollect$1(this));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void u(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mainArea");
        DeepFeedProductSlcVH r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "mainArea");
        r0.getClass();
        r0.getClass();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void z(int r3, String r4) {
        this.g.p(new com.bytedance.android.shopping.deepfeed.viewmodel.b(r3, r4));
    }

    public DeepFeedSlcCardContainer(DeepFeedProductSlcVH r4, DeepFeedProductViewModel r5, h r6) {
        Intrinsics.checkNotNullParameter(r4, "vh");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "dfContext");
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.c = new LinkedHashMap();
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Object r8 = Boolean.FALSE;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L166
        Object r10 = null;
        Object r0 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_default_use_detail_link");     // Catch: Throwable -> L57
        if (r0 != null) goto L9;
    L54:
        Object r1 = null;
    L55:
        Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L57
    L59:
        Throwable r3 = Result.exceptionOrNull-impl(r2);     // Catch: Throwable -> L166
        if (r3 == null) goto L63;
        EnsureManager.ensureNotReachHere(r3);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r2) == false) goto L66;
        r2 = null;
    L66:
        if ((r2 instanceof Boolean) == true) goto L68;
        r2 = null;
    L68:
        Object r11 = (Boolean) r2;     // Catch: Throwable -> L166
        if (r11 != null) goto L75;
        Object r12 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_default_use_detail_link");     // Catch: Throwable -> L166
        if ((r12 instanceof Boolean) == true) goto L74;
        r12 = null;
    L74:
        r11 = (Boolean) r12;     // Catch: Throwable -> L166
    L75:
        if (r11 != null) goto L175;
        int r13 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r14 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_default_use_detail_link");     // Catch: Throwable -> L130
        if (r14 != null) goto L82;
    L127:
        Object r15 = null;
    L128:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L130
    L132:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L156
        if (r17 == null) goto L136;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r16) == false) goto L139;
        r16 = null;
    L139:
        if ((r16 instanceof Boolean) == true) goto L141;
        r16 = null;
    L141:
        r11 = (Boolean) r16;     // Catch: Throwable -> L156
        if (r11 != null) goto L164;
        IHybridHostService r18 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r18 == null) goto L147;
        Object r19 = r18.getHostABValue("mall_deep_feed_default_use_detail_link", r8);     // Catch: Throwable -> L156
    L148:
        if (r19 != null) goto L150;
    L155:
        r11 = r8;
        goto L164
    L150:
        if ((r19 instanceof Boolean) == false) goto L153;
        r10 = r19;
    L153:
        Object r20 = (Boolean) r10;     // Catch: Throwable -> L156
        if (r20 == null) goto L155;
    L163:
        r11 = r20;
        goto L164
    L147:
        r19 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_default_use_detail_link", r11);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r14 instanceof Boolean) == true) goto L84;
        Object r21 = null;
    L85:
        r15 = (Boolean) r21;     // Catch: Throwable -> L130
        if (r15 != null) goto L128;
        if ((r14 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L95;
        r22 = null;
    L95:
        r15 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L101;
        r23 = null;
    L101:
        r15 = (Boolean) r23;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r24 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L130
        if ((r24 instanceof Boolean) == true) goto L107;
        r24 = null;
    L107:
        r15 = (Boolean) r24;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r25 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L130
        if ((r25 instanceof Boolean) == true) goto L113;
        r25 = null;
    L113:
        r15 = (Boolean) r25;     // Catch: Throwable -> L130
    L115:
        if ((r14 instanceof JSONObject) == false) goto L117;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r26 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r26 instanceof Boolean) == true) goto L121;
        r26 = null;
    L121:
        Object r27 = Result.constructor-impl((Boolean) r26);     // Catch: Throwable -> L123
    L125:
        r15 = r27;
        if (Result.isFailure-impl(r15) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L130
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r14 instanceof JSONArray) == false) goto L127;
    L84:
        r21 = r14;
    L130:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L156
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L156:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L166
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r31 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L166
        if (r31 == null) goto L161;
        EnsureManager.ensureNotReachHere(r31);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r20) == false) goto L163;
        r20 = r8;
    L175:
        this.d = ((Boolean) r11).booleanValue();
        return;
    L9:
        if ((r0 instanceof Boolean) == true) goto L11;
        Object r32 = null;
    L12:
        r1 = (Boolean) r32;     // Catch: Throwable -> L57
        if (r1 != null) goto L55;
        if ((r0 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r33 = Float.valueOf(((Number) r0).floatValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L22;
        r33 = null;
    L22:
        r1 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r34 = Double.valueOf(((Number) r0).doubleValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L28;
        r34 = null;
    L28:
        r1 = (Boolean) r34;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r35 = Integer.valueOf(((Number) r0).intValue());     // Catch: Throwable -> L57
        if ((r35 instanceof Boolean) == true) goto L34;
        r35 = null;
    L34:
        r1 = (Boolean) r35;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r36 = Long.valueOf(((Number) r0).longValue());     // Catch: Throwable -> L57
        if ((r36 instanceof Boolean) == true) goto L40;
        r36 = null;
    L40:
        r1 = (Boolean) r36;     // Catch: Throwable -> L57
    L42:
        if ((r0 instanceof JSONObject) == false) goto L44;
    L177:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r37 = SDKSettingsCacheManager.a().fromJson(r0.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r37 instanceof Boolean) == true) goto L48;
        r37 = null;
    L48:
        Object r38 = Result.constructor-impl((Boolean) r37);     // Catch: Throwable -> L50
    L52:
        r1 = r38;
        if (Result.isFailure-impl(r1) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L57
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r0 instanceof JSONArray) == false) goto L54;
    L11:
        r32 = r0;
    L57:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L166
        r2 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L171;
        EnsureManager.ensureNotReachHere(r43);
    L171:
        if (Result.isFailure-impl(r42) == true) goto L174;
        r8 = r42;
    L174:
        r11 = r8;
        goto L175
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void d(String r13, List<String> r14, View r15) {
        Intrinsics.checkNotNullParameter(r13, "query");
        Intrinsics.checkNotNullParameter(r14, "featureInfoList");
        Intrinsics.checkNotNullParameter(r15, "targetView");
        if (r13.length() != 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L9;
        return;
    L9:
        if (this.e.getAdapterPosition() != (this.f.curNoFullScreenCount() - 1)) goto L12;
        this.f.addNoFullScreenCount();
    L12:
        if (this.e.getAdapterPosition() < this.f.curNoFullScreenCount()) goto L14;
        boolean r7 = true;
    L15:
        String r10 = UUID.randomUUID().toString();
        InFeedProductV2 r17 = this.e.m;
        if (r17 == null) goto L20;
        he3.v r18 = r17.getDynamicData();
        if (r18 == null) goto L20;
        r18.j = true;
    L20:
        InFeedProductV2 r19 = this.e.m;
        if (r19 == null) goto L25;
        he3.v r110 = r19.getDynamicData();
        if (r110 == null) goto L25;
        r110.l = r10;
    L25:
        this.e.Z1();
        l r111 = this.f.getResp();
        if (r111 == null) goto L42;
        Integer r6 = Integer.valueOf(this.e.getAdapterPosition() + 1);
        InFeedProductV2 r1 = this.e.m;
        if (r1 == null) goto L32;
        z0 r2 = r1.getRespExtra();
        if (r2 == null) goto L32;
        Integer r3 = r2.b();
    L33:
        Integer r9 = r3;
        InFeedProductV2 r4 = this.e.m;
        if (r4 == null) goto L39;
        e1 r5 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r4);
        if (r5 == null) goto L39;
        String r8 = r5.a();
        if (r8 == null) goto L39;
    L40:
        l.d(r111, new n(r13, r14, r6, r7, null, r9, r10, r8));
        return;
    L39:
        r8 = "";
    L32:
        r3 = null;
        goto L33
    L42:
        return;
    L14:
        r7 = false;
        goto L15
    L5:
        r16 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void p(int r2, int r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        this.f.updateModelRange(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.a n(String r11, String r12, String r13, boolean r14, View r15) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r12, "area");
        Intrinsics.checkNotNullParameter(r13, "btm");
        Intrinsics.checkNotNullParameter(r15, FreqActions.ACTION_VIEW);
        InFeedProductV2 r0 = this.e.m;
        String r1 = null;
        if (r0 == null) goto L5;
        Map<String, Object> r3 = com.bytedance.android.shopping.deepfeed.utlis.a.b(r0, r11);
    L7:
        if (r13.length() != 0) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L12;
        r13 = this.e.A4(r12);
    L14:
        String r4 = r13;
        int r17 = le3.a.a;
        InFeedProductV2 r18 = this.e.m;
        if (r18 == null) goto L19;
        e1 r19 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r18);
        if (r19 == null) goto L19;
        r1 = r19.b();
    L19:
        JSONObject r9 = le3.a.a(r15, r1);
        InFeedProductV2 r110 = this.e.m;
        if (r110 == null) goto L24;
        he3.v r111 = r110.getDynamicData();
        if (r111 == null) goto L24;
        int r5 = r111.c;
    L25:
        DeepFeedProductSlcVH r112 = this.e;
        return new vc3.a(r3, r4, r5, r112.m, r112.n, this.f.getFeedParam(), r9);
    L24:
        r5 = -1;
        goto L25
    L12:
        if (r14 == false) goto L14;
        r13 = r13 + "_i" + (this.e.getAdapterPosition() + 1);
        goto L14
    L9:
        r16 = false;
        goto L10
    L5:
        r3 = null;
        goto L7
    }
}
