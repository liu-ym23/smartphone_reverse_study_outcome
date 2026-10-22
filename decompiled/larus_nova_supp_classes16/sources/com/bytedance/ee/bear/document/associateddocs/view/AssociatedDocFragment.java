package com.bytedance.ee.bear.document.associateddocs.view;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.document.associateddocs.AssociatedDocViewModel;
import com.bytedance.ee.util.ui.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedDocFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "<init>", "()V", "mResult", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "getPicker", "getPickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedDocFragment extends BaseDialogFragment {
    public ArrayList<SearchBaseInfo> h;
    public AssociatedDocViewModel i;

    public static final class a {
    }

    static {
    }

    public AssociatedDocFragment() {
        new ArrayList();
    }

    public final int getTheme() {
        if (getContext() != null) goto L5;
    L7:
        return 2131952029;
    L5:
        if (ku5.c.k(getContext()) == false) goto L7;
        return 2131952037;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ba0(getResources().getConfiguration());
    }

    public final void ba0(Configuration r7) {
        Dialog r0 = getDialog();     // Catch: Throwable -> L26
        FrameLayout.LayoutParams r1 = null;
        if (r0 == null) goto L7;
        Window r2 = r0.getWindow();     // Catch: Throwable -> L26
        if (r2 == null) goto L7;
        WindowManager.LayoutParams r3 = r2.getAttributes();     // Catch: Throwable -> L26
    L8:
        if (r3 == null) goto L10;
        r3.gravity = 81;     // Catch: Throwable -> L26
    L10:
        if (r3 == null) goto L12;
        r3.height = (int) (((double) n.p(getContext())) * 0.95d);     // Catch: Throwable -> L26
    L12:
        Dialog r4 = getDialog();     // Catch: Throwable -> L26
        if (r4 == null) goto L17;
        Window r5 = r4.getWindow();     // Catch: Throwable -> L26
        if (r5 == null) goto L17;
        r5.setAttributes(r3);     // Catch: Throwable -> L26
    L17:
        Dialog r6 = getDialog();     // Catch: Throwable -> L26
        if (r6 == null) goto L30;
        Window r8 = r6.getWindow();     // Catch: Throwable -> L26
        if (r8 == null) goto L30;
        View r9 = r8.getDecorView();     // Catch: Throwable -> L26
        if (com.larus.home.impl.utils.c.e == false) goto L28;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L26
        Thread r10 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L26
        if (r10 == com.larus.home.impl.utils.c.a) goto L28;
        com.larus.home.impl.utils.c.a(r10, "getDecorView");     // Catch: Throwable -> L26
    L28:
        if (r9 == null) goto L30;
        LinearLayout r11 = (LinearLayout) r9.findViewById(2131363287);     // Catch: Throwable -> L26
    L31:
        if (r11 == null) goto L33;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();     // Catch: Throwable -> L26
    L35:
        if ((r12 instanceof FrameLayout.LayoutParams) == false) goto L37;
        r1 = (FrameLayout.LayoutParams) r12;     // Catch: Throwable -> L26
    L37:
        if (r1 != null) goto L39;
        return;
    L39:
        if (r7.orientation != 2) goto L41;
        r1.width = (int) (((double) n.q(getContext())) * 0.7d);     // Catch: Throwable -> L26
        r1.gravity = 1;     // Catch: Throwable -> L26
        return;
    L41:
        r1.width = n.q(getContext());     // Catch: Throwable -> L26
        r1.gravity = -1;     // Catch: Throwable -> L26
        return;
    L33:
        r12 = null;
    L30:
        r11 = null;
    L7:
        r3 = null;
    L26:
        th = move-exception;
        tt5.a.e("AssociatedDocFragment", "init peek height", th, false);
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        ba0(r2);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if ((getContext() instanceof FragmentActivity) == false) goto L6;
        FragmentActivity r0 = getContext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.i = (AssociatedDocViewModel) new ViewModelProvider(r0).get(AssociatedDocViewModel.class);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        if (getActivity() == null) goto L10;
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout r0 = (LinearLayout) r7;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        Picker r2 = new Picker(r1);
        PickerConfig r3 = new PickerConfig(new Dependency(r1, r1.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r3.extra(new AssociatedDocFragment$getPickerConfig$config$1$1(this));
        r3.searcher(AssociatedDocFragment$getPickerConfig$config$1$2.INSTANCE);
        r3.recommendList(AssociatedDocFragment$getPickerConfig$config$1$3.INSTANCE);
        r2.init(r3);
    L8:
        r0.addView(r2, 1, r9);
        r7.findViewById(2131363290).setLeftClickListener(new k(this));
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560031, r3, false);
    }
}
