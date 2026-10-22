package com.bytedance.android.livesdk.landscapeslide;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.setting.u2;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/LiveLandscapeSlideGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLandscapeSlideGuideWidget extends LiveWidget implements Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public e a;
    public ConstraintLayout b;
    public ConstraintLayout c;
    public ConstraintLayout d;
    public HSImageView e;

    public static final class a {
        @JvmStatic
        public static boolean a(IRoom r4) {
            if (((MultiLinkFirstFrameOptConfigV2) u2.a.getValue()).isEnableLandscapeSlideGuideWidgetLoadOpt() == false) goto L14;
            Context r0 = s1.getContext();
            if (r0 == null) goto L14;
            Resources r1 = r0.getResources();
            if (r1 == null) goto L14;
            Configuration r2 = r1.getConfiguration();
            if (r2 == null) goto L14;
            if (r2.orientation != 1) goto L14;
            return false;
        L14:
            if (v5.b().getBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE", false) == true) goto L16;
        L23:
            return true;
        L16:
            if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L19;
            return false;
        L19:
            if (d1.a(r4) == false) goto L21;
        L22:
            return false;
        L21:
            if (v5.b().getBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE_EXT", false) == false) goto L23;
            goto L22
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveLandscapeSlideGuideWidget a;

        public b(LiveLandscapeSlideGuideWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveLandscapeSlideGuideWidget r3 = this.a;
            int r0 = LiveLandscapeSlideGuideWidget.f;
            r3.hide();
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566562;
    }

    public final void hide() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Widget) this).contentView == null) goto L10;
        r0.setVisibility(8);
        ((Widget) this).contentView.setVisibility(8);
        return;
    }

    public final void xq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        IRoom r1 = null;
        if (r0 == null) goto L6;
        r1 = (IRoom) r0.get("data_room", null);
    L6:
        if (a.a(r1) == true) goto L9;
        return;
    L9:
        if (((Widget) this).containerView != null) goto L11;
        return;
    L11:
        if (((Widget) this).contentView == null) goto L22;
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(i2.c("/slide/ttlive_landscape_slide_guide.webp")).setAutoPlayAnimations(true).build();
        HSImageView r3 = this.e;
        if (r3 == null) goto L16;
        r3.setController(r2);
    L16:
        ((Widget) this).containerView.setVisibility(0);
        ((Widget) this).contentView.setVisibility(0);
        ((Widget) this).containerView.setOnClickListener(new b(this));
        v5.b().edit().putBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE", true).apply();
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L21;
        v5.b().edit().putBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE_EXT", true).apply();
        return;
    L21:
        return;
    }

    public final void onCreate() {
        super.onCreate();
        e.a r0 = e.a;
        int r1 = com.bytedance.android.livesdk.utils.landscape.f.a.d();
        r0.getClass();
        if (r1 != 1) goto L5;
        e r2 = new c();
    L9:
        this.a = r2;
        this.b = ((Widget) this).contentView.findViewById(2131389631);
        this.c = ((Widget) this).contentView.findViewById(2131389632);
        this.d = ((Widget) this).contentView.findViewById(2131389633);
        this.e = ((Widget) this).contentView.findViewById(2131389626);
        ConstraintLayout r3 = this.b;
        e r4 = this.a;
        Float r5 = null;
        if (r4 == null) goto L12;
        Float r6 = Float.valueOf(r4.a());
    L13:
        wq(r3, r6);
        ConstraintLayout r7 = this.c;
        e r8 = this.a;
        if (r8 == null) goto L16;
        Float r9 = Float.valueOf(r8.c());
    L17:
        wq(r7, r9);
        ConstraintLayout r10 = this.d;
        e r11 = this.a;
        if (r11 == null) goto L20;
        r5 = Float.valueOf(r11.b());
    L20:
        wq(r10, r5);
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 != null) goto L23;
        return;
    L23:
        r12.observe("data_is_portrait", this);
        return;
    L16:
        r9 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L5:
        if (r1 == 2) goto L7;
        r2 = new com.bytedance.android.livesdk.landscapeslide.a();
        goto L9
    L7:
        r2 = new com.bytedance.android.livesdk.landscapeslide.a();
        goto L9
    }

    public final void onDestroy() {
        super.onDestroy();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver("data_is_portrait", this);
    }

    public LiveLandscapeSlideGuideWidget() {
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        Boolean r0 = null;
        if (r3 == null) goto L6;
        r0 = (Boolean) r3.getData(null);
    L6:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L9;
        hide();
        return;
    }

    public static void wq(ConstraintLayout r1, Float r2) {
        if (r1 == null) goto L13;
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r1.getLayoutParams() instanceof LinearLayout.LayoutParams) == false) goto L15;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L12;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r0;
        r3.weight = r2.floatValue();
        r1.setLayoutParams(r3);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L15:
        return;
    }
}
