package com.bytedance.ee.bear.drive.biz.extra_info.meta;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b55.g;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.PermShareUserInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jg5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bJ\b\u0010!\u001a\u00020\u0017H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/extra_info/meta/DriveMetaInfoVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "liveMetaInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "getLiveMetaInfo", "()Landroidx/lifecycle/MutableLiveData;", "docInfoDataFetchExecutor", "Lcom/bytedance/ee/bear/drive/biz/docinfo/DocInfoDataFetchExecutor;", "liveDocVersion", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "getLiveDocVersion", "liveMetaInfoError", "", "getLiveMetaInfoError", "liveShareUserResult", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/PermShareUserInfo;", "getLiveShareUserResult", "updateMetaInfoError", "", "throwable", "fetchMetaInfo", "fileId", "", "fetchDocVersion", "fetchCollaborates", "type", "", "token", "onCleared", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMetaInfoVM extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final g docInfoDataFetchExecutor;
    private final MutableLiveData<DocVersion> liveDocVersion;
    private final MutableLiveData<u55.a> liveMetaInfo;
    private final MutableLiveData<Throwable> liveMetaInfoError;
    private final MutableLiveData<PermShareUserInfo> liveShareUserResult;

    public static final class a implements ax4.e<ShareUserInfoResult> {
        public final /* synthetic */ DriveMetaInfoVM a;

        public a(DriveMetaInfoVM r1) {
            this.a = r1;
        }

        @Override // ax4.e
        public final void onFailed(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "throwable");
            this.a.getLiveShareUserResult().setValue(new PermShareUserInfo(false, new ShareUserInfoResult()));
        }

        @Override // ax4.e
        public final void onSuccess(ShareUserInfoResult r4) {
            ShareUserInfoResult r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "data");
            this.a.getLiveShareUserResult().setValue(new PermShareUserInfo(true, r5));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DriveMetaInfoVM a;

        public b(DriveMetaInfoVM r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DocVersion r3 = (DocVersion) r2;
            Intrinsics.checkNotNullParameter(r3, "ownerType");
            this.a.getLiveDocVersion().postValue(r3);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.f("DriveComponent", (Throwable) r3, false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveMetaInfoVM b;

        public d(String r1, DriveMetaInfoVM r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            u55.a r5 = (u55.a) r4;
            Intrinsics.checkNotNullParameter(r5, "driveMetaInfo");
            tt5.a.h("DriveComponent", "fetch meta info=" + r5);
            o75.b.a().Tb().q("request_meta_info", this.a);
            this.b.getLiveMetaInfo().postValue(r5);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DriveMetaInfoVM a;
        public final /* synthetic */ String b;

        public e(DriveMetaInfoVM r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.f("DriveComponent", r4, false);
            DriveMetaInfoVM.access$updateMetaInfoError(this.a, r4);
            o75.b.a().Tb().q("request_meta_info", this.b);
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

    private final void updateMetaInfoError(Throwable r2) {
        this.liveMetaInfoError.setValue(r2);
        this.liveMetaInfoError.setValue(null);
    }

    public final void fetchDocVersion(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fileId");
        Disposable r5 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).f(r4, sbb.e.l.b).subscribe(new b(this), c.a);
        this.compositeDisposable.add(r5);
    }

    public final void fetchMetaInfo(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "fileId");
        tt5.a.h("DriveComponent", "DriveMetaInfoVM#fetchMetaInfo() start");
        o75.b.a().Tb().b(r4, "request_meta_info", null);
        this.docInfoDataFetchExecutor.getClass();
        int r0 = t05.a.a;
        Disposable r5 = t05.a.a(r4, sbb.e.l.b).map(new b55.a(r4)).observeOn(fo5.d.d()).subscribe(new d(r4, this), new e(this, r4));
        this.compositeDisposable.add(r5);
    }

    public static final /* synthetic */ void access$updateMetaInfoError(DriveMetaInfoVM r0, Throwable r1) {
        r0.updateMetaInfoError(r1);
    }

    public final void fetchCollaborates(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        a r2 = new a(this);
        r0.getClass();
        Disposable r6 = li5.c.c(r4, r5, r2, null);
        this.compositeDisposable.add(r6);
    }
}
