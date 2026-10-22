package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.graphics.drawable.Drawable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n39.h;
import n39.n;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0006J1\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocSnapshotManager;", "", "<init>", "()V", "snapShotServiceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/larus/doc/sdk/api/ISnapShotService;", "setSnapshotService", "", "service", "key", "startDocSnapshot", "inputViewHeight", "", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "docLogicKey", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSnapshotManager {
    public static final DocSnapshotManager INSTANCE = null;
    private static ConcurrentHashMap<String, n> snapShotServiceMap;

    private DocSnapshotManager() {
    }

    static {
        INSTANCE = new DocSnapshotManager();
        snapShotServiceMap = new ConcurrentHashMap();
    }

    public final void setSnapshotService(n r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 != null) goto L6;
        snapShotServiceMap.remove(r101);
        return;
    L6:
        snapShotServiceMap.put(r101, r100);
    }

    public final void startDocSnapshot(Integer r100, Drawable r101, h r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        Intrinsics.checkNotNullParameter(r103, "docLogicKey");
        n r104 = snapShotServiceMap.get(r103);
        if (r104 == null) goto L6;
        r104.startDocSnapshot(r100, r101, r102);
        return;
    }

    public static /* synthetic */ void setSnapshotService$default(DocSnapshotManager r100, n r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = "default_doc_logic_key";
    L5:
        r100.setSnapshotService(r101, r102);
    }

    public static /* synthetic */ void startDocSnapshot$default(DocSnapshotManager r100, Integer r101, Drawable r102, h r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = "default_doc_logic_key";
    L5:
        r100.startDocSnapshot(r101, r102, r103, r104);
    }
}
