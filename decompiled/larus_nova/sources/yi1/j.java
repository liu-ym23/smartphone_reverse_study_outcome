package yi1;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.pushstream.StatusApi;
import com.bytedance.android.livesdk.config.e11;
import com.bytedance.android.livesdk.config.fb;
import com.bytedance.android.livesdk.config.mh;
import com.bytedance.bpea.cert.token.TokenCert;
import com.lynx.tasm.LynxError;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.bytedance.android.live.pushstream.report.a, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f567864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f567865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f567866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f567867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f567868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f567869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f567870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.report.b f567871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final yi1.b f567872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.report.c f567873j;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.core.utils.rxutils.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f567874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e11 f567875b;

        public b(int r100, e11 r101) {
            this.f567874a = r100;
            this.f567875b = r101;
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.l.a
        public final boolean a(Throwable r100, int r101) {
            if (this.f567874a != 4) goto L7;
            if (this.f567875b.b() == false) goto L7;
        L10:
            Boolean r102 = NewBroadcastMonitor.f64916a;
            int r103 = NewBroadcastMonitor.d(r100);
            if (this.f567875b.a().contains(Integer.valueOf(r103)) == false) goto L17;
            return false;
        L17:
            return true;
        L7:
            if (this.f567874a == 3) goto L9;
            return true;
        L9:
            if (this.f567875b.e() == true) goto L10;
            return true;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f567876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f567877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f567878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f567879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f567880e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f567881f;

        public c(j r100, int r101, boolean r102, long r103, int r104, String r105) {
            this.f567876a = r100;
            this.f567877b = r101;
            this.f567878c = r102;
            this.f567879d = r103;
            this.f567880e = r104;
            this.f567881f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            BaseResponse r111 = (BaseResponse) r110;
            if (this.f567877b != 4) goto L5;
            boolean r112 = true;
        L6:
            j.a(this.f567876a, r112, 0, null);
            com.bytedance.android.live.pushstream.report.c r100 = this.f567876a.f567873j;
            if (r100 == null) goto L10;
            r100.a(this.f567877b, r112, 0, null);
        L10:
            if (this.f567878c == false) goto L12;
            long r101 = System.currentTimeMillis() - this.f567879d;
            j.b(this.f567876a, this.f567877b, this.f567880e, this.f567881f, r101);
        L12:
            if (r112 == false) goto L15;
            com.bytedance.android.livesdk.sharedpref.e<Pair<String, String>> r113 = com.bytedance.android.livesdk.sharedpref.b.D;
            Pair r102 = new Pair("0", "0");
            r113.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r113, r102);
            return;
        L15:
            return;
        L5:
            r112 = false;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f567882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f567883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f567884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f567885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f567886e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f567887f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f567888g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e11 f567889h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Map f567890i;

        public d(j r100, int r101, String r102, int r103, boolean r104, int r105, int r106, e11 r107, Map r108) {
            this.f567882a = r100;
            this.f567883b = r101;
            this.f567884c = r102;
            this.f567885d = r103;
            this.f567886e = r104;
            this.f567887f = r105;
            this.f567888g = r106;
            this.f567889h = r107;
            this.f567890i = r108;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            Throwable r100 = (Throwable) r210;
            if (this.f567883b != 4) goto L5;
            boolean r101 = true;
        L6:
            String r102 = "1";
            if (r101 == false) goto L21;
            NewBroadcastMonitor.a r110 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_CLOSE_ROOM_FAILED, null, null, 14);
            r110.n(r100);
            r110.c(String.valueOf(this.f567883b));
            r110.d(this.f567884c);
            r110.e("reason", String.valueOf(this.f567885d));
            if (this.f567886e == false) goto L11;
            String r111 = "1";
        L12:
            r110.e("status_change", r111);
            r110.e("retry_times", String.valueOf(this.f567887f));
            if (this.f567887f <= 0) goto L15;
            String r112 = String.valueOf(this.f567888g);
        L16:
            r110.e("last_error_code", r112);
            if (NetworkUtils.f(jc1.a.b()) == false) goto L19;
            String r113 = "1";
        L20:
            r110.e("is_network_available", r113);
            r110.a().report();
            goto L21
        L19:
            r113 = "0";
            goto L20
        L15:
            r112 = "";
            goto L16
        L11:
            r111 = "0";
        L21:
            if (r101 == false) goto L31;
            mh r114 = mh.f120755a;
            if (r114.getValue().b() == false) goto L31;
            if (this.f567889h.b() == true) goto L31;
            if (this.f567887f >= r114.getValue().c()) goto L31;
            Boolean r115 = NewBroadcastMonitor.f64916a;
            int r211 = NewBroadcastMonitor.d(r100);
            if (r114.getValue().a().contains(Integer.valueOf(r211)) == false) goto L31;
            this.f567882a.c(this.f567883b, this.f567885d, this.f567884c, this.f567890i, this.f567886e, this.f567887f + 1, r211);
            return;
        L31:
            j.a(this.f567882a, r101, 1, r100);
            if ((r100 instanceof ApiServerException) == false) goto L36;
            com.bytedance.android.live.pushstream.report.c r116 = this.f567882a.f567873j;
            if (r116 == null) goto L39;
            r116.a(this.f567883b, r101, ((ApiServerException) r100).getErrorCode(), r100);
        L39:
            TokenCert r117 = y50.d.f566210a;
            y50.d.b(LiveTracingMonitor.EventModule.OPEN_LIVE, y50.d.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("server_api_name", "/room/ping/anchor/")}), this.f567883b));
            NewBroadcastMonitor.a r103 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_PING_ANCHOR_FAILED, null, null, 14);
            r103.n(r100);
            r103.c(String.valueOf(this.f567883b));
            r103.d(this.f567884c);
            r103.e("reason", String.valueOf(this.f567885d));
            if (this.f567886e == true) goto L43;
            r102 = "0";
        L43:
            r103.e("status_change", r102);
            r103.a().report();
            if (r101 == false) goto L48;
            com.bytedance.android.livesdk.sharedpref.e<Pair<String, String>> r104 = com.bytedance.android.livesdk.sharedpref.b.D;
            String r105 = String.valueOf(this.f567882a.f567871h.getRoomId());
            Boolean r106 = NewBroadcastMonitor.f64916a;
            Pair r107 = new Pair(r105, String.valueOf(NewBroadcastMonitor.d(r100)));
            r104.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r104, r107);
            return;
        L48:
            return;
        L36:
            com.bytedance.android.live.pushstream.report.c r118 = this.f567882a.f567873j;
            if (r118 == null) goto L39;
            r118.a(this.f567883b, r101, -1, r100);
            goto L39
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
    }

    public final void f() {
        Disposable r100 = this.f567870g;
        if (r100 != null) goto L5;
    L7:
        Handler r101 = this.f567865b;
        if (r101 == null) goto L10;
        r101.removeMessages(this.f567864a);
    L10:
        Handler r102 = this.f567865b;
        if (r102 == null) goto L14;
        r102.removeCallbacksAndMessages(null);
        return;
    L14:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r100.dispose();
        goto L7
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.what;
        if (this.f567864a != r101) goto L11;
        Integer r102 = this.f567871h.a();
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        d(r103, "", false);
        return true;
    L7:
        r103 = 0;
        goto L8
    L11:
        return true;
    }

    public /* synthetic */ j(com.bytedance.android.livesdk.chatroom.broadcast.v2.service.b r100, com.bytedance.android.livesdk.chatroom.broadcast.v2.service.a r101) {
        this(r100, null, r101, 0);
    }

    public final void d(int r110, String r111, boolean r112) {
        Handler r100 = this.f567865b;
        if (r100 == null) goto L5;
        r100.removeMessages(this.f567864a);
    L5:
        c(this.f567868e, r110, r111, this.f567869f, r112, 0, 0);
        ALogger.i("audience_ping", "send status:" + this.f567868e + " reason:" + r110);
        if (4 == this.f567868e) goto L11;
        Handler r113 = this.f567865b;
        if (r113 == null) goto L12;
        r113.sendEmptyMessageDelayed(this.f567864a, this.f567867d);
        return;
    L12:
        return;
    }

    public final void e(int r100, int r101, String r102) {
        boolean r103 = false;
        if (this.f567868e == r100) goto L5;
        TokenCert r104 = y50.d.f566210a;
        LiveTracingMonitor.EventModule r105 = LiveTracingMonitor.EventModule.OPEN_LIVE;
        JSONObject r106 = y50.d.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sdk_callback_name", "normal_push_stream_state_change")}), r100);
        Intrinsics.checkNotNullParameter(r105, "scene");
        Intrinsics.checkNotNullParameter(r106, "args");
        LiveTracingMonitor.d("ttlive_anchor_sdk_callback", r105, LiveTracingMonitor.EventType.SDK_CALLBACK, r106);
        r103 = true;
    L5:
        this.f567868e = r100;
        d(r101, r102, r103);
    }

    public j(com.bytedance.android.live.pushstream.report.b r100, f r101, com.bytedance.android.live.pushstream.report.c r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "roomCtx");
        this.f567871h = r100;
        this.f567872i = r101;
        this.f567873j = r102;
        this.f567864a = 102;
        this.f567868e = 1;
        this.f567869f = new LinkedHashMap();
        this.f567865b = new Handler(this);
        if (r103 > 0) goto L5;
        r103 = 5000;
    L5:
        this.f567867d = r103;
    }

    public static final void a(j r100, boolean r101, int r102, Throwable r103) {
        r100.getClass();
        if (r101 == false) goto L14;
        ALogger.e("StatusReport", "monitorRoomFinishStatus status: " + r102 + ", throwable: " + r103);
        JSONObject r104 = new JSONObject();
        if (r103 != null) goto L12;
    L10:
        LiveSlardarMonitor.monitorStatus("ttlive_anchor_close_room_all", r102, r104);
        return;
    L12:
        r104.put(LynxError.LYNX_THROWABLE, r103.getMessage());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static final void b(j r100, int r101, int r102, String r103, long r104) {
        r100.getClass();
        NewBroadcastMonitor.a r105 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ON_HANDLE_UPDATE_ROOM_STATUS, null, null, 14);
        r105.l(0);
        r105.c(String.valueOf(r101));
        r105.d(r103);
        r105.h(r104);
        r105.i("reason", Integer.valueOf(r102));
        r105.i("source", r103);
        if (r101 != 1) goto L5;
        String r106 = "prepare";
    L15:
        r105.i("status_msg", r106);
        r105.a().report();
        return;
    L5:
        if (r101 != 2) goto L7;
        r106 = "play";
        goto L15
    L7:
        if (r101 != 3) goto L9;
        r106 = "pause";
        goto L15
    L9:
        if (r101 == 4) goto L11;
        r106 = "";
        goto L15
    L11:
        r106 = VideoEventOneOutSync.END_TYPE_FINISH;
        goto L15
    }

    public final void c(int r210, int r211, String r212, Map<String, ? extends Object> r213, boolean r214, int r215, int r216) {
        if (r210 != 4) goto L19;
        TokenCert r100 = y50.d.f566210a;
        y50.d.b(LiveTracingMonitor.EventModule.OPEN_LIVE, y50.d.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("server_api_name", "/room/close/")}), r210));
        if (112 != r211) goto L11;
        if (v.a() == false) goto L50;
        f2.c("cannot reach here. room start cannot finish room. Connect ShangHai", 0);
        return;
    L50:
        return;
    L11:
        if (ms1.h.a() == false) goto L19;
        if (115 != r211) goto L19;
        if (v.a() == false) goto L51;
        f2.c("cannot reach here. room start cannot finish room. Connect ShangHai", 0);
        return;
    L51:
        return;
    L19:
        if (r210 != 2) goto L26;
        yi1.b r101 = this.f567872i;
        if (r101 == null) goto L26;
        if (r101.a() == true) goto L26;
        ALogger.i("audience_ping", "can't ping anchor because checker.");
        return;
    L26:
        Object r102 = null;
        if (r213 == null) goto L29;
        Object r103 = r213.get("current_sticker_id");
    L31:
        if ((r103 instanceof Long) == false) goto L34;
        r102 = r103;
    L34:
        Long r104 = (Long) r102;
        long r110 = System.currentTimeMillis();
        LinkedHashMap r105 = new LinkedHashMap();
        e11 r106 = fb.f120187a.getValue();
        StatusApi r107 = (StatusApi) com.bytedance.android.live.network.c.b().e(StatusApi.class);
        long r108 = this.f567871h.getRoomId();
        long r109 = this.f567871h.b();
        if (r212 != null) goto L37;
        String r111 = "";
    L38:
        Observable<BaseResponse<Void, uv0.b>> r112 = r107.sendStatusWithExtra(r108, r210, r109, r211, r111, r104, r105).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        if (r106.b() == false) goto L41;
    L42:
        if (r210 != 4) goto L44;
    L47:
        e11 r113 = r106;
        Observable<BaseResponse<Void, uv0.b>> r114 = r112.retryWhen(new com.bytedance.android.live.core.utils.rxutils.l(r106.d(), r106.c(), new b(r210, r113)));
    L48:
        this.f567870g = r114.subscribe(new c(this, r210, r214, r110, r211, r212), new d(this, r210, r212, r211, r214, r215, r216, r113, r213));
        return;
    L44:
        if (r210 == 3) goto L47;
    L46:
        r114 = r112;
        r113 = r106;
        goto L48
    L41:
        if (r106.e() == false) goto L46;
    L37:
        r111 = r212;
        goto L38
    L29:
        r103 = null;
        goto L31
    }
}
