package com.larus.project.create;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import be8.d;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.bmhome.taskskill.service.IPcDevicePanelService;
import com.larus.bmhome.taskskill.service.j;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.flowskill.impl.databinding.LarusFlowskillFragmentCreateProjectPanelBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.v0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ls9.e;
import ls9.f;
import ls9.g;
import ls9.h;
import ls9.i;
import org.json.JSONObject;
import tx9.p3;
import v19.i5;
import v19.s5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\rH\u0002J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u001eH\u0002J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006A"}, d2 = {"Lcom/larus/project/create/CreateProjectPanelFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFlowskillFragmentCreateProjectPanelBinding;", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "selectedDevice", "Lcom/larus/bmhome/chat/component/skill/TaskDeviceInfo;", "selectedFolderName", "", "selectedFolderPath", "shouldReportAddFolderResult", "", "isWaitingForFolderResult", "hasSubmitted", "isUserCanceled", "contentBottomPadding", "fragmentResultKey", "getFragmentResultKey$impl_mainlandRelease", "()Ljava/lang/String;", "autoLaunchDevicePicker", "getAutoLaunchDevicePicker", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onDestroyView", "updateCreateEnabled", "openDevicePicker", "openFolderPicker", "device", "reportAddProjectFolderResult", "addResult", "renderFolderRow", "softInputAdjustMode", "setupImeInsets", RootDescription.ROOT_ELEMENT, "updateImeBottomPadding", "insets", "Landroidx/core/view/WindowInsetsCompat;", "showProjectNameKeyboard", "hideProjectNameKeyboard", LocationMonitorConst.SUBMIT, "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateProjectPanelFragment extends RoundedBottomSheetDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f367005m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFlowskillFragmentCreateProjectPanelBinding f367006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f367007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f367008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f367009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f367010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f367011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f367012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f367013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f367014l;

    public static final class a {
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreateProjectPanelFragment f367015a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(CreateProjectPanelFragment r100) {
            this.f367015a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            CreateProjectPanelFragment r101 = this.f367015a;
            int r102 = CreateProjectPanelFragment.f367005m;
            r101.ba0();
        }
    }

    public static final class c implements IPcDevicePanelService.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreateProjectPanelFragment f367016a;

        @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.a
        public final void a() {
            CreateProjectPanelFragment r100 = this.f367016a;
            if (r100.f367011i == true) goto L6;
            r100.aa0("cancel");
            return;
        }

        @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.a
        public final void c() {
            CreateProjectPanelFragment r100 = this.f367016a;
            r100.f367007e = null;
            r100.f367008f = null;
            r100.f367009g = null;
            r100.Z90();
            this.f367016a.aa0("cancel");
        }

        public c(CreateProjectPanelFragment r100) {
            this.f367016a = r100;
        }

        @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.a
        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            FLogger r101 = FLogger.f375446a;
            r101.i("CreateProjectPanel", "onPcDeviceSelected id=" + r100.f18767a);
            CreateProjectPanelFragment r102 = this.f367016a;
            r102.f367007e = r100;
            r102.f367008f = null;
            r102.f367009g = null;
            r102.Z90();
            CreateProjectPanelFragment r103 = this.f367016a;
            boolean r104 = true;
            r103.f367011i = true;
            if (r103.isAdded() == true) goto L5;
            return;
        L5:
            if (r103.getChildFragmentManager().isStateSaved() == true) goto L24;
            String r105 = r100.f18767a;
            if (r105 == null) goto L14;
            if (r105.length() == 0) goto L14;
            r104 = false;
        L14:
            if (r104 == false) goto L16;
            r101.w("CreateProjectPanel", "openFolderPicker: empty deviceId");
            r103.aa0("fail");
            return;
        L16:
            IPcDevicePanelService r106 = (IPcDevicePanelService) ServiceManager.get().getService(IPcDevicePanelService.class);
            if (r106 != null) goto L19;
            r101.w("CreateProjectPanel", "openFolderPicker: IPcDevicePanelService not found");
            r103.aa0("fail");
            return;
        L19:
            r106.b(r103, r105, new IPcDevicePanelService.c(false), new i(r103));
            return;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int S90() {
        return R.drawable.larus_flowskill_bg_create_project_panel;
    }

    public final void Z90() {
        LarusFlowskillFragmentCreateProjectPanelBinding r100 = this.f367006d;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        if (this.f367008f != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        LinearLayout r103 = r100.f343502f;
        if (r102 == true) goto L15;
        r101 = 8;
    L15:
        r103.setVisibility(r101);
        TextView r104 = r100.f343504h;
        String r105 = this.f367008f;
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r104.setText(r105);
        return;
    L8:
        if (this.f367009g == null) goto L10;
        r102 = true;
        goto L11
    }

    public final void ba0() {
        LarusFlowskillFragmentCreateProjectPanelBinding r100 = this.f367006d;
        if (r100 != null) goto L5;
        return;
    L5:
        Editable r101 = r100.f343499c.getText();
        if (r101 == null) goto L10;
        String r102 = r101.toString();
        if (r102 == null) goto L10;
        String r103 = StringsKt.trim(r102).toString();
    L12:
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        boolean r105 = !r104;
        r100.f343503g.setEnabled(r105);
        TextView r106 = r100.f343503g;
        if (r105 == false) goto L21;
        float r107 = 1.0f;
    L22:
        r106.setAlpha(r107);
        return;
    L21:
        r107 = 0.3f;
        goto L22
    L14:
        if (r103.length() == 0) goto L17;
        r104 = false;
    L10:
        r103 = null;
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LarusFlowskillFragmentCreateProjectPanelBinding r100 = this.f367006d;
        if (r100 == null) goto L7;
        LinearLayout r101 = r100.f343497a;
        if (r101 == null) goto L7;
        ViewCompat.setOnApplyWindowInsetsListener(r101, null);
        ViewCompat.setWindowInsetsAnimationCallback(r101, null);
    L7:
        this.f367006d = null;
        super.onDestroyView();
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int U90() {
        return i5.E();
    }

    public final String X90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L12;
        String r101 = r100.getString("result_key");
        if (r101 == null) goto L12;
        if ((!StringsKt.isBlank(r101)) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return "project_create_panel_service_result";
    }

    public final void Y90() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (getChildFragmentManager().isStateSaved() == true) goto L32;
        LarusFlowskillFragmentCreateProjectPanelBinding r100 = this.f367006d;
        String r101 = null;
        if (r100 == null) goto L22;
        EditText r102 = r100.f343499c;
        if (r102 == null) goto L22;
        Context r103 = getContext();
        if (r103 == null) goto L15;
        Object r104 = r103.getSystemService("input_method");
    L17:
        if ((r104 instanceof InputMethodManager) == false) goto L19;
        InputMethodManager r105 = (InputMethodManager) r104;
    L20:
        if (r105 == null) goto L22;
        r105.hideSoftInputFromWindow(r102.getWindowToken(), 0);
        goto L22
    L19:
        r105 = null;
        goto L20
    L15:
        r104 = null;
    L22:
        IPcDevicePanelService r106 = (IPcDevicePanelService) ServiceManager.get().getService(IPcDevicePanelService.class);
        if (r106 != null) goto L26;
        FLogger.f375446a.w("CreateProjectPanel", "openDevicePicker: IPcDevicePanelService not found");
        aa0("fail");
        return;
    L26:
        d r107 = this.f367007e;
        if (r107 == null) goto L29;
        r101 = r107.f18767a;
    L29:
        r106.a(this, r101, new IPcDevicePanelService.d(Integer.valueOf(R.string.larus_groupChats_navBar_projects_newProject_popupTitle_selectDevice), Integer.valueOf(R.drawable.larus_ic_back_dialog), 28, false), new c(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        boolean r100 = s5.f552609a;
        s5.f552609a = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        boolean r100 = s5.f552609a;
        s5.f552609a = true;
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L20;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L9;
        int r102 = 48;
    L10:
        Bundle r103 = getArguments();
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        int r105 = 3;
    L19:
        r101.setSoftInputMode(r102 | r105);
        goto L20
    L18:
        r105 = 5;
        goto L19
    L13:
        if (r103.getBoolean("auto_launch_device_picker") != true) goto L15;
        r104 = true;
        goto L16
    L9:
        r102 = 16;
    L20:
        Dialog r106 = getDialog();
        if ((r106 instanceof BottomSheetDialog) == false) goto L23;
        BottomSheetDialog r107 = (BottomSheetDialog) r106;
    L24:
        if (r107 == null) goto L33;
        View r108 = r107.findViewById(R.id.design_bottom_sheet);
        if (r108 == null) goto L34;
        BottomSheetBehavior r109 = BottomSheetBehavior.from(r108);
        r109.setSkipCollapsed(true);
        r109.setState(3);
        LarusFlowskillFragmentCreateProjectPanelBinding r110 = this.f367006d;
        if (r110 == null) goto L35;
        LinearLayout r111 = r110.f343497a;
        if (r111 == null) goto L36;
        ViewCompat.requestApplyInsets(r111);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L23:
        r107 = null;
        goto L24
    }

    public CreateProjectPanelFragment() {
    }

    public final void W90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (this.f367013k == true) goto L5;
    L14:
        super.onDismiss(r100);
        return;
    L5:
        if (this.f367012j == true) goto L14;
        FragmentManager r101 = getParentFragmentManager();
        String r102 = X90();
        Bundle r103 = new Bundle();
        r103.putBoolean("is_cancel", true);
        String r104 = this.f367009g;
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        r103.putBoolean("is_bind_folder", !r105);
        Unit r106 = Unit.INSTANCE;
        r101.setFragmentResult(r102, r103);
        goto L14
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
        goto L13
    }

    public final void aa0(String r100) {
        if (this.f367010h == true) goto L5;
        return;
    L5:
        this.f367010h = false;
        this.f367011i = false;
        Intrinsics.checkNotNullParameter(r100, "addResult");
        JSONObject r101 = new JSONObject();
        r101.put("current_page", "chat");
        r101.put("platform", "app");
        r101.put("add_result", r100);
        p3.a("add_project_folder", r101, null);
    }

    public final void ca0(WindowInsetsCompat r100) {
        LarusFlowskillFragmentCreateProjectPanelBinding r101 = this.f367006d;
        if (r101 == null) goto L12;
        LinearLayout r102 = r101.f343497a;
        if (r102 == null) goto L13;
        int r103 = r100.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        int r104 = r100.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r105 = this.f367014l + RangesKt.coerceAtLeast(r103 - r104, 0);
        if (r102.getPaddingBottom() != r105) goto L10;
        return;
    L10:
        r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r102.getPaddingRight(), r105);
        return;
    L13:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f367013k = true;
        super.onCancel(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        W90(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        final LarusFlowskillFragmentCreateProjectPanelBinding r102 = this.f367006d;
        if (r102 != null) goto L5;
        return;
    L5:
        this.f367014l = r102.f343497a.getPaddingBottom();
        LinearLayout r103 = r102.f343497a;
        if (Build.VERSION.SDK_INT < 30) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(r103, new h(this));
        ViewCompat.setWindowInsetsAnimationCallback(r103, new CreateProjectPanelFragment$setupImeInsets$2(this));
    L9:
        boolean r104 = true;
        r102.f343499c.setFilters(new j[]{new j()});
        r102.f343499c.requestFocus();
        AppCompatImageView r105 = r102.f343500d;
        if (z2.f365865a.b4().f473645d == false) goto L12;
        int r106 = 0;
    L13:
        r105.setVisibility(r106);
        int r107 = v0.f375471a;
        v0.a(r102.f343500d, 28, 0, 0, 0);
        e1.d(r102.f343501e, new ls9.a(this));
        e1.d(r102.f343500d, new ls9.b(this));
        r102.f343499c.addTextChangedListener(new b(this));
        e1.d(r102.f343498b, new ls9.c(this));
        e1.d(r102.f343503g, new ls9.d(this));
        r102.f343499c.setOnEditorActionListener(new e(r102));
        Z90();
        ba0();
        if (r101 != null) goto L23;
        Bundle r108 = getArguments();
        if (r108 != null) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == false) goto L23;
    L24:
        if (r104 == false) goto L26;
        r100.post(new f(this));
        return;
    L26:
        r102.f343499c.post(new g(this));
        return;
    L18:
        if (r108.getBoolean("auto_launch_device_picker") != true) goto L20;
        r109 = true;
    L23:
        r104 = false;
        goto L24
    L12:
        r106 = 8;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_flowskill_fragment_create_project_panel, r111, false);
        int r114 = R.id.cl_folder_row;
        ConstraintLayout r100 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.cl_folder_row);
        if (r100 == null) goto L33;
        r114 = R.id.cl_header;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.cl_header)) == null) goto L33;
        r114 = R.id.cl_name_input;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.cl_name_input)) == null) goto L33;
        r114 = R.id.et_project_name;
        EditText r101 = (EditText) ViewBindings.findChildViewById(r113, R.id.et_project_name);
        if (r101 == null) goto L33;
        r114 = R.id.iv_add_folder;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_add_folder);
        if (r102 == null) goto L33;
        r114 = R.id.iv_close;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_close);
        if (r103 == null) goto L33;
        r114 = R.id.iv_folder_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_folder_arrow)) == null) goto L33;
        r114 = R.id.iv_folder_leading;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_folder_leading)) == null) goto L33;
        r114 = R.id.iv_name_leading;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_name_leading)) == null) goto L33;
        r114 = R.id.ll_local_resource;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.ll_local_resource);
        if (r104 == null) goto L33;
        r114 = R.id.tv_create_action;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.tv_create_action);
        if (r105 == null) goto L33;
        r114 = R.id.tv_folder_name;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.tv_folder_name);
        if (r106 == null) goto L33;
        r114 = R.id.tv_local_resource_label;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.tv_local_resource_label)) == null) goto L33;
        r114 = R.id.tv_panel_title;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.tv_panel_title)) == null) goto L33;
        LinearLayout r115 = (LinearLayout) r113;
        this.f367006d = new LarusFlowskillFragmentCreateProjectPanelBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        return r115;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
