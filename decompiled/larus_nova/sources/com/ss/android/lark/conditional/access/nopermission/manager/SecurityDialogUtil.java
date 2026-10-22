package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Dialog;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SecurityDialogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Dialog> f418123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Activity> f418124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static InternalSecurityAction f418125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f418126d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Integer> f418127e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f418128f = null;

    static {
        new AtomicBoolean(false);
        f418126d = LazyKt.lazy(SecurityDialogUtil$mainHandler$2.INSTANCE);
        Integer r100 = Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotUpload_Title);
        Integer r101 = Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotDownload_Title);
        Integer r102 = Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotPrint_Title);
        Integer r103 = Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotCopy_Title);
        Integer r104 = Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotDelete_Title);
        Integer r105 = Integer.valueOf(R.string.Lark_FilePolicyMgmtDevice_FailedToShare_Title);
        Integer r106 = Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotView_Title);
        f418127e = MapsKt.mapOf(new Pair[]{TuplesKt.to("IM_MSG_FILE_UPLOAD", r100), TuplesKt.to("CCM_ATTACHMENT_UPLOAD", r100), TuplesKt.to("CCM_FILE_UPLOAD", r100), TuplesKt.to("APPROVAL_FILE_UPLOAD", r100), TuplesKt.to("IM_MSG_FILE_DOWNLOAD", r101), TuplesKt.to("IM_MSG_FILE_SAVE", r101), TuplesKt.to("CCM_ATTACHMENT_DOWNLOAD", r101), TuplesKt.to("CCM_FILE_DOWNLOAD", r101), TuplesKt.to("CCM_EXPORT", r101), TuplesKt.to("APPROVAL_FILE_DOWNLOAD", r101), TuplesKt.to("CCM_PRINT", r102), TuplesKt.to("APPROVAL_FILE_PRINT", r102), TuplesKt.to("IM_MSG_FILE_COPY", r103), TuplesKt.to("CCM_CONTENT_COPY", r103), TuplesKt.to("VC_MM_CONTENT_COPY", r103), TuplesKt.to("CCM_CREATE_COPY", Integer.valueOf(R.string.Lark_Shared_FilePolicyMgmtDevic_CannotMakeACopy_Title)), TuplesKt.to("CCM_MOVE_RECYCLE_BIN", r104), TuplesKt.to("CCM_DELETE_FROM_RECYCLE_BIN", r104), TuplesKt.to("VC_MM_MOVE_RECYCLE_BIN", r104), TuplesKt.to("VC_MM_DELETE_FROM_RECYCLE_BIN", r104), TuplesKt.to("IM_MSG_FILE_SHARE", r105), TuplesKt.to("CCM_SHARE", r105), TuplesKt.to("CCM_AUTH", r105), TuplesKt.to("IM_MSG_FILE_PREVIEW", r106), TuplesKt.to("CCM_CONTENT_PREVIEW", r106), TuplesKt.to("CCM_FILE_PREVIEW", r106), TuplesKt.to("APPROVAL_FILE_PREVIEW", r106), TuplesKt.to("IM_MSG_FILE_READ", r105)});
        Integer r107 = Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantShareToPerson);
        Integer r108 = Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantPreviewSinceSettings);
        f418128f = MapsKt.mapOf(new Pair[]{TuplesKt.to("IM_MSG_FILE_UPLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantUploadBecauseFilePolicy)), TuplesKt.to("CCM_ATTACHMENT_UPLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantUploadAttachBecauseFilePolicy)), TuplesKt.to("CCM_FILE_UPLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantUploadFileBecauseFilePolicy)), TuplesKt.to("APPROVAL_FILE_UPLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantUploadAttachBecauseFilePolicy)), TuplesKt.to("IM_MSG_FILE_DOWNLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantDownloadSinceSettings)), TuplesKt.to("IM_MSG_FILE_SAVE", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantDownloadSinceSettings)), TuplesKt.to("CCM_ATTACHMENT_DOWNLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantDownloadAttach)), TuplesKt.to("CCM_FILE_DOWNLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_OnlyDownloadAllowedFiles)), TuplesKt.to("CCM_EXPORT", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_OnlyDownloadAllowedFiles)), TuplesKt.to("APPROVAL_FILE_DOWNLOAD", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantDownloadAttach)), TuplesKt.to("CCM_PRINT", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantPrintSinceSettings)), TuplesKt.to("APPROVAL_FILE_PRINT", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantPrintSinceSettings)), TuplesKt.to("IM_MSG_FILE_COPY", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_NoCopingAllowed)), TuplesKt.to("CCM_CONTENT_COPY", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantCopySinceSettings)), TuplesKt.to("VC_MM_CONTENT_COPY", Integer.valueOf(R.string.Lark_FilePolicy_ErrorDesc_CantCopyMinutesText)), TuplesKt.to("CCM_CREATE_COPY", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_CantDuplicateSinceSettings)), TuplesKt.to("CCM_MOVE_RECYCLE_BIN", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_OnlyDeleteAllowedFiles)), TuplesKt.to("CCM_DELETE_FROM_RECYCLE_BIN", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_OnlyDeleteAllowedFiles)), TuplesKt.to("VC_MM_MOVE_RECYCLE_BIN", Integer.valueOf(R.string.Lark_FilePolicy_ErrorDesc_CantDeleteMinutes)), TuplesKt.to("VC_MM_DELETE_FROM_RECYCLE_BIN", Integer.valueOf(R.string.Lark_FilePolicy_ErrorDesc_CantDeleteMinutes)), TuplesKt.to("IM_MSG_FILE_SHARE", r107), TuplesKt.to("CCM_SHARE", r107), TuplesKt.to("CCM_AUTH", r107), TuplesKt.to("IM_MSG_FILE_PREVIEW", r108), TuplesKt.to("CCM_CONTENT_PREVIEW", r108), TuplesKt.to("CCM_FILE_PREVIEW", r108), TuplesKt.to("APPROVAL_FILE_PREVIEW", r108), TuplesKt.to("IM_MSG_FILE_READ", Integer.valueOf(R.string.Lark_Conditions_FilePolicy_Dialog_UnableToAccessFile))});
    }

    public static Pair a(String r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        Integer r101 = f418127e.get(r100);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        Integer r103 = f418128f.get(r100);
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L11:
        return new Pair(Integer.valueOf(r102), Integer.valueOf(r104));
    L9:
        r104 = R.string.Lark_Conditions_FilePolicy_Dialog_NoActionsAllowedBCOrgSettings;
        goto L11
    L5:
        r102 = R.string.Lark_Conditions_FilePolicy_Dialog_NoActionsAllowed;
        goto L6
    }

    public static void b(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        List<DecisionData.Action> r101 = CollectionsKt.toMutableList(r100.getActions());
        r101.remove(r100.getCurrentAction());
        r100.setActions(r101);
        DecisionData.Action r102 = (DecisionData.Action) CollectionsKt.firstOrNull(r101);
        if (r102 != null) goto L5;
        r102 = new DecisionData.Action();
    L5:
        r100.setCurrentAction(r102);
        PublishSubject<InternalSecurityAction> r103 = RegulateDispatcher.f418428a;
        Object r104 = r100.getInternalParams().get("comeFrom");
        if (r104 != null) goto L8;
        r104 = "SDK_INTERNAL";
    L8:
        RegulateDispatcher.a(r100, (String) r104);
    }
}
