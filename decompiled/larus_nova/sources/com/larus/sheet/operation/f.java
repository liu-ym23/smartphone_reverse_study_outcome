package com.larus.sheet.operation;

import android.app.Application;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.bytedance.ee.permission.doc.GetPublicPermissionApi$Result;
import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi$Result;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.card.sheet.download.OfficeCardSheetDownloadServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, MutableLiveData<Boolean>> f369099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f369100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f369101c = null;

    public static final class a implements ut5.a<GetPublicPermissionApi$Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f369102a;

        public a(String r100) {
            this.f369102a = r100;
        }

        @Override // ut5.a
        public final void onResult(GetPublicPermissionApi$Result r100) {
            GetPublicPermissionApi$Result r101 = r100;
            FLogger.f375446a.i("SheetOpManager", "[refreshSheetPermissionV2] success");
            HashMap<String, MutableLiveData<Boolean>> r102 = f.f369099a;
            String r103 = this.f369102a;
            boolean r104 = true;
            if (r101 == null) goto L9;
            GetPublicPermissionApi$Result.PermPublic r105 = r101.getPublicPerm();
            if (r105 == null) goto L9;
            if (r105.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_READ.m8351getTypeValue().intValue()) goto L9;
            boolean r106 = true;
        L10:
            if (r106 == true) goto L21;
            if (r101 == null) goto L17;
            GetPublicPermissionApi$Result.PermPublic r107 = r101.getPublicPerm();
            if (r107 == null) goto L17;
            if (r107.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_EDIT.m8351getTypeValue().intValue()) goto L17;
            boolean r108 = true;
        L18:
            if (r108 == true) goto L21;
            r104 = false;
        L17:
            r108 = false;
        L21:
            f.a(r103, r104);
            if (r101 == null) goto L26;
            GetPublicPermissionApi$Result.PermPublic r109 = r101.getPublicPerm();
            if (r109 == null) goto L26;
            Boolean r110 = Boolean.valueOf(r109.getHasModifiedLinkShare());
        L27:
            f.f369100b = r110;
            return;
        L26:
            r110 = null;
        L9:
            r106 = false;
            goto L10
        }

        @Override // ut5.a
        public final void onError(int r100, Throwable r101) {
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("[refreshSheetPermissionV2] failed, code:");
            r103.append(r100);
            r103.append(", msg:");
            if (r101 == null) goto L5;
            String r104 = r101.getMessage();
        L6:
            r103.append(r104);
            r102.e("SheetOpManager", r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class b implements xt5.a<com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f369103a;

        public b(String r100) {
            this.f369103a = r100;
        }

        @Override // xt5.a
        public final void a(xt5.c r100) {
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result r101 = (com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result) r100;
            FLogger.f375446a.i("SheetOpManager", "[refreshSheetPermission] success");
            HashMap<String, MutableLiveData<Boolean>> r102 = f.f369099a;
            String r103 = this.f369103a;
            boolean r104 = true;
            if (r101 == null) goto L9;
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result.PermPublic r105 = r101.getPublicPerm();
            if (r105 == null) goto L9;
            if (r105.getLinkShareEntityV2() != com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_ANYONE_READ.m8357getTypeValue().intValue()) goto L9;
            boolean r106 = true;
        L10:
            if (r106 == true) goto L21;
            if (r101 == null) goto L17;
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result.PermPublic r107 = r101.getPublicPerm();
            if (r107 == null) goto L17;
            if (r107.getLinkShareEntityV2() != com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_ANYONE_EDIT.m8357getTypeValue().intValue()) goto L17;
            boolean r108 = true;
        L18:
            if (r108 == true) goto L21;
            r104 = false;
        L17:
            r108 = false;
        L21:
            f.a(r103, r104);
            if (r101 == null) goto L26;
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result.PermPublic r109 = r101.getPublicPerm();
            if (r109 == null) goto L26;
            Boolean r110 = Boolean.valueOf(r109.getHasModifiedLinkShare());
        L27:
            f.f369100b = r110;
            return;
        L26:
            r110 = null;
        L9:
            r106 = false;
            goto L10
        }

        @Override // xt5.a
        public final void onError(int r100, Throwable r101) {
            FLogger.f375446a.e("SheetOpManager", "[refreshSheetPermission] failed, code:" + r100 + ", msg:" + r101.getMessage());
        }
    }

    public static final class c implements ut5.a<UpdatePublicPermissionApi$Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f369104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f369105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f369106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f369107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f369108e;

        @Override // ut5.a
        public final void onResult(UpdatePublicPermissionApi$Result r100) {
            FLogger.f375446a.i("SheetOpManager", "[updatePublicPermissionV2] success");
            HashMap<String, MutableLiveData<Boolean>> r101 = f.f369099a;
            f.a(this.f369104a, this.f369105b);
            f.f369100b = Boolean.TRUE;
            this.f369106c.invoke();
        }

        @Override // ut5.a
        public final void onError(int r100, Throwable r101) {
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("[updatePublicPermissionV2] failed, code:");
            r103.append(r100);
            r103.append(", msg:");
            if (r101 == null) goto L5;
            String r104 = r101.getMessage();
        L6:
            r103.append(r104);
            r102.e("SheetOpManager", r103.toString());
            HashMap<String, MutableLiveData<Boolean>> r105 = f.f369099a;
            f.a(this.f369104a, this.f369107d);
            this.f369108e.invoke(Boolean.valueOf(this.f369107d));
            return;
        L5:
            r104 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(String r100, boolean r101, Function0<Unit> r102, boolean r103, Function1<? super Boolean, Unit> r104) {
            this.f369104a = r100;
            this.f369105b = r101;
            this.f369106c = r102;
            this.f369107d = r103;
            this.f369108e = r104;
        }
    }

    public static final class d implements xt5.a<com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi$Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f369109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f369110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f369111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f369112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f369113e;

        @Override // xt5.a
        public final void a(xt5.c r100) {
            com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi$Result r101 = (com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi$Result) r100;
            FLogger.f375446a.i("SheetOpManager", "[updatePublicPermission] success");
            HashMap<String, MutableLiveData<Boolean>> r102 = f.f369099a;
            f.a(this.f369109a, this.f369112d);
            f.f369100b = Boolean.TRUE;
            this.f369113e.invoke();
        }

        @Override // xt5.a
        public final void onError(int r100, Throwable r101) {
            FLogger.f375446a.e("SheetOpManager", "[updatePublicPermission] failed, code:" + r100 + ", msg:" + r101.getMessage());
            HashMap<String, MutableLiveData<Boolean>> r102 = f.f369099a;
            f.a(this.f369109a, this.f369110b);
            this.f369111c.invoke(Boolean.valueOf(this.f369110b));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(String r100, boolean r101, Function1<? super Boolean, Unit> r102, boolean r103, Function0<Unit> r104) {
            this.f369109a = r100;
            this.f369110b = r101;
            this.f369111c = r102;
            this.f369112d = r103;
            this.f369113e = r104;
        }
    }

    public f() {
    }

    static {
        f369099a = new HashMap();
        f369101c = "https://feishu.doubao.com/sheets/";
    }

    public static com.bytedance.ee.permission.a c() {
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L7;
        gk5.e r101 = r100.q0();
        if (r101 == null) goto L7;
        return r101.i0();
    L7:
        return null;
    }

    public static MutableLiveData b(String r100) {
        HashMap<String, MutableLiveData<Boolean>> r101 = f369099a;
        MutableLiveData<Boolean> r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new MutableLiveData(Boolean.FALSE);
        r101.put(r100, r102);
    L6:
        return r102;
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        com.bytedance.ee.permission.a r101 = c();
        if (r101 == null) goto L6;
        vt5.a r102 = new vt5.a(r100, 3);
        ((PermissionSdk) r101).a().d(r102, new a(r100));
        return;
    L6:
        wt5.c r103 = wt5.c.f561223a;
        wt5.a r104 = wt5.c.f561225c;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("apiAll");
        r104 = null;
    L9:
        yt5.a r105 = new yt5.a(r100);
        b r106 = new b(r100);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "request");
        new yt5.b(r105, com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi$Result.class, r106).b();
    }

    public static final void a(String r100, boolean r101) {
        MutableLiveData r102 = b(r100);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r102.setValue(Boolean.valueOf(r101));
        return;
    L5:
        r102.postValue(Boolean.valueOf(r101));
    }

    public static void f(Fragment r210, kw9.e r211) {
        Intrinsics.checkNotNullParameter(r210, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r211, "downloadParams");
        FLogger.f375446a.i("SheetOpManager", "[showDownloadFragment] token:" + r211.f506429a);
        String r100 = r211.f506429a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        s r102 = s.f544207a;
        Application r103 = AppHost.f326268a.getApplication();
        r102.getClass();
        s.s(r103, R.string.larus_slides_download_toast_fail);
        return;
    L12:
        int r104 = com.larus.office.card.sheet.download.a.f361629a;
        String r105 = r211.f506429a;
        if (r105 != null) goto L15;
        String r106 = "";
    L16:
        if (r105 != null) goto L18;
        String r107 = "";
    L19:
        com.larus.office.card.sheet.a r108 = new com.larus.office.card.sheet.a(r107, r106, r211.f506436h, r211.f506432d, r211.f506433e, r211.f506439k, r211.f506440l, r211.f506441m, r211.f506442n, r211.f506443o, r211.f506445q, r211.f506446r, r211.f506437i);
        Intrinsics.checkNotNullParameter(r210, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r108, "downloadParams");
        OfficeCardSheetDownloadServiceDelegate.f361619b.a(r210, r108);
        return;
    L18:
        r107 = r105;
        goto L19
    L15:
        r106 = r105;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void e(String r110, boolean r111, Function0 r112, Function1 r113) {
        Intrinsics.checkNotNullParameter(r110, "sheetToken");
        Intrinsics.checkNotNullParameter(r112, "onSuccess");
        Intrinsics.checkNotNullParameter(r113, LynxVideoManagerLite.EVENT_ON_ERROR);
        Intrinsics.checkNotNullParameter(r110, "sheetToken");
        Intrinsics.checkNotNullParameter(r110, "sheetToken");
        boolean r100 = Intrinsics.areEqual(b(r110).getValue(), Boolean.TRUE);
        com.bytedance.ee.permission.a r101 = c();
        if (r101 == null) goto L14;
        vt5.c r102 = new vt5.c(r110, 3);
        if (r111 == false) goto L7;
        TypeExternalAccess r103 = TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
    L8:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f557226d = r103;
        if (r111 == false) goto L11;
        TypeLinkShare r104 = TypeLinkShare.LINK_SHARE_ANYONE_READ;
    L12:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f557227e = r104;
        ((PermissionSdk) r101).a().f(r102, new c(r110, r111, r112, r100, r113));
        return;
    L11:
        r104 = TypeLinkShare.LINK_SHARE_CLOSE;
        goto L12
    L7:
        r103 = TypeExternalAccess.EXTERNAL_ACCESS_CLOSE;
        goto L8
    L14:
        yt5.c r105 = new yt5.c(r110);
        if (r111 == false) goto L17;
        com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess r106 = com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
    L18:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f569142d = r106;
        if (r111 == false) goto L21;
        com.bytedance.ee.permission.sdk.define.value.TypeLinkShare r107 = com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_ANYONE_READ;
    L22:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f569143e = r107;
        wt5.c r108 = wt5.c.f561223a;
        wt5.a r109 = wt5.c.f561225c;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("apiAll");
        r109 = null;
    L25:
        d r114 = new d(r110, r100, r113, r111, r112);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r105, "request");
        new wt5.b(r105, com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi$Result.class, r114).b();
        return;
    L21:
        r107 = com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_CLOSE;
        goto L22
    L17:
        r106 = com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess.EXTERNAL_ACCESS_CLOSE;
        goto L18
    }
}
