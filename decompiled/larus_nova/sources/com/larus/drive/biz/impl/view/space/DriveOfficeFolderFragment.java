package com.larus.drive.biz.impl.view.space;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadPickerFragment$buildCallback$1;
import com.bytedance.ee.bear.office.export.space.OfficeFolderActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceAskDoubaoRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelectionRequest;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.drive.biz.impl.activity.DriveOfficeFolderActivity;
import com.larus.drive.biz.impl.activity.DriveSearchActivity;
import com.larus.drive.biz.impl.databinding.LarusFragmentDriveOfficeFolderBinding;
import com.larus.drive.biz.impl.file.DriveOfficeUploadGuard;
import com.larus.drive.biz.impl.utils.DriveOfficeSpaceHelper;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002fgB\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020+2\u0006\u0010'\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0018\u00102\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u000205H\u0016J \u00106\u001a\u00020+2\u0006\u0010,\u001a\u0002072\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u000205H\u0016J\u0010\u00108\u001a\u0002092\u0006\u00103\u001a\u000204H\u0016J \u0010:\u001a\u0002092\u0006\u0010,\u001a\u0002072\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u000205H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010@\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010A\u001a\u00020+2\u0006\u0010'\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u0018\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0012H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u0017H\u0002J\u001a\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020M0L2\b\u0010J\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L2\b\u0010J\u001a\u0004\u0018\u00010\u0017H\u0002J3\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u000f2\b\u0010S\u001a\u0004\u0018\u00010\u000f2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002¢\u0006\u0002\u0010VJ\u0010\u0010W\u001a\u00020X2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010Y\u001a\u00020\"2\u0006\u0010P\u001a\u00020QH\u0002J\u001e\u0010Z\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000f2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020M0LH\u0002J\u0010\u0010\\\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000fH\u0002J\u0018\u0010]\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010\u00142\u0006\u0010C\u001a\u00020\u000fH\u0002J\b\u0010`\u001a\u00020\"H\u0002J\u0006\u0010a\u001a\u000209J\b\u0010b\u001a\u00020\"H\u0002J\b\u0010c\u001a\u00020\"H\u0002J\u0016\u0010d\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/larus/drive/biz/impl/view/space/DriveOfficeFolderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageDelegate;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoVisibilityProvider;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressActionAvailabilityListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionProvider;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusFragmentDriveOfficeFolderBinding;", "folderPageRequest", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "previousPage", "", "pendingUploadRequestId", "pendingUploadAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "pendingUploadCallback", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionCallback;", "officeSpacePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onOpenChildFolder", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "request", "onSearch", com.alipay.sdk.m.x.d.f25924n, "onHeaderActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "onRequestUploadSelection", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "callback", "onItemClick", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "onLongPressActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", "shouldShowAskDoubao", "", "canHandleLongPressAction", "handleCreateOfficeDocument", "reportAiDocCreateIfNeeded", "createdFile", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "getPreviousPage", "notifyOfficeDocumentCreated", "handleOpenUploadSelector", "openUploadSelectorAfterGuard", "requestId", "buildOfficeSpaceAlbumConfig", "Lcom/larus/platform/model/album/AlbumSettingConfig;", "buildOfficeSpaceFileSelectIntent", "handleUploadPickerResult", "resultCode", "", "data", "parseAlbumSelections", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "parseFileSelections", "buildUploadSelection", "uri", "Landroid/net/Uri;", CommonConstant.KEY_DISPLAY_NAME, DBDefinition.MIME_TYPE, "size", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "queryUploadMeta", "Lcom/larus/drive/biz/impl/view/space/DriveOfficeFolderFragment$UploadMeta;", "persistReadPermission", "notifyUploadSelected", "selections", "notifyUploadCancel", "notifyUploadError", "message", "uploadCallbackFor", "clearPendingUpload", "handleBack", "initConfig", "attachFolderIfNeeded", "resolveFolderFragment", "(Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "UploadMeta", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficeFolderFragment extends Fragment implements com.bytedance.ee.bear.office.export.space.b, com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.e, com.bytedance.ee.bear.office.export.space.j, com.bytedance.ee.bear.office.export.space.o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f341403k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentDriveOfficeFolderBinding f341404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeFolderPageRequest f341405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f341406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f341407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OfficeSpaceHeaderAction f341408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.office.export.space.n f341409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f341410j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f341411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f341412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f341413c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f341411a, r101.f341411a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f341412b, r101.f341412b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f341413c, r101.f341413c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f341411a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f341412b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.f341413c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadMeta(displayName=" + this.f341411a + ", mimeType=" + this.f341412b + ", size=" + this.f341413c + ')';
        }

        public b(String r100, String r101, Long r102) {
            this.f341411a = r100;
            this.f341412b = r101;
            this.f341413c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341414a = null;

        static {
            int[] r100 = new int[OfficeSpaceHeaderAction.values().length];
            r100[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f341414a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final /* synthetic */ OfficeSpaceActionResult.NotHandled XS(OfficeSpaceItem r100, OfficeSpaceEventSource r101) {
        return com.bytedance.ee.bear.office.export.space.g.a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final void YJ(OfficeSpaceSelectionState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final void oI(OfficeSpaceTab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        String r100 = this.f341407g;
        if (r100 == null) goto L5;
        V90(r100);
    L5:
        this.f341404d = null;
        super.onDestroyView();
    }

    public DriveOfficeFolderFragment() {
        this.f341410j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this));
    }

    @Override // com.bytedance.ee.bear.office.export.space.b
    public final OfficeFolderActionResult E00(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        int r101 = DriveSearchActivity.f341054i;
        DriveSearchActivity.a.a(getContext());
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.office.export.space.e
    public final boolean Jk(OfficeSpaceItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Set<Integer> r101 = DriveOfficeSpaceHelper.f341251a;
        return DriveOfficeSpaceHelper.c(com.bytedance.ee.bear.office.export.space.d.a(r100));
    }

    public final void V90(String r100) {
        com.bytedance.ee.bear.office.export.space.n r101 = Y90(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.onCancel(r100);
        this.f341407g = null;
        this.f341408h = null;
        this.f341409i = null;
    }

    public final b X90(Uri r100) {
        Context r101 = getContext();
        String r102 = null;
        Long r103 = null;
        r103 = null;
        Unit r104 = null;
        if (r101 == null) goto L55;
        ContentResolver r105 = r101.getContentResolver();
        if (r105 == null) goto L55;
        String r106 = r105.getType(r100);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L46
        Cursor r108 = U90(r105, r100, new String[]{"_display_name", "_size"});     // Catch: Throwable -> L46
        if (r108 == null) goto L41;
        Cursor r109 = r108;     // Catch: Throwable -> L46
        Cursor r110 = r109;     // Catch: Throwable -> L32
        if (r110.moveToFirst() == false) goto L26;
        int r111 = r110.getColumnIndex("_display_name");     // Catch: Throwable -> L32
        int r112 = r110.getColumnIndex("_size");     // Catch: Throwable -> L32
        if (r111 < 0) goto L17;
        String r113 = r110.getString(r111);     // Catch: Throwable -> L32
    L18:
        if (r112 >= 0) goto L68;
    L25:
        Long r114 = null;
    L66:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r109, null);     // Catch: Throwable -> L44
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L42:
        Object r116 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L44
    L49:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L53;
        FLogger.f375446a.e("DriveOfficeFolder", "query office folder upload uri meta failed", r117);
    L53:
        return new b(r113, r106, r114);
    L44:
        th = th;
    L40:
        r102 = r113;
    L48:
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r113 = r102;
    L30:
        th = move-exception;
        r103 = r114;
        th = th;
    L58:
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = th;
        r114 = r103;
        goto L40
    L68:
    L23:
        th = th;
        goto L58
    L20:
        if (r110.isNull(r112) == true) goto L25;
        r114 = Long.valueOf(r110.getLong(r112));     // Catch: Throwable -> L23
        goto L66
    L17:
        r113 = null;
        goto L18
    L26:
        r114 = null;
        r113 = null;
    L32:
        th = th;
        r113 = null;
        goto L58
    L41:
        r114 = null;
        r113 = null;
    L46:
        th = th;
        r114 = null;
    L55:
        return new b(null, null, null);
    }

    public final com.bytedance.ee.bear.office.export.space.n Y90(String r100) {
        if (Intrinsics.areEqual(this.f341407g, r100) == true) goto L7;
        FLogger.f375446a.i("DriveOfficeFolder", "ignore stale folder upload callback, requestId=" + r100 + ", pending=" + this.f341407g);
        return null;
    L7:
        return this.f341409i;
    }

    @Override // com.bytedance.ee.bear.office.export.space.b
    public final OfficeFolderActionResult pH(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        int r101 = DriveOfficeFolderActivity.f341052g;
        DriveOfficeFolderActivity.a.a(getContext(), r100);
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.office.export.space.b
    public final OfficeFolderActionResult r50(OfficeFolderPageRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L6;
        r101.finish();
    L6:
        return OfficeFolderActionResult.Handled;
    }

    @Override // com.bytedance.ee.bear.office.export.space.o
    public final OfficeSpaceActionResult NF(OfficeSpaceUploadSelectionRequest r100, OfficeUploadPickerFragment$buildCallback$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        final OfficeSpaceHeaderAction r102 = r100.getAction();
        final String r103 = r100.getRequestId();
        if (StringsKt.isBlank(r103) == false) goto L6;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L6:
        if (r102 == OfficeSpaceHeaderAction.UPLOAD_IMAGE) goto L11;
        if (r102 == OfficeSpaceHeaderAction.UPLOAD_FILE) goto L11;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L11:
        if (this.f341407g == null) goto L13;
        r101.onError(r103, "upload picker already pending");
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L13:
        this.f341407g = r103;
        this.f341408h = r102;
        this.f341409i = r101;
        DriveOfficeUploadGuard.a(this, new com.larus.drive.biz.impl.view.space.b(this, r103, r102), new com.larus.drive.biz.impl.view.space.c(this, r103));
        return OfficeSpaceActionResult.Handled.INSTANCE;
    }

    public final void W90(String r100, String r101) {
        com.bytedance.ee.bear.office.export.space.n r102 = Y90(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.onError(r100, r101);
        this.f341407g = null;
        this.f341408h = null;
        this.f341409i = null;
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final OfficeSpaceActionResult Zj(final OfficeSpaceHeaderAction r110, final OfficeSpaceHeaderEventSource r111) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "source");
        int[] r100 = c.f341414a;
        int r101 = r100[r110.ordinal()];
        if (r101 == 1) goto L8;
        if (r101 == 2) goto L8;
        if (r101 == 3) goto L8;
        if (r101 == 4) goto L8;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L8:
        final long r102 = System.currentTimeMillis();
        int r103 = r100[r110.ordinal()];
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 == 3) goto L15;
        if (r103 != 4) goto L25;
        int r104 = 3;
    L18:
        Set<Integer> r105 = DriveOfficeSpaceHelper.f341251a;
        OfficeFolderPageRequest r106 = this.f341405e;
        if (r106 == null) goto L21;
        String r107 = r106.getFolderToken();
    L22:
        final int r108 = r104;
        return DriveOfficeSpaceHelper.b(this, r107, r104, r111, new com.larus.drive.biz.impl.view.space.a(r110, r108, r111, r102, this));
    L21:
        r107 = null;
        goto L22
    L25:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L15:
        r104 = 8;
        goto L18
    L16:
        r104 = 30;
        goto L18
    L17:
        r104 = 22;
        goto L18
    }

    @Override // com.bytedance.ee.bear.office.export.space.h
    public final OfficeSpaceActionResult ne(OfficeSpaceItem r100, OfficeSpaceEventSource r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100.isFolder() == true) goto L5;
        Context r102 = getContext();
        if (r102 != null) goto L11;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L11:
        if (IDriveSdkServiceV2.f341560a.c(r102, r100, r101) == false) goto L14;
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L14:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L5:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        if (r102 == null) goto L5;
        Serializable r103 = r102.getSerializable("drive_office_folder_request");
    L7:
        if ((r103 instanceof OfficeFolderPageRequest) == false) goto L9;
        OfficeFolderPageRequest r104 = (OfficeFolderPageRequest) r103;
    L10:
        this.f341405e = r104;
        Bundle r105 = getArguments();
        if (r105 == null) goto L13;
        String r106 = r105.getString("drive_office_folder_previous_page");
    L14:
        this.f341406f = r106;
        Fragment r107 = getChildFragmentManager().findFragmentByTag("drive_office_folder_content");
        if (r107 == null) goto L17;
        FLogger.f375446a.i("DriveOfficeFolder", "remove restored office folder child before reattach");
        getChildFragmentManager().beginTransaction().remove(r107).commitNowAllowingStateLoss();
    L17:
        OfficeFolderPageRequest r108 = this.f341405e;
        if (r108 != null) goto L20;
        FLogger.f375446a.e("DriveOfficeFolder", "office folder request is empty");
        return;
    L20:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DriveOfficeFolderFragment$attachFolderIfNeeded$2(this, r108, null), 3, null);
        return;
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Object S90(DriveOfficeFolderFragment r100, OfficeFolderPageRequest r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DriveOfficeFolderFragment$resolveFolderFragment$1) == false) goto L7;
        DriveOfficeFolderFragment$resolveFolderFragment$1 r103 = (DriveOfficeFolderFragment$resolveFolderFragment$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        IOfficeSdkServiceV2 r108 = (IOfficeSdkServiceV2) r103.L$1;
        OfficeFolderPageRequest r109 = (OfficeFolderPageRequest) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        ik5.a r110 = (ik5.a) r105;
        if (r110 == null) goto L31;
        FLogger.f375446a.i("DriveOfficeFolder", "Office docs sdk ready: " + r110);
        gk5.e r111 = r108.q0();
        if (r111 == null) goto L29;
        com.bytedance.ee.bear.office.export.space.a r112 = r111.e7();
        if (r112 == null) goto L29;
        return r112.e(r109, r100);
    L29:
        throw new IllegalStateException("office space sdk unavailable".toString());
    L31:
        throw new IllegalStateException("office docs sdk not ready".toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        IOfficeSdkServiceV2 r113 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r113 == null) goto L33;
        IOfficeSdkServiceV2.a.b(r113, false, null, 7);
        r103.L$0 = r101;
        r103.L$1 = r113;
        r103.label = 1;
        Object r114 = r113.o0(15000, r103);
        if (r114 == r106) goto L34;
        r109 = r101;
        r108 = r113;
        r105 = r114;
        goto L20
    L34:
        return r106;
    L33:
        throw new IllegalStateException("office sdk service unavailable".toString());
    L7:
        r103 = new DriveOfficeFolderFragment$resolveFolderFragment$1(r100, r102);
        goto L8
    }

    public static Cursor U90(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    @Override // com.bytedance.ee.bear.office.export.space.j
    public final boolean Sp(OfficeSpaceLongPressAction r100, OfficeSpaceItem r101, OfficeSpaceEventSource r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "source");
        if (r100 == OfficeSpaceLongPressAction.ASK_DOUBAO) goto L5;
        return false;
    L5:
        if (r101.isFolder() == true) goto L11;
        Set<Integer> r103 = DriveOfficeSpaceHelper.f341251a;
        OfficeSpaceAskDoubaoRequest r104 = com.bytedance.ee.bear.office.export.space.d.b(r101, r102);
        Intrinsics.checkNotNullParameter(r104, "request");
        return DriveOfficeSpaceHelper.c(r104.getCurrent());
    L11:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_drive_office_folder, r101, false);
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.drive_office_folder_content);
        if (r104 == null) goto L7;
        FrameLayout r105 = (FrameLayout) r103;
        this.f341404d = new LarusFragmentDriveOfficeFolderBinding(r105, r104);
        return r105;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.drive_office_folder_content)));
    }

    @Override // com.bytedance.ee.bear.office.export.space.k
    public final OfficeSpaceActionResult xR(OfficeSpaceLongPressAction r100, OfficeSpaceItem r101, OfficeSpaceEventSource r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "source");
        if (r100 != OfficeSpaceLongPressAction.ASK_DOUBAO) goto L10;
        if (r101.isFolder() == true) goto L10;
        Set<Integer> r103 = DriveOfficeSpaceHelper.f341251a;
        return DriveOfficeSpaceHelper.a(this, com.bytedance.ee.bear.office.export.space.d.b(r101, r102));
    L10:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    public final OfficeSpaceUploadSelection T90(Uri r100, String r101, String r102, Long r110) {
        String r103 = null;
        if (r101 != null) goto L5;
    L9:
        String r104 = r100.getLastPathSegment();
        if (r104 != null) goto L12;
    L14:
        if (r103 != null) goto L17;
        r101 = "未命名文件";
    L16:
        String r105 = r101;
    L19:
        return new OfficeSpaceUploadSelection(r100.toString(), true, r105, r102, r110);
    L17:
        r105 = r103;
        goto L19
    L12:
        if ((!StringsKt.isBlank(r104)) == false) goto L14;
        r103 = r104;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L16;
        goto L9
    }
}
