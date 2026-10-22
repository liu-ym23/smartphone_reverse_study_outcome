package com.bytedance.livesdk.ktvimpl.base.lyric;

import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.i;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/ktvimpl/base/lyric/KaraokeLyricComponentV2;", "Lcom/bytedance/android/livesdk/ktvimpl/base/component/AbsViewComponent;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KaraokeLyricComponentV2 extends AbsViewComponent {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f256309o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f256310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f256311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f256312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f256313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Long, Unit> f256314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvimpl.base.lyric.b f256315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j f256316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a f256317n;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f256318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f256319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f256320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f256321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ConstraintLayout f256322e;

        public b(ConstraintLayout r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "lyricContainer");
            Intrinsics.checkNotNullParameter(r101, "containerView");
            this.f256322e = r100;
            LinearLayout r102 = new LinearLayout(r101.getContext());
            r102.setOrientation(1);
            Unit r103 = Unit.INSTANCE;
            this.f256318a = r102;
            this.f256319b = new TextView(r101.getContext());
            this.f256320c = new TextView(r101.getContext());
            HashSet r104 = new HashSet();
            r104.add(s1.B(R.string.ttlive_ktv_room_lyrics_empty_and_score));
            r104.add(s1.B(R.string.ttlive_ktv_room_score_empty));
            TextView r105 = new TextView(r101.getContext());
            r105.setTextColor(ColorProtector.parseColor("#ffffff"));
            r105.setTextSize(15.0f);
            r105.setTypeface(Typeface.DEFAULT_BOLD);
            r105.setGravity(16);
            r105.setVisibility(8);
            this.f256321d = r105;
        }

        public static void a(LinearLayout r100, TextView r101) {
            r101.setTextColor(ColorProtector.parseColor("#ffffff"));
            r101.setTypeface(Typeface.DEFAULT_BOLD);
            r101.setTextSize(15.0f);
            r101.setGravity(17);
            LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, 0);
            r102.gravity = 17;
            r102.weight = 1.0f;
            Unit r103 = Unit.INSTANCE;
            r100.addView(r101, r102);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final ViewGroup c() {
        FrameLayout r100 = new FrameLayout(this.f142406f.getContext());
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        b r101 = this.f256313j;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        r100.addView(r101.f256322e, new ViewGroup.LayoutParams(-1, -1));
        r100.addView(r101.f256321d, new ViewGroup.LayoutParams(-1, -1));
        LinearLayout r102 = r101.f256318a;
        r102.setOrientation(1);
        b.a(r102, r101.f256319b);
        b.a(r102, r101.f256320c);
        r100.addView(r101.f256318a, new ViewGroup.LayoutParams(-1, -1));
        return r100;
    }

    public final void g() {
        final int r100 = 0;
        if (this.f256312i.getVisibility() != 0) goto L5;
    L7:
        this.f256312i.setVisibility(0);
        return;
    L5:
        if (this.f256312i.getVisibility() == 0) goto L7;
        UtilityKotlinExtentionsKt.s(300, false, false, new KaraokeLyricComponentV2$updateLyricContainerVisibilityBasedOnPlaceholder$1(this, r100), 6);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.livesdk.ktvimpl.base.lyric.b r100 = this.f256315l;
        r100.f256339f.setVisibility(8);
        KaraokeLyricTimerV2 r101 = r100.f256335b;
        if (r101 == null) goto L10;
        Disposable r102 = r101.f256327a;
        if (r102 != null) goto L7;
    L9:
        r101.f256329c = 0;
        r101.f256328b = 0;
        goto L10
    L7:
        if (r102.isDisposed() == true) goto L9;
        r102.dispose();
    L10:
        ng4.e r103 = r100.f256337d.f256343a;
        if (r103 == null) goto L13;
        r103.release();
    L13:
        d r104 = this.f256310g;
        ng4.e r105 = r104.f256343a;
        if (r105 == null) goto L16;
        r105.release();
    L16:
        ng4.e r106 = r104.f256343a;
        if (r106 == null) goto L19;
        r106.c();
    L19:
        int r107 = c.f256342a;
        j r108 = r104.f256344b;
        Intrinsics.checkNotNullParameter(r108, "scope");
        m.f163449e.getClass();
        com.bytedance.livesdk.ktvimpl.base.lyric.a r109 = (com.bytedance.livesdk.ktvimpl.base.lyric.a) m.b(r108).b(com.bytedance.livesdk.ktvimpl.base.lyric.a.class);
        if (r109 == null) goto L23;
        r109.F();
        return;
    }

    public KaraokeLyricComponentV2(j r100, KaraokeSceneType r110, LifecycleOwner r111, ViewGroup r112, i r113) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r110, "karaokeSceneType");
        Intrinsics.checkNotNullParameter(r111, "owner");
        Intrinsics.checkNotNullParameter(r112, "containerView");
        Intrinsics.checkNotNullParameter(r113, "lyricRunContext");
        super(r111, r112);
        this.f256316m = r100;
        this.f256317n = r113;
        d r101 = new d(r112.getContext(), r110, r100);
        this.f256310g = r101;
        ng4.e r102 = r101.f256343a;
        AttributeSet r114 = null;
        if (r102 == null) goto L5;
        Object r103 = r102.a();
    L6:
        if (r103 == null) goto L10;
        View r104 = (View) r103;
        this.f256311h = r104;
        KtvComponentCountDownView r105 = new KtvComponentCountDownView(r112.getContext(), r114, 6, 0);
        RectF[] r115 = {new RectF(UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(16.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(7.0f), UtilityKotlinExtentionsKt.h(9.0f), UtilityKotlinExtentionsKt.h(10.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(1.0f), UtilityKotlinExtentionsKt.h(4.0f), UtilityKotlinExtentionsKt.h(4.0f), UtilityKotlinExtentionsKt.h(19.0f))};
        Intrinsics.checkNotNullParameter(r115, "timeRectArray");
        r105.f145277e = r115;
        r105.f145279g = s1.f(17.0f);
        r105.f145275c.setColor(ColorProtector.parseColor("#01F6E9"));
        r105.setVisibility(8);
        Unit r116 = Unit.INSTANCE;
        ConstraintLayout r106 = new ConstraintLayout(r112.getContext());
        r106.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(s1.f(230.0f), -1);
        r117.rightToRight = 0;
        r117.bottomToBottom = 0;
        r117.topToTop = 0;
        r106.addView(r104, r117);
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(-2, -2);
        r107.rightToRight = 0;
        r107.topToTop = 0;
        r106.addView(r105, r107);
        this.f256312i = r106;
        this.f256313j = new b(r106, r112);
        this.f256315l = new com.bytedance.livesdk.ktvimpl.base.lyric.b(r101, r106, r105, r113, new KaraokeLyricComponentV2$lyricPresenter$1(this));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L5:
        r103 = null;
        goto L6
    }
}
