package com.larus.profile.impl.creation.repository;

import androidx.lifecycle.MutableLiveData;
import com.larus.network.http.y;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.impl.ProfileRepo;
import dm9.a;
import fs9.b0;
import fs9.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import zp9.c;
import zp9.n;

/* JADX INFO: loaded from: classes31.dex */
public final class ProfileCreationFeedRepository implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f366364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f366365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProfileRepo f366366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Integer> f366367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData f366368e;

    @Override // zp9.n
    public final CreationFeedCacheEntity b() {
        return null;
    }

    public ProfileCreationFeedRepository(String r100) {
        this.f366364a = 20;
        this.f366365b = r100;
        Lazy<ProfileRepo> r101 = ProfileRepo.f366052b;
        this.f366366c = ProfileRepo.a.a();
        MutableLiveData<Integer> r102 = new MutableLiveData();
        this.f366367d = r102;
        this.f366368e = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zp9.n
    public final Object a(int r110, String r111, Long r112, String r113, Continuation<? super Pair<c, ? extends a<?>>> r210) {
        if ((r210 instanceof ProfileCreationFeedRepository$fetchBatch$1) == false) goto L7;
        ProfileCreationFeedRepository$fetchBatch$1 r100 = (ProfileCreationFeedRepository$fetchBatch$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L21:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof y) == false) goto L46;
        y r106 = (y) r105;
        b0 r107 = (b0) r106.f360135b;
        if (r107 == null) goto L29;
        List<UserCreation> r108 = r107.a();
        if (r108 == null) goto L29;
        List r109 = CollectionsKt.filterNotNull(r108);
        if (r109 == null) goto L29;
    L30:
        List r114 = r109;
        b0 r115 = (b0) r106.f360135b;
        if (r115 == null) goto L33;
        String r116 = r115.c();
    L34:
        String r117 = String.valueOf(r116);
        b0 r118 = (b0) r106.f360135b;
        int r119 = 0;
        if (r118 == null) goto L37;
        boolean r120 = r118.b();
    L38:
        MutableLiveData<Integer> r121 = this.f366367d;
        b0 r122 = (b0) r106.f360135b;
        if (r122 == null) goto L43;
        Integer r123 = r122.d();
        if (r123 == null) goto L43;
        r119 = r123.intValue();
    L43:
        r121.postValue(Boxing.boxInt(r119));
        return TuplesKt.to(new c(r120, null, r114, null, r117, 10), null);
    L37:
        r120 = false;
        goto L38
    L33:
        r116 = null;
    L29:
        r109 = new ArrayList();
        goto L30
    L46:
        return TuplesKt.to(null, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        ProfileRepo r124 = this.f366366c;
        int r125 = this.f366364a;
        String r126 = this.f366365b;
        if (r111 != null) goto L17;
        String r127 = "";
    L18:
        x r128 = new x(r125, r126, r127, Boxing.boxInt(1), r113, null, null, 96);
        r100.label = 1;
        r124.getClass();
        r102 = ProfileRepo.d(r128, r100);
        if (r102 != r103) goto L21;
        return r103;
    L17:
        r127 = r111;
    L7:
        r100 = new ProfileCreationFeedRepository$fetchBatch$1(this, r210);
        goto L8
    }
}
