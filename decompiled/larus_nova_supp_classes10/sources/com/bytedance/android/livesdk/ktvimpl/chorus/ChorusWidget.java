package com.bytedance.android.livesdk.ktvimpl.chorus;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.model.ChorusInfo;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.ktvimpl.chorus.api.ChorusApi;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/chorus/ChorusWidget;", "Lfd2/f;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusWidget extends MiddlewareRoomWidget implements fd2.f, Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public ChorusContext a;
    public ChorusViewModel b;
    public final CompositeDisposable c;
    public final e d;
    public final d e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", "closeChorus success");
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", "closeChorus failed " + ((Throwable) r3).getMessage());
        }
    }

    public static final class d implements p.a {
        public d() {
        }

        public final void c(MusicPanel r1, int r2) {
        }

        public final void a(MusicPanel r1, String r2, String r3) {
            StringBuilder r4 = new StringBuilder("download music ");
            if (r1 == null) goto L7;
            KtvMusic r5 = r1.a;
            if (r5 == null) goto L7;
            String r6 = r5.getMTitle();
        L8:
            r4.append(r6);
            r4.append(" successed");
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", r4.toString());
            return;
        L7:
            r6 = null;
            goto L8
        }

        public final void b(MusicPanel r2, int r3, String r4) {
            StringBuilder r5 = new StringBuilder("download music ");
            if (r2 == null) goto L7;
            KtvMusic r6 = r2.a;
            if (r6 == null) goto L7;
            String r7 = r6.getMTitle();
        L8:
            r5.append(r7);
            r5.append(" failed errorCode: ");
            r5.append(r3);
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", r5.toString());
            return;
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class e extends xh0.a {
        public final /* synthetic */ ChorusWidget a;

        public final ArrayList<xh0.f> getIncompatibleSourceList() {
            return CollectionsKt.arrayListOf(new xh0.f[]{new xh0.f(IncompatibleTag.PLAY_MODE, 29)});
        }

        public final xh0.h getPlayModeInfo() {
            return new xh0.h(23, s1.B(2131923569));
        }

        public final boolean isOpen() {
            return ChorusContext.Companion.c();
        }

        public e(ChorusWidget r1) {
            this.a = r1;
        }

        public final void tryStartPlayMode(HashMap<String, Object> r3) {
            Long r4 = (Long) r3.get("channelId");
            if (r4 == null) goto L6;
            long r0 = r4.longValue();
            this.a.Xj(r0);
            return;
        }

        public final void tryStopPlayMode(HashMap<String, Object> r4) {
            Long r5 = (Long) r4.get("channelId");
            if (r5 == null) goto L6;
            long r0 = r5.longValue();
            this.a.xk(r0, 1);
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ChorusWidget a;

        public f(ChorusWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L10;
            boolean r4 = r3.booleanValue();
            ChorusContext r0 = this.a.a;
            if (r0 == null) goto L11;
            n<Boolean> r1 = r0.getChorusOpenStatus();
            if (r1 == null) goto L12;
            r1.setValue(Boolean.valueOf(r4));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", "startChorus success");
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r3) {
            ApiServerException r4 = (Throwable) r3;
            if ((r4 instanceof ApiServerException) == true) goto L5;
            ApiServerException r0 = null;
        L6:
            ApiServerException r1 = r0;
            if (r1 == null) goto L9;
            f2.c(r1.getPrompt(), 0);
        L9:
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", "startChorus failed " + r4.getMessage());
            return;
        L5:
            r0 = r4;
            goto L6
        }
    }

    static {
    }

    public final boolean Pp() {
        ChorusViewModel r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        Boolean r1 = (Boolean) r0.getOpenStatus().getValue();
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.booleanValue();
    }

    public final com.bytedance.android.live.liveinteract.model.a getChorusInfo() {
        ChorusViewModel r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return (com.bytedance.android.live.liveinteract.model.a) r0.getChorusInfo().getValue();
    }

    public final int i0() {
        String r0 = k.n(IMiddlewareUserService.class).user().n().toString();
        ChorusViewModel r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        ChorusInfo r2 = (ChorusInfo) r1.getChorusInfo().getValue();
        if (r2 == null) goto L8;
        String r3 = r2.getLeadSingerIdString();
    L10:
        if (Intrinsics.areEqual(r3, r0) == false) goto L13;
        return 1;
    L13:
        if (a0.d(((Widget) this).dataCenter, false) != true) goto L15;
        return 2;
    L15:
        return 0;
    L8:
        r3 = null;
        goto L10
    }

    public ChorusWidget() {
        this.c = new CompositeDisposable();
        this.d = new e(this);
        this.e = new d();
    }

    public final void onCreate() {
        super.onCreate();
        ChorusViewModel r0 = new ChorusViewModel(((Widget) this).dataCenter);
        this.b = r0;
        r0.getOpenStatus().observe(this, new f(this));
        Pair r1 = com.bytedance.live.datacontext.d.a(ChorusWidget$initDataContext$pair$1.INSTANCE);
        ChorusContext r2 = (ChorusContext) r1.getFirst();
        r2.getService().d(this);
        com.bytedance.live.datacontext.b.a(r2, ChorusContext.class);
        this.a = r2;
        Intrinsics.checkNotNull(r2);
        j<ChorusViewModel> r3 = r2.getChorusViewModel();
        ChorusViewModel r4 = this.b;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r3.d(r4);
        ChorusContext r5 = this.a;
        Intrinsics.checkNotNull(r5);
        RxUtilKt.c(r5.getChorusSelectedSongList().a().subscribe(new com.bytedance.android.livesdk.ktvimpl.chorus.f(this)), this.c);
        this.c.add((Disposable) r1.getSecond());
        if (a0.d(((Widget) this).dataCenter, false) == true) goto L37;
        z5 r6 = com.bytedance.android.live.ktv.common.util.a.c().getLinkerDetail();
        if (r6 == null) goto L31;
        List<Long> r7 = r6.getPlayModes();
        if (r7 == null) goto L31;
        if (r7.contains(Long.valueOf(23)) != true) goto L31;
        ChorusViewModel r8 = this.b;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L16:
        r8.getOpenStatus().setValue(Boolean.TRUE);
        u r9 = m.e(this);
        if (r9 == null) goto L23;
        j r10 = r9.J();
        if (r10 == null) goto L23;
        LivePlayModeLogContext r11 = (LivePlayModeLogContext) r10.getValue();
        if (r11 == null) goto L23;
        r11.addPlayMode(23);
    L23:
        o r12 = m.j(this);
        if (r12 == null) goto L31;
        com.bytedance.live.datacontext.m r13 = r12.getRoom();
        if (r13 == null) goto L31;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L31;
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).fetchPlayModeInfo(r14.getRoomId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.chorus.d(this), new com.bytedance.android.livesdk.ktvimpl.chorus.e(this)), this.c);
    L31:
        if (Pp() == false) goto L37;
        ChorusViewModel r15 = this.b;
        if (r15 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L35:
        if (r15 == null) goto L37;
        r15.initChorusSongList();
    L37:
        xh0.d r16 = k.n(IInteractService.class).getPlayModeService();
        if (r16 == null) goto L40;
        r16.c(this.d);
    L40:
        ((Widget) this).dataCenter.observe("data_link_state", this);
    }

    public final void onDestroy() {
        if (KtvSettingHelper.r().booleanValue() == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.removeObserver(this);
    L8:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixDataCenter() == false) goto L12;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L12;
        r1.removeObserver(this);
    L12:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        xh0.d r2 = k.n(IInteractService.class).getPlayModeService();
        if (r2 == null) goto L15;
        r2.i(this.d);
    L15:
        this.c.dispose();
        ChorusViewModel r3 = this.b;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L19:
        if (Intrinsics.areEqual((Boolean) r3.getOpenStatus().getValue(), Boolean.TRUE) == false) goto L24;
        if (a0.d(((Widget) this).dataCenter, false) == true) goto L24;
        com.bytedance.android.livesdk.ktvimpl.chorus.c.e();
    L24:
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L27;
        ((Widget) this).widgetCallback = null;
        return;
    }

    public final void Xj(long r5) {
        o r0 = m.j(this);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L12;
        long r3 = r2.getRoomId();
        RxUtilKt.c(((ChorusApi) com.bytedance.android.live.network.c.b().e(ChorusApi.class)).openChorus(r3, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(g.a, h.a), this.c);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (r10 == null) goto L5;
        String r11 = r10.getKey();
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.hashCode() == 872172481) goto L12;
        return;
    L12:
        if (r11.equals("data_link_state") == false) goto L36;
        Integer r12 = (Integer) ((Widget) this).dataCenter.get("data_link_state", 0);
        if (Pp() == true) goto L16;
        return;
    L16:
        if (v.a(r12.intValue(), 4) == false) goto L18;
        return;
    L18:
        if (v.a(r12.intValue(), 64) == false) goto L20;
        return;
    L20:
        if (a0.d(((Widget) this).dataCenter, false) == false) goto L40;
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a("ChorusWidget", "close chorus reveal all the details");
        o r13 = m.j(this);
        if (r13 == null) goto L41;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L42;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L43;
        long r1 = r15.getRoomId();
        long r3 = k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId();
        ChorusViewModel r16 = this.b;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L30:
        ChorusInfo r17 = (ChorusInfo) r16.getChorusInfo().getValue();
        if (r17 == null) goto L33;
        long r5 = r17.getChorusId();
    L34:
        ChorusApi r0 = (ChorusApi) com.bytedance.android.live.network.c.b().e(ChorusApi.class);
        RxUtilKt.c(r0.closeChorus(r1, r3, 8, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(com.bytedance.android.livesdk.ktvimpl.chorus.g.a, com.bytedance.android.livesdk.ktvimpl.chorus.h.a), this.c);
        return;
    L33:
        r5 = 0;
        goto L34
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L36:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void xk(long r8, int r10) {
        o r0 = m.j(this);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L12;
        long r3 = r2.getRoomId();
        RxUtilKt.c(((ChorusApi) com.bytedance.android.live.network.c.b().e(ChorusApi.class)).closeChorus(r3, r8, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(b.a, c.a), this.c);
        return;
    L12:
        return;
    L11:
        return;
    }
}
