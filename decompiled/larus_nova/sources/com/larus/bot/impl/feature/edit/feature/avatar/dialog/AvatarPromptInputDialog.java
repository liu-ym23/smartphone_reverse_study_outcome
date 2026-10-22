package com.larus.bot.impl.feature.edit.feature.avatar.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusDialogAvatarPromptInputBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.AvatarChooserFragment;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 02\u00020\u0001:\u00010B<\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012'\b\u0002\u0010\u0004\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\nH\u0016J?\u0010(\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\nH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0004\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarPromptInputDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "avatarPrompt", "", "avatarChooserListener", "Lkotlin/Function1;", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Lkotlin/ParameterName;", "name", "selectedAvatar", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogAvatarPromptInputBinding;", "avatarChooserFragment", "Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/AvatarChooserFragment;", "currentPrompt", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "isGenBg", "", "creationId", "createWay", "needUpdateBotInfo", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "setUp", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;)V", "setupView", "bindObservers", "disableSendAction", "enableSendAction", "showBgImageChooseDialog", "showAvatarChooserFragment", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarPromptInputDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f318545o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f318546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<BotAvatarIconData, Unit> f318547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDialogAvatarPromptInputBinding f318548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AvatarChooserFragment f318549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f318550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x1 f318551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f318552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f318553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f318554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f318555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BotModel f318556n;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarPromptInputDialog f318557a;

        public b(AvatarPromptInputDialog r100) {
            this.f318557a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L13;
            FLogger.f375446a.i("AvatarPromptInputDialog", "dismiss when key back");
            this.f318557a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return true;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L17;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return true;
        L17:
            return true;
        L13:
            return false;
        }
    }

    static {
    }

    public AvatarPromptInputDialog() {
        this(null, null);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LarusDialogAvatarPromptInputBinding r100 = this.f318548f;
        if (r100 == null) goto L8;
        r100.f317734c.requestFocus();
        x1 r101 = this.f318551i;
        if (r101 == null) goto L9;
        x1.d(r101, 3);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarPromptInputDialog(String r100, Function1<? super BotAvatarIconData, Unit> r101) {
        this.f318546d = r100;
        this.f318547e = r101;
        this.f318550h = "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        String r102 = this.f318546d;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.f318550h = r102;
        Dialog r103 = getDialog();
        if (r103 == null) goto L8;
        r103.setOnKeyListener(new b(this));
    L8:
        Dialog r104 = getDialog();
        if (r104 == null) goto L11;
        r104.setOnCancelListener(new i());
    L11:
        LarusDialogAvatarPromptInputBinding r105 = this.f318548f;
        if (r105 == null) goto L16;
        FrameLayout r106 = r105.f317732a;
        if (r106 == null) goto L16;
        ViewExtKt.n(r106, null, null, new j(this), 3);
    L16:
        LarusDialogAvatarPromptInputBinding r107 = this.f318548f;
        if (r107 == null) goto L36;
        String r108 = this.f318546d;
        r107.f317734c.setText(r108);
        e1.d(r107.f317733b, new k(this));
        Editable r109 = r107.f317734c.getText();
        if (r109 != null) goto L21;
    L24:
        boolean r110 = true;
    L25:
        if (r110 == false) goto L29;
        LarusDialogAvatarPromptInputBinding r111 = this.f318548f;
        if (r111 == null) goto L29;
        r111.f317733b.setEnabled(false);
        r111.f317733b.setAlpha(0.3f);
    L29:
        r107.f317734c.requestFocus();
        Dialog r112 = getDialog();
        if (r112 == null) goto L34;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L34;
        r113.setSoftInputMode(5);
    L34:
        r107.f317734c.addTextChangedListener(new m(this, r107));
        goto L36
    L21:
        if (r109.length() == 0) goto L24;
        r110 = false;
    L36:
        if (this.f318552j == false) goto L39;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AvatarPromptInputDialog$bindObservers$1(this, null), 3, null);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_avatar_prompt_input, r101, false);
        int r104 = R.id.action_send;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r103, R.id.action_send);
        if (r105 == null) goto L14;
        r104 = R.id.prompt_input_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.prompt_input_container)) == null) goto L14;
        r104 = R.id.prompt_input_text;
        AppCompatEditText r106 = (AppCompatEditText) ViewBindings.findChildViewById(r103, R.id.prompt_input_text);
        if (r106 == null) goto L14;
        this.f318548f = new LarusDialogAvatarPromptInputBinding((FrameLayout) r103, r105, r106);
        this.f318551i = new x1(r106);
        LarusDialogAvatarPromptInputBinding r107 = this.f318548f;
        if (r107 != null) goto L15;
        return null;
    L15:
        return r107.f317732a;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public static void S90(AvatarPromptInputDialog r100, boolean r101, String r102, String r103) {
        r100.f318552j = r101;
        r100.f318553k = r102;
        r100.f318554l = r103;
        r100.f318555m = false;
        r100.f318556n = null;
    }
}
