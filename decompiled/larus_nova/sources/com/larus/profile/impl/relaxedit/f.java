package com.larus.profile.impl.relaxedit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.nova.R;
import com.larus.profile.impl.viewmodel.ProfileEditViewModel;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f366816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f366817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProfileEditViewModel f366818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f366819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r38.b f366820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f366821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f366822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f366823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f366824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Callback f366825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f366826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f366827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f366828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Callback f366829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f366830o;

    public final Map<String, Object> c() {
        q38.a r100 = ILoginService.f286097a.getAccountInfo();
        r38.b r101 = this.f366820e;
        if (r101 != null) goto L5;
        r101 = IAccountService.f286094a.getUserInfo();
        this.f366820e = r101;
    L5:
        Pair[] r102 = new Pair[13];
        r102[0] = TuplesKt.to("userId", r100.f531530c);
        String r103 = null;
        if (r101 == null) goto L8;
        String r104 = r101.d();
    L9:
        String r105 = "";
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        r102[1] = TuplesKt.to("nickName", r104);
        if (r101 == null) goto L15;
        String r106 = r101.g();
    L16:
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        r102[2] = TuplesKt.to("userName", r106);
        if (r101 == null) goto L23;
        AvatarInfo r107 = r101.a();
        if (r107 == null) goto L23;
        String r108 = r107.a();
    L24:
        if (r108 != null) goto L26;
        r108 = "";
    L26:
        r102[3] = TuplesKt.to("avatarUrl", r108);
        if (r101 == null) goto L29;
        boolean r109 = r101.i();
    L30:
        r102[4] = TuplesKt.to("isDefaultAvatar", Boolean.valueOf(r109));
        r102[5] = TuplesKt.to("isEnterpriseAccount", Boolean.valueOf(r100.f531534g));
        if (r101 == null) goto L35;
        r38.a r110 = r101.e();
        if (r110 == null) goto L35;
        r103 = r110.b();
    L35:
        if (r103 == null) goto L38;
        r105 = r103;
    L38:
        r102[6] = TuplesKt.to("enterpriseDisplayName", r105);
        r102[7] = TuplesKt.to("enterFrom", this.f366822g);
        if (this.f366821f == false) goto L41;
        String r111 = "account";
    L42:
        r102[8] = TuplesKt.to("scene", r111);
        r102[9] = TuplesKt.to("platform", "android");
        r102[10] = TuplesKt.to("isOversea", Boolean.valueOf(AppHost.f326268a.isOversea()));
        boolean r112 = v19.h.f552477a;
        r102[11] = TuplesKt.to("isDarkMode", Boolean.valueOf(v19.h.b(this.f366817b)));
        r102[12] = TuplesKt.to("avatarEditable", Boolean.valueOf(!r100.f531534g));
        return MapsKt.mapOf(r102);
    L41:
        r111 = "default";
        goto L42
    L29:
        r109 = true;
    L23:
        r108 = null;
        goto L24
    L15:
        r106 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    }

    public static void a(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void b(JavaOnlyMap r100) {
        Callback r101 = this.f366825j;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f366825j = null;
        r101.invoke(new Object[]{r100});
    }

    public final void d(ProfileEditViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f366818c = r100;
        r100.getUserNameAvailable().observe(this.f366816a.getViewLifecycleOwner(), new g.a(new b(this)));
        r100.getEditProfileState().observe(this.f366816a.getViewLifecycleOwner(), new g.a(new c(this)));
    }

    public final JavaOnlyMap e(boolean r100) {
        if (r100 == false) goto L11;
        CommonDialog.a r101 = new CommonDialog.a();
        r101.i(this.f366817b.getString(R.string.larus_setting_profile_discard_title));
        CommonDialog.a.f(r101, new d(this), this.f366817b.getString(R.string.larus_setting_profile_discard_discard), false, 12);
        CommonDialog.a.e(r101, new e(), this.f366817b.getString(R.string.larus_setting_profile_discard_keep_editing), 4);
        CommonDialog r102 = r101.c();
        FragmentManager r103 = this.f366816a.getChildFragmentManager();
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, null, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r103, r102, r104) == false) goto L14;
    L9:
        JavaOnlyMap r105 = new JavaOnlyMap();
        r105.putBoolean(PTYSocketStateCallback.CLOSED, false);
        r105.putBoolean("pendingConfirm", true);
        return r105;
    L14:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        r102.show(r103, null);
        goto L9
    L11:
        this.f366817b.finish();
        JavaOnlyMap r106 = new JavaOnlyMap();
        r106.putBoolean(PTYSocketStateCallback.CLOSED, true);
        r106.putBoolean("pendingConfirm", false);
        return r106;
    }

    public f(Fragment r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "activity");
        this.f366816a = r100;
        this.f366817b = r101;
        this.f366819d = LazyKt.lazy(new a(this));
        this.f366820e = IAccountService.f286094a.getUserInfo();
        Intent r102 = r101.getIntent();
        String r103 = null;
        if (r102 == null) goto L7;
        Uri r104 = r102.getData();
        if (r104 == null) goto L7;
        String r105 = UriProtector.getQueryParameter(r104, "scene");
    L8:
        this.f366821f = Intrinsics.areEqual(r105, "account");
        Bundle r106 = r100.getArguments();
        String r107 = "setting";
        if (r106 == null) goto L20;
        String r108 = r106.getString("enter_from", "setting");
        if (r108 == null) goto L20;
        if (r108.length() <= 0) goto L15;
        boolean r109 = true;
    L16:
        if (r109 == false) goto L18;
        r103 = r108;
    L18:
        if (r103 == null) goto L20;
        r107 = r103;
        goto L20
    L15:
        r109 = false;
    L20:
        this.f366822g = r107;
        this.f366823h = "";
        this.f366824i = "";
        this.f366826k = "";
        this.f366827l = "";
        this.f366828m = "";
        return;
    L7:
        r105 = null;
        goto L8
    }
}
