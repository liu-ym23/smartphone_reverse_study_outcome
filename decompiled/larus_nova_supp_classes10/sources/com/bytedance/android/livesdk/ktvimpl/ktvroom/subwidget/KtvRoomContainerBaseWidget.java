package com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.e;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestApplyDialog;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.widget.GuestApplyTopBarWidget;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.dialog.p;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.util.FragmentManagerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.KtvRoomInteractEmojiPanel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget;
import com.bytedance.android.livesdk.logger.PanelType;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hg6.i;
import hh1.w0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kk0.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oe2.l;
import org.json.JSONArray;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/subwidget/KtvRoomContainerBaseWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvRoomSceneBaseWidget;", "Lkk0/g;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvRoomContainerBaseWidget extends KtvRoomSceneBaseWidget implements g {
    public static final /* synthetic */ int H = 0;
    public com.bytedance.android.live.pushstream.d A;
    public WidgetManager B;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d C;
    public w0 D;
    public y E;
    public InteractAnimationController F;
    public final j1 G;
    public final Lazy c;
    public w d;
    public qe2.a e;
    public Widget f;
    public MiddlewareRoomWidget g;
    public j50.a h;
    public GuestApplyDialog i;
    public q0 j;
    public ih0.d k;
    public p l;
    public final CompositeDisposable m;
    public k50.c n;
    public GLSurfaceView o;
    public final KtvContext p;
    public final sb0.b q;
    public final sb0.a r;
    public final l s;
    public final e t;
    public KtvCoreViewModel u;
    public RecyclableWidgetManager v;
    public Pair<KtvRoomContext, ? extends Disposable> w;
    public final b x;
    public KtvSingerViewModel y;
    public qe2.c z;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvRoomContainerBaseWidget a;

        public b(KtvRoomContainerBaseWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "valid");
            this.a.yq(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvRoomContainerBaseWidget a;
        public final /* synthetic */ IBaseUser b;

        public c(KtvRoomContainerBaseWidget r1, IBaseUser r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            IMiddlewareHostSocial r6 = k.f(IMiddlewareHostSocial.class);
            Intrinsics.checkNotNull(r6);
            r6.inviteFriendByIM(((Widget) this.a).context, this.b, new KtvRoomContainerBaseWidget$onFastInviteButtonClick$1$1(this));
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            ALogger.e("KtvRoomContainerBaseWidget", String.valueOf((Throwable) r2));
        }
    }

    static {
    }

    public void yq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
    }

    public void onDestroy() {
        q0 r0 = this.j;
        if (r0 != null) goto L5;
    L9:
        GuestApplyDialog r1 = this.i;
        if (r1 != null) goto L35;
    L17:
        this.i = null;
        wq();
        ih0.d r2 = this.k;
        if (r2 != null) goto L20;
    L24:
        jd0.g r3 = new jd0.g(false);
        xs2.b.a().post(r3);
        DataCenter r4 = this.q.getDataCenter();
        if (r4 == null) goto L27;
        r4.put("cmd_interact_audio", r3);
    L27:
        qe2.a r5 = this.e;
        if (r5 == null) goto L31;
        r5.end();
    L31:
        if (this.m.isDisposed() == true) goto L33;
        this.m.clear();
    L33:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
        return;
    L20:
        if (r2.p() != true) goto L24;
        ih0.d r6 = this.k;
        if (r6 == null) goto L24;
        r6.dismissDialog();
        goto L24
    L35:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L17;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L17
    L5:
        if (r0.p() != true) goto L9;
        q0 r8 = this.j;
        if (r8 == null) goto L9;
        r8.dismissDialog();
        goto L9
    }

    public final void um() {
        if (o.t(this.q.isAnchor()) == true) goto L5;
        return;
    L5:
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        Intrinsics.checkNotNull(r0);
        if (r0.user().c() == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L14;
        r1.showInviteAndPermitDialog(false, "", -1);
        return;
    L14:
        return;
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r2 == null) goto L16;
        r2.showInviteDialog(false, "", -1);
        return;
    }

    public final void wq() {
        p r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L29;
        p r1 = this.l;
        if (r1 == null) goto L30;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r1);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(r1));
        return;
    L30:
        return;
    }

    public final RecyclableWidgetManager xq() {
        Lazy r0 = KtvCommonSettingHelper.a;
        if (this.v != null) goto L58;
        Fragment r1 = null;
        if (KtvSettingHelper.i() == false) goto L45;
        Context r2 = ((Widget) this).context;
        if ((r2 instanceof FragmentActivity) == true) goto L9;
        r2 = null;
    L9:
        Activity r3 = (FragmentActivity) r2;
        if (r3 != null) goto L14;
        r3 = com.bytedance.android.live.core.utils.a.d();
    L14:
        if ((r3 instanceof FragmentActivity) == true) goto L16;
        r3 = null;
    L16:
        FragmentActivity r4 = (FragmentActivity) r3;
        Fragment r5 = com.bytedance.android.livesdk.ktvimpl.base.util.d.a(r4);
        if (r5 != null) goto L19;
    L21:
        if (r4 != null) goto L23;
    L25:
        if (r5 == null) goto L38;
        FragmentManager r6 = r5.getChildFragmentManager();
        if (r6 == null) goto L38;
        List r7 = r6.getFragments();
        if (r7 == null) goto L38;
        Iterator r8 = r7.iterator();
    L32:
        if (r8.hasNext() == false) goto L36;
        Object r9 = r8.next();
        if ((((Fragment) r9) instanceof RecyclableWidgetManager) == false) goto L32;
    L37:
        Fragment r10 = (Fragment) r9;
    L40:
        if ((r10 instanceof RecyclableWidgetManager) == false) goto L43;
        r1 = r10;
    L43:
        RecyclableWidgetManager r11 = (RecyclableWidgetManager) r1;
    L44:
        this.v = r11;
        goto L58
    L36:
        r9 = null;
    L38:
        r10 = null;
        goto L40
    L23:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r4.getSupportFragmentManager()) == true) goto L25;
        r11 = RecyclableWidgetManager.ha0(r4, ((Widget) this).contentView);
        goto L44
    L19:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r5.getChildFragmentManager()) == true) goto L21;
        r11 = RecyclableWidgetManager.ga0(r5, ((Widget) this).contentView);
        goto L44
    L45:
        Fragment r12 = ((Widget) this).context;
        if ((r12 instanceof FragmentActivity) == true) goto L48;
        r12 = null;
    L48:
        Fragment r13 = (FragmentActivity) r12;
        if (r13 != null) goto L53;
        r13 = com.bytedance.android.live.core.utils.a.d();
    L53:
        if ((r13 instanceof FragmentActivity) == false) goto L56;
        r1 = r13;
    L56:
        this.v = RecyclableWidgetManager.ha0((FragmentActivity) r1, ((Widget) this).contentView);
    L58:
        return this.v;
    }

    public final int getLayoutId() {
        if (KtvSettingHelper.r().booleanValue() == false) goto L5;
        return 2131567750;
    L5:
        Lazy r0 = KtvCommonSettingHelper.a;
        if (KtvCommonSettingHelper.a(this.q.b().getAnchorAbMap()) == false) goto L8;
        return 2131567749;
    L8:
        return 2131567751;
    }

    public final IRoom getMRoom() {
        com.bytedance.android.livesdk.chatroom.o r0 = m.i();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
    L9:
        if ((r2 instanceof IRoom) == true) goto L12;
        return null;
    L12:
        return r2;
    L7:
        r2 = null;
        goto L9
    }

    private static boolean zq(ILinkPlayerInfoBridge r1) {
        if (r1 == null) goto L6;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L6;
        String r3 = r2.getIdString();
    L8:
        return Intrinsics.areEqual(r3, o.J());
    L6:
        r3 = null;
        goto L8
    }

    public final void Aq(ILinkPlayerInfoBridge r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        IBaseUser r1 = r5.getUser();
    L6:
        if (r1 == null) goto L27;
        IBaseUser r2 = r5.getUser();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
    L11:
        IRoom r4 = getMRoom();
        if (r4 == null) goto L14;
        r0 = r4.getOwnerUserIdString();
    L14:
        boolean r6 = Intrinsics.areEqual(r3, r0);
        if (zq(r5) == false) goto L17;
        String r7 = "oneself";
    L20:
        IBaseUser r8 = r5.getUser();
        if (r8 == null) goto L24;
        String r9 = r8.getIdString();
        if (r9 == null) goto L24;
    L25:
        TalkRoomLogUtils.d(r9, r7, n.b(r5));
        return;
    L24:
        r9 = "";
        goto L25
    L17:
        if (r6 == false) goto L19;
        r7 = "anchor";
        goto L20
    L19:
        r7 = "audience";
        goto L20
    L10:
        r3 = null;
        goto L11
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void N0(w8 r3) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("cmd_show_dynamic_emoji_in_comment", r3);
        return;
    }

    public final void ac(ILinkPlayerInfoBridge r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r0 != null) goto L7;
    L18:
        IBaseUser r1 = r12.getUser();
        String r2 = null;
        if (r1 == null) goto L21;
        String r3 = r1.getIdString();
    L22:
        IRoom r4 = getMRoom();
        if (r4 == null) goto L25;
        String r5 = r4.getOwnerUserIdString();
    L27:
        if (Intrinsics.areEqual(r3, r5) == false) goto L33;
        DataCenter r6 = this.q.getDataCenter();
        if (r6 == null) goto L31;
        r6.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
    L31:
        Aq(r12);
        return;
    L33:
        Aq(r12);
        if (zq(r12) == false) goto L53;
        IInteractService r7 = k.f(IInteractService.class);
        Intrinsics.checkNotNull(r7);
        if (r7.isEnableTalkRoomEmoji() == false) goto L53;
        DataCenter r8 = this.q.getDataCenter();
        if (r8 == null) goto L45;
        if (r12.getSilenceStatus() == 0) goto L42;
        boolean r9 = true;
    L43:
        r8.put("data_self_is_silenced", Boolean.valueOf(r9));
        goto L45
    L42:
        r9 = false;
    L45:
        if (hd0.c.f().h() == false) goto L49;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r13 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r13.b(((Widget) this).context);
        r13.c(((Widget) this).dataCenter);
        r13.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r13.d = "seat";
        q0 r14 = r13.a();
        this.j = r14;
        r14.a();
        return;
    L49:
        if (hd0.c.f().g() == false) goto L53;
        xs2.b.a().post(new UserProfileEvent(r12.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L53:
        if (je0.d.c0() == true) goto L55;
    L75:
        boolean r10 = hd0.c.f().h();
        boolean r11 = k.n(IMiddlewareUserService.class).user().c();
        if (this.q.isAnchor() == true) goto L90;
        if (r11 == false) goto L82;
        if (r10 == true) goto L90;
        if (r12.isLinkRoomUser() == false) goto L90;
    L82:
        if (zq(r12) == true) goto L90;
        IBaseUser r15 = r12.getUser();
        if (r15 == null) goto L88;
        r2 = r15.getIdString();
    L88:
        if ((!Intrinsics.areEqual(r2, o.J())) == false) goto L99;
        xs2.b.a().post(new UserProfileEvent(r12.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L99:
        return;
    L90:
        p r16 = new p(((Widget) this).context, ((Widget) this).dataCenter, r12, this.q.isAnchor());
        r16.G = "seat";
        this.l = r16;
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L97;
        DialogLancet.handleBlockedDialogShow(r16);
        return;
    L97:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L96
    L94:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        return;
    L55:
        if (this.q.isAnchor() == false) goto L57;
    L60:
        ih0.d r17 = this.k;
        if ((r17 instanceof KtvRoomInteractEmojiPanel) == false) goto L66;
        if (r17 == null) goto L66;
        if (r17.p() != true) goto L66;
        return;
    L66:
        Context r18 = ((Widget) this).context;
        DataCenter r19 = ((Widget) this).dataCenter;
        LinkPlayerInfo r110 = (LinkPlayerInfo) r12;
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "dataCenter");
        Intrinsics.checkNotNullParameter(r110, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (i.a() == false) goto L69;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r20 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r110, "seat", false);
    L73:
        this.k = r20;
        r20.a();
        return;
    L69:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r21 = new KtvRoomInteractEmojiPanel(r18, r19, r110);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        ((InteractEmojiPanel) r21).k = "seat";
        ((InteractEmojiPanel) r21).r = false;
        tb6.c r111 = ((InteractEmojiPanel) r21).x;
        if (r111 == null) goto L72;
        r111.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r111.d = "seat";
    L72:
        r20 = r21;
        goto L73
    L57:
        if (zq(r12) == true) goto L75;
        if (hd0.c.f().h() == false) goto L75;
    L25:
        r5 = null;
        goto L27
    L21:
        r3 = null;
        goto L22
    L7:
        if (r0.isEngineOn() == true) goto L18;
        com.bytedance.android.livesdk.chatroom.o r22 = m.i();
        if (r22 == null) goto L18;
        com.bytedance.live.datacontext.m r23 = r22.getCleanMode();
        if (r23 == null) goto L18;
        if (((Number) r23.getValue()).intValue() != 2) goto L18;
        if (vm2.e.h() == false) goto L18;
        ALogger.w("KtvRoomContainerBaseWidget", "rejected guest stub click for pure clean mode");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget
    public void onLoad(Object[] r3) {
        super.onLoad(r3);
        Pair r4 = com.bytedance.live.datacontext.d.a(KtvRoomContainerBaseWidget$initGuestApplyViewModel$1.INSTANCE);
        GuestApplyViewModel r0 = (GuestApplyViewModel) r4.component1();
        Disposable r5 = (Disposable) r4.component2();
        com.bytedance.live.datacontext.b.a(r0, "GuestApplyViewModel");
        this.m.add(r5);
        Pair r6 = com.bytedance.live.datacontext.d.a(KtvRoomContainerBaseWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r1 = (AdminInviteAndApplyViewModel) r6.component1();
        Disposable r7 = (Disposable) r6.component2();
        com.bytedance.live.datacontext.b.a(r1, "AdminInviteAndApplyViewModel");
        this.m.add(r7);
    }

    public static void Bq(boolean r2, int r3) {
        if (o.I() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L11;
        r0.showInviteAndPermitDialog(r2, "seat", r3);
        return;
    L11:
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L13;
        r1.showInviteDialog(r2, "seat", r3);
        return;
    }

    public final void L8(int r6, boolean r7) {
        if (this.q.isAnchor() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L72;
        r0.showInviteAndPermitDialog(r7, "seat", r6);
        return;
    L72:
        return;
    L7:
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L11;
    L42:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L46;
    L57:
        int r8 = bh0.a.a;
        if (r7 == false) goto L60;
        int r9 = 104;
    L61:
        ALogger.d("KtvRoomContainerBaseWidget", "tryCheckAndApply position applySource fromSource : -1 - " + r9 + " - linkin_empty_stub_click");
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r10 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r10 == null) goto L74;
        r10.checkAndApply(-1, String.valueOf(r9), LinkApplyType.NORMAL.getValue(), "linkin_empty_stub_click");
        return;
    L74:
        return;
    L60:
        r9 = 101;
        goto L61
    L46:
        if (2 != r2.intValue()) goto L57;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r3 == null) goto L52;
        MuteStateChecker r4 = r3.muteChecker();
        if (r4 == null) goto L52;
        r4.a("empty_stub", false);
    L52:
        if (r7 == false) goto L55;
        Bq(r7, -1);
        return;
    L55:
        Bq(r7, r6);
        return;
    L11:
        if (1 != r1.intValue()) goto L42;
        if (h.U().a() == false) goto L19;
        IRoom r11 = getMRoom();
        if (r11 == null) goto L65;
        ILinkPanelService r5 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r5 == null) goto L66;
        ILinkPanelService.a.a(r5, ((Widget) this).context, r11, null, "seat");
        return;
    L66:
        return;
    L65:
        return;
    L19:
        Map r12 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.h(PanelType.APPLY_PANEL, 0);
        if (this.i != null) goto L28;
        com.bytedance.android.livesdk.chatroom.o r13 = m.i();
        if (r13 == null) goto L26;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L26;
        IRoom r15 = (IRoom) r14.getValue();
    L27:
        int r16 = GuestApplyDialog.o;
        Function0<Unit> r17 = new KtvRoomContainerBaseWidget$showNewGuestApplyDialog$2(this);
        GuestApplyDialog r18 = new GuestApplyDialog();
        r18.d = r15;
        r18.g = -1;
        r18.e = r17;
        this.i = r18;
    L26:
        r15 = null;
    L28:
        GuestApplyDialog r19 = this.i;
        if (r19 != null) goto L31;
    L38:
        GuestApplyDialog r20 = this.i;
        if (r20 == null) goto L71;
        r20.show(((Widget) this).context, "seat");
        return;
    L71:
        return;
    L31:
        if (r19.isShowing() != true) goto L38;
        GuestApplyDialog r21 = this.i;
        if (r21 == null) goto L68;
        GuestApplyTopBarWidget r22 = r21.l;
        if (r22 != null) goto L37;
        r21.f = null;
        return;
    L37:
        r22.wq(null);
        return;
    }

    public final void Tf(IBaseUser r9, boolean r10) {
        if (r10 == false) goto L6;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L16;
        r11.put("cmd_audio_talk_invite", r9);
        return;
    L16:
        return;
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        ArrayList r12 = new ArrayList();
        r12.add(r9.getIdString());
        LinkAnchorApi r1 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        IRoom r0 = getMRoom();
        if (r0 == null) goto L11;
        long r2 = r0.getId();
    L12:
        Disposable r13 = r1.inviteFriends(r2, new JSONArray(r12).toString(), 1, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r9), d.a);
        if (r13 == null) goto L18;
        RxUtilKt.c(r13, this.m);
        return;
    L18:
        return;
    L11:
        r2 = 0;
        goto L12
    }

    public final void mo(int r2, IBaseUser r3) {
        w0 r0 = this.D;
        if (r0 == null) goto L9;
        if (r2 <= 0) goto L6;
        boolean r4 = true;
    L7:
        r0.Mc(r3, r4);
        return;
    L6:
        r4 = false;
        goto L7
    }

    public KtvRoomContainerBaseWidget(com.bytedance.android.live.pushstream.d r1, WidgetManager r2, com.bytedance.android.live.liveinteract.plantform.datamerge.d r3, KtvContext r4, w0 r5, y r6, InteractAnimationController r7, j1 r8) {
        this.A = r1;
        this.B = r2;
        this.C = r3;
        this.D = r5;
        this.E = r6;
        this.F = r7;
        this.G = r8;
        this.c = LazyKt.lazy(KtvRoomContainerBaseWidget$guestApplyViewModel$2.INSTANCE);
        this.m = new CompositeDisposable();
        if (r4 != null) goto L5;
        r4 = new KtvContext();
    L5:
        this.p = r4;
        sb0.b.a.getClass();
        Pair r9 = sb0.b.a.a();
        sb0.b r10 = (sb0.b) r9.getFirst();
        r4.getDataEntity().d(r10);
        Unit r11 = Unit.INSTANCE;
        this.q = r10;
        this.r = (sb0.a) r9.getSecond();
        this.s = new l(r8);
        this.t = r4.getBizLcMager();
        this.x = new b(this);
    }
}
