package com.larus.drive.biz.impl.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.activity.DriveFolderActivity;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapter;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapterFooterState;
import com.larus.drive.biz.impl.databinding.LarusDriveFileListBinding;
import com.larus.drive.biz.impl.dialog.DriveDownloadingDialog;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectActionType;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.DriveFolderListViewModel;
import com.larus.drive.biz.impl.viewmodel.DriveRecentListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.home.api.main.HomeService;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.u0;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001A\b&\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u000101J\u0006\u0010-\u001a\u00020>J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020D2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020>H\u0004J\b\u0010Q\u001a\u00020>H\u0016J\b\u0010R\u001a\u00020>H\u0016J\b\u0010S\u001a\u00020>H\u0002J\u0010\u0010T\u001a\u00020>2\b\b\u0002\u0010U\u001a\u00020\u000bJ\b\u0010V\u001a\u00020>H\u0002J\b\u0010W\u001a\u00020>H\u0014J\"\u0010X\u001a\u00020>2\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010Z2\b\b\u0002\u0010U\u001a\u00020\u000bJ\u0006\u0010]\u001a\u00020>J\u0010\u0010^\u001a\u00020>2\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010_\u001a\u00020>H\u0002J\b\u0010`\u001a\u00020>H\u0002J\b\u0010a\u001a\u00020>H\u0014J\b\u0010b\u001a\u00020>H\u0014J\u0016\u0010c\u001a\u00020>2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020408H\u0004J\u001c\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u0002042\n\b\u0002\u0010g\u001a\u0004\u0018\u00010DH\u0014J\u0014\u0010h\u001a\u0004\u0018\u00010D2\b\u0010g\u001a\u0004\u0018\u00010DH\u0002J\u0018\u0010i\u001a\u00020\u000b2\u0006\u0010f\u001a\u0002042\u0006\u0010L\u001a\u00020DH\u0014J\b\u0010j\u001a\u00020\u000bH\u0004J\u000e\u0010k\u001a\u00020>2\u0006\u0010l\u001a\u000204J\u0006\u0010m\u001a\u00020>J\u0010\u0010n\u001a\u00020>2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010o\u001a\u00020>2\u0006\u0010f\u001a\u000204H\u0002J\b\u0010p\u001a\u00020>H\u0002J\u000e\u0010q\u001a\u00020>2\u0006\u0010r\u001a\u00020sJ\u0006\u0010t\u001a\u00020>J\u0010\u0010u\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020sH\u0002J\u0016\u0010v\u001a\u00020>2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020408H\u0002J\n\u0010w\u001a\u0004\u0018\u00010xH\u0002J\u0018\u0010y\u001a\u00020>2\u0006\u0010f\u001a\u0002042\u0006\u0010z\u001a\u00020DH\u0002J\u0010\u0010{\u001a\u00020>2\u0006\u0010|\u001a\u000201H\u0014J\b\u0010}\u001a\u00020>H\u0016J\b\u0010~\u001a\u00020>H\u0016J\b\u0010\u007f\u001a\u000201H\u0014J\t\u0010\u0080\u0001\u001a\u00020\u000bH\u0014J\t\u0010\u0081\u0001\u001a\u00020\u000bH\u0014J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u00010DH\u0014J\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010)H\u0004J\u000b\u0010\u0084\u0001\u001a\u0004\u0018\u00010)H\u0002J\u000f\u0010\u0085\u0001\u001a\u00020AH\u0002¢\u0006\u0003\u0010\u0086\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00102\u001a\u001e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020403j\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000204`5X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R#\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u000101088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010[\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDriveFileListBinding;", "getBinding", "()Lcom/larus/drive/biz/impl/databinding/LarusDriveFileListBinding;", "setBinding", "(Lcom/larus/drive/biz/impl/databinding/LarusDriveFileListBinding;)V", "isViewModelSetup", "", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "getViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "setViewModel", "(Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;)V", "adapter", "Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;", "getAdapter", "()Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;", "setAdapter", "(Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;)V", "isLoadingMoreState", "()Z", "setLoadingMoreState", "(Z)V", "hasMoreState", "getHasMoreState", "setHasMoreState", "isOnStart", "setOnStart", "hasTriggeredFirstVisibleLoad", "pendingHostTabActivationForbidLoadingAnim", "Ljava/lang/Boolean;", "isDownloading", "driveDownloadingDialog", "Lcom/larus/drive/biz/impl/dialog/DriveDownloadingDialog;", "parentMainFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/larus/drive/biz/impl/view/DriveMainFragment;", "recyclerViewOriginalPaddingBottom", "", "Ljava/lang/Integer;", "forbidLoadingPullAnimOnce", "inSelectMode", "selectedTokens", "Ljava/util/LinkedHashSet;", "", "selectedFilesByToken", "Ljava/util/LinkedHashMap;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlin/collections/LinkedHashMap;", "tempEventShowFromParam", "fileCanNotSupportPreview", "", "getFileCanNotSupportPreview", "()Ljava/util/List;", "fileCanNotSupportPreview$delegate", "Lkotlin/Lazy;", "setEventShowFromParam", "", "showFrom", "driveFileListAdapterEventCallback", "com/larus/drive/biz/impl/view/AbsDriveListFragment$getDriveFileListAdapterEventCallback$1", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment$getDriveFileListAdapterEventCallback$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "loadLocalInitialData", WidgetCostModule.TYPE_ON_START, "onStop", "initDriveSdk", "onHostTabActivated", "forbidLoadingAnim", "consumePendingHostTabActivationIfNeeded", "setupViewModel", "refreshFiles", "onRefreshTriggered", "Lkotlin/Function0;", "lastScrollToTopAndReloadTime", "", "scrollToTopAndReload", "handleDownloadingState", "setupRecyclerView", "setupSwipeRefresh", "setupUploadBanner", "loadInitialData", "updateFileList", KevaImpl.PrivateConstants.FILES_DIR_NAME, "onFileClick", "file", "itemView", "getDrivePreviewStartView", "onFileLongClick", "isInSelectMode", "enterSelectMode", "initial", "exitSelectMode", "updateRecyclerViewBottomPadding", "toggleSelected", "notifySelectedFilesChanged", "handleSelectPanelAction", ReportConstant.COMMON_ACTION_TYPE, "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "exitSelectModeAfterActionConfirmed", "shouldExitSelectModeImmediately", "syncSelectedFileCacheFromList", "getSelectModeHost", "Lcom/larus/drive/biz/impl/view/fileselect/IDrivePageSelectMode;", "showDriveLongClickMenu", "anchorView", "showErrorState", "errorMessage", "onDestroyView", "onDetach", "getTagName", "provideIsDialogMode", "showUploadBanner", "getEmptyView", "getDriveMainFragment", "resolveDriveMainFragment", "getDriveFileListAdapterEventCallback", "()Lcom/larus/drive/biz/impl/view/AbsDriveListFragment$getDriveFileListAdapterEventCallback$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDriveListFragment extends Fragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f341284y = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDriveFileListBinding f341285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f341286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AbsDriveListViewModel f341287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DriveFileListAdapter f341288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f341289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f341290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f341291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f341292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f341293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f341294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DriveDownloadingDialog f341295n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference<DriveMainFragment> f341296o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f341297p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f341298q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f341299r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedHashSet<String> f341300s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinkedHashMap<String, DriveFileItem> f341301t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f341302u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f341303v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t f341304w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f341305x;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341306a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f341307b = null;

        static {
            int[] r100 = new int[DriveFileListAdapterFooterState.values().length];
            r100[DriveFileListAdapterFooterState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[DriveFileListAdapterFooterState.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            f341306a = r100;
            int[] r101 = new int[DriveSelectActionType.values().length];
            r101[DriveSelectActionType.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L37:
            r101[DriveSelectActionType.RENAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L29:
            r101[DriveSelectActionType.ASK_AI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r101[DriveSelectActionType.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L23:
            r101[DriveSelectActionType.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L33:
            r101[DriveSelectActionType.MOVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L13:
            f341307b = r101;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f341308a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f341308a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f341308a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f341308a.invoke(r100);
        }
    }

    public static final class d implements s79.a {
        public d() {
        }

        @Override // s79.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileToken");
            com.larus.drive.biz.impl.utils.f.a(r100);
        }

        @Override // s79.a
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "fileToken");
            Intrinsics.checkNotNullParameter(r101, "newFileName");
            com.larus.drive.biz.impl.utils.f.b(r100, r101);
        }
    }

    static {
    }

    public String V90() {
        return "AbsDriveFragment";
    }

    public boolean ca0() {
        return false;
    }

    public final DriveMainFragment S90() {
        WeakReference<DriveMainFragment> r100 = this.f341296o;
        WeakReference<DriveMainFragment> r101 = null;
        if (r100 == null) goto L5;
        DriveMainFragment r102 = r100.get();
    L6:
        if (r102 != null) goto L8;
    L10:
        Fragment r103 = getParentFragment();
    L11:
        if (r103 == null) goto L16;
        if ((r103 instanceof DriveMainFragment) == true) goto L14;
        r103 = r103.getParentFragment();
        goto L11
    L14:
        DriveMainFragment r104 = (DriveMainFragment) r103;
    L17:
        if (r104 != null) goto L19;
        WeakReference<DriveMainFragment> r105 = DriveMainFragment.f341322w;
        r104 = DriveMainFragment.a.a();
    L19:
        if (r104 == null) goto L21;
        r101 = new WeakReference(r104);
    L21:
        this.f341296o = r101;
        return r104;
    L16:
        r104 = null;
        goto L17
    L8:
        if (r102.isAdded() == false) goto L10;
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public View T90() {
        LarusDriveFileListBinding r100 = this.f341285d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f341114b;
    }

    public final AbsDriveListViewModel W90() {
        AbsDriveListViewModel r100 = this.f341287f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void ea0() {
        if (this.f341286e == true) goto L5;
        return;
    L5:
        long r100 = SystemClock.elapsedRealtime();
        if ((r100 - this.f341305x) >= 1000) goto L8;
        return;
    L8:
        this.f341305x = r100;
        LarusDriveFileListBinding r101 = this.f341285d;
        if (r101 == null) goto L11;
        RecyclerView r102 = r101.f341117e;
    L12:
        if (r102 == null) goto L14;
        r102.stopScroll();
    L14:
        if (r102 == null) goto L16;
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
    L18:
        if ((r103 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r104 = (LinearLayoutManager) r103;
    L22:
        if (r104 == null) goto L24;
        r104.scrollToPositionWithOffset(0, 0);
    L24:
        AbsDriveListViewModel.loadFiles$default(W90(), null, false, 3, null);
        return;
    L20:
        r104 = null;
        goto L22
    L16:
        r103 = null;
        goto L18
    L11:
        r102 = null;
        goto L12
    }

    public void fa0() {
        if ((!(this instanceof DriveMoveListFragment)) == true) goto L5;
        return;
    L5:
        com.larus.drive.biz.impl.file.t.f341219f.observe(getViewLifecycleOwner(), new c(new s(this)));
    }

    public final void j() {
        if (this.f341299r == true) goto L5;
        return;
    L5:
        this.f341299r = false;
        this.f341300s.clear();
        this.f341301t.clear();
        DriveFileListAdapter r100 = this.f341288g;
        if (r100 == null) goto L8;
        r100.C0(SetsKt.emptySet());
    L8:
        DriveFileListAdapter r101 = this.f341288g;
        if (r101 == null) goto L11;
        r101.t0(false);
    L11:
        ha0(false);
        Y90();
    }

    public AbsDriveListFragment() {
        this.f341290i = true;
        this.f341300s = new LinkedHashSet();
        this.f341301t = new LinkedHashMap();
        this.f341303v = LazyKt.lazy(new q());
        this.f341304w = new t(this);
    }

    public final o79.g U90() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof o79.g) == true) goto L5;
        KeyEventDispatcher.Component r101 = getActivity();
        if ((r101 instanceof o79.g) == true) goto L9;
        WeakReference<DriveMainFragment> r102 = DriveMainFragment.f341322w;
        return DriveMainFragment.a.a();
    L9:
        return (o79.g) r101;
    L5:
        return (o79.g) r100;
    }

    public final void Y90() {
        o79.g r100 = U90();
        if (r100 == null) goto L6;
        r100.F70(CollectionsKt.toList(this.f341301t.values()));
        return;
    }

    public void ga0() {
        W90().setForbidLoadingAnimFunc(new com.larus.drive.biz.impl.view.a(this));
        W90().getFiles().observe(getViewLifecycleOwner(), new c(new k(this)));
        W90().isLoading().observe(getViewLifecycleOwner(), new c(new l(this)));
        W90().getLoadMoreState().observe(getViewLifecycleOwner(), new c(new m(this)));
        W90().getHasMore().observe(getViewLifecycleOwner(), new c(new n(this)));
        W90().isDownloading().observe(getViewLifecycleOwner(), new c(new o(this)));
        W90().getErrorMessage().observe(getViewLifecycleOwner(), new c(new p(this)));
        DriveSdkService.f341224a.k(new d());
        this.f341286e = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.f375446a.i(V90(), "[onDestroyView] Cleaning up");
        this.f341292k = false;
        LarusDriveFileListBinding r100 = this.f341285d;
        if (r100 == null) goto L7;
        RecyclerView r101 = r100.f341117e;
        if (r101 == null) goto L7;
        r101.setAdapter(null);
    L7:
        this.f341300s.clear();
        this.f341301t.clear();
        this.f341299r = false;
        this.f341297p = null;
        this.f341285d = null;
        this.f341288g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f341296o = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f341291j = true;
        Boolean r100 = this.f341293l;
        if (r100 == null) goto L9;
        boolean r101 = r100.booleanValue();
        if (this.f341286e == false) goto L10;
        this.f341293l = null;
        ba0(r101);
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f341291j = false;
    }

    public final void X90(DriveSelectActionType r100) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        List<DriveFileItem> r101 = CollectionsKt.toList(this.f341301t.values());
        if (r101.isEmpty() == false) goto L6;
        return;
    L6:
        switch(b.f341307b[r100.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L15;
        o79.g r103 = U90();
        if (r103 == null) goto L15;
        r103.j();
    L15:
        W90().handleSelectPanelAction(r100, this, r101);
        return;
    L10:
        r102 = false;
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void ba0(boolean r100) {
        if (this.f341286e == true) goto L6;
        this.f341293l = Boolean.valueOf(r100);
        return;
    L6:
        this.f341293l = null;
        if (this.f341292k == true) goto L13;
        this.f341292k = true;
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L11;
        IOfficeSdkServiceV2.a.b(r101, false, "drive_list", 5);
    L11:
        AbsDriveListViewModel.loadFiles$default(W90(), null, false, 3, null);
        return;
    L13:
        da0(this, r100, 1);
    }

    public final void ha0(boolean r100) {
        LarusDriveFileListBinding r101 = this.f341285d;
        if (r101 == null) goto L21;
        RecyclerView r102 = r101.f341117e;
        if (r102 == null) goto L22;
        Integer r103 = this.f341297p;
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
    L11:
        if (r100 == true) goto L13;
    L19:
        r102.setPaddingRelative(r102.getPaddingStart(), r102.getPaddingTop(), r102.getPaddingEnd(), r104);
        return;
    L13:
        if ((W90() instanceof DriveFolderListViewModel) == false) goto L15;
    L18:
        r104 = ((Number) i5.L0.getValue()).intValue();
        goto L19
    L15:
        if (HomeService.f344094a.o() == true) goto L18;
        r104 = i5.l0();
        goto L19
    L10:
        r104 = r102.getPaddingBottom();
        this.f341297p = Integer.valueOf(r104);
        goto L11
    L22:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        Fragment r101 = getParentFragment();
    L3:
        WeakReference<DriveMainFragment> r102 = null;
        if (r101 == null) goto L9;
        if ((r101 instanceof DriveMainFragment) == true) goto L7;
        r101 = r101.getParentFragment();
        goto L3
    L7:
        DriveMainFragment r103 = (DriveMainFragment) r101;
    L10:
        if (r103 == null) goto L12;
        r102 = new WeakReference(r103);
    L12:
        this.f341296o = r102;
        return;
    L9:
        r103 = null;
        goto L10
    }

    public void Z90(DriveFileItem r110, View r111) {
        Intrinsics.checkNotNullParameter(r110, "file");
        if (this.f341299r == false) goto L16;
        String r112 = r110.f341565b;
        if (StringsKt.isBlank(r112) == false) goto L8;
        return;
    L8:
        if (this.f341300s.contains(r112) == false) goto L10;
        this.f341300s.remove(r112);
        this.f341301t.remove(r112);
    L11:
        DriveFileListAdapter r113 = this.f341288g;
        if (r113 == null) goto L14;
        r113.C0(new HashSet(this.f341300s));
    L14:
        Y90();
        return;
    L10:
        this.f341300s.add(r112);
        this.f341301t.put(r112, r110);
        goto L11
    L16:
        FLogger.f375446a.i(V90(), "File clicked: " + r110.f341564a + " (token: " + r110.f341565b + ')');
        String r100 = null;
        if (r110.f341573j != DriveFileType.FOLDER) goto L28;
        int r114 = DriveFolderActivity.f341042g;
        Context r115 = getContext();
        String r101 = r110.f341565b;
        String r102 = r110.f341566c;
        String r116 = r110.f341564a;
        JSONObject r103 = new JSONObject();
        DriveMainFragment r104 = S90();
        if (r104 == null) goto L23;
        Bundle r105 = r104.getArguments();
        if (r105 == null) goto L23;
        String r106 = r105.getString("previous_page");
    L24:
        r103.put("previous_page", r106);
        if (S90() == null) goto L27;
        r100 = "ai_space_list";
    L27:
        r103.put("current_page", r100);
        Unit r107 = Unit.INSTANCE;
        DriveFolderActivity.a.a(r115, r101, r102, r116, r103);
        return;
    L23:
        r106 = null;
        goto L24
    L28:
        Context r108 = getContext();
        if (r108 != null) goto L31;
        return;
    L31:
        if ((this instanceof DriveRecentListFragment) == false) goto L35;
        PreviewFromPage r109 = PreviewFromPage.RECENT;
    L33:
        PreviewFromPage r117 = r109;
        DriveSdkService r118 = DriveSdkService.f341224a;
        LifecycleCoroutineScope r119 = LifecycleOwnerKt.getLifecycleScope(this);
        DriveFileListAdapter r120 = this.f341288g;
        boolean r121 = true;
        if (r120 == null) goto L52;
        List<DriveFileItem> r122 = r120.getCurrentList();
        if (r122 == null) goto L52;
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r122.iterator();
    L47:
        if (r124.hasNext() == false) goto L51;
        Object r125 = r124.next();
        if ((!((List) this.f341303v.getValue()).contains(((DriveFileItem) r125).d(true).toLowerCase(Locale.ROOT))) == false) goto L47;
        r123.add(r125);
        goto L47
    L51:
        ArrayList r126 = r123;
    L53:
        AbsDriveListViewModel r127 = W90();
        if (r111 == null) goto L56;
        View r128 = r111.findViewById(R.id.larus_drive_file_thumbnail);
    L57:
        if (r128 != null) goto L59;
    L61:
        r121 = false;
    L62:
        if (r121 == false) goto L64;
        View r129 = r128;
    L68:
        r118.m(new z79.b(r108, r110, r119, r126, r117, r127, r129), null);
        return;
    L64:
        if (r111 == null) goto L66;
        View r130 = r111.findViewById(R.id.larus_drive_file_icon);
    L67:
        r129 = r130;
        goto L68
    L66:
        r130 = null;
        goto L67
    L59:
        if (r128.getVisibility() != 0) goto L61;
    L56:
        r128 = null;
    L52:
        r126 = null;
        goto L53
    L35:
        if ((this instanceof DriveMineListFragment) == false) goto L37;
    L40:
        r109 = PreviewFromPage.MINE;
        goto L33
    L37:
        if ((this instanceof DriveFolderListFragment) == true) goto L40;
        r109 = PreviewFromPage.UNKNOWN;
        goto L33
    }

    public boolean aa0(final DriveFileItem r210, View r211) {
        Intrinsics.checkNotNullParameter(r210, "file");
        Intrinsics.checkNotNullParameter(r211, "view");
        if (this.f341299r == false) goto L5;
        return true;
    L5:
        FLogger.f375446a.i(V90(), "File long clicked: " + r210.f341564a + " (token: " + r210.f341565b + ')');
        View r100 = r211.findViewById(R.id.larus_drive_file_item_container);
        if (r100 != null) goto L8;
        final View r101 = r211;
    L9:
        r101.setPressed(false);
        r101.invalidate();
        final Drawable r102 = r101.getBackground();
        r101.setBackgroundResource(R.drawable.larus_bg_drive_list_item_container);
        r101.draw(new Canvas(Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_8888)));
        r101.post(new f(r101, r102));
        final x0 r110 = new x0();
        r110.d(this);
        r110.i(new g());
        final View r103 = r101;
        Function0<? extends View> r111 = new h(r103, this, r210, this, r110);
        Intrinsics.checkNotNullParameter(r101, "anchor");
        Intrinsics.checkNotNullParameter(r111, "menuViewHolder");
        Bitmap r104 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_8888);
        r101.draw(new Canvas(r104));
        r110.j(r101, false, r104, r111);
        String r105 = r210.f341565b;
        String r106 = r210.f341564a;
        String r107 = com.larus.drive.biz.impl.utils.e.f341259a;
        u0.e(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, null, null, null, null, null, r105, r106, com.larus.drive.biz.impl.utils.e.c(r210.f341573j), com.larus.drive.biz.impl.utils.e.b(r210), null, S90(), 1086);
        return true;
    L8:
        r101 = r100;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.drive.biz.impl.view.b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.drive.biz.impl.view.c] */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        FLogger.f375446a.i(V90(), "[onViewCreated] Initialize");
        ga0();
        DriveFileListAdapter r112 = new DriveFileListAdapter(W90(), new com.larus.drive.biz.impl.view.b(this), new com.larus.drive.biz.impl.view.c(this), ca0(), W90() instanceof DriveRecentListViewModel, getViewLifecycleOwner(), this.f341304w);
        String r113 = this.f341302u;
        SimpleItemAnimator r100 = null;
        if (r113 == null) goto L5;
        r112.f341074k = r113;
        this.f341302u = null;
    L5:
        this.f341288g = r112;
        LarusDriveFileListBinding r114 = this.f341285d;
        if (r114 == null) goto L15;
        RecyclerView r115 = r114.f341117e;
        if (r115 == null) goto L15;
        r115.setLayoutManager(new LinearLayoutManager(r115.getContext()));
        r115.setAdapter(this.f341288g);
        RecyclerView.ItemAnimator r101 = r115.getItemAnimator();
        if ((r101 instanceof SimpleItemAnimator) == false) goto L12;
        r100 = (SimpleItemAnimator) r101;
    L12:
        if (r100 == null) goto L14;
        r100.setSupportsChangeAnimations(false);
    L14:
        this.f341297p = Integer.valueOf(r115.getPaddingBottom());
        r115.addOnScrollListener(new AbsDriveListFragment$setupRecyclerView$4$1(this));
    L15:
        LarusDriveFileListBinding r116 = this.f341285d;
        if (r116 == null) goto L20;
        SwipeRefreshLayout r117 = r116.f341116d;
        if (r117 == null) goto L20;
        r117.setColorSchemeColors(new int[]{ContextCompat.getColor(r117.getContext(), v19.c.b(R.attr.larus_primary_50, r117.getContext(), R.color.larus_primary_50))});
        r117.setOnRefreshListener(new r(this));
    L20:
        fa0();
    }

    public static void da0(AbsDriveListFragment r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if (r100.f341286e == false) goto L10;
        r100.W90().refreshFiles(null, r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_drive_file_list, r111, false);
        int r114 = R.id.larus_drive_empty_view;
        LinearLayout r100 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.larus_drive_empty_view);
        if (r100 == null) goto L25;
        r114 = R.id.larus_drive_move_empty_view;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.larus_drive_move_empty_view);
        if (r101 == null) goto L25;
        r114 = R.id.larus_drive_pull_refresh;
        SwipeRefreshLayout r102 = (SwipeRefreshLayout) ViewBindings.findChildViewById(r113, R.id.larus_drive_pull_refresh);
        if (r102 == null) goto L25;
        r114 = R.id.larus_drive_recycler_view;
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.larus_drive_recycler_view);
        if (r103 == null) goto L25;
        r114 = R.id.larus_drive_upload_banner;
        CardView r104 = (CardView) ViewBindings.findChildViewById(r113, R.id.larus_drive_upload_banner);
        if (r104 == null) goto L25;
        r114 = R.id.larus_drive_upload_banner_close;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r113, R.id.larus_drive_upload_banner_close);
        if (r105 == null) goto L25;
        r114 = R.id.larus_drive_upload_banner_success;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r113, R.id.larus_drive_upload_banner_success);
        if (r106 == null) goto L25;
        r114 = R.id.larus_drive_upload_banner_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.larus_drive_upload_banner_text);
        if (r107 == null) goto L25;
        r114 = R.id.larus_drive_upload_banner_uploading;
        ProgressBar r115 = (ProgressBar) ViewBindings.findChildViewById(r113, R.id.larus_drive_upload_banner_uploading);
        if (r115 == null) goto L25;
        r114 = R.id.larus_drive_upload_banner_warning;
        ImageView r116 = (ImageView) ViewBindings.findChildViewById(r113, R.id.larus_drive_upload_banner_warning);
        if (r116 == null) goto L25;
        ConstraintLayout r117 = (ConstraintLayout) r113;
        this.f341285d = new LarusDriveFileListBinding(r117, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        return r117;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
