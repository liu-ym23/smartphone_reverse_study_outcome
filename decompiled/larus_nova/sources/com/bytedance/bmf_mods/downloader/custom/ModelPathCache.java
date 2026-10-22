package com.bytedance.bmf_mods.downloader.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/ModelPathCache;", "", "()V", "modelPaths", "", "Lkotlin/Pair;", "", "getModelPath", "modelName", "storeModelPath", "", "modelPath", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ModelPathCache {
    public static final ModelPathCache INSTANCE = null;
    private static final List<Pair<String, String>> modelPaths = null;

    private ModelPathCache() {
    }

    static {
        INSTANCE = new ModelPathCache();
        modelPaths = new ArrayList();
    }

    public final String getModelPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "modelName");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        String r102 = null;
        if (r101 == false) goto L9;
        return null;
    L9:
        monitor-enter(this);
        Iterator<T> r103 = modelPaths.iterator();     // Catch: Throwable -> L22
    L12:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(((Pair) r104).getFirst(), r100) == false) goto L12;
    L17:
        Pair r105 = (Pair) r104;     // Catch: Throwable -> L22
        if (r105 == null) goto L20;
        r102 = (String) r105.getSecond();     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return r102;
    L16:
        r104 = null;
    L22:
        th = move-exception;
        throw th;
    L5:
        r101 = false;
        goto L6
    }

    public final void storeModelPath(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "modelName");
        Intrinsics.checkNotNullParameter(r101, "modelPath");
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L23;
        monitor-enter(this);
        List<Pair<String, String>> r104 = modelPaths;     // Catch: Throwable -> L17
        CollectionsKt.removeAll(r104, new ModelPathCache$storeModelPath$1$1(r100));     // Catch: Throwable -> L17
        r104.add(new Pair(r100, r101));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    L23:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
