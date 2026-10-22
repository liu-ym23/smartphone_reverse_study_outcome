package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment;
import com.ss.android.lark.filedetail.impl.folder.manage.service.ExtractConfig;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 K2\u00020\u0001:\u0001KB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020.H\u0016J&\u00102\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00107\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020.H\u0002J0\u0010@\u001a\u00020.2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020B2\b\b\u0002\u0010D\u001a\u00020B2\b\b\u0002\u0010E\u001a\u00020BH\u0002J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020B2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020BH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010,0+0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/ExtractPackageFragment;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/BaseFolderContentFragment;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "dependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/IExtractDependency;", "<init>", "(Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/IExtractDependency;)V", "extractProgressLayout", "Landroid/view/View;", "extractPackageSize", "Landroid/widget/TextView;", "extractProgress", "Lcom/larksuite/component/universe_design/progress/UDProgress;", "extractProgressDesc", "extractPackageTip", "loadingLayout", "loadingIV", "Landroid/widget/ImageView;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "loadingStatus", "", "retryLayout", "retrySize", "retryBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "failedLayout", "failedTip", "failedSize", "openWithOtherBtn", "packageCleanedLayout", "fileName", "viewModel", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/ExtractPackageViewModel;", "curFileKey", "", "progressObserver", "Landroidx/lifecycle/Observer;", "", "errorObserver", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "folderResponseObserver", "Lkotlin/Pair;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FolderPreviewResponse;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onActivityCreated", "onViewCreated", "view", "initView", "initExtractTip", "updatePackageSize", "size", "", "initClickListeners", "handleLayoutVisible", "loadingVisible", "", "progressVisible", "failedVisible", "retryVisible", "fetchData", "data", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "isCachedData", "onBackPressed", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtractPackageFragment extends BaseFolderContentFragment {
    public final com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.a A;
    public final b B;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FolderManageLaunchParams f421696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f421697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f421698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f421699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDProgress f421700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f421701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f421702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f421703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f421704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UDLoadingDrawable f421705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f421706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f421707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f421708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public UDButton f421709q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f421710r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f421711s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f421712t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public UDButton f421713u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f421714v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f421715w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ExtractPackageViewModel f421716x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f421717y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f421718z;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment
    public final boolean T90(nfb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return false;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.c
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        ExtractPackageViewModel r100 = this.f421716x;
        ExtractPackageViewModel r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.getProgressLiveData().removeObserver(this.f421718z);
        ExtractPackageViewModel r102 = this.f421716x;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L8:
        r102.getFolderResponseLiveData().removeObserver(this.B);
        ExtractPackageViewModel r103 = this.f421716x;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r101.onDestroy();
        super.onDestroy();
        return;
    L11:
        r101 = r103;
        goto L12
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment
    public final void S90(nfb.a r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        this.f421717y = r110.f518975a;
        String r100 = FileUtils.h(r110.f518978d);
        TextView r101 = this.f421699g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractPackageSize");
        r101 = null;
    L5:
        r101.setText(r100);
        TextView r102 = this.f421708p;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("retrySize");
        r102 = null;
    L8:
        r102.setText(r100);
        TextView r103 = this.f421712t;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("failedSize");
        r103 = null;
    L11:
        r103.setText(r100);
        U90(this, true, false, false, false, 14);
        this.f421697e.d();
        ExtractPackageViewModel r104 = this.f421716x;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        ExtractPackageViewModel r105 = null;
    L15:
        r105.requestExtractPackage(this.f421717y, r110.f518985k, this.f421696d.f421514u, r110.f518986l, this.f421697e.a().getFirst().longValue(), this.f421696d.f421499f);
        return;
    L14:
        r105 = r104;
        goto L15
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        ExtractPackageViewModel r101 = this.f421716x;
        ExtractPackageViewModel r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.getProgressLiveData().observe(getViewLifecycleOwner(), this.f421718z);
        ExtractPackageViewModel r103 = this.f421716x;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L8:
        r103.getErrorLiveData().observe(getViewLifecycleOwner(), this.A);
        ExtractPackageViewModel r104 = this.f421716x;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r102.getFolderResponseLiveData().observe(getViewLifecycleOwner(), this.B);
        return;
    L11:
        r102 = r104;
        goto L12
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ExtractPackageViewModel r101 = (ExtractPackageViewModel) new ViewModelProvider(this).get(ExtractPackageViewModel.class);
        this.f421716x = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.onCreate(this.f421717y, this.f421696d.f421513t);
    }

    public ExtractPackageFragment(FolderManageLaunchParams r100, com.ss.android.lark.filedetail.impl.folder.manage.page.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f421696d = r100;
        this.f421697e = r101;
        this.f421706n = -1;
        this.f421717y = r100.f421500g;
        this.f421718z = new f(this);
        this.A = new com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.a(this);
        this.B = new b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        StringBuilder r102 = new StringBuilder();
        List<String> r103 = ExtractConfig.f421788a.getExtractConfig().getSupportedFormat();
        Iterator<T> r104 = r103.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L12;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r102.append((String) r106);
        if (r105 >= CollectionsKt.getLastIndex(r103)) goto L11;
        r102.append(UIUtils.getString(getContext(), R.string.Lark_Legacy_ReactionSeparator));
    L11:
        r105 = r107;
        goto L4
    L12:
        String r108 = FileUtils.h(ExtractConfig.f421788a.getExtractConfig().getMaxExtractSize());
        TextView r109 = this.f421702j;
        UDLoadingDrawable r110 = null;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("extractPackageTip");
        r109 = null;
    L15:
        r109.setText(UIHelper.mustacheFormat(R.string.Lark_IMPreviewCompress_PreviewOnlyFileTypeLessG_Mobile_Toast, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Num", r108), TuplesKt.to("FileTypes", r102.toString())})));
        UDButton r111 = this.f421709q;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
        r111 = null;
    L18:
        r111.setOnClickListener(new d(this));
        UDButton r112 = this.f421713u;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("openWithOtherBtn");
        r112 = null;
    L21:
        r112.setOnClickListener(new e(this));
        UDLoadingDrawable r113 = new UDLoadingDrawable(this.mContext);
        r113.setColorSchemeColors(new int[]{UIUtils.getColor(this.mContext, R.color.primary_fill_default)});
        this.f421705m = r113;
        ImageView r114 = this.f421704l;
        if (r114 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("loadingIV");
        r114 = null;
    L24:
        UDLoadingDrawable r115 = this.f421705m;
        if (r115 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L28:
        r114.setImageDrawable(r110);
        return;
    L27:
        r110 = r115;
        goto L28
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_extract_package, r101, false);
        View r104 = r103.findViewById(R.id.extract_package_progress);
        this.f421698f = r104;
        View r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgressLayout");
        r104 = null;
    L5:
        ImageView r106 = (ImageView) r104.findViewById(R.id.file_icon);
        if (r106 == null) goto L8;
        r106.setImageResource(kac.a.b(R.drawable.ud_icon_file_zip_colorful));
    L8:
        this.f421699g = (TextView) r103.findViewById(R.id.extract_package_size);
        this.f421700h = (UDProgress) r103.findViewById(R.id.extract_progress);
        this.f421701i = (TextView) r103.findViewById(R.id.extract_progress_desc);
        this.f421702j = (TextView) r103.findViewById(R.id.extract_package_tip);
        this.f421703k = r103.findViewById(R.id.fetch_loading);
        this.f421704l = (ImageView) r103.findViewById(R.id.fetch_loading_iv);
        View r107 = r103.findViewById(R.id.extract_retry_layout);
        this.f421707o = r107;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
        r107 = null;
    L11:
        ImageView r108 = (ImageView) r107.findViewById(R.id.file_retry_icon);
        if (r108 == null) goto L14;
        r108.setImageResource(kac.a.b(R.drawable.ud_icon_file_zip_colorful));
    L14:
        this.f421708p = (TextView) r103.findViewById(R.id.extract_retry_size);
        this.f421709q = (UDButton) r103.findViewById(R.id.retry_btn);
        this.f421710r = r103.findViewById(R.id.extract_failed_layout);
        this.f421711s = (TextView) r103.findViewById(R.id.extract_failed_tip);
        this.f421712t = (TextView) r103.findViewById(R.id.extract_failed_size_tv);
        this.f421713u = (UDButton) r103.findViewById(R.id.open_btn);
        View r109 = r103.findViewById(R.id.extract_cleaned_fail_layout);
        this.f421714v = r109;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("packageCleanedLayout");
        r109 = null;
    L17:
        ImageView r110 = (ImageView) r109.findViewById(R.id.file_cleaned_icon);
        if (r110 == null) goto L20;
        r110.setImageResource(kac.a.b(R.drawable.ud_icon_file_zip_colorful));
    L20:
        View r111 = this.f421714v;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("packageCleanedLayout");
    L24:
        this.f421715w = (TextView) r105.findViewById(R.id.tv_file_name);
        return r103;
    L23:
        r105 = r111;
        goto L24
    }

    public static void U90(ExtractPackageFragment r100, boolean r101, boolean r102, boolean r103, boolean r104, int r110) {
        int r105 = 0;
        if ((r110 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r103 = false;
    L12:
        if ((r110 & 8) == 0) goto L14;
        r104 = false;
    L14:
        View r106 = null;
        if (r101 == false) goto L20;
        r100.f421706n = 2;
        View r107 = r100.f421703k;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r107 = null;
    L19:
        r107.postDelayed(new c(r100), 300);
    L27:
        View r108 = r100.f421698f;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgressLayout");
        r108 = null;
    L30:
        if (r102 == false) goto L32;
        int r109 = 0;
    L33:
        r108.setVisibility(r109);
        View r111 = r100.f421710r;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("failedLayout");
        r111 = null;
    L36:
        if (r103 == false) goto L38;
        int r112 = 0;
    L39:
        r111.setVisibility(r112);
        View r113 = r100.f421707o;
        if (r113 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L43:
        if (r104 == true) goto L46;
        r105 = 8;
    L46:
        r106.setVisibility(r105);
        return;
    L42:
        r106 = r113;
        goto L43
    L38:
        r112 = 8;
        goto L39
    L32:
        r109 = 8;
        goto L33
    L20:
        UDLoadingDrawable r114 = r100.f421705m;
        if (r114 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r114 = null;
    L23:
        r114.stop();
        View r115 = r100.f421703k;
        if (r115 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r115 = null;
    L26:
        r115.setVisibility(8);
        r100.f421706n = 1;
        goto L27
    }
}
