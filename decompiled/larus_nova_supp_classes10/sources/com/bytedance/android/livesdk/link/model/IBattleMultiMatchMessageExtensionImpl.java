package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010-\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001d\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R$\u0010%\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R$\u0010,\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMultiMatchMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/t;", "Lcom/bytedance/android/livesdk/link/model/w1;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getMatchStatus", "()I", "setMatchStatus", "(I)V", "matchStatus", "", "getExpectTime", "()J", "setExpectTime", "(J)V", "expectTime", "getDefaultWaitLimit", "setDefaultWaitLimit", "defaultWaitLimit", "getInviteLimitSec", "setInviteLimitSec", "inviteLimitSec", "", "Lcom/bytedance/android/livesdk/link/model/w1$c;", "getPreviewUsers", "()Ljava/util/List;", "previewUsers", "getMatchType", "setMatchType", "matchType", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/t;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleMultiMatchMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.t, w1> implements w1, com.bytedance.android.livesdk.link.model.bridge.t {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.t $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.w1, com.bytedance.android.livesdk.link.model.bridge.t
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.t>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.w1, com.bytedance.android.livesdk.link.model.bridge.t
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.t>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.w1, com.bytedance.android.livesdk.link.model.bridge.t
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.w1, com.bytedance.android.livesdk.link.model.bridge.t
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public long getDefaultWaitLimit() {
        return ((Number) get(5, w1.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public long getExpectTime() {
        return ((Number) get(3, w1.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public long getInviteLimitSec() {
        return ((Number) get(6, w1.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public int getMatchStatus() {
        return ((Number) get(2, w1.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public long getMatchType() {
        return ((Number) get(7, w1.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public List<w1.c> getPreviewUsers() {
        return (List) get(4, w1.class, com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a());
    }

    public IBattleMultiMatchMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.t r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public void setDefaultWaitLimit(long r3) {
        set(5, "default_wait_limit", w1.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public void setExpectTime(long r3) {
        set(3, "expect_time", w1.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public void setInviteLimitSec(long r3) {
        set(6, "invite_limit_sec", w1.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public void setMatchStatus(int r4) {
        set(2, "match_status", w1.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.w1
    public void setMatchType(long r3) {
        set(7, "match_type", w1.class, Long.valueOf(r3));
    }
}
