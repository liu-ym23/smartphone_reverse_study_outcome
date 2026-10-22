package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010/\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R(\u0010(\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020%\u0018\u0001`&8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010+¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerLeaveContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "Lcom/bytedance/android/livesdk/link/model/g6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getVersion", "()J", "version", "", "Lcom/bytedance/android/livesdk/link/model/p;", "getLinkUsers", "()Ljava/util/List;", "linkUsers", "", "Lcom/bytedance/android/livesdk/link/model/b9;", "getLinkerContentMap", "()Ljava/util/Map;", "linkerContentMap", "", "getLeaveSource", "()I", "leaveSource", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "preRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPreOnlineUsers", "preOnlineUsers", "", "getUserId", "()Ljava/lang/String;", "userId", "getUserIdStr", "userIdStr", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerLeaveContentExtensionImpl extends ModelExtensionBase<ILinkerLeaveContentBridge, g6> implements g6, ILinkerLeaveContentBridge {
    private final /* synthetic */ ILinkerLeaveContentBridge $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.g6
    public <R extends vh7.e<ILinkerLeaveContentBridge>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public <R extends vh7.e<ILinkerLeaveContentBridge>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public List<p> getLinkUsers() {
        return (List) get(2, g6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public Map<Long, b9> getLinkerContentMap() {
        return (Map) get(6, g6.class);
    }

    public List<com.bytedance.android.livesdk.link.model.bridge.k> getPreOnlineUsers() {
        return this.$$delegate_0.getPreOnlineUsers();
    }

    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    public String getUserIdStr() {
        return this.$$delegate_0.getUserIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public int getLeaveSource() {
        return ((Number) get(7, g6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public b7 getMultiChannelInfo() {
        return (b7) get(9, g6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(8, g6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.g6
    public long getVersion() {
        return ((Number) get(5, g6.class, 0L)).longValue();
    }

    public ILinkerLeaveContentExtensionImpl(ILinkerLeaveContentBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
