package h85;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.document.security.DlpUploadAction;
import com.bytedance.ee.bear.drive.core.DriveActivity;
import com.bytedance.ee.bear.drive.core.DriveExpandActivity;
import com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j1 implements com.bytedance.ee.bear.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.j> f484175a;

    public j1() {
        this.f484175a = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.i
    public final void b(com.bytedance.ee.bear.j r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.f484175a).contains(r100) == true) goto L8;
        ((ArrayList) this.f484175a).add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.i
    public final void e(BaseOpenEntity r100) {
        Iterator r101 = ((ArrayList) this.f484175a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.j) r101.next()).switchEntity(r100);
        goto L4
    }

    @Override // com.bytedance.ee.bear.i
    public final void g(com.bytedance.ee.bear.j r100) {
        if (r100 == null) goto L5;
        ((ArrayList) this.f484175a).remove(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.i
    public final void a(final String r100, final DlpUploadAction r101) {
        tt5.a.h("DriveComponent", "DriveSdkWrapper#execPreviewAction() uniqueId=" + r100);
        final ArrayList r102 = new ArrayList();
        r102.add(r101);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new e1()).map(new f1(r100, r102, r101)).subscribe(new g1(), new h1());
    }

    @Override // com.bytedance.ee.bear.i
    public final void c(Context r100, BaseOpenEntity r101) {
        tt5.a.h("DriveComponent", "DriveSdkWrapper#openPreview()");
        ArrayList<? extends BaseOpenEntity> r102 = new ArrayList();
        r102.add(r101);
        h(r100, r102, 0);
    }

    @Override // com.bytedance.ee.bear.i
    public final UserContainerDriveMainFragment d(SpaceFileOpenEntity r100, Bundle r101) {
        l65.g r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getString("vc_meeting_id");
        boolean r104 = r101.getBoolean("vc_refresh");
        if (TextUtils.isEmpty(r103) == true) goto L7;
        l65.g r105 = new l65.g(null);
        r105.f507715b = r103;
        r105.f507714a = r104;
        r102 = r105;
    L7:
        com.bytedance.ee.drive.render.j r106 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(LarkContext.getApplication());
        int r107 = DriveMainFragment.f224144l;
        Intrinsics.checkNotNullParameter(r106, "openStrategy");
        Intrinsics.checkNotNullParameter(r100, "openEntity");
        ArrayList r108 = new ArrayList();
        r108.add(r100);
        return DriveMainFragment.a.a(r106, r108, 0, r102, r101);
    }

    @Override // com.bytedance.ee.bear.i
    public final void h(Context r100, ArrayList<? extends BaseOpenEntity> r101, int r102) {
        f(r100, r101, r102, new ma5.a(), null);
    }

    @Override // com.bytedance.ee.bear.i
    public final void f(Context r100, ArrayList<? extends BaseOpenEntity> r101, int r102, ma5.a r110, Bundle r111) {
        tt5.a.h("DriveComponent", "DriveSdkWrapper#openMultiplePreview()");
        com.bytedance.ee.bear.contract.b0 r103 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        com.bytedance.ee.bear.contract.h0 r104 = (com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class);
        if (r103 == null) goto L58;
        if (r104 == null) goto L58;
        if (r100 != null) goto L60;
        r100 = eu5.b.f474075a;
    L60:
        Iterator<? extends BaseOpenEntity> r105 = r101.iterator();     // Catch: Exception -> L55
    L11:
        if (r105.hasNext() == false) goto L22;
        BaseOpenEntity r106 = r105.next();     // Catch: Exception -> L55
        if (r106.getBizType() == 4) goto L19;
        if (r106.getBizType() == 2) goto L19;
        if (r106.getBizType() != 5) goto L11;
    L19:
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L11;
        tt5.a.h("DriveComponent", "openPreviewInternal() disable31Feature");     // Catch: Exception -> L55
        com.bytedance.ee.util.ui.m.a(new i1());     // Catch: Exception -> L55
        return;
    L22:
        if (i85.a.a(r100, r101) == false) goto L26;
        return;
    L26:
        if (a95.b.a("ccm.mobile.android_doc_support_expand_page") == true) goto L29;
        Intent r107 = new Intent(r100, DriveExpandActivity.class);     // Catch: Exception -> L55
    L43:
        if ((r100 instanceof Application) == false) goto L45;
        r107.addFlags(268435456);     // Catch: Exception -> L55
    L45:
        r107.setExtrasClassLoader(BaseOpenEntity.class.getClassLoader());     // Catch: Exception -> L55
        r107.putParcelableArrayListExtra("extra_drive_sdk_open_entity", r101);     // Catch: Exception -> L55
        r107.putExtra("extra_drive_sdk_open_index", r102);     // Catch: Exception -> L55
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L49;
        r107.putExtra("extra_drive_sdk_enter_anime", r110.f512699a);     // Catch: Exception -> L55
        r107.putExtra("extra_drive_sdk_exit_anime", r110.f512700b);     // Catch: Exception -> L55
    L49:
        if (r110.f512701c == false) goto L51;
        r107.addFlags(536870912);     // Catch: Exception -> L55
    L51:
        if (r111 == null) goto L53;
        r107.putExtras(r111);     // Catch: Exception -> L55
    L53:
        tt5.a.h("DrivePreviewImpl", "openPreviewInternal, isSingleTop: " + r110.f512701c);     // Catch: Exception -> L55
        r100.startActivity(r107);     // Catch: Exception -> L55
        return;
    L29:
        if (r110.f512702d == false) goto L32;
        r107 = new Intent(r100, DriveExpandActivity.class);     // Catch: Exception -> L55
        goto L43
    L32:
        if (com.ss.android.lark.base.embedded.b.g() == false) goto L34;
    L37:
        boolean r108 = true;
    L38:
        tt5.a.h("DrivePreviewImpl", "isDefaultFoldCheckHit: " + r108);     // Catch: Exception -> L55
        if (r108 == false) goto L41;
        r107 = new Intent(r100, DriveExpandActivity.class);     // Catch: Exception -> L55
        goto L43
    L41:
        r107 = new Intent(r100, DriveActivity.class);     // Catch: Exception -> L55
        goto L43
    L34:
        if (com.ss.android.lark.base.embedded.f.a() == true) goto L37;
        r108 = false;
    L55:
        e = move-exception;
        tt5.a.e("DriveComponent", "DriveSdkRouter#route() error", e, false);
        return;
    L58:
        tt5.a.d("DriveComponent", "DriveSdkWrapper#openMultiplePreview() infoProvideService or loginService is null, " + r103 + " - " + r104);
    }
}
