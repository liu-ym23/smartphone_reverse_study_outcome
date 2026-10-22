package tg1;

import android.content.Context;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.end.a1;
import com.bytedance.android.livesdk.chatroom.end.tabliveguide.view.LiveEndPageSkylightAdapter;
import com.bytedance.android.livesdk.chatroom.end.tabliveguide.view.LiveEndPgaeSkylightItemDecoration;
import com.bytedance.android.livesdk.chatroom.end.z0;
import com.bytedance.android.livesdk.chatroom.model.c0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.utils.f5;
import com.bytedance.android.livesdkapi.depend.message.PaidLiveTypeModifyData;
import com.bytedance.android.livesdkapi.depend.message.PreviewUserBlockMessage;
import com.bytedance.android.livesdkapi.depend.message.WebcastPaidLiveTypeModifyMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends sv2.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveEndPageSkylightAdapter f545829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final GestureDetector f545830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f545831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f5 f545832q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataCenter f545833r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f545834s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function0<Unit> f545835t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c0 f545836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f545837v;

    /* JADX INFO: renamed from: tg1.a$a, reason: collision with other inner class name */
    public static final class ViewOnTouchListenerC7721a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f545838a;

        public ViewOnTouchListenerC7721a(a r100) {
            this.f545838a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return this.f545838a.f545830o.onTouchEvent(r101);
        }
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f545839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f545840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ sv2.c f545841c;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f545839a.e("live_cover", this.f545840b.getIdStr(), this.f545840b.getOwnerUserIdString());
            this.f545839a.c(this.f545841c.f543643j);
            return true;
        }

        public b(a r100, Room r101, sv2.c r102) {
            this.f545839a = r100;
            this.f545840b = r101;
            this.f545841c = r102;
        }
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f545842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f545843b;

        public c(a r100, Room r101) {
            this.f545842a = r100;
            this.f545843b = r101;
        }

        @Override // vlc.l
        public final void onMessage(d r100) {
            if ((r100 instanceof WebcastPaidLiveTypeModifyMessage) == false) goto L14;
            WebcastPaidLiveTypeModifyMessage r101 = (WebcastPaidLiveTypeModifyMessage) r100;
            if (this.f545843b.f162599id != r101.getRoomId()) goto L27;
            PaidLiveTypeModifyData r102 = r101.paidLiveModifyData;
            if (r102 == null) goto L28;
            PrivilegeInfo r103 = r102.data;
            if (r103 != null) goto L11;
            return;
        L11:
            if (r103.paidLiveType != 101) goto L30;
            a.j(this.f545842a, "主播已切换为会员直播，去直播广场可看更多");
            return;
        L30:
            return;
        L28:
            return;
        L27:
            return;
        L14:
            if ((r100 instanceof ControlMessage) == false) goto L22;
            ControlMessage r104 = (ControlMessage) r100;
            if (r104.getAction() != 3) goto L19;
            a.j(this.f545842a, "当前直播关播，去直播广场可看更多");
        L19:
            if (r104.getAction() != 4) goto L32;
            a.j(this.f545842a, "当前房间被封禁，去直播广场可看更多");
            return;
        L32:
            return;
        L22:
            if ((r100 instanceof PreviewUserBlockMessage) == false) goto L34;
            long r105 = this.f545843b.f162599id;
            if (((PreviewUserBlockMessage) r100).baseMessage.roomId != r105) goto L35;
            a.j(this.f545842a, "当前直播异常，去直播广场可看更多");
            return;
        L35:
            return;
        }
    }

    public final void k() {
        ILivePlayerClient r100 = this.f543616a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        m();
        DataCenter r101 = this.f545833r;
        if (r101 == null) goto L8;
        r101.put("data_live_end_page_refresh", Boolean.TRUE);
    L8:
        this.f545833r = null;
        Function0<Unit> r102 = this.f545835t;
        if (r102 == null) goto L11;
        Unit r103 = r102.invoke();
    L11:
        this.f545835t = null;
        this.f545834s = false;
    }

    public final void l() {
        ILivePlayerClient r100 = this.f543616a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        m();
        this.f545833r = null;
        this.f545835t = null;
        this.f545834s = false;
    }

    public final void m() {
        f5 r100 = this.f545832q;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this.f545831p);
    L5:
        f5 r101 = this.f545832q;
        if (r101 == null) goto L8;
        r101.r(false);
    L8:
        f5 r102 = this.f545832q;
        if (r102 == null) goto L11;
        r102.release();
    L11:
        this.f545832q = null;
    }

    public final long getCurrentRoomId() {
        return this.f545837v;
    }

    public final c0 getResponse() {
        return this.f545836u;
    }

    public static final void j(a r100, String r101) {
        if (r100.f545834s == false) goto L5;
        f2.c(r101, 0);
    L5:
        r100.f545834s = false;
        DataCenter r102 = r100.f545833r;
        if (r102 == null) goto L8;
        r102.put("data_live_end_page_refresh", Boolean.TRUE);
    L8:
        Function0<Unit> r103 = r100.f545835t;
        if (r103 == null) goto L12;
        Unit r104 = r103.invoke();
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        boolean r102 = super.drawChild(r100, r101, r110);
        z0 r103 = (z0) ((LinkedHashMap) a1.f106031a).get(Long.valueOf(this.f545837v));
        if (r103 != null) goto L5;
    L7:
        return r102;
    L5:
        if (r103.f106202b == true) goto L7;
        r103.f106202b = true;
        j0.l().sendLog("livesdk_endlive_audience_relax_performance", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "radical_card_draw_child"), TuplesKt.to("costtime", String.valueOf(System.currentTimeMillis() - r103.f106201a))}), new Object[0]);
        goto L7
    }

    public a(Context r100, sv2.c r101, Room r102, c0 r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewParams");
        Intrinsics.checkNotNullParameter(r102, "firstRoom");
        Intrinsics.checkNotNullParameter(r103, "response");
        super(r100, r101, r102);
        this.f545836u = r103;
        this.f545837v = r104;
        this.f545830o = new GestureDetector(r100, new b(this, r102, r101));
        this.f545831p = new c(this, r102);
        d();
        List<Room> r105 = r103.c();
        if (r105 == null) goto L5;
        this.f545829n = new LiveEndPageSkylightAdapter(r105);
    L5:
        RecyclerView r106 = getSkylightRecyclerView();
        if (r106 == null) goto L8;
        r106.setAdapter(this.f545829n);
    L8:
        RecyclerView r107 = getSkylightRecyclerView();
        if (r107 == null) goto L11;
        r107.addItemDecoration(new LiveEndPgaeSkylightItemDecoration());
    L11:
        RecyclerView r108 = getSkylightRecyclerView();
        if (r108 == null) goto L14;
        r108.setOnTouchListener(new ViewOnTouchListenerC7721a(this));
    L14:
        String r109 = r103.b();
        if (r109 != null) goto L17;
        r109 = "";
    L17:
        a(r109, "");
        this.f545834s = true;
    }
}
