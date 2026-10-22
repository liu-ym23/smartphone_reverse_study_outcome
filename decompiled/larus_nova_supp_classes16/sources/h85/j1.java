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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j1 implements com.bytedance.ee.bear.i {
    public final List<com.bytedance.ee.bear.j> a;

    public j1() {
        this.a = new ArrayList();
    }

    public final void b(com.bytedance.ee.bear.j r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.a).contains(r2) == true) goto L8;
        ((ArrayList) this.a).add(r2);
        return;
    }

    public final void e(BaseOpenEntity r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.j) r0.next()).switchEntity(r3);
        goto L4
    }

    public final void g(com.bytedance.ee.bear.j r2) {
        if (r2 == null) goto L5;
        ((ArrayList) this.a).remove(r2);
        return;
    }

    public final void a(final String r4, final DlpUploadAction r5) {
        tt5.a.h("DriveComponent", "DriveSdkWrapper#execPreviewAction() uniqueId=" + r4);
        final ArrayList r0 = new ArrayList();
        r0.add(r5);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new e1()).map(new f1(r4, r0, r5)).subscribe(new g1(), new h1());
    }

    public final void c(Context r3, BaseOpenEntity r4) {
        tt5.a.h("DriveComponent", "DriveSdkWrapper#openPreview()");
        ArrayList<? extends BaseOpenEntity> r0 = new ArrayList();
        r0.add(r4);
        h(r3, r0, 0);
    }

    public final UserContainerDriveMainFragment d(SpaceFileOpenEntity r5, Bundle r6) {
        l65.g r0 = null;
        if (r6 == null) goto L7;
        String r1 = r6.getString("vc_meeting_id");
        boolean r2 = r6.getBoolean("vc_refresh");
        if (TextUtils.isEmpty(r1) == true) goto L7;
        l65.g r3 = new l65.g(null);
        r3.b = r1;
        r3.a = r2;
        r0 = r3;
    L7:
        com.bytedance.ee.drive.render.j r4 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(LarkContext.getApplication());
        int r7 = DriveMainFragment.l;
        Intrinsics.checkNotNullParameter(r4, "openStrategy");
        Intrinsics.checkNotNullParameter(r5, "openEntity");
        ArrayList r8 = new ArrayList();
        r8.add(r5);
        return DriveMainFragment.a.a(r4, r8, 0, r0, r6);
    }

    public final void h(Context r7, ArrayList<? extends BaseOpenEntity> r8, int r9) {
        f(r7, r8, r9, new ma5.a(), null);
    }

    public final void f(Context r7, ArrayList<? extends BaseOpenEntity> r8, int r9, ma5.a r10, Bundle r11) {
        tt5.a.h("DriveComponent", "DriveSdkWrapper#openMultiplePreview()");
        com.bytedance.ee.bear.contract.b0 r1 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        com.bytedance.ee.bear.contract.h0 r2 = (com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class);
        if (r1 == null) goto L58;
        if (r2 == null) goto L58;
        if (r7 != null) goto L60;
        r7 = eu5.b.a;
    L60:
        Iterator<? extends BaseOpenEntity> r3 = r8.iterator();     // Catch: Exception -> L55
    L11:
        if (r3.hasNext() == false) goto L22;
        BaseOpenEntity r4 = r3.next();     // Catch: Exception -> L55
        if (r4.getBizType() == 4) goto L19;
        if (r4.getBizType() == 2) goto L19;
        if (r4.getBizType() != 5) goto L11;
    L19:
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L11;
        tt5.a.h("DriveComponent", "openPreviewInternal() disable31Feature");     // Catch: Exception -> L55
        com.bytedance.ee.util.ui.m.a(new i1());     // Catch: Exception -> L55
        return;
    L22:
        if (i85.a.a(r7, r8) == false) goto L26;
        return;
    L26:
        if (a95.b.a("ccm.mobile.android_doc_support_expand_page") == true) goto L29;
        Intent r5 = new Intent(r7, DriveExpandActivity.class);     // Catch: Exception -> L55
    L43:
        if ((r7 instanceof Application) == false) goto L45;
        r5.addFlags(268435456);     // Catch: Exception -> L55
    L45:
        r5.setExtrasClassLoader(BaseOpenEntity.class.getClassLoader());     // Catch: Exception -> L55
        r5.putParcelableArrayListExtra("extra_drive_sdk_open_entity", r8);     // Catch: Exception -> L55
        r5.putExtra("extra_drive_sdk_open_index", r9);     // Catch: Exception -> L55
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L49;
        r5.putExtra("extra_drive_sdk_enter_anime", r10.a);     // Catch: Exception -> L55
        r5.putExtra("extra_drive_sdk_exit_anime", r10.b);     // Catch: Exception -> L55
    L49:
        if (r10.c == false) goto L51;
        r5.addFlags(536870912);     // Catch: Exception -> L55
    L51:
        if (r11 == null) goto L53;
        r5.putExtras(r11);     // Catch: Exception -> L55
    L53:
        tt5.a.h("DrivePreviewImpl", "openPreviewInternal, isSingleTop: " + r10.c);     // Catch: Exception -> L55
        r7.startActivity(r5);     // Catch: Exception -> L55
        return;
    L29:
        if (r10.d == false) goto L32;
        r5 = new Intent(r7, DriveExpandActivity.class);     // Catch: Exception -> L55
        goto L43
    L32:
        if (com.ss.android.lark.base.embedded.b.g() == false) goto L34;
    L37:
        boolean r6 = true;
    L38:
        tt5.a.h("DrivePreviewImpl", "isDefaultFoldCheckHit: " + r6);     // Catch: Exception -> L55
        if (r6 == false) goto L41;
        r5 = new Intent(r7, DriveExpandActivity.class);     // Catch: Exception -> L55
        goto L43
    L41:
        r5 = new Intent(r7, DriveActivity.class);     // Catch: Exception -> L55
        goto L43
    L34:
        if (com.ss.android.lark.base.embedded.f.a() == true) goto L37;
        r6 = false;
    L55:
        e = move-exception;
        tt5.a.e("DriveComponent", "DriveSdkRouter#route() error", e, false);
        return;
    L58:
        tt5.a.d("DriveComponent", "DriveSdkWrapper#openMultiplePreview() infoProvideService or loginService is null, " + r1 + " - " + r2);
    }
}
