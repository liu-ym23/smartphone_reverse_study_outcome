package qw1;

import android.os.Message;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.feed.preview.roomdetector.RoomRetrofitApi;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdkapi.ping.PingResult;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f534960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f534961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f534962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f534963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Gson f534964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f534965f;

    public interface a {
    }

    public final void a() {
        if (this.f534963d == false) goto L19;
        qw1.a r100 = ((e) this.f534962c).f534967b;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L19;
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendPlayingPing(this.f534961b, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        long r102 = this.f534965f;
        if (r102 > 0) goto L15;
        return;
    L15:
        if (r102 < LiveFeedSettings.AUDIENCE_PING_INTERVAL.getValue().intValue()) goto L24;
        this.f534960a.sendMessageDelayed(this.f534960a.obtainMessage(8), this.f534965f * 1000);
        return;
    L24:
        return;
    L7:
        if (r100.onPingCheck() == false) goto L9;
        r101 = true;
    L19:
        if (this.f534963d == false) goto L25;
        this.f534963d = false;
        this.f534960a.removeCallbacksAndMessages(null);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        boolean r101 = this.f534963d;
        if (r101 == true) goto L5;
        return;
    L5:
        int r102 = r100.what;
        if (r102 != 7) goto L8;
        Object r103 = r100.obj;
        if (r101 == true) goto L15;
        return;
    L15:
        if ((r103 instanceof ApiServerException) == false) goto L32;
        int r104 = ((ApiServerException) r103).getErrorCode();
        Logger.d("LivePingController", "ping replay api exception, error code: " + r104);
        if (30001 != r104) goto L19;
    L28:
        qw1.a r105 = ((e) this.f534962c).f534967b;
        if (r105 == null) goto L50;
        r105.b();
        return;
    L50:
        return;
    L19:
        if (30003 == r104) goto L28;
        if (30004 == r104) goto L28;
        if (50002 != r104) goto L47;
        qw1.a r106 = ((e) this.f534962c).f534967b;
        if (r106 == null) goto L48;
        r106.onUserNotInRoom();
        return;
    L48:
        return;
    L47:
        return;
    L32:
        if ((r103 instanceof PingResult) == false) goto L52;
        long r107 = System.currentTimeMillis();
        ALogger.json(4, "pingresult", GsonProtectorUtils.toJson(this.f534964e, r103));
        ALogger.i("pingresultCostTime", String.valueOf(System.currentTimeMillis() - r107));
        PingResult r108 = (PingResult) r103;
        this.f534965f = r108.getNextPingInterval();
        if (4 != r108.getRoomStatus()) goto L41;
        if (r108.getRoomId() != this.f534961b) goto L41;
        qw1.a r109 = ((e) this.f534962c).f534967b;
        if (r109 == null) goto L53;
        r109.onRoomFinished();
        return;
    L53:
        return;
    L41:
        if (r108.getMosaicStatus() == 0) goto L55;
        a r110 = this.f534962c;
        r108.getRoomId();
        long r111 = r108.getMosaicStatus();
        qw1.a r112 = ((e) r110).f534967b;
        if (r112 == null) goto L56;
        r112.a(r111);
        return;
    L56:
        return;
    L55:
        return;
    L52:
        return;
    L8:
        if (r102 != 8) goto L57;
        a();
        return;
    }

    public d(long r100, a r101) {
        this.f534960a = new WeakHandler(this);
        this.f534963d = false;
        this.f534965f = LiveFeedSettings.AUDIENCE_PING_INTERVAL.getValue().intValue();
        this.f534961b = r100;
        this.f534962c = r101;
        this.f534964e = LiveGsonHelper.get();
    }
}
