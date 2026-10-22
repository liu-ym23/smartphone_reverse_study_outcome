package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class x extends DriveCacheService {

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f224071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<String> f224072b;

        public b(String r100, List<String> r101) {
            this.f224071a = r100;
            this.f224072b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Integer r101 = (Integer) r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            tt5.a.h("LarkDriveCacheService", "onDriveCacheRemoved(" + this.f224071a + "), tokens: " + this.f224072b + ", result: " + r101.intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void E8() {
        Intrinsics.checkNotNullParameter("DriveDatabaseManager-Migration78", "logKey");
        tt5.a.h("LarkDriveCacheService", "onDBTableDeleted(DriveDatabaseManager-Migration78)");
        ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.c(com.bytedance.ee.bear.contract.c0.class, null, null, 6)).m0(sbb.e.f541301l.f541317b);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void Z3() {
        Intrinsics.checkNotNullParameter("DriveDataService-cleanTempFileWhenInit", "logKey");
        if (((Boolean) ((ml5.b) this.f224044c.getValue()).a("sync_status_doc_finished", Boolean.FALSE)).booleanValue() == false) goto L7;
        tt5.a.h("LarkDriveCacheService", "onOldOfflineCacheDeleted(DriveDataService-cleanTempFileWhenInit), sync already finished.");
        return;
    L7:
        monitor-enter(DriveCacheService.class);
        List<DriveCache> r100 = ((com.bytedance.ee.bear.drive.services.c) org.koin.java.a.c(com.bytedance.ee.bear.drive.services.c.class, null, null, 6)).X2(this.f224043b.getSession());     // Catch: Throwable -> L20
        if (r100 == null) goto L17;
        List<DriveCache> r101 = r100;     // Catch: Throwable -> L20
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));     // Catch: Throwable -> L20
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L20
    L12:
        if (r103.hasNext() == false) goto L14;
        r102.add(((DriveCache) r103.next()).f216977k);     // Catch: Throwable -> L20
        goto L12
    L14:
        Flowable<Integer> r104 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).l(r102);     // Catch: Throwable -> L20
        if (r104 == null) goto L17;
        r104.subscribe(new a0(this), new b0());     // Catch: Throwable -> L20
    L17:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(DriveCacheService.class);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void J6(String r100) {
        Intrinsics.checkNotNullParameter("DriveDataService-put", "logKey");
        Intrinsics.checkNotNullParameter(r100, "fileId");
        List<String> r101 = CollectionsKt.mutableListOf(new String[]{r100});     // Catch: Exception -> L9
        List<String> r102 = r101;     // Catch: Exception -> L9
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));     // Catch: Exception -> L9
        Iterator r104 = r102.iterator();     // Catch: Exception -> L9
    L5:
        if (r104.hasNext() == false) goto L7;
        r103.add(du5.b.i((String) r104.next()));     // Catch: Exception -> L9
        goto L5
    L7:
        Unit r105 = (Unit) ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).l(r101).map(new y(r103, this)).blockingSingle();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.i("LarkDriveCacheService", "onDriveCacheAdded, error:", e);
        ((ml5.b) this.f224044c.getValue()).b("sync_status_doc_finished", Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void i6(List r100) {
        Intrinsics.checkNotNullParameter("DriveDataService-removeAll", "logKey");
        Intrinsics.checkNotNullParameter(r100, "fileIds");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(du5.b.i((String) r102.next()));
        goto L4
    L6:
        Unit r103 = (Unit) ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r100).map(new z(r101)).blockingSingle();
    }

    @Inject
    public x(by4.b r100, com.ss.android.lark.passportc.api.m r101) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        Intrinsics.checkNotNullParameter(r101, "userService");
        super("LarkDriveCacheService", r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void F8(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "logKey");
        Intrinsics.checkNotNullParameter(r101, "fileId");
        List<String> r102 = CollectionsKt.mutableListOf(new String[]{r101});
        List<String> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(du5.b.i((String) r105.next()));
        goto L4
    L6:
        Unit r106 = (Unit) ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r102).map(new b(r100, r104)).blockingSingle();
    }
}
