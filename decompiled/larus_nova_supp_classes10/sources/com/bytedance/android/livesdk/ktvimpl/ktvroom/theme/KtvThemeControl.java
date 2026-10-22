package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.config.y0;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.RecycleWidgetHelper;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;
import vm2.k;
import zg1.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvThemeControl {
    public final boolean a;
    public CompositeDisposable b;
    public final e c;
    public final View d;
    public final HSImageView e;
    public final ViewGroup f;
    public final DataCenter g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvThemeControl a;

        public a(KtvThemeControl r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Integer r2 = (Integer) r1;
            KtvThemeControl.a(this.a);
            this.a.d();
        }
    }

    public static final class b extends ScalingUtils.AbstractScaleType {
        public static final b e = null;

        static {
            e = new b();
        }

        public b() {
        }

        public final void getTransformImpl(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r1, "outTransform");
            Intrinsics.checkNotNullParameter(r2, "parentRect");
            float r9 = r2.left;
            float r10 = r2.top;
            r1.setScale(r7, r8);
            r1.postTranslate(r9 + 0.5f, r10 + 0.5f);
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ KtvThemeControl a;

        public c(KtvThemeControl r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            this.a.c();
        }
    }

    public static final class d extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ KtvThemeControl a;

        public d(KtvThemeControl r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            this.a.c();
        }
    }

    public static final class e implements Runnable {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("KtvThemeControl", "KTV房间背景已加载好并展示");     // Catch: Throwable -> L4
            xs2.b.a().post(new v0());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        this.f.setBackgroundColor(ColorProtector.parseColor("#100b5c"));     // Catch: Exception -> L5
        this.e.setBackgroundColor(Color.parseColor("#100b5c"));     // Catch: Exception -> L5
        this.d.setBackgroundColor(Color.parseColor("#08002a"));     // Catch: Exception -> L5
    L7:
        this.e.getHierarchy().setActualImageScaleType(b.e);
        d9 r0 = k.a();
        if (TextUtils.isEmpty(r0.ktvStageStaticBg) == false) goto L10;
        r0.ktvStageStaticBg = d9.a;
    L10:
        String r1 = r0.ktvStageStaticBg;
        d9 r2 = k.a();
        boolean r3 = this.a;
        r2.getClass();
        boolean r4 = false;
        if (r3 == false) goto L16;
        if (z0.b(true) <= r2.ktvBgDegradeAnchorLimit) goto L17;
    L18:
        if (r4 == false) goto L20;
        this.e.setController(Fresco.newDraweeControllerBuilder().setUri(r1).setOldController(this.e.getController()).setControllerListener(new c(this)).build());
        return;
    L20:
        d9 r5 = k.a();
        if (TextUtils.isEmpty(r5.ktvStageAnimatedBg) == false) goto L23;
        r5.ktvStageAnimatedBg = d9.b;
    L23:
        this.e.setController(Fresco.newDraweeControllerBuilder().setLowResImageRequest(ImageRequest.fromUri(r1)).setImageRequest(ImageRequest.fromUri(r5.ktvStageAnimatedBg)).setOldController(this.e.getController()).setAutoPlayAnimations(true).setControllerListener(new d(this)).build());
        return;
    L17:
        r4 = true;
        goto L18
    L16:
        if (z0.b(false) > r2.ktvBgDegradeAudienceLimit) goto L18;
    L5:
        e = move-exception;
        ALogger.e("KtvThemeControl", "loadDefaultKtvBackground exception: " + e.getMessage());
        goto L7
    }

    public final void c() {
        long r0 = ((Number) h.T3.getValue(null, h.a[252(0xfc, float:3.53E-43)])).longValue();
        this.e.postDelayed(this.c, r0);
        d();
    }

    public final void d() {
        ALogger.d("KtvThemeControl", "[smoothEnterRoom] on complete load background success");
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r2 = MultiSceneEnterRoomStatisticsUtils.a.a(this.g, 0L);
        if (r2 == null) goto L6;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r2, "background_Load", 0, 2, null);
        return;
    }

    public static final void a(KtvThemeControl r2) {
        r2.getClass();
        if (vm2.d.q0().isOpenSmoothViewMock() == true) goto L5;
        return;
    L5:
        if (r2.a == true) goto L11;
        ALogger.d("KtvThemeControl", "handleKtvStageVisibleAlpha");
        r2.e.setAlpha(1.0f);
        r2.f.setAlpha(1.0f);
        DataCenter r3 = r2.g;
        if (r3 == null) goto L12;
        r3.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
        return;
    L12:
        return;
    }

    public KtvThemeControl(View r2, HSImageView r3, ViewGroup r4, HSImageView r5, Context r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r2, "ktvTopBar");
        Intrinsics.checkNotNullParameter(r3, "ktvBackground");
        Intrinsics.checkNotNullParameter(r4, "ktvLayout");
        Intrinsics.checkNotNullParameter(r5, "fullScreenThemeBackground");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r7;
        Drawable r8 = null;
        if (r7 == null) goto L5;
        Boolean r9 = (Boolean) r7.get("data_is_anchor", Boolean.FALSE);
    L6:
        this.a = Intrinsics.areEqual(r9, Boolean.TRUE);
        y0.a r10 = new y0.a();
        r10.e();
        r10.f();
        r10.g();
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.livesdk.a r12 = new com.bytedance.android.livesdk.a(r10);
        Function2<Integer, Boolean, Unit> r13 = new KtvThemeControl$$special$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r13, "cb");
        r12.a = r13;
        this.b = new CompositeDisposable();
        KtvContext.Companion.getClass();
        lb0.b r14 = KtvContext.a.g().getKtvMvBackRound();
        jc1.k.n(IInteractService.class).addBusinessDegradeStrategy(r12);
        if (r7 == null) goto L9;
        int r15 = RecycleWidgetHelper.a;
        Drawable r16 = (Drawable) r7.get("recycle_key_of_mv_bg");
    L11:
        if ((r16 instanceof lb0.b) == false) goto L14;
        r8 = r16;
    L14:
        lb0.b r17 = (lb0.b) r8;
        if (r17 == null) goto L17;
        r14.c = r17.c;
        r14.d = r17.d;
    L17:
        this.b.add(KtvContext.a.g().getKtvStageReadyEvent().onEvent().subscribe(new a(this)));
        this.c = e.a;
        return;
    L9:
        r16 = null;
        goto L11
    L5:
        r9 = null;
        goto L6
    }
}
