package vja;

import android.app.Activity;
import com.larus.nova.R;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f555447a = 0;

    static {
        new mja.b();
    }

    @JvmStatic
    public static final void a(Activity r100, TransitionAnimStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "animStyle");
        int r102 = a.f555443a[r101.ordinal()];
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        TransitionAnimStyle r103 = r101;
    L8:
        String r104 = r100.getClass().getSimpleName();
        if (r101 == r103) goto L11;
        mja.a.C6822a r105 = mja.a.f514263a;
        mja.a.b("TransitionAnimHelper", "overrideEnterAnim, " + r101 + " is deprecated: , use " + r103 + " instead, activity: " + r104);
    L12:
        int r106 = a.f555444b[r103.ordinal()];
        if (r106 == 1) goto L23;
        if (r106 != 2) goto L16;
        r100.overridePendingTransition(R.anim.oui_modal_open_enter, R.anim.oui_modal_open_exit);
        return;
    L16:
        if (r106 == 3) goto L21;
        mja.a.C6822a r107 = mja.a.f514263a;
        String r108 = "overrideEnterAnim, unsupported anim style: " + r101 + "，activity: " + r104;
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r108, "msg");
        if (mja.a.f514263a == null) goto L20;
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r108, "msg");
        return;
    L20:
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r108, "msg");
        return;
    L21:
        r100.overridePendingTransition(R.anim.oui_search_open_enter, R.anim.oui_search_open_exit);
        return;
    L23:
        r100.overridePendingTransition(R.anim.oui_activity_open_enter, R.anim.oui_activity_open_exit);
        return;
    L11:
        mja.a.C6822a r109 = mja.a.f514263a;
        mja.a.d("TransitionAnimHelper", "overrideEnterAnim, animStyle: " + r101 + "，activity: " + r104);
        goto L12
    L6:
        r103 = TransitionAnimStyle.Modal;
        goto L8
    L7:
        r103 = TransitionAnimStyle.Standard;
        goto L8
    }
}
