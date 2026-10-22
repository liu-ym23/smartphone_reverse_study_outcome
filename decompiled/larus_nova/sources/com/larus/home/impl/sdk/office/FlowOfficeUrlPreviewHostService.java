package com.larus.home.impl.sdk.office;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import com.larus.home.impl.sdk.x1;
import com.larus.office.base.preview.OfficePreviewNavigator;
import com.larus.office.card.urlpreview.v1;
import com.larus.platform.api.IOfficeUrlPreviewHostService;
import com.larus.platform.api.a1;
import com.larus.platform.api.q4;
import com.larus.platform.api.r4;
import com.ss.android.lark.integrator.im.impl.preview.OfficeUrlPreviewPageServiceImpl;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kc9.c;
import kc9.f;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import sza.d;
import xp9.n;
import xp9.o;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0017J \u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0016J<\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e\u0012\u0004\u0012\u00020\u00110\u001dH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/home/impl/sdk/office/FlowOfficeUrlPreviewHostService;", "Lcom/larus/platform/api/IOfficeUrlPreviewHostService;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "isOfficeSdkReady", "", "openPreview", "request", "Lcom/larus/platform/api/OfficeUrlPreviewHostOpenRequest;", "ensureReady", "Lcom/larus/platform/api/IOfficeUrlPreviewHostReadyHandle;", "source", "", "onReady", "Lkotlin/Function0;", "", "getInitState", "Lcom/larus/platform/api/OfficeSdkInitState;", "createPage", "Lcom/larus/platform/api/IOfficeUrlPreviewHostPage;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "renderConfigProvider", "Lcom/larus/platform/api/IOfficeUrlPreviewHostRenderConfigProvider;", "onPreviewUpdated", "Lkotlin/Function1;", "", "getUrlPreviewService", "Lcom/ss/android/lark/biz/officesdk/im/preview/IOfficeUrlPreviewService;", "ReadyHandle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowOfficeUrlPreviewHostService implements IOfficeUrlPreviewHostService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f346214a;

    public final class a implements a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f346215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f346216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f346217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final kc9.b f346218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f346219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FlowOfficeUrlPreviewHostService f346220f;

        public final void a() {
            this.f346220f.getClass();
            if ((n.f564774a instanceof OfficeSDKGlobalApi) == false) goto L7;
            x1 r100 = x1.f346268a;
            if (f.a().f365249c == false) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == true) goto L10;
            return;
        L10:
            if (this.f346216b.get() == false) goto L13;
            return;
        L13:
            if (this.f346217c.compareAndSet(false, true) == false) goto L17;
            this.f346220f.f346214a.post(this.f346218d);
            return;
        L17:
            return;
        L7:
            r101 = false;
            goto L8
        }

        @Override // com.larus.platform.api.a1
        public final void cancel() {
            if (this.f346216b.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f346220f.f346214a.removeCallbacks(this.f346218d);
            Object r100 = n.f564774a;
            n.b(this.f346219e);
            Object r101 = o.f564776a;
            o.d(this.f346219e);
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [kc9.b] */
        /* JADX WARN: Type inference failed for: r2v4, types: [kc9.c] */
        public a(FlowOfficeUrlPreviewHostService r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "onReady");
            this.f346220f = r100;
            this.f346215a = r101;
            this.f346216b = new AtomicBoolean(false);
            this.f346217c = new AtomicBoolean(false);
            this.f346218d = new kc9.b(this);
            this.f346219e = new c(this);
        }
    }

    public static final class b implements d, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f346221a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f346221a = r100;
        }

        @Override // sza.d
        public final /* synthetic */ void a(List r100) {
            this.f346221a.invoke(r100);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof d) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f346221a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    @Override // com.larus.platform.api.IOfficeUrlPreviewHostService
    public final q4 a() {
        return x1.f346268a.f();
    }

    public FlowOfficeUrlPreviewHostService() {
        this.f346214a = new Handler(Looper.getMainLooper());
    }

    @Override // com.larus.platform.api.IOfficeUrlPreviewHostService
    public final boolean c(r4 r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        OfficePreviewNavigator r100 = OfficePreviewNavigator.f361008a;
        com.larus.office.base.preview.b r111 = new com.larus.office.base.preview.b(r110.getContext(), r110.f365254b, r110.f365255c, r110.f365256d, r110.f365257e, null, r110.f365258f, r110.f365259g, r110.f365260h, null, 544);
        r100.getClass();
        return OfficePreviewNavigator.a(r111);
    }

    @Override // com.larus.platform.api.IOfficeUrlPreviewHostService
    public final a d(Function0 r100) {
        Intrinsics.checkNotNullParameter("office_url_preview", "source");
        Intrinsics.checkNotNullParameter(r100, "onReady");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L20;
        if ((n.f564774a instanceof OfficeSDKGlobalApi) == false) goto L9;
        x1 r101 = x1.f346268a;
        if (f.a().f365249c == false) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        a r103 = new a(this, r100);
        n.a(r103.f346219e);
        Object r104 = o.f564776a;
        o.a(r103.f346219e);
        x1.f346268a.d(false, "office_url_preview");     // Catch: Throwable -> L16
        r103.a();     // Catch: Throwable -> L16
        return r103;
    L16:
        th = move-exception;
        r103.cancel();
        throw th;
    L9:
        r102 = false;
        goto L10
    L20:
        throw new IllegalStateException("ensureReady must be called on the main thread".toString());
    }

    @Override // com.larus.platform.api.IOfficeUrlPreviewHostService
    public final kc9.d b(Context r100, LifecycleOwner r101, v1 r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "renderConfigProvider");
        Intrinsics.checkNotNullParameter(r103, "onPreviewUpdated");
        Object r104 = n.f564774a;
        if ((r104 instanceof OfficeSDKGlobalApi) == false) goto L5;
        OfficeSDKGlobalApi r105 = (OfficeSDKGlobalApi) r104;
    L6:
        if (r105 == null) goto L11;
        aza.c r106 = (aza.c) r105.getService(aza.c.class);
        if (r106 == null) goto L11;
        sza.c r107 = r106.N1();
    L12:
        if (r107 == null) goto L18;
        OfficeUrlPreviewPageServiceImpl r108 = r107.b(r100, r101, new kc9.a(r102), new b(r103));
        if (r108 == null) goto L18;
        return new kc9.d(r108);
    L18:
        return null;
    L11:
        r107 = null;
        goto L12
    L5:
        r105 = null;
        goto L6
    }
}
