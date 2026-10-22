package com.larus.share.impl.view;

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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import com.larus.platform.service.IOfficePlatformService;
import com.larus.share.impl.databinding.LarusDialogFragmentDriveShareBinding;
import com.larus.share.impl.panel.SharePanelAdapter;
import com.larus.share.impl.panel.SharePanelItemDecoration;
import com.larus.share.service.ShareDocType;
import com.larus.share.service.ShareOfficeDocDelegate;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006-"}, d2 = {"Lcom/larus/share/impl/view/DriveShareDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "shareContext", "Lcom/larus/share/bean/DriveShareContext;", "<init>", "(Lcom/larus/share/bean/DriveShareContext;)V", "()V", "binding", "Lcom/larus/share/impl/databinding/LarusDialogFragmentDriveShareBinding;", "currentPrivacyStatus", "", "isEnterpriseMode", "()Z", "isEnterpriseMode$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", WidgetCostModule.TYPE_ON_START, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "setupLandscape", "setupTitleBar", "setupPrivacy", "observePrivacy", "refreshPrivacy", "setupSharePanel", "toDrivePermissionPage", "showOpenPermissionGuide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveShareDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f368776h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kw9.b f368777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusDialogFragmentDriveShareBinding f368778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f368779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f368780g;

    public static final class a {
    }

    static {
    }

    public DriveShareDialogFragment() {
        this(null);
        S90(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("DriveShareDialogFragment", "no argument constructor, dismiss failed", e);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public final void T90() {
        ShareOfficeDocDelegate r100 = ShareOfficeDocDelegate.f368886b;
        ShareDocType r101 = ShareDocType.DRIVE;
        kw9.b r102 = this.f368777d;
        if (r102 == null) goto L8;
        kw9.d r103 = r102.f506419b;
        if (r103 == null) goto L8;
        String r104 = r103.f506423a;
        if (r104 == null) goto L8;
    L9:
        boolean r105 = r100.a(r101, r104);
        this.f368779f = r105;
        if (r105 == false) goto L21;
        LarusDialogFragmentDriveShareBinding r106 = this.f368778e;
        if (r106 == null) goto L16;
        ImageView r107 = r106.f368594c;
        if (r107 == null) goto L16;
        r107.setImageResource(R.drawable.larus_slides_public);
    L16:
        LarusDialogFragmentDriveShareBinding r108 = this.f368778e;
        if (r108 == null) goto L32;
        TextView r109 = r108.f368595d;
        if (r109 == null) goto L33;
        r109.setText(getResources().getString(R.string.larus_slides_share_linkAccess_on_status));
        return;
    L33:
        return;
    L32:
        return;
    L21:
        LarusDialogFragmentDriveShareBinding r110 = this.f368778e;
        if (r110 == null) goto L26;
        ImageView r111 = r110.f368594c;
        if (r111 == null) goto L26;
        r111.setImageResource(R.drawable.larus_slides_lock);
    L26:
        LarusDialogFragmentDriveShareBinding r112 = this.f368778e;
        if (r112 == null) goto L35;
        TextView r113 = r112.f368595d;
        if (r113 == null) goto L36;
        r113.setText(getResources().getString(R.string.larus_slides_share_linkAccess_off_status));
        return;
    L36:
        return;
    L35:
        return;
    L8:
        r104 = "";
        goto L9
    }

    public final void U90() {
        ShareOfficeDocDelegate r100 = ShareOfficeDocDelegate.f368886b;
        Context r101 = getContext();
        ShareDocType r102 = ShareDocType.DRIVE;
        kw9.b r103 = this.f368777d;
        if (r103 == null) goto L8;
        kw9.d r104 = r103.f506419b;
        if (r104 == null) goto L8;
        String r105 = r104.f506423a;
        if (r105 == null) goto L8;
    L9:
        boolean r106 = this.f368779f;
        if (r103 == null) goto L14;
        kw9.d r107 = r103.f506419b;
        if (r107 == null) goto L14;
        int r108 = r107.f506424b;
    L15:
        r100.c(r101, r102, new com.larus.share.service.i(r105, r106, false, null, null, null, null, null, null, null, Integer.valueOf(r108), 1016));
        return;
    L14:
        r108 = 12;
    L8:
        r105 = "";
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f368778e = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.setLayout(-1, -1);
        r101.setWindowAnimations(R.style.larus_share_long_image_dialog_animation);
        return;
    L9:
        return;
    }

    public DriveShareDialogFragment(kw9.b r100) {
        this.f368777d = r100;
        this.f368780g = LazyKt.lazy(new c());
    }

    public static void S90(DriveShareDialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L12;
        FLogger.f375446a.i("DriveShareDialogFragment", "UI mode changed during recreation, dismissing dialog");
        S90(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("DriveShareDialogFragment", "dismiss failed during recreation", e);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r210);
        Dialog r100 = getDialog();
        List r101 = null;
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r102 = (BottomSheetDialog) r100;
    L6:
        if (r102 == null) goto L8;
        final View r103 = r102.findViewById(R.id.design_bottom_sheet);
    L9:
        Dialog r104 = getDialog();
        if (r104 == null) goto L12;
        r104.setOnShowListener(new com.larus.share.impl.view.a(r103));
    L12:
        LarusDialogFragmentDriveShareBinding r105 = this.f368778e;
        if (r105 == null) goto L17;
        ImageView r106 = r105.f368593b;
        if (r106 == null) goto L17;
        e1.d(r106, new b(this));
    L17:
        LarusDialogFragmentDriveShareBinding r107 = this.f368778e;
        if (r107 == null) goto L28;
        TextView r108 = r107.f368598g;
        if (r108 == null) goto L28;
        kw9.b r109 = this.f368777d;
        if (r109 == null) goto L26;
        com.larus.bmhome.share.panel.b r111 = r109.f506421d;
        if (r111 == null) goto L26;
        String r112 = r111.f313865h;
    L27:
        r108.setText(r112);
    L26:
        r112 = null;
    L28:
        T90();
        LarusDialogFragmentDriveShareBinding r113 = this.f368778e;
        if (r113 == null) goto L33;
        ConstraintLayout r114 = r113.f368597f;
        if (r114 == null) goto L33;
        e1.d(r114, new d(this));
    L33:
        LarusDialogFragmentDriveShareBinding r115 = this.f368778e;
        if (r115 == null) goto L70;
        RecyclerView r116 = r115.f368596e;
        if (r116 == null) goto L70;
        kw9.b r117 = this.f368777d;
        if (r117 == null) goto L70;
        List<jr9.a> r118 = r117.f506420c;
        if (r118 != null) goto L42;
    L45:
        boolean r119 = true;
    L46:
        if (r119 == false) goto L53;
        com.larus.share.impl.util.e r120 = com.larus.share.impl.util.e.f368769a;
        int r121 = com.larus.share.impl.sdk.a.f368732a;
        jr9.c r122 = com.larus.share.impl.sdk.a.a(r117.f506419b.f506425c);
        if (r122 == null) goto L52;
        List<jr9.a> r123 = r122.c();
        if (r123 == null) goto L52;
        r101 = CollectionsKt.filterNotNull(r123);
    L52:
        List<jr9.a> r124 = com.larus.share.impl.util.e.d(r120, r101, false, null, false, 7);
    L54:
        IOfficePlatformService r125 = (IOfficePlatformService) ServiceManager.get().getService(IOfficePlatformService.class);
        FLogger.f375446a.i("DriveShareDialogFragment", "feishuService: " + r125 + "， fileType: " + r117.f506419b.f506424b);
        if (r125 != null) goto L57;
    L65:
        List<jr9.a> r126 = r124;
    L67:
        if ((!r126.isEmpty()) == false) goto L69;
        SharePanelAdapter r127 = new SharePanelAdapter(r117.f506418a, this, new g(r117, this), r117.f506421d, null, false, 96);
        r127.setData(r126);
        r116.setAdapter(r127);
        r116.setLayoutManager(new LinearLayoutManager(r117.f506418a, 0, false));
        r116.addItemDecoration(new SharePanelItemDecoration(r117.f506418a, false));
        r116.setVisibility(0);
        goto L70
    L69:
        FLogger.f375446a.i("DriveShareDialogFragment", "setupSharePanel: shareItems is empty");
        r116.setVisibility(8);
        goto L70
    L57:
        if (r125.c(Integer.valueOf(r117.f506419b.f506424b)) == true) goto L65;
        ArrayList r128 = new ArrayList();
        Iterator r129 = r124.iterator();
    L60:
        if (r129.hasNext() == false) goto L64;
        Object r130 = r129.next();
        if ((!Intrinsics.areEqual(((jr9.a) r130).b(), ShareChannel.COPY_FEISHU_LINK)) == false) goto L60;
        r128.add(r130);
        goto L60
    L64:
        r126 = r128;
        goto L67
    L53:
        r124 = com.larus.share.impl.util.e.d(com.larus.share.impl.util.e.f368769a, r117.f506420c, false, null, false, 7);
        goto L54
    L42:
        if (r118.isEmpty() == true) goto L45;
        r119 = false;
    L70:
        kw9.b r131 = this.f368777d;
        if (r131 == null) goto L84;
        kw9.d r132 = r131.f506419b;
        if (r132 == null) goto L85;
        String r133 = r132.f506423a;
        if (r133 == null) goto L86;
        ShareOfficeDocDelegate.f368886b.b(ShareDocType.DRIVE, r133, getViewLifecycleOwner(), new e(this));
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L12;
    L7:
        kw9.b r103 = this.f368777d;
        if (r103 == null) goto L14;
        com.larus.share.impl.e r104 = com.larus.share.impl.a.f368590a;
        kw9.d r105 = r103.f506419b;
        com.larus.share.impl.a.r(r105.f506425c, r105.f506426d, r105.f506427e);
        kw9.d r106 = r103.f506419b;
        com.larus.share.impl.a.q(r106.f506425c, ShareChannel.PERMISSION_SETTING, r106.f506426d, r106.f506427e);
        return;
    L14:
        return;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        super.show(r100, r101);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_dialog_fragment_drive_share, r110, false);
        int r112 = R.id.close_iv;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r101, R.id.close_iv);
        if (r102 == null) goto L31;
        r112 = R.id.divider;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.divider)) == null) goto L31;
        r112 = R.id.privacy_iv;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.privacy_iv);
        if (r103 == null) goto L31;
        r112 = R.id.privacy_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.privacy_title);
        if (r104 == null) goto L31;
        r112 = R.id.private_next;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.private_next)) == null) goto L31;
        r112 = R.id.share_panel;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.share_panel);
        if (r105 == null) goto L31;
        r112 = R.id.share_subtitle_privacy;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.share_subtitle_privacy);
        if (r106 == null) goto L31;
        r112 = R.id.share_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.share_title);
        if (r107 == null) goto L31;
        r112 = R.id.share_title_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.share_title_container)) == null) goto L31;
        this.f368778e = new LarusDialogFragmentDriveShareBinding((FrameLayout) r101, r102, r103, r104, r105, r106, r107);
        Dialog r108 = getDialog();
        if (r108 == null) goto L25;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L25;
        r109.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), android.R.color.transparent)));
    L25:
        LarusDialogFragmentDriveShareBinding r113 = this.f368778e;
        if (r113 != null) goto L32;
        return null;
    L32:
        return r113.f368592a;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
