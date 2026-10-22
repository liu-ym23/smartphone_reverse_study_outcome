package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010C\u001a\u00020\u0002¢\u0006\u0004\bD\u0010EJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010&\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R(\u0010,\u001a\u0004\u0018\u00010'2\b\u0010\f\u001a\u0004\u0018\u00010'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u00102\u001a\u0004\u0018\u00010-2\b\u0010\f\u001a\u0004\u0018\u00010-8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00108\u001a\u0004\u0018\u0001032\b\u0010\f\u001a\u0004\u0018\u0001038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R(\u0010>\u001a\u0004\u0018\u0001092\b\u0010\f\u001a\u0004\u0018\u0001098V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010@\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0014R\u0016\u0010B\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0014¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorApplyDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/e;", "Lcom/bytedance/android/livesdk/link/model/f;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getVendor", "()I", "setVendor", "(I)V", "vendor", "", "getSignExtra", "()Ljava/lang/String;", "setSignExtra", "(Ljava/lang/String;)V", "signExtra", "", "getWaitSec", "()J", "setWaitSec", "(J)V", "waitSec", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "setVersionInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/k2;)V", "versionInfo", "getLinkmicId", "setLinkmicId", "linkmicId", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "setMultiRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/v1;)V", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "setMultiLiveCoreInfo", "(Lcom/bytedance/android/livesdk/link/model/d7;)V", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "setMultiChannelInfo", "(Lcom/bytedance/android/livesdk/link/model/b7;)V", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "preRtcInfo", "getLynxData", "lynxData", "getEventTrackingInfo", "eventTrackingInfo", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/e;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAnchorApplyDataExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.e, f> implements f, com.bytedance.android.livesdk.link.model.bridge.e {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.e $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.f, com.bytedance.android.livesdk.link.model.bridge.e
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.f, com.bytedance.android.livesdk.link.model.bridge.e
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(7, f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(6, f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public String getEventTrackingInfo() {
        return (String) get(14, f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public String getLinkmicId() {
        return (String) get(4, f.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public String getLynxData() {
        return (String) get(13, f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public b7 getMultiChannelInfo() {
        return (b7) get(8, f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(9, f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public String getSignExtra() {
        return (String) get(2, f.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public int getVendor() {
        return ((Number) get(1, f.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public com.bytedance.android.livesdk.link.model.bridge.k2 getVersionInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.k2) get(11, f.class, com.bytedance.android.livesdk.link.model.bridge.k2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public long getWaitSec() {
        return ((Number) get(10, f.class, 0L)).longValue();
    }

    public IAnchorApplyDataExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.e r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setLinkmicId(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(4, "linkmic_id_str", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setMultiChannelInfo(b7 r4) {
        set(8, "multi_channel_info", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setMultiLiveCoreInfo(d7 r4) {
        set(7, "multi_live_core_info", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setMultiRtcInfo(com.bytedance.android.livesdk.link.model.bridge.v1 r4) {
        set(6, "multi_rtc_info", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r4) {
        set(9, "pre_rtc_info", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setSignExtra(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(2, "sign_extra", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setVendor(int r4) {
        set(1, "vendor", f.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setVersionInfo(com.bytedance.android.livesdk.link.model.bridge.k2 r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(11, "apply_version_info", f.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.f
    public void setWaitSec(long r3) {
        set(10, "wait_sec", f.class, Long.valueOf(r3));
    }
}
