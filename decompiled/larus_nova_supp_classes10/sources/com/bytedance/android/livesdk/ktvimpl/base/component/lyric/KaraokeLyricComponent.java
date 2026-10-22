package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.h;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.Disposable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/lyric/KaraokeLyricComponent;", "Lcom/bytedance/android/livesdk/ktvimpl/base/component/AbsViewComponent;", "", "a", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KaraokeLyricComponent extends AbsViewComponent {
    public static final /* synthetic */ int l = 0;
    public final ConstraintLayout g;
    public final b h;
    public Function1<? super Long, Unit> i;
    public final com.bytedance.android.livesdk.ktvimpl.base.component.lyric.b j;
    public final com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a k;

    public static final class a {
    }

    public static final class b {
        public final LinearLayout a;
        public final TextView b;
        public final TextView c;
        public final HashSet<String> d;
        public final TextView e;
        public final ConstraintLayout f;

        public b(ConstraintLayout r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "lyricContainer");
            Intrinsics.checkNotNullParameter(r3, "containerView");
            this.f = r2;
            LinearLayout r4 = new LinearLayout(r3.getContext());
            r4.setOrientation(1);
            Unit r0 = Unit.INSTANCE;
            this.a = r4;
            this.b = new TextView(r3.getContext());
            this.c = new TextView(r3.getContext());
            HashSet<String> r5 = new HashSet();
            r5.add(s1.B(2131918536));
            r5.add(s1.B(2131918554));
            this.d = r5;
            TextView r6 = new TextView(r3.getContext());
            r6.setTextColor(ColorProtector.parseColor("#ffffff"));
            r6.setTextSize(15.0f);
            r6.setTypeface(Typeface.DEFAULT_BOLD);
            r6.setGravity(16);
            r6.setVisibility(8);
            this.e = r6;
        }

        public static void a(LinearLayout r4, TextView r5) {
            r5.setTextColor(ColorProtector.parseColor("#ffffff"));
            r5.setTypeface(Typeface.DEFAULT_BOLD);
            r5.setTextSize(15.0f);
            r5.setGravity(17);
            LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, 0);
            r1.gravity = 17;
            r1.weight = 1.0f;
            Unit r0 = Unit.INSTANCE;
            r4.addView(r5, r1);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void b() {
        MutableLiveData<String[]> r0 = this.j.e;
        Function1<String[], Unit> r1 = new KaraokeLyricComponent$bindData$1(this);
        Intrinsics.checkNotNullParameter(r0, "$this$bindData");
        Intrinsics.checkNotNullParameter(r1, "cb");
        r0.observe(this.e, new com.bytedance.android.livesdk.ktvimpl.base.component.a(r1));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final ViewGroup c() {
        FrameLayout r0 = new FrameLayout(this.f.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        b r1 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "frameLayout");
        r0.addView(r1.f, new ViewGroup.LayoutParams(-1, -1));
        r0.addView(r1.e, new ViewGroup.LayoutParams(-1, -1));
        LinearLayout r3 = r1.a;
        r3.setOrientation(1);
        b.a(r3, r1.b);
        b.a(r3, r1.c);
        r0.addView(r1.a, new ViewGroup.LayoutParams(-1, -1));
        return r0;
    }

    public final void g() {
        if (this.j.e.getValue() != null) goto L5;
        final int r0 = 0;
    L7:
        if (this.g.getVisibility() != r0) goto L9;
    L11:
        this.g.setVisibility(r0);
        return;
    L9:
        if (this.g.getVisibility() == 0) goto L11;
        UtilityKotlinExtentionsKt.s(300, false, false, new KaraokeLyricComponent$updateLyricContainerVisibilityBasedOnPlaceholder$1(this, r0), 6);
        return;
    L5:
        r0 = 8;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.b r0 = this.j;
        r0.g.setVisibility(8);
        KaraokeLyricTimer r1 = r0.b;
        if (r1 == null) goto L10;
        Disposable r2 = r1.a;
        if (r2 != null) goto L7;
    L9:
        r1.c = 0;
        r1.b = 0;
        goto L10
    L7:
        if (r2.isDisposed() == true) goto L9;
        r2.dispose();
    L10:
        r0.c.m();
    }

    public KaraokeLyricComponent(LifecycleOwner r10, ViewGroup r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "containerView");
        Intrinsics.checkNotNullParameter(r12, "lyricRunContext");
        super(r10, r11);
        this.k = r12;
        View r4 = new ViewPainter(r11.getContext(), null);
        KtvComponentCountDownView r3 = new KtvComponentCountDownView(r11.getContext(), null, 6, 0);
        RectF[] r13 = {new RectF(UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(16.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(7.0f), UtilityKotlinExtentionsKt.h(9.0f), UtilityKotlinExtentionsKt.h(10.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(1.0f), UtilityKotlinExtentionsKt.h(4.0f), UtilityKotlinExtentionsKt.h(4.0f), UtilityKotlinExtentionsKt.h(19.0f))};
        Intrinsics.checkNotNullParameter(r13, "timeRectArray");
        r3.e = r13;
        r3.g = s1.f(17.0f);
        r3.c.setColor(ColorProtector.parseColor("#01F6E9"));
        r3.setVisibility(8);
        Unit r14 = Unit.INSTANCE;
        ConstraintLayout r15 = new ConstraintLayout(r11.getContext());
        r15.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(s1.f(230.0f), -1);
        r0.rightToRight = 0;
        r0.bottomToBottom = 0;
        r0.topToTop = 0;
        r15.addView(r4, r0);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.rightToRight = 0;
        r1.topToTop = 0;
        r15.addView(r3, r1);
        this.g = r15;
        this.h = new b(r15, r11);
        this.j = new com.bytedance.android.livesdk.ktvimpl.base.component.lyric.b(r15, r3, r4, r12, new KaraokeLyricComponent$lyricPresenter$1(this));
    }
}
