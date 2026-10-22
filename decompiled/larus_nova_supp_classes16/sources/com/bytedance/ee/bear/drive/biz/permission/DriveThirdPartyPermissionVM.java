package com.bytedance.ee.bear.drive.biz.permission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016J\u0010\u0010 \u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0011J\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0011J\b\u0010\"\u001a\u0004\u0018\u00010\nJ\b\u0010#\u001a\u00020\u0013H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DriveThirdPartyPermissionVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "permExecutor", "Lcom/bytedance/ee/bear/drive/biz/permission/ThirdPartyAttachmentPermissionExecutor;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "livePerm", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/ThirdPartyAttachmentPermission;", "offlinePerm", "liveCopyEscape", "", "liveParentCopyable", "isFilePermission", "isOfflineScreenEnable", "Landroidx/lifecycle/LiveData;", "resetParentCopyPermission", "", "fetchParentCopyPermission", "parentToken", "", "parentType", "", "canParentCopy", "userPermission", "", "fetchPermission", "objToken", "extra", "mountPoint", "postOfflinePerm", "liveOfflinePerm", "getPermValueSupportOffline", "onCleared", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveThirdPartyPermissionVM extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "DriveThirdPartyPermissionVM";
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Boolean> liveCopyEscape;
    private final MutableLiveData<Boolean> liveParentCopyable;
    private final MutableLiveData<ThirdPartyAttachmentPermission> livePerm;
    private final MutableLiveData<ThirdPartyAttachmentPermission> offlinePerm;
    private final com.bytedance.ee.bear.drive.biz.permission.f permExecutor;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DriveThirdPartyPermissionVM a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public b(DriveThirdPartyPermissionVM r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            DriveThirdPartyPermissionVM.access$getLiveParentCopyable$p(this.a).postValue(Boolean.valueOf(DriveThirdPartyPermissionVM.access$canParentCopy(this.a, this.b, this.c, ((DocPermission) r5).a)));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DriveThirdPartyPermissionVM a;

        public c(DriveThirdPartyPermissionVM r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            DriveThirdPartyPermissionVM.access$getLiveParentCopyable$p(this.a).postValue(Boolean.TRUE);
            tt5.a.e(DriveThirdPartyPermissionVM.TAG, "fetch parent perm error", (Throwable) r4, false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DriveThirdPartyPermissionVM a;
        public final /* synthetic */ String b;

        public d(DriveThirdPartyPermissionVM r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            MutableLiveData r0 = DriveThirdPartyPermissionVM.access$getLivePerm$p(this.a);
            r0.postValue((ThirdPartyAttachmentPermission) r5);
            InsertNewBlock r6 = b25.a.a;
            if (r6 == null) goto L6;
            String r1 = this.b;
            ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).a(r1, mu5.a.b(r6));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DriveThirdPartyPermissionVM a;

        public e(DriveThirdPartyPermissionVM r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            DriveThirdPartyPermissionVM.access$getLivePerm$p(this.a).postValue(null);
            tt5.a.e(DriveThirdPartyPermissionVM.TAG, "fetch perm error", (Throwable) r4, false);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DriveThirdPartyPermissionVM a;

        public f(DriveThirdPartyPermissionVM r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            MutableLiveData r0 = DriveThirdPartyPermissionVM.access$getOfflinePerm$p(this.a);
            int r1 = mu5.a.a;
            r0.postValue(mu5.a.a((String) r3, ThirdPartyAttachmentPermission.class));
        }
    }

    public static final class g<T> implements Consumer {
        public static final g<T> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d(DriveThirdPartyPermissionVM.TAG, "postOfflinePerm error " + r4.getMessage());
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isOfflineScreenEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L7;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.f() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean isFilePermission() {
        ThirdPartyAttachmentPermission r0 = (ThirdPartyAttachmentPermission) this.livePerm.getValue();
        if (r0 == null) goto L9;
        ThirdPartyAttachmentPermission.PermissionV2 r1 = r0.getPermV2();
        if (r1 == null) goto L9;
        if (r1.getView() != 2002) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return true;
    L12:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final void resetParentCopyPermission() {
        this.liveParentCopyable.postValue(null);
    }

    public DriveThirdPartyPermissionVM() {
        this.permExecutor = new com.bytedance.ee.bear.drive.biz.permission.f((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        this.compositeDisposable = new CompositeDisposable();
        this.livePerm = new MutableLiveData();
        this.offlinePerm = new MutableLiveData();
        this.liveCopyEscape = new MutableLiveData();
        this.liveParentCopyable = new MutableLiveData();
    }

    public final ThirdPartyAttachmentPermission getPermValueSupportOffline() {
        if (isOfflineScreenEnable() == false) goto L7;
        return (ThirdPartyAttachmentPermission) liveOfflinePerm().getValue();
    L7:
        return (ThirdPartyAttachmentPermission) livePerm().getValue();
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final MutableLiveData<Boolean> liveCopyEscape() {
        return this.liveCopyEscape;
    }

    public final LiveData<ThirdPartyAttachmentPermission> liveOfflinePerm() {
        return this.offlinePerm;
    }

    public final LiveData<Boolean> liveParentCopyable() {
        return this.liveParentCopyable;
    }

    public final LiveData<ThirdPartyAttachmentPermission> livePerm() {
        return this.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getLiveParentCopyable$p(DriveThirdPartyPermissionVM r0) {
        return r0.liveParentCopyable;
    }

    public static final /* synthetic */ MutableLiveData access$getLivePerm$p(DriveThirdPartyPermissionVM r0) {
        return r0.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getOfflinePerm$p(DriveThirdPartyPermissionVM r0) {
        return r0.offlinePerm;
    }

    public final void postOfflinePerm(String r4) {
        if (isOfflineScreenEnable() == false) goto L9;
        ph5.b r0 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.c(r4).observeOn(fo5.d.d()).subscribe(new f(this), g.a);
        return;
    }

    public final void fetchParentCopyPermission(String r5, int r6) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L14;
        if (r6 <= 0) goto L14;
        this.compositeDisposable.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r5, r6).subscribe(new b(this, r5, r6), new c(this)));
        return;
    L14:
        this.liveParentCopyable.postValue(null);
        return;
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    private final boolean canParentCopy(String r6, int r7, Object r8) {
        IDocUserPermission r1 = null;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L5;
        BaseEntity r0 = new BaseEntity(r6, sbb.e.d(r7), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, "CONTENT_COPY"), new UserPermissionEntity(r8, null)).getAllow();
    L5:
        if ((r8 instanceof IDocUserPermission) == false) goto L7;
        r1 = (IDocUserPermission) r8;
    L7:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.canCopy() != true) goto L11;
        return true;
    }

    public final void fetchPermission(String r3, String r4, String r5) {
        this.compositeDisposable.add(this.permExecutor.a(r3, r4, r5).subscribe(new d(this, r3), new e(this)));
    }

    public static final /* synthetic */ boolean access$canParentCopy(DriveThirdPartyPermissionVM r0, String r1, int r2, Object r3) {
        return r0.canParentCopy(r1, r2, r3);
    }
}
