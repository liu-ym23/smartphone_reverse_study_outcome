package com.bytedance.ee.bear.drive.biz.extra_info.meta;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b55.g;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.PermShareUserInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.lynx.tasm.LynxError;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jg5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bJ\b\u0010!\u001a\u00020\u0017H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/extra_info/meta/DriveMetaInfoVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "liveMetaInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "getLiveMetaInfo", "()Landroidx/lifecycle/MutableLiveData;", "docInfoDataFetchExecutor", "Lcom/bytedance/ee/bear/drive/biz/docinfo/DocInfoDataFetchExecutor;", "liveDocVersion", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "getLiveDocVersion", "liveMetaInfoError", "", "getLiveMetaInfoError", "liveShareUserResult", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/PermShareUserInfo;", "getLiveShareUserResult", "updateMetaInfoError", "", LynxError.LYNX_THROWABLE, "fetchMetaInfo", "fileId", "", "fetchDocVersion", "fetchCollaborates", "type", "", "token", "onCleared", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMetaInfoVM extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final g docInfoDataFetchExecutor;
    private final MutableLiveData<DocVersion> liveDocVersion;
    private final MutableLiveData<u55.a> liveMetaInfo;
    private final MutableLiveData<Throwable> liveMetaInfoError;
    private final MutableLiveData<PermShareUserInfo> liveShareUserResult;

    public static final class a implements ax4.e<ShareUserInfoResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveMetaInfoVM f222979a;

        public a(DriveMetaInfoVM r100) {
            this.f222979a = r100;
        }

        @Override // ax4.e
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f222979a.getLiveShareUserResult().setValue(new PermShareUserInfo(false, new ShareUserInfoResult()));
        }

        @Override // ax4.e
        public final void onSuccess(ShareUserInfoResult r100) {
            ShareUserInfoResult r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f222979a.getLiveShareUserResult().setValue(new PermShareUserInfo(true, r101));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveMetaInfoVM f222980a;

        public b(DriveMetaInfoVM r100) {
            this.f222980a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocVersion r101 = (DocVersion) r100;
            Intrinsics.checkNotNullParameter(r101, "ownerType");
            this.f222980a.getLiveDocVersion().postValue(r101);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f222981a = null;

        static {
            f222981a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("DriveComponent", (Throwable) r100, false);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f222982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveMetaInfoVM f222983b;

        public d(String r100, DriveMetaInfoVM r101) {
            this.f222982a = r100;
            this.f222983b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            u55.a r101 = (u55.a) r100;
            Intrinsics.checkNotNullParameter(r101, "driveMetaInfo");
            tt5.a.h("DriveComponent", "fetch meta info=" + r101);
            o75.b.a().Tb().q("request_meta_info", this.f222982a);
            this.f222983b.getLiveMetaInfo().postValue(r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveMetaInfoVM f222984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f222985b;

        public e(DriveMetaInfoVM r100, String r101) {
            this.f222984a = r100;
            this.f222985b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.f("DriveComponent", r101, false);
            DriveMetaInfoVM.access$updateMetaInfoError(this.f222984a, r101);
            o75.b.a().Tb().q("request_meta_info", this.f222985b);
        }
    }

    public DriveMetaInfoVM() {
        this.compositeDisposable = new CompositeDisposable();
        this.liveMetaInfo = new MutableLiveData();
        this.docInfoDataFetchExecutor = new g();
        this.liveDocVersion = new MutableLiveData();
        this.liveMetaInfoError = new MutableLiveData();
        this.liveShareUserResult = new MutableLiveData();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final MutableLiveData<DocVersion> getLiveDocVersion() {
        return this.liveDocVersion;
    }

    public final MutableLiveData<u55.a> getLiveMetaInfo() {
        return this.liveMetaInfo;
    }

    public final MutableLiveData<Throwable> getLiveMetaInfoError() {
        return this.liveMetaInfoError;
    }

    public final MutableLiveData<PermShareUserInfo> getLiveShareUserResult() {
        return this.liveShareUserResult;
    }

    private final void updateMetaInfoError(Throwable r100) {
        this.liveMetaInfoError.setValue(r100);
        this.liveMetaInfoError.setValue(null);
    }

    public final void fetchDocVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileId");
        Disposable r101 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).f(r100, sbb.e.f541301l.f541317b).subscribe(new b(this), c.f222981a);
        this.compositeDisposable.add(r101);
    }

    public final void fetchMetaInfo(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileId");
        tt5.a.h("DriveComponent", "DriveMetaInfoVM#fetchMetaInfo() start");
        o75.b.a().Tb().b(r100, "request_meta_info", null);
        this.docInfoDataFetchExecutor.getClass();
        int r101 = t05.a.f544124a;
        Disposable r102 = t05.a.a(r100, sbb.e.f541301l.f541317b).map(new b55.a(r100)).observeOn(fo5.d.d()).subscribe(new d(r100, this), new e(this, r100));
        this.compositeDisposable.add(r102);
    }

    public static final /* synthetic */ void access$updateMetaInfoError(DriveMetaInfoVM r100, Throwable r101) {
        r100.updateMetaInfoError(r101);
    }

    public final void fetchCollaborates(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        j r102 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        a r103 = new a(this);
        r102.getClass();
        Disposable r104 = li5.c.c(r100, r101, r103, null);
        this.compositeDisposable.add(r104);
    }
}
