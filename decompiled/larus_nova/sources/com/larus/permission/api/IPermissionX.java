package com.larus.permission.api;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.home.impl.sdk.w0;
import com.larus.setting.impl.iconchanger.ChangeAppIconManager;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 #2\u00020\u0001:\u0004#$%&J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nj\u0002`\fH&JP\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nj\u0002`\f2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&JP\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0011j\u0002`\u0012H&J2\u0010\u0013\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0014H&Jh\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0011j\u0002`\u00122\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&J@\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00142\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H&JJ\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00142\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u000bH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\bH&J0\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u001cH&J\u001c\u0010\u001d\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&¨\u0006'"}, d2 = {"Lcom/larus/permission/api/IPermissionX;", "", "permission", "", "activity", "Landroidx/fragment/app/FragmentActivity;", ErrorType.MANIFEST, "", "", "requestCallBack", "Lkotlin/Function1;", "", "Lcom/larus/permission/api/RequestPermissionCallback;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "subTitleMap", "", "Lkotlin/Function3;", "Lcom/larus/permission/api/RequestPermissionDataCallback;", "permissionAny", "Lcom/larus/permission/api/IPermissionX$IRequestPermissionCallback;", "showGoSettingsDialog", "registerGoToSystemSettingCallback", "callback", "Lcom/larus/permission/api/IGotoSettingPageCallback;", "hasPermissionRequest", "showGoSettingPageDialog", "subTitle", "Lcom/larus/permission/api/IPermissionX$IGoSettingPageCallback;", "goPermissionSettings", "checkExplainRequestDialog", "addPermissionInterceptor", "interceptor", "Lcom/larus/permission/api/IPermissionX$IPermissionInterceptor;", "removePermissionInterceptor", "Companion", "IRequestPermissionCallback", "IGoSettingPageCallback", "IPermissionInterceptor", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPermissionX {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f363962a = null;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012j\u0002`\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J,\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0016JN\u0010\u000b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012j\u0002`\u00142\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016JP\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102.\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\f0 j\u0002`!H\u0016Jf\u0010\u000b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102.\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\f0 j\u0002`!2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016J>\u0010\u000b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\"2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016JF\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\"2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020\u0013H\u0016J2\u0010$\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\"H\u0016J\u001a\u0010%\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006+"}, d2 = {"Lcom/larus/permission/api/IPermissionX$Companion;", "Lcom/larus/permission/api/IPermissionX;", "<init>", "()V", "MANIFEST_PERMISSION_POST_NOTIFICATIONS", "", "impl", "getImpl", "()Lcom/larus/permission/api/IPermissionX;", "impl$delegate", "Lkotlin/Lazy;", "permission", "", "activity", "Landroidx/fragment/app/FragmentActivity;", ErrorType.MANIFEST, "", "requestCallBack", "Lkotlin/Function1;", "", "Lcom/larus/permission/api/RequestPermissionCallback;", "registerGoToSystemSettingCallback", "callback", "Lcom/larus/permission/api/IGotoSettingPageCallback;", "hasPermissionRequest", "showGoSettingPageDialog", "subTitle", "Lcom/larus/permission/api/IPermissionX$IGoSettingPageCallback;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "subTitleMap", "", "Lkotlin/Function3;", "Lcom/larus/permission/api/RequestPermissionDataCallback;", "Lcom/larus/permission/api/IPermissionX$IRequestPermissionCallback;", "showGoSettingsDialog", "permissionAny", "goPermissionSettings", "checkExplainRequestDialog", "addPermissionInterceptor", "interceptor", "Lcom/larus/permission/api/IPermissionX$IPermissionInterceptor;", "removePermissionInterceptor", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IPermissionX {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f363963b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IPermissionX> f363964c = null;

        private Companion() {
        }

        static {
            f363963b = new Companion();
            f363964c = LazyKt.lazy(new gp9.b());
        }

        public static IPermissionX c() {
            return f363964c.getValue();
        }

        @Override // com.larus.permission.api.IPermissionX
        public final boolean d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "permission");
            IPermissionX r101 = c();
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.d(r100) != true) goto L7;
            return true;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void g(ChangeAppIconManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            IPermissionX r101 = c();
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final boolean k(Fragment r100) {
            IPermissionX r101 = c();
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.k(r100) != true) goto L7;
            return true;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void m(lb9.b r100) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            IPermissionX r101 = c();
            if (r101 == null) goto L6;
            r101.m(r100);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void j(FragmentActivity r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            IPermissionX r102 = c();
            if (r102 == null) goto L6;
            r102.j(r100, r101);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void a(FragmentActivity r100, List<String> r101, Function1<? super Boolean, Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r102, "requestCallBack");
            IPermissionX r103 = c();
            if (r103 == null) goto L6;
            r103.a(r100, r101, r102);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void e(FragmentActivity r100, List<String> r101, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r102, "requestCallBack");
            IPermissionX r103 = c();
            if (r103 == null) goto L6;
            r103.e(r100, r101, r102);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void b(Fragment r100, List<String> r101, Function1<? super Boolean, Unit> r102, Map<String, String> r103) {
            Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r102, "requestCallBack");
            IPermissionX r104 = c();
            if (r104 == null) goto L6;
            r104.b(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void f(FragmentActivity r100, String r101, String r102, w0.e r103) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "permission");
            IPermissionX r104 = c();
            if (r104 == null) goto L6;
            r104.f(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void h(Fragment r100, FragmentActivity r101, List r102, w0.a r103) {
            Intrinsics.checkNotNullParameter(r102, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r103, "requestCallBack");
            IPermissionX r104 = c();
            if (r104 == null) goto L6;
            r104.h(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void l(Fragment r100, List r101, w0.a r102, Map r103) {
            Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r102, "requestCallBack");
            IPermissionX r104 = c();
            if (r104 == null) goto L6;
            r104.l(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.permission.api.IPermissionX
        public final void i(FragmentActivity r100, List r101, w0.a r110, Map r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r110, "requestCallBack");
            IPermissionX r102 = c();
            if (r102 == null) goto L6;
            r102.i(r100, r101, r110, r111, r112);
            return;
        }
    }

    public interface a {
        void a(boolean r100, String r101);

        void b(String r100);

        void onSettingPageReturn();
    }

    public interface b {
        boolean a(String r100, List<String> r101);
    }

    public interface c extends a {
        void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103);
    }

    static {
        f363962a = Companion.f363963b;
    }

    void a(FragmentActivity r100, List<String> r101, Function1<? super Boolean, Unit> r102);

    void b(Fragment r100, List<String> r101, Function1<? super Boolean, Unit> r102, Map<String, String> r103);

    boolean d(String r100);

    void e(FragmentActivity r100, List<String> r101, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r102);

    void f(FragmentActivity r100, String r101, String r102, w0.e r103);

    void g(ChangeAppIconManager.a r100);

    void h(Fragment r100, FragmentActivity r101, List r102, w0.a r103);

    void i(FragmentActivity r100, List r101, w0.a r102, Map r103, boolean r104);

    void j(FragmentActivity r100, c r101);

    boolean k(Fragment r100);

    void l(Fragment r100, List r101, w0.a r102, Map r103);

    void m(lb9.b r100);
}
