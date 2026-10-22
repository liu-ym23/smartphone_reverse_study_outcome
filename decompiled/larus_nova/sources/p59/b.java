package p59;

import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.nl.n;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.util.b0;
import com.larus.nova.R;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f527842a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527843a = null;

        static {
            int[] r100 = new int[CategoryWhenNotGranted.values().length];
            r100[CategoryWhenNotGranted.NEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CategoryWhenNotGranted.LOOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CategoryWhenNotGranted.INTERRUPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f527843a = r100;
        }
    }

    /* JADX INFO: renamed from: p59.b$b, reason: collision with other inner class name */
    public static final class C7154b implements IPermissionX.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f527844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<ProactivePermission> f527845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CategoryWhenNotGranted f527846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f527847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List<ProactivePermission> f527848e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<ProactivePermission> f527849f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function3<Boolean, List<? extends ProactivePermission>, List<? extends ProactivePermission>, Unit> f527850g;

        @Override // com.larus.permission.api.IPermissionX.a
        public final void onSettingPageReturn() {
            StringBuilder r100 = new StringBuilder("checkPermission: ");
            ProactivePermission r110 = ProactivePermission.NOTIFICATION_LISTENER;
            r100.append(r110);
            r100.append(" onSettingPageReturn");
            g49.d.d("ProactivePermissionX", r100.toString());
            boolean r101 = n.d();
            int r102 = b.f527842a;
            b.a(this.f527844a, this.f527845b, this.f527846c, this.f527847d, this.f527848e, this.f527849f, this.f527850g, r101, r110);
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void b(String r100) {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.NOTIFICATION_LISTENER + " onGoSettingsDialogShow");
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void a(boolean r110, String r111) {
            StringBuilder r112 = new StringBuilder("checkPermission: ");
            ProactivePermission r100 = ProactivePermission.NOTIFICATION_LISTENER;
            r112.append(r100);
            r112.append(" onGoSettingsDialogDismiss: isConfirmed=");
            r112.append(r110);
            g49.d.d("ProactivePermissionX", r112.toString());
            if (r110 == true) goto L6;
            int r113 = b.f527842a;
            b.a(this.f527844a, this.f527845b, this.f527846c, this.f527847d, this.f527848e, this.f527849f, this.f527850g, false, r100);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.NOTIFICATION_LISTENER + " allGranted=" + r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C7154b(Fragment r100, List<? extends ProactivePermission> r101, CategoryWhenNotGranted r102, int r103, List<ProactivePermission> r104, List<ProactivePermission> r105, Function3<? super Boolean, ? super List<? extends ProactivePermission>, ? super List<? extends ProactivePermission>, Unit> r106) {
            this.f527844a = r100;
            this.f527845b = r101;
            this.f527846c = r102;
            this.f527847d = r103;
            this.f527848e = r104;
            this.f527849f = r105;
            this.f527850g = r106;
        }
    }

    public static final class c implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f527851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<ProactivePermission> f527852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CategoryWhenNotGranted f527853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f527854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List<ProactivePermission> f527855e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<ProactivePermission> f527856f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function3<Boolean, List<? extends ProactivePermission>, List<? extends ProactivePermission>, Unit> f527857g;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " onGoSettingsDialogShow");
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " onSettingPageReturn");
            int r100 = b.f527842a;
            a(b.d());
        }

        public final void a(boolean r110) {
            int r100 = b.f527842a;
            b.a(this.f527851a, this.f527852b, this.f527853c, this.f527854d, this.f527855e, this.f527856f, this.f527857g, r110, ProactivePermission.POST_NOTIFICATION);
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " onGoSettingsDialogDismiss: isConfirmed=" + r100);
            if (r100 == true) goto L6;
            a(false);
            return;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            if (r103 == false) goto L5;
            return;
        L5:
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " allGranted=" + r100);
            a(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Fragment r100, List<? extends ProactivePermission> r101, CategoryWhenNotGranted r102, int r103, List<ProactivePermission> r104, List<ProactivePermission> r105, Function3<? super Boolean, ? super List<? extends ProactivePermission>, ? super List<? extends ProactivePermission>, Unit> r106) {
            this.f527851a = r100;
            this.f527852b = r101;
            this.f527853c = r102;
            this.f527854d = r103;
            this.f527855e = r104;
            this.f527856f = r105;
            this.f527857g = r106;
        }
    }

    static {
    }

    public b() {
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), "android.permission.POST_NOTIFICATIONS") != 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        return NotificationManagerCompat.from(AppHost.f326268a.getApplication()).areNotificationsEnabled();
    }

    public static boolean e(DoraOnboardingBaseFragment r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        boolean r102 = true;
        if (r101.contains(ProactivePermission.POST_NOTIFICATION) == false) goto L5;
        boolean r103 = d();
    L7:
        if (r101.contains(ProactivePermission.NOTIFICATION_LISTENER) == false) goto L15;
        if (r103 == true) goto L10;
    L12:
        r102 = false;
    L14:
        return r102;
    L10:
        if (n.d() == false) goto L12;
    L15:
        return r103;
    L5:
        r103 = true;
        goto L7
    }

    public static void c(Fragment r100, List r101, CategoryWhenNotGranted r110, Function3 r111) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r110, "category");
        Intrinsics.checkNotNullParameter(r111, "onResult");
        b(r100, r101, r110, 0, new ArrayList(), new ArrayList(), r111);
    }

    public static void b(Fragment r110, List r111, CategoryWhenNotGranted r112, int r113, List r114, List r115, Function3 r116) {
        g49.d.d("ProactivePermissionX", "checkPermission: start loopCheck=" + r113 + ", loopCount=" + r113);
        ProactivePermission r100 = ProactivePermission.POST_NOTIFICATION;
        if (r111.contains(r100) == false) goto L17;
        boolean r101 = d();
        g49.d.d("ProactivePermissionX", "checkPermission: " + r100 + " isGranted=" + r101);
        if (r101 == true) goto L16;
        c r117 = new c(r110, r111, r112, r113, r114, r115, r116);
        g49.d.d("ProactivePermissionX", "checkPermission: " + r100 + " requestPermission");
        b0.f338123a.getClass();
        b0.F();
        if (Build.VERSION.SDK_INT < 33) goto L9;
        List r102 = CollectionsKt.mutableListOf(new String[]{"android.permission.POST_NOTIFICATIONS"});
        i2 r103 = i2.f365748b;
        g1.a.a(r110, r102, r117, null, null, 24);
        return;
    L9:
        Context r104 = r110.getContext();
        if ((r104 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r105 = (FragmentActivity) r104;
    L13:
        if (r105 == null) goto L33;
        i2.f365748b.l(r105, "android.permission.POST_NOTIFICATIONS", null, r117);
        return;
    L33:
        return;
    L12:
        r105 = null;
        goto L13
    L16:
        r114.add(r100);
    L17:
        ProactivePermission r106 = ProactivePermission.NOTIFICATION_LISTENER;
        if (r111.contains(r106) == false) goto L30;
        boolean r107 = n.d();
        g49.d.d("ProactivePermissionX", "checkPermission: " + r106 + " isGranted=" + r107);
        if (r107 == true) goto L29;
        b0.f338123a.getClass();
        b0.F();
        C7154b r108 = new C7154b(r110, r111, r112, r113, r114, r115, r116);
        if (r110.isStateSaved() == false) goto L24;
        g49.d.d("ProactivePermissionX", "fragment is state saved");
        return;
    L24:
        Context r109 = r110.getContext();
        if (r109 == null) goto L35;
        r108.b(null);
        CommonDialog.a r118 = new CommonDialog.a();
        r118.i(r109.getString(R.string.larus_dora_broadcast_access_title_cn));
        r118.g(r109.getString(R.string.larus_dora_broadcast_access_content_cn));
        r118.f327197z = false;
        CommonDialog.a.f(r118, new p59.c(r108, r109, r110), r109.getString(R.string.larus_dora_goto_settings_cn), false, 12);
        CommonDialog.a.e(r118, new d(r108), r109.getString(R.string.larus_dora_dialog_btn_cancel_cn), 4);
        r118.a().T90(r110.getParentFragmentManager(), null);
        return;
    L35:
        return;
    L29:
        r114.add(r106);
    L30:
        boolean r119 = r115.isEmpty();
        g49.d.d("ProactivePermissionX", "checkPermission: all permission checked, allGranted=" + r119 + ", grantedPermissions=" + r114 + ", deniedPermissions=" + r115);
        r116.invoke(Boolean.valueOf(r119), r114, r115);
    }

    public static final void a(Fragment r110, List r111, CategoryWhenNotGranted r112, int r113, List r114, List r115, Function3 r116, boolean r117, ProactivePermission r118) {
        if (r117 == false) goto L14;
        ArrayList r100 = new ArrayList();
        Iterator r101 = r111.iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        if (((ProactivePermission) r102) == r118) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L6;
        r100.add(r102);
        goto L6
    L10:
        r103 = false;
        goto L11
    L13:
        r114.add(r118);
        Unit r104 = Unit.INSTANCE;
        b(r110, r100, r112, r113 + 1, r114, r115, r116);
        return;
    L14:
        int r105 = a.f527843a[r112.ordinal()];
        if (r105 != 1) goto L17;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r111.iterator();
    L26:
        if (r107.hasNext() == false) goto L33;
        Object r108 = r107.next();
        if (((ProactivePermission) r108) == r118) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == false) goto L26;
        r106.add(r108);
        goto L26
    L30:
        r109 = false;
        goto L31
    L33:
        r115.add(r118);
        Unit r119 = Unit.INSTANCE;
        b(r110, r106, r112, r113 + 1, r114, r115, r116);
        return;
    L17:
        if (r105 != 2) goto L19;
        b(r110, r111, r112, r113 + 1, r114, r115, r116);
        return;
    L19:
        if (r105 != 3) goto L22;
        Boolean r120 = Boolean.FALSE;
        r115.add(r118);
        Unit r121 = Unit.INSTANCE;
        r116.invoke(r120, r114, r115);
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
