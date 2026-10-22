package yi1;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.pushstream.StatusApi;
import com.bytedance.android.livesdk.config.nh;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.bytedance.android.livesdk.room.c<ls2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f567861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f567862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f567863d;

    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public i() {
        this.f567862c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f567861b != null) goto L6;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L6:
        ALogger.i("ttlive_anchor_swallow_back", "Biz Ping onExitRoom");
        int r100 = ms1.h.f515462a;
        if (nh.f120832a.getValue().booleanValue() == true) goto L17;
        j r101 = this.f567861b;
        if (r101 == null) goto L17;
        if (r101.f567866c == false) goto L17;
        if (r101.f567868e != 2) goto L17;
        ALogger.i("ttlive_anchor_swallow_back", "pause when jump");
        r101.f567868e = 3;
        long r102 = System.currentTimeMillis();
        LinkedHashMap r110 = new LinkedHashMap();
        ((StatusApi) com.bytedance.android.live.network.c.b().e(StatusApi.class)).sendStatusWithExtra(r101.f567871h.getRoomId(), 3, r101.f567871h.b(), 0, "audience_exit_jump", 0L, r110).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r101, r102), l.f567893a);
    L17:
        j r103 = this.f567861b;
        if (r103 == null) goto L20;
        r103.f();
    L20:
        this.f567861b = null;
        this.f567862c.clear();
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static String z(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "streamId");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L5
        r103.put("last_anchor_room_id", r100);     // Catch: Throwable -> L5
        r103.put("last_anchor_room_stream_id", r101);     // Catch: Throwable -> L5
        r103.put("is_direct_go_end_page", true);     // Catch: Throwable -> L5
        return "sslocal://webcast_open_live?source_params=%7B%22live_scene%22%3A%22video%22%7D&record_tab_only=true&shell_source_params=" + URLEncoder.encode(r103.toString(), StandardCharsets.UTF_8.name());
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Throwable r105 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r105 == null) goto L13;
        ALogger.e("ttlive_anchor_swallow_back", "buildWebcastOpenLiveScheme error", r105);
        return "";
    L13:
        return "";
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void n(com.bytedance.android.livesdk.room.b r210, ts2.i r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ms1.h.a() == true) goto L6;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L6:
        this.f567863d = new WeakReference(r210.getActivity());
        Bundle r100 = r210.f510498e;
        if (r100 == null) goto L9;
        String r101 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_MY_PAUSED_LIVING_ROOM_ID, "");
    L10:
        Bundle r102 = r210.f510498e;
        if (r102 == null) goto L13;
        String r103 = r102.getString(ILiveRoomPlayFragmentConstant.EXTRA_MY_PAUSED_LIVING_ROOM_STREAM_ID, "");
    L14:
        ALogger.i("ttlive_anchor_swallow_back", "Biz my last anchor room id = " + r101 + " , streamId = " + r103);
        if (TextUtils.isEmpty(r101) == false) goto L17;
    L46:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L17:
        if (TextUtils.isEmpty(r103) == true) goto L46;
        Observable<Unit> r104 = ((IBrowserService) jc1.k.n(IBrowserService.class)).registerExternalMethodFactory(new h(this.f567863d));
        if (r104 == null) goto L23;
        Disposable r105 = r104.subscribe();
        if (r105 == null) goto L23;
        RxUtilKt.c(r105, this.f567862c);
    L23:
        DataCenter r106 = r210.f157610s;
        if (r106 == null) goto L26;
        r106.put("key_live_my_last_paused_living_room_id", r101);
    L26:
        DataCenter r107 = r210.f157610s;
        if (r107 == null) goto L29;
        r107.put("key_live_my_last_paused_living_stream_id", r103);
    L29:
        DataCenter r108 = r210.f157610s;
        if (r101 == null) goto L46;
        Long r109 = StringsKt.toLongOrNull(r101);
        if (r109 == null) goto L46;
        long r110 = r109.longValue();
        if (r103 == null) goto L46;
        Long r111 = StringsKt.toLongOrNull(r103);
        if (r111 == null) goto L46;
        long r112 = r111.longValue();
        NewBroadcastMonitor.a r113 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.NEW_LINK_AUDIENCE_PING_START, null, null, 14);
        int r114 = 0;
        r113.l(0);
        r113.i("room_id", r101);
        r113.i("stream_id", r103);
        r113.a().report();
        this.f567861b = new j(new com.bytedance.android.live.pushstream.report.e(r110, r112, 201), new f(r108), new g(this, r101, r103), 5000);
        ALogger.i("ttlive_anchor_swallow_back", "Biz Ping onStart");
        j r115 = this.f567861b;
        if (r115 == null) goto L46;
        if (r115.f567866c == true) goto L46;
        r115.f567868e = 2;
        Integer r116 = r115.f567871h.a();
        if (r116 == null) goto L45;
        r114 = r116.intValue();
    L45:
        r115.d(r114, "", true);
        r115.f567866c = true;
        goto L46
    L13:
        r103 = null;
        goto L14
    L9:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(com.bytedance.android.livesdk.room.b r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f567861b != null) goto L6;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L6:
        if (r101 == null) goto L48;
        int r103 = e.f567854a[r101.ordinal()];
        int r104 = 0;
        if (r103 == 2) goto L36;
        if (r103 == 3) goto L23;
        if (r103 != 5) goto L48;
        if (this.f567861b != null) goto L18;
        return;
    L18:
        ALogger.i("ttlive_anchor_swallow_back", "Biz Ping ON_DESTROY");
        j r105 = this.f567861b;
        if (r105 == null) goto L21;
        r105.f();
    L21:
        this.f567861b = null;
        this.f567862c.clear();
        goto L48
    L23:
        if (this.f567861b != null) goto L26;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L26:
        ALogger.i("ttlive_anchor_swallow_back", "Biz Ping onPause");
        j r106 = this.f567861b;
        if (r106 == null) goto L48;
        if (r106.f567866c == false) goto L48;
        ALogger.i("ttlive_anchor_swallow_back", "pause ping audience_pause");
        Integer r107 = r106.f567871h.a();
        if (r107 == null) goto L34;
        r104 = r107.intValue();
    L34:
        r106.e(3, r104, "audience_pause");
        goto L48
    L36:
        if (this.f567861b != null) goto L39;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L39:
        ALogger.i("ttlive_anchor_swallow_back", "Biz Ping onResume");
        j r108 = this.f567861b;
        if (r108 == null) goto L48;
        if (r108.f567866c == false) goto L48;
        Integer r109 = r108.f567871h.a();
        if (r109 == null) goto L47;
        r104 = r109.intValue();
    L47:
        r108.e(2, r104, "audience_resume");
    L48:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
