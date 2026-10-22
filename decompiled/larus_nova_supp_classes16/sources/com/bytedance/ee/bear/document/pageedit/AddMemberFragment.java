package com.bytedance.ee.bear.document.pageedit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.util.avatar.BaseAddAvatarUriSettings;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.factory.PickerFactory;
import com.ss.android.lark.picker.factory.PickerFactoryLoader;
import com.ss.android.lark.picker.factory.PickerViewHolder;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010$\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020\u0014H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0014H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020)H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/AddMemberFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/OrientationBaseDialogFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "selectResult", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$UserInfo;", "Lkotlin/collections/ArrayList;", "forceSelect", "", "pickerViewHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "callBack", "Lcom/bytedance/ee/bear/document/pageedit/SelectUserCallBack;", "avatarUriSettings", "Lcom/bytedance/ee/util/avatar/BaseAddAvatarUriSettings;", "container", "Landroid/view/ViewGroup;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "sourceFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onViewCreated", "view", "getPickerView", "onStart", "adjustWindowHeight", "attributes", "Landroid/view/WindowManager$LayoutParams;", "isLandscape", "", "applyTopCornerRadius", "getPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDestroyView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "isSupportScreenLandscape", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddMemberFragment extends Hilt_AddMemberFragment implements d0c.c {
    public static final /* synthetic */ int q = 0;
    public final ArrayList<PageEditPlugin.UserInfo> k;
    public ArrayList<String> l;
    public PickerViewHolder m;
    public g n;
    public final BaseAddAvatarUriSettings o;
    public ViewGroup p;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final void onDestroyView() {
        PickerViewHolder r0 = this.m;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.m = null;
        super.onDestroyView();
    }

    public AddMemberFragment() {
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.o = (BaseAddAvatarUriSettings) SettingManager.getInstance().get(BaseAddAvatarUriSettings.class);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.OrientationBaseDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
    L8:
        if (r2 == null) goto L10;
        r2.windowAnimations = 2131951623;
    L10:
        TypedValue r3 = new TypedValue();
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L17;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L15;
        r5.getValue(2131169371, r3, true);
    L15:
        if (r2 == null) goto L17;
        r2.dimAmount = r3.getFloat();
    L17:
        Dialog r6 = getDialog();
        if (r6 == null) goto L23;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L24;
        r7.setAttributes(r2);
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m232provideComponent() {
        return provideComponent();
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        tt5.a.h("AddMemberFragment", "on cancel");
        g r3 = this.n;
        if (r3 == null) goto L6;
        r3.onCancel();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r3) {
        tt5.a.h("AddMemberFragment", "onCreate");
        super.onCreate(r3);
        Bundle r4 = getArguments();
        ArrayList<String> r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("FORCE_SELECT");
    L7:
        if ((r5 instanceof ArrayList) == false) goto L9;
        r0 = (ArrayList) r5;
    L9:
        this.l = r0;
        return;
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.OrientationBaseDialogFragment
    public final void ba0(WindowManager.LayoutParams r5, boolean r6) {
        r5.gravity = 81;     // Catch: Throwable -> L5
        r5.height = (int) (((double) n.p(getContext())) * 0.95d);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("AddMemberFragment", "init peek height", th, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        ViewGroup.LayoutParams r9 = new ViewGroup.LayoutParams(-1, -1);
        this.p = (ViewGroup) r7.findViewById(2131367728);
        final FragmentActivity r10 = getActivity();
        if (r10 == null) goto L5;
        PickerFactory r1 = PickerFactoryLoader.INSTANCE.load();
        final NavPickerConfig r2 = new NavPickerConfig(new Dependency(r10, r10.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r2.extra(new AddMemberFragment$getPickerConfig$config$1$1(this, r10));
        r2.searcher(AddMemberFragment$getPickerConfig$config$1$2.INSTANCE);
        r2.navigation(new AddMemberFragment$getPickerConfig$config$1$3(r10, r2, this));
        PickerViewHolder r11 = r1.createNavPickerHolder(r10, r2, PickerStatistics.Scene.CcmCommonPanelAddMember);
        this.m = r11;
        View r12 = r11.getView();
    L6:
        if (r12 == null) goto L10;
        ViewGroup r3 = this.p;
        if (r3 == null) goto L10;
        r3.addView(r12, r9);
    L10:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
        float r13 = xo5.a.a(12.0f);
        ViewGroup r14 = this.p;
        if (r14 == null) goto L13;
        r14.setOutlineProvider(new com.bytedance.ee.bear.document.pageedit.a(r13));
    L13:
        ViewGroup r16 = this.p;
        if (r16 == null) goto L17;
        r16.setClipToOutline(true);
        return;
    L17:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ForsetiHelper.w(getActivity(), 0.9f);
        return r2.inflate(2131558530, r3, false);
    }
}
