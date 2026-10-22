package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class CollectElementView extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, i> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f196676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f196677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AoAnimationLottieView f196678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f196679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f196680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public State f196681j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/collect/CollectElementView$State;", "", "AnimToCollect", "AnimToUnCollect", "UnCollect", "Collect", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum State extends Enum<State> {
        public static final State AnimToCollect = null;
        public static final State AnimToUnCollect = null;
        public static final State Collect = null;
        public static final State UnCollect = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f196682a = null;

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f196682a.clone();
        }

        static {
            State r100 = new State("AnimToCollect", 0);
            AnimToCollect = r100;
            State r101 = new State("AnimToUnCollect", 1);
            AnimToUnCollect = r101;
            State r102 = new State("UnCollect", 2);
            UnCollect = r102;
            State r103 = new State("Collect", 3);
            Collect = r103;
            f196682a = new State[]{r100, r101, r102, r103};
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CollectElementView f196683d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((g) this.f196683d.f195897b).f196696a.b(Unit.INSTANCE);
        }

        public a(CollectElementView r100) {
            this.f196683d = r100;
        }
    }

    public final void d() {
        AoAnimationLottieView r100 = this.f196678g;
        AoAnimationLottieView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r100 = null;
    L5:
        r100.setImageResource(R.drawable.aos_feed_collected_icon);
        AoAnimationLottieView r102 = this.f196678g;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r102 = null;
    L9:
        if (r102.isShown() == true) goto L11;
    L13:
        boolean r103 = false;
    L15:
        if (r102.isRunning() == false) goto L19;
        r102.f198576h.cancelAnimation();
        return;
    L19:
        if (r103 == false) goto L21;
        r102.setMinAndMaxFrame(0, 40);
        this.f196681j = State.AnimToCollect;
        r102.start();
        return;
    L21:
        r102.setMinAndMaxFrame(40, 40);
        this.f196681j = State.Collect;
        AoAnimationLottieView r104 = this.f196678g;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
    L25:
        r101.setImageResource(R.drawable.aos_feed_collected_icon);
        return;
    L24:
        r101 = r104;
        goto L25
    L11:
        if (this.f196680i == false) goto L13;
        r103 = true;
        goto L15
    }

    public final void e() {
        AoAnimationLottieView r100 = this.f196678g;
        AoAnimationLottieView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r100 = null;
    L5:
        r100.setImageResource(R.drawable.aos_feed_collect_icon);
        AoAnimationLottieView r102 = this.f196678g;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r102 = null;
    L9:
        if (r102.isShown() == true) goto L11;
    L13:
        boolean r103 = false;
    L15:
        if (r102.isRunning() == false) goto L19;
        r102.f198576h.cancelAnimation();
        return;
    L19:
        if (r103 == false) goto L21;
        r102.setMinAndMaxFrame(40, 64);
        this.f196681j = State.AnimToUnCollect;
        r102.start();
        return;
    L21:
        r102.setMinAndMaxFrame(64, 64);
        this.f196681j = State.UnCollect;
        AoAnimationLottieView r104 = this.f196678g;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
    L25:
        r101.setImageResource(R.drawable.aos_feed_collect_icon);
        return;
    L24:
        r101 = r104;
        goto L25
    L11:
        if (this.f196680i == false) goto L13;
        r103 = true;
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.f196677f = (LinearLayout) b().findViewById(R.id.collect_view_layout);
        this.f196679h = (TextView) b().findViewById(R.id.collect_count);
        AoAnimationLottieView r100 = (AoAnimationLottieView) b().findViewById(R.id.collect_image);
        this.f196678g = r100;
        LinearLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r100 = null;
    L5:
        r100.setImageResource(R.drawable.aos_feed_collect_icon);
        AoAnimationLottieView r102 = this.f196678g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r102 = null;
    L8:
        r102.setImagesAssetsFolder("aos_anim_collect_img_star");
        String r103 = com.bytedance.awemeopen.infra.util.f.b(getContext().getAssets().open("aos_anim_collect.json"));
        AoAnimationLottieView r104 = this.f196678g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r104 = null;
    L11:
        r104.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, r103, new f(this), new CollectElementView$initCollectView$2(this), 4));
        LinearLayout r105 = this.f196677f;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("collectContainer");
    L15:
        r101.setOnClickListener(new a(this));
        i r106 = (i) this.f195898c;
        Observer<Unit> r107 = new b(this);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "observer");
        r106.f196698a.a(r107);
        i r108 = (i) this.f195898c;
        Observer<Boolean> r109 = new c(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "observer");
        r108.f196700c.a(r109);
        i r110 = (i) this.f195898c;
        Observer<Long> r111 = new d(this);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "observer");
        r110.f196699b.a(r111);
        i r112 = (i) this.f195898c;
        Observer<Boolean> r113 = new e(this);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "observer");
        r112.f196701d.a(r113);
        return;
    L14:
        r101 = r105;
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_common_feed_layout_video_collect, r100, false);
    }

    public CollectElementView(Context r100, g r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f196676e = "CollectElementView";
        this.f196680i = true;
        this.f196681j = State.UnCollect;
    }
}
