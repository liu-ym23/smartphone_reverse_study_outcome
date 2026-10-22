package kw0;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import j40.f4;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jw0.g;
import jw0.h;
import kotlin.jvm.internal.Intrinsics;
import yo2.e;
import zr2.k;
import zv0.j;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends k implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f506371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f506372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f506373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View.OnClickListener f506374e;

    /* JADX INFO: renamed from: kw0.a$a, reason: collision with other inner class name */
    public static final class C6618a {
    }

    static {
    }

    @Override // zv0.j
    public final void load() {
    }

    public a() {
        this.f506374e = null;
        this.f506372c = new CompositeDisposable();
    }

    @Override // zv0.j
    public final View.OnClickListener getBehavior() {
        return this.f506374e;
    }

    @Override // zr2.b
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        String r101 = g.a().toString();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        ((zz0.g) f.a(zz0.g.class)).S2(r100.getContext(), r101);
    L5:
        int r102 = h.f500665a;
        HashMap r103 = new HashMap();
        r103.put("request_page", "shortcut");
        r103.put("charge_reason", "exchange_diamond");
        HashMap<Class<?>, d<?>> r104 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_entrance_click", r103, new Class[]{IRoom.class, x.class});
    }

    @Override // zr2.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f506372c.clear();
        e r102 = this.f506373d;
        if (r102 == null) goto L6;
        r102.d();
        return;
    }

    @Override // zr2.b
    public final void p4(View r110, DataCenter r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "dataCenter");
        this.f506371b = r110;
        ((com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class)).F2();
        int r112 = com.bytedance.android.livesdk.revenue.room.d.f157283a;
        yz0.k r113 = (yz0.k) f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r113 == null) goto L5;
        boolean r114 = r113.isAnchor();
    L7:
        if (g2.b(Boolean.valueOf(r114)) == false) goto L9;
        g2.a(this.f506371b);
    L9:
        View r115 = this.f506371b;
        if (r115 == null) goto L12;
        View r116 = r115.findViewById(R.id.icon);
    L14:
        if ((r116 instanceof HSImageView) == true) goto L16;
        r116 = null;
    L16:
        HSImageView r117 = (HSImageView) r116;
        if (r117 == null) goto L19;
        r117.setActualImageResource(R.drawable.ttlive_icon_toolbar_cash_exchange_new_diamond);
    L19:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r118 = f4.f497215r;
        if (r118.getValue().booleanValue() == true) goto L25;
        View r100 = this.f506371b;
        if (r100 == null) goto L25;
        e r101 = new e(r100.getContext());
        r101.f568642d = null;
        r101.f568643e = R.layout.ttlive_layout_toolbar_cash_exchange_guide;
        r101.f568650l = true;
        r101.a();
        this.f506373d = r101;
        r101.i(r100, 1, 0, 0, -s1.f(4.0f));
        this.f506372c.add(Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.f506376a));
        com.bytedance.android.livesdk.sharedpref.f.d(r118, Boolean.TRUE);
    L25:
        int r119 = h.f500665a;
        HashMap r120 = new HashMap();
        r120.put("request_page", "shortcut");
        r120.put("charge_reason", "exchange_diamond");
        HashMap<Class<?>, d<?>> r102 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_entrance_show", r120, new Class[]{IRoom.class, x.class});
        return;
    L12:
        r116 = null;
        goto L14
    L5:
        r114 = false;
        goto L7
    }
}
