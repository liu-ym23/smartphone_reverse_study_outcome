package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomLinkInfoBase;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRoomLinkInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomLinkInfoBase;", "Lcom/bytedance/android/livesdk/link/model/a9;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getGuestId", "()Ljava/lang/String;", "guestId", "", "getChannelId", "()J", "channelId", "Lcom/bytedance/android/livesdk/link/model/i5;", "getChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/i5;", "channelInfo", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting;", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting;", "battleSetting", "", "Lcom/bytedance/android/livesdk/link/model/f5;", "getBattleScorePairList", "()Ljava/util/List;", "battleScorePairList", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomLinkInfoBase;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IRoomLinkInfoExtensionImpl extends ModelExtensionBase<IRoomLinkInfoBase, a9> implements a9, IRoomLinkInfoBase {
    private final /* synthetic */ IRoomLinkInfoBase $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.a9
    public <R extends vh7.e<IRoomLinkInfoBase>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a9
    public <R extends vh7.e<IRoomLinkInfoBase>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a9
    public List<f5> getBattleScorePairList() {
        return (List) get(3, a9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a9
    public ILinkMicBattleSetting getBattleSetting() {
        return (ILinkMicBattleSetting) get(4, a9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a9
    public i5 getChannelInfo() {
        return (i5) get(2, a9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a9
    public long getChannelId() {
        return ((Number) get(1, a9.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.a9
    public String getGuestId() {
        return (String) get(5000, a9.class);
    }

    public IRoomLinkInfoExtensionImpl(IRoomLinkInfoBase r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
