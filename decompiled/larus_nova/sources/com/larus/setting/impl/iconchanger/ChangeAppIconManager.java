package com.larus.setting.impl.iconchanger;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Size;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.common_ui.dialog.l1;
import com.larus.common_ui.dialog.p0;
import com.larus.home.api.main.AppIconsType;
import com.larus.home.api.main.HomeService;
import com.larus.image.loader.b0;
import com.larus.nova.R;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import v19.c7;
import v19.q5;

/* JADX INFO: loaded from: classes31.dex */
public final class ChangeAppIconManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<CommonDialog> f368330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f368331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Integer> f368332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f368333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f368334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f368335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f368336g;

    public static final class a implements gp9.a {
        public a() {
        }

        @Override // gp9.a
        public final void a() {
            WeakReference<CommonDialog> r100 = ChangeAppIconManager.f368330a;
            ChangeAppIconManager.f368331b = false;
        }
    }

    public static final class b implements q5 {
        public b() {
        }

        @Override // v19.q5
        public final void gotoToSystemPage() {
            WeakReference<CommonDialog> r100 = ChangeAppIconManager.f368330a;
            ChangeAppIconManager.f368331b = false;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f368337a;

        public c(u r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f368337a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f368337a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f368337a.invoke(r100);
        }
    }

    public static final class d implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<CommonDialog, Unit> f368338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<CommonDialog> f368339b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            Function1<CommonDialog, Unit> r100 = this.f368338a;
            if (r100 == null) goto L6;
            r100.invoke(this.f368339b.element);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super CommonDialog, Unit> r100, Ref.ObjectRef<CommonDialog> r101) {
            this.f368338a = r100;
            this.f368339b = r101;
        }
    }

    public static final class e implements l1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f368340a;

        @Override // com.larus.common_ui.dialog.l1
        public final void a() {
            Function0<Unit> r100 = this.f368340a;
            if (r100 == null) goto L6;
            r100.invoke();
            return;
        }

        public e(Function0<Unit> r100) {
            this.f368340a = r100;
        }
    }

    static {
        f368331b = true;
        f368332c = new LinkedHashSet();
        f368333d = true;
    }

    public static boolean a() {
        c1<e0> r100 = AuthModelDelegate.f297134b.c().getValue();
        if (r100 == null) goto L11;
        e0 r101 = r100.f295753d;
        if (r101 == null) goto L11;
        List<CocoSetting> r102 = r101.p();
        if (r102 == null) goto L11;
        if (r102.size() != f368332c.size()) goto L11;
        return true;
    L11:
        return false;
    }

    public static void b() {
        if (f368336g == false) goto L5;
        return;
    L5:
        f368336g = true;
        AccountService.f365697a.E(new w());
        AppHost.Companion r100 = AppHost.f326268a;
        r100.a().j(new ChangeAppIconManager$registerBackGroundListener$2());
        f368334e = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new ChangeAppIconManager$initActivityOnResumeListener$1(null), 3, null);
        if (z2.f365865a.getBasicExperienceAnrOptConfig().a() == false) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ChangeAppIconManager$initActivityOnResumeListener$2(null), 3, null);
    L9:
        r100.getApplication().registerActivityLifecycleCallbacks(new v());
        IPermissionX.f363962a.g(new a());
        v19.a.a(new b());
        return;
    L8:
        c();
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.setting.impl.iconchanger.u] */
    public static void c() {
        Transformations.map(AuthModelDelegate.f297134b.c(), new t()).observeForever(new c(new u()));
    }

    public static void f() {
        if (a() == false) goto L5;
        return;
    L5:
        boolean r100 = Fresco.hasBeenInitialized();
        FLogger.f375446a.i("ChangeAppIconDynamicImgLoader", "preload frescoInitialized = " + r100);
        if (r100 == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChangeAppIconManager$preload$1(null), 2, null);
    }

    public static void e(boolean r100) {
        Job r101 = f368335f;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        f368335f = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new ChangeAppIconManager$postShowSyncDialog$1(r100, null), 3, null);
    }

    public static void h(final int r110) {
        HomeService r100 = HomeService.f344094a;
        AppHost.Companion r101 = AppHost.f326268a;
        Integer r102 = r100.H(r101.getApplication());
        if (r102 == null) goto L27;
        int r103 = r102.intValue();
        Integer r104 = r100.s().get(Integer.valueOf(r110));
        Activity r105 = r101.a().getCurrentActivity();
        String r106 = null;
        if ((r105 instanceof FragmentActivity) == false) goto L7;
        final FragmentActivity r107 = (FragmentActivity) r105;
    L8:
        FLogger r108 = FLogger.f375446a;
        r108.i("ChangeAppIconDynamicImgLoader", "currentUseAppIconId=" + r103 + " shouldShowAppIconId=" + r110);
        if (r103 != r110) goto L11;
        return;
    L11:
        if (r104 == null) goto L28;
        String r109 = "res://" + r101.getApplication().getPackageName() + '/' + r104.intValue();
        if (Build.VERSION.SDK_INT < 29) goto L15;
        boolean r111 = true;
    L16:
        if (r111 == false) goto L29;
        r108.i("ChangeAppIconDynamicImgLoader", "currentUseAppIconId=" + r103 + " shouldShowAppIconId=" + r110 + " enableShowSyncDialog=" + f368333d);
        if (f368333d == true) goto L20;
        return;
    L20:
        f368333d = false;
        if (r107 == null) goto L23;
        r106 = r107.getString(R.string.larus_change_app_avatar_backtodefault, new Object[]{r101.getAppStringName()});
    L23:
        if (r106 != null) goto L25;
        r106 = "";
    L25:
        g(r107, r106, r109, new r(), new s(r107, r110));
        return;
    L29:
        return;
    L15:
        r111 = false;
        goto L16
    L28:
        return;
    L7:
        r107 = null;
        goto L8
    }

    public static void d(Context r100, AppIconsType r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("onAppBackground isBack = ");
        AppHost.Companion r104 = AppHost.f326268a;
        r103.append(r104.a().isAppBackground());
        r102.i("ChangeAppIconDynamicImgLoader", r103.toString());
        if (r104.a().isAppBackground() == true) goto L5;
        return;
    L5:
        HomeService r105 = HomeService.f344094a;
        Integer r106 = r105.H(r100);
        if (r106 == null) goto L16;
        int r107 = r106.intValue();
        et9.e.a().stopAudio();
        if (Build.VERSION.SDK_INT < 29) goto L10;
        boolean r108 = true;
    L11:
        if (r108 == true) goto L13;
        return;
    L13:
        if (r107 == r101.getAppIconId()) goto L18;
        r105.w(r100, r101);
        return;
    L18:
        return;
    L10:
        r108 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r8v12, types: [T, com.larus.common_ui.dialog.CommonDialog] */
    public static void g(FragmentActivity r100, String r101, String r102, Function0 r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r101, "title");
        if (r100 != null) goto L5;
        return;
    L5:
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        WeakReference<CommonDialog> r104 = f368330a;     // Catch: Exception -> L18
        if (r104 == null) goto L16;
        CommonDialog r105 = r104.get();     // Catch: Exception -> L18
        if (r105 == null) goto L16;
        r105.dismiss();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L18
        Throwable r106 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L18
        if (r106 == null) goto L16;
        com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L18
    L16:
        CommonDialog.a r107 = new CommonDialog.a();     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r101, "title");     // Catch: Exception -> L18
        r107.f327172a = r101;     // Catch: Exception -> L18
        r107.f327174c = Float.valueOf(c7.b(16));     // Catch: Exception -> L18
        r107.f327176e = b0.a(r102, "change_app_icon", false, false, 6);     // Catch: Exception -> L18
        Size r108 = new Size(c7.b(80), c7.b(80));     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r108, "size");     // Catch: Exception -> L18
        r107.f327177f = r108;     // Catch: Exception -> L18
        r107.f327175d = true;     // Catch: Exception -> L18
        f0 r109 = new f0(null, Integer.valueOf(ContextCompat.getColor(r100, R.color.larus_primary_50)), null, 5);     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r109, "commonDialogTextStyleConfig");     // Catch: Exception -> L18
        r107.D = r109;     // Catch: Exception -> L18
        CommonDialog.a.f(r107, new d(r111, r103), r100.getString(R.string.larus_change_app_avatar_restartapp_confirm), false, 12);     // Catch: Exception -> L18
        r107.f327194w = true;     // Catch: Exception -> L18
        r107.f327173b = false;     // Catch: Exception -> L18
        e r112 = new e(r110);     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r112, "listener");     // Catch: Exception -> L18
        r107.f327193v = r112;     // Catch: Exception -> L18
        ?? r113 = r107.b(ContextCompat.getColor(r100, R.color.larus_primary_50));     // Catch: Exception -> L18
        r103.element = r113;     // Catch: Exception -> L18
        r113.T90(r100.getSupportFragmentManager(), null);     // Catch: Exception -> L18
        f368330a = new WeakReference(r103.element);     // Catch: Exception -> L18
        return;
    }
}
