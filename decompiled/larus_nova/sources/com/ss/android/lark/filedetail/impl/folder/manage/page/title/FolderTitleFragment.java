package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.breadcrumb.UDBreadcrumb;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.android.lark.filedetail.impl.folder.manage.page.FolderManageActivity;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView$switchAction$2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001e\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020+H\u0002J\b\u00100\u001a\u00020+H\u0002J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u000108J\u0006\u00109\u001a\u00020+J\u000e\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aJ\b\u0010<\u001a\u0004\u0018\u00010\u001aJ\b\u0010=\u001a\u00020\u0014H\u0016J\u0010\u0010>\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aH\u0002J0\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020A2\u001e\u0010B\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0E0C0\u0019H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aH\u0002J\u0010\u0010G\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006I"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/IFolderFragment;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "dependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/ITitleDependency;", "<init>", "(Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/ITitleDependency;)V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "searchEt", "Lcom/suite/lark/emm/design/edittext/SCEditText;", "breadcrumb", "Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumb;", "singleFolderNameTv", "Landroid/widget/TextView;", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/view/View;", "isShowSearch", "", "isShowForward", "isShowJumpToChat", "isShowDownload", "breadcrumbList", "", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "chatId", "", "moreAction", "com/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment$moreAction$2$1", "getMoreAction", "()Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment$moreAction$2$1;", "moreAction$delegate", "Lkotlin/Lazy;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "", "initView", "setActionVisibility", "isHideActionInMessageLinkCard", "initTitleBar", "initSearchEt", "initBreadcrumb", "onChangeBreadcrumb", "backToFolder", "position", "", "updateTitleBar", "extraAction", "Lcom/ss/android/lark/ui/IActionTitlebar$Action;", "change2SimpleTitleBar", "addItemToBreadcrumb", "data", "getCurFilePreviewInfo", "onBackPressed", "generateDialog", "showActionDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemList", "Lkotlin/Pair;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItemBuilder;", "Lkotlin/Function0;", "doJumpToChat", "doForward", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderTitleFragment extends BaseFragment implements com.ss.android.lark.filedetail.impl.folder.manage.page.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f421768r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FolderManageLaunchParams f421769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f421770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonTitleBar f421771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SCEditText f421772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDBreadcrumb f421773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f421774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f421775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f421776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f421777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f421778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f421779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<nfb.a> f421780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f421781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f421782q;

    public static final class a {
    }

    static {
    }

    public final void U90() {
        CommonTitleBar r100 = this.f421771f;
        CommonTitleBar r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r100 = null;
    L5:
        r100.removeAllActions();
        SCEditText r102 = this.f421772g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
        r102 = null;
    L8:
        r102.setVisibility(8);
        UDBreadcrumb r103 = this.f421773h;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r103 = null;
    L11:
        r103.setVisibility(8);
        TextView r104 = this.f421774i;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("singleFolderNameTv");
        r104 = null;
    L14:
        r104.setVisibility(8);
        View r105 = this.f421775j;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
        r105 = null;
    L17:
        r105.setVisibility(8);
        CommonTitleBar r106 = this.f421771f;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L21:
        r101.setTitle("");
        return;
    L20:
        r101 = r106;
        goto L21
    }

    public final void V90() {
        int r100 = 0;
        boolean r101 = true;
        if (this.f421780o.size() > 1) goto L6;
        r101 = false;
    L6:
        UDBreadcrumb r102 = this.f421773h;
        TextView r103 = null;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r102 = null;
    L10:
        if (r101 == false) goto L12;
        int r104 = 0;
    L13:
        r102.setVisibility(r104);
        TextView r105 = this.f421774i;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("singleFolderNameTv");
    L17:
        if (r101 == false) goto L19;
        r100 = 8;
    L19:
        r103.setVisibility(r100);
        return;
    L16:
        r103 = r105;
        goto L17
    L12:
        r104 = 8;
        goto L13
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.c
    public final boolean onBackPressed() {
        if (((ArrayList) this.f421780o).size() > 1) goto L6;
        return false;
    L6:
        T90(CollectionsKt.getLastIndex(this.f421780o) - 1);
        return true;
    }

    public final void T90(int r100) {
        if (this.f421780o.size() > r100) goto L5;
        return;
    L5:
        int r101 = r100 + 1;
        UDBreadcrumb r102 = this.f421773h;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r102 = null;
    L8:
        r102.c(r101);
        this.f421780o = new ArrayList(this.f421780o.subList(0, r101));
        V90();
        this.f421770e.a((nfb.a) CollectionsKt.last(this.f421780o));
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        FolderManageLaunchParams r101 = this.f421769d;
        int r102 = r101.f421498e;
        int r103 = 0;
        if (r102 != 4) goto L5;
        this.f421776k = false;
        this.f421778m = false;
    L16:
        if (this.f421779n == true) goto L18;
    L20:
        boolean r104 = false;
    L21:
        this.f421779n = r104;
        String r105 = r101.f421512s;
        if (r105 != null) goto L24;
    L27:
        boolean r106 = true;
    L28:
        boolean r107 = !r106;
        if (this.f421777l == true) goto L31;
    L34:
        boolean r108 = false;
    L35:
        this.f421777l = r108;
        if (this.f421778m == false) goto L39;
        if (r107 == true) goto L39;
        boolean r109 = true;
    L40:
        this.f421778m = r109;
        if (this.f421776k == false) goto L44;
        if (r107 == true) goto L44;
        boolean r110 = true;
    L45:
        this.f421776k = r110;
        CommonTitleBar r111 = this.f421771f;
        UDBreadcrumb r112 = null;
        if (r111 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r111 = null;
    L48:
        r111.setTitle(R.string.Lark_Legacy_FileFragmentTitle);
        r111.setLeftClickListener(new c(this));
        SCEditText r113 = this.f421772g;
        if (r113 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
        r113 = null;
    L52:
        if (this.f421776k == true) goto L55;
        r103 = 8;
    L55:
        r113.setVisibility(r103);
        SCEditText r114 = this.f421772g;
        if (r114 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
        r114 = null;
    L58:
        r114.setOnClickListener(new b(this));
        if (this.f421769d.f421511r != 1) goto L61;
        FileType r115 = FileType.FOLDER;
    L62:
        nfb.a.C6924a r116 = new nfb.a.C6924a();
        String r117 = this.f421769d.f421501h;
        Intrinsics.checkNotNullParameter(r117, "name");
        r116.f518989c = r117;
        String r118 = this.f421769d.f421500g;
        Intrinsics.checkNotNullParameter(r118, "key");
        r116.f518987a = r118;
        FolderManageLaunchParams r119 = this.f421769d;
        r116.f518990d = r119.f421507n;
        r116.f518997k = r119.f421512s;
        r116.f518998l = r119.f421513t;
        Intrinsics.checkNotNullParameter(r115, "type");
        r116.f518988b = r115;
        nfb.a r120 = r116.a();
        this.f421770e.a(r120);
        UDBreadcrumb r121 = this.f421773h;
        if (r121 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r121 = null;
    L65:
        r121.setItems(CollectionsKt.listOf(r120.f518977c));
        ((ArrayList) this.f421780o).add(r120);
        TextView r122 = this.f421774i;
        if (r122 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("singleFolderNameTv");
        r122 = null;
    L68:
        r122.setText(r120.f518977c);
        V90();
        UDBreadcrumb r123 = this.f421773h;
        if (r123 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
    L72:
        r112.setOnItemClickListener(new com.ss.android.lark.filedetail.impl.folder.manage.page.title.a(this));
        return;
    L71:
        r112 = r123;
        goto L72
    L61:
        r115 = FileType.FILE;
    L44:
        r110 = false;
    L39:
        r109 = false;
        goto L40
    L31:
        if (this.f421769d.f421510q == false) goto L34;
        if (r107 == true) goto L34;
        r108 = true;
        goto L35
    L24:
        if (r105.length() == 0) goto L27;
        r106 = false;
        goto L28
    L18:
        if (r101.f421509p == false) goto L20;
        r104 = true;
        goto L21
    L5:
        if (r102 != 5) goto L7;
        this.f421776k = false;
        this.f421777l = true;
        this.f421778m = false;
        goto L16
    L7:
        if (r102 != 6) goto L9;
        this.f421776k = false;
        goto L16
    L9:
        if (r102 != 9) goto L16;
        this.f421776k = false;
        this.f421778m = false;
        goto L16
    }

    public FolderTitleFragment(FolderManageLaunchParams r100, FolderManageActivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f421769d = r100;
        this.f421770e = r101;
        boolean r102 = true;
        this.f421776k = true;
        this.f421777l = true;
        this.f421778m = true;
        this.f421780o = new ArrayList();
        String r103 = r100.f421503j;
        if (r103 != null) goto L5;
    L8:
        if (r102 == true) goto L10;
        String r104 = r100.f421503j;
    L11:
        this.f421781p = r104;
        this.f421782q = LazyKt.lazy(new FolderTitleFragment$moreAction$2(this));
        return;
    L10:
        r104 = r100.f421495b;
        goto L11
    L5:
        if (r103.length() == 0) goto L8;
        r102 = false;
        goto L8
    }

    public static final void S90(FolderTitleFragment r110, nfb.a r111) {
        Message r100 = r110.f421769d.f421506m;
        if (r100 != null) goto L10;
        com.ss.android.lark.storage.a r101 = FileDetailModule.f421460a;
        hfb.b r102 = FileDetailModule.a.a();
        if (r102 == null) goto L9;
        hfb.b.d r103 = r102.getChatDependency();
        if (r103 == null) goto L9;
        String r104 = r110.f421769d.f421494a;
        r103.d();
    L9:
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        r100.getRootId();
    L12:
        com.ss.android.lark.storage.a r105 = FileDetailModule.f421460a;
        hfb.b r106 = FileDetailModule.a.a();
        if (r106 == null) goto L18;
        hfb.b.d r107 = r106.getChatDependency();
        if (r107 == null) goto L18;
        r107.d();
    L18:
        if (r100 != null) goto L20;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == true) goto L43;
        if (r100 == null) goto L29;
        if (r100.isReplyInThreadChildMessage() == true) goto L29;
    L29:
        int r109 = pfb.d.f529030a;
        pfb.d.a.f(r110.f421781p, "forward", "none", pfb.d.a.a(r111.getType(), r111.f518977c, r111.f518978d));
        nfb.a r112 = (nfb.a) CollectionsKt.lastOrNull(r110.f421780o);
        if (r112 != null) goto L32;
        return;
    L32:
        if (TextUtils.isEmpty(r110.f421769d.f421515v) == false) goto L34;
        String r113 = r110.f421769d.f421494a;
    L35:
        String r114 = r113;
        if (r114 == null) goto L42;
        int r115 = com.ss.android.lark.filedetail.impl.detail.templatefactory.b.f421646a;
        Context r116 = r110.requireContext();
        String r117 = r112.f518975a;
        String r118 = r112.f518977c;
        long r119 = r112.f518978d;
        if (r112.getType() != FileType.FOLDER) goto L40;
        boolean r120 = true;
    L41:
        com.ss.android.lark.filedetail.impl.detail.templatefactory.b.a(r116, r117, r118, r119, r120, r114);
        return;
    L40:
        r120 = false;
        goto L41
    L42:
        Log.e("FolderTitleFragment", "forward messageId is invalid!");
        return;
    L34:
        r113 = r110.f421769d.f421515v;
        goto L35
    L43:
        LKUIToast.show(r110.mContext, R.string.Lark_IM_MessageRestrictedCantForward_Hover);
        return;
    L20:
        if (r100.isRestricted() != true) goto L22;
        r108 = true;
        goto L23
    }

    public final void W90(boolean r100, FileListView$switchAction$2.a r110) {
        boolean r101 = false;
        if (r100 == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f421779n = r102;
        if (r100 == false) goto L11;
    L16:
        boolean r103 = true;
    L17:
        if (r110 == null) goto L19;
        boolean r104 = true;
    L20:
        CommonTitleBar r105 = this.f421771f;
        CommonTitleBar r106 = null;
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r105 = null;
    L24:
        if (r105.getViewByAction((FolderTitleFragment$moreAction$2.a) this.f421782q.getValue()) == null) goto L26;
        boolean r107 = true;
    L27:
        if (r110 == null) goto L34;
        CommonTitleBar r108 = this.f421771f;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r108 = null;
    L32:
        if (r108.getViewByAction(r110) != null) goto L46;
    L47:
        if (r103 != r107) goto L50;
        if (r104 != r101) goto L50;
        return;
    L50:
        CommonTitleBar r109 = this.f421771f;
        if (r109 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L54:
        r106.removeAllActions();
        if (r110 == null) goto L57;
        r106.addAction(r110);
    L57:
        if (r103 == false) goto L60;
        r106.addAction((FolderTitleFragment$moreAction$2.a) this.f421782q.getValue());
        return;
    L60:
        return;
    L53:
        r106 = r109;
    L46:
        r101 = true;
        goto L47
    L34:
        if (r107 == false) goto L41;
        CommonTitleBar r111 = this.f421771f;
        if (r111 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r111 = null;
    L39:
        if (r111.getActionCount() < 2) goto L47;
    L41:
        CommonTitleBar r112 = this.f421771f;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r112 = null;
    L45:
        if (r112.getActionCount() < 1) goto L47;
    L26:
        r107 = false;
        goto L27
    L19:
        r104 = false;
        goto L20
    L11:
        if (this.f421778m == true) goto L16;
        if (this.f421777l == true) goto L16;
        r103 = false;
        goto L17
    L5:
        if (this.f421769d.f421509p == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_folder_title_view, r101, false);
        this.f421771f = (CommonTitleBar) r103.findViewById(R.id.titlebar);
        this.f421772g = (SCEditText) r103.findViewById(R.id.search_et);
        this.f421773h = (UDBreadcrumb) r103.findViewById(R.id.folder_name_list);
        this.f421774i = (TextView) r103.findViewById(R.id.parent_folder_name_tv);
        this.f421775j = r103.findViewById(R.id.v_divider);
        return r103;
    }
}
