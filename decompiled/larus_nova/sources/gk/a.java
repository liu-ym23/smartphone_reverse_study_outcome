package gk;

import android.view.View;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.ec.hybrid.popup.g;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f481517a;

    public a(b r100) {
        this.f481517a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Lazy r111 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.e.f47505b, this + " on popup view attached");
        long r100 = System.currentTimeMillis();
        Pair[] r101 = new Pair[2];
        r101[0] = TuplesKt.to("container_id", this.f481517a.f481521d);
        g r102 = this.f481517a.f481520c;
        if (r102 == null) goto L5;
        String r103 = r102.getName();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101[1] = TuplesKt.to("group", r103);
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.on_popup_show", r100, "", true, MapsKt.mapOf(r101), false, 32));
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Lazy r111 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.e.f47505b, this + " on popup view detached");
        long r100 = System.currentTimeMillis();
        Pair[] r101 = new Pair[2];
        r101[0] = TuplesKt.to("container_id", this.f481517a.f481521d);
        g r102 = this.f481517a.f481520c;
        if (r102 == null) goto L5;
        String r103 = r102.getName();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101[1] = TuplesKt.to("group", r103);
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.on_popup_dismiss", r100, "", true, MapsKt.mapOf(r101), false, 32));
        return;
    L5:
        r103 = null;
        goto L6
    }
}
