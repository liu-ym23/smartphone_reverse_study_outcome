package com.larus.voice_setting.voice.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusDialogOptUserVoiceInfoBinding;
import com.larus.voice_setting.voice.ImageUploadViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020\u001dH\u0002J\b\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\b\u0010>\u001a\u00020\u0013H\u0002J\b\u0010?\u001a\u00020\u001dH\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\b\u0010D\u001a\u00020\u001dH\u0002J\b\u0010E\u001a\u00020\u001dH\u0016J\b\u0010F\u001a\u00020\u001dH\u0002J\u0012\u0010G\u001a\u00020\u001d2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\b\u0010J\u001a\u00020\u001dH\u0002J\b\u0010K\u001a\u00020\u001dH\u0002J\u0010\u0010L\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020\u0013H\u0002J\u0012\u0010N\u001a\u00020\u001d2\b\u0010O\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010P\u001a\u00020\u001d2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/UgcVoiceInfoOptimizeDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogOptUserVoiceInfoBinding;", "uploadViewModel", "Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "cropLauncher", "needModifyInfo", "", "isVoicePlay", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "jumpToCreateVoice", "Lkotlin/Function2;", "Lcom/larus/voice_setting/voice/bean/UgcVoiceInfo;", "", "getJumpToCreateVoice", "()Lkotlin/jvm/functions/Function2;", "setJumpToCreateVoice", "(Lkotlin/jvm/functions/Function2;)V", "currentAvatarUrl", "voiceName", "isPublic", "currentAvatarUri", "cloneFail", "value", "originalVoiceInfo", "getOriginalVoiceInfo", "()Lcom/larus/voice_setting/voice/bean/UgcVoiceInfo;", "setOriginalVoiceInfo", "(Lcom/larus/voice_setting/voice/bean/UgcVoiceInfo;)V", "currentVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "initTitleBar", "initAvatar", "openPhoto", "showImagePreviewDialog", "isDefaultAvatar", "initName", "initPermission", "updatePermissionStatus", "initCompleteButton", "initVoiceCheckBar", "updateVoicePlayStatus", "onStop", "updatePlayIcon", "handlePhotoPickerResult", "uri", "Landroid/net/Uri;", "initResultLauncher", "initViewModel", "changeCompleteButtonStatus", "enable", "setAvatarUrl", "url", "uploadAvatarFail", "message", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceInfoOptimizeDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f376546t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogOptUserVoiceInfoBinding f376547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f376548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActivityResultLauncher<String> f376549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f376550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f376551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f376552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f376553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f376554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2<? super Boolean, ? super r2a.f, Unit> f376555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f376556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f376557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f376558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f376559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f376560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r2a.f f376561r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SpeakerVoice f376562s;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f376563a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f376563a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f376563a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f376563a.invoke(r100);
        }
    }

    public static final class c implements p68.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UgcVoiceInfoOptimizeDialog f376564a;

        @Override // p68.e
        public final void onBegin() {
        }

        @Override // p68.e
        public final void onError() {
        }

        @Override // p68.e
        public final void onEnd() {
            UgcVoiceInfoOptimizeDialog r100 = this.f376564a;
            r100.f376553j = false;
            r100.X90();
        }

        public c(UgcVoiceInfoOptimizeDialog r100) {
            this.f376564a = r100;
        }
    }

    static {
    }

    public final void W90() {
        LarusDialogOptUserVoiceInfoBinding r100 = this.f376547d;
        if (r100 == null) goto L25;
        AppCompatImageView r101 = r100.f376090k;
        int r102 = 0;
        if (this.f376558o == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        AppCompatImageView r104 = r100.f376089j;
        if ((!this.f376558o) == false) goto L11;
        int r105 = 0;
    L12:
        r104.setVisibility(r105);
        Context r106 = getContext();
        if (r106 == null) goto L19;
        TextView r107 = r100.f376083d;
        if (this.f376558o == false) goto L17;
        String r108 = r106.getString(R.string.larus_ugc_voice_release);
    L18:
        r107.setText(r108);
        goto L19
    L17:
        r108 = r106.getString(R.string.larus_create_bot_done);
    L19:
        TextView r109 = r100.f376087h;
        if (this.f376558o == true) goto L23;
        r102 = 8;
    L23:
        r109.setVisibility(r102);
        return;
    L11:
        r105 = 8;
        goto L12
    L7:
        r103 = 8;
        goto L8
    }

    public final void X90() {
        if (this.f376553j == false) goto L9;
        LarusDialogOptUserVoiceInfoBinding r100 = this.f376547d;
        if (r100 == null) goto L15;
        LottieAdapterView r101 = r100.f376088i;
        if (r101 == null) goto L16;
        r101.playAnimation();
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusDialogOptUserVoiceInfoBinding r102 = this.f376547d;
        if (r102 == null) goto L18;
        LottieAdapterView r103 = r102.f376088i;
        if (r103 == null) goto L19;
        r103.cancelAnimation();
        r103.setProgress(0.0f);
        return;
    L19:
        return;
    }

    public final void Y90() {
        this.f376553j = !this.f376553j;
        X90();
        SpeakerVoice r100 = this.f376562s;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f376553j == false) goto L15;
        p2a.q.a().stopAudio();
        com.larus.audio.s0 r101 = p2a.q.a();
        String r102 = r100.getStyleId();
        AudioPreview r103 = r100.getPreview();
        if (r103 == null) goto L9;
        String r104 = r103.getPreviewAudio();
    L10:
        AudioPreview r105 = r100.getPreview();
        if (r105 == null) goto L13;
        String r106 = r105.getMd5();
    L14:
        com.larus.audio.s0.a.a(r101, r102, r104, r106, new c(this), null, null, 48);
        return;
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L15:
        p2a.q.a().stopAudio();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        if (this.f376553j == false) goto L5;
        Y90();
    L5:
        super.onStop();
    }

    public UgcVoiceInfoOptimizeDialog() {
        final Function0<Fragment> r100 = new UgcVoiceInfoOptimizeDialog$special$$inlined$viewModels$default$1(this);
        this.f376548e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ImageUploadViewModel.class), new UgcVoiceInfoOptimizeDialog$special$$inlined$viewModels$default$2(r100), new UgcVoiceInfoOptimizeDialog$special$$inlined$viewModels$default$3(r100, this));
        this.f376554k = LazyKt.lazy(new m0(this));
        this.f376556m = "";
        this.f376557n = "";
        this.f376558o = true;
        this.f376559p = "";
    }

    public static void S90(UgcVoiceInfoOptimizeDialog r100) {
        r100.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void T90(com.larus.common_ui.dialog.l0 r100) {
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

    public final void U90(boolean r100) {
        LarusDialogOptUserVoiceInfoBinding r101 = this.f376547d;
        if (r101 == null) goto L10;
        r101.f376083d.setClickable(r100);
        TextView r102 = r101.f376083d;
        if (r100 == false) goto L7;
        float r103 = 1.0f;
    L8:
        r102.setAlpha(r103);
        return;
    L7:
        r103 = 0.3f;
        goto L8
    }

    public final void V90(Uri r100) {
        if (r100 == null) goto L8;
        FLogger.f375446a.i("UgcVoiceInfoOptimizeDialog", "onActivityResult called, icon_uri = " + r100);
        Uri r101 = Uri.fromFile(new PolarisFileWrapper(requireActivity().getCacheDir(), "crop_voice_avatar"));
        Intent r102 = new Intent();
        Bundle r103 = new Bundle();
        r103.putParcelable("com.yalantis.ucrop.InputUri", r100);
        r103.putParcelable("com.yalantis.ucrop.OutputUri", r101);
        r103.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r103.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        ActivityResultLauncher<Intent> r104 = this.f376551h;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
        r104 = null;
    L6:
        r102.setClass(requireActivity(), UCropActivity.class);
        r102.putExtras(r103);
        r104.launch(r102);
        return;
    }

    public final void Z90(String r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        com.larus.common_ui.dialog.l0 r102 = (com.larus.common_ui.dialog.l0) this.f376554k.getValue();
        if (r102 == null) goto L9;
        T90(r102);
    L9:
        if (r100 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        t19.s.f544207a.getClass();
        t19.s.b(r101, R.string.larus_bot_upload_profile_pic_failed, false);
        return;
    L17:
        t19.s.f544207a.getClass();
        t19.s.c(r101, r100);
        return;
    L11:
        if (r100.length() == 0) goto L14;
        r103 = false;
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        View r103 = null;
        if ((r102 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r104 = (BottomSheetDialog) r102;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.findViewById(R.id.design_bottom_sheet);
    L8:
        if (r103 == null) goto L10;
        BottomSheetBehavior r105 = BottomSheetBehavior.from(r103);
        r103.setBackgroundResource(android.R.color.transparent);
        r105.setState(3);
    L10:
        LarusDialogOptUserVoiceInfoBinding r106 = this.f376547d;
        if (r106 == null) goto L15;
        AppCompatImageView r107 = r106.f376082c;
        if (r107 == null) goto L15;
        e1.d(r107, new n0(this));
    L15:
        LarusDialogOptUserVoiceInfoBinding r108 = this.f376547d;
        if (r108 == null) goto L21;
        String r109 = this.f376556m;
        if (r108 == null) goto L20;
        ImageLoaderKt.y(r108.f376091l, r109, "settings_edit.avatar_default", new p0(r108), 4);
    L20:
        e1.d(r108.f376091l, new s0(this));
        e1.d(r108.f376081b, new t0(this));
    L21:
        LarusDialogOptUserVoiceInfoBinding r110 = this.f376547d;
        if (r110 == null) goto L24;
        e1.d(r110.f376092m, new k0(this));
        e1.d(r110.f376096q, new l0(this));
    L24:
        final Context r111 = getContext();
        if (r111 == null) goto L30;
        final LarusDialogOptUserVoiceInfoBinding r112 = this.f376547d;
        if (r112 == null) goto L30;
        r112.f376093n.setText(this.f376557n);
        e1.d(r112.f376084e, new u0(r111, r112, this));
    L30:
        W90();
        LarusDialogOptUserVoiceInfoBinding r113 = this.f376547d;
        if (r113 == null) goto L33;
        e1.d(r113.f376095p, new i0(this));
        e1.d(r113.f376094o, new j0(this));
    L33:
        LarusDialogOptUserVoiceInfoBinding r114 = this.f376547d;
        if (r114 == null) goto L36;
        e1.d(r114.f376083d, new y0(this));
    L36:
        this.f376549f = registerForActivityResult(new ActivityResultContracts.GetContent(), new v0(this));
        this.f376550g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new w0(this));
        this.f376551h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new x0(this));
        ((ImageUploadViewModel) this.f376548e.getValue()).getUpload().f360128c.observe(getViewLifecycleOwner(), new b(new h0(this)));
        UgcVoiceLoader.f376305x.observe(getViewLifecycleOwner(), new b(new q0(this)));
        UgcVoiceLoader.f376307z.observe(getViewLifecycleOwner(), new b(new r0(this)));
        JSONObject r115 = new JSONObject();
        Intrinsics.checkNotNullParameter(r115, "params");
        TrackParams r116 = new TrackParams().merge(r115);
        by7.a r117 = new by7.a("popup_voice_edit_function_show");
        r117.f21463a.merge(r116);
        r117.b();
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_dialog_opt_user_voice_info, r211, false);
        int r101 = R.id.avatar_add;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.avatar_add);
        if (r102 == null) goto L43;
        r101 = R.id.back;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.back);
        if (r103 == null) goto L43;
        r101 = R.id.complete_button;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.complete_button);
        if (r104 == null) goto L43;
        r101 = R.id.edit_icon;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.edit_icon);
        if (r105 == null) goto L43;
        r101 = R.id.error_icon;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.error_icon);
        if (r106 == null) goto L43;
        r101 = R.id.error_text;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r100, R.id.error_text);
        if (r110 == null) goto L43;
        r101 = R.id.permission_hint;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.permission_hint)) == null) goto L43;
        r101 = R.id.permission_private_hint;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r100, R.id.permission_private_hint);
        if (r111 == null) goto L43;
        r101 = R.id.play_lottie;
        LottieAdapterView r112 = (LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.play_lottie);
        if (r112 == null) goto L43;
        r101 = R.id.private_state;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.private_state);
        if (r113 == null) goto L43;
        r101 = R.id.public_state;
        AppCompatImageView r114 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.public_state);
        if (r114 == null) goto L43;
        r101 = R.id.voice_avatar;
        SimpleDraweeView r115 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.voice_avatar);
        if (r115 == null) goto L43;
        r101 = R.id.voice_edit_area;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_edit_area)) == null) goto L43;
        r101 = R.id.voice_error_bar;
        LinearLayout r116 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_error_bar);
        if (r116 == null) goto L43;
        r101 = R.id.voice_name_area;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.voice_name_area);
        if (r117 == null) goto L43;
        r101 = R.id.voice_permission_private;
        LinearLayout r118 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_permission_private);
        if (r118 == null) goto L43;
        r101 = R.id.voice_permission_public;
        LinearLayout r119 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_permission_public);
        if (r119 == null) goto L43;
        r101 = R.id.voice_play_bar;
        LinearLayout r213 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_play_bar);
        if (r213 == null) goto L43;
        r101 = R.id.voice_progress_bar;
        LinearLayout r214 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_progress_bar);
        if (r214 == null) goto L43;
        NestedScrollView r107 = (NestedScrollView) r100;
        this.f376547d = new LarusDialogOptUserVoiceInfoBinding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r213, r214);
        return r107;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
