package com.bytedance.ee.bear.drive.core;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002,-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0016J(\u0010$\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020&\u0018\u00010%j\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020&\u0018\u0001`'H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/drive/core/DriveHostAbilityPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/document/FileCommonAbility;", "<init>", "()V", "driveBearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getDriveBearUrl", "()Lcom/bytedance/ee/bear/domain/BearUrl;", "driveBearUrl$delegate", "Lkotlin/Lazy;", "driveOriginBearUrl", "getDriveOriginBearUrl", "driveOriginBearUrl$delegate", "loadState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/FileCommonAbility$LoadingState;", "fileDeleteObserver", "Lcom/bytedance/ee/space/push/PushObserver;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "getFragment", "Landroidx/fragment/app/Fragment;", "getTitle", "", "getBearUrl", "getUrl", "getOriginUrl", "getContainerUrl", "getOriginBearUrl", "getLoadState", "Landroidx/lifecycle/LiveData;", "getReportCommonParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "load", "startBrowserView", "initFileDeleteObserver", "destroyFileDeleteObserver", "InnerLoadingCallback", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveHostAbilityPlugin extends AbsDrivePreviewPlugin implements r4 {
    private static final a Companion = null;
    private static final String TAG = "DriveAbilityPlugin";
    private final Lazy driveBearUrl$delegate;
    private final Lazy driveOriginBearUrl$delegate;
    private bu5.a fileDeleteObserver;
    private final MutableLiveData<r4.a> loadState;

    public static final class a {
        public a() {
        }
    }

    public final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveHostAbilityPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.LoadStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[InfoCode.FileNotChange.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L6:
                a = r0;
                int[] r1 = new int[ErrCode.values().length];
                r1[ErrCode.OWNER_DELETED_FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L21:
                r1[ErrCode.FILE_NOT_FOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L9:
                b = r1;
            }
        }

        public b(DriveHostAbilityPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
            DriveHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.c.a);
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r6) {
            Intrinsics.checkNotNullParameter(r6, "code");
            int r0 = a.b[r6.ordinal()];
            if (r0 != 1) goto L5;
            int r1 = -55;
        L9:
            DriveHostAbilityPlugin.access$getLoadState$p(this.a).setValue(new r4.a.C0096a(r1, new Throwable(r6.name(), r6.getCause())));
            return;
        L5:
            if (r0 == 2) goto L7;
            r1 = r6.ordinal() + 1;
            goto L9
        L7:
            r1 = 920004002;
            goto L9
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <I> void a(InfoCode r1, I r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            int r3 = a.a[r1.ordinal()];
            if (r3 != 1) goto L5;
            DriveHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.b.a);
            return;
        L5:
            if (r3 != 2) goto L11;
            DriveHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.c.a);
            return;
        }
    }

    public static final class c implements bu5.a {
        public final /* synthetic */ DriveHostAbilityPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ DriveHostAbilityPlugin a;

            public a(DriveHostAbilityPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (DriveHostAbilityPlugin.access$isUIContainerAttached(this.a) == false) goto L9;
                DriveHostAbilityPlugin.access$getLoadState$p(this.a).setValue(new r4.a.C0096a(-55, new Throwable("OWNER_DELETED_FILE")));     // Catch: Throwable -> L6
                return;
            }
        }

        public c(DriveHostAbilityPlugin r1) {
            this.a = r1;
        }

        public final void didReceivePush(String r2) {
            m.a(new a(this.a));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void reload() {
    }

    private final void destroyFileDeleteObserver() {
        bu5.a r0 = this.fileDeleteObserver;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).De(r0);
    L5:
        this.fileDeleteObserver = null;
    }

    private final BearUrl getDriveBearUrl() {
        return (BearUrl) this.driveBearUrl$delegate.getValue();
    }

    private final BearUrl getDriveOriginBearUrl() {
        return (BearUrl) this.driveOriginBearUrl$delegate.getValue();
    }

    private final void initFileDeleteObserver() {
        c r0 = new c(this);
        this.fileDeleteObserver = r0;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).r6(k75.a.d(this), e.l.b, r0);
    }

    public DriveHostAbilityPlugin() {
        this.driveBearUrl$delegate = LazyKt.lazy(new DriveHostAbilityPlugin$driveBearUrl$2(this));
        this.driveOriginBearUrl$delegate = LazyKt.lazy(new DriveHostAbilityPlugin$driveOriginBearUrl$2(this));
        this.loadState = new MutableLiveData();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public BearUrl getBearUrl() {
        return getDriveBearUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public String getContainerUrl() {
        return getOriginUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public Fragment getFragment() {
        return getHost().a;
    }

    @Override // com.bytedance.ee.bear.document.r4
    public BearUrl getOriginBearUrl() {
        return getDriveOriginBearUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public String getOriginUrl() {
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        String r2 = null;
        if ((r0 instanceof SpaceFileOpenEntity) == false) goto L5;
        SpaceFileOpenEntity r1 = (SpaceFileOpenEntity) r0;
    L6:
        if (r1 == null) goto L9;
        String r3 = r1.getOriginUrl();
        if (r3 == null) goto L9;
        return r3;
    L9:
        if (r1 == null) goto L11;
        r2 = r1.getUrl();
    L11:
        if (r2 != null) goto L14;
        return "";
    L14:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.r4
    public HashMap<String, Object> getReportCommonParams() {
        com.bytedance.ee.bear.drive.report.c r0 = o75.b.a().Ke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(getHost().c.getOpenEntity());
    }

    public String getTitle() {
        String r0 = getHost().c.getFileName();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String getUrl() {
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        if ((r0 instanceof SpaceFileOpenEntity) == false) goto L5;
        SpaceFileOpenEntity r1 = (SpaceFileOpenEntity) r0;
    L6:
        if (r1 == null) goto L9;
        String r2 = r1.getUrl();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    L5:
        r1 = null;
        goto L6
    }

    public void load() {
        getHost().c().load();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        initFileDeleteObserver();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        destroyFileDeleteObserver();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public void startBrowserView() {
        if (isUIContainerDetached() == false) goto L6;
        tt5.a.k(TAG, "startShare when not active !");
        return;
    L6:
        String r0 = getContainerUrl();
        if (TextUtils.isEmpty(r0) == false) goto L15;
        tt5.a.k(TAG, "origin url is empty !");
        return;
    L15:
        getActivity().startActivity(new Intent("android.intent.action.VIEW", UriProtector.parse(r0)));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.d(TAG, "start intent activity fail: " + e);
    }

    @Override // com.bytedance.ee.bear.document.r4
    public LiveData<r4.a> getLoadState() {
        return this.loadState;
    }

    public static final /* synthetic */ MutableLiveData access$getLoadState$p(DriveHostAbilityPlugin r0) {
        return r0.loadState;
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(DriveHostAbilityPlugin r0) {
        return r0.isUIContainerAttached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.registerHostAbility(this);
        r2.c().c(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
