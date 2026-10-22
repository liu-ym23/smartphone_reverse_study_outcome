package lm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends lm0.a {

    public static final class a {
    }

    static {
    }

    @Override // lm0.a, u71.b
    public final void a() {
        DataCenter r100 = this.f509826d;
        IRoom r101 = null;
        if (r100 == null) goto L5;
        r101 = (IRoom) r100.get("data_room", null);
    L5:
        super.a();
        if (r101 == null) goto L19;
        IOfficialChannelInfo r102 = r101.getOfficialChannelInfo();
        if (r102 == null) goto L20;
        long r103 = r102.getEndTimeStamp();
        long r104 = com.bytedance.android.livesdk.utils.ntp.e.a();
        Long r105 = this.f509827e;
        if (r105 == null) goto L12;
        long r106 = r105.longValue();
    L13:
        long r107 = r103 - ((r104 + r106) / ((long) 1000));
        ALogger.d("ExitMicTimeLimitTrigger", "start time count down wait" + r107);
        if (r107 <= 0) goto L16;
        Disposable r108 = Observable.just(1).delay(r107, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this));
        Intrinsics.checkNotNullParameter(r108, "$this$autoBind");
        this.f509824b.add(r108);
        return;
    L16:
        if (r107 > 0) goto L22;
        d(this.f509828f);
        return;
    L22:
        return;
    L12:
        r106 = 0;
        goto L13
    L20:
        return;
    }

    @Override // u71.b
    public final TriggerId b() {
        return TriggerId.EXIT_MIC_TIME_LIMIT;
    }

    public e(DataCenter r100, Long r101, int r102) {
        super(r100, r101, r102);
    }
}
