package com.larus.share.impl.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import com.larus.share.impl.databinding.LarusDialogFragmentSlidesShareBinding;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0010H\u0002J\b\u0010/\u001a\u00020\u0010H\u0002J\b\u00100\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\b\u00103\u001a\u00020\u0010H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u00065"}, d2 = {"Lcom/larus/share/impl/view/SlidesShareDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "shareContext", "Lcom/larus/share/bean/SlideShareContext;", "<init>", "(Lcom/larus/share/bean/SlideShareContext;)V", "()V", "binding", "Lcom/larus/share/impl/databinding/LarusDialogFragmentSlidesShareBinding;", "currentPrivacyStatus", "", "isEnterpriseMode", "()Z", "isEnterpriseMode$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "getTheme", "", WidgetCostModule.TYPE_ON_START, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setupLandscape", "applyWindowHorizontalPadding", "preSyncSystemBarsWithHost", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "setupPrivacy", "refreshPrivacy", "setupTitleBar", "setupSharePanel", "showOpenPermissionGuide", "toSlidesPermissionPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesShareDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f368799h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kw9.i f368800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusDialogFragmentSlidesShareBinding f368801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f368802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f368803g;

    public static final class a {
    }

    static {
    }

    public SlidesShareDialogFragment() {
        this(null);
        T90(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("SlidesShareDialogFragment", "no argument constructor, dismiss failed", e);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public final void V90() {
        ShareOfficeDocDelegate r100 = ShareOfficeDocDelegate.f368886b;
        ShareDocType r101 = ShareDocType.SLIDES;
        kw9.i r102 = this.f368800d;
        if (r102 == null) goto L8;
        kw9.j r103 = r102.f506479d;
        if (r103 == null) goto L8;
        String r104 = r103.f506480a;
        if (r104 == null) goto L8;
    L9:
        boolean r105 = r100.a(r101, r104);
        this.f368802f = r105;
        if (r105 == false) goto L21;
        LarusDialogFragmentSlidesShareBinding r106 = this.f368801e;
        if (r106 == null) goto L16;
        ImageView r107 = r106.f368605c;
        if (r107 == null) goto L16;
        r107.setImageResource(R.drawable.larus_slides_public);
    L16:
        LarusDialogFragmentSlidesShareBinding r108 = this.f368801e;
        if (r108 == null) goto L32;
        TextView r109 = r108.f368606d;
        if (r109 == null) goto L33;
        r109.setText(getResources().getString(R.string.larus_slides_share_linkAccess_on_status));
        return;
    L33:
        return;
    L32:
        return;
    L21:
        LarusDialogFragmentSlidesShareBinding r110 = this.f368801e;
        if (r110 == null) goto L26;
        ImageView r111 = r110.f368605c;
        if (r111 == null) goto L26;
        r111.setImageResource(R.drawable.larus_slides_lock);
    L26:
        LarusDialogFragmentSlidesShareBinding r112 = this.f368801e;
        if (r112 == null) goto L35;
        TextView r113 = r112.f368606d;
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

    public final void W90() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L29;
        FragmentActivity r102 = getActivity();
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L29;
        Context r104 = getContext();
        if (r104 == null) goto L25;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L25;
        Configuration r106 = r105.getConfiguration();
        if (r106 == null) goto L25;
        if (r106.orientation != 2) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == true) goto L29;
        boolean r108 = false;
    L30:
        ShareOfficeDocDelegate r109 = ShareOfficeDocDelegate.f368886b;
        Context r110 = getContext();
        ShareDocType r111 = ShareDocType.SLIDES;
        kw9.i r112 = this.f368800d;
        if (r112 == null) goto L36;
        kw9.j r113 = r112.f506479d;
        if (r113 == null) goto L36;
        String r114 = r113.f506480a;
        if (r114 == null) goto L36;
    L37:
        boolean r115 = this.f368802f;
        if (r112 == null) goto L44;
        kw9.j r116 = r112.f506479d;
        if (r116 == null) goto L44;
        com.larus.bmhome.share.panel.h r117 = r116.f506482c;
        if (r117 == null) goto L44;
        String r118 = r117.Z;
    L45:
        if (r112 == null) goto L51;
        kw9.j r119 = r112.f506479d;
        if (r119 == null) goto L51;
        com.larus.bmhome.share.panel.h r120 = r119.f506482c;
        if (r120 == null) goto L51;
        String r121 = r120.f313906a0;
    L53:
        if (r112 == null) goto L59;
        kw9.j r122 = r112.f506479d;
        if (r122 == null) goto L59;
        com.larus.bmhome.share.panel.h r123 = r122.f506482c;
        if (r123 == null) goto L59;
        String r124 = r123.f313910c0;
    L60:
        if (r112 == null) goto L66;
        kw9.j r125 = r112.f506479d;
        if (r125 == null) goto L66;
        com.larus.bmhome.share.panel.h r126 = r125.f506482c;
        if (r126 == null) goto L66;
        Integer r127 = r126.f313912d0;
    L67:
        if (r112 == null) goto L73;
        kw9.j r128 = r112.f506479d;
        if (r128 == null) goto L73;
        com.larus.bmhome.share.panel.h r129 = r128.f506482c;
        if (r129 == null) goto L73;
        String r130 = r129.L;
    L74:
        if (r112 == null) goto L80;
        kw9.j r131 = r112.f506479d;
        if (r131 == null) goto L80;
        com.larus.bmhome.share.panel.h r132 = r131.f506482c;
        if (r132 == null) goto L80;
        Integer r133 = r132.M;
    L81:
        r109.c(r110, r111, new com.larus.share.service.i(r114, r115, r108, r118, r121, null, r124, r127, r130, r133, null, 1056));
        return;
    L80:
        r133 = null;
    L73:
        r130 = null;
    L66:
        r127 = null;
    L59:
        r124 = null;
    L51:
        r121 = null;
    L44:
        r118 = null;
    L36:
        r114 = "";
    L25:
        r107 = false;
        goto L26
    L12:
        if (r102.getRequestedOrientation() != 8) goto L14;
        r103 = true;
    L29:
        r108 = true;
        goto L30
    L5:
        if (r100.getRequestedOrientation() != 0) goto L7;
        r101 = true;
        goto L8
    }

    public final void U90() {
        int r100 = 0;
        if (requireContext().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_122, null, R.dimen.larus_dp_122));
    L8:
        Dialog r102 = getDialog();
        if (r102 == null) goto L17;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L18;
        View r104 = S90(r103);
        if (r104 == null) goto L19;
        r104.setPadding(r100, r104.getPaddingTop(), r100, r104.getPaddingBottom());
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        V90();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.setLayout(-1, -1);
        r101.setWindowAnimations(R.style.larus_share_long_image_dialog_animation);
    L7:
        U90();
    }

    public SlidesShareDialogFragment(kw9.i r100) {
        this.f368800d = r100;
        this.f368803g = LazyKt.lazy(new v0());
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

    public static void T90(SlidesShareDialogFragment r100) {
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

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        U90();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L12;
        FLogger.f375446a.i("SlidesShareDialogFragment", "UI mode changed during recreation, dismissing dialog");
        T90(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("SlidesShareDialogFragment", "no argument constructor, dismiss failed", e);
        return;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L14;
        r102.addFlags(8);
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L14;
        Window r104 = r103.getWindow();
        View r105 = S90(r104);
        View r106 = S90(r102);
        WindowCompat.setDecorFitsSystemWindows(r102, false);
        r102.addFlags(Integer.MIN_VALUE);
        r102.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        int r107 = Build.VERSION.SDK_INT;
        if (r107 < 29) goto L11;
        r102.setNavigationBarContrastEnforced(false);
    L11:
        if (r107 < 28) goto L13;
        WindowManager.LayoutParams r108 = r102.getAttributes();
        r108.layoutInDisplayCutoutMode = 1;
        r102.setAttributes(r108);
    L13:
        r106.setSystemUiVisibility(((r105.getSystemUiVisibility() | 1024) | 512) | 256);
        r102.setStatusBarColor(r104.getStatusBarColor());
        r102.setNavigationBarColor(0);
    L14:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Dialog r112 = getDialog();
        List r100 = null;
        if ((r112 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r113 = (BottomSheetDialog) r112;
    L6:
        if (r113 == null) goto L8;
        final View r114 = r113.findViewById(R.id.design_bottom_sheet);
    L9:
        Dialog r115 = getDialog();
        if (r115 == null) goto L12;
        r115.setOnShowListener(new w0(r114, this));
    L12:
        LarusDialogFragmentSlidesShareBinding r116 = this.f368801e;
        if (r116 == null) goto L17;
        ImageView r117 = r116.f368604b;
        if (r117 == null) goto L17;
        e1.d(r117, new x0(this));
    L17:
        LarusDialogFragmentSlidesShareBinding r118 = this.f368801e;
        if (r118 == null) goto L28;
        TextView r119 = r118.f368609g;
        if (r119 == null) goto L28;
        kw9.i r120 = this.f368800d;
        if (r120 == null) goto L26;
        com.larus.bmhome.share.panel.b r121 = r120.f506478c;
        if (r121 == null) goto L26;
        String r122 = r121.f313865h;
    L27:
        r119.setText(r122);
    L26:
        r122 = null;
    L28:
        V90();
        LarusDialogFragmentSlidesShareBinding r123 = this.f368801e;
        if (r123 == null) goto L33;
        ConstraintLayout r124 = r123.f368608f;
        if (r124 == null) goto L33;
        e1.d(r124, new u0(this));
    L33:
        LarusDialogFragmentSlidesShareBinding r125 = this.f368801e;
        if (r125 == null) goto L59;
        RecyclerView r126 = r125.f368607e;
        if (r126 == null) goto L60;
        kw9.i r127 = this.f368800d;
        if (r127 == null) goto L61;
        List<jr9.a> r101 = r127.f506477b;
        if (r101 != null) goto L42;
    L45:
        boolean r102 = true;
    L46:
        if (r102 == false) goto L53;
        com.larus.share.impl.util.e r103 = com.larus.share.impl.util.e.f368769a;
        int r104 = com.larus.share.impl.sdk.a.f368732a;
        jr9.c r105 = com.larus.share.impl.sdk.a.a(r127.f506479d.f506481b);
        if (r105 == null) goto L52;
        List<jr9.a> r106 = r105.c();
        if (r106 == null) goto L52;
        r100 = CollectionsKt.filterNotNull(r106);
    L52:
        List<jr9.a> r107 = com.larus.share.impl.util.e.d(r103, r100, false, null, false, 7);
    L55:
        if ((!r107.isEmpty()) == false) goto L57;
        SharePanelAdapter r108 = new SharePanelAdapter(r127.f506476a, this, new z0(r127, this), r127.f506478c, null, false, 96);
        r108.setData(r107);
        r126.setAdapter(r108);
        r126.setLayoutManager(new LinearLayoutManager(r127.f506476a, 0, false));
        r126.addItemDecoration(new SharePanelItemDecoration(r127.f506476a, false));
        r126.setVisibility(0);
        return;
    L57:
        FLogger.f375446a.i("SlidesShareDialogFragment", "setupSharePanel: shareItems is empty");
        r126.setVisibility(8);
        return;
    L53:
        r107 = com.larus.share.impl.util.e.d(com.larus.share.impl.util.e.f368769a, r127.f506477b, false, null, false, 7);
        goto L55
    L42:
        if (r101.isEmpty() == true) goto L45;
        r102 = false;
        goto L46
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L8:
        r114 = null;
        goto L9
    L5:
        r113 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L12;
    L7:
        kw9.i r103 = this.f368800d;
        if (r103 == null) goto L14;
        com.larus.share.impl.e r104 = com.larus.share.impl.a.f368590a;
        kw9.j r105 = r103.f506479d;
        com.larus.share.impl.a.r(r105.f506481b, r105.f506482c, r105.f506483d);
        kw9.j r106 = r103.f506479d;
        com.larus.share.impl.a.q(r106.f506481b, ShareChannel.PERMISSION_SETTING, r106.f506482c, r106.f506483d);
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
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f368801e = LarusDialogFragmentSlidesShareBinding.a(r100, r101);
        Dialog r103 = getDialog();
        if (r103 == null) goto L7;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L7;
        r104.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), android.R.color.transparent)));
    L7:
        LarusDialogFragmentSlidesShareBinding r105 = this.f368801e;
        if (r105 != null) goto L12;
        return null;
    L12:
        return r105.f368603a;
    }
}
