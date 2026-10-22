package com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.impl.SpaceFileLoader;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0015J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/ownerdeletefile/DriveSpaceOwnerDeleteFilePlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/error/ownerdeletefile/DriveOwnerDeletedFilePlugin;", "<init>", "()V", "mFileDeleteObserver", "Lcom/bytedance/ee/space/push/PushObserver;", "mHasObserveFileDeleted", "", "handleOwnerDeleteFile", "", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceOwnerDeleteFilePlugin extends DriveOwnerDeletedFilePlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveSpaceOwnerDeleteFilePlugin";
    private bu5.a mFileDeleteObserver;
    private boolean mHasObserveFileDeleted;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            return (com.bytedance.ee.bear.contract.g) org.koin.java.a.c(com.bytedance.ee.bear.contract.g.class, null, null, 6);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ DriveSpaceOwnerDeleteFilePlugin a;

        public c(DriveSpaceOwnerDeleteFilePlugin r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            com.bytedance.ee.bear.contract.g r3 = (com.bytedance.ee.bear.contract.g) r2;
            Intrinsics.checkNotNullParameter(r3, "badgeService");
            r3.remove(this.a.getHost().c.getOpenEntity().getFileId());
            return Boolean.TRUE;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            tt5.a.f(DriveSpaceOwnerDeleteFilePlugin.TAG, (Throwable) r3, false);
        }
    }

    public static final class f implements bu5.a {
        public final /* synthetic */ DriveSpaceOwnerDeleteFilePlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ DriveSpaceOwnerDeleteFilePlugin a;

            public a(DriveSpaceOwnerDeleteFilePlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L13:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L20;
                throw th;
            L20:
                return;
            L3:
                if (DriveSpaceOwnerDeleteFilePlugin.access$isUIContainerDetached(this.a) == true) goto L16;
                u75.b r0 = this.a.getHost().c();     // Catch: Throwable -> L13
                if ((r0 instanceof SpaceFileLoader) == false) goto L8;
                SpaceFileLoader r1 = (SpaceFileLoader) r0;     // Catch: Throwable -> L13
            L9:
                if (r1 == null) goto L11;
                r1.h(ErrCode.OWNER_DELETED_FILE);     // Catch: Throwable -> L13
            L11:
                this.a.handleOwnerDeleteFile();     // Catch: Throwable -> L13
                return;
            L8:
                r1 = null;
                goto L9
            }
        }

        public f(DriveSpaceOwnerDeleteFilePlugin r1) {
            this.a = r1;
        }

        public final void didReceivePush(String r2) {
            tt5.a.h("DriveComponent", "receive file delete push");
            m.a(new a(this.a));
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ DriveSpaceOwnerDeleteFilePlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public static final class a<T> implements Observer {
            public final /* synthetic */ DriveSpaceOwnerDeleteFilePlugin a;
            public final /* synthetic */ DrivePluginHost b;

            public a(DriveSpaceOwnerDeleteFilePlugin r1, DrivePluginHost r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onChanged(Object r2) {
                cu5.b.a r3 = (cu5.b) r2;
                if ((r3 instanceof cu5.b.a) == true) goto L5;
                return;
            L5:
                if (tp5.b.b(r3.a, 920004123) == true) goto L7;
                return;
            L7:
                if (DriveSpaceOwnerDeleteFilePlugin.access$isUIContainerAttached(this.a) == false) goto L18;
                u75.b r4 = this.b.c();
                if ((r4 instanceof SpaceFileLoader) == false) goto L11;
                SpaceFileLoader r5 = (SpaceFileLoader) r4;
            L12:
                if (r5 == null) goto L14;
                r5.h(ErrCode.OWNER_DELETED_FILE);
            L14:
                this.a.handleOwnerDeleteFile();
                return;
            L11:
                r5 = null;
                goto L12
            }
        }

        public g(DriveSpaceOwnerDeleteFilePlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (DriveSpaceOwnerDeleteFilePlugin.access$getMHasObserveFileDeleted$p(this.a) == true) goto L6;
            ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).o(this.b).observe(this.b.getLifecycleOwner(), new a(this.a, this.b));
            DriveSpaceOwnerDeleteFilePlugin.access$setMHasObserveFileDeleted$p(this.a, true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile.DriveOwnerDeletedFilePlugin, com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile.DriveOwnerDeletedFilePlugin
    public void handleOwnerDeleteFile() {
        super.handleOwnerDeleteFile();
        tt5.a.h(TAG, "handleOwnerDeleteFile.");
        Flowable.just("").subscribeOn(fo5.d.b()).map(b.a).map(new c(this)).subscribe(d.a, e.a);
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).W(getHost().c.getOpenEntity().getFileId());
        k75.a.i(getHost()).liveInnerCommentSelected().postValue(null);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        f r0 = new f(this);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).r6(k75.a.d(this), sbb.e.l.b, r0);
        this.mFileDeleteObserver = r0;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        bu5.a r0 = this.mFileDeleteObserver;
        if (r0 == null) goto L6;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).De(r0);
        return;
    }

    public DriveSpaceOwnerDeleteFilePlugin() {
    }

    public static final /* synthetic */ boolean access$getMHasObserveFileDeleted$p(DriveSpaceOwnerDeleteFilePlugin r0) {
        return r0.mHasObserveFileDeleted;
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(DriveSpaceOwnerDeleteFilePlugin r0) {
        return r0.isUIContainerAttached();
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveSpaceOwnerDeleteFilePlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile.DriveOwnerDeletedFilePlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        if (r4.c.isTypeWiki() == false) goto L6;
        addInfoHandler(new g(this, r4), new InfoCode[]{InfoCode.PreFetchFileInfo});
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile.DriveOwnerDeletedFilePlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setMHasObserveFileDeleted$p(DriveSpaceOwnerDeleteFilePlugin r0, boolean r1) {
        r0.mHasObserveFileDeleted = r1;
    }
}
