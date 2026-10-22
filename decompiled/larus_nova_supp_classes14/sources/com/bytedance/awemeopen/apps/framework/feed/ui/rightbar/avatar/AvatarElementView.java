package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AvatarElementView extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<p, AvatarModel> {
    public final String e;
    public AoImageView f;
    public AoAnimationLottieView g;
    public yz3.c h;
    public FrameLayout i;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AvatarModel.FollowStatus.values().length];
            r0[AvatarModel.FollowStatus.UNSHOWFOLLOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AvatarModel.FollowStatus.MYSELF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b extends IWrittenLayout {
        public final /* synthetic */ AvatarElementView c;

        public final View f() {
            Resources r2 = Resources.getSystem();
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 64, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
            Resources r3 = Resources.getSystem();
            r0.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
            Unit r1 = Unit.INSTANCE;
            final AvatarElementView r4 = this.c;
            FrameLayout r5 = n(r0, new AvatarElementView$createView$1$createView$2(r4, this));
            r5.setId(2131363752);
            return r5;
        }

        public b(AvatarElementView r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public static final class c extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ AvatarElementView d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((p) this.d.b).c.b(Unit.INSTANCE);
        }

        public c(AvatarElementView r1) {
            this.d = r1;
        }
    }

    public static final class d extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ AvatarElementView d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((p) this.d.b).d.b(Unit.INSTANCE);
        }

        public d(AvatarElementView r1) {
            this.d = r1;
        }
    }

    public static final class e extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ AvatarElementView d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((p) this.d.b).a.b(Unit.INSTANCE);
        }

        public e(AvatarElementView r1) {
            this.d = r1;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        int r0 = com.bytedance.awemeopen.infra.util.e.a(getContext(), 4.0f);
        yz3.c r1 = this.h;
        FrameLayout r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveHead");
        r1 = null;
    L5:
        r1.setPadding(r0, r0, r0, r0);
        AoAnimConfig r2 = new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, com.bytedance.awemeopen.infra.util.f.b(getContext().getAssets().open(this.e)), new o(this), AvatarElementView$initFollowLottieView$config$2.INSTANCE, 4);
        AoAnimationLottieView r4 = this.g;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemUserFollow");
        r4 = null;
    L8:
        r4.setAnimationConfigAndStartLoad(r2);
        ImageView r5 = this.f;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
        r5 = null;
    L11:
        r5.setOnClickListener(new c(this));
        yz3.c r6 = this.h;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("liveHead");
        r6 = null;
    L14:
        r6.setOnClickListener(new d(this));
        FrameLayout r7 = this.i;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("followItemLayout");
    L18:
        r3.setOnClickListener(new e(this));
        p r8 = (p) this.b;
        Function0<Integer> r9 = new AvatarElementView$onCreate$4(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.f = r9;
        AvatarModel r10 = (AvatarModel) this.c;
        Observer<List<String>> r11 = new k(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "observer");
        r10.b.a(r11);
        AvatarModel r12 = (AvatarModel) this.c;
        Observer<AvatarModel.FollowStatus> r13 = new l(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "observer");
        r12.a.a(r13);
        AvatarModel r14 = (AvatarModel) this.c;
        Observer<Unit> r15 = new m(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "observer");
        r14.c.a(r15);
        AvatarModel r16 = (AvatarModel) this.c;
        Observer<yz3.b> r17 = new n(this);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "observer");
        r16.d.a(r17);
        return;
    L17:
        r3 = r7;
        goto L18
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new b(this, getContext()).j();
    }

    public AvatarElementView(Context r2, p r3, AvatarModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.e = "aos_anim_follow_add_v2.json";
    }
}
