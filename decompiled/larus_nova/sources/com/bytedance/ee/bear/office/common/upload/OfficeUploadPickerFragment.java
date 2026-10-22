package com.bytedance.ee.bear.office.common.upload;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelectionRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadTarget;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J.\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\"\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\t2\u0010\u0010'\u001a\f\u0012\b\u0012\u00060)j\u0002`*0(H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0002J\u001e\u0010.\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001000H\u0002J\f\u00101\u001a\u000202*\u00020\u0007H\u0002J\u0012\u00103\u001a\b\u0012\u0004\u0012\u00020\t0(*\u00020\u0007H\u0002J\f\u00104\u001a\u000205*\u00020\u0005H\u0002J\f\u00106\u001a\u00020\t*\u000207H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadPickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "pendingTarget", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;", "pendingType", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadActionType;", "pendingRequestId", "", "pendingGuardContext", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadGuardContext;", "callbackConsumed", "", "launching", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "open", "type", PickerReporterConstants.KEY.TARGET, ShortVideoSegments.KEY_PROP_PROVIDER, "", "guardContext", "restorePendingState", "state", "clearPendingState", "requestHostPicker", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionProvider;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "buildCallback", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionCallback;", "consumeSelected", "requestId", "selections", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadSelection;", "handlePermissionAction", "action", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadAvailability$PermissionAction;", "consumeTerminal", "block", "Lkotlin/Function0;", "toHeaderAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "acceptedMimeTypes", "toExternalTarget", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "toLogKey", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadAvailability;", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUploadPickerFragment extends Fragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f235282j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f235283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeUploadActionType f235284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f235285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t f235286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f235287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f235288i;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235289a = null;

        static {
            int[] r100 = new int[OfficeUploadActionType.values().length];
            r100[OfficeUploadActionType.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OfficeUploadActionType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f235289a = r100;
        }
    }

    static {
    }

    public OfficeUploadPickerFragment() {
    }

    public static final void S90(OfficeUploadPickerFragment r100) {
        r100.f235283d = null;
        r100.f235284e = null;
        r100.f235285f = null;
        r100.f235286g = null;
        r100.f235287h = false;
        r100.f235288i = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L40;
        String r101 = r100.getString("office_upload_pending_type");
        g0 r102 = null;
        if (r101 != null) goto L38;
        OfficeUploadActionType r103 = null;
    L15:
        this.f235284e = r103;
        this.f235285f = r100.getString("office_upload_pending_request_id");
        this.f235287h = r100.getBoolean("office_upload_callback_consumed", false);
        String r104 = r100.getString("office_upload_pending_target_type");
        if (r104 == null) goto L36;
        int r105 = r104.hashCode();
        if (r105 == (-1268966290)) goto L26;
        if (r105 != (-867198576)) goto L36;
        if (r104.equals("root_mine") == false) goto L36;
        r102 = g0.b.f235371a;
        goto L36
    L26:
        if (r104.equals(DocumentType.FOLDER_NAME) == false) goto L36;
        String r106 = r100.getString("office_upload_pending_folder_token");
        if (r106 == null) goto L36;
        if ((!StringsKt.isBlank(r106)) == true) goto L34;
        r106 = null;
    L34:
        if (r106 == null) goto L36;
        r102 = new g0.a(r106);
    L36:
        this.f235283d = r102;
        this.f235288i = r100.getBoolean("office_upload_launching", false);
        return;
    L38:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L8
        Object r108 = Result.m9449constructorimpl(OfficeUploadActionType.valueOf(r101));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r108) == false) goto L13;
        r108 = null;
    L13:
        r103 = (OfficeUploadActionType) r108;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        OfficeUploadActionType r101 = this.f235284e;
        if (r101 == null) goto L5;
        String r102 = r101.name();
    L6:
        r100.putString("office_upload_pending_type", r102);
        r100.putString("office_upload_pending_request_id", this.f235285f);
        r100.putBoolean("office_upload_callback_consumed", this.f235287h);
        g0 r103 = this.f235283d;
        if (Intrinsics.areEqual(r103, g0.b.f235371a) == false) goto L10;
        r100.putString("office_upload_pending_target_type", "root_mine");
    L13:
        r100.putBoolean("office_upload_launching", this.f235288i);
        return;
    L10:
        if ((r103 instanceof g0.a) == false) goto L12;
        r100.putString("office_upload_pending_target_type", DocumentType.FOLDER_NAME);
        r100.putString("office_upload_pending_folder_token", ((g0.a) r103).f235370a);
        goto L13
    L12:
        if (r103 == null) goto L13;
        throw new NoWhenBranchMatchedException();
    L5:
        r102 = null;
        goto L6
    }

    public final void T90(String r100, Function0<Unit> r101) {
        String r102 = this.f235285f;
        if (StringsKt.isBlank(r100) == false) goto L5;
    L13:
        tt5.a.k("OfficeUploadPickerFragment", "ignore stale upload callback, current=" + r102 + ", incoming=" + r100);
        return;
    L5:
        if (Intrinsics.areEqual(r100, r102) == false) goto L13;
        if (this.f235287h == false) goto L11;
        tt5.a.k("OfficeUploadPickerFragment", "ignore duplicate upload callback, requestId=" + r100);
        return;
    L11:
        this.f235287h = true;
        r101.invoke();
    }

    public final boolean U90(OfficeUploadActionType r110, g0 r111, Object r210, t r211) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        if (this.f235288i == false) goto L5;
        return false;
    L5:
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L8;
        return false;
    L8:
        int r101 = com.bytedance.ee.bear.office.common.upload.a.f235336a;
        Context r102 = r100.getApplicationContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r103 = r102.getApplicationContext();
        if ((r103 instanceof Application) == false) goto L11;
        Application r104 = (Application) r103;
    L11:
        this.f235288i = true;
        this.f235284e = r110;
        this.f235283d = r111;
        this.f235286g = r211;
        this.f235285f = UUID.randomUUID().toString();
        this.f235287h = false;
        int[] r112 = b.f235289a;
        int r113 = r112[r110.ordinal()];
        if (r113 == 1) goto L17;
        if (r113 != 2) goto L16;
        OfficeSpaceHeaderAction r114 = OfficeSpaceHeaderAction.UPLOAD_FILE;
    L19:
        if (Intrinsics.areEqual(r111, g0.b.f235371a) == false) goto L22;
        OfficeSpaceUploadTarget r115 = OfficeSpaceUploadTarget.RootMine.INSTANCE;
    L24:
        String r105 = this.f235285f;
        if (r105 != null) goto L27;
        r105 = "";
    L27:
        String r116 = r105;
        int r106 = r112[r110.ordinal()];
        if (r106 == 1) goto L33;
        if (r106 != 2) goto L32;
        List r107 = CollectionsKt.emptyList();
    L35:
        if (r110 != OfficeUploadActionType.MEDIA) goto L37;
        boolean r117 = true;
    L38:
        OfficeSpaceUploadSelectionRequest r108 = new OfficeSpaceUploadSelectionRequest(r114, r115, 99, r116, r107, r117);
        if ((r210 instanceof com.bytedance.ee.bear.office.export.space.o) == false) goto L41;
        com.bytedance.ee.bear.office.export.space.o r109 = (com.bytedance.ee.bear.office.export.space.o) r210;
    L42:
        if (r109 != null) goto L73;
    L54:
        o r118 = new o(r100);
        Function1<List<? extends OfficeSpaceUploadSelection>, Unit> r119 = new OfficeUploadPickerFragment$open$1(this);
        OfficeUploadPickerFragment$open$2 r120 = new OfficeUploadPickerFragment$open$2(this);
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r119, "onSelected");
        Intrinsics.checkNotNullParameter(r120, "onCancel");
        int r121 = com.bytedance.ee.bear.office.common.upload.a.f235336a;
        Context r122 = r118.f235406a.getApplicationContext();
        Intrinsics.checkNotNullParameter(r122, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r123 = r122.getApplicationContext();
        if ((r123 instanceof Application) == false) goto L57;
        Application r124 = (Application) r123;
    L57:
        StringBuilder r125 = new StringBuilder("open picker, type=");
        r125.append(r110);
        r125.append(", activityActive=");
        if (r118.f235406a.isFinishing() == false) goto L60;
    L62:
        boolean r126 = false;
    L63:
        r125.append(r126);
        tt5.a.h("OfficeUploadFileSelector", r125.toString());
        int r127 = o.b.f235407a[r110.ordinal()];
        if (r127 == 1) goto L69;
        if (r127 != 2) goto L68;
        FileSelectConfig.f r128 = FileSelectConfig.filePickerBuilder();
        r128.f226780a.customSendBtnTips = r118.f235406a.getString(R.string.Doc_Facade_Upload);
        p r129 = new p(r118, r119, r120);
        FileSelectConfig r130 = r128.f226780a;
        r130.fileSelectListener = r129;
        r130.permissionCheckListener = new q(r120);
        FileSelectConfig r131 = r128.a();
        Intrinsics.checkNotNull(r131);
        r118.c(r131, r120);
    L70:
        return true;
    L68:
        throw new NoWhenBranchMatchedException();
    L69:
        int r132 = com.bytedance.ee.bear.fileselector.d.f226786a;
        FragmentActivity r133 = r118.f235406a;
        FragmentManager r134 = r133.getSupportFragmentManager();
        FileSelectConfig.g r135 = FileSelectConfig.fullScreenAlbumBuilder();
        FileSelectConfig r136 = r135.f226780a;
        r136.showGif = true;
        r136.sourceType = 2;
        r136.showOrigin = true;
        r136.checkedKeepOrigin = true;
        r136.isOriginFile = true;
        r136.mediaType = 2;
        r136.maxSelectImageNum = 99;
        r136.enableImageCompress = true;
        r136.larkAlbumActionType = 2;
        r r137 = new r(r118, r119, r120);
        FileSelectConfig r138 = r135.f226780a;
        r138.fileSelectListener = r137;
        r138.permissionCheckListener = new s(r120);
        com.bytedance.ee.bear.fileselector.d.a.c(r133, r134, r135.a(), "OfficeUploadFileSelector");
        goto L70
    L60:
        if (r118.f235406a.isDestroyed() == true) goto L62;
        r126 = true;
        goto L63
    L73:
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L45
        Object r140 = Result.m9449constructorimpl(r109.NF(r108, new OfficeUploadPickerFragment$buildCallback$1(this)));     // Catch: Throwable -> L45
    L47:
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L52;
        tt5.a.l("OfficeUploadPickerFragment", "typed upload provider failed, requestId=" + r108.getRequestId(), r141);
        r140 = OfficeSpaceActionResult.NotHandled.INSTANCE;
    L52:
        if (Intrinsics.areEqual((OfficeSpaceActionResult) r140, OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L54;
        return true;
    L45:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L41:
        r109 = null;
        goto L42
    L37:
        r117 = false;
        goto L38
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r107 = CollectionsKt.listOf(new String[]{"image/*", "video/*"});
        goto L35
    L22:
        if ((r111 instanceof g0.a) == false) goto L72;
        r115 = new OfficeSpaceUploadTarget.Folder(((g0.a) r111).f235370a);
        goto L24
    L72:
        throw new NoWhenBranchMatchedException();
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r114 = OfficeSpaceHeaderAction.UPLOAD_IMAGE;
        goto L19
    }
}
