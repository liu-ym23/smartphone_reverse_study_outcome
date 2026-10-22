package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.UpdateSongSettingType;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\bg\u0010hJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010J&\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u00100\u001a\u00020\u0004H\u0004J\b\u00101\u001a\u00020\u0004H\u0016J\u0012\u00103\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u00104\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u00105\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010*\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010<R\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR'\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010N\u001a\u0004\bT\u0010UR\u001d\u0010[\u001a\u0004\u0018\u00010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010N\u001a\u0004\bY\u0010ZRY\u0010`\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00040\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aRY\u0010b\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00040\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010aRD\u0010d\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eRD\u0010f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010e¨\u0006k"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/KSongSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/content/Context;", "context", "", "dismissMainDialog", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/SwitchItemType;", LocationMonitorConst.TYPE, "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/UpdateSongSettingType;", "obtainUpdateSongSettingType", "switchItemType", "reversalSwitchCheckedState", "Landroid/view/View;", "rootView", "initView", "openRulePage", "", "scene", "", "isMultiLinkScene", "show", "updateKtvChallengeSwitchStatus", "checked", "", "obtainActionType", "hasApplyUser", "closeAudienceSingSwitchPreCheck", "updateMultiChorusSwitchState", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/e;", "switchView", "addSwitchItemView", "needShowHideLyricsForSubtitle", "addHideLyricsForSubtitle", "obtainSwitchItemView", "setupDialogWindowWidth", "isXScreen", "initDialog", "outerHeight", "injectKtvTopControlBarHeight", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "view", "onViewCreated", "hideTouchOutSide", "onDestroy", "Landroid/app/Dialog;", "onCreateDialog", "onCreate", "onActivityCreated", "Lio/reactivex/disposables/Disposable;", "closeChallengeDisposable", "Lio/reactivex/disposables/Disposable;", "settingDialogHeight", "I", "outside", "Landroid/view/View;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/FrameLayout;", "topArea", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "backView", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "dividerLine", "Landroid/widget/LinearLayout;", "contentArea", "Landroid/widget/LinearLayout;", "", "switchViewMap$delegate", "Lkotlin/Lazy;", "getSwitchViewMap", "()Ljava/util/Map;", "switchViewMap", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/b;", "kSongSettingViewModel$delegate", "getKSongSettingViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/b;", "kSongSettingViewModel", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "actionType", "updateSettingByType", "Lkotlin/jvm/functions/Function3;", "confirmCallback", "Lkotlin/Function2;", "cancelCallback", "Lkotlin/jvm/functions/Function2;", "updateSettingCallback", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongSettingDialog extends LiveDialogFragment {
    public static final a Companion = null;
    public static final float DIALOG_HEIGHT_EXCLUDE_TOP_CONTROL_BAR = 481.0f;
    public static final float DIALOG_HEIGHT_INCLUDE_TOP_CONTROL_BAR = 533.0f;
    public static final String TAG = "KSongSettingDialog";
    private ImageView backView;
    private final Function2<SwitchItemType, Boolean, Unit> cancelCallback;
    private Disposable closeChallengeDisposable;
    private final Lazy compositeDisposable$delegate;
    private final Function3<SwitchItemType, Boolean, String, Unit> confirmCallback;
    private ConstraintLayout container;
    private LinearLayout contentArea;
    private View dividerLine;
    private final Lazy kSongSettingViewModel$delegate;
    private View outside;
    private int settingDialogHeight;
    private final Lazy switchViewMap$delegate;
    private TextView titleTv;
    private FrameLayout topArea;
    private final Function3<SwitchItemType, Boolean, String, Unit> updateSettingByType;
    private final Function2<SwitchItemType, Boolean, Unit> updateSettingCallback;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c {
        public final /* synthetic */ KSongSettingDialog a;

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void d() {
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final boolean b() {
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L7;
            com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
            if (r1 == null) goto L7;
            return r1.d;
        L7:
            return false;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final String a() {
            return s1.B(2131917340);
        }

        public b(KSongSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void c(boolean r3) {
            KSongSettingDialog.access$getUpdateSettingCallback$p(this.a).invoke(SwitchItemType.HIDE_LYRICS_FOR_SUBTITLE, Boolean.valueOf(r3));
        }
    }

    public static final class c implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c {
        public final /* synthetic */ KSongSettingDialog a;

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void d() {
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final boolean b() {
            com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isKtvChallengeOpen() != true) goto L7;
            return true;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final String a() {
            return s1.B(2131918230);
        }

        public c(KSongSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void c(boolean r3) {
            KSongSettingDialog.access$getUpdateSettingCallback$p(this.a).invoke(SwitchItemType.KTV_CHALLENGE, Boolean.valueOf(r3));
        }
    }

    public static final class d implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c {
        public final /* synthetic */ KSongSettingDialog a;

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void d() {
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final boolean b() {
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
            if (r1 == null) goto L9;
            if (r1.a != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final String a() {
            return s1.B(2131918306);
        }

        public d(KSongSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void c(boolean r3) {
            KSongSettingDialog.access$getUpdateSettingCallback$p(this.a).invoke(SwitchItemType.AUDIENCE_SING, Boolean.valueOf(r3));
        }
    }

    public static final class e implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c {
        public final /* synthetic */ KSongSettingDialog a;

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final boolean b() {
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
            if (r1 == null) goto L9;
            if (r1.b != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void d() {
            KSongSettingDialog.access$openRulePage(this.a);
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final String a() {
            return s1.B(2131920522);
        }

        public e(KSongSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.c
        public final void c(boolean r6) {
            IStrategyService r0 = jc1.k.f(IStrategyService.class);
            if (r0 == null) goto L8;
            LiveData r1 = IStrategyService.a.a(r0, "live_enable_dynamic_switch_mix_type", Boolean.FALSE, false, 12);
            if (r1 == null) goto L8;
            Boolean r2 = (Boolean) r1.getValue();
            if (r2 == null) goto L8;
        L9:
            boolean r3 = r2.booleanValue();
            if (r6 == false) goto L27;
            if (r3 == false) goto L27;
            IMultiLinkInternalService r4 = jc1.k.f(IMultiLinkInternalService.class);
            if (r4 == null) goto L27;
            cg6.a r5 = r4.getMultiLinkComponentService(null, m.i());
            if (r5 == null) goto L27;
            hg6.g r7 = r5.getRtcManager();
            if (r7 == null) goto L27;
            ei6.a r8 = r7.V0();
            if (r8 == null) goto L27;
            fi6.a r9 = r8.g();
            if (r9 == null) goto L27;
            if (r9.b() == true) goto L27;
            ti6.d r10 = r8.p();
            if (r10 == null) goto L27;
            r10.m(MixStreamType.RTC_CLIENT_MIX);
        L27:
            KSongSettingDialog.access$getUpdateSettingCallback$p(this.a).invoke(SwitchItemType.MULTI_CHORUS, Boolean.valueOf(r6));
            return;
        L8:
            r2 = Boolean.FALSE;
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KSongSettingDialog a;

        public f(KSongSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            UserAttr r4 = (UserAttr) r3;
            KSongSettingDialog r0 = this.a;
            if (r4 == null) goto L7;
            boolean r1 = true;
            if (r4.isAdmin() != true) goto L7;
        L8:
            KSongSettingDialog.access$updateKtvChallengeSwitchStatus(r0, r1);
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ KSongSettingDialog a;

        public g(KSongSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            KSongSettingDialog.access$updateMultiChorusSwitchState(this.a);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ KSongSettingDialog a;

        public h(KSongSettingDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1) == null) goto L7;
            KSongSettingDialog.access$updateMultiChorusSwitchState(this.a);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KSongSettingDialog a;

        public i(KSongSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r2;
            if (r3.d == true) goto L6;
            KSongSettingDialog r0 = this.a;
            KSongSettingDialog.access$updateKtvChallengeSwitchStatus(r0, KSongSettingDialog.access$isMultiLinkScene(r0, r3.a));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.KSongSettingDialog$initView$5, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass5 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
            super(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d.class, "openAudienceAddSongSwitch", "getOpenAudienceAddSongSwitch()Z", 0);
        }

        public Object get(Object r1) {
            return Boolean.valueOf(((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1).a);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KSongSettingDialog a;

        public j(KSongSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KSongSettingDialog r0 = this.a;
            KSongSettingDialog.access$updateKtvChallengeSwitchStatus(r0, KSongSettingDialog.access$isMultiLinkScene(r0, ((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2).a));
        }
    }

    public static final class k implements LiveBottomSheetDialog.m {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.compositeDisposable$delegate.getValue();
    }

    private final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b getKSongSettingViewModel() {
        return (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b) this.kSongSettingViewModel$delegate.getValue();
    }

    private final Map<SwitchItemType, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e> getSwitchViewMap() {
        return (Map) this.switchViewMap$delegate.getValue();
    }

    private final boolean isMultiLinkScene(int r2) {
        if (r2 != 5) goto L5;
    L12:
        return true;
    L5:
        if (r2 == 8) goto L12;
        if (r2 == 12) goto L12;
        if (r2 == 16) goto L12;
        return false;
    }

    private final boolean hasApplyUser() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<List<com.bytedance.android.live.ktv.common.model.bean.d>> r1 = r0.getCurWaitingUserList();
        if (r1 == null) goto L9;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        if (r3 <= 0) goto L13;
        return true;
    L13:
        return false;
    L9:
        r3 = 0;
        goto L10
    }

    @JvmStatic
    public static final KSongSettingDialog newInstance() {
        Companion.getClass();
        return new KSongSettingDialog();
    }

    private final void openRulePage() {
        MultiChorusContext.Companion.getClass();
        if (MultiChorusContext.a.d() == true) goto L5;
        return;
    L5:
        Context r0 = getContext();
        if (r0 == null) goto L8;
        int r1 = com.bytedance.android.live.liveinteract.e.a;
        com.bytedance.android.live.liveinteract.e.d(r0, 29, null);
    L8:
        int r2 = ke2.b.a;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("anchor_id", com.bytedance.android.live.ktv.common.util.a.c().getOwnerUserIdString());
        r3.put("room_id", com.bytedance.android.live.ktv.common.util.a.c().getIdStr());
        r3.put("live_type", com.bytedance.android.live.ktv.common.util.j.d());
        Long r4 = KtvLoggerHelper.a;
        r3.put("function_type2", KtvLoggerHelper.H(com.bytedance.android.live.ktv.common.util.j.c()));
        we2.a.a(r3);
        we2.a.c(r3);
        j0.l().sendLog("livesdk_anchor_chorus_intro_click", r3, new Object[]{IRoom.class, x.class});
    }

    private final void updateMultiChorusSwitchState() {
        MultiChorusContext.Companion.getClass();
        if (MultiChorusContext.a.d() == false) goto L19;
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r1 = r0.a();
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r2 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1.getValue();
        if (r2 == null) goto L19;
        if (r2.a != true) goto L19;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e r3 = obtainSwitchItemView(SwitchItemType.MULTI_CHORUS);
        if (r3 == null) goto L23;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r4 = r0.a();
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r5 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r4.getValue();
        if (r5 == null) goto L17;
        boolean r6 = r5.b;
    L18:
        int r7 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e.f;
        r3.d(r6, false);
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e.c(r3, 0);
        return;
    L17:
        r6 = false;
        goto L18
    L23:
        return;
    L19:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e r8 = obtainSwitchItemView(SwitchItemType.MULTI_CHORUS);
        if (r8 == null) goto L25;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e.c(r8, 8);
        return;
    }

    public final void hideTouchOutSide() {
        if (((Boolean) vm2.d.S2.getValue(null, vm2.d.a[198(0xc6, float:2.77E-43)])).booleanValue() == false) goto L10;
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        View r1 = r0.findViewById(2131389843);
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    L12:
        return;
    L11:
        return;
    }

    public KSongSettingDialog() {
        this.settingDialogHeight = s1.f(481.0f);
        this.switchViewMap$delegate = LazyKt.lazy(KSongSettingDialog$switchViewMap$2.INSTANCE);
        this.compositeDisposable$delegate = LazyKt.lazy(KSongSettingDialog$compositeDisposable$2.INSTANCE);
        this.kSongSettingViewModel$delegate = LazyKt.lazy(KSongSettingDialog$kSongSettingViewModel$2.INSTANCE);
        this.updateSettingByType = new KSongSettingDialog$updateSettingByType$1(this);
        this.confirmCallback = new KSongSettingDialog$confirmCallback$1(this);
        this.cancelCallback = new KSongSettingDialog$cancelCallback$1(this);
        this.updateSettingCallback = new KSongSettingDialog$updateSettingCallback$1(this);
    }

    private final boolean closeAudienceSingSwitchPreCheck() {
        if (ne2.a.a() == false) goto L6;
        f2.b(2131918313, 0);
        return false;
    L6:
        return true;
    }

    private final void initDialog() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L25;
        RadiusLayout r1 = r0.findViewById(2131389519);
        if (r1 == null) goto L26;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.height = -2;
        r2.width = -1;
        ViewGroup.LayoutParams r3 = null;
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        ViewGroup.LayoutParams r4 = null;
    L10:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L14;
        r5.setMargins(0, 0, 0, 0);
    L14:
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == false) goto L17;
        r3 = r2;
    L17:
        CoordinatorLayout.LayoutParams r6 = (CoordinatorLayout.LayoutParams) r3;
        if (r6 == null) goto L21;
        r6.gravity = 85;
    L21:
        if ((r1 instanceof RadiusLayout) == false) goto L23;
        r1.setMaxHeight(0);
    L23:
        r1.setLayoutParams(r2);
        return;
    L9:
        r4 = r2;
        goto L10
    L26:
        return;
    }

    private final boolean isXScreen() {
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        return true;
    L5:
        if (FoldScreenUtils.f() == true) goto L8;
        return false;
    }

    private final boolean needShowHideLyricsForSubtitle() {
        u r0 = m.d();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r1 = r0.s();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L11;
        int r4 = r3.a;
    L13:
        if (vm2.c.b().getDismissKtvComponentLyricsAndMidiOnStageSubtitle() == false) goto L20;
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L20;
        if (r5.hitStageAB() != true) goto L20;
        if (r4 != 5) goto L20;
    L25:
        return true;
    L20:
        if (r4 == 0) goto L22;
        return false;
    L22:
        if (com.bytedance.android.live.ktv.common.util.a.c().isLiveTypeAudio() != true) goto L28;
        int r6 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(com.bytedance.android.live.ktv.common.util.j.i()) == true) goto L25;
        return false;
    L28:
        return false;
    L11:
        r4 = 0;
        goto L13
    }

    private final void setupDialogWindowWidth() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L12;
        Window r1 = r0.getWindow();
        if (r1 != null) goto L7;
        return;
    L7:
        if (isXScreen() == false) goto L9;
        int r2 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L10:
        r1.setLayout(r2, -1);
        return;
    L9:
        r2 = -1;
        goto L10
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        getCompositeDisposable().clear();
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ boolean access$closeAudienceSingSwitchPreCheck(KSongSettingDialog r0) {
        return r0.closeAudienceSingSwitchPreCheck();
    }

    public static final /* synthetic */ Function2 access$getCancelCallback$p(KSongSettingDialog r0) {
        return r0.cancelCallback;
    }

    public static final /* synthetic */ Disposable access$getCloseChallengeDisposable$p(KSongSettingDialog r0) {
        return r0.closeChallengeDisposable;
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(KSongSettingDialog r0) {
        return r0.getCompositeDisposable();
    }

    public static final /* synthetic */ Function3 access$getConfirmCallback$p(KSongSettingDialog r0) {
        return r0.confirmCallback;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b access$getKSongSettingViewModel$p(KSongSettingDialog r0) {
        return r0.getKSongSettingViewModel();
    }

    public static final /* synthetic */ Function3 access$getUpdateSettingByType$p(KSongSettingDialog r0) {
        return r0.updateSettingByType;
    }

    public static final /* synthetic */ Function2 access$getUpdateSettingCallback$p(KSongSettingDialog r0) {
        return r0.updateSettingCallback;
    }

    public static final /* synthetic */ boolean access$hasApplyUser(KSongSettingDialog r0) {
        return r0.hasApplyUser();
    }

    public static final /* synthetic */ void access$openRulePage(KSongSettingDialog r0) {
        r0.openRulePage();
    }

    public static final /* synthetic */ void access$updateMultiChorusSwitchState(KSongSettingDialog r0) {
        r0.updateMultiChorusSwitchState();
    }

    private final void addHideLyricsForSubtitle(Context r3) {
        addSwitchItemView(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e(new b(this), r3), SwitchItemType.HIDE_LYRICS_FOR_SUBTITLE);
    }

    private final void dismissMainDialog(Context r2) {
        KSongOrderSongUtilKt.i(r2, CloseOrderSongDialogSource.OPEN_KTV_CHALLENGE_SETTING_DIALOG);
    }

    private final void initView(View r5) {
        LinearLayout r0 = null;
        if (r5 == null) goto L5;
        View r1 = r5.findViewById(2131381758);
    L6:
        this.outside = r1;
        if (r5 == null) goto L9;
        ConstraintLayout r2 = (ConstraintLayout) r5.findViewById(2131367728);
    L10:
        this.container = r2;
        if (r5 == null) goto L13;
        FrameLayout r3 = (FrameLayout) r5.findViewById(2131389111);
    L14:
        this.topArea = r3;
        if (r5 == null) goto L17;
        ImageView r4 = (ImageView) r5.findViewById(2131363802);
    L18:
        this.backView = r4;
        if (r5 == null) goto L21;
        TextView r6 = (TextView) r5.findViewById(2131388920);
    L22:
        this.titleTv = r6;
        if (r5 == null) goto L25;
        View r7 = r5.findViewById(2131369232);
    L26:
        this.dividerLine = r7;
        if (r5 == null) goto L29;
        r0 = (LinearLayout) r5.findViewById(2131367802);
    L29:
        this.contentArea = r0;
        View r8 = this.outside;
        if (r8 == null) goto L32;
        r8.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L32:
        ImageView r9 = this.backView;
        if (r9 == null) goto L35;
        r9.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L35:
        LinearLayout r10 = this.contentArea;
        if (r10 == null) goto L38;
        r10.removeAllViews();
    L38:
        Context r11 = getContext();
        if (r11 == null) goto L43;
        addSwitchItemView(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e(new c(this), r11), SwitchItemType.KTV_CHALLENGE);
        addSwitchItemView(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e(new d(this), r11), SwitchItemType.AUDIENCE_SING);
        addSwitchItemView(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e(new e(this), r11), SwitchItemType.MULTI_CHORUS);
        if (needShowHideLyricsForSubtitle() == false) goto L43;
        addHideLyricsForSubtitle(r11);
    L43:
        TextView r12 = this.titleTv;
        if (r12 == null) goto L46;
        r12.setClickable(true);
    L46:
        TextView r13 = this.titleTv;
        if (r13 == null) goto L49;
        r13.setFocusableInTouchMode(true);
    L49:
        int r14 = r3.a;
        r3.a(this.titleTv, s1.B(2131918403));
        Disposable r15 = MultiChorusContext.Companion.g(new g(this));
        if (r15 == null) goto L52;
        RxUtilKt.c(r15, getCompositeDisposable());
    L52:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r16 = KtvComponentContext.Companion.a();
        if (r16 == null) goto L56;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r16, this, AnonymousClass5.INSTANCE, new h(this));
    L56:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L58;
    L59:
        o r17 = m.i();
        if (r17 == null) goto L78;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L78;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L78;
        if (r19.isLiveTypeAudio() != true) goto L78;
        u r20 = m.d();
        if (r20 == null) goto L90;
        com.bytedance.live.datacontext.j r21 = r20.s();
        if (r21 == null) goto L90;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
        if (r22 == null) goto L90;
        BehaviorSubject r23 = r22.a();
        if (r23 == null) goto L90;
        Disposable r24 = r23.subscribe(new i(this));
        if (r24 == null) goto L90;
        getCompositeDisposable().add(r24);
    L90:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L103;
        if (ne2.a.c() == false) goto L103;
        IMiddlewareUserService r25 = jc1.k.f(IMiddlewareUserService.class);
        if (r25 == null) goto L103;
        com.bytedance.android.livesdk.user.e r26 = r25.user();
        if (r26 == null) goto L103;
        Observable r27 = r26.u();
        if (r27 == null) goto L103;
        Disposable r28 = r27.subscribe(new f(this));
        if (r28 == null) goto L103;
        RxUtilKt.c(r28, getCompositeDisposable());
    L103:
        if (MultiChorusContext.a.d() == false) goto L107;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e r29 = obtainSwitchItemView(SwitchItemType.MULTI_CHORUS);
        if (r29 == null) goto L107;
        r29.b();
    L107:
        ConstraintLayout r30 = this.container;
        if (r30 == null) goto L110;
        r30.setImportantForAccessibility(2);
    L110:
        LinearLayout r31 = this.contentArea;
        if (r31 == null) goto L113;
        r31.setImportantForAccessibility(2);
    L113:
        r3.c(this.backView, s1.B(2131918650), true);
        r3.a(this.titleTv, s1.B(2131918403));
        return;
    L78:
        u r32 = m.d();
        if (r32 == null) goto L90;
        com.bytedance.live.datacontext.j r33 = r32.getVideoTalkRoomSubScene();
        if (r33 == null) goto L90;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r34 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r33.getValue();
        if (r34 == null) goto L90;
        BehaviorSubject r35 = r34.a();
        if (r35 == null) goto L90;
        Disposable r36 = r35.subscribe(new j(this));
        if (r36 == null) goto L90;
        getCompositeDisposable().add(r36);
        goto L90
    L58:
        if (KtvUtilsKt.d() == false) goto L90;
    L25:
        r7 = null;
        goto L26
    L21:
        r6 = null;
        goto L22
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final String obtainActionType(boolean r1) {
        if (r1 == false) goto L5;
        return SwitchActionResultType.OPEN_TYPE.getValue();
    L5:
        return SwitchActionResultType.CLOSE_TYPE.getValue();
    }

    private final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e obtainSwitchItemView(SwitchItemType r4) {
        LinearLayout r0 = this.contentArea;
        View r1 = null;
        if (r0 == null) goto L10;
        View r5 = r0.getChildAt(r0.indexOfChild(getSwitchViewMap().get(r4)));
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e) == false) goto L9;
        r1 = r5;
    L9:
        return (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e) r1;
    L10:
        return null;
    }

    private final UpdateSongSettingType obtainUpdateSongSettingType(SwitchItemType r2) {
        if (r2 != SwitchItemType.AUDIENCE_SING) goto L6;
        return UpdateSongSettingType.AUDIENCE_ADD_SONG;
    L6:
        if (r2 != SwitchItemType.MULTI_CHORUS) goto L9;
        return UpdateSongSettingType.AUDIENCE_MULTI_CHORUS;
    L9:
        if (r2 != SwitchItemType.HIDE_LYRICS_FOR_SUBTITLE) goto L12;
        return UpdateSongSettingType.HIDE_LYRICS_SUBTITLE_OPEN;
    L12:
        return UpdateSongSettingType.UNKNOWN;
    }

    private final void reversalSwitchCheckedState(SwitchItemType r2) {
        int r0 = ke2.b.a;
        ke2.b.b(SwitchActionResultType.FAILED_TYPE.getValue(), r2);
    }

    private final void updateKtvChallengeSwitchStatus(boolean r2) {
        if (r2 == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e r3 = obtainSwitchItemView(SwitchItemType.KTV_CHALLENGE);
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e.c(r3, 0);
        return;
    L10:
        return;
    L6:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e r4 = obtainSwitchItemView(SwitchItemType.KTV_CHALLENGE);
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e.c(r4, 8);
        return;
    }

    public final void injectKtvTopControlBarHeight(int r1) {
        if (r1 != 0) goto L5;
        this.settingDialogHeight = s1.f(533.0f);
        return;
    }

    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        initDialog();
        setupDialogWindowWidth();
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r5).setPadding(0, 0, 0, 0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(85);
        r5.setSoftInputMode(48);
        return;
    L9:
        return;
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954697);
        setBottomSheetSlideProcessor(k.a);
    }

    public Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public static final /* synthetic */ void access$dismissMainDialog(KSongSettingDialog r0, Context r1) {
        r0.dismissMainDialog(r1);
    }

    public static final /* synthetic */ boolean access$isMultiLinkScene(KSongSettingDialog r0, int r1) {
        return r0.isMultiLinkScene(r1);
    }

    public static final /* synthetic */ String access$obtainActionType(KSongSettingDialog r0, boolean r1) {
        return r0.obtainActionType(r1);
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e access$obtainSwitchItemView(KSongSettingDialog r0, SwitchItemType r1) {
        return r0.obtainSwitchItemView(r1);
    }

    public static final /* synthetic */ UpdateSongSettingType access$obtainUpdateSongSettingType(KSongSettingDialog r0, SwitchItemType r1) {
        return r0.obtainUpdateSongSettingType(r1);
    }

    public static final /* synthetic */ void access$reversalSwitchCheckedState(KSongSettingDialog r0, SwitchItemType r1) {
        r0.reversalSwitchCheckedState(r1);
    }

    public static final /* synthetic */ void access$setCloseChallengeDisposable$p(KSongSettingDialog r0, Disposable r1) {
        r0.closeChallengeDisposable = r1;
    }

    public static final /* synthetic */ void access$updateKtvChallengeSwitchStatus(KSongSettingDialog r0, boolean r1) {
        r0.updateKtvChallengeSwitchStatus(r1);
    }

    private final void addSwitchItemView(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.e r2, SwitchItemType r3) {
        LinearLayout r0 = this.contentArea;
        if (r0 == null) goto L5;
        r0.removeView(r2);
    L5:
        LinearLayout r1 = this.contentArea;
        if (r1 == null) goto L8;
        r1.addView(r2);
    L8:
        getSwitchViewMap().put(r3, r2);
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ConstraintLayout r4 = this.container;
        if (r4 == null) goto L7;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L7;
        r5.height = this.settingDialogHeight;
    L8:
        ConstraintLayout r6 = this.container;
        if (r6 == null) goto L11;
        r6.setLayoutParams(r5);
    L11:
        hideTouchOutSide();
        return;
    L7:
        r5 = null;
        goto L8
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565568, r3, false);
        initView(r5);
        return r5;
    }
}
