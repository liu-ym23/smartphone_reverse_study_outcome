package com.larus.avlink.gallery.migration;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.avlink.gallery.storage.m;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class AlbumMetadataMigrationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f292616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f292617b = null;

    public AlbumMetadataMigrationHelper() {
    }

    static {
        f292616a = LazyKt.lazy(new a());
        f292617b = LazyKt.lazy(new b());
    }

    public static final List a(String r100) {
        List r101 = m.a(r100);     // Catch: Exception -> L16
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));     // Catch: Exception -> L16
        Iterator r103 = r101.iterator();     // Catch: Exception -> L16
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((MediaMetadata) r103.next()).getUniqId());     // Catch: Exception -> L16
        goto L4
    L6:
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L16
        Iterator r105 = r102.iterator();     // Catch: Exception -> L16
    L7:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();     // Catch: Exception -> L16
        if (((String) r106).length() <= 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L7;
        r104.add(r106);     // Catch: Exception -> L16
        goto L7
    L12:
        r107 = false;
        goto L13
    L27:
        return r104;
    L16:
        e = move-exception;
        FLogger.f375446a.w("AlbumMetadataMigrationHelper", "Error extracting file IDs from index: " + e.getMessage());
        return CollectionsKt.emptyList();
    }

    public static Object b(Continuation r100) {
        GalleryStoragePolicyManager.f292721a.getClass();
        if (GalleryStoragePolicyManager.m() == true) goto L5;
        Object r101 = BuildersKt.withContext(Dispatchers.getIO(), new AlbumMetadataMigrationHelper$mediaMetadataMigrate$2(null), r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r101;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
