package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.m;
import com.bytedance.android.live.ui.q;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.g;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import py.k;
import vh7.f;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements m, com.bytedance.android.live.ktv.common.util.c {
    public IVoiceLiveTheme a;
    public final lb0.b b;
    public q c;
    public Function2<? super Boolean, ? super Long, Unit> d;
    public final String e;
    public final a f;
    public final KtvContext g;
    public final ViewGroup h;
    public final HSImageView i;
    public final HSImageView j;
    public final sb0.b k;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            this.a.d();
        }

        public final void onFinalImageSet(String r5, Object r6, Animatable r7) {
            ImageInfo r8 = (ImageInfo) r6;
            Function2<? super Boolean, ? super Long, Unit> r0 = this.a.d;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        L5:
            super.onFinalImageSet(r5, r8, r7);
        }
    }

    public final void d() {
        Function2<? super Boolean, ? super Long, Unit> r0 = this.d;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L5:
        Drawable r2 = this.b;
        if ((r2 instanceof Drawable) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L11;
        this.i.setImageDrawable(r2);
        return;
    }

    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.d;
    }

    public final String getTypeName() {
        return this.e;
    }

    public final void b(tb0.c r3) {
        Intrinsics.checkNotNullParameter(r3, BaseCoreViewModel.CORE_TAG_STATE);
        if ((r3 instanceof tb0.c.b) == false) goto L5;
        q.a r4 = new q.a();
        g r0 = new g(this.k.b().isAnchor());
        Intrinsics.checkNotNullParameter(r0, "callback");
        r4.c = r0;
        q r5 = r4.a();
        this.c = r5;
        r5.c(this.a);
        return;
    L5:
        q r6 = this.c;
        if (r6 == null) goto L8;
        r6.d(this.a);
    L8:
        this.c = null;
    }

    public final void c(IVoiceLiveTheme r11) {
        Intrinsics.checkNotNullParameter(r11, "theme");
        this.a = r11;
        long r0 = r11.getId();
        ReadOnlyProperty r2 = vm2.d.D3;
        KProperty[] r3 = vm2.d.a;
        boolean r4 = false;
        if (r0 != ((Number) r2.getValue(null, r3[235(0xeb, float:3.3E-43)])).longValue()) goto L14;
        Boolean r1 = (Boolean) this.g.getRealOpenStateData().getValue();
        Boolean r5 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r1, r5)) == false) goto L7;
        this.g.getRealOpenStateData().setValue(r5);
    L7:
        this.i.setController(null);
        this.i.setBackgroundColor(ColorProtector.parseColor(r11.getPublicScreenColorValue()));
        k r12 = r11.getSingleStaticBackground();
        if (r12 != null) goto L10;
        r12 = (k) f.c(k.class);
    L10:
        e(r12, this.j);
        this.j.setVisibility(0);
        ConstraintLayout.LayoutParams r13 = this.j.getLayoutParams();
        if ((r13 instanceof ConstraintLayout.LayoutParams) == false) goto L49;
        ConstraintLayout.LayoutParams r14 = r13;
        r14.topToTop = 2131377060;
        ((ViewGroup.MarginLayoutParams) r14).bottomMargin = s1.f(85.0f);
        r14.bottomToBottom = 2131377060;
        return;
    L49:
        return;
    L14:
        Boolean r6 = (Boolean) this.g.getRealOpenStateData().getValue();
        Boolean r7 = Boolean.FALSE;
        if ((!Intrinsics.areEqual(r6, r7)) == false) goto L17;
        this.g.getRealOpenStateData().setValue(r7);
    L17:
        this.j.setVisibility(8);
        this.i.getHierarchy().setActualImageScaleType(d.e);
        if (this.k.b().isAnchor() != true) goto L21;
        r4 = true;
    L21:
        if (r11.getId() != ((Number) vm2.d.S4.getValue(null, r3[302(0x12e, float:4.23E-43)])).longValue()) goto L23;
    L37:
        String r8 = h.Y().a();
        if (r11.getId() == h.Y().b()) goto L40;
    L44:
        d();
    L45:
        q r9 = this.c;
        if (r9 == null) goto L50;
        r9.a(r11);
        return;
    L50:
        return;
    L40:
        if (TextUtils.isEmpty(r8) == true) goto L44;
        ImageLoader.bindImage(this.i, r8);
        Function2<? super Boolean, ? super Long, Unit> r10 = this.d;
        if (r10 == null) goto L45;
        Unit r15 = (Unit) r10.invoke(r7, Long.valueOf(System.currentTimeMillis()));
        goto L45
    L23:
        if (KtvSettingHelper.a() == false) goto L37;
        if (com.bytedance.android.livesdk.model.k.c(r4) == false) goto L34;
        if (VoiceLiveTheme.isImageModelValid(r11.getSingleStaticBackground()) == false) goto L34;
        k r16 = r11.getSingleStaticBackground();
        if (r16 != null) goto L32;
        r16 = (k) f.c(k.class);
    L32:
        e(r16, null);
    L34:
        if (VoiceLiveTheme.isImageModelValid(r11.getAnimatedBackground()) == false) goto L36;
        PipelineDraweeControllerBuilder r17 = Fresco.newDraweeControllerBuilder();
        r17.setFirstAvailableImageRequests(a1.b(r11.getAnimatedBackground(), -1));
        r17.setAutoPlayAnimations(true);
        r17.setControllerListener(this.f);
        this.i.setController(r17.build());
        goto L45
    L36:
        d();
        goto L45
    }

    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.d = r1;
    }

    public final void a(tb0.b r3, tb0.c r4) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Intrinsics.checkNotNullParameter(r4, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r3, "e");
        Intrinsics.checkNotNullParameter(r4, BaseCoreViewModel.CORE_TAG_STATE);
    }

    public final void e(k r3, HSImageView r4) {
        if (r4 != null) goto L4;
        r4 = this.i;
    L4:
        r4.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r3, -1)).setOldController(this.i.getController()).setControllerListener(this.f).build());
    }

    public c(KtvContext r2, ViewGroup r3, HSImageView r4, HSImageView r5, sb0.b r6) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r4, "bgView");
        Intrinsics.checkNotNullParameter(r5, "ktvBackground");
        Intrinsics.checkNotNullParameter(r6, "dataEntity");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.b = r2.getKtvMvBackRound();
        this.e = TraceCons.METRIC_BACKGROUND;
        this.f = new a(this);
    }
}
