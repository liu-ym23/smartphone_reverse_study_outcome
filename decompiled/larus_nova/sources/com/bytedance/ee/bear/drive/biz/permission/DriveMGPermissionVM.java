package com.bytedance.ee.bear.drive.biz.permission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.lynx.tasm.LynxError;
import i75.p;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0005J\u0010\u0010&\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010'\u001a\u00020\tH\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)2\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060*J\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060*J\b\u0010,\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DriveMGPermissionVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "livePerm", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DrivePermissionInfo;", "offlinePerm", "liveTooManyRequestTips", "", "getLiveTooManyRequestTips", "()Landroidx/lifecycle/MutableLiveData;", "liveConditionControl", "getLiveConditionControl", "setLiveConditionControl", "(Landroidx/lifecycle/MutableLiveData;)V", "liveHardDelete", "getLiveHardDelete", "setLiveHardDelete", "liveCopyEscape", "getLiveCopyEscape", "setLiveCopyEscape", "isNoPermission", "()Z", "setNoPermission", "(Z)V", "permissionChangeListener", "Lkotlin/Function1;", "", "getPermissionChangeListener", "()Lkotlin/jvm/functions/Function1;", "setPermissionChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "fetchPermission", "objToken", "", "extraListener", "Lcom/bytedance/ee/bear/drive/biz/docinfo/IDrivePermissionRequestListener;", "postOfflinePerm", "isOfflineScreenEnable", "fetchPermissionFlow", "Lio/reactivex/Flowable;", "Landroidx/lifecycle/LiveData;", "liveOfflinePerm", "getPermValueSupportOffline", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMGPermissionVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveMGPermissionVM";
    private boolean isNoPermission;
    private MutableLiveData<Boolean> liveConditionControl;
    private MutableLiveData<Boolean> liveCopyEscape;
    private MutableLiveData<Boolean> liveHardDelete;
    private final MutableLiveData<u55.b> livePerm;
    private final MutableLiveData<Boolean> liveTooManyRequestTips;
    private final MutableLiveData<u55.b> offlinePerm;
    private Function1<? super u55.b, Unit> permissionChangeListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f223103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveMGPermissionVM f223104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b55.h f223105c;

        public b(String r100, DriveMGPermissionVM r101, b55.h r102) {
            this.f223103a = r100;
            this.f223104b = r101;
            this.f223105c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocPermission r101 = (DocPermission) r100;
            tt5.a.h(DriveMGPermissionVM.TAG, "fetchPermission - onNext, objToken: " + du5.b.i(this.f223103a) + ", docPermission: " + r101);
            u55.b r102 = new u55.b(this.f223103a, r101);
            this.f223104b.getLiveCopyEscape().postValue(Boolean.valueOf(t55.b.b(r102)));
            DriveMGPermissionVM.access$getLivePerm$p(this.f223104b).postValue(r102);
            IDocUserPermission r103 = null;
            ph5.b r104 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            String r105 = this.f223103a;
            int r106 = mu5.a.f515754a;
            if (r101 == null) goto L5;
            r103 = r101.f234419a;
        L5:
            String r107 = mu5.a.b(r103);
            if (r107 != null) goto L8;
            r107 = "";
        L8:
            r104.a(r105, r107);
            b55.h r108 = this.f223105c;
            if (r108 == null) goto L11;
            r108.a(r102);
        L11:
            Function1<u55.b, Unit> r109 = this.f223104b.getPermissionChangeListener();
            if (r109 == null) goto L15;
            r109.invoke(r102);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f223106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveMGPermissionVM f223107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b55.h f223108c;

        public c(String r100, DriveMGPermissionVM r101, b55.h r102) {
            this.f223106a = r100;
            this.f223107b = r101;
            this.f223108c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            boolean r102 = false;
            tt5.a.e(DriveMGPermissionVM.TAG, "fetchPermission - onError, objToken: " + du5.b.i(this.f223106a) + ", error: ", r101, false);
            DriveMGPermissionVM.access$getLivePerm$p(this.f223107b).postValue(null);
            if (r101 != null) goto L5;
        L10:
            b55.h r103 = this.f223108c;
            if (r103 == null) goto L13;
            r103.onFailure(r101);
        L13:
            if (r101 != null) goto L15;
            return;
        L15:
            if (p.a(r101.getMessage()) != 429) goto L17;
            r102 = true;
        L17:
            if (r102 == true) goto L20;
            r101 = null;
        L20:
            if (r101 == null) goto L24;
            this.f223107b.getLiveTooManyRequestTips().postValue(Boolean.TRUE);
            return;
        L24:
            return;
        L5:
            if (ax4.d.b(r101, 3) == false) goto L7;
            Throwable r104 = r101;
        L8:
            if (r104 == null) goto L10;
            this.f223107b.liveHardDelete().postValue(Boolean.TRUE);
            goto L10
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f223109a;

        public d(String r100) {
            this.f223109a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = this.f223109a;
            return new u55.b(r101, (DocPermission) r100);
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f223110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveMGPermissionVM f223111b;

        public e(String r100, DriveMGPermissionVM r101) {
            this.f223110a = r100;
            this.f223111b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            u55.b r101 = (u55.b) r100;
            Intrinsics.checkNotNullParameter(r101, "drivePermissionInfo");
            tt5.a.h(DriveMGPermissionVM.TAG, "fetchPermissionFlow - map, objToken: " + du5.b.i(this.f223110a) + ", drivePermissionInfo: " + r101);
            DriveMGPermissionVM.access$getLivePerm$p(this.f223111b).postValue(r101);
            ph5.b r102 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            String r103 = this.f223110a;
            int r104 = mu5.a.f515754a;
            r102.a(r103, mu5.a.b(r101.f548841b.f234419a));
            Function1<u55.b, Unit> r105 = this.f223111b.getPermissionChangeListener();
            if (r105 == null) goto L5;
            r105.invoke(r101);
        L5:
            return r101;
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f223112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveMGPermissionVM f223113b;

        public f(String r100, DriveMGPermissionVM r101) {
            this.f223112a = r100;
            this.f223113b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.h(DriveMGPermissionVM.TAG, "fetchPermissionFlow - onErrorResumeNext, objToken: " + du5.b.i(this.f223112a) + ", throwable: " + r101);
            Throwable r102 = null;
            DriveMGPermissionVM.access$getLivePerm$p(this.f223113b).postValue(null);
            if (p.a(r101.getMessage()) != 429) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L8;
            r102 = r101;
        L8:
            if (r102 == null) goto L11;
            this.f223113b.getLiveTooManyRequestTips().postValue(Boolean.TRUE);
        L11:
            return Flowable.error(r101);
        L5:
            r103 = false;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveMGPermissionVM f223114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f223115b;

        public g(DriveMGPermissionVM r100, String r101) {
            this.f223114a = r100;
            this.f223115b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            MutableLiveData r102 = DriveMGPermissionVM.access$getOfflinePerm$p(this.f223114a);
            int r103 = t55.a.f544628a;
            r102.postValue(t55.a.b(this.f223115b, r101));
            MutableLiveData<Boolean> r104 = this.f223114a.getLiveCopyEscape();
            int r105 = t55.b.f544629a;
            r104.postValue(Boolean.valueOf(t55.b.b(t55.a.b(this.f223115b, r101))));
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f223116a = null;

        static {
            f223116a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.d("DriveComponent", "postOfflinePerm error " + r101.getMessage());
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

    public DriveMGPermissionVM() {
        this.livePerm = new MutableLiveData();
        this.offlinePerm = new MutableLiveData();
        this.liveTooManyRequestTips = new MutableLiveData();
        this.liveConditionControl = new MutableLiveData();
        this.liveHardDelete = new MutableLiveData();
        this.liveCopyEscape = new MutableLiveData();
    }

    public final u55.b getPermValueSupportOffline() {
        if (isOfflineScreenEnable() == false) goto L7;
        return liveOfflinePerm().getValue();
    L7:
        return livePerm().getValue();
    }

    public final MutableLiveData<Boolean> getLiveConditionControl() {
        return this.liveConditionControl;
    }

    public final MutableLiveData<Boolean> getLiveCopyEscape() {
        return this.liveCopyEscape;
    }

    public final MutableLiveData<Boolean> getLiveHardDelete() {
        return this.liveHardDelete;
    }

    public final MutableLiveData<Boolean> getLiveTooManyRequestTips() {
        return this.liveTooManyRequestTips;
    }

    public final Function1<u55.b, Unit> getPermissionChangeListener() {
        return this.permissionChangeListener;
    }

    public final boolean isNoPermission() {
        return this.isNoPermission;
    }

    public final MutableLiveData<Boolean> liveHardDelete() {
        return this.liveHardDelete;
    }

    public final LiveData<u55.b> liveOfflinePerm() {
        return this.offlinePerm;
    }

    public final LiveData<u55.b> livePerm() {
        return this.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getLivePerm$p(DriveMGPermissionVM r100) {
        return r100.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getOfflinePerm$p(DriveMGPermissionVM r100) {
        return r100.offlinePerm;
    }

    public final Flowable<u55.b> fetchPermissionFlow(String r100) {
        return ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r100, sbb.e.f541301l.f541317b).observeOn(fo5.d.d()).map(new d(r100)).map(new e(r100, this)).onErrorResumeNext(new f(r100, this));
    }

    public final void postOfflinePerm(String r100) {
        if (isOfflineScreenEnable() == false) goto L10;
        ph5.b r101 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
        if (r100 != null) goto L7;
        String r102 = "";
    L8:
        r101.c(r102).observeOn(fo5.d.d()).subscribe(new g(this, r100), h.f223116a);
        return;
    L7:
        r102 = r100;
        goto L8
    }

    public final void setLiveConditionControl(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveConditionControl = r100;
    }

    public final void setLiveCopyEscape(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveCopyEscape = r100;
    }

    public final void setLiveHardDelete(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveHardDelete = r100;
    }

    public final void setNoPermission(boolean r100) {
        this.isNoPermission = r100;
    }

    public final void setPermissionChangeListener(Function1<? super u55.b, Unit> r100) {
        this.permissionChangeListener = r100;
    }

    public final void fetchPermission(String r100, b55.h r101) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r100, sbb.e.f541301l.f541317b).observeOn(fo5.d.d()).subscribe(new b(r100, this, r101), new c(r100, this, r101));
    }

    public static /* synthetic */ void fetchPermission$default(DriveMGPermissionVM r100, String r101, b55.h r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.fetchPermission(r101, r102);
    }
}
