package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR \u0010\u0019\u001a\u00060\u0013j\u0002`\u00148\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u00060\u0013j\u0002`\u00148\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR \u0010 \u001a\u00060\u0013j\u0002`\u00148\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R4\u0010&\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\"\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\"\u0018\u0001`#8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010+\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserList_IOpenGameInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "Lcom/bytedance/android/livesdk/link/model/r$c;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appId", "getGameExtra", "gameExtra", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getGameId", "()J", "setGameId", "(J)V", "gameId", "getGameType", "gameType", "getLinkExtra", "linkExtra", "getLinkGameId", "setLinkGameId", "linkGameId", "", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRoleInfos", "()Ljava/util/Map;", "roleInfos", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKt;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "streamUrl", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/y1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAnchorLinkUserList_IOpenGameInfoExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.y1, r.c> implements r.c, com.bytedance.android.livesdk.link.model.bridge.y1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.y1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.y1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.y1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public String getAppId() {
        return this.$$delegate_0.getAppId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public String getGameExtra() {
        return this.$$delegate_0.getGameExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public long getGameId() {
        return this.$$delegate_0.getGameId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public long getGameType() {
        return this.$$delegate_0.getGameType();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public String getLinkExtra() {
        return this.$$delegate_0.getLinkExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public long getLinkGameId() {
        return this.$$delegate_0.getLinkGameId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public Map<String, IAnchorGameRoleBridge> getRoleInfos() {
        return this.$$delegate_0.getRoleInfos();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public IBaseStreamUrl getStreamUrl() {
        return this.$$delegate_0.getStreamUrl();
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public void setAppId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setAppId(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public void setGameId(long r2) {
        this.$$delegate_0.setGameId(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r.c, com.bytedance.android.livesdk.link.model.bridge.y1
    public void setLinkGameId(long r2) {
        this.$$delegate_0.setLinkGameId(r2);
    }

    public IAnchorLinkUserList_IOpenGameInfoExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.y1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
