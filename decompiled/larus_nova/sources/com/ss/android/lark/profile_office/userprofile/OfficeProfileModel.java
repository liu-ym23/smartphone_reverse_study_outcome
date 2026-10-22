package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.bytedance.lark.pb.contact.v2.UpdateDoubaoInfoRequest;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.users.PatchUserMemoRequest;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeProfileModel implements c38.c<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.profile.core.di.a f438882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f438883b;

    public static final class a {
    }

    static {
    }

    @Override // c38.c
    public final b38.b getScopedRucket() {
        com.ss.android.lark.profile.core.di.a r100 = this.f438882a;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("netClientGetter");
        r100 = null;
    L7:
        return r100.Q4();
    }

    @Inject
    public OfficeProfileModel() {
        this.f438883b = LazyKt.lazy(OfficeProfileModel$coreService$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r100, boolean r101, Continuation<? super q1c.b<GetDoubaoProfileResponse>> r102) {
        if ((r102 instanceof OfficeProfileModel$loadProfileByToken$1) == false) goto L7;
        OfficeProfileModel$loadProfileByToken$1 r103 = (OfficeProfileModel$loadProfileByToken$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        ResultKt.throwOnFailure(r105);
    L21:
        q1c.b r108 = q1c.c.a((com.larksuite.rucket.job.base.b) r105);
        if ((!(r108 instanceof q1c.b.a)) == false) goto L24;
        Log.i("OfficeProfileModel", "loadProfileByToken success, fromServer: " + r101 + ", edition: " + ((GetDoubaoProfileResponse) ((q1c.b.C7270b) r108).f531323a).edition);
    L25:
        return r108;
    L24:
        Log.e("OfficeProfileModel", "loadProfileByToken error, fromServer: " + r101, ((q1c.b.a) r108).f531322a);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r101 == false) goto L17;
        SyncDataStrategy r109 = SyncDataStrategy.FORCE_SERVER;
    L18:
        GetDoubaoProfileRequest.Builder r110 = new GetDoubaoProfileRequest.Builder().token(r100).sync_data_strategy(r109);
        Log.i("OfficeProfileModel", "start loadProfileByToken, token: " + r100 + ", fromServer: " + r101);
        RucketJob<GetDoubaoProfileResponse> r111 = ((b) getScopedRucket().create(b.class)).getOfficeProfile(r110.build());
        r103.Z$0 = r101;
        r103.label = 1;
        r105 = r111.awaitGet(r103);
        if (r105 != r106) goto L21;
        return r106;
    L17:
        r109 = SyncDataStrategy.LOCAL;
    L7:
        r103 = new OfficeProfileModel$loadProfileByToken$1(this, r102);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r100, boolean r101, Continuation<? super q1c.b<GetDoubaoProfileResponse>> r102) {
        if ((r102 instanceof OfficeProfileModel$loadProfileByUserId$1) == false) goto L7;
        OfficeProfileModel$loadProfileByUserId$1 r103 = (OfficeProfileModel$loadProfileByUserId$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        ResultKt.throwOnFailure(r105);
    L21:
        q1c.b r108 = q1c.c.a((com.larksuite.rucket.job.base.b) r105);
        if ((!(r108 instanceof q1c.b.a)) == false) goto L24;
        Log.i("OfficeProfileModel", "loadProfileByUserId success, fromServer: " + r101 + ", edition: " + ((GetDoubaoProfileResponse) ((q1c.b.C7270b) r108).f531323a).edition);
    L25:
        return r108;
    L24:
        Log.e("OfficeProfileModel", "loadProfileByUserId error, fromServer: " + r101, ((q1c.b.a) r108).f531322a);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r101 == false) goto L17;
        SyncDataStrategy r109 = SyncDataStrategy.FORCE_SERVER;
    L18:
        GetDoubaoProfileRequest.Builder r110 = new GetDoubaoProfileRequest.Builder().user_id(r100).sync_data_strategy(r109);
        Log.i("OfficeProfileModel", "start loadProfileByUserId, userId: " + r100 + ", fromServer: " + r101);
        RucketJob<GetDoubaoProfileResponse> r111 = ((b) getScopedRucket().create(b.class)).getOfficeProfile(r110.build());
        r103.Z$0 = r101;
        r103.label = 1;
        r105 = r111.awaitGet(r103);
        if (r105 != r106) goto L21;
        return r106;
    L17:
        r109 = SyncDataStrategy.LOCAL;
    L7:
        r103 = new OfficeProfileModel$loadProfileByUserId$1(this, r102);
        goto L8
    }

    public final Object c(String r100, String r101, Continuation<? super q1c.b<Unit>> r102) {
        if ((r102 instanceof OfficeProfileModel$saveAlias$1) == false) goto L7;
        OfficeProfileModel$saveAlias$1 r103 = (OfficeProfileModel$saveAlias$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        q1c.b r108 = q1c.c.a((com.larksuite.rucket.job.base.b) r105);
        if ((!(r108 instanceof q1c.b.a)) == false) goto L20;
        Log.i("OfficeProfileModel", "saveAlias success");
    L21:
        return r108;
    L20:
        Log.e("OfficeProfileModel", "saveAlias error", ((q1c.b.a) r108).f531322a);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        PatchUserMemoRequest.Builder r109 = new PatchUserMemoRequest.Builder().target_user_id(r100).alias(r101);
        Log.i("OfficeProfileModel", "start saveAlias, userId: " + r100 + ", alias: " + r101);
        RucketJob r110 = RucketJob.map$default(((com.ss.android.lark.profile.core.service.a) this.f438883b.getValue()).saveAlias(r109.build()), null, OfficeProfileModel$saveAlias$result$1.INSTANCE, 1, null);
        r103.label = 1;
        r105 = r110.awaitGet(r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OfficeProfileModel$saveAlias$1(this, r102);
        goto L8
    }

    public final Object d(String r100, String r101, Continuation<? super q1c.b<Unit>> r102) {
        if ((r102 instanceof OfficeProfileModel$updateDoubaoInfo$1) == false) goto L7;
        OfficeProfileModel$updateDoubaoInfo$1 r103 = (OfficeProfileModel$updateDoubaoInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        q1c.b r108 = q1c.c.a((com.larksuite.rucket.job.base.b) r105);
        if ((!(r108 instanceof q1c.b.a)) == false) goto L20;
        Log.i("OfficeProfileModel", "updateDoubaoInfo success");
    L21:
        return r108;
    L20:
        Log.e("OfficeProfileModel", "updateDoubaoInfo error", ((q1c.b.a) r108).f531322a);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        UpdateDoubaoInfoRequest.Builder r109 = new UpdateDoubaoInfoRequest.Builder().user_id(r100).content(r101);
        Log.i("OfficeProfileModel", "start updateDoubaoInfo, userId: " + r100 + ", content: " + r101);
        RucketJob r110 = RucketJob.map$default(((b) getScopedRucket().create(b.class)).updateDoubaoInfo(r109.build()), null, OfficeProfileModel$updateDoubaoInfo$result$1.INSTANCE, 1, null);
        r103.label = 1;
        r105 = r110.awaitGet(r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OfficeProfileModel$updateDoubaoInfo$1(this, r102);
        goto L8
    }
}
