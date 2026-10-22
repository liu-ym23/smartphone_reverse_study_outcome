package zf1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import bolts.Task;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.ya;
import com.bytedance.android.livesdk.message.model.j0;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.backtrace.AnchorBackRecordData;
import com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements IAnchorBacktrackService, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f571631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f571632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IAnchorBacktrackService.State f571633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnchorBackRecordData f571634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j0 f571635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f571636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f571637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f571638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f571639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f571640k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f571641l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f571642m;

    public class a implements ConfigObserver<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f571643a;

        @Override // com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
        public final Object getConfig() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f571643a.f571630a);
            String r101 = File.separator;
            r100.append(r101);
            r100.append("live");
            r100.append(r101);
            r100.append(PortraitEngine.LABEL_FIRST_FRAME);
            PolarisFileWrapper r102 = new PolarisFileWrapper(r100.toString());
            if (r102.exists() == true) goto L8;
            if (r102.mkdirs() == true) goto L8;
            return this.f571643a.f571630a;
        L8:
            return r102.getAbsolutePath();
        }

        public a(b0 r100) {
            this.f571643a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
        public final void onChanged(Object r100) {
            final String r101 = (String) r100;
            if (TextUtils.isEmpty(r101) == true) goto L7;
            Task.callInBackground(new z(r101)).continueWith(new a0(this), Task.UI_THREAD_EXECUTOR);
            return;
        }
    }

    public class b implements Consumer<Response<AnchorBackRecordData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f571644a;

        public b(b0 r100) {
            this.f571644a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Response<AnchorBackRecordData> r110) throws Exception {
            Response<AnchorBackRecordData> r111 = r110;
            if (r111 == null) goto L10;
            AnchorBackRecordData r100 = r111.data;
            if (r100 == null) goto L10;
            if (TextUtils.isEmpty(r100.getExecutionId()) == true) goto L10;
            b0 r101 = this.f571644a;
            AnchorBackRecordData r112 = r111.data;
            r101.f571634e = r112;
            long r102 = r112.getWaitSeconds();
            long r103 = this.f571644a.f571634e.getTimeoutSeconds();
            c0 r113 = new c0(this);
            d0 r104 = new d0(this);
            r101.c();
            ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, 100}).setDuration(r102 * 1000);
            r101.f571640k = r105;
            r105.addUpdateListener(r113);
            r101.f571640k.start();
            ValueAnimator r114 = ValueAnimator.ofInt(new int[]{0, 100}).setDuration(r103 * 1000);
            r101.f571641l = r114;
            r114.addListener(r104);
            r101.f571641l.start();
            return;
        L10:
            this.f571644a.d("backtrack error", "invalid response");
            this.f571644a.e(IAnchorBacktrackService.State.BACKTRACK_DOING, IAnchorBacktrackService.State.IDLE);
        }
    }

    public final void c() {
        ValueAnimator r100 = this.f571640k;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
        this.f571640k.cancel();
        this.f571640k = null;
    L5:
        ValueAnimator r101 = this.f571641l;
        if (r101 == null) goto L9;
        r101.removeAllListeners();
        this.f571641l.cancel();
        this.f571641l = null;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final void discardBacktrack() {
        if (b(IAnchorBacktrackService.State.BACKTRACK_DOING) == false) goto L12;
        c();
        com.bytedance.android.livesdk.service.l.d().getClass();
        RoomRetrofitApi r100 = (RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class);
        DataCenter r101 = this.f571631b;
        long r102 = 0;
        if (r101 == null) goto L7;
        r102 = ((Long) r101.get("data_room_id", 0L)).longValue();
    L7:
        AnchorBackRecordData r103 = this.f571634e;
        if (r103 == null) goto L10;
        String r104 = r103.getExecutionId();
    L11:
        this.f571638i = r100.anchorCancelBacktrack(r102, r104).compose(RxUtil.rxSchedulerHelper()).subscribe(RxUtil.getNoOp(), RxUtil.getNoOpThrowable());
        goto L12
    L10:
        r104 = "";
    L12:
        this.f571635f = null;
        e(IAnchorBacktrackService.State.BACKTRACK_DONE, IAnchorBacktrackService.State.IDLE);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final long getDuration() {
        j0 r100 = this.f571635f;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getEndTime() - this.f571635f.getStartTime();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final String getM3u8Url() {
        j0 r100 = this.f571635f;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.G();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final int getProgress() {
        ValueAnimator r100 = this.f571640k;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return ((Integer) r100.getAnimatedValue()).intValue();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final void startBacktrack() {
        IAnchorBacktrackService.State r100 = IAnchorBacktrackService.State.IDLE;
        if (b(r100) == true) goto L5;
        return;
    L5:
        DataCenter r101 = this.f571631b;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f571632c != null) goto L13;
        vlc.d r102 = (vlc.d) r101.get("data_message_manager", null);
        this.f571632c = r102;
        if (r102 == null) goto L13;
        r102.addMessageListener(MessageType.ANCHOR_BACK_RECORD_MESSAGE.getIntType(), this);
    L13:
        e(r100, IAnchorBacktrackService.State.BACKTRACK_DOING);
        com.bytedance.android.livesdk.service.l.d().getClass();
        RoomRetrofitApi r103 = (RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class);
        long r104 = ((Long) this.f571631b.get("data_room_id", 0L)).longValue();
        int r105 = ya.f121669a.getValue().intValue() * 60;
        if (r105 > 0) goto L16;
        r105 = 300;
    L16:
        this.f571636g = r103.queryAnchorBacktrack(r104, r105).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new b(this), new n(this));
        this.f571631b.put("data_save_back_record_preview_info", null);
        this.f571631b.put("cmd_screenshot_live_room", this.f571642m);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final void release() {
        c();
        Disposable r100 = this.f571636g;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f571637h;
        if (r101 != null) goto L10;
    L12:
        Disposable r102 = this.f571638i;
        if (r102 != null) goto L15;
    L17:
        vlc.d r103 = this.f571632c;
        if (r103 == null) goto L20;
        r103.removeMessageListener(this);
    L20:
        this.f571632c = null;
        this.f571631b = null;
        return;
    L15:
        if (r102.isDisposed() == true) goto L17;
        this.f571638i.isDisposed();
        goto L17
    L10:
        if (r101.isDisposed() == true) goto L12;
        this.f571637h.dispose();
        goto L12
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f571636g.dispose();
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final int getOperationProgress() {
        return this.f571639j;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final IAnchorBacktrackService.State getState() {
        return this.f571633d;
    }

    public static void a(List r100) {
        if (CollectionUtils.isEmpty(r100) == true) goto L6;
        new com.bytedance.android.livesdk.chatroom.record.b().execute1(new String[][]{(String[]) r100.toArray(new String[0])});
        return;
    }

    public final boolean b(IAnchorBacktrackService.State r100) {
        if (r100 != this.f571633d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getIntType() != MessageType.ANCHOR_BACK_RECORD_MESSAGE.getIntType()) goto L25;
        IAnchorBacktrackService.State r101 = IAnchorBacktrackService.State.BACKTRACK_DOING;
        if (b(r101) == true) goto L10;
        d("handle message error", "check state error, current state: " + this.f571633d);
        return;
    L10:
        j0 r102 = (j0) r100;
        if (TextUtils.equals(this.f571634e.getExecutionId(), r102.E()) == true) goto L14;
        d("handle message error", "check executionId error, current id: " + this.f571634e.getExecutionId() + ", message id: " + r102.E());
        return;
    L14:
        c();
        if (r102.getSucceed() == true) goto L17;
    L21:
        d("handle message error", "invalid message, executionId: " + r102.E() + ", success: " + r102.getSucceed());
        e(r101, IAnchorBacktrackService.State.IDLE);
        return;
    L17:
        if (TextUtils.isEmpty(r102.G()) == true) goto L21;
        if (CollectionUtils.isEmpty(r102.H()) == true) goto L21;
        this.f571635f = r102;
        e(r101, IAnchorBacktrackService.State.BACKTRACK_DONE);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final void startSaveDraft(final Context r110) {
        IAnchorBacktrackService.State r100 = IAnchorBacktrackService.State.BACKTRACK_DONE;
        if (b(r100) == true) goto L5;
        return;
    L5:
        e(r100, IAnchorBacktrackService.State.SAVE_DRAFT);
        ArrayList r101 = new ArrayList();
        String[] r102 = new String[this.f571635f.H().size()];
        final ArrayList r103 = new ArrayList();
        int r104 = 0;
    L7:
        if (r104 >= this.f571635f.H().size()) goto L9;
        String r105 = (String) ListProtector.get(this.f571635f.H(), r104);
        String r106 = this.f571630a + File.separator + r104 + "_" + UriProtector.parse(r105).getLastPathSegment();
        r101.add(new Pair(r105, r106));
        r102[r104] = r106;
        r103.add(r106);
        r104 = r104 + 1;
        goto L7
    L9:
        StringBuilder r107 = new StringBuilder();
        r107.append(this.f571630a);
        String r108 = File.separator;
        r107.append(r108);
        r107.append(this.f571635f.E());
        r107.append(".mp4");
        final String r109 = r107.toString();
        final String r111 = this.f571630a + r108 + this.f571635f.E() + "_" + System.currentTimeMillis() + ".mp4";
        r103.add(r109);
        this.f571637h = Observable.concat(Observable.create(new p(this, r101)), Observable.create(new y(this, r102, r109)).subscribeOn(Schedulers.io()), Observable.create(new o(this, r111, r109)).subscribeOn(Schedulers.io()), Observable.create(new x(this, r111, r110))).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this), new r(this, r103), new s(this, r103));
    }

    public b0(DataCenter r100, String r101) {
        this.f571633d = IAnchorBacktrackService.State.IDLE;
        this.f571634e = null;
        this.f571635f = null;
        this.f571636g = null;
        this.f571637h = null;
        this.f571638i = null;
        this.f571639j = 0;
        this.f571640k = null;
        this.f571641l = null;
        this.f571642m = new a(this);
        this.f571630a = r101;
        this.f571631b = r100;
        vlc.d r102 = (vlc.d) r100.get("data_message_manager", null);
        this.f571632c = r102;
        if (r102 == null) goto L6;
        r102.addMessageListener(MessageType.ANCHOR_BACK_RECORD_MESSAGE.getIntType(), this);
        return;
    }

    public final void d(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r102.put("event_info", r101);
        AnchorBackRecordData r103 = this.f571634e;
        if (r103 != null) goto L5;
        String r104 = "";
    L6:
        r102.put("execution_id", r104);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_anchor_backtrack", r102);
        return;
    L5:
        r104 = r103.getExecutionId();
        goto L6
    }

    public final void e(IAnchorBacktrackService.State r100, IAnchorBacktrackService.State r101) {
        d("state_change", "pre state: " + r100 + ", cur state: " + r101);
        this.f571633d = r101;
        DataCenter r102 = this.f571631b;
        if (r102 == null) goto L6;
        r102.put("data_backtrack_state_changed", new g(r100, r101));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService
    public final void startDownloadWithStorageControl(final Context r100, final String r101) {
        IAnchorBacktrackService.State r102 = IAnchorBacktrackService.State.BACKTRACK_DONE;
        if (b(r102) == true) goto L5;
        return;
    L5:
        e(r102, IAnchorBacktrackService.State.DOWNLOAD);
        ArrayList r103 = new ArrayList();
        String[] r104 = new String[this.f571635f.H().size()];
        final ArrayList r105 = new ArrayList();
        int r106 = 0;
    L7:
        if (r106 >= this.f571635f.H().size()) goto L9;
        String r107 = (String) ListProtector.get(this.f571635f.H(), r106);
        String r108 = this.f571630a + File.separator + r106 + "_" + UriProtector.parse(r107).getLastPathSegment();
        r103.add(new Pair(r107, r108));
        r104[r106] = r108;
        r105.add(r108);
        r106 = r106 + 1;
        goto L7
    L9:
        final String r109 = this.f571630a + File.separator + this.f571635f.E() + ".mp4";
        r105.add(r109);
        this.f571637h = Observable.concat(Observable.create(new p(this, r103)), Observable.create(new y(this, r104, r109)).subscribeOn(Schedulers.io()), Observable.create(new w(r100, r101, r109)).subscribeOn(Schedulers.io())).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this), new u(this, r105), new v(this, r105));
    }
}
