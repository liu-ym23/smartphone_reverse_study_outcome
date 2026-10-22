package com.ss.android.lark.forwardv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint;
import com.ss.android.lark.forwardv2.impl.ForwardPickActivity;
import com.ss.android.lark.forwardv2.impl.ForwardPickResponsiveActivity;
import com.ss.android.lark.forwardv3.utils.n;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nnc.t;
import z5c.c4;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static hib.d f424890a;

    public static final class a {
        @JvmStatic
        public static hib.d a() {
            if (e.f424890a != null) goto L6;
            e.f424890a = (hib.d) PluginServiceLoader.loadFirst(hib.d.class);
        L6:
            if (e.f424890a != null) goto L8;
            e.f424890a = new d();
        L8:
            hib.d r100 = e.f424890a;
            Intrinsics.checkNotNull(r100);
            return r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final hib.d d() {
        return a.a();
    }

    public static Intent a(Context r100) {
        if (ForsetiFGHelpers.d() == false) goto L6;
        Intent r101 = new Intent(r100, ForwardPickResponsiveActivity.class).addFlags(65536);
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        return new Intent(r100, ForwardPickActivity.class);
    }

    public static /* synthetic */ void c(Context r100, ForwardTemplate r101) {
        b(r100, r101, -1, null, null);
    }

    public static void b(Context r100, ForwardTemplate r101, final int r102, int[] r103, int[] r104) {
        if (r100 == null) goto L48;
        boolean r105 = zib.b.f572310d;
        s5c.a r106 = c4.f570178c;
        ForwardHitPoint r107 = r101.f424790f;
        if (r107 == null) goto L8;
        String r108 = r107.f424840b;
        if (r108 == null) goto L8;
    L9:
        zib.b.e(r106, r108);
        Intent r109 = a(r100);
        r109.putExtra("parcelable_forward_template", r101);
        if (r103 == null) goto L12;
        r109.putExtra("key_transition_anim_in", r103);
    L12:
        if (r104 == null) goto L14;
        r109.putExtra("key_transition_anim_out", r104);
    L14:
        r109.putExtra(ILoadStallMonitor.START_TIME, SystemClock.elapsedRealtime());
        Bundle r110 = r101.f424791g;
        if (r110 == null) goto L20;
        if (r110.getBoolean("sdkshare") == false) goto L20;
        r109.addFlags(335544320);
    L20:
        if (ForsetiFGHelpers.d() == true) goto L22;
        int r111 = n.f425590a;
        if (n.f(r100) == false) goto L37;
        if ((r100 instanceof FragmentActivity) == true) goto L30;
        r109.addFlags(268435456);
        r100.startActivity(r109);
    L41:
        if (ForsetiFGHelpers.d() == true) goto L43;
        return;
    L43:
        if ((r100 instanceof Activity) == false) goto L47;
        ((Activity) r100).overridePendingTransition(0, 0);
        return;
    L47:
        return;
    L30:
        g r112 = f.c((FragmentActivity) r100, true);
        if (r112 == null) goto L41;
        t r113 = t.f519838a;
        Bundle r114 = r109.getExtras();
        if (r114 != null) goto L35;
        r114 = new Bundle();
    L35:
        Intrinsics.checkNotNullParameter(r114, "args");
        r112.f(new onc.g(r114), new ForwardModuleV2$safeStartActivity$1(r102));
        goto L41
    L37:
        if ((r100 instanceof Activity) == true) goto L39;
        r109.addFlags(268435456);
        r100.startActivity(r109);
        goto L41
    L39:
        ((Activity) r100).startActivityForResult(r109, r102);
        goto L41
    L22:
        if ((r100 instanceof Activity) == true) goto L24;
        r109.addFlags(268435456);
        r100.startActivity(r109);
        goto L41
    L24:
        ((Activity) r100).startActivityForResult(r109, r102);
    L8:
        r108 = "v2_default";
        goto L9
    }
}
