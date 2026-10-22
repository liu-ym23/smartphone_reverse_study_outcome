package com.larus.avatar.impl.onboarding;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.Keva;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.avatar.impl.databinding.LarusDialogDigitalAvatarOnboardingBinding;
import com.larus.avatar.impl.onboarding.model.DigitalAvatarAuthType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.SpanableDialog;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.home.impl.sdk.l1;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IVideoController;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.z2;
import com.larus.trace.DigitalAvatarProcessType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.o0;
import com.larus.utils.w0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.model.VideoRef;
import hq9.x4;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.a1;
import v19.i5;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0016J\u001a\u00103\u001a\u00020&2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020&H\u0016J\b\u00109\u001a\u00020&H\u0016J\b\u0010:\u001a\u00020&H\u0002J\u001a\u0010;\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u00010*2\u0006\u0010<\u001a\u00020$H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0003J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0016J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020&H\u0002J-\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020$2\u0016\u0010I\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010K0J\"\u0004\u0018\u00010KH\u0002¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020&H\u0002J\b\u0010O\u001a\u00020&H\u0002J\u0010\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020\u0007H\u0002J\b\u0010S\u001a\u00020&H\u0002J\u0010\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u000207H\u0002J\b\u0010W\u001a\u000207H\u0002J\u0018\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u0002072\u0006\u0010Z\u001a\u00020[H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/larus/avatar/impl/onboarding/DigitalAvatarOnboardingDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avatar/impl/databinding/LarusDialogDigitalAvatarOnboardingBinding;", "closeFromConfirmButton", "", "closeFromCloseButton", "dialogType", "Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthType;", "getDialogType", "()Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthType;", "dialogType$delegate", "Lkotlin/Lazy;", "userAvatarImgConfig", "Lcom/larus/platform/model/UserAvatarImgConfig;", "getUserAvatarImgConfig", "()Lcom/larus/platform/model/UserAvatarImgConfig;", "userAvatarImgConfig$delegate", "userAvatarAuthVideoConfig", "Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthVideoConfig;", "getUserAvatarAuthVideoConfig", "()Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthVideoConfig;", "userAvatarAuthVideoConfig$delegate", "userAvatarAuthStyleConfig", "Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthStyleConfig;", "getUserAvatarAuthStyleConfig", "()Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthStyleConfig;", "userAvatarAuthStyleConfig$delegate", "videoController", "Lcom/larus/platform/api/IVideoController;", "getVideoController", "()Lcom/larus/platform/api/IVideoController;", "videoController$delegate", "getTheme", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "dismiss", "dismissAllowingStateLoss", "checkRadio", "setClipViewTopCornerRadius", "radius", "initView", "initText", "privacyDialog", "Lcom/larus/common_ui/dialog/SpanableDialog;", "showPrivacyDialog", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "openLegacyUrl", "starlingStr", "resId", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "needPrivacyAgreement", "initPrivacyCheck", "performConfirmAction", "isMute", "initMuteIcon", "showMute", "mobPopShow", "mobPopClick", "clickType", "getDialogName", "getMediaType", "reportEvent", "eventName", "params", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarOnboardingDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f290836n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogDigitalAvatarOnboardingBinding f290837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f290838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f290839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f290840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f290841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f290842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f290843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f290844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SpanableDialog f290845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f290846m;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f290847a = null;

        static {
            int[] r100 = new int[DigitalAvatarAuthType.values().length];
            r100[DigitalAvatarAuthType.IMAGE_AVATAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DigitalAvatarAuthType.CREATE_NEW_VIDEO_AVATAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DigitalAvatarAuthType.APPEND_VIDEO_MATERIAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f290847a = r100;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public final DigitalAvatarAuthType V90() {
        return (DigitalAvatarAuthType) this.f290840g.getValue();
    }

    public final n88.a X90() {
        return (n88.a) this.f290843j.getValue();
    }

    public DigitalAvatarOnboardingDialog() {
        this.f290840g = LazyKt.lazy(new c(this));
        this.f290841h = LazyKt.lazy(new e(this));
        this.f290842i = LazyKt.lazy(new f(this));
        this.f290843j = LazyKt.lazy(new g(this));
        this.f290844k = LazyKt.lazy(new h());
        this.f290846m = true;
    }

    public final String U90() {
        DigitalAvatarAuthType r100 = V90();
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 != (-1)) goto L9;
        return "create_replica";
    L9:
        if (r101 != 1) goto L11;
        return "create_replica";
    L11:
        if (r101 != 2) goto L13;
        return "create_replica";
    L13:
        if (r101 != 3) goto L16;
        return "replica_upload_video";
    L16:
        throw new NoWhenBranchMatchedException();
    L5:
        r101 = b.f290847a[r100.ordinal()];
        goto L7
    }

    public final String W90() {
        if (V90() != DigitalAvatarAuthType.IMAGE_AVATAR) goto L14;
        String r100 = ((n88.b) this.f290842i.getValue()).d();
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        return "image";
    L8:
        if (r100.length() == 0) goto L11;
        r101 = false;
    L14:
        return "video";
    }

    public final void aa0() {
        if (V90() == DigitalAvatarAuthType.APPEND_VIDEO_MATERIAL) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        com.larus.avatar.impl.onboarding.b r101 = com.larus.avatar.impl.onboarding.b.f290851a;
        com.larus.avatar.impl.onboarding.b.b();
    L8:
        this.f290838e = true;
        Dialog r102 = getDialog();
        if (r102 == null) goto L11;
        S90(r102);
    L11:
        Bundle r103 = getArguments();
        if (r103 != null) goto L14;
        r103 = com.larus.utils.f.c(new Pair[0]);
    L14:
        r103.putString("previous_page", "replica_onboarding");
        String r104 = r103.getString("replica_create_id", "");
        Intrinsics.checkNotNull(r104);
        if (StringsKt.isBlank(r104) == false) goto L17;
        r103.putString("replica_create_id", fy9.a.a());
    L17:
        r103.putString("scene", "create");
        r103.putBoolean("is_from_onboarding", true);
        Bundle r105 = getArguments();
        if (r105 == null) goto L20;
        int r106 = r105.getInt("digital_avatar_onboarding_dialog_type", -1);
        DigitalAvatarAuthType.Companion.getClass();
        DigitalAvatarAuthType r107 = DigitalAvatarAuthType.a.a(r106);
    L21:
        if (r107 != null) goto L23;
        int r108 = -1;
    L24:
        if (r108 == (-1)) goto L35;
        if (r108 != 1) goto L27;
        int r109 = DigitalAvatarProcessType.RE_UPLOAD_IMAGE.getId();
    L36:
        r103.putInt("digital_avatar_process_type", r109);
        r103.putBoolean("skip_digital_avatar_onboarding", true);
        r103.putString("click_from", "pop");
        FLogger.f375446a.i("DigitalAvatarOnboardingDialog", "performConfirmAction: dialogType=" + r107 + ", processTypeId=" + r109);
        FragmentActivity r110 = getActivity();
        if (r110 == null) goto L40;
        com.bytedance.router.i r111 = SmartRouter.buildRoute(r110, "//flow/create_digital_avatar");
        r111.f267554c.putExtras(r103);
        r111.f267554c.addFlags(268435456);
        r111.e(1000);
        return;
    L40:
        return;
    L27:
        if (r108 != 2) goto L29;
        r109 = DigitalAvatarProcessType.BOTH_IMAGE_AND_VIDEO.getId();
        goto L36
    L29:
        if (r108 != 3) goto L32;
        r109 = DigitalAvatarProcessType.APPEND_VIDEO_ONLY.getId();
        goto L36
    L32:
        throw new NoWhenBranchMatchedException();
    L35:
        r109 = DigitalAvatarProcessType.UNKNOWN.getId();
        goto L36
    L23:
        r108 = b.f290847a[r107.ordinal()];
        goto L24
    L20:
        r107 = null;
        goto L21
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4 Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.w("DigitalAvatarOnboardingDialog", th);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L9
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L9
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L9
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4 Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.w("DigitalAvatarOnboardingDialog", th);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L9
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L9
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L9
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        LarusDialogDigitalAvatarOnboardingBinding r100 = this.f290837d;
        if (r100 == null) goto L7;
        VideoPlayView r101 = r100.f290729e;
        if (r101 == null) goto L7;
        r101.D();
    L7:
        this.f290837d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        LarusDialogDigitalAvatarOnboardingBinding r100 = this.f290837d;
        if (r100 == null) goto L8;
        VideoPlayView r101 = r100.f290729e;
        if (r101 == null) goto L9;
        VideoPlayView.z(r101, 0, 2);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LarusDialogDigitalAvatarOnboardingBinding r100 = this.f290837d;
        if (r100 == null) goto L8;
        VideoPlayView r101 = r100.f290729e;
        if (r101 == null) goto L9;
        VideoPlayView.H(r101, 0, 2);
        return;
    L9:
        return;
    }

    public static void S90(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final void T90(DigitalAvatarOnboardingDialog r100) {
        r100.Z90("click_agreement");
        Context r101 = r100.getContext();
        if (r101 == null) goto L6;
        com.larus.platform.service.q.f365787a.e(r101, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r100.getResources().getString(R.string.larus_flow_digital_avatar_legacy_url))}), null);
        return;
    }

    public final void Y90(boolean r100) {
        if (r100 == false) goto L18;
        LarusDialogDigitalAvatarOnboardingBinding r101 = this.f290837d;
        if (r101 == null) goto L8;
        ImageView r102 = r101.f290730f;
        if (r102 == null) goto L8;
        e1.x(r102);
    L8:
        LarusDialogDigitalAvatarOnboardingBinding r103 = this.f290837d;
        if (r103 == null) goto L13;
        ImageView r104 = r103.f290730f;
        if (r104 == null) goto L13;
        r104.setImageResource(R.drawable.larus_nex_pulse_dialog_mute);
    L13:
        LarusDialogDigitalAvatarOnboardingBinding r105 = this.f290837d;
        if (r105 == null) goto L24;
        ImageView r106 = r105.f290730f;
        if (r106 == null) goto L25;
        e1.d(r106, new d(this));
        return;
    L25:
        return;
    L24:
        return;
    L18:
        LarusDialogDigitalAvatarOnboardingBinding r107 = this.f290837d;
        if (r107 == null) goto L27;
        ImageView r108 = r107.f290730f;
        if (r108 == null) goto L28;
        e1.o(r108);
        return;
    L28:
        return;
    }

    public final void Z90(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("current_page", "replica_onboarding");
        r101.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, W90());
        r101.put("name", U90());
        r101.put("click_type", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("pop_click");
        r103.f21463a.merge(r102);
        r103.b();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r510) {
        super.onCreate(r510);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("previous_page");
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        r101 = "chat";
    L14:
        a1.c(null, null, null, null, null, "replica_onboarding", null, null, null, null, null, null, null, null, null, null, r101, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048705, -1, 7);
        JSONObject r103 = new JSONObject();
        r103.put("current_page", "replica_onboarding");
        r103.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, W90());
        r103.put("name", U90());
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("pop_show");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L17
        super.onDismiss(r100);     // Catch: Throwable -> L17
        if (this.f290838e == true) goto L8;
        FragmentActivity r101 = getActivity();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        r101.finish();     // Catch: Throwable -> L17
    L8:
        if (this.f290839f == false) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        Z90("out_pop");     // Catch: Throwable -> L17
    L15:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L10:
        if (this.f290838e == true) goto L12;
        r102 = true;
    L17:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final String ba0(int r100, Object... r101) {
    L12:
        e = move-exception;
        FLogger.f375446a.e("DigitalAvatarOnboardingDialog", "load starling string exception: " + e.getMessage());
        return "";
    L3:
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L7:
        if ((!r102) == false) goto L9;
        String r103 = getResources().getString(r100, Arrays.copyOf(r101, r101.length));     // Catch: Exception -> L12
    L10:
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L12
        return r103;
    L9:
        r103 = getResources().getString(r100);     // Catch: Exception -> L12
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r210);
        Dialog r100 = getDialog();
        if (r100 == null) goto L5;
        r100.setOnShowListener(new i());
    L5:
        z2 r101 = z2.f365865a;
        boolean r102 = true;
        float r103 = 1.21875f;
        if (r101.hasAvatarModelUpdate() == true) goto L18;
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L14;
        r104.H();
        VideoPortraitConfig r105 = l1.f346198a.a();
        if (r105 == null) goto L14;
        if (r105.getEnableAvatarCreation() != true) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L18;
        Float r107 = Float.valueOf(1.21875f);
    L19:
        if (r107 == null) goto L21;
        r103 = r107.floatValue();
    L21:
        LarusDialogDigitalAvatarOnboardingBinding r108 = this.f290837d;
        if (r108 == null) goto L33;
        r108.f290728d.setAspectRatio(1.0f);
        VideoPlayView r109 = r108.f290729e;
        ViewGroup.LayoutParams r111 = r109.getLayoutParams();
        if ((r111 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
    L27:
        if (r112 == null) goto L29;
        int r113 = m0.f375450a;
        AppHost.Companion r114 = AppHost.f326268a;
        ((ViewGroup.MarginLayoutParams) r112).width = m0.c(r114.getApplication());
        ((ViewGroup.MarginLayoutParams) r112).height = (int) (m0.c(r114.getApplication()) / r103);
    L30:
        r109.setLayoutParams(r112);
        ConstraintLayout r115 = r108.f290725a;
        int r116 = i5.q();
        if (r115 == null) goto L33;
        r115.setOutlineProvider(new o(r116));
        r115.setClipToOutline(true);
        goto L33
    L29:
        r112 = null;
        goto L30
    L26:
        r112 = null;
    L33:
        LarusDialogDigitalAvatarOnboardingBinding r117 = this.f290837d;
        if (r117 != null) goto L36;
    L64:
        final LarusDialogDigitalAvatarOnboardingBinding r118 = this.f290837d;
        if (r118 != null) goto L67;
    L88:
        final LarusDialogDigitalAvatarOnboardingBinding r119 = this.f290837d;
        if (r119 != null) goto L91;
        return;
    L91:
        if (V90() != DigitalAvatarAuthType.APPEND_VIDEO_MATERIAL) goto L94;
        r102 = false;
    L94:
        if (r102 == false) goto L96;
        e1.x(r119.f290731g);
        r119.f290733i.setOnClickListener(new l(r119));
        r119.f290731g.setOnCheckedChangeListener(new m(this));
        return;
    L96:
        e1.o(r119.f290731g);
        return;
    L67:
        if (o0.d(((n88.b) this.f290842i.getValue()).d()) == false) goto L84;
        n88.b r120 = (n88.b) this.f290842i.getValue();
        VideoPlayView r121 = r118.f290729e;
        r121.setIsMuted(true);
        r121.setBackgroundColor(ContextCompat.getColor(AppHost.f326268a.getApplication(), R.color.larus_base_2));
        r121.setEnabled(false);
        r121.setBanInnerDismiss(true);
        boolean r122 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L73;
        String r123 = r120.a();
        if (r123 != null) goto L74;
        r123 = r120.b();
    L74:
        String r124 = r123;
        if (v19.h.a(null) == false) goto L80;
        String r125 = r120.c();
        if (r125 != null) goto L79;
        String r126 = r120.d();
    L81:
        String r127 = r126;
    L82:
        VideoPlayView.e(r121, (IVideoController) this.f290844k.getValue(), r127, null, null, null, null, 60);
        VideoPlayView.p(r121, r124, r124, null, Integer.valueOf(r121.getHeight()), Integer.valueOf(r121.getWidth()), null, null, null, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2);
        r121.setIsMuted(this.f290846m);
        r121.M();
        Y90(true);
        e1.o(r118.f290728d);
    L87:
        e1.d(r118.f290726b, new j(this));
        r118.f290734j.setOnClickListener(new n(this));
        e1.d(r118.f290727c, new k(this, r118));
        goto L88
    L79:
        r127 = r125;
        goto L82
    L80:
        r126 = r120.d();
        goto L81
    L73:
        r123 = r120.b();
        goto L74
    L84:
        if (o0.d(((x4) this.f290841h.getValue()).f486817a) == false) goto L86;
        ImageLoaderKt.u(r118.f290728d, ((x4) this.f290841h.getValue()).f486817a, "digital_avatar_onboarding_image");
    L86:
        Y90(false);
        e1.o(r118.f290729e);
        goto L87
    L36:
        if (r101.hasAvatarModelUpdate() == true) goto L48;
        IFlowSdkDepend r128 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r128 == null) goto L44;
        r128.H();
        VideoPortraitConfig r129 = l1.f346198a.a();
        if (r129 == null) goto L44;
        if (r129.getEnableAvatarCreation() != true) goto L44;
        boolean r130 = true;
    L45:
        if (r130 == true) goto L48;
        r117.f290735k.setText(getResources().getString(R.string.larus_replica_bottomsheet_title_replica));
        r117.f290732h.setText(getResources().getString(R.string.larus_replica_bottomsheet_desc_legal));
        r117.f290727c.setText(getResources().getString(R.string.larus_replica_bottomsheet_btn_newReplica));
        r117.f290734j.setUrlSpannedText(getResources().getString(R.string.larus_replica_bottomsheet_select_agree));
        TextView r131 = r117.f290727c;
        int r132 = w0.f375484a;
        r131.setBackground(w0.b(Integer.valueOf(ContextCompat.getColor(AppHost.f326268a.getApplication(), R.color.larus_primary_50)), Float.valueOf(i5.q()), 0.0f, null, 12));
    L44:
        r130 = false;
    L48:
        Context r133 = getContext();
        if (r133 != null) goto L51;
        r133 = AppHost.f326268a.getApplication().getApplicationContext();
    L51:
        String r134 = r133.getPackageName();
        int r135 = getResources().getIdentifier("larus_" + X90().f(), "string", r134);
        int r136 = getResources().getIdentifier("larus_" + X90().e(), "string", r134);
        int r137 = getResources().getIdentifier("larus_" + X90().d(), "string", r134);
        int r138 = getResources().getIdentifier("larus_" + X90().b(), "string", r134);
        r117.f290735k.setText(ba0(r135, new Object[0]));
        r117.f290732h.setText(ba0(r136, new Object[0]));
        r117.f290727c.setText(ba0(r138, new Object[0]));
        r117.f290734j.setUrlSpannedText(ba0(r137, new Object[0]));
        TextView r139 = r117.f290727c;
        int r140 = w0.f375484a;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L54
        Object r142 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(X90().a())));     // Catch: Throwable -> L54
    L57:
        if (Result.m9455isFailureimpl(r142) == false) goto L59;
        r142 = null;
    L59:
        Integer r143 = (Integer) r142;
        if (r143 == null) goto L62;
        int r144 = r143.intValue();
    L63:
        r139.setBackground(w0.b(Integer.valueOf(r144), Float.valueOf(i5.q()), 0.0f, null, 12));
        goto L64
    L62:
        r144 = ContextCompat.getColor(AppHost.f326268a.getApplication(), R.color.larus_primary_50);
    L54:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        r106 = false;
    L18:
        r107 = X90().c();
        goto L19
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L10
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);     // Catch: Throwable -> L10
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L14;
    L8:
        ((Keva) DigitalAvatarOnboardingShowHelper.f290848a.getValue()).storeBoolean("show_onboarding_dialog", true);     // Catch: Throwable -> L10
        return;
    L14:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13 Throwable -> L10
    L7:
        super.show(r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        FLogger.f375446a.w("DigitalAvatarOnboardingDialog", th);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialog_digital_avatar_onboarding, r111, false);
        int r114 = R.id.close_btn;
        View r100 = ViewBindings.findChildViewById(r113, R.id.close_btn);
        if (r100 == null) goto L25;
        r114 = R.id.confirm_btn;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.confirm_btn);
        if (r101 == null) goto L25;
        r114 = R.id.cover;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r113, R.id.cover);
        if (r102 == null) goto L25;
        r114 = R.id.cover_video;
        VideoPlayView r103 = (VideoPlayView) ViewBindings.findChildViewById(r113, R.id.cover_video);
        if (r103 == null) goto L25;
        r114 = R.id.mute_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r113, R.id.mute_icon);
        if (r104 == null) goto L25;
        r114 = R.id.select_privacy_circle_view;
        CheckBox r105 = (CheckBox) ViewBindings.findChildViewById(r113, R.id.select_privacy_circle_view);
        if (r105 == null) goto L25;
        r114 = R.id.select_privacy_text_view;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.select_privacy_text_view);
        if (r106 == null) goto L25;
        r114 = R.id.select_view;
        LinearLayout r107 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.select_view);
        if (r107 == null) goto L25;
        r114 = R.id.subtitle;
        UrlSpanTextView r115 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.subtitle);
        if (r115 == null) goto L25;
        r114 = R.id.title;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r113, R.id.title);
        if (r116 == null) goto L25;
        ConstraintLayout r117 = (ConstraintLayout) r113;
        this.f290837d = new LarusDialogDigitalAvatarOnboardingBinding(r117, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        return r117;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
