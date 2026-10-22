package wm9;

import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.m.p.e;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginError;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginStage;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements IOfficeSDKPluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f560365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<String, Boolean> f560366b = null;

    /* JADX INFO: renamed from: wm9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8132a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f560367a = null;

        static {
            int[] r100 = new int[OfficeSDKPluginState.values().length];
            r100[OfficeSDKPluginState.INSTALLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[OfficeSDKPluginState.LOADED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[OfficeSDKPluginState.NOT_INSTALLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OfficeSDKPluginState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f560367a = r100;
        }
    }

    public static final class b implements PluginLoadBuilder.b, zk9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f560368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKPluginCallback f560369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f560370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IPluginService f560371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Class<?> f560372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f560373f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKPluginStage f560374g;

        /* JADX INFO: renamed from: wm9.a$b$a, reason: collision with other inner class name */
        public /* synthetic */ class C8133a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f560375a = null;

            static {
                int[] r100 = new int[OfficeSDKPluginStage.values().length];
                r100[OfficeSDKPluginStage.INSTALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[OfficeSDKPluginStage.LOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[OfficeSDKPluginStage.QUERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f560375a = r100;
            }
        }

        @Override // zk9.a
        public final void Wg() {
        }

        @Override // zk9.a
        public final void Zp(FragmentManager r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
        }

        @Override // zk9.a
        public final void zV() {
        }

        @Override // com.larus.mirabridge.api.bean.PluginLoadBuilder.b
        public final void onFailed() {
            int r100 = C8133a.f560375a[this.f560374g.ordinal()];
            if (r100 != 1) goto L5;
            int r101 = OfficeSDKPluginErrorCode.INSTALL_FAILED;
        L13:
            a(r101, "Flow failed to prepare OfficeSDK plugin: " + this.f560373f, null);
            return;
        L5:
            if (r100 != 2) goto L7;
            r101 = OfficeSDKPluginErrorCode.LOAD_FAILED;
            goto L13
        L7:
            if (r100 != 3) goto L10;
            r101 = -10006;
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.larus.mirabridge.api.bean.PluginLoadBuilder.b
        public final void onSuccess() {
            if (this.f560370c == true) goto L9;
            if (this.f560371d.c(this.f560372e) == true) goto L9;
            a(OfficeSDKPluginErrorCode.LOAD_FAILED, "Flow plugin loaded but SPI binding is unavailable: " + this.f560373f, null);
            return;
        L9:
            if (this.f560368a.compareAndSet(false, true) == false) goto L12;
            a.f560366b.add(this.f560373f);
            this.f560369b.onProgress(100);
            this.f560369b.onSuccess();
            return;
        }

        @Override // zk9.a
        public final void eg(int r100) {
            if (this.f560368a.get() == true) goto L6;
            this.f560369b.onProgress(RangesKt.coerceIn(r100, 0, 100));
            return;
        }

        public final void a(int r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r101, "message");
            if (this.f560368a.compareAndSet(false, true) == false) goto L6;
            a r103 = a.f560365a;
            OfficeSDKPluginCallback r104 = this.f560369b;
            OfficeSDKPluginStage r105 = this.f560374g;
            r103.getClass();
            a.Z1(r104, r105, r100, r101, r102);
            return;
        }

        public b(AtomicBoolean r100, OfficeSDKPluginCallback r101, boolean r102, IPluginService r103, Class<?> r104, String r105, OfficeSDKPluginStage r106) {
            this.f560368a = r100;
            this.f560369b = r101;
            this.f560370c = r102;
            this.f560371d = r103;
            this.f560372e = r104;
            this.f560373f = r105;
            this.f560374g = r106;
        }
    }

    public a() {
    }

    static {
        f560365a = new a();
        f560366b = ConcurrentHashMap.newKeySet();
    }

    @Override // com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService
    public final OfficeSDKPluginState getPluginState(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginId");
        if (StringsKt.isBlank(r100) == true) goto L5;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        IPluginService r102 = (IPluginService) ServiceManager.get().getService(IPluginService.class);     // Catch: Throwable -> L21
        if (r102 != null) goto L9;
        OfficeSDKPluginState r103 = OfficeSDKPluginState.UNKNOWN;     // Catch: Throwable -> L21
    L19:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L21
    L23:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L28;
        FLogger.f375446a.e("DoubaoOfficeSDKPluginService", "query plugin state failed, pluginId=" + r100, r105);
        r104 = OfficeSDKPluginState.UNKNOWN;
    L28:
        return (OfficeSDKPluginState) r104;
    L9:
        Class r106 = a2(r102, r100);     // Catch: Throwable -> L21
        if (r106 != null) goto L13;
        r103 = OfficeSDKPluginState.UNKNOWN;     // Catch: Throwable -> L21
        goto L19
    L13:
        if (r102.c(r106) == false) goto L16;
        r103 = OfficeSDKPluginState.LOADED;     // Catch: Throwable -> L21
        goto L19
    L16:
        if (f560366b.contains(r100) == false) goto L18;
        r103 = OfficeSDKPluginState.INSTALLED;     // Catch: Throwable -> L21
        goto L19
    L18:
        r103 = OfficeSDKPluginState.UNKNOWN;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L5:
        return OfficeSDKPluginState.UNKNOWN;
    }

    @Override // com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService
    public final boolean isPluginSupported(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginId");
        boolean r101 = false;
        if (StringsKt.isBlank(r100) == false) goto L21;
        return false;
    L21:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        IPluginService r103 = (IPluginService) ServiceManager.get().getService(IPluginService.class);     // Catch: Throwable -> L13
        if (r103 != null) goto L9;
    L11:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L13
    L15:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L20;
        FLogger.f375446a.e("DoubaoOfficeSDKPluginService", "query plugin support failed, pluginId=" + r100, r105);
        r104 = Boolean.FALSE;
    L20:
        return ((Boolean) r104).booleanValue();
    L9:
        if (a2(r103, r100) == null) goto L11;
        r101 = true;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static Class a2(IPluginService r100, String r101) {
        Iterator<T> r102 = r100.d().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        Map.Entry r104 = (Map.Entry) r103;
        Intrinsics.checkNotNull(r104);
        if (Intrinsics.areEqual(((al9.a) r104.getValue()).f4197a, r101) == false) goto L4;
    L9:
        Map.Entry r105 = (Map.Entry) r103;
        if (r105 != null) goto L12;
        return null;
    L12:
        return (Class) r105.getKey();
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService
    public final void installPlugin(String r100, OfficeSDKPluginCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        OfficeSDKPluginState r102 = getPluginState(r100);
        int r103 = C8132a.f560367a[r102.ordinal()];
        if (r103 != 1) goto L5;
    L14:
        r101.onSuccess();
        return;
    L5:
        if (r103 == 2) goto L14;
        if (r103 != 3) goto L9;
    L13:
        X0(r100, OfficeSDKPluginStage.INSTALL, true, r101);
        return;
    L9:
        if (r103 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService
    public final void loadPlugin(String r100, OfficeSDKPluginCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (getPluginState(r100) != OfficeSDKPluginState.LOADED) goto L6;
        r101.onSuccess();
        return;
    L6:
        X0(r100, OfficeSDKPluginStage.LOAD, false, r101);
    }

    public final void X0(String r110, OfficeSDKPluginStage r111, boolean r112, OfficeSDKPluginCallback r113) {
        if (StringsKt.isBlank(r110) == false) goto L6;
        Z1(r113, r111, -10000, "OfficeSDK plugin id is blank", null);
        return;
    L6:
        IPluginService r114 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        if (r114 != null) goto L10;
        Z1(r113, r111, -10001, "Flow IPluginService is not registered", null);
        return;
    L10:
        Class<?> r115 = a2(r114, r110);
        if (r115 != null) goto L14;
        Z1(r113, r111, -10002, "Flow plugin is not registered for OfficeSDK: " + r110, null);
        return;
    L14:
        b r116 = new b(new AtomicBoolean(false), r113, r112, r114, r115, r110, r111);
        PluginLoadBuilder r100 = new PluginLoadBuilder();
        Intrinsics.checkNotNullParameter(r110, "packageName");
        r100.f359294a = r110;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type java.lang.Class<*>");
        r100.f359295b = r115;
        PluginLoadBuilder.PluginLoadType r101 = PluginLoadBuilder.PluginLoadType.ASYNC;
        Intrinsics.checkNotNullParameter(r101, "type");
        r100.f359298e = r101;
        PluginLoadBuilder.PluginLoadTime r102 = PluginLoadBuilder.PluginLoadTime.IMMEDIATE;
        Intrinsics.checkNotNullParameter(r102, e.f25671s);
        r100.f359297d = r102;
        r100.f359300g = 15000;
        r100.f359301h = r112;
        Intrinsics.checkNotNullParameter(r116, "loadingUI");
        r100.f359296c = new WeakReference(r116);
        Intrinsics.checkNotNullParameter(r116, "result");
        r100.f359299f = r116;
        PluginLoadBuilder.c r103 = r100.a();
        r113.onProgress(0);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        r114.a(r103);     // Catch: Throwable -> L17
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L25;
        r116.a(-10004, "Flow plugin operation threw an exception: ".concat(r110), r106);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static void Z1(OfficeSDKPluginCallback r110, OfficeSDKPluginStage r111, int r112, String r113, Throwable r114) {
        if (r114 == null) goto L5;
        FLogger.f375446a.e("DoubaoOfficeSDKPluginService", r113, r114);
    L6:
        r110.onFailure(new OfficeSDKPluginError(r111, r112, r113, null, r114, 8, null));
        return;
    L5:
        FLogger.f375446a.e("DoubaoOfficeSDKPluginService", r113);
        goto L6
    }
}
