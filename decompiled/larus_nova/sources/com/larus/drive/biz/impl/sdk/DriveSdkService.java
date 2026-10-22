package com.larus.drive.biz.impl.sdk;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveListLoadType;
import com.larus.drive.biz.impl.file.s;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.a0;
import com.larus.drive.biz.impl.viewmodel.o;
import com.larus.drive.biz.impl.viewmodel.p;
import com.larus.drive.biz.impl.viewmodel.q;
import com.larus.drive.biz.impl.viewmodel.r;
import com.larus.drive.biz.impl.viewmodel.z;
import com.larus.drive.sdk.api.DrivePickerScene;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.list.RequestDriveFileListRankType;
import com.larus.drive.sdk.api.file.upload.DriveUploadPriority;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kw9.c;
import z79.b;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016JF\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016JT\u0010!\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0016\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016JJ\u0010*\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00132\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016JH\u0010/\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00132\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016J@\u00100\u001a\u0004\u0018\u00010\u00152\u0006\u00101\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016JR\u00102\u001a\u0004\u0018\u00010\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u00020(042\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2 \u00105\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001106\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016Ja\u00107\u001a\u0004\u0018\u00010\u00132\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00112#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.H\u0016J\u0018\u0010@\u001a\u00020\n2\u0006\u00101\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0016J(\u0010C\u001a\u00020\n2\u0006\u0010A\u001a\u00020B2\u0006\u0010:\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0018\u0010C\u001a\u00020\n2\u0006\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020\u0013H\u0016J\b\u0010F\u001a\u00020\u001aH\u0016J8\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010\u001f\u001a\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020(04H\u0016J*\u0010Q\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020T2\u0006\u0010\u001f\u001a\u00020UH\u0016J2\u0010Q\u001a\u00020\n2\u0006\u00101\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\u0006\u00108\u001a\u0002092\u0006\u0010S\u001a\u00020T2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0016\u0010Z\u001a\u00020\n2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001304H\u0016J\u0018\u0010\\\u001a\u00020\n2\u0006\u00101\u001a\u00020(2\u0006\u0010]\u001a\u00020^H\u0016J2\u0010_\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010S\u001a\u00020a2\u0006\u0010\u001f\u001a\u00020bH\u0016J\u001a\u0010c\u001a\u0004\u0018\u00010\u00132\u0006\u0010d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020bH\u0016JX\u0010e\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020\u00132\b\u0010h\u001a\u0004\u0018\u00010\u00132\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013062\u0006\u0010S\u001a\u00020a2\u0006\u0010\u001f\u001a\u00020jH\u0016J\u001a\u0010k\u001a\u0004\u0018\u00010\u00132\u0006\u0010d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020jH\u0016J\u0016\u0010l\u001a\u00020\u001a2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001304H\u0016J\b\u0010m\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u00101\u001a\u00020(H\u0016JO\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020(2\u0006\u00108\u001a\u0002092%\u0010&\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.H\u0016J\u001a\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J,\u0010r\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010w\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00132\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0010\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0013H\u0016J)\u0010}\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u001aH\u0096@¢\u0006\u0003\u0010\u0080\u0001J\u0012\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u001f\u001a\u00030\u0082\u0001H\u0016J*\u0010\u0083\u0001\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00132\u0007\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u00020\u0013H\u0096@¢\u0006\u0003\u0010\u0086\u0001J\u0013\u0010\u0087\u0001\u001a\u00020\u00132\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\u000f\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u001104H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/drive/biz/impl/sdk/DriveSdkService;", "Lcom/larus/drive/sdk/api/IDriveSdkService;", "<init>", "()V", "service", "getService", "()Lcom/larus/drive/sdk/api/IDriveSdkService;", "service$delegate", "Lkotlin/Lazy;", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "requestDriveFileList", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "loadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "parentToken", "onlyFolder", "", "length", "loadMoreLabel", "rankType", "Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "callback", "Lcom/larus/drive/sdk/api/file/list/IRequestDriveFileListCallback;", "createDriveFile", "parentDriveToken", "type", "Lcom/larus/drive/biz/api/model/DriveFileType;", "fileName", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", LynxVideoManagerLite.EVENT_ON_ERROR, "moveDriveFile", "fileToken", "driveObjType", "parentFolderToken", "Lkotlin/Function0;", "renameDriveFile", "deleteDriveFile", "file", "deleteDriveFiles", "fileList", "", "onFailure", "", "getImageCoverUrl", "scope", "Lkotlinx/coroutines/CoroutineScope;", "token", "height", "width", "Lkotlin/ParameterName;", "name", "url", "loadFileTypeIcon", "imageView", "Landroid/widget/ImageView;", "loadDocumentIcon", "objType", "iconInfo", "isPickerInitialized", "attachPickerView", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerController;", "pickerScene", "Lcom/larus/drive/sdk/api/DrivePickerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "rootView", "Landroid/view/ViewGroup;", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerViewCallback;", "preSelectedDriveItems", "downloadDriveFile", "localPath", "priority", "Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "Lcom/larus/drive/sdk/api/file/download/IDriveDownloadCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "cancelDownloadDriveFile", "taskKeys", "shareDriveFile", "param", "Lcom/larus/share/bean/DriveShareEventParam;", "startUploadingDriveFile", "uri", "Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "Lcom/larus/drive/sdk/api/file/upload/IDriveUploadCallback;", "resumeUploadingDriveFile", DBDefinition.TASK_ID, "startUploadingDriveFileToMountPoint", "mountPoint", "mountNodeToken", "uploadCode", "extraRust", "Lcom/larus/drive/sdk/api/file/upload/IDriveMountUploadCallback;", "resumeUploadingDriveFileToMountPoint", "cancelUploadDriveFile", "clearDriveUploadTasks", "refreshVisitedTime", "registerDriveResource", MapController.ITEM_LAYER_TAG, "resourceId", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "ccmType", "updateDriveMetaInfo", "info", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "getDriveMetaInfo", "getDriveFilePermission", "fetchDriveFileInfo", "fileObjType", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLocalDbService", "Lcom/larus/drive/sdk/api/file/database/ILocalDatabaseCallback;", "validateDriveFileInLarkSecurityControl", "fileType", WikiFolderPushPlugin.OPT, "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatFileTime", "timestamp", "", "getFileTypeInList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkService implements IDriveSdkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DriveSdkService f341224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f341225b = null;

    private DriveSdkService() {
    }

    static {
        f341224a = new DriveSdkService();
        f341225b = LazyKt.lazy(new a());
    }

    public static IDriveSdkService V() {
        return (IDriveSdkService) f341225b.getValue();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final List<Integer> U() {
        IDriveSdkService r100 = V();
        if (r100 == null) goto L7;
        List<Integer> r101 = r100.U();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        IDriveSdkService r100 = V();
        if (r100 == null) goto L6;
        r100.destroyDocSdk();
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void h() {
        IDriveSdkService r100 = V();
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final boolean l() {
        IDriveSdkService r100 = V();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.l();
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        IDriveSdkService r100 = V();
        if (r100 == null) goto L6;
        String r101 = r100.lifecycleCategory();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "drive";
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final int lifecycleOrder() {
        IDriveSdkService r100 = V();
        if (r100 != null) goto L7;
        return 3;
    L7:
        return r100.lifecycleOrder();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final boolean S(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "taskKeys");
        IDriveSdkService r101 = V();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.S(r100);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void g(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "taskKeys");
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        r101.initDocSdk(r100);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void k(AbsDriveListFragment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        r101.k(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        r101.postInitDocSdk(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        r101.preInitDocSdk(r100);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final Object w(Continuation r100) {
        if ((r100 instanceof DriveSdkService$validateDriveFileInLarkSecurityControl$1) == false) goto L7;
        DriveSdkService$validateDriveFileInLarkSecurityControl$1 r101 = (DriveSdkService$validateDriveFileInLarkSecurityControl$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        int r106 = ((Number) r103).intValue();
    L22:
        return Boxing.boxInt(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IDriveSdkService r107 = V();
        if (r107 == null) goto L20;
        r101.label = 1;
        r103 = r107.w(r101);
        if (r103 != r104) goto L19;
        return r104;
    L20:
        r106 = 10003;
    L7:
        r101 = new DriveSdkService$validateDriveFileInLarkSecurityControl$1(this, r100);
        goto L8
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String x(long r100) {
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        String r102 = r101.x(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void z(DriveFileItem r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        IDriveSdkService r101 = V();
        if (r101 == null) goto L6;
        r101.z(r100);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void F(DriveFileItem r100, ImageView r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "imageView");
        IDriveSdkService r102 = V();
        if (r102 == null) goto L6;
        r102.F(r100, r101);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String I(String r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.I(r100, r101);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void P(DriveFileItem r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "param");
        IDriveSdkService r102 = V();
        if (r102 == null) goto L6;
        r102.P(r100, r101);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void e(ImageView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "url");
        IDriveSdkService r102 = V();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void m(b r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "galleryContext");
        IDriveSdkService r102 = V();
        if (r102 == null) goto L6;
        r102.m(r100, r101);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String p(String r100, bo9.c r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.p(r100, r101);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void H(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        IDriveSdkService r103 = V();
        if (r103 == null) goto L6;
        r103.H(r100, r101, r102);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void C(DriveFileItem r100, CoroutineScope r101, Function1<? super String, Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "scope");
        IDriveSdkService r104 = V();
        if (r104 == null) goto L6;
        r104.C(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b O(DriveFileItem r100, DriveListLoadType r101, o r102, p r103) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "loadType");
        IDriveSdkService r104 = V();
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.O(r100, r101, r102, r103);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final Object b(String r100, int r101, boolean r102, Continuation<? super DriveFileItem> r103) {
        IDriveSdkService r104 = V();
        if (r104 != null) goto L5;
        return null;
    L5:
        return r104.b(r100, r101, r102, r103);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void o(ImageView r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter("", "token");
        Intrinsics.checkNotNullParameter("", "iconInfo");
        IDriveSdkService r104 = V();
        if (r104 == null) goto L6;
        r104.o(r100, "", r102, "");
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b q(List<DriveFileItem> r100, DriveListLoadType r101, Function0<Unit> r102, Function1<? super Map<String, Integer>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "fileList");
        Intrinsics.checkNotNullParameter(r101, "loadType");
        IDriveSdkService r104 = V();
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.q(r100, r101, r102, r103);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String r(String r100, String r101, DriveDownloadPriority r102, AbsDriveListViewModel.C114301 r103) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r101, "localPath");
        Intrinsics.checkNotNullParameter(r102, "priority");
        Intrinsics.checkNotNullParameter(r103, "callback");
        IDriveSdkService r104 = V();
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.r(r100, r101, r102, r103);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final w79.b A(DrivePickerScene r100, FragmentActivity r101, ViewGroup r110, w79.c r111, List<DriveFileItem> r112) {
        Intrinsics.checkNotNullParameter(r100, "pickerScene");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r110, "rootView");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "preSelectedDriveItems");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.A(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void E(DriveFileItem r100, FragmentActivity r101, CoroutineScope r110, DriveDownloadPriority r111, Fragment r112) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "priority");
        IDriveSdkService r102 = V();
        if (r102 == null) goto L6;
        r102.E(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b Q(String r100, int r101, String r110, q r111, r r112) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r110, "fileName");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.Q(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b R(String r100, DriveFileType r101, String r110, Function1<? super DriveFileItem, Unit> r111, Function1<? super String, Unit> r112) {
        Intrinsics.checkNotNullParameter(r101, "type");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.R(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String t(String r100, String r101, String r110, DriveUploadPriority r111, s r112) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r110, "parentDriveToken");
        Intrinsics.checkNotNullParameter(r111, "priority");
        Intrinsics.checkNotNullParameter(r112, "callback");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.t(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b u(String r100, int r101, String r110, z r111, a0 r112) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        IDriveSdkService r102 = V();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.u(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String f(CoroutineScope r100, String r110, int r111, int r112, Function1<? super String, Unit> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, "token");
        IDriveSdkService r101 = V();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b B(DriveListLoadType r110, String r111, boolean r112, int r113, String r114, RequestDriveFileListRankType r115, u79.b r116) {
        Intrinsics.checkNotNullParameter(r110, "loadType");
        Intrinsics.checkNotNullParameter(r115, "rankType");
        Intrinsics.checkNotNullParameter(r116, "callback");
        IDriveSdkService r100 = V();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.B(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String J(String r110, String r111, String r112, String r113, String r114, Map r115, DriveUploadPriority r116, bo9.c r117) {
        Intrinsics.checkNotNullParameter(r110, "fileName");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "mountPoint");
        Intrinsics.checkNotNullParameter(r113, "mountNodeToken");
        Intrinsics.checkNotNullParameter(r115, "extraRust");
        Intrinsics.checkNotNullParameter(r116, "priority");
        Intrinsics.checkNotNullParameter(r117, "callback");
        IDriveSdkService r100 = V();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.J(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
