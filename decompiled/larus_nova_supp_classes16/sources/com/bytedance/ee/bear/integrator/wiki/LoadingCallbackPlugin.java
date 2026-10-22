package com.bytedance.ee.bear.integrator.wiki;

import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.i;
import com.bytedance.ee.bear.contract.route.parcelable.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0001H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/integrator/wiki/LoadingCallbackPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "Lcom/bytedance/ee/bear/contract/route/parcelable/LoadingCallbackAbility;", "Lcom/bytedance/ee/bear/contract/route/parcelable/LoadingCallbackPluginProvider;", "<init>", "()V", "loadingCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ee/bear/contract/route/parcelable/LoadingCallbackAbility$LoadingCallback;", "documentLoaderCallback", "Lcom/bytedance/ee/bear/integrator/wiki/LoadingCallbackPlugin$DocumentLoaderCallback;", "getDocumentLoaderCallback", "()Lcom/bytedance/ee/bear/integrator/wiki/LoadingCallbackPlugin$DocumentLoaderCallback;", "documentLoaderCallback$delegate", "Lkotlin/Lazy;", "driveLoaderCallback", "Lcom/bytedance/ee/bear/integrator/wiki/LoadingCallbackPlugin$DriveLoaderCallback;", "getDriveLoaderCallback", "()Lcom/bytedance/ee/bear/integrator/wiki/LoadingCallbackPlugin$DriveLoaderCallback;", "driveLoaderCallback$delegate", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "addLoadingCallback", "callback", "newLoadingCallbackPlugin", "DocumentLoaderCallback", "DriveLoaderCallback", "Companion", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingCallbackPlugin extends BasePluginV2 implements i, j {
    public static final a Companion = null;
    private static final String TAG = "LoadingCallbackPlugin";
    private final Lazy documentLoaderCallback$delegate;
    private final Lazy driveLoaderCallback$delegate;
    private final CopyOnWriteArrayList<i.a> loadingCallbacks;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends x2.c {
        public final List<i.a> a;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((i.a) r0.next()).onLoadStart();
            goto L4
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((i.a) r0.next()).onLoadSuccess();
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends i.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "loadingCallbacks");
            this.a = r2;
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            Iterator<T> r3 = this.a.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((i.a) r3.next()).onLoadFail();
            goto L4
        }
    }

    public static final class c implements u75.b.a {
        public final List<i.a> a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.LoadStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[InfoCode.FileNotChange.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[InfoCode.WPS_PREVIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        @Override // u75.b.a
        public final void onProgress(int r1) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends i.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "loadingCallbacks");
            this.a = r2;
        }

        @Override // u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
            Iterator<T> r3 = this.a.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((i.a) r3.next()).onLoadSuccess();
            goto L4
        }

        @Override // u75.b.a
        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            i.a r1 = (i.a) r0.next();
            r3.getCause();
            r1.onLoadFail();
            goto L4
        }

        @Override // u75.b.a
        public final <I> void a(InfoCode r1, I r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            int r3 = a.a[r1.ordinal()];
            if (r3 != 1) goto L5;
            Iterator<T> r4 = this.a.iterator();
        L19:
            if (r4.hasNext() == false) goto L27;
            ((i.a) r4.next()).onLoadStart();
            goto L19
        L27:
            return;
        L5:
            if (r3 != 2) goto L7;
            Iterator<T> r5 = this.a.iterator();
        L15:
            if (r5.hasNext() == false) goto L26;
            ((i.a) r5.next()).onLoadSuccess();
            goto L15
        L26:
            return;
        L7:
            if (r3 != 3) goto L21;
            Iterator<T> r6 = this.a.iterator();
        L11:
            if (r6.hasNext() == false) goto L25;
            ((i.a) r6.next()).onLoadSuccess();
            goto L11
        L25:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final b getDocumentLoaderCallback() {
        return (b) this.documentLoaderCallback$delegate.getValue();
    }

    private final c getDriveLoaderCallback() {
        return (c) this.driveLoaderCallback$delegate.getValue();
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.j
    public BasePluginV2 newLoadingCallbackPlugin() {
        return new LoadingCallbackPlugin();
    }

    public LoadingCallbackPlugin() {
        this.loadingCallbacks = new CopyOnWriteArrayList();
        this.documentLoaderCallback$delegate = LazyKt.lazy(new LoadingCallbackPlugin$documentLoaderCallback$2(this));
        this.driveLoaderCallback$delegate = LazyKt.lazy(new LoadingCallbackPlugin$driveLoaderCallback$2(this));
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getLoadingCallbacks$p(LoadingCallbackPlugin r0) {
        return r0.loadingCallbacks;
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.i
    public void addLoadingCallback(i.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (this.loadingCallbacks.contains(r2) == true) goto L6;
        this.loadingCallbacks.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.registerHostAbility(this);
        if ((r2 instanceof DocumentPluginHost) == false) goto L6;
        ((DocumentPluginHost) r2).getDocumentLoader().S3(getDocumentLoaderCallback());
        return;
    L6:
        if ((r2 instanceof DrivePluginHost) == false) goto L9;
        ((DrivePluginHost) r2).c().c(getDriveLoaderCallback());
        return;
    L9:
        if ((r2 instanceof ChameleonPluginHost) == false) goto L13;
        x2 r3 = (x2) r2.getHostAbilityOrNull(x2.class);
        if (r3 == null) goto L17;
        r3.S3(getDocumentLoaderCallback());
        return;
    L17:
        return;
    L13:
        Log.w(TAG, "addLoadingCallback, unrecognized pluginHost.");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if ((r2 instanceof DocumentPluginHost) == false) goto L6;
        ((DocumentPluginHost) r2).getDocumentLoader().S(getDocumentLoaderCallback());
        return;
    L6:
        if ((r2 instanceof DrivePluginHost) == false) goto L10;
        ((DrivePluginHost) r2).c().g(getDriveLoaderCallback());
        return;
    }
}
