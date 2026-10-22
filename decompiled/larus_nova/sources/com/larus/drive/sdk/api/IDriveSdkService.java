package com.larus.drive.sdk.api;

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
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.a0;
import com.larus.drive.biz.impl.viewmodel.o;
import com.larus.drive.biz.impl.viewmodel.p;
import com.larus.drive.biz.impl.viewmodel.q;
import com.larus.drive.biz.impl.viewmodel.r;
import com.larus.drive.biz.impl.viewmodel.z;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.list.RequestDriveFileListRankType;
import com.larus.drive.sdk.api.file.upload.DriveUploadPriority;
import com.larus.office.base.service.ISdkLifecycleV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import nc5.b;
import w79.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u0000 ~2\u00020\u0001:\u0001~JP\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&Jx\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072'\b\u0002\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&J]\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&J[\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&JS\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&Je\u0010&\u001a\u0004\u0018\u00010\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180(2\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#21\b\u0002\u0010)\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0*¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&Je\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#H&J\u0018\u00103\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u00104\u001a\u000205H&J(\u00106\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0007H&J\u0018\u00106\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u00102\u001a\u00020\u0007H&J\b\u00109\u001a\u00020\tH&J:\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00180(H&J*\u0010D\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020G2\u0006\u0010\u000f\u001a\u00020HH&J6\u0010D\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010I\u001a\u00020J2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010F\u001a\u00020G2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010LH&J\u0016\u0010M\u001a\u00020\u001c2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070(H&J\u0018\u0010O\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010P\u001a\u00020QH&J6\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020UH&J\u001a\u0010V\u001a\u0004\u0018\u00010\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020UH&J^\u0010X\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070*2\b\b\u0002\u0010F\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020]H&J\u001a\u0010^\u001a\u0004\u0018\u00010\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020]H&J\u0016\u0010_\u001a\u00020\t2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070(H&J\b\u0010`\u001a\u00020\u001cH&J\u0010\u0010a\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H&JS\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020.2%\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#H&J\u001c\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020g2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010iH&J0\u0010e\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010h\u001a\u0004\u0018\u00010iH&J\u0010\u0010k\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020mH&J\b\u0010n\u001a\u00020mH&J\u0010\u0010o\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0007H&J*\u0010p\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u000b2\b\b\u0002\u0010r\u001a\u00020\tH¦@¢\u0006\u0002\u0010sJ\u0010\u0010t\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020uH&J&\u0010v\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020|H&J\u000e\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000b0(H&¨\u0006\u007f"}, d2 = {"Lcom/larus/drive/sdk/api/IDriveSdkService;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "requestDriveFileList", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "loadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "parentToken", "", "onlyFolder", "", "length", "", "loadMoreLabel", "rankType", "Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "callback", "Lcom/larus/drive/sdk/api/file/list/IRequestDriveFileListCallback;", "createDriveFile", "parentDriveToken", "type", "Lcom/larus/drive/biz/api/model/DriveFileType;", "fileName", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlin/ParameterName;", "name", "file", "", LynxVideoManagerLite.EVENT_ON_ERROR, "error", "moveDriveFile", "fileToken", "driveObjType", "parentFolderToken", "Lkotlin/Function0;", "renameDriveFile", "deleteDriveFile", "deleteDriveFiles", "fileList", "", "onFailure", "", "failFileWithCode", "getImageCoverUrl", "scope", "Lkotlinx/coroutines/CoroutineScope;", "token", "height", "width", "url", "loadFileTypeIcon", "imageView", "Landroid/widget/ImageView;", "loadDocumentIcon", "objType", "iconInfo", "isPickerInitialized", "attachPickerView", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerController;", "pickerScene", "Lcom/larus/drive/sdk/api/DrivePickerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "rootView", "Landroid/view/ViewGroup;", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerViewCallback;", "preSelectedDriveItems", "downloadDriveFile", "localPath", "priority", "Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "Lcom/larus/drive/sdk/api/file/download/IDriveDownloadCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "cancelDownloadDriveFile", "taskKeys", "shareDriveFile", "param", "Lcom/larus/share/bean/DriveShareEventParam;", "startUploadingDriveFile", "uri", "Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "Lcom/larus/drive/sdk/api/file/upload/IDriveUploadCallback;", "resumeUploadingDriveFile", DBDefinition.TASK_ID, "startUploadingDriveFileToMountPoint", "mountPoint", "mountNodeToken", "uploadCode", "extraRust", "Lcom/larus/drive/sdk/api/file/upload/IDriveMountUploadCallback;", "resumeUploadingDriveFileToMountPoint", "cancelUploadDriveFile", "clearDriveUploadTasks", "refreshVisitedTime", "registerDriveResource", MapController.ITEM_LAYER_TAG, "resourceId", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "ccmType", "updateDriveMetaInfo", "info", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "getDriveMetaInfo", "getDriveFilePermission", "fetchDriveFileInfo", "fileObjType", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLocalDbService", "Lcom/larus/drive/sdk/api/file/database/ILocalDatabaseCallback;", "validateDriveFileInLarkSecurityControl", "fileType", WikiFolderPushPlugin.OPT, "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatFileTime", "timestamp", "", "getFileTypeInList", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDriveSdkService extends ISdkLifecycleV2 {

    public static final class a {
        public static /* synthetic */ String b(DriveSdkService r100, String r101, int r102, int r110) {
            return r100.f(null, r101, r102, r110, null, null);
        }

        public static /* synthetic */ void a(DriveSdkService r100, DriveFileItem r101, FragmentActivity r102, CoroutineScope r103, Fragment r110) {
            r100.E(r101, r102, r103, DriveDownloadPriority.NORMAL, r110);
        }

        public static /* synthetic */ b c(IDriveSdkService r110, DriveListLoadType r111, String r112, boolean r113, int r114, String r115, u79.b r116, int r117) {
            RequestDriveFileListRankType r100 = null;
            if ((r117 & 2) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r117 & 4) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r117 & 8) == 0) goto L13;
            int r103 = 20;
        L15:
            if ((r117 & 16) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r117 & 32) == 0) goto L22;
            r100 = RequestDriveFileListRankType.ACCESS_TIME;
        L22:
            return r110.B(r111, r101, r102, r103, r104, r100, r116);
        L17:
            r104 = r115;
            goto L19
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    w79.b A(DrivePickerScene r100, FragmentActivity r101, ViewGroup r102, c r103, List<DriveFileItem> r104);

    b B(DriveListLoadType r100, String r101, boolean r102, int r103, String r104, RequestDriveFileListRankType r105, u79.b r106);

    void C(DriveFileItem r100, CoroutineScope r101, Function1<? super String, Unit> r102, Function0<Unit> r103);

    void E(DriveFileItem r100, FragmentActivity r101, CoroutineScope r102, DriveDownloadPriority r103, Fragment r104);

    void F(DriveFileItem r100, ImageView r101);

    void H(String r100, String r101, Bundle r102);

    String I(String r100, s r101);

    String J(String r100, String r101, String r102, String r103, String r104, Map r105, DriveUploadPriority r106, bo9.c r107);

    b O(DriveFileItem r100, DriveListLoadType r101, o r102, p r103);

    void P(DriveFileItem r100, kw9.c r101);

    b Q(String r100, int r101, String r102, q r103, r r104);

    b R(String r100, DriveFileType r101, String r102, Function1<? super DriveFileItem, Unit> r103, Function1<? super String, Unit> r104);

    boolean S(List<String> r100);

    List<Integer> U();

    Object b(String r100, int r101, boolean r102, Continuation<? super DriveFileItem> r103);

    void e(ImageView r100, String r101);

    String f(CoroutineScope r100, String r101, int r102, int r103, Function1<? super String, Unit> r104, Function0<Unit> r105);

    void g(List<String> r100);

    void h();

    void k(AbsDriveListFragment.d r100);

    boolean l();

    void m(z79.b r100, Bundle r101);

    void o(ImageView r100, String r101, int r102, String r103);

    String p(String r100, bo9.c r101);

    b q(List<DriveFileItem> r100, DriveListLoadType r101, Function0<Unit> r102, Function1<? super Map<String, Integer>, Unit> r103);

    String r(String r100, String r101, DriveDownloadPriority r102, AbsDriveListViewModel.C114301 r103);

    String t(String r100, String r101, String r102, DriveUploadPriority r103, s r104);

    b u(String r100, int r101, String r102, z r103, a0 r104);

    Object w(Continuation r100);

    String x(long r100);

    void z(DriveFileItem r100);
}
