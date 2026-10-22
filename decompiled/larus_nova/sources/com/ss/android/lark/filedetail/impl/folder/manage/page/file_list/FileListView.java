package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010*\u0001@\u0018\u0000 c2\u00020\u0001:\u0004cdefB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020JH\u0002J\b\u0010L\u001a\u00020;H\u0002J\u0012\u0010M\u001a\u00020J2\b\u0010N\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010O\u001a\u00020JH\u0002J\b\u0010P\u001a\u00020JH\u0002J\u0018\u0010Q\u001a\u00020J2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010SH\u0016J\u0010\u0010U\u001a\u00020J2\u0006\u0010V\u001a\u00020WH\u0016J\u001a\u0010X\u001a\u00020J2\u0006\u0010Y\u001a\u00020;2\b\u0010Z\u001a\u0004\u0018\u00010FH\u0016J \u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020WH\u0016J\b\u0010_\u001a\u00020JH\u0016J\b\u0010`\u001a\u00020JH\u0016J\u0012\u0010a\u001a\u00020J2\b\u0010b\u001a\u0004\u0018\u00010>H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001e\u0010+\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/IView;", "mContext", "Landroid/content/Context;", "mDependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$IViewDependency;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$IViewDependency;Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;)V", "mFileListRv", "Landroidx/recyclerview/widget/RecyclerView;", "getMFileListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setMFileListRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mPtrView", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "getMPtrView", "()Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "setMPtrView", "(Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;)V", "mContentLayout", "Landroid/view/ViewGroup;", "getMContentLayout", "()Landroid/view/ViewGroup;", "setMContentLayout", "(Landroid/view/ViewGroup;)V", "mLoadingLayout", "Landroid/view/View;", "getMLoadingLayout", "()Landroid/view/View;", "setMLoadingLayout", "(Landroid/view/View;)V", "loadingIv", "Landroid/widget/ImageView;", "getLoadingIv", "()Landroid/widget/ImageView;", "setLoadingIv", "(Landroid/widget/ImageView;)V", "mEmptyLayout", "getMEmptyLayout", "setMEmptyLayout", "mEmptyIv", "getMEmptyIv", "setMEmptyIv", "mEmptyHint", "Landroid/widget/TextView;", "getMEmptyHint", "()Landroid/widget/TextView;", "setMEmptyHint", "(Landroid/widget/TextView;)V", "mAdapter", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mLoadingStatus", "", "itemLayoutType", "mViewDelegate", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/IView$Delegate;", "switchAction", "com/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$switchAction$2$1", "getSwitchAction", "()Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$switchAction$2$1;", "switchAction$delegate", "Lkotlin/Lazy;", "chatId", "", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "create", "", "initView", "getSwitchLayoutResId", "switchItemLayout", "view", "initRecyclerView", "initPullToRefresh", "updateFileList", "list", "", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "updateTitleBar", "isDownload", "", "showError", "errorCode", "displayMsg", "handleLoadingStatus", "listVisible", "loadingVisible", "emptyVisible", "finishLoadMore", MapMonitorConst.EVENT_DESTROY, "setViewDelegate", "viewDelegate", "Companion", "IViewDependency", "LoadingStatus", "SpaceItemDecoration", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileListView implements j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f421737m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f421739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FolderManageLaunchParams f421740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileInfoAdapter f421741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayoutManager f421742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GridLayoutManager f421743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f421744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f421745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j.a f421746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f421747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f421748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDLoadingDrawable f421749l;

    @BindView(9355)
    public ImageView loadingIv;

    @BindView(9182)
    public ViewGroup mContentLayout;

    @BindView(9304)
    public TextView mEmptyHint;

    @BindView(9305)
    public ImageView mEmptyIv;

    @BindView(9357)
    public View mEmptyLayout;

    @BindView(9363)
    public RecyclerView mFileListRv;

    @BindView(9354)
    public View mLoadingLayout;

    @BindView(9940)
    public LKUIPtrClassicFrameLayout mPtrView;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$LoadingStatus;", "", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LoadingStatus {
        public static final a Companion = null;
        public static final int HIDE = 1;
        public static final int LOADING_DELAY = 2;
        public static final int UNKNOWN = -1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f421750a = null;

            static {
                f421750a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f421750a;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", GXTemplateKey.FLEXBOX_MARGIN, "dataProvider", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/SpaceItemDataProvider;", "<init>", "(Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView;IILcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/SpaceItemDataProvider;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f421751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f421752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f421753c;

        public SpaceItemDecoration(int r100, int r101, g r102) {
            Intrinsics.checkNotNullParameter(r102, "dataProvider");
            this.f421751a = r100;
            this.f421752b = r101;
            this.f421753c = r102;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, int r101, RecyclerView r102) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r102, "parent");
            if (this.f421753c.a() != 0) goto L5;
            return;
        L5:
            int r103 = this.f421751a;
            int r104 = r101 / r103;
            int r105 = r101 % r103;
            if (r104 != 0) goto L8;
            r100.top = UIUtils.dp2px(r102.getContext(), 20.0f);
        L8:
            int r106 = this.f421752b;
            int r107 = this.f421751a;
            r100.left = r106 - ((r105 * r106) / r107);
            r100.right = ((r105 + 1) * r106) / r107;
        }
    }

    public static final class a {
    }

    public interface b {
        Triple<Long, Integer, Integer> a();

        void b(boolean r100, FileListView$switchAction$2.a r101);

        void c();

        void d(nfb.a r100);

        void e(j r100);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileListView f421754a;

        public c(FileListView r100) {
            this.f421754a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileListView r100 = this.f421754a;     // Catch: Throwable -> L14
            if (r100.f421744g != 2) goto L17;
            UDLoadingDrawable r101 = r100.f421749l;     // Catch: Throwable -> L14
            View r102 = null;
            if (r101 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");     // Catch: Throwable -> L14
            r101 = null;
        L8:
            r101.start();     // Catch: Throwable -> L14
            View r103 = this.f421754a.mLoadingLayout;     // Catch: Throwable -> L14
            if (r103 == null) goto L11;
            r102 = r103;
        L12:
            r102.setVisibility(0);     // Catch: Throwable -> L14
            return;
        L11:
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingLayout");     // Catch: Throwable -> L14
            goto L12
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f421739b.e(this);
        j.a r100 = this.f421746i;
        if (r100 == null) goto L5;
        int r101 = r100.M();
    L6:
        this.f421745h = r101;
        ChatWindowPtrLoadingHeader r102 = new ChatWindowPtrLoadingHeader(this.f421738a);
        k().setKeepHeaderWhenRefresh(true);
        k().setFooterView(r102);
        k().addPtrUIHandler(r102);
        k().disableWhenHorizontalMove(true);
        k().setPtrHandler(new e(this));
        FileInfoAdapter r103 = new FileInfoAdapter();
        this.f421741d = r103;
        r103.f421661b = this.f421745h;
        f r104 = new f(this);
        Intrinsics.checkNotNullParameter(r104, "listener");
        r103.f421660a = r104;
        this.f421742e = new LinearLayoutManager(this.f421738a, 1, false);
        int r105 = this.f421739b.a().getSecond().intValue();
        int r106 = this.f421739b.a().getThird().intValue();
        this.f421743f = new GridLayoutManager(this.f421738a, r105, 1, false);
        SpaceItemDecoration r107 = new SpaceItemDecoration(r105, r106, new g(this));
        RecyclerView r108 = h();
        UDLoadingDrawable r109 = null;
        if (this.f421741d == null) goto L13;
        zdc.h.b(r108);
        r108.setItemAnimator(null);
        if (this.f421745h != 1) goto L11;
        RecyclerView.LayoutManager r110 = this.f421743f;
    L12:
        r108.setLayoutManager(r110);
        r108.addItemDecoration(r107);
        r108.setAdapter(this.f421741d);
        goto L13
    L11:
        r110 = this.f421742e;
    L13:
        k();
        h();
        int r111 = DesktopUtil.f420394a;
        UDLoadingDrawable r112 = new UDLoadingDrawable(this.f421738a);
        r112.setColorSchemeColors(new int[]{UIUtils.getColor(this.f421738a, R.color.primary_fill_default)});
        this.f421749l = r112;
        ImageView r113 = this.loadingIv;
        if (r113 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("loadingIv");
        r113 = null;
    L17:
        UDLoadingDrawable r114 = this.f421749l;
        if (r114 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L21:
        r113.setImageDrawable(r109);
        return;
    L20:
        r109 = r114;
        goto L21
    L5:
        r101 = 0;
        goto L6
    }

    public final RecyclerView h() {
        RecyclerView r100 = this.mFileListRv;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFileListRv");
        return null;
    }

    public final LKUIPtrClassicFrameLayout k() {
        LKUIPtrClassicFrameLayout r100 = this.mPtrView;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPtrView");
        return null;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void n() {
        if (k().isRefreshing() == false) goto L6;
        k().refreshComplete();
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void J0(List<nfb.a> r100) {
        List<nfb.a> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        ImageView r103 = this.mEmptyIv;
        TextView r104 = null;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyIv");
        r103 = null;
    L14:
        r103.setImageResource(R.drawable.illustration_placeholder_common_no_file);
        TextView r105 = this.mEmptyHint;
        if (r105 == null) goto L17;
        r104 = r105;
    L18:
        r104.setText(UIHelper.getString(R.string.Lark_Legacy_PullEmptyResult));
        T3(false, false, true);
        return;
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyHint");
        goto L18
    L20:
        T3(true, false, false);
        FileInfoAdapter r106 = this.f421741d;
        if (r106 == null) goto L24;
        r106.diff(r101);
        return;
    L24:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void Q5(boolean r100) {
        this.f421739b.b(r100, (FileListView$switchAction$2.a) this.f421747j.getValue());
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        j.a r101 = (j.a) r100;
        if (r101 == null) goto L7;
        this.f421746i = r101;
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void h6(int r100, String r101) {
        ImageView r102 = this.mEmptyIv;
        TextView r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyIv");
        r102 = null;
    L6:
        r102.setImageResource(R.drawable.illustration_placeholder_common_load_failed);
        TextView r104 = this.mEmptyHint;
        if (r104 == null) goto L9;
        r103 = r104;
    L11:
        if (r100 != 5607) goto L21;
        if (r101 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L21;
    L24:
        r103.setText(r101);
        T3(false, false, true);
        return;
    L14:
        if (r101.length() == 0) goto L17;
        r105 = false;
    L21:
        if (com.ss.android.lark.widget.utils.e.a(r100) == false) goto L23;
        this.f421739b.c();
        r101 = UIHelper.getString(R.string.Lark_IM_ViewOrDownloadFile_FileDeleted_Text);
        goto L24
    L23:
        r101 = UIHelper.getString(R.string.Lark_Legacy_FailedtoLoadTryLater);
        goto L24
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyHint");
        goto L11
    }

    public FileListView(Context r100, FileListFragment.a r101, FolderManageLaunchParams r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mDependency");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f421738a = r100;
        this.f421739b = r101;
        this.f421740c = r102;
        this.f421744g = -1;
        this.f421747j = LazyKt.lazy(new FileListView$switchAction$2(this));
        String r103 = r102.f421503j;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        String r105 = r102.f421503j;
    L12:
        this.f421748k = r105;
        return;
    L11:
        r105 = r102.f421495b;
        goto L12
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void T3(boolean r100, boolean r101, boolean r102) {
        RecyclerView r103 = h();
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        r103.setVisibility(r104);
        View r105 = null;
        if (r101 == false) goto L13;
        this.f421744g = 2;
        View r106 = this.mLoadingLayout;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingLayout");
        r106 = null;
    L12:
        r106.postDelayed(new c(this), 300);
    L22:
        if (r102 == false) goto L32;
        View r107 = this.mEmptyLayout;
        if (r107 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        r107 = null;
    L27:
        r107.setVisibility(0);
        View r108 = this.mEmptyLayout;
        if (r108 == null) goto L30;
        r105 = r108;
    L31:
        UIUtils.setViewOnScreenOneThirdPlaceByTranslationY(r105);
        return;
    L30:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        goto L31
    L32:
        View r109 = this.mEmptyLayout;
        if (r109 == null) goto L35;
        r105 = r109;
    L36:
        r105.setVisibility(8);
        return;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        goto L36
    L13:
        UDLoadingDrawable r110 = this.f421749l;
        if (r110 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r110 = null;
    L16:
        r110.stop();
        View r111 = this.mLoadingLayout;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingLayout");
        r111 = null;
    L20:
        r111.setVisibility(8);
        this.f421744g = 1;
        goto L22
    L5:
        r104 = 8;
        goto L6
    }
}
