package com.bytedance.android.livesdk.ktvimpl.realtimechorus.pcChorus;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.m;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.KtvJsbDataContext;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.ConcertTuner;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.d;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusPlayerProxy;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import fd2.e;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import vb6.f;
import vb6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/pcChorus/PcAudioChorusWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PcAudioChorusWidget extends PlatformMultiLinkWidget implements Observer<KVData> {
    public e a;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a b;
    public final CompositeDisposable c;
    public d d;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b e;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a f;
    public String g;
    public com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a h;
    public final b i;

    public static final class a {
    }

    public static final class b implements f {
        public final /* synthetic */ PcAudioChorusWidget a;

        public final void Am(ei6.a r1, int r2, long r3, Exception r5) {
        }

        public final void E2() {
        }

        public final void X1(int r1, int r2, Exception r3) {
        }

        public final void Y4() {
        }

        public final void k4() {
        }

        public final void q2(int r1, int r2, int r3) {
        }

        public final void ra() {
        }

        public final void s1() {
        }

        public final void t1() {
        }

        public final void H1() {
            PcAudioChorusWidget r0 = this.a;
            r0.h = new KtvEarMonitor(this.a);
            com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a r1 = this.a.h;
            if (r1 == null) goto L5;
            r1.init();
        L5:
            com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a r2 = this.a.h;
            if (r2 == null) goto L9;
            r2.f(false);
            return;
        }

        public final void M1() {
            com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a r0 = this.a.h;
            if (r0 == null) goto L5;
            r0.e();
        L5:
            com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a r1 = this.a.h;
            if (r1 == null) goto L8;
            r1.release();
        L8:
            this.a.h = null;
        }

        public b(PcAudioChorusWidget r1) {
            this.a = r1;
        }

        public final void H4(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void M4(cc6.b r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final ec6.a O2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
            return null;
        }

        public final void Ra(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void ag(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void fe(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void y1(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void z2(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void C2(long r1, ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        public final void F2(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void Fk(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void I2(ei6.a r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "client");
            Intrinsics.checkNotNullParameter(r3, "source");
            f.a.b(r2, r3);
        }

        public final void U8(long r1, ExtraResponse<IApplyResult, Extra> r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        public final void W(long r1, OperateType r3) {
            Intrinsics.checkNotNullParameter(r3, "operationType");
            Intrinsics.checkNotNullParameter(r3, "operationType");
        }

        public final void Wb(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void Xf(long r1, ExtraResponse<? extends g1, Extra> r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        public final void Zk(long r1, ei6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            int r2 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(this.a.g) == false) goto L8;
            si6.b r4 = r3.b();
            if (r4 == null) goto L9;
            r4.r(this.a.g);
            return;
        L9:
            return;
        }

        public final void bp(long r1, ExtraResponse<LinkFinishResult, Extra> r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        public final void lf(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void o1(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void t5(ec6.a r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "client");
            Intrinsics.checkNotNullParameter(r3, "source");
            f.a.a(r2, r3);
        }

        public final void u4(long r1, ec6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            Intrinsics.checkNotNullParameter(r3, "client");
            Intrinsics.checkNotNullParameter(r3, "client");
        }

        public final void uf(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void wn(long r1, ExtraResponse<m, Extra> r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        public final void yp(long r1, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r3, "throwable");
        }

        public final void c1(long r1, OperateType r3, BaseCheckException r4) {
            Intrinsics.checkNotNullParameter(r3, "operationType");
            Intrinsics.checkNotNullParameter(r4, "exception");
            Intrinsics.checkNotNullParameter(r3, "operationType");
            Intrinsics.checkNotNullParameter(r4, "exception");
        }

        public final void vc(ei6.a r1, int r2, long r3, Object... r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r5, "params");
        }
    }

    static {
    }

    public PcAudioChorusWidget() {
        this.c = new CompositeDisposable();
        this.g = "";
        this.i = new b(this);
    }

    public final int getScene() {
        return je0.d.f();
    }

    public final void onCreate() {
        super.onCreate();
        ((Widget) this).dataCenter.observe(ChorusJsbDataContext.CMD_RUNTIME_PARAMETERS_ON_LINK, this);
        ((Widget) this).dataCenter.observe(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE, this);
        this.b = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a(((Widget) this).dataCenter, "chorus_concert", this);
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        g r1 = r0.O5();
        if (r1 == null) goto L7;
        r1.X0(this.i, true);
    L7:
        d r2 = new d(this);
        this.d = r2;
        r2.d = false;
        ConcertTuner r3 = new ConcertTuner(((Widget) this).context, r2);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r4 = this.b;
        e r5 = null;
        if (r4 == null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a r6 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a(r3, r4);
    L11:
        this.f = r6;
        ChorusJsbDataContext r7 = ChorusJsbDataContext.Companion.getContext();
        if (r7 == null) goto L16;
        j<e> r8 = r7.getService();
        if (r8 == null) goto L16;
        r5 = (e) r8.getValue();
    L16:
        this.a = r5;
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a r9 = this.f;
        Intrinsics.checkNotNull(r9);
        r5.n1(r9);
    L19:
        e r10 = this.a;
        if (r10 == null) goto L22;
        r10.p1(r3);
    L22:
        e r11 = this.a;
        if (r11 == null) goto L25;
        d r12 = this.d;
        Intrinsics.checkNotNull(r12);
        r11.q1(r12);
    L25:
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r13 == null) goto L31;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L31;
        String r15 = r14.getIdStr();
        if (r15 == null) goto L31;
    L32:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.b r16 = new com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.b(new VideoChorusPlayerProxy(r15, this), this);
        Pair r17 = com.bytedance.live.datacontext.d.a(PcAudioChorusWidget$initKtvJsbDataContext$pair$1.INSTANCE);
        KtvJsbDataContext r18 = (KtvJsbDataContext) r17.getFirst();
        r18.isFeed().d(Boolean.FALSE);
        r18.getService().d(r16);
        com.bytedance.live.datacontext.b.a(r18, KtvJsbDataContext.TAG_FOR_LIVE);
        this.c.add((Disposable) r17.getSecond());
        return;
    L31:
        r15 = "";
        goto L32
    L10:
        r6 = null;
        goto L11
    }

    public final void onDestroy() {
        super.onDestroy();
        this.c.clear();
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.o1();
    L5:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r1 = this.b;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        d r2 = this.d;
        if (r2 == null) goto L15;
        ((LinkedHashMap) r2.c).clear();
        cg6.a r3 = r2.k();
        if (r3 == null) goto L15;
        hg6.g r4 = r3.getRtcManager();
        if (r4 == null) goto L15;
        r4.Z(r2.f);
    L15:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r5 = this.e;
        if (r5 != null) goto L18;
    L35:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a r6 = this.h;
        if (r6 == null) goto L38;
        r6.release();
    L38:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L41;
        r7.removeObserver(this);
    L41:
        cg6.a r8 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r8 == null) goto L47;
        g r9 = r8.O5();
        if (r9 == null) goto L48;
        r9.a1(this.i);
        return;
    L48:
        return;
    L47:
        return;
    L18:
        if (r5.c != true) goto L35;
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r10 == null) goto L24;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L24;
        long r12 = r11.getId();
    L25:
        long r13 = r12;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r14 = this.e;
        if (r14 == null) goto L29;
        String r15 = r14.a;
        if (r15 == null) goto L29;
    L30:
        String r16 = r15;
        if (r14 == null) goto L33;
        int r17 = r14.b;
    L34:
        ((RealTimeChorusApi) c.b().e(RealTimeChorusApi.class)).leaveChorus(r13, r16, 1, r17);
        goto L35
    L33:
        r17 = 0;
    L29:
        r15 = BDLocationException.ERROR_TIMEOUT;
    L24:
        r12 = 0;
        goto L25
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        String r0 = r6.getKey();
        int r1 = r0.hashCode();
        Object r3 = null;
        if (r1 == (-1238735384)) goto L18;
        if (r1 == (-1012021519)) goto L8;
        return;
    L8:
        if (r0.equals(ChorusJsbDataContext.CMD_RUNTIME_PARAMETERS_ON_LINK) == false) goto L25;
        Object r7 = r6.getData();
        if ((r7 instanceof String) == false) goto L13;
        r3 = r7;
    L13:
        String r4 = (String) r3;
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        this.g = r4;
        return;
    L25:
        return;
    L18:
        if (r0.equals(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE) == false) goto L27;
        Object r8 = r6.getData();
        if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b) == false) goto L23;
        r3 = r8;
    L23:
        this.e = (com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b) r3;
        return;
    }
}
