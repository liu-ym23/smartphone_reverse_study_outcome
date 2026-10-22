package yi0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f567843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ILinkPlayerInfoBridge f567844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f567845d;

    /* JADX INFO: renamed from: yi0.a$a, reason: collision with other inner class name */
    public static final class C8344a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f567846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f567847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f567848c;

        public C8344a(a r100, boolean r101, long r102) {
            this.f567846a = r100;
            this.f567847b = r101;
            this.f567848c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            e r101 = (e) r100;
            a r102 = this.f567846a;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r102);
        L18:
            if (this.f567846a.f567845d == false) goto L24;
            if (this.f567847b == true) goto L22;
            MultiLinkEventModule r104 = zi0.b.f572218a;
            zi0.b.e(true, r101.logId, this.f567848c);
            goto L24
        L22:
            MultiLinkEventModule r105 = zi0.b.f572218a;
            zi0.b.e(false, r101.logId, this.f567848c);
        L24:
            if (this.f567847b == true) goto L26;
            String r106 = "静音";
        L27:
            ALogger.i(LinkRoomFightContext.TAG, r106.concat("对方成功"));
            return;
        L26:
            r106 = "解除";
            goto L27
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r107 == null) goto L16;
            d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r103.getLooper()) goto L7;
            r103.post(DialogLancet.createDismissRunnable(r102));
            goto L18
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f567849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f567850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f567851c;

        public b(a r100, boolean r101, long r102) {
            this.f567849a = r100;
            this.f567850b = r101;
            this.f567851c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ExceptionUtils.handleException(this.f567849a.getContext(), r101);
            if (this.f567849a.f567845d == false) goto L9;
            if (this.f567850b == true) goto L7;
            MultiLinkEventModule r102 = zi0.b.f572218a;
            zi0.b.d(true, r101, this.f567851c);
            goto L9
        L7:
            MultiLinkEventModule r103 = zi0.b.f572218a;
            zi0.b.d(false, r101, this.f567851c);
        L9:
            if (this.f567850b == true) goto L11;
            String r104 = "静音";
        L12:
            ALogger.e(LinkRoomFightContext.TAG, r104.concat("对方失败"), r101);
            return;
        L11:
            r104 = "解除";
            goto L12
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable r100 = this.f567843b;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public static void a(a r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = r100.getId();
        if (r101 != R.id.watch_profile) goto L9;
        xs2.b.a().post(new UserProfileEvent(this.f567844c.getUser()).setClickUserPosition(UserProfileEvent.POSITION_LINKED_AUDIENCE_MULTIAUDIENCE).setReportSource("audience_audio").setReportType(UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE_MULTIAUDIENCE));
        if (this.f567845d == false) goto L7;
        g2 r102 = zi0.d.f572224b;
        zi0.d.d(this.f567844c, "profile");
    L7:
        a(this);
        return;
    L9:
        if (r101 != R.id.set_silence_peer_room) goto L33;
        m<IRoom> r103 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r103 == null) goto L15;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L15;
        Long r105 = Long.valueOf(r104.getRoomId());
    L16:
        long r106 = this.f567844c.getLinkRoomId();
        if (this.f567844c.getRoomLinkSilenceStatus() != 1) goto L19;
        boolean r107 = true;
    L20:
        if (r105 == null) goto L25;
        if (r107 == true) goto L23;
        Single r108 = ((LinkApi) c.b().e(LinkApi.class)).silenceLinkRoom(r105.longValue(), r106, 2);
    L24:
        long r109 = System.currentTimeMillis();
        r108.compose(RxUtil.rxSchedulerHelper()).subscribe(new C8344a(this, r107, r109), new b(this, r107, r109));
        goto L25
    L23:
        r108 = ((LinkApi) c.b().e(LinkApi.class)).unSilenceLinkRoom(r105.longValue(), r106, 1);
    L25:
        a(this);
        if (this.f567845d == false) goto L37;
        g2 r110 = zi0.d.f572224b;
        ILinkPlayerInfoBridge r111 = this.f567844c;
        if (r107 == false) goto L30;
        String r112 = "unmute";
    L31:
        zi0.d.d(r111, r112);
        return;
    L30:
        r112 = ITTVideoEngineEventSource.KEY_MUTE;
        goto L31
    L37:
        return;
    L19:
        r107 = false;
    L15:
        r105 = null;
        goto L16
    L33:
        if (r101 != R.id.cancel) goto L39;
        a(this);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_link_room_linkmic_operation, null));
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setGravity(80);
        r101.setLayout(-1, -2);
    L5:
        TextView r102 = (TextView) findViewById(R.id.hint);
        boolean r103 = true;
        Object[] r104 = new Object[1];
        IBaseUser r105 = this.f567844c.getUser();
        if (r105 == null) goto L9;
        String r106 = r105.getNickName();
        if (r106 == null) goto L9;
    L10:
        r104[0] = r106;
        r102.setText(s1.C(R.string.ttlive_interact_link_room_fight_linkmic_operation_title, r104));
        ((TextView) findViewById(R.id.hint)).setOnClickListener(this);
        ((TextView) findViewById(R.id.watch_profile)).setOnClickListener(this);
        ((TextView) findViewById(R.id.set_silence_peer_room)).setOnClickListener(this);
        Map.Entry<Long, ? extends g2> r107 = tc0.c.h().f545359p;
        if (r107 == null) goto L17;
        g2 r108 = r107.getValue();
        if (r108 == null) goto L17;
        if (r108.getRoomLinkSilenceStatus() != 1) goto L17;
    L18:
        TextView r109 = (TextView) findViewById(R.id.set_silence_peer_room);
        if (r103 == true) goto L21;
        String r110 = s1.B(R.string.ttlive_interact_link_room_fight_linkmic_operation_silence_peer_room);
    L22:
        r109.setText(r110);
        return;
    L21:
        r110 = s1.B(R.string.ttlive_interact_link_room_fight_linkmic_operation_unsilence_peer_room);
    L17:
        r103 = false;
    L9:
        r106 = "";
        goto L10
    }

    public a(Context r100, ILinkPlayerInfoBridge r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "userInfo");
        super(r100, true);
        this.f567844c = r101;
        this.f567845d = r102;
        this.f567843b = new CompositeDisposable();
        y r103 = (y) ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
    }
}
