package com.bytedance.ee.bear.drive.biz.permission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import i75.p;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveMGPermissionVM b;
        public final /* synthetic */ b55.h c;

        public b(String r1, DriveMGPermissionVM r2, b55.h r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            DocPermission r7 = (DocPermission) r6;
            tt5.a.h(DriveMGPermissionVM.TAG, "fetchPermission - onNext, objToken: " + du5.b.i(this.a) + ", docPermission: " + r7);
            u55.b r0 = new u55.b(this.a, r7);
            this.b.getLiveCopyEscape().postValue(Boolean.valueOf(t55.b.b(r0)));
            DriveMGPermissionVM.access$getLivePerm$p(this.b).postValue(r0);
            IDocUserPermission r3 = null;
            ph5.b r1 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            String r2 = this.a;
            int r4 = mu5.a.a;
            if (r7 == null) goto L5;
            r3 = r7.a;
        L5:
            String r8 = mu5.a.b(r3);
            if (r8 != null) goto L8;
            r8 = "";
        L8:
            r1.a(r2, r8);
            b55.h r9 = this.c;
            if (r9 == null) goto L11;
            r9.a(r0);
        L11:
            Function1<u55.b, Unit> r10 = this.b.getPermissionChangeListener();
            if (r10 == null) goto L15;
            r10.invoke(r0);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveMGPermissionVM b;
        public final /* synthetic */ b55.h c;

        public c(String r1, DriveMGPermissionVM r2, b55.h r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            boolean r2 = false;
            tt5.a.e(DriveMGPermissionVM.TAG, "fetchPermission - onError, objToken: " + du5.b.i(this.a) + ", error: ", r6, false);
            DriveMGPermissionVM.access$getLivePerm$p(this.b).postValue(null);
            if (r6 != null) goto L5;
        L10:
            b55.h r0 = this.c;
            if (r0 == null) goto L13;
            r0.onFailure(r6);
        L13:
            if (r6 != null) goto L15;
            return;
        L15:
            if (p.a(r6.getMessage()) != 429) goto L17;
            r2 = true;
        L17:
            if (r2 == true) goto L20;
            r6 = null;
        L20:
            if (r6 == null) goto L24;
            this.b.getLiveTooManyRequestTips().postValue(Boolean.TRUE);
            return;
        L24:
            return;
        L5:
            if (ax4.d.b(r6, 3) == false) goto L7;
            Throwable r1 = r6;
        L8:
            if (r1 == null) goto L10;
            this.b.liveHardDelete().postValue(Boolean.TRUE);
            goto L10
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            String r1 = this.a;
            return new u55.b(r1, (DocPermission) r3);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveMGPermissionVM b;

        public e(String r1, DriveMGPermissionVM r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            u55.b r5 = (u55.b) r4;
            Intrinsics.checkNotNullParameter(r5, "drivePermissionInfo");
            tt5.a.h(DriveMGPermissionVM.TAG, "fetchPermissionFlow - map, objToken: " + du5.b.i(this.a) + ", drivePermissionInfo: " + r5);
            DriveMGPermissionVM.access$getLivePerm$p(this.b).postValue(r5);
            ph5.b r0 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            String r1 = this.a;
            int r2 = mu5.a.a;
            r0.a(r1, mu5.a.b(r5.b.a));
            Function1<u55.b, Unit> r3 = this.b.getPermissionChangeListener();
            if (r3 == null) goto L5;
            r3.invoke(r5);
        L5:
            return r5;
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveMGPermissionVM b;

        public f(String r1, DriveMGPermissionVM r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.h(DriveMGPermissionVM.TAG, "fetchPermissionFlow - onErrorResumeNext, objToken: " + du5.b.i(this.a) + ", throwable: " + r5);
            Throwable r1 = null;
            DriveMGPermissionVM.access$getLivePerm$p(this.b).postValue(null);
            if (p.a(r5.getMessage()) != 429) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            r1 = r5;
        L8:
            if (r1 == null) goto L11;
            this.b.getLiveTooManyRequestTips().postValue(Boolean.TRUE);
        L11:
            return Flowable.error(r5);
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ DriveMGPermissionVM a;
        public final /* synthetic */ String b;

        public g(DriveMGPermissionVM r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            MutableLiveData r0 = DriveMGPermissionVM.access$getOfflinePerm$p(this.a);
            int r1 = t55.a.a;
            r0.postValue(t55.a.b(this.b, r4));
            MutableLiveData<Boolean> r2 = this.a.getLiveCopyEscape();
            int r5 = t55.b.a;
            r2.postValue(Boolean.valueOf(t55.b.b(t55.a.b(this.b, r4))));
        }
    }

    public static final class h<T> implements Consumer {
        public static final h<T> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d("DriveComponent", "postOfflinePerm error " + r4.getMessage());
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
        return (u55.b) liveOfflinePerm().getValue();
    L7:
        return (u55.b) livePerm().getValue();
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

    public static final /* synthetic */ MutableLiveData access$getLivePerm$p(DriveMGPermissionVM r0) {
        return r0.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getOfflinePerm$p(DriveMGPermissionVM r0) {
        return r0.offlinePerm;
    }

    public final Flowable<u55.b> fetchPermissionFlow(String r4) {
        return ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r4, sbb.e.l.b).observeOn(fo5.d.d()).map(new d(r4)).map(new e(r4, this)).onErrorResumeNext(new f(r4, this));
    }

    public final void postOfflinePerm(String r4) {
        if (isOfflineScreenEnable() == false) goto L10;
        ph5.b r0 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
        if (r4 != null) goto L7;
        String r1 = "";
    L8:
        r0.c(r1).observeOn(fo5.d.d()).subscribe(new g(this, r4), h.a);
        return;
    L7:
        r1 = r4;
        goto L8
    }

    public final void setLiveConditionControl(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveConditionControl = r2;
    }

    public final void setLiveCopyEscape(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveCopyEscape = r2;
    }

    public final void setLiveHardDelete(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveHardDelete = r2;
    }

    public final void setNoPermission(boolean r1) {
        this.isNoPermission = r1;
    }

    public final void setPermissionChangeListener(Function1<? super u55.b, Unit> r1) {
        this.permissionChangeListener = r1;
    }

    public final void fetchPermission(String r4, b55.h r5) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r4, sbb.e.l.b).observeOn(fo5.d.d()).subscribe(new b(r4, this, r5), new c(r4, this, r5));
    }

    public static /* synthetic */ void fetchPermission$default(DriveMGPermissionVM r0, String r1, b55.h r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.fetchPermission(r1, r2);
    }
}
