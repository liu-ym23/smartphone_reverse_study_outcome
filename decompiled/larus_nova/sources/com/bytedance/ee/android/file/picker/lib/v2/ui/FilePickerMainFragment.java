package com.bytedance.ee.android.file.picker.lib.v2.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.android.file.picker.lib.FilePickerParams;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerMainActivityBinding;
import com.bytedance.ee.android.file.picker.lib.utils.FileUtils;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.CheckedState;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerAdapter;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.OpenConfirmHandler;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.OpenSystemPickerHandler;
import com.bytedance.supervisor.token.Token;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u000203H\u0016J\u001a\u00104\u001a\u0002052\u0006\u00106\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u000205H\u0002J \u00109\u001a\u0002052\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000205H\u0002J\u0010\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u000205H\u0002J\u0010\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020?H\u0002J\u0010\u0010G\u001a\u0002052\u0006\u0010H\u001a\u00020\rH\u0002J\u0010\u0010I\u001a\u0002052\u0006\u0010H\u001a\u00020\rH\u0002J\b\u0010J\u001a\u000205H\u0002J\"\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0015\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u00020SH\u0000¢\u0006\u0002\bTR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/FilePickerMainFragment;", "Lcom/ss/android/lark/base/fragment/BaseForsetiFragment;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/larksuite/arch/jack/JackView;", "<init>", "()V", "mViewModel", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerViewModel;", "getMViewModel", "()Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mBinding", "Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerMainActivityBinding;", "getMBinding", "()Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerMainActivityBinding;", "setMBinding", "(Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerMainActivityBinding;)V", "mCategoryConfigManager", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "getMCategoryConfigManager", "()Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "setMCategoryConfigManager", "(Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;)V", "dependency", "Lcom/bytedance/ee/android/file/picker/lib/dependency/FilePickerModuleDependency;", "getDependency", "()Lcom/bytedance/ee/android/file/picker/lib/dependency/FilePickerModuleDependency;", "setDependency", "(Lcom/bytedance/ee/android/file/picker/lib/dependency/FilePickerModuleDependency;)V", "mAdapter", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerAdapter;", "getMAdapter", "()Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerAdapter;", "mAdapter$delegate", "mOpenSystemPickerHandler", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/OpenSystemPickerHandler;", "mOpenConfirmHandler", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/OpenConfirmHandler;", "mLoadingDialog", "Lkotlin/Lazy;", "Lcom/ss/android/lark/widget/dialog/CommonLoadingDialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getViewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onViewCreated", "", "view", "initView", "initListeners", "onUserSelectFile", "groupEntity", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/GroupEntity;", "fileEntry", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", "selected", "", "onSendButtonClick", "handlePickerResult", "result", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/PickerResult;", "initSubscribers", "updateLoadingDialogStatus", "show", "hideSystemPickerEntrance", "binding", "showSystemPickerEntrance", "checkRequiredPermission", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "showErrorDialog", "message", "", "showErrorDialog$file_picker_lib_release", "Companion", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class FilePickerMainFragment extends Hilt_FilePickerMainFragment implements JackView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f206064s;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f206065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FilePickerMainActivityBinding f206066l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Inject
    public sm4.b f206067m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Inject
    public om4.a f206068n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f206069o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OpenSystemPickerHandler f206070p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OpenConfirmHandler f206071q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy<CommonLoadingDialog> f206072r;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f206073a = null;

        static {
            int[] r100 = new int[CheckedState.values().length];
            r100[CheckedState.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CheckedState.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CheckedState.FAILED_WITH_DIALOG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f206073a = r100;
        }
    }

    @Override // com.larksuite.arch.jack.i
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    static {
        f206064s = true;
    }

    public final FilePickerMainActivityBinding W90() {
        FilePickerMainActivityBinding r100 = this.f206066l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    public final FilePickerViewModel X90() {
        return (FilePickerViewModel) this.f206065k.getValue();
    }

    public FilePickerMainFragment() {
        final Function0<Fragment> r100 = new FilePickerMainFragment$special$$inlined$viewModels$default$1(this);
        this.f206065k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FilePickerViewModel.class), new FilePickerMainFragment$special$$inlined$viewModels$default$2(r100), new FilePickerMainFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f206069o = LazyKt.lazy(new FilePickerMainFragment$mAdapter$2(this));
        this.f206072r = LazyKt.lazy(FilePickerMainFragment$mLoadingDialog$1.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public final LifecycleOwner getViewLifecycleOwner() {
        return super.getViewLifecycleOwner();
    }

    public final void Y90(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Context r101 = getContext();
        if (r101 == null) goto L6;
        new UDDialogBuilder(r101).message(r100).messageTextColor(R.color.text_title).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Lark_Legacy_DialogOk).textColorRes(R.color.primary_fill_default)).show();
        return;
    }

    public static final void U90(FilePickerMainFragment r100, tm4.b r110) {
        FilePickerParams r101 = r100.X90().getParams();
        int r102 = r110.f546774a.size();
        int r103 = r101.f205958c;
        if (r102 <= r103) goto L8;
        String r104 = UIHelper.mustacheFormat(R.string.Lark_Legacy_SendAttachedFileSelectedExceedMaxLimit, "max_select_count", String.valueOf(r103));
        Context r105 = r100.getContext();
        if (r105 == null) goto L7;
        Intrinsics.checkNotNull(r104);
        UDToast.show(r105, r104);
    L7:
        CheckedState r106 = CheckedState.FAILED;
    L32:
        int r107 = b.f206073a[r106.ordinal()];
        if (r107 != 1) goto L35;
        Intent r108 = tm4.c.a(r110);
        if ((!r110.f546774a.isEmpty()) == false) goto L51;
        com.suite.lark.component.navroute.forseti.g r111 = com.suite.lark.component.navroute.forseti.f.b(r100);
        if (r111 == null) goto L50;
        Bundle r109 = r108.getExtras();
        if (r109 != null) goto L49;
        r109 = new Bundle();
    L49:
        r111.c(-1, r109);
        goto L51
    L50:
        r100.setResult(-1, r108);
    L51:
        r100.S90();
        return;
    L35:
        if (r107 != 2) goto L37;
        r100.S90();
        return;
    L37:
        if (r107 != 3) goto L40;
        return;
    L40:
        throw new NoWhenBranchMatchedException();
    L8:
        Iterator<tm4.a> r112 = r110.f546774a.iterator();
    L9:
        boolean r113 = false;
        if (r112.hasNext() == false) goto L21;
        long r114 = r112.next().f546773b;
        if (r114 <= r101.f205957b) goto L9;
        int r115 = qm4.a.f533872a;
        qm4.a.C7357a.b(String.valueOf(r114));
        String r116 = r101.f205960e;
        if (r116 != null) goto L16;
    L17:
        r113 = true;
    L18:
        if (r113 == false) goto L20;
        r106 = CheckedState.FAILED;
        goto L32
    L20:
        r100.Y90(r116);
        r106 = CheckedState.FAILED_WITH_DIALOG;
        goto L32
    L16:
        if (StringsKt.isBlank(r116) == false) goto L18;
    L21:
        long r117 = r110.f546775b;
        if (r117 <= r101.f205956a) goto L31;
        int r118 = qm4.a.f533872a;
        qm4.a.C7357a.b(String.valueOf(r117));
        String r119 = r101.f205959d;
        if (r119 != null) goto L26;
    L27:
        r113 = true;
    L28:
        if (r113 == false) goto L30;
        r106 = CheckedState.FAILED;
        goto L32
    L30:
        r100.Y90(r119);
        r106 = CheckedState.FAILED_WITH_DIALOG;
        goto L32
    L26:
        if (StringsKt.isBlank(r119) == false) goto L28;
    L31:
        r106 = CheckedState.SUCCESS;
        goto L32
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        W90().f205995e.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerViewExpandableItemManager r112 = new RecyclerViewExpandableItemManager();
        W90().f205995e.setAdapter(r112.b((FilePickerAdapter) this.f206069o.getValue()));
        r112.a(W90().f205995e);
        RefactoredDefaultItemAnimator r113 = new RefactoredDefaultItemAnimator();
        r113.setSupportsChangeAnimations(false);
        W90().f205995e.setItemAnimator(r113);
        W90().f205997g.setDividerVisible(false);
        W90().f205997g.setLeftImageDrawable(null);
        W90().f205997g.setLeftText(CommonTitleBarConstants.TEXT_CANCEL);
        W90().f205997g.setLeftClickListener(new k(this));
        W90().f205993c.setOnShowListener(FilePickerMainFragment$initListeners$2.INSTANCE);
        W90().f205993c.setOnDismissListener(FilePickerMainFragment$initListeners$3.INSTANCE);
        FragmentActivity r114 = getActivity();
        if (r114 == null) goto L5;
        OpenSystemPickerHandler r100 = new OpenSystemPickerHandler(r114, new FilePickerMainFragment$initListeners$4$1(this), X90().getParams(), this);
    L6:
        this.f206070p = r100;
        W90().f205993c.setSystemPickerClickListener(this.f206070p);
        FragmentActivity r115 = getActivity();
        if (r115 == null) goto L9;
        OpenConfirmHandler r101 = new OpenConfirmHandler(r115, X90(), this);
    L10:
        this.f206071q = r101;
        W90().f205996f.setOnClickListener(this.f206071q);
        W90().f205994d.setOnClickListener(new j(this));
        ((FilePickerAdapter) this.f206069o.getValue()).f206111e = new FilePickerMainFragment$initListeners$7(this);
        com.larksuite.arch.jack.f.a.e(this, X90(), FilePickerMainFragment$initSubscribers$1.INSTANCE, new FilePickerMainFragment$initSubscribers$2(this));
        com.larksuite.arch.jack.f.a.e(this, X90(), FilePickerMainFragment$initSubscribers$3.INSTANCE, new FilePickerMainFragment$initSubscribers$4(this));
        com.larksuite.arch.jack.f.a.f(this, X90(), FilePickerMainFragment$initSubscribers$5.INSTANCE, FilePickerMainFragment$initSubscribers$6.INSTANCE, new FilePickerMainFragment$initSubscribers$7(this));
        com.larksuite.arch.jack.f.a.d(this, X90(), FilePickerMainFragment$initSubscribers$8.INSTANCE, FilePickerMainFragment$initSubscribers$9.INSTANCE, FilePickerMainFragment$initSubscribers$10.INSTANCE, new FilePickerMainFragment$initSubscribers$11(this));
        com.larksuite.arch.jack.f.a.e(this, X90(), FilePickerMainFragment$initSubscribers$12.INSTANCE, new FilePickerMainFragment$initSubscribers$13(this));
        if (X90().getParams().f205966k == false) goto L16;
        OpenSystemPickerHandler r116 = this.f206070p;
        if (r116 == null) goto L23;
        r116.onSingleClick(null);
        return;
    L23:
        return;
    L16:
        if (f206064s == false) goto L20;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L21;
        com.ss.android.lark.utils.h.f(r102, new i(this), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-android_file_picker_request_permission"), 22, new String[0]);
    L21:
        int r117 = qm4.a.f533872a;
        Statistics.sendEvent("show_attach_localdisk");
        return;
    L20:
        X90().loadData();
        goto L21
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return JackView.a.d(this, r100, r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 != 102) goto L5;
        OpenSystemPickerHandler r103 = this.f206070p;
        if (r103 == null) goto L16;
        r103.b(r101, r102);
        return;
    L16:
        return;
    L5:
        if (r100 != 103) goto L17;
        OpenConfirmHandler r104 = this.f206071q;
        if (r104 == null) goto L14;
        r104.a(r101, r102);
        return;
    L14:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FilePickerMainActivityBinding r103 = FilePickerMainActivityBinding.a(getLayoutInflater(), r101);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f206066l = r103;
        return W90().f205991a;
    }

    public static final void V90(FilePickerMainFragment r100, GroupEntity r101, FileEntry r102, boolean r103) {
        r100.getClass();
        if (r103 == false) goto L5;
        String r104 = "select";
    L6:
        om4.a r105 = r100.f206068n;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        r105 = null;
    L10:
        Uri r106 = r102.f206014b;
        ((fjb.a) r105).getClass();
        Intrinsics.checkNotNullParameter(r106, "uri");
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).preprocessFile(null, r106, r103);
        int r107 = qm4.a.f533872a;
        qm4.a.C7357a.a(FileUtils.c(r102.f206014b), r104);
        r100.X90().updateSelectedStatus(CollectionsKt.listOf(GroupEntity.a(r101, CollectionsKt.listOf(r102))), r103);
        return;
    L5:
        r104 = "select_cancel";
        goto L6
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ik(JackViewModel r100, PropertyReference1Impl r101, com.larksuite.arch.jack.l r102, Function1 r103) {
        return JackView.a.a(this, r100, r101, r102, r103);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, com.larksuite.arch.jack.l r103, Function1 r104) {
        return JackView.a.b(this, r100, r101, r102, r103, r104);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, com.larksuite.arch.jack.l r104, Function1 r105) {
        return JackView.a.c(this, r100, r101, r102, r103, r104, r105);
    }
}
