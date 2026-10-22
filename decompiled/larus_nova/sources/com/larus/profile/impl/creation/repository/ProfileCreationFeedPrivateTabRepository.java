package com.larus.profile.impl.creation.repository;

import com.larus.network.http.y;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationGroup;
import com.larus.profile.api.bean.UserCreationGroupListResponse;
import com.larus.profile.impl.ProfileRepo;
import dm9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import zp9.c;
import zp9.n;

/* JADX INFO: loaded from: classes31.dex */
public final class ProfileCreationFeedPrivateTabRepository implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f366361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f366362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProfileRepo f366363c;

    @Override // zp9.n
    public final CreationFeedCacheEntity b() {
        return null;
    }

    public ProfileCreationFeedPrivateTabRepository(String r100) {
        this.f366361a = 20;
        this.f366362b = r100;
        Lazy<ProfileRepo> r101 = ProfileRepo.f366052b;
        this.f366363c = ProfileRepo.a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zp9.n
    public final Object a(int r100, String r101, Long r110, String r111, Continuation<? super Pair<c, ? extends a<?>>> r112) {
        if ((r112 instanceof ProfileCreationFeedPrivateTabRepository$fetchBatch$1) == false) goto L7;
        ProfileCreationFeedPrivateTabRepository$fetchBatch$1 r102 = (ProfileCreationFeedPrivateTabRepository$fetchBatch$1) r112;
        int r113 = r102.label;
        if ((r113 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r113 - Integer.MIN_VALUE;
    L8:
        Object r114 = r102.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r102.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L20:
        com.larus.network.http.a r116 = (com.larus.network.http.a) r114;
        if ((r116 instanceof y) == false) goto L53;
        y r117 = (y) r116;
        UserCreationGroupListResponse r104 = (UserCreationGroupListResponse) r117.f360135b;
        if (r104 == null) goto L25;
        List<UserCreationGroup> r105 = r104.a();
    L26:
        UserCreationGroupListResponse r118 = (UserCreationGroupListResponse) r117.f360135b;
        if (r118 == null) goto L29;
        String r119 = r118.c();
    L30:
        String r106 = String.valueOf(r119);
        UserCreationGroupListResponse r120 = (UserCreationGroupListResponse) r117.f360135b;
        if (r120 == null) goto L33;
        boolean r107 = r120.b();
    L34:
        if (r105 == null) goto L49;
        ArrayList r121 = new ArrayList();
        Iterator<T> r108 = r105.iterator();
    L37:
        if (r108.hasNext() == false) goto L48;
        UserCreationGroup r122 = (UserCreationGroup) r108.next();
        if (r122 != null) goto L41;
        r122 = null;
    L41:
        if (r122 == null) goto L45;
        List<UserCreation> r123 = r122.a();
        if (r123 == null) goto L45;
        List r124 = CollectionsKt.filterNotNull(r123);
    L46:
        if (r124 == null) goto L37;
        r121.add(r124);
    L45:
        r124 = null;
        goto L46
    L48:
        ArrayList r109 = r121;
    L51:
        return TuplesKt.to(new c(r107, null, null, r109, r106, 6), null);
    L49:
        r109 = null;
        goto L51
    L33:
        r107 = false;
        goto L34
    L29:
        r119 = null;
        goto L30
    L25:
        r105 = null;
        goto L26
    L53:
        return TuplesKt.to(null, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        ProfileRepo r125 = this.f366363c;
        int r126 = this.f366361a;
        String r127 = this.f366362b;
        if (r101 != null) goto L17;
        r101 = "";
    L17:
        r102.label = 1;
        r125.getClass();
        r114 = ProfileRepo.b(r126, r127, r101, r111, r102);
        if (r114 != r115) goto L20;
        return r115;
    L7:
        r102 = new ProfileCreationFeedPrivateTabRepository$fetchBatch$1(this, r112);
        goto L8
    }
}
