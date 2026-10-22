package com.bytedance.ee.bear.drive.biz.preview.secret;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveBannerPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.PermShareUserInfo;
import com.bytedance.ee.bear.middleground.permission.secret.n;
import com.bytedance.ee.bear.middleground.permission.secret.o;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import jg5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0003J(\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u000bH\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u000204H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/secret/DriveSecretLevelPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/secret/SecretLevelChangeListener;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/IMemberFetchListener;", "<init>", "()V", "secretUpdatePush", "Lcom/bytedance/ee/space/push/PushObserver;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "secLabelStatus", "", "enableAutoBanner", "", "reportBanner", "metaInfoObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "shareNumber", "isFetching", "shareInfoObserver", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/PermShareUserInfo;", "showSecretBar", "", "it", "showSecretBanner", "handleRecommend", "secretBean", "Lcom/bytedance/ee/bear/middleground/permission/secret/RecommendSecretBean;", "driveMetaInfo", "canShow", "isForceSecret", "handleAutoBanner", "metaInfo", "hasCollaborate", "cacheHasColloaborate", "checkSecretSetShow", "permissionObserver", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DrivePermissionInfo;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "onAttachPreview", "notifyMemberNumber", "number", "onDetachPreview", "updateSecretLevelToList", "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", "onSecretLevelChange", "name", "", "level", "getRetryToken", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSecretLevelPlugin extends AbsDrivePreviewPlugin implements fj5.b, com.bytedance.ee.bear.middleground_permission_export.model.g {
    public static final a Companion = null;
    private static final String TAG = "DriveSecretPlugin";
    private final CompositeDisposable compositeDisposable;
    private boolean enableAutoBanner;
    private boolean isFetching;
    private final Observer<u55.a> metaInfoObserver;
    private final Observer<u55.b> permissionObserver;
    private boolean reportBanner;
    private final int secLabelStatus;
    private bu5.a secretUpdatePush;
    private final Observer<PermShareUserInfo> shareInfoObserver;
    private int shareNumber;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            tt5.a.h(DriveSecretLevelPlugin.TAG, "closeBanner success");
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            tt5.a.h(DriveSecretLevelPlugin.TAG, "closeBanner error");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ DriveSecretLevelPlugin b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ u55.a e;

        public d(n r1, DriveSecretLevelPlugin r2, boolean r3, boolean r4, u55.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r6) {
            ArrayList r7 = (ArrayList) ((VisibleSecretResult) r6).data;
            Intrinsics.checkNotNull(r7);
            u55.a r0 = this.e;
            n r1 = this.a;
            Iterator<T> r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L8;
            SecretLevel r2 = (SecretLevel) r8.next();
            if (TextUtils.equals(r2.getId(), r0.b.getRecommendLabelId()) == false) goto L4;
            String r3 = r2.getName();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r1.g = r3;
            goto L4
        L8:
            o r9 = ((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.secret.d.class, null, null, 6)).a(this.a, DriveSecretLevelPlugin.access$getContext(this.b));
            boolean r4 = false;
            if (r9.d == true) goto L11;
        L13:
            r9.f = this.c;
            if (r9.d == true) goto L16;
        L18:
            r9.d = r4;
            DriveBannerPlugin r5 = (DriveBannerPlugin) DriveSecretLevelPlugin.access$findPlugin(this.b, DriveBannerPlugin.class);
            if (r5 == null) goto L27;
            r5.showNoticeBanner(this.e, r9);
            return;
        L27:
            return;
        L16:
            if (this.d == false) goto L18;
            r4 = true;
            goto L18
        L11:
            if (DriveSecretLevelPlugin.access$getReportBanner$p(this.b) == false) goto L13;
            DriveSecretLevelPlugin.access$setReportBanner$p(this.b, false);
            com.bytedance.ee.bear.middleground.permission.c.H(this.c);
            goto L13
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            tt5.a.h(DriveSecretLevelPlugin.TAG, "fetchVisibleSecret error");
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveSecretLevelPlugin a;

        public f(DriveSecretLevelPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            u55.a r4 = (u55.a) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            DriveSecretLevelPlugin.access$updateSecretLevelToList(this.a, r4.b);
            if (DriveSecretLevelPlugin.access$getEnableAutoBanner$p(this.a) == false) goto L5;
            DriveSecretLevelPlugin.access$showSecretBanner(this.a, r4);
        L6:
            DriveBannerPlugin r0 = (DriveBannerPlugin) DriveSecretLevelPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r0 == null) goto L10;
            r0.notifyMetaChange(r4.b);
            return;
        L10:
            return;
        L5:
            DriveSecretLevelPlugin.access$showSecretBar(this.a, r4);
            goto L6
        }
    }

    public static final class g implements bu5.a {
        public final /* synthetic */ DriveSecretLevelPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ DriveSecretLevelPlugin a;

            public a(DriveSecretLevelPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            L14:
                return;
            L3:
                if (DriveSecretLevelPlugin.access$isUIContainerDetached(this.a) == true) goto L10;
                ((DriveMetaInfoVM) DriveSecretLevelPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).fetchMetaInfo(k75.a.d(this.a));     // Catch: Throwable -> L7
                return;
            }
        }

        public g(DriveSecretLevelPlugin r1) {
            this.a = r1;
        }

        public final void didReceivePush(String r2) {
            tt5.a.h(DriveSecretLevelPlugin.TAG, "receive secret update push");
            m.a(new a(this.a));
        }
    }

    public static final class h<T> implements Observer {
        public static final h<T> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            u55.b r2 = (u55.b) r1;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DriveSecretLevelPlugin a;

        public i(DriveSecretLevelPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Intrinsics.checkNotNullParameter((PermShareUserInfo) r3, "it");
            MutableLiveData<u55.a> r4 = ((DriveMetaInfoVM) DriveSecretLevelPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).getLiveMetaInfo();
            if (r4.getValue() == null) goto L9;
            DriveSecretLevelPlugin.access$setFetching$p(this.a, false);
            if (DriveSecretLevelPlugin.access$getEnableAutoBanner$p(this.a) == false) goto L7;
            DriveSecretLevelPlugin.access$showSecretBanner(this.a, (u55.a) r4.getValue());
            return;
        L7:
            DriveSecretLevelPlugin.access$showSecretBar(this.a, (u55.a) r4.getValue());
            return;
        }
    }

    static {
        Companion = new a();
    }

    public String getRetryToken() {
        return "";
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean checkSecretSetShow() {
        u55.a r0 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        u55.b r1 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        DocVersion r2 = (DocVersion) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveDocVersion().getValue();
        boolean r4 = true;
        if (r0 == null) goto L20;
        if (r1 == null) goto L20;
        if (r2 == null) goto L20;
        DocMetaInfo r3 = r0.b;
        boolean r5 = r1.b.a.canModifySecretLevel();
        boolean r6 = getHost().c.isTypeWiki();
        boolean r7 = r2.isDocV2();
        if (r6 == true) goto L12;
        if (r7 == true) goto L12;
        boolean r8 = false;
    L13:
        boolean r9 = r3.isVisibleSecList();
        tt5.a.b(TAG, "checkSecretSetShow " + r5 + ", " + r8 + ", " + r9);
        if (r5 == false) goto L18;
        if (r8 == false) goto L18;
        if (r9 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r8 = true;
    L20:
        StringBuilder r10 = new StringBuilder("meta is null?");
        if (r0 != null) goto L23;
        boolean r11 = true;
    L24:
        r10.append(r11);
        r10.append(", permission is null?");
        if (r1 != null) goto L27;
        boolean r12 = true;
    L28:
        r10.append(r12);
        r10.append(", version is null?");
        if (r2 == null) goto L32;
        r4 = false;
    L32:
        r10.append(r4);
        tt5.a.h(TAG, r10.toString());
        return false;
    L27:
        r12 = false;
        goto L28
    L23:
        r11 = false;
        goto L24
    }

    public DriveSecretLevelPlugin() {
        this.compositeDisposable = new CompositeDisposable();
        this.secLabelStatus = 1;
        this.reportBanner = true;
        this.metaInfoObserver = new f(this);
        this.shareNumber = -1;
        this.shareInfoObserver = new i(this);
        this.permissionObserver = h.a;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        g r0 = new g(this);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(k75.a.d(this), sbb.e.l.b, r0);
        this.secretUpdatePush = r0;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().o(k75.a.d(this), this);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().n(k75.a.d(this), this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        bu5.a r0 = this.secretUpdatePush;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r0);
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().q(k75.a.d(this), this);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ConcurrentHashMap) j.c.a).remove(this);
    }

    public static final /* synthetic */ Context access$getContext(DriveSecretLevelPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ boolean access$getEnableAutoBanner$p(DriveSecretLevelPlugin r0) {
        return r0.enableAutoBanner;
    }

    public static final /* synthetic */ boolean access$getReportBanner$p(DriveSecretLevelPlugin r0) {
        return r0.reportBanner;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveSecretLevelPlugin r0) {
        return r0.isUIContainerDetached();
    }

    private final void handleAutoBanner(u55.a r9) {
        this.compositeDisposable.add(((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.secret.d.class, null, null, 6)).d(r9.b.getObjId(), 12, r9.b.getSecretLevel().getId(), r9.b.getSecLabelBannerType(), this.secLabelStatus).subscribe(b.a, c.a));
    }

    private final boolean hasCollaborate(boolean r3) {
        int r0 = this.shareNumber;
        if (r0 <= 1) goto L5;
        return true;
    L5:
        if (r0 != 1) goto L8;
        return false;
    L8:
        return r3;
    }

    private final void showSecretBanner(u55.a r22) {
        if (r22 != null) goto L5;
        return;
    L5:
        boolean r2 = checkSecretSetShow();
        u55.a r3 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        u55.b r4 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r3 == null) goto L51;
        DocMetaInfo r6 = r3.b;
        if (r6 == null) goto L51;
        boolean r7 = r6.isSecretAdminDefault();
        String r14 = r3.b.getSecretLevel().getName();
        DocMetaInfo r8 = r3.b;
        if (r4 == null) goto L15;
        DocPermission r5 = r4.b;
        if (r5 == null) goto L15;
        IDocUserPermission r9 = r5.a;
    L16:
        boolean r10 = fj5.a.d(r8, r9);
        boolean r11 = !TextUtils.equals("", r3.b.getSecretLevel().getId());
        boolean r12 = r3.b.isAutoMark();
        boolean r17 = r3.b.isRecommendMark();
        boolean r13 = r3.b.getDoubleCheckDefaultLabel();
        if (r3.b.getSecLabelStatus() == 1) goto L19;
        boolean r16 = true;
    L20:
        if (r12 == false) goto L24;
        if (r16 == true) goto L24;
        tt5.a.h(TAG, "is autoBanner");
        return;
    L24:
        n r18 = new n(r7, r12, r17, r11, r13, r10, r14, r16, 256);
        if (r17 == false) goto L28;
        handleRecommend(r18, r22, r2, r10);
        return;
    L28:
        PermShareUserInfo r1 = (PermShareUserInfo) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveShareUserResult().getValue();
        if (r1 != null) goto L32;
        r1 = new PermShareUserInfo(false, new ShareUserInfoResult());
    L32:
        if (r1.isHasPullSuc() == false) goto L47;
        r18.i = hasCollaborate(r1.hasCollborate());
        o r19 = ((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.secret.d.class, null, null, 6)).a(r18, getContext());
        if (r19.e == false) goto L36;
        handleAutoBanner(r3);
    L36:
        r19.f = r10;
        if (r19.d == false) goto L40;
        if (r2 == false) goto L40;
        boolean r110 = true;
    L41:
        r19.d = r110;
        DriveBannerPlugin r20 = (DriveBannerPlugin) findPlugin(DriveBannerPlugin.class);
        if (r20 == null) goto L44;
        r20.showNoticeBanner(r3, r19);
    L44:
        tt5.a.h(TAG, "showbar " + r2 + ", " + r7);
        return;
    L40:
        r110 = false;
        goto L41
    L47:
        if (this.isFetching == true) goto L49;
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).fetchCollaborates(sbb.e.l.b, r3.a);
    L49:
        this.isFetching = true;
        return;
    L19:
        r16 = false;
    L15:
        r9 = null;
    L51:
        tt5.a.h(TAG, "empty meta info");
    }

    private final void showSecretBar(u55.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        boolean r0 = checkSecretSetShow();
        u55.a r3 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        u55.b r1 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r3 == null) goto L33;
        DocMetaInfo r4 = r3.b;
        if (r4 == null) goto L33;
        boolean r6 = r4.isSecretAdminDefault();
        String r7 = r3.b.getSecretLevel().getName();
        DocMetaInfo r5 = r3.b;
        if (r1 == null) goto L14;
        DocPermission r2 = r1.b;
        if (r2 == null) goto L14;
        IDocUserPermission r8 = r2.a;
    L15:
        boolean r9 = fj5.a.d(r5, r8);
        tt5.a.h(TAG, "showbar " + r0 + ", " + r6);
        PermShareUserInfo r11 = (PermShareUserInfo) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveShareUserResult().getValue();
        if (r11 != null) goto L19;
        r11 = new PermShareUserInfo(false, new ShareUserInfoResult());
    L19:
        if (r11.isHasPullSuc() == false) goto L29;
        boolean r12 = r10.b.isSecretBannerShow(r9, true, hasCollaborate(r11.hasCollborate()));
        DriveBannerPlugin r13 = (DriveBannerPlugin) findPlugin(DriveBannerPlugin.class);
        if (r13 == null) goto L35;
        if (r0 == false) goto L25;
        if (r12 == false) goto L25;
        boolean r14 = true;
    L26:
        r13.showNoNoticeBanner(r3, r9, r14, r6, r7);
        return;
    L25:
        r14 = false;
        goto L26
    L35:
        return;
    L29:
        if (this.isFetching == true) goto L31;
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).fetchCollaborates(sbb.e.l.b, r3.a);
    L31:
        this.isFetching = true;
        return;
    L14:
        r8 = null;
    L33:
        tt5.a.h(TAG, "empty meta info");
    }

    private final void updateSecretLevelToList(DocMetaInfo r4) {
        if (r4.isGetSecSuccess() == false) goto L6;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(k75.a.d(this), r4.getSecretLevel().getName(), r4.getSecretLevel().getLevel());
        return;
    }

    public void notifyMemberNumber(int r3) {
        if (this.shareNumber != r3) goto L6;
        tt5.a.b(TAG, "notifyMemberNumber same share member " + r3);
        return;
    L6:
        this.shareNumber = r3;
        u55.a r4 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        if (r4 != null) goto L10;
        return;
    L10:
        if (this.shareNumber >= 1) goto L12;
        return;
    L12:
        if (this.enableAutoBanner == false) goto L14;
        showSecretBanner(r4);
        return;
    L14:
        showSecretBar(r4);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        this.isFetching = false;
        this.enableAutoBanner = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.permission.secret_auto");
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().observe(getLifecycleOwner(), this.metaInfoObserver);
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), this.permissionObserver);
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveShareUserResult().observe(getLifecycleOwner(), this.shareInfoObserver);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().removeObserver(this.metaInfoObserver);
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().removeObserver(this.permissionObserver);
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveShareUserResult().removeObserver(this.shareInfoObserver);
        this.compositeDisposable.clear();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(DriveSecretLevelPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setFetching$p(DriveSecretLevelPlugin r0, boolean r1) {
        r0.isFetching = r1;
    }

    public static final /* synthetic */ void access$setReportBanner$p(DriveSecretLevelPlugin r0, boolean r1) {
        r0.reportBanner = r1;
    }

    public static final /* synthetic */ void access$showSecretBanner(DriveSecretLevelPlugin r0, u55.a r1) {
        r0.showSecretBanner(r1);
    }

    public static final /* synthetic */ void access$showSecretBar(DriveSecretLevelPlugin r0, u55.a r1) {
        r0.showSecretBar(r1);
    }

    public static final /* synthetic */ void access$updateSecretLevelToList(DriveSecretLevelPlugin r0, DocMetaInfo r1) {
        r0.updateSecretLevelToList(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSecretLevelPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    public void onSecretLevelChange(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).fetchMetaInfo(k75.a.d(this));
    }

    private final void handleRecommend(n r10, u55.a r11, boolean r12, boolean r13) {
        this.compositeDisposable.add(((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.secret.d.class, null, null, 6)).c(r11.a, 12).subscribe(new d(r10, this, r13, r12, r11), e.a));
    }
}
