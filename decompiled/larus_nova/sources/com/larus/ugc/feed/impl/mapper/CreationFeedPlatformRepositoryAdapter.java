package com.larus.ugc.feed.impl.mapper;

import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.impl.cache.CreationListCacheDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import m0a.j;
import m0a.l;
import zp9.n;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationFeedPlatformRepositoryAdapter implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f374850a;

    @Override // m0a.l
    public final CreationFeedCacheEntityKmp b() {
        CreationFeedCacheEntity r100 = this.f374850a.b();
        CommonCreationFeedDataKmp r101 = null;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = r100.getCreationRecommendType();
        zp9.c r103 = r100.getListData();
        if (r103 == null) goto L8;
        r101 = c.a(r103);
    L8:
        return new CreationFeedCacheEntityKmp(r102, r101, r100.getRandomSeed(), r100.getTimeStamp());
    L9:
        return null;
    }

    public CreationFeedPlatformRepositoryAdapter(n r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f374850a = r100;
    }

    @Override // m0a.l
    public final Object c(CreationFeedCacheEntityKmp r110, Continuation<? super Unit> r111) {
        String r100 = r110.getCreationRecommendType();
        if (r100 != null) goto L7;
        return Unit.INSTANCE;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        CreationListCacheDataSource r102 = CreationListCacheDataSource.f374641a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r103 = r110.getCreationRecommendType();
        CommonCreationFeedDataKmp r104 = r110.getListData();
        zp9.c r105 = null;
        ArrayList r106 = null;
        if (r104 == null) goto L26;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        boolean r107 = r104.getHasMore();
        Map<String, String> r108 = r104.getTraceMap();
        List<UserCreationKmp> r109 = r104.getCreationList();
        if (r109 == null) goto L18;
        List<UserCreation> r112 = c.e(r109);
    L19:
        List<List<UserCreationKmp>> r113 = r104.getCreationGroupList();
        if (r113 == null) goto L25;
        List<List<UserCreationKmp>> r114 = r113;
        r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r115 = r114.iterator();
    L23:
        if (r115.hasNext() == false) goto L25;
        r106.add(c.e((List) r115.next()));
    L25:
        r105 = new zp9.c(r107, r108, r112, r106, r104.getNextCursor());
        goto L26
    L18:
        r112 = null;
    L26:
        Object r116 = r102.b(r100, new CreationFeedCacheEntity(r103, r105, r110.getRandomSeed(), r110.getTimeStamp()), r111);
        if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        return r116;
    L30:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L9:
        r101 = false;
        goto L10
    }

    @Override // m0a.l
    public final Object a(int r100, String r101, Long r110, String r111, Continuation<? super Pair<CommonCreationFeedDataKmp, ? extends j<Unit>>> r112) {
        if ((r112 instanceof CreationFeedPlatformRepositoryAdapter$fetchBatch$1) == false) goto L7;
        CreationFeedPlatformRepositoryAdapter$fetchBatch$1 r102 = (CreationFeedPlatformRepositoryAdapter$fetchBatch$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        CreationFeedPlatformRepositoryAdapter$fetchBatch$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        Pair r114 = (Pair) r113;
        zp9.c r107 = (zp9.c) r114.component1();
        dm9.a r108 = (dm9.a) r114.component2();
        Object r115 = null;
        if (r107 == null) goto L20;
        CommonCreationFeedDataKmp r109 = c.a(r107);
    L21:
        if (r108 == null) goto L31;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if ((r108 instanceof dm9.a.b) == false) goto L26;
        r115 = new j.b(Unit.INSTANCE);
        goto L31
    L26:
        if ((r108 instanceof dm9.a.C5690a) == false) goto L29;
        dm9.a.C5690a r116 = (dm9.a.C5690a) r108;
        r115 = new j.a(r116.f469228a, r116.f469229b, r116.f469230c);
        goto L31
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        return TuplesKt.to(r109, r115);
    L20:
        r109 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        n r117 = this.f374850a;
        r104.label = 1;
        r113 = r117.a(r100, r101, r110, r111, r104);
        if (r113 != r105) goto L17;
        return r105;
    L7:
        r102 = new CreationFeedPlatformRepositoryAdapter$fetchBatch$1(this, r112);
        goto L8
    }
}
