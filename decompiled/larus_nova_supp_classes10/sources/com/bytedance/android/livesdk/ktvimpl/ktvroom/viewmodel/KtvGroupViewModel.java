package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.GroupInfo;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.i1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.toolbar.KtvToolbarBehaviorManager;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvInteractGroupDialog;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010\\\u001a\u00020[¢\u0006\u0004\b`\u0010aJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002JK\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010 \u001a\u00020\b2'\b\u0002\u0010\u001f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fJ\u0017\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\"\u0010#J\u0006\u0010$\u001a\u00020\bJ9\u0010 \u001a\u00020\b2'\b\u0002\u0010\u001f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010%\u001a\u00020\u001aJ\b\u0010&\u001a\u00020\bH\u0014J9\u0010'\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u000fJ\u0016\u0010(\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0005R\u0019\u0010.\u001a\u0004\u0018\u00010-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u001d\u00108\u001a\b\u0012\u0004\u0012\u000207068\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010#R\"\u0010A\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\"\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0L0K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR3\u0010R\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0Pj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)`Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010W\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010\\\u001a\u00020[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvGroupViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Landroid/content/Context;", "context", "", "conversationId", "page", "", "realStartGroupManagerFragment", "", "source_type", "mConversationID", "mConversationShortID", "enter_type", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "inGroupState", "cb", "realJoinGroup", "Ltlc/d;", "message", "onMessage", "Lcom/bytedance/android/livesdk/message/model/LinkMicGuideMessage;", "msg", "", "isKtvGuideMsg", "startGroupManagerFragment", "Lcom/bytedance/android/live/ktv/common/model/api/GroupInfo;", "groupInfo", "infoCb", "getGroupInfo", "setting", "onGetRoomSetting", "(Ljava/lang/Integer;)V", "checkSetting", "refresh", "onCleared", "joinGroup", "createGroup", "", "roomId", "uid", "inviteToKtvGroup", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "singCompositeDisposable", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Landroid/text/SpannableString;", "joinGroupTips", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getJoinGroupTips", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "roomAudienceSettings", "Ljava/lang/Integer;", "getRoomAudienceSettings", "()Ljava/lang/Integer;", "setRoomAudienceSettings", "hasKtvGroupInvited", "Z", "getHasKtvGroupInvited", "()Z", "setHasKtvGroupInvited", "(Z)V", "Lcom/bytedance/android/live/ktv/common/model/api/GroupInfo;", "Lcom/bytedance/android/livesdk/ktvimpl/base/toolbar/KtvToolbarBehaviorManager;", "toolbarBehaviorManager", "Lcom/bytedance/android/livesdk/ktvimpl/base/toolbar/KtvToolbarBehaviorManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "settingObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "inviteRecordMap", "Ljava/util/HashMap;", "getInviteRecordMap", "()Ljava/util/HashMap;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "widget", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "getWidget", "()Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupViewModel extends ViewModel implements vlc.l {
    private final CompositeDisposable compositeDisposable;
    private final DataCenter dataCenter;
    private GroupInfo groupInfo;
    private boolean hasKtvGroupInvited;
    private final HashMap<String, Long> inviteRecordMap;
    private final NextLiveData<SpannableString> joinGroupTips;
    private final IRoom room;
    private Integer roomAudienceSettings;
    private Observer<List<y>> settingObserver;
    private final CompositeDisposable singCompositeDisposable;
    private final KtvToolbarBehaviorManager toolbarBehaviorManager;
    private final HolderRoomWidget widget;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvGroupViewModel a;
        public final /* synthetic */ long b;

        public a(KtvGroupViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetAudienceSettings;
            long r2 = System.currentTimeMillis() - this.b;
            if (r8 == null) goto L6;
            String r4 = ((ExtraResponse) r8).logId;
            if (r4 == null) goto L6;
        L7:
            mb0.c.a.b(r0, r1, r2, r4);
            if (r8 == null) goto L12;
            h1 r9 = (h1) ((ExtraResponse) r8).data;
            if (r9 == null) goto L12;
            List r10 = r9.getSettings();
        L13:
            if (r10 != null) goto L15;
            ALogger.i(bb0.b.b(), "getAudienceSettings null, invoke class :KtvGroupViewModel");
            return;
        L15:
            Iterator<T> r11 = r10.iterator();
        L17:
            if (r11.hasNext() == false) goto L36;
            ILinkmicAudienceSetting r3 = (ILinkmicAudienceSetting) r11.next();
            Integer r5 = r3.getKey();
            int r6 = LinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_DELEGATED_TO_FRIENDS.ordinal();
            if (r5 == null) goto L17;
            if (r5.intValue() != r6) goto L17;
            KtvGroupViewModel r12 = this.a;
            i1 r13 = r3.getValue();
            if (r13 == null) goto L26;
            Integer r14 = r13.getLinkmicAudienceSettingValue();
        L27:
            r12.setRoomAudienceSettings(r14);
            KtvGroupViewModel r15 = this.a;
            r15.onGetRoomSetting(r15.getRoomAudienceSettings());
            goto L17
        L26:
            r14 = null;
            goto L27
        L36:
            return;
        L12:
            r10 = null;
        L6:
            r4 = "";
            goto L7
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetAudienceSettings;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvGroupViewModel a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ long c;

        public c(KtvGroupViewModel r1, Function1 r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            com.bytedance.android.live.ktv.common.model.api.q r0 = (com.bytedance.android.live.ktv.common.model.api.q) ((ExtraResponse) r8).data;
            if (r0 == null) goto L19;
            List r1 = r0.a();
            if (r1 == null) goto L19;
            if (r1.isEmpty() == true) goto L19;
            KtvGroupViewModel r2 = this.a;
            com.bytedance.android.live.ktv.common.model.api.q r3 = (com.bytedance.android.live.ktv.common.model.api.q) ((ExtraResponse) r8).data;
            if (r3 == null) goto L14;
            List r4 = r3.a();
            if (r4 == null) goto L14;
            GroupInfo r5 = (GroupInfo) ListProtector.get(r4, 0);
        L15:
            KtvGroupViewModel.access$setGroupInfo$p(r2, r5);
            Function1 r6 = this.b;
            if (r6 == null) goto L18;
            Unit r9 = (Unit) r6.invoke(KtvGroupViewModel.access$getGroupInfo$p(this.a));
        L18:
            ALogger.i(bb0.b.b(), "getGroupInfo success, invoke class :KtvGroupViewModel");
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetGroupInfo, System.currentTimeMillis() - this.c, ((ExtraResponse) r8).logId);
            return;
        L14:
            r5 = null;
        L19:
            ALogger.i(bb0.b.b(), "groupInfoList is null, invoke class :KtvGroupViewModel");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;

        public d(KtvGroupViewModel r1, long r2) {
            this.a = r2;
        }

        public final void accept(Object r7) {
            f2.c("获取群信息失败", 0);
            ALogger.i(bb0.b.b(), "getGroupInfo error, invoke class :KtvGroupViewModel");
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetGroupInfo;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvGroupViewModel a;
        public final /* synthetic */ KtvInteractGroupDialog b;

        public e(KtvGroupViewModel r1, KtvInteractGroupDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L10;
            KtvInteractGroupDialog r3 = this.b;
            if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L14;
            DialogLancet.handleBlockedDialogShow(r3);
            goto L10
        L14:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L8:
            DialogLancet.beforeDialogShow(r3);
            r3.show();
            DialogLancet.afterDialogShow(r3);
        L10:
            if (KtvGroupViewModel.access$getSingCompositeDisposable$p(this.a).isDisposed() == true) goto L16;
            KtvGroupViewModel.access$getSingCompositeDisposable$p(this.a).dispose();
            return;
        }
    }

    public static final class f implements IMiddlewareHostAction.IMFansGroupManagerCallback {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void onBackPressed(Object r1) {
        }
    }

    public static final class g implements IMiddlewareHostAction.IMFansGroupManagerClickCallback {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void onLeftTitleClick(Object r1) {
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ KtvGroupViewModel a;

        public h(KtvGroupViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            List r7 = (List) r6;
            Integer r1 = null;
            if (r7 == null) goto L17;
            Iterator<T> r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L13;
            T r2 = r8.next();
            if (((y) r2).getKey() != 56) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == false) goto L6;
        L14:
            y r4 = (y) r2;
            if (r4 == null) goto L17;
            r1 = Integer.valueOf(r4.getValue());
            goto L17
        L10:
            r3 = false;
            goto L11
        L13:
            r2 = null;
        L17:
            String r9 = "update linkMicSetting： " + r1 + ',' + com.bytedance.android.live.ktv.common.util.j.i();
            ALogger.i(bb0.b.b(), r9 + ", invoke class :KtvGroupViewModel");
            if (r1 == null) goto L23;
            if (r1.intValue() != 1) goto L23;
        L28:
            KtvGroupViewModel.access$getToolbarBehaviorManager$p(this.a).a(ToolbarButton.KTV_GROUP);
            return;
        L23:
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L28;
            KtvToolbarBehaviorManager r10 = KtvGroupViewModel.access$getToolbarBehaviorManager$p(this.a);
            ToolbarButton r0 = ToolbarButton.KTV_GROUP;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r0, "key");
            c0.b r5 = r10.a.get(r0);
            if (r5 == null) goto L35;
            y3.f(((Widget) r10.b).dataCenter).d(r0, r5);
            return;
        }
    }

    public final void checkSetting() {
        long r0 = System.currentTimeMillis();
        JSONArray r2 = new JSONArray();
        ALogger.i("KtvGroupViewModel", "checkSetting");
        KtvRoomApi r3 = (KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class);
        String r4 = r2.toString();
        IRoom r5 = this.room;
        if (r5 == null) goto L5;
        long r6 = r5.getId();
    L6:
        RxUtilKt.c(r3.getAudienceSettings(r4, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r0), new b(r0)), this.compositeDisposable);
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
        this.singCompositeDisposable.dispose();
        KtvToolbarBehaviorManager r0 = this.toolbarBehaviorManager;
        if (r0 == null) goto L7;
        ToolbarButton r1 = ToolbarButton.KTV_GROUP;
        Intrinsics.checkNotNullParameter(r1, "key");
        c0.b r2 = r0.a.get(r1);
        if (r2 == null) goto L7;
        y3.f(((Widget) r0.b).dataCenter).d(r1, r2);
    L7:
        IInteractService.linkMicSettings.removeObserver(this.settingObserver);
        vlc.d r3 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        if (r3 == null) goto L11;
        r3.removeMessageListener(this);
        return;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final boolean getHasKtvGroupInvited() {
        return this.hasKtvGroupInvited;
    }

    public final HashMap<String, Long> getInviteRecordMap() {
        return this.inviteRecordMap;
    }

    public final NextLiveData<SpannableString> getJoinGroupTips() {
        return this.joinGroupTips;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    public final Integer getRoomAudienceSettings() {
        return this.roomAudienceSettings;
    }

    public final HolderRoomWidget getWidget() {
        return this.widget;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvroom_viewmodel_KtvGroupViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(KtvInteractGroupDialog r1) {
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

    public static final /* synthetic */ GroupInfo access$getGroupInfo$p(KtvGroupViewModel r0) {
        return r0.groupInfo;
    }

    public static final /* synthetic */ CompositeDisposable access$getSingCompositeDisposable$p(KtvGroupViewModel r0) {
        return r0.singCompositeDisposable;
    }

    public static final /* synthetic */ KtvToolbarBehaviorManager access$getToolbarBehaviorManager$p(KtvGroupViewModel r0) {
        return r0.toolbarBehaviorManager;
    }

    public final void getGroupInfo(Function1<? super GroupInfo, Unit> r2) {
        getGroupInfo(r2, false);
    }

    public final boolean isKtvGuideMsg(LinkMicGuideMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        LinkMicGuideMessage.JoinGroupChatGuideContent r4 = r3.joinGroupChatGuideContent;
        if (r4 == null) goto L5;
        int r5 = r4.group_type;
    L7:
        if (r5 != LinkMicGuideMessage.GroupType.KtvGroup.value) goto L10;
        return true;
    L10:
        return false;
    L5:
        r5 = 0;
        goto L7
    }

    public final void onGetRoomSetting(Integer r7) {
        ALogger.i("KtvGroupViewModel", "setting:" + r7);
        int r0 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.ordinal();
        if (r7 != null) goto L6;
    L8:
        int r1 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal();
        if (r7 != null) goto L12;
    L14:
        int r2 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.ordinal();
        if (r7 != null) goto L18;
    L20:
        int r3 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_UNSET.ordinal();
        if (r7 != null) goto L24;
        return;
    L24:
        if (r7.intValue() != r3) goto L28;
    L25:
        Lazy r8 = KtvUtilsKt.a;
        String r9 = jc1.a.b().getString(2131917393);
    L26:
        NextLiveData<SpannableString> r4 = this.joinGroupTips;
        SpannableString r5 = new SpannableString(r9);
        int r6 = r9.length() - 16;
        int r10 = r9.length() - 3;
        r5.setSpan(new ForegroundColorSpan(-1), r6, r10, 18);
        r5.setSpan(new AbsoluteSizeSpan(s1.f(14.0f)), r6, r10, 18);
        Unit r11 = Unit.INSTANCE;
        r4.setValue(r5);
        return;
    L28:
        return;
    L18:
        if (r7.intValue() != r2) goto L20;
    L12:
        if (r7.intValue() != r1) goto L14;
        Lazy r12 = KtvUtilsKt.a;
        r9 = jc1.a.b().getString(2131917394);
        goto L26
    L6:
        if (r7.intValue() != r0) goto L8;
        Lazy r13 = KtvUtilsKt.a;
        r9 = jc1.a.b().getString(2131917392);
        goto L26
    }

    public void onMessage(tlc.d r12) {
        if ((r12 instanceof LinkMicGuideMessage) == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L47;
        LinkMicGuideMessage r13 = (LinkMicGuideMessage) r12;
        if (isKtvGuideMsg(r13) == false) goto L47;
        long r2 = r13.guidelineType;
        String r4 = bb0.b.b();
        ALogger.i(r4, ("onMessage LinkMicGuideMessage, type:" + r2) + ", invoke class :KtvGroupViewModel");
        if (r2 != 5) goto L13;
        LinkMicGuideMessage.CreateGroupChatGuideContent r14 = r13.createGroupChatGuideContent;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvroom_viewmodel_KtvGroupViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new KtvInteractGroupDialog(((Widget) this.widget).context, true, r14.headerText, r14.bodyText, null, "", "", null));
        return;
    L13:
        if (r2 != 6) goto L51;
        LinkMicGuideMessage.JoinGroupChatGuideContent r15 = r13.joinGroupChatGuideContent;
        if (r15 != null) goto L18;
        return;
    L18:
        if (this.hasKtvGroupInvited == true) goto L20;
    L23:
        int r0 = r15.guide_source;
        LinkMicGuideMessage.GuideSource r1 = LinkMicGuideMessage.GuideSource.SingingRank;
        if (r0 != r1.value) goto L27;
        this.hasKtvGroupInvited = true;
    L27:
        if (((Widget) this.widget).context != null) goto L29;
        return;
    L29:
        Context r3 = ((Widget) this.widget).context;
        String r5 = r15.headerText;
        String r6 = r15.bodyText;
        List r7 = r15.iconsList;
        String r8 = r15.conversationID;
        String r9 = String.valueOf(r15.conversationShortID.longValue());
        int r10 = r15.guide_source;
        if (r10 != r1.value) goto L34;
        String r11 = "sing_rank";
    L37:
        KtvInteractGroupDialog r16 = new KtvInteractGroupDialog(r3, false, r5, r6, r7, r8, r9, r11);
        if (r15.guide_source != LinkMicGuideMessage.GuideSource.Invitation.value) goto L40;
        int r17 = 24;
    L41:
        r16.b = r17;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L46;
        ALogger.i(bb0.b.b(), "is singing,show group invitation later, invoke class :KtvGroupViewModel");
        Disposable r18 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new e(this, r16), 3, null);
        if (r18 == null) goto L52;
        RxUtilKt.c(r18, this.singCompositeDisposable);
        return;
    L52:
        return;
    L46:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvroom_viewmodel_KtvGroupViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r16);
        return;
    L40:
        r17 = 23;
        goto L41
    L34:
        if (r10 != LinkMicGuideMessage.GuideSource.Invitation.value) goto L36;
        r11 = "anchor_invite";
        goto L37
    L36:
        r11 = "";
        goto L37
    L20:
        if (r15.guide_source != LinkMicGuideMessage.GuideSource.SingingRank.value) goto L23;
        ALogger.i(bb0.b.b(), "cannot show KtvInteractGroupDialog, invoke class :KtvGroupViewModel");
        return;
    L51:
        return;
    L47:
        ALogger.i(bb0.b.b(), "cannot show KtvInteractGroupDialog, invoke class :KtvGroupViewModel");
    }

    public final void setHasKtvGroupInvited(boolean r1) {
        this.hasKtvGroupInvited = r1;
    }

    public final void setRoomAudienceSettings(Integer r1) {
        this.roomAudienceSettings = r1;
    }

    public KtvGroupViewModel(DataCenter r3, HolderRoomWidget r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "widget");
        this.dataCenter = r3;
        this.widget = r4;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
    L8:
        this.room = r2;
        this.compositeDisposable = new CompositeDisposable();
        this.singCompositeDisposable = new CompositeDisposable();
        this.joinGroupTips = new NextLiveData();
        KtvToolbarBehaviorManager r5 = new KtvToolbarBehaviorManager(r4);
        this.toolbarBehaviorManager = r5;
        this.settingObserver = new h(this);
        vlc.d r6 = (vlc.d) r3.get("data_message_manager", null);
        if (r6 == null) goto L11;
        r6.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L11:
        IInteractService.linkMicSettings.observe(r5, this.settingObserver, true);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L14;
        r5.a(ToolbarButton.KTV_GROUP);
    L14:
        this.inviteRecordMap = new HashMap();
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static final /* synthetic */ void access$setGroupInfo$p(KtvGroupViewModel r0, GroupInfo r1) {
        r0.groupInfo = r1;
    }

    public final void createGroup(final Context r9, final String r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "page");
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L6;
        ALogger.i(bb0.b.b(), "createGroup error,isn't anchor, invoke class :KtvGroupViewModel");
        return;
    L6:
        int r4 = jc1.k.n(IInteractService.class).getCurrentScene();
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        String r1 = "";
        if (r0 == null) goto L16;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L16;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L16;
        String r5 = r3.getOwnerUserIdString();
        if (r5 == null) goto L16;
        String r6 = r5;
    L17:
        com.bytedance.android.livesdk.chatroom.o r7 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r7 == null) goto L30;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L30;
        IRoom r11 = (IRoom) r8.getValue();
        if (r11 == null) goto L30;
        IBaseUser r12 = r11.getOwner();
        if (r12 == null) goto L30;
        String r13 = r12.getRealNickName();
        if (r13 == null) goto L30;
        r1 = r13;
    L30:
        if (r1.length() <= 8) goto L32;
        r1 = r1.substring(0, 8);
    L32:
        IMiddlewareHostSocial r14 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r14 == null) goto L36;
        r14.createCommonGroup(r9, r6, r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("ktv_group", "{\"anchor_id\": " + r6 + '}'), TuplesKt.to("group_create_type", PromotionCategory.CATEGORY_TYPE_TEMPLATE), TuplesKt.to("group_entry_limit", "{\"webcast_connect_count\": \"7\"}"), TuplesKt.to("group_name", r1 + "歌友群")}), new AnonymousClass1(this, r9, r10));
        return;
    L36:
        return;
    L16:
        r6 = "";
        goto L17
    }

    public final void getGroupInfo(Function1<? super GroupInfo, Unit> r6, boolean r7) {
        ALogger.i(bb0.b.b(), "getGroupInfo, invoke class :KtvGroupViewModel");
        if (r7 == true) goto L9;
        GroupInfo r8 = this.groupInfo;
        if (r8 == null) goto L9;
        if (r6 == null) goto L18;
        Unit r9 = (Unit) r6.invoke(r8);
        return;
    L18:
        return;
    L9:
        IRoom r10 = this.room;
        if (r10 == null) goto L12;
        Long r11 = Long.valueOf(r10.getRoomId());
    L13:
        if (r11 != null) goto L16;
        ALogger.i(bb0.b.b(), "getGroupInfo roomid is null, invoke class :KtvGroupViewModel");
        return;
    L16:
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getGroupInfo(r11.longValue(), 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r6, r0), new d(this, r0)), this.compositeDisposable);
        return;
    L12:
        r11 = null;
        goto L13
    }

    public final void inviteToKtvGroup(final long r9, final String r11) {
        Intrinsics.checkNotNullParameter(r11, "uid");
        long r0 = System.currentTimeMillis() - ((long) 60000);
        Long r2 = this.inviteRecordMap.get(r11);
        if (r2 != null) goto L6;
        r2 = 0L;
    L6:
        if (r0 >= r2.longValue()) goto L9;
        f2.c("当前操作过于频繁", 0);
        ALogger.i(bb0.b.b(), "inviteToKtvGroup error,shorter than one minute, invoke class :KtvGroupViewModel");
        return;
    L9:
        final long r5 = System.currentTimeMillis();
        getGroupInfo(new C02381(this, r9, r11, r5));
    }

    public final void startGroupManagerFragment(final Context r3, final String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "page");
        GroupInfo r0 = this.groupInfo;
        if (r0 != null) goto L6;
        getGroupInfo(new C02401(this, r3, r4));
        return;
    L6:
        if (r0 == null) goto L8;
        Long r1 = Long.valueOf(r0.b());
    L9:
        realStartGroupManagerFragment(r3, String.valueOf(r1), r4);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvroom_viewmodel_KtvGroupViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void realStartGroupManagerFragment(Context r5, String r6, String r7) {
        FragmentActivity r8 = ContextUtil.contextToFragmentActivity(r5);
        DialogFragment r9 = jc1.k.n(IMiddlewareHostAction.class).startGroupManagerFragment(r6, "live_song", f.a, g.a);
        if (r9 == null) goto L8;
        if (r8 == null) goto L8;
        Long r0 = KtvLoggerHelper.a;
        KtvLoggerHelper.X("livesdk_ktv_friends_group_detail_show", MapsKt.mapOf(TuplesKt.to("source", r7)));
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvroom_viewmodel_KtvGroupViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r9, r8.getSupportFragmentManager(), "startGroupManagerFragment");
        return;
    L8:
        ALogger.i(bb0.b.b(), "realStartGroupManagerFragment IS NULL, invoke class :KtvGroupViewModel");
    }

    public final void joinGroup(final int r2, final int r3, final Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "cb");
        getGroupInfo(new C02391(this, r2, r3, r4));
    }

    public static final /* synthetic */ void access$realStartGroupManagerFragment(KtvGroupViewModel r0, Context r1, String r2, String r3) {
        r0.realStartGroupManagerFragment(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getGroupInfo$default(KtvGroupViewModel r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.getGroupInfo(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getGroupInfo$default(KtvGroupViewModel r0, Function1 r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        r0.getGroupInfo(r1, r2);
    }

    private final void realJoinGroup(int r19, final String r20, final String r21, int r22, final Function1<? super Integer, Unit> r23) {
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        IRoom r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L7;
        IRoom r4 = (IRoom) r3.getValue();
    L8:
        com.bytedance.android.livesdk.chatroom.o r5 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r5 == null) goto L15;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L15;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L15;
        String r8 = r7.getOwnerUserIdString();
    L17:
        if (r19 != 24) goto L19;
        StringBuilder r9 = new StringBuilder("{\"anchor_id\": ");
        r9.append(r8);
    L20:
        r9.append('}');
        final Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source_type", String.valueOf(r19)), TuplesKt.to("ktv_group", String.valueOf(r9.toString()))});
        if (r19 != 24) goto L28;
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L25;
        Integer r11 = Integer.valueOf(r0.appId());
    L26:
        r10.put("invitation", "{\"invitee\":{\"source_app_id\":" + String.valueOf(r11) + "},\"invitor\":{\"im_user_id\":" + r8 + '}');
        goto L28
    L25:
        r11 = null;
    L28:
        if ((r4 instanceof IRoom) == false) goto L31;
        r2 = r4;
    L31:
        if (r2 == null) goto L38;
        String r12 = r2.getOwnerUserIdString();
        if (r12 == null) goto L38;
        IMiddlewareHostSocial r13 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r13 == null) goto L38;
        r13.joinKtvGroup(((Widget) this.widget).context, r20, r21, jc1.k.n(IMiddlewareUserService.class).user().n().toString(), r12, jc1.k.n(IInteractService.class).getCurrentScene(), r10, new KtvGroupViewModel$realJoinGroup$$inlined$let$lambda$1(this, r20, r21, r10, r23));
        return;
    L38:
        return;
    L19:
        r9 = new StringBuilder("{\"anchor_id\": ");
        r9.append(r8);
        r9.append(", \"enter_type\": ");
        r9.append(r22);
    L15:
        r8 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static final /* synthetic */ void access$realJoinGroup(KtvGroupViewModel r0, int r1, String r2, String r3, int r4, Function1 r5) {
        r0.realJoinGroup(r1, r2, r3, r4, r5);
    }
}
