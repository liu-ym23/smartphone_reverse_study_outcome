package qa2;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.HotMsgType;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.ConfrontType;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import nm1.m;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements f52.d, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f52.b f532238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f52.j<g3> f532239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f52.j<g3> f532240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f532241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f532242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f532243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f532244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f532245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f532246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f532247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f532248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f532249l;

    public static final class a extends IHostAppMonitorListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f532250a;

        public a(k r100) {
            this.f532250a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            this.f532250a.f532246i = r100;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f532251a;

        public b(k r100) {
            this.f532251a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            k r102 = this.f532251a;
            com.bytedance.android.livesdk.interactivity.api.quickcomment.e.f133749a.getClass();
            if (r101 != null) goto L6;
        L7:
            if (r101 != null) goto L10;
        L11:
            boolean r103 = true;
        L13:
            r102.f532242e = r103;
            return;
        L10:
            if (r101.intValue() != 3) goto L11;
        L12:
            r103 = false;
            goto L13
        L6:
            if (r101.intValue() == 2) goto L12;
            goto L7
        }
    }

    @Override // f52.d
    public final void onUnload() {
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(this.f532248k + " onUnload");
        this.f532240c = null;
        this.f532239b = null;
        this.f532241d.clear();
        Lazy r100 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().b(this.f532247j);
    }

    @Override // f52.d
    public final String getId() {
        return this.f532248k;
    }

    public k(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f532249l = r100;
        this.f532241d = new CompositeDisposable();
        this.f532242e = true;
        this.f532244g = 60000;
        this.f532247j = new a(this);
        this.f532248k = "MatchMsgViewManager";
    }

    @Override // f52.d
    public final void j(f52.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(this.f532248k + " onLoad");
        this.f532238a = r100;
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r101 == null) goto L13;
        o r102 = IRoomContextService.a.a(r101, null, 0, 2);
        if (r102 == null) goto L13;
        com.bytedance.live.datacontext.j<vlc.d> r103 = r102.getMessageManager();
        if (r103 == null) goto L13;
        vlc.d r104 = r103.getValue();
        if (r104 == null) goto L13;
        Disposable r105 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.c(r104, "WebcastMatchHotMessage", this);
        if (r105 == null) goto L13;
        RxUtilKt.c(r105, this.f532241d);
    L13:
        Lazy r106 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().a(this.f532247j);
        com.bytedance.android.livesdk.interactivity.api.h r107 = com.bytedance.android.livesdk.interactivity.api.i.b(r100.getDataCenter(), 1);
        if (r107 == null) goto L25;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r108 = r107.getQuickCommentManager();
        if (r108 == null) goto L26;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r109 = r108.getValue();
        if (r109 == null) goto L27;
        com.bytedance.android.live.core.arch.mvvm.d<Integer> r110 = r109.getQuickCommentType();
        if (r110 == null) goto L28;
        Disposable r111 = r110.subscribe(new b(this));
        if (r111 == null) goto L29;
        RxUtilKt.c(r111, this.f532241d);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(this.f532248k + " receive msg");
        if ((r110 instanceof g3) == false) goto L151;
        g3 r100 = (g3) r110;
        if (this.f532242e == false) goto L48;
        if (this.f532246i == true) goto L48;
        m r101 = pm1.f.l();
        if (r101 == null) goto L18;
        f52.b r102 = this.f532238a;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L15:
        if (r101.y(r102.getDataCenter()) != true) goto L18;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("refuse msg cuzz in matchsubcamera");
    L52:
        boolean r103 = false;
    L53:
        if (r103 == true) goto L55;
        return;
    L55:
        if (r100.getMsgType() != HotMsgType.ConfrontMsg.getId()) goto L145;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("dispatchConfrontMsg id=" + r100.getMessageId());
        int r104 = r100.getGroup();
        int r105 = ConfrontType.MainGroup.getId();
        ra2.a r106 = ra2.a.f536811a;
        Long r111 = null;
        String r112 = null;
        Long r113 = null;
        Long r114 = null;
        if (r104 != r105) goto L90;
        PriorityBlockingQueue<g3> r107 = ra2.b.f536812a;
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (ra2.b.f536812a != null) goto L61;
        ra2.b.f536812a = new PriorityBlockingQueue(11, r106);
    L61:
        g3 r108 = ra2.b.f536814c;
        if (r108 == null) goto L72;
        String r109 = r108.getContent();
        if (r109 == null) goto L72;
        if (r109.equals(r100.getContent()) == true) goto L72;
        StringBuilder r115 = new StringBuilder("confrontView is showing, refuse msg because of content is unfit. CurShow msg content is ");
        g3 r116 = ra2.b.f536814c;
        if (r116 == null) goto L70;
        r112 = r116.getContent();
    L70:
        r115.append(r112);
        r115.append(". Received msg's content is ");
        r115.append(r100.getContent());
        r115.append(", type is ");
        r115.append(r100.getMsgType());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r115.toString());
    L126:
        PriorityBlockingQueue<g3> r117 = ra2.b.f536812a;
        if (r117 != null) goto L129;
    L135:
        boolean r118 = false;
    L136:
        if (r118 == true) goto L139;
        return;
    L139:
        if (this.f532239b != null) goto L153;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("start running ConfrontView");
        i r119 = new i(this);
        f52.b r120 = this.f532238a;
        if (r120 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L143:
        r120.a(new d(this.f532249l, r100, r119));
        return;
    L153:
        return;
    L129:
        if ((!r117.isEmpty()) != true) goto L135;
        PriorityBlockingQueue<g3> r121 = ra2.b.f536813b;
        if (r121 == null) goto L135;
        if ((!r121.isEmpty()) != true) goto L135;
        r118 = true;
    L72:
        if (ra2.b.f536814c == null) goto L87;
        long r122 = r100.getCount();
        g3 r123 = ra2.b.f536814c;
        if (r123 == null) goto L76;
        long r124 = r123.getCount();
    L78:
        if (r122 >= r124) goto L87;
        StringBuilder r125 = new StringBuilder("confrontView is showing, refuse msg because of msg's count is smaller than curshow. CurShow msg content is ");
        g3 r126 = ra2.b.f536814c;
        if (r126 == null) goto L82;
        String r127 = r126.getContent();
    L83:
        r125.append(r127);
        r125.append(", count is ");
        g3 r128 = ra2.b.f536814c;
        if (r128 == null) goto L86;
        r113 = Long.valueOf(r128.getCount());
    L86:
        r125.append(r113);
        r125.append(".  Received msg's content is ");
        r125.append(r100.getContent());
        r125.append(", type is ");
        r125.append(r100.getMsgType());
        r125.append(", seqid is ");
        r125.append(r100.getSequenceId());
        r125.append(", count is ");
        r125.append(r100.getCount());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r125.toString());
        goto L126
    L82:
        r127 = null;
        goto L83
    L76:
        r124 = 0;
    L87:
        PriorityBlockingQueue<g3> r129 = ra2.b.f536812a;
        if (r129 == null) goto L126;
        r129.add(r100);
        goto L126
    L90:
        PriorityBlockingQueue<g3> r130 = ra2.b.f536812a;
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (ra2.b.f536813b != null) goto L93;
        ra2.b.f536813b = new PriorityBlockingQueue(11, r106);
    L93:
        g3 r131 = ra2.b.f536815d;
        if (r131 == null) goto L108;
        String r132 = r131.getContent();
        if (r132 == null) goto L108;
        if (r132.equals(r100.getContent()) == true) goto L108;
        StringBuilder r133 = new StringBuilder("confrontView is showing, refuse msg because of content is unfit. CurShow msg content is ");
        g3 r134 = ra2.b.f536815d;
        if (r134 == null) goto L102;
        String r135 = r134.getContent();
    L103:
        r133.append(r135);
        r133.append(", count is ");
        g3 r136 = ra2.b.f536815d;
        if (r136 == null) goto L106;
        r114 = Long.valueOf(r136.getCount());
    L106:
        r133.append(r114);
        r133.append(". Received msg's content is ");
        r133.append(r100.getContent());
        r133.append(", type is ");
        r133.append(r100.getMsgType());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r133.toString());
        goto L126
    L102:
        r135 = null;
    L108:
        if (ra2.b.f536815d == null) goto L123;
        long r137 = r100.getCount();
        g3 r138 = ra2.b.f536815d;
        if (r138 == null) goto L112;
        long r139 = r138.getCount();
    L114:
        if (r137 >= r139) goto L123;
        StringBuilder r140 = new StringBuilder("confrontView is showing, refuse msg because of msg's count is smaller than curshow.CurShow msg content is ");
        g3 r141 = ra2.b.f536815d;
        if (r141 == null) goto L118;
        String r142 = r141.getContent();
    L119:
        r140.append(r142);
        r140.append(", count is ");
        g3 r143 = ra2.b.f536815d;
        if (r143 == null) goto L122;
        r111 = Long.valueOf(r143.getCount());
    L122:
        r140.append(r111);
        r140.append(". Received msg's content is ");
        r140.append(r100.getContent());
        r140.append(", type is ");
        r140.append(r100.getMsgType());
        r140.append(", seqid is ");
        r140.append(r100.getSequenceId());
        r140.append(", count is ");
        r140.append(r100.getCount());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r140.toString());
        goto L126
    L118:
        r142 = null;
        goto L119
    L112:
        r139 = 0;
    L123:
        PriorityBlockingQueue<g3> r144 = ra2.b.f536813b;
        if (r144 == null) goto L126;
        r144.add(r100);
        goto L126
    L145:
        if (r100.getMsgType() != HotMsgType.AggregateMsg.getId()) goto L155;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("dispatchMatchHotMsg id=" + r100.getMessageId());
        j r145 = new j(this);
        f52.b r146 = this.f532238a;
        if (r146 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L149:
        r146.a(new h(this.f532249l, r100, r145));
        return;
    L155:
        return;
    L18:
        if (v.a() == false) goto L23;
        if (r100.getTriggerTimestamp() != (-10086)) goto L23;
        r100.setTriggerTimestamp(System.currentTimeMillis());
    L23:
        if (r100.getMsgType() != HotMsgType.ConfrontMsg.getId()) goto L28;
        if ((System.currentTimeMillis() - this.f532243f) >= this.f532244g) goto L45;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of freeze time, msg type is " + r100.getMsgType() + ", content is " + r100.getContent() + ", seqId is " + r100.getSequenceId());
    L45:
        r103 = true;
        goto L53
    L28:
        if (r100.getMsgType() == HotMsgType.AggregateMsg.getId()) goto L30;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of unknown msg, receive msg type is " + r100.getMsgType() + ", content is " + r100.getContent() + ", seqId is " + r100.getSequenceId());
        goto L52
    L30:
        if (this.f532239b == null) goto L33;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of ConfrontView is showing, cur msg type is " + r100.getMsgType() + ", content is " + r100.getContent() + ", seqId is " + r100.getSequenceId());
        goto L52
    L33:
        if (this.f532240c == null) goto L35;
        boolean r147 = true;
    L37:
        if (r147 == false) goto L39;
    L41:
        if (r147 == false) goto L45;
        if (r100.getTriggerTimestamp() >= this.f532245h) goto L45;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of MatchHotMsgView is running. triggerTimestamp is smaller than cur msg's timestamp. Receive msg: " + r100.getMsgType() + ", content is " + r100.getContent() + ", seqId is " + r100.getSequenceId() + ", triggerTimestamp is " + r100.getTriggerTimestamp() + '.');
        goto L52
    L39:
        if (r100.getTriggerTimestamp() > this.f532245h) goto L41;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of triggerTimestamp is smaller than or equal the lastHotMsgTriggerTimeStamp, cur msg: type is " + r100.getMsgType() + ", content is " + r100.getContent() + ", seqId is " + r100.getSequenceId() + ", triggerTimestamp is " + r100.getTriggerTimestamp() + '.');
        goto L52
    L35:
        r147 = false;
    L48:
        if (this.f532246i == false) goto L50;
        String r148 = "refuse msg because of is in background!";
    L51:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r148);
        goto L52
    L50:
        r148 = "refuse msg because of msgReceiveOrShowChanger is off !";
        goto L51
    }
}
