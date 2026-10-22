package com.bytedance.ee.space.sync;

import com.bytedance.ee.bear.rn.RnPushProtocol;
import com.bytedance.ee.bear.rn.h;
import com.bytedance.ee.bear.rn.i;
import com.bytedance.ee.bear.rn.l;
import f75.e;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class RnSyncPushManager implements com.bytedance.ee.space.sync.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f243074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f243075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f243076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f243077d;

    public static final class a {
    }

    public static final class b implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bu5.a f243078a;

        public b(bu5.a r100) {
            this.f243078a = r100;
        }

        @Override // com.bytedance.ee.bear.rn.h.a
        public final void didReceivePush(String r100) {
            this.f243078a.didReceivePush(r100);
        }
    }

    public static final class c implements l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bu5.a f243079a;

        public c(bu5.a r100) {
            this.f243079a = r100;
        }

        @Override // com.bytedance.ee.bear.rn.l.a
        public final void didReceivePush(String r100) {
            this.f243079a.didReceivePush(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void onDestroy() {
    }

    public RnSyncPushManager() {
        this.f243074a = LazyKt.lazy(RnSyncPushManager$commonObserverMap$2.INSTANCE);
        this.f243075b = LazyKt.lazy(RnSyncPushManager$deleteObserverMap$2.INSTANCE);
        this.f243076c = LazyKt.lazy(RnSyncPushManager$secretObserverMap$2.INSTANCE);
        this.f243077d = LazyKt.lazy(RnSyncPushManager$commonPushObserverMap$2.INSTANCE);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void De(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        i r101 = (i) ((Map) this.f243075b.getValue()).remove(r100);
        if (r101 != null) goto L6;
        tt5.a.k("RnSyncPushManager", "removeFileDeleteObserver, observer doesn't exist: " + r100);
        return;
    L6:
        tt5.a.h("RnSyncPushManager", "removeFileDeleteObserver, observer: " + r100 + ", unregister RnPushProtocol: " + r101);
        r101.a();
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Lc(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        c(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void P1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        d(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Ye(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        l r101 = (l) ((Map) this.f243076c.getValue()).remove(r100);
        if (r101 != null) goto L6;
        tt5.a.k("RnSyncPushManager", "removeSecUpdateObserver, observer doesn't exist: " + r100);
        return;
    L6:
        tt5.a.h("RnSyncPushManager", "removeSecUpdateObserver, observer: " + r100 + ", unregister RnSecretProtocol: " + r101);
        r101.a();
    }

    public final void c(bu5.a r100) {
        RnPushProtocol r101 = (RnPushProtocol) ((Map) this.f243074a.getValue()).remove(r100);
        if (r101 != null) goto L6;
        tt5.a.k("RnSyncPushManager", "removeReliableCommonObserver, observer doesn't exist: " + r100);
        return;
    L6:
        tt5.a.h("RnSyncPushManager", "removeReliableCommonObserver, observer: " + r100 + ", unregister RnPushProtocol: " + r101);
        r101.a();
    }

    public final void d(bu5.a r100) {
        h r101 = (h) ((Map) this.f243077d.getValue()).remove(r100);
        if (r101 != null) goto L6;
        tt5.a.k("RnSyncPushManager", "removeRnCommonPushObserver, observer doesn't exist: " + r100);
        return;
    L6:
        tt5.a.h("RnSyncPushManager", "removeRnCommonPushObserver, observer: " + r100 + ", unregister RnCommonPushProtocol: " + r101);
        r101.a();
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void lb(cr5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        c(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n5(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        d(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n8(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        d(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void q1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        d(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void w7(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        c(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Cd(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        return a("WIKI_TREE_", r100, "id", "WIKI_TREE", r101);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Lb(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "routeKey");
        Intrinsics.checkNotNullParameter(r101, "observer");
        return a("DRIVE_PREVIEW_EVENT_", r100, "token", "DRIVE_PREVIEW_EVENT", r101);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean M6(String r100, int r101, i65.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return b(r100, r101, "UPDATE_FILE_META", r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean P8(String r100, int r101, f75.c r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return b(r100, r101, "DELETE_FILE_VERSION", r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean S2(String r100, int r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return b(r100, r101, "UPLOAD_FILE_VERSION", r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean d7(final String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (((l) ((Map) this.f243076c.getValue()).get(r102)) == null) goto L6;
        tt5.a.d("RnSyncPushManager", "addSecUpdateObserver, observer is already been registered.");
        return false;
    L6:
        final String r103 = "NOTICE_" + r101 + '_';
        l r104 = (l) org.koin.java.a.b(l.class, null, new RnSyncPushManager$addSecUpdateObserver$rnPush$1(r103, r100));
        tt5.a.h("RnSyncPushManager", "addSecUpdateObserver, docType: " + r101 + ", observer: " + r102 + ", register RnSecretProtocol: " + r104);
        ((Map) this.f243076c.getValue()).put(r102, r104);
        r104.b(new c(r102));
        return true;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean i4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return a("PERMISSION_CHANGE_", r100, "token", "PERMISSION_CHANGE", r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean r6(final String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (((i) ((Map) this.f243075b.getValue()).get(r102)) == null) goto L6;
        tt5.a.d("RnSyncPushManager", "addFileDeleteObserver, observer is already been registered.");
        return false;
    L6:
        final String r103 = "NOTICE_" + r101 + '_';
        i r104 = (i) org.koin.java.a.b(i.class, null, new RnSyncPushManager$addFileDeleteObserver$rnPush$1(r103, r100));
        tt5.a.h("RnSyncPushManager", "addFileDeleteObserver, docType: " + r101 + ", observer: " + r102 + ", register RnPushProtocol: " + r104);
        ((Map) this.f243075b.getValue()).put(r102, r104);
        r104.b(r102);
        return true;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean u4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return b(r100, r101, "groupChange", r102);
    }

    public final boolean b(final String r100, final int r101, final String r102, bu5.a r103) {
        if (((h) ((Map) this.f243077d.getValue()).get(r103)) == null) goto L6;
        tt5.a.d("RnSyncPushManager", "addRnCommonPushObserver, observer is already been registered.");
        return false;
    L6:
        h r104 = (h) org.koin.java.a.b(h.class, null, new RnSyncPushManager$addRnCommonPushObserver$rnPush$1(r100, r101, r102));
        tt5.a.h("RnSyncPushManager", "addRnCommonPushObserver, operation: " + r102 + ", docType: " + r101 + ", observer: " + r103 + ", register RnCommonPushProtocol: " + r104);
        ((Map) this.f243077d.getValue()).put(r103, r104);
        r104.b(new b(r103));
        return true;
    }

    public final boolean a(final String r100, final String r101, final String r102, final String r103, bu5.a r104) {
        if (((RnPushProtocol) ((Map) this.f243074a.getValue()).get(r104)) == null) goto L6;
        tt5.a.d("RnSyncPushManager", "addReliableCommonObserver, observer is already been registered.");
        return false;
    L6:
        RnPushProtocol r105 = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new RnSyncPushManager$addReliableCommonObserver$rnPush$1(r100, r101, r102, r103));
        tt5.a.h("RnSyncPushManager", "addReliableCommonObserver, tagPrefix: " + r100 + ", observer: " + r104 + ", register RnPushProtocol: " + r105);
        ((Map) this.f243074a.getValue()).put(r104, r105);
        r105.b(r104);
        return true;
    }
}
