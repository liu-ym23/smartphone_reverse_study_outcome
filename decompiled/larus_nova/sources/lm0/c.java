package lm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends lm0.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TriggerId f509830g;

    public static final class a {
    }

    static {
    }

    @Override // lm0.a, u71.b
    public final void a() {
        super.a();
        DataCenter r100 = this.f509826d;
        if (r100 == null) goto L5;
        Long r101 = (Long) r100.get("live_enter_room_complete_time");
    L6:
        if (r101 == null) goto L19;
        long r102 = System.currentTimeMillis() - r101.longValue();
        ALogger.d("EnterRoomTimeLimitTrigger", "start time count down wait" + r102);
        Long r103 = this.f509827e;
        long r104 = 0;
        if (r103 == null) goto L10;
        long r105 = r103.longValue();
    L12:
        if (r102 >= r105) goto L17;
        Observable r106 = Observable.just(1);
        Long r107 = this.f509827e;
        if (r107 == null) goto L16;
        r104 = r107.longValue() - r102;
    L16:
        Disposable r108 = r106.delay(r104, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this));
        Intrinsics.checkNotNullParameter(r108, "$this$autoBind");
        this.f509824b.add(r108);
        return;
    L17:
        d(this.f509828f);
        return;
    L10:
        r105 = 0;
        goto L12
    L19:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // u71.b
    public final TriggerId b() {
        return this.f509830g;
    }

    public c(DataCenter r100, Long r101, int r102) {
        super(r100, r101, r102);
        this.f509830g = TriggerId.ENTER_ROOM_TIME_LIMIT;
    }
}
