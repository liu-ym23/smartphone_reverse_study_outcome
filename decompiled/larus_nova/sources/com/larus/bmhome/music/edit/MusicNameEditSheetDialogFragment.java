package com.larus.bmhome.music.edit;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.music.databinding.LarusDialogFragmentMusicNameEditBinding;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.nova.R;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.platform.service.e0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 82\u00020\u0001:\u00018Bv\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016¢\u0006\u0004\b\u0013\u0010\u0015J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0002J\b\u00100\u001a\u00020\u0012H\u0002J?\u00101\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052%\b\u0002\u00102\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0002J=\u00103\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00052%\b\u0002\u00102\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0082@¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/larus/bmhome/music/edit/MusicNameEditSheetDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "messageId", "", "creationId", "originMusicName", "currentPage", "isMusicAppletScene", "", "musicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "editMusicName", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newTitle", "", "<init>", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/bmhome/music/mob/MusicAppletMobContext;Lkotlin/jvm/functions/Function1;)V", "()V", "binding", "Lcom/larus/bmhome/music/databinding/LarusDialogFragmentMusicNameEditBinding;", "isClickConfirm", "onDismissListener", "getOnDismissListener", "()Lkotlin/jvm/functions/Function1;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "onResume", "onPause", "onDestroyView", "initDialog", "initView", "editName", "editNameCallback", "editCreationName", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toastError", "errorString", "releaseImeFocus", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicNameEditSheetDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f312800o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MusicCreationContent f312801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f312802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f312803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f312804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f312805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f312806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kr8.o f312807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<String, Unit> f312808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LarusDialogFragmentMusicNameEditBinding f312809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f312810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f312811n;

    public static final class a {
    }

    static {
    }

    public MusicNameEditSheetDialogFragment() {
        this(new MusicCreationContent(), "", "", "", "", false, null, new y());
        T90(this);     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.f375446a.e("MusicNameEditSheetDialogFragment", "fallback by dismiss failed");
    }

    public final void V90() {
        if (this.f312806i == true) goto L5;
        return;
    L5:
        LarusDialogFragmentMusicNameEditBinding r100 = this.f312809l;
        if (r100 != null) goto L8;
        return;
    L8:
        InputMethodManager r101 = null;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L11:
        EditText r102 = r100.f312729e;
        IBinder r103 = r102.getWindowToken();
        if (r103 != null) goto L30;
        Dialog r104 = getDialog();
        if (r104 == null) goto L20;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L20;
        View r106 = S90(r105);
        if (r106 == null) goto L20;
        r103 = r106.getWindowToken();
    L21:
        if (r103 != null) goto L30;
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L29;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L29;
        View r109 = S90(r108);
        if (r109 == null) goto L29;
        r103 = r109.getWindowToken();
    L29:
        r103 = null;
    L20:
        r103 = null;
    L30:
        Context r110 = getContext();
        if (r110 == null) goto L33;
        Object r111 = r110.getSystemService("input_method");
    L35:
        if ((r111 instanceof InputMethodManager) == false) goto L37;
        r101 = (InputMethodManager) r111;
    L37:
        if (r103 == null) goto L40;
        if (r101 == null) goto L40;
        r101.hideSoftInputFromWindow(r103, 0);
    L40:
        r102.clearFocus();
        Dialog r112 = getDialog();
        if (r112 == null) goto L48;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L49;
        View r114 = S90(r113);
        if (r114 == null) goto L50;
        r114.clearFocus();
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L33:
        r111 = null;
        goto L35
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        V90();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        V90();
        super.onPause();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.setSoftInputMode(2);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L10;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L10;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r102.width = r104;
        if (r104 <= i5.L()) goto L9;
        r102.width = i5.L();
    L9:
        r101.setAttributes(r102);
    L10:
        LarusDialogFragmentMusicNameEditBinding r105 = this.f312809l;
        LarusDialogFragmentMusicNameEditBinding r106 = null;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L13:
        r105.f312729e.postDelayed(new w(this), 100);
        LarusDialogFragmentMusicNameEditBinding r107 = this.f312809l;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L16:
        r107.f312729e.postDelayed(new x(this), 100);
        LarusDialogFragmentMusicNameEditBinding r108 = this.f312809l;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        r106.f312729e.requestFocus();
        return;
    L19:
        r106 = r108;
        goto L20
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void T90(MusicNameEditSheetDialogFragment r100) {
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        V90();
        super.onCancel(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        V90();     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        Function1<? super Boolean, Unit> r101 = this.f312811n;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.invoke(Boolean.valueOf(this.f312810m));     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        View r103 = r102.findViewById(R.id.design_bottom_sheet);
    L6:
        if (r103 == null) goto L8;
        r103.setBackgroundResource(android.R.color.transparent);
    L8:
        LarusDialogFragmentMusicNameEditBinding r104 = this.f312809l;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        r104.f312729e.setText(this.f312804g);
        LarusDialogFragmentMusicNameEditBinding r105 = this.f312809l;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L14:
        e1.d(r105.f312726b, new z(this));
        LarusDialogFragmentMusicNameEditBinding r106 = this.f312809l;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L17:
        e1.d(r106.f312727c, new a0(this));
        LarusDialogFragmentMusicNameEditBinding r107 = this.f312809l;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L20:
        r107.f312729e.addTextChangedListener(new b0(this));
        String r108 = this.f312805h;
        String r109 = this.f312801d.getVid();
        String r110 = this.f312805h;
        if (Intrinsics.areEqual(r110, "chat") == false) goto L24;
        String r111 = "click_music_card";
    L27:
        kr8.b r112 = new kr8.b(r108, r109, r111, 1);
        if (this.f312806i == false) goto L30;
        kr8.n r113 = kr8.n.f505865a;
        kr8.o r114 = this.f312807j;
        String r115 = this.f312805h;
        String r116 = this.f312804g;
        Intrinsics.checkNotNullParameter(r115, "currentPage");
        JSONObject r117 = kr8.n.c(r114, r115, true);
        kr8.n.f(r117, "old_title", r116);
        kr8.n.f(r117, "new_title", null);
        kr8.l.a.b(r112, r117, 1);
        return;
    L30:
        kr8.l.a.b(r112, null, 3);
        return;
    L24:
        if (Intrinsics.areEqual(r110, "music_detail") == false) goto L26;
        r111 = "click_music_detail";
        goto L27
    L26:
        r111 = "";
        goto L27
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dialog_fragment_music_name_edit, r101, false);
        int r103 = R.id.cancel;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.cancel);
        if (r104 == null) goto L23;
        r103 = R.id.confirm;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.confirm);
        if (r105 == null) goto L23;
        r103 = R.id.dialog_title;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.dialog_title)) == null) goto L23;
        r103 = R.id.divider;
        View r106 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r106 == null) goto L23;
        r103 = R.id.music_name_edit_text;
        EditText r107 = (EditText) ViewBindings.findChildViewById(r102, R.id.music_name_edit_text);
        if (r107 == null) goto L23;
        this.f312809l = new LarusDialogFragmentMusicNameEditBinding((LinearLayout) r102, r104, r105, r106, r107);
        Dialog r108 = getDialog();
        if (r108 == null) goto L17;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L17;
        r109.setBackgroundDrawable(new ColorDrawable(0));
    L17:
        LarusDialogFragmentMusicNameEditBinding r111 = this.f312809l;
        if (r111 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L21:
        return r111.f312725a;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public static final Object U90(MusicNameEditSheetDialogFragment r100, String r101, Function1 r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof MusicNameEditSheetDialogFragment$editCreationName$1) == false) goto L7;
        MusicNameEditSheetDialogFragment$editCreationName$1 r104 = (MusicNameEditSheetDialogFragment$editCreationName$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = (Function1) r104.L$1;
        r101 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L20:
        Pair r109 = (Pair) r106;
        if (r109 == null) goto L23;
        ModifiedUserCreationResponse r110 = (ModifiedUserCreationResponse) r109.getFirst();
    L24:
        if (r110 == null) goto L26;
        T90(r100);
        r102.invoke(r101);
    L35:
        return Unit.INSTANCE;
    L26:
        int r111 = p0.f375454a;
        if (r109 == null) goto L29;
        String r112 = (String) r109.getSecond();
    L30:
        String r113 = p0.a(r112);
        if (r113 != null) goto L33;
        r113 = AppHost.f326268a.getApplication().getString(R.string.larus_music_generate_title_edit_toast);
    L33:
        t19.s r114 = t19.s.f544207a;
        Application r115 = AppHost.f326268a.getApplication();
        r114.getClass();
        t19.s.c(r115, r113);
        T90(r100);
        r102.invoke(null);
        goto L35
    L29:
        r112 = null;
        goto L30
    L23:
        r110 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        e0 r116 = e0.f365731a;
        String r117 = r100.f312803f;
        if (r117 != null) goto L17;
        r117 = "";
    L17:
        r104.L$0 = r101;
        r104.L$1 = r102;
        r104.label = 1;
        r106 = r116.k(r117, r101, null, r104);
        if (r106 != r107) goto L20;
        return r107;
    L7:
        r104 = new MusicNameEditSheetDialogFragment$editCreationName$1(r100, r103);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MusicNameEditSheetDialogFragment(MusicCreationContent r100, String r101, String r102, String r103, String r104, boolean r105, kr8.o r106, Function1<? super String, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "musicContent");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r103, "originMusicName");
        Intrinsics.checkNotNullParameter(r104, "currentPage");
        Intrinsics.checkNotNullParameter(r107, "editMusicName");
        this.f312801d = r100;
        this.f312802e = r101;
        this.f312803f = r102;
        this.f312804g = r103;
        this.f312805h = r104;
        this.f312806i = r105;
        this.f312807j = r106;
        this.f312808k = r107;
    }
}
