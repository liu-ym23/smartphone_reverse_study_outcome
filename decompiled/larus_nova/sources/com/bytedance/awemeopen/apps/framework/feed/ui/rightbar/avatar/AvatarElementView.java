package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class AvatarElementView extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<p, AvatarModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f196611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AoImageView f196612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AoAnimationLottieView f196613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public yz3.c f196614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f196615i;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f196616a = null;

        static {
            int[] r100 = new int[AvatarModel.FollowStatus.values().length];
            r100[AvatarModel.FollowStatus.UNSHOWFOLLOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AvatarModel.FollowStatus.MYSELF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f196616a = r100;
        }
    }

    public static final class b extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AvatarElementView f196617c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            Resources r100 = Resources.getSystem();
            LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 64, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()))));
            Resources r102 = Resources.getSystem();
            r101.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))));
            Unit r103 = Unit.INSTANCE;
            final AvatarElementView r104 = this.f196617c;
            FrameLayout r105 = n(r101, new AvatarElementView$createView$1$createView$2(r104, this));
            r105.setId(R.id.avatar_view_layout);
            return r105;
        }

        public b(AvatarElementView r100, Context r101) {
            this.f196617c = r100;
            super(r101);
        }
    }

    public static final class c extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AvatarElementView f196618d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((p) this.f196618d.f195897b).f196661c.b(Unit.INSTANCE);
        }

        public c(AvatarElementView r100) {
            this.f196618d = r100;
        }
    }

    public static final class d extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AvatarElementView f196619d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((p) this.f196619d.f195897b).f196662d.b(Unit.INSTANCE);
        }

        public d(AvatarElementView r100) {
            this.f196619d = r100;
        }
    }

    public static final class e extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AvatarElementView f196620d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((p) this.f196620d.f195897b).f196659a.b(Unit.INSTANCE);
        }

        public e(AvatarElementView r100) {
            this.f196620d = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        int r100 = com.bytedance.awemeopen.infra.util.e.a(getContext(), 4.0f);
        yz3.c r101 = this.f196614h;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveHead");
        r101 = null;
    L5:
        r101.setPadding(r100, r100, r100, r100);
        AoAnimConfig r103 = new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, com.bytedance.awemeopen.infra.util.f.b(getContext().getAssets().open(this.f196611e)), new o(this), AvatarElementView$initFollowLottieView$config$2.INSTANCE, 4);
        AoAnimationLottieView r104 = this.f196613g;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemUserFollow");
        r104 = null;
    L8:
        r104.setAnimationConfigAndStartLoad(r103);
        AoImageView r105 = this.f196612f;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
        r105 = null;
    L11:
        r105.setOnClickListener(new c(this));
        yz3.c r106 = this.f196614h;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("liveHead");
        r106 = null;
    L14:
        r106.setOnClickListener(new d(this));
        FrameLayout r107 = this.f196615i;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("followItemLayout");
    L18:
        r102.setOnClickListener(new e(this));
        p r108 = (p) this.f195897b;
        Function0<Integer> r109 = new AvatarElementView$onCreate$4(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f196664f = r109;
        AvatarModel r110 = (AvatarModel) this.f195898c;
        Observer<List<String>> r111 = new k(this);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "observer");
        r110.f196622b.a(r111);
        AvatarModel r112 = (AvatarModel) this.f195898c;
        Observer<AvatarModel.FollowStatus> r113 = new l(this);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "observer");
        r112.f196621a.a(r113);
        AvatarModel r114 = (AvatarModel) this.f195898c;
        Observer<Unit> r115 = new m(this);
        r114.getClass();
        Intrinsics.checkNotNullParameter(r115, "observer");
        r114.f196623c.a(r115);
        AvatarModel r116 = (AvatarModel) this.f195898c;
        Observer<yz3.b> r117 = new n(this);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "observer");
        r116.f196624d.a(r117);
        return;
    L17:
        r102 = r107;
        goto L18
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new b(this, getContext()).j();
    }

    public AvatarElementView(Context r100, p r101, AvatarModel r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f196611e = "aos_anim_follow_add_v2.json";
    }
}
