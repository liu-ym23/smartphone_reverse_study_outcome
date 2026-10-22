package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010T\u001a\u00020\u0002¢\u0006\u0004\bU\u0010VJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R0\u0010.\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010'j\n\u0012\u0004\u0012\u00020(\u0018\u0001`)8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-RD\u00108\u001a*\u0012\b\u0012\u000600j\u0002`1\u0012\u0004\u0012\u000202\u0018\u00010/j\u0014\u0012\b\u0012\u000600j\u0002`1\u0012\u0004\u0012\u000202\u0018\u0001`38\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010>\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010D\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010G\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bE\u0010+\"\u0004\bF\u0010-R\u001c\u0010M\u001a\u00020H8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010S\u001a\u000600j\u0002`N8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerEnterContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "Lcom/bytedance/android/livesdk/link/model/a6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/link/model/t4;", "getLinkIconConfig", "()Lcom/bytedance/android/livesdk/link/model/t4;", "linkIconConfig", "Lcom/bytedance/android/livesdk/link/model/t6;", "getUiConfig", "()Lcom/bytedance/android/livesdk/link/model/t6;", "uiConfig", "", "getBattleDisplayEntrance", "()Z", "battleDisplayEntrance", "", "getApplyType", "()I", "setApplyType", "(I)V", "applyType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "cityEffect", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUiInfo", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "linkUsers", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "linkerContentMap", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "matchEffect", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "getMessageBoardInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "setMessageBoardInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;)V", "messageBoardInfo", "getPreOnlineUsers", "setPreOnlineUsers", "preOnlineUsers", "", "getUserIdString", "()Ljava/lang/String;", "setUserIdString", "(Ljava/lang/String;)V", "userIdString", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/VersionNum;", "getVersion", "()J", "setVersion", "(J)V", "version", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/f1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerEnterContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.f1, a6> implements a6, com.bytedance.android.livesdk.link.model.bridge.f1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.f1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.f1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.f1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public int getApplyType() {
        return this.$$delegate_0.getApplyType();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public ICityEffect getCityEffect() {
        return this.$$delegate_0.getCityEffect();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public ClientUIInfo getClientUiInfo() {
        return this.$$delegate_0.getClientUiInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkUsers() {
        return this.$$delegate_0.getLinkUsers();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap() {
        return this.$$delegate_0.getLinkerContentMap();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public IMatchEffect getMatchEffect() {
        return this.$$delegate_0.getMatchEffect();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public IMessageBoardInfo getMessageBoardInfo() {
        return this.$$delegate_0.getMessageBoardInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getPreOnlineUsers() {
        return this.$$delegate_0.getPreOnlineUsers();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public String getUserIdString() {
        return this.$$delegate_0.getUserIdString();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public long getVersion() {
        return this.$$delegate_0.getVersion();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setApplyType(int r2) {
        this.$$delegate_0.setApplyType(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setCityEffect(ICityEffect r2) {
        this.$$delegate_0.setCityEffect(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setLinkUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2) {
        this.$$delegate_0.setLinkUsers(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setLinkerContentMap(Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r2) {
        this.$$delegate_0.setLinkerContentMap(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setMatchEffect(IMatchEffect r2) {
        this.$$delegate_0.setMatchEffect(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setMessageBoardInfo(IMessageBoardInfo r2) {
        this.$$delegate_0.setMessageBoardInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setPreOnlineUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2) {
        this.$$delegate_0.setPreOnlineUsers(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setUserIdString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setUserIdString(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6, com.bytedance.android.livesdk.link.model.bridge.f1
    public void setVersion(long r2) {
        this.$$delegate_0.setVersion(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6
    public boolean getBattleDisplayEntrance() {
        return ((Boolean) get(13, a6.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.a6
    public t4 getLinkIconConfig() {
        return (t4) get(10, a6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.a6
    public t6 getUiConfig() {
        return (t6) get(12, a6.class);
    }

    public ILinkerEnterContentExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.f1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
