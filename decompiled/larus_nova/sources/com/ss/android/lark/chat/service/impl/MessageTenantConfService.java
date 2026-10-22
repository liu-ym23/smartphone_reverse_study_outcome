package com.ss.android.lark.chat.service.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.GetTenantMessageConfRequest;
import com.bytedance.lark.pb.im.v1.GetTenantMessageConfResponse;
import com.bytedance.lark.pb.im.v1.PushTenantMessageConfResponse;
import com.bytedance.lark.pb.im.v1.TenantMessageConf;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class MessageTenantConfService extends c38.a<b> implements m6b.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<c> f416393b;

    public static final class a {
    }

    public interface b {
        @SdkCall(4521)
        RucketJob<GetTenantMessageConfResponse> getTenantMessageConf(GetTenantMessageConfRequest r100);

        @SdkPush(4522)
        RucketJob<PushTenantMessageConfResponse> pushTenantMessageConf();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f416394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f416395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f416396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f416397d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f416394a == r101.f416394a) goto L12;
            return false;
        L12:
            if (this.f416395b == r101.f416395b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f416396c, r101.f416396c) == true) goto L18;
            return false;
        L18:
            if (this.f416397d == r101.f416397d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f416394a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f416395b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            String r104 = this.f416396c;
            if (r104 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = (r103 + r105) * 31;
            if (this.f416397d == false) goto L9;
            int r107 = 1231;
        L11:
            return r106 + r107;
        L9:
            r107 = 1237;
            goto L11
        L5:
            r105 = r104.hashCode();
            goto L6
        }

        public final String toString() {
            return "MessageTenantConf(recallEffectiveTime=" + this.f416394a + ", editEffectiveTime=" + this.f416395b + ", inputBoxPlaceHolder=" + this.f416396c + ", isSupportRestrictMessage=" + this.f416397d + ')';
        }

        public c(long r100, long r101, String r102, boolean r103) {
            this.f416394a = r100;
            this.f416395b = r101;
            this.f416396c = r102;
            this.f416397d = r103;
        }
    }

    static {
    }

    @Override // m6b.j
    public final LiveData<c> getConfig() {
        return this.f416393b;
    }

    @Inject
    public MessageTenantConfService(b38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "rucket");
        super(r100);
        this.f416393b = new MutableLiveData(new c(86400, 86400, null, false));
        RucketJob.then$default(((b) this.f22343a.create(b.class)).pushTenantMessageConf(), null, new MessageTenantConfService$setupPush$1(this, null), 1, null);
    }

    @Override // m6b.j
    public final void jd(boolean r100) {
        if (r100 == false) goto L4;
        SyncDataStrategy r101 = SyncDataStrategy.FORCE_SERVER;
    L5:
        RucketJob.error$default(RucketJob.then$default(((b) this.f22343a.create(b.class)).getTenantMessageConf(new GetTenantMessageConfRequest.Builder().conf_types(CollectionsKt.mutableListOf(new GetTenantMessageConfRequest.ConfType[]{GetTenantMessageConfRequest.ConfType.EditEffectiveTime, GetTenantMessageConfRequest.ConfType.RecallEffectiveTime, GetTenantMessageConfRequest.ConfType.InputBoxPlaceholder, GetTenantMessageConfRequest.ConfType.IsSupportRestrictMessage})).sync_data_strategy(r101).build()), null, new MessageTenantConfService$fetch$1(this, null), 1, null), null, new MessageTenantConfService$fetch$2(null), 1, null);
        return;
    L4:
        r101 = SyncDataStrategy.LOCAL;
        goto L5
    }

    public static final /* synthetic */ void a(MessageTenantConfService r100, MutableLiveData r101, TenantMessageConf r102) {
        r100.update(r101, r102, true);
    }

    public static /* synthetic */ void b(MessageTenantConfService r100, MutableLiveData r101, TenantMessageConf r102) {
        r100.update(r101, r102, false);
    }

    private final void update(MutableLiveData<c> r100, TenantMessageConf r110, boolean r111) {
        c r101 = new c(r110.recall_effective_time.longValue(), r110.edit_effective_time.longValue(), r110.input_box_placehold, r110.is_support_restrict_message.booleanValue());
        Log.i("MessageTenantConfService", "update message tenant conf " + r101 + " by push: " + r111);
        r100.postValue(r101);
    }
}
