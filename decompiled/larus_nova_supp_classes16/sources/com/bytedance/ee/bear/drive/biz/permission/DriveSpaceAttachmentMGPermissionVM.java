package com.bytedance.ee.bear.drive.biz.permission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b55.g;
import b55.h;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013J\b\u0010\u0015\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DriveSpaceAttachmentMGPermissionVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "executor", "Lcom/bytedance/ee/bear/drive/biz/docinfo/DocInfoDataFetchExecutor;", "livePerm", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DrivePermissionInfo;", "offlinePerm", "liveCopyEscape", "", "fetchPermission", "", "objToken", "", "url", "postOfflinePerm", "isOfflineScreenEnable", "Landroidx/lifecycle/LiveData;", "liveOfflinePerm", "getPermValueSupportOffline", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceAttachmentMGPermissionVM extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "DriveSpaceAttachmentMGPermissionVM";
    private final g executor;
    private MutableLiveData<Boolean> liveCopyEscape;
    private final MutableLiveData<u55.b> livePerm;
    private final MutableLiveData<u55.b> offlinePerm;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements h {
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionVM a;
        public final /* synthetic */ String b;

        @Override // b55.h
        public final void a(u55.b r5) {
            DriveSpaceAttachmentMGPermissionVM.access$getLiveCopyEscape$p(this.a).postValue(Boolean.valueOf(t55.b.b(r5)));
            DriveSpaceAttachmentMGPermissionVM.access$getLivePerm$p(this.a).postValue(r5);
            String r0 = this.b;
            ph5.b r1 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            int r2 = mu5.a.a;
            DocPermission r6 = r5.b;
            if (r6 == null) goto L7;
            IDocUserPermission r7 = r6.a;
            if (r7 == null) goto L7;
        L8:
            r1.a(r0, mu5.a.b(r7));
            return;
        L7:
            r7 = "";
            goto L8
        }

        @Override // b55.h
        public final void onFailure(Throwable r4) {
            DriveSpaceAttachmentMGPermissionVM.access$getLivePerm$p(this.a).postValue(null);
            tt5.a.e("DriveComponent", "fetchPermission() failed", r4, false);
        }

        public b(DriveSpaceAttachmentMGPermissionVM r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionVM a;
        public final /* synthetic */ String b;

        public c(DriveSpaceAttachmentMGPermissionVM r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            MutableLiveData r0 = DriveSpaceAttachmentMGPermissionVM.access$getOfflinePerm$p(this.a);
            int r1 = t55.a.a;
            r0.postValue(t55.a.b(this.b, r4));
            MutableLiveData r2 = DriveSpaceAttachmentMGPermissionVM.access$getLiveCopyEscape$p(this.a);
            int r5 = t55.b.a;
            r2.postValue(Boolean.valueOf(t55.b.b(t55.a.b(this.b, r4))));
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d(DriveSpaceAttachmentMGPermissionVM.TAG, "postOfflinePerm error " + r4.getMessage());
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

    public DriveSpaceAttachmentMGPermissionVM() {
        this.executor = new g();
        this.livePerm = new MutableLiveData();
        this.offlinePerm = new MutableLiveData();
        this.liveCopyEscape = new MutableLiveData();
    }

    public final u55.b getPermValueSupportOffline() {
        if (isOfflineScreenEnable() == false) goto L7;
        return (u55.b) liveOfflinePerm().getValue();
    L7:
        return (u55.b) livePerm().getValue();
    }

    public final MutableLiveData<Boolean> liveCopyEscape() {
        return this.liveCopyEscape;
    }

    public final LiveData<u55.b> liveOfflinePerm() {
        return this.offlinePerm;
    }

    public final LiveData<u55.b> livePerm() {
        return this.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getLiveCopyEscape$p(DriveSpaceAttachmentMGPermissionVM r0) {
        return r0.liveCopyEscape;
    }

    public static final /* synthetic */ MutableLiveData access$getLivePerm$p(DriveSpaceAttachmentMGPermissionVM r0) {
        return r0.livePerm;
    }

    public static final /* synthetic */ MutableLiveData access$getOfflinePerm$p(DriveSpaceAttachmentMGPermissionVM r0) {
        return r0.offlinePerm;
    }

    public final void postOfflinePerm(String r4) {
        if (isOfflineScreenEnable() == false) goto L10;
        ph5.b r0 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
        if (r4 != null) goto L7;
        String r1 = "";
    L8:
        r0.c(r1).observeOn(fo5.d.d()).subscribe(new c(this, r4), d.a);
        return;
    L7:
        r1 = r4;
        goto L8
    }

    public final void fetchPermission(final String r3, String r4) {
        g r5 = this.executor;
        final b r0 = new b(this, r3);
        r5.getClass();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().c(r3, sbb.e.l.b).observeOn(fo5.d.d()).subscribe(new b55.b(r0, r3), new b55.c(r0));
    }
}
