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
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010C\u001a\u00020\u0002¢\u0006\u0004\bD\u0010EJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010$\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0016\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001c\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010#R\u0016\u00107\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010#R\u0014\u00109\u001a\u00020\u001b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b8\u0010\u001dR\u001e\u0010?\u001a\u0004\u0018\u00010:8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010B\u001a\u000600j\u0002`@8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bA\u00102¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ISwitchSceneDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/j2;", "Lcom/bytedance/android/livesdk/link/model/o9;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "preRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "", "getDefaultUILayout", "()I", "defaultUILayout", "getToScene", "toScene", "", "getLiveCoreExtInfo", "()Ljava/lang/String;", "liveCoreExtInfo", "getRtcExtInfo", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "layoutInfo", "", "Lcom/bytedance/android/livesdk/link/model/p;", "getLinkedUsers", "()Ljava/util/List;", "linkedUsers", "", "getVersion", "()J", "version", "getBattleAttachedInfoStr", "battleAttachedInfoStr", "getEventTrackingInfo", "eventTrackingInfo", "getInviterFromScene", "inviterFromScene", "Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "getMultiAnchorExtra", "()Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "setMultiAnchorExtra", "(Lcom/bytedance/android/livesdk/link/model/bridge/n1;)V", "multiAnchorExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LinkerId;", "getToLinkerId", "toLinkerId", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/j2;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ISwitchSceneDataExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.j2, o9> implements o9, com.bytedance.android.livesdk.link.model.bridge.j2 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.j2 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.o9, com.bytedance.android.livesdk.link.model.bridge.j2
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j2>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9, com.bytedance.android.livesdk.link.model.bridge.j2
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j2>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9, com.bytedance.android.livesdk.link.model.bridge.j2
    public int getInviterFromScene() {
        return this.$$delegate_0.getInviterFromScene();
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public List<p> getLinkedUsers() {
        return (List) get(3, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9, com.bytedance.android.livesdk.link.model.bridge.j2
    public com.bytedance.android.livesdk.link.model.bridge.n1 getMultiAnchorExtra() {
        return this.$$delegate_0.getMultiAnchorExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(7, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9, com.bytedance.android.livesdk.link.model.bridge.j2
    public long getToLinkerId() {
        return this.$$delegate_0.getToLinkerId();
    }

    @Override // com.bytedance.android.livesdk.link.model.o9, com.bytedance.android.livesdk.link.model.bridge.j2
    public void setMultiAnchorExtra(com.bytedance.android.livesdk.link.model.bridge.n1 r2) {
        this.$$delegate_0.setMultiAnchorExtra(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public String getBattleAttachedInfoStr() {
        return (String) get(17, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public int getDefaultUILayout() {
        return ((Number) get(12, o9.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public String getEventTrackingInfo() {
        return (String) get(18, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public m getLayoutInfo() {
        return (m) get(14, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public String getLiveCoreExtInfo() {
        return (String) get(2, o9.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public b7 getMultiChannelInfo() {
        return (b7) get(9, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(8, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(16, o9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public String getRtcExtInfo() {
        return (String) get(1, o9.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public int getToScene() {
        return ((Number) get(4, o9.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.o9
    public long getVersion() {
        return ((Number) get(15, o9.class, 0L)).longValue();
    }

    public ISwitchSceneDataExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.j2 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
