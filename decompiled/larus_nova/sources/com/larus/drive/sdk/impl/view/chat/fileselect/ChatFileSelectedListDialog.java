package com.larus.drive.sdk.impl.view.chat.fileselect;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import com.larus.drive.sdk.impl.databinding.LarusDialogChatFileSelectedListBinding;
import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter;
import com.larus.nova.R;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0014\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u000eJ\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\f\u0010#\u001a\u00020$*\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/ChatFileSelectedListDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogChatFileSelectedListBinding;", "hasShownAnim", "", "selectedList", "", "Lcom/larus/platform/api/FlowSelectedFileItem;", "selectedAdapter", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatFileSelectedAdapter;", "selectedListener", "Lcom/larus/platform/api/fileselect/IChatFileSelectedListListener;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "onDestroyView", "setSelectedList", "list", "setSelectedListener", "listener", "startEnterAnimation", "setupView", "toBaseFileSelectConfig", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFileSelectedListDialog extends DialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f342103i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogChatFileSelectedListBinding f342104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f342105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<com.larus.platform.api.u> f342106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ChatFileSelectedAdapter f342107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public aq9.c f342108h;

    public static final class a {
    }

    static {
    }

    public ChatFileSelectedListDialog() {
        this.f342106f = CollectionsKt.emptyList();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f342104d = null;
        this.f342107g = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L18;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L18;
        r101.setLayout(-1, -1);
        r101.setGravity(80);
        r101.clearFlags(2);
        LarusDialogChatFileSelectedListBinding r102 = this.f342104d;
        if (r102 == null) goto L11;
        View r103 = r102.f341710a;
        if (r103 == null) goto L11;
    L16:
        new WindowInsetsControllerCompat(r101, r103).setAppearanceLightStatusBars(false);
    L11:
        r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L16;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L18:
        if (this.f342105e == true) goto L31;
        this.f342105e = true;
        LarusDialogChatFileSelectedListBinding r105 = this.f342104d;
        if (r105 == null) goto L30;
        final View r106 = r105.f341713d;
        if (r106 == null) goto L32;
        final ConstraintLayout r107 = r105.f341714e;
        if (r107 == null) goto L33;
        r106.setAlpha(0.0f);
        r107.post(new k(r107, r106));
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    }

    public final x79.a S90(com.larus.platform.api.u r110) {
        Map<String, String> r100 = r110.f365292m;
        if (r100 == null) goto L5;
        String r101 = r100.get("upload_way");
    L6:
        String r102 = r110.f365280a;
        String r103 = r110.f365281b;
        String r104 = r110.f365283d;
        int r105 = r110.f365284e;
        if (r110.f365285f != FlowDriveFileType.IMAGE) goto L9;
        boolean r106 = true;
    L10:
        if (r101 == null) goto L30;
        int r111 = r101.hashCode();
        if (r111 == (-485349153)) goto L27;
        if (r111 == (-124477692)) goto L23;
        if (r111 != 229020005) goto L30;
        if (r101.equals("browser_folder") == false) goto L30;
        BaseFileSelectFromType r112 = BaseFileSelectFromType.LOCAL;
    L32:
        return new x79.a(r102, r103, r104, r105, r106, r112, 48);
    L23:
        if (r101.equals("input_ai_space") == false) goto L30;
        r112 = BaseFileSelectFromType.DRIVE;
        goto L32
    L27:
        if (r101.equals("recent_sent_file") == false) goto L30;
        r112 = BaseFileSelectFromType.RECENT;
    L30:
        r112 = BaseFileSelectFromType.LOCAL;
        goto L32
    L9:
        r106 = false;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 != null) goto L13;
        setStyle(2, R.style.FullScreenDialogCreationTheme);
        setCancelable(true);
        return;
    L13:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L15;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        final LarusDialogChatFileSelectedListBinding r102 = this.f342104d;
        if (r102 == null) goto L12;
        ViewCompat.setOnApplyWindowInsetsListener(r102.f341710a, new l(r102));
        ViewCompat.requestApplyInsets(r102.f341710a);
        e1.d(r102.f341713d, new m(this));
        e1.d(r102.f341711b, new n(this));
        r102.f341715f.setText(getString(R.string.larus_chat_addFile_tabName_selectedFiles));
        ChatFileSelectedAdapter r103 = new ChatFileSelectedAdapter(new o(this));
        List<com.larus.platform.api.u> r104 = this.f342106f;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r105.add(S90((com.larus.platform.api.u) r106.next()));
        goto L7
    L9:
        r103.submitList(r105);
        this.f342107g = r103;
        RecyclerView r107 = r102.f341712c;
        r107.setLayoutManager(new LinearLayoutManager(r107.getContext(), 1, false));
        r107.setAdapter(this.f342107g);
        r107.setItemAnimator(null);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialog_chat_file_selected_list, r111, false);
        int r114 = R.id.chat_selected_back;
        AppCompatImageView r100 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.chat_selected_back);
        if (r100 == null) goto L25;
        r114 = R.id.chat_selected_list;
        RecyclerView r101 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.chat_selected_list);
        if (r101 == null) goto L25;
        r114 = R.id.chat_selected_overlay_bg;
        View r102 = ViewBindings.findChildViewById(r113, R.id.chat_selected_overlay_bg);
        if (r102 == null) goto L25;
        r114 = R.id.chat_selected_panel;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.chat_selected_panel);
        if (r103 == null) goto L25;
        r114 = R.id.chat_selected_title;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.chat_selected_title);
        if (r104 == null) goto L25;
        r114 = R.id.chat_selected_title_bar;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.chat_selected_title_bar);
        if (r105 == null) goto L25;
        this.f342104d = new LarusDialogChatFileSelectedListBinding((ConstraintLayout) r113, r100, r101, r102, r103, r104, r105);
        Dialog r115 = getDialog();
        if (r115 == null) goto L19;
        Window r116 = r115.getWindow();
        if (r116 == null) goto L19;
        r116.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r116, false);
    L19:
        LarusDialogChatFileSelectedListBinding r117 = this.f342104d;
        if (r117 != null) goto L26;
        return null;
    L26:
        return r117.f341710a;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
