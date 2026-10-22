package lm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends lm0.a {

    public static final class a {
    }

    /* JADX INFO: renamed from: lm0.b$b, reason: collision with other inner class name */
    public static final class C6711b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f509829a;

        public C6711b(b r100) {
            this.f509829a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ALogger.d("CycleDisplayTrigger", "recycleDisplayCard");
            if (ny0.f120869a.getValue().booleanValue() == true) goto L5;
            xs2.b.a().post(new u71.a(this.f509829a.f509828f));
        L5:
            this.f509829a.e();
        }
    }

    static {
    }

    public final void e() {
        Disposable r100 = this.f509823a;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (ny0.f120869a.getValue().booleanValue() == false) goto L8;
        xs2.b.a().post(new u71.a(this.f509828f));
    L8:
        Long r101 = this.f509827e;
        if (r101 == null) goto L11;
        long r102 = r101.longValue();
    L12:
        this.f509823a = Observable.timer(r102, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new C6711b(this));
        return;
    L11:
        r102 = 60000;
        goto L12
    }

    @Override // lm0.a, u71.b
    public final void a() {
        super.a();
        e();
    }

    @Override // u71.b
    public final TriggerId b() {
        return TriggerId.CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER;
    }

    public b(DataCenter r100, Long r101, int r102) {
        super(r100, r101, r102);
    }
}
