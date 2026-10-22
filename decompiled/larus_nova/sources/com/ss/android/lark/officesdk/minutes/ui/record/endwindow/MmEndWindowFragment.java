package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.NetworkUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapUtilKt;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmViewEndWindowLoadingBinding;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmEndWindowLoadingLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper;
import com.ss.android.lark.officesdk.minutes.ui.service.MmRecordingUiProviders;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.f;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.ttvideoengine.DataLoaderHelper;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Ý\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001u\b\u0007\u0018\u0000 \u0082\u00012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0002\u0082\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010M\u001a\u00020DH\u0016J\b\u0010N\u001a\u00020DH\u0016J\b\u0010O\u001a\u00020DH\u0016J\b\u0010P\u001a\u00020DH\u0016J\u001a\u0010Q\u001a\u00020D2\u0006\u0010R\u001a\u00020H2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010S\u001a\u00020DH\u0002J1\u0010T\u001a\u00020D2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0002\u0010ZJ\b\u0010[\u001a\u00020DH\u0002J\b\u0010\\\u001a\u00020DH\u0002J\u0010\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\nH\u0002J\u0010\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020\nH\u0002J\b\u0010a\u001a\u00020<H\u0002J\b\u0010b\u001a\u00020<H\u0002J(\u0010c\u001a\u00020D2\u0006\u0010d\u001a\u00020V2\u0006\u0010e\u001a\u00020V2\u0006\u0010f\u001a\u00020V2\u0006\u0010g\u001a\u00020VH\u0014J\u0010\u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020D2\u0006\u0010l\u001a\u00020<H\u0014J\b\u0010m\u001a\u00020DH\u0002J\b\u0010n\u001a\u00020DH\u0002J\u001a\u0010o\u001a\u00020D2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0002J\r\u0010t\u001a\u00020uH\u0002¢\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020DH\u0002J\b\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020D2\u0006\u0010{\u001a\u00020|H\u0002J\b\u0010}\u001a\u00020DH\u0002J\b\u0010~\u001a\u00020DH\u0002J\u0012\u0010\u007f\u001a\u00020D2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000e\u001a\u0004\b@\u0010A¨\u0006\u0083\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowUIEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "getMmUccApi", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "setMmUccApi", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "navRectProvider", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "getNavRectProvider", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "navRectProvider$delegate", "appletNavigator", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmAppletNavigator;", "getAppletNavigator", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmAppletNavigator;", "appletNavigator$delegate", "hostBridge", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmRecordingHostBridge;", "getHostBridge", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmRecordingHostBridge;", "hostBridge$delegate", "_endWindowView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/endwindow/MmEndWindowFragmentView;", "endWindowView", "getEndWindowView", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/endwindow/MmEndWindowFragmentView;", "webHelper", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowWebHelper;", "statTracker", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/MmEndWindowStatTracker;", "getStatTracker", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/MmEndWindowStatTracker;", "statTracker$delegate", "uiProviders", "Lcom/ss/android/lark/officesdk/minutes/ui/service/MmRecordingUiProviders;", "getUiProviders", "()Lcom/ss/android/lark/officesdk/minutes/ui/service/MmRecordingUiProviders;", "uiProviders$delegate", "dataKey", "sessionId", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "loadTimeoutJob", "Lkotlinx/coroutines/Job;", "hasReceivedLoadComplete", "", "hasTrackedEndWindowShowFail", "isInvalidRestore", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel;", "viewModel$delegate", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onResume", "onPause", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "onViewCreated", "view", "startEndWindowLoadTimeout", "trackEndWindowShowFailOnce", "errorCode", "", "errorMsg", "latencyMs", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "setupBackPressCallback", "initView", "openWebPageFromHost", "url", "openProfileFromHost", "userId", "supportHostBridge", "supportHostNavRect", "onWindowInsetsChanged", "left", "top", "right", "bottom", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDarkModeChanged", "isDarkMode", "updateUiWhenThemeChanged", "applyTopCloseButtonStyle", "handleChangeSpeaker", PlayerResolution.SDKKEY.ORIGIN, "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowChangeSpeakerOrigin;", "callback", "Lcom/ss/android/lark/officewebview/bridge/JsCallBack;", "createWebHelperListener", "com/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowFragment$createWebHelperListener$1", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowFragment$createWebHelperListener$1;", "observeState", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "closePage", "reason", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/CloseReason;", "clearCachedEntityIfNeeded", "markEndWindowClosedIfNeeded", "sendOpenPage", "entity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowEntity;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowFragment extends Hilt_MmEndWindowFragment<d, Object, c, MmEndWindowViewModel> implements d0c.c {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public final Lazy C;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f435844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f435846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f435847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f435848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public lwb.a f435849r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MmEndWindowWebHelper f435850s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f435851t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f435852u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f435853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f435854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MmRecordingUILaunchMode f435855x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Job f435856y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f435857z;

    public static final class a {
        public static MmEndWindowFragment a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "dataKey");
            MmEndWindowFragment r101 = new MmEndWindowFragment();
            Bundle r102 = new Bundle();
            r102.putString("mm_end_window_data_key", r100);
            Application r103 = LarkContext.getApplication();
            if (r103 == null) goto L5;
            PassportcConvention.f(r102, r103);
        L6:
            r101.setArguments(r102);
            return r101;
        L5:
            int r104 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "newInstance", "newInstance: Application not initialized, dataKey=" + r100, null);
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final String U90() {
        return (String) this.f435844m.getValue();
    }

    public final lwb.a fa0() {
        lwb.a r100 = this.f435849r;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("End window view is not created".toString());
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a ga0() {
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100 = this.f435845n;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mmUccApi");
        return null;
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c ha0() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c) this.f435851t.getValue();
    }

    public final MmEndWindowViewModel ia0() {
        return (MmEndWindowViewModel) this.C.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.B == false) goto L6;
        super.onDestroy();
        return;
    L6:
        FragmentActivity r100 = getActivity();
        boolean r101 = false;
        if (r100 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
    L23:
        FragmentActivity r103 = getActivity();
        if (r103 != null) goto L26;
    L28:
        boolean r104 = false;
    L29:
        if (r104 == false) goto L32;
    L41:
        super.onDestroy();
        return;
    L32:
        if (isRemoving() == true) goto L38;
        if (r103 != null) goto L35;
    L37:
        if (r101 == false) goto L41;
    L35:
        if (r103.isFinishing() != true) goto L37;
        r101 = true;
    L38:
        String r105 = this.f435853v;
        if (r105 == null) goto L41;
        ConcurrentHashMap<String, Object> r106 = uub.c.f551785a;
        Intrinsics.checkNotNullParameter(r105, "dataKey");
        uub.c.f551785a.remove(r105);
        goto L41
    L26:
        if (r103.isChangingConfigurations() != true) goto L28;
        r104 = true;
        goto L29
    L15:
        if (isRemoving() == true) goto L22;
        if (r100 != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == false) goto L23;
    L18:
        if (r100.isFinishing() != true) goto L20;
        r107 = true;
    L22:
        ga0().N().e(this.f435854w);
        goto L23
    L9:
        if (r100.isChangingConfigurations() != true) goto L11;
        r102 = true;
        goto L12
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        if (this.B == false) goto L6;
        super.onDestroyView();
        return;
    L6:
        ((MmRecordingUiProviders) this.f435852u.getValue()).a(getContext(), getChildFragmentManager());
        super.onDestroyView();
        Job r100 = this.f435856y;
        if (r100 == null) goto L9;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c r101 = ha0();
        if (r101.f435414e == true) goto L13;
        lvb.a.b(r101.f435411b, "[endTracking] hasTrackedView is false");
    L16:
        T90();
        MmEndWindowWebHelper r102 = this.f435850s;
        if (r102 == null) goto L21;
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.WEB, MapMonitorConst.EVENT_DESTROY, null, r102.f(), 4);
        r102.e();
        if (r102.f435885m == false) goto L21;
        MmRecordingMapReadHelper r104 = (MmRecordingMapReadHelper) r102.f435884l.getValue();
        r104.f435007b = null;
        r104.f435008c = null;
        MmRecordingMapUtilKt.b(LarkContext.getApplication(), r104.f435006a, "MmRecordingMapReadHelper.destroy");
    L21:
        this.f435849r = null;
        return;
    L13:
        if (r101.f435410a.d(r101.f435412c) == true) goto L15;
        lvb.a.b(r101.f435411b, "[endTracking] commonParam invalid, sessionId=" + r101.f435412c);
        goto L16
    L15:
        long r105 = (System.currentTimeMillis() - r101.f435413d) / ((long) 1000);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r106 = r101.f435410a;
        String r107 = r101.f435412c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r108 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r108.c("duration", r105);
        r108.e("source", "native");
        r106.g(r107, "vc_record_tail_window_duration_status", r108.a());
        r101.f435412c = "";
        r101.f435413d = 0;
        r101.f435414e = false;
        goto L16
    }

    public MmEndWindowFragment() {
        this.f435844m = LazyKt.lazy(new MmEndWindowFragment$logDetail$2(this));
        this.f435846o = LazyKt.lazy(new MmEndWindowFragment$navRectProvider$2(this));
        this.f435847p = LazyKt.lazy(new MmEndWindowFragment$appletNavigator$2(this));
        this.f435848q = LazyKt.lazy(new MmEndWindowFragment$hostBridge$2(this));
        this.f435851t = LazyKt.lazy(new MmEndWindowFragment$statTracker$2(this));
        this.f435852u = LazyKt.lazy(new MmEndWindowFragment$uiProviders$2(this));
        this.f435854w = "";
        this.f435855x = MmRecordingUILaunchMode.UNKNOWN;
        this.C = LazyKt.lazy(new MmEndWindowFragment$viewModel$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment
    public final /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a Z90() {
        return ia0();
    }

    public final void da0() {
        AppCompatImageView r100 = fa0().f511102e;
        Context r101 = r100.getContext();
        Intrinsics.checkNotNull(r101);
        r100.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r101).w(r101));
        r100.clearColorFilter();
        ImageViewCompat.setImageTintList(r100, UDColorUtils.getColorStateList(r101, com.ss.android.lark.officesdk.minutes.ui.style.a.a(r101).k()));
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.B == false) goto L5;
        return;
    L5:
        MmEndWindowWebHelper r100 = this.f435850s;
        if (r100 == null) goto L9;
        e r101 = r100.f435886n;
        lvb.a.e(r101.f435509b, "[onPause]");
        r101.f435512e = true;
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.B == false) goto L5;
        return;
    L5:
        MmEndWindowWebHelper r100 = this.f435850s;
        if (r100 == null) goto L9;
        r100.f435886n.a();
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void X90(boolean r100) {
        if (this.B == false) goto L5;
        return;
    L5:
        T90();
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.END_WINDOW, "updateUiWhenThemeChanged", null, U90(), 4);
        da0();
        MmEndWindowWebHelper r102 = this.f435850s;
        if (r102 == null) goto L9;
        r102.l(r100);
        return;
    }

    public final void ea0(CloseReason r100) {
        wvb.a.a((uub.a) this.f435847p.getValue(), getActivity(), r100);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (this.B == false) goto L5;
        return;
    L5:
        V90(true);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (LarkContext.getApplication() != null) goto L6;
        int r101 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.END_WINDOW, WidgetCostModule.TYPE_ON_CREATE, "Application not initialized, finish activity", U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L6:
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L9;
        String r104 = r102.getString("mm_end_window_data_key");
    L10:
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L19;
        int r106 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.END_WINDOW, WidgetCostModule.TYPE_ON_CREATE, "dataKey is null or blank, finish activity", U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L19:
        ConcurrentHashMap<String, Object> r107 = uub.c.f551785a;
        Intrinsics.checkNotNullParameter(r104, "dataKey");
        Object r108 = uub.c.f551785a.get(r104);
        if (r108 != null) goto L22;
        r108 = null;
    L22:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r109 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r108;
        if (r109 != null) goto L27;
        int r110 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.END_WINDOW, WidgetCostModule.TYPE_ON_CREATE, "Entity is null, finish activity, dataKey=".concat(r104), U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L27:
        if (r109.f434945c.shouldHandleUI() == true) goto L30;
        int r111 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.END_WINDOW, WidgetCostModule.TYPE_ON_CREATE, "uiLaunchMode is invalid, ui=" + r109.f434945c, U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L30:
        com.ss.android.lark.officesdk.minutes.ui.style.e r112 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r113 = r109.f434945c;
        r112.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.c(r113) != null) goto L34;
        int r114 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.END_WINDOW, WidgetCostModule.TYPE_ON_CREATE, "ui provider is missing, ui=" + r109.f434945c, U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L34:
        this.f435853v = r104;
        this.f435854w = r109.f434943a;
        this.f435855x = r109.f434945c;
        int r115 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.ENTRY, WidgetCostModule.TYPE_ON_CREATE, "page=end, ui=" + this.f435855x + ", session=" + this.f435854w, U90());
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c r116 = ha0();
        String r117 = r109.f434943a;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "sessionId");
        r116.f435412c = r117;
        r116.f435413d = System.currentTimeMillis();
        r116.f435414e = true;
        if (r116.f435410a.d(r116.f435412c) == true) goto L37;
        lvb.a.b(r116.f435411b, "[trackView] commonParam invalid, sessionId=" + r116.f435412c);
    L38:
        this.f435626h = Boolean.valueOf(W90());
        ia0().dispatchEvent(new c.a(r109));
        tvb.a r118 = (tvb.a) ga0().N().f435428g.getValue();
        String r119 = r109.f434943a;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "sessionId");
        MmRecordingCommonParam r120 = r118.f547708a.b(r119);
        if (r120 == null) goto L41;
        r103 = r120.getRecordId();
    L41:
        if (r103 != null) goto L43;
        r103 = "";
    L43:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r121 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r121.e("current_page", "feishu_recording_end_window_page");
        r121.e("feishu_record_id", r103);
        r121.e("enter_method", "recording_end_auto_open");
        r118.a(r119, CheckPointType.ENTER_PAGE, r121.a());
        return;
    L37:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r122 = r116.f435410a;
        String r123 = r116.f435412c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r124 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r124.e("source", "native");
        r122.g(r123, "vc_record_tail_window_view", r124.a());
        goto L38
    L12:
        if (StringsKt.isBlank(r104) == true) goto L15;
        r105 = false;
        goto L16
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        if (this.B == false) goto L5;
        return;
    L5:
        int r111 = uvb.b.f551863a;
        uvb.a.b(r100, uvb.c.f551872d0);
        uvb.b.a(r100, R.id.topCloseBtn, uvb.c.f551874e0);
        OnBackPressedCallback r101 = new MmEndWindowFragment$setupBackPressCallback$callback$1(this);
        FragmentActivity r112 = getActivity();
        if (r112 == null) goto L10;
        OnBackPressedDispatcher r113 = r112.getOnBackPressedDispatcher();
        if (r113 == null) goto L10;
        r113.addCallback(getViewLifecycleOwner(), r101);
    L10:
        Job r102 = this.f435856y;
        if (r102 == null) goto L13;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L13:
        this.f435857z = false;
        this.A = false;
        this.f435856y = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MmEndWindowFragment$startEndWindowLoadTimeout$1(this, null), 3, null);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r103 = ia0().getLatestEntity();
        da0();
        com.ss.android.lark.officesdk.minutes.ui.style.e r104 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r105 = this.f435855x;
        r104.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.b(r105).getCapability().e() == true) goto L16;
    L18:
        fa0().f511102e.setVisibility(0);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(fa0().f511102e, new MmEndWindowFragment$initView$1(this));
    L19:
        this.f435850s = new MmEndWindowWebHelper(ga0(), r103.f434946d.getMeetingId(), LifecycleOwnerKt.getLifecycleScope(this), fa0().f511100c, new MmEndWindowFragment$createWebHelperListener$1(this));
        aa0(MmEndWindowFragment$observeState$1.INSTANCE, new MmEndWindowFragment$observeState$2(this, null));
        aa0(MmEndWindowFragment$observeState$3.INSTANCE, new MmEndWindowFragment$observeState$4(this, null));
        return;
    L16:
        if (((uub.b) this.f435846o.getValue()) == null) goto L18;
        fa0().f511102e.setVisibility(8);
        goto L19
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        super.onCreateView(r110, r111, r112);
        if (this.B == true) goto L5;
        LayoutInflater r113 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r110.getContext(), this.f435855x));
        com.ss.android.lark.officesdk.minutes.ui.style.e r114 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r100 = this.f435855x;
        r114.getClass();
        f r115 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r100).getLayout();
        Intrinsics.checkNotNull(r113);
        lwb.a r116 = r115.i(r113, r111);
        this.f435849r = r116;
        MmEndWindowLoadingLayout r117 = r116.f511101d;
        MmRecordingUILaunchMode r118 = this.f435855x;
        if (r117.f435652b != null) goto L9;
    L11:
        r117.R5();
        r117.removeAllViews();
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(r118).getLayout().D(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r117.getContext(), r118)), r117);
        int r101 = R.id.viewSkeleton1;
        View r102 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton1);
        if (r102 == null) goto L61;
        r101 = R.id.viewSkeleton2;
        View r103 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton2);
        if (r103 == null) goto L61;
        r101 = R.id.viewSkeleton3;
        View r104 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton3);
        if (r104 == null) goto L61;
        r101 = R.id.viewSkeleton4;
        View r105 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton4);
        if (r105 == null) goto L61;
        r101 = R.id.viewSkeleton5;
        View r106 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton5);
        if (r106 == null) goto L61;
        r101 = R.id.viewSkeleton6;
        View r107 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton6);
        if (r107 == null) goto L61;
        r101 = R.id.viewSkeleton7;
        View r108 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton7);
        if (r108 == null) goto L61;
        r101 = R.id.viewSkeleton8;
        View r109 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton8);
        if (r109 == null) goto L61;
        r101 = R.id.viewSkeleton9;
        View r119 = ViewBindings.findChildViewById(r117, R.id.viewSkeleton9);
        if (r119 == null) goto L61;
        r117.f435652b = new OfficeSdkMmViewEndWindowLoadingBinding(r117, r102, r103, r104, r105, r106, r107, r108, r109, r119);
        r117.f435653c = r118;
        r117.setBackgroundColor(UIUtils.getColor(r117.getContext(), R.color.bg_body));
        OfficeSdkMmViewEndWindowLoadingBinding r120 = r117.f435652b;
        OfficeSdkMmViewEndWindowLoadingBinding r121 = null;
        if (r120 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L32:
        r117.S5(r120.f435592b, R.layout.office_sdk_mm_view_skeleton_64_16);
        OfficeSdkMmViewEndWindowLoadingBinding r122 = r117.f435652b;
        if (r122 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L35:
        r117.S5(r122.f435593c, R.layout.office_sdk_mm_view_skeleton_160_12);
        OfficeSdkMmViewEndWindowLoadingBinding r123 = r117.f435652b;
        if (r123 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r123 = null;
    L38:
        r117.S5(r123.f435594d, R.layout.office_sdk_mm_view_skeleton_64_16);
        OfficeSdkMmViewEndWindowLoadingBinding r124 = r117.f435652b;
        if (r124 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L41:
        r117.S5(r124.f435595e, R.layout.office_sdk_mm_view_skeleton_240_12);
        OfficeSdkMmViewEndWindowLoadingBinding r125 = r117.f435652b;
        if (r125 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r125 = null;
    L44:
        r117.S5(r125.f435596f, R.layout.office_sdk_mm_view_skeleton_280_12);
        OfficeSdkMmViewEndWindowLoadingBinding r126 = r117.f435652b;
        if (r126 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L47:
        r117.S5(r126.f435597g, R.layout.office_sdk_mm_view_skeleton_160_12);
        OfficeSdkMmViewEndWindowLoadingBinding r127 = r117.f435652b;
        if (r127 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r127 = null;
    L50:
        r117.S5(r127.f435598h, R.layout.office_sdk_mm_view_skeleton_240_12);
        OfficeSdkMmViewEndWindowLoadingBinding r128 = r117.f435652b;
        if (r128 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L53:
        r117.S5(r128.f435599i, R.layout.office_sdk_mm_view_skeleton_280_12);
        OfficeSdkMmViewEndWindowLoadingBinding r129 = r117.f435652b;
        if (r129 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L57:
        r117.S5(r121.f435600j, R.layout.office_sdk_mm_view_skeleton_160_12);
    L59:
        return r116.f511098a;
    L56:
        r121 = r129;
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r117.getResources().getResourceName(r101)));
    L9:
        if (r117.f435653c != r118) goto L11;
    L5:
        return new View(r110.getContext());
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void Y90(int r100, int r101, int r102, int r103) {
        int r104 = bwb.b.f21271a;
        MmUiLogScene r105 = MmUiLogScene.END_WINDOW;
        StringBuilder r106 = new StringBuilder("onWindowInsetsChanged: insets=[");
        r106.append(r100);
        r106.append(',');
        r106.append(r101);
        r106.append(',');
        r106.append(r102);
        r106.append(',');
        r106.append(r103);
        r106.append("], hasNavRectProvider=");
        if (((uub.b) this.f435846o.getValue()) == null) goto L5;
        boolean r107 = true;
    L6:
        r106.append(r107);
        bwb.b.f(r105, "onWindowInsetsChanged", r106.toString(), U90());
        com.ss.android.lark.officesdk.minutes.ui.style.e r108 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r109 = this.f435855x;
        r108.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.b(r109).getCapability().e() == true) goto L9;
    L11:
        ViewGroup.LayoutParams r110 = fa0().f511102e.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        r111.topMargin = r101 + UIUtils.dp2px(fa0().f511102e.getContext(), 2.0f);
        fa0().f511102e.setLayoutParams(r111);
        fa0().f511099b.setPadding(0, 0, 0, r103);
        return;
    L9:
        if (((uub.b) this.f435846o.getValue()) == null) goto L11;
        return;
    L5:
        r107 = false;
        goto L6
    }

    public static void ja0(MmEndWindowFragment r110, Integer r111, String r210, Long r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Long r112 = null;
    L15:
        if (r110.A == true) goto L23;
        r110.A = true;
        qvb.a r102 = qvb.a.f534934a;
        if (r101 != null) goto L20;
        String r103 = "";
    L21:
        qvb.a.c(r102, "endwindow", "error", r100, r103, null, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), r112, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT);
        return;
    L20:
        r103 = r101;
        goto L21
    L23:
        return;
    L13:
        r112 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
