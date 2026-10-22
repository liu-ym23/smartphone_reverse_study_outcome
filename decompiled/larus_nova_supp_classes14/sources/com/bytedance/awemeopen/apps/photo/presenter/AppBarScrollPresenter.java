package com.bytedance.awemeopen.apps.photo.presenter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.photo.view.CustomCoordinatorLayout;
import com.bytedance.awemeopen.apps.photo.viewmodel.SlidesDetailSizeVM;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.SlidesDetailAppbarBehavior;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppBarScrollPresenter extends f04.a<Unit> {
    public final a14.a d;
    public final Lazy e;
    public CustomCoordinatorLayout f;
    public AppBarLayout g;
    public SlidesDetailAppbarBehavior h;
    public View i;
    public boolean j;
    public long k;
    public boolean l;
    public int m;
    public f n;

    @Override // f04.a
    public final void k() {
    }

    public final void m() {
        long r0 = SystemClock.uptimeMillis() - this.k;
        com.bytedance.awemeopen.apps.photo.utils.a r2 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        a14.a r3 = this.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
        Map r6 = com.bytedance.awemeopen.apps.photo.utils.a.a(r3);
        r6.put("duration", Long.valueOf(r0));
        AosEventReporter r4 = AosEventReporter.a;
        AosPictureDetailConfig r1 = r3.c.getPageConfig();
        if (r1 == null) goto L5;
        JSONObject r5 = r1.getHostExtraParams();
    L6:
        AosEventReporter.s(r4, "graphic_detail_playtime_comment", r6, null, r5, new com.bytedance.awemeopen.apps.framework.utils.e(r3.a), 4);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void n() {
        this.k = SystemClock.uptimeMillis();
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        com.bytedance.awemeopen.apps.photo.utils.a r0 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        a14.a r1 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "feedGroupParameters");
        Map r4 = com.bytedance.awemeopen.apps.photo.utils.a.a(r1);
        AosEventReporter r2 = AosEventReporter.a;
        AosPictureDetailConfig r3 = r1.c.getPageConfig();
        if (r3 == null) goto L8;
        JSONObject r5 = r3.getHostExtraParams();
    L9:
        AosEventReporter.s(r2, "click_comment_button", r4, null, r5, new com.bytedance.awemeopen.apps.framework.utils.e(r1.a), 4);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public AppBarScrollPresenter(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AppBarScrollPresenter$sizeVM$2(this));
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View, com.bytedance.awemeopen.apps.photo.view.CustomCoordinatorLayout] */
    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        final AppBarLayout r4 = i(2131363087);
        r4.addOnOffsetChangedListener(new a(r4, this));
        this.g = r4;
        CoordinatorLayout.LayoutParams r5 = r4.getLayoutParams();
        SlidesDetailAppbarBehavior r1 = null;
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L5;
        CoordinatorLayout.LayoutParams r6 = r5;
    L6:
        if (r6 == null) goto L8;
        CoordinatorLayout.Behavior r7 = r6.getBehavior();
    L10:
        if ((r7 instanceof SlidesDetailAppbarBehavior) == false) goto L12;
        r1 = (SlidesDetailAppbarBehavior) r7;
    L12:
        this.h = r1;
        final ?? r8 = (CustomCoordinatorLayout) i(2131368370);
        ViewTreeObserver r0 = com.bytedance.awemeopen.apps.photo.utils.e.a(r8);
        if (r0 == null) goto L15;
        r0.addOnGlobalLayoutListener(new b(this, r8));
    L15:
        this.f = r8;
        final View r9 = i(2131367388);
        ViewTreeObserver r2 = com.bytedance.awemeopen.apps.photo.utils.e.a(r9);
        if (r2 == null) goto L18;
        r2.addOnGlobalLayoutListener(new d(r9, this));
    L18:
        this.i = r9;
        SlidesDetailSizeVM r10 = (SlidesDetailSizeVM) this.e.getValue();
        if (r10 == null) goto L24;
        MutableLiveData<Object> r11 = r10.getMainListHeightDec();
        if (r11 == null) goto L25;
        r11.observe(this.d.d, new e(this));
        return;
    L25:
        return;
    L24:
        return;
    L8:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
