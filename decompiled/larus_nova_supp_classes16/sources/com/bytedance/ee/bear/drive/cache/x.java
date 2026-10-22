package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x extends DriveCacheService {

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ List<String> b;

        public b(String r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Integer r4 = (Integer) r3;
            Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
            tt5.a.h("LarkDriveCacheService", "onDriveCacheRemoved(" + this.a + "), tokens: " + this.b + ", result: " + r4.intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void E8() {
        Intrinsics.checkNotNullParameter("DriveDatabaseManager-Migration78", "logKey");
        tt5.a.h("LarkDriveCacheService", "onDBTableDeleted(DriveDatabaseManager-Migration78)");
        ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.c(com.bytedance.ee.bear.contract.c0.class, null, null, 6)).m0(sbb.e.l.b);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void Z3() {
        Intrinsics.checkNotNullParameter("DriveDataService-cleanTempFileWhenInit", "logKey");
        if (((Boolean) ((ml5.b) this.c.getValue()).a("sync_status_doc_finished", Boolean.FALSE)).booleanValue() == false) goto L7;
        tt5.a.h("LarkDriveCacheService", "onOldOfflineCacheDeleted(DriveDataService-cleanTempFileWhenInit), sync already finished.");
        return;
    L7:
        monitor-enter(DriveCacheService.class);
        List<DriveCache> r1 = ((com.bytedance.ee.bear.drive.services.c) org.koin.java.a.c(com.bytedance.ee.bear.drive.services.c.class, null, null, 6)).X2(this.b.getSession());     // Catch: Throwable -> L20
        if (r1 == null) goto L17;
        List<DriveCache> r2 = r1;     // Catch: Throwable -> L20
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Throwable -> L20
        Iterator<T> r3 = r2.iterator();     // Catch: Throwable -> L20
    L12:
        if (r3.hasNext() == false) goto L14;
        r4.add(((DriveCache) r3.next()).k);     // Catch: Throwable -> L20
        goto L12
    L14:
        Flowable r5 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).l(r4);     // Catch: Throwable -> L20
        if (r5 == null) goto L17;
        r5.subscribe(new a0(this), new b0());     // Catch: Throwable -> L20
    L17:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(DriveCacheService.class);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void J6(String r5) {
        Intrinsics.checkNotNullParameter("DriveDataService-put", "logKey");
        Intrinsics.checkNotNullParameter(r5, "fileId");
        List r6 = CollectionsKt.mutableListOf(new String[]{r5});     // Catch: Exception -> L9
        List r0 = r6;     // Catch: Exception -> L9
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Exception -> L9
        Iterator r2 = r0.iterator();     // Catch: Exception -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(du5.b.i((String) r2.next()));     // Catch: Exception -> L9
        goto L5
    L7:
        Unit r7 = (Unit) ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).l(r6).map(new y(r1, this)).blockingSingle();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.i("LarkDriveCacheService", "onDriveCacheAdded, error:", e);
        ((ml5.b) this.c.getValue()).b("sync_status_doc_finished", Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void i6(List r5) {
        Intrinsics.checkNotNullParameter("DriveDataService-removeAll", "logKey");
        Intrinsics.checkNotNullParameter(r5, "fileIds");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r1 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(du5.b.i((String) r1.next()));
        goto L4
    L6:
        Unit r6 = (Unit) ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r5).map(new z(r0)).blockingSingle();
    }

    @Inject
    public x(by4.b r2, com.ss.android.lark.passportc.api.m r3) {
        Intrinsics.checkNotNullParameter(r2, "kvStorage");
        Intrinsics.checkNotNullParameter(r3, "userService");
        super("LarkDriveCacheService", r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void F8(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "logKey");
        Intrinsics.checkNotNullParameter(r6, "fileId");
        List r7 = CollectionsKt.mutableListOf(new String[]{r6});
        List r0 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(du5.b.i((String) r2.next()));
        goto L4
    L6:
        Unit r8 = (Unit) ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r7).map(new b(r5, r1)).blockingSingle();
    }
}
