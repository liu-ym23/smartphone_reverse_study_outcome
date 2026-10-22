package ut1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerPresenter$innerDrawerListener$1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveDrawerLayout f551589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f551590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f551591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f551592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f551593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f551594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DouyinLoadingLayout f551595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f551596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f551597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f551598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RelativeLayout f551599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f551600l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LiveDrawerPresenter$innerDrawerListener$1 f551601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f551602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Activity f551603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FragmentManager f551604p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DataCenter f551605q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<? extends DrawerLayout.DrawerListener> f551606r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Bundle f551607s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f551608t;

    public interface a {
        void H();

        boolean er();
    }

    public static final class b {
    }

    static {
    }

    public final Activity getActivity() {
        return this.f551603o;
    }

    public final Context getContext() {
        return this.f551602n;
    }

    public static float a(float r100) {
        if (PadConfigUtils.c() == true) goto L7;
        return 0.0f;
    L7:
        return (s1.G(s1.y()) - 358.0f) - r100;
    }

    public final void b(Fragment r100, Fragment r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f551594f == r101) goto L22;
        this.f551594f = r101;
        FragmentTransaction r102 = this.f551604p.beginTransaction();
        if (r101.isAdded() == true) goto L17;
        if (r100 == null) goto L13;
        if (r100.isAdded() == false) goto L13;
        r102.hide(r100);
    L13:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.panel_feed_container) == true) goto L16;
        r102 = r102.add(R.id.panel_feed_container, r101);
    L16:
        r102.commitAllowingStateLoss();
        goto L22
    L17:
        if (r100 != null) goto L19;
    L21:
        r102.show(r101).commitAllowingStateLoss();
        goto L22
    L19:
        if (r100.isAdded() == false) goto L21;
        r102.hide(r100);
    L22:
        ActivityResultCaller r103 = this.f551593e;
        if ((r103 instanceof pa1.a) == false) goto L32;
        if (r103 == null) goto L31;
        pa1.a r104 = (pa1.a) r103;
        if (this.f551594f != r103) goto L28;
        boolean r105 = true;
    L29:
        r104.Bp(r105);
        return;
    L28:
        r105 = false;
        goto L29
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.search.api.ILiveSearchFragment");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.drawer.LiveDrawerPresenter$innerDrawerListener$1] */
    public k(Context r100, FragmentActivity r101, FragmentManager r102, a r103) {
        Intrinsics.checkNotNullParameter(r102, "fragmentManager");
        Intrinsics.checkNotNullParameter(r103, "containerCallBack");
        this.f551602n = r100;
        this.f551603o = r101;
        this.f551604p = r102;
        this.f551605q = null;
        this.f551606r = null;
        this.f551607s = null;
        this.f551608t = r103;
        this.f551601m = new LiveDrawerPresenter$innerDrawerListener$1(this);
    }
}
