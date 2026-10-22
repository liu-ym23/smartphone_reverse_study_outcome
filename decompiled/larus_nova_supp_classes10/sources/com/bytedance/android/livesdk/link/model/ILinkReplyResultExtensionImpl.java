package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010V\u001a\u00020\u0002¢\u0006\u0004\bW\u0010XJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R4\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R(\u00104\u001a\u0004\u0018\u00010/2\b\u0010\u001d\u001a\u0004\u0018\u00010/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00108\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0015R\u0014\u0010<\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\rR\u0014\u0010>\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\rR\u0016\u0010@\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0011R\u0016\u0010B\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0011R\u001c\u0010F\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`C8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bG\u0010\u0011R<\u0010O\u001a*\u0012\b\u0012\u00060\u0013j\u0002`J\u0012\u0004\u0012\u00020K\u0018\u00010Ij\u0014\u0012\b\u0012\u00060\u0013j\u0002`J\u0012\u0004\u0012\u00020K\u0018\u0001`L8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0016\u0010S\u001a\u0004\u0018\u00010P8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u0010U\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bT\u0010\u0011¨\u0006Y"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkReplyResultExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "Lcom/bytedance/android/livesdk/link/model/q5;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getSwitchToScene", "()I", "switchToScene", "", "getAccessKey", "()Ljava/lang/String;", "accessKey", "", "getCurMaxInviteNum", "()J", "curMaxInviteNum", "", "getBizJoinChannel", "()Z", "bizJoinChannel", "", "Lcom/bytedance/android/livesdk/link/model/p;", "value", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "linkUsers", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "layoutInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "preRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getInviterVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "inviterVersionInfo", "getVersion", "version", "getToBizType", "toBizType", "getBizType", "bizType", "getLynxData", "lynxData", "getEventTrackingInfo", "eventTrackingInfo", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLinkMicId", "()Ljava/lang/Long;", "linkMicId", "getLinkMicIdStr", "linkMicIdStr", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LinkerId;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "linkerContentMap", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "multiChannelInfo", "getRtcExtInfo", "rtcExtInfo", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/d1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkReplyResultExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.d1, q5> implements q5, com.bytedance.android.livesdk.link.model.bridge.d1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.d1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public Long getLinkMicId() {
        return this.$$delegate_0.getLinkMicId();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public String getLinkMicIdStr() {
        return this.$$delegate_0.getLinkMicIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap() {
        return this.$$delegate_0.getLinkerContentMap();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public com.bytedance.android.livesdk.link.model.bridge.s1 getMultiChannelInfo() {
        return this.$$delegate_0.getMultiChannelInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5, com.bytedance.android.livesdk.link.model.bridge.d1
    public String getRtcExtInfo() {
        return this.$$delegate_0.getRtcExtInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public String getAccessKey() {
        return (String) get(1, q5.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public boolean getBizJoinChannel() {
        return ((Boolean) get(18, q5.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public int getBizType() {
        return ((Number) get(38, q5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public long getCurMaxInviteNum() {
        return ((Number) get(29, q5.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public String getEventTrackingInfo() {
        return (String) get(42, q5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public com.bytedance.android.livesdk.link.model.bridge.k2 getInviterVersionInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.k2) get(35, q5.class, com.bytedance.android.livesdk.link.model.bridge.k2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public m getLayoutInfo() {
        return (m) get(30, q5.class, m.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public List<p> getLinkUsers() {
        return (List) get(25, q5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public String getLynxData() {
        return (String) get(39, q5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(33, q5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(32, q5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(34, q5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public int getSwitchToScene() {
        return ((Number) get(28, q5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public int getToBizType() {
        return ((Number) get(37, q5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public long getVersion() {
        return ((Number) get(26, q5.class, 0L)).longValue();
    }

    public ILinkReplyResultExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.d1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public void setLinkUsers(List<? extends p> r4) {
        set(25, "linked_users", q5.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.q5
    public void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r4) {
        set(34, "pre_rtc_info", q5.class, r4);
    }
}
