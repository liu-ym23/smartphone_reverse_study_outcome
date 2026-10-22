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
import com.lynx.tasm.LynxError;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThirdPartyPermissionVM f223141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f223142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f223143c;

        public b(DriveThirdPartyPermissionVM r100, String r101, int r102) {
            this.f223141a = r100;
            this.f223142b = r101;
            this.f223143c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DriveThirdPartyPermissionVM.access$getLiveParentCopyable$p(this.f223141a).postValue(Boolean.valueOf(DriveThirdPartyPermissionVM.access$canParentCopy(this.f223141a, this.f223142b, this.f223143c, ((DocPermission) r100).f234419a)));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThirdPartyPermissionVM f223144a;

        public c(DriveThirdPartyPermissionVM r100) {
            this.f223144a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DriveThirdPartyPermissionVM.access$getLiveParentCopyable$p(this.f223144a).postValue(Boolean.TRUE);
            tt5.a.e(DriveThirdPartyPermissionVM.TAG, "fetch parent perm error", (Throwable) r100, false);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThirdPartyPermissionVM f223145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f223146b;

        public d(DriveThirdPartyPermissionVM r100, String r101) {
            this.f223145a = r100;
            this.f223146b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData r101 = DriveThirdPartyPermissionVM.access$getLivePerm$p(this.f223145a);
            r101.postValue((ThirdPartyAttachmentPermission) r100);
            InsertNewBlock r102 = b25.a.f16997a;
            if (r102 == null) goto L6;
            String r103 = this.f223146b;
            ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).a(r103, mu5.a.b(r102));
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThirdPartyPermissionVM f223147a;

        public e(DriveThirdPartyPermissionVM r100) {
            this.f223147a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DriveThirdPartyPermissionVM.access$getLivePerm$p(this.f223147a).postValue(null);
            tt5.a.e(DriveThirdPartyPermissionVM.TAG, "fetch perm error", (Throwable) r100, false);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThirdPartyPermissionVM f223148a;

        public f(DriveThirdPartyPermissionVM r100) {
            this.f223148a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData r101 = DriveThirdPartyPermissionVM.access$getOfflinePerm$p(this.f223148a);
            int r102 = mu5.a.f515754a;
            r101.postValue(mu5.a.a((String) r100, ThirdPartyAttachmentPermission.class));
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f223149a = null;

        static {
            f223149a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.d(DriveThirdPartyPermissionVM.TAG, "postOfflinePerm error " + r101.getMessage());
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isOfflineScreenEnable() {
        if (j.a.f217090a.getNetworkState().a() == true) goto L7;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.f() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean isFilePermission() {
        ThirdPartyAttachmentPermission r100 = this.livePerm.getValue();
        if (r100 == null) goto L9;
        ThirdPartyAttachmentPermission.PermissionV2 r101 = r100.getPermV2();
        if (r101 == null) goto L9;
        if (r101.getView() != 2002) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return true;
    L12:
        return false;
    L9:
        r102 = false;
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
        return liveOfflinePerm().getValue();
    L7:
        return livePerm().getValue();
    }

    @Override // androidx.lifecycle.ViewModel
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

    public static final /* synthetic */ MutableLiveData access$getLiveParentCopyable$p(DriveThirdPartyPermissionVM r100) {
        return r100.liveParentCopyable;
    }

    public static final /* synthetic */ MutableLiveData access$getLivePerm$p(DriveThirdPartyPermissionVM r100) {
        return r100.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getOfflinePerm$p(DriveThirdPartyPermissionVM r100) {
        return r100.offlinePerm;
    }

    public final void postOfflinePerm(String r100) {
        if (isOfflineScreenEnable() == false) goto L9;
        ph5.b r101 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        r101.c(r100).observeOn(fo5.d.d()).subscribe(new f(this), g.f223149a);
        return;
    }

    public final void fetchParentCopyPermission(String r100, int r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L14;
        if (r101 <= 0) goto L14;
        this.compositeDisposable.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r100, r101).subscribe(new b(this, r100, r101), new c(this)));
        return;
    L14:
        this.liveParentCopyable.postValue(null);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L9
    }

    private final boolean canParentCopy(String r100, int r101, Object r102) {
        IDocUserPermission r103 = null;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L5;
        BaseEntity r104 = new BaseEntity(r100, sbb.e.d(r101), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r104, "CONTENT_COPY"), new UserPermissionEntity(r102, null)).getAllow();
    L5:
        if ((r102 instanceof IDocUserPermission) == false) goto L7;
        r103 = (IDocUserPermission) r102;
    L7:
        if (r103 != null) goto L9;
    L11:
        return false;
    L9:
        if (r103.canCopy() != true) goto L11;
        return true;
    }

    public final void fetchPermission(String r100, String r101, String r102) {
        this.compositeDisposable.add(this.permExecutor.a(r100, r101, r102).subscribe(new d(this, r100), new e(this)));
    }

    public static final /* synthetic */ boolean access$canParentCopy(DriveThirdPartyPermissionVM r100, String r101, int r102, Object r103) {
        return r100.canParentCopy(r101, r102, r103);
    }
}
