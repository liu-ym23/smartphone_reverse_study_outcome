package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import am2.x;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.CommonOrderSongViewModel;
import com.bytedance.android.live.ktv.common.search.viewmodel.CommonSearchViewModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.widget.widget.q;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.ww0;
import com.bytedance.android.livesdk.config.xw0;
import com.bytedance.android.livesdk.ktvapi.model.PanelType;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongHandler;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.viewmodel.KtvComponentOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.videochorus.VideoChorusFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.KtvDressViewModel;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.KtvJsbDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.VerticalDragFrameLayout;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.kd;
import com.bytedance.android.livesdk.message.model.t2;
import com.bytedance.android.livesdk.message.model.w2;
import com.bytedance.android.livesdk.message.model.z2;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import fd2.n;
import fd2.u;
import fd2.w;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/video/VideoChorusWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lfd2/w;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lfd2/u;", "Lvlc/l;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusWidget extends PlatformMultiLinkWidget implements Observer<KVData>, w, ViewModelStoreOwnerCompat, u, vlc.l {
    public static final /* synthetic */ int v = 0;
    public final Lazy a;
    public FrameLayout b;
    public VerticalDragFrameLayout c;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c d;
    public fd2.e e;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a f;
    public final CompositeDisposable g;
    public z0 h;
    public boolean i;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b j;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g k;
    public FrameLayout l;
    public Boolean m;
    public VideoChorusPlayerProxy n;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.a o;
    public Pair<? extends OrderedSongDataContext, ? extends Disposable> p;
    public Pair<? extends DataContext, ? extends Disposable> q;
    public KSongOrderSongDialog r;
    public q s;
    public final c t;
    public final b u;

    public static final class a {
    }

    public static final class b implements xb6.b {
        public final /* synthetic */ VideoChorusWidget a;

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> c() {
            return xb6.b.a.b();
        }

        public final Pair<Boolean, String> e() {
            return xb6.b.a.e();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> h() {
            return xb6.b.a.g();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public b(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final Pair<Boolean, String> d(z0 r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            if (r4.getSwitchToSilence() == false) goto L19;
            cg6.a r5 = this.a.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r5 == null) goto L9;
            vb6.g r6 = r5.O5();
            if (r6 == null) goto L9;
            yb6.e r7 = r6.j();
        L11:
            if (r7 == null) goto L13;
            r7.d0(StreamType.AUDIO, "handleKickOutMsg switchToSilence");
        L13:
            if (r7 == null) goto L15;
            r7.g0(false, "handleKickOutMsg switchToSilence");
        L15:
            if (r7 == null) goto L18;
            r7.v();
        L18:
            return new Pair(Boolean.TRUE, "chorus concert interceptPermitMsg");
        L9:
            r7 = null;
            goto L11
        L19:
            cg6.a r8 = this.a.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r8 == null) goto L25;
            vb6.g r9 = r8.O5();
            if (r9 == null) goto L25;
            r9.i1("leave chorus", false);
        L25:
            return new Pair(Boolean.TRUE, "video chorus");
        }

        public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.d(r2);
        }

        public final Pair<Boolean, String> j(z0 r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusWidget", "interceptPermitMsg  hasInitClient " + this.a.i);
            VideoChorusWidget r0 = this.a;
            if (r0.i == true) goto L5;
            r0.h = r4;
            return new Pair(Boolean.TRUE, "chorus concert interceptPermitMsg");
        L5:
            r0.i = false;
            return new Pair(Boolean.FALSE, "chorus concert interceptPermitMsg");
        }

        public final Pair<Boolean, String> l(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.m(r2);
        }

        public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "secToUserId");
            Intrinsics.checkNotNullParameter(r4, "toUserIdString");
            return xb6.b.a.j(r3, r4);
        }
    }

    public static final class c extends vb6.a {
        public final /* synthetic */ VideoChorusWidget a;

        public final void H1() {
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L10;
            VideoChorusWidget r0 = this.a;
            int r1 = VideoChorusWidget.v;
            ei6.a r2 = r0.Z0();
            if (r2 == null) goto L11;
            ChorusManager r3 = r2.i();
            if (r3 == null) goto L12;
            r3.b = true;
            return;
        L12:
            return;
        L11:
            return;
        }

        public c(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final void Zk(long r1, ei6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L10;
            VideoChorusWidget r2 = this.a;
            int r4 = VideoChorusWidget.v;
            ei6.a r5 = r2.Z0();
            if (r5 == null) goto L11;
            ChorusManager r6 = r5.i();
            if (r6 == null) goto L12;
            r6.b = true;
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ VideoChorusWidget a;

        public d(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            jd2.c r5 = (jd2.c) r4;
            VideoChorusWidget r0 = this.a;
            int r1 = VideoChorusWidget.v;
            r0.getClass();
            if (r5 == null) goto L30;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusWidget", "VideoChorusWidget ;; handleSingStateData, ktvSingStateData: " + r5);
            r0.yq(r5);
            int r2 = r5.a;
            if (r2 != 0) goto L8;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r6 = r0.k;
            if (r6 == null) goto L29;
            r6.g();
            return;
        L29:
            return;
        L8:
            if (r2 != 2) goto L10;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r3 = r0.k;
            if (r3 == null) goto L18;
            r3.d();
        L18:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r7 = r0.k;
            if (r7 == null) goto L27;
            r7.e(r5.b);
            return;
        L27:
            return;
        L10:
            if (r2 != 3) goto L31;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r8 = r0.k;
            if (r8 == null) goto L25;
            r8.c();
            return;
        L25:
            return;
        L31:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ VideoChorusWidget a;

        public e(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            jd2.c r6 = (jd2.c) r5;
            VideoChorusWidget r0 = this.a;
            int r1 = VideoChorusWidget.v;
            r0.getClass();
            if (r6 == null) goto L22;
            boolean r2 = r6.d.a;
            if ((!Intrinsics.areEqual(Boolean.valueOf(r2), r0.m)) == false) goto L14;
            r0.m = Boolean.valueOf(r2);
            FrameLayout r3 = r0.l;
            if (r3 == null) goto L13;
            if (r2 == false) goto L11;
            int r4 = 0;
        L12:
            r3.setVisibility(r4);
            goto L13
        L11:
            r4 = 8;
        L13:
            r0.Aq();
        L14:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusWidget", "handleSingProgressChange ktvSingStateData: " + r6);
            r0.yq(r6);
            if (r6.a != 2) goto L20;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r7 = r0.k;
            if (r7 == null) goto L21;
            r7.e(r6.b);
            return;
        L21:
            return;
        L20:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VideoChorusWidget a;

        public f(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final List r4 = (List) r3;
            VideoChorusWidget r0 = this.a;
            r0.zq();
            UtilityKotlinExtentionsKt.b(r0, new VideoChorusWidget$handleSongListChange$1(r4));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ VideoChorusWidget a;

        public g(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r15) {
            jd2.f r16 = (jd2.f) r15;
            if (r16 == null) goto L5;
            String r1 = r16.a;
        L7:
            if (Intrinsics.areEqual(r1, PanelType.ORDER_SONG_PANEL.getValue()) == false) goto L41;
            VideoChorusWidget r2 = this.a;
            String r3 = r16.b;
            Integer r4 = r16.c;
            String r5 = r16.d;
            int r17 = VideoChorusWidget.v;
            if (((Widget) r2).context == null) goto L45;
            r2.xq();
            com.bytedance.android.livesdk.ktvimpl.base.util.q.e();
            KtvComponentOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r18 = KtvComponentOrderSongDataContext.Companion.a();
            if (r18 == null) goto L15;
            r18.updateOrderSongExtraInfo(new td2.b(r3, new WeakReference(((Widget) r2).context)));
        L15:
            if (Intrinsics.areEqual(r3, "sing_song") == false) goto L17;
            String r19 = "component_btn_click";
        L18:
            FragmentActivity r6 = ((Widget) r2).context;
            if (r6 == null) goto L40;
            FragmentManager r7 = r6.getSupportFragmentManager();
            Fragment r8 = r7.findFragmentByTag("KSongOrderSongDialog");
            if ((r8 instanceof KSongOrderSongDialog) == true) goto L23;
            r8 = null;
        L23:
            KSongOrderSongDialog r9 = (KSongOrderSongDialog) r8;
            if (r9 != null) goto L26;
        L34:
            KSongOrderSongUtilKt.b(((Widget) r2).context, CloseOrderSongDialogSource.AUTO);
            int r10 = KSongOrderSongDialog.p;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r11 = KtvComponentOrderSongDataContext.Companion.a();
            int r12 = VideoChorusFirstLevelTabManager.q;
            VideoChorusFirstLevelTabManager r13 = new VideoChorusFirstLevelTabManager(r4, r5, ((Widget) r2).context, KtvComponentOrderSongDataContext.Companion.b(), KtvComponentOrderSongDataContext.Companion.c(), KtvComponentOrderSongDataContext.Companion.a(), KtvComponentOrderSongDataContext.Companion.e());
            r13.s();
            KSongOrderSongDialog r0 = KSongOrderSongDialog.a.a(r11, r13, null, 12);
            r0.setOnDismissListener(new m(r0));
            FragmentActivity r14 = ((Widget) r2).context;
            if (r14 == null) goto L38;
            VideoChorusWidget.wq(r0, r14.getSupportFragmentManager());
            pd2.d.n.getClass();
            pd2.d.G(r19, true);
            Unit r110 = Unit.INSTANCE;
            r2.r = r0;
            return;
        L38:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L26:
            if (r2.r == null) goto L34;
            if (r9.isAdded() == true) goto L30;
            VideoChorusWidget.wq(r9, r7);
            pd2.d.n.getClass();
            pd2.d.G(r19, true);
            return;
        L30:
            r9.m.c(r4, r5);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e.a.a(r9.m);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r20 = KtvComponentOrderSongDataContext.Companion.a();
            if (r20 == null) goto L33;
            r20.updateCurrentTabData();
        L33:
            KSongOrderSongDialog.aa0(r9, false, r19, 1);
            return;
        L40:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L17:
            r19 = "other";
            goto L18
        L45:
            return;
        L41:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ VideoChorusWidget a;

        public h(VideoChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final String r4 = ((pv0.c) r3).a;
            if (r4 == null) goto L6;
            UtilityKotlinExtentionsKt.b(this.a, new VideoChorusWidget$onCreate$7$1$1(r4));
            return;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ VideoChorusWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public i(VideoChorusWidget r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            VerticalDragFrameLayout r0 = this.a.c;
            if (r0 == null) goto L5;
            int r1 = this.b;
            int r2 = this.c;
            r0.d = r1;
            r0.e = r2;
        L5:
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.d > r0.e) goto L20;
            int r3 = (int) r0.getY();
            if (RangesKt.coerceIn(r3, r0.d, r0.e) != r3) goto L12;
            r0.setY(r3);
            return;
        L12:
            if (Math.abs(r3 - r0.d) > Math.abs(r3 - r0.e)) goto L14;
            int r4 = r0.d;
        L15:
            r0.setY(r4);
            return;
        L14:
            r4 = r0.e;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567577;
    }

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public final ei6.a Z0() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        return r1.V0();
    L7:
        return null;
    }

    public final n m1() {
        fd2.e r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m1();
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.livesdk.ktvimpl.base.download.a.c.getClass();
        com.bytedance.livesdk.ktvimpl.base.download.a.b();
        String r0 = gh0.a.c();
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L7;
        String r4 = r3.getOwnerUserIdString();
    L9:
        if (Intrinsics.areEqual(r0, r4) == true) goto L11;
    L13:
        KtvComponentOrderedSongDataContext r1 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r1 == null) goto L21;
        List<SongUniqueInfo> r5 = r1.getSelfKtvSongUniqueInfoList();
        if (r5 == null) goto L21;
        SongUniqueInfo r6 = (SongUniqueInfo) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L21;
        long r7 = System.currentTimeMillis();
        long r9 = com.bytedance.android.live.ktv.common.util.a.c().getRoomId();
        int r8 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.e(r7, r9, r9, 0, gh0.a.c(), false, (int) r6.getSongType(), 0, VideoChorusWidget$removeMyOrderSong$1.INSTANCE, VideoChorusWidget$removeMyOrderSong$2.INSTANCE);
    L21:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L24;
        r10.put("cmd_video_chorus_state_change", Boolean.FALSE);
    L24:
        q r11 = this.s;
        if (r11 != null) goto L27;
    L48:
        VideoChorusPlayerProxy r12 = this.n;
        if (r12 == null) goto L58;
        com.bytedance.livesdk.ktvimpl.base.download.a.c.getClass();
        com.bytedance.livesdk.ktvimpl.base.download.a.b();
        j1 r13 = r12.m;
        if (r13 == null) goto L57;
        cg6.a r14 = r13.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r14 == null) goto L57;
        vb6.g r15 = r14.O5();
        if (r15 == null) goto L57;
        r15.a1(r12.j);
    L57:
        r12.h();
        r12.e.release();
    L58:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r16 = this.k;
        if (r16 == null) goto L61;
        r16.b();
    L61:
        o r17 = o3.f();
        if (r17 == null) goto L68;
        com.bytedance.live.datacontext.j r18 = r17.getMessageManager();
        if (r18 == null) goto L68;
        vlc.d r19 = (vlc.d) r18.getValue();
        if (r19 == null) goto L68;
        r19.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);
    L68:
        KSongOrderSongUtilKt.b(((Widget) this).context, CloseOrderSongDialogSource.BUSINESS_WIDGET_DESTROY);
        Pair<? extends DataContext, ? extends Disposable> r20 = this.q;
        if (r20 == null) goto L75;
        Disposable r21 = (Disposable) r20.getSecond();
        if (r21 == null) goto L75;
        if (r21.isDisposed() == true) goto L75;
        r21.dispose();
        this.q = null;
    L75:
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r22 = this.p;
        if (r22 == null) goto L82;
        Disposable r23 = (Disposable) r22.getSecond();
        if (r23 == null) goto L82;
        if (r23.isDisposed() == true) goto L82;
        r23.dispose();
        this.p = null;
    L82:
        this.r = null;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r24 = this.d;
        if (r24 == null) goto L85;
        r24.b();
    L85:
        this.g.clear();
        fd2.e r25 = this.e;
        if (r25 == null) goto L88;
        r25.o1();
    L88:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r26 = this.f;
        if (r26 == null) goto L91;
        r26.a();
    L91:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r27 = this.j;
        if (r27 != null) goto L94;
    L111:
        DataCenter r28 = ((Widget) this).dataCenter;
        if (r28 == null) goto L115;
        r28.removeObserver(this);
    L115:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L121;
        ei6.a r29 = Z0();
        if (r29 == null) goto L121;
        ChorusManager r30 = r29.i();
        if (r30 == null) goto L121;
        r30.b = false;
    L121:
        ((ViewModelStore) this.a.getValue()).clear();
        cg6.a r31 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r31 == null) goto L126;
        vb6.g r32 = r31.O5();
        if (r32 == null) goto L126;
        r32.f1(this.u);
    L126:
        cg6.a r33 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r33 == null) goto L135;
        vb6.g r34 = r33.O5();
        if (r34 == null) goto L136;
        r34.a1(this.t);
        return;
    L136:
        return;
    L135:
        return;
    L94:
        if (r27.c != true) goto L111;
        com.bytedance.live.datacontext.m r35 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r35 == null) goto L100;
        IRoom r36 = (IRoom) r35.getValue();
        if (r36 == null) goto L100;
        long r37 = r36.getId();
    L101:
        long r38 = r37;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r39 = this.j;
        if (r39 == null) goto L105;
        String r40 = r39.a;
        if (r40 == null) goto L105;
    L106:
        String r41 = r40;
        if (r39 == null) goto L109;
        int r110 = r39.b;
    L110:
        ((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).leaveChorus(r38, r41, 1, r110);
        goto L111
    L109:
        r110 = 0;
    L105:
        r40 = BDLocationException.ERROR_TIMEOUT;
    L100:
        r37 = 0;
        goto L101
    L27:
        if (r11.isShowing() != true) goto L48;
        q r42 = this.s;
        if (r42 == null) goto L48;
        Handler r43 = DialogLancet.resolveDialogHandler(r42);
        if (r43 != null) goto L33;
    L35:
        DialogLancet.beforeDialogDismiss(r42);
        r42.dismiss();     // Catch: Throwable -> L38 Exception -> L40
    L45:
        DialogLancet.afterDialogDismiss(r42);
        goto L48
    L38:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r42);
        throw th;
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L38
        Throwable r44 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L38
        if (r44 == null) goto L45;
        com.bytedance.crash.d.d(r44, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L38
        goto L45
    L33:
        if (Looper.myLooper() == r43.getLooper()) goto L35;
        r43.post(DialogLancet.createDismissRunnable(r42));
        goto L48
    L11:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L13;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusWidget", "is not anchor removeMyOrderSong return");
    L7:
        r4 = null;
        goto L9
    }

    public final ViewModelStore tf() {
        return (ViewModelStore) this.a.getValue();
    }

    public final void xq() {
        KtvComponentOrderSongDataContext.Companion.getClass();
        if (KtvComponentOrderSongDataContext.Companion.d() != null) goto L34;
        Pair<? extends DataContext, ? extends Disposable> r0 = com.bytedance.live.datacontext.d.a(VideoChorusWidget$initKSongOrderSongDataContextIfNeed$1.INSTANCE);
        this.q = r0;
        DataContext r1 = null;
        if (r0 == null) goto L7;
        DataContext r2 = (DataContext) r0.getFirst();
    L9:
        if ((r2 instanceof KtvComponentOrderSongDataContext) == false) goto L12;
        r1 = r2;
    L12:
        KtvComponentOrderSongDataContext r3 = (KtvComponentOrderSongDataContext) r1;
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.b.a(r3, VideoChorusWidget$initKSongOrderSongDataContextIfNeed$2.INSTANCE);
    L15:
        KSongOrderSongHandler r4 = new KSongOrderSongHandler();
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b> r5 = r3.m59getCommonOrderSongViewModel();
        if (r5 == null) goto L20;
        CommonOrderSongViewModel.Companion.getClass();
        r5.d(CommonOrderSongViewModel.a.a(this, r4));
    L20:
        if (r3 == null) goto L24;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r6 = r3.m60getCommonSearchViewModel();
        if (r6 == null) goto L24;
        CommonSearchViewModel.Companion.getClass();
        r6.d(CommonSearchViewModel.a.a(this, r4));
    L24:
        if (r3 == null) goto L28;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r7 = r3.m58getBusinessOrderSongViewModel();
        if (r7 == null) goto L28;
        KtvComponentOrderSongViewModel.a r8 = KtvComponentOrderSongViewModel.Companion;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r9 = KtvComponentOrderSongDataContext.Companion.b();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r10 = KtvComponentOrderSongDataContext.Companion.c();
        KtvComponentOrderedSongDataContext r11 = KtvComponentOrderedSongDataContext.Companion.getContext();
        r8.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = KtvComponentOrderSongViewModel.a.a(this, r9, r10, r11);
        r12.initData();
        Unit r13 = Unit.INSTANCE;
        r7.d(r12);
    L28:
        r4.a = KtvComponentOrderSongDataContext.Companion.a();
        r4.b = KtvComponentOrderSongDataContext.Companion.b();
        if (r3 == null) goto L35;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r14 = r3.m61getKtvDressViewModel();
        if (r14 == null) goto L36;
        KtvDressViewModel.Companion.getClass();
        r14.d(KtvDressViewModel.a.a(this));
        return;
    L36:
        return;
    L35:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void zq() {
        KtvComponentOrderedSongDataContext r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r0 == null) goto L45;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
        if (r1 == null) goto L49;
        com.bytedance.android.livesdk.log.filter.o r2 = j0.l().c(x.class);
        com.bytedance.android.livesdk.log.filter.o r3 = null;
        if ((r2 instanceof t) == true) goto L10;
        r2 = null;
    L10:
        t r4 = (t) r2;
        if (r4 == null) goto L14;
        String r5 = r4.l();
        if (r5 == null) goto L14;
    L15:
        com.bytedance.android.livesdk.log.filter.o r6 = j0.l().c(x.class);
        if ((r6 instanceof t) == true) goto L18;
        r6 = null;
    L18:
        t r7 = (t) r6;
        if (r7 == null) goto L22;
        String r8 = r7.e();
        if (r8 == null) goto L22;
    L24:
        if (Intrinsics.areEqual(r5, "true") == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(r8, "join_chorus") == false) goto L47;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r9 = KtvComponentOrderSongDataContext.Companion.a();
        if ((r9 instanceof KtvComponentOrderSongViewModel) == true) goto L30;
        r9 = null;
    L30:
        KtvComponentOrderSongViewModel r10 = (KtvComponentOrderSongViewModel) r9;
        if (r10 == null) goto L37;
        RealTimeChorusInfo r11 = r1.C;
        if (r11 == null) goto L35;
        String r12 = r11.getChorusIDStr();
    L36:
        r10.joinChorusAgainSendToLynx("realtime_chorus", r12);
        goto L37
    L35:
        r12 = null;
    L37:
        com.bytedance.android.livesdk.log.filter.o r13 = j0.l().c(x.class);
        if ((r13 instanceof t) == false) goto L41;
        r3 = r13;
    L41:
        t r14 = (t) r3;
        if (r14 == null) goto L48;
        r14.F("");
        r14.t("");
        return;
    L48:
        return;
    L47:
        return;
    L22:
        r8 = "";
    L14:
        r5 = "";
        goto L15
    L49:
        return;
    }

    public VideoChorusWidget() {
        this.a = LazyKt.lazy(VideoChorusWidget$viewModelStorage$2.INSTANCE);
        this.g = new CompositeDisposable();
        this.t = new c(this);
        this.u = new b(this);
    }

    public final void Aq() {
        int r0 = s1.j(2131168816);
        InteractionWidgetsPosContext r1 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getPublicScreenBottomMargin();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L11:
        if (PadConfigUtils.c() == false) goto L13;
        int r5 = 2131168847;
    L14:
        FrameLayout r6 = this.l;
        if (r6 != null) goto L17;
    L19:
        int r7 = 2131168850;
    L20:
        int r8 = 0;
        Iterator r9 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(r5), 2131168848, Integer.valueOf(r7)}).iterator();
    L22:
        if (r9.hasNext() == false) goto L25;
        r8 = r8 + s1.j(((Number) r9.next()).intValue());
        goto L22
    L25:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.j(this).isPortraitInteraction(), Boolean.TRUE) == false) goto L27;
        int r10 = s1.w();
    L29:
        if (FoldScreenUtils.e() == false) goto L31;
    L34:
        float r11 = r10;
        float r12 = ((Float) xw0.a.getValue()).floatValue();
    L35:
        int r13 = (int) (r11 * r12);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusWidget", "getBottomRange, screenHeight: " + r10 + ", publicScreenHeight: " + r13 + ", height: " + r8 + ", bottomMargin: " + r4);
        int r14 = (((r10 - r13) - r8) - r4) - s1.f(25.0f);
        VerticalDragFrameLayout r15 = this.c;
        if (r15 == null) goto L40;
        r15.post(new i(this, r0, r14));
        return;
    L40:
        return;
    L31:
        if (PadConfigUtils.c() == true) goto L34;
        r11 = r10;
        r12 = ((Float) ww0.a.getValue()).floatValue();
        goto L35
    L27:
        r10 = Math.min(s1.w(), s1.y());
        goto L29
    L17:
        if (r6.getVisibility() != 0) goto L19;
        r7 = 2131168849;
        goto L20
    L13:
        r5 = 2131168846;
    L9:
        r4 = s1.j(2131168830);
        goto L11
    }

    public final int getScene() {
        return je0.d.f();
    }

    public final void onCreate() {
        super.onCreate();
        if (FoldScreenUtils.e() == false) goto L5;
    L6:
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L9;
        r0.post(new l(this));
    L9:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L12;
        r1.put("cmd_video_chorus_state_change", Boolean.TRUE);
    L12:
        bb0.a r2 = bb0.b.a;
        com.bytedance.android.livesdk.ktvimpl.base.n r3 = com.bytedance.android.livesdk.ktvimpl.base.n.a;
        Intrinsics.checkNotNullParameter(r3, "ktvCommonInject");
        bb0.b.a = r3;
        pb0.a r4 = pb0.b.a;
        KtvLoggerHelper r5 = KtvLoggerHelper.d;
        Intrinsics.checkNotNullParameter(r5, "ktvLogger");
        pb0.b.a = r5;
        mb0.c r6 = mb0.d.a;
        pd2.d r7 = pd2.d.n;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r7, "monitor");
        mb0.d.a = r7;
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r8 = this.p;
        vlc.d r9 = null;
        if (r8 == null) goto L15;
        OrderedSongDataContext r10 = (OrderedSongDataContext) r8.getFirst();
    L16:
        if (r10 != null) goto L22;
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r11 = com.bytedance.live.datacontext.d.a(VideoChorusWidget$initKtvComponentOrderedSongDataContextIfNeed$1.INSTANCE);
        this.p = r11;
        if (r11 == null) goto L22;
        OrderedSongDataContext r12 = (OrderedSongDataContext) r11.getFirst();
        if (r12 == null) goto L22;
        com.bytedance.live.datacontext.b.a(r12, KtvComponentOrderedSongDataContext.class);
    L22:
        com.bytedance.live.datacontext.d.a(VideoChorusWidget$initCoreData$1.INSTANCE);
        xq();
        Pair r13 = com.bytedance.live.datacontext.d.a(VideoChorusWidget$initChorusDataContext$1.INSTANCE);
        VideoChorusDataContext r14 = (VideoChorusDataContext) r13.component1();
        Disposable r15 = (Disposable) r13.component2();
        com.bytedance.live.datacontext.i<Boolean> r16 = r14.isFeed();
        Boolean r17 = Boolean.FALSE;
        r16.d(r17);
        r14.getService().d(this);
        com.bytedance.live.datacontext.b.a(r14, VideoChorusDataContext.TAG_FOR_LIVE);
        this.g.add(r15);
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L25;
        r18.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
    L25:
        View r19 = ((Widget) this).contentView;
        if (r19 == null) goto L28;
        FrameLayout r20 = (FrameLayout) r19.findViewById(2131365694);
    L29:
        this.l = r20;
        View r21 = ((Widget) this).contentView;
        if (r21 == null) goto L32;
        FrameLayout r22 = (FrameLayout) r21.findViewById(2131380101);
    L33:
        View r23 = ((Widget) this).contentView;
        if (r23 == null) goto L36;
        FrameLayout r24 = (FrameLayout) r23.findViewById(2131379318);
    L37:
        if (r22 == null) goto L40;
        if (r24 == null) goto L40;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r25 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g(r22, r24, this, this, getMultiLinkRoomScope());
        r25.a(this);
        Unit r26 = Unit.INSTANCE;
        this.k = r25;
    L40:
        View r27 = ((Widget) this).contentView;
        if (r27 == null) goto L43;
        VerticalDragFrameLayout r28 = (VerticalDragFrameLayout) r27.findViewById(2131392275);
    L44:
        this.c = r28;
        View r29 = ((Widget) this).contentView;
        if (r29 == null) goto L47;
        FrameLayout r30 = (FrameLayout) r29.findViewById(2131392273);
    L48:
        this.b = r30;
        if (PadConfigUtils.c() == false) goto L57;
        FrameLayout r31 = this.b;
        if (r31 == null) goto L57;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if (r32 == null) goto L57;
        r32.height = s1.j(2131168847);
        FrameLayout r33 = this.b;
        if (r33 == null) goto L57;
        r33.setLayoutParams(r32);
    L57:
        Aq();
        Context r34 = ((Widget) this).context;
        this.d = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r35 = this.d;
        String r36 = "";
        if (r35 == null) goto L78;
        com.bytedance.live.datacontext.m r37 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r37 == null) goto L67;
        IRoom r38 = (IRoom) r37.getValue();
        if (r38 == null) goto L67;
        String r39 = r38.getIdStr();
        if (r39 == null) goto L67;
        String r40 = r39;
    L68:
        com.bytedance.live.datacontext.m r41 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r41 == null) goto L76;
        IRoom r42 = (IRoom) r41.getValue();
        if (r42 == null) goto L76;
        String r43 = r42.getOwnerUserIdString();
        if (r43 == null) goto L76;
        String r44 = r43;
    L77:
        r35.a(new fd2.b(r34, r40, r44, false, true, null, null, null, this.b));
    L76:
        r44 = "";
    L67:
        r40 = "";
    L78:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r45 = this.d;
        if (r45 == null) goto L93;
        com.bytedance.live.datacontext.m r46 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r46 == null) goto L85;
        IRoom r47 = (IRoom) r46.getValue();
        if (r47 == null) goto L85;
        String r48 = r47.getIdStr();
    L86:
        com.bytedance.live.datacontext.m r49 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r49 == null) goto L91;
        IRoom r50 = (IRoom) r49.getValue();
        if (r50 == null) goto L91;
        String r51 = r50.getOwnerUserIdString();
    L92:
        r45.c(r48, r51, false, "");
    L91:
        r51 = null;
    L85:
        r48 = null;
    L93:
        this.f = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a(((Widget) this).dataCenter, "realtime_chorus", this);
        com.bytedance.live.datacontext.m r52 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r52 == null) goto L101;
        IRoom r53 = (IRoom) r52.getValue();
        if (r53 == null) goto L101;
        String r54 = r53.getIdStr();
        if (r54 == null) goto L101;
        r36 = r54;
    L101:
        VideoChorusPlayerProxy r55 = new VideoChorusPlayerProxy(r36, this);
        this.n = r55;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.b r56 = new com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.b(r55, this);
        Pair r57 = com.bytedance.live.datacontext.d.a(VideoChorusWidget$initKtvJsbDataContext$pair$1.INSTANCE);
        KtvJsbDataContext r58 = (KtvJsbDataContext) r57.getFirst();
        r58.isFeed().d(r17);
        r58.getService().d(r56);
        com.bytedance.live.datacontext.b.a(r58, KtvJsbDataContext.TAG_FOR_LIVE);
        this.g.add((Disposable) r57.getSecond());
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r59 = this.f;
        if (r59 == null) goto L104;
        this.o = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.a(r59);
    L104:
        ChorusJsbDataContext r60 = ChorusJsbDataContext.Companion.getContext();
        if (r60 == null) goto L109;
        com.bytedance.live.datacontext.j<fd2.e> r61 = r60.getService();
        if (r61 == null) goto L109;
        fd2.e r62 = (fd2.e) r61.getValue();
    L110:
        this.e = r62;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.a r63 = this.o;
        if (r63 == null) goto L114;
        if (r62 == null) goto L114;
        r62.n1(r63);
    L114:
        VideoChorusDataContext.a r64 = VideoChorusDataContext.Companion;
        VideoChorusDataContext r65 = r64.getContext();
        if (r65 == null) goto L119;
        com.bytedance.live.datacontext.j<fd2.d> r66 = r65.getChorusBizProxy();
        if (r66 == null) goto L119;
        r66.d(this.o);
    L119:
        VideoChorusDataContext r67 = r64.getContext();
        if (r67 == null) goto L124;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c> r68 = r67.getMusicPlayerProxy();
        if (r68 == null) goto L124;
        r68.d(this.n);
    L124:
        ((Widget) this).dataCenter.observe(ChorusJsbDataContext.CMD_START_RTC_ENGINE, this);
        ((Widget) this).dataCenter.observe(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE, this);
        ((Widget) this).dataCenter.observe("data_dynamic_show_emoji_panel", this);
        cg6.a r69 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r69 == null) goto L129;
        vb6.g r70 = r69.O5();
        if (r70 == null) goto L129;
        r70.e1(this.u, true);
    L129:
        cg6.a r71 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r71 == null) goto L134;
        vb6.g r72 = r71.O5();
        if (r72 == null) goto L134;
        r72.X0(this.t, true);
    L134:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r73 = r64.a();
        if (r73 == null) goto L137;
        r73.l(this, new d(this));
    L137:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r74 = r64.a();
        if (r74 == null) goto L140;
        r74.e(this, new e(this));
    L140:
        KtvComponentOrderedSongDataContext r75 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r75 == null) goto L145;
        Disposable r76 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b.a.a(r75, false, new f(this), 3);
        if (r76 == null) goto L145;
        RxUtilKt.c(r76, this.g);
    L145:
        RxUtilKt.c(xs2.b.a().b(jd2.f.class).subscribe(new g(this)), this.g);
        Disposable r77 = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        if (r77 == null) goto L148;
        RxUtilKt.c(r77, this.g);
    L148:
        DataCenter r78 = ((Widget) this).dataCenter;
        if (r78 == null) goto L151;
        r78.observe("data_hide_screen", this);
    L151:
        o r79 = o3.f();
        if (r79 == null) goto L156;
        com.bytedance.live.datacontext.j r80 = r79.getMessageManager();
        if (r80 == null) goto L156;
        vlc.d r81 = (vlc.d) r80.getValue();
    L158:
        if ((r81 instanceof xlc.a) == false) goto L161;
        r9 = r81;
    L161:
        xlc.a r82 = (xlc.a) r9;
        if (r82 == null) goto L165;
        MessageType r83 = MessageType.REAL_TIME_CHORUS_MESSAGE;
        r82.y(r83.getIntType(), this);
        onMessage(r82.u(r83.getIntType()));
    L165:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L171;
        ei6.a r85 = Z0();
        if (r85 == null) goto L171;
        ChorusManager r86 = r85.i();
        if (r86 == null) goto L171;
        r86.b = true;
    L171:
        zq();
        return;
    L156:
        r81 = null;
    L109:
        r62 = null;
        goto L110
    L47:
        r30 = null;
        goto L48
    L43:
        r28 = null;
        goto L44
    L36:
        r24 = null;
        goto L37
    L32:
        r22 = null;
        goto L33
    L28:
        r20 = null;
        goto L29
    L15:
        r10 = null;
        goto L16
    L5:
        if (PadConfigUtils.c() == false) goto L9;
        goto L6
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        String r0 = r6.getKey();
        Object r2 = null;
        switch(r0.hashCode()) {
            case -1238735384: goto L54;
            case -1122045708: goto L43;
            case -374564286: goto L29;
            case 135538046: goto L6;
            default: goto L74;
        };
    L74:
        return;
    L6:
        if (r0.equals("data_dynamic_show_emoji_panel") == false) goto L61;
        String r7 = (String) r6.getData();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.base.i r3 = r1.getLinkUserInfoCenter();
        if (r3 == null) goto L63;
        ILinkPlayerInfoBridge r4 = je0.d.i(r3, r7);
        if (r4 == null) goto L75;
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r8 == null) goto L64;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 != null) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r7, r9.getOwnerUserIdString()) == false) goto L25;
        xs2.b.a().post(new UserProfileEvent(r9.getOwner()).setReportType("data_card_linked_anchor"));
        return;
    L25:
        IInteractService r10 = jc1.k.f(IInteractService.class);
        if (r10 == null) goto L66;
        r10.openVideoTalkRoomManageDialog(((Widget) this).context, r4, Boolean.FALSE, ((Widget) this).dataCenter);
        return;
    L66:
        return;
    L64:
        return;
    L75:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L29:
        if (r0.equals(ChorusJsbDataContext.CMD_START_RTC_ENGINE) == false) goto L68;
        this.i = true;
        if (this.h == null) goto L41;
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getMessageManager();
        if (r11 == null) goto L41;
        vlc.d r12 = (vlc.d) r11.getValue();
        if (r12 == null) goto L41;
        tlc.d r13 = this.h;
        if (r13 == null) goto L40;
        r12.j(r13, true);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L41:
        this.h = null;
        return;
    L68:
        return;
    L43:
        if (r0.equals("data_hide_screen") == false) goto L70;
        Boolean r14 = (Boolean) r6.getData();
        if (r14 != null) goto L47;
        r14 = Boolean.FALSE;
    L47:
        boolean r15 = r14.booleanValue();
        View r16 = ((Widget) this).contentView;
        if (r16 == null) goto L71;
        if (r15 == false) goto L51;
        int r17 = 4;
    L52:
        r16.setVisibility(r17);
        return;
    L51:
        r17 = 0;
        goto L52
    L71:
        return;
    L70:
        return;
    L54:
        if (r0.equals(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE) == false) goto L73;
        Object r18 = r6.getData();
        if ((r18 instanceof com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b) == false) goto L59;
        r2 = r18;
    L59:
        this.j = (com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b) r2;
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (FoldScreenUtils.e() == false) goto L5;
    L6:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L9;
        r3.post(new l(this));
    L9:
        Aq();
        return;
    L5:
        if (PadConfigUtils.c() == false) goto L9;
        goto L6
    }

    public final void onMessage(tlc.d r7) {
        if ((r7 instanceof kd) == false) goto L36;
        kd r8 = (kd) r7;
        if (r8.getMsgType() != 3) goto L37;
        z2 r0 = r8.G();
        if (r0 == null) goto L19;
        List r1 = r0.a();
        if (r1 == null) goto L19;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L20;
        w2 r5 = ((t2) r4.next()).c();
        if (r5 == null) goto L40;
        py.k r6 = r5.a();
        if (r6 == null) goto L39;
        r3.add(r6);
        goto L12
    L39:
        return;
    L40:
        return;
    L20:
        VideoChorusPlayerProxy r9 = this.n;
        if (r9 == null) goto L38;
        z2 r10 = r8.G();
        if (r10 == null) goto L26;
        String r11 = r10.d();
        if (r11 == null) goto L26;
    L27:
        z2 r12 = r8.G();
        if (r12 == null) goto L30;
        int r13 = (int) r12.c();
    L31:
        r9.u(new jd2.a(r11, r13, r3));
        return;
    L30:
        r13 = 0;
    L26:
        r11 = "";
        goto L27
    L38:
        return;
    L19:
        r3 = new ArrayList();
        goto L20
    L37:
        return;
    }

    public final void yq(jd2.c r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (ArraysKt.contains(new Integer[]{3, 1, 2}, Integer.valueOf(r10.a)) == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.g r0 = this.k;
        if (r0 == null) goto L11;
        String r2 = r10.c;
        long r3 = r10.b;
        jd2.c.b r11 = r10.d;
        r0.f(new com.bytedance.android.livesdk.ktvimpl.base.a(r2, r3, r11.a, r11.d, r11.e));
        return;
    L11:
        return;
    }

    public static void wq(KSongOrderSongDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "KSongOrderSongDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.showNow(r3, "KSongOrderSongDialog");
    }

    public final void onSei(final String r1, ye1.a r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        UtilityKotlinExtentionsKt.b(this, new AnonymousClass1(r1));
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r3 = false;
        goto L8
    }

    public final void K2(boolean r10, boolean r11, tf0.q r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.m r1 = r0.y1();
        if (r1 == null) goto L8;
        r1.setValue(Boolean.TRUE);
    L8:
        q r2 = this.s;
        if (r2 != null) goto L11;
    L13:
        q r3 = new q(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.j(this), this, r11, r10, r12);
        this.s = r3;
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L17:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L11:
        if (r2.isShowing() != true) goto L13;
    }
}
