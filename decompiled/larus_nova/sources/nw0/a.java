package nw0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.incentive.exchange.j;
import com.bytedance.android.live.recharge.util.i;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import jw0.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import pa0.o;
import yo2.e;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements zv0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f520931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f520932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f520933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f520934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f520935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<View> f520936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f520937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Integer, Unit> f520938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f520939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f520940j;

    /* JADX INFO: renamed from: nw0.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC6982a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f520941a;

        public ViewOnClickListenerC6982a(a r100) {
            this.f520941a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (j.b() == true) goto L5;
            ToastUtil.a(R.string.ttlive_income_not_enough_exchange_toast_new, 0);
            gx0.b.a(false);
        L11:
            com.bytedance.tools.kcp.spongepreference.runtime.a r101 = i.f90447b;
            KProperty<?>[] r102 = i.f90446a;
            if (((Boolean) r101.getValue(null, r102[0])).booleanValue() == true) goto L15;
            r101.setValue(null, r102[0], Boolean.TRUE);
            zr2.i r103 = new zr2.i(false, false);
            ((com.bytedance.android.livesdk.revenue.service.toolbar.e) vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class)).b9(this.f520941a.f520934d).a(RevToolbarButton.Gift, r103);
            return;
        L15:
            return;
        L5:
            a r104 = this.f520941a;
            r104.getClass();
            String r105 = g.a().toString();
            if (TextUtils.isEmpty(r105) == true) goto L10;
            Context r106 = r104.f520940j;
            if (r106 == null) goto L10;
            ((zz0.g) f.a(zz0.g.class)).S2(r106, r105);
        L10:
            gx0.b.a(true);
            goto L11
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // zv0.b
    public final void onUnload() {
        e r100 = this.f520931a;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        this.f520940j = null;
        this.f520932b.clear();
        this.f520931a = null;
    }

    public final Context getContext() {
        return this.f520940j;
    }

    @Override // zv0.b
    public final void setDataCenter(DataCenter r100) {
        this.f520934d = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r100, List<? extends View> r101, TextView r102, Function1<? super Integer, Unit> r103, int r104, Context r105) {
        Intrinsics.checkNotNullParameter(r101, "actionViews");
        Intrinsics.checkNotNullParameter(r102, "updateView");
        this.f520935e = r100;
        this.f520936f = r101;
        this.f520937g = r102;
        this.f520938h = r103;
        this.f520939i = r104;
        this.f520940j = r105;
        this.f520932b = new CompositeDisposable();
        Iterator r106 = r101.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        ((View) r106.next()).setOnClickListener(new ViewOnClickListenerC6982a(this));
        goto L4
    L6:
        RxUtilKt.c(com.bytedance.android.live.revenue.common.reactive.j.a(o.f528351b, true).subscribe(new nw0.b(this)), this.f520932b);
    }
}
