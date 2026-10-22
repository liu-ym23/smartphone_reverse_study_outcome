package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.AnchorLinkmicRecordsResponse.RecordInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkRecordFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o5;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "startTime$delegate", "Ljava/lang/Object;", "getStartTime", "()Ljava/lang/Long;", "startTime", "endTime$delegate", "getEndTime", "endTime", "count$delegate", "getCount", "count", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkRecordFlexImpl extends FlexModelBase<o5> implements o5, vh7.h {

    @SerializedName("count")
    protected Long _$$count;

    @SerializedName("end_time")
    protected Long _$$endTime;

    @SerializedName("start_time")
    protected Long _$$startTime;

    @SerializedName("user")
    protected IBaseUser user;

    public ILinkRecordFlexImpl() {
        super(o5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o5
    public final Long getCount() {
        return this._$$count;
    }

    @Override // com.bytedance.android.livesdk.link.model.o5
    public final Long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.o5
    public final Long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.o5
    public IBaseUser getUser() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public ILinkRecordFlexImpl(am3.g r6) {
        super(o5.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.user = vh7.f.a(r6, IBaseUser.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$startTime = Long.valueOf(r6.j());
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$endTime = Long.valueOf(r6.j());
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$count = Long.valueOf(r6.j());
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setUser(IBaseUser r1) {
        this.user = r1;
    }
}
