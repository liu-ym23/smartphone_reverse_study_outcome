package com.larus.office.card.doc.download;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;
import com.larus.common_ui.view.FileExportType;
import com.larus.common_ui.view.FileExportTypeItemView;
import com.larus.nova.R;
import com.larus.office.card.databinding.LarusDialogDocExportChooseBinding;
import com.larus.platform.api.IFlowDocExportConfigProvider;
import com.larus.platform.api.IFlowOfficeExportService;
import com.larus.platform.api.IFlowOfficeWikiTokenResolver;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.b1;
import tx9.u0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\tH\u0002J\u001c\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u00101\u001a\u00020)2\u0006\u0010/\u001a\u00020\u000e2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\tH\u0002J\b\u00103\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u0004\u0018\u000109H\u0082@¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u000bH\u0002J\b\u0010<\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006?"}, d2 = {"Lcom/larus/office/card/doc/download/DocExportChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/office/card/databinding/LarusDialogDocExportChooseBinding;", "exportType", "Lcom/larus/common_ui/view/FileExportType;", "resourceId", "", "resourceType", "", "resourceVersion", "hasCancel", "", "showFrom", "currentPage", "artifactMetaId", "docTitle", "activeExportResourceId", "exportActionId", "exportStartTime", "", "passback", "paneAwareController", "Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "getPaneAwareController", "()Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "paneAwareController$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "trackClick", "fileType", "clickFrom", "trackExportResult", "success", "errorMsg", "trackDownload", "reason", "parseArgument", "onFileTypeChange", "type", "newExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "resolveExportResource", "Lcom/larus/office/card/doc/download/DocExportChooseDialog$ExportResource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrackingResourceType", "onDestroyView", "Companion", "ExportResource", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocExportChooseDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f361380s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogDocExportChooseBinding f361381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FileExportType f361382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f361383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f361384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f361385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f361386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f361387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f361388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f361389l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f361390m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f361391n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f361392o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f361393p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f361394q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f361395r;

    public static final class a {
        public static void a(DocExportChooseDialog r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            r100.dismiss();     // Catch: Throwable -> L5 Exception -> L7
        L18:
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L5
            Throwable r101 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L5
            if (r101 == null) goto L17;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L5
            return;
        L17:
            return;
        L5:
            th = move-exception;
            FLogger.f375446a.e("DocExportChooseDialog", "dialog dismiss error: " + th);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f361397b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f361396a, r101.f361396a) == true) goto L12;
            return false;
        L12:
            if (this.f361397b == r101.f361397b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f361396a.hashCode() * 31) + this.f361397b;
        }

        public final String toString() {
            return "ExportResource(resourceId=" + this.f361396a + ", resourceType=" + this.f361397b + ')';
        }

        public b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "resourceId");
            this.f361396a = r100;
            this.f361397b = r101;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f361386i = true;
        W90(false, "Cancelled");
        IFlowOfficeExportService r100 = (IFlowOfficeExportService) ServiceManager.get().getService(IFlowOfficeExportService.class);
        if (r100 == null) goto L8;
        String r101 = this.f361391n;
        if (StringsKt.isBlank(r101) == false) goto L7;
        r101 = this.f361383f;
    L7:
        r100.a(r101);
    L8:
        ((PaneAwareBottomSheetController) this.f361395r.getValue()).e();
        super.onDestroyView();
    }

    public DocExportChooseDialog() {
        this.f361382e = FileExportType.word;
        this.f361383f = "";
        this.f361385h = -1;
        this.f361387j = "";
        this.f361388k = "";
        this.f361389l = "";
        this.f361390m = "";
        this.f361391n = "";
        this.f361392o = UUID.randomUUID().toString();
        this.f361395r = LazyKt.lazy(new e(this));
    }

    public final void T90(FileExportType r100) {
        this.f361382e = r100;
        FileExportTypeItemView[] r101 = new FileExportTypeItemView[3];
        LarusDialogDocExportChooseBinding r102 = this.f361381d;
        LarusDialogDocExportChooseBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r101[0] = r102.f361341h;
        LarusDialogDocExportChooseBinding r104 = this.f361381d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r101[1] = r104.f361338e;
        LarusDialogDocExportChooseBinding r105 = this.f361381d;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r101[2] = r103.f361340g;
        Iterator r106 = CollectionsKt.listOf(r101).iterator();
    L14:
        if (r106.hasNext() == false) goto L20;
        FileExportTypeItemView r107 = (FileExportTypeItemView) r106.next();
        if (r107.getFileType() != r100) goto L18;
        boolean r108 = true;
    L19:
        r107.setSelected(r108);
        goto L14
    L18:
        r108 = false;
        goto L19
    L20:
        return;
    L11:
        r103 = r105;
        goto L12
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return ((PaneAwareBottomSheetController) this.f361395r.getValue()).b();
    }

    public static final Object S90(DocExportChooseDialog r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DocExportChooseDialog$resolveExportResource$1) == false) goto L7;
        DocExportChooseDialog$resolveExportResource$1 r102 = (DocExportChooseDialog$resolveExportResource$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L22:
        String r107 = (String) r104;
        if (r107 != null) goto L28;
    L25:
        return null;
    L28:
        return new b(r107, 10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r108 = r100.f361384g;
        if (r108 != 14) goto L27;
        IFlowOfficeWikiTokenResolver r109 = (IFlowOfficeWikiTokenResolver) ServiceManager.get().getService(IFlowOfficeWikiTokenResolver.class);
        if (r109 == null) goto L25;
        String r110 = r100.f361383f;
        r102.label = 1;
        r104 = r109.a(r110, r102);
        if (r104 != r105) goto L22;
        return r105;
    L27:
        return new b(r100.f361383f, r108);
    L7:
        r102 = new DocExportChooseDialog$resolveExportResource$1(r100, r101);
        goto L8
    }

    public final void U90(FileExportType r110, String r111) {
        String r100 = this.f361392o;
        String r112 = this.f361383f;
        String r113 = this.f361389l;
        int r101 = this.f361384g;
        if (r101 != 14) goto L5;
        r101 = 10;
    L5:
        String r114 = this.f361387j;
        ActivityResultCaller r102 = getParentFragment();
        if ((r102 instanceof by7.e) == false) goto L8;
        by7.e r103 = (by7.e) r102;
    L9:
        String r104 = r110.toFileTypeStr();
        Integer r115 = Integer.valueOf(r101);
        b1.a(null, null, null, r104, r100, r111, null, null, null, r112, r113, r115, r114, r103, 25031);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void V90(boolean r110, String r111) {
        String r100 = this.f361387j;
        String r101 = this.f361383f;
        String r102 = this.f361389l;
        int r103 = this.f361384g;
        if (r103 != 14) goto L5;
        r103 = 10;
    L5:
        if (r110 == false) goto L7;
        String r112 = "1";
    L8:
        String r104 = this.f361388k;
        ActivityResultCaller r105 = getParentFragment();
        if ((r105 instanceof by7.e) == false) goto L11;
        by7.e r106 = (by7.e) r105;
    L12:
        Integer r107 = Integer.valueOf(r103);
        String r108 = r112;
        u0.f(r100, r108, r111, "download", r101, r102, r107, r104, null, r106, 256);
        return;
    L11:
        r106 = null;
        goto L12
    L7:
        r112 = "0";
        goto L8
    }

    public final void W90(boolean r110, String r111) {
        if (this.f361393p <= 0) goto L12;
        if (r110 == false) goto L6;
        String r112 = "1";
    L7:
        String r100 = r112;
        String r101 = this.f361383f;
        String r102 = this.f361382e.toFileTypeStr();
        Long r103 = Long.valueOf(System.currentTimeMillis() - this.f361393p);
        int r113 = this.f361384g;
        if (r113 != 14) goto L10;
        r113 = 10;
    L10:
        u0.c(r100, r101, r102, r103, r111, Integer.valueOf(r113), null, 192);
        this.f361393p = 0;
        return;
    L6:
        r112 = "0";
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        Bundle r100 = getArguments();
        LarusDialogDocExportChooseBinding r101 = null;
        String r102 = "";
        if (r100 == null) goto L5;
        String r103 = r100.getString("export_resource_id", "");
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f361383f = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L11;
        int r105 = r104.getInt("export_resource_type", 0);
    L12:
        this.f361384g = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L15;
        int r107 = r106.getInt("export_resource_version", 0);
    L16:
        this.f361385h = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L19;
        String r109 = r108.getString("export_show_from", "");
    L20:
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        this.f361387j = r109;
        Bundle r110 = getArguments();
        if (r110 == null) goto L25;
        String r111 = r110.getString("current_page", "");
    L26:
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        this.f361388k = r111;
        Bundle r112 = getArguments();
        if (r112 == null) goto L31;
        String r113 = r112.getString("export_artifact_meta_id", "");
    L32:
        if (r113 != null) goto L34;
        r113 = "";
    L34:
        this.f361389l = r113;
        Bundle r114 = getArguments();
        if (r114 == null) goto L37;
        String r115 = r114.getString("export_doc_title", "");
    L38:
        if (r115 == null) goto L41;
        r102 = r115;
    L41:
        this.f361390m = r102;
        Bundle r116 = getArguments();
        if (r116 == null) goto L44;
        String r117 = r116.getString("export_sub_type", null);
    L45:
        this.f361394q = r117;
        Dialog r118 = getDialog();
        if (r118 == null) goto L48;
        r118.setOnShowListener(new com.larus.office.card.doc.download.a(this));
    L48:
        LarusDialogDocExportChooseBinding r119 = this.f361381d;
        if (r119 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L51:
        r119.f361341h.setItemType(FileExportType.word);
        LarusDialogDocExportChooseBinding r120 = this.f361381d;
        if (r120 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L54:
        r120.f361338e.setItemType(FileExportType.pdf);
        LarusDialogDocExportChooseBinding r121 = this.f361381d;
        if (r121 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L57:
        r121.f361340g.setItemType(FileExportType.txt);
        IFlowDocExportConfigProvider r122 = (IFlowDocExportConfigProvider) ServiceManager.get().getService(IFlowDocExportConfigProvider.class);
        if (r122 != null) goto L60;
    L62:
        boolean r123 = false;
    L63:
        if (r123 == false) goto L69;
        LarusDialogDocExportChooseBinding r124 = this.f361381d;
        if (r124 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L67:
        r124.f361340g.setVisibility(8);
    L69:
        if (r123 == false) goto L77;
        FileExportTypeItemView[] r125 = new FileExportTypeItemView[2];
        LarusDialogDocExportChooseBinding r126 = this.f361381d;
        if (r126 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L73:
        r125[0] = r126.f361341h;
        LarusDialogDocExportChooseBinding r127 = this.f361381d;
        if (r127 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r127 = null;
    L76:
        r125[1] = r127.f361338e;
        final List r128 = CollectionsKt.listOf(r125);
    L87:
        Iterator r129 = r128.iterator();
    L89:
        if (r129.hasNext() == false) goto L98;
        final FileExportTypeItemView r130 = (FileExportTypeItemView) r129.next();
        e1.d(r130, new com.larus.office.card.doc.download.b(this, r130));
        String r131 = this.f361392o;
        String r132 = this.f361383f;
        String r133 = this.f361389l;
        int r134 = this.f361384g;
        if (r134 != 14) goto L93;
        r134 = 10;
    L93:
        String r135 = this.f361387j;
        ActivityResultCaller r136 = getParentFragment();
        if ((r136 instanceof by7.e) == false) goto L96;
        by7.e r137 = (by7.e) r136;
    L97:
        b1.b(null, null, r135, r131, null, null, null, r132, r133, Integer.valueOf(r134), r130.getFileType().toFileTypeStr(), null, r137, 6259);
        goto L89
    L96:
        r137 = null;
        goto L97
    L98:
        T90(FileExportType.word);
        LarusDialogDocExportChooseBinding r138 = this.f361381d;
        if (r138 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r138 = null;
    L101:
        e1.d(r138.f361335b, new c(this));
        LarusDialogDocExportChooseBinding r139 = this.f361381d;
        if (r139 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L105:
        e1.d(r101.f361339f, new d(this, r128));
        Context r140 = getContext();
        if (r140 == null) goto L116;
        Dialog r141 = getDialog();
        if (r141 == null) goto L117;
        Window r142 = r141.getWindow();
        if (r142 == null) goto L118;
        r142.setNavigationBarColor(v19.c.a(R.attr.larus_base_3, r140, R.color.larus_base_3));
        return;
    L118:
        return;
    L117:
        return;
    L116:
        return;
    L104:
        r101 = r139;
        goto L105
    L77:
        FileExportTypeItemView[] r143 = new FileExportTypeItemView[3];
        LarusDialogDocExportChooseBinding r144 = this.f361381d;
        if (r144 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r144 = null;
    L80:
        r143[0] = r144.f361341h;
        LarusDialogDocExportChooseBinding r145 = this.f361381d;
        if (r145 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r145 = null;
    L83:
        r143[1] = r145.f361338e;
        LarusDialogDocExportChooseBinding r146 = this.f361381d;
        if (r146 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r146 = null;
    L86:
        r143[2] = r146.f361340g;
        r128 = CollectionsKt.listOf(r143);
        goto L87
    L60:
        if (r122.a() != true) goto L62;
        r123 = true;
        goto L63
    L44:
        r117 = null;
        goto L45
    L37:
        r115 = null;
        goto L38
    L31:
        r113 = null;
        goto L32
    L25:
        r111 = null;
        goto L26
    L19:
        r109 = null;
        goto L20
    L15:
        r107 = 0;
        goto L16
    L11:
        r105 = 0;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialog_doc_export_choose, r111, false);
        int r114 = R.id.cancel;
        AppCompatImageView r100 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.cancel);
        if (r100 == null) goto L21;
        r114 = R.id.download_progress;
        ProgressBar r101 = (ProgressBar) ViewBindings.findChildViewById(r113, R.id.download_progress);
        if (r101 == null) goto L21;
        r114 = R.id.download_text;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r113, R.id.download_text);
        if (r102 == null) goto L21;
        r114 = R.id.pdfType;
        FileExportTypeItemView r103 = (FileExportTypeItemView) ViewBindings.findChildViewById(r113, R.id.pdfType);
        if (r103 == null) goto L21;
        r114 = R.id.previewFile;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.previewFile);
        if (r104 == null) goto L21;
        r114 = R.id.title;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.title)) == null) goto L21;
        r114 = R.id.txtType;
        FileExportTypeItemView r105 = (FileExportTypeItemView) ViewBindings.findChildViewById(r113, R.id.txtType);
        if (r105 == null) goto L21;
        r114 = R.id.wordType;
        FileExportTypeItemView r106 = (FileExportTypeItemView) ViewBindings.findChildViewById(r113, R.id.wordType);
        if (r106 == null) goto L21;
        ConstraintLayout r115 = (ConstraintLayout) r113;
        this.f361381d = new LarusDialogDocExportChooseBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        return ((PaneAwareBottomSheetController) this.f361395r.getValue()).f(r110.getContext(), r115);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
