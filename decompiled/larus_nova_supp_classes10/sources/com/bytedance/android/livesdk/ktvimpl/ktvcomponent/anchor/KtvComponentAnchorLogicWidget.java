package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.broadcast.api.AnchorInteractionData;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.c2;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvapi.model.PanelType;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.KSongSettingViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.jg;
import com.bytedance.android.livesdk.message.model.kh;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdk.message.model.ll;
import com.bytedance.android.livesdk.message.model.nn;
import com.bytedance.android.livesdk.model.KtvChallengeProperty;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.x;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty1;
import nz.f0;
import nz.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/anchor/KtvComponentAnchorLogicWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "CloseSource", "a", "OpenSource", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentAnchorLogicWidget extends HolderRoomWidget implements vlc.l, Observer<KVData> {
    public static final /* synthetic */ int q = 0;
    public boolean d;
    public final IRoom e;
    public KtvComponentContext f;
    public final CompositeDisposable g;
    public final he2.a h;
    public boolean i;
    public final he2.a j;
    public KtvComponentUIWidget k;
    public MultiChorusWidget l;
    public long m;
    public boolean n;
    public final h o;
    public final AbsKtvControlWidget.a p;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/anchor/KtvComponentAnchorLogicWidget$CloseSource;", "", "", "value", "I", "getValue", "()I", "NOTHING", "MANUAL", "NOT_MANUAL", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CloseSource extends Enum<CloseSource> {
        public static final CloseSource MANUAL = null;
        public static final CloseSource NOTHING = null;
        public static final CloseSource NOT_MANUAL = null;
        public static final /* synthetic */ CloseSource[] a = null;
        private final int value;

        static {
            CloseSource r1 = new CloseSource("NOTHING", 0, 0);
            NOTHING = r1;
            CloseSource r2 = new CloseSource("MANUAL", 1, 1);
            MANUAL = r2;
            CloseSource r3 = new CloseSource("NOT_MANUAL", 2, 2);
            NOT_MANUAL = r3;
            a = new CloseSource[]{r1, r2, r3};
        }

        public static CloseSource valueOf(String r1) {
            return (CloseSource) r27.a.a(CloseSource.class, r1);
        }

        public static CloseSource[] values() {
            return (CloseSource[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public CloseSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/anchor/KtvComponentAnchorLogicWidget$OpenSource;", "", "", "value", "I", "getValue", "()I", "UNKNOW", "NORMAL", "AUTO", "CHORUS", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OpenSource extends Enum<OpenSource> {
        public static final OpenSource AUTO = null;
        public static final OpenSource CHORUS = null;
        public static final OpenSource NORMAL = null;
        public static final OpenSource UNKNOW = null;
        public static final /* synthetic */ OpenSource[] a = null;
        private final int value;

        static {
            OpenSource r1 = new OpenSource("UNKNOW", 0, 0);
            UNKNOW = r1;
            OpenSource r2 = new OpenSource("NORMAL", 1, 1);
            NORMAL = r2;
            OpenSource r3 = new OpenSource("AUTO", 2, 2);
            AUTO = r3;
            OpenSource r4 = new OpenSource("CHORUS", 3, 3);
            CHORUS = r4;
            a = new OpenSource[]{r1, r2, r3, r4};
        }

        public static OpenSource valueOf(String r1) {
            return (OpenSource) r27.a.a(OpenSource.class, r1);
        }

        public static OpenSource[] values() {
            return (OpenSource[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public OpenSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentAnchorLogicWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef d;
        public final /* synthetic */ boolean e;

        public b(KtvComponentAnchorLogicWidget r1, long r2, String r4, Ref.ObjectRef r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r10) {
            com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.APICloseKtvComponent, System.currentTimeMillis() - this.b, ((ExtraResponse) r11).logId);
            int r0 = mb0.f.a;
            String r12 = ((ExtraResponse) r11).logId;
            String r1 = this.c;
            Intrinsics.checkNotNullParameter(r12, "logId");
            JSONObject r7 = new JSONObject();
            r7.put("logId", r12);
            if (r1 == null) goto L5;
            r7.put("source", r1);
        L5:
            int r13 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "ktvComponentClose", 0, null, r7, 88);
            x0 r14 = (x0) this.d.element;
            if (r14 == null) goto L24;
            Handler r2 = DialogLancet.resolveDialogHandler(r14);
            if (r2 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r14);
            r14.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r14);
            goto L24
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r14);
            throw th;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r3 == null) goto L21;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
            goto L21
        L10:
            if (Looper.myLooper() == r2.getLooper()) goto L12;
            r2.post(DialogLancet.createDismissRunnable(r14));
        L24:
            KtvComponentAnchorLogicWidget r15 = this.a;
            boolean r4 = this.e;
            String r5 = this.c;
            int r6 = KtvComponentAnchorLogicWidget.q;
            r15.Gq(r4, r5);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvComponentAnchorLogicWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef d;

        public c(KtvComponentAnchorLogicWidget r1, long r2, String r4, Ref.ObjectRef r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            this.a.i = true;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.APICloseKtvComponent, System.currentTimeMillis() - this.b, r11);
            int r0 = mb0.f.a;
            String r1 = this.c;
            Intrinsics.checkNotNullParameter(r11, "throwable");
            JSONObject r7 = new JSONObject();
            if (r1 == null) goto L5;
            r7.put("source", r1);
        L5:
            nd0.c.a.getClass();
            Pair r2 = nd0.c.t(r11, r7);
            int r3 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "ktvComponentClose", ((Number) r2.getFirst()).intValue(), (String) r2.getSecond(), r7, 64);
            x0 r4 = (x0) this.d.element;
            if (r4 == null) goto L24;
            Handler r5 = DialogLancet.resolveDialogHandler(r4);
            if (r5 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r4);
            r4.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r4);
            goto L24
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r6 == null) goto L21;
            com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r4);
            throw th;
        L10:
            if (Looper.myLooper() == r5.getLooper()) goto L12;
            r5.post(DialogLancet.createDismissRunnable(r4));
        L24:
            ExceptionUtils.handleException(((Widget) this.a).context, r11);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            final com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            ALogger.i("KtvComponentAnchorLogicWidget", "updateRealTimeChorusSwitch success");
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L5;
            com.bytedance.android.livesdk.ktvapi.util.d.b(r0, new KtvComponentAnchorLogicWidget$handleOpenVideoChorus$1$1(r4));
        L5:
            f2.c(s1.B(2131918638), 0);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            ALogger.i("KtvComponentAnchorLogicWidget", "updateRealTimeChorusSwitch error: " + ((Throwable) r3).getMessage());
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ KtvComponentAnchorLogicWidget a;

        public f(KtvComponentAnchorLogicWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r23) {
            Boolean r1 = (Boolean) r23;
            if (r1 == null) goto L70;
            long r4 = 0;
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L34;
            KtvComponentOrderedSongDataContext r2 = KtvComponentOrderedSongDataContext.Companion.getContext();
            if (r2 == null) goto L29;
            List<SongUniqueInfo> r3 = r2.getSelfKtvSongUniqueInfoList();
            if (r3 == null) goto L29;
            if ((!r3.isEmpty()) != true) goto L29;
            long r8 = System.currentTimeMillis();
            int r5 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
            com.bytedance.android.live.ktv.common.karaokestation.model.g r7 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
            com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
            if (r6 == null) goto L18;
            IRoom r9 = (IRoom) r6.getValue();
            if (r9 == null) goto L18;
            long r10 = r9.getId();
        L19:
            com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
            if (r11 == null) goto L24;
            IRoom r12 = (IRoom) r11.getValue();
            if (r12 == null) goto L24;
            r4 = r12.getId();
        L24:
            long r13 = r4;
            String r14 = gh0.a.c();
            if (r14 != null) goto L27;
            String r16 = "";
        L28:
            r7.e(r8, r10, r13, 0, r16, false, 0, 0, KtvComponentAnchorLogicWidget$onCreate$2$1.INSTANCE, KtvComponentAnchorLogicWidget$onCreate$2$2.INSTANCE);
            goto L29
        L27:
            r16 = r14;
        L18:
            r10 = 0;
        L29:
            this.a.Nq("open_video_chorus");
            DataCenter r15 = ((Widget) this.a).dataCenter;
            if (r15 == null) goto L32;
            r15.put("cmd_ktv_component_init_link", new c2(8, 63, 36));
        L32:
            xs2.b.a().post(new jd2.f(PanelType.ORDER_SONG_PANEL.getValue(), 14));
            return;
        L34:
            if (Intrinsics.areEqual(r1, Boolean.FALSE) == true) goto L36;
            return;
        L36:
            if (this.a.d == false) goto L69;
            KtvComponentOrderedSongDataContext r17 = KtvComponentOrderedSongDataContext.Companion.getContext();
            if (r17 == null) goto L59;
            List<SongUniqueInfo> r18 = r17.getSelfKtvSongUniqueInfoList();
            if (r18 == null) goto L59;
            if ((!r18.isEmpty()) != true) goto L59;
            long r19 = System.currentTimeMillis();
            int r20 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
            com.bytedance.android.live.ktv.common.karaokestation.model.g r21 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
            com.bytedance.live.datacontext.m r22 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
            if (r22 == null) goto L48;
            IRoom r24 = (IRoom) r22.getValue();
            if (r24 == null) goto L48;
            long r110 = r24.getId();
        L49:
            com.bytedance.live.datacontext.m r25 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
            if (r25 == null) goto L54;
            IRoom r26 = (IRoom) r25.getValue();
            if (r26 == null) goto L54;
            r4 = r26.getId();
        L54:
            long r111 = r4;
            String r27 = gh0.a.c();
            if (r27 != null) goto L57;
            String r112 = "";
        L58:
            r21.e(r19, r110, r111, 0, r112, false, 0, 0, KtvComponentAnchorLogicWidget$onCreate$2$3.INSTANCE, KtvComponentAnchorLogicWidget$onCreate$2$4.INSTANCE);
            goto L59
        L57:
            r112 = r27;
        L48:
            r110 = 0;
        L59:
            KtvComponentAnchorLogicWidget r28 = this.a;
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r29 = KtvComponentContext.Companion.a();
            if (r29 == null) goto L64;
            com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r30 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r29.getValue();
            if (r30 == null) goto L64;
            Boolean r31 = Boolean.valueOf(r30.a);
        L65:
            KtvComponentAnchorLogicWidget.Eq(r28, "close_video_chorus", r31);
            return;
        L64:
            r31 = null;
            goto L65
        L69:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ KtvComponentAnchorLogicWidget a;

        public g(KtvComponentAnchorLogicWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            sh6.b r8 = (sh6.b) r7;
            if (sh6.c.b(r8) == null) goto L38;
            jd2.g r0 = (jd2.g) sh6.c.b(r8);
            if (r0 != null) goto L8;
        L10:
            jd2.g r1 = (jd2.g) sh6.c.b(r8);
            if (r1 != null) goto L13;
            return;
        L13:
            if (r1.a == true) goto L35;
            final KtvComponentAnchorLogicWidget r2 = this.a;
            final jd2.g r9 = (jd2.g) sh6.c.b(r8);
            int r3 = KtvComponentAnchorLogicWidget.q;
            r2.getClass();
            if (r9 != null) goto L18;
            return;
        L18:
            if (r9.b == false) goto L31;
            String r4 = s1.B(2131918193);
            int r5 = r9.d;
            if (r5 != 1) goto L23;
            r4 = s1.B(2131918490);
        L28:
            x0 r10 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.f(((Widget) r2).context, s1.C(2131923068, new Object[]{r4}), s1.B(2131923066), new KtvComponentAnchorLogicWidget$handleCloseVideoChorus$1(r2, r9), new KtvComponentAnchorLogicWidget$handleCloseVideoChorus$2(r9));
            if (r10 == null) goto L36;
            KtvComponentAnchorLogicWidget.wq(r10);
            return;
        L36:
            return;
        L23:
            if (r5 != 8) goto L26;
            r4 = s1.B(2131918193);
            goto L28
        L26:
            if (r5 != 12) goto L28;
            r4 = s1.B(2131918629);
            goto L28
        L31:
            r2.Iq(r9);
            return;
        L35:
            return;
        L8:
            if (r0.a != true) goto L10;
            KtvComponentAnchorLogicWidget r11 = this.a;
            int r6 = KtvComponentAnchorLogicWidget.q;
            r11.Mq();
            return;
        }
    }

    public static final class h<T> implements Observer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            RevPkState r2 = (RevPkState) r1;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KtvComponentAnchorLogicWidget a;
        public final /* synthetic */ jd2.g b;

        public i(KtvComponentAnchorLogicWidget r1, jd2.g r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            final com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            ALogger.i("KtvComponentAnchorLogicWidget", "updateRealTimeChorusSwitch success");
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L6;
            com.bytedance.android.livesdk.ktvapi.util.d.b(r0, new KtvComponentAnchorLogicWidget$realCloseVideoChorus$1$1(r4));
        L6:
            if (((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.n) ((ExtraResponse) r4).data).a() == true) goto L21;
            jd2.g r5 = this.b;
            if (r5.d != 1) goto L10;
        L11:
            IMultiLinkInternalService r6 = jc1.k.f(IMultiLinkInternalService.class);
            cg6.a r1 = null;
            if (r6 == null) goto L14;
            r1 = r6.getMultiLinkComponentService(((Widget) this.a).dataCenter, null);
        L14:
            if (r1 == null) goto L18;
            vb6.g r7 = r1.O5();
            if (r7 == null) goto L18;
            r7.X0(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.j(this), false);
        L18:
            rj0.k.m2.getClass();
            rj0.k r8 = rj0.k.a.a();
            if (r8 == null) goto L21;
            rj0.k.b.a(r8);
            goto L21
        L10:
            if (r5.c == true) goto L11;
        L21:
            this.b.g.accept(Boolean.TRUE);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ jd2.g a;

        public j(jd2.g r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.i("KtvComponentAnchorLogicWidget", "updateRealTimeChorusSwitch error: " + ((Throwable) r3).getMessage());
            this.a.g.accept(Boolean.FALSE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.KtvComponentAnchorLogicWidget$onCreate$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d.class, "openRealtimeChorusSwitch", "getOpenRealtimeChorusSwitch()Z", 0);
        }

        public Object get(Object r1) {
            return Boolean.valueOf(((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1).e);
        }
    }

    static {
    }

    public final boolean Bq() {
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.e != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void Kq() {
        KtvContext.Companion.getClass();
        KtvContext.a.n(1);
        KtvComponentContext r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r1 = r0.getKtvComponentStatus();
        if (r1 == null) goto L7;
        r1.setValue(0);
    L7:
        KtvContext r2 = KtvContext.a.g();
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.m<Integer> r3 = r2.getKtvComponentStatus();
        if (r3 == null) goto L12;
        r3.setValue(0);
    L12:
        Nq("auto");
    }

    public final void Mq() {
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        KtvComponentContext r1 = r0.getContext();
        Integer r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r3 = r1.getKtvComponentStatus();
        if (r3 == null) goto L7;
        Integer r4 = (Integer) r3.getValue();
    L9:
        if (r4 != null) goto L12;
    L20:
        KtvComponentContext r5 = r0.getContext();
        if (r5 == null) goto L25;
        com.bytedance.live.datacontext.n<Integer> r6 = r5.getKtvComponentStatus();
        if (r6 == null) goto L25;
        r2 = (Integer) r6.getValue();
    L25:
        if (r2 != null) goto L28;
    L29:
        zq(new x(1, null, "webcast_open_live", null, Boolean.FALSE, "webcast_open_live", null, Boolean.TRUE, 74));
        return;
    L28:
        if (r2.intValue() != 1) goto L29;
        return;
    L12:
        if (r4.intValue() != 1) goto L20;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r7 = r0.a();
        if (r7 == null) goto L20;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r8 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r7.getValue();
        if (r8 == null) goto L20;
        if (r8.e == true) goto L20;
        Aq();
        return;
    L7:
        r4 = null;
        goto L9
    }

    public final void onDestroy() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        KtvComponentContext r1 = this.f;
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.n<Integer> r2 = r1.getKtvComponentStatus();
        if (r2 == null) goto L10;
        Integer r3 = (Integer) r2.getValue();
    L11:
        if (r3 != null) goto L14;
    L64:
        KtvComponentContext r4 = this.f;
        if (r4 == null) goto L69;
        com.bytedance.live.datacontext.n<Integer> r5 = r4.getOpenSource();
        if (r5 == null) goto L69;
        r5.setValue(null);
    L69:
        super.onDestroy();
        this.g.dispose();
        vlc.d r6 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r6 == null) goto L72;
        r6.removeMessageListener(this);
    L72:
        IMultiLinkServiceExternal r7 = jc1.k.f(IMultiLinkServiceExternal.class);
        if (r7 == null) goto L78;
        yr0.f r8 = r7.getPkServiceExternal();
        if (r8 == null) goto L79;
        r8.c(this.o);
        return;
    L79:
        return;
    L78:
        return;
    L14:
        if (r3.intValue() != 1) goto L64;
        KtvComponentContext r9 = this.f;
        if (r9 == null) goto L20;
        com.bytedance.live.datacontext.n<Boolean> r10 = r9.isAudienceEnableSing();
        if (r10 == null) goto L20;
        Boolean r11 = (Boolean) r10.getValue();
    L22:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L24;
        String r12 = "on";
    L25:
        String r13 = r12;
        long r14 = (System.currentTimeMillis() - this.m) / 1000;
        com.bytedance.android.livesdk.chatroom.o r15 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        int r16 = 0;
        int r17 = 0;
        if (r15 == null) goto L30;
        com.bytedance.live.datacontext.i r18 = r15.getLiveMode();
        if (r18 == null) goto L30;
        LiveMode r19 = (LiveMode) r18.getValue();
    L32:
        if (r19 != LiveMode.VIDEO) goto L42;
        u r20 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r20 == null) goto L49;
        com.bytedance.live.datacontext.j r21 = r20.getVideoTalkRoomSubScene();
        if (r21 == null) goto L49;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r21.getValue();
        if (r22 == null) goto L49;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r23 = r22.h();
        if (r23 == null) goto L49;
        r16 = Integer.valueOf(r23.a);
        r17 = Integer.valueOf(r23.c);
    L49:
        String r24 = jc1.k.n(IInteractService.class).getFunctionType2BeforeReset();
        String r25 = "audience";
        if (Intrinsics.areEqual("audience", r24) == true) goto L53;
        r25 = KtvLoggerHelper.D(r16, r17);
    L53:
        String r26 = r25;
        int r27 = ke2.b.a;
        KtvComponentContext r28 = this.f;
        if (r28 == null) goto L57;
        String r29 = r28.getSource();
        if (r29 == null) goto L57;
    L63:
        ke2.b.c("live_end", r13, r14, r26, r24, ke2.a.g(r29));
    L57:
        KtvComponentContext r30 = this.f;
        if (r30 == null) goto L62;
        com.bytedance.live.datacontext.n<String> r31 = r30.getFromSource();
        if (r31 == null) goto L62;
        r29 = (String) r31.getValue();
    L62:
        r29 = null;
        goto L63
    L42:
        u r32 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r32 == null) goto L49;
        com.bytedance.live.datacontext.j r33 = r32.s();
        if (r33 == null) goto L49;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r34 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r33.getValue();
        if (r34 == null) goto L49;
        r34.e();
    L30:
        r19 = null;
        goto L32
    L24:
        r12 = "off";
    L20:
        r11 = null;
    L10:
        r3 = null;
        goto L11
    }

    public final void Aq() {
        if (Bq() == false) goto L5;
        return;
    L5:
        Disposable r0 = ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateRealTimeChorusSwitch(com.bytedance.android.live.ktv.common.util.a.a().getRoomId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(d.a, e.a);
        if (r0 == null) goto L9;
        RxUtilKt.c(r0, this.g);
        return;
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(KtvComponentAnchorLogicWidget$initDataContext$pair$1.INSTANCE);
        KtvComponentContext r1 = (KtvComponentContext) r0.getFirst();
        this.g.add((Disposable) r0.getSecond());
        com.bytedance.live.datacontext.b.a(r1, KtvComponentContext.class);
        this.f = r1;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b> r2 = r1.getKSongSettingViewModel();
        if (r2 == null) goto L5;
        KSongSettingViewModel.Companion.getClass();
        r2.setValue(KSongSettingViewModel.a.a(this));
    L5:
        KtvComponentContext.a r3 = KtvComponentContext.Companion;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r4 = r3.a();
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r4, this, KtvComponentAnchorLogicWidget$initDataContext$1.INSTANCE, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.c.a);
    L8:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r5 = r3.a();
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r5, this, KtvComponentAnchorLogicWidget$initDataContext$3.INSTANCE, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.d(this));
    L11:
        ArrayList r6 = null;
        vlc.d r7 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r7 == null) goto L14;
        r7.addMessageListener(MessageType.KTV_MESSAGE.getIntType(), this);
    L14:
        KtvContext.Companion.getClass();
        boolean r8 = true;
        Lq(!v.a(((Number) KtvContext.a.g().getKtvAllState().getValue()).intValue(), 8));
        Lazy r9 = KtvSettingHelper.a;
        u r10 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r10 == null) goto L26;
        com.bytedance.live.datacontext.j r11 = r10.s();
        if (r11 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r11.getValue();
        if (r12 == null) goto L26;
        BehaviorSubject r13 = r12.a();
        if (r13 == null) goto L26;
        Disposable r14 = r13.subscribe(new l(this));
        if (r14 == null) goto L26;
        RxUtilKt.c(r14, this.g);
    L26:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c == false) goto L32;
        x r15 = (x) KtvContext.a.g().getKtvComponentCmdForAnchor().getValue();
        if (r15 == null) goto L30;
        zq(r15);
    L30:
        KtvContext.a.g().getKtvComponentCmdForAnchor().setValue(null);
    L32:
        if (vm2.h.l() == false) goto L44;
        u r16 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r16 == null) goto L44;
        com.bytedance.live.datacontext.j r17 = r16.s();
        if (r17 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r18 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r17.getValue();
        if (r18 == null) goto L44;
        BehaviorSubject r19 = r18.a();
        if (r19 == null) goto L44;
        Disposable r20 = r19.subscribe(new m(this));
        if (r20 == null) goto L44;
        RxUtilKt.c(r20, this.g);
    L44:
        KtvComponentContext r21 = r3.getContext();
        if (r21 == null) goto L53;
        com.bytedance.live.datacontext.n<x> r22 = r21.getKtvComponentCmd();
        if (r22 == null) goto L53;
        Observable r23 = r22.a();
        if (r23 == null) goto L53;
        ObservableSubscribeProxy r24 = (ObservableSubscribeProxy) r23.as(autoDispose());
        if (r24 == null) goto L53;
        r24.subscribe(new n(this));
    L53:
        KtvContext r25 = KtvContext.a.g();
        if (r25 == null) goto L62;
        com.bytedance.live.datacontext.k<kh> r26 = r25.getOpenKtvEvent();
        if (r26 == null) goto L62;
        PublishSubject r27 = r26.onEvent();
        if (r27 == null) goto L62;
        ObservableSubscribeProxy r28 = (ObservableSubscribeProxy) r27.as(autoDispose());
        if (r28 == null) goto L62;
        final KtvComponentAnchorLogicWidget$subscribeAll$6 r29 = new KtvComponentAnchorLogicWidget$subscribeAll$6(this);
        r28.subscribe(new k(r29));
    L62:
        IMultiLinkServiceExternal r30 = jc1.k.f(IMultiLinkServiceExternal.class);
        if (r30 == null) goto L67;
        yr0.f r31 = r30.getPkServiceExternal();
        if (r31 == null) goto L67;
        r31.a(this.o);
    L67:
        KtvContext r32 = KtvContext.a.g();
        if (r32 == null) goto L76;
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.base.util.i> r33 = r32.getKtvContainerPositionUpdateEvent();
        if (r33 == null) goto L76;
        PublishSubject r34 = r33.onEvent();
        if (r34 == null) goto L76;
        Disposable r35 = r34.subscribe(new o(this));
        if (r35 == null) goto L76;
        RxUtilKt.c(r35, this.g);
    L76:
        MultiChorusWidget r36 = new MultiChorusWidget();
        this.l = r36;
        AbsKtvControlWidget.a r37 = this.p;
        AbsKtvControlWidget.WidgetType r38 = AbsKtvControlWidget.WidgetType.MULTI_CHORUS;
        Intrinsics.checkNotNull(r36);
        r37.a(r38, r36);
        MultiChorusWidget r39 = this.l;
        Intrinsics.checkNotNull(r39);
        r39.Aq(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.e(this));
        z5 r40 = this.e.getLinkerDetail();
        if (r40 == null) goto L81;
        List<Long> r41 = r40.getPlayModes();
        if (r41 == null) goto L81;
        boolean r42 = r41.contains(Long.valueOf(21));
    L82:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAnchorLogicWidget:getSettingIfNeed, linkerDetail.playModes contains = " + r42);
        if (r42 == false) goto L86;
        long r43 = System.currentTimeMillis();
        this.g.add(((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).getAudienceSingEnableSetting(this.e.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.a(this, r43), new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.b(r43)));
    L86:
        if (KtvCommonSettingHelper.b() == true) goto L88;
    L96:
        t r44 = o3.a();
        if (r44 == null) goto L101;
        com.bytedance.live.datacontext.n r45 = r44.a();
        if (r45 == null) goto L101;
        r6 = (ArrayList) r45.getValue();
    L101:
        if (r6 != null) goto L103;
    L105:
        r8 = false;
    L106:
        if (r8 == false) goto L108;
        UtilityKotlinExtentionsKt.s(0, false, true, new KtvComponentAnchorLogicWidget$checkPreViewSchema$2(this), 3);
    L119:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r46 = r3.a();
        if (r46 == null) goto L122;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r46, this, AnonymousClass1.INSTANCE, new f(this));
    L122:
        KtvComponentContext r47 = r3.getContext();
        if (r47 == null) goto L131;
        com.bytedance.live.datacontext.n<jd2.g> r48 = r47.getEnableVideoChorus();
        if (r48 == null) goto L131;
        Observable r49 = r48.a();
        if (r49 == null) goto L131;
        Disposable r50 = r49.subscribe(new g(this));
        if (r50 == null) goto L131;
        RxUtilKt.c(r50, this.g);
    L131:
        DataCenter r51 = ((Widget) this).dataCenter;
        if (r51 == null) goto L134;
        r51.observe("cmd_enable_video_chorus_in_critical", this);
    L134:
        DataCenter r52 = ((Widget) this).dataCenter;
        if (r52 == null) goto L138;
        r52.observe("data_cloud_group_live_pipeline_status", this);
        return;
    L138:
        return;
    L108:
        u r53 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r53 == null) goto L119;
        com.bytedance.live.datacontext.n r54 = r53.C();
        if (r54 == null) goto L119;
        Pair r55 = (Pair) r54.getValue();
        if (r55 == null) goto L119;
        Integer r56 = (Integer) r55.getFirst();
        if (r56 == null) goto L119;
        if (r56.intValue() <= 0) goto L119;
        UtilityKotlinExtentionsKt.s(0, false, true, new KtvComponentAnchorLogicWidget$checkPreViewSchema$$inlined$let$lambda$1(this), 3);
        goto L119
    L103:
        if (r6.contains(21) == false) goto L105;
    L88:
        if (this.e.isLiveTypeAudio() == true) goto L96;
        if (qe2.d.a() != 0) goto L96;
        com.bytedance.live.datacontext.m r57 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).u();
        if (r57 == null) goto L96;
        if (((Number) r57.getValue()).intValue() != 36) goto L96;
        UtilityKotlinExtentionsKt.s(0, false, true, new KtvComponentAnchorLogicWidget$checkPreViewSchema$1(this), 3);
    L81:
        r42 = false;
        goto L82
    }

    public KtvComponentAnchorLogicWidget(AbsKtvControlWidget.a r3) {
        Intrinsics.checkNotNullParameter(r3, "loader");
        this.p = r3;
        this.e = com.bytedance.android.live.ktv.common.util.a.c();
        this.g = new CompositeDisposable();
        this.h = new he2.a("more", new KtvComponentAnchorLogicWidget$moreAccessBehavior$1(this));
        this.j = new he2.a("interact", new KtvComponentAnchorLogicWidget$interactAccessBehavior$1(this));
        this.o = h.a;
    }

    public static void wq(x0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void Fq(MusicPanel r4) {
        KtvComponentUIWidget r0 = this.k;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "musicPanel");
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = KtvComponentOrderSongDataContext.Companion.a();
        if (r1 == null) goto L9;
        r1.addSong(((Widget) r0).context, r4, null, null);
        return;
    L9:
        return;
    }

    public final void Iq(jd2.g r5) {
        Disposable r6 = ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateRealTimeChorusSwitch(com.bytedance.android.live.ktv.common.util.a.a().getRoomId(), false).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r5), new j(r5));
        if (r6 == null) goto L6;
        RxUtilKt.c(r6, this.g);
        return;
    }

    public final void Jq(boolean r10) {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        w r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r2 = r0.getAnchorRoomScopeViewModel();
        if (r2 == null) goto L7;
        nz.l r3 = (nz.l) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        r1 = (w) r3.a();
    L10:
        if (r10 == false) goto L12;
        int r11 = nz.b.a.a;
    L13:
        if (r1 == null) goto L16;
        int r12 = f0.a.b;
        int r13 = nz.a.a.a;
        new AnchorInteractionData(null, 6L, 20L, null, 9, null);
        r1.a();
        return;
    L16:
        return;
    L12:
        int r14 = nz.b.b.a;
    L7:
        r3 = null;
        goto L8
    }

    public final void Lq(boolean r3) {
        Lazy r0 = KtvSettingHelper.a;
        if (((Boolean) KtvSettingHelper.j.getValue()).booleanValue() == false) goto L6;
        if (r3 == false) goto L6;
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.KTV, this.j);
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.BGM, this.h);
        return;
    L6:
        y3.f(((Widget) this).dataCenter).d(ToolbarButton.KTV, this.j);
        y3.f(((Widget) this).dataCenter).d(ToolbarButton.BGM, this.h);
    }

    public final void Nq(String r3) {
        ALogger.i("KtvComponentAnchorLogicWidget", "unloadComponentUIWidget, source=".concat(r3));
        boolean r4 = Intrinsics.areEqual(r3, "open_video_chorus");
        this.d = r4;
        if (r4 == false) goto L17;
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r5 = KtvContext.a.g().getKtvCoreController();
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.i r6 = (com.bytedance.android.livesdk.ktvimpl.base.i) r5.getValue();
    L8:
        if (r6 == null) goto L10;
        r6.s();
    L10:
        if (r6 == null) goto L12;
        r6.l();
    L12:
        if (r6 == null) goto L14;
        r6.j();
    L14:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r7 = KtvContext.a.g().getKtvCoreController();
        if (r7 == null) goto L17;
        r7.setValue(null);
        goto L17
    L7:
        r6 = null;
    L17:
        KtvComponentUIWidget r8 = this.k;
        if (r8 == null) goto L20;
        this.p.k(r8);
        Jq(false);
    L20:
        this.k = null;
    }

    public final void Pq(boolean r9) {
        long r1 = System.currentTimeMillis();
        int r0 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.a;
        Disposable r10 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.C0018b.a.a(r1, this.e.getRoomId(), r9, KtvComponentAnchorLogicWidget$updateKtvComponentSetting$1.INSTANCE, KtvComponentAnchorLogicWidget$updateKtvComponentSetting$2.INSTANCE);
        if (r10 == null) goto L6;
        RxUtilKt.c(r10, this.g);
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 == null) goto L39;
        int r1 = r0.hashCode();
        if (r1 == 207962843) goto L19;
        if (r1 == 761234139) goto L14;
        return;
    L14:
        if (r0.equals("data_cloud_group_live_pipeline_status") == true) goto L16;
        return;
    L16:
        if (((CloudGroupLivePipelineStatus) r5.getData()) != CloudGroupLivePipelineStatus.START) goto L33;
        yq(true, "cloud group live start");
        return;
    L33:
        return;
    L19:
        if (r0.equals("cmd_enable_video_chorus_in_critical") == true) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual((Boolean) r5.getData(), Boolean.TRUE) == false) goto L24;
        Mq();
        return;
    L24:
        if (Intrinsics.areEqual((Boolean) r5.getData(), Boolean.FALSE) == true) goto L26;
        return;
    L26:
        if (Bq() == false) goto L41;
        Disposable r6 = ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateRealTimeChorusSwitch(com.bytedance.android.live.ktv.common.util.a.a().getRoomId(), false).compose(RxUtil.rxSchedulerHelper()).subscribe(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.f.a, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.g.a);
        if (r6 == null) goto L38;
        RxUtilKt.c(r6, this.g);
        return;
    L38:
        return;
    L41:
        return;
    L39:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r13) {
        if ((r13 instanceof l8) == false) goto L209;
        final l8 r14 = (l8) r13;
        boolean r1 = true;
        Integer r6 = null;
        String r7 = null;
        r7 = null;
        String r8 = null;
        String r9 = null;
        r9 = null;
        String r10 = null;
        r10 = null;
        r6 = null;
        switch(r14.getMessageType()) {
            case 7: goto L195;
            case 8: goto L192;
            case 9: goto L129;
            case 10: goto L81;
            case 11: goto L228;
            case 12: goto L228;
            case 13: goto L228;
            case 14: goto L64;
            case 15: goto L10;
            case 16: goto L7;
            default: goto L228;
        };
    L7:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L210;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r0, new KtvComponentAnchorLogicWidget$onKtvMessage$3(r14));
        return;
    L210:
        return;
    L10:
        jg r15 = r14.getMultiChorusWaitingListChangedContent();
        if (r15 == null) goto L13;
        long r11 = r15.a();
    L14:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r16 = KtvComponentOrderSongDataContext.Companion.a();
        if (r16 == null) goto L21;
        MutableLiveData<vb0.a> r17 = r16.getOrderSongUiState();
        if (r17 == null) goto L21;
        vb0.a r18 = (vb0.a) r17.getValue();
        if (r18 == null) goto L21;
        boolean r19 = r18.j;
    L22:
        if (r19 == false) goto L44;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r110 = KtvComponentOrderSongDataContext.Companion.b();
        if (r110 == null) goto L30;
        Pair r111 = r110.getSelectedFirstLevelTabValue();
        if (r111 == null) goto L30;
        Integer r112 = (Integer) r111.getFirst();
        if (r112 == null) goto L30;
        int r113 = r112.intValue();
    L31:
        FirstLevelTab r2 = FirstLevelTab.AudienceSingTab;
        if (r113 != r2.getValue()) goto L34;
        boolean r114 = true;
    L35:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = KtvComponentOrderSongDataContext.Companion.b();
        if (r3 == null) goto L40;
        y r4 = r3.getSelectedSecondLevelTabData(r2.getValue());
        if (r4 == null) goto L40;
        r7 = r4.c;
    L40:
        boolean r5 = Intrinsics.areEqual(r7, "multi_chorus");
        if (r114 == false) goto L44;
        if (r5 == false) goto L44;
    L45:
        if (r1 == true) goto L55;
        KtvComponentContext r115 = KtvComponentContext.Companion.getContext();
        if (r115 == null) goto L55;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r116 = r115.getKtvComponentUIContext();
        if (r116 == null) goto L55;
        KtvComponentUIContext r117 = (KtvComponentUIContext) r116.getValue();
        if (r117 == null) goto L55;
        MutableLiveData<Long> r118 = r117.getUnreadMultiChorusApplyNum();
        if (r118 == null) goto L55;
        r118.setValue(Long.valueOf(r11));
    L55:
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("KtvComponentAnchorLogicWidget", "onKtvMessage: MULTI_CHORUS_WAITING_LIST_CHANGED num " + r11);
        if (r11 <= 0) goto L212;
        KtvComponentContext r119 = this.f;
        if (r119 == null) goto L213;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r120 = r119.getKtvComponentUIContext();
        if (r120 == null) goto L214;
        KtvComponentUIContext r121 = (KtvComponentUIContext) r120.getValue();
        if (r121 == null) goto L215;
        r121.setLastApplyMsgType(15);
        return;
    L215:
        return;
    L214:
        return;
    L213:
        return;
    L212:
        return;
    L34:
        r114 = false;
    L30:
        r113 = FirstLevelTab.Unknown.getValue();
    L44:
        r1 = false;
    L21:
        r19 = false;
        goto L22
    L13:
        r11 = 0;
        goto L14
    L64:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r12 = KtvComponentContext.Companion.a();
        if (r12 == null) goto L67;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r12, new KtvComponentAnchorLogicWidget$onKtvMessage$2(r14));
    L67:
        com.bytedance.android.livesdk.message.model.f0 r20 = r14.getAudienceMultiChorusSettingChangedContent();
        if (r20 == null) goto L70;
        String r21 = r20.b();
    L71:
        if (r21 != null) goto L73;
    L76:
        if (r1 == true) goto L217;
        com.bytedance.android.livesdk.message.model.f0 r122 = r14.getAudienceMultiChorusSettingChangedContent();
        if (r122 == null) goto L80;
        r8 = r122.b();
    L80:
        f2.c(r8, 0);
        return;
    L217:
        return;
    L73:
        if (r21.length() == 0) goto L76;
        r1 = false;
        goto L76
    L70:
        r21 = null;
        goto L71
    L81:
        nn r123 = r14.getWantListenListChangedContent();
        if (r123 == null) goto L84;
        long r22 = r123.a();
    L85:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAnchorLogicWidget, onKtvMessage: wantListenListChanged, num=" + r22);
        if (r22 <= 0) goto L94;
        KtvComponentContext r124 = this.f;
        if (r124 == null) goto L94;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r125 = r124.getKtvComponentUIContext();
        if (r125 == null) goto L94;
        KtvComponentUIContext r126 = (KtvComponentUIContext) r125.getValue();
        if (r126 == null) goto L94;
        r126.setLastApplyMsgType(10);
    L94:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r127 = KtvComponentOrderSongDataContext.Companion.a();
        if (r127 == null) goto L101;
        MutableLiveData<vb0.a> r128 = r127.getOrderSongUiState();
        if (r128 == null) goto L101;
        vb0.a r129 = (vb0.a) r128.getValue();
        if (r129 == null) goto L101;
        boolean r130 = r129.j;
    L102:
        if (r130 == false) goto L124;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r131 = KtvComponentOrderSongDataContext.Companion.b();
        if (r131 == null) goto L110;
        Pair r132 = r131.getSelectedFirstLevelTabValue();
        if (r132 == null) goto L110;
        Integer r133 = (Integer) r132.getFirst();
        if (r133 == null) goto L110;
        int r134 = r133.intValue();
    L112:
        if (r134 != FirstLevelTab.OrderSongTab.getValue()) goto L114;
        boolean r135 = true;
    L115:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r23 = KtvComponentOrderSongDataContext.Companion.b();
        if (r23 == null) goto L120;
        y r24 = r23.getSelectedSecondLevelTabData(FirstLevelTab.OrderedSongTab.getValue());
        if (r24 == null) goto L120;
        r9 = r24.c;
    L120:
        boolean r25 = Intrinsics.areEqual(r9, "recommend");
        if (r135 == false) goto L124;
        if (r25 == false) goto L124;
    L125:
        if (r1 == true) goto L219;
        KtvComponentContext r136 = KtvComponentContext.Companion.getContext();
        if (r136 == null) goto L220;
        r136.updateListenApplyUnreadCount(r22);
        return;
    L220:
        return;
    L219:
        return;
    L114:
        r135 = false;
    L110:
        r134 = FirstLevelTab.Unknown.getValue();
    L124:
        r1 = false;
    L101:
        r130 = false;
        goto L102
    L84:
        r22 = 0;
        goto L85
    L129:
        ll r137 = r14.getSongWaitingListChangedContent();
        if (r137 == null) goto L132;
        long r26 = r137.a();
    L133:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r138 = KtvComponentOrderSongDataContext.Companion.a();
        if (r138 == null) goto L140;
        MutableLiveData<vb0.a> r139 = r138.getOrderSongUiState();
        if (r139 == null) goto L140;
        vb0.a r140 = (vb0.a) r139.getValue();
        if (r140 == null) goto L140;
        boolean r141 = r140.j;
    L141:
        if (r141 == false) goto L177;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r142 = KtvComponentOrderSongDataContext.Companion.b();
        if (r142 == null) goto L149;
        Pair r143 = r142.getSelectedFirstLevelTabValue();
        if (r143 == null) goto L149;
        Integer r144 = (Integer) r143.getFirst();
        if (r144 == null) goto L149;
        int r145 = r144.intValue();
    L150:
        FirstLevelTab r27 = FirstLevelTab.AudienceSingTab;
        if (r145 != r27.getValue()) goto L153;
        boolean r28 = true;
    L154:
        FirstLevelTab r146 = FirstLevelTab.OrderedSongTab;
        if (r145 != r146.getValue()) goto L157;
        boolean r147 = true;
    L158:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r148 = KtvComponentOrderSongDataContext.Companion.b();
        if (r148 == null) goto L163;
        y r149 = r148.getSelectedSecondLevelTabData(r146.getValue());
        if (r149 == null) goto L163;
        String r150 = r149.c;
    L164:
        boolean r151 = Intrinsics.areEqual(r150, "mine_want_sing");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r152 = KtvComponentOrderSongDataContext.Companion.b();
        if (r152 == null) goto L169;
        y r29 = r152.getSelectedSecondLevelTabData(r27.getValue());
        if (r29 == null) goto L169;
        r10 = r29.c;
    L169:
        boolean r30 = Intrinsics.areEqual(r10, "single_sing");
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L174;
        if (r28 == false) goto L177;
        if (r30 == false) goto L177;
    L179:
        if (r26 <= 0) goto L187;
        KtvComponentContext r153 = this.f;
        if (r153 == null) goto L187;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r154 = r153.getKtvComponentUIContext();
        if (r154 == null) goto L187;
        KtvComponentUIContext r155 = (KtvComponentUIContext) r154.getValue();
        if (r155 == null) goto L187;
        r155.setLastApplyMsgType(9);
    L187:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAnchorLogicWidget, onKtvMessage: waittingListChanged, num=" + r26 + ", isShowingApplyList=" + r1);
        if (r1 == true) goto L222;
        KtvComponentContext r156 = KtvComponentContext.Companion.getContext();
        if (r156 == null) goto L223;
        r156.updateSingApplyUnreadCount(r26);
        return;
    L223:
        return;
    L222:
        return;
    L174:
        if (r147 == false) goto L177;
        if (r151 == false) goto L177;
    L163:
        r150 = null;
        goto L164
    L157:
        r147 = false;
        goto L158
    L153:
        r28 = false;
    L149:
        r145 = FirstLevelTab.Unknown.getValue();
    L177:
        r1 = false;
    L140:
        r141 = false;
        goto L141
    L132:
        r26 = 0;
        goto L133
    L192:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r31 = KtvComponentContext.Companion.a();
        if (r31 == null) goto L225;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r31, new KtvComponentAnchorLogicWidget$onKtvMessage$1(r14));
        return;
    L225:
        return;
    L195:
        KtvComponentContext r157 = this.f;
        if (r157 == null) goto L200;
        com.bytedance.live.datacontext.n<Integer> r158 = r157.getKtvComponentStatus();
        if (r158 == null) goto L200;
        r6 = (Integer) r158.getValue();
    L200:
        if (r6 != null) goto L203;
    L205:
        r1 = false;
    L206:
        if (r1 == false) goto L227;
        Gq(false, "im close");
        return;
    L227:
        return;
    L203:
        if (r6.intValue() != 1) goto L205;
    L228:
        return;
    }

    public final void zq(x r26) {
        KtvComponentContext r1 = this.f;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r2 = r1.getKtvComponentStatus();
        if (r2 == null) goto L7;
        Integer r3 = (Integer) r2.getValue();
    L9:
        if (r3 != null) goto L12;
    L19:
        Integer r4 = r26.a;
        Boolean r5 = r26.b;
        Boolean r6 = r26.e;
        KtvComponentContext r7 = this.f;
        if (r7 == null) goto L24;
        com.bytedance.live.datacontext.n<Integer> r8 = r7.getKtvComponentStatus();
        if (r8 == null) goto L24;
        Integer r9 = (Integer) r8.getValue();
    L26:
        if (r9 != null) goto L29;
    L31:
        boolean r10 = false;
    L32:
        MusicPanel r11 = r26.d;
        Integer r12 = r26.g;
        String r13 = r26.c;
        if (r4 != null) goto L36;
    L49:
        if (r4 == null) goto L118;
        if (r4.intValue() != 1) goto L114;
        ArrayList<Integer> r14 = ke2.a.a;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 == null) goto L59;
        ai0.c r16 = r15.getAdventureService();
        if (r16 == null) goto L59;
        if (r16.c() != true) goto L59;
        f2.b(2131918322, 0);
        boolean r17 = true;
    L60:
        if (r17 == false) goto L62;
        return;
    L62:
        if (r10 == true) goto L100;
        if (r5 != null) goto L65;
        long r18 = 0;
    L69:
        if (r6 == null) goto L71;
        boolean r22 = r6.booleanValue();
    L72:
        String r19 = r26.c;
        String r20 = r26.f;
        Boolean r21 = r26.h;
        String r0 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
        IInteractService r23 = jc1.k.f(IInteractService.class);
        if (r23 == null) goto L77;
        z30.b r24 = r23.getCloudGroupLiveService();
        if (r24 == null) goto L77;
        CloudGroupLivePipelineStatus r25 = r24.b();
    L79:
        if (r25 != CloudGroupLivePipelineStatus.START) goto L82;
        f2.b(2131918314, 0);
        ALogger.i("KtvComponentAnchorLogicWidget", "openKtvComponent return, cause: cloudGroupLivePipelineStatus is START");
    L132:
        return;
    L82:
        if (this.n == true) goto L132;
        if (((Boolean) vm2.h.R3.getValue(null, vm2.h.a[250(0xfa, float:3.5E-43)])).booleanValue() == false) goto L91;
        KtvComponentContext r27 = this.f;
        if (r27 == null) goto L91;
        com.bytedance.live.datacontext.n<Integer> r28 = r27.getKtvComponentStatus();
        if (r28 == null) goto L91;
        r28.setValue(2);
    L91:
        this.n = true;
        Ref.ObjectRef r29 = new Ref.ObjectRef();
        r29.element = null;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c == true) goto L94;
        Context r30 = ((Widget) this).context;
        x0.d r31 = new x0.d();
        r31.b = r30;
        r31.a = 2;
        r31.k = false;
        x0 r32 = new x0(r31.b, r31);
        r29.element = r32;
        wq(r32);
    L94:
        long r210 = System.currentTimeMillis();
        CompositeDisposable r33 = this.g;
        KtvComponentApi r110 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        long r111 = this.e.getRoomId();
        if (r12 == null) goto L97;
        int r34 = r12.intValue();
    L98:
        r33.add(r110.openKtvComponent(r111, r18, r34, ((KtvChallengeProperty) com.bytedance.android.livesdk.sharedpref.c.n0.getValue()).getChallengeStatus()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.h(this, r29, r210, r19, r22, r20, r11, r21, r18), new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.i(this, r29, r210, r18, r19, r22, r20)));
        goto L132
    L97:
        r34 = OpenSource.NORMAL.getValue();
    L77:
        r25 = null;
        goto L79
    L71:
        r22 = false;
        goto L72
    L65:
        if (r5.booleanValue() == false) goto L67;
        r18 = 1;
        goto L69
    L67:
        r18 = 2;
        goto L69
    L100:
        if (r5 == null) goto L102;
        KtvComponentAnchorLogicWidget r35 = this;
        r35.Pq(r5.booleanValue());
    L103:
        if (r6 != null) goto L105;
    L111:
        if (r11 == null) goto L133;
        r35.Fq(r11);
        return;
    L133:
        return;
    L105:
        if (r6.booleanValue() == false) goto L111;
        String r36 = r26.f;
        if (r36 == null) goto L111;
        KtvComponentUIWidget r37 = r35.k;
        if (r37 == null) goto L111;
        TokenCert r38 = KtvComponentUIWidget.y1;
        r37.nr(r36, null, null);
        goto L111
    L102:
        r35 = this;
    L59:
        r17 = false;
        goto L60
    L114:
        if (r4.intValue() != 0) goto L135;
        if (r10 == false) goto L136;
        yq(true, r26.c);
        return;
    L136:
        return;
    L135:
        return;
    L118:
        if (r10 == false) goto L138;
        if (r5 == null) goto L121;
        Pq(r5.booleanValue());
    L121:
        if (r6 != null) goto L123;
    L129:
        if (r11 == null) goto L139;
        Fq(r11);
        return;
    L139:
        return;
    L123:
        if (r6.booleanValue() == false) goto L129;
        String r39 = r26.f;
        if (r39 == null) goto L129;
        KtvComponentUIWidget r40 = this.k;
        if (r40 == null) goto L129;
        TokenCert r41 = KtvComponentUIWidget.y1;
        r40.nr(r39, null, null);
        goto L129
    L138:
        return;
    L36:
        if (r4.intValue() != 1) goto L49;
        KtvComponentContext r112 = this.f;
        if (r112 == null) goto L43;
        com.bytedance.live.datacontext.n<Integer> r113 = r112.getOpenSource();
        if (r113 == null) goto L43;
        r113.setValue(r12);
    L43:
        if (TextUtils.isEmpty(r13) == true) goto L49;
        KtvComponentContext r114 = this.f;
        if (r114 == null) goto L49;
        com.bytedance.live.datacontext.n<String> r115 = r114.getFromSource();
        if (r115 == null) goto L49;
        r115.setValue(r13);
        goto L49
    L29:
        if (r9.intValue() != 1) goto L31;
        r10 = true;
    L24:
        r9 = null;
        goto L26
    L12:
        if (r3.intValue() != 2) goto L19;
        Integer r42 = r26.a;
        if (r42 == null) goto L19;
        if (r42.intValue() != 1) goto L19;
        return;
    L7:
        r3 = null;
        goto L9
    }

    public static final void xq(KtvComponentAnchorLogicWidget r13, String r14) {
        if (r13.Bq() == false) goto L6;
        xs2.b.a().post(new jd2.f(PanelType.ORDER_SONG_PANEL.getValue(), 14));
        return;
    L6:
        if (r14.hashCode() == 3357525) goto L9;
    L11:
        String r9 = "interact";
    L13:
        if (r14.hashCode() == 3357525) goto L16;
    L18:
        String r15 = "interaction_button";
    L19:
        String r6 = r15;
        KtvComponentContext r16 = r13.f;
        if (r16 == null) goto L26;
        com.bytedance.live.datacontext.n<x> r17 = r16.getKtvComponentCmd();
        if (r17 == null) goto L27;
        r17.setValue(new x(1, null, r6, null, Boolean.TRUE, r9, null, null, 202));
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (r14.equals("more") == false) goto L18;
        r15 = "more_panel";
        goto L19
    L9:
        if (r14.equals("more") == false) goto L11;
        r9 = "more";
        goto L13
    }

    public final void Gq(boolean r10, String r11) {
        this.i = false;
        KtvComponentContext r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L8:
        u r3 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.j r4 = r3.J();
        if (r4 == null) goto L15;
        LivePlayModeLogContext r5 = (LivePlayModeLogContext) r4.getValue();
        if (r5 == null) goto L15;
        r5.removePlayMode(21);
    L15:
        if (r10 == true) goto L17;
        Kq();
    L17:
        ChorusContext.a r12 = ChorusContext.Companion;
        if (r12.c() == false) goto L25;
        if (((Boolean) vm2.d.X4.getValue(null, vm2.d.a[307(0x133, float:4.3E-43)])).booleanValue() == false) goto L25;
        fd2.f r13 = r12.b();
        if (r13 == null) goto L25;
        r13.xk(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId(), 1);
    L25:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L27;
        String r14 = "on";
    L28:
        String r6 = r14;
        long r7 = (System.currentTimeMillis() - this.m) / 1000;
        int r15 = ke2.b.a;
        KtvComponentContext r16 = this.f;
        if (r16 == null) goto L32;
        String r17 = r16.getSource();
        if (r17 == null) goto L32;
    L38:
        ke2.b.c(r11, r6, r7, null, null, ke2.a.g(r17));
        KtvComponentContext r18 = this.f;
        if (r18 == null) goto L43;
        com.bytedance.live.datacontext.n<Integer> r19 = r18.getOpenSource();
        if (r19 == null) goto L43;
        r19.setValue(null);
    L43:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r110 = KtvComponentContext.Companion.a();
        if (r110 == null) goto L47;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r110, KtvComponentAnchorLogicWidget$realCloseKtvComponent$1.INSTANCE);
        return;
    L47:
        return;
    L32:
        KtvComponentContext r111 = this.f;
        if (r111 == null) goto L37;
        com.bytedance.live.datacontext.n<String> r112 = r111.getFromSource();
        if (r112 == null) goto L37;
        r17 = (String) r112.getValue();
    L37:
        r17 = null;
        goto L38
    L27:
        r14 = "off";
    L7:
        r2 = null;
        goto L8
    }

    public final void yq(boolean r13, String r14) {
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        if (r13 == false) goto L6;
        Context r15 = ((Widget) this).context;
        x0.d r2 = new x0.d();
        r2.b = r15;
        r2.a = 2;
        r2.k = false;
        x0 r16 = new x0(r2.b, r2);
        r7.element = r16;
        wq(r16);
    L6:
        if (((Boolean) vm2.h.P3.getValue(null, vm2.h.a[248(0xf8, float:3.48E-43)])).booleanValue() == false) goto L18;
        u r17 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r17 == null) goto L18;
        com.bytedance.live.datacontext.j r18 = r17.s();
        if (r18 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.getValue();
        if (r19 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r110 = r19.t();
        if (r110 == null) goto L18;
        if (r110.a != 9) goto L18;
        boolean r6 = true;
    L20:
        if (Intrinsics.areEqual(r14, "function_switch") == true) goto L22;
    L27:
        if (r6 == false) goto L29;
        Kq();
    L29:
        this.i = false;
        long r8 = System.currentTimeMillis();
        CompositeDisposable r111 = this.g;
        KtvComponentApi r0 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        long r1 = this.e.getRoomId();
        if (Intrinsics.areEqual(r14, "click") == false) goto L32;
        CloseSource r3 = CloseSource.MANUAL;
    L33:
        r111.add(r0.closeKtvComponent(r1, r3.getValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r8, r14, r7, r6), new c(this, r8, r14, r7)));
        return;
    L32:
        r3 = CloseSource.NOT_MANUAL;
        goto L33
    L22:
        if (vm2.h.l() == false) goto L27;
        if (this.i == true) goto L27;
        ALogger.i("KtvComponentAnchorLogicWidget", "close return");
        return;
    L18:
        r6 = false;
        goto L20
    }

    public static /* synthetic */ void Eq(KtvComponentAnchorLogicWidget r7, String r8, Boolean r9) {
        r7.Cq(r8, r9, false, null, null, null);
    }

    public final void Cq(final String r10, final Boolean r11, final boolean r12, final String r13, final MusicPanel r14, Boolean r15) {
        this.m = System.currentTimeMillis();
        KtvContext.Companion.getClass();
        KtvContext.a.a(1);
        KtvComponentContext r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r1 = r0.getKtvComponentStatus();
        if (r1 == null) goto L7;
        r1.setValue(1);
    L7:
        KtvContext r2 = KtvContext.a.g();
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.m<Integer> r3 = r2.getKtvComponentStatus();
        if (r3 == null) goto L12;
        r3.setValue(1);
    L12:
        u r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r4 == null) goto L20;
        com.bytedance.live.datacontext.j r5 = r4.J();
        if (r5 == null) goto L20;
        LivePlayModeLogContext r6 = (LivePlayModeLogContext) r5.getValue();
        if (r6 == null) goto L20;
        r6.addPlayMode(21);
    L20:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L24;
        Aq();
        ALogger.i("KtvComponentAnchorLogicWidget", "openComponentSuccess, scheme to openVideoChorus");
        return;
    L24:
        if (Bq() == false) goto L27;
        ALogger.i("KtvComponentAnchorLogicWidget", "openComponentSuccess, isOpenVideoChorus = true return");
        return;
    L27:
        KtvComponentUIWidget r16 = new KtvComponentUIWidget(r10, new KtvComponentAnchorLogicWidget$openComponentSuccess$1(this, r12, r13, r11, r14, r10), new KtvComponentAnchorLogicWidget$openComponentSuccess$2(this));
        this.k = r16;
        Jq(true);
        this.p.a(AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_UI_WIDGET, r16);
        int r17 = ne2.a.a;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r18 = KtvChallengeDataContext.Companion.a();
        if (r18 == null) goto L31;
        r18.checkAutoOpenChallenge();
        return;
    }
}
