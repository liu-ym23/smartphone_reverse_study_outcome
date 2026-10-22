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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J.\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\"\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\t2\u0010\u0010'\u001a\f\u0012\b\u0012\u00060)j\u0002`*0(H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0002J\u001e\u0010.\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001000H\u0002J\f\u00101\u001a\u000202*\u00020\u0007H\u0002J\u0012\u00103\u001a\b\u0012\u0004\u0012\u00020\t0(*\u00020\u0007H\u0002J\f\u00104\u001a\u000205*\u00020\u0005H\u0002J\f\u00106\u001a\u00020\t*\u000207H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadPickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "pendingTarget", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;", "pendingType", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadActionType;", "pendingRequestId", "", "pendingGuardContext", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadGuardContext;", "callbackConsumed", "", "launching", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "open", ResourceData.KEY_TYPE, "target", "provider", "", "guardContext", "restorePendingState", "state", "clearPendingState", "requestHostPicker", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionProvider;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "buildCallback", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionCallback;", "consumeSelected", "requestId", "selections", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadSelection;", "handlePermissionAction", "action", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadAvailability$PermissionAction;", "consumeTerminal", "block", "Lkotlin/Function0;", "toHeaderAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "acceptedMimeTypes", "toExternalTarget", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadTarget;", "toLogKey", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadAvailability;", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUploadPickerFragment extends Fragment {
    public static final /* synthetic */ int j = 0;
    public g0 d;
    public OfficeUploadActionType e;
    public String f;
    public t g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeUploadActionType.values().length];
            r0[OfficeUploadActionType.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OfficeUploadActionType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public OfficeUploadPickerFragment() {
    }

    public static final void S90(OfficeUploadPickerFragment r1) {
        r1.d = null;
        r1.e = null;
        r1.f = null;
        r1.g = null;
        r1.h = false;
        r1.i = false;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        if (r6 == null) goto L40;
        String r0 = r6.getString("office_upload_pending_type");
        g0 r1 = null;
        if (r0 != null) goto L38;
        OfficeUploadActionType r2 = null;
    L15:
        this.e = r2;
        this.f = r6.getString("office_upload_pending_request_id");
        this.h = r6.getBoolean("office_upload_callback_consumed", false);
        String r3 = r6.getString("office_upload_pending_target_type");
        if (r3 == null) goto L36;
        int r4 = r3.hashCode();
        if (r4 == (-1268966290)) goto L26;
        if (r4 != (-867198576)) goto L36;
        if (r3.equals("root_mine") == false) goto L36;
        r1 = g0.b.a;
        goto L36
    L26:
        if (r3.equals(DocumentType.FOLDER_NAME) == false) goto L36;
        String r5 = r6.getString("office_upload_pending_folder_token");
        if (r5 == null) goto L36;
        if ((!StringsKt.isBlank(r5)) == true) goto L34;
        r5 = null;
    L34:
        if (r5 == null) goto L36;
        r1 = new g0.a(r5);
    L36:
        this.d = r1;
        this.i = r6.getBoolean("office_upload_launching", false);
        return;
    L38:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(OfficeUploadActionType.valueOf(r0));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r8) == false) goto L13;
        r8 = null;
    L13:
        r2 = (OfficeUploadActionType) r8;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        super.onSaveInstanceState(r4);
        OfficeUploadActionType r0 = this.e;
        if (r0 == null) goto L5;
        String r1 = r0.name();
    L6:
        r4.putString("office_upload_pending_type", r1);
        r4.putString("office_upload_pending_request_id", this.f);
        r4.putBoolean("office_upload_callback_consumed", this.h);
        g0 r2 = this.d;
        if (Intrinsics.areEqual(r2, g0.b.a) == false) goto L10;
        r4.putString("office_upload_pending_target_type", "root_mine");
    L13:
        r4.putBoolean("office_upload_launching", this.i);
        return;
    L10:
        if ((r2 instanceof g0.a) == false) goto L12;
        r4.putString("office_upload_pending_target_type", DocumentType.FOLDER_NAME);
        r4.putString("office_upload_pending_folder_token", ((g0.a) r2).a);
        goto L13
    L12:
        if (r2 == null) goto L13;
        throw new NoWhenBranchMatchedException();
    L5:
        r1 = null;
        goto L6
    }

    public final void T90(String r4, Function0<Unit> r5) {
        String r0 = this.f;
        if (StringsKt.isBlank(r4) == false) goto L5;
    L13:
        tt5.a.k("OfficeUploadPickerFragment", "ignore stale upload callback, current=" + r0 + ", incoming=" + r4);
        return;
    L5:
        if (Intrinsics.areEqual(r4, r0) == false) goto L13;
        if (this.h == false) goto L11;
        tt5.a.k("OfficeUploadPickerFragment", "ignore duplicate upload callback, requestId=" + r4);
        return;
    L11:
        this.h = true;
        r5.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.bytedance.ee.bear.office.common.upload.OfficeUploadPickerFragment$buildCallback$1] */
    public final boolean U90(OfficeUploadActionType r18, g0 r19, Object r20, t r21) {
        Intrinsics.checkNotNullParameter(r18, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r19, "target");
        if (this.i == false) goto L5;
        return false;
    L5:
        FragmentActivity r5 = getActivity();
        if (r5 != null) goto L8;
        return false;
    L8:
        int r7 = com.bytedance.ee.bear.office.common.upload.a.a;
        Context r8 = r5.getApplicationContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        Context r9 = r8.getApplicationContext();
        if ((r9 instanceof Application) == false) goto L11;
        Application r10 = (Application) r9;
    L11:
        this.i = true;
        this.e = r18;
        this.d = r19;
        this.g = r21;
        this.f = UUID.randomUUID().toString();
        this.h = false;
        int[] r11 = b.a;
        int r12 = r11[r18.ordinal()];
        if (r12 == 1) goto L17;
        if (r12 != 2) goto L16;
        OfficeSpaceHeaderAction r13 = OfficeSpaceHeaderAction.UPLOAD_FILE;
    L19:
        if (Intrinsics.areEqual(r19, g0.b.a) == false) goto L22;
        OfficeSpaceUploadTarget r14 = OfficeSpaceUploadTarget.RootMine.INSTANCE;
    L24:
        String r0 = this.f;
        if (r0 != null) goto L27;
        r0 = "";
    L27:
        String r15 = r0;
        int r1 = r11[r18.ordinal()];
        if (r1 == 1) goto L33;
        if (r1 != 2) goto L32;
        List r2 = CollectionsKt.emptyList();
    L35:
        if (r18 != OfficeUploadActionType.MEDIA) goto L37;
        boolean r16 = true;
    L38:
        OfficeSpaceUploadSelectionRequest r17 = new OfficeSpaceUploadSelectionRequest(r13, r14, 99, r15, r2, r16);
        if ((r20 instanceof com.bytedance.ee.bear.office.export.space.o) == false) goto L41;
        com.bytedance.ee.bear.office.export.space.o r3 = (com.bytedance.ee.bear.office.export.space.o) r20;
    L42:
        if (r3 != 0) goto L73;
    L54:
        o r4 = new o(r5);
        Function1<List<? extends OfficeSpaceUploadSelection>, Unit> r6 = new OfficeUploadPickerFragment$open$1(this);
        OfficeUploadPickerFragment$open$2 r22 = new OfficeUploadPickerFragment$open$2(this);
        Intrinsics.checkNotNullParameter(r18, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r6, "onSelected");
        Intrinsics.checkNotNullParameter(r22, "onCancel");
        int r23 = com.bytedance.ee.bear.office.common.upload.a.a;
        Context r24 = r4.a.getApplicationContext();
        Intrinsics.checkNotNullParameter(r24, "context");
        Context r25 = r24.getApplicationContext();
        if ((r25 instanceof Application) == false) goto L57;
        Application r26 = (Application) r25;
    L57:
        StringBuilder r27 = new StringBuilder("open picker, type=");
        r27.append(r18);
        r27.append(", activityActive=");
        if (r4.a.isFinishing() == false) goto L60;
    L62:
        boolean r28 = false;
    L63:
        r27.append(r28);
        tt5.a.h("OfficeUploadFileSelector", r27.toString());
        int r29 = o.b.a[r18.ordinal()];
        if (r29 == 1) goto L69;
        if (r29 != 2) goto L68;
        FileSelectConfig.f r30 = FileSelectConfig.filePickerBuilder();
        ((FileSelectConfig.c) r30).a.customSendBtnTips = r4.a.getString(2131887846);
        p r31 = new p(r4, r6, r22);
        FileSelectConfig r32 = ((FileSelectConfig.c) r30).a;
        r32.fileSelectListener = r31;
        r32.permissionCheckListener = new q(r22);
        FileSelectConfig r33 = r30.a();
        Intrinsics.checkNotNull(r33);
        r4.c(r33, r22);
    L70:
        return true;
    L68:
        throw new NoWhenBranchMatchedException();
    L69:
        int r34 = com.bytedance.ee.bear.fileselector.d.a;
        FragmentActivity r35 = r4.a;
        FragmentManager r36 = r35.getSupportFragmentManager();
        FileSelectConfig.g r37 = FileSelectConfig.fullScreenAlbumBuilder();
        FileSelectConfig r110 = ((FileSelectConfig.c) r37).a;
        r110.showGif = true;
        r110.sourceType = 2;
        r110.showOrigin = true;
        r110.checkedKeepOrigin = true;
        r110.isOriginFile = true;
        r110.mediaType = 2;
        r110.maxSelectImageNum = 99;
        r110.enableImageCompress = true;
        r110.larkAlbumActionType = 2;
        r r38 = new r(r4, r6, r22);
        FileSelectConfig r39 = ((FileSelectConfig.c) r37).a;
        r39.fileSelectListener = r38;
        r39.permissionCheckListener = new s(r22);
        com.bytedance.ee.bear.fileselector.d.a.c(r35, r36, r37.a(), "OfficeUploadFileSelector");
        goto L70
    L60:
        if (r4.a.isDestroyed() == true) goto L62;
        r28 = true;
        goto L63
    L73:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L45
        Object r41 = Result.constructor-impl(r3.NF(r17, new OfficeUploadPickerFragment$buildCallback$1(this)));     // Catch: Throwable -> L45
    L47:
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 == null) goto L52;
        tt5.a.l("OfficeUploadPickerFragment", "typed upload provider failed, requestId=" + r17.getRequestId(), r42);
        r41 = OfficeSpaceActionResult.NotHandled.INSTANCE;
    L52:
        if (Intrinsics.areEqual((OfficeSpaceActionResult) r41, OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L54;
        return true;
    L45:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L41:
        r3 = 0;
        goto L42
    L37:
        r16 = false;
        goto L38
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r2 = CollectionsKt.listOf(new String[]{"image/*", "video/*"});
        goto L35
    L22:
        if ((r19 instanceof g0.a) == false) goto L72;
        r14 = new OfficeSpaceUploadTarget.Folder(((g0.a) r19).a);
        goto L24
    L72:
        throw new NoWhenBranchMatchedException();
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r13 = OfficeSpaceHeaderAction.UPLOAD_IMAGE;
        goto L19
    }
}
