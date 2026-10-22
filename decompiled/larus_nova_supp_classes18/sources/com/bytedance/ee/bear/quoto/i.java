package com.bytedance.ee.bear.quoto;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.quoto.cta.DriveCTAQuotaConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.Contexts;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements t {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean k(int r2) {
        if (r2 != 90001061) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 90003061) goto L10;
        if (r2 == 900011002) goto L10;
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean q(int r2) {
        if (r2 != 11001) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 13001) goto L10;
        if (r2 == 90008072) goto L10;
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean s(int r2) {
        if (r2 != 90003083) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 90005083) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final Flowable b() {
        NetService.f r0 = new NetService.f("/space/api/box/quota/info/");
        if (TextUtils.isEmpty("") == true) goto L8;
        if (TextUtils.isEmpty("mountPoint") == true) goto L8;
        r0.b("mount_node_token", "");
        r0.b("mount_point", "mountPoint");
    L8:
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new j()).a(r0).observeOn(fo5.d.b()).map(new h());
    }

    public i() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.i("ccm.drive.size_limit_enable", false);
        this.b = r1;
        boolean r3 = r0.i("ccm.mobile.cta_component_enable", false);
        this.a = r3;
        boolean r2 = r0.i("ccm.workspace.apigw_plugin_check_quota", false);
        this.c = r2;
        this.d = r0.f("ccm.storage.edit_limit_popup");
        tt5.a.h("ExceedQuotaImpl", "DRIVE_UPLOAD_SIZE_LIMIT_ENABLE = " + r1 + ", DRIVE_CTA_COMPONENT_ENABLE = " + r3 + ", CREATE_DOCUMENT_SIZE_LIMIT_ENABLE = " + r2);
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean e() {
        return this.b;
    }

    public static FragmentActivity t(Context r2) {
        Activity r0 = AppLifecycle.a.a.f();
        if ((r2 instanceof FragmentActivity) == false) goto L6;
        r0 = Contexts.requireActivity(r2);
    L6:
        if (com.bytedance.ee.util.ui.b.a(r0) == true) goto L8;
        return null;
    L8:
        if ((r0 instanceof FragmentActivity) == true) goto L10;
        return null;
    L10:
        return (FragmentActivity) r0;
    }

    public static boolean u(String r1) {
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        tt5.a.h("ExceedQuotaImpl", "suppress upload quota dialog in OfficeSDK, scene=".concat(r1));
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean g(int r2) {
        if (this.b == true) goto L5;
    L9:
        return false;
    L5:
        if (r2 != 90003043) goto L7;
    L8:
        return true;
    L7:
        if (r2 != 90001043) goto L9;
        goto L8
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean o(int r2) {
        if (r2 != 90003087) goto L5;
    L14:
        return true;
    L5:
        if (this.c == false) goto L11;
        if (r2 == 90008072) goto L14;
        if (r2 == 11001) goto L14;
    L11:
        if (r2 == 90003088) goto L14;
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean a(Throwable r1, Context r2) {
        return l(ax4.d.a(r1), r2);
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void d(Context r2, int r3) {
        n(r2, r3, null);
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void j(FragmentActivity r6, FullQuotoConfig r7) {
        if (r7 == FullQuotoConfig.UPLOAD) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (this.a == false) goto L21;
        if (this.d == false) goto L15;
        DriveCTAQuotaConfig r8 = DriveCTAQuotaConfig.UNI_STORAGE_EXCEED_TENANT_QUOTA;
    L16:
        int r1 = ol5.a.b;
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r8, "config");
        Lifecycle.State r2 = r6.getLifecycle().getCurrentState();
        tt5.a.h("DriveCTAWrapper", "currentState =" + r2);
        if (r2.isAtLeast(Lifecycle.State.RESUMED) == false) goto L33;
        ol5.a.a(r6, r6, r8, null);
        return;
    L33:
        return;
    L15:
        r8 = DriveCTAQuotaConfig.EXCEED_TENANT_QUOTA;
        goto L16
    L21:
        if (r7.showCreateExceedCapacity == false) goto L23;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).D(r6);
        return;
    L23:
        int r3 = FullQuotoDialogFragment.o;
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "config");
        if (r7.getMainTitleId() == 2131887308) goto L26;
    L28:
        FullQuotoDialogFragment.a.a(r6, r7, true, null);
        return;
    L26:
        if ((!((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand()) == false) goto L28;
        tt5.a.h("FullQuotoDialogFragment", "isOverSea && isStorage return");
        return;
    L5:
        if (u("tenant_quota") == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean l(int r3, Context r4) {
        tt5.a.h("ExceedQuotaImpl", "handleCreateDocumentExceedTenantQuota, code=" + r3);
        if (o(r3) == false) goto L6;
        n(r4, r3, null);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void m(FragmentActivity r3, DialogInterface.OnDismissListener r4) {
        if (this.d == false) goto L5;
        DriveCTAQuotaConfig r0 = DriveCTAQuotaConfig.UNI_STORAGE_EXCEED_TENANT_QUOTA;
    L6:
        ol5.a.b(r3, r3, r0, null, r4);
        return;
    L5:
        r0 = DriveCTAQuotaConfig.EXCEED_TENANT_QUOTA;
        goto L6
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void r(FragmentActivity r3, DialogInterface.OnDismissListener r4) {
        FullQuotoConfig r0 = FullQuotoConfig.OTHERS_EXCEED_TENANT_QUOTA;
        int r1 = FullQuotoDialogFragment.o;
        FullQuotoDialogFragment.a.a(r3, r0, false, r4);
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void f(Context r5, SingleFileQuotaConfig r6, Long r7) {
        if (r6 == SingleFileQuotaConfig.UPLOAD) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (r5 != null) goto L13;
        tt5.a.d("ExceedQuotaImpl", "showExceedSingleFileQuota fail because context is null!");
        return;
    L13:
        Bundle r1 = new Bundle();
        r1.putLong("key_file_size", r7.longValue());
        r1.putParcelable("key_quota_config", r6);
        Intent r8 = new Intent(r5, ExceedQuotaActivity.class);
        r8.putExtra("exceed_quota_code", 90001043);
        r8.putExtras(r1);
        if ((r5 instanceof Application) == false) goto L16;
        r8.addFlags(268435456);
    L16:
        r5.startActivity(r8);
        return;
    L5:
        if (u("single_file_quota") == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean h(int r13, Context r14, boolean r15) {
        if (k(r13) == false) goto L7;
        c(r14, null, null, r15, false, "");
        return true;
    L7:
        if (s(r13) == false) goto L10;
        c(r14, null, null, r15, true, "");
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void n(final Context r2, final int r3, final i55.a r4) {
        com.bytedance.ee.util.ui.m.a(new g(this, r3, r4, r2));
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean p(Throwable r2, Context r3, boolean r4) {
        if ((r2 instanceof NetService.ServerErrorException) == true) goto L5;
        return false;
    L5:
        return h(((NetService.ServerErrorException) r2).getCode(), r3, r4);
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void c(Context r10, String r11, String r12, boolean r13, boolean r14, String r15) {
        if (r14 == false) goto L4;
        String r0 = "department_quota";
    L5:
        if (r12 == null) goto L11;
        if (r12.length() == 0) goto L11;
        if ("explorer".equals(r12) == true) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L16;
        return;
    L16:
        FragmentActivity r2 = t(r10);
        if (r2 == null) goto L20;
        ExceedQuotaFragment.da0(r2, r11, r12, r13, r15, true, null, r14, null);
        return;
    L20:
        return;
    L11:
        if (u(r0) == false) goto L13;
        r1 = true;
        goto L14
    L4:
        r0 = "user_quota";
        goto L5
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void i(FragmentActivity r10, String r11, String r12, boolean r13, String r14, View.OnClickListener r15) {
        if (r13 == false) goto L5;
        String r0 = "department_quota_callback";
    L6:
        if (r12 == null) goto L12;
        if (r12.length() == 0) goto L12;
        if ("explorer".equals(r12) == true) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        FragmentActivity r2 = t(r10);
        if (r2 == null) goto L21;
        ExceedQuotaFragment.da0(r2, r11, r12, false, "", false, r14, r13, r15);
        return;
    L21:
        return;
    L12:
        if (u(r0) == false) goto L14;
        r1 = true;
        goto L15
    L5:
        r0 = "user_quota_callback";
        goto L6
    }
}
