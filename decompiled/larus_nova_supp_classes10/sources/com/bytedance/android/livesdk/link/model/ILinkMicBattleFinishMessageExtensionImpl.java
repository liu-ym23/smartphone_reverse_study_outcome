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
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010E\u001a\u00020\u0002¢\u0006\u0004\bF\u0010GJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\rR\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0014\u0010-\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001eR\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\"\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000207\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\"\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020;\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u00109R$\u0010D\u001a\n\u0018\u00010>j\u0004\u0018\u0001`?8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006H"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleFinishMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/message/model/v8;", "Lcom/bytedance/android/livesdk/link/model/a5;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getEndReason", "()I", "endReason", "Lcom/bytedance/android/livesdk/link/model/u1;", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/u1;", "battleSetting", "", "Lcom/bytedance/android/livesdk/link/model/a1;", "getBattleScorePairList", "()Ljava/util/List;", "battleScorePairList", "Lcom/bytedance/android/livesdk/link/model/x2;", "getSkinConfig", "()Lcom/bytedance/android/livesdk/link/model/x2;", "skinConfig", "", "getCutShortPrompt", "()Ljava/lang/String;", "cutShortPrompt", "", "getCutShortWin", "()Z", "cutShortWin", "getKillFinishType", "killFinishType", "Lcom/bytedance/android/livesdk/link/model/n3;", "getBreakthroughInfo", "()Lcom/bytedance/android/livesdk/link/model/n3;", "breakthroughInfo", "getSkinType", "skinType", "getEventTrackingInfo", "eventTrackingInfo", "Lcom/bytedance/android/livesdk/link/model/l9;", "getSurvivalInfo", "()Lcom/bytedance/android/livesdk/link/model/l9;", "survivalInfo", "Lcom/bytedance/android/livesdk/link/model/z4;", "getBattleFinishExtra", "()Lcom/bytedance/android/livesdk/link/model/z4;", "battleFinishExtra", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "getBattleUserInfoMap", "()Ljava/util/Map;", "battleUserInfoMap", "Lcom/bytedance/android/livesdk/link/model/z2;", "getGradeChanges", "gradeChanges", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/message/model/v8;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBattleFinishMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.message.model.v8, a5> implements a5, com.bytedance.android.livesdk.message.model.v8 {
    private final /* synthetic */ com.bytedance.android.livesdk.message.model.v8 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.a5
    public <R extends vh7.e<com.bytedance.android.livesdk.message.model.v8>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public <R extends vh7.e<com.bytedance.android.livesdk.message.model.v8>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public u1 getBattleSetting() {
        return (u1) get(2, a5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public z4 getBattleFinishExtra() {
        return (z4) get(20, a5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public List<a1> getBattleScorePairList() {
        return (List) get(4, a5.class, com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a());
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public Map<String, IBattleUserInfo> getBattleUserInfoMap() {
        return (Map) get(5000, a5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public n3 getBreakthroughInfo() {
        return (n3) get(14, a5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public String getCutShortPrompt() {
        return (String) get(9, a5.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public boolean getCutShortWin() {
        return ((Boolean) get(11, a5.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.a5, com.bytedance.android.livesdk.link.model.b5
    public int getEndReason() {
        return ((Number) get(8, a5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public String getEventTrackingInfo() {
        return (String) get(18, a5.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public Map<String, z2> getGradeChanges() {
        return (Map) get(5001, a5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public int getKillFinishType() {
        return ((Number) get(13, a5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public x2 getSkinConfig() {
        return (x2) get(15, a5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public int getSkinType() {
        return ((Number) get(16, a5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.a5
    public l9 getSurvivalInfo() {
        return (l9) get(17, a5.class);
    }

    public ILinkMicBattleFinishMessageExtensionImpl(com.bytedance.android.livesdk.message.model.v8 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
