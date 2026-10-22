package xz3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.CommonElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.page.VideoFeedPage;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends BaseGroup<b, LinearLayout, tz3.a, jz3.a> {
    public final Activity j;
    public final o k;
    public final VideoFeedPage l;
    public final CommonElement m;
    public final c n;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ArrayList<BaseElement<?, ?, ?, jz3.a>> c() {
        return CollectionsKt.arrayListOf(new BaseElement[]{this.m});
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void h() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.d a() {
        return new b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void f() {
        this.l.l();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void i() {
        this.l.l();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void j() {
        com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.b r0 = this.m.h();
        c r1 = this.n;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        tz3.b<Pair<Boolean, Boolean>> r2 = r0.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r2.a.remove(r1);
    }

    public final Activity getActivity() {
        return this.j;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ViewGroup b(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(0, -2);
        float r1 = 12;
        Resources r3 = Resources.getSystem();
        int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        Resources r6 = Resources.getSystem();
        int r5 = MathKt.roundToInt(TypedValue.applyDimension(1, 64, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        Resources r7 = Resources.getSystem();
        r0.setMargins(r4, 0, r5, MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()))));
        r0.bottomToTop = 2131363067;
        r0.leftToLeft = 0;
        r0.rightToRight = 0;
        LinearLayout r2 = new LinearLayout(r9);
        r2.setLayoutParams(r0);
        r2.setOrientation(1);
        r2.setVisibility(8);
        return r2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void g(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        r4.getClass();
        com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.b r5 = this.m.h();
        c r0 = this.n;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "observer");
        r5.a.a(r0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [xz3.c] */
    public d(Activity r2, o r3, VideoFeedPage r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "videoFeedPage");
        super(r2);
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = new CommonElement(r2, r3);
        this.n = new c(this);
    }
}
