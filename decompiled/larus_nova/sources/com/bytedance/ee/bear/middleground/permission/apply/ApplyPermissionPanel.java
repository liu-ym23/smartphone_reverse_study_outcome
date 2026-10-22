package com.bytedance.ee.bear.middleground.permission.apply;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPanel;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "notesInputFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getNotesInputFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setNotesInputFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "clearFromXmlViewCache", "", "type", "", "token", "", EventConstant.Key.MODULE, "ownerId", "ownerName", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "hasSendRequest", "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "sendRequest", "addWatermark", WidgetCostModule.TYPE_ON_START, "onDestroyView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyPermissionPanel extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f232884p = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpaceEditText f232885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f232886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f232887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f232888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f232889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f232890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f232891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f232892o;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r100, String r101, int r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r103, "ownerId");
            Intrinsics.checkNotNullParameter(r104, "ownerName");
            Intrinsics.checkNotNullParameter(r105, EventConstant.Key.MODULE);
            Bundle r106 = new Bundle();
            r106.putString("extra_token", r101);
            r106.putInt("extra_type", r102);
            r106.putString("extra_owner_id", r103);
            r106.putString("extra_owner_name", r104);
            r106.putString("extra_module", r105);
            Fragment r107 = Fragment.instantiate(r100, ApplyPermissionPanel.class.getName(), r106);
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            DialogFragment r108 = (DialogFragment) r107;
            FragmentManager r109 = r100.getSupportFragmentManager();
            String r110 = ApplyPermissionPanel.class.getName();
            if ((r108 instanceof Fragment) == false) goto L5;
            DialogFragment r111 = r108;
        L6:
            LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r111, r110, r112);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r109, r111, r112) == true) goto L15;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r108.show(r109, r110);
            return;
        L15:
            return;
        L5:
            r111 = null;
            goto L6
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApplyPermissionPanel f232893a;

        public b(ApplyPermissionPanel r100) {
            this.f232893a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            ApplyPermissionPanel r101 = this.f232893a;
            if (r101.f232892o == true) goto L26;
            View r102 = r101.f232885h;
            if (r102 != null) goto L11;
            View r103 = r101.getView();
            if (r103 == null) goto L9;
            r102 = r103.findViewById(R.id.notesInput);
        L10:
            r101.f232885h = (SpaceEditText) r102;
            goto L11
        L9:
            r102 = null;
        L11:
            Editable r104 = ((SpaceEditText) r102).getText();
            boolean r105 = false;
            if (r104 == null) goto L19;
            String r106 = r104.toString();
            if (r106 == null) goto L19;
            if (r106.length() <= 0) goto L18;
            r105 = true;
        L18:
            boolean r107 = r105;
        L20:
            ApplyPermissionPanel r108 = this.f232893a;
            int r109 = r108.f232886i;
            String r110 = r108.f232887j;
            if (r110 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("token");
            String r111 = null;
        L24:
            String[] r112 = PermissionAnalytic.f232823a;
            Intrinsics.checkNotNullParameter(r111, "token");
            Intrinsics.checkNotNullParameter("edit", "permission");
            PermissionAnalytic.f(r109, r111, "cancel", "edit", r107, false);
            return;
        L23:
            r111 = r110;
        L19:
            r107 = false;
            goto L20
        }
    }

    static {
    }

    public ApplyPermissionPanel() {
        this.f232886i = sbb.e.f541296g.f541317b;
        this.f232891n = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f232891n.dispose();
        this.f232885h = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -2;
        r102.softInputMode = 16;
        r102.gravity = 80;
        r101.setAttributes(r102);
        r101.setDimAmount(0.2f);
        r101.setWindowAnimations(R.style.ActionSheetAnimation);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L11;
        r103.setOnCancelListener(new b(this));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.getString("extra_token", "");
        if (r103 == null) goto L6;
    L7:
        this.f232887j = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L10;
        int r105 = r104.getInt("extra_type", this.f232886i);
    L11:
        this.f232886i = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L15;
        String r107 = r106.getString("extra_owner_id", "");
        if (r107 == null) goto L15;
    L16:
        this.f232889l = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L20;
        String r109 = r108.getString("extra_owner_name", "");
        if (r109 == null) goto L20;
    L21:
        this.f232890m = r109;
        Bundle r110 = getArguments();
        if (r110 == null) goto L27;
        String r111 = r110.getString("extra_module", "");
        if (r111 == null) goto L27;
        r102 = r111;
    L27:
        this.f232888k = r102;
        return;
    L20:
        r109 = "";
    L15:
        r107 = "";
        goto L16
    L10:
        r105 = this.f232886i;
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        StringBuilder r111 = new StringBuilder("@");
        String r101 = this.f232890m;
        String r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ownerName");
        r101 = null;
    L5:
        r111.append(r101);
        String r112 = r111.toString();
        String r103 = xo5.a.c(getContext(), R.string.Doc_Permission_ApplyEditPermDesc, "owner_name", r112);
        Intrinsics.checkNotNull(r103);
        int r104 = StringsKt.indexOf$default(r103, r112, 0, false, 6, null);
        SpannableString r105 = new SpannableString(r103);
        r105.setSpan(new hi5.y(getContext(), new q(this)), r104, r112.length() + r104, 33);
        ((TextView) r100.findViewById(R.id.tips)).setText(r105);
        ((TextView) r100.findViewById(R.id.tips)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) r100.findViewById(R.id.tips)).setHighlightColor(0);
        ((Button) r100.findViewById(R.id.sendRequestBtn)).setOnClickListener(new r(this));
        ((CommonActionPanelLayout) r100.findViewById(R.id.title_panel)).setOnActionListener(new s(this));
        zo5.b r106 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        String r113 = this.f232887j;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("token");
    L9:
        r106.j(r102, this.f232886i, getDialog());
        com.bytedance.ee.bear.middleground.permission.c.g("apply_permission");
        return;
    L8:
        r102 = r113;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.apply_permission_panel_layout, r101, false);
    }
}
