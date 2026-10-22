package zl0;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c implements t71.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f572760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f572761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f572762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f572763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v61.a f572764e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f572765a;

        public a(c r100) {
            this.f572765a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ICardLifecycle$State r101 = (ICardLifecycle$State) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (d.f572766a[r101.ordinal()] != 1) goto L11;
            this.f572765a.f572760a.clear();
            return;
        }
    }

    @Override // t71.a
    public Single<Boolean> a() {
        return null;
    }

    @Override // t71.a
    public abstract Object getIdentity();

    @Override // t71.a
    public final void onIntercept() {
        com.bytedance.android.live.room.api.messagewindow.monitor.i r100 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r100 == null) goto L13;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r101 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_fail_show");
        r101.b("type", this.f572763d);
        r101.b("reason", "1");
        StringBuilder r102 = new StringBuilder("interceptor: ");
        Object r103 = getIdentity();
        String r104 = null;
        if ((r103 instanceof ConditionId) == true) goto L8;
        r103 = null;
    L8:
        ConditionId r105 = (ConditionId) r103;
        if (r105 == null) goto L11;
        r104 = r105.getDesc();
    L11:
        r102.append(r104);
        r102.append(", value: ");
        r102.append(this.f572762c);
        r101.b("extra", r102.toString());
        Unit r106 = Unit.INSTANCE;
        r100.b(r101.a());
        return;
    }

    public c(DataCenter r100, Long r101, Integer r102, v61.a r103) {
        this.f572761b = r100;
        this.f572762c = r101;
        this.f572763d = r102;
        this.f572764e = r103;
        this.f572760a = new CompositeDisposable();
        if (r103 == null) goto L8;
        Observable<ICardLifecycle$State> r104 = r103.v();
        if (r104 == null) goto L9;
        r104.subscribe(new a(this));
        return;
    L9:
        return;
    }
}
