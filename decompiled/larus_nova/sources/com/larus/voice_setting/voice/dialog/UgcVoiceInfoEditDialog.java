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
import android.widget.FrameLayout;
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
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusDialogEditUserVoiceInfoBinding;
import com.larus.voice_setting.voice.ImageUploadViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0002J\b\u0010@\u001a\u000209H\u0002J\b\u0010A\u001a\u000209H\u0002J\b\u0010B\u001a\u000209H\u0002J\b\u0010C\u001a\u000209H\u0002J\u0012\u0010D\u001a\u0002092\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\b\u0010G\u001a\u000209H\u0002J\b\u0010H\u001a\u000209H\u0002J\u0010\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u0013H\u0002J\u0012\u0010K\u001a\u0002092\b\u0010L\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010M\u001a\u0002092\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001c\u0010+\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u000e\u0010.\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/UgcVoiceInfoEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogEditUserVoiceInfoBinding;", "uploadViewModel", "Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "cropLauncher", "needModifyInfo", "", "currentAvatarUrl", "getCurrentAvatarUrl", "()Ljava/lang/String;", "setCurrentAvatarUrl", "(Ljava/lang/String;)V", "currentAvatarUri", "getCurrentAvatarUri", "setCurrentAvatarUri", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "voiceName", "getVoiceName", "setVoiceName", "isPublic", "()Z", "setPublic", "(Z)V", "enterFrom", "getEnterFrom", "setEnterFrom", "voiceId", "getVoiceId", "setVoiceId", "isDefaultAvatar", "isDefaultName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "initTitleBar", "initAvatar", "openPhoto", "showImagePreviewDialog", "initName", "initPermission", "updatePermissionStatus", "initCompleteButton", "handlePhotoPickerResult", "uri", "Landroid/net/Uri;", "initResultLauncher", "initViewModel", "changeCompleteButtonStatus", "enable", "setAvatarUrl", "url", "uploadAvatarFail", "message", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceInfoEditDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f376530r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogEditUserVoiceInfoBinding f376531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f376532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActivityResultLauncher<String> f376533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f376534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f376535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f376536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f376537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f376538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f376539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f376540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f376541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f376542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f376543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f376544q;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f376545a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f376545a = r100;
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
            return this.f376545a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f376545a.invoke(r100);
        }
    }

    static {
    }

    public final void W90() {
        LarusDialogEditUserVoiceInfoBinding r100 = this.f376531d;
        if (r100 == null) goto L25;
        AppCompatImageView r101 = r100.f376075i;
        int r102 = 0;
        if (this.f376541n == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        AppCompatImageView r104 = r100.f376074h;
        if ((!this.f376541n) == false) goto L11;
        int r105 = 0;
    L12:
        r104.setVisibility(r105);
        Context r106 = getContext();
        if (r106 == null) goto L19;
        TextView r107 = r100.f376071e;
        if (this.f376541n == false) goto L17;
        String r108 = r106.getString(R.string.larus_ugc_voice_release);
    L18:
        r107.setText(r108);
        goto L19
    L17:
        r108 = r106.getString(R.string.larus_create_bot_done);
    L19:
        TextView r109 = r100.f376073g;
        if (this.f376541n == true) goto L23;
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

    public UgcVoiceInfoEditDialog() {
        final Function0<Fragment> r100 = new UgcVoiceInfoEditDialog$special$$inlined$viewModels$default$1(this);
        this.f376532e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ImageUploadViewModel.class), new UgcVoiceInfoEditDialog$special$$inlined$viewModels$default$2(r100), new UgcVoiceInfoEditDialog$special$$inlined$viewModels$default$3(r100, this));
        this.f376537j = "";
        this.f376538k = "";
        this.f376539l = LazyKt.lazy(new y(this));
        this.f376540m = "";
        this.f376542o = "";
        this.f376543p = true;
        this.f376544q = true;
    }

    public static void S90(UgcVoiceInfoEditDialog r100) {
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
        LarusDialogEditUserVoiceInfoBinding r101 = this.f376531d;
        if (r101 == null) goto L10;
        r101.f376071e.setClickable(r100);
        TextView r102 = r101.f376071e;
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
        ActivityResultLauncher<Intent> r104 = this.f376535h;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
        r104 = null;
    L6:
        r102.setClass(requireActivity(), UCropActivity.class);
        r102.putExtras(r103);
        r104.launch(r102);
        return;
    }

    public final void X90(String r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        com.larus.common_ui.dialog.l0 r102 = (com.larus.common_ui.dialog.l0) this.f376539l.getValue();
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
        LarusDialogEditUserVoiceInfoBinding r106 = this.f376531d;
        if (r106 == null) goto L15;
        AppCompatImageView r107 = r106.f376070d;
        if (r107 == null) goto L15;
        e1.d(r107, new x(this));
    L15:
        LarusDialogEditUserVoiceInfoBinding r108 = this.f376531d;
        if (r108 == null) goto L21;
        String r109 = this.f376537j;
        if (r108 == null) goto L20;
        ImageLoaderKt.y(r108.f376076j, r109, "settings_edit.avatar_default", new v(r108), 4);
    L20:
        e1.d(r108.f376076j, new a0(this));
        e1.d(r108.f376068b, new b0(this));
    L21:
        final Context r110 = getContext();
        if (r110 == null) goto L27;
        final LarusDialogEditUserVoiceInfoBinding r111 = this.f376531d;
        if (r111 == null) goto L27;
        r111.f376077k.setText(this.f376540m);
        e1.d(r111.f376072f, new r(r110, r111, this));
    L27:
        W90();
        LarusDialogEditUserVoiceInfoBinding r112 = this.f376531d;
        if (r112 == null) goto L30;
        e1.d(r112.f376079m, new f0(this));
        e1.d(r112.f376078l, new s(this));
    L30:
        LarusDialogEditUserVoiceInfoBinding r113 = this.f376531d;
        if (r113 == null) goto L33;
        e1.d(r113.f376071e, new z(this));
    L33:
        this.f376533f = registerForActivityResult(new ActivityResultContracts.GetContent(), new c0(this));
        this.f376534g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d0(this));
        this.f376535h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e0(this));
        ((ImageUploadViewModel) this.f376532e.getValue()).getUpload().f360128c.observe(getViewLifecycleOwner(), new b(new t(this)));
        UgcVoiceLoader.B.observe(getViewLifecycleOwner(), new b(new u(this)));
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_dialog_edit_user_voice_info, r111, false);
        int r101 = R.id.avatar_add;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.avatar_add);
        if (r102 == null) goto L33;
        r101 = R.id.avatar_area;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.avatar_area);
        if (r103 == null) goto L33;
        r101 = R.id.close;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.close);
        if (r104 == null) goto L33;
        r101 = R.id.complete_button;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.complete_button);
        if (r105 == null) goto L33;
        r101 = R.id.edit_icon;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.edit_icon);
        if (r106 == null) goto L33;
        r101 = R.id.permission_hint;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.permission_hint)) == null) goto L33;
        r101 = R.id.permission_private_hint;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r100, R.id.permission_private_hint);
        if (r112 == null) goto L33;
        r101 = R.id.private_state;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.private_state);
        if (r113 == null) goto L33;
        r101 = R.id.public_state;
        AppCompatImageView r114 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.public_state);
        if (r114 == null) goto L33;
        r101 = R.id.voice_avatar;
        SimpleDraweeView r115 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.voice_avatar);
        if (r115 == null) goto L33;
        r101 = R.id.voice_edit_area;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_edit_area)) == null) goto L33;
        r101 = R.id.voice_name_area;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.voice_name_area);
        if (r116 == null) goto L33;
        r101 = R.id.voice_permission_private;
        LinearLayout r117 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_permission_private);
        if (r117 == null) goto L33;
        r101 = R.id.voice_permission_public;
        LinearLayout r118 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.voice_permission_public);
        if (r118 == null) goto L33;
        NestedScrollView r107 = (NestedScrollView) r100;
        this.f376531d = new LarusDialogEditUserVoiceInfoBinding(r107, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r117, r118);
        return r107;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
