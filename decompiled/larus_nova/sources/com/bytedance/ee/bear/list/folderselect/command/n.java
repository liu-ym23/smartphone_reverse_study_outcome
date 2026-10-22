package com.bytedance.ee.bear.list.folderselect.command;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements td5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f228188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f228189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f228190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f228191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ShareFolderUserPermission f228192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public td5.b f228193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SpaceSelectorBean f228194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f228195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larksuite.component.universe_design.toast.c f228196i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f228197a;

        public b(n r100) {
            this.f228197a = r100;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, android.app.Activity] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SpaceMakeCopyToSpaceResult r101 = (SpaceMakeCopyToSpaceResult) r100;
            tt5.a.h("SpaceMakeCopyToSpaceCommand", "make copy success.");
            jw4.a.g("copy", Integer.valueOf(this.f228197a.f228194g.f229385a));
            n r102 = this.f228197a;
            Intrinsics.checkNotNull(r101);
            r102.getClass();
            Toast.cancelLoading();
            td5.b r103 = r102.f228193f;
            if (r103 == null) goto L5;
            r103.finish();
        L5:
            com.bytedance.ee.bear.route.h r104 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            Ref.ObjectRef r105 = new Ref.ObjectRef();
            ?? r106 = (T) r104.getActivity();
            r105.element = r106;
            if (com.bytedance.ee.util.ui.b.a(r106) == false) goto L15;
            Activity r107 = (Activity) r105.element;
            if (r107 == null) goto L16;
            SpaceSelectorBean r108 = r102.f228194g;
            if (r108 == null) goto L12;
            int r109 = r108.f229385a;
        L13:
            UDToast.a r110 = UDToast.build(r107);
            r110.f285429b.e(R.string.Doc_Facade_MakeCopySucceed);
            r110.b(R.string.CreationMobile_Doc_Facade_MakeCopySucceed_open_btn, new q(r104, r101, r102, r109));
            r110.f(new r(r105, r102));
            com.ss.android.lark.compose.foundation.toast.g r111 = r110.a();
            r102.f228196i = r111;
            r111.show();
            return;
        L12:
            r109 = sbb.e.f541296g.f541317b;
            goto L13
        L16:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f228198a;

        public c(n r100) {
            this.f228198a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            tt5.a.d("SpaceMakeCopyToSpaceCommand", "make copy failed, throwable = " + r111);
            jw4.a.h("copy", r111, Integer.valueOf(this.f228198a.f228194g.f229385a));
            n r100 = this.f228198a;
            Intrinsics.checkNotNull(r111);
            r100.getClass();
            Toast.cancelLoading();
            if ((r111 instanceof NetService.ServerErrorException) == false) goto L5;
            int r101 = ((NetService.ServerErrorException) r111).getCode();
        L6:
            ErrorResponse r102 = null;
            Integer r103 = null;
            rc5.a r104 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
            if (com.bytedance.ee.bear.contract.k0.b(r101) == true) goto L112;
            com.bytedance.ee.bear.quoto.t r105 = (com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6);
            SpaceSelectorBean r106 = r100.f228194g;
            if (r106 == null) goto L12;
            int r107 = r106.f229385a;
        L14:
            if (r101 != 4) goto L17;
            Toast.showFailureText(r100.f228188a, R.string.LarkCCM_Workspace_FolderPerm_CantCopy_Tooltip);
            return;
        L17:
            if (r101 != 4007) goto L24;
            if (r107 != sbb.e.f541301l.f541317b) goto L21;
            int r112 = R.string.Doc_Facade_DriveMakeCopyCrossUnitTips;
        L22:
            Toast.showFailureText(r100.f228188a, r112);
            return;
        L21:
            r112 = R.string.Doc_Facade_DocMakeCopyCrossUnitTips;
            goto L22
        L24:
            if (r101 != 11001) goto L29;
            Context r113 = r100.f228188a;
            if ((r113 instanceof FragmentActivity) == false) goto L98;
            ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).j((FragmentActivity) r113, FullQuotoConfig.MAKE_COPY.withShowCreateExceedCapacity(!((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand()));
            return;
        L98:
            return;
        L29:
            if (r105.o(r101) == false) goto L32;
            r105.l(r101, r100.f228188a);
            return;
        L32:
            if (r105.k(r101) == false) goto L37;
            Context r108 = r100.f228188a;
            if ((r108 instanceof FragmentActivity) == false) goto L101;
            ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).c(r108, null, null, !TextUtils.isEmpty(r100.f228189b), false, "");
            return;
        L101:
            return;
        L37:
            if (r105.s(r101) == false) goto L41;
            Context r109 = r100.f228188a;
            if ((r109 instanceof FragmentActivity) == false) goto L103;
            ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).c(r109, null, null, !TextUtils.isEmpty(r100.f228189b), true, "");
            return;
        L103:
            return;
        L41:
            String r114 = "";
            if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).g(r101) == false) goto L53;
            if (r107 != sbb.e.f541301l.f541317b) goto L53;
            com.bytedance.ee.bear.h r115 = (com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6);
            SpaceSelectorBean r116 = r100.f228194g;
            if (r116 == null) goto L51;
            String r117 = r116.f229386b;
            if (r117 == null) goto L51;
            r114 = r117;
        L51:
            r100.f228195h.add(r115.P5(r114, FileInfoPuller.CALLER_EXPLORER).subscribe(new o(r100), new p(r100)));
            return;
        L53:
            if (r101 != 4000080) goto L55;
        L94:
            Toast.showFailureText(r100.f228188a, R.string.CreationMobile_Docs_duplicate_inProgress_toast);
            return;
        L55:
            if (r101 == 800004046) goto L94;
            if (r101 != 4202) goto L60;
            Toast.showFailureText(r100.f228188a, R.string.CreationMobile_DataUpgrade_Locked_toast);
            return;
        L60:
            com.bytedance.ee.bear.middleground_permission_export.model.d r118 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
            SpaceSelectorBean r119 = r100.f228194g;
            if (r119 == null) goto L64;
            String r120 = r119.f229386b;
            if (r120 == null) goto L64;
        L65:
            String r121 = r118.f(r120, "CCM_CREATE_COPY", r101);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            boolean r122 = jg5.e.a.f499003a.g();
            if (r122 == false) goto L76;
            ph5.b r123 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            SpaceSelectorBean r124 = r100.f228194g;
            if (r124 == null) goto L73;
            String r125 = r124.f229386b;
            if (r125 == null) goto L73;
            r114 = r125;
        L73:
            if (r124 == null) goto L75;
            r103 = Integer.valueOf(r124.f229385a);
        L75:
            r102 = r123.e(r114, r103, "CREATE_COPY", r111);
        L76:
            if (r122 == false) goto L86;
            if (r102 == null) goto L86;
            if (r102.getHasHandledUiAction() == false) goto L86;
            ph5.a r126 = r102.getCallback();
            if (r126 == null) goto L107;
            Context r127 = r100.f228188a;
            if (r127 != null) goto L85;
            r127 = eu5.b.f474075a;
        L85:
            Intrinsics.checkNotNull(r127);
            r126.a(r127, r102);
            return;
        L107:
            return;
        L86:
            if (r122 == true) goto L91;
            if (TextUtils.isEmpty(r121) == true) goto L91;
            Toast.showFailureText(r100.f228188a, r121);
            return;
        L91:
            if (r101 != 1201) goto L93;
            Toast.showFailureText(r100.f228188a, R.string.LarkCCM_Sheets_Protect_CantDuplicate_Toast);
            return;
        L93:
            Toast.showFailureText(r100.f228188a, R.string.Doc_Facade_OperateFailed);
            return;
        L64:
            r120 = "";
            goto L65
        L12:
            r107 = sbb.e.f541296g.f541317b;
            goto L14
        L112:
            return;
        L5:
            r101 = -1;
            goto L6
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "destroy()...");
        if (this.f228195h.isDisposed() == true) goto L5;
        this.f228195h.clear();
    L5:
        this.f228188a = null;
        this.f228193f = null;
        if (this.f228196i != null) goto L9;
        Toast.cancelLoading();
        return;
    }

    @Override // td5.d
    public final void execute() {
        if (this.f228194g != null) goto L6;
        tt5.a.d("SpaceMakeCopyToSpaceCommand", "execute()...spaceSelectorBean is null.");
        return;
    L6:
        com.larksuite.component.universe_design.toast.c r100 = this.f228196i;
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L15;
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "already make copy success, return");
        return;
    L15:
        String r102 = null;
        if ((!com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a()) == false) goto L23;
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "execute()...failed, offline");
        Context r103 = this.f228188a;
        if (r103 == null) goto L20;
        r102 = r103.getString(R.string.Doc_List_OperateFailedNoNet);
    L20:
        Toast.showFailureText(r103, r102);
        return;
    L23:
        if (this.f228194g.f229391g == false) goto L32;
        FolderVersion.a r104 = FolderVersion.Companion;
        Integer r105 = Integer.valueOf(this.f228191d);
        r104.getClass();
        if (FolderVersion.a.c(r105) == true) goto L32;
        Context r106 = this.f228188a;
        if (r106 == null) goto L29;
        r102 = r106.getString(R.string.CreationMobile_ECM_UnableDuplicateDocToast);
    L29:
        Toast.showText(r106, r102);
        return;
    L32:
        if (this.f228194g.f229391g == true) goto L41;
        FolderVersion.a r107 = FolderVersion.Companion;
        Integer r108 = Integer.valueOf(this.f228191d);
        r107.getClass();
        if (FolderVersion.a.c(r108) == false) goto L41;
        Context r109 = this.f228188a;
        if (r109 == null) goto L38;
        r102 = r109.getString(R.string.CreationMobile_ECM_UnableDuplicateToast);
    L38:
        Toast.showText(r109, r102);
        return;
    L41:
        if (this.f228192e == null) goto L50;
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).u(this.f228192e, "MOVE_TO_HERE"), Boolean.FALSE) == false) goto L50;
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "execute()...has no permission.");
        Context r110 = this.f228188a;
        if (r110 == null) goto L47;
        r102 = r110.getString(R.string.LarkCCM_Workspace_FolderPerm_CantCopy_Tooltip);
    L47:
        Toast.showFailureText(r110, r102);
        return;
    L50:
        if (this.f228195h.isDisposed() == true) goto L52;
        this.f228195h.clear();
    L52:
        Context r111 = this.f228188a;
        if (r111 == null) goto L55;
        String r112 = r111.getString(R.string.CreationMobile_Wiki_CreateCopy_Creating_Toast);
    L56:
        Toast.showLoading(r111, r112);
        if (this.f228190c != 4) goto L59;
        String r113 = "";
    L60:
        String r114 = r113;
        rc5.a r115 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        Context r116 = this.f228188a;
        SpaceSelectorBean r117 = this.f228194g;
        this.f228195h.add(r115.h(new com.bytedance.ee.bear.contract.d0(r116, r117.f229386b, r117.f229385a, r117.f229389e, r114, r117.f229390f, r117.f229398n, r117.f229397m, r117.f229391g)).subscribe(new b(this), new c(this)));
        return;
    L59:
        r113 = this.f228189b;
        goto L60
    L55:
        r112 = null;
        goto L56
    L9:
        if (r100.isShowing() != true) goto L11;
        r101 = true;
        goto L12
    }

    public final Context getContext() {
        return this.f228188a;
    }

    public n(Context r100, String r101, int r102, int r103, ShareFolderUserPermission r104, Bundle r105, td5.b r106, ce5.a r107) {
        Intrinsics.checkNotNullParameter(r101, "destToken");
        Intrinsics.checkNotNullParameter(r107, "userComponentAbility");
        this.f228188a = r100;
        this.f228189b = r101;
        this.f228190c = r102;
        this.f228191d = r103;
        this.f228192e = r104;
        this.f228193f = r106;
        if (r105 == null) goto L5;
        SpaceSelectorBean r108 = (SpaceSelectorBean) r105.getParcelable("extra_space_bean");
    L6:
        this.f228194g = r108;
        this.f228195h = new CompositeDisposable();
        return;
    L5:
        r108 = null;
        goto L6
    }
}
