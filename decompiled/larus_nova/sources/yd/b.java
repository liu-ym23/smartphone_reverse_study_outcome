package yd;

import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.sti.IECExternalEntryEvent;
import com.bytedance.android.livesdk.livecommerce.room.widgets.coupon.CustomIconTemplate;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b<STATE> implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f567296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super STATE, Unit> f567297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Integer, ? super Long, Integer> f567298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f567299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f567300e;

    public b() {
    }

    public abstract void b(Object r100, Object r101);

    public abstract a d(STATE r100, STATE r101);

    public abstract STATE e();

    public abstract int j();

    public abstract CustomIconTemplate k(Object r100);

    public abstract void m();

    public void n(View r100, IECExternalEntryEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "entryView");
        Intrinsics.checkNotNullParameter(r101, "event");
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public final void l(STATE r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Function1<? super STATE, Unit> r101 = this.f567297b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moveToState");
    L5:
        r101.invoke(r100);
    }
}
