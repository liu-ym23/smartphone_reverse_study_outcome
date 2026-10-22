package com.ss.android.lark.officesdk.integrator.im.impl;

import android.app.Activity;
import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.utils.DownloadAuthorizationEventType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.OpenFeishuMediaSecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class i implements kza.a {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433300a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GalleryType.Image.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f433300a = r100;
        }
    }

    public static final class b implements AuthorizationServiceV2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<kza.s, Unit> f433301a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super kza.s, Unit> r100) {
            this.f433301a = r100;
        }

        @Override // com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2.b
        public final void a(ValidateResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f433301a.invoke(new kza.s(owa.a.c().isAuthorizationPassed(r100)));
        }
    }

    @Inject
    public i() {
    }

    @Override // kza.a
    public final void E1(Context r110, kza.o r111, OpenFeishuMediaSecurityAction r112, Function1<? super kza.s, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "securityContext");
        Intrinsics.checkNotNullParameter(r112, "action");
        Intrinsics.checkNotNullParameter(r113, "callback");
        kza.t r100 = r111.f506796g;
        if (r100 != null) goto L6;
        r113.invoke(new kza.s(true));
        return;
    L6:
        kza.q r101 = r100.f506823b;
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L15;
        r113.invoke(new kza.s(true));
        return;
    L15:
        kza.r r103 = r100.f506822a;
        if (r111.f506791b == false) goto L50;
        if (r111.f506792c == true) goto L50;
        if (r111.f506793d == true) goto L50;
        if (r111.f506794e == true) goto L50;
        if (r112 != OpenFeishuMediaSecurityAction.SHARE) goto L28;
        r113.invoke(new kza.s(true));
        return;
    L28:
        GalleryType r104 = r103.f506814a;
        int[] r105 = a.f433300a;
        int r106 = r105[r104.ordinal()];
        if (r106 == 1) goto L34;
        if (r106 != 2) goto L33;
        DownloadAuthorizationEventType r107 = DownloadAuthorizationEventType.IMAGE_DOWNLOAD;
    L35:
        DownloadAuthorizationEventType r108 = r107;
        int r109 = r105[r103.f506814a.ordinal()];
        if (r109 == 1) goto L41;
        if (r109 != 2) goto L40;
        int r114 = R.string.Lark_Audit_BlockedActionDownloadFullImage;
    L42:
        AuthorizationServiceV2 r115 = owa.a.c();
        String r116 = r101.f506809a;
        if (r116 != null) goto L45;
        r116 = r101.f506810b;
    L45:
        if (r116 != null) goto L47;
        r116 = "";
    L47:
        String r117 = r116;
        r115.g(r108, r117, r101.f506810b, r103.f506816c, r103.f506815b, r101.f506811c, r101.f506812d, r110, Integer.valueOf(r114), new b(r113));
        return;
    L40:
        throw new NoWhenBranchMatchedException();
    L41:
        r114 = R.string.Lark_Audit_BlockedActionDownloadVideo;
        goto L42
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        r107 = DownloadAuthorizationEventType.VIDEO_DOWNLOAD;
    L50:
        if (r112 == OpenFeishuMediaSecurityAction.SAVE) goto L53;
        UDToast.show(r110, R.string.Lark_IM_UnableOperationDueToPermissionRestrictions_Toast);
    L56:
        r113.invoke(new kza.s(false));
        return;
    L53:
        if ((r110 instanceof Activity) == false) goto L55;
        new UDDialogBuilder(r110).title(R.string.Lark_FileSecurity_Dialog_UnableToDownload).message(R.string.Lark_IM_DLP_OrgSecPolicyCantDownload_Error).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Group_RevokeIKnow, null).show();
        goto L56
    L55:
        UDToast.show(r110, R.string.Lark_IM_DLP_OrgSecPolicyCantDownload_Error);
        goto L56
    L9:
        if (r101.f506813e != true) goto L11;
        r102 = true;
        goto L12
    }
}
